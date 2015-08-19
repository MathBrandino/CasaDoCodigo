package br.com.caelum.casadocodigo.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;

import br.com.caelum.casadocodigo.R;
import br.com.caelum.casadocodigo.adapter.CarrinhoAdapter;
import br.com.caelum.casadocodigo.aplication.CasaDoCodigoStore;
import br.com.caelum.casadocodigo.async.EnviaJsonTask;
import br.com.caelum.casadocodigo.converter.LivroConverter;
import br.com.caelum.casadocodigo.helper.EmailCompraHelper;
import br.com.caelum.casadocodigo.modelo.Item;

/**
 * Created by matheus on 27/07/15.
 */
public class CarrinhoComprasActivity extends AppCompatActivity {

    private List<Item> itens;
    private CasaDoCodigoStore casaDoCodigoStore;
    private CarrinhoAdapter adapter;
    private String emailParaJson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.carrinho_de_compras);

        Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar_carrinho);
        setSupportActionBar(toolbar);

        casaDoCodigoStore = (CasaDoCodigoStore) getApplication();

        itens = casaDoCodigoStore.getCarrinho().pegaListaItens();

        populaCarrinho(casaDoCodigoStore);

        atualizaValorCompra();

    }

    private void atualizaValorCompra() {
        double valorCompra = casaDoCodigoStore.getSaldo(itens);

        TextView valorCompras = (TextView) findViewById(R.id.valor_lista_compra);

        valorCompras.setText("O valor da compra é : R$ " + valorCompra);
    }


    private void populaCarrinho(final CasaDoCodigoStore casaDoCodigoStore) {
        ListView listaDeLivrosComprados = (ListView) findViewById(R.id.itens_comprados);

        adapter = new CarrinhoAdapter(itens, this);

        listaDeLivrosComprados.setAdapter(adapter);

        chamaListenerParaRemocaoDeLivro(casaDoCodigoStore, listaDeLivrosComprados, adapter);
    }

    private void chamaListenerParaRemocaoDeLivro(final CasaDoCodigoStore casaDoCodigoStore, ListView listaDeLivrosComprados, final CarrinhoAdapter adapter) {
        listaDeLivrosComprados.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {

                alertaRemocaoLivro(position, casaDoCodigoStore);

                return false;
            }
        });
    }

    private void alertaRemocaoLivro(final int position, final CasaDoCodigoStore casaDoCodigoStore) {

        new AlertDialog.Builder(CarrinhoComprasActivity.this)
                .setMessage("Deseja remover ? ")
                .setPositiveButton("Desejo !", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        casaDoCodigoStore.getCarrinho().remove(position);
                        atualizaListas();
                    }
                })
                .setNegativeButton("Não !", null).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_carrinho, menu);


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.menu_carrinho_finaliza) {
            item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {

                    iniciaCompra();

                    return true;
                }
            });
        }
        return super.onOptionsItemSelected(item);
    }

    private void iniciaCompra() {
        if (itens.size() > 0) {
            iniciaFechamentoCompra();
        } else {
            Toast.makeText(CarrinhoComprasActivity.this, "Você ainda não comprou nada :( ", Toast.LENGTH_LONG).show();
        }
    }

    private void iniciaFechamentoCompra() {

        new AlertDialog.Builder(CarrinhoComprasActivity.this)
                .setTitle("Finalizar Compra ?")
                .setMessage("Sua compra possui " + itens.size() + " livros e o valor é : R$ " + casaDoCodigoStore.getSaldo(itens) + "0")
                .setPositiveButton("Sim ! ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        View emailView = View.inflate(CarrinhoComprasActivity.this, R.layout.email_compra, null);
                        EmailCompraHelper helper = new EmailCompraHelper(emailView);

                        EditText emailUser = helper.getEmailUser();

                        emailUser.setText(casaDoCodigoStore.getEmailDevice());

                        Button pegaEmail = helper.getBotaoValidaEmail();
                        Button continuaCompra = helper.getContinuaCompra();

                        AlertDialog alertDialog = criaAlertaEmail(emailView);

                        concluiCompra(emailUser, pegaEmail, continuaCompra, alertDialog);

                    }
                })
                .setNegativeButton("Quero continuar comprando", null)
                .show();
    }


    private AlertDialog criaAlertaEmail(View emailView) {
        return new AlertDialog.Builder(CarrinhoComprasActivity.this)
                .setView(emailView)
                .setTitle("Por favor passe seu email")
                .setIcon(R.drawable.casadocodigo)
                .setCancelable(false)
                .show();
    }

    private void concluiCompra(final EditText emailUser, Button pegaEmail, Button continuaCompra, final AlertDialog alertDialog) {

        pegaEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                emailParaJson = emailUser.getText().toString().trim();

                if (validaEmail(emailParaJson)) {

                    alertDialog.dismiss();

                    try {
                        atualizaFinalizacaoCompra();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } else {
                    emailUser.setError("Por favor coloque um email válido !");
                }
            }
        });

        continuaCompra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });
    }

    private boolean validaEmail(String email) {

        if (!email.trim().isEmpty()) {
            if (email.contains("@") && email.contains(".")) {
                return true;
            }
        }
        return false;
    }

    private void atualizaFinalizacaoCompra() throws IOException {

        enviaListaJsonParaServidor();

        casaDoCodigoStore.getCarrinho().limpaLista(itens);
        atualizaListas();
        Toast.makeText(CarrinhoComprasActivity.this, "OK", Toast.LENGTH_LONG).show();
    }

    public void enviaListaJsonParaServidor() throws IOException {

        String json = geraJson();

        EnviaJsonTask task = new EnviaJsonTask();
        task.execute(json);
    }

    private String geraJson() {
        LivroConverter converter = new LivroConverter();
        return converter.toJson(itens, emailParaJson);
    }

    private void atualizaListas() {
        adapter.notifyDataSetChanged();
        atualizaValorCompra();
    }
}
