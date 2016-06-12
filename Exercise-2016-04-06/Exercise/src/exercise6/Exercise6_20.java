package exercise6;

/**
 * Created by cj on 2016-03-12.
 */
public class Exercise6_20 {

    public static int[] shuffle(int[] arr) {

        for(int i=0; i<arr.length; i++) {
            int tmp;
            int RandomN1=(int)(Math.random()*9);
            int RandomN2=(int)(Math.random()*9);
            tmp=arr[RandomN1];
            arr[RandomN1]=arr[RandomN2];
            arr[RandomN2]=tmp;
        }

        return arr;
    }

    public static void main(String[] args)
    {
        int[] original = {1,2,3,4,5,6,7,8,9};
        System.out.println(java.util.Arrays.toString(original));
        int[] result = shuffle(original);
        System.out.println(java.util.Arrays.toString(result));
    }
}
