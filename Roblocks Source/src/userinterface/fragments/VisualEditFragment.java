package userinterface.fragments;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import miscellaneous.constants.Application;
import miscellaneous.utilities.Utils;
import userinterface.interfaces.IFragment;
import userinterface.interfaces.IInteractable;
import userinterface.interfaces.ISelectable;
import userinterface.enums.SelectionType;

import java.util.ArrayList;

public class VisualEditFragment implements IFragment, ISelectable, IInteractable {
    public final BorderPane uiBorderPane = new BorderPane();
    public final HBox uiTopBar = new HBox();
    public final VBox uiCenterStack = new VBox();
    public final HBox uiBottomBar = new HBox();
    public final Button uiSettingsButton = new Button();
    public final TextField uiTitleField = new TextField();
    public final ArrayList<ToolboxFragment> uiToolboxFragments = new ArrayList<ToolboxFragment>();
    public final ArrayList<OperationFragment> uiOperationFragments = new ArrayList<OperationFragment>();

    public String name = "Node";

    public Color color = Color.GRAY;

    public VisualEditFragment() {
        uiBorderPane.setTop(uiTopBar);
        uiBorderPane.setCenter(uiCenterStack);
        uiBorderPane.setBottom(uiBottomBar);

        build();
    }

    private void build() {
        uiTopBar.getChildren().add(uiTitleField);
        uiTopBar.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        uiTitleField.setBorder(new Border(new BorderStroke(Color.GRAY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1,1,0,1))));
        Utils.bindNodeTransparentBackground(uiTitleField);
        Utils.bindNodeTransparentFocus(uiTitleField);
        uiTitleField.setPrefHeight(20);
        uiTitleField.setText(Application.InterfaceStrings.VISUAL_EDIT_FRAGMENT_DEFAULT_TITLE);

        uiCenterStack.setBackground(new Background(new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY)));
        uiCenterStack.setPrefHeight(200);

        ImageView settings = Utils.getImageView(this, Application.IconPaths.SETTINGS,20, 20);
        uiSettingsButton.setGraphic(settings);
        uiBottomBar.setBorder(new Border(new BorderStroke(Color.GRAY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(0,1,1,1))));
        uiBottomBar.setAlignment(Pos.CENTER_RIGHT);
        uiBottomBar.getChildren().add(uiSettingsButton);
        Utils.bindNodeTransparentFocus(uiSettingsButton);
        Utils.bindNodesTransparentBackground(uiSettingsButton);

        ImageView spacingArrow = Utils.getImageView(this, Application.IconPaths.CHEVRON_DOWN, 20,20);
        uiCenterStack.setAlignment(Pos.TOP_LEFT);
        uiCenterStack.getChildren().add(spacingArrow);

    }

    public void removeOperationFragment(OperationFragment operationFragment) {
        int toRemove = uiCenterStack.getChildren().indexOf(((OperationFragment)operationFragment).getFragment());
        if (toRemove!=-1) {
            uiCenterStack.getChildren().remove(toRemove);
            uiToolboxFragments.remove(operationFragment.toolboxFragment);
        }
        uiOperationFragments.remove(operationFragment);
    }

    public OperationFragment getLastOperationFragment() {
        return uiOperationFragments.get(uiOperationFragments.size()-1);
    }

    public void addOperationFragment2(ToolboxFragment toolboxFragment) {
        OperationFragment operationFragment = new OperationFragment(toolboxFragment);
        uiOperationFragments.add(operationFragment);
        uiCenterStack.getChildren().add(operationFragment.getFragment());
    }

    public void addOperationFragment(ToolboxFragment toolboxFragment) {
       if (!uiToolboxFragments.contains(toolboxFragment)) {
           OperationFragment operationFragment = new OperationFragment(toolboxFragment);
           uiOperationFragments.add(operationFragment);
           uiCenterStack.getChildren().add(operationFragment.getFragment());
           uiToolboxFragments.add(toolboxFragment);
       }
    }

    @Override
    public Node getFragment() {
        return uiBorderPane;
    }

    @Override
    public void hover() {

    }

    @Override
    public void exit() {

    }

    @Override
    public void select() {
        uiBorderPane.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
    }

    @Override
    public void deselect() {
        uiBorderPane.setBorder(null);
    }

    @Override
    public SelectionType getType() {
        return SelectionType.VISUAL_EDIT_ITEM;
    }

    @Override
    public String toString() {
        return "VisualEditFragment{" +
                "m_borderPane=" + uiBorderPane +
                ", m_topBar=" + uiTopBar +
                ", m_centerStack=" + uiCenterStack +
                ", m_bottomBar=" + uiBottomBar +
                ", m_settingsButton=" + uiSettingsButton +
                ", m_titleField=" + uiTitleField +
                ", m_toolboxFragments=" + uiToolboxFragments +
                ", m_operationFragments=" + uiOperationFragments +
                ", name='" + name + '\'' +
                ", m_color=" + color +
                '}';
    }
}
