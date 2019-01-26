import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
 
public class A11 {


    public static void main(String[] args) {

        List<String> keyWords = Arrays.asList("WRITE", "READ", "IF", "ELSE", "RETURN", "BEGIN", "END", "MAIN", "STRING", "INT", "REAL", ";", ",", "(", ")", "+", "-", "*", "/", ":=", "==", "!=","input\"");
        List<String> store = new ArrayList<>();
        FileWriter fileWriter;
        BufferedReader bufferedReader;
        BufferedWriter bufferedWriter;
        File file = new File("/Users/shehanatukorala/Desktop/test.txt");

        StringTokenizer st;
        String line;
        int counter = 0;

        try{
            bufferedReader = new BufferedReader(new FileReader(file));
            while((line = bufferedReader.readLine()) != null){
                st = new StringTokenizer(line, ";,():==!=+-*/%&#_- ");
              //  st = new StringTokenizer(line);
                while(st.hasMoreTokens()){
                    line = st.nextToken();

                    if(Character.isLetter(line.charAt(0)) && !keyWords.contains(line)){

                        if(!store.contains(line)){
                            System.out.println(line);
                            store.add(line);
                        }
                        counter++;
                    }
                }
            }

            System.out.println("identifiers:" + store.size());
            bufferedWriter = new BufferedWriter(new FileWriter("/Users/shehanatukorala/Desktop/A1.output"));
            bufferedWriter.write("identifiers:" + store.size());
            bufferedReader.close();
            bufferedWriter.close();
        }catch(IOException e){
            e.printStackTrace();
        }


    }
}
