package Jan29;

/**
 * 
 * @author Neelay Junnarkar
 */
public class CommonPrefix {
    
    public static String commonPrefix(String one, String two) {
        int minlen = (one.length() < two.length()) ? one.length() : two.length();
        int i = 0;
        for (i= 0; i < minlen; ++i) {
            if (one.charAt(i) != two.charAt(i))
                break;
        }
        return one.substring(0, i);
    }
    
    public static void main(String[] args) {
        System.out.println(commonPrefix("Hello", "Hehaw")); //prints "He"
        System.out.println(commonPrefix("Hello", "helloarsadf")); //prints nothing--helloarsadf is lower case
        
    }
}
