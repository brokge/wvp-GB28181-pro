package com.genersoft.iot.vmp.conf;

import com.alibaba.fastjson.JSON;
import com.genersoft.iot.vmp.vmanager.bean.ErrorCode;
import com.genersoft.iot.vmp.vmanager.bean.WVPResult;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 全局统一返回结果
 */
@RestControllerAdvice
public class GlobalResponseAdvice implements ResponseBodyAdvice<Object> {


    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        // 排除api文档的接口，这个接口不需要统一
        String[] excludePath = {"/v3/api-docs","/api/v1"};
        for (String path : excludePath) {
            if (request.getURI().getPath().startsWith(path)) {
                return body;
            }
        }

        if (body instanceof WVPResult) {
            return body;
        }

        if (body instanceof ErrorCode) {
            ErrorCode errorCode = (ErrorCode) body;
            return new WVPResult<>(errorCode.getCode(), errorCode.getMsg(), null);
        }

        if (body instanceof String) {
            return JSON.toJSON(WVPResult.success(body));
        }

        return WVPResult.success(body);
    }
}
