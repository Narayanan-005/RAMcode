class WithoutDivMul {
    public static void main(String[] args) {
        WithoutDivMul obj=new WithoutDivMul();
        System.out.println(obj.multiplyBy15(2));
        System.out.println(obj.multiplyBy75(2));
        System.out.println(obj.multiply15AndDivBy16(32));
    }
    
    public int multiplyBy15(int n){
        int res=0;
        int times=15;
        while(times-->0){
            res+=n;
        }
        return res;
    }
    public int multiplyBy75(int n){
        int res=0;
        int times=7;
        while(times-->0){
            res+=n;
        }
        res+=n>>1;
        return res;
    }
    public int multiply15AndDivBy16(int n){
        int res=n>>4;
        res=multiplyBy15(res);
        return res;
    }
}
