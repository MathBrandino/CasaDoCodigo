package br.com.caelum.casadocodigo.converter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.casadocodigo.modelo.Autor;
import br.com.caelum.casadocodigo.modelo.Item;
import br.com.caelum.casadocodigo.modelo.Livro;

/**
 * Created by matheus on 22/07/15.
 */
public class LivroConverter {

    private final String ID = "id";
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
    private final String LISTA_ITENS = "itens";
    private final String LIVROS = "livros";
    private final String ID_LIVRO = "idLivro";
    private final String NOME_LIVRO = "nomeLivro";
    private final String TIPO_LIVRO = "tipoLivro";
    private final String USUARIO = "usuario";
    private final String EMAIL = "email";
    private final String ITEM = "item";
    private final String LIVRO = "livro";
    private final String COMPRA = "compra";

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


    public String toJson(List<Item> items, String email) {

        try {
            JSONStringer jsonStringer = new JSONStringer();

            jsonStringer
                    .object().key(COMPRA).array();

            jsonStringer
                    .object().key(LISTA_ITENS).array();

            for (Item item : items) {

                jsonStringer.object().key(ITEM).array();

                jsonStringer.object().key(LIVRO).array();

                jsonStringer.object()
                        .key(ID_LIVRO).value(item.getLivro().getId())
                        .endObject();

                jsonStringer.endArray().endObject();

                jsonStringer.object()
                        .key(TIPO_LIVRO).value(item.getTipoDeCompra())
                        .endObject();

                jsonStringer.endArray().endObject();
            }

            jsonStringer.object().key(USUARIO).array();

            jsonStringer.object().key(EMAIL).value(email).endObject();

            jsonStringer.endArray().endObject();

            String jsonSaida = jsonStringer.endArray().endObject().toString();

            return jsonSaida;

        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
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
        livro.setNome(objectLivro.getString(NOME_LIVRO));
        livro.setDescricao(objectLivro.getString(DESCRICAO_LIVRO));
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
