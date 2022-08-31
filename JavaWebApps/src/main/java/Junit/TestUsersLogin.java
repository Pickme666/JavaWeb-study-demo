package Junit;

import org.junit.*;

/**
 * Junit 框架
 * Junit是用java语言实现的单元测试框架，它是开源的
 * 使用Junit框架可以实现自动化测试，而不需要程序员自己去观察测试是否成功
 * 单元测试，针对最小的功能单元编写测试代码，针对java方法的测试，检查方法的正确性
 */

//UsersLogin类的测试类
public class TestUsersLogin {  //执行所有测试方法
    /*
        编写测试方法：
            1.测试方法必须是公开的、无参数、无返回值、非静态的方法
            2.测试方法必须要用@Test注解标记
            3.方法测试的结果可以很明确的显示，并且可以一键执行所有测试方法
     */

    @Test
    public void testUserLogin() {  //单元执行
        UsersLogin usersLogin = new UsersLogin();

        //测试login()方法，取得测试结果的值
        String rs = usersLogin.login("root","123456");

        //断言：进行预期结果的正确性测试
        Assert.assertEquals("登录出现问题","登录成功",rs);
        //参数：断言失败的提示值，预期值（要与被测试类的值一致），实际测试值
    }

    @Test
    public void testSelect() {  //单元执行
        UsersLogin usersLogin = new UsersLogin();
        usersLogin.selectName();  //测试selectName()方法
    }
}
