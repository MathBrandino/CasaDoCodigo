package br.com.caelum.casadocodigo.servidor;

import android.util.Log;

import java.io.IOException;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by matheus on 29/07/15.
 */
public class ComunicaServidor {

    private URL url;
    private HttpURLConnection connection;

    public HttpURLConnection abreConexaoListaCompleta() throws IOException {

        url = new URL("https://raw.githubusercontent.com/MathBrandino/CasaDoCodigo/master/app/src/main/res/raw/listalivros.json");
        //url = new URL("http://3f0a38a1.ngrok.io/casadocodigo/listarLivros?indicePrimeiroLivro=0&qtdLivros=20");

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

    public void abreConexaoMandaJson(String json) throws IOException {

        url = new URL("http://3f0a38a1.ngrok.io/casadocodigo/registrarCompra");

        connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("POST");

        connection.setRequestProperty("Content-type", "application/json");

        connection.setDoOutput(true);


        PrintStream printStream = new PrintStream(connection.getOutputStream());
        printStream.println(json);

        connection.connect();

        String jsonDeResposta = new Scanner(connection.getInputStream()).next();

        Log.i("jsonResposta",jsonDeResposta);

    }
}
