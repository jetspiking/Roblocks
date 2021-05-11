package main;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import userinterface.interfaces.ISplashscreen;
import userinterface.popups.Splashscreen;
import userinterface.views.StartWindow;

public class Main extends Application {

    public static Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        stage = primaryStage;
        Stage splashScreenStage = new Stage();

        Splashscreen splashscreen = new Splashscreen(new ISplashscreen() {
            @Override
            public void loaded() {
                primaryStage.setTitle(miscellaneous.constants.Application.Strings.APPLICATION_TITLE);
                primaryStage.setScene(new Scene(new StartWindow().GetView(), 800, 600));
                primaryStage.show();
                splashScreenStage.close();
            }
        });

        splashScreenStage.setScene(new Scene(new Group(splashscreen.getFragment())));
        splashScreenStage.setWidth(500);
        splashScreenStage.setHeight(300);
        splashScreenStage.initStyle(StageStyle.UNDECORATED);
        splashScreenStage.centerOnScreen();
        splashScreenStage.show();

        splashscreen.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
