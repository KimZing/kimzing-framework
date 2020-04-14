package com.kimzing.controller.manager;

import com.kimzing.framework.core.annotation.Controller;
import com.kimzing.shop.domain.bo.HeadLine;
import com.kimzing.shop.domain.bo.ShopCategory;
import com.kimzing.shop.domain.dto.ApiResult;
import com.kimzing.shop.service.solo.ShopCategoryService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * .
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/3/30 00:02
 */
@Controller
public class ShopCategoryController {

    ShopCategoryService shopCategoryService;

    public ApiResult<Boolean> add(HttpServletRequest req, HttpServletResponse resp) {
        return shopCategoryService.add(new ShopCategory());
    }

    public ApiResult<Boolean> remove(HttpServletRequest req, HttpServletResponse resp) {
        return shopCategoryService.remove(1);
    }

    public ApiResult<Boolean> update(HttpServletRequest req, HttpServletResponse resp) {
        return shopCategoryService.update(new ShopCategory());
    }

    public ApiResult<HeadLine> queryById(HttpServletRequest req, HttpServletResponse resp) {
        return shopCategoryService.queryById(1);
    }

    public ApiResult<List<ShopCategory>> queryByCondition(HttpServletRequest req, HttpServletResponse resp) {
        return shopCategoryService.queryByCondition(new ShopCategory(), 1, 1000);
    }
}
