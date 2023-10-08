package com.sky.service;

import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.result.PageResult;

import java.util.List;

public interface CategoryService {


    /**
     * 添加分类
     *
     * @param categoryDTO
     */
    void addCategory(CategoryDTO categoryDTO);


    /**
     * 分页查询分类
     *
     * @param categoryPageQueryDTO
     * @return
     */
    PageResult pageCategory(CategoryPageQueryDTO categoryPageQueryDTO);

    /**
     * 修改分类状态
     *
     * @param status
     * @param id
     */
    void startOrStop(Integer status, long id);

    /**
     * 修改分类
     *
     * @param categoryDTO
     */
    void updateCategory(CategoryDTO categoryDTO);

    /**
     * 删除分类
     *
     * @param id
     */
    void deleteCategory(long id);

    /**
     * 查询分类
     *
     * @param type
     * @return
     */
    List<Category> list(Integer type);
}
