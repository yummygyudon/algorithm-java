class Solution {
    public int solution(int[] num_list) {
        int multi = num_list[0];
        int add = num_list[0];
        for(int i = 1; i < num_list.length; i++) {
            multi = Math.multiplyExact(multi, num_list[i]);
            add += num_list[i];
            // System.out.println("multi : "+multi+" / add : "+add);
        }
        add *= add ;
        return (multi > add) ? 0 : 1;
    }
}