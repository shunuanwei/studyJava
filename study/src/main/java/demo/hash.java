package demo;

import org.bouncycastle.util.encoders.Hex;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class hash {

    public static void main(String[] args) {
        System.out.println(myHash("hello"));

    }



    private static String myHash(String str) {
        try {
            //将目标字符串进行转换成字节数组
            byte[] bytes = str.getBytes("utf-8");
            //创建MessageDigest对象,并且设置计算的方式
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            //将对象重置
//            digest.reset();
            //进行hash计算
            byte[] digest1 = digest.digest(bytes);
            //校验一下计算得到的字节数组
            if (digest1.length != 32) {
                System.out.println("计算hash值失败");
                return null;
            }
            //将字节数组,按照十六进制,转换成字符串
            return Hex.toHexString(digest1);
        } catch (UnsupportedEncodingException u) {
            System.exit(-2);
        } catch (NoSuchAlgorithmException n) {
            System.exit(-3);
        }
        return null;
    }
}
