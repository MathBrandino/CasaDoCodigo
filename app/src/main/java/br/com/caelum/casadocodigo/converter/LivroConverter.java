package br.com.caelum.casadocodigo.converter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.casadocodigo.modelo.Livro;

/**
 * Created by matheus on 22/07/15.
 */
public class LivroConverter {


    public List<Livro> fromJson(String json){

        List<Livro> livros = new ArrayList<>();

        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArray = jsonObject.getJSONArray("list")
                    .getJSONObject(0)
                    .getJSONArray("livro");
            int nLivros = jsonArray.length();
            for (int i = 0; i < nLivros; i++) {
                Livro livro = new Livro();

                JSONObject objectLivro = jsonArray.getJSONObject(i);

                livro.setId(objectLivro.getLong("id"));
                livro.setNomeLivro(objectLivro.getString("nomeLivro"));
                livro.setDescricaoLivro(objectLivro.getString("descricaoLivro"));
                livro.setDataPublicacao(objectLivro.getString("dataPublicacao"));
                livro.setISBN(objectLivro.getString("ISBN"));
                livro.setNumPaginas(objectLivro.getInt("numeroPaginas"));
                livro.setValorFisico(objectLivro.getDouble("valorFisico"));
                livro.setValorVirtual(objectLivro.getDouble("valorVirtual"));
                livro.setValorDoisJuntos(objectLivro.getDouble("valorVirtualComFisico"));

                livros.add(livro);
            }
            return livros;

        } catch (JSONException e) {
            throw new IllegalArgumentException(e);
        }
    }


}
