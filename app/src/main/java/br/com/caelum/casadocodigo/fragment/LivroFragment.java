package br.com.caelum.casadocodigo.fragment;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import br.com.caelum.casadocodigo.R;
import br.com.caelum.casadocodigo.activity.EstadoTela;
import br.com.caelum.casadocodigo.activity.MainActivity;
import br.com.caelum.casadocodigo.activity.TipoDeCompra;
import br.com.caelum.casadocodigo.aplication.CasaDoCodigoStore;
import br.com.caelum.casadocodigo.helper.LivrosActivityHelper;
import br.com.caelum.casadocodigo.listener.ListenerComprarPeloDetalhe;
import br.com.caelum.casadocodigo.modelo.Livro;

/**
 * Created by matheus on 04/08/15.
 */

public class LivroFragment extends Fragment {

    private final String LIVRO = "livro";
    private LivrosActivityHelper helper;
    private Livro livro;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        CasaDoCodigoStore casaDoCodigoStore = (CasaDoCodigoStore) getActivity().getApplication();

        View view = inflater.inflate(R.layout.fragment_livro, container, false);

        helper = new LivrosActivityHelper(view);

        casaDoCodigoStore.setEstadoTela(EstadoTela.LIVRO);

        livro = casaDoCodigoStore.getLivroSelecionado();

        populaDetalhes(helper);
        populaFormaPagmento(helper);
        populaLivro(helper);

        return view;
    }


    private void populaDetalhes(LivrosActivityHelper helper) {

        TextView numeroPaginas = helper.getNumeroPaginas();
        numeroPaginas.setText(String.valueOf(livro.getNumPaginas()));

        TextView isbn = helper.getIsbn();
        isbn.setText(livro.getISBN());

        TextView dataPublicacao = helper.getDataPublicacao();
        dataPublicacao.setText(livro.getDataPublicacao());
    }

    private void populaLivro(LivrosActivityHelper helper) {
        ImageView imagemLivro = helper.getImagemLivro();

        if (livro.getImagemUrl() != null) {
            Picasso.with(getActivity()).load(Uri.parse(livro.getImagemUrl())).into(imagemLivro);
        }

        TextView nomeLivro = helper.getNomeLivro();
        nomeLivro.setText(livro.getNome());

        TextView autorLivro = helper.getNomeAutor();

        String nomes = helper.concatenaAutores(livro.getAutores());

        autorLivro.setText(nomes);

        autorLivro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                CasaDoCodigoStore casaDoCodigoStore = (CasaDoCodigoStore) getActivity().getApplication();
                casaDoCodigoStore.setEstadoTela(EstadoTela.AUTOR);
                casaDoCodigoStore.getEstadoTela().executa((MainActivity) getActivity());


            }
        });
        TextView descricaoLivro = helper.getDescricaoLivro();
        descricaoLivro.setText(livro.getDescricao());
    }


    private void populaFormaPagmento(LivrosActivityHelper helper) {

        RadioButton virtual = helper.getVirtual();
        virtual.setText("Virtual : R$ " + livro.getValorVirtual());

        RadioButton fisico = helper.getFisico();
        fisico.setText("Fisico : R$ " + livro.getValorFisico());

        RadioButton juntos = helper.getJuntos();
        juntos.setText("Juntos : R$ " + livro.getValorDoisJuntos());
        juntos.toggle();

        Button comprar = helper.getAdicionarCarrinho();

        comprar.setOnClickListener(new ListenerComprarPeloDetalhe(this, livro));
    }

    public TipoDeCompra getTipoDeCompra() {

        TipoDeCompra tipoDeCompra = null;


        RadioGroup radioGroup = helper.getRadioGroup();

        tipoDeCompra = devolveTipoDeCompra(radioGroup);

        return tipoDeCompra;

    }

    ;

    private TipoDeCompra devolveTipoDeCompra(RadioGroup radioGroup) {
        TipoDeCompra tipoDeCompra;

        switch (radioGroup.getCheckedRadioButtonId()) {

            case (R.id.valor_virtual):
                tipoDeCompra = TipoDeCompra.VIRTUAL;
                return tipoDeCompra;

            case (R.id.valor_fisico):
                tipoDeCompra = TipoDeCompra.FISICO;
                return tipoDeCompra;

            case (R.id.valor_juntos):
                tipoDeCompra = TipoDeCompra.JUNTOS;
                return tipoDeCompra;

            default:
                return null;
        }
    }

}
