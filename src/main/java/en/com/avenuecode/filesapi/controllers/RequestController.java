package en.com.avenuecode.filesapi.controllers;

import en.com.avenuecode.filesapi.services.FilesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class RequestController {

    final FilesService filesService;

    public RequestController(FilesService filesService) {
        this.filesService = filesService;
    }

    @RequestMapping(value = "/uploader", method = RequestMethod.POST)
    public ResponseEntity uploader(@RequestBody String fileName, @RequestBody MultipartFile file) {

        return filesService.saveFile(fileName, file);
    }

    @RequestMapping(value = "/downloader", method = RequestMethod.GET)
    public ResponseEntity<String> downloader(@RequestBody String fileName) {
        return filesService.retrieveFile(fileName);
    }
}
