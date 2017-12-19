/* Project ArrayList, Interfaces, Class Object and instanceof opera**
 * This program reads a text file with students record and ask the user to enter command to find students by the grade.
 * possible commands are "excellent", "ok", "all", "end" 
 * if other commands are typed, the program ignores the command.
 *
 * @author (Ga Young Lee) lee.gayoung@gmail.com  class :  CS 152-03 
 * @version (Sep. 07, 2017)
 */
import java.util.Scanner;   
import java.io.*;
import java.util.ArrayList;

public class Students
{
    public static void main (String[] args) throws IOException
    {   String first_name, last_name;
        int grade;
        String prompt = "";     

        /*
         * In this part, program  reads a text file with student records -  students.txt 
         */
        
        Scanner fileInput = new Scanner(new File("students.txt"));
        Student st;
        ArrayList<Student> students = new ArrayList<Student>();                 // create an ArrayList students to store Student st
 
        while (fileInput.hasNext())
        {            
            first_name  = fileInput.next();
            last_name   = fileInput.next();
            grade       = fileInput.nextInt();

            if (grade>89){                                                      // when the grade > 89
                st = new Excellent(first_name, last_name, grade);               // Create an Excellent named st
                students.add(st);                                               // store st into ArrayList student
            } else {                                                            // when the grade <= 89
                st = new Ok(first_name, last_name, grade);                      // Create an Ok named st
                students.add(st);                                               // store st into ArrayList student
            }



        }

        /* 
         * Prompt the user to enter a command(excellent, ok, all, or end)
         * "all" - prints all student records (first name, last name, grade).
         * "excellent" - prints students with grade > 89.
         * "ok" - prints students with grade <= 89.
         * "end" - exits the loop the terminates the program.
         * When other commands are entered, it is ignored.
         */
        Scanner in = new Scanner(System.in);                                    
        System.out.print("Enter a command (excellent, ok, all, or end ): ");                     // ask the user to enter a command
        prompt = in.next();                                                                      // get command from user (prompt) 
        prompt = prompt.toLowerCase();                                                           // commands from prompt are changed to lower cases 

        while(prompt.length()>0 && !prompt.equals("end")){         //                              //when the user enters "end" the program terminates
    
            for(int i=0;i<students.size();i++){
                if(prompt.equals("all")) students.get(i).info();                                //when the user enters "all" show all students
                else if(prompt.equals("ok") && students.get(i) instanceof Ok){                  //when the user enters "ok" show students in Ok
                    students.get(i).info();
                } else if(prompt.equals("excellent") && students.get(i) instanceof Excellent){  //when the user enters "excellent"show students in Excellent
                    students.get(i).info();    
                }
            }// end of for loop
    
            System.out.print("Enter a command (excellent, ok, all, or end ) : ");
            prompt = in.next();
            prompt = prompt.toLowerCase();

        } // end of while loop
    
    }

}
