package demo.exception;

/**
 * @author wsn
 */
public class Demo {

    public static void main(String[] args) {

        System.out.println("hello");
        throw new ApiException(HttpResponseEnums.RESPONSE_RESULT_NO_AUTH);
    }
}
