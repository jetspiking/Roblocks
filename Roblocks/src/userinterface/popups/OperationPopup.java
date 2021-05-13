package userinterface.popups;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import userinterface.fragments.DoubleListingFragment;
import userinterface.fragments.OperationFragment;
import userinterface.interfaces.IHideable;

/**
 * Popup to edit Operation.
 */

public class OperationPopup implements IHideable {
    public final BorderPane uiBorderPane = new BorderPane();
    public final ScrollPane uiScrollPane = new ScrollPane();
    public final VBox uiContentStack = new VBox();
    public final OperationFragment operationFragment;

    public final DoubleListingFragment<Label,Label> uiInfoList;
    public final DoubleListingFragment<Label,TextField> uiAttributeList;
    public final DoubleListingFragment<Label,Label> uiTagList;

    public final Stage uiOperationStage = new Stage();

    /**
     * Construct Operation Popup view.
     * @param operationFragment OperationFragment to display.
     */

    public OperationPopup(OperationFragment operationFragment) {
        this.operationFragment = operationFragment;

        Scene scene = new Scene(uiBorderPane,500,500);
        uiOperationStage.setTitle(operationFragment.toolboxFragment.uiToolboxItem.getName());
        uiOperationStage.setScene(scene);

        uiBorderPane.setCenter(uiScrollPane);
        uiScrollPane.setContent(uiContentStack);

        uiInfoList = new DoubleListingFragment<Label,Label>("Info");
        uiContentStack.getChildren().add(uiInfoList.getFragment());

        uiAttributeList = new DoubleListingFragment<Label, TextField>("Attributes");
        uiContentStack.getChildren().add(uiAttributeList.getFragment());

        uiTagList = new DoubleListingFragment<Label,Label>("Tags");
        uiContentStack.getChildren().add(uiTagList.getFragment());

        BorderPane.setMargin(uiScrollPane, new Insets(10,10,10,10));
        uiContentStack.setSpacing(10);

        build();
    }

    /**
     * Helper method to build the view and keep constructor more clear.
     */

    private void build() {
        uiInfoList.add(new Label("Name"), new Label(operationFragment.toolboxFragment.uiToolboxItem.getName()));
        uiInfoList.add(new Label("Description"), new Label(operationFragment.toolboxFragment.uiToolboxItem.getDescription()));
        uiInfoList.add(new Label("Image name"), new Label(operationFragment.toolboxFragment.uiToolboxItem.getImageName()));

        int i = 0;
        for(String attribute : operationFragment.toolboxFragment.uiToolboxItem.getAttributes()) {
            TextField textField = new TextField();
            textField.setText(operationFragment.attributeValues.get(i++));
            uiAttributeList.add(new Label(attribute),textField);
        }
        for(String tag: operationFragment.toolboxFragment.uiToolboxItem.getTags()) {
            uiTagList.add(new Label(tag), new Label(""));
        }
    }

    /**
     * Show the popup window.
     */

    @Override
    public void show() {
        uiOperationStage.show();
    }

    /**
     * Hide the popup window.
     */

    @Override
    public void hide() {
        uiOperationStage.hide();
    }


}
