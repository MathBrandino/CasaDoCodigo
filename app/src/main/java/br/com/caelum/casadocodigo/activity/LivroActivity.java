package br.com.caelum.casadocodigo.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import br.com.caelum.casadocodigo.R;
import br.com.caelum.casadocodigo.helper.LivrosActivityHelper;
import br.com.caelum.casadocodigo.listener.ListenerCarrinho;
import br.com.caelum.casadocodigo.listener.ListenerComprarPeloDetalhe;
import br.com.caelum.casadocodigo.modelo.Livro;


public class LivroActivity extends AppCompatActivity {

    private final String LIVRO = "livro";
    private Livro livro;
    private LivrosActivityHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_livro);

        Intent pegaLivro = getIntent();

        helper = new LivrosActivityHelper(this);


        if (pegaLivro.hasExtra("livro")){
            livro = (Livro) pegaLivro.getSerializableExtra("livro");
        }

        populaLivro(helper);

        populaFormaPagmento(helper);

    }

    private void populaLivro(LivrosActivityHelper helper) {
        ImageView imagemLivro = helper.getImagemLivro();

        if(livro.getImagemUrl() != null) {
            Picasso.with(this).load(Uri.parse(livro.getImagemUrl())).into(imagemLivro);
        }

        TextView nomeLivro = helper.getNomeLivro();
        nomeLivro.setText(livro.getNomeLivro());

        TextView autorLivro = helper.getNomeAutor();

        String nomes = "";

        for (int i = 0; i < livro.getAutores().size(); i++) {

            nomes = populaAutores(nomes, i);

        }
        autorLivro.setText(nomes);

        autorLivro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mostraAutores = new Intent(LivroActivity.this, AutorActivity.class);
                mostraAutores.putExtra(LIVRO, livro);
                startActivity(mostraAutores);
            }
        });
        TextView descricaoLivro = helper.getDescricaoLivro();
        descricaoLivro.setText(livro.getDescricaoLivro());
    }

    private String populaAutores(String nomes, int i) {
        if (i  == livro.getAutores().size() -1 ){
            nomes += livro.getAutores().get(i).getNomeAutor() ;
        }else  {
            nomes += livro.getAutores().get(i).getNomeAutor() + ", ";

        }
        return nomes;
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

        comprar.setOnClickListener(new ListenerComprarPeloDetalhe(LivroActivity.this, livro));
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

        switch (id){

            case (R.id.carrinho_compras) :
                item.setOnMenuItemClickListener(new ListenerCarrinho(this));
                return true;

        }
        return super.onOptionsItemSelected(item);
    }

    public TipoDeCompra getTipoDeCompra(){

        TipoDeCompra tipoDeCompra = null;


        RadioGroup radioGroup = helper.getRadioGroup();

        tipoDeCompra = devolveTipoDeCompra(radioGroup);

        return tipoDeCompra;

    };

    private TipoDeCompra devolveTipoDeCompra(RadioGroup radioGroup){
        TipoDeCompra tipoDeCompra;

        switch (radioGroup.getCheckedRadioButtonId()){

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
