package Servlet.URLCodec;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * URL编码解码工具 <p>
 * http协议对URL默认使用UTF-8编码格式, 会把中文字符转换成16进制, 每个字节前都有一个%
 */

public class UrlCodecDemo {
    public static void main(String[] args) throws UnsupportedEncodingException {

        String str = "南华歌姬";

        //URL编码
        String encode = URLEncoder.encode(str,"utf-8");  //utf-8 编码
        System.out.println(encode);

        //URL解码
        String decode = URLDecoder.decode(encode, "utf-8");  //utf-8 解码
        System.out.println(decode);

        //使用不支持中文的编码格式解码会产生乱码
        String chaos = URLDecoder.decode(encode, "iso-8859-1");  //iso-8859-1 解码
        System.out.println(chaos);

        //解决乱码, 使用指定字符集(iso-8859-1)将乱码的字符编码为一个字节序列，并将结果存储到一个新的字节数组中。
        byte[] bytes = chaos.getBytes(StandardCharsets.ISO_8859_1);
        for (byte b : bytes) System.out.print(b + " ");

        //然后创建一个新的String传教字节数组, 通过使用指定的字符集(utf-8)对字节数组进行解码
        String fresh = new String(bytes, StandardCharsets.UTF_8);
        System.out.println("\n" + fresh);

    }
}
