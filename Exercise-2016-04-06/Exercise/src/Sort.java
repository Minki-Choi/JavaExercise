/**
 * Created by cj on 2016-03-11.
 */
public class Sort {

    public int[] sortArr(int[] arr) {
        for(int i=0;i<arr.length-1;i++) {
            for(int j=0; j<arr.length-(i+1); j++) {
                if(arr[j]<arr[j+1]) {
                    int tmp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=tmp;
                }
            }
        }
        for(int i=0;i<arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        return arr;
    }
    public static void main(String[] args) {
        int[] arr={5,7,9,2,1,3,6,1};
        Sort sort=new Sort();
        sort.sortArr(arr);
    }
}
