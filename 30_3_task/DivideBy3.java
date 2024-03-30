import java.util.Scanner;

public class DivideBy3 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String input=scanner.next();
        if(new DivideBy3().divideBy3(input)){
            System.out.println("yes");
        }else {
            System.out.println("no");
        }
    }
    public boolean divideBy3(String str){
        long sum=0;
        for(int i=0;i<str.length();i++){
            sum+=(str.charAt(i)-'0');
        }
        if(sum%3==0){
            return true;
        }
        return false;
    }
}
