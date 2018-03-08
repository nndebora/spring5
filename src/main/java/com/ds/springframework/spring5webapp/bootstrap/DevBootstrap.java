package com.ds.springframework.spring5webapp.bootstrap;

import com.ds.springframework.spring5webapp.model.Author;
import com.ds.springframework.spring5webapp.model.Book;
import com.ds.springframework.spring5webapp.model.Publisher;
import com.ds.springframework.spring5webapp.repositories.AuthorRepository;
import com.ds.springframework.spring5webapp.repositories.BookRepository;
import com.ds.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }
    private void initData(){

        //Deb
        Author deb = new Author("Deb", "Nascimento");
        Publisher poli = new Publisher("POLI","Rua Benfica");
        Book fss = new Book("Fish School Search", poli, "1234");
        deb.getBooks().add(fss);
        fss.getAuthors().add(deb);
        publisherRepository.save(poli);
        authorRepository.save(deb);
        bookRepository.save(fss);

        //Eron
        Author eron = new Author("Eron","Lopes");
        Book pso = new Book("Particle Swarm Optimization", poli, "1235");
        eron.getBooks().add(pso);
        pso.getAuthors().add(eron);
        authorRepository.save(eron);
        bookRepository.save(pso);


    }



}
