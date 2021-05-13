package userinterface.popups;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import userinterface.interfaces.IHideable;

/**
 * Popup browser window.
 */

public class PopupBrowser implements IHideable {
    private final BorderPane uiBorderPane = new BorderPane();
    private final WebView uiWebView = new WebView();
    private final WebEngine uiWebEngine = uiWebView.getEngine();
    private final Stage uiWebViewStage = new Stage();

    /**
     * Constructs the popup browser.
     * @param title Window title.
     * @param url URL to navigate to.
     */

    public PopupBrowser(String title, String url) {
        uiBorderPane.setCenter(uiWebView);
        uiWebEngine.load(url);
        Scene scene = new Scene(uiBorderPane,500,500);
        uiWebViewStage.setTitle(title);
        uiWebViewStage.setScene(scene);
    }

    /**
     * Show the popup window.
     */

    @Override
    public void show() {
        uiWebViewStage.show();
    }

    /**
     * Hide the popup window.
     */

    @Override
    public void hide() {
        uiWebViewStage.hide();
    }
}
