package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.annotation.AutoFill;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.enumeration.OperationType;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {


    /**
     * 添加分类
     *
     * @param category
     */
    @AutoFill(OperationType.INSERT)
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
    @AutoFill(OperationType.UPDATE)
    void update(Category category);

    /**
     * 删除分类
     *
     * @param id
     */
    @Delete("delete from category where id = #{id}")
    void delete(long id);

    /**
     * 根据类型查询分类
     * @param type
     * @return
     */
    List<Category> list(Integer type);
}
