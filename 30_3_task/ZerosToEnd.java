import java.util.Arrays;
import java.util.Scanner;

public class ZerosToEnd {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int arr[]=new int[scanner.nextInt()];
        for(int i=0;i<arr.length;i++){
            arr[i]=scanner.nextInt();
        }
        System.out.println(Arrays.toString(new ZerosToEnd().zeroToEnd(arr)));
    }
    public int[] zeroToEnd(int[] arr){
        for(int i=0,j=0;i<arr.length;i++){
            if(arr[i]!=0){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j++]=temp;
            }
        }
        return arr;
    }
}
