package br.com.caelum.casadocodigo.servidor;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by matheus on 29/07/15.
 */
public class ComunicaServidor {

    private URL url;
    private HttpURLConnection connection;

    public HttpURLConnection abreConexaoListaCompleta() throws IOException {

        url = new URL("https://raw.githubusercontent.com/MathBrandino/CasaDoCodigo/master/app/src/main/res/raw/listalivros.json");

        connection = (HttpURLConnection) url.openConnection();

        return connection;

    }

    public HttpURLConnection abreConexaoListaAgile() throws IOException {

        url = new URL("https://raw.githubusercontent.com/MathBrandino/CasaDoCodigo/master/app/src/main/res/raw/listalivros_agile.json");

        connection = (HttpURLConnection) url.openConnection();

        return connection;

    }

    public HttpURLConnection abreConexaoListaJava() throws IOException {

        url = new URL("https://raw.githubusercontent.com/MathBrandino/CasaDoCodigo/master/app/src/main/res/raw/listalivros_java.json");

        connection = (HttpURLConnection) url.openConnection();

        return connection;

    }

    public HttpURLConnection abreConexaoListaMobile() throws IOException {

        url = new URL("https://raw.githubusercontent.com/MathBrandino/CasaDoCodigo/master/app/src/main/res/raw/listalivros_mobile.json");

        connection = (HttpURLConnection) url.openConnection();

        return connection;

    }

    public HttpURLConnection abreConexaoListaFront() throws IOException {

        url = new URL("https://raw.githubusercontent.com/MathBrandino/CasaDoCodigo/master/app/src/main/res/raw/listalivros_front.json");

        connection = (HttpURLConnection) url.openConnection();

        return connection;

    }

    public HttpURLConnection abreConexaoListaWeb() throws IOException {

        url = new URL("https://raw.githubusercontent.com/MathBrandino/CasaDoCodigo/master/app/src/main/res/raw/listalivros_web.json");

        connection = (HttpURLConnection) url.openConnection();

        return connection;

    }
    public HttpURLConnection abreConexaoListaGames() throws IOException {

        url = new URL("https://raw.githubusercontent.com/MathBrandino/CasaDoCodigo/master/app/src/main/res/raw/listalivros_games.json");

        connection = (HttpURLConnection) url.openConnection();

        return connection;

    }

    public HttpURLConnection abreConexaoListaOutros() throws IOException {

        url = new URL("https://raw.githubusercontent.com/MathBrandino/CasaDoCodigo/master/app/src/main/res/raw/listalivros_diversos.json");

        connection = (HttpURLConnection) url.openConnection();

        return connection;

    }
}
