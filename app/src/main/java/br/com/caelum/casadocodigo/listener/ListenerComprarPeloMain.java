package br.com.caelum.casadocodigo.listener;

import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Toast;

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
    private CasaDoCodigoStore casaDoCodigoStore;
    private View alertView;
    private AlertDialog alertDialog;

    public ListenerComprarPeloMain(ListenerMenuCompra listenerMenuCompra, Livro livro, MainActivity activity, View alertView, AlertDialog alertDialog) {
        this.listenerMenuCompra = listenerMenuCompra;
        this.activity = activity;
        this.livro = livro;
        this.alertView = alertView ;
        casaDoCodigoStore = (CasaDoCodigoStore) activity.getApplication();
        this.alertDialog = alertDialog;
    }

    @Override
    public void onClick(View v) {

        Item item = new Item(livro, listenerMenuCompra.getTipoDeCompra(alertView));

        casaDoCodigoStore.getCarrinho().adicionar(item);

        Toast.makeText(activity, item.getLivro().getNomeLivro() + " foi adicionado ao carrinho", Toast.LENGTH_LONG).show();

        alertDialog.cancel();


    }



}
