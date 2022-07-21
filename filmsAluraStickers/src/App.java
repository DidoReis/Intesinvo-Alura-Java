import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {
    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        //criar uma conexão HTTP e buscar os tops 250 filme
        
        //String url ="https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";
        //ExtratorDeConteudo extrator = new ExtratordeConteudoDoIMDB();
        
        String url ="https://api.mocki.io/v2/549a5d8b/NASA-APOD";
        ExtratorDeConteudo extrator = new ExtratordeConteudoNasa();
 extrator = new ExtratordeConteudoNasa();
            var http = new clientHttp();
            String json = http.buscaDados(url);
       
        //Exibir e manipular os dados.
        
            List<conteudo> conteudos = extrator.extraiConteudos(json);
        
            var geradora = new GeradorDeFiguras();

            for(int i = 0; i < 3; i++) {
                conteudo conteudo = conteudos.get(i);

                
                InputStream inputStream = new URL(conteudo.getUrlImage()).openStream();
                String nameFile = "exit/" + conteudo.getTitle() + ".png";
                
                geradora.create(inputStream, nameFile); 

                System.out.println(conteudo.getTitle());
                System.out.println();
            }
         
              
           
          
          
          
        }
    }

