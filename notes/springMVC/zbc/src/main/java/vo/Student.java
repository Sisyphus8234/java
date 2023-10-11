package vo;

public class Student {
    public String name;
    public Integer age;


    public Student() {
        System.out.println("Student无参构造");
    }

    public Integer getAgeA() {
        return age;
    }

    public void setAgeA(Integer age) {
        this.age = age;
    }

    public String getNameA() {
        return name;
    }

    public void setNameA(String name) {
        this.name = name;
    }
}

