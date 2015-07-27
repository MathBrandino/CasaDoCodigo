package br.com.caelum.casadocodigo.listener;

import android.app.Activity;
import android.view.View;
import android.widget.Toast;

import java.util.concurrent.Callable;

import br.com.caelum.casadocodigo.TipoDeCompra;
import br.com.caelum.casadocodigo.activity.MainActivity;
import br.com.caelum.casadocodigo.aplication.CasaDoCodigoStore;
import br.com.caelum.casadocodigo.modelo.Item;
import br.com.caelum.casadocodigo.modelo.Livro;

/**
 * Created by matheus on 27/07/15.
 */
public class ListenerComprarPeloMain implements View.OnClickListener {

    private ListenerMenuCompra listenerMenuCompra;
    private MainActivity activity;
    private Livro livro;
    private Callable<TipoDeCompra> funcaoQueRetornaCompra;
    private CasaDoCodigoStore casaDoCodigoStore;

    public ListenerComprarPeloMain(ListenerMenuCompra listenerMenuCompra, Livro livro, MainActivity activity, Callable<TipoDeCompra> funcaoQueRetornaCompra) {
        this.listenerMenuCompra = listenerMenuCompra;
        this.activity = activity;
        this.livro = livro;
        this.funcaoQueRetornaCompra = funcaoQueRetornaCompra;
        casaDoCodigoStore = (CasaDoCodigoStore) activity.getApplication();
    }

    @Override
    public void onClick(View v) {

        Item item = new Item();

        try {
            item.setTipoDeCompra(funcaoQueRetornaCompra.call());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        item.setLivro(livro);

        casaDoCodigoStore.getCarrinho().adicionar(item);

        Toast.makeText(activity, livro.getNomeLivro() + " foi adicionado ao carrinho", Toast.LENGTH_LONG).show();


    }



}
