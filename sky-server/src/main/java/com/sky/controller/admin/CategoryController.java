package com.sky.controller.admin;

import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.properties.JwtProperties;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/category")
@Slf4j
@Api(tags = "分类管理")
public class CategoryController {

    @Autowired
    private JwtProperties jwtProperties;

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    @ApiOperation(value = "添加分类")
    public Result addCategory(@RequestBody CategoryDTO categoryDTO) {
        log.info("categoryDTO:{}", categoryDTO);
        categoryService.addCategory(categoryDTO);
        return Result.success();
    }

    @GetMapping("/page")
    @ApiOperation(value = "分页查询分类")
    public Result<PageResult> pageCategory(CategoryPageQueryDTO categoryPageQueryDTO) {
        PageResult pageResult = categoryService.pageCategory(categoryPageQueryDTO);
        return Result.success(pageResult);
    }

    @PostMapping("/status/{status}")
    @ApiOperation(value = "修改分类状态")
    public Result startOrStop(@PathVariable Integer status, long id) {
        categoryService.startOrStop(status, id);
        return Result.success();
    }

    @PutMapping
    @ApiOperation(value = "修改分类")
    public Result updateCategory(@RequestBody CategoryDTO categoryDTO) {
        categoryService.updateCategory(categoryDTO);
        return Result.success();
    }

    @DeleteMapping
    @ApiOperation(value = "删除分类")
    public Result deleteCategory(long id) {
        categoryService.deleteCategory(id);
        return Result.success();
    }

    /**
     * 根据类型查询分类
     * @param type
     * @return
     */
    @GetMapping("/list")
    @ApiOperation("根据类型查询分类")
    public Result<List<Category>> list(Integer type){
        List<Category> list = categoryService.list(type);
        return Result.success(list);
    }
}
