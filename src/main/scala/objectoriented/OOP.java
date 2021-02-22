package objectoriented;

class A {
    A() {
        init();
    }

    void init() {
        System.out.println("A");
    }
}


class B extends A {
    B() {
        super();
    }
    void init() {
        System.out.println("B");
    }
}
public class OOP {
    public static void main(String[] args) {
        A a = new A();
        System.out.println(a);

        A a1 = new B(); // in this B constructor is called --> so A constructor is called --> A class has init
        // called in its constructor --> it finds that its child class B has also init method -> so B init method is called
        System.out.println(a1);

        B b = new B();// in this B constructor is called --> so A constructor is called --> A class has init
        // called in its constructor --> it finds that its child class B has also init method -> so B init method is called
        System.out.println(b);
    }
}
