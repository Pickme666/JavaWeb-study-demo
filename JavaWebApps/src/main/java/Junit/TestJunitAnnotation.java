package Junit;

import org.junit.*;

/**
 * Junit4 的常用注解
 */

public class TestJunitAnnotation {

    @Before  //修饰实例方法，该方法在每个测试方法执行前执行，junit5的注解名为 @BeforeEach
    public void before() {
        System.out.println("JunitAnnotation.before");
    }

    @After  //修饰实例方法，在每个测试方法执行后执行，junit5的注解名为 @AfterEach
    public void after() {
        System.out.println("JunitAnnotation.after");
    }

    @BeforeClass  //修饰静态方法，在所有测试方法执行前执行，junit5的注解名为 @BeforeAll
    public static void beforeClass() {
        System.out.println("JunitAnnotation.beforeClass");
    }

    @AfterClass  //修饰静态方法，在所有测试方法执行后执行，junit5的注解名为 @AfterAll
    public static void afterClass() {
        System.out.println("JunitAnnotation.afterClass");
    }

    @Test
    public void test1() {
        System.out.println("测试方法1");
    }

    @Test
    public void test2() {
        System.out.println("测试方法2");
    }
}
