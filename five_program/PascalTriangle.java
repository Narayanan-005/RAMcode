import java.util.*;
class PascalTriangle {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int rows=sc.nextInt();
        List<List<Integer>> list=new ArrayList<List<Integer>>();
        list.add(Arrays.asList(1));
        PascalTriangle obj=new PascalTriangle();
        for(int i=1;i<rows;i++){
            obj.createRow(list);
        }
        System.out.println(list);
    }
    private void createRow(List<List<Integer>> list){
        List<Integer> pre=list.get(list.size()-1);
        List<Integer> li=new ArrayList<Integer>();
        li.add(1);
        for(int i=0;i<pre.size()-1;i++){
            li.add(pre.get(i)+pre.get(i+1));
        }
        li.add(1);
        list.add(li);
    }
}
