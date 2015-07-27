package br.com.caelum.casadocodigo.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

import br.com.caelum.casadocodigo.R;
import br.com.caelum.casadocodigo.modelo.Autor;

/**
 * Created by matheus on 27/07/15.
 */
public class LivroAutorAdapter extends BaseAdapter {

    private List<Autor> autores;
    private Activity activity;

    public LivroAutorAdapter(List<Autor> autores, Activity activity) {
        this.autores = autores;
        this.activity = activity;
    }

    public class ViewHolder{

        ImageView fotoAutor;
        TextView nomeAutor;
        TextView descricaoAutor;

        public ViewHolder(View view) {

            fotoAutor = (ImageView) view.findViewById(R.id.foto_autor_livro);
            nomeAutor = (TextView) view.findViewById(R.id.nome_autor_livro);
            descricaoAutor = (TextView) view.findViewById(R.id.detalhes_autor_livro);
        }
    }

    @Override
    public int getCount() {
        return autores.size();
    }

    @Override
    public Object getItem(int position) {
        return autores.get(position);
    }

    @Override
    public long getItemId(int position) {
        return autores.get(position).getIdAutor();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view;
        if (convertView != null) {
            view = convertView;
        } else {

            view = activity.getLayoutInflater().inflate(R.layout.listagem_autor_livro, parent, false);

        }


        ViewHolder holder = new ViewHolder(view);

        populaAutor(position, holder);

        return view;
    }

    private void populaAutor(int position, ViewHolder holder) {

        ImageView autorImagem = holder.fotoAutor;
        TextView nomeAutor = holder.nomeAutor;
        TextView descricaoAutor  = holder.descricaoAutor;

        if (autores.get(position).getImagemAutorUrl() != null){
            Picasso.with(activity).load(autores.get(position).getImagemAutorUrl()).into(autorImagem);
        }

        nomeAutor.setText(autores.get(position).getNomeAutor());
        descricaoAutor.setText(autores.get(position).getDetalhesAutor());
    }

}
