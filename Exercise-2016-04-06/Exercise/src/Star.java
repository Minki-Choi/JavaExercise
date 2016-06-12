/**
 * Created by cj on 2016-03-02.
 */
public class Star {

    public static void main(String[] args) {
        int i,j; //가로
        int k=40;
        for(j=0; j<=k ; j++) {
            for (i = 0; i <= 34; i++) {
                if(j==3*i-8||j==i-4||j==30||j==30-i||j==-3*i+94)
                    System.out.print("*"+"\t");
                else
                    System.out.print("\t");
            }
            System.out.println();
        }
    }
}
