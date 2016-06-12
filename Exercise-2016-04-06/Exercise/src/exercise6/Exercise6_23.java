package exercise6;

/**
 * Created by cj on 2016-03-13.
 */
public class Exercise6_23 {

    public static int max(int[] data) {

        if(data==null||data.length==0) //조건문에 2개이상 조건이 들어갈때 null값에 대한 조건은 항상 먼저 쓸것.
            return -999999;
        int tmp=data[0];
        for(int i=0; i<data.length-1; i++) {
            if(tmp<data[i+1])
                tmp=data[i+1];
        }
        return tmp;
    }


    public static void main(String[] args)
    {
        int[] data = {3,2,9,4,7};
        System.out.println(java.util.Arrays.toString(data));
        System.out.println("최대값:"+max(data));
        System.out.println("최대값:"+max(null));
        System.out.println("최대값:"+max(new int[]{})); // 크기가 0인 배열
    }
}