package spring.boot.demo.common;


import com.alibaba.fastjson.JSON;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class Response<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description = "业务返回码 1 成功 0 失败")
    private final int code;

    @Schema(description = "业务状态码 200 成功 300+ 失败")
    private final int status;

    @Schema(description = "提示信息")
    private final String message;

    @Schema(description = "响应数据")
    private final T data;

    private Response(int code, int status, String message, T data) {
        this.code = code;
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public static <D> Response<D> success() {
        return new Response<>(1, 200, "success", null);
    }

    public static <D> Response<D> success(D data) {
        return new Response<>(1, 200, "success", data);
    }

    public static <D> Response<D> success(String message, D data) {
        return new Response<>(1, 200, message, data);
    }

    public static <D> Response<D> failure() {
        return new Response<>(0, 300, "failure", null);
    }

    public static <D> Response<D> failure(String message) {
        return new Response<>(0, 300, message, null);
    }

    public static <D> Response<D> failure(int status, String message) {
        return new Response<>(0, status, message, null);
    }

    public static <D> Response<D> failure(int status, String message, D data) {
        return new Response<>(0, status, message, data);
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

    public String toString(boolean raw) {
        return raw ? super.toString() : this.toString();
    }

}
