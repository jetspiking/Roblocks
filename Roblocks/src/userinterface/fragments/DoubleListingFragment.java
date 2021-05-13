package userinterface.fragments;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import userinterface.interfaces.IFragment;

/**
 * Create a new view with a left and right stack of UI objects.
 * @param <T1> JavaFX Region object for left side.
 * @param <T2> JavaFX Region object for right side.
 */

public class DoubleListingFragment<T1,T2> implements IFragment {
    public final BorderPane uiBorderPane = new BorderPane();
    public final HBox uiObjectsMainStack = new HBox();
    public final VBox uiObjectsLeftStack = new VBox();
    public final VBox uiObjectsRightStack = new VBox();

    /**
     * Construct a DoubleListingFragment view.
     * @param title Title of the view.
     */

    public DoubleListingFragment(String title) {
        Label titleLabel = new Label(title);
        Font defaultFont = Font.getDefault();
        titleLabel.setFont(Font.font("Verdana", FontWeight.BOLD, defaultFont.getSize()));
        uiBorderPane.setTop(titleLabel);
        uiBorderPane.setCenter(uiObjectsMainStack);
        uiObjectsLeftStack.setPrefWidth(200);
        uiObjectsRightStack.setPrefWidth(200);
        uiObjectsMainStack.getChildren().addAll(uiObjectsLeftStack, uiObjectsRightStack);
        uiObjectsLeftStack.setSpacing(0);
        uiObjectsRightStack.setSpacing(0);
    }

    /**
     * Add a listing.
     * @param objectLeft Left in view.
     * @param objectRight Right in view.
     */

    public void add(T1 objectLeft, T2 objectRight) {
        Region left = (Region) objectLeft;
        Region right = (Region) objectRight;
        left.setPrefHeight(30);
        left.setMinHeight(30);
        left.setMaxHeight(30);
        right.setPrefHeight(30);
        right.setMinHeight(30);
        right.setMaxHeight(30);
        uiObjectsLeftStack.getChildren().add(left);
        uiObjectsRightStack.getChildren().add(right);
    }

    /**
     * Set left object stack width.
     * @param width Integer width.
     */

    public void setLeftWidth(int width) {
        uiObjectsLeftStack.getChildren().forEach(objectLeft -> {
            Region left = (Region) objectLeft;
            left.setPrefWidth(width);
            left.setMinWidth(width);
            left.setMaxWidth(width);
        });
    }

    /**
     * Set right object stack width.
     * @param width Integer width.
     */

    public void setRightWidth(int width) {
        uiObjectsRightStack.getChildren().forEach(objectRight -> {
            Region right = (Region) objectRight;
            right.setPrefWidth(width);
            right.setMinWidth(width);
            right.setMaxWidth(width);
        });
    }

    /**
     * Get main view fragment.
     * @return uiBorderPane.
     */

    @Override
    public Node getFragment() {
        return uiBorderPane;
    }
}
