package com.myntra.controller;

import com.myntra.constants.enumHelper;
import com.myntra.model.MUpload;
import com.myntra.model.ResponseObject;
import com.myntra.service.FileStorageService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.Resource;
import java.io.IOException;

@RestController
@RequestMapping("flipkart")
@CrossOrigin(origins = "http://localhost:4201")
public class FileStorageController {

    @Autowired
    FileStorageService fileStorageService;

    @PostMapping(value = {"/file/upload"})
//    @Operation(summary = "It will upload the files")
    public ResponseObject fileUpload(@RequestParam("file") MultipartFile file,
                                     @RequestParam("prefixFolder") String prefixFolder, @RequestParam("modelKey") String key,
                                     @RequestParam("filename") String filename) throws IOException {
        if (filename == null) {
            filename = "fileUploaded";
        }
        MUpload fileUpload = this.fileStorageService.uploadFile(file, prefixFolder, key, filename);
//        logger.info("fileUpload:::============================"+fileUpload);
        if (fileUpload == null) {
//            logger.info("File not uploaded");
            ResponseObject resp = new ResponseObject();
//            ResponseObject resp = new ResponseObject(enumHelper.MessageEnum.APP_CREATE_V1, enumHelper.CRUDEnum.LIST, fileUpload);
            resp.setSuccess(false);
            return resp;
        } else {
            ResponseObject resp = new ResponseObject();
            resp.setObject(fileUpload);
//            logger.info("File not null");
//            logger.info(fileUpload.toString());
//            ResponseObject resp = new ResponseObject(enumHelper.MessageEnum.APP_CREATE_V1, enumHelper.CRUDEnum.LIST, fileUpload);
            resp.setSuccess(true);
            return resp;
        }
    }

    @GetMapping("/file/download/{prefixFolder:.+}/{modelKey:.+}/{fileName:.+}")
//    @Operation(summary = "It will download the files")
    public ResponseEntity<Resource> downloadFile(@PathVariable String prefixFolder, @PathVariable String modelKey,
                                                 @PathVariable String fileName, HttpServletRequest request) {
        return this.fileStorageService.getFile(fileName, prefixFolder, modelKey);
    }

}
