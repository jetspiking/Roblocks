package miscellaneous.utilities;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

import java.io.File;
import java.util.Random;

/**
 * The Utils class contains static functions, for general usage in the application.
 */

public class Utils
{
    /**
     * Get an image from disk as ImageView object.
     * @param context Application context (this).
     * @param path Path to image.
     * @param width Desired ImageView width.
     * @param height Desired ImageView height.
     * @return ImageView object.
     */

    public static ImageView getImageView(Object context, String path, int width, int height)
    {
        ImageView menuImage = Utils.imageFromUri(path, context);
        menuImage.setFitWidth(width);
        menuImage.setFitHeight(height);
        return menuImage;
    }

    /**
     * Set transparent background color on node.
     * @param node To apply transparent background to.
     */

    public static void bindNodeTransparentBackground(Node node) {
        node.setStyle("-fx-background-color: transparent;");
    }

    /**
     * Set transparent background color on nodes.
     * @param nodes To apply transparent background to.
     */

    public static void bindNodesTransparentBackground(Node ... nodes) {
        for (Node node : nodes)
            bindNodeTransparentBackground(node);
    }

    /**
     * Set transparent focus color on node.
     * @param node To apply transparent focus to.
     */

    public static void bindNodeTransparentFocus(Node node) {
        node.setStyle("-fx-focus-color: transparent;");
    }

    /**
     * Set transparent focus color on nodes.
     * @param nodes To apply transparent focus to.
     */

    public static void bindNodesTransparentFocus(Node ... nodes) {
        for (Node node : nodes)
            bindNodeTransparentFocus(node);
    }

    /**
     * Get ImageView from souce path.
     * @param source Path to image.
     * @param me Application context.
     * @return ImageView object.
     */

    public static ImageView imageFromUri(String source, Object me)
    {
        return new ImageView(new Image(me.getClass().getResource(source).toExternalForm()));
    }

    /**
     * Verify whether a location is present (exists) or not.
     * @param source Path to location.
     * @param me Application context.
     * @return "true" Or "false" for existing or not, respectively.
     */

    public static boolean verifyExistingLocation(String source, Object me) {
        try { new File(me.getClass().getResource(source).toExternalForm()); }
        catch(NullPointerException e) {
            return false;
        }
        return true;
    }

    /**
     * Get a random color.
     * @return JavaFX Color.
     */

    public static Color getRandomColor() {
        Random rng = new Random();

        int c = rng.nextInt();
        int r = c & 255;
        int g = (c >>> 8) & 255;
        int b = (c >>> 16) & 255;
        double op = (c >>> 24) / 255.0;

        return Color.rgb(r, g, b, op);
    }

    /**
     * Get a random bright color.
     * @return JavaFX Color.
     */

    public static Color getRandomBrightColor() {
        Random randomNumberGenerator = new Random();
        float r = randomNumberGenerator.nextFloat() / 2f + .5f;
        float g = randomNumberGenerator.nextFloat() / 2f + .5f;
        float b = randomNumberGenerator.nextFloat() / 2f + .5f;
        return Color.rgb((int)(r*255),(int)(g*255),(int)(b*255));
    }
}
