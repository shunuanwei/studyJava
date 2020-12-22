package demo.exception;


/**
 * @author weish
 */
public class ApiException extends RuntimeException{


    private Integer code;

    private String msg;

    private HttpResponseEnums httpResponseEnums;

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

    public HttpResponseEnums getHttpResponseEnums() {
        return httpResponseEnums;
    }

    public void setHttpResponseEnums(HttpResponseEnums httpResponseEnums) {
        this.httpResponseEnums = httpResponseEnums;
    }

    public ApiException(String msg){
        super(msg);
        this.msg = msg;
        this.code = 501;
    }

    public ApiException(Integer code, String msg){
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public ApiException(HttpResponseEnums httpResponseEnums){
        super(httpResponseEnums.toString());
        this.httpResponseEnums = httpResponseEnums;
    }
}
