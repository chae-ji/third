package scnu.bookstore.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import scnu.bookstore.dto.BookDto;
import scnu.bookstore.dto.Book_ImgDto;
import scnu.bookstore.entity.BookEntity;
import scnu.bookstore.entity.Book_ImgEntity;
import scnu.bookstore.entity.CategoryEntity;
import scnu.bookstore.repository.BookRepository;
import scnu.bookstore.repository.Book_ImgRepository;
import scnu.bookstore.repository.CategoryRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Log4j2
@RequiredArgsConstructor
public class BookServiceImpl implements BookService{

    private final BookRepository bookRepository;

    private final CategoryRepository categoryRepository;

    private final Book_ImgRepository book_imgRepository;

    private final UploadService uploadService;

    @Override
    @Transactional
    public Long register(MultipartFile[] files,String uploadPath, BookDto dto) {

        Optional<CategoryEntity> result = categoryRepository.findByCategoryName(dto.getDepartment());

        if (result.isPresent()) {
            CategoryEntity department = result.get();

            log.info(department);

            BookEntity bookEntity = dtoToEntity(dto, department);

            List<Book_ImgDto> book_imgDtos = uploadService.uploadFile(files, uploadPath);

            for (Book_ImgDto book_imgDto : book_imgDtos) {
                Book_ImgEntity book_imgEntity = Book_ImgEntity.builder()
                        .iname(book_imgDto.getImgName())
                        .uuid(book_imgDto.getUuid())
                        .path(book_imgDto.getPath())
                        .bookEntity(bookEntity)
                        .build();

                book_imgRepository.save(book_imgEntity);

            }
            return bookRepository.save(bookEntity).getBno();
        }
        return null;
    }

    @Transactional
    @Override
    public List<BookDto> getList() {
        
        List<BookEntity> bookEntities = bookRepository.findAll();

        List<BookDto> bookDtos = new ArrayList<>();

        bookEntities.stream().forEach(bookEntity -> {
            BookDto bookDto = BookDto.builder()
                    .bno(bookEntity.getBno())
                    .bookName(bookEntity.getBookName())
                    .price(bookEntity.getPrice())
                    .isNew(bookEntity.isNew())
                    .department(bookEntity.getCategory().getCategoryName())
                    .college(bookEntity.getCategory().getCollege())
                    .regDate(bookEntity.getRegdate())
                    .build();

            bookDtos.add(bookDto);
        });

        return bookDtos;
    }

    @Transactional
    @Override
    public BookDto read(Long bno) {
        Optional<BookEntity> result = bookRepository.findById(bno);

        if (result.isPresent()) {

            BookEntity bookEntity = result.get();

            BookDto bookDto = entityToDto(bookEntity);

            return bookDto;
        }

        return null;

    }

    @Transactional
    @Override
    public Long update(BookDto dto) {

        Optional<CategoryEntity> categoryResult = categoryRepository.findByCategoryName(dto.getDepartment());

        if (categoryResult.isPresent()) {
            CategoryEntity department = categoryResult.get();

            Optional<BookEntity> bookResult = bookRepository.findById(dto.getBno());

            if (bookResult.isPresent()) {

                BookEntity bookEntity = BookEntity.builder()
                        .bno(dto.getBno())
                        .bookName(dto.getBookName())
                        .isNew(dto.isNew())
                        .category(department)
                        .price(dto.getPrice())
                        .build();

                return bookRepository.save(bookEntity).getBno();
            }

            return null;

        }

        return null;

    }

    @Transactional
    @Override
    public void remove(Long bno) {

        bookRepository.deleteById(bno);

    }
}
