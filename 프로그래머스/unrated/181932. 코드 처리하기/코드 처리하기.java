class Solution {
    public String solution(String code) {
        String mode = "0" ;
        String c ;
        String[] codes = code.split("");
        StringBuilder ret = new StringBuilder();
        int index = 0;
        while(index < codes.length) {
            c = codes[index] ;
            if (c.equals("1")){
                mode = switchMode(mode) ;
            } else {
                // mode를 바꾸지 않을 때
                if (mode.equals("0")) {
                    if (index % 2 == 0) {
                        ret.append(c);
                    }
                } else {
                    if (index % 2 == 1 ){
                        ret.append(c);
                    }
                }
            }
            index++;
        }
        return ret.length() == 0 ? "EMPTY" : ret.toString();
    }
    String switchMode(String mode) {
        if (mode.equals("1")) {
            return "0" ;
        }
        return "1" ;
    }
}