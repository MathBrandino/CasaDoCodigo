package br.com.caelum.casadocodigo.async;

import android.app.ProgressDialog;
import android.os.AsyncTask;

import java.util.List;

import br.com.caelum.casadocodigo.aplication.CasaDoCodigoStore;
import br.com.caelum.casadocodigo.factory.LeitorDeLivrosFactory;
import br.com.caelum.casadocodigo.leitorDeLivros.LeitorDeLivros;
import br.com.caelum.casadocodigo.modelo.Livro;
import br.com.caelum.casadocodigo.receiver.LivrosRecebidos;


/**
 * Created by matheus on 28/07/15.
 */
public class CarregadorCatalogoTask extends AsyncTask<Void, Void, List<Livro>> {

    private Exception erro;

    private List<Livro> livros;
    private ProgressDialog progressDialog;
    private CasaDoCodigoStore casaDoCodigoStore;

    public CarregadorCatalogoTask(CasaDoCodigoStore casaDoCodigoStore) {

        this.casaDoCodigoStore = casaDoCodigoStore;
        this.casaDoCodigoStore.registra(this);
    }

    @Override
    protected List<Livro> doInBackground(Void... params) {

        try {

            LeitorDeLivros leitorDeLivros = LeitorDeLivrosFactory.getLeitorDeLivros();

            livros = leitorDeLivros.devolveLista();

            return livros;

        } catch (Exception e) {
            erro = e;

            return null;
        }

    }

    @Override
    protected void onPreExecute() {

    }


    @Override
    protected void onPostExecute(List<Livro> livros) {
        super.onPostExecute(livros);


        trataListaDeRetorno(livros);

        casaDoCodigoStore.remove(this);
    }

    private void trataListaDeRetorno(List<Livro> livros) {

        if (livros != null) {
            LivrosRecebidos.notifica(casaDoCodigoStore, livros, true);
        } else {
            LivrosRecebidos.notifica(casaDoCodigoStore, livros, false);
        }
    }
}
