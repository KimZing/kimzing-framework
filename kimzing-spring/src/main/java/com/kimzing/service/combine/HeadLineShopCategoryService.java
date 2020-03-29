package com.kimzing.service.combine;

import com.kimzing.domain.dto.ApiResult;
import com.kimzing.domain.dto.MainPageInfoDTO;

/**
 * 首页服务.
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/3/29 23:26
 */
public interface HeadLineShopCategoryService {

    ApiResult<MainPageInfoDTO> getMainPage();

}
