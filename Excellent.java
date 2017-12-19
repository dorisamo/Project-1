/* *
 * Excellent class implements interface Student
 *
 * @author (Ga Young Lee) lee.gayoung@gmail.com           class :  CS 152-03 
 * @version (Sep. 07, 2017)
 */
public class Excellent implements Student
{
    private String fname, lname;
    private int grade;

    public Excellent(String fname, String lname, int grade)
    {
        this.fname = fname;
        this.lname = lname;
        this.grade = grade;
    }

    public void info()
    {
        System.out.println(fname + " " + lname + "\t" + grade);
    }
}
