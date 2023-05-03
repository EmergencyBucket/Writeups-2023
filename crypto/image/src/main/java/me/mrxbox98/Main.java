package me.mrxbox98;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Random;

import static spark.Spark.get;
import static spark.Spark.port;

public class Main {
    
    public static String flag = System.getenv("FLAG");
    
    public static Random random = new Random();

    public static void main(String[] args) {
        port(80);
        
        get("/:id", (req, res) -> {
            try {
                String in = req.params("id");

                if(in==null) {
                    return "Try having a path.";
                }

                StringBuilder sb = new StringBuilder();

                for (int i = 0; i < 6; i++) {
                    String r = String.valueOf(random.nextDouble()).substring(2);
                    
                    while(r.length()!=18) {
                        r=r+"0";
                    }

                    System.out.println(r);

                    sb.append(r);
                }
                
                if(sb.toString().equals(in)) {
                    return flag;
                }

                System.out.println(sb.toString());

                System.out.println(in);

                String x = xor(hexToBinary(sb.toString()), hexToBinary(in));
                
                System.out.println(x);

                BufferedImage bi = new BufferedImage(108, 1, BufferedImage.TYPE_3BYTE_BGR);

                Graphics2D graphics = bi.createGraphics();

                for (int i = 0; i < 108; i+=3) {
                    graphics.setColor(new Color(x.charAt(i), x.charAt(i+1), x.charAt(i+2)));
                    graphics.fillRect(i,0,1,1);
                }

                byte[] rawImage = null;

                try(ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
                    ImageIO.write( bi, "png", baos );

                    baos.flush();
                    rawImage = baos.toByteArray();
                }

                res.header("Content-Type", "image/png");

                System.out.println(Arrays.toString(rawImage));

                return rawImage;
            }
            catch (Exception e) {
                e.printStackTrace();
                return "";
            }
        });
    }
    
    public static String xor(String a, String b) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < a.length(); i++)
            sb.append((a.charAt(i) ^ b.charAt(i % b.length())));
        String result = sb.toString();
        
        return result;
    }

    public static String hexToBinary(String hex) {
        return new BigInteger(hex, 16).toString(2);
    }
    
}