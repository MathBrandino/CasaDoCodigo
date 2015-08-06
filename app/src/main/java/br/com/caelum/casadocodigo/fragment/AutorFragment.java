package br.com.caelum.casadocodigo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.List;

import br.com.caelum.casadocodigo.R;
import br.com.caelum.casadocodigo.adapter.LivroAutorAdapter;
import br.com.caelum.casadocodigo.aplication.CasaDoCodigoStore;
import br.com.caelum.casadocodigo.modelo.Autor;
import br.com.caelum.casadocodigo.modelo.Livro;

/**
 * Created by matheus on 04/08/15.
 */
public class AutorFragment extends Fragment {

    private final String LIVRO = "livro";
    private Livro livro;
    private List<Autor> autores;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_autor, container, false);

        CasaDoCodigoStore casaDoCodigoStore = (CasaDoCodigoStore) getActivity().getApplication();

        livro = casaDoCodigoStore.getLivroSelecionado();

        autores = livro.getAutores();

        populaAutores(view);

        return view;
    }

    private void populaAutores(View view) {

        ListView listaAutores = (ListView) view.findViewById(R.id.mostra_autores);

        LivroAutorAdapter adapter = new LivroAutorAdapter(autores, getActivity());

        listaAutores.setAdapter(adapter);
    }
}
