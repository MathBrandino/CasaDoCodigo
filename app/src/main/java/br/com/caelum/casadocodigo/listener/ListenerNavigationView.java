package br.com.caelum.casadocodigo.listener;

import android.app.Activity;
import android.support.design.widget.NavigationView;
import android.view.MenuItem;
import android.widget.Toast;

import br.com.caelum.casadocodigo.R;

/**
 * Created by matheus on 06/08/15.
 */
public class ListenerNavigationView implements NavigationView.OnNavigationItemSelectedListener {

    private Activity activity;


    public ListenerNavigationView(Activity activity) {
        this.activity = activity;
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {

            case R.id.java_menu:
                Toast.makeText(activity, "Livros de java", Toast.LENGTH_LONG).show();
                return true;

            case R.id.carrinho_menu:
                menuItem.setOnMenuItemClickListener(new ListenerCarrinho(activity));
                return true;

            case R.id.web_menu:
                Toast.makeText(activity, "Livros de web", Toast.LENGTH_LONG).show();
                return true;

            case R.id.front_menu:
                Toast.makeText(activity, "Livros de front", Toast.LENGTH_LONG).show();
                return true;

            case R.id.mobile_menu:
                Toast.makeText(activity, "Livros de mobile", Toast.LENGTH_LONG).show();
                return true;

            case R.id.games_menu:
                Toast.makeText(activity, "Livros de game", Toast.LENGTH_LONG).show();
                return true;

            case R.id.outros_menu:
                Toast.makeText(activity, "Livros diversos", Toast.LENGTH_LONG).show();
                return true;

            case R.id.agile_menu:
                Toast.makeText(activity, "Livros de agile", Toast.LENGTH_LONG).show();
                return true;
        }

        return false;
    }
}
