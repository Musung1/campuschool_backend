package com.example.campuschool_backend.util;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class FileUpload {
    public static String local(MultipartFile file) {
        String returnValue = "";
        try {
            String path ="Users/workspace/uploadfiles/";
            setDir(path);
            String fileName = setFileName(file);
            FileCopyUtils.copy(file.getBytes(), new File(path + fileName));
            returnValue = "/uploadfile/" + fileName;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return returnValue;
    }
    private static void setDir(String root_path){
        // 디랙토리 주소에 대해서, File 객체에 담음.(파일이 아니라, 폴더!!)
        File newfile = new File(root_path);
        // File 객체에 담긴 폴더가 존재하는지 물어봄!
        if(!newfile.exists()) {
            // File 객체에 담긴 폴더가 존재안하면 강제 생성!!
            newfile.mkdirs();
        }
    }
    public static String setFileName(MultipartFile mf){
        String result = "";
        if (mf == null || "".equals(mf.getOriginalFilename() + "")) {
        } else {
            Date date = new Date();
            String temp_date = date.getTime() + "";
            String filename = mf.getOriginalFilename();
            // sky_vew12.jpg
            String extension = StringUtils.getFilenameExtension(filename);
            // jpg
            if(extension == null || "".equals(extension)) {
                extension = "nnn";
            }
            filename = filename.replaceAll(" ", "");
			/*
			filename = "file" + "." + extension;
			 */
            // file.jpg
            result = temp_date + "_" + filename;
            // 92032037230952_file.jpg
        }
        return result;
    }
}
