package br.com.caelum.casadocodigo.delegate;

import android.app.Activity;

import java.util.List;

import br.com.caelum.casadocodigo.aplication.CasaDoCodigoStore;
import br.com.caelum.casadocodigo.modelo.Livro;

/**
 * Created by matheus on 29/07/15.
 */
public interface BuscaLivrosDelegate {

    void lidaComRetorno(List<Livro> livros);
    void lidaComErro(Exception e);
    Activity retornaActivity();
    CasaDoCodigoStore getCasaDoCodigoStore();
}

