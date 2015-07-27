package br.com.caelum.casadocodigo.listener;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.view.MenuItem;

import br.com.caelum.casadocodigo.activity.CarrinhoComprasActivity;

/**
 * Created by matheus on 27/07/15.
 */
public class ListenerCarrinho implements MenuItem.OnMenuItemClickListener {

    Activity activity ;

    public ListenerCarrinho(Activity activity) {
        this.activity = activity;
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        Intent intent = new Intent(activity, CarrinhoComprasActivity.class);
        activity.startActivity(intent);

        return true;
    }
}
