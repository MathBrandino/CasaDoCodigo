package br.com.caelum.casadocodigo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.casadocodigo.R;
import br.com.caelum.casadocodigo.activity.MainActivity;
import br.com.caelum.casadocodigo.adapter.ListaDeLivrosAdapter;
import br.com.caelum.casadocodigo.modelo.Livro;

/**
 * Created by matheus on 04/08/15.
 */
public class MainFragment extends Fragment {

    private ListView listaLivros;
    private List<Livro> livros;
    private Bundle bundle;

    private ListaDeLivrosAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment, container, false);

        bundle = getArguments();

        ViewHolder holder = new ViewHolder(view);

        listaLivros = holder.listaLivros;

        livros = new ArrayList<>();

        livros = (List<Livro>) bundle.getSerializable("livros");

        adapter = new ListaDeLivrosAdapter(livros, (MainActivity) getActivity());

        listaLivros.setAdapter(adapter);

        return view;
    }

    private class ViewHolder {
        final private ListView listaLivros;

        public ViewHolder(View view) {
            listaLivros = (ListView) view.findViewById(R.id.lista_livros);
        }
    }
}
