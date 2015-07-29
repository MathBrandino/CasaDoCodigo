package br.com.caelum.casadocodigo.async;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.widget.ListView;

import java.util.List;

import br.com.caelum.casadocodigo.activity.MainActivity;
import br.com.caelum.casadocodigo.adapter.LivrosAdapter;
import br.com.caelum.casadocodigo.converter.LeitorDeLivros;
import br.com.caelum.casadocodigo.delegate.BuscaLivrosDelegate;
import br.com.caelum.casadocodigo.factory.LeitorDeLivrosFactory;
import br.com.caelum.casadocodigo.modelo.Livro;


/**
 * Created by matheus on 28/07/15.
 */
public class CarregadorCatalogoTask extends AsyncTask<Void, Void , List<Livro>>{

    private BuscaLivrosDelegate delegate;
    private Exception erro;

    private List<Livro> livros;
    private ProgressDialog progressDialog;

    public CarregadorCatalogoTask(BuscaLivrosDelegate delegate) {
        this.delegate = delegate;
        this.delegate.getCasaDoCodigoStore().registra(this);

    }

    @Override
    protected List<Livro> doInBackground(Void... params) {

        try {
            LeitorDeLivros leitorDeLivros = LeitorDeLivrosFactory.getLeitorDeLivros(delegate.retornaActivity());

            livros = leitorDeLivros.devolveLista();

            int n = Integer.MIN_VALUE;
            while (n < Integer.MAX_VALUE) {
                n++;
            }

            return livros;

        } catch (Exception e){
            erro = e;

            return null;
        }

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        progressDialog = ProgressDialog.show(delegate.retornaActivity() ,"Aguarde...", "Pegando livros do servidor ", true);

    }


    @Override
    protected void onPostExecute(List<Livro> livros) {
        super.onPostExecute(livros);

        if (livros != null ){
            delegate.lidaComRetorno(livros);
        } else {
            delegate.lidaComErro(erro);
        }

        delegate.getCasaDoCodigoStore().remove(this);
        progressDialog.dismiss();
    }



}
