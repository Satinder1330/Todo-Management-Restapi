package com.learning.todo.Todo_Manager.controllers;

import jakarta.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;


@RestController
@RequestMapping("/file")
public class FileController {

    Logger logger = LoggerFactory.getLogger(FileController.class);

    @PostMapping("/singleUpload")
    public String singleFile(@RequestParam("image") MultipartFile file) throws IOException {

        logger.info("Original file name: {}", file.getOriginalFilename());
        logger.info("Size of the file: {} bytes", file.getSize());
        logger.info("Type of the file: {}", file.getContentType());

        // Target directory: your folder path where you wish to save the file
        Path uploadPath = Paths.get("/Users/satindersingh/Desktop/write files");
        Path filePath = uploadPath.resolve(file.getOriginalFilename());
        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
        return "File uploaded and saved successfully";
    }

    //Handle Multiple files
    @PostMapping("/multiple")
    public ResponseEntity<String> multipleFiles(@RequestParam("files") MultipartFile[] files) throws IOException {

        Path uploadPath = Paths.get("/Users/satindersingh/Desktop/write files");

        for (MultipartFile file : files) {
            logger.info("file name is {}", file.getOriginalFilename());
            logger.info("type of the file is {}", file.getContentType());
            Path filePath = uploadPath.resolve(file.getOriginalFilename());
            Files.copy(
                    file.getInputStream(),
                    filePath,
                    StandardCopyOption.REPLACE_EXISTING
            );
        }

        return new ResponseEntity<>("Files are uploaded successfully", HttpStatus.OK);
    }


    @GetMapping("/getImage")
    public void getImage(HttpServletResponse response) throws IOException {


           FileInputStream inputStream =new FileInputStream("images/image1.png");//add images in the images dir
           response.setContentType(MediaType.IMAGE_JPEG_VALUE);
           StreamUtils.copy(inputStream,response.getOutputStream());



    }

    @GetMapping("getFile")
    public void getFile(HttpServletResponse response) throws IOException {

            FileInputStream inputStream =new FileInputStream("files/first.pdf");//add files in the files dir
            response.setContentType(MediaType.APPLICATION_PDF_VALUE);
            StreamUtils.copy(inputStream,response.getOutputStream());

    }

}
