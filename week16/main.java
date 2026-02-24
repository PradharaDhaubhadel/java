package week16;


/**
 * Write a description of class main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class main
{
    public static void main(String[] args) {
        CensusProcessor cp = new CensusProcessor();
        //calling static method, since there are no such methods in main class
        Student[] students = CensusProcessor.parseCSV(cp.csvData);
        String report = CensusProcessor.generateCensusReport(students);
        System.out.println(report);
    }   
}