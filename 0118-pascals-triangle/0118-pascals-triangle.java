class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> result = new ArrayList<>();

        for( int r=1 ; r<=numRows ; r++){
        List<Integer> ans = new ArrayList<>();
        // ans = ans * (Row - Col) / Col
        int x = 1;
        ans.add(x);
        
        for(int c=1 ; c < r ; c ++){
            
            x = x * (r - c);
            x = x / c;
            
            ans.add(x);
            
        }
        result.add(ans);
        }


        return result;
    }
}