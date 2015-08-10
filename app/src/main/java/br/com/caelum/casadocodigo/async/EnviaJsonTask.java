package br.com.caelum.casadocodigo.async;

import android.os.AsyncTask;

import java.io.IOException;

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
