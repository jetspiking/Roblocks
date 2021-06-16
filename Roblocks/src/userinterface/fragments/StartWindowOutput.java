package userinterface.fragments;

import javafx.scene.Node;
import javafx.scene.control.TextArea;
import userinterface.interfaces.IFragment;
import userinterface.interfaces.ISelectable;
import userinterface.enums.SelectionType;
import userinterface.interfaces.IThemeSwitcher;

/**
 * Create the JSON-output (code) window.
 */

public class StartWindowOutput implements IFragment, ISelectable, IThemeSwitcher {
    public final TextArea uiOutput = new TextArea();

    /**
     * Construct the window.
     */

    public StartWindowOutput()
    {
        uiOutput.setWrapText(true);
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

    /**
     * Switch fragment to dark mode appearance.
     */

    @Override
    public void toDarkMode() {
        uiOutput.setStyle("-fx-text-inner-color: white;");
    }

    /**
     * Switch fragment to light mode appearance.
     */

    @Override
    public void toLightMode() {
        uiOutput.setStyle("-fx-text-inner-color: black;");
    }
}
