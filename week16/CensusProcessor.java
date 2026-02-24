package week16;


/**
 * Write a description of class CensusProcessor here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CensusProcessor
{
    String[] csvData = {
        "Name,Age,School,Grade,Citizenship,Phone",
        "Ram Bahadur Thapa,18,Itahari Int. College,12,01-0012345,9841234567",
        "Sita Kumari Rai,17,Itahari Int. College,11,01-0054321,9807654321",
        "Hari Prasad Sharma,19,ICK College,12,02-0098765,9812345678",
        "Gita Devi Tamang,16,ICP College,10,03-0011111,9800000000",
        "Bikash Kumar Limbu,18,Itahari Int. College,12,01-0077777,9841111111",
        "Anita Rai,17,ICK College,11,04-002222,981234",
        "Deepak Shah,20,ICP College,12,01-00ABCDE,9867890123"
    };
    
    public static Student[] parseCSV(String[] csvData){
        Student[] stud = new Student[csvData.length - 1];//skipping the header
        for(int i =1; i<csvData.length; i++){
            String[] text1 = csvData[i].split(",");
            for(int j=0; j<text1.length;j++){//trimming the data
            text1[j] = text1[j].trim();
            }
            
            int age = Integer.parseInt(text1[1]);
            int grade = Integer.parseInt(text1[3]);
            
            String name = text1[0];
            String school = text1[2];
            String citizenship = text1[4];
            String phone = text1[5];
            
            stud[i-1] = new Student(name,age,school,grade,citizenship,phone);
            //our first data is in index 1 but for printing it starts from 0 so we are keeping it at 0 by doing i-1
        }
        return stud;
    }
    
    public static boolean isValidCitizenship(String cit){
        if(cit.length() != 10){
            return false;
        }
        if(cit.charAt(2) != '-'){
            return false;
        }
        //making sure first 2 are digits
        if (!Character.isDigit(cit.charAt(0)) || !Character.isDigit(cit.charAt(1))) {
            return false;
        }
        //making sure last 7 characters are digits
        for(int i = 3; i< cit.length(); i++){ //i = 3: starting from the 3rd index
            if(!Character.isDigit(cit.charAt(i))){
                return false;
            }
        }
        return true;
    }
    
    public String findBySchool(Student[] students, String school){
        StringBuilder result = new StringBuilder();
        for (Student s : students) {
            if (s.getSchool().equalsIgnoreCase(school)) {
            result.append(s.getName()).append("\n");
            }
        }
        return result.toString();
    }
    public int countByGrade(Student[] students, int grade) {
        int i = 0;
            for (Student s : students) {
                if (s.getGrade() == grade) {
                    i++;
                }
            }
        return i;
    }
    public static double averageAge(Student[] students) {
        int totalAge = 0;
        for (Student s : students) {
            totalAge = totalAge + s.getAge();
        }
        return (double) totalAge / students.length;
    }
    public static String findLongestName(Student[] students) {
        String longestName = students[0].getName();
        for (Student s : students) {
            if (s.getName().length() > longestName.length()) {
                longestName = s.getName();
            }
        }
        return longestName;
    }
    
    public static int studentCount(Student[] students, String school) {
        int std = 0;
        for (int i = 0; i < students.length; i++) {
            if (students[i].getSchool().equalsIgnoreCase(school)) {
                std++;
            }
        }
        return std;
    }
    
    
    public static String generateCensusReport(Student[] students){
        StringBuilder sb = new StringBuilder("===== Nepal School Census Report =====\n");

        // valid counts for citizenship
        int isValid = 0;
        for (Student s : students) {
            if (isValidCitizenship(s.getCitizenship())) {
                isValid++;
            }
        }

        sb.append(String.format("Total students: %d   Valid records: %d    Invalid records: %d\n",students.length, isValid, students.length - isValid));
        
        sb.append("- Student List -\n");
        for (Student s : students) {
            String valid = isValidCitizenship(s.getCitizenship()) ? "VALID" : "INVALID";
            sb.append(String.format("%s | Age %d | Grade %d | %s\n", s.getName(), s.getAge(), s.getGrade(), valid));
        }

        sb.append("- Statistics -\n");
        sb.append(String.format("Average age : %f\n",averageAge(students)));
        String longest = findLongestName(students);
        sb.append(String.format("Longest name : %s (%d characters)\n", longest, longest.length()));
        sb.append(String.format("Itahari Int. College: %d\n", studentCount(students,"Itahari Int. College"))); 

        return sb.toString();
    }

}
    
    


    


    
