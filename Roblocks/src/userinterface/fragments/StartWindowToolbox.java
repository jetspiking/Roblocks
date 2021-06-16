package userinterface.fragments;

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
import userinterface.interfaces.IThemeSwitcher;
import userinterface.models.ToolboxItem;
import java.util.ArrayList;

import static miscellaneous.constants.Application.Containers.TopBar.MENU_BUTTON_SIZE;

/**
 * Create the toolbox view window, which displays all actions from the JSON-protocol.
 */

public class StartWindowToolbox implements IFragment, ISelectable, IThemeSwitcher {
    public final VBox uiToolbox = new VBox();
    public final GridPane uiMetroToolBox = new GridPane();
    public final ArrayList<ToolboxFragment> uiToolboxFragments = new ArrayList<ToolboxFragment>();

    public final HBox uiButtonBar = new HBox();
    public final Button uiAdd = new Button(""); // "Add"
    public final Button uiRemove = new Button(""); // "Remove"
    public final Button uiSettings = new Button(""); // "Home"

    public ToolboxFragment uiSelectedNode;

    /**
     * Construct the toolbox window.
     */

    public StartWindowToolbox()
    {
        ImageView homeImage = Utils.getImageView(this, Application.IconPaths.getThemeImageURL(Application.Icons.EDIT), MENU_BUTTON_SIZE, MENU_BUTTON_SIZE);
        uiSettings.setBackground(null);
        uiSettings.setGraphic(homeImage);

        ImageView addImage = Utils.getImageView(this, Application.IconPaths.getThemeImageURL(Application.Icons.PLUS_CIRCLE),MENU_BUTTON_SIZE, MENU_BUTTON_SIZE);
        uiAdd.setBackground(null);
        uiAdd.setGraphic(addImage);

        ImageView removeImage = Utils.getImageView(this, Application.IconPaths.getThemeImageURL(Application.Icons.MINUS_CIRCLE),MENU_BUTTON_SIZE, MENU_BUTTON_SIZE);
        uiRemove.setBackground(null);
        uiRemove.setGraphic(removeImage);

        Utils.bindNodesTransparentBackground(uiSettings, uiAdd, uiRemove);

        uiButtonBar.getChildren().addAll(uiAdd, uiRemove, uiSettings);

        uiToolbox.getChildren().add(uiButtonBar);

        ScrollPane toolBox = new ScrollPane();
        Utils.bindNodeTransparentFocus(toolBox);

        toolBox.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        toolBox.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        toolBox.setFitToWidth(true);
        uiToolbox.getChildren().add(toolBox);

        toolBox.prefHeightProperty().bind(uiToolbox.heightProperty());
        toolBox.setContent(uiMetroToolBox);

        uiMetroToolBox.vgapProperty().bind(uiToolbox.heightProperty().divide(200));
        uiMetroToolBox.hgapProperty().bind(uiToolbox.heightProperty().divide(200));
    }

    /**
     * Set ArrayList of ToolboxItems.
     * @param toolboxItems List of ToolboxItems.
     */

    public void setToolbox(ArrayList<ToolboxItem> toolboxItems)
    {
        uiToolboxFragments.clear();

        final int gridwidth = 2;

        int x = 0;
        int y = 0;

        for (ToolboxItem toolboxItem : toolboxItems)
        {
            String path = Application.IconPaths.getThemeImageURL(toolboxItem.getImageName());
            boolean exists = Utils.verifyExistingLocation(path, this);

            ImageView imageView = Utils.getImageView(this, exists?Application.IconPaths.getThemeImageURL(toolboxItem.getImageName()):Application.IconPaths.getThemeImageURL(Application.Icons.X),MENU_BUTTON_SIZE, MENU_BUTTON_SIZE);

            ToolboxFragment toolboxFragment = new ToolboxFragment(toolboxItem, imageView);
            toolboxFragment.setColor(Application.State.isDarkTheme?Utils.getRandomDarkColor():Utils.getRandomBrightColor());

            uiMetroToolBox.add(toolboxFragment.getFragment(), x++%2, y++/2);

            uiToolboxFragments.add(toolboxFragment);

            ((BorderPane)toolboxFragment.getFragment()).prefWidthProperty().bind(uiToolbox.widthProperty().divide(gridwidth));
            ((BorderPane)toolboxFragment.getFragment()).prefHeightProperty().bind(uiToolbox.widthProperty().divide(gridwidth));
        }
    }

    /**
     * Update a node to selected state.
     * @param node ToolboxFragment that should be swapped to selected state.
     */

    public void updateSelectedNode(ToolboxFragment node) {
        if (uiSelectedNode !=null) {
            uiSelectedNode.deselect();
        }

        uiSelectedNode = node;
        uiSelectedNode.select();
    }

    /**
     * Get main view fragment.
     * @return uiVBox.
     */

    @Override
    public Node getFragment() {
        return uiToolbox;
    }

    /**
     * Is called when item is selected, changes look.
     */

    @Override
    public void select() {
        uiButtonBar.setBorder(new Border(new BorderStroke(Application.State.isDarkTheme?Color.WHITE:Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
    }

    /**
     * Is called when item is deselected, changes look.
     */

    @Override
    public void deselect() {
        uiButtonBar.setBorder(null);
    }

    /**
     * Specifies what kind of SelectionType this object is.
     * @return SelectionType.
     */

    @Override
    public SelectionType getType() {
        return SelectionType.TOOLBOX;
    }

    /**
     * Switch fragment to dark mode appearance.
     */

    @Override
    public void toDarkMode() {
        ImageView homeImage = Utils.getImageView(this, Application.IconPaths.getThemeImageURL(Application.Icons.EDIT), MENU_BUTTON_SIZE, MENU_BUTTON_SIZE);
        uiSettings.setGraphic(homeImage);

        ImageView addImage = Utils.getImageView(this, Application.IconPaths.getThemeImageURL(Application.Icons.PLUS_CIRCLE),MENU_BUTTON_SIZE, MENU_BUTTON_SIZE);
        uiAdd.setGraphic(addImage);

        ImageView removeImage = Utils.getImageView(this, Application.IconPaths.getThemeImageURL(Application.Icons.MINUS_CIRCLE),MENU_BUTTON_SIZE, MENU_BUTTON_SIZE);
        uiRemove.setGraphic(removeImage);
    }

    /**
     * Switch fragment to light mode appearance.
     */

    @Override
    public void toLightMode() {
        ImageView homeImage = Utils.getImageView(this, Application.IconPaths.getThemeImageURL(Application.Icons.EDIT), MENU_BUTTON_SIZE, MENU_BUTTON_SIZE);
        uiSettings.setGraphic(homeImage);

        ImageView addImage = Utils.getImageView(this, Application.IconPaths.getThemeImageURL(Application.Icons.PLUS_CIRCLE),MENU_BUTTON_SIZE, MENU_BUTTON_SIZE);
        uiAdd.setGraphic(addImage);

        ImageView removeImage = Utils.getImageView(this, Application.IconPaths.getThemeImageURL(Application.Icons.MINUS_CIRCLE),MENU_BUTTON_SIZE, MENU_BUTTON_SIZE);
        uiRemove.setGraphic(removeImage);
    }
}
