package chuvaTreino;


import com.sun.org.apache.xerces.internal.dom.DOMMessageFormatter;
import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;


public class APIchuva {

    public static void main(String[] args) {
                try{
            String cdd = "Chuva em Sorocaba, leve o guarda chuva ";
            String arquivo = "C: \\ chuvaXML.xml";

            DocumentBuilderFactory DBF = DocumentBuilderFactory.newInstance();
            DocumentBuilder DB = DBF.newDocumentBuilder();

            Document D = DB.newDocument();

            //Elemento raiz XML

                        Element raiz = D.createElement("chuva");
                        D.appendChild(raiz);

            //Elemento chuva

           Element chv = D.createElement("wind");
           raiz.appendChild(chv);

           //Definindo o Atributo
           Attr attr = D.createAttribute("id");
           long currentTimeStamp = System.currentTimeMillis();
           attr.setValue("_" + currentTimeStamp);
           chv.setAttributeNode(attr);

           //Definindo o valor da postagem
           Element textoRecebido = D.createElement(" Text");
           textoRecebido.appendChild(D.createTextNode(cdd));
           chv.appendChild(textoRecebido);

            //Construção do XML
           TransformerFactory TF = TransformerFactory.newInstance();
           Transformer T = TF.newTransformer();
           DOMSource domSource = new DOMSource(D);
           StreamResult streamResult = new StreamResult(new File(arquivo));

            //juntar Conteudo
           T.transform(domSource, streamResult);
           System.out.println("Criado");


        } catch (Exception e){
            e.printStackTrace();
            System.out.println("Diretorio"+ System.getProperty("user.dir"));
        }


    }
}

/* minha primeira vez mexendo com XML então não sei se era isso que precisava ser feito
* busquei aprender o maximo que pude em pouco tempo, e com base no que eu vi
* eu tentei reproduzir com oque foi pedido!
 */
