package userinterface.fragments;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
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
    }

    /**
     * Adds a VisualEditFragment as a visual element.
     * @param fragment Fragment with data.
     */

    public void addVisualEditFragment(VisualEditFragment fragment) {
        uiVisualEditFragments.add(fragment);
        uiWindowVisualStack.getChildren().add(fragment.getFragment());
        uiWindowVisualStack.setSpacing(10);
        ImageView image = Utils.getImageView(this, Application.IconPaths.ARROW_RIGHT_CIRCLE,25, 25);

        HBox.setMargin(fragment.getFragment(), new Insets(10,10,5,10));
        uiWindowVisualStack.setAlignment(Pos.CENTER_RIGHT);
        uiWindowVisualStack.getChildren().add(image);
    }

    /**
     * Helper method to add a newVisualEditFragment.
     */

    public void addVisualEditFragment() {
        VisualEditFragment visualEditFragment = new VisualEditFragment();
        uiVisualEditFragments.add(visualEditFragment);
        uiWindowVisualStack.getChildren().add(visualEditFragment.getFragment());
        uiWindowVisualStack.setSpacing(10);
        ImageView image = Utils.getImageView(this, Application.IconPaths.ARROW_RIGHT_CIRCLE,25, 25);

        HBox.setMargin(visualEditFragment.getFragment(), new Insets(10,10,5,10));
        uiWindowVisualStack.setAlignment(Pos.CENTER_RIGHT);
        uiWindowVisualStack.getChildren().add(image);
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
        uiWindowScrollpane.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
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
