package br.com.caelum.casadocodigo.listener;

import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import br.com.caelum.casadocodigo.R;
import br.com.caelum.casadocodigo.activity.MainActivity;
import br.com.caelum.casadocodigo.activity.TipoDeCompra;
import br.com.caelum.casadocodigo.aplication.CasaDoCodigoStore;
import br.com.caelum.casadocodigo.modelo.Item;
import br.com.caelum.casadocodigo.modelo.Livro;

/**
 * Created by matheus on 27/07/15.
 */
public class ListenerComprarPeloMain implements View.OnClickListener {

    private MainActivity activity;
    private Livro livro;
    private CasaDoCodigoStore casaDoCodigoStore;
    private AlertDialog alertDialog;

    public ListenerComprarPeloMain(Livro livro, MainActivity activity, AlertDialog alertDialog) {
        this.activity = activity;
        this.livro = livro;
        casaDoCodigoStore = (CasaDoCodigoStore) activity.getApplication();
        this.alertDialog = alertDialog;
    }

    @Override
    public void onClick(View v) {

        Item item = new Item(livro, getTipoDeCompra());

        casaDoCodigoStore.getCarrinho().adicionar(item);

        Toast.makeText(activity, item.getLivro().getNomeLivro() + " foi adicionado ao carrinho", Toast.LENGTH_LONG).show();

        alertDialog.cancel();


    }


    public TipoDeCompra getTipoDeCompra() {

        TipoDeCompra tipoDeCompra = null;

        RadioGroup radioGroup = (RadioGroup) alertDialog.findViewById(R.id.radio_group);

        tipoDeCompra = devolveTipoCompra(radioGroup);

        return tipoDeCompra;
    }

    ;


    private TipoDeCompra devolveTipoCompra(RadioGroup radioGroup) {
        TipoDeCompra tipoDeCompra;

        switch (radioGroup.getCheckedRadioButtonId()) {

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
