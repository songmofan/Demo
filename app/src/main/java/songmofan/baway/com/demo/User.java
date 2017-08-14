package songmofan.baway.com.demo;

/**
 * 类的作用：
 * <p>
 * 作者： 宋莫凡
 * <p>
 * 思路：
 * <p>
 * on 2017/8/4 16
 */

public class User {

    private String name;
    private String age;
    private int aas;

    public User(String name, String age,int aa) {
        this.name = name;
        this.age = age;
        this.aas = aa;

    }

    public int getAa() {

        return aas;
    }

    public void setAa(int aa) {
        this.aas = aa;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public User(String name) {
        this.name = name;
    }
}
