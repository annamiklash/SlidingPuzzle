package mi.mi.miklash.slidingpuzzle.util;


import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static mi.mi.miklash.slidingpuzzle.common.Constants.COLUMN_NUMBER;
import static mi.mi.miklash.slidingpuzzle.common.Constants.SPACE_PIC_PATH;

public class ImageUtil {


    /**
     * TODO: имя файла нужно передавать как аргумент или нужно создать константу в которой будет храниться имя файла
     */
    public static void cutImage(int imageNumberInRow) {
        try {
            final BufferedImage originalImage = ImageIO.read(Objects.requireNonNull(ImageUtil.class.getClassLoader().getResource(SPACE_PIC_PATH)));

            final int pieceWidth = getPieceWidth(originalImage, imageNumberInRow);
            final int pieceHeight = getPieceHeight(originalImage, imageNumberInRow);

            final List<Point> pointList = getSubImagesLocation(pieceWidth, pieceHeight, imageNumberInRow);

            for (int imageNumber = 0; imageNumber < pointList.size(); imageNumber++) {
                final Point actualPoint = pointList.get(imageNumber);

                saveSubImage(originalImage, imageNumber, actualPoint, pieceWidth, pieceHeight);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Image> readImageList(int columnNumber) {
        final List<Image> imageList = new ArrayList<>();

        for (int i = 0; i < COLUMN_NUMBER * COLUMN_NUMBER; i++) {
            System.out.println("Checking for image " + i);
            imageList.add(readImage(i));
        }

        return imageList;
    }


    private static void saveSubImage(BufferedImage originalImage, int imageNumber, Point actualPoint, int pieceWidth, int pieceHeight) throws IOException {
        final BufferedImage subImage = originalImage.getSubimage((int) actualPoint.getX(), (int) actualPoint.getY(), pieceWidth, pieceHeight);
        final File outputFile = new File("spaceCutImages/" + imageNumber + ".jpg");

        ImageIO.write(subImage, "jpg", outputFile);
    }

    private static int getPieceHeight(BufferedImage originalImage, int imageNumberInRow) {
        final int originalImageHeight = originalImage.getHeight();

        System.out.println("originalImageHeight: " + originalImageHeight);

        return originalImageHeight / imageNumberInRow;
    }

    private static int getPieceWidth(BufferedImage originalImage, int imageNumberInRow) {
        final int originalImageWidth = originalImage.getWidth();

        System.out.println("originalImageWidth: " + originalImageWidth);

        return originalImageWidth / imageNumberInRow;
    }

    private static List<Point> getSubImagesLocation(int pieceWidth, int pieceHeight, int columnNumber) {
        final List<Point> pointList = new ArrayList<>();
        int x = 0;
        int y = 0;

        for (int i = 0; i < COLUMN_NUMBER; i++) {
            x = 0;
            for (int j = 0; j < COLUMN_NUMBER; j++) {

                System.out.println("creating piece: " + i + " " + j);

                final Point actualPoint = new Point(x, y);
                pointList.add(actualPoint);

                x += pieceWidth;
            }
            y += pieceHeight;
        }

        return pointList;
    }


    private static Image readImage(int imageNumber) {
        return new Image("spaceCutImages/" + imageNumber + ".jpg");
    }
}
