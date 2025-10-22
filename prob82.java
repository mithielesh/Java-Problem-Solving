import java.util.*;
public class prob82 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int sec = sc.nextInt();
        sc.nextLine();
        List <String> grid = new ArrayList<>();
        for(int i=0;i<row;i++){
            String temp = sc.nextLine();
            grid.add(temp);
        }
        List <String> list = new ArrayList<>();
        for(int i=0;i<grid.size();i++){
            String temp = "";
            for(int j=0;j<grid.get(0).length();j++){
                temp += 'O';
            }
            list.add(temp);
        }
        if(sec%6==0 || sec%6==1){
            for(int i=0;i<grid.size();i++){
                System.out.println(grid.get(i));
            }
        }
        else if(sec%3==2){
            for(int i=0;i<list.size();i++){
                System.out.println(list.get(i));
            }
        }
        else if(sec%3==0 || sec%3==1){
            for(int i=1;i<list.size()-1;i++){
                StringBuilder sb2 = new StringBuilder(list.get(i-1));
                StringBuilder sb = new StringBuilder(list.get(i));
                StringBuilder sb1 = new StringBuilder(list.get(i+1));
                String temp = grid.get(i);
                if(i-1==0){
                    for(int j=0;j<temp.length();j++){
                        if(grid.get(i-1).charAt(j)=='O'){
                            sb2.setCharAt(j,'.');
                            if(j<temp.length()-1){
                                sb.setCharAt(j+1,'.');
                            }
                            sb.setCharAt(j,'.');
                        }
                    }
                    list.set(i-1,sb2.toString());
                    list.set(i,sb.toString());
                }
                else if(i+1==list.size()-1){
                    for(int j=0;j<temp.length();j++){
                        if(grid.get(i+1).charAt(j)=='O'){
                            sb1.setCharAt(j,'.');
                            if(j<temp.length()-1){
                                sb1.setCharAt(j+1,'.');
                            }
                            sb.setCharAt(j,'.');
                        }
                    }
                    list.set(i,sb.toString());
                    list.set(i+1,sb1.toString());
                }
                else{
                    for(int j=0;j<temp.length();j++){
                        if(temp.charAt(j)=='O'){
                            sb.setCharAt(j,'.');
                            if(j>0){
                                sb.setCharAt(j-1,'.');
                            }
                            if(j<temp.length()-1){
                                sb.setCharAt(j+1,'.');
                            }
                            sb1.setCharAt(j,'.');
                            sb2.setCharAt(j,'.');
                        }
                    }
                    list.set(i-1,sb2.toString());
                    list.set(i,sb.toString());
                    list.set(i+1,sb1.toString());
                }
            }
            for(int i=0;i<list.size();i++){
                System.out.println(list.get(i));
            }
        }
        sc.close();
    }
}
