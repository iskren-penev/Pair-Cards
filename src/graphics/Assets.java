package graphics;


import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Assets {
    private static final int width = 73, height = 98;
    public static List<BufferedImage> images = new ArrayList<BufferedImage>();
    public static BufferedImage joker = ImageLoader.loadImage("/joker_card_by_hojcat.jpg");

    public static void init() {
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/classic-playing-cards.png"));
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                images.add(sheet.crop(j * width, i * height, width, height));
            }
        }
    }

}
