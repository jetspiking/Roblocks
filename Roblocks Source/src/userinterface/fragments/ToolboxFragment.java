package userinterface.fragments;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import userinterface.interfaces.IFragment;
import userinterface.interfaces.IInteractable;
import userinterface.interfaces.ISelectable;
import userinterface.enums.SelectionType;
import userinterface.models.ToolboxItem;

public class ToolboxFragment implements IFragment, ISelectable, IInteractable {
    public final BorderPane uiBorderPane = new BorderPane();
    public final ImageView uiIcon;
    public final ToolboxItem uiToolboxItem;
    public Color color;

    public ToolboxFragment(ToolboxItem toolboxItem, ImageView icon) {
        uiIcon = icon;
        uiToolboxItem = toolboxItem;
        build();
    }

    private void build() {
        uiBorderPane.setCenter(uiIcon);

        Label text = new Label();
        text.setText(uiToolboxItem.getName());
        //text.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        text.setTextFill(Color.BLACK);

        uiIcon.fitWidthProperty().bind(uiBorderPane.widthProperty().divide(2));
        uiIcon.fitHeightProperty().bind(uiBorderPane.widthProperty().divide(2));

        uiBorderPane.setBottom(text);
        BorderPane.setAlignment(text, Pos.CENTER);
        BorderPane.setMargin(text, new Insets(0,0,10,0));
    }

    public void setColor(Color color) {
        this.color = color;
        uiBorderPane.setBackground(new Background(new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY)));
    }

    @Override
    public Node getFragment() {
        return uiBorderPane;
    }

    @Override
    public void select() {
       uiBorderPane.setOpacity(1.);
       uiBorderPane.setBackground(new Background(new BackgroundFill(color, new CornerRadii(4), new Insets(1,1,1,1))));
       uiBorderPane.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(4), new BorderWidths(3,3,3,3))));
    }

    @Override
    public void deselect() {
        uiBorderPane.setOpacity(1.);
        uiBorderPane.setBackground(new Background(new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY)));
        uiBorderPane.setBorder(null);
    }

    @Override
    public SelectionType getType() {
        return SelectionType.TOOLBOX_ITEM;
    }

    @Override
    public void hover() {
        uiBorderPane.setOpacity(.7);
        uiBorderPane.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(4), new BorderWidths(1.,1.,1.,1.))));
    }

    @Override
    public void exit() {
        uiBorderPane.setOpacity(1.);
        uiBorderPane.setBorder(null);
    }
}
