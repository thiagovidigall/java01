package br.com.vidigal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.vidigal.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {}