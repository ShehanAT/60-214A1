import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern; 

public class A12Test {
    public static void main(String[] args) {
        List<String> keyWords = Arrays.asList("WRITE", "READ", "IF", "ELSE", "RETURN", "BEGIN", "END", "MAIN", "STRING", "INT", "REAL");
        Set<String> setWords = new HashSet<>();
        BufferedReader bufferedReader;
        BufferedWriter bufferedWriter;
        String firstPattern = "(\"[^\"]*\")*";
        String secondPattern = "[^a-zA-Z0-9]";
        String patternString = "([A-Za-z])[A-Za-z0-9]*";
        Pattern p = Pattern.compile(firstPattern);
        Pattern p2 = Pattern.compile(patternString);
        Matcher m = null;
        String line;
        String mainString = "";
        int counter = 0;
        try {
            bufferedReader = new BufferedReader(new FileReader(args[0]));
            while ((line = bufferedReader.readLine()) != null) {
                mainString += line + " ";
            }
            mainString = mainString.replaceAll("(\"[^\"]*\")*", "");
            System.out.println(mainString+ "----- ");
            mainString = mainString.replaceAll(secondPattern," " + "\n");
            System.out.println(mainString);
            m = p2.matcher(mainString);
            while(m.find()){
                System.out.println(m.group());
                if(!keyWords.contains(m.group())){
                   // System.out.println();
                    setWords.add(m.group());
                }
            }
            counter = setWords.size();
            System.out.println("Identifiers = " + counter);
            for(String i : setWords){
                System.out.println(i);
            }
            bufferedWriter = new BufferedWriter(new FileWriter("A1.output"));
            bufferedWriter.write("identifiers:" + setWords.size());
            bufferedReader.close();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
