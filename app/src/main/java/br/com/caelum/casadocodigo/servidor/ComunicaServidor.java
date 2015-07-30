package br.com.caelum.casadocodigo.servidor;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by matheus on 29/07/15.
 */
public class ComunicaServidor {

    private URL url;
    private HttpURLConnection connection;

    public HttpURLConnection abreConexao() throws IOException {

        url = new URL("https://raw.githubusercontent.com/MathBrandino/CasaDoCodigo/master/app/src/main/res/raw/listalivros.json");

        connection = (HttpURLConnection) url.openConnection();

       return connection;

    }
}
