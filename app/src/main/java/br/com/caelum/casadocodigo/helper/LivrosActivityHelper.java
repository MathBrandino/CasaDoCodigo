package br.com.caelum.casadocodigo.helper;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.List;

import br.com.caelum.casadocodigo.R;
import br.com.caelum.casadocodigo.modelo.Autor;

/**
 * Created by matheus on 30/07/15.
 */
public class LivrosActivityHelper {

    final TextView nomeLivro;
    final TextView nomeAutor;
    final TextView descricaoLivro;
    final Button adicionarCarrinho;
    final ImageView imagemLivro;
    final RadioButton virtual;
    final RadioButton fisico;
    final RadioButton juntos;
    final RadioGroup radioGroup;
    final TextView numeroPaginas;
    final TextView isbn;
    final TextView dataPublicacao;
    private View view;


    public LivrosActivityHelper(View view) {
        this.view = view;

        nomeLivro = (TextView) this.view.findViewById(R.id.nome_livro_detalhe);
        descricaoLivro = (TextView) this.view.findViewById(R.id.desc_livro_detalhes);
        adicionarCarrinho = (Button) this.view.findViewById(R.id.botao_comprar_livro);
        imagemLivro = (ImageView) this.view.findViewById(R.id.imagem_livro_desc);
        virtual = (RadioButton) this.view.findViewById(R.id.valor_virtual);
        fisico = (RadioButton) this.view.findViewById(R.id.valor_fisico);
        juntos = (RadioButton) this.view.findViewById(R.id.valor_juntos);
        nomeAutor = (TextView) this.view.findViewById(R.id.autor_livro);
        radioGroup = (RadioGroup) this.view.findViewById(R.id.radio_group);

        numeroPaginas = (TextView) this.view.findViewById(R.id.livro_num_pag);
        isbn = (TextView) this.view.findViewById(R.id.livro_isbn);
        dataPublicacao = (TextView) this.view.findViewById(R.id.livro_data_publicacao);
    }

    public TextView getNomeLivro() {
        return nomeLivro;
    }

    public TextView getNomeAutor() {
        return nomeAutor;
    }

    public TextView getDescricaoLivro() {
        return descricaoLivro;
    }

    public Button getAdicionarCarrinho() {
        return adicionarCarrinho;
    }

    public ImageView getImagemLivro() {
        return imagemLivro;
    }

    public RadioButton getVirtual() {
        return virtual;
    }

    public RadioButton getFisico() {
        return fisico;
    }

    public RadioButton getJuntos() {
        return juntos;
    }

    public RadioGroup getRadioGroup() {
        return radioGroup;
    }

    public String concatenaAutores(List<Autor> autores) {
        String nomes = "";

        for (int i = 0; i < autores.size(); i++) {
            if (i == autores.size() - 1) {
                nomes += autores.get(i).getNomeAutor();
            } else {
                nomes += autores.get(i).getNomeAutor() + ", ";
            }
        }

        return nomes;
    }

    public TextView getNumeroPaginas() {
        return numeroPaginas;
    }

    public TextView getIsbn() {
        return isbn;
    }

    public TextView getDataPublicacao() {
        return dataPublicacao;
    }
}
