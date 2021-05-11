package userinterface.fragments;

import javafx.scene.control.CheckMenuItem;
import miscellaneous.constants.Application;
import javafx.scene.Node;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import miscellaneous.utilities.Utils;
import userinterface.interfaces.IFragment;

public class StartWindowTopBar implements IFragment {
    private final HBox uiTopBar = new HBox();

    public MenuButton uiAppFlyout;
    public final MenuItem uiAppFlyoutPreferences = new MenuItem("Preferences");
    public final MenuItem uiAppFlyoutExit = new MenuItem("Exit");

    public MenuButton uiFileFlyout;
    public final MenuItem uiFileFlyoutOpenProject = new MenuItem("Open Project");
    public final MenuItem uiFileFlyoutSaveProject = new MenuItem("Save Project");
    public final MenuItem uiFileFlyoutCloseProject = new MenuItem("Close Project");

    public MenuButton uiViewFlyout;
    public final CheckMenuItem uiViewFlyoutOutput = new CheckMenuItem("Output (left)");
    public final CheckMenuItem uiViewFlyoutBlockSequence = new CheckMenuItem("Block Sequence (center)");
    public final CheckMenuItem uiViewFlyoutToolbox = new CheckMenuItem("Toolbox (right)");
    public final CheckMenuItem uiViewFlyoutLog = new CheckMenuItem("Log (bottom)");

    public MenuButton uiBuildFlyout;
    public final MenuItem uiBuildFlyoutCompile = new MenuItem("Compile");
    public final MenuItem uiBuildFlyoutExport = new MenuItem("Export");
    public final MenuItem uiBuildFlyoutUpload = new MenuItem("Upload");

    public MenuButton uiAboutFlyout;
    public final MenuItem uiAboutFlyoutSourceCode = new MenuItem("View Source Code");

    public MenuButton uiHelpFlyout;
    public final MenuItem uiHelpFlyoutProtocol = new MenuItem("Roblocks protocol");

    public StartWindowTopBar() {
        uiTopBar.setPrefHeight(Application.Containers.TopBar.MENU_BUTTON_SIZE);
        uiTopBar.setSpacing(15);

        initAppMenu();
        initFileMenu();
        initViewMenu();
        initBuildMenu();
        initAboutMenu();
        initHelpMenu();
        setLayout();

        uiTopBar.getChildren().addAll(uiAppFlyout, uiFileFlyout, uiViewFlyout, uiBuildFlyout, uiAboutFlyout, uiHelpFlyout);
    }

    private void setLayout()
    {
        uiAppFlyout.setFont(Application.Containers.TopBar.MENU_BUTTON_FONT);
        uiFileFlyout.setFont(Application.Containers.TopBar.MENU_BUTTON_FONT);
        uiViewFlyout.setFont(Application.Containers.TopBar.MENU_BUTTON_FONT);
        uiBuildFlyout.setFont(Application.Containers.TopBar.MENU_BUTTON_FONT);
        uiAboutFlyout.setFont(Application.Containers.TopBar.MENU_BUTTON_FONT);
        uiHelpFlyout.setFont(Application.Containers.TopBar.MENU_BUTTON_FONT);
    }

    private void initAppMenu()
    {
        // Main Button
        ImageView menuImage = Utils.getImageView(this, Application.IconPaths.ROBLOCKS_LOGO, 20, 20);
        uiAppFlyout = createMenuButton(menuImage, ""); // App

        uiAppFlyout.getItems().addAll(uiAppFlyoutPreferences, uiAppFlyoutExit);
    }

    private void initFileMenu()
    {
        // File Button
        ImageView menuImage = Utils.getImageView(this, Application.IconPaths.FILE,20, 20);
        uiFileFlyout = createMenuButton(menuImage, "File");

        uiFileFlyout.getItems().addAll(uiFileFlyoutOpenProject, uiFileFlyoutSaveProject); // m_fileFlyoutCloseProject
    }

    private void initViewMenu()
    {
        // View Button
        ImageView menuImage = Utils.getImageView(this, Application.IconPaths.BOOK,20, 20);
        uiViewFlyout = createMenuButton(menuImage, "View");

        uiViewFlyout.getItems().addAll(uiViewFlyoutOutput, uiViewFlyoutBlockSequence, uiViewFlyoutToolbox, uiViewFlyoutLog);
    }

    private void initBuildMenu()
    {
        // Build Button
        ImageView menuImage = Utils.getImageView(this, Application.IconPaths.CODE,20, 20);
        uiBuildFlyout = createMenuButton(menuImage, "Build");

        uiBuildFlyout.getItems().addAll(uiBuildFlyoutCompile, uiBuildFlyoutUpload); // mBuildFlyoutExport
    }

    private void initAboutMenu()
    {
        // About Button
        ImageView menuImage = Utils.getImageView(this, Application.IconPaths.GITHUB,20, 20);
        uiAboutFlyout = createMenuButton(menuImage, "About");

        uiAboutFlyout.getItems().addAll(uiAboutFlyoutSourceCode);
    }

    private void initHelpMenu()
    {
        // Help Button
        ImageView menuImage = Utils.getImageView(this, Application.IconPaths.HELP_CIRCLE,20, 20);
        uiHelpFlyout = createMenuButton(menuImage, "Help");

        uiHelpFlyout.getItems().addAll(uiHelpFlyoutProtocol);
    }

    private MenuButton createMenuButton(ImageView imageView, String text)
    {
        MenuButton menuButton = new MenuButton();
        menuButton.setBackground(null);
        if (text!=null)
            menuButton.setText(text);
        if (imageView!=null)
            menuButton.setGraphic(imageView);
        return menuButton;
    }

    @Override
    public Node getFragment() {
        return this.uiTopBar;
    }
}
