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
import userinterface.models.ToolboxItem;
import java.util.ArrayList;

/**
 * Create the toolbox view window, which displays all actions from the JSON-protocol.
 */

public class StartWindowToolbox implements IFragment, ISelectable {
    public final VBox uiToolbox = new VBox();
    public final GridPane uiMetroToolBox = new GridPane();
    public final ArrayList<ToolboxFragment> uiToolboxFragments = new ArrayList<ToolboxFragment>();

    public final HBox uiButtonBar = new HBox();
    public final Button uiHome = new Button("Home"); // "Home"
    public final Button uiAdd = new Button("Add"); // "Add"
    public final Button uiRemove = new Button("Remove"); // "Remove"

    public ToolboxFragment uiSelectedNode;

    /**
     * Construct the toolbox window.
     */

    public StartWindowToolbox()
    {
        ImageView homeImage = Utils.getImageView(this, Application.IconPaths.HOME,20, 20);
        uiHome.setBackground(null);
        uiHome.setGraphic(homeImage);

        ImageView addImage = Utils.getImageView(this, Application.IconPaths.PLUS_CIRCLE,20, 20);
        uiAdd.setBackground(null);
        uiAdd.setGraphic(addImage);

        ImageView removeImage = Utils.getImageView(this, Application.IconPaths.MINUS_CIRCLE,20, 20);
        uiRemove.setBackground(null);
        uiRemove.setGraphic(removeImage);

        Utils.bindNodesTransparentBackground(uiHome, uiAdd, uiRemove);

        uiButtonBar.getChildren().addAll(uiAdd, uiRemove); // REMOVED m_home from adding

        uiToolbox.getChildren().add(uiButtonBar);

        ScrollPane toolBox = new ScrollPane();
        Utils.bindNodeTransparentFocus(toolBox);

        toolBox.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        toolBox.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        toolBox.setFitToWidth(true);
        uiToolbox.getChildren().add(toolBox);

        toolBox.prefHeightProperty().bind(uiToolbox.heightProperty());
        toolBox.setContent(uiMetroToolBox);
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
            String path = Application.Paths.ICONS_PATH+toolboxItem.getImageName();
            boolean exists = Utils.verifyExistingLocation(path, this);

            ImageView imageView = Utils.getImageView(this, exists?path:Application.IconPaths.X,20, 20);

            ToolboxFragment toolboxFragment = new ToolboxFragment(toolboxItem, imageView);
            toolboxFragment.setColor(Utils.getRandomBrightColor());

            ((BorderPane)toolboxFragment.getFragment()).prefWidthProperty().bind(uiToolbox.widthProperty().divide(gridwidth));
            ((BorderPane)toolboxFragment.getFragment()).prefHeightProperty().bind(uiToolbox.widthProperty().divide(gridwidth));

            uiMetroToolBox.add(toolboxFragment.getFragment(), x++%2, y++/2);

            uiToolboxFragments.add(toolboxFragment);
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
        uiButtonBar.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
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
}
