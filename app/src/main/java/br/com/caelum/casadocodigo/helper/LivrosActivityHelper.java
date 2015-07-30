package br.com.caelum.casadocodigo.helper;

import android.app.Activity;
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

    private Activity activity;

    final TextView nomeLivro;
    final TextView nomeAutor;
    final TextView descricaoLivro;
    final Button adicionarCarrinho;
    final ImageView imagemLivro;
    final RadioButton virtual;
    final RadioButton fisico;
    final RadioButton juntos;
    final RadioGroup radioGroup;


    public LivrosActivityHelper(Activity activity) {
        this.activity = activity;

        nomeLivro = (TextView) activity.findViewById(R.id.nome_livro_detalhe);
        descricaoLivro = (TextView) activity.findViewById(R.id.desc_livro_detalhes);
        adicionarCarrinho = (Button) activity.findViewById(R.id.botao_comprar_livro);
        imagemLivro = (ImageView) activity.findViewById(R.id.imagem_livro_desc);
        virtual = (RadioButton) activity.findViewById(R.id.valor_virtual);
        fisico = (RadioButton) activity.findViewById(R.id.valor_fisico);
        juntos = (RadioButton) activity.findViewById(R.id.valor_juntos);
        nomeAutor = (TextView) activity.findViewById(R.id.autor_livro);
        radioGroup = (RadioGroup) activity.findViewById(R.id.radio_group);

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

    public String concatenaAutores(List<Autor> autores){
        String nomes = "";

        for (int i = 0; i < autores.size() ; i++) {
            if (i  == autores.size() -1 ){
                nomes += autores.get(i).getNomeAutor() ;
            }else  {
                nomes += autores.get(i).getNomeAutor() + ", ";
            }
        }

        return nomes;
    }
}
