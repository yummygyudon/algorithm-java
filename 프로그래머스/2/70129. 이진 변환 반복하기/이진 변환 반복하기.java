class Solution {
    public int[] solution(String s) {
        int convertCount = 0;
        int removeCount = 0;
        while (!s.equals("1")) {
            convertCount++;
            int[] result = countOneAndRemovedZero(s);
            int decimal= result[0];
            removeCount += result[1];
            
            s = toBinary(decimal);
        }
        
        
        return new int[]{convertCount, removeCount};
    }
    private int[] countOneAndRemovedZero(String binaryString) {
        int count = 0;
        int remove = 0;
    
        for (String num : binaryString.split("")) {
            if (num.equals("1")) {
                count++;
            } else {
                remove++;
            }
        }
        return new int[]{count, remove};
    }
    
    private String toBinary(int number) {
        return Integer.toBinaryString(number);
    }
}