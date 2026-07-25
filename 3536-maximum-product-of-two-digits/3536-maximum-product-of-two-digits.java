class Solution {
    public int maxProduct(int n) {
        ArrayList<Integer> product = new ArrayList<>();
        while(n!=0){
            int temp = n % 10;
            product.add(temp);
            n = n/10;
        }
        Collections.sort(product);
        return (product.get(product.size()-1) * product.get(product.size()-2));
    }
}