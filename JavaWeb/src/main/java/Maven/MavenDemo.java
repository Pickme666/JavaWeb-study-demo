package Maven;

/**
 * Maven <p>
 * Apache Maven 是一个项目管理和构建工具，它基于项目对象模型 (POM) 的概念 </p>
 * 主要功能有：
 *      1.标准化的项目结构
 *      2.标准化的构建流程（编译，测试，打包，发布……）
 *      3.依赖管理机制, 管理项目中所依赖的第三方资源（jar包、插件等）。
 * <P>
 * Maven仓库 <P>
 * 用于储存依赖的第三方资源（jar包、插件等）。
 * 仓库分类：
 *      本地仓库：自己计算机上的一个目录
 *      中央仓库：由Maven团队维护的全球唯一的仓库, 地址: <a href="https://repo1.maven.org/maven2/">https://repo1.maven.org/maven2/</a>
 *      远程仓库 (私服)：一般由公司团队搭建的私有仓库
 * <P>
 * Maven常用命令和生命周期 <p>
 * 常用命令: compile 编译;  clean 清理;  test 测试;  package 打包;  install 安装 </p>
 * 生命周期: Maven构建项目生命周期描述的是一次构建过程经历经历了多少个事件 <p>
 *          生命周期划分为3套：
 *                  clean   清理工作。
 *                  default 核心工作，例如编译，测试，打包，安装等。
 *                  site    产生报告，发布站点等。这套声明周期一般不会使用。
 *              同一套生命周期内，执行后边的命令，前面的所有命令会自动执行。
 */

public class MavenDemo {
    public static void main(String[] args) {
        System.out.println("MavenDemo.main");
    }
}
