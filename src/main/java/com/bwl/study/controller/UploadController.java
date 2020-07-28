package com.bwl.study.controller;

import com.bwl.study.utils.FileUploadUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @author BW Li
 * @date 2020-07-20 11:11
 * @description
 */
@RestController
@RequestMapping(value = "/api/file")
public class UploadController {

    @RequestMapping("/upload")
    public void upload(HttpServletRequest httpServletRequest, MultipartFile file) throws Exception {
        byte[] bytes = file.getBytes();
        FileUploadUtil.fileUpload(bytes,"apps/pdf/fileOutput/","333.pdf");

    }

    @RequestMapping("/getIn")
    public void getIn() throws Exception {
        FileUploadUtil.getInputStream("/apps/pdf/fileInput/DNK.pdf");

    }
}
