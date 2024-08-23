package exercise2;
public class ArrayContains {
    public static void main(String[] args) {
        String[] stringArray = {"FTP", "Fresher", "Academy", "2018"};
        String sValue = "Fresher";
        boolean contains = false;
        for (String element : stringArray) {
            if (element.equals(sValue)) {
                contains = true;
                break;
            }
        }
        if (contains) {
            System.out.println("Check '" + sValue + "' in Array: Contained!");
        } else {
            System.out.println("Check '" + sValue + "' in Array: No Contain");
        }
    }
}
