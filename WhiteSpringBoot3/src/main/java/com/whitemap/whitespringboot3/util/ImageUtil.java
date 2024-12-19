package com.whitemap.whitespringboot3.util;

import org.springframework.boot.system.ApplicationHome;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.UUID;

public class ImageUtil {
    public static String uploadImage(MultipartFile file) throws IOException {
        if (file.isEmpty())
            throw new FileNotFoundException();
        String fileName = file.getOriginalFilename();
        int idx = fileName.lastIndexOf(".");
        if(idx == -1)
            throw new IOException("no extension");
        String ext = fileName.substring(idx);
        if(!ext.equals("jpg") && !ext.equals("jpeg") && !ext.equals("png"))
            throw new IOException("not a valid extension");
        String uuid = UUID.randomUUID().toString().replace("-", "");
        //上传图片
        ApplicationHome appHome = new ApplicationHome(ImageUtil.class);
        String pre = appHome.getDir().getParentFile().getParentFile().getAbsolutePath() +
                File.separator + "src"+File.separator+"main"+File.separator+"resources"+File.separator+"images"+File.separator;
        String path = pre+uuid+ext;
        file.transferTo(new File(path));
        return path;
    }

    public static void deleteImage(String path) throws IOException {
        File file = new File(path);
        if(file.exists())
            file.delete();
    }
}
