package week16;


/**
 * Write a description of class q7 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class q7
{
    public boolean isValidPhone(String phone) {
        return phone.matches("9[78]\\d{8}");
    }

    public static void main(String[] args) {
        q7 obj = new q7();
        String p1 = "9841637989";
        String p2 = "1234567890";
        String p3 = "98412345";
        String p4 = "98-412-345";
    
        System.out.println(obj.isValidPhone(p1)); // true
        System.out.println(obj.isValidPhone(p2)); 
        System.out.println(obj.isValidPhone(p3));
        System.out.println(obj.isValidPhone(p3));
        
    }
}

