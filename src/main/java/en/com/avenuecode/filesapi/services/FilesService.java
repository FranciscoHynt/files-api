package en.com.avenuecode.filesapi.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface FilesService {

    ResponseEntity<String> retrieveFile(String fileName);

    ResponseEntity<String> saveFile(String fileName, MultipartFile multipartFile);
}
