package com.javasm.utils;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class GetFileURL {
    private static StorageClient storageClient;
    static{
        try {
            ClientGlobal.initByProperties("fastdfs-client.properties");
            TrackerClient trackerClient = new TrackerClient();
            TrackerServer trackerServer = trackerClient.getConnection();
            storageClient = new StorageClient(trackerServer,null);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }
    }
    public static String getFileURL(MultipartFile file){
        String fileName = file.getOriginalFilename();
        String ext = fileName.substring(fileName.lastIndexOf(".")+1);
        try {
            String[] strings = storageClient.upload_file(file.getBytes(), ext, null);
            return "http://192.168.20.252:8111"+File.separator+strings[0]+File.separator+strings[1];
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
