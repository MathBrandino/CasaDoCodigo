package br.com.caelum.casadocodigo.helper;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.com.caelum.casadocodigo.R;

/**
 * Created by matheus on 31/07/15.
 */
public class EmailCompraHelper {

    private EditText colocaEmail;
    private Button pegaEmail;
    private Button continuaCompra;

    public EmailCompraHelper(View view) {

        colocaEmail = (EditText) view.findViewById(R.id.email_compra);
        pegaEmail = (Button) view.findViewById(R.id.pega_email_compra);
        continuaCompra = (Button) view.findViewById(R.id.continua_compra);
    }

    public EditText getColocaEmail() {
        return colocaEmail;
    }

    public Button getPegaEmail() {
        return pegaEmail;
    }

    public Button getContinuaCompra() {
        return continuaCompra;
    }
}
