package br.com.caelum.casadocodigo.aplication;

import android.app.Application;

/**
 * Created by matheus on 24/07/15.
 */
public class CasaDoCodigoStore extends Application {

    public String ola = "blaba";

    public String getOla() {
        return ola;
    }

    public void setOla(String ola) {
        this.ola = ola;
    }
}
