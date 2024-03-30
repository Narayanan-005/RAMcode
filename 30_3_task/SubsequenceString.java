import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Arrays;

public class SubsequenceString {
    public static void main(String[] args) {
        System.out.println(new SubsequenceString().allPossiblities(""));
    }
    public Set<String> allPossiblities(String str){
        String temp="";
        Set<String> set=new HashSet<>();
        if(str.length()<2){
            set.add(str);
            return set;
        }
        for(int i=0;i<str.length()-1;i++){
            for(int j=0;j<str.length()-i;j++){
                char ch []=str.substring(j,j+i+1).toCharArray();
                Arrays.sort(ch);
                temp= new String(ch);
                if(!set.contains(temp)){
                    set.add(temp);
                }
            }
            if(i==0){
                str+=str.charAt(0);
            }
        }
        set.add(str.substring(0,str.length()-1));
        return set;
    }
}
