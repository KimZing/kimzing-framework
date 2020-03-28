package com.kimzing.domain;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 头条实体.
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/3/28 13:37
 */
@Data
public class HeadLine {
    private Long lineId;
    private String lineName;
    private  String lineLink;
    private String lineImg;
    private Integer priority;
    private Integer enableStatus;
    private LocalDateTime createTime;
    private LocalDateTime lastEditTime;
}
