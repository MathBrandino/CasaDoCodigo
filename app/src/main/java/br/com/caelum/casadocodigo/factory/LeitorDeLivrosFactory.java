package br.com.caelum.casadocodigo.factory;

import android.app.Activity;

import br.com.caelum.casadocodigo.converter.LeitorDeLivros;
import br.com.caelum.casadocodigo.converter.LeitorDeLivrosArquivo;

/**
 * Created by matheus on 23/07/15.
 */
public class LeitorDeLivrosFactory {

    public static LeitorDeLivros getLeitorDeLivros(Activity activity){

        LeitorDeLivros leitorDeLivros = new LeitorDeLivrosArquivo(activity);

        return leitorDeLivros;
    }
}
