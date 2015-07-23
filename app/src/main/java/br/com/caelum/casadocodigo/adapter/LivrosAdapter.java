package br.com.caelum.casadocodigo.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.caelum.casadocodigo.R;
import br.com.caelum.casadocodigo.activity.LivroActivity;
import br.com.caelum.casadocodigo.modelo.Livro;

/**
 * Created by matheus on 22/07/15.
 */
public class LivrosAdapter extends BaseAdapter {

    private List<Livro> livros;
    private Activity activity;

    public LivrosAdapter(List<Livro> livros, Activity activity) {

        this.livros = livros;
        this.activity = activity;

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
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        if(position % 2 == 0){
            view = View.inflate(activity, R.layout.livro_item, null);
        }else {
            view = View.inflate(activity, R.layout.livro_item_impar, null);
        }

        final Livro livro = (Livro) getItem(position);

        ImageView imageView = (ImageView) view.findViewById(R.id.imagem_livro);
        if(position % 2 == 0){
            imageView.setImageResource(R.drawable.games_android_featured_large);
        }else {
            imageView.setImageResource(R.drawable.plsql_featured_large);
        }
        TextView nomeLivro = (TextView) view.findViewById(R.id.nome_livro);
        TextView descLivro = (TextView) view.findViewById(R.id.desc_livro);

        nomeLivro.setText(livro.getNomeLivro());
        descLivro.setText(livro.getDescricaoLivro());

        Button comprar = (Button) view.findViewById(R.id.botao_comprar);
        comprar.setText("Comprar");

        comprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(activity).setMessage("Voce comprou : " + livro.getNomeLivro()).show();
            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mostraLivro = new Intent(activity, LivroActivity.class);
                mostraLivro.putExtra("livro", livro);
                activity.startActivity(mostraLivro);
            }
        });

        return view;
    }
}
