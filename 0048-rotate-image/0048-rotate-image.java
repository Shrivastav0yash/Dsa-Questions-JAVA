class Solution {

    public void reverseMatrix(int[] arr){
        int i = 0;
        int j = arr.length -1;
        while(i < j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    public void rotate(int[][] matrix) {
        //Optimal
        //Time = O(NxN)
        //Space = O(1)

        int n = matrix.length;

        //Input to transpose
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n ; j++ ){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        //transpose to reverse (result)
        for(int i=0; i<n; i++){
            reverseMatrix(matrix[i]);
        }
    }
}