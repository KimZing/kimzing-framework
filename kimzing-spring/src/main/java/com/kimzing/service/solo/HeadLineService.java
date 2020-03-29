package com.kimzing.service.solo;

import com.kimzing.domain.bo.HeadLine;
import com.kimzing.domain.dto.ApiResult;

import java.util.List;

/**
 * 头条服务.
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/3/29 23:25
 */
public interface HeadLineService {

    ApiResult<Boolean> add(HeadLine headLine);

    ApiResult<Boolean> remove(int id);

    ApiResult<Boolean> update(HeadLine headLine);

    ApiResult<HeadLine> queryById(int id);

    ApiResult<List<HeadLine>> queryByCondition(HeadLine headLineCondition, int page, int count);

}
