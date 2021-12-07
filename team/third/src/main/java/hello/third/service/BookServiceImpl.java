package hello.third.service;

import hello.third.dto.BookDto;
import hello.third.entity.BookEntity;
import hello.third.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    @Override
    public void register(BookDto dto) {

        String uuid = UUID.randomUUID().toString();

        BookEntity bookEntity = dtoToEntity(dto);

        bookRepository.save(bookEntity);
    }

    @Override
    public List<BookDto> getList() {
        List<BookEntity> entities = bookRepository.findAll();

        List<BookDto> bookDtos = new ArrayList<>();

        entities.forEach(entity -> {
            BookDto bookDto = entityToDto(entity);
            bookDtos.add(bookDto);
        });

        return bookDtos;
    }

    @Override
    public BookDto read(Long bno) {

        Optional<BookEntity> entity = bookRepository.findById(bno);
        if (entity.isPresent()) {
            BookEntity bookEntity = entity.get();
            BookDto bookDto = entityToDto(bookEntity);

            return bookDto;
        }

        return null;

    }

    @Transactional
    @Override
    public BookEntity update(BookDto dto) {
        Long bno = dto.getBno();

        Optional<BookEntity> entity = bookRepository.findById(bno);

        if (entity.isPresent()) {
            BookEntity bookEntity = entity.get();

            BookEntity result = BookEntity.builder()
                    .bno(bookEntity.getBno())
                    .name(dto.getName())
                    .price(dto.getPrice())
                    .build();

            bookRepository.save(result);
        }

        return null;

    }

    @Transactional
    @Override
    public void remove(Long bno) {

        bookRepository.deleteById(bno);

    }
}
