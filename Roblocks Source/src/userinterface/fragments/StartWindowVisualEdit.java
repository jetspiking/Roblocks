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

public class StartWindowVisualEdit implements IFragment, ISelectable {
    public final ScrollPane uiWindowScrollpane = new ScrollPane();
    public final HBox uiWindowVisualStack = new HBox();
    public final ArrayList<VisualEditFragment> uiVisualEditFragments = new ArrayList<VisualEditFragment>();

    public StartWindowVisualEdit() {
        uiWindowScrollpane.setContent(uiWindowVisualStack);
    }

    public void addVisualEditFragment(VisualEditFragment fragment) {
        uiVisualEditFragments.add(fragment);
        uiWindowVisualStack.getChildren().add(fragment.getFragment());
        uiWindowVisualStack.setSpacing(10);
        ImageView image = Utils.getImageView(this, Application.IconPaths.ARROW_RIGHT_CIRCLE,25, 25);

        HBox.setMargin(fragment.getFragment(), new Insets(10,10,5,10));
        uiWindowVisualStack.setAlignment(Pos.CENTER_RIGHT);
        uiWindowVisualStack.getChildren().add(image);
    }

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


    public VisualEditFragment getLastVisualEditFragment() {
        return uiVisualEditFragments.get(uiVisualEditFragments.size()-1);
    }

    public void removeVisualEditFragment(ISelectable fragment) {
        int toRemove = uiWindowVisualStack.getChildren().indexOf(((VisualEditFragment)fragment).getFragment());

        uiWindowVisualStack.getChildren().remove(toRemove);
        uiWindowVisualStack.getChildren().remove(toRemove);

        uiVisualEditFragments.remove(((VisualEditFragment)fragment));
    }

    @Override
    public Node getFragment() {
        return uiWindowScrollpane;
    }

    @Override
    public void select() {
        uiWindowScrollpane.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
    }

    @Override
    public void deselect() {
        uiWindowScrollpane.setBorder(Border.EMPTY);
    }

    @Override
    public SelectionType getType() {
        return SelectionType.VISUAL_EDIT;
    }
}
