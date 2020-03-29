package com.kimzing.controller.manager;

import com.kimzing.domain.bo.HeadLine;
import com.kimzing.domain.dto.ApiResult;
import com.kimzing.service.solo.HeadLineService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * .
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/3/30 00:02
 */
public class HeadLineController {

    HeadLineService headLineService;

    public ApiResult<Boolean> add(HttpServletRequest req, HttpServletResponse resp) {
        return headLineService.add(new HeadLine());
    }

    public ApiResult<Boolean> remove(HttpServletRequest req, HttpServletResponse resp) {
        return headLineService.remove(1);
    }

    public ApiResult<Boolean> update(HttpServletRequest req, HttpServletResponse resp) {
        return headLineService.update(new HeadLine());
    }

    public ApiResult<HeadLine> queryById(HttpServletRequest req, HttpServletResponse resp) {
        return headLineService.queryById(1);
    }

    public ApiResult<List<HeadLine>> queryByCondition(HttpServletRequest req, HttpServletResponse resp) {
        return headLineService.queryByCondition(new HeadLine(), 1, 1000);
    }
}
