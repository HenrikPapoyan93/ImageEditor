package imageeditor;

import java.util.Scanner;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.*;



/**
 *
 * @author 
 */
public class ImageEditor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter (1) to enter image url or (2) to enter local image path (other) to exit");
        int x = in.nextInt();
        if(x == 1 || x == 2) {
            System.out.println("Enter a valid image path/url:");
            String path = in.next();
            System.out.println("Enter the output image width:");
            int width = in.nextInt();
            System.out.println("Enter the output image Height:");
            int height = in.nextInt();
            GenerateModifiedImage(path, width, height, x);
        }              
    }

    private static void GenerateModifiedImage(String path, int width, int height, int x) {
        try {
            BufferedImage img;
            if(x == 1) {
                URL input = new URL(path);
                img = ImageIO.read(input); 
            } else {
                File input = new File(path);
                img = ImageIO.read(input);
            }
            BufferedImage result = new BufferedImage(
                    width,
                    height,
                    BufferedImage.TYPE_BYTE_GRAY);
            Graphics2D graphic = result.createGraphics();
            graphic.drawImage(img, 0, 0, width, height, null);
            graphic.dispose();
            File output = new File("BlackAndWhite.jpg");
            ImageIO.write(result, "jpg", output);
        }  catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
