package userinterface.fragments;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.CheckMenuItem;
import miscellaneous.constants.Application;
import javafx.scene.Node;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import miscellaneous.utilities.Utils;
import userinterface.interfaces.IFragment;
import userinterface.interfaces.IThemeSwitcher;

import static miscellaneous.constants.Application.Containers.TopBar.LOGO_SIZE_INCREASE;
import static miscellaneous.constants.Application.Containers.TopBar.MENU_BUTTON_SIZE;
import static miscellaneous.utilities.Utils.createMenuButton;

/**
 * Generates the application top-bar (menu).
 */

public class StartWindowTopBar implements IFragment, IThemeSwitcher {
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
    public final MenuItem uiViewFlyoutExpandLog = new MenuItem("Expand log");

    public MenuButton uiBuildFlyout;
    public final MenuItem uiBuildFlyoutCompile = new MenuItem("Compile");
    public final MenuItem uiBuildFlyoutExport = new MenuItem("Export");
    public final MenuItem uiBuildFlyoutUpload = new MenuItem("Upload");

    public MenuButton uiAboutFlyout;
    public final MenuItem uiAboutFlyoutSourceCode = new MenuItem("View Source Code");

    public MenuButton uiHelpFlyout;
    public final MenuItem uiHelpFlyoutProtocol = new MenuItem("Roblocks protocol");

    /**
     * Construct the top-bar window.
     */

    public StartWindowTopBar() {
        uiTopBar.setPrefHeight(MENU_BUTTON_SIZE);
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

    /**
     * Set layout.
     */

    private void setLayout()
    {
        uiTopBar.setAlignment(Pos.CENTER_LEFT);
        uiAppFlyout.setFont(Application.Containers.TopBar.MENU_BUTTON_FONT);
        uiFileFlyout.setFont(Application.Containers.TopBar.MENU_BUTTON_FONT);
        uiViewFlyout.setFont(Application.Containers.TopBar.MENU_BUTTON_FONT);
        uiBuildFlyout.setFont(Application.Containers.TopBar.MENU_BUTTON_FONT);
        uiAboutFlyout.setFont(Application.Containers.TopBar.MENU_BUTTON_FONT);
        uiHelpFlyout.setFont(Application.Containers.TopBar.MENU_BUTTON_FONT);
    }

    /**
     * Initialize app menu.
     */

    private void initAppMenu()
    {
        // Main Button
        ImageView menuImage = Utils.getImageView(this, Application.IconPaths.ROBLOCKS_LOGO, MENU_BUTTON_SIZE+15, MENU_BUTTON_SIZE+15);
        uiAppFlyout = createMenuButton(menuImage, "", true); // App
        HBox.setMargin(uiAppFlyout, new Insets(-(LOGO_SIZE_INCREASE/2.),0,-(LOGO_SIZE_INCREASE/2.),0));

        uiAppFlyout.getItems().addAll(uiAppFlyoutPreferences, uiAppFlyoutExit);
    }

    /**
     * Initialize file menu.
     */

    private void initFileMenu()
    {
        // File Button
        ImageView menuImage = Utils.getImageView(this, Application.IconPaths.getThemeImageURL(Application.Icons.FILE),MENU_BUTTON_SIZE, MENU_BUTTON_SIZE);
        uiFileFlyout = createMenuButton(menuImage, "File", true);
        uiFileFlyout.getItems().addAll(uiFileFlyoutOpenProject, uiFileFlyoutSaveProject); // m_fileFlyoutCloseProject
    }

    /**
     * Initialize view menu.
     */

    private void initViewMenu()
    {
        // View Button
        ImageView menuImage = Utils.getImageView(this, Application.IconPaths.getThemeImageURL(Application.Icons.BOOK),MENU_BUTTON_SIZE, MENU_BUTTON_SIZE);
        uiViewFlyout = createMenuButton(menuImage, "View", true);
        uiViewFlyout.getItems().addAll(uiViewFlyoutOutput, uiViewFlyoutBlockSequence, uiViewFlyoutToolbox, uiViewFlyoutLog, uiViewFlyoutExpandLog);
    }

    /**
     * Initialize build menu.
     */

    private void initBuildMenu()
    {
        // Build Button
        ImageView menuImage = Utils.getImageView(this, Application.IconPaths.getThemeImageURL(Application.Icons.CODE),MENU_BUTTON_SIZE, MENU_BUTTON_SIZE);
        uiBuildFlyout = createMenuButton(menuImage, "Build", true);
        uiBuildFlyout.getItems().addAll(uiBuildFlyoutCompile, uiBuildFlyoutUpload); // mBuildFlyoutExport
    }

    /**
     * Initialize about menu.
     */

    private void initAboutMenu()
    {
        // About Button
        ImageView menuImage = Utils.getImageView(this, Application.IconPaths.getThemeImageURL(Application.Icons.GITHUB),MENU_BUTTON_SIZE, MENU_BUTTON_SIZE);
        uiAboutFlyout = createMenuButton(menuImage, "About", true);
        uiAboutFlyout.getItems().addAll(uiAboutFlyoutSourceCode);
    }

    /**
     * Initialize help menu.
     */

    private void initHelpMenu()
    {
        // Help Button
        ImageView menuImage = Utils.getImageView(this, Application.IconPaths.getThemeImageURL(Application.Icons.HELP_CIRCLE),MENU_BUTTON_SIZE, MENU_BUTTON_SIZE);
        uiHelpFlyout = createMenuButton(menuImage, "Help", true);
        uiHelpFlyout.getItems().addAll(uiHelpFlyoutProtocol);
    }

    /**
     * Get main view fragment.
     * @return uiHBox.
     */

    @Override
    public Node getFragment() {
        return this.uiTopBar;
    }

    /**
     * Switch fragment to dark mode appearance.
     */
    @Override
    public void toDarkMode() {
        ImageView menuImageFile = Utils.getImageView(this, Application.IconPaths.getThemeImageURL(Application.Icons.FILE),MENU_BUTTON_SIZE, MENU_BUTTON_SIZE);
        uiFileFlyout.setGraphic(menuImageFile);

        ImageView menuImageView = Utils.getImageView(this, Application.IconPaths.getThemeImageURL(Application.Icons.BOOK),MENU_BUTTON_SIZE, MENU_BUTTON_SIZE);
        uiViewFlyout.setGraphic(menuImageView);

        ImageView menuImageBuild = Utils.getImageView(this, Application.IconPaths.getThemeImageURL(Application.Icons.CODE),MENU_BUTTON_SIZE, MENU_BUTTON_SIZE);
        uiBuildFlyout.setGraphic(menuImageBuild);

        ImageView menuImageAbout = Utils.getImageView(this, Application.IconPaths.getThemeImageURL(Application.Icons.GITHUB),MENU_BUTTON_SIZE, MENU_BUTTON_SIZE);
        uiAboutFlyout.setGraphic(menuImageAbout);

        ImageView menuImageHelp = Utils.getImageView(this, Application.IconPaths.getThemeImageURL(Application.Icons.HELP_CIRCLE),MENU_BUTTON_SIZE, MENU_BUTTON_SIZE);
        uiHelpFlyout.setGraphic(menuImageHelp);
    }

    /**
     * Switch fragment to light mode appearance.
     */
    @Override
    public void toLightMode() {
        ImageView menuImageFile = Utils.getImageView(this, Application.IconPaths.getThemeImageURL(Application.Icons.FILE),MENU_BUTTON_SIZE, MENU_BUTTON_SIZE);
        uiFileFlyout.setGraphic(menuImageFile);

        ImageView menuImageView = Utils.getImageView(this, Application.IconPaths.getThemeImageURL(Application.Icons.BOOK),MENU_BUTTON_SIZE, MENU_BUTTON_SIZE);
        uiViewFlyout.setGraphic(menuImageView);

        ImageView menuImageBuild = Utils.getImageView(this, Application.IconPaths.getThemeImageURL(Application.Icons.CODE),MENU_BUTTON_SIZE, MENU_BUTTON_SIZE);
        uiBuildFlyout.setGraphic(menuImageBuild);

        ImageView menuImageAbout = Utils.getImageView(this, Application.IconPaths.getThemeImageURL(Application.Icons.GITHUB),MENU_BUTTON_SIZE, MENU_BUTTON_SIZE);
        uiAboutFlyout.setGraphic(menuImageAbout);

        ImageView menuImageHelp = Utils.getImageView(this, Application.IconPaths.getThemeImageURL(Application.Icons.HELP_CIRCLE),MENU_BUTTON_SIZE, MENU_BUTTON_SIZE);
        uiHelpFlyout.setGraphic(menuImageHelp);
    }
}
