package com.kimzing.service.solo.impl;

import com.kimzing.domain.bo.HeadLine;
import com.kimzing.domain.bo.ShopCategory;
import com.kimzing.domain.dto.ApiResult;
import com.kimzing.service.solo.ShopCategoryService;

import java.util.List;

/**
 * .
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/3/29 23:33
 */
public class ShopCategoryServiceImpl implements ShopCategoryService {
    @Override
    public ApiResult<Boolean> add(ShopCategory shopCategory) {
        return null;
    }

    @Override
    public ApiResult<Boolean> remove(int id) {
        return null;
    }

    @Override
    public ApiResult<Boolean> update(ShopCategory shopCategory) {
        return null;
    }

    @Override
    public ApiResult<HeadLine> queryById(int id) {
        return null;
    }

    @Override
    public ApiResult<List<ShopCategory>> queryByCondition(ShopCategory shopCategoryCondition, int page, int count) {
        return null;
    }
}
