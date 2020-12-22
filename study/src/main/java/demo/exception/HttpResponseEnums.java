package demo.exception;

/**
 * @author weish
 */

public enum HttpResponseEnums {


    // 请求成功
    RESPONSE_RESULT_SUCCESS(200,"请求成功"),
    // 用户未登录
    RESPONSE_RESULT_NO_AUTH(401,"用户未登录"),
    // 没有访问权限
    RESPONSE_RESULT_NO_PERMISSION(403,"没有访问权限"),
    // 系统繁忙，请稍后再试
    RESPONSE_RESULT_SYSTEM_EXCEPTION(500,"系统内部异常"),
    // 服务暂不可用
    RESPONSE_RESULT_SERVER_DOWN(503,"服务暂不可用"),
    // 业务异常
    RESPONSE_RESULT_BIZ_EXCEPTION(500000,"业务异常"),
    // 参数异常
    RESPONSE_RESULT_PARAMS_IS_NULL(500001,"参数异常"),
    ;

    private Integer code;

    private String msg;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    HttpResponseEnums(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    @Override
    public String toString(){
        return "code: "+ code + ", msg: "+ msg;
    }
}
