package com.sky.controller.admin;

import com.sky.constant.ShopConstant;
import com.sky.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

@RestController("adminShopController")
@RequestMapping("/admin/shop")
@Api(value = "ShopController", tags = {"店铺相关接口"})
@Slf4j
public class ShopController {

    @Autowired
    private RedisTemplate redisTemplate;



    @PutMapping("/{status}")
    @ApiOperation("设置店铺状态")
    public Result setStatus(@PathVariable Integer status) {
        log.info("设置店铺状态为:{}", status == 1 ? "开启" : "关闭");
        redisTemplate.opsForValue().set(ShopConstant.SHOP_STATUS, status);
        return Result.success();
    }


    @GetMapping("/status")
    @ApiOperation("获取店铺状态")
    public Result<Integer> getStatus() {
        Integer status = (Integer) redisTemplate.opsForValue().get(ShopConstant.SHOP_STATUS);
        log.info("获取店铺状态为：{}", status == 1 ? "开启" : "关闭");
        return Result.success(status);
    }


}
