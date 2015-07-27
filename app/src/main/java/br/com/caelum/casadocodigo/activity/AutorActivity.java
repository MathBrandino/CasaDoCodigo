package br.com.caelum.casadocodigo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.List;

import br.com.caelum.casadocodigo.R;
import br.com.caelum.casadocodigo.adapter.LivroAutorAdapter;
import br.com.caelum.casadocodigo.modelo.Autor;
import br.com.caelum.casadocodigo.modelo.Livro;

/**
 * Created by matheus on 27/07/15.
 */
public class AutorActivity extends AppCompatActivity {

    private final String LIVRO = "livro";
    private Livro livro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_autores);


        Intent intent = getIntent();

        if (intent.hasExtra(LIVRO)){
            livro = (Livro) intent.getSerializableExtra(LIVRO);
        }

        List<Autor> autores = livro.getAutores();

        populaListaAutores(autores);

    }

    private void populaListaAutores(List<Autor> autores) {
        LivroAutorAdapter autorAdapter = new LivroAutorAdapter(autores, this);

        ListView listaAutores = (ListView) findViewById(R.id.mostra_autores);

        listaAutores.setAdapter(autorAdapter);
    }
}
