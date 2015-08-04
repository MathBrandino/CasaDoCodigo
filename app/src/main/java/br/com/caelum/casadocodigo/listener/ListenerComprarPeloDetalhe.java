package br.com.caelum.casadocodigo.listener;

import android.view.View;
import android.widget.Toast;

import br.com.caelum.casadocodigo.aplication.CasaDoCodigoStore;
import br.com.caelum.casadocodigo.fragment.LivroFragment;
import br.com.caelum.casadocodigo.modelo.Item;
import br.com.caelum.casadocodigo.modelo.Livro;

/**
 * Created by matheus on 24/07/15.
 */
public class ListenerComprarPeloDetalhe implements View.OnClickListener {

    private LivroFragment fragment;
    private Livro livro;
    private CasaDoCodigoStore casaDoCodigoStore;

    public ListenerComprarPeloDetalhe(LivroFragment fragment, Livro livro) {
        this.fragment = fragment;
        this.livro = livro;
        casaDoCodigoStore = (CasaDoCodigoStore) fragment.getActivity().getApplication();

    }


    @Override
    public void onClick(View view) {
        Item item = new Item(livro, fragment.getTipoDeCompra());
        casaDoCodigoStore.getCarrinho().adicionar(item);

        Toast.makeText(fragment.getActivity(), item.getLivro().getNomeLivro() + " adicionado ao carrinho", Toast.LENGTH_LONG).show();

    }

}
