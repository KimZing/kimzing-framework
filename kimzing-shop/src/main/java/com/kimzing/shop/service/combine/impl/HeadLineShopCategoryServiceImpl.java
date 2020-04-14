package com.kimzing.shop.service.combine.impl;

import com.kimzing.framework.core.annotation.Service;
import com.kimzing.shop.domain.bo.HeadLine;
import com.kimzing.shop.domain.bo.ShopCategory;
import com.kimzing.shop.domain.dto.ApiResult;
import com.kimzing.shop.domain.dto.MainPageInfoDTO;
import com.kimzing.shop.service.combine.HeadLineShopCategoryService;
import com.kimzing.shop.service.solo.HeadLineService;
import com.kimzing.shop.service.solo.ShopCategoryService;

import java.util.List;

/**
 * .
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/3/29 23:35
 */
@Service
public class HeadLineShopCategoryServiceImpl implements HeadLineShopCategoryService {

    HeadLineService headLineService;

    ShopCategoryService shopCategoryService;

    @Override
    public ApiResult<MainPageInfoDTO> getMainPage() {
        HeadLine headLine = new HeadLine();
        headLine.setEnableStatus(1);
        ApiResult<List<HeadLine>> headLinesResult = headLineService.queryByCondition(headLine, 1, 4);
        ShopCategory shopCategory = new ShopCategory();
        ApiResult<List<ShopCategory>> shopCategorysResult = shopCategoryService.queryByCondition(shopCategory, 1, 10);
        ApiResult<MainPageInfoDTO> result = combineResult(headLinesResult, shopCategorysResult);
        return result;
    }

    private ApiResult<MainPageInfoDTO> combineResult(ApiResult<List<HeadLine>> headLinesResult, ApiResult<List<ShopCategory>> shopCategorysResult) {
        return null;
    }
}
