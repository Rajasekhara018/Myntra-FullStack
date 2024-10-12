package com.myntra.serviceImpl;
import com.myntra.exception.FileStorageException;
import com.myntra.model.MUpload;
import com.myntra.service.FileStorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileStorageServiceImpl implements FileStorageService {

    @Value("${file.storage.path}")
    private String storagePath;
    private static final Logger logger = LoggerFactory.getLogger(FileStorageService.class);

    @Override
    public MUpload uploadFile(MultipartFile file, String prefixFolder, String modelKey, String fileName) throws IOException {
        Path directoryPath = Paths.get(prefixFolder, modelKey);
        Path filePath = directoryPath.resolve(fileName).normalize();
        if (!Files.exists(directoryPath)) {
            Files.createDirectories(directoryPath);
        }
        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
        if (!Files.exists(directoryPath)) {
            Files.createDirectories(directoryPath);
        }
        System.out.println("File will be stored at: " + filePath.toString());
        MUpload upl = new MUpload();
        upl.setName(fileName);
        upl.setFileType(file.getContentType());
        upl.setSize(file.getSize());
        upl.setLocation(String.valueOf(filePath));
        upl.setTitle(prefixFolder);
        upl.setPrefixFolder(prefixFolder);
        upl.setModelKey(modelKey);
        logger.info("TUpload value in touloc:::============================" + upl);
        return upl;
    }

    public ResponseEntity<Resource> getFile(String fileName, String prefixFolder, String modelKey) throws FileStorageException {
        try {
            Path fileStoragePath = Paths
                    .get(prefixFolder.concat("/").concat(modelKey).concat("/").concat(fileName));
            Resource resource = new UrlResource(fileStoragePath.toUri());
//            String mimeType = resource.getURL().openConnection().getContentType();
//            if (mimeType == null || mimeType.contains("unknown")) {
//                mimeType = "application/octet-stream";
//            }
            if (resource.exists()) {
                String filePath = prefixFolder.concat("/").concat(modelKey).concat("/").concat(fileName);
                Path path = Paths.get(filePath).normalize();
                String contentType = Files.probeContentType(path);
                return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType))
                        .header(HttpHeaders.CONTENT_DISPOSITION,
                                "attachment;" + path.getFileName().toString() + "\"")
                        .body(resource);
            } else {
                throw new FileStorageException("File not found " + fileName);
            }
        } catch (IOException ex) {
//        logger.info("Could not determine file type.");
//        logger.error("Error is ", ex);
        }
        return ResponseEntity.noContent().build();
    }
}

//        try {
////			file.getOriginalFilename()
//            String getext = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
//            if (!fileName.contains(getext)) {
//                logger.info("There is extension mismatch , get ext : ".concat(getext).concat(" original : ")
//                        .concat(file.getOriginalFilename()).concat(" : received :  ")
//                        .concat(file.getOriginalFilename()));
//            }
//
////            return this.load(prefixFolder, modelKey, fileName, file.getContentType(), file.getInputStream(), null, null,
////                    false);
//        } catch (IOException e) {
//            logger.error("Error is ", e);
//            return null;
//        }
//    }
//    private MUpload load(String prefixFolder, String modelKey, String fileName, String contentType, InputStream in,
//                         String filePath, ByteArrayOutputStream baos, boolean isInternalUploadedFile) {
//        logger.info("load method started in touloc:::============================");
//
//        enumHelper.PrefixFolder pf = null;
//        try {
//            pf = enumHelper.PrefixFolder.valueOf(prefixFolder);
//        } catch (Exception e) {
//            logger.error("Error is ", e);
//            return null;
//        }
//        if (!pf.isAllowedContentType(contentType, fileName)) {
//            logger.info("content type not allowed : ".concat(pf.name()).concat(" : ").concat(fileName));
//            return null;
//        }
//        // If Scan service is defined then call and check
//        if (in != null) {
//            baos = new ByteArrayOutputStream();
//            try {
//                IOUtils.copy(in, baos);
//            } catch (IOException e) {
//                logger.error("Error is ", e);
//            }
//        } else {
//            if (baos != null) {
//                in = new ByteArrayInputStream(baos.toByteArray());
//            }
//        }
//
////        if (!isInternalUploadedFile) {
////            if (!this.iService.scanAttachement(in, this.getAllianceOrgModelKeyOfUser())) {
////                return null;
////            }
////        }
//
//        return this.loadInternal(prefixFolder, modelKey, fileName, contentType, filePath, baos);
//    }
//    private MUpload loadInternal(String prefixFolder, String modelKey, String fileName, String contentType,
//                                 String filePath, ByteArrayOutputStream baos) {
//        logger.info("loadInternal method started in touloc:::============================");
//
////        GeneralConfiguration genConfigObj = genConfService.findOne(AppConstant.GENERAL_CONFIG, Backpack.get());
//        FileStorageEngine storageEngineObj = genConfigObj.getFileStorage();
//        logger.info("storageEngineObj in touloc:::============================" + storageEngineObj);
//        enumHelper.PrefixFolder pf = null;
//        try {
//            pf = enumHelper.PrefixFolder.valueOf(prefixFolder);
//        } catch (Exception e) {
//            logger.error("Error is ", e);
//            return null;
//        }
//        return loadIntoFileStorage(storageEngineObj.getFileUploadDir(), pf, modelKey, contentType, fileName, filePath,
//                baos);
//    }
//    private MUpload loadIntoFileStorage(String uploadDir, enumHelper.PrefixFolder prefixFolder, String modelKey, String fileType,
//                                        String name, String filePath, ByteArrayOutputStream baos) {
//        logger.info("loadIntoFileStorage method started in touloc:::============================");
//
//        String fileName = this.getFileName();
//        if (name != null) {
//            fileName = name;
//        }
//        logger.info("fileName in touloc:::============================" + fileName);
//
//        Path fileStoragePath = Paths.get(uploadDir.concat("/").concat(this.profile).concat("/")
//                .concat(this.getLocation(prefixFolder, modelKey, null))).normalize();
//        logger.info("fileStoragePath in touloc:::============================" + fileStoragePath);
//
//        try {
//            Files.createDirectories(fileStoragePath);
//        } catch (Exception ex) {
//            logger.info("File storage path -- > " + fileStoragePath);
//            logger.info("Exception occurred in loadIntoFileStorage() method --> " + ex);
//            logger.error("Error is ", ex);
//            throw new FileStorageException("Could not create the directory where the uploaded files will be stored.",
//                    ex);
//        }
//        try {
//            Path targetLocation = fileStoragePath.resolve(fileName).normalize();
//
//            if (baos != null) {
//                ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
//                Files.copy(bais, targetLocation, StandardCopyOption.REPLACE_EXISTING);
//            } else {
//                Files.copy(Paths.get(filePath), targetLocation);
//            }
////			Set<PosixFilePermission> ownerWritable = PosixFilePermissions.fromString("rwxr--r--");
//            Set<PosixFilePermission> ownerWritable = PosixFilePermissions.fromString("rwxrwxrwx");
//            Files.setPosixFilePermissions(targetLocation, ownerWritable);
//        } catch (IOException ex) {
//            logger.error("Error is ", ex);
//            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
//
//        } catch (Exception e) {
//            logger.error("Error is ", e);
//            return null;
//        }
//        if (name == null) {
//            name = fileName;
//        }
//        MUpload upl = new MUpload();
//        upl.setName(fileName);
//        upl.setFileType(fileType);
//        upl.setSize(0);
//        upl.setLocation(this.getLocation(prefixFolder, modelKey, fileName));
//        upl.setTitle(name);
//        upl.setPrefixFolder(prefixFolder.name());
//        upl.setModelKey(modelKey);
////        upl.setRetentionPolicy(AppConstant.getRetentionBucket(prefixFolder));
//        logger.info("TUpload value in touloc:::============================" + upl);
//        return upl;
//    }
//    private String getLocation(enumHelper.PrefixFolder prefix, String modelKey, String fileName) {
//        enumHelper.FileRetentionPolicyEnum retentionPolicy = enumHelper.FileRetentionPolicyEnum.valueOf("RENTENTION_LONG");
//        String ret = retentionPolicy.name().concat("/").concat(prefix.name());
//        logger.info("inside retention===" + ret);
//        if (modelKey != null) {
//            ret = ret.concat("/").concat(modelKey);
//        }
//        if (fileName != null) {
//            return ret.concat("/").concat(fileName);
//        }
//        return ret;
//
//    }
//
//    private String getFileName() {
//        String genFileName = "fs-".concat(String.valueOf(System.currentTimeMillis()));
//        return genFileName;
//    }
//}
