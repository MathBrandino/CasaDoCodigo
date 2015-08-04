package br.com.caelum.casadocodigo.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;

import java.io.Serializable;
import java.util.List;

import br.com.caelum.casadocodigo.delegate.BuscaLivrosDelegate;
import br.com.caelum.casadocodigo.modelo.Livro;

/**
 * Created by matheus on 30/07/15.
 */
public class LivrosRecebidos extends BroadcastReceiver {

    private static final String LIVROS_RECEBIDOS = "livros_recebidos";
    private static String SUCESSO = "sucesso";
    private static String RETORNO = "retorno";
    private BuscaLivrosDelegate delegate;

    public static LivrosRecebidos registraObservador(BuscaLivrosDelegate delegate) {
        LivrosRecebidos receiver = new LivrosRecebidos();

        receiver.delegate = delegate;

        LocalBroadcastManager
                .getInstance(delegate.getCasaDoCodigoStore())
                .registerReceiver(receiver,
                        new IntentFilter(LIVROS_RECEBIDOS));

        return receiver;
    }

    public static void notifica(Context context, List<Livro> resultado, boolean sucesso) {

        Intent intent = new Intent(LIVROS_RECEBIDOS);

        intent.putExtra(RETORNO, (Serializable) resultado);
        intent.putExtra(SUCESSO, sucesso);

        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        boolean deuCerto = intent.getBooleanExtra(SUCESSO, false);

        if (deuCerto) {
            delegate.lidaComRetorno((List<Livro>) intent.getSerializableExtra(RETORNO));
        } else {
            delegate.lidaComErro((Exception) intent.getSerializableExtra(RETORNO));
        }
    }
}
