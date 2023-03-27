package en.com.avenuecode.filesapi.services.impl;

import en.com.avenuecode.filesapi.services.FilesService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.*;

@Service
public class DefaultFilesService implements FilesService {

    public static final String LINE_SEPARATOR = "\r\n";

    private final Path uploadPath = Paths.get("uploads/");

    public DefaultFilesService() {
        try {
            Files.createDirectories(uploadPath);
        } catch (IOException e) {
            throw new RuntimeException("Couldn't create uploads folder!", e);
        }
    }

    @Override
    public ResponseEntity<String> retrieveFile(String fileName) {

        try {
            Path file = uploadPath.resolve(fileName);
            if (Files.exists(file) && Files.isReadable(file)) {
                List<String> fileLines = Files.lines(file).collect(Collectors.toList());
                return new ResponseEntity<>(String.join(LINE_SEPARATOR, fileLines), OK);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return new ResponseEntity<>("File not found!", BAD_REQUEST);
    }

    @Override
    public ResponseEntity<String> saveFile(String fileName, MultipartFile multipartFile) {

        try {
            Files.copy(multipartFile.getInputStream(), uploadPath.resolve(fileName), StandardCopyOption.REPLACE_EXISTING);
            return new ResponseEntity<>(CREATED);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
