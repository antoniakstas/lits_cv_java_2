package service;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileStorageService {

    private final Path fileStorageLocation;
    private Path fileStorageLocation1;

    public FileStorageService() {
        this.fileStorageLocation = Paths.get("myCustomDirectory/")
                .toAbsolutePath().normalize();
        this.fileStorageLocation1 = Paths.get("src/main/resources/image/product")
                .toAbsolutePath().normalize();


        try {
            Files.createDirectories(this.fileStorageLocation);
            Files.createDirectories(this.fileStorageLocation1);
        } catch (Exception ex) {
            throw new RuntimeException("Could not create the directory where the uploaded files will be stored.", ex);
        }
    }

    public String storeFile(MultipartFile file) {
        // Normalize file name
        String fileName =
                StringUtils
                        .cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if (fileName.contains("..")) {
                throw new RuntimeException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            // Copy file to the target location (Replacing existing file with the same name)
            Path targetLocation = this.fileStorageLocation.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

            return fileName;
        } catch (IOException ex) {
            throw
                    new RuntimeException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

    public String storeFile1(MultipartFile file, Long id) {
        // Normalize file name
        String fileName =
                StringUtils
                        .cleanPath(file.getOriginalFilename());
        Integer fileIndex = fileName.indexOf('.');
        String str = fileName.substring(fileIndex);
        String name = id + str;
        try {
            // Check if the file's name contains invalid characters
            if (name.contains("..")) {
                throw new RuntimeException("Sorry! Filename contains invalid path sequence " + name);
            }


            // Copy file to the target location (Replacing existing file with the same name)
            Path targetLocation = this.fileStorageLocation1.resolve(name);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

            return name;
        } catch (IOException ex) {
            throw
                    new RuntimeException("Could not store file " + name + ". Please try again!", ex);
        }
    }

    public Resource loadFileAsResource(String fileName) {
        try {
            Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if (resource.exists()) {
                return resource;
            } else {
                throw new RuntimeException("File not found " + fileName);
            }
        } catch (MalformedURLException ex) {
            throw new RuntimeException("File not found " + fileName, ex);
        }
    }

    public Resource loadFileAsResource1(String id) {
        try {
            Path filePath = this.fileStorageLocation1.resolve(id).normalize();
            Resource resource = new UrlResource(id);
            if (resource.exists()) {
                return resource;
            } else {
                throw new RuntimeException("File not found " + id);
            }
        } catch (MalformedURLException ex) {
            throw new RuntimeException("File not found " + id, ex);
        }
    }
}