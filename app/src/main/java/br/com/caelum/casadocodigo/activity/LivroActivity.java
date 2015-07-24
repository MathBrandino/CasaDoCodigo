package br.com.caelum.casadocodigo.activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.casadocodigo.R;
import br.com.caelum.casadocodigo.adapter.LivrosAdapter;
import br.com.caelum.casadocodigo.listener.ListenerComprar;
import br.com.caelum.casadocodigo.modelo.Livro;


public class LivroActivity extends AppCompatActivity {

    private Livro livro;

    private class ViewHolder {

        final TextView nomeLivro;
        final TextView descricaoLivro;
        final Button adicionarCarrinho;
        final ImageView imagemLivro;
        final RadioButton virtual;
        final RadioButton fisico;
        final RadioButton juntos;

        public ViewHolder(){

            nomeLivro = (TextView) findViewById(R.id.nome_livro_detalhe);
            descricaoLivro = (TextView) findViewById(R.id.desc_livro_detalhes);
            adicionarCarrinho = (Button) findViewById(R.id.botao_comprar_livro);
            imagemLivro = (ImageView) findViewById(R.id.imagem_livro_desc);
            virtual = (RadioButton) findViewById(R.id.valor_virtual);
            fisico = (RadioButton) findViewById(R.id.valor_fisico);
            juntos = (RadioButton) findViewById(R.id.valor_juntos);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_livro);

        Intent pegaLivro = getIntent();

        ViewHolder holder = new ViewHolder();

        if (pegaLivro.hasExtra("livro")){
            livro = (Livro) pegaLivro.getSerializableExtra("livro");
        }

        ImageView imageView = holder.imagemLivro;
        Picasso.with(this).load(Uri.parse(livro.getImagemUrl())).into(imageView);

        TextView nomeLivro = holder.nomeLivro;
        nomeLivro.setText(livro.getNomeLivro());

        TextView descricaoLivro = holder.descricaoLivro;
        descricaoLivro.setText(livro.getDescricaoLivro());

        RadioButton virtual = holder.virtual;
        virtual.setText("Virtual : R$ "+ livro.getValorVirtual());

        RadioButton fisico = holder.fisico;
        fisico.setText("Fisico : R$ "+livro.getValorFisico());

        RadioButton juntos = holder.juntos;
        juntos.setText("Juntos : R$ "+ livro.getValorDoisJuntos());

        Button comprar = holder.adicionarCarrinho;

        comprar.setOnClickListener(new ListenerComprar(LivroActivity.this));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
