package xml_analysis;

/**
 * 对应XML文件数据的类
 */

public class Student {
    private int id;
    private boolean vip;
    private String name;
    private char sex;
    private String school;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean getVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", vip=" + vip +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", school='" + school + '\'' +
                '}';
    }
}
