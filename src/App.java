import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Please Enter File Name: ");
        String passageinput = scnr.nextLine();


        BufferedReader buffreader = new BufferedReader(new FileReader(passageinput));

        Map<String, Integer> counter = new HashMap<>();
        String line = buffreader.readLine();

        while (line != null){
            String[] wordarray = line.split(" ");

            for (String word : wordarray){
                if(word == null || word.trim().equals(" ")) {
                    continue;
                }
                String lowercaseword = word.toLowerCase();
                lowercaseword = lowercaseword.replace(",", " ");

                if (counter.containsKey(lowercaseword)){
                    counter.put(lowercaseword, counter.get(lowercaseword)+1);
                }
                else{
                    counter.put(lowercaseword, 1);
                }

            }
            line = buffreader.readLine();
        }
        for (Entry<String, Integer> entry : counter.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
