package me.silvio.gutenfree;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.silvio.gutenfree.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

}
