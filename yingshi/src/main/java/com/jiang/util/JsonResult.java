package com.jiang.util;



enum StatusCode{

    success(1,"成功"),

    error(0,"失败");

    private String message;

    private Integer code;

    // 构造方法
    private StatusCode(int index,String name) {
        this.message = name;
        this.code = index;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
};




public class JsonResult<T> {

    private Integer code;

    private String message;

    public Integer getCode() {
        return code;
    }
    private T data;


    public  JsonResult()
    {

    }

    public  JsonResult(Integer code)
    {
        this.code = code;
    }

    public  JsonResult(Integer code,String msg)
    {
        this.code = code;
        this.message = msg;
    }

    public  JsonResult(Integer code,String msg,T data)
    {
        this.code = code;
        this.message = msg;
        this.data = data;
    }


    public static JsonResult success()
    {
        JsonResult json = new JsonResult(StatusCode.success.getCode());

        return json;
    }

    public static JsonResult success(String msg)
    {
        JsonResult json = new JsonResult(StatusCode.success.getCode(),msg);

        return json;
    }

    public static <T>JsonResult success(String msg,T data)
    {
        JsonResult json = new JsonResult(StatusCode.success.getCode(),msg,data);

        return json;
    }


    public static JsonResult error()
    {
        JsonResult json = new JsonResult(StatusCode.error.getCode());

        return json;
    }


    public static JsonResult error(String message)
    {
        JsonResult json = new JsonResult(StatusCode.error.getCode(),message);

        return json;
    }
    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
