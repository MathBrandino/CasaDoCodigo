package br.com.caelum.casadocodigo.leitorDeLivros;


import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.caelum.casadocodigo.R;
import br.com.caelum.casadocodigo.converter.LivroConverter;
import br.com.caelum.casadocodigo.converter.OnlyOpenRawResource;
import br.com.caelum.casadocodigo.modelo.Livro;

/**
 * Created by matheus on 23/07/15.
 */
class LeitorDeLivrosArquivo implements LeitorDeLivros {

    private OnlyOpenRawResource resource;

    public LeitorDeLivrosArquivo(OnlyOpenRawResource resources) {
        this.resource = resources;
    }

    private String leArquivo() {

        Scanner scanner = new Scanner(resource.openRawResource(R.raw.listalivros));

        String line;
        String json = "";

        while ((line = scanner.nextLine()) != null) {
            json += line;
        }

        return json;
    }

    @Override
    public List<Livro> devolveLista() {

        List<Livro> livros = new ArrayList<>();

        LivroConverter converter = new LivroConverter();

        try {
            livros = converter.fromJson(leArquivo());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return livros;
    }
}
