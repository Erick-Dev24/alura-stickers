import java.io.InputStream;
import java.net.URL;
import java.util.List;
//import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("");

        //fazer uma conexão HTTP e buscar os Top 250 filmes
//String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java/api/TopMovies.json";
//ExtratorDeConteudo extrator = new ExtratorDeConteudoDoIMDB();

//String url = "https://api.mocki.io/v2/549a5d8b/NASA-APOD";
//ExtratorDeConteudo extrator = new ExtratorDeConteudoDaNasa();

String url = "http://localhost:8080/linguagens";
ExtratorDeConteudo extrator = new ExtratorDeConteudoDoIMDB();

var http = new ClienteHttp();
String json = http.buscaDados(url);
      
        //exibir e manipular os dados
        
       List<conteudo> conteudos = extrator.extraiConteudos(json);

        var geradora = new GeradoradeFigurinhas(); 
        for(int i = 0; i < 5; i++){

         conteudo conteudo = conteudos.get(i); {
       
            InputStream inputStream = new URL(conteudo.getUrlimagem()).openStream();
            String nomeArquivo = "saida/" + conteudo.getTitulo() + ".png";

           
            geradora.cria(inputStream, nomeArquivo);

            System.out.println(conteudo.getTitulo());
            //System.out.println(conteudo.get("image"));
            //System.out.println(conteudo.get("imDbRating"));
            System.out.println();
        }
    }
  }
}
