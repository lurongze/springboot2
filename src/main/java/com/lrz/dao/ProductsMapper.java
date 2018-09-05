package com.lrz.dao;

import com.lrz.core.Mapper;
import com.lrz.model.Products;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsMapper extends Mapper<Products> {

    List<Products> getList(@Param("unionId") String unionId, @Param("cid") Integer cid, @Param("isShow") Integer isShow, @Param("isRecommend") Integer isRecommend);

}