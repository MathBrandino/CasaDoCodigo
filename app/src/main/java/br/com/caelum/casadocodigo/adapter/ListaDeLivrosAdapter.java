package br.com.caelum.casadocodigo.adapter;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import br.com.caelum.casadocodigo.R;
import br.com.caelum.casadocodigo.activity.LivroActivity;
import br.com.caelum.casadocodigo.activity.MainActivity;
import br.com.caelum.casadocodigo.listener.ListenerMenuCompra;
import br.com.caelum.casadocodigo.modelo.Livro;

/**
 * Created by matheus on 22/07/15.
 */
public class ListaDeLivrosAdapter extends BaseAdapter {

    private final String LIVRO = "livro";
    private List<Livro> livros;
    private MainActivity activity;

    public ListaDeLivrosAdapter(List<Livro> livros, MainActivity activity) {

        this.livros = livros;
        this.activity = activity;

    }


    private class ViewHolder {

        final TextView nomeLivro;
        final TextView descricaoLivro;
        final Button adicionarCarrinho;
        final ImageView imagemLivro;


        public ViewHolder(View view) {

            nomeLivro = (TextView) view.findViewById(R.id.nome_livro);
            descricaoLivro = (TextView) view.findViewById(R.id.desc_livro);
            adicionarCarrinho = (Button) view.findViewById(R.id.botao_comprar);
            imagemLivro = (ImageView) view.findViewById(R.id.imagem_livro);


        }


    }

    @Override
    public int getCount() {
        return livros.size();
    }

    @Override
    public Object getItem(int position) {
        return livros.get(position);
    }

    @Override
    public long getItemId(int position) {
        return livros.get(position).getId();
    }


    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        return position % 2;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = criaView(position, convertView);


        final Livro livro = (Livro) getItem(position);

        populaView(view, livro);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mostraLivro = new Intent(activity, LivroActivity.class);
                mostraLivro.putExtra(LIVRO, livro);
                activity.startActivity(mostraLivro);
            }
        });

        return view;
    }

    private void populaView(View view, final Livro livro) {
        ViewHolder holder = (ViewHolder) view.getTag();

        ImageView imagemLivro = holder.imagemLivro;
        TextView nomeLivro = holder.nomeLivro;
        TextView descricaoLivro = holder.descricaoLivro;
        Button adicionarCarrinho = holder.adicionarCarrinho;

        if (livro.getImagemUrl() != null) {

            Picasso.with(activity).
                    load(livro.getImagemUrl()).
                    into(imagemLivro);
        }

        nomeLivro.setText(livro.getNomeLivro());
        descricaoLivro.setText(livro.getDescricaoLivro());

        adicionarCarrinho.setText(view.getResources().getString(R.string.comprar));

        adicionarCarrinho.setOnClickListener(new ListenerMenuCompra(activity, livro));

    }

    private View criaView(int position, View convertView) {
        View view;
        ViewHolder holder;


        if (convertView != null) {
            view = convertView;
        } else {
            if (position % 2 == 0) {
                view = View.inflate(activity, R.layout.livro_item, null);
            } else {
                view = View.inflate(activity, R.layout.livro_item_impar, null);
            }
            holder = new ViewHolder(view);
            view.setTag(holder);
        }
        return view;
    }
}
