//Two pointers/Sliding Window Approach Question
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        
        int allSum = 0;
        
        //cardPoints = [1,2,3,4,5,6,1], k = 3, n = 7
        //find the sum of all elements/cards
        for(int i=0;i<cardPoints.length;i++){
            allSum = allSum + cardPoints[i];
        }
        
        int x = cardPoints.length - k; //window_Size = n - k = 7-3 = 4
        int sum_n_k = 0;
        //find the sum of (n-k) cards (7-3=4)
        for(int i=0;i<x;i++){
            sum_n_k = sum_n_k + cardPoints[i];
        }
        
        int result = allSum - sum_n_k; //result = (allsum) - (sum(n-k)) = 22 - 10 = 12
        int l = 0;
        while(x < cardPoints.length){ //4 < 7
            sum_n_k = sum_n_k + cardPoints[x] - cardPoints[l]; // sum = 10 + 5 - 1 = 14
            result = Math.max(result, (allSum-sum_n_k)); // maxof(12, (22-14=8))
            x++; // 5..
            l++; // 1..
        }
        //result = 12
        return result;
    }
}