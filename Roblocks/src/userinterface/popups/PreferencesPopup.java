package userinterface.popups;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import miscellaneous.constants.Application;
import userinterface.fragments.DoubleListingFragment;
import userinterface.interfaces.IHideable;

/**
 * Preferences popup-window.
 */

public class PreferencesPopup implements IHideable {

    public final BorderPane uiBorderPane = new BorderPane();
    public final ScrollPane uiScrollPane = new ScrollPane();
    public final Stage uiStage = new Stage();

    public final VBox uiContentStack = new VBox();

    public final DoubleListingFragment<Label, TextField> uiPathsList;
    public final DoubleListingFragment<Label, TextField> uiConnectionList;

    public final TextField uiToolboxConfigPath = new TextField();
    public final TextField uiSavePath = new TextField();

    public final TextField uiIpAddress = new TextField();
    public final TextField uiPort = new TextField();

    /**
     * Constructs the preferences popup-window.
     */

    public PreferencesPopup() {
        uiScrollPane.setContent(uiBorderPane);
        uiBorderPane.setCenter(uiContentStack);

        Scene scene = new Scene(uiBorderPane,500,500);
        uiStage.setTitle(Application.InterfaceStrings.PREFERENCES);
        uiStage.setScene(scene);

        uiPathsList = new DoubleListingFragment<>(Application.InterfaceStrings.PATHS);
        uiConnectionList = new DoubleListingFragment<>(Application.InterfaceStrings.CONNECTION);

        uiPathsList.add(new Label("Toolbox JSON path"), uiToolboxConfigPath);
        uiPathsList.add(new Label("Save JSON path"), uiSavePath);

        uiConnectionList.add(new Label("Upload ip-address"), uiIpAddress);
        uiConnectionList.add(new Label("Upload port"), uiPort);

        uiContentStack.getChildren().addAll(uiPathsList.getFragment(), uiConnectionList.getFragment());
    }

    /**
     * Show the popup window.
     */

    @Override
    public void show() {
        uiStage.show();
    }

    /**
     * Hide the popup window.
     */

    @Override
    public void hide() {
        uiStage.hide();
    }
}
