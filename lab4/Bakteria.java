import java.io.*;

class Bakteria{
  Bakteria(){
    System.out.println("Jestem Tobą w 80%");
  }

  void ugabuga(){
    System.out.println("asfadfasfdawsdcvsdc dfserfvgdfvgtefadvhtrgstsrvbdrc");
  }
}

class Mucha extends Bakteria{
  Mucha(){
    System.out.println("Jestem Tobą w 90%");
  }

  void ugabuga(){
    System.out.println("Bzykam sobie, bzzz bzzz bzzz");
  }
}

class Ty extends Mucha{
  Ty(){
    System.out.println("Jestem Tobą");
  }

  void ugabuga(){
    System.out.println("Studiuje prawo.");
  }

  public static void main(String[] args){
    Ty c = new Ty();
    c.ugabuga();
  }
}
