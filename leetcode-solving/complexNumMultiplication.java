public class complexNumMultiplication {
    public String complexNumberMultiply(String num1, String num2) {
        int[] firstEq = coeffXtractor(num1);
        int[] secondEq = coeffXtractor(num2);
        StringBuilder sb = new StringBuilder(); 
        int realCoeff = (firstEq[0] * secondEq[0]) + (-1 * (firstEq[1] * secondEq[1]));
        int complexCoeff = (firstEq[0] * secondEq[1]) + (firstEq[1] * secondEq[0]);
        sb.append(realCoeff).append('+').append(complexCoeff).append('i');
        return sb.toString();
    }
    private int[] coeffXtractor(String num) {
        boolean realNeg = false;
        int index = 0;
        if(num.charAt(index) == '-') {
            realNeg = true;
            index++;
        }
        int realNum = 0;
        while(num.charAt(index) != '+') {
            realNum = (realNum * 10) + (num.charAt(index) - '0');
            index++;
        }
        if(realNeg) {
            realNum = 0 - realNum;
        }
        index++;
        boolean complexNeg = false;
        if(num.charAt(index) == '-') {
            complexNeg = true;
            index++;
        }
        int complexNum = 0;
        while(num.charAt(index) != 'i') {
            complexNum = (complexNum * 10) + (num.charAt(index) - '0');
            index++;
        }
        if(complexNeg) {
            complexNum = 0 - complexNum;
        }
        return new int[]{realNum,complexNum};
    }
}