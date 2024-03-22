class ElementAndDigitSum {
    public static void main(String[] args) {
        int arr[]={1,15,6,3};
        System.out.println(new ElementAndDigitSum().differenceOfSum(arr));
    }
    public int differenceOfSum(int[] nums) {
        int digitSum=0,elementSum=0,num=0;
        for(int i=0;i<nums.length;i++){
            num=nums[i];
            elementSum+=num;
            digitSum+=digitSum(num);            
        }
        return elementSum-digitSum;
    }
    private int digitSum(int n){
        int sum=0;
        while(n>0){
            sum+=(n%10);
            n/=10;
        }
        return sum;
    }
}
