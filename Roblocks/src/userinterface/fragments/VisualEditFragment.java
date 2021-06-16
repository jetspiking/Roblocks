package userinterface.fragments;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import miscellaneous.constants.Application;
import miscellaneous.utilities.Utils;
import userinterface.interfaces.IFragment;
import userinterface.interfaces.IInteractable;
import userinterface.interfaces.ISelectable;
import userinterface.enums.SelectionType;
import userinterface.interfaces.IThemeSwitcher;

import java.util.ArrayList;

import static miscellaneous.constants.Application.Containers.TopBar.MENU_BUTTON_SIZE;
import static miscellaneous.utilities.Utils.createMenuButton;

/**
 * VisualEditFragment view.
 */

public class VisualEditFragment implements IFragment, ISelectable, IInteractable, IThemeSwitcher {
    public final BorderPane uiBorderPane = new BorderPane();
    public final HBox uiTopBar = new HBox();
    public final VBox uiCenterStack = new VBox();
    public final HBox uiBottomBar = new HBox();
    public MenuButton uiMenuFlyout = new MenuButton();
    public final CheckMenuItem uiMenuFlyoutRename = new CheckMenuItem("Rename");
    public final MenuItem uiMenuFlyoutDelete = new MenuItem("Delete");
    public final TextField uiTitleField = new TextField();
    public final ArrayList<ToolboxFragment> uiToolboxFragments = new ArrayList<ToolboxFragment>();
    public final ArrayList<OperationFragment> uiOperationFragments = new ArrayList<OperationFragment>();

    public String name = "Node";

    public Color color = Color.GRAY;

    /**
     * Constructs a VisualEditFragment View.
     */

    public VisualEditFragment() {
        uiBorderPane.setTop(uiTopBar);
        uiBorderPane.setCenter(uiCenterStack);
        uiBorderPane.setBottom(uiBottomBar);

        build();
    }

    /**
     * Helper method to build the view and keep constructor more clear.
     */

    private void build() {
        uiTopBar.getChildren().add(uiTitleField);

        ImageView menuImage = Utils.getImageView(this, Application.IconPaths.getThemeImageURL(Application.Icons.MORE_VERTICAL), MENU_BUTTON_SIZE, MENU_BUTTON_SIZE);
        uiMenuFlyout = createMenuButton(menuImage, "", false);
        uiMenuFlyout.getItems().addAll(uiMenuFlyoutRename, uiMenuFlyoutDelete); // uiMenuFlyoutDuplicate not added
        Utils.bindNodesTransparentBackground(uiMenuFlyout);

        uiTopBar.getChildren().add(uiMenuFlyout);

        uiTopBar.setBorder(new Border(new BorderStroke(Color.GRAY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1,1,0,1))));
        uiTopBar.setPrefHeight(35);
        uiTitleField.setPrefHeight(35);
        uiTopBar.setAlignment(Pos.CENTER_LEFT);

        uiTitleField.setText(Application.InterfaceStrings.VISUAL_EDIT_FRAGMENT_DEFAULT_TITLE);

        uiCenterStack.setBackground(new Background(new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY)));
        uiCenterStack.setPrefHeight(200);

        uiBottomBar.setBorder(new Border(new BorderStroke(Color.GRAY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(0,1,1,1))));
        uiBottomBar.setPrefHeight(35);
        uiBottomBar.setAlignment(Pos.CENTER_RIGHT);

        ImageView spacingArrow = Utils.getImageView(this, Application.IconPaths.getThemeImageURL(Application.Icons.CHEVRON_DOWN), 20,20);
        uiCenterStack.setAlignment(Pos.TOP_LEFT);
        uiCenterStack.getChildren().add(spacingArrow);

        uiMenuFlyoutRename.setSelected(false);
        uiTitleField.setEditable(false);

        uiMenuFlyoutRename.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                uiTitleField.setEditable(uiMenuFlyoutRename.isSelected());
            }
        });

        uiBorderPane.setPrefWidth(175);

        Utils.bindNodeTransparentFocus(uiTitleField);
        Utils.bindNodeTransparentBackground(uiTitleField);

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                if (Application.State.isDarkTheme)
                    toDarkMode();
                else
                    toLightMode();
            }
        });

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

    public void addOperationFragment(ToolboxFragment toolboxFragment) {
       if (!uiToolboxFragments.contains(toolboxFragment)) {
           OperationFragment operationFragment = new OperationFragment(toolboxFragment);
           uiOperationFragments.add(operationFragment);
           uiCenterStack.getChildren().add(operationFragment.getFragment());
           uiToolboxFragments.add(toolboxFragment);
       }
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

    }

    /**
     * Is called on mouse exit, changes look.
     */

    @Override
    public void exit() {

    }

    /**
     * Is called when item is selected, changes look.
     */

    @Override
    public void select() {
        uiBorderPane.setBorder(new Border(new BorderStroke(Application.State.isDarkTheme?Color.WHITE:Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
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
     * @return SelectionType
     */

    @Override
    public SelectionType getType() {
        return SelectionType.VISUAL_EDIT_ITEM;
    }

    /**
     * Switch fragment to dark mode appearance.
     */
    @Override
    public void toDarkMode() {
        uiTitleField.setStyle("-fx-text-inner-color: white;");
    }

    /**
     * Switch fragment to white mode appearance.
     */
    @Override
    public void toLightMode() {
        uiTitleField.setStyle("-fx-text-inner-color: black;");
    }
}
