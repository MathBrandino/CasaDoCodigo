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
import br.com.caelum.casadocodigo.TipoDeCompra;
import br.com.caelum.casadocodigo.listener.ListenerCarrinho;
import br.com.caelum.casadocodigo.listener.ListenerComprarPeloDetalhe;
import br.com.caelum.casadocodigo.modelo.Livro;


public class LivroActivity extends AppCompatActivity {

    private final String LIVRO = "livro";
    private Livro livro;

    private class ViewHolder {

        final TextView nomeLivro;
        final TextView nomeAutor;
        final TextView descricaoLivro;
        final Button adicionarCarrinho;
        final ImageView imagemLivro;
        final RadioButton virtual;
        final RadioButton fisico;
        final RadioButton juntos;
        final RadioGroup radioGroup;

        public ViewHolder(){

            nomeLivro = (TextView) findViewById(R.id.nome_livro_detalhe);
            descricaoLivro = (TextView) findViewById(R.id.desc_livro_detalhes);
            adicionarCarrinho = (Button) findViewById(R.id.botao_comprar_livro);
            imagemLivro = (ImageView) findViewById(R.id.imagem_livro_desc);
            virtual = (RadioButton) findViewById(R.id.valor_virtual);
            fisico = (RadioButton) findViewById(R.id.valor_fisico);
            juntos = (RadioButton) findViewById(R.id.valor_juntos);
            nomeAutor = (TextView) findViewById(R.id.autor_livro);
            radioGroup = (RadioGroup) findViewById(R.id.radio_group);

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

        populaLivro(holder);

        populaFormaPagmento(holder);





    }


    private void populaLivro(ViewHolder holder) {
        ImageView imagemLivro = holder.imagemLivro;

        if(livro.getImagemUrl() != null) {
            Picasso.with(this).load(Uri.parse(livro.getImagemUrl())).into(imagemLivro);
        }

        TextView nomeLivro = holder.nomeLivro;
        nomeLivro.setText(livro.getNomeLivro());

        TextView autorLivro = holder.nomeAutor;

        String nomes = "";

        for (int i = 0; i < livro.getAutores().size(); i++) {

            if (i  == livro.getAutores().size() -1 ){
                nomes += livro.getAutores().get(i).getNomeAutor() ;
            }else  {
                nomes += livro.getAutores().get(i).getNomeAutor() + ", ";

            }



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
        TextView descricaoLivro = holder.descricaoLivro;
        descricaoLivro.setText(livro.getDescricaoLivro());
    }

    private void populaFormaPagmento(ViewHolder holder) {



        RadioButton virtual = holder.virtual;
        virtual.setText("Virtual : R$ " + livro.getValorVirtual());

        RadioButton fisico = holder.fisico;
        fisico.setText("Fisico : R$ " + livro.getValorFisico());

        RadioButton juntos = holder.juntos;
        juntos.setText("Juntos : R$ " + livro.getValorDoisJuntos());
        juntos.toggle();


        Button comprar = holder.adicionarCarrinho;



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

        ViewHolder holder = new ViewHolder();


        RadioGroup radioGroup = holder.radioGroup;

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
