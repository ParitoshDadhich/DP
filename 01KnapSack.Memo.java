class Solution 
{ 
    static int knapSack(int w, int wt[], int val[], int n) 
    { 
        int t[][] = new int[n+1][w+1];
        for(int i=0; i<n+1; i++)
            for(int j=0; j<w+1; j++)
                t[i][j] = -1;
                
        return helper(w, wt, val, n, t);
    } 
    
    static int helper(int w, int wt[], int val[], int n, int t[][]){
        if(n == 0 || w == 0)
            return 0;
        
        if(t[n][w] != -1)
            return t[n][w];
        
        // including 
        if(wt[n-1] <= w)
            t[n][w] = Math.max(val[n-1] + helper(w-wt[n-1], wt, val, n-1, t),
                                helper(w, wt, val, n-1, t));
        
        // not including
        else if(wt[n-1] > w)
            t[n][w] = helper(w, wt, val, n-1, t);
            
    
        return t[n][w];
    }
    
}
