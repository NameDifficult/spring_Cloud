package com.fu.springCloud.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 通用的前端json数据串
 * @param <T>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private Integer code;//200 404
    private String message;
    private T data;
    public CommonResult(Integer code , String message){
        this(code,message,null);
    }
}
