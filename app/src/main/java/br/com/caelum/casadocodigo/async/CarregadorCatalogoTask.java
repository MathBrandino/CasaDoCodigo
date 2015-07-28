package br.com.caelum.casadocodigo.async;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.widget.ListView;

import java.util.List;

import br.com.caelum.casadocodigo.activity.MainActivity;
import br.com.caelum.casadocodigo.adapter.LivrosAdapter;
import br.com.caelum.casadocodigo.converter.LeitorDeLivros;
import br.com.caelum.casadocodigo.factory.LeitorDeLivrosFactory;
import br.com.caelum.casadocodigo.modelo.Livro;


/**
 * Created by matheus on 28/07/15.
 */
public class CarregadorCatalogoTask extends AsyncTask<Void, Void , List<Livro>>{

    private MainActivity activity;
    private List<Livro> livros;
    private ProgressDialog progressDialog;
    private ListView lista;


    public CarregadorCatalogoTask(MainActivity activity, ListView lista) {
        this.activity = activity;
        this.lista = lista;
    }

    @Override
    protected List<Livro> doInBackground(Void... params) {


        LeitorDeLivros leitorDeLivros = LeitorDeLivrosFactory.getLeitorDeLivros(activity);

        livros = leitorDeLivros.devolveLista();


        int n =0;
        while (n < Integer.MAX_VALUE){
            n++;
        }

        return livros;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        progressDialog = ProgressDialog.show(activity ,"Aguarde...", "Pegando livros do servidor ", true);

    }


    @Override
    protected void onPostExecute(List<Livro> livros) {
        super.onPostExecute(livros);

        LivrosAdapter adapter = new LivrosAdapter(livros, activity);

        lista.setAdapter(adapter);

        progressDialog.dismiss();
    }


}
