package br.com.caelum.casadocodigo.converter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

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

    public List<Livro> fromJson(String json) throws JSONException {

        List<Livro> livros = new ArrayList<>();

        if (json != null) {


            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArray = jsonObject.getJSONArray("livros");

            int nLivros = jsonArray.length();
            for (int i = 0; i < nLivros; i++) {

                JSONObject objectLivro = jsonArray.getJSONObject(i);

                Livro livro = geraLivroPorJSONObject(objectLivro);

                livros.add(livro);
            }
        }
        return livros;


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


}
