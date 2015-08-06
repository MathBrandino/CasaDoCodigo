package br.com.caelum.casadocodigo.listener;

import android.app.Activity;
import android.support.design.widget.NavigationView;
import android.view.MenuItem;
import android.widget.Toast;

import br.com.caelum.casadocodigo.R;
import br.com.caelum.casadocodigo.activity.EstadoTela;
import br.com.caelum.casadocodigo.activity.MainActivity;
import br.com.caelum.casadocodigo.aplication.CasaDoCodigoStore;
import br.com.caelum.casadocodigo.async.CarregadorCatalogoTask;

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
                buscaDadosServidor(2);
                return true;

            case R.id.carrinho_menu:
                menuItem.setOnMenuItemClickListener(new ListenerCarrinho(activity));
                return true;

            case R.id.web_menu:
                buscaDadosServidor(7);
                return true;

            case R.id.front_menu:
                buscaDadosServidor(4);
                return true;

            case R.id.mobile_menu:
                buscaDadosServidor(6);
                return true;

            case R.id.games_menu:
                buscaDadosServidor(5);
                return true;

            case R.id.outros_menu:
                buscaDadosServidor(8);
                return true;

            case R.id.agile_menu:
                buscaDadosServidor(3);
                return true;

            case R.id.todos_menu:
                buscaDadosServidor(1);
                return true;
        }

        return false;
    }

    public void buscaDadosServidor(int i) {
        CarregadorCatalogoTask task = new CarregadorCatalogoTask((CasaDoCodigoStore) activity.getApplication());
        task.execute(i);
        preparaTelaParaTrocaDeFragment();
    }

    private void preparaTelaParaTrocaDeFragment() {
        CasaDoCodigoStore casaDoCodigoStore = (CasaDoCodigoStore) activity.getApplication();
        casaDoCodigoStore.setEstadoTela(EstadoTela.CARREGAMENTO);
        casaDoCodigoStore.getEstadoTela().executa((MainActivity) activity);
    }
}
