package userinterface.interfaces;

/**
 * Switch to a different theme mode for the application layout.
 */

public interface IThemeSwitcher {

    /**
     * Switch fragment to dark mode appearance.
     */
    void toDarkMode();

    /**
     * Switch fragment to light mode appearance.
     */
    void toLightMode();
}
