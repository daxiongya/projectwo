package com.javasm.controller;

import com.javasm.utils.GetFileURL;
import org.csource.common.MyException;
import org.csource.fastdfs.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@CrossOrigin
public class FileDown {

    @PostMapping("fileupdown")
    public String fileupdown(MultipartFile file){
//        try {
//            ClientGlobal.initByProperties("fastdfs-client.properties");
//            TrackerClient trackerClient = new TrackerClient();
//            //追踪文件
//            TrackerServer trackerServer = trackerClient.getConnection();
//            //存储文件
//            StorageClient storageClient = new StorageClient(trackerServer,null);
//            String fileName =file.getOriginalFilename();
//            String ext = fileName.substring(fileName.lastIndexOf(".")+1);
//            String[] strings = storageClient.upload_file(file.getBytes(), ext, null);
//            for(String st:strings){
//                System.out.println(st);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        String urlFile = GetFileURL.getFileURL(file);
        return urlFile;
    }
}
