package br.com.caelum.casadocodigo.aplication;

import android.app.Application;
import android.os.AsyncTask;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.casadocodigo.activity.EstadoTela;
import br.com.caelum.casadocodigo.modelo.Carrinho;
import br.com.caelum.casadocodigo.modelo.Livro;

/**
 * Created by matheus on 24/07/15.
 */
public class CasaDoCodigoStore extends Application {

    private Carrinho carrinho;
    private List<AsyncTask<?, ?, ?>> tasks = new ArrayList<>();
    private List<Livro> livros;
    private EstadoTela estadoTela;

    public EstadoTela getEstadoTela() {
        return estadoTela;
    }

    public void setEstadoTela(EstadoTela estadoTela) {
        this.estadoTela = estadoTela;
    }

    public CasaDoCodigoStore() {
        carrinho = new Carrinho();
        estadoTela = EstadoTela.INICIO;
    }

    public void registra(AsyncTask<?, ?, ?> task) {
        tasks.add(task);
    }

    public void remove(AsyncTask<?, ?, ?> task) {
        tasks.remove(task);
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

}
