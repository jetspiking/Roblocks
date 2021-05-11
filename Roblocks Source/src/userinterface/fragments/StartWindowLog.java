package userinterface.fragments;

import javafx.scene.Node;
import javafx.scene.control.TextField;
import userinterface.interfaces.IFragment;
import userinterface.interfaces.ISelectable;
import userinterface.enums.SelectionType;

public class StartWindowLog implements IFragment, ISelectable {
    public final TextField uiLog = new TextField();

    public StartWindowLog()
    {
        uiLog.setEditable(false);
        uiLog.setText("Issues, errors and other messages are logged here.");
    }

    public void setLogVisible(boolean visible) {
        uiLog.setVisible(visible);
    }

    @Override
    public Node getFragment() {
        return uiLog;
    }

    @Override
    public void select() {

    }

    @Override
    public void deselect() {

    }

    @Override
    public SelectionType getType() {
        return SelectionType.LOG;
    }
}
