package br.com.caelum.casadocodigo.aplication;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.casadocodigo.modelo.Carrinho;
import br.com.caelum.casadocodigo.modelo.Livro;

/**
 * Created by matheus on 24/07/15.
 */
public class CasaDoCodigoStore extends Application {

    private Carrinho carrinho;



    public CasaDoCodigoStore() {
        carrinho = new Carrinho();
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

}
