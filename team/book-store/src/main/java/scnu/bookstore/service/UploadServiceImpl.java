package scnu.bookstore.service;

import lombok.extern.log4j.Log4j2;
import net.coobird.thumbnailator.Thumbnailator;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import scnu.bookstore.dto.Book_ImgDto;
import scnu.bookstore.repository.Book_ImgRepository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Log4j2
public class UploadServiceImpl implements UploadService{

    @Override
    public List<Book_ImgDto> uploadFile(MultipartFile[] files, String uploadPath) {

        List<Book_ImgDto> dtos = new ArrayList<>();

        for (MultipartFile file : files) {

            // 유효성 검사
            if (file.getContentType().startsWith("image") == false) {
                log.warn("this file is not image type");

                return null;
            }

            // file 이름 추출
            String originalName = file.getOriginalFilename();
            String fileName = originalName.substring(originalName.lastIndexOf("\\") + 1);

            // 폴더 경로 추출
            String folderPath = makeFolder(uploadPath);

            // UUID 생성
            String uuid = UUID.randomUUID().toString();

            // 저장이름 생성
            String saveName = uploadPath + File.separator + folderPath + File.separator + uuid
                    + "_" + fileName;

            // Path로 변환
            Path savePath = Paths.get(saveName);


            // 썸네일 생성
            try {
                file.transferTo(savePath);

                String thumbnailSaveName = uploadPath + File.separator + folderPath + File.separator + "s_" + uuid
                        + "_" + fileName;

                File thumbnailFile = new File(thumbnailSaveName);

                Thumbnailator.createThumbnail(savePath.toFile(), thumbnailFile, 100, 100);

                Book_ImgDto dto = Book_ImgDto.builder()
                        .imgName(fileName)
                        .uuid(uuid)
                        .path(saveName)
                        .build();

                dtos.add(dto);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return dtos;
    }

    private String makeFolder(String uploadPath) {

        String str = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));

        String folderPath = str.replace("//", File.separator);

        File uploadPathFolder = new File(uploadPath, folderPath);

        if (!uploadPathFolder.exists()) {
            uploadPathFolder.mkdirs();
        }

        return folderPath;
    }

    @Override
    public File getReal(String uploadPath, Long ino) {

    }

    @Override
    public File getFiction(String uploadPath, Long ino) {
        return null;
    }

    @Override
    public boolean remove(String uploadPath, Long ino) {
        return false;
    }
}
