package miscellaneous.utilities;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

import java.io.File;
import java.util.Random;

public class Utils
{
    public static ImageView getImageView(Object context, String path, int width, int height)
    {
        ImageView menuImage = Utils.imageFromUri(path, context);
        menuImage.setFitWidth(width);
        menuImage.setFitHeight(height);
        return menuImage;
    }

    public static void bindNodeTransparentBackground(Node node) {
        node.setStyle("-fx-background-color: transparent;");
    }

    public static void bindNodesTransparentBackground(Node ... nodes) {
        for (Node node : nodes)
            bindNodeTransparentBackground(node);
    }

    public static void bindNodeTransparentFocus(Node node) {
        node.setStyle("-fx-focus-color: transparent;");
    }

    public static void bindNodesTransparentFocus(Node ... nodes) {
        for (Node node : nodes)
            bindNodeTransparentFocus(node);
    }

    public static ImageView imageFromUri(String source, Object me)
    {
        return new ImageView(new Image(me.getClass().getResource(source).toExternalForm()));
    }

    public static boolean verifyExistingLocation(String source, Object me) {
        try { new File(me.getClass().getResource(source).toExternalForm()); }
        catch(NullPointerException e) {
            return false;
        }
        return true;
    }

    public static Color getRandomColor() {
        Random rng = new Random();

        int c = rng.nextInt();
        int r = c & 255;
        int g = (c >>> 8) & 255;
        int b = (c >>> 16) & 255;
        double op = (c >>> 24) / 255.0;

        return Color.rgb(r, g, b, op);
    }

    public static Color getRandomBrightColor() {
        Random randomNumberGenerator = new Random();
        float r = randomNumberGenerator.nextFloat() / 2f + .5f;
        float g = randomNumberGenerator.nextFloat() / 2f + .5f;
        float b = randomNumberGenerator.nextFloat() / 2f + .5f;
        return Color.rgb((int)(r*255),(int)(g*255),(int)(b*255));
    }
}
