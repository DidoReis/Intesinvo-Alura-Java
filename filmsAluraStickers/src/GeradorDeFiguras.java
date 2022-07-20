import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
public class GeradorDeFiguras {
  
  public void create(InputStream inputStream, String nameFile) throws IOException {
    //leitura da ImageReadParam
    //InputStream inputStream = new FileInputStream(new File("entrada/filme.jpg")); 
   // InputStream inputStream = new URL("https://m.media-amazon.com/images/M/MV5BYzIzYmJlYTYtNGNiYy00N2EwLTk4ZjItMGYyZTJiOTVkM2RlXkEyXkFqcGdeQXVyODY1NDk1NjE@.jpg").openStream();
     
   BufferedImage imageOriginal = ImageIO.read(inputStream);

    //criar nova imagem com transparência e tamanho novo
    int width = imageOriginal.getWidth(); 
    int height = imageOriginal.getHeight();
    int newHeight = height + 200;
    BufferedImage newImage = new BufferedImage(width, newHeight, BufferedImage.TRANSLUCENT);
    
    //copiar a imagem original para nova imagem (em memória)
    Graphics2D graphics = (Graphics2D) newImage.getGraphics();
    graphics.drawImage(imageOriginal, 0, 0, null);


    //configurar a fonte
    var font = new Font(Font.SANS_SERIF, Font.BOLD, 64);
    graphics.setColor(Color.YELLOW);
    graphics.setFont(font);



    //escrever uma frase na nova imagem
    graphics.drawString("TOPZERA", 320, newHeight - 100);


    // escrever a nova imagem em um arquivo
    ImageIO.write(newImage, "png", new File(nameFile));

    }

  }

