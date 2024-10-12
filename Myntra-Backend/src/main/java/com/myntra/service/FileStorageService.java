package com.myntra.service;

import com.myntra.model.MUpload;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


public interface FileStorageService {
    ResponseEntity<Resource> getFile(String fileName, String prefixFolder, String modelKey);
//    InputStream getFileAsResource(MUpload upload);
    MUpload uploadFile(MultipartFile file, String prefixFolder, String modelKey, String fileName) throws IOException;
//    MUpload uploadEncoded(MUpload uploaded);
//    MUpload uploadFile(ByteArrayOutputStream baos, String prefixFolder, String modelKey, String fileName,
//                       String contentType);
//    MUpload uploadFile(InputStream file, String prefixFolder, String modelKey, String fileName,
//                       String contentType);
//    MUpload uploadFile(String filePath, String prefixFolder, String modelKey, String fileName,
//                       String contentType);
//    MUpload internalUploadFile(InputStream file, String prefixFolder, String modelKey, String fileName,
//                               String contentType);
//    Boolean deleteObject(MUpload fileDetail);
}
