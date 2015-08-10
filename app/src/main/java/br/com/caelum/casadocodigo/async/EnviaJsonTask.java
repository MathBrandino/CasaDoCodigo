package br.com.caelum.casadocodigo.async;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;

import java.io.IOException;

import br.com.caelum.casadocodigo.servidor.ComunicaServidor;

/**
 * Created by matheus on 07/08/15.
 */
public class EnviaJsonTask extends AsyncTask<String, Void, String> {


    @Override
    protected String doInBackground(String... params) {

        String[] json = params;

        String resposta = null;

        ComunicaServidor comunicaServidor = new ComunicaServidor();
        try {
           resposta = comunicaServidor.abreConexaoMandaJson(json[0]);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return resposta;
    }


    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

    }
}
