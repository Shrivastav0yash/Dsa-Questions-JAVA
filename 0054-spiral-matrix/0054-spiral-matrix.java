class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length; // Rows ( top to bottom)
        int m = matrix[0].length; // Col (Left to Right)
        int top = 0;
        int bottom = n-1;
        int left = 0;
        int right = m -1;

        List<Integer> result = new ArrayList<>();

        //i = top/bottom j = left/right

        while( top <= bottom && left <= right){
             
            // Left to Right 
            for(int i = left; i <= right; i++){
                result.add(matrix[top][i]);
                //top will be constant
            }
            top++;

            // Top to Bottom 
            for(int i=top; i<= bottom; i++){
                result.add(matrix[i][right]);
                //right constant
            }
            right--;

            if( top <= bottom){
            //Right to left
            for(int i = right; i>= left ; i--){
                result.add(matrix[bottom][i]); 
                //bottom constant
            }
            bottom--;
            }
            if( left <= right) {
            //Bottom to Top
            for(int i= bottom; i>= top ; i--){
                result.add(matrix[i][left]);
                //left constant
            }
            left++;
            }
        }

        return result;

    }
}
