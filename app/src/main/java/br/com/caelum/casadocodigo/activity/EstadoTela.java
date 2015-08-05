package br.com.caelum.casadocodigo.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import br.com.caelum.casadocodigo.R;
import br.com.caelum.casadocodigo.fragment.MainFragment;
import br.com.caelum.casadocodigo.fragment.ProgressFragment;

/**
 * Created by matheus on 04/08/15.
 */
public enum EstadoTela {
    INICIO {
        @Override
        public void colocaFragmentTela(MainActivity activity, Fragment fragment) {

            FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.frame_main, fragment);
            transaction.commit();

        }

        @Override
        public void executa(MainActivity activity) {
            activity.buscaDadosServidor();
            ProgressFragment progressFragment = new ProgressFragment();
            colocaFragmentTela(activity, progressFragment);
        }
    },
    LISTA_LIVROS {
        @Override
        public void colocaFragmentTela(MainActivity activity, Fragment fragment) {

            FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.frame_main, fragment);
            transaction.commit();

        }

        @Override
        public void executa(MainActivity activity) {

            MainFragment fragment = new MainFragment();
            colocaFragmentTela(activity, fragment);
        }
    },

    LIVRO {
        @Override
        public void colocaFragmentTela(MainActivity activity, Fragment fragment) {

            FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.frame_main, fragment);
            transaction.addToBackStack(null);
            transaction.commit();

        }

        @Override
        public void executa(MainActivity activity) {

        }
    },
    AUTOR {
        @Override
        public void colocaFragmentTela(MainActivity activity, Fragment fragment) {

            FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.frame_main, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }

        @Override
        public void executa(MainActivity activity) {

        }
    };

    public abstract void colocaFragmentTela(MainActivity activity, Fragment fragment);

    public abstract void executa(MainActivity activity);
}
