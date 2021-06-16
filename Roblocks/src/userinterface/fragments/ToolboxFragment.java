package userinterface.fragments;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import miscellaneous.constants.Application;
import userinterface.interfaces.IFragment;
import userinterface.interfaces.IInteractable;
import userinterface.interfaces.ISelectable;
import userinterface.enums.SelectionType;
import userinterface.models.ToolboxItem;

/**
 * ToolboxFragment element.
 */

public class ToolboxFragment implements IFragment, ISelectable, IInteractable {
    public final BorderPane uiBorderPane = new BorderPane();
    public final ImageView uiIcon;
    public final ToolboxItem uiToolboxItem;
    public Color color;

    /**
     * Constructs a ToolboxFragment.
     * @param toolboxItem ToolboxItem.
     * @param icon ImageView.
     */

    public ToolboxFragment(ToolboxItem toolboxItem, ImageView icon) {
        uiIcon = icon;
        uiToolboxItem = toolboxItem;
        build();
    }

    /**
     * Helper method to build the view and keep constructor more clear.
     */

    private void build() {
        uiBorderPane.setCenter(uiIcon);

        Label text = new Label();
        text.setText(uiToolboxItem.getName());
        text.setFont(Application.Containers.TopBar.MENU_BUTTON_FONT);

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

    /**
     * Get main view fragment
     * @return uiBorderPane
     */

    @Override
    public Node getFragment() {
        return uiBorderPane;
    }

    /**
     * Is called when item is selected, changes look.
     */

    @Override
    public void select() {
       uiBorderPane.setOpacity(1.);
       uiBorderPane.setBackground(new Background(new BackgroundFill(color, new CornerRadii(4), new Insets(1,1,1,1))));
       uiBorderPane.setBorder(new Border(new BorderStroke(Application.State.isDarkTheme?Color.WHITE:Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(4), new BorderWidths(3,3,3,3))));
    }

    /**
     * Is called when item is deselected, changes look.
     */

    @Override
    public void deselect() {
        uiBorderPane.setOpacity(1.);
        uiBorderPane.setBackground(new Background(new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY)));
        uiBorderPane.setBorder(null);
    }

    /**
     * Specifies what kind of SelectionType this object is.
     * @return SelectionType
     */

    @Override
    public SelectionType getType() {
        return SelectionType.TOOLBOX_ITEM;
    }

    /**
     * Is called on mouse hover, changes look.
     */

    @Override
    public void hover() {
        uiBorderPane.setOpacity(.7);
        uiBorderPane.setBorder(new Border(new BorderStroke(Application.State.isDarkTheme?Color.WHITE:Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(4), new BorderWidths(1.,1.,1.,1.))));
    }

    /**
     * Is called on mouse exit, changes look.
     */

    @Override
    public void exit() {
        uiBorderPane.setOpacity(1.);
        uiBorderPane.setBorder(null);
    }
}
