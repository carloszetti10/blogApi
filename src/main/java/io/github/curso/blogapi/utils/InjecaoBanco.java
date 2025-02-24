package io.github.curso.blogapi.utils;

import io.github.curso.blogapi.model.Post;
import io.github.curso.blogapi.repository.BlogRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class InjecaoBanco {

    @Autowired
    BlogRepository repository;

    @PostConstruct
    public void salvarPost(){
        Post post = new Post();
        post.setAutor("Carlos Zetti");
        post.setData(LocalDate.now());
        post.setTitulo("O Segredo das Noites Estreladas");
        post.setTexto("As noites estreladas sempre foram um mistério para os sonhadores. Cada ponto brilhante no céu carrega consigo histórias de tempos antigos, ecos de galáxias distantes e segredos que a ciência ainda busca desvendar. Quem nunca olhou para o alto e imaginou o que existe além do que podemos ver? Talvez, em algum lugar, outras formas de vida estejam olhando para cá, fazendo as mesmas perguntas.\n" +
                "\n" +
                "Seja como for, contemplar as estrelas nos faz lembrar que somos pequenos diante do universo, mas grandes na capacidade de imaginar e sonhar.");

        Post post1 = new Post();
        post1.setAutor("Nego Zetti");
        post1.setData(LocalDate.now());
        post1.setTitulo("Café e Conversas");
        post1.setTexto("O aroma do café recém-passado se espalha pela casa como um convite para momentos de pausa e reflexão. Algumas das melhores conversas acontecem ao redor de uma xícara quente, onde palavras fluem mais leves e histórias são contadas sem pressa.\n" +
                "\n" +
                "Entre um gole e outro, compartilhamos risadas, segredos e até silenciosas compreensões. O café, mais do que uma bebida, é um ritual de conexão – com os outros e consigo mesmo. Afinal, há algo mais aconchegante do que o calor de um café e uma boa companhia?");

        List<Post> lista = new ArrayList<>();
        lista.add(post);
        lista.add(post1);

        for (Post p:lista){
            repository.save(p);
            System.out.println(p.getId());
        }



    }




}
