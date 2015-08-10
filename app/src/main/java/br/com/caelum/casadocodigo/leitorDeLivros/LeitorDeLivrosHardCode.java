package br.com.caelum.casadocodigo.leitorDeLivros;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.casadocodigo.modelo.Autor;
import br.com.caelum.casadocodigo.modelo.Livro;

/**
 * Created by matheus on 23/07/15.
 */
class LeitorDeLivrosHardCode implements LeitorDeLivros {


    @Override
    public List<Livro> devolveLista() {

        Autor autor = new Autor();
        autor.setNomeAutor("Nome");
        List<Autor> autors = new ArrayList<>();

        autors.add(autor);

        Livro l1 = new Livro();
        l1.setNome("Jogos Android: Crie um game do zero usando classes nativas");
        l1.setDescricao("195, 300, 800 milhões de dólares!!! Essas são as cifras por trás dos jogos Angry Birds, Candy Crush e Clash of Clans. Quer pensar em cifras menores? Que tal 120 mil reais por dia? Foi o que Flappy Bird chegou a faturar. Pois é, já pensou em trabalhar com algo criativo, divertido e recompensador? Desenvolver jogos pode ser assim.   Neste livro, Felipe Torres mostra como criar um jogo do zero sem usar frameworks e discute as vantagens e desvantagens dessa abordagem usada pelo criador de Flappy Bird. Usando a linguagem Java, você vai desenvolver um jogo para Android e entender de fato como funciona a criação de jogos através da óptica do desenvolvedor e terá mais confiança e informação para decidir os caminhos do que esperamos. Seja o novo jogo viral do mercado!");
        l1.setAutores(autors);

        Livro l2 = new Livro();
        l2.setDescricao("Durante o dia, milhões de dados trafegam por servidores ao redor do mundo. São informações de todo tipo e muitas delas precisam ser preservadas. Qual a forma de fazer isso? Persistindo os dados.  Neste livro, Eduardo Gonçalves mostra o poder da linguagem PL/SQL e como você pode conseguir um alto grau de produtividade e performance para as suas aplicações. Os leitores iniciantes terão contato com conceitos sobre a estrutura da linguagem PL/SQL e suas características, e criarão programas, dos mais simples até os mais complexos, para atender às mais diversas necessidades. Para os já experientes, ajudará como fonte de referência e para atualizar conceitos e técnicas da linguagem.");
        l2.setNome("PL/SQL: Domine a linguagem do banco de dados Oracle");

        l2.setAutores(autors);

        Livro l3 = new Livro();
        l3.setNome("Jogos Android: Crie um game do zero usando classes nativas");
        l3.setDescricao("195, 300, 800 milhões de dólares!!! Essas são as cifras por trás dos jogos Angry Birds, Candy Crush e Clash of Clans. Quer pensar em cifras menores? Que tal 120 mil reais por dia? Foi o que Flappy Bird chegou a faturar. Pois é, já pensou em trabalhar com algo criativo, divertido e recompensador? Desenvolver jogos pode ser assim.   Neste livro, Felipe Torres mostra como criar um jogo do zero sem usar frameworks e discute as vantagens e desvantagens dessa abordagem usada pelo criador de Flappy Bird. Usando a linguagem Java, você vai desenvolver um jogo para Android e entender de fato como funciona a criação de jogos através da óptica do desenvolvedor e terá mais confiança e informação para decidir os caminhos do que esperamos. Seja o novo jogo viral do mercado!");

        l3.setAutores(autors);

        Livro l4 = new Livro();
        l4.setDescricao("Durante o dia, milhões de dados trafegam por servidores ao redor do mundo. São informações de todo tipo e muitas delas precisam ser preservadas. Qual a forma de fazer isso? Persistindo os dados.  Neste livro, Eduardo Gonçalves mostra o poder da linguagem PL/SQL e como você pode conseguir um alto grau de produtividade e performance para as suas aplicações. Os leitores iniciantes terão contato com conceitos sobre a estrutura da linguagem PL/SQL e suas características, e criarão programas, dos mais simples até os mais complexos, para atender às mais diversas necessidades. Para os já experientes, ajudará como fonte de referência e para atualizar conceitos e técnicas da linguagem.");
        l4.setNome("PL/SQL: Domine a linguagem do banco de dados Oracle");

        l4.setAutores(autors);

        Livro l5 = new Livro();
        l5.setNome("Jogos Android: Crie um game do zero usando classes nativas");
        l5.setDescricao("195, 300, 800 milhões de dólares!!! Essas são as cifras por trás dos jogos Angry Birds, Candy Crush e Clash of Clans. Quer pensar em cifras menores? Que tal 120 mil reais por dia? Foi o que Flappy Bird chegou a faturar. Pois é, já pensou em trabalhar com algo criativo, divertido e recompensador? Desenvolver jogos pode ser assim.   Neste livro, Felipe Torres mostra como criar um jogo do zero sem usar frameworks e discute as vantagens e desvantagens dessa abordagem usada pelo criador de Flappy Bird. Usando a linguagem Java, você vai desenvolver um jogo para Android e entender de fato como funciona a criação de jogos através da óptica do desenvolvedor e terá mais confiança e informação para decidir os caminhos do que esperamos. Seja o novo jogo viral do mercado!");

        l5.setAutores(autors);

        Livro l6 = new Livro();
        l6.setDescricao("Durante o dia, milhões de dados trafegam por servidores ao redor do mundo. São informações de todo tipo e muitas delas precisam ser preservadas. Qual a forma de fazer isso? Persistindo os dados.  Neste livro, Eduardo Gonçalves mostra o poder da linguagem PL/SQL e como você pode conseguir um alto grau de produtividade e performance para as suas aplicações. Os leitores iniciantes terão contato com conceitos sobre a estrutura da linguagem PL/SQL e suas características, e criarão programas, dos mais simples até os mais complexos, para atender às mais diversas necessidades. Para os já experientes, ajudará como fonte de referência e para atualizar conceitos e técnicas da linguagem.");
        l6.setNome("PL/SQL: Domine a linguagem do banco de dados Oracle");

        l6.setAutores(autors);

        Livro l7 = new Livro();
        l7.setNome("Jogos Android: Crie um game do zero usando classes nativas");
        l7.setDescricao("195, 300, 800 milhões de dólares!!! Essas são as cifras por trás dos jogos Angry Birds, Candy Crush e Clash of Clans. Quer pensar em cifras menores? Que tal 120 mil reais por dia? Foi o que Flappy Bird chegou a faturar. Pois é, já pensou em trabalhar com algo criativo, divertido e recompensador? Desenvolver jogos pode ser assim.   Neste livro, Felipe Torres mostra como criar um jogo do zero sem usar frameworks e discute as vantagens e desvantagens dessa abordagem usada pelo criador de Flappy Bird. Usando a linguagem Java, você vai desenvolver um jogo para Android e entender de fato como funciona a criação de jogos através da óptica do desenvolvedor e terá mais confiança e informação para decidir os caminhos do que esperamos. Seja o novo jogo viral do mercado!");

        l7.setAutores(autors);


        List<Livro> livros = new ArrayList<>();

        livros.add(l1);
        livros.add(l2);
        livros.add(l3);
        livros.add(l4);
        livros.add(l5);
        livros.add(l6);
        livros.add(l7);


        return livros;
    }
}
