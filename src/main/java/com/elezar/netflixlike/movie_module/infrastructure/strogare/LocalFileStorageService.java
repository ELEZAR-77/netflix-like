package com.elezar.netflixlike.movie_module.infrastructure.strogare;

import jakarta.annotation.PostConstruct;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class LocalFileStorageService implements FileStorageService {

    private final Path videoDirectory = Paths.get("storage/videos");


    @Override
    public String saveVideo(MultipartFile file) {

        System.out.println("Absolute path: " + videoDirectory.toAbsolutePath());
        System.out.println("Exists: " + Files.exists(videoDirectory));
        System.out.println("Is directory: " + Files.isDirectory(videoDirectory));
        System.out.println("Writable: " + Files.isWritable(videoDirectory));


        try {
            if (file.isEmpty()) {
                throw new IllegalArgumentException("Video file is empty!");
            }

            String originalFileName = file.getOriginalFilename();

            String extention = "";

            if (originalFileName != null && originalFileName.contains(".")) {
                extention = originalFileName.substring(
                        originalFileName.lastIndexOf(".")
                );

                System.out.println(extention);
            }


            String generatedFilename =
                    UUID.randomUUID() + extention;

            Path targetPath = videoDirectory.resolve(generatedFilename);

            file.transferTo(targetPath);

            return targetPath.toString();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Resource loadVideo(String path) {
        return null;
    }

    @Override
    public void delete(String path) {

    }
}
