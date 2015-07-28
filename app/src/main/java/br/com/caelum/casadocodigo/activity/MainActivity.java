package br.com.caelum.casadocodigo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.List;

import br.com.caelum.casadocodigo.R;
import br.com.caelum.casadocodigo.async.CarregadorCatalogoTask;
import br.com.caelum.casadocodigo.listener.ListenerCarrinho;
import br.com.caelum.casadocodigo.modelo.Livro;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lista = (ListView) findViewById(R.id.lista_livros);

        CarregadorCatalogoTask myAsync = new CarregadorCatalogoTask(this, lista);
        myAsync.execute();


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

}
