
import java.io.FileInputStream;import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.awt.Color;
import java.awt.Font;
import javax.imageio.ImageIO;

public class GeradoradeFigurinhas {


    public void cria (InputStream inputStream, String nomeArquivo) throws Exception{

// Leitura da imagem
//InputStream inputStream = 
//                          new FileInputStream("img-filmes/TSR-maior.jpg");
//InputStream inputStream =
//               new URL("https://");
//                .openStream();
BufferedImage imagemOriginal = ImageIO.read(inputStream);

//cria nova imagem em mémoria com transparência e com tamanho novo
int largura = imagemOriginal.getWidth();
int altura = imagemOriginal.getHeight();
int novaAltura = altura + 200;
BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

//copiar a imagem original pra nova imagem (em memoria)
Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
graphics.drawImage(imagemOriginal, 0, 0, null);

//configurar a fonte
var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 64);
graphics.setColor(Color.YELLOW);
graphics.setFont(fonte);

//escrever uma frase na nova imagem
graphics.drawString("TOPZERA MLK", 0, novaAltura - 100);


// escrever a nova imagem em um arquivo
ImageIO.write(novaImagem, "png", new File(nomeArquivo));

    }
    

    
}


