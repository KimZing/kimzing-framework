package com.kimzing.shop.domain.dto;

import com.kimzing.shop.domain.bo.HeadLine;
import com.kimzing.shop.domain.bo.ShopCategory;
import lombok.Data;

import java.util.List;

/**
 * 首页数据实体.
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/3/29 23:34
 */
@Data
public class MainPageInfoDTO {

    List<HeadLine> headLines;

    List<ShopCategory> shopCategories;

}
