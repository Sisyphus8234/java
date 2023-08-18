//继承时
//this.成员变量 – this所在类的成员变量
//this.成员函数 – 当前new对象所在类的成员函数

// 父类
class Fu {

    int num = 3;

    public void func() {
        System.out.println("Fu show");
    }

    public void show() {
        System.out.println("this.num = " + this.num);    // this.成员变量 -- this所在类的成员变量

        System.out.print("this.func() = ");
        this.func();    // this.成员函数 -- 当前new对象所在类的成员函数
    }
}

// 子类
class Zi extends Fu {
    int num = 1;

    public void func() {
        System.out.println("Zi show");
    }

}

// 主程序所在的类
class Demo {
    public static void main(String[] args) {
        Fu f = new Zi();
//        Zi f=new Zi();

        System.out.println("f.num = " + f.num);  // f.num = 3
        f.show();
        // this.num = 3
        // this.func() = Zi show
    }
}
