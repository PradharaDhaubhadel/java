package week22;


/**
 * Write a description of class Invalid here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class InvalidPatientDataException extends RuntimeException 
{
    public InvalidPatientDataException(String message) 
    {
        super(message);
    }
}