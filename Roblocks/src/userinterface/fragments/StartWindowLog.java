package userinterface.fragments;

import javafx.scene.Node;
import javafx.scene.control.TextField;
import userinterface.interfaces.IFragment;
import userinterface.interfaces.ISelectable;
import userinterface.enums.SelectionType;
import userinterface.interfaces.IThemeSwitcher;

/**
 * Create the log which displays application information and messages.
 */

public class StartWindowLog implements IFragment, ISelectable, IThemeSwitcher {
    public final TextField uiLog = new TextField();

    /**
     * Construct view.
     */

    public StartWindowLog()
    {
        uiLog.setEditable(false);
        uiLog.setText("Issues, errors and other messages are logged here.");
    }

    /**
     * Set log to boolean visible.
     * @param visible True (show), False (hide).
     */

    public void setLogVisible(boolean visible) {
        uiLog.setVisible(visible);
    }

    /**
     * Get main view fragment.
     * @return uiTextField.
     */

    @Override
    public Node getFragment() {
        return uiLog;
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
        return SelectionType.LOG;
    }


    /**
     * Switch fragment to dark mode appearance.
     */

    @Override
    public void toDarkMode() {
        uiLog.setStyle("-fx-text-inner-color: white;");
    }

    /**
     * Switch fragment to light mode appearance.
     */

    @Override
    public void toLightMode() {
        uiLog.setStyle("-fx-text-inner-color: black;");
    }
}
