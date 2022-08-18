package Junit;

/**
 * 要测试用的类
 */

public class UsersLogin {

    //模拟用户登录
    public String login(String user, String pwd) {
        if ("root".equals(user) && "123456".equals(pwd)) return "登录成功";
        return "用户或密码不正确";
    }

    public void selectName() {
        System.out.println(2/0);  //模拟查询异常
        System.out.println("查询用户名成功");
    }
}
