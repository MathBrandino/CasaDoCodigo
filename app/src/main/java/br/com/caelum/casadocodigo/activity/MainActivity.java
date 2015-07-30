package br.com.caelum.casadocodigo.activity;

import android.app.Activity;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.casadocodigo.R;
import br.com.caelum.casadocodigo.adapter.LivrosAdapter;
import br.com.caelum.casadocodigo.aplication.CasaDoCodigoStore;
import br.com.caelum.casadocodigo.async.CarregadorCatalogoTask;
import br.com.caelum.casadocodigo.delegate.BuscaLivrosDelegate;
import br.com.caelum.casadocodigo.listener.ListenerCarrinho;
import br.com.caelum.casadocodigo.modelo.Livro;


public class MainActivity extends AppCompatActivity implements BuscaLivrosDelegate {

    private final String LIVROS = "livros";
    private ListView lista ;
    private LivrosAdapter adapter;
    private CarregadorCatalogoTask catalogoTask;
    private List<Livro> livros;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = (ListView) findViewById(R.id.lista_livros);

        buscaDadosServidor();

    }

    private void buscaDadosServidor() {
        catalogoTask = new CarregadorCatalogoTask(this);
        catalogoTask.execute();
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

        adapter = new LivrosAdapter(livros, this);


        lista.setAdapter(adapter);

    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(LIVROS, (Serializable) livros);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        livros = (List<Livro>) savedInstanceState.getSerializable(LIVROS);
    }

    @Override
    public void lidaComErro(Exception e) {
        e.printStackTrace();
        Toast.makeText(this, "Deu erro", Toast.LENGTH_LONG).show();
    }

    @Override
    public Activity retornaActivity() {
        return this;
    }

    @Override
    public CasaDoCodigoStore getCasaDoCodigoStore() {
        return (CasaDoCodigoStore) getApplication();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        getCasaDoCodigoStore().onTerminate();
    }
}
