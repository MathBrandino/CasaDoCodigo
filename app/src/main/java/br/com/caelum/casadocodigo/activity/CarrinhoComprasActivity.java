package br.com.caelum.casadocodigo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import br.com.caelum.casadocodigo.R;
import br.com.caelum.casadocodigo.adapter.CarrinhoAdapter;
import br.com.caelum.casadocodigo.aplication.CasaDoCodigoStore;
import br.com.caelum.casadocodigo.modelo.Item;

/**
 * Created by matheus on 27/07/15.
 */
public class CarrinhoComprasActivity extends AppCompatActivity {

    private List<Item> itens;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.carrinho_de_compras);

        final CasaDoCodigoStore casaDoCodigoStore = (CasaDoCodigoStore) getApplication();

        itens = casaDoCodigoStore.getCarrinho().pegaListaItens();

        ListView listaDeLivrosComprados = (ListView) findViewById(R.id.itens_comprados);

        final CarrinhoAdapter adapter = new CarrinhoAdapter(itens, this);

        listaDeLivrosComprados.setAdapter(adapter);

        listaDeLivrosComprados.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                casaDoCodigoStore.getCarrinho().remove(position);
                adapter.notifyDataSetChanged();
                return false;
            }
        });

    }
}
