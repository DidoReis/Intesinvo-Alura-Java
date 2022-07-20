import java.io.InputStream;
import java.net.URI;
import java.net.URL;
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
        
        String url ="https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";
        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString( ));
        String body = response.body();
       
        

        //Separar as informações necessárias (title, image, Classification)
        var parser = new jsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);
        
        
        //Exibir e manipular os dados.
         var geradora = new GeradorDeFiguras();
         for (Map<String,String> filme : listaDeFilmes) {    
            
          String urlImage = filme.get("image");
          String title = filme.get("title");

           InputStream inputStream = new URL(urlImage).openStream();
           String nameFile = title.replace(":", "-") + ".png";
            
           
           geradora.create(inputStream, nameFile); 

           System.out.println("\u001b[3m \u001b[37;2m \u001b[45mPosition Rank: \u001b[m" +  filme.get("rank")); 
           System.out.println("\u001b[3m \u001b[37;2m \u001b[44mTitle: \u001b[m"+  filme.get("title"));
           System.out.println("\u001b[3m \u001b[37;2m \u001b[41mIMDb Rating: \u001b[m" + filme.get("imDbRating"));
           System.out.println("\u001b[3m \u001b[37;2m \u001b[43mCrew: \u001b[m" +  filme.get("crew"));
           System.out.println("\u001b[3m \u001b[37;2m \u001b[42mImage link: \u001b[m" +  filme.get("image"));
           

         }
           
           
          
          
          
        }
    }

