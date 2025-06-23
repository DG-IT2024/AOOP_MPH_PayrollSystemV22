
import java.time.LocalTime;
import java.util.Scanner;
import java.util.ArrayList;

class coveredDays {

    public static void main(String[] args) {
        Scanner entry = new Scanner(System.in);

        ArrayList<String> inputs = new ArrayList<>();

        System.out.println("Enter Employee Number");
        String employeeNumber = entry.nextLine();
        int employeeNumber_ = Integer.parseInt(employeeNumber);

        System.out.println("Enter multiple Time-In and Time-out:(format: HH:MM,HH:MM). Type P to process");
        while (true) {
            String inputline = entry.nextLine(); //before "\n" newline charter
            if (inputline.equalsIgnoreCase("p")) { // equalsIgnoreCase ignores the case (uppercase or lowercase) of "done"
                break; // Exit the loop if 'done' is entered
            }

            String[] elements; // Split input by delimiter ","
            for (String element : elements) {
                inputs.add(element.trim()); // Trim spaces and add each elemen
            }
        }
        System.out.println(inputs );
        
    }
    
}
