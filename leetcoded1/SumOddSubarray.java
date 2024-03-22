class SumOddSubarray {
    public static void main(String[] args) {
        int arr[]={1,4,2,5,3};
        System.out.println(new SumOddSubarray().sumOddLengthSubarrays(arr));
    }
    public int sumOddLengthSubarrays(int[] arr) {
        int count=0;
        int sum=0,tempSum=0;
        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                tempSum+=arr[j];
                count++;
                if(count%2==1){
                    sum+=tempSum;
                }   
            }
            count=0;
            tempSum=0;
        }
        return sum;
    }
}
