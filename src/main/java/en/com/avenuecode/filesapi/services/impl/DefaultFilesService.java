package en.com.avenuecode.filesapi.services.impl;

import en.com.avenuecode.filesapi.services.FilesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class DefaultFilesService implements FilesService {

    @Override
    public ResponseEntity<String> retrieveFile(String fileName) {

        return new ResponseEntity<>("Test OK", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> saveFile(String fileName, MultipartFile multipartFile) {

        return new ResponseEntity<>("Test OK", HttpStatus.OK);
    }
}
