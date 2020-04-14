package com.kimzing.shop.service.solo;

import com.kimzing.shop.domain.bo.HeadLine;
import com.kimzing.shop.domain.bo.ShopCategory;
import com.kimzing.shop.domain.dto.ApiResult;

import java.util.List;

/**
 * 头条服务.
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/3/29 23:26
 */
public interface ShopCategoryService {
    ApiResult<Boolean> add(ShopCategory shopCategory);

    ApiResult<Boolean> remove(int id);

    ApiResult<Boolean> update(ShopCategory shopCategory);

    ApiResult<HeadLine> queryById(int id);

    ApiResult<List<ShopCategory>> queryByCondition(ShopCategory shopCategoryCondition, int page, int count);
}
