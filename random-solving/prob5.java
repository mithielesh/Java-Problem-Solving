import java.io.*;

public class prob5{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int i = 1;
        String name;
        while((name = br.readLine())!=null){
            System.out.println(i+" "+name);
            i++;
        }
        out.flush();
    }
}