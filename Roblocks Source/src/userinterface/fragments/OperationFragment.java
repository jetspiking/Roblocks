package userinterface.fragments;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import miscellaneous.utilities.Utils;
import userinterface.enums.SelectionType;
import userinterface.interfaces.IFragment;
import userinterface.interfaces.IInteractable;
import userinterface.interfaces.ISelectable;

import java.util.ArrayList;
import java.util.Arrays;

public class OperationFragment implements IFragment, ISelectable, IInteractable {
    public final BorderPane uiBorderPane = new BorderPane();
    public final ToolboxFragment toolboxFragment;
    public final Label uiName;

    public final String name;
    public final ArrayList<String> attributes = new ArrayList<String>();;
    public final ArrayList<String> attributeValues= new ArrayList<String>();;

    public OperationFragment(ToolboxFragment toolboxFragment) {
        this.toolboxFragment = toolboxFragment;
        uiName = new Label(toolboxFragment.uiToolboxItem.getName());
        uiBorderPane.setCenter(uiName);

        this.attributes.addAll(Arrays.asList(toolboxFragment.uiToolboxItem.getAttributes()));
        this.attributes.forEach(attribute -> this.attributeValues.add(""));

        this.name = toolboxFragment.uiToolboxItem.getName();

        build();
    }

    private void build() {
        uiBorderPane.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
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

    @Override
    public Node getFragment() {
        return uiBorderPane;
    }

    @Override
    public void hover() {
        Font defaultFont = Font.getDefault();
        uiName.setFont(Font.font("Verdana", FontWeight.BOLD, defaultFont.getSize()));
    }

    @Override
    public void exit() {
        Font defaultFont = Font.getDefault();
        uiName.setFont(Font.font(defaultFont.getFamily(), FontWeight.NORMAL, defaultFont.getSize()));
    }

    @Override
    public void select() {
        uiBorderPane.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(2,2,2,2))));
    }

    @Override
    public void deselect() {
        uiBorderPane.setBorder(null);
    }

    @Override
    public SelectionType getType() {
        return SelectionType.OPERATION_ITEM;
    }
}
