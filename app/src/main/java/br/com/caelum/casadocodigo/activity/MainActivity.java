package br.com.caelum.casadocodigo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.List;

import br.com.caelum.casadocodigo.R;
import br.com.caelum.casadocodigo.adapter.LivrosAdapter;
import br.com.caelum.casadocodigo.aplication.CasaDoCodigoStore;
import br.com.caelum.casadocodigo.async.CarregadorCatalogoTask;
import br.com.caelum.casadocodigo.delegate.BuscaLivrosDelegate;
import br.com.caelum.casadocodigo.listener.ListenerCarrinho;
import br.com.caelum.casadocodigo.modelo.Livro;
import br.com.caelum.casadocodigo.receiver.LivrosRecebidos;


public class MainActivity extends AppCompatActivity implements BuscaLivrosDelegate {

    private ListView lista;
    private LivrosAdapter adapter;
    private List<Livro> livros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        lista = (ListView) findViewById(R.id.lista_livros);

        livros = getCasaDoCodigoStore().getLivros();

        verificaSeJaPossuiLista();

        LivrosRecebidos.registraObservador(this);
    }

    private void verificaSeJaPossuiLista() {

        if (livros == null) {
            buscaDadosServidor();
        } else {
            populaView(livros);
        }
    }

    private void buscaDadosServidor() {
        new CarregadorCatalogoTask(getCasaDoCodigoStore()).execute();
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

        if (id == R.id.carrinho_compras) {
            item.setOnMenuItemClickListener(new ListenerCarrinho(this));
            return true;

        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    public void lidaComRetorno(List<Livro> livros) {

        getCasaDoCodigoStore().setLivros(livros);

        populaView(livros);

    }

    private void populaView(List<Livro> livros) {

        adapter = new LivrosAdapter(livros, this);
        lista.setAdapter(adapter);

    }

    @Override
    public void lidaComErro(Exception e) {

        new AlertDialog.Builder(this)
                .setTitle("Problemas com a conexão")
                .setMessage("Verifique se está conectado na internet e tente novamente ")
                .setIcon(R.drawable.casadocodigo)
                .show();
    }

    @Override
    public Activity retornaActivity() {
        return this;
    }

    @Override
    public CasaDoCodigoStore getCasaDoCodigoStore() {
        return (CasaDoCodigoStore) getApplication();
    }


}
