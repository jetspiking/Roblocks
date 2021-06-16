package miscellaneous.constants;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import miscellaneous.models.LogMessage;

import javax.swing.*;

/**
This file defines application strings, constants and other data.
The purpose of this file is to prevent hardcoded strings and values in all other files of this application.
*/

public class Application {

    public static class State {
        public static boolean isDarkTheme = false;
    }

    /**
     * Contains application UI strings.
     */

    public static final class Strings
    {
        public static final String APPLICATION_TITLE = "R O B L O C K S";
        public static final String JSON_COMPONENTS = "components";
        public static final String JSON_NAME = "name";
        public static final String JSON_OPERATIONS = "operations";
        public static final String JSON_ATTRIBUTES = "attributes";
        public static final String JSON_IMAGE = "image";
        public static final String JSON_TAGS = "tags";
        public static final String JSON_DESCRIPTION = "description";
    }

    /**
     * Contains data for stages.
     */

    public static final class Stages
    {
        public static final class SplashScreen
        {
            public static final int SPLASHSCREEN_WIDTH = 1200;
            public static final int SPLASHSCREEN_HEIGHT = 600;
        }
    }

    /**
     * Contains data (sizes) for containers.
     */

    public static final class Containers
    {
        public static final class TopBar
        {
            public static final int MENU_BUTTON_SIZE = 25;
            public static final int LOGO_SIZE_INCREASE = 10;
            public static final Font MENU_BUTTON_FONT = Font.font("sans-serif", FontWeight.BOLD, 13);
        }

        public static final class VisualEdit
        {
            public static final int IMAGEVIEW_SIZE = 40;
        }
    }

    /**
     * Colors used in the application
     */

    public static final class Colors {
        public static final Color DARK_MODE_COLOR = new Color(.2,.2,.2,1.);
        public static final Color LIGHT_MODE_COLOR = Color.WHITE;
    }

    /**
     * Contains resources-paths.
     */

    public static final class Paths
    {
        public static final String APPICONS_PATH = "/appicons/";

        public static String ICONS_PATH(String icon) {
            return "/feathericons/"+(State.isDarkTheme?"light":"dark")+"/"+icon;
        }
    }

    /**
     * Contains Urls, currently only the GitHub page of the software.
     */

    public static final class URLs {
        public static final String GITHUB = "https://github.com/jetspiking/Roblocks";
        public static final String GITHUB_PROTOCOL_HELP = "https://htmlpreview.github.io/?https://github.com/jetspiking/Roblocks/blob/main/Documentation/Protocol/RoblocksHelp.html";
    }

    /**
     * Contains paths to files.
     */

    public static final class FilesPaths
    {
        public static final String ROBLOCKS_FOLDER = new JFileChooser().getFileSystemView().getDefaultDirectory().toString()+"/RoblocksData"; // FileSystemView.getFileSystemView().getDefaultDirectory().getPath()+"/Roblocks"; // "/Users/dustin/Desktop/RoblocksConfig/ToolboxConfiguration.json"
        public static final String DEFAULT_TOOLBOX_PATH = ROBLOCKS_FOLDER+"/ToolboxConfiguration.json";
        public static final String DEFAULT_SAVE_PATH = ROBLOCKS_FOLDER+"/ProgramExport.json";
    }

    /**
     * Contains pre-programmed LogMessages.
     */

    public static final class Messages
    {
        public static final LogMessage ERROR_CONFIGURATION_READ = new LogMessage("Can not read toolbox configuration on specified location.", LogMessage.LogMessageType.ERROR);
        public static final LogMessage SUCCESS_CONFIGURATION_READ = new LogMessage("Read configuration file and filled toolbox.", LogMessage.LogMessageType.VERBOSE);
    }

    /**
     * UI-strings.
     */

    public static final class InterfaceStrings
    {
        public static final String VISUAL_EDIT_FRAGMENT_DEFAULT_TITLE = "Node";
        public static final String PREFERENCES = "Preferences";
        public static final String CONNECTION = "Connection";
        public static final String PATHS = "Paths";
        public static final String INTERFACES = "Interfaces";
    }

    /**
     * Get the URL of the desired icon.
     */

    public static final class IconPaths
    {
        public static final String ROBLOCKS_LOGO = Paths.APPICONS_PATH+"roblocks.png";
        public static final String ROBLOCKS_SPLASHSCREEN = Paths.APPICONS_PATH+"splashscreen.png";

        public static String getThemeImageURL(String image) {
            return Paths.ICONS_PATH(image);
        }
    }


    /**
     * All Icons.
     */

    public static final class Icons // Was IconPaths
    {
        public static final String ACTIVITY = "activity.png";
        public static final String AIRPLAY = "airplay.png";
        public static final String ALERT_CIRCLE = "alert-circle.png";
        public static final String ALERT_OCTAGON = "alert-octagon.png";
        public static final String ALERT_TRIANGLE = "alert-triangle.png";
        public static final String ALIGN_CENTER = "align-center.png";
        public static final String ALIGN_JUSTIFY = "align-justify.png";
        public static final String ALIGN_LEFT = "align-left.png";
        public static final String ALIGN_RIGHT = "align-right.png";
        public static final String ANCHOR = "anchor.png";
        public static final String APERTURE = "aperture.png";
        public static final String ARCHIVE = "archive.png";
        public static final String ARROW_DOWN = "arrow-down.png";
        public static final String ARROW_DOWN_CIRCLE = "arrow-down-circle.png";
        public static final String ARROW_DOWN_LEFT = "arrow-down-left.png";
        public static final String ARROW_DOWN_RIGHT = "arrow-down-right.png";
        public static final String ARROW_LEFT = "arrow-left.png";
        public static final String ARROW_LEFT_CIRCLE = "arrow-left-circle.png";
        public static final String ARROW_RIGHT = "arrow-right.png";
        public static final String ARROW_RIGHT_CIRCLE = "arrow-right-circle.png";
        public static final String ARROW_UP = "arrow-up.png";
        public static final String ARROW_UP_CIRCLE = "arrow-up-circle.png";
        public static final String ARROW_UP_LEFT = "arrow-up-left.png";
        public static final String ARROW_UP_RIGHT = "arrow-up-right.png";
        public static final String AT_SIGN = "at-sign.png";
        public static final String AWARD = "award.png";
        public static final String BAR_CHART = "bar-chart.png";
        public static final String BAR_CHART_2 = "bar-chart-2.png";
        public static final String BATTERY = "battery.png";
        public static final String BATTERY_CHARGING = "battery-charging.png";
        public static final String BELL = "bell.png";
        public static final String BELL_OFF = "bell-off.png";
        public static final String BLUETOOTH = "bluetooth.png";
        public static final String BOLD = "bold.png";
        public static final String BOOK = "book.png";
        public static final String BOOK_OPEN = "book-open.png";
        public static final String BOOKMARK = "bookmark.png";
        public static final String BOX = "box.png";
        public static final String BRIEFCASE = "briefcase.png";
        public static final String CALENDAR = "calendar.png";
        public static final String CAMERA = "camera.png";
        public static final String CAMERA_OFF = "camera-off.png";
        public static final String CAST = "cast.png";
        public static final String CHECK = "check.png";
        public static final String CHECK_CIRCLE = "check-circle.png";
        public static final String CHECK_SQUARE = "check-square.png";
        public static final String CHEVRON_DOWN = "chevron-down.png";
        public static final String CHEVRON_LEFT = "chevron-left.png";
        public static final String CHEVRON_RIGHT = "chevron-right.png";
        public static final String CHEVRON_UP = "chevron-up.png";
        public static final String CHEVRONS_DOWN = "chevrons-down.png";
        public static final String CHEVRONS_LEFT = "chevrons-left.png";
        public static final String CHEVRONS_RIGHT = "chevrons-right.png";
        public static final String CHEVRONS_UP = "chevrons-up.png";
        public static final String CHROME = "chrome.png";
        public static final String CIRCLE = "circle.png";
        public static final String CLIPBOARD = "clipboard.png";
        public static final String CLOCK = "clock.png";
        public static final String CLOUD = "cloud.png";
        public static final String CLOUD_DRIZZLE = "cloud-drizzle.png";
        public static final String CLOUD_LIGHTNING = "cloud-lightning.png";
        public static final String CLOUD_OFF = "cloud-off.png";
        public static final String CLOUD_RAIN = "cloud-rain.png";
        public static final String CLOUD_SNOW = "cloud-snow.png";
        public static final String CODE = "code.png";
        public static final String CODEPEN = "codepen.png";
        public static final String CODE_SANDBOX = "codesandbox.png";
        public static final String COFFEE = "coffee.png";
        public static final String COLUMNS = "columns.png";
        public static final String COMMAND = "command.png";
        public static final String COMPASS = "compass.png";
        public static final String COPY = "copy.png";
        public static final String CORNER_DOWN_LEFT = "corner-down-left.png";
        public static final String CORNER_DOWN_RIGHT = "corner-down-right.png";
        public static final String CORNER_LEFT_DOWN = "corner-left-down.png";
        public static final String CORNER_LEFT_UP = "corner-left-up.png";
        public static final String CORNER_RIGHT_DOWN = "corner-right-down.png";
        public static final String CORNER_RIGHT_UP = "corner-right-up.png";
        public static final String CORNER_UP_LEFT = "corner-up-left.png";
        public static final String CORNER_UP_RIGHT = "corner-up-right.png";
        public static final String CPU = "cpu.png";
        public static final String CREDIT_CARD = "credit-card.png";
        public static final String CROP = "crop.png";
        public static final String CROSSHAIR = "crosshair.png";
        public static final String DATABASE = "database.png";
        public static final String DELETE = "delete.png";
        public static final String DISC = "disc.png";
        public static final String DIVIDE = "divide.png";
        public static final String DIVIDE_CIRCLE = "divide-circle.png";
        public static final String DIVIDE_SQUARE = "divide-square.png";
        public static final String DOLLAR_SIGN = "dollar-sign.png";
        public static final String DOWNLOAD = "download.png";
        public static final String DOWNLOAD_CLOUD = "download-cloud.png";
        public static final String DRIBBBLE = "dribbble.png";
        public static final String DROPLET = "droplet.png";
        public static final String EDIT = "edit.png";
        public static final String EDIT_2 = "edit-2.png";
        public static final String EDIT_3 = "edit-3.png";
        public static final String EXTERNAL_LINK = "external-link.png";
        public static final String EYE = "eye.png";
        public static final String EYE_OFF = "eye-off.png";
        public static final String FACEBOOK = "facebook.png";
        public static final String FAST_FORWARD = "fast-forward.png";
        public static final String FEATHER = "feather.png";
        public static final String FIGMA = "figma.png";
        public static final String FILE = "file.png";
        public static final String FILE_MINUS = "file-minus.png";
        public static final String FILE_PLUS = "file-plus.png";
        public static final String FILE_TEXT = "file-text.png";
        public static final String FILM = "film.png";
        public static final String FILTER = "filter.png";
        public static final String FLAG = "flag.png";
        public static final String FOLDER = "folder.png";
        public static final String FOLDER_MINUS = "folder-minus.png";
        public static final String FOLDER_PLUS = "folder-plus.png";
        public static final String FRAMER = "framer.png";
        public static final String FROWN = "frown.png";
        public static final String GIFT = "gift.png";
        public static final String GIT_BRANCH = "git-branch.png";
        public static final String GIT_COMMIT = "git-commit.png";
        public static final String GIT_MERGE = "git-merge.png";
        public static final String GIT_PULL_REQUEST = "git-pull-request.png";
        public static final String GITHUB = "github.png";
        public static final String GITLAB = "gitlab.png";
        public static final String GLOBE = "globe.png";
        public static final String GRID = "grid.png";
        public static final String HARDDRIVE = "harddrive.png";
        public static final String HASH = "hash.png";
        public static final String HEADPHONES = "headphones.png";
        public static final String HEART = "heart.png";
        public static final String HELP_CIRCLE = "help-circle.png";
        public static final String HEXAGON = "hexagon.png";
        public static final String HOME = "home.png";
        public static final String IMAGE = "image.png";
        public static final String INBOX = "inbox.png";
        public static final String INFO = "info.png";
        public static final String INSTAGRAM = "instagram.png";
        public static final String ITALIC = "italic.png";
        public static final String KEY = "key.png";
        public static final String LAYERS = "layers.png";
        public static final String LAYOUT = "layout.png";
        public static final String LIFE_BUOY = "life-buoy.png";
        public static final String LINK = "link.png";
        public static final String LINK_2 = "link-2.png";
        public static final String LINKEDIN = "linkedin.png";
        public static final String LIST = "list.png";
        public static final String LOADER = "loader.png";
        public static final String LOCK = "lock.png";
        public static final String LOG_IN = "log-in.png";
        public static final String LOG_OUT = "log-out.png";
        public static final String MAIL = "mail.png";
        public static final String MAP = "map.png";
        public static final String MAP_PIN = "map-pin.png";
        public static final String MAXIMALIZE = "maximalize.png";
        public static final String MAXIMALIZE_2 = "maximalize-2.png";
        public static final String MEH = "meh.png";
        public static final String MENU = "menu.png";
        public static final String MESSAGE_CIRCLE = "message-circle.png";
        public static final String MESSAGE_SQUARE = "message-square.png";
        public static final String MIC = "mic.png";
        public static final String MIC_OFF = "mic-off.png";
        public static final String MINIMIZE = "minimize.png";
        public static final String MINIMIZE_2 = "minimize-2.png";
        public static final String MINUS = "minus.png";
        public static final String MINUS_CIRCLE = "minus-circle.png";
        public static final String MINUS_SQUARE = "minus-square.png";
        public static final String MONITOR = "monitor.png";
        public static final String MOON = "moon.png";
        public static final String MORE_HORIZONTAL = "more-horizontal.png";
        public static final String MORE_VERTICAL = "more-vertical.png";
        public static final String MOUSE_POINTER = "mouse-pointer.png";
        public static final String MOVE = "move.png";
        public static final String MUSIC = "music.png";
        public static final String NAVIGATION = "navigation.png";
        public static final String NAVIGATION_2 = "navigation-2.png";
        public static final String OCTAGON = "octagon.png";
        public static final String PACKAGE = "package.png";
        public static final String PAPERCLIP = "paperclip.png";
        public static final String PAUSE = "pause.png";
        public static final String PAUSE_CIRCLE = "pause-circle.png";
        public static final String PEN_TOOL = "pen-tool.png";
        public static final String PERCENT = "percent.png";
        public static final String PHONE = "phone.png";
        public static final String PHONE_CALL = "phone-call.png";
        public static final String PHONE_FORWARDED = "phone-forwarded.png";
        public static final String PHONE_INCOMING = "phone-incoming.png";
        public static final String PHONE_MISSED = "phone-missed.png";
        public static final String PHONE_OFF = "phone-off.png";
        public static final String PHONE_OUTGOING = "phone-outgoing.png";
        public static final String PIE_CHART = "pie-chart.png";
        public static final String PLAY = "play.png";
        public static final String PLAY_CIRCLE = "play-circle.png";
        public static final String PLUS = "plus.png";
        public static final String PLUS_CIRCLE = "plus-circle.png";
        public static final String PLUS_SQUARE = "plus-square.png";
        public static final String POCKET = "pocket.png";
        public static final String POWER = "power.png";
        public static final String PRINTER = "printer.png";
        public static final String RADIO = "radio.png";
        public static final String REFRESH_CCW = "refresh-ccw.png";
        public static final String REFRESH_CW = "refresh-cw.png";
        public static final String REPEAT = "repeat.png";
        public static final String REWIND = "rewind.png";
        public static final String ROTATE_CCW = "rotate-ccw.png";
        public static final String ROTATE_CW = "rotate-cw.png";
        public static final String RSS = "rss.png";
        public static final String SAVE = "save.png";
        public static final String SCISSORS = "scissors.png";
        public static final String SEARCH = "search.png";
        public static final String SEND = "send.png";
        public static final String SERVER = "server.png";
        public static final String SETTINGS = "settings.png";
        public static final String SHARE = "share.png";
        public static final String SHARE_2 = "share-2.png";
        public static final String SHIELD = "shield.png";
        public static final String SHIELD_OFF = "shield-off.png";
        public static final String SHOPPING_BAG = "shopping-bag.png";
        public static final String SHOPPING_CART = "shopping-cart.png";
        public static final String SHUFFLE = "shuffle.png";
        public static final String SIDEBAR = "sidebar.png";
        public static final String SKIP_BACK = "skip-back.png";
        public static final String SKIP_FORWARD = "skip-forward.png";
        public static final String SLACK = "slack.png";
        public static final String SLASH = "slash.png";
        public static final String SLIDERS = "sliders.png";
        public static final String SMARTPHONE = "smartphone.png";
        public static final String SMILE = "smile.png";
        public static final String SPEAKER = "speaker.png";
        public static final String SQUARE = "square.png";
        public static final String STAR = "star.png";
        public static final String STOP_CIRCLE = "stop-circle.png";
        public static final String SUN = "sun.png";
        public static final String SUNRISE = "sunrise.png";
        public static final String SUNSET = "sunset.png";
        public static final String TABLET = "tablet.png";
        public static final String TAG = "tag.png";
        public static final String TARGET = "target.png";
        public static final String TERMINAL = "terminal.png";
        public static final String THERMOMETER = "thermometer.png";
        public static final String THUMBS_DOWN = "thumbs-down.png";
        public static final String THUMBS_UP = "thumbs-up.png";
        public static final String TOGGLE_LEFT = "toggle-left.png";
        public static final String TOGGLE_RIGHT = "toggle-right.png";
        public static final String TOOL = "tool.png";
        public static final String TRASH = "trash.png";
        public static final String TRASH_2 = "trash-2.png";
        public static final String TRELLO = "trello.png";
        public static final String TRENDING_DOWN = "trending-down.png";
        public static final String TRENDING_UP = "trending-up.png";
        public static final String TRIANGLE = "triangle.png";
        public static final String TRUCK = "truck.png";
        public static final String TV = "tv.png";
        public static final String TWITCH = "twitch.png";
        public static final String TWITTER = "twitter.png";
        public static final String TYPE = "type.png";
        public static final String UMBRELLA = "umbrella.png";
        public static final String UNDERLINE = "underline.png";
        public static final String UNLOCK = "unlock.png";
        public static final String UPLOAD = "upload.png";
        public static final String UPLOAD_CLOUD = "upload-cloud.png";
        public static final String USER = "user.png";
        public static final String USER_CHECK = "user-check.png";
        public static final String USER_MINUS = "user-minus.png";
        public static final String USER_PLUS = "user-plus.png";
        public static final String USER_X = "user-x.png";
        public static final String USERS = "users.png";
        public static final String VIDEO = "video.png";
        public static final String VIDEO_OFF = "video-off.png";
        public static final String VOICEMAIL = "voicemail.png";
        public static final String VOLUME = "volume.png";
        public static final String VOLUME_1 = "volume-1.png";
        public static final String VOLUME_2 = "volume-2.png";
        public static final String VOLUME_X = "volume-x.png";
        public static final String WATCH = "watch.png";
        public static final String WIFI = "wifi.png";
        public static final String WIFI_OFF = "wifi-off.png";
        public static final String WIND = "wind.png";
        public static final String X = "x.png";
        public static final String X_CIRCLE = "x-circle.png";
        public static final String X_OCTAGON = "x-octagon.png";
        public static final String X_SQUARE = "x-square.png";
        public static final String YOUTUBE = "youtube.png";
        public static final String ZAP = "zap.png";
        public static final String ZAP_OFF = "zap-off.png";
        public static final String ZOOM_IN = "zoom-in.png";
        public static final String ZOOM_OUT = "zoom-out.png";
    }
}
