package userinterface.fragments;

import javafx.scene.Node;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.Region;
import miscellaneous.utilities.Utils;
import userinterface.interfaces.IFragment;
import java.util.ArrayList;

/**
 * Builds the startup (main) window of the application.
 */

public class StartWindowContent implements IFragment {
    public final SplitPane uiContentPane = new SplitPane();

    public final StartWindowOutput output = new StartWindowOutput();
    public final StartWindowVisualEdit visualEdit = new StartWindowVisualEdit();
    public final StartWindowToolbox toolbox = new StartWindowToolbox();

    private double outputDividerPosition = .2;
    private double toolboxDividerPosition = .8;

    /**
     * Construct fragment.
     */

    public StartWindowContent()
    {
        uiContentPane.getItems().addAll(output.getFragment(), visualEdit.getFragment(), toolbox.getFragment());

        ((Region)output.getFragment()).setMinWidth(0);
        ((Region)visualEdit.getFragment()).setMinWidth(0);
        ((Region)toolbox.getFragment()).setMinWidth(0);

        Utils.bindNodesTransparentFocus(uiContentPane, output.getFragment(), visualEdit.getFragment(), toolbox.getFragment(), (Node)output.uiOutput, (Node)visualEdit.uiWindowVisualStack, (Node)toolbox.uiToolbox, (Node)toolbox.uiMetroToolBox);

        uiContentPane.setDividerPosition(0,.2);
        uiContentPane.setDividerPosition(1, .8);
    }

    /**
     * Set output to boolean visible.
     * @param visible True (show), False (hide).
     */

    public void setOutputVisible(boolean visible) {
        output.getFragment().setVisible(visible);

        uiContentPane.getItems().get(0).setVisible(visible);

        uiContentPane.setDividerPosition(0,visible?outputDividerPosition:0);

        ArrayList<Node> nodes = new ArrayList<>(uiContentPane.lookupAll(".split-pane-divider"));
        nodes.get(0).setVisible(visible);
    }

    /**
     * Set visualEdit to boolean visible.
     * @param visible True (show), False (hide).
     */

    public void setVisualEditVisible(boolean visible) {
        visualEdit.getFragment().setVisible(visible);
        if (!visible) {
            outputDividerPosition = uiContentPane.getDividerPositions()[0];
            toolboxDividerPosition = uiContentPane.getDividerPositions()[1];
        }
        uiContentPane.setDividerPosition(0,visible?outputDividerPosition:.5);
        uiContentPane.setDividerPosition(1, visible?toolboxDividerPosition:.5);
    }

    /**
     * Set toolbox to boolean visible.
     * @param visible True (show), False (hide).
     */

    public void setToolboxVisible(boolean visible) {
        toolbox.getFragment().setVisible(visible);

        ArrayList<Node> nodes = new ArrayList<>(uiContentPane.lookupAll(".split-pane-divider"));
        nodes.get(1).setVisible(visible);

        uiContentPane.setDividerPosition(1,visible?toolboxDividerPosition:1.);
    }

    /**
     * Get main view fragment.
     * @return uiSplitPane.
     */

    @Override
    public Node getFragment() {
        return uiContentPane;
    }
}
