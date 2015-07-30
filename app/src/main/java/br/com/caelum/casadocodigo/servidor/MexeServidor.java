package br.com.caelum.casadocodigo.servidor;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by matheus on 29/07/15.
 */
public class MexeServidor  {

    private URL url;
    private HttpURLConnection connection;

    public HttpURLConnection abreConexao() throws IOException {

        url = new URL("https://raw.githubusercontent.com/MathBrandino/CasaDoCodigo/master/app/src/main/res/raw/listalivros.json");

       return (HttpURLConnection) url.openConnection();

    }
}
