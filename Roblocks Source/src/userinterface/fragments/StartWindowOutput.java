package userinterface.fragments;

import javafx.scene.Node;
import javafx.scene.control.TextArea;
import userinterface.interfaces.IFragment;
import userinterface.interfaces.ISelectable;
import userinterface.enums.SelectionType;

public class StartWindowOutput implements IFragment, ISelectable {
    public final TextArea uiOutput = new TextArea();

    public StartWindowOutput()
    {
        uiOutput.setWrapText(true);
        uiOutput.setStyle("-fx-test-inner-color: black;");
    }

    @Override
    public Node getFragment() {
        return uiOutput;
    }

    @Override
    public void select() {
        //m_output.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
    }

    @Override
    public void deselect() {
        //m_output.setBorder(null);
    }

    @Override
    public SelectionType getType() {
        return SelectionType.OUTPUT;
    }
}
