import java.io.*;
import java.util.*;

public class task2 {
    public static void main(String[] args)throws IOException{
        Map<String, String> map = new HashMap<>();
        String[] strTemp;

        // list that holds strings of a file
        List<String> listOfStrings = new ArrayList<String>();
        
        // load data from file
        BufferedReader bf = new BufferedReader(new FileReader("employeesList.txt"));
        
        // read entire line as string
        String line = bf.readLine();
        
        // checking for end of file
        while (line != null) {
            listOfStrings.add(line);
            line = bf.readLine();
        }
        
        // closing bufferreader object
        bf.close();
        
        // storing the data in arraylist to array
        String[] array = listOfStrings.toArray(new String[0]);
        
        // printing each line of file
        /*
        // which is stored in array
        for (String str : array) {
            System.out.println(str);
        }
        */
        int count       = 1;
        int step        = 1;
        for (Object item : listOfStrings){
            String i = (String) item;
            strTemp = i.split(" ");
            if (step > 1){
                // map.put(strTemp[0], strTemp[1]);
                if (map.containsKey(strTemp[0])){
                    int digitVal = Integer.parseInt(map.get(strTemp[0]));
                    map.put(strTemp[0], String.format("%d", digitVal+1));
                }
                else{
                    map.put(strTemp[0], String.format("%d", count));
                }
            }
            else{
                map.put(strTemp[0], String.format("%d", count));
            }
            // System.out.println(strTemp[0]+" "+strTemp[1]);
            // System.out.println(map.size());
            step++;
        }
        List mapValues = new ArrayList<>(map.values());
        Collections.sort(mapValues);
        for (Object i : mapValues){
            System.out.println(i);
        
        }
    }
}
