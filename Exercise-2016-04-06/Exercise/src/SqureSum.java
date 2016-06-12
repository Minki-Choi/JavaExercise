/**
 * Created by cj on 2016-03-11.
 */
public class SqureSum {
    public static void main(String[] args) {
        SqureSum squreSum=new SqureSum();
        long x;
        x=squreSum.addSqure(4,3);
        System.out.println(x);
    }

    public long addSqure(int m,int n) {
        if(m<=0) {
            return 0;
        }
        else if(n<=0) {
            return 1;
        }
        else
            return multiply(m,n)+addSqure(m-1,n);
    }
    public long multiply(int m,int n) {
        if (n==1)
            return m;
        else
            return m*multiply(m,n-1);
    }
}
