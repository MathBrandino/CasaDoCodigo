package br.com.caelum.casadocodigo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.List;

import br.com.caelum.casadocodigo.R;
import br.com.caelum.casadocodigo.adapter.ListaDeLivrosAdapter;
import br.com.caelum.casadocodigo.aplication.CasaDoCodigoStore;
import br.com.caelum.casadocodigo.async.CarregadorCatalogoTask;
import br.com.caelum.casadocodigo.delegate.BuscaLivrosDelegate;
import br.com.caelum.casadocodigo.fragment.MainFragment;
import br.com.caelum.casadocodigo.fragment.ProgressFragment;
import br.com.caelum.casadocodigo.listener.ListenerCarrinho;
import br.com.caelum.casadocodigo.modelo.Livro;
import br.com.caelum.casadocodigo.receiver.LivrosRecebidos;


public class MainActivity extends AppCompatActivity implements BuscaLivrosDelegate, NavigationView.OnNavigationItemSelectedListener {

    private final String ESTADO = "ESTADO";
    private ListaDeLivrosAdapter adapter;
    private List<Livro> livros;
    private CasaDoCodigoStore casaDoCodigoStore;
    private NavigationView navigationView;
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        casaDoCodigoStore = getCasaDoCodigoStore();

        bundle = new Bundle();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        livros = getCasaDoCodigoStore().getLivros();

        navigationView = (NavigationView) findViewById(R.id.drawer);

        navigationView.setNavigationItemSelectedListener(this);

        LivrosRecebidos.registraObservador(this);

        verificaEstado();

    }

    private void verificaEstado() {
        if(livros == null) {
            casaDoCodigoStore.setEstadoTela(EstadoTela.INICIO);
        } else {
            casaDoCodigoStore.setEstadoTela(EstadoTela.LISTA_LIVROS);
        }
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(ESTADO, casaDoCodigoStore.getEstadoTela());
    }

    @Override
    protected void onResume() {
        super.onResume();
        casaDoCodigoStore.getEstadoTela().executa(this);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        casaDoCodigoStore.setEstadoTela((EstadoTela) savedInstanceState.getSerializable(ESTADO));
    }

    public void buscaDadosServidor() {
        CarregadorCatalogoTask task = new CarregadorCatalogoTask((CasaDoCodigoStore) getApplicationContext());
        task.execute();
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

        switch (id) {

            case (R.id.carrinho_compras):
                item.setOnMenuItemClickListener(new ListenerCarrinho(this));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void lidaComRetorno(List<Livro> livros) {

        getCasaDoCodigoStore().setLivros(livros);

        casaDoCodigoStore.setEstadoTela(EstadoTela.LISTA_LIVROS);
        casaDoCodigoStore.getEstadoTela().executa(this);
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


    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {

        switch (menuItem.getItemId()) {
            case R.id.java_menu:
                Toast.makeText(this, "Livros de java", Toast.LENGTH_LONG).show();
                return true;

            case R.id.carrinho_menu:
                menuItem.setOnMenuItemClickListener(new ListenerCarrinho(this));
                return true;

            case R.id.web_menu:
                Toast.makeText(this, "Livros de web", Toast.LENGTH_LONG).show();
                return true;

            case R.id.front_menu:
                Toast.makeText(this, "Livros de front", Toast.LENGTH_LONG).show();
                return true;

            case R.id.games_menu:
                Toast.makeText(this, "Livros de game", Toast.LENGTH_LONG).show();
                return true;

            case R.id.outros_menu:
                Toast.makeText(this, "Livros diversos", Toast.LENGTH_LONG).show();
                return true;

            case R.id.agile_menu:
                Toast.makeText(this, "Livros de agile", Toast.LENGTH_LONG).show();
                return true;
        }

        return false;
    }
}
