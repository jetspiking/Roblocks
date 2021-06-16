package userinterface.fragments;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import miscellaneous.constants.Application;
import miscellaneous.utilities.Utils;
import userinterface.enums.SelectionType;
import userinterface.interfaces.IFragment;
import userinterface.interfaces.IInteractable;
import userinterface.interfaces.ISelectable;
import userinterface.interfaces.IThemeSwitcher;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * OperationFragment builds a view of an operation.
 */

public class OperationFragment implements IFragment, ISelectable, IInteractable, IThemeSwitcher {
    public final BorderPane uiBorderPane = new BorderPane();
    public final ToolboxFragment toolboxFragment;
    public final Label uiName;

    public final String name;
    public final ArrayList<String> attributes = new ArrayList<String>();;
    public final ArrayList<String> attributeValues= new ArrayList<String>();;

    /**
     * Constructs an OperationFragment
     * @param toolboxFragment Fragment to add to.
     */

    public OperationFragment(ToolboxFragment toolboxFragment) {
        this.toolboxFragment = toolboxFragment;
        uiName = new Label(toolboxFragment.uiToolboxItem.getName());
        uiBorderPane.setCenter(uiName);

        this.attributes.addAll(Arrays.asList(toolboxFragment.uiToolboxItem.getAttributes()));
        this.attributes.forEach(attribute -> this.attributeValues.add(""));

        this.name = toolboxFragment.uiToolboxItem.getName();

        build();
    }

    /**
     * Helper method to build the view and keep constructor more clear.
     */

    private void build() {
        uiBorderPane.setBackground(new Background(new BackgroundFill(Application.State.isDarkTheme?Application.Colors.DARK_MODE_COLOR:Application.Colors.LIGHT_MODE_COLOR, CornerRadii.EMPTY, Insets.EMPTY)));
        VBox.setMargin(uiBorderPane, new Insets(0,0,10,0));

        BorderPane typeHint = new BorderPane();
        ImageView configure = new ImageView();
        Utils.bindNodeTransparentFocus(typeHint);
        configure.setImage(toolboxFragment.uiIcon.getImage());
        configure.setFitWidth(20);
        configure.setFitHeight(20);
        typeHint.setCenter(configure);
        uiBorderPane.setRight(typeHint);

        typeHint.setBackground(new Background(new BackgroundFill(toolboxFragment.color, CornerRadii.EMPTY, Insets.EMPTY)));
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
     * Is called on mouse hover, changes look.
     */

    @Override
    public void hover() {
        Font defaultFont = Font.getDefault();
        uiName.setFont(Font.font("Verdana", FontWeight.BOLD, defaultFont.getSize()));
    }

    /**
     * Is called on mouse exit, changes look.
     */

    @Override
    public void exit() {
        Font defaultFont = Font.getDefault();
        uiName.setFont(Font.font(defaultFont.getFamily(), FontWeight.NORMAL, defaultFont.getSize()));
    }

    /**
     * Is called when item is selected, changes look.
     */

    @Override
    public void select() {
        uiBorderPane.setBorder(new Border(new BorderStroke(Application.State.isDarkTheme?Color.WHITE:Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(2,2,2,2))));
    }

    /**
     * Is called when item is deselected, changes look.
     */

    @Override
    public void deselect() {
        uiBorderPane.setBorder(null);
    }

    /**
     * Specifies what kind of SelectionType this object is.
     * @return SelectionType.
     */

    @Override
    public SelectionType getType() {
        return SelectionType.OPERATION_ITEM;
    }

    /**
     * Switch fragment to dark mode appearance.
     */

    @Override
    public void toDarkMode() {
        uiBorderPane.setBackground(new Background(new BackgroundFill(Application.Colors.DARK_MODE_COLOR, CornerRadii.EMPTY, Insets.EMPTY)));
    }

    /**
     * Switch fragment to light mode appearance.
     */

    @Override
    public void toLightMode() {
        uiBorderPane.setBackground(new Background(new BackgroundFill(Application.Colors.LIGHT_MODE_COLOR, CornerRadii.EMPTY, Insets.EMPTY)));
    }
}
