import javax.management.MBeanRegistrationException;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.*;


public class A12 {


    public static void main(String[] args) {
        List<String> keyWords = Arrays.asList("WRITE", "READ", "IF", "ELSE", "RETURN", "BEGIN", "END", "MAIN", "STRING", "INT", "REAL", ";", ",", "(", ")", "+", "-", "*", "/", ":=", "==", "!=", "input\"","input");
        List<String> storeWords = new ArrayList<>();
        List<String> store = new ArrayList<>();
        FileWriter fileWriter;
        BufferedReader bufferedReader;
        BufferedWriter bufferedWriter;
        File file = new File("/Users/shehanatukorala/Desktop/test.txt");
        //String patternString = "[A-Za-z0-9.\"]";
        String patternString = "([^;+:=*,_\\- ()#&%!]+)";
        String test ="";
        Pattern p = Pattern.compile(patternString);
        Matcher m;
        String[] list;
        String line;
        String bigString = "";
        int counter = 0;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter("/Users/shehanatukorala/Desktop/A1.output"));
            bufferedReader = new BufferedReader(new FileReader(file));
            while ((line = bufferedReader.readLine()) != null) {
                m = p.matcher(line);
                while(m.find()){
                    test = m.group();
                    if(!keyWords.contains(test) && !storeWords.contains(test) && test.charAt(0) != '\"'){
                        ++counter;
                        storeWords.add(test);
                    }
                }
             //   list = line.split(patternString);
//                for(int i = 0 ; i < list.length;i++){
//                    if(!keyWords.contains(list[i])){
//                        System.out.println(list[i]);
//                        counter++;
//
//                    }
//                }
            };

            System.out.println("identifiers:"+counter);
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}//"((?:\\"|[^"]|\\")*)" - targest the strings in the double quotes