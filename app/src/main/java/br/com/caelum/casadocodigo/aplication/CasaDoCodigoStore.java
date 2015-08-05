package br.com.caelum.casadocodigo.aplication;

import android.accounts.Account;
import android.accounts.AccountManager;
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
    private String emailDevice;

    public CasaDoCodigoStore() {
        carrinho = new Carrinho();
        estadoTela = EstadoTela.INICIO;
    }

    public String getEmailDevice() {

        try {
            AccountManager accountManager = AccountManager.get(this);
            Account[] accounts = accountManager.getAccountsByType("com.google");
            if (accounts.length > 0) {
                Account account = accounts[0];
                return account.name;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public EstadoTela getEstadoTela() {
        return estadoTela;
    }

    public void setEstadoTela(EstadoTela estadoTela) {
        this.estadoTela = estadoTela;
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
