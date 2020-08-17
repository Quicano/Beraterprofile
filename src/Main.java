import DBMS.SetupBeraterprofile;
import IO.InputClass;

public class Main {
    public static void main(String[] args) {


        SetupBeraterprofile.setupProfile();

        InputClass.analyseInput("Project Manager for Javascript-App which should connect to a SQL Database");
        /*  1) Basic requirements for the "Search Machine":

            The optimal result should be an employee, which has experiences in Javascript,
            SQL and Project Management. If the optimal result isn't available, the "Search Machine"
            should return an employee who has at least some knowledge in some of the written areas.
        */
        InputClass.analyseInput("Bug in Hibernate");
        /*  2) More complex inputs, that the "Search Machine" should be able to understand:

            This is an Example of a short Input with very little information.
            In a perfect world, there should be an employee who has deep understanding and
            knowledge of Hibernate and is passionate about finding and resolving Bugs.
            Should this kind of person not exist, the "Search Machine" should be able to process,
            that Hibernate is a Framework, that connects Java to an SQL database. So the second best Result,
            should be a consultant, who has experiences in SQL and Java and maybe similar Frameworks.
         */
        InputClass.analyseInput("How do I read my Essay into my Python code");
        /*  3) Very Hard to understand for the "Search Machine", in the Best-Case scenario this Input gets a valuable result:

            This is an example of a person who does not know the basic terminologies and is therefore
            unable to comprehensibly describe what the problem ist and what he/she needs. In this case
            the text-analysis has to do the heavy lifting in terms of coming up with an appropriate response.
            In this case: A developer, who knows how to initiate an InputStream in Python.
         */
    }
}
