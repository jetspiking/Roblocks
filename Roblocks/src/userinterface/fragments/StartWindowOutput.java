package userinterface.fragments;

import javafx.scene.Node;
import javafx.scene.control.TextArea;
import userinterface.interfaces.IFragment;
import userinterface.interfaces.ISelectable;
import userinterface.enums.SelectionType;

/**
 * Create the JSON-output (code) window.
 */

public class StartWindowOutput implements IFragment, ISelectable {
    public final TextArea uiOutput = new TextArea();

    /**
     * Construct the window.
     */

    public StartWindowOutput()
    {
        uiOutput.setWrapText(true);
        uiOutput.setStyle("-fx-test-inner-color: black;");
    }

    /**
     * Get main view fragment.
     * @return uiTextArea.
     */

    @Override
    public Node getFragment() {
        return uiOutput;
    }

    /**
     * Is called when item is selected, changes look.
     */

    @Override
    public void select() {
    }

    /**
     * Is called when item is deselected, changes look.
     */

    @Override
    public void deselect() {
    }

    /**
     * Specifies what kind of SelectionType this object is.
     * @return SelectionType.
     */

    @Override
    public SelectionType getType() {
        return SelectionType.OUTPUT;
    }
}
