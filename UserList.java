import java.io.*;
import java.util.*;

public class UserList {
    public static void main(String[] args)throws IOException {
        Map<String, String> map = new HashMap<>();
        String[] strTemp;
        List<String> listOfStrings = new ArrayList<String>();
        BufferedReader bf = new BufferedReader(new FileReader("phoneBook.txt"));
        String line = bf.readLine();
        while (line != null) {
            listOfStrings.add(line);
            line = bf.readLine();
        }
        bf.close();
        for (var item : listOfStrings){
            String[] arr = item.split(":");
            map.put(arr[0], arr[1]);
            System.out.println("Абонент: "+arr[0]);
            String[] phones = arr[1].split(" ");
            for (var ph : phones){
                System.out.println("Тел.: "+ph);
            }
        }
        Scanner input = new Scanner(System.in);
	    System.out.print("Введите имя и фамилию абонента: ");
        String user = input.nextLine();
        if (map.containsKey(user)){
            String ph = map.get(user);
            String[] uPhones = ph.split(" ");
            System.out.println("Существующие телефоны:");
            for (var i : uPhones){
                System.out.println(i);
            }
            System.out.print("Желаете добавить номер? Да=1, нет=0:");
            int variate = input.nextInt();
            if (variate == 1){
                System.out.print("Введите номер телефона: ");
                String newPhone = input.next();
                map.put(user, ph+" "+newPhone);
            }
            else{
                System.out.println("Выход из программы");
            }
        }
        else{
            System.out.print("Введите номер телефона: ");
            String newPhone = input.next();
            map.put(user, newPhone);
        }
	    input.close();
    }
}
