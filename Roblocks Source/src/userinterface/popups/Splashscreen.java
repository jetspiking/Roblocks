package userinterface.popups;

import javafx.animation.FadeTransition;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import miscellaneous.constants.Application;
import miscellaneous.utilities.Utils;
import userinterface.interfaces.IFragment;
import userinterface.interfaces.IHideable;
import userinterface.interfaces.ISplashscreen;

public class Splashscreen implements IHideable, IFragment {
    public final ImageView uiIcon = Utils.getImageView(this, Application.IconPaths.ROBLOCKS_SPLASHSCREEN, 500, 300);
    public final ISplashscreen iSplashscreen;

    public Splashscreen(ISplashscreen iSplashscreen) {
        this.iSplashscreen = iSplashscreen;
    }

    @Override
    public void show() {
        FadeTransition fadeIn = new FadeTransition(Duration.seconds(5), uiIcon);
        fadeIn.setFromValue(0);
        fadeIn.setToValue(1);
        fadeIn.setCycleCount(1);

        fadeIn.play();

        fadeIn.setOnFinished((e) -> {
            this.iSplashscreen.loaded();
        });
    }

    @Override
    public void hide() {

    }

    @Override
    public Node getFragment() {
        return uiIcon;
    }
}
