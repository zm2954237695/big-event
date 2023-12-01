package com.guo.event.controller;


import com.guo.event.pojo.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping
public class FileUploadController {

    @PostMapping("/upload")
    public Result<String> upload(MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();
        String filename = UUID.randomUUID() +originalFilename.substring(originalFilename.indexOf("."));
        file.transferTo(new File("C:\\Users\\逐梦\\Desktop\\files"+filename));
        return Result.success("url访问地址...");
    }
}
