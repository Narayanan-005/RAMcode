import java.util.*;
class DecodeSequence {
    public static void main(String[] args) {
        String input="IIDDIDID";
        StringBuffer sb=new StringBuffer();
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<=input.length();i++){
            stack.push(i+1);
           if(input.length()==i || input.charAt(i)=='I'){
                while(!stack.isEmpty()){
                    sb.append(stack.pop());
                }
            }
        }
        System.out.println(sb);
    }
}
