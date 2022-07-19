import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        //criar uma conexão HTTP e buscar os tops 250 filme
        
        String url ="https://alura-imdb-api.herokuapp.com/movies";
        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString( ));
        String body = response.body();
       
        

        //Separar as informações necessárias (title, image, Classification)
        var parser = new jsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);
        
        
        //Exibir e manipular os dados.
        for (Map<String,String> filme : listaDeFilmes) {
           
           System.out.println("\u001b[3m \u001b[37;2m \u001b[45mPosition Rank: \u001b[m" +  filme.get("rank")); 
           System.out.println("\u001b[3m \u001b[37;2m \u001b[44mTitle: \u001b[m"+  filme.get("title"));
           System.out.println("\u001b[3m \u001b[37;2m \u001b[41mIMDb Rating: \u001b[m" + filme.get("imDbRating"));
           System.out.println("\u001b[3m \u001b[37;2m \u001b[43mCrew: \u001b[m" +  filme.get("crew"));
           System.out.println("\u001b[3m \u001b[37;2m \u001b[42mImage link: \u001b[m" +  filme.get("image"));
        

         }
           
           
          
          
          
        }
    }

