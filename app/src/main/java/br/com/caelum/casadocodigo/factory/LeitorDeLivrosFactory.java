package br.com.caelum.casadocodigo.factory;

import android.app.Activity;

import br.com.caelum.casadocodigo.converter.LeitorDeLivros;
import br.com.caelum.casadocodigo.converter.LeitorDeLivrosArquivo;
import br.com.caelum.casadocodigo.converter.LeitorDeLivrosHardCode;
import br.com.caelum.casadocodigo.converter.LeitorDeLivrosServidor;
import br.com.caelum.casadocodigo.converter.OnlyOpenRawResource;

/**
 * Created by matheus on 23/07/15.
 */
public class LeitorDeLivrosFactory {

    public static LeitorDeLivros getLeitorDeLivros(Activity activity){


       // LeitorDeLivros leitorDeLivros = new LeitorDeLivrosArquivo(new OnlyOpenRawResource(activity.getResources()));

       // LeitorDeLivros leitorDeLivros = new LeitorDeLivrosHardCode();

        LeitorDeLivros leitorDeLivros = new LeitorDeLivrosServidor();

        return leitorDeLivros;
    }
}
