package com.sky.controller.admin;

import com.sky.constant.MessageConstant;
import com.sky.result.Result;
import com.sky.service.DishService;
import com.sky.utils.AliOssUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/admin/common")
@Slf4j
@Api(value = "CommonController", tags = {"公共接口"})
public class CommonController {

    @Autowired
    private AliOssUtil aliOssUtil;



    @PostMapping("/upload")
    @ApiOperation("上传文件")
    public Result<String> upload(MultipartFile file) {
        log.info("开始上传文件");
        try {

            String originalFilename = file.getOriginalFilename();
            String substring = originalFilename.substring(originalFilename.lastIndexOf("."));
            String newName = UUID.randomUUID() + substring;
            String url = aliOssUtil.upload(file.getBytes(), newName);
            log.info("上传文件成功，文件地址：{}", url);
            return Result.success(url);
        } catch (IOException e) {
            log.error("上传文件失败:", e);
        }
        return Result.error(MessageConstant.UPLOAD_FAILED);
    }
}
