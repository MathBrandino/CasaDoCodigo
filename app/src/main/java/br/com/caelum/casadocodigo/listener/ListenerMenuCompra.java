package br.com.caelum.casadocodigo.listener;

import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import br.com.caelum.casadocodigo.R;
import br.com.caelum.casadocodigo.activity.MainActivity;
import br.com.caelum.casadocodigo.modelo.Livro;

/**
 * Created by matheus on 24/07/15.
 */
public class ListenerMenuCompra implements View.OnClickListener {
    private MainActivity activity;
    private Livro livro;

    public ListenerMenuCompra(MainActivity activity, Livro livro) {
        this.activity = activity;
        this.livro = livro;
    }

    @Override
    public void onClick(View v) {
        final View alertView = View.inflate(activity, R.layout.opcao_compra, null);

        populaRadioGroup(alertView);

        AlertDialog alertDialog = new AlertDialog.Builder(activity)
                .setView(alertView)
                .setTitle(livro.getNomeLivro())
                .show();

        Button comprar = (Button) alertView.findViewById(R.id.botao_comprar_livro_alert);

        comprar.setOnClickListener(new ListenerComprarPeloMain(livro, activity, alertDialog));

    }

    private void populaRadioGroup(View alertView) {
        RadioButton virtual = (RadioButton) alertView.findViewById(R.id.valor_virtual);
        RadioButton fisico = (RadioButton) alertView.findViewById(R.id.valor_fisico);
        RadioButton juntos = (RadioButton) alertView.findViewById(R.id.valor_juntos);


        virtual.setText("Virtual : R$ " + livro.getValorVirtual());
        fisico.setText("Fisico : R$ " + livro.getValorFisico());
        juntos.setText("Juntos : R$ " + livro.getValorDoisJuntos());

        juntos.toggle();
    }

}
