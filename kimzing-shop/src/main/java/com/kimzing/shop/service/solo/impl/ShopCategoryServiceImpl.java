package com.kimzing.shop.service.solo.impl;

import com.kimzing.framework.core.annotation.Service;
import com.kimzing.shop.domain.bo.HeadLine;
import com.kimzing.shop.domain.bo.ShopCategory;
import com.kimzing.shop.domain.dto.ApiResult;
import com.kimzing.shop.service.solo.ShopCategoryService;

import java.util.List;

/**
 * .
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/3/29 23:33
 */
@Service
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
