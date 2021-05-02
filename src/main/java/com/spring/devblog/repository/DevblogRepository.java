package com.spring.devblog.repository;

import com.spring.devblog.model.Post;

import org.springframework.data.jpa.repository.JpaRepository;



//jpa repository traz metodos de interação com o banco
public interface DevblogRepository extends JpaRepository<Post,Long> {
    // Post findById(long id);
    //    Não temos que escrever código de implementação porque
    //    Spring Data JPA irá gerar o código necessário em tempo de execução,
    //     na forma de instâncias de proxy.
    //    Portanto, o propósito de escrever a interface do repository é informar ao
    //    Spring Data JPA sobre o tipo de domínio
    //    ( Produto ) e o tipo de ID ( Longo ) com o qual trabalhar.

}
