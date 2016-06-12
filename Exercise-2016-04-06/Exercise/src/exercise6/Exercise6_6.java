package exercise6;

/**
 * Created by cj on 2016-03-12.
 */
public class Exercise6_6 {

    public static void main(String args[]) {
        MyPoint p = new MyPoint(1,1);
        System.out.println(p.getDistance(2,2));
    }
}

class MyPoint {
    int x;
    int y;

    MyPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    double getDistance(double x,double y) {
        double distanceX=x-(double)(this.x);
        double distanceY=y-(double)(this.y);
        return Math.sqrt(distanceX*distanceX+distanceY*distanceY);
    }
}