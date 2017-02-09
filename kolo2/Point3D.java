import java.io.*;
import java.math.*;

interface Cartesian3D{
    public double LengthC(double x, double y, double z);
}

interface Polar3D{
    public double LengthP(double x, double y, double z);
}

class Point3D implements Cartesian3D, Polar3D{
  double x, y, z;

  Point3D(){
    this.x = 0.0;
    this.y = 0.0;
    this.z = 0.0;
  }

  Point3D(double x, double y, double z){
    this.x = x;
    this.y = y;
    this.z = z;
  }

  String str(){
    return Double.toString(this.x) + ", " + Double.toString(this.y) + " ," + Double.toString(this.z);
  }

  public double LengthC(double x, double y, double z){
    double wyn = x*x + y*y + z*z;
    wyn = Math.sqrt(wyn);
    return wyn;
  }

  public double LengthP(double x, double y, double z){
    Point3D zero = new Point3D(0, 0, 0);
    double wyn = Math.pow(x-zero.x, 2) + Math.pow(y-zero.y, 2) + Math.pow(z-zero.z, 2);
    wyn = Math.sqrt(wyn);
    return wyn;
  }

  public static void main(String[] args){
    Point3D p = new Point3D(3, 4, 5);
    System.out.println(p.LengthC(p.x, p.y, p.z));
    System.out.println(p.LengthP(p.x, p.y, p.z));
  }
}
