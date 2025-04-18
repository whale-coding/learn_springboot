package com.star.controller;

import com.star.common.Result;
import com.star.utils.AliOssUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @Classname: FileUploadController
 * @Date: 2024/12/6 14:55
 * @Author: 聂建强
 * @Description: 文件上传接口
 */
@RestController
public class FileUploadController {

    @PostMapping("/upload")
    public Result<String> upload(MultipartFile file) throws IOException{
        // 把文件的内容存储到本地磁盘上
        String originalFilename = file.getOriginalFilename();  // 得到原始文件名
        // 保证文件名是唯一的，防止文件覆盖
        assert originalFilename != null;
        String filename = UUID.randomUUID().toString() + originalFilename.substring(originalFilename.lastIndexOf("."));
        // file.transferTo(new File("/Users/macbook/Desktop/"+filename));  // 将文件移动到指定目录

        // 使用阿里云工具类将图片上传到阿里云
        String url = AliOssUtil.uploadFile(filename, file.getInputStream());
        return Result.success(url);
    }
}
