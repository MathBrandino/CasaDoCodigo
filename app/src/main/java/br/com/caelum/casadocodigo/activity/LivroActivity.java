package br.com.caelum.casadocodigo.activity;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.casadocodigo.R;
import br.com.caelum.casadocodigo.adapter.LivrosAdapter;
import br.com.caelum.casadocodigo.modelo.Livro;


public class LivroActivity extends AppCompatActivity {

    private Livro livro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_livro);

        Intent pegaLivro = getIntent();

        if (pegaLivro.hasExtra("livro")){
            livro = (Livro) pegaLivro.getSerializableExtra("livro");
        }

        ImageView imageView = (ImageView) findViewById(R.id.imagem_livro_desc);
        imageView.setImageResource(R.drawable.games_android_featured_large);

        TextView nomeLivro = (TextView) findViewById(R.id.nome_livro_detalhe);
        nomeLivro.setText(livro.getNomeLivro());

        TextView descricaoLivro = (TextView) findViewById(R.id.desc_livro_detalhes);
        descricaoLivro.setText(livro.getDescricaoLivro());

        RadioButton virtual = (RadioButton) findViewById(R.id.valor_virtual);
        virtual.setText("Virtual : R$ "+ livro.getValorVirtual());

        RadioButton fisico = (RadioButton) findViewById(R.id.valor_fisico);
        fisico.setText("Fisico : R$ "+livro.getValorFisico());

        RadioButton juntos = (RadioButton) findViewById(R.id.valor_juntos);
        juntos.setText("Juntos : R$ "+ livro.getValorDoisJuntos());

        Button comprar = (Button) findViewById(R.id.botao_comprar_livro);
        comprar.setText("Comprar");

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
