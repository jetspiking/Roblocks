package miscellaneous.constants;

import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import miscellaneous.models.LogMessage;

import javax.swing.filechooser.FileSystemView;

public class Application {
    public static final class Strings
    {
        public static final String APPLICATION_TITLE = "R O B L O C K S";
    }

    public static final class Containers
    {
        public static final class TopBar
        {
            public static final int MENU_BUTTON_SIZE = 20;
            public static final Font MENU_BUTTON_FONT = Font.font("sans-serif", FontWeight.BOLD, 13);
        }
    }

    public static final class Paths
    {
        public static final String ICONS_PATH = "/feathericons/";
        public static final String APPICONS_PATH = "/appicons/";
        public static final String FILES_PATH = "/files/";
    }

    public static final class URLs {
        public static final String GITHUB = "https://github.com/jetspiking/Roblocks";
    }

    public static final class FilesPaths
    {
        public static final String ROBLOCKS_HELP = Paths.FILES_PATH+"RoblocksHelpDoc.html";
        public static final String ROBLOCKS_FOLDER = FileSystemView.getFileSystemView().getDefaultDirectory().getPath()+"/Roblocks"; // "/Users/dustin/Desktop/RoblocksConfig/ToolboxConfiguration.json"
        public static final String DEFAULT_TOOLBOX_PATH = ROBLOCKS_FOLDER+"/ToolboxConfiguration.json";
        public static final String DEFAULT_SAVE_PATH = ROBLOCKS_FOLDER+"/ProgramExport.json";
    }

    public static final class Messages
    {
        public static final LogMessage ERROR_CONFIGURATION_READ = new LogMessage("Can not read toolbox configuration on specified location.", LogMessage.LogMessageType.ERROR);
        public static final LogMessage SUCCESS_CONFIGURATION_READ = new LogMessage("Read configuration file and filled toolbox.", LogMessage.LogMessageType.VERBOSE);
    }

    public static final class InterfaceStrings
    {
        public static final String VISUAL_EDIT_FRAGMENT_DEFAULT_TITLE = "Node";
        public static final String PREFERENCES = "Preferences";
        public static final String CONNECTION = "Connection";
        public static final String PATHS = "Paths";
    }

    public static final class IconPaths
    {
        public static final String ROBLOCKS_LOGO = Paths.APPICONS_PATH+"roblocks.png";
        public static final String ROBLOCKS_SPLASHSCREEN = Paths.APPICONS_PATH+"splashscreen.png";
        public static final String ACTIVITY = Paths.ICONS_PATH+"activity.png";
        public static final String AIRPLAY = Paths.ICONS_PATH+"airplay.png";
        public static final String ALERT_CIRCLE = Paths.ICONS_PATH+"alert-circle.png";
        public static final String ALERT_OCTAGON = Paths.ICONS_PATH+"alert-octagon.png";
        public static final String ALERT_TRIANGLE = Paths.ICONS_PATH+"alert-triangle.png";
        public static final String ALIGN_CENTER = Paths.ICONS_PATH+"align-center.png";
        public static final String ALIGN_JUSTIFY = Paths.ICONS_PATH+"align-justify.png";
        public static final String ALIGN_LEFT = Paths.ICONS_PATH+"align-left.png";
        public static final String ALIGN_RIGHT = Paths.ICONS_PATH+"align-right.png";
        public static final String ANCHOR = Paths.ICONS_PATH+"anchor.png";
        public static final String APERTURE = Paths.ICONS_PATH+"aperture.png";
        public static final String ARCHIVE = Paths.ICONS_PATH+"archive.png";
        public static final String ARROW_DOWN = Paths.ICONS_PATH+"arrow-down.png";
        public static final String ARROW_DOWN_CIRCLE = Paths.ICONS_PATH+"arrow-down-circle.png";
        public static final String ARROW_DOWN_LEFT = Paths.ICONS_PATH+"arrow-down-left.png";
        public static final String ARROW_DOWN_RIGHT = Paths.ICONS_PATH+"arrow-down-right.png";
        public static final String ARROW_LEFT = Paths.ICONS_PATH+"arrow-left.png";
        public static final String ARROW_LEFT_CIRCLE = Paths.ICONS_PATH+"arrow-left-circle.png";
        public static final String ARROW_RIGHT = Paths.ICONS_PATH+"arrow-right.png";
        public static final String ARROW_RIGHT_CIRCLE = Paths.ICONS_PATH+"arrow-right-circle.png";
        public static final String ARROW_UP = Paths.ICONS_PATH+"arrow-up.png";
        public static final String ARROW_UP_CIRCLE = Paths.ICONS_PATH+"arrow-up-circle.png";
        public static final String ARROW_UP_LEFT = Paths.ICONS_PATH+"arrow-up-left.png";
        public static final String ARROW_UP_RIGHT = Paths.ICONS_PATH+"arrow-up-right.png";
        public static final String AT_SIGN = Paths.ICONS_PATH+"at-sign.png";
        public static final String AWARD = Paths.ICONS_PATH+"award.png";
        public static final String BAR_CHART = Paths.ICONS_PATH+"bar-chart.png";
        public static final String BAR_CHART_2 = Paths.ICONS_PATH+"bar-chart-2.png";
        public static final String BATTERY = Paths.ICONS_PATH+"battery.png";
        public static final String BATTERY_CHARGING = Paths.ICONS_PATH+"battery-charging.png";
        public static final String BELL = Paths.ICONS_PATH+"bell.png";
        public static final String BELL_OFF = Paths.ICONS_PATH+"bell-off.png";
        public static final String BLUETOOTH = Paths.ICONS_PATH+"bluetooth.png";
        public static final String BOLD = Paths.ICONS_PATH+"bold.png";
        public static final String BOOK = Paths.ICONS_PATH+"book.png";
        public static final String BOOK_OPEN = Paths.ICONS_PATH+"book-open.png";
        public static final String BOOKMARK = Paths.ICONS_PATH+"bookmark.png";
        public static final String BOX = Paths.ICONS_PATH+"box.png";
        public static final String BRIEFCASE = Paths.ICONS_PATH+"briefcase.png";
        public static final String CALENDAR = Paths.ICONS_PATH+"calendar.png";
        public static final String CAMERA = Paths.ICONS_PATH+"camera.png";
        public static final String CAMERA_OFF = Paths.ICONS_PATH+"camera-off.png";
        public static final String CAST = Paths.ICONS_PATH+"cast.png";
        public static final String CHECK = Paths.ICONS_PATH+"check.png";
        public static final String CHECK_CIRCLE = Paths.ICONS_PATH+"check-circle.png";
        public static final String CHECK_SQUARE = Paths.ICONS_PATH+"check-square.png";
        public static final String CHEVRON_DOWN = Paths.ICONS_PATH+"chevron-down.png";
        public static final String CHEVRON_LEFT = Paths.ICONS_PATH+"chevron-left.png";
        public static final String CHEVRON_RIGHT = Paths.ICONS_PATH+"chevron-right.png";
        public static final String CHEVRON_UP = Paths.ICONS_PATH+"chevron-up.png";
        public static final String CHEVRONS_DOWN = Paths.ICONS_PATH+"chevrons-down.png";
        public static final String CHEVRONS_LEFT = Paths.ICONS_PATH+"chevrons-left.png";
        public static final String CHEVRONS_RIGHT = Paths.ICONS_PATH+"chevrons-right.png";
        public static final String CHEVRONS_UP = Paths.ICONS_PATH+"chevrons-up.png";
        public static final String CHROME = Paths.ICONS_PATH+"chrome.png";
        public static final String CIRCLE = Paths.ICONS_PATH+"circle.png";
        public static final String CLIPBOARD = Paths.ICONS_PATH+"clipboard.png";
        public static final String CLOCK = Paths.ICONS_PATH+"clock.png";
        public static final String CLOUD = Paths.ICONS_PATH+"cloud.png";
        public static final String CLOUD_DRIZZLE = Paths.ICONS_PATH+"cloud-drizzle.png";
        public static final String CLOUD_LIGHTNING = Paths.ICONS_PATH+"cloud-lightning.png";
        public static final String CLOUD_OFF = Paths.ICONS_PATH+"cloud-off.png";
        public static final String CLOUD_RAIN = Paths.ICONS_PATH+"cloud-rain.png";
        public static final String CLOUD_SNOW = Paths.ICONS_PATH+"cloud-snow.png";
        public static final String CODE = Paths.ICONS_PATH+"code.png";
        public static final String CODEPEN = Paths.ICONS_PATH+"codepen.png";
        public static final String CODE_SANDBOX = Paths.ICONS_PATH+"codesandbox.png";
        public static final String COFFEE = Paths.ICONS_PATH+"coffee.png";
        public static final String COLUMNS = Paths.ICONS_PATH+"columns.png";
        public static final String COMMAND = Paths.ICONS_PATH+"command.png";
        public static final String COMPASS = Paths.ICONS_PATH+"compass.png";
        public static final String COPY = Paths.ICONS_PATH+"copy.png";
        public static final String CORNER_DOWN_LEFT = Paths.ICONS_PATH+"corner-down-left.png";
        public static final String CORNER_DOWN_RIGHT = Paths.ICONS_PATH+"corner-down-right.png";
        public static final String CORNER_LEFT_DOWN = Paths.ICONS_PATH+"corner-left-down.png";
        public static final String CORNER_LEFT_UP = Paths.ICONS_PATH+"corner-left-up.png";
        public static final String CORNER_RIGHT_DOWN = Paths.ICONS_PATH+"corner-right-down.png";
        public static final String CORNER_RIGHT_UP = Paths.ICONS_PATH+"corner-right-up.png";
        public static final String CORNER_UP_LEFT = Paths.ICONS_PATH+"corner-up-left.png";
        public static final String CORNER_UP_RIGHT = Paths.ICONS_PATH+"corner-up-right.png";
        public static final String CPU = Paths.ICONS_PATH+"cpu.png";
        public static final String CREDIT_CARD = Paths.ICONS_PATH+"credit-card.png";
        public static final String CROP = Paths.ICONS_PATH+"crop.png";
        public static final String CROSSHAIR = Paths.ICONS_PATH+"crosshair.png";
        public static final String DATABASE = Paths.ICONS_PATH+"database.png";
        public static final String DELETE = Paths.ICONS_PATH+"delete.png";
        public static final String DISC = Paths.ICONS_PATH+"disc.png";
        public static final String DIVIDE = Paths.ICONS_PATH+"divide.png";
        public static final String DIVIDE_CIRCLE = Paths.ICONS_PATH+"divide-circle.png";
        public static final String DIVIDE_SQUARE = Paths.ICONS_PATH+"divide-square.png";
        public static final String DOLLAR_SIGN = Paths.ICONS_PATH+"dollar-sign.png";
        public static final String DOWNLOAD = Paths.ICONS_PATH+"download.png";
        public static final String DOWNLOAD_CLOUD = Paths.ICONS_PATH+"download-cloud.png";
        public static final String DRIBBBLE = Paths.ICONS_PATH+"dribbble.png";
        public static final String DROPLET = Paths.ICONS_PATH+"droplet.png";
        public static final String EDIT = Paths.ICONS_PATH+"edit.png";
        public static final String EDIT_2 = Paths.ICONS_PATH+"edit-2.png";
        public static final String EDIT_3 = Paths.ICONS_PATH+"edit-3.png";
        public static final String EXTERNAL_LINK = Paths.ICONS_PATH+"external-link.png";
        public static final String EYE = Paths.ICONS_PATH+"eye.png";
        public static final String EYE_OFF = Paths.ICONS_PATH+"eye-off.png";
        public static final String FACEBOOK = Paths.ICONS_PATH+"facebook.png";
        public static final String FAST_FORWARD = Paths.ICONS_PATH+"fast-forward.png";
        public static final String FEATHER = Paths.ICONS_PATH+"feather.png";
        public static final String FIGMA = Paths.ICONS_PATH+"figma.png";
        public static final String FILE = Paths.ICONS_PATH+"file.png";
        public static final String FILE_MINUS = Paths.ICONS_PATH+"file-minus.png";
        public static final String FILE_PLUS = Paths.ICONS_PATH+"file-plus.png";
        public static final String FILE_TEXT = Paths.ICONS_PATH+"file-text.png";
        public static final String FILM = Paths.ICONS_PATH+"film.png";
        public static final String FILTER = Paths.ICONS_PATH+"filter.png";
        public static final String FLAG = Paths.ICONS_PATH+"flag.png";
        public static final String FOLDER = Paths.ICONS_PATH+"folder.png";
        public static final String FOLDER_MINUS = Paths.ICONS_PATH+"folder-minus.png";
        public static final String FOLDER_PLUS = Paths.ICONS_PATH+"folder-plus.png";
        public static final String FRAMER = Paths.ICONS_PATH+"framer.png";
        public static final String FROWN = Paths.ICONS_PATH+"frown.png";
        public static final String GIFT = Paths.ICONS_PATH+"gift.png";
        public static final String GIT_BRANCH = Paths.ICONS_PATH+"git-branch.png";
        public static final String GIT_COMMIT = Paths.ICONS_PATH+"git-commit.png";
        public static final String GIT_MERGE = Paths.ICONS_PATH+"git-merge.png";
        public static final String GIT_PULL_REQUEST = Paths.ICONS_PATH+"git-pull-request.png";
        public static final String GITHUB = Paths.ICONS_PATH+"github.png";
        public static final String GITLAB = Paths.ICONS_PATH+"gitlab.png";
        public static final String GLOBE = Paths.ICONS_PATH+"globe.png";
        public static final String GRID = Paths.ICONS_PATH+"grid.png";
        public static final String HARDDRIVE = Paths.ICONS_PATH+"harddrive.png";
        public static final String HASH = Paths.ICONS_PATH+"hash.png";
        public static final String HEADPHONES = Paths.ICONS_PATH+"headphones.png";
        public static final String HEART = Paths.ICONS_PATH+"heart.png";
        public static final String HELP_CIRCLE = Paths.ICONS_PATH+"help-circle.png";
        public static final String HEXAGON = Paths.ICONS_PATH+"hexagon.png";
        public static final String HOME = Paths.ICONS_PATH+"home.png";
        public static final String IMAGE = Paths.ICONS_PATH+"image.png";
        public static final String INBOX = Paths.ICONS_PATH+"inbox.png";
        public static final String INFO = Paths.ICONS_PATH+"info.png";
        public static final String INSTAGRAM = Paths.ICONS_PATH+"instagram.png";
        public static final String ITALIC = Paths.ICONS_PATH+"italic.png";
        public static final String KEY = Paths.ICONS_PATH+"key.png";
        public static final String LAYERS = Paths.ICONS_PATH+"layers.png";
        public static final String LAYOUT = Paths.ICONS_PATH+"layout.png";
        public static final String LIFE_BUOY = Paths.ICONS_PATH+"life-buoy.png";
        public static final String LINK = Paths.ICONS_PATH+"link.png";
        public static final String LINK_2 = Paths.ICONS_PATH+"link-2.png";
        public static final String LINKEDIN = Paths.ICONS_PATH+"linkedin.png";
        public static final String LIST = Paths.ICONS_PATH+"list.png";
        public static final String LOADER = Paths.ICONS_PATH+"loader.png";
        public static final String LOCK = Paths.ICONS_PATH+"lock.png";
        public static final String LOG_IN = Paths.ICONS_PATH+"log-in.png";
        public static final String LOG_OUT = Paths.ICONS_PATH+"log-out.png";
        public static final String MAIL = Paths.ICONS_PATH+"mail.png";
        public static final String MAP = Paths.ICONS_PATH+"map.png";
        public static final String MAP_PIN = Paths.ICONS_PATH+"map-pin.png";
        public static final String MAXIMALIZE = Paths.ICONS_PATH+"maximalize.png";
        public static final String MAXIMALIZE_2 = Paths.ICONS_PATH+"maximalize-2.png";
        public static final String MEH = Paths.ICONS_PATH+"meh.png";
        public static final String MENU = Paths.ICONS_PATH+"menu.png";
        public static final String MESSAGE_CIRCLE = Paths.ICONS_PATH+"message-circle.png";
        public static final String MESSAGE_SQUARE = Paths.ICONS_PATH+"message-square.png";
        public static final String MIC = Paths.ICONS_PATH+"mic.png";
        public static final String MIC_OFF = Paths.ICONS_PATH+"mic-off.png";
        public static final String MINIMIZE = Paths.ICONS_PATH+"minimize.png";
        public static final String MINIMIZE_2 = Paths.ICONS_PATH+"minimize-2.png";
        public static final String MINUS = Paths.ICONS_PATH+"minus.png";
        public static final String MINUS_CIRCLE = Paths.ICONS_PATH+"minus-circle.png";
        public static final String MINUS_SQUARE = Paths.ICONS_PATH+"minus-square.png";
        public static final String MONITOR = Paths.ICONS_PATH+"monitor.png";
        public static final String MOON = Paths.ICONS_PATH+"moon.png";
        public static final String MORE_HORIZONTAL = Paths.ICONS_PATH+"more-horizontal.png";
        public static final String MORE_VERTICAL = Paths.ICONS_PATH+"more-vertical.png";
        public static final String MOUSE_POINTER = Paths.ICONS_PATH+"mouse-pointer.png";
        public static final String MOVE = Paths.ICONS_PATH+"move.png";
        public static final String MUSIC = Paths.ICONS_PATH+"music.png";
        public static final String NAVIGATION = Paths.ICONS_PATH+"navigation.png";
        public static final String NAVIGATION_2 = Paths.ICONS_PATH+"navigation-2.png";
        public static final String OCTAGON = Paths.ICONS_PATH+"octagon.png";
        public static final String PACKAGE = Paths.ICONS_PATH+"package.png";
        public static final String PAPERCLIP = Paths.ICONS_PATH+"paperclip.png";
        public static final String PAUSE = Paths.ICONS_PATH+"pause.png";
        public static final String PAUSE_CIRCLE = Paths.ICONS_PATH+"pause-circle.png";
        public static final String PEN_TOOL = Paths.ICONS_PATH+"pen-tool.png";
        public static final String PERCENT = Paths.ICONS_PATH+"percent.png";
        public static final String PHONE = Paths.ICONS_PATH+"phone.png";
        public static final String PHONE_CALL = Paths.ICONS_PATH+"phone-call.png";
        public static final String PHONE_FORWARDED = Paths.ICONS_PATH+"phone-forwarded.png";
        public static final String PHONE_INCOMING = Paths.ICONS_PATH+"phone-incoming.png";
        public static final String PHONE_MISSED = Paths.ICONS_PATH+"phone-missed.png";
        public static final String PHONE_OFF = Paths.ICONS_PATH+"phone-off.png";
        public static final String PHONE_OUTGOING = Paths.ICONS_PATH+"phone-outgoing.png";
        public static final String PIE_CHART = Paths.ICONS_PATH+"pie-chart.png";
        public static final String PLAY = Paths.ICONS_PATH+"play.png";
        public static final String PLAY_CIRCLE = Paths.ICONS_PATH+"play-circle.png";
        public static final String PLUS = Paths.ICONS_PATH+"plus.png";
        public static final String PLUS_CIRCLE = Paths.ICONS_PATH+"plus-circle.png";
        public static final String PLUS_SQUARE = Paths.ICONS_PATH+"plus-square.png";
        public static final String POCKET = Paths.ICONS_PATH+"pocket.png";
        public static final String POWER = Paths.ICONS_PATH+"power.png";
        public static final String PRINTER = Paths.ICONS_PATH+"printer.png";
        public static final String RADIO = Paths.ICONS_PATH+"radio.png";
        public static final String REFRESH_CCW = Paths.ICONS_PATH+"refresh-ccw.png";
        public static final String REFRESH_CW = Paths.ICONS_PATH+"refresh-cw.png";
        public static final String REPEAT = Paths.ICONS_PATH+"repeat.png";
        public static final String REWIND = Paths.ICONS_PATH+"rewind.png";
        public static final String ROTATE_CCW = Paths.ICONS_PATH+"rotate-ccw.png";
        public static final String ROTATE_CW = Paths.ICONS_PATH+"rotate-cw.png";
        public static final String RSS = Paths.ICONS_PATH+"rss.png";
        public static final String SAVE = Paths.ICONS_PATH+"save.png";
        public static final String SCISSORS = Paths.ICONS_PATH+"scissors.png";
        public static final String SEARCH = Paths.ICONS_PATH+"search.png";
        public static final String SEND = Paths.ICONS_PATH+"send.png";
        public static final String SERVER = Paths.ICONS_PATH+"server.png";
        public static final String SETTINGS = Paths.ICONS_PATH+"settings.png";
        public static final String SHARE = Paths.ICONS_PATH+"share.png";
        public static final String SHARE_2 = Paths.ICONS_PATH+"share-2.png";
        public static final String SHIELD = Paths.ICONS_PATH+"shield.png";
        public static final String SHIELD_OFF = Paths.ICONS_PATH+"shield-off.png";
        public static final String SHOPPING_BAG = Paths.ICONS_PATH+"shopping-bag.png";
        public static final String SHOPPING_CART = Paths.ICONS_PATH+"shopping-cart.png";
        public static final String SHUFFLE = Paths.ICONS_PATH+"shuffle.png";
        public static final String SIDEBAR = Paths.ICONS_PATH+"sidebar.png";
        public static final String SKIP_BACK = Paths.ICONS_PATH+"skip-back.png";
        public static final String SKIP_FORWARD = Paths.ICONS_PATH+"skip-forward.png";
        public static final String SLACK = Paths.ICONS_PATH+"slack.png";
        public static final String SLASH = Paths.ICONS_PATH+"slash.png";
        public static final String SLIDERS = Paths.ICONS_PATH+"sliders.png";
        public static final String SMARTPHONE = Paths.ICONS_PATH+"smartphone.png";
        public static final String SMILE = Paths.ICONS_PATH+"smile.png";
        public static final String SPEAKER = Paths.ICONS_PATH+"speaker.png";
        public static final String SQUARE = Paths.ICONS_PATH+"square.png";
        public static final String STAR = Paths.ICONS_PATH+"star.png";
        public static final String STOP_CIRCLE = Paths.ICONS_PATH+"stop-circle.png";
        public static final String SUN = Paths.ICONS_PATH+"sun.png";
        public static final String SUNRISE = Paths.ICONS_PATH+"sunrise.png";
        public static final String SUNSET = Paths.ICONS_PATH+"sunset.png";
        public static final String TABLET = Paths.ICONS_PATH+"tablet.png";
        public static final String TAG = Paths.ICONS_PATH+"tag.png";
        public static final String TARGET = Paths.ICONS_PATH+"target.png";
        public static final String TERMINAL = Paths.ICONS_PATH+"terminal.png";
        public static final String THERMOMETER = Paths.ICONS_PATH+"thermometer.png";
        public static final String THUMBS_DOWN = Paths.ICONS_PATH+"thumbs-down.png";
        public static final String THUMBS_UP = Paths.ICONS_PATH+"thumbs-up.png";
        public static final String TOGGLE_LEFT = Paths.ICONS_PATH+"toggle-left.png";
        public static final String TOGGLE_RIGHT = Paths.ICONS_PATH+"toggle-right.png";
        public static final String TOOL = Paths.ICONS_PATH+"tool.png";
        public static final String TRASH = Paths.ICONS_PATH+"trash.png";
        public static final String TRASH_2 = Paths.ICONS_PATH+"trash-2.png";
        public static final String TRELLO = Paths.ICONS_PATH+"trello.png";
        public static final String TRENDING_DOWN = Paths.ICONS_PATH+"trending-down.png";
        public static final String TRENDING_UP = Paths.ICONS_PATH+"trending-up.png";
        public static final String TRIANGLE = Paths.ICONS_PATH+"triangle.png";
        public static final String TRUCK = Paths.ICONS_PATH+"truck.png";
        public static final String TV = Paths.ICONS_PATH+"tv.png";
        public static final String TWITCH = Paths.ICONS_PATH+"twitch.png";
        public static final String TWITTER = Paths.ICONS_PATH+"twitter.png";
        public static final String TYPE = Paths.ICONS_PATH+"type.png";
        public static final String UMBRELLA = Paths.ICONS_PATH+"umbrella.png";
        public static final String UNDERLINE = Paths.ICONS_PATH+"underline.png";
        public static final String UNLOCK = Paths.ICONS_PATH+"unlock.png";
        public static final String UPLOAD = Paths.ICONS_PATH+"upload.png";
        public static final String UPLOAD_CLOUD = Paths.ICONS_PATH+"upload-cloud.png";
        public static final String USER = Paths.ICONS_PATH+"user.png";
        public static final String USER_CHECK = Paths.ICONS_PATH+"user-check.png";
        public static final String USER_MINUS = Paths.ICONS_PATH+"user-minus.png";
        public static final String USER_PLUS = Paths.ICONS_PATH+"user-plus.png";
        public static final String USER_X = Paths.ICONS_PATH+"user-x.png";
        public static final String USERS = Paths.ICONS_PATH+"users.png";
        public static final String VIDEO = Paths.ICONS_PATH+"video.png";
        public static final String VIDEO_OFF = Paths.ICONS_PATH+"video-off.png";
        public static final String VOICEMAIL = Paths.ICONS_PATH+"voicemail.png";
        public static final String VOLUME = Paths.ICONS_PATH+"volume.png";
        public static final String VOLUME_1 = Paths.ICONS_PATH+"volume-1.png";
        public static final String VOLUME_2 = Paths.ICONS_PATH+"volume-2.png";
        public static final String VOLUME_X = Paths.ICONS_PATH+"volume-x.png";
        public static final String WATCH = Paths.ICONS_PATH+"watch.png";
        public static final String WIFI = Paths.ICONS_PATH+"wifi.png";
        public static final String WIFI_OFF = Paths.ICONS_PATH+"wifi-off.png";
        public static final String WIND = Paths.ICONS_PATH+"wind.png";
        public static final String X = Paths.ICONS_PATH+"x.png";
        public static final String X_CIRCLE = Paths.ICONS_PATH+"x-circle.png";
        public static final String X_OCTAGON = Paths.ICONS_PATH+"x-octagon.png";
        public static final String X_SQUARE = Paths.ICONS_PATH+"x-square.png";
        public static final String YOUTUBE = Paths.ICONS_PATH+"youtube.png";
        public static final String ZAP = Paths.ICONS_PATH+"zap.png";
        public static final String ZAP_OFF = Paths.ICONS_PATH+"zap-off.png";
        public static final String ZOOM_IN = Paths.ICONS_PATH+"zoom-in.png";
        public static final String ZOOM_OUT = Paths.ICONS_PATH+"zoom-out.png";

    }
}
