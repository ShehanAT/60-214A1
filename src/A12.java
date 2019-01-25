import java.nio.file.*;
import java.util.*;
import java.util.regex.*;
 class A12Test {
    public static void main(String[] args) throws java.io.IOException{
        Set<String> setwords = new HashSet<>();
        Matcher m = Pattern.compile("(?:\"[^\"]*\")|[a-zA-Z][a-zA-Z0-9]*").matcher(new String(Files.readAllBytes(Paths.get("/Users/shehanatukorala/Desktop/Desktop/test.txt"))));
        while(m.find()){
            if(!m.group().matches("(?:\"[^\"]*\")")&& !Arrays.asList(("WRITEZREADZIFZELSEZRETURNZBEGINZENDZMAINZSTRINGZINTZREALZMAIN").split("Z")).contains(m.group())){
                setwords.add(m.group());
            }
        }
        Files.write(Paths.get("/Users/shehanatukorala/Desktop/Desktop/testfile.txt"), ("identifiers:" + setwords.size()).getBytes());
    }
}
