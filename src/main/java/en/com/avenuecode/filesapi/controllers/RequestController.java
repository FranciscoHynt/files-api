package en.com.avenuecode.filesapi.controllers;

import en.com.avenuecode.filesapi.services.FilesService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class RequestController {

    final FilesService filesService;

    public RequestController(FilesService filesService) {
        this.filesService = filesService;
    }

    @RequestMapping(value = "/uploader", method = RequestMethod.POST)
    public ResponseEntity uploader(@RequestParam("fileName") String fileName, @RequestParam("file") MultipartFile file) {

        return filesService.saveFile(fileName, file);
    }

    @RequestMapping(value = "/downloader", method = RequestMethod.GET)
    public ResponseEntity<String> downloader(@RequestParam String fileName) {
        return filesService.retrieveFile(fileName);
    }
}
