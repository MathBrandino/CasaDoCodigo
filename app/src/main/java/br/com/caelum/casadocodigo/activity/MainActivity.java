package br.com.caelum.casadocodigo.activity;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

import br.com.caelum.casadocodigo.R;
import br.com.caelum.casadocodigo.aplication.CasaDoCodigoStore;
import br.com.caelum.casadocodigo.async.CarregadorCatalogoTask;
import br.com.caelum.casadocodigo.delegate.BuscaLivrosDelegate;
import br.com.caelum.casadocodigo.listener.ListenerCarrinho;
import br.com.caelum.casadocodigo.listener.ListenerNavigationView;
import br.com.caelum.casadocodigo.modelo.Livro;
import br.com.caelum.casadocodigo.receiver.LivrosRecebidos;


public class MainActivity extends AppCompatActivity implements BuscaLivrosDelegate {

    private final String ESTADO = "ESTADO";
    private List<Livro> livros;
    private CasaDoCodigoStore casaDoCodigoStore;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        casaDoCodigoStore = getCasaDoCodigoStore();


        criaActionBar();

        livros = getCasaDoCodigoStore().getLivros();

        criaNavigationView();

        LivrosRecebidos.registraObservador(this);

        verificaEstado();

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putSerializable(ESTADO, casaDoCodigoStore.getEstadoTela());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        recuperaEstadoColocandoNaTela((EstadoTela) savedInstanceState.getSerializable(ESTADO));
    }

    private void recuperaEstadoColocandoNaTela(EstadoTela estadoTela) {
        casaDoCodigoStore.setEstadoTela(estadoTela);
        casaDoCodigoStore.getEstadoTela().executa(this);
    }

    private void criaNavigationView() {
        navigationView = (NavigationView) findViewById(R.id.drawer);
        navigationView.setNavigationItemSelectedListener(new ListenerNavigationView(this));
    }

    private void criaActionBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    private void verificaEstado() {
        if (livros == null) {
            recuperaEstadoColocandoNaTela(EstadoTela.INICIO);

        } else {
            recuperaEstadoColocandoNaTela(EstadoTela.LISTA_LIVROS);
        }
    }

    public void buscaDadosServidor() {
        CarregadorCatalogoTask task = new CarregadorCatalogoTask((CasaDoCodigoStore) getApplicationContext());
        task.execute(1);
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

        recuperaEstadoColocandoNaTela(EstadoTela.LISTA_LIVROS);
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
    public CasaDoCodigoStore getCasaDoCodigoStore() {
        return (CasaDoCodigoStore) getApplication();
    }
}
