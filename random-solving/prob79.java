import java.util.*;
public class prob79 {
    public static void binToDec(int num, int base, int cBase){
        String convert = String.valueOf(num);
        int pow = 0;
        int result = 0;
        for(int i=convert.length()-1;i>=0;i--){
            int val = convert.charAt(i) - '0';
            result += val * Math.pow(base,pow);
            pow++;
        }
        System.out.println("The conversion from base "+base+" to base "+cBase+" is: "+result);
    }
    public static void binToOct(int num, int base, int cBase){
        String convert = String.valueOf(num);
        int pow = 0;
        int result = 0;
        for(int i=convert.length()-1;i>=0;i--){
            int val = convert.charAt(i) - '0';
            result += val * Math.pow(base,pow);
            pow++;
        }
        decToOct(result,10,8);
    }
    public static void octToDec(int num, int base, int cBase){
        String convert = String.valueOf(num);
        int pow = 0;
        int result = 0;
        for(int i=convert.length()-1;i>=0;i--){
            int val = convert.charAt(i) - '0';
            result += val * Math.pow(base,pow);
            pow++;
        }
        System.out.println("The conversion from base "+base+" to base "+cBase+" is: "+result);
    }
    public static void octToBin(int num, int base, int cBase){
        String convert = String.valueOf(num);
        int pow = 0;
        int result = 0;
        for(int i=convert.length()-1;i>=0;i--){
            int val = convert.charAt(i) - '0';
            result += val * Math.pow(base,pow);
            pow++;
        }
        decToBin(result,10,2);
    }
    public static void decToBin(int num, int base, int cBase){
        StringBuilder temp = new StringBuilder();
        while(num>0){
            int rem = num % cBase;
            temp.insert(0,rem);
            num /= cBase;
        } 
        System.out.println("The conversion from base "+base+" to base "+cBase+" is: "+temp);
    }
    public static void decToOct(int num, int base, int cBase){
        StringBuilder temp = new StringBuilder();
        while(num>0){
            int rem = num % cBase;
            temp.insert(0,rem);
            num /= cBase;
        } 
        System.out.println("The conversion from base "+base+" to base "+cBase+" is: "+temp);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int num = sc.nextInt();
        System.out.print("Enter the base: ");
        int base = sc.nextInt();
        System.out.print("Enter the base to convert to: ");
        int convBase = sc.nextInt();
        if(base==2 && convBase==8){
            binToOct(num,base,convBase);
        }
        else if(base==2 && convBase==10){
            binToDec(num,base,convBase);
        }
        else if(base==8 && convBase==2){
            octToBin(num,base,convBase);
        }
        else if(base==8 && convBase==10){
            octToDec(num,base,convBase);
        }
        else if(base==10 && convBase==2){
            decToBin(num,base,convBase);
        }
        else if(base==10 && convBase==8){
            decToOct(num,base,convBase);
        }
        else{
            System.out.println("Invalid Input");
        }
        sc.close();
    }
}
