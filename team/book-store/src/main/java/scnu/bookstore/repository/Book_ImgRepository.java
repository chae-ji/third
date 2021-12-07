package scnu.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import scnu.bookstore.entity.Book_ImgEntity;

public interface Book_ImgRepository extends JpaRepository<Book_ImgEntity, Long> {
}
