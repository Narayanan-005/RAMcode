import javax.security.sasl.SaslClient;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Leader {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Size");
        int size=scanner.nextInt();
        int arr[]=new int[size];
        for (int i=0;i<size;i++){
            arr[i]=scanner.nextInt();
        }
        List<Integer> result=new Leader().leader(arr);
        for (int i=result.size()-1;i>=0;i--){
            System.out.print(result.get(i)+" ");
        }
    }

    public List<Integer> leader(int arr[]) {
        List<Integer> list = new ArrayList<>();
        int max = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] > max) {
                list.add(arr[i]);
            }
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return list;
    }
}
