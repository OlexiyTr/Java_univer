import java.security.Key;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;

public class task_9 {
    public static void main(String args[]){
        String stroka = "abcdefgghhh";
        func(stroka);
    }
    public static void func(String str){
        char[] char_arr = str.toCharArray();
        Map<String,Integer> dictionary = new HashMap<String,Integer>();

        for (int i = 0; i < str.length(); i++){
            if(dictionary.containsKey(char_arr[i]) == false){
                String symbol = Character.toString(char_arr[i]);
                dictionary.put(symbol,countOccurrences(str,char_arr[i]));
            }
            else{
                continue;
            }
        }
        System.out.println(dictionary.keySet());
        System.out.println(dictionary.values());
        int min_ = Collections.min(dictionary.values());
        int max_ = Collections.max(dictionary.values());
        for(String name : dictionary.keySet()){
            if (dictionary.get(name) == max_){
                System.out.println("Max: " + name + ": " + max_);
                break;
            }
            else{
                continue;
            }
        }
        for(String name : dictionary.keySet()){
            if (dictionary.get(name) == min_){
                System.out.println("Max: " + name + ": " + min_);
                break;
            }
            else{
                continue;
            }
        }

    }
    public static int countOccurrences(String haystack, char needle)
    {
        int count = 0;
        for (int i=0; i < haystack.length(); i++)
        {
            if (haystack.charAt(i) == needle)
            {
                count++;
            }
        }
        return count;
    }
}
