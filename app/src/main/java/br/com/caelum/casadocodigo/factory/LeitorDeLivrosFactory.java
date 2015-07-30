package br.com.caelum.casadocodigo.factory;

import br.com.caelum.casadocodigo.converter.LeitorDeLivros;
import br.com.caelum.casadocodigo.converter.LeitorDeLivrosServidor;

/**
 * Created by matheus on 23/07/15.
 */
public class LeitorDeLivrosFactory {

    public static LeitorDeLivros getLeitorDeLivros() {


        // LeitorDeLivros leitorDeLivros = new LeitorDeLivrosArquivo(new OnlyOpenRawResource(activity.getResources()));

        // LeitorDeLivros leitorDeLivros = new LeitorDeLivrosHardCode();

        LeitorDeLivros leitorDeLivros = new LeitorDeLivrosServidor();

        return leitorDeLivros;
    }
}
