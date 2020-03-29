package com.kimzing.domain.dto;

import lombok.Data;

/**
 * 通用返回结果.
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/3/29 23:27
 */
@Data
public class ApiResult<T> {

    private Integer code;

    private String message;

    private T data;

}
