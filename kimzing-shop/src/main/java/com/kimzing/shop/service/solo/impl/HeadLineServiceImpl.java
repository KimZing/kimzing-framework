package com.kimzing.service.solo.impl;

import com.kimzing.framework.core.annotation.Service;
import com.kimzing.shop.domain.bo.HeadLine;
import com.kimzing.shop.domain.dto.ApiResult;
import com.kimzing.shop.service.solo.HeadLineService;

import java.util.List;

/**
 * .
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/3/29 23:33
 */
@Service
public class HeadLineServiceImpl implements HeadLineService {
    @Override
    public ApiResult<Boolean> add(HeadLine headLine) {
        return null;
    }

    @Override
    public ApiResult<Boolean> remove(int id) {
        return null;
    }

    @Override
    public ApiResult<Boolean> update(HeadLine headLine) {
        return null;
    }

    @Override
    public ApiResult<HeadLine> queryById(int id) {
        return null;
    }

    @Override
    public ApiResult<List<HeadLine>> queryByCondition(HeadLine headLineCondition, int page, int count) {
        return null;
    }
}
