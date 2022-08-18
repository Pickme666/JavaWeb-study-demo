package Ajax;

import cases.pojo.User;
import com.alibaba.fastjson.JSON;

/**
 * 阿里巴巴提供的JSON库, 可以实现java对象和JSON字符串相互转换
 */

public class JsonConvert {
    public static void main(String[] args) {

        //将java对象转换成json字符串
        User user = new User(1, "老六", "123456");
        String jsonString = JSON.toJSONString(user);
        System.out.println(jsonString);

        //将json字符串转换成java对象 (字符串,要转换成的对象.class)
        User u = JSON.parseObject(jsonString, User.class);
        System.out.println(u);
    }
}
