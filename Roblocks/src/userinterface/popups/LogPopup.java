package userinterface.popups;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import miscellaneous.utilities.LogKeeper;
import userinterface.fragments.DoubleListingFragment;
import userinterface.interfaces.IHideable;

/**
 *  Popup that displays all log messages.
 */

public class LogPopup implements IHideable {

    public final BorderPane uiBorderPane = new BorderPane();
    public final Stage uiLogStage = new Stage();
    public final ScrollPane uiScrollPane = new ScrollPane();
    public final VBox uiContentStack = new VBox();
    public final DoubleListingFragment<Label, TextField> logs = new DoubleListingFragment<Label,TextField>("Logs");
    public final LogKeeper logKeeper;

    /**
     * Constructs the log popup view.
     * @param logKeeper LogKeeper messages.
     */

    public LogPopup(LogKeeper logKeeper) {
        Scene scene = new Scene(uiBorderPane,500,500);
        uiLogStage.setTitle("Logs");
        uiLogStage.setScene(scene);

        uiBorderPane.setCenter(uiScrollPane);
        uiScrollPane.setContent(uiContentStack);

        uiContentStack.getChildren().add(logs.getFragment());

        this.logKeeper = logKeeper;

        this.logKeeper.get().forEach(logMessage -> {
            TextField textField = new TextField(logMessage.message);
            textField.setEditable(false);
            logs.add(new Label(logMessage.logMessageType.toString()), textField);
        });
    }

    /**
     * Show the popup window.
     */

    @Override
    public void show() {
        uiLogStage.show();
    }

    /**
     * Hide the popup window.
     */

    @Override
    public void hide() {
        uiLogStage.close();
    }
}
