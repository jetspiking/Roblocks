package userinterface.jfxcustom;

import javafx.animation.FillTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;


public class JFXToggleBtn {
    private static final double ANIMATIONTIME = .25;
    private static final Color BUTTONCOLOR = Color.WHITE;
    private static final Color BUTTONBACKGROUND = Color.DARKGRAY;
    private static final Color ONCOLOR = Color.GREEN;
    private static final Color OFFCOLOR = Color.TRANSPARENT;
    private ToggleSwitch toggleSwitch;

    public JFXToggleBtn(int height, boolean isOn) {
        toggleSwitch=new ToggleSwitch(height, isOn);
    }

    public Region getSwitch() {
        return toggleSwitch;
    }

    public BooleanProperty getIsOn() { return toggleSwitch.isOn(); }

    public static class ToggleSwitch extends Region {
        private BooleanProperty isOn = new SimpleBooleanProperty(false);
        private TranslateTransition translateAnimation = new TranslateTransition(Duration.seconds(ANIMATIONTIME));
        private FillTransition fillTransition = new FillTransition(Duration.seconds(ANIMATIONTIME));
        private ParallelTransition parallelTransition = new ParallelTransition(translateAnimation, fillTransition);

        public BooleanProperty isOn() {
            return isOn;
        }

        public ToggleSwitch(int height, boolean isOn) {
            this.isOn.setValue(isOn);
            Rectangle background = new Rectangle(height*2,height);
            background.setStroke(BUTTONBACKGROUND);
            background.setArcWidth(height);
            background.setArcHeight(height);
            background.setFill(OFFCOLOR);

            Circle circleSwitch = new Circle(height/2.);
            circleSwitch.setCenterX(height/2.);
            circleSwitch.setCenterY(height/2.);
            circleSwitch.setFill(BUTTONCOLOR);
            circleSwitch.setStroke(BUTTONBACKGROUND);

            translateAnimation.setNode(circleSwitch);
            fillTransition.setShape(background);

            getChildren().addAll(new Pane(background, circleSwitch));

            if (isOn) {
                translateAnimation.setToX(height);
                fillTransition.setFromValue(OFFCOLOR);
                fillTransition.setToValue(ONCOLOR);
                parallelTransition.playFrom(Duration.seconds(ANIMATIONTIME));
            }

            this.isOn.addListener((observable, oldValue, newValue) -> {
                translateAnimation.setToX(newValue ? height : 0);
                fillTransition.setFromValue(newValue ? OFFCOLOR : ONCOLOR);
                fillTransition.setToValue(newValue ? ONCOLOR : OFFCOLOR);
                parallelTransition.playFromStart();
            });

            background.setOnMouseClicked(onClick -> {
                this.isOn.set(!this.isOn.get());
            });
            circleSwitch.setOnMouseClicked(onClick -> {
                this.isOn.set(!this.isOn.get());
            });
        }
    }
}
