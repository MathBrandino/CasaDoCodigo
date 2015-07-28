package br.com.caelum.casadocodigo.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

import br.com.caelum.casadocodigo.R;
import br.com.caelum.casadocodigo.modelo.Carrinho;
import br.com.caelum.casadocodigo.modelo.Item;
import br.com.caelum.casadocodigo.modelo.Livro;

/**
 * Created by matheus on 27/07/15.
 */
public class CarrinhoAdapter extends BaseAdapter {

    private List<Item> itens;
    private Activity activity;

    public CarrinhoAdapter(List<Item> itens, Activity activity) {
        this.itens = itens;
        this.activity = activity;
    }

    private class ViewHolder{
        ImageView imagemLivro;
        TextView nomeLivro;
        TextView valorLivro;

        public ViewHolder(View view) {

            imagemLivro = (ImageView) view.findViewById(R.id.foto_livro_compra);
            nomeLivro = (TextView) view.findViewById(R.id.nome_livro_compra);
            valorLivro = (TextView) view.findViewById(R.id.mostra_valor_livro);
        }
    }

    @Override
    public int getCount() {
        return itens.size();
    }

    @Override
    public Object getItem(int position) {
        return itens.get(position).getLivro();
    }

    @Override
    public long getItemId(int position) {
        return itens.get(position).getLivro().getId();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        View view = criaView(convertView);

        Livro livro = (Livro) getItem(position);

        ViewHolder holder = (ViewHolder) view.getTag();

        populaView(position, livro, holder);

        return view;
    }

    private View criaView(View convertView) {
        View view;


        if (convertView != null){
            view = convertView;
        }else {
            view = View.inflate(activity, R.layout.item_carrinho,null);
            ViewHolder viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        }
        return view;
    }

    private void populaView(int position, Livro livro, ViewHolder holder) {
        populaImagem(livro, holder);
        populaNomeLivro(livro, holder);
        popularValorLivro(position, livro, holder);
    }

    private void popularValorLivro(int position, Livro livro, ViewHolder holder) {
        TextView valorLivro = holder.valorLivro;
        String valor = verificaTipo(position,livro);
        valorLivro.setText(valor);
    }


    private void populaNomeLivro(Livro livro, ViewHolder holder) {
        TextView nomeLivro = holder.nomeLivro;
        nomeLivro.setText(livro.getNomeLivro());
    }

    private void populaImagem(Livro livro, ViewHolder holder) {
        ImageView fotoLivro = holder.imagemLivro;
        if (livro.getImagemUrl() != null){
            Picasso.with(activity).load(livro.getImagemUrl()).into(fotoLivro);
        }
    }


    public String verificaTipo(int position, Livro livro){

        String valor = "R$ ";
        switch (itens.get(position).getTipoDeCompra()){

            case VIRTUAL:
                valor += String.valueOf(livro.getValorVirtual());

                return valor;
            case FISICO:
                valor += String.valueOf(livro.getValorFisico());

                return valor;
            case JUNTOS:
                valor += String.valueOf(livro.getValorDoisJuntos());

                return valor;
            default:
                return null;
        }
    }
}
