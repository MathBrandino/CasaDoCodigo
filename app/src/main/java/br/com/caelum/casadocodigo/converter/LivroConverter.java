package br.com.caelum.casadocodigo.converter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.casadocodigo.modelo.Autor;
import br.com.caelum.casadocodigo.modelo.Livro;

/**
 * Created by matheus on 22/07/15.
 */
public class LivroConverter {

    private final String ID = "id";
    private final String NOME_LIVRO = "nomeLivro";
    private final String DESCRICAO_LIVRO = "descricaoLivro";
    private final String DATA_PUBLICACAO = "dataPublicacao";
    private final String ISBN = "ISBN";
    private final String NUMERO_PAGINAS = "numeroPaginas";
    private final String VALOR_FISICO = "valorFisico";
    private final String VALOR_VIRTUAL = "valorVirtual";
    private final String VALOR_VIRTUAL_COM_FISICO = "valorVirtualComFisico";
    private final String URL_IMAGEM = "imagemUrl";
    private final String ID_AUTOR = "idAutor";
    private final String NOME_AUTOR = "nomeAutor";
    private final String DETALHES_AUTOR = "detalhesAutor";
    private final String IMAGEM_AUTOR = "imagemAutor";
    private final String AUTORES = "autores";
    private final String LIVROS = "livros";

    public List<Livro> fromJson(String json) throws JSONException {

        List<Livro> livros = new ArrayList<>();

        if (json != null) {


            JSONObject jsonObjectTodosLivros = new JSONObject(json);
            JSONArray jsonArrayLivros = jsonObjectTodosLivros.getJSONArray(LIVROS);

            int nLivros = jsonArrayLivros.length();
            for (int i = 0; i < nLivros; i++) {

                JSONObject objectLivro = jsonArrayLivros.getJSONObject(i);

                Livro livro = geraLivroPorJSONObject(objectLivro);

                List<Autor> autores = getAutores(objectLivro);

                livro.setAutores(autores);

                livros.add(livro);
            }
        }
        return livros;
    }

    private List<Autor> getAutores(JSONObject objectLivro) throws JSONException {
        List<Autor> autors = new ArrayList<>();

        JSONArray jsonArrayAutores = objectLivro.getJSONArray(AUTORES);

        int nAutores = jsonArrayAutores.length();
        for (int j = 0; j < nAutores; j++) {

            JSONObject objectAutor = jsonArrayAutores.getJSONObject(j);

            Autor autor = geraAutorPorJSONObjetct(objectAutor);

            autors.add(autor);
        }
        return autors;
    }

    private Livro geraLivroPorJSONObject(JSONObject objectLivro) throws JSONException {
        Livro livro = new Livro();

        livro.setId(objectLivro.getLong(ID));
        livro.setNomeLivro(objectLivro.getString(NOME_LIVRO));
        livro.setDescricaoLivro(objectLivro.getString(DESCRICAO_LIVRO));
        livro.setDataPublicacao(objectLivro.getString(DATA_PUBLICACAO));
        livro.setISBN(objectLivro.getString(ISBN));
        livro.setNumPaginas(objectLivro.getInt(NUMERO_PAGINAS));
        livro.setValorFisico(objectLivro.getDouble(VALOR_FISICO));
        livro.setValorVirtual(objectLivro.getDouble(VALOR_VIRTUAL));
        livro.setValorDoisJuntos(objectLivro.getDouble(VALOR_VIRTUAL_COM_FISICO));
        livro.setImagemUrl(objectLivro.getString(URL_IMAGEM));



        return livro;
    }


    private Autor geraAutorPorJSONObjetct(JSONObject objectAutor) throws JSONException {
        Autor autor = new Autor();

        autor.setIdAutor(objectAutor.getLong(ID_AUTOR));
        autor.setNomeAutor(objectAutor.getString(NOME_AUTOR));
        autor.setDetalhesAutor(objectAutor.getString(DETALHES_AUTOR));
        autor.setImagemAutorUrl(objectAutor.getString(IMAGEM_AUTOR));

        return autor;
    }
}
