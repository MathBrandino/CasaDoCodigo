package br.com.caelum.casadocodigo.helper;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.com.caelum.casadocodigo.R;

/**
 * Created by matheus on 31/07/15.
 */
public class EmailCompraHelper {

    private EditText emailUser;
    private Button botaoValidaEmail;
    private Button continuaCompra;

    public EmailCompraHelper(View view) {

        emailUser = (EditText) view.findViewById(R.id.email_compra);
        botaoValidaEmail = (Button) view.findViewById(R.id.pega_email_compra);
        continuaCompra = (Button) view.findViewById(R.id.continua_compra);
    }

    public EditText getEmailUser() {
        return emailUser;
    }

    public Button getBotaoValidaEmail() {
        return botaoValidaEmail;
    }

    public Button getContinuaCompra() {
        return continuaCompra;
    }
}
