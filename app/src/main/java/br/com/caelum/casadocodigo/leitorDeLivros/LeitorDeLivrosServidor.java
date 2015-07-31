package br.com.caelum.casadocodigo.leitorDeLivros;


import org.json.JSONException;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Scanner;

import br.com.caelum.casadocodigo.converter.LivroConverter;
import br.com.caelum.casadocodigo.modelo.Livro;
import br.com.caelum.casadocodigo.servidor.ComunicaServidor;

/**
 * Created by matheus on 29/07/15.
 */
public class LeitorDeLivrosServidor implements LeitorDeLivros {
    private List<Livro> livros;
    private ComunicaServidor servidor;

    @Override
    public List<Livro> devolveLista() {

        try {

            HttpURLConnection connection = pegaConexao();

            connection.setDoInput(true);

            String json = devolveJson(connection);

            converteJsonParaLista(json);

            connection.disconnect();

            return livros;

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return null;
    }

    private HttpURLConnection pegaConexao() throws IOException {
        servidor = new ComunicaServidor();

        return servidor.abreConexao();
    }

    private void converteJsonParaLista(String json) throws JSONException {
        LivroConverter converter = new LivroConverter();
        livros = converter.fromJson(json);
    }


    private String devolveJson(HttpURLConnection connection) throws IOException {

        Scanner scanner = new Scanner(connection.getInputStream());

        String line;
        String json = "";

        try {
            while ((line = scanner.nextLine()) != null) {
                json += line;
            }
        } catch (Exception e) {

        }
        return json;
    }
}
