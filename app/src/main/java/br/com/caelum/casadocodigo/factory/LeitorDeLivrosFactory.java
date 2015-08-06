package br.com.caelum.casadocodigo.factory;

import android.app.Activity;
import android.content.Context;

import br.com.caelum.casadocodigo.aplication.CasaDoCodigoStore;
import br.com.caelum.casadocodigo.converter.OnlyOpenRawResource;
import br.com.caelum.casadocodigo.leitorDeLivros.LeitorDeLivros;
import br.com.caelum.casadocodigo.leitorDeLivros.LeitorDeLivrosArquivo;
import br.com.caelum.casadocodigo.leitorDeLivros.LeitorDeLivrosServidor;

/**
 * Created by matheus on 23/07/15.
 */
public class LeitorDeLivrosFactory {

    public static LeitorDeLivros getLeitorDeLivros() {


        //LeitorDeLivros leitorDeLivros = new LeitorDeLivrosArquivo(new OnlyOpenRawResource(activity.getResources()));

        // LeitorDeLivros leitorDeLivros = new LeitorDeLivrosHardCode();

        LeitorDeLivros leitorDeLivros = new LeitorDeLivrosServidor();

        return leitorDeLivros;
    }
}
