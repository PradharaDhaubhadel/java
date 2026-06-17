package week21;


/**
 * Write a description of class InvalidEmployeeDataException here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class InvalidEmployeeDataException extends RuntimeException
{
    public InvalidEmployeeDataException(String message) 
    {
        super(message);
    }
}