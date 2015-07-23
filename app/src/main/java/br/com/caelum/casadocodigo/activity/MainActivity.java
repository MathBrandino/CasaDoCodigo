package br.com.caelum.casadocodigo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.List;

import br.com.caelum.casadocodigo.R;
import br.com.caelum.casadocodigo.adapter.LivrosAdapter;
import br.com.caelum.casadocodigo.converter.LeitorDeLivros;
import br.com.caelum.casadocodigo.factory.LeitorDeLivrosFactory;
import br.com.caelum.casadocodigo.modelo.Livro;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

/*
        Livro l1 = new Livro();
        l1.setNomeLivro("Jogos Android: Crie um game do zero usando classes nativas");
        l1.setDescricaoLivro("195, 300, 800 milhões de dólares!!! Essas são as cifras por trás dos jogos Angry Birds, Candy Crush e Clash of Clans. Quer pensar em cifras menores? Que tal 120 mil reais por dia? Foi o que Flappy Bird chegou a faturar. Pois é, já pensou em trabalhar com algo criativo, divertido e recompensador? Desenvolver jogos pode ser assim.   Neste livro, Felipe Torres mostra como criar um jogo do zero sem usar frameworks e discute as vantagens e desvantagens dessa abordagem usada pelo criador de Flappy Bird. Usando a linguagem Java, você vai desenvolver um jogo para Android e entender de fato como funciona a criação de jogos através da óptica do desenvolvedor e terá mais confiança e informação para decidir os caminhos do que esperamos. Seja o novo jogo viral do mercado!");

        Livro l2 = new Livro();
        l2.setDescricaoLivro("Durante o dia, milhões de dados trafegam por servidores ao redor do mundo. São informações de todo tipo e muitas delas precisam ser preservadas. Qual a forma de fazer isso? Persistindo os dados.  Neste livro, Eduardo Gonçalves mostra o poder da linguagem PL/SQL e como você pode conseguir um alto grau de produtividade e performance para as suas aplicações. Os leitores iniciantes terão contato com conceitos sobre a estrutura da linguagem PL/SQL e suas características, e criarão programas, dos mais simples até os mais complexos, para atender às mais diversas necessidades. Para os já experientes, ajudará como fonte de referência e para atualizar conceitos e técnicas da linguagem.");
        l2.setNomeLivro("PL/SQL: Domine a linguagem do banco de dados Oracle");

        Livro l3 = new Livro();
        l3.setNomeLivro("Jogos Android: Crie um game do zero usando classes nativas");
        l3.setDescricaoLivro("195, 300, 800 milhões de dólares!!! Essas são as cifras por trás dos jogos Angry Birds, Candy Crush e Clash of Clans. Quer pensar em cifras menores? Que tal 120 mil reais por dia? Foi o que Flappy Bird chegou a faturar. Pois é, já pensou em trabalhar com algo criativo, divertido e recompensador? Desenvolver jogos pode ser assim.   Neste livro, Felipe Torres mostra como criar um jogo do zero sem usar frameworks e discute as vantagens e desvantagens dessa abordagem usada pelo criador de Flappy Bird. Usando a linguagem Java, você vai desenvolver um jogo para Android e entender de fato como funciona a criação de jogos através da óptica do desenvolvedor e terá mais confiança e informação para decidir os caminhos do que esperamos. Seja o novo jogo viral do mercado!");

        Livro l4 = new Livro();
        l4.setDescricaoLivro("Durante o dia, milhões de dados trafegam por servidores ao redor do mundo. São informações de todo tipo e muitas delas precisam ser preservadas. Qual a forma de fazer isso? Persistindo os dados.  Neste livro, Eduardo Gonçalves mostra o poder da linguagem PL/SQL e como você pode conseguir um alto grau de produtividade e performance para as suas aplicações. Os leitores iniciantes terão contato com conceitos sobre a estrutura da linguagem PL/SQL e suas características, e criarão programas, dos mais simples até os mais complexos, para atender às mais diversas necessidades. Para os já experientes, ajudará como fonte de referência e para atualizar conceitos e técnicas da linguagem.");
        l4.setNomeLivro("PL/SQL: Domine a linguagem do banco de dados Oracle");

        Livro l5 = new Livro();
        l5.setNomeLivro("Jogos Android: Crie um game do zero usando classes nativas");
        l5.setDescricaoLivro("195, 300, 800 milhões de dólares!!! Essas são as cifras por trás dos jogos Angry Birds, Candy Crush e Clash of Clans. Quer pensar em cifras menores? Que tal 120 mil reais por dia? Foi o que Flappy Bird chegou a faturar. Pois é, já pensou em trabalhar com algo criativo, divertido e recompensador? Desenvolver jogos pode ser assim.   Neste livro, Felipe Torres mostra como criar um jogo do zero sem usar frameworks e discute as vantagens e desvantagens dessa abordagem usada pelo criador de Flappy Bird. Usando a linguagem Java, você vai desenvolver um jogo para Android e entender de fato como funciona a criação de jogos através da óptica do desenvolvedor e terá mais confiança e informação para decidir os caminhos do que esperamos. Seja o novo jogo viral do mercado!");

        Livro l6 = new Livro();
        l6.setDescricaoLivro("Durante o dia, milhões de dados trafegam por servidores ao redor do mundo. São informações de todo tipo e muitas delas precisam ser preservadas. Qual a forma de fazer isso? Persistindo os dados.  Neste livro, Eduardo Gonçalves mostra o poder da linguagem PL/SQL e como você pode conseguir um alto grau de produtividade e performance para as suas aplicações. Os leitores iniciantes terão contato com conceitos sobre a estrutura da linguagem PL/SQL e suas características, e criarão programas, dos mais simples até os mais complexos, para atender às mais diversas necessidades. Para os já experientes, ajudará como fonte de referência e para atualizar conceitos e técnicas da linguagem.");
        l6.setNomeLivro("PL/SQL: Domine a linguagem do banco de dados Oracle");

        Livro l7 = new Livro();
        l7.setNomeLivro("Jogos Android: Crie um game do zero usando classes nativas");
        l7.setDescricaoLivro("195, 300, 800 milhões de dólares!!! Essas são as cifras por trás dos jogos Angry Birds, Candy Crush e Clash of Clans. Quer pensar em cifras menores? Que tal 120 mil reais por dia? Foi o que Flappy Bird chegou a faturar. Pois é, já pensou em trabalhar com algo criativo, divertido e recompensador? Desenvolver jogos pode ser assim.   Neste livro, Felipe Torres mostra como criar um jogo do zero sem usar frameworks e discute as vantagens e desvantagens dessa abordagem usada pelo criador de Flappy Bird. Usando a linguagem Java, você vai desenvolver um jogo para Android e entender de fato como funciona a criação de jogos através da óptica do desenvolvedor e terá mais confiança e informação para decidir os caminhos do que esperamos. Seja o novo jogo viral do mercado!");

        List<Livro> livros = new ArrayList<>();

        livros.add(l1);
        livros.add(l2);
        livros.add(l3);
        livros.add(l4);
        livros.add(l5);
        livros.add(l6);
        livros.add(l7);
*/


        LeitorDeLivros leitorDeLivros = LeitorDeLivrosFactory.getLeitorDeLivros(this);

        List<Livro> livros = leitorDeLivros.devolveLista();



        ListView lista = (ListView) findViewById(R.id.lista_livros);

        LivrosAdapter adapter = new LivrosAdapter(livros, this);

        lista.setAdapter(adapter);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
