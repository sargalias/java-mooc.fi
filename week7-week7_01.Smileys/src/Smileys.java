
public class Smileys {

    public static void main(String[] args) {
        // Test your method at least with the following
//         printWithSmileys("Method");
//         printWithSmileys("Beerbottle");
//         printWithSmileys("Interface");
    }

    private static void printWithSmileys(String characterString) {
        String strMiddle = createMiddleString(characterString);
        int numSmileys = strMiddle.length() / 2 ;
        printSmileysLine(numSmileys);
        System.out.println(strMiddle);
        printSmileysLine(numSmileys);
    }

    private static void printSmileysLine(int numSmileys) {
        String str = "";
        for (int i=0; i<numSmileys; i++) {
            str += ":)";
        }
        System.out.println(str);
    }

    public static String createMiddleString(String characterString) {
        String strMiddle;
        if (characterString.length() % 2 == 0) {
            strMiddle = ":) " + characterString + " :)";
        } else {
            strMiddle = ":) " + characterString + "  :)";
        }
        return strMiddle;
    }

}
