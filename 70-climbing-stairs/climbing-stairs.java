class Solution {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int f0=1,f1=2,fn=0;
        for(int i=3;i<=n;i++){
            fn=f1+f0;
            f0=f1;
            f1=fn;
        }
        return fn;
    }
}