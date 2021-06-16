package userinterface.fragments;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import miscellaneous.constants.Application;
import miscellaneous.utilities.Utils;
import userinterface.interfaces.IFragment;
import userinterface.interfaces.ISelectable;
import userinterface.enums.SelectionType;

import java.util.ArrayList;

import static miscellaneous.constants.Application.Containers.VisualEdit.IMAGEVIEW_SIZE;

/**
 * Visual Edit window.
 */

public class StartWindowVisualEdit implements IFragment, ISelectable {
    public final ScrollPane uiWindowScrollpane = new ScrollPane();
    public final HBox uiWindowVisualStack = new HBox();
    public final ArrayList<VisualEditFragment> uiVisualEditFragments = new ArrayList<VisualEditFragment>();

    /**
     * Constructs the VisualEdit Fragment.
     */

    public StartWindowVisualEdit() {
        uiWindowScrollpane.setContent(uiWindowVisualStack);
        uiWindowScrollpane.setBackground(null);
    }

    /**
     * Adds a VisualEditFragment as a visual element on the last position.
     * @param fragment Fragment with data.
     */

    public void addVisualEditFragment(VisualEditFragment fragment) {
        addVisualEditFragment(fragment, -1);
    }

    /**
     * Adds a VisualEditFragment as a visual element
     * @param fragment Fragment with data.
     * @param index Index to add to.
     */

    public void addVisualEditFragment(VisualEditFragment fragment, int index) {
        if (index==-1)
            uiVisualEditFragments.add(fragment);
        else
            uiVisualEditFragments.add(index, fragment);

        uiWindowVisualStack.setSpacing(10);
        ImageView image = Utils.getImageView(this, Application.IconPaths.getThemeImageURL(Application.Icons.ARROW_RIGHT_CIRCLE),IMAGEVIEW_SIZE, IMAGEVIEW_SIZE);
        image.setPickOnBounds(true);
        HBox.setMargin(fragment.getFragment(), new Insets(10,10,5,10));
        uiWindowVisualStack.setAlignment(Pos.CENTER_RIGHT);

        if (index==-1) {
            uiWindowVisualStack.getChildren().add(fragment.getFragment());
            uiWindowVisualStack.getChildren().add(image);
        }
        else {
            uiWindowVisualStack.getChildren().add(index+1, fragment.getFragment());
            uiWindowVisualStack.getChildren().add(index+1, image);
        }



    }

    /**
     * Add method to add a hint for creating the first node.
     */

    public void addFirstNodeHint() {
        Button addNodeButton = new Button();
        ImageView addImage = Utils.getImageView(this, Application.IconPaths.getThemeImageURL(Application.Icons.PLUS_CIRCLE), IMAGEVIEW_SIZE, IMAGEVIEW_SIZE);
        HBox.setMargin(addNodeButton, new Insets(120,5,120,5));
        Utils.bindNodesTransparentBackground(addNodeButton);
        addNodeButton.setGraphic(addImage);
        uiWindowVisualStack.getChildren().add(0, addNodeButton);
    }

    /**
     * Helper method to add a newVisualEditFragment.
     */

    public void addVisualEditFragment() {
        addVisualEditFragment(-1);
    }

    public void addVisualEditFragment(int index) {
        VisualEditFragment visualEditFragment = new VisualEditFragment();

        if (index!=-1)
            addVisualEditFragment(visualEditFragment, index);
        else
            addVisualEditFragment(visualEditFragment);
    }

    /**
     * Returns the last VisualEditFragment, make sure list size is bigger than 0.
     * @return VisualEditFragment to get.
     */

    public VisualEditFragment getLastVisualEditFragment() {
        return uiVisualEditFragments.get(uiVisualEditFragments.size()-1);
    }

    /**
     * Remove VisualEditFragment by object.
     * @param fragment VisualEditFragment to be removed.
     */

    public void removeVisualEditFragment(ISelectable fragment) {
        int toRemove = uiWindowVisualStack.getChildren().indexOf(((VisualEditFragment)fragment).getFragment());

        uiWindowVisualStack.getChildren().remove(toRemove);
        uiWindowVisualStack.getChildren().remove(toRemove);

        uiVisualEditFragments.remove(((VisualEditFragment)fragment));
    }

    /**
     * Get main view fragment.
     * @return uiScrollPane.
     */

    @Override
    public Node getFragment() {
        return uiWindowScrollpane;
    }

    /**
     * Is called when item is selected, changes look.
     */

    @Override
    public void select() {
        uiWindowScrollpane.setBorder(new Border(new BorderStroke(Application.State.isDarkTheme?Color.WHITE:Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
    }

    /**
     * Is called when item is deselected, changes look.
     */

    @Override
    public void deselect() {
        uiWindowScrollpane.setBorder(Border.EMPTY);
    }

    /**
     * Specifies what kind of SelectionType this object is.
     * @return SelectionType.
     */

    @Override
    public SelectionType getType() {
        return SelectionType.VISUAL_EDIT;
    }
}
