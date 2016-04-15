package graphics;


import java.awt.image.BufferedImage;

public class Assets {
    private static final int width = 73, height = 98;

    public static BufferedImage spadesA, spades2, spades3, spades4, spades5, spades6,
            spades7, spades8, spades9, spades10, spadesJ, spadesQ, spadesK,
            clubsA, clubs2, clubs3, clubs4, clubs5, clubs6, clubs7,
            clubs8, clubs9, clubs10, clubsJ, clubsQ, clubsK,
            diamondsA, diamonds2, diamonds3, diamonds4, diamonds5, diamonds6, diamonds7,
            diamonds8, diamonds9, diamonds10, diamondsJ, diamondsQ, diamondsK,
            heartsA, hearts2, hearts3, hearts4, hearts5, hearts6, hearts7,
            hearts8, hearts9, hearts10, heartsJ, heartsQ, heartsK;

    public static void init() {
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/classic-playing-cards.png"));
        /*get subimage for each card*/
        /*Clubs*/
        clubsA = sheet.crop(0 * width, 0 * height, width, height);
        clubs2 = sheet.crop(1 * width, 0 * height, width, height);
        clubs3 = sheet.crop(2 * width, 0 * height, width, height);
        clubs4 = sheet.crop(3 * width, 0 * height, width, height);
        clubs5 = sheet.crop(4 * width, 0 * height, width, height);
        clubs6 = sheet.crop(5 * width, 0 * height, width, height);
        clubs7 = sheet.crop(6 * width, 0 * height, width, height);
        clubs8 = sheet.crop(7 * width, 0 * height, width, height);
        clubs9 = sheet.crop(8 * width, 0 * height, width, height);
        clubs10 = sheet.crop(9 * width, 0 * height, width, height);
        clubsJ = sheet.crop(10 * width, 0 * height, width, height);
        clubsQ = sheet.crop(11 * width, 0 * height, width, height);
        clubsK = sheet.crop(12 * width, 0 * height, width, height);
        /*Spades*/
        spadesA = sheet.crop(0 * width, 1 * height, width, height);
        spades2 = sheet.crop(1 * width, 1 * height, width, height);
        spades3 = sheet.crop(2 * width, 1 * height, width, height);
        spades4 = sheet.crop(3 * width, 1 * height, width, height);
        spades5 = sheet.crop(4 * width, 1 * height, width, height);
        spades6 = sheet.crop(5 * width, 1 * height, width, height);
        spades7 = sheet.crop(6 * width, 1 * height, width, height);
        spades8 = sheet.crop(7 * width, 1 * height, width, height);
        spades9 = sheet.crop(8 * width, 1 * height, width, height);
        spades10 = sheet.crop(9 * width, 1 * height, width, height);
        spadesJ = sheet.crop(10 * width, 1 * height, width, height);
        spadesQ = sheet.crop(11 * width, 1 * height, width, height);
        spadesK = sheet.crop(12 * width, 1 * height, width, height);
        /*Hearts*/
        heartsA = sheet.crop(0 * width, 2 * height, width, height);
        hearts2 = sheet.crop(1 * width, 2 * height, width, height);
        hearts3 = sheet.crop(2 * width, 2 * height, width, height);
        hearts4 = sheet.crop(3 * width, 2 * height, width, height);
        hearts5 = sheet.crop(4 * width, 2 * height, width, height);
        hearts6 = sheet.crop(5 * width, 2 * height, width, height);
        hearts7 = sheet.crop(6 * width, 2 * height, width, height);
        hearts8 = sheet.crop(7 * width, 2 * height, width, height);
        hearts9 = sheet.crop(8 * width, 2 * height, width, height);
        hearts10 = sheet.crop(9 * width, 2 * height, width, height);
        heartsJ = sheet.crop(10 * width, 2 * height, width, height);
        heartsQ = sheet.crop(11 * width, 2 * height, width, height);
        heartsK = sheet.crop(12 * width, 2 * height, width, height);
        /*Diamonds*/
        diamondsA = sheet.crop(0 * width, 3 * height, width, height);
        diamonds2 = sheet.crop(1 * width, 3 * height, width, height);
        diamonds3 = sheet.crop(2 * width, 3 * height, width, height);
        diamonds4 = sheet.crop(3 * width, 3 * height, width, height);
        diamonds5 = sheet.crop(4 * width, 3 * height, width, height);
        diamonds6 = sheet.crop(5 * width, 3 * height, width, height);
        diamonds7 = sheet.crop(6 * width, 3 * height, width, height);
        diamonds8 = sheet.crop(7 * width, 3 * height, width, height);
        diamonds9 = sheet.crop(8 * width, 3 * height, width, height);
        diamonds10 = sheet.crop(9 * width, 3 * height, width, height);
        diamondsJ = sheet.crop(10 * width, 3 * height, width, height);
        diamondsQ = sheet.crop(11 * width, 3 * height, width, height);
        diamondsK = sheet.crop(12 * width, 3 * height, width, height);
    }

}
