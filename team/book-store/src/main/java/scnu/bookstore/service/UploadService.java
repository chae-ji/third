package scnu.bookstore.service;

import org.springframework.web.multipart.MultipartFile;
import scnu.bookstore.dto.Book_ImgDto;

import java.io.File;
import java.util.List;

public interface UploadService {

    List<Book_ImgDto> uploadFile(MultipartFile[] files, String uploadPath);

    File getReal(String uploadPath, Long ino);

    File getFiction(String uploadPath, Long ino);

    boolean remove(String uploadPath, Long ino);
}
