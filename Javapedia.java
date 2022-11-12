import java.util.Scanner;

public class Javapedia {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("\n**********Javapedia**********");
        System.out.println("How many historical figures will you register?");
        //Task 1 – Ask the user: how many historical figures will you register?
        //       – Store the value.
        int historicalFigures = scan.nextInt();
        
        //Task 2 – Create a 2D array with a variable number of rows, and 3 values per row.  
        String[][] figure = new String[historicalFigures][3];      
         
        scan.nextLine();
        //Watch out for the nextLine() pitfall. 
        for (int i = 0; i < figure.length; i++) {

            System.out.println("\n\tFigure " + (i+1)); 

            System.out.print("\t - Name: ");
            String name = scan.nextLine(); 
            figure[i][0] = name;  

            System.out.print("\t - Date of birth: ");
            String dateOfBirth = scan.nextLine();
            figure[i][1] = dateOfBirth;

            System.out.print("\t - Occupation: ");
            String occupation = scan.nextLine(); 
            figure[i][2] = occupation;

            System.out.print("\n");

        }
        
        
        System.out.println("These are the values you stored:"); 
        //Task 4: call print2DArray.
        print2DArray(figure);

        System.out.print("\nWho do you want information on? "); 
        String information = scan.nextLine();
        
        /*Task 5: Let the user search the database by name. 
            If there's a match:
              print(    tab of space    Name: <name>)
              print(    tab of space    Date of birth: <date of birth>)
              print(    tab of space    Occupation: <occupation>)

        */    
        for (int i = 0; i < figure.length; i ++){
          if (figure[i][0].equalsIgnoreCase(information)){
            System.out.println("\tName: " + figure[i][0]);
            System.out.println("\tDate of birth: " + figure[i][1]);
            System.out.println("\tOccupation: " + figure[i][2]);
          }
           }

           scan.close();
        }
            

        
    

    /**
     * Function name: print2DArray
     * @param array (String[][])
     * 
     * Inside the function
     *  1. print the database
     *     • a tab of space precedes each row.
     *     • each value in database has one space from the other value. 
     *     • print a new line.
     */

     public static void print2DArray(String[][] array){
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[i].length; j++){
                System.out.print("\t" + array[i][j] + " ");
            }
            System.out.println("\n");
        }
     }

}
