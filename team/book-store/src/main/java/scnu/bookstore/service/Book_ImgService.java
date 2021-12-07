package scnu.bookstore.service;

import org.springframework.web.multipart.MultipartFile;
import scnu.bookstore.dto.Book_ImgDto;

public interface Book_ImgService {

    void register(MultipartFile[] files, String uploadPath, Long bno);
}
