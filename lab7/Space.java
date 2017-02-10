import java.io.*;

class Point1D {
  double x;

  Point1D(){ this.x = 0.0; }

  Point1D(double x){ this.x = x; }

  String str(){ return Double.toString(this.x); }
}

class Point2D extends Point1D {
  double y;

  Point2D(){ super(); this.y = 0.0; }

  Point2D(double x,double y){ super(x); this.y = y; }

  String str(){ return super.str()+","+Double.toString(this.y); }
}

class Point3D extends Point2D {
  double z;

  Point3D(){ super(); this.z = 0.0; }

  Point3D(double x,double y,double z){ super(x,y); this.z = z; }

  String str(){ return super.str()+","+Double.toString(this.z); }
}

class Space {
  public static void main(String[] args){
    int MAX = 3;
    Point1D[] p = new Point1D[MAX];
    p[0] = new Point1D(1.0);
    p[1] = new Point2D(11.0,22.0);
    p[2] = new Point3D(111.0,222.0,333.0);
    for(int i=0;i<MAX;i++){
      System.out.println( p[i].getClass().getName() );
      System.out.println( p[i].str() );
    }
  }
}
