import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratordeConteudoNasa implements ExtratorDeConteudo {
  public List<conteudo> extraiConteudos(String json) {
  var parser = new jsonParser();
  List<Map<String, String>> listaDeAtributos = parser.parse(json);
  List<conteudo> conteudos = new ArrayList<>();
  for (Map<String, String> atributos : listaDeAtributos) {
    String title = atributos.get("title");
    String urlImage = atributos.get("url");
    var conteudo = new conteudo(title, urlImage);

    conteudos.add(conteudo);
  }
  return conteudos;
}
}




