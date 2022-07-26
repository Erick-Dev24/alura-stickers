import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoDaNasa implements ExtratorDeConteudo {
  
    public List<conteudo> extraiConteudos(String json){

        //pegar só os dados que interessam (titulo, poster, classficação)
        var parser = new JsonParser();
        List<Map<String, String>> listadeAtributos = parser.parse(json);
    
        List<conteudo> conteudos = new ArrayList<>();
        
        //popular a lista de conteudos
        for (Map<String, String> atributos : listadeAtributos){
            String titulo = atributos.get("title");
            String urlImagem = atributos.get("url");
           
            var conteudo = new conteudo (titulo, urlImagem);

            conteudos.add(conteudo);
        }

        return conteudos;
    }
}
