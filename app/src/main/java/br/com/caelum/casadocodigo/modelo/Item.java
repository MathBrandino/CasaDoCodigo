package br.com.caelum.casadocodigo.modelo;

import br.com.caelum.casadocodigo.TipoDeCompra;

/**
 * Created by matheus on 27/07/15.
 */
public class Item  {
    private Livro livro;
    private TipoDeCompra tipoDeCompra;

    public Item(Livro livro, TipoDeCompra tipoDeCompra) {
        this.livro = livro;
        this.tipoDeCompra = tipoDeCompra;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public TipoDeCompra getTipoDeCompra() {
        return tipoDeCompra;
    }

}
