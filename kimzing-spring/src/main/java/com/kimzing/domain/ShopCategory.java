package com.kimzing.domain;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 类别实体.
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/3/28 13:37
 */
@Data
public class ShopCategory {
    private Long shopCategoryId;
    private String shopCategoryName;
    private String shopCategoryDesc;
    private String shopCategoryImg;
    private Integer priority;
    private LocalDateTime createTime;
    private LocalDateTime lastEditTime;
    private ShopCategory parent;
}
