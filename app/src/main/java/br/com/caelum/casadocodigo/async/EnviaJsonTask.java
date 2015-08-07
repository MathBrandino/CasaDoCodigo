package br.com.caelum.casadocodigo.async;

import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.util.Log;

import java.io.IOException;
import java.net.HttpURLConnection;

import br.com.caelum.casadocodigo.aplication.CasaDoCodigoStore;
import br.com.caelum.casadocodigo.servidor.ComunicaServidor;

/**
 * Created by matheus on 07/08/15.
 */
public class EnviaJsonTask extends AsyncTask<String, Void, Void> {
    @Override
    protected Void doInBackground(String... params) {

        String[] json = params;

        ComunicaServidor comunicaServidor = new ComunicaServidor();
        try {
            comunicaServidor.abreConexaoMandaJson(json[0]);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }




}
