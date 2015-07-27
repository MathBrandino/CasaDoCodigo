package br.com.caelum.casadocodigo.auxiliador;

import android.widget.RadioGroup;

import br.com.caelum.casadocodigo.R;
import br.com.caelum.casadocodigo.TipoDeCompra;

/**
 * Created by matheus on 27/07/15.
 */
public class Auxiliador  {

    public TipoDeCompra auxilia(RadioGroup radioGroup){

        TipoDeCompra tipoDeCompra;

        switch (radioGroup.getCheckedRadioButtonId()){

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
