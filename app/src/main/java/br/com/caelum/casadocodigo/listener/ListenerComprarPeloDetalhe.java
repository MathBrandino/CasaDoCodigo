package br.com.caelum.casadocodigo.listener;

import android.view.View;
import android.widget.Toast;

import br.com.caelum.casadocodigo.activity.LivroActivity;
import br.com.caelum.casadocodigo.aplication.CasaDoCodigoStore;
import br.com.caelum.casadocodigo.modelo.Item;
import br.com.caelum.casadocodigo.modelo.Livro;

/**
 * Created by matheus on 24/07/15.
 */
public class ListenerComprarPeloDetalhe implements View.OnClickListener {

    private LivroActivity activity;
    private Livro livro;
    private CasaDoCodigoStore casaDoCodigoStore;

    public ListenerComprarPeloDetalhe(LivroActivity activity, Livro livro) {
        this.activity = activity;
        this.livro = livro;
        casaDoCodigoStore = (CasaDoCodigoStore) activity.getApplication();

    }



    @Override
    public void onClick(View view) {

        Item item = new Item(livro, activity.getTipoDeCompra());
        casaDoCodigoStore.getCarrinho().adicionar(item);

        Toast.makeText(activity, item.getLivro().getNomeLivro() + " adicionado ao carrinho", Toast.LENGTH_LONG).show();

    }

}
