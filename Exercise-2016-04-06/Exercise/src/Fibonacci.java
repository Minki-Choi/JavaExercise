/**
 * Created by cj on 2016-03-02.
 */
import java.util.Scanner;

public class Fibonacci {

    public int getGeneralTerm (int n) {
        if(n==1)
            return 1;
        else if(n==2)
            return 2;
        else
            return getGeneralTerm(n-2)+getGeneralTerm(n-1);
    }

    public static void main(String[] args) {
        int number;
        int generalTerm;
        Scanner scan=new Scanner(System.in);
        Fibonacci Fibonacci1=new Fibonacci();
        System.out.print("출력할 항을 입력(정수) : ");
        number=scan.nextInt();
        generalTerm=Fibonacci1.getGeneralTerm(number);
        System.out.println("출력 값 : "+generalTerm);
    }
}
