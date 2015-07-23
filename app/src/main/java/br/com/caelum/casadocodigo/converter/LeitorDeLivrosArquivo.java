package br.com.caelum.casadocodigo.converter;

import android.app.Activity;
import android.util.Log;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.casadocodigo.R;
import br.com.caelum.casadocodigo.modelo.Livro;

/**
 * Created by matheus on 23/07/15.
 */
public class LeitorDeLivrosArquivo implements LeitorDeLivros {

    private Activity activity;

    public LeitorDeLivrosArquivo(Activity activity) {
        this.activity = activity;
    }

    private String leArquivo(){

        InputStream inputStream = activity.getResources().openRawResource(R.raw.listalivros);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String line;
        String json = "";

        try {
            while ((line = bufferedReader.readLine()) != null){
                json += line;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return json;
    }

    @Override
    public List<Livro> devolveLista() {

        List<Livro> livros = new ArrayList<>();

        LivroConverter converter = new LivroConverter();

        try {
           livros = converter.fromJson(leArquivo());
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return livros;
    }
}
