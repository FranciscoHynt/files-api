package en.com.avenuecode.filesapi.services.impl;

import en.com.avenuecode.filesapi.services.FilesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class DefaultFilesService implements FilesService {

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

        return new ResponseEntity<>("Test OK", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> saveFile(String fileName, MultipartFile multipartFile) {

        try {
            Files.copy(multipartFile.getInputStream(), uploadPath.resolve(fileName));
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
