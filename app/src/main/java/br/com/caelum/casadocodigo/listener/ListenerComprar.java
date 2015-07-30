package br.com.caelum.casadocodigo.listener;

import android.app.Activity;
import android.view.View;
import android.widget.Toast;

/**
 * Created by matheus on 24/07/15.
 */
public class ListenerComprar implements View.OnClickListener {

    Activity activity;

    public ListenerComprar(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(activity, "Adicionado ao carrinho", Toast.LENGTH_LONG).show();

    }

}
