/*
Copyright 2021 Dustin Hendriks
https://github.com/jetspiking

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction,
including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software,
and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */


package main;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import userinterface.interfaces.ISplashscreen;
import userinterface.popups.Splashscreen;
import userinterface.views.StartWindow;

import static miscellaneous.constants.Application.Stages.SplashScreen.SPLASHSCREEN_HEIGHT;
import static miscellaneous.constants.Application.Stages.SplashScreen.SPLASHSCREEN_WIDTH;

public class Main extends Application {

    public static Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        stage = primaryStage;                                                                           // This is the primary stage which will contain the Roblocks-application-view.
        Stage splashScreenStage = new Stage();                                                          // This is the secondary stage which will display a splashscreen for a short period.

        Splashscreen splashscreen = new Splashscreen(new ISplashscreen() {                              // Create splashscreen, close on animation finished and set primary stage to visible again.
            @Override
            public void loaded() {
                splashScreenStage.close();                                                              // After timeout-period close splashscreen.
                primaryStage.setTitle(miscellaneous.constants.Application.Strings.APPLICATION_TITLE);   // Set title to application name (Roblocks).
                StartWindow startWindow = new StartWindow();                                            // Create startWindow while displaying splash screen.
                Scene scene = new Scene(startWindow.getView(), 800, 600);                  // Create scene.
                scene.getStylesheets().add("/miscellaneous/css/styles.css");                            // Bind css.
                primaryStage.setScene(scene);                                                           // Set view and default application width and height.
                primaryStage.show();                                                                    // Show view.
            }
        });

        splashScreenStage.setScene(new Scene(new Group(splashscreen.getFragment())));                   // Set scene for splashscreen.
        splashScreenStage.setWidth(SPLASHSCREEN_WIDTH);                                                 // Default splashscreen width.
        splashScreenStage.setHeight(SPLASHSCREEN_HEIGHT);                                               // Default splashscreen height.
        splashScreenStage.initStyle(StageStyle.UNDECORATED);                                            // Hide GUI frame of Operating System.
        splashScreenStage.centerOnScreen();                                                             // Center splashscreen on screen.
        splashScreenStage.show();                                                                       // Show splashscreen.
        splashscreen.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
