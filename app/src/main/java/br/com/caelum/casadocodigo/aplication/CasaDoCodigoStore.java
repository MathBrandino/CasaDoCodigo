package br.com.caelum.casadocodigo.aplication;

import android.app.Application;
import android.os.AsyncTask;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.casadocodigo.modelo.Carrinho;
import br.com.caelum.casadocodigo.modelo.Item;
import br.com.caelum.casadocodigo.modelo.Livro;

/**
 * Created by matheus on 24/07/15.
 */
public class CasaDoCodigoStore extends Application {

    private Carrinho carrinho;
    private List<AsyncTask<?,?,?>> tasks = new ArrayList<>();

    @Override
    public void onTerminate() {
        super.onTerminate();

        for(AsyncTask task : tasks){

            task.cancel(true);
        }
    }

    public void registra(AsyncTask<? , ? , ?> task ){
        tasks.add(task);
    }


    public void remove(AsyncTask<? , ? , ?> task ){
        tasks.remove(task);
    }

    public CasaDoCodigoStore() {
        carrinho = new Carrinho();
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

}
