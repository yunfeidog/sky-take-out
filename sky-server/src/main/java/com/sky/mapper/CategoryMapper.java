package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CategoryMapper {


    /**
     * 添加分类
     *
     * @param category
     */
    void insert(Category category);


    /**
     * @param categoryPageQueryDTO
     * @return
     */
    Page<Category> pageCategory(CategoryPageQueryDTO categoryPageQueryDTO);

    /**
     * 更新分类
     *
     * @param category
     */
    void update(Category category);

    /**
     * 删除分类
     *
     * @param id
     */
    @Delete("delete from category where id = #{id}")
    void delete(long id);
}
