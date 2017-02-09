class A{
  void m(){
    System.out.println(1);
  }
  void test(){
    m();
  }
}

class B extends A{
  void m(){
    System.out.println(2);
  }
  void testSuper(){
    super.m();
  }
}

class C extends B{
  void m(){
    System.out.println(3);
  }
}

class Parents{
  public static void main(String[] args){
    A a = new A();
    B b = new B();
    C c = new C();
    B c1 = new C();
    a.test();
    b.test();
    c.test();
    c1.test();
    b.testSuper();
    c.testSuper();
    c1.testSuper();
  }
}
