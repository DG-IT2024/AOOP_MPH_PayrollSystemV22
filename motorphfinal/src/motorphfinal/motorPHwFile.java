package motorphfinal;

/**
 *
 * @author amatibag
 */
import java.util.*;
import java.io.*;
import java.time.*;

public class motorPHwFile {

    public static void main(String[] args) throws FileNotFoundException {
        //print out list of employee
        System.out.println("Hello\nHere's the list of Motor PH employees.");
        System.out.println("Please choose associate details you want to view by entering Employee Number below:\n");

        File employeeList = new File("EmployeeList.txt");
        Scanner employeefile = new Scanner(employeeList);
        while (employeefile.hasNextLine()) {
            System.out.println(employeefile.nextLine());
        }
        System.out.println("\n");

        //delete existing file
        File paySumC = new File("paySummary.txt");

        if (paySumC.delete()) {
            System.out.println("Process reset any existing paySummary.txt will reset to blank.");
        } else {
            System.out.println(" ");
        }

        //create a paysummary file
        File paySum = new File("paySummary.txt");

        try {
            if (paySum.createNewFile()) {
                System.out.println("New paySummary file is created sucessfully.\n");
            } else {
                System.out.println(" ");
            }
        } catch (IOException ex) {
            System.out.println(" ");
        }

        //print header into the file
        try {
            FileWriter header = new FileWriter("paySummary.txt");
            PrintWriter prheader = new PrintWriter(header);

            prheader.printf("%-15s%-33s%-16s%-12s%-20s%-16s%-24s%-15s%-15s", "Employee#", "Employee Name", "GrossPay", "SSS", "PhilHealth", "PagIbig", "WitholdingTax", "Benefits", "NetPay");
            header.close();
        } catch (IOException ex) {
            System.out.println(" ");
        }

        enterEmployeeNo();

    }

    public static void enterEmployeeNo() {
//get an entry
        System.out.println("Please Enter the employee number of the employee you want to view and calculate salary:");
        Scanner employeNoEntry = new Scanner(System.in);
        try {
            int employeeNoEntry = employeNoEntry.nextInt();
           
            if (employeeNoEntry == 1) {
                employee1();
            } else {
                if (employeeNoEntry == 2) {
                    employee2();
                } else {
                    if (employeeNoEntry == 3) {
                        employee3();
                    } else {
                        if (employeeNoEntry == 4) {
                            employee4();
                        } else {
                            if (employeeNoEntry == 5) {
                                employee5();
                            } else {
                                if (employeeNoEntry == 6) {
                                    employee6();
                                } else {
                                    if (employeeNoEntry == 7) {
                                        employee7();
                                    } else {
                                        if (employeeNoEntry == 8) {
                                            employee8();
                                        } else {
                                            if (employeeNoEntry == 9) {
                                                employee9();
                                            } else {
                                                if (employeeNoEntry == 10) {
                                                    employee10();
                                                } else {
                                                    if (employeeNoEntry == 11) {
                                                        employee11();
                                                    } else {
                                                        if (employeeNoEntry == 12) {
                                                            employee12();
                                                        } else {
                                                            if (employeeNoEntry == 13) {
                                                                employee13();
                                                            } else {
                                                                if (employeeNoEntry == 14) {
                                                                    employee14();
                                                                } else {
                                                                    if (employeeNoEntry == 15) {
                                                                        employee15();
                                                                    } else {
                                                                        if (employeeNoEntry == 16) {
                                                                            employee16();
                                                                        } else {
                                                                            if (employeeNoEntry == 17) {
                                                                                employee17();
                                                                            } else {
                                                                                if (employeeNoEntry == 18) {
                                                                                    employee18();
                                                                                } else {
                                                                                    if (employeeNoEntry == 19) {
                                                                                        employee19();
                                                                                    } else {
                                                                                        if (employeeNoEntry == 20) {
                                                                                            employee20();
                                                                                        } else {
                                                                                            if (employeeNoEntry == 21) {
                                                                                                employee21();
                                                                                            } else {
                                                                                                if (employeeNoEntry == 22) {
                                                                                                    employee22();
                                                                                                } else {
                                                                                                    if (employeeNoEntry == 23) {
                                                                                                        employee23();
                                                                                                    } else {
                                                                                                        if (employeeNoEntry == 24) {
                                                                                                            employee24();
                                                                                                        } else {
                                                                                                            if (employeeNoEntry == 25) {
                                                                                                                employee25();
                                                                                                            } else {
                                                                                                                if (employeeNoEntry == 26) {
                                                                                                                    employee26();
                                                                                                                } else {
                                                                                                                    if (employeeNoEntry == 27) {
                                                                                                                        employee27();
                                                                                                                    } else {
                                                                                                                        if (employeeNoEntry == 28) {
                                                                                                                            employee28();
                                                                                                                        } else {
                                                                                                                            if (employeeNoEntry == 29) {
                                                                                                                                employee29();
                                                                                                                            } else {
                                                                                                                                if (employeeNoEntry == 30) {
                                                                                                                                    employee30();
                                                                                                                                } else {
                                                                                                                                    if (employeeNoEntry == 31) {
                                                                                                                                        employee31();
                                                                                                                                    } else {
                                                                                                                                        if (employeeNoEntry == 32) {
                                                                                                                                            employee32();
                                                                                                                                        } else {
                                                                                                                                            if (employeeNoEntry == 33) {
                                                                                                                                                employee33();
                                                                                                                                            } else {
                                                                                                                                                if (employeeNoEntry == 34) {
                                                                                                                                                    employee34();
                                                                                                                                                } else {
                                                                                                                                                    System.out.println("!!! INVALID ENTRY ENTERED !!!" + "\n");
                                                                                                                                                    enterEmployeeNo();
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception invalidEntry) {
            System.out.println("!!! INVALID ENTRY ENTERED !!!\n");
            enterEmployeeNo();
        }
    }

    public static void employee1() {
        int employe1 = 1;
        String lastName1 = "Garcia";
        String firstName1 = "Manuel III";
        String birthday1 = "10/11/1983";
        String address1 = "Valero Carpark Building Valero Street 1227, Makati City";
        String phoneNumber1 = "966-860-270";
        String sssNo1 = "44-4506057-3";
        String philhealthNo1 = "820126853951";
        String tinNo1 = "442-605-657-000";
        String pagibig1 = "691295330870";
        String status1 = "Regular";
        String position1 = "Chief Executive Officer";
        String immediateSupervisor1 = "N/A";
        double basicSalary1 = 90000;
        double riceSubsidy1 = 1500;
        double phoneAllowance1 = 2000;
        double clothingAllowance1 = 1000;
        double grossSemiMonthlyRate1 = 45000;
        double hourlyRate1 = 535.71;

        System.out.println("Here are the details based on the Employee Number you entered: " + "\n"
                + "Employee #:                " + employe1 + "\n"
                + "Last Name:                 " + lastName1 + "\n"
                + "First Name:                " + firstName1 + "\n"
                + "Birthday:                  " + birthday1 + "\n"
                + "Address:                   " + address1 + "\n"
                + "Phone Number:              " + phoneNumber1 + "\n"
                + "SSS Number:                " + sssNo1 + "\n"
                + "Philhealth Number:         " + philhealthNo1 + "\n"
                + "TIN Number:                " + tinNo1 + "\n"
                + "Pag-ibig Number:           " + pagibig1 + "\n"
                + "Status:                    " + status1 + "\n"
                + "Position:                  " + position1 + "\n"
                + "Immediate Supervisor:      " + immediateSupervisor1 + "\n"
                + "Basic Salary:              " + basicSalary1 + "\n"
                + "Rice Subsidy:              " + riceSubsidy1 + "\n"
                + "Phone Allowance:           " + phoneAllowance1 + "\n"
                + "Clothing Allowance:        " + clothingAllowance1 + "\n"
                + "Gross Semi-monthly Rate:   " + grossSemiMonthlyRate1 + "\n"
                + "Hourly Rate:               " + hourlyRate1 + "\n");

//calculate salary
        try {
            double nonTaxableBenefits = riceSubsidy1 + phoneAllowance1 + clothingAllowance1;
            double taxableEarnings = calculateTaxableWage(hourlyRate1);
            double sSS = calculateSSS(basicSalary1);
            double philHealth = calculatePhilHealth(basicSalary1);
            double pagIbig = calculatePagibig(basicSalary1);
            double withEarnings = taxableEarnings - (sSS + philHealth + pagIbig);
            double witHoldingTax = calculateWitholdingTax(withEarnings);

            System.out.println("\n" + "Would you like to add the Non-Taxable Benefits on your calculation? Type yes or no:");
            Scanner refBen = new Scanner(System.in);
            String addBen = refBen.next();

            if ("no".equals(addBen.toLowerCase())) {
                payslipNObenefits(taxableEarnings, sSS, philHealth,
                        pagIbig, witHoldingTax, employe1, lastName1, firstName1);
            } else {
                if ("yes".equals(addBen.toLowerCase())) {
                    payslipWITHbenefits(taxableEarnings, sSS, philHealth,
                            pagIbig, witHoldingTax, nonTaxableBenefits,
                            riceSubsidy1, phoneAllowance1, clothingAllowance1, employe1, lastName1, firstName1);
                }
            }

            System.out.println("\n" + "\n");
            enterEmployeeNo();
        } catch (Exception invalidEntry) {
            System.out.println("!!! INVALID ENTRY ENTERED !!!" + "\n");
            enterEmployeeNo();
        }

    }

    public static void employee2() {
        int employe2 = 2;
        String lastName2 = "Lim";
        String firstName2 = "Antonio";
        String birthday2 = "06/19/1988";
        String address2 = "San Antonio De Padua 2, Block 1 Lot 8 and 2, Dasmarinas, Cavite";
        String phoneNumber2 = "171-867-411";
        String sssNo2 = "52-2061274-9";
        String philhealthNo2 = "331735646338";
        String tinNo2 = "683-102-776-000";
        String pagibig2 = "663904995411";
        String status2 = "Regular";
        String position2 = "Chief Operating Officer";
        String immediateSupervisor2 = "Garcia, Manuel III";
        double basicSalary2 = 60000;
        double riceSubsidy2 = 1500;
        double phoneAllowance2 = 2000;
        double clothingAllowance2 = 1000;
        double grossSemiMonthlyRate2 = 30000;
        double hourlyRate2 = 357.14;

        System.out.println("Here are the details based on the Employee Number you entered: " + "\n"
                + "Employee #:            " + employe2 + "\n"
                + "Last Name:             " + lastName2 + "\n"
                + "First Name:            " + firstName2 + "\n"
                + "Birthday:              " + birthday2 + "\n"
                + "Address:               " + address2 + "\n"
                + "Phone Number:          " + phoneNumber2 + "\n"
                + "SSS Number:            " + sssNo2 + "\n"
                + "Philhealth Number:     " + philhealthNo2 + "\n"
                + "TIN Number:            " + tinNo2 + "\n"
                + "Pag-ibig Number:       " + pagibig2 + "\n"
                + "Status:                " + status2 + "\n"
                + "Position:              " + position2 + "\n"
                + "Immediate Supervisor:  " + immediateSupervisor2 + "\n"
                + "Basic Salary:          " + basicSalary2 + "\n"
                + "Rice Subsidy:          " + riceSubsidy2 + "\n"
                + "Phone Allowance:       " + phoneAllowance2 + "\n"
                + "Clothing Allowance:    " + clothingAllowance2 + "\n"
                + "Gross Semi-monthly Rate:" + grossSemiMonthlyRate2 + "\n"
                + "Hourly Rate:           " + hourlyRate2 + "\n" + "\n");

//calculate salary
        try {
            double nonTaxableBenefits = riceSubsidy2 + phoneAllowance2 + clothingAllowance2;
            double taxableEarnings = calculateTaxableWage(hourlyRate2);
            double sSS = calculateSSS(basicSalary2);
            double philHealth = calculatePhilHealth(basicSalary2);
            double pagIbig = calculatePagibig(basicSalary2);
            double withEarnings = taxableEarnings - (sSS + philHealth + pagIbig);
            double witHoldingTax = calculateWitholdingTax(withEarnings);

            System.out.println("\n" + "Would you like to add the Non-Taxable Benefits on your calculation? Type yes or no:");
            Scanner refBen = new Scanner(System.in);
            String addBen = refBen.next();

            if ("no".equals(addBen.toLowerCase())) {
                payslipNObenefits(taxableEarnings, sSS, philHealth,
                        pagIbig, witHoldingTax, employe2, lastName2, firstName2);
            } else {
                if ("yes".equals(addBen.toLowerCase())) {
                    payslipWITHbenefits(taxableEarnings, sSS, philHealth,
                            pagIbig, witHoldingTax, nonTaxableBenefits,
                            riceSubsidy2, phoneAllowance2, clothingAllowance2, employe2, lastName2, firstName2);
                }
            }

            System.out.println("\n" + "\n");
            enterEmployeeNo();
        } catch (Exception invalidEntry) {
            System.out.println("!!! INVALID ENTRY ENTERED !!!" + "\n");
            enterEmployeeNo();
        }

    }

    public static void employee3() {
        int employe3 = 3;
        String lastName3 = "Aquino";
        String firstName3 = "Bianca Sofia";
        String birthday3 = "08/04/1989";
        String address3 = "Rm. 402 4/F Jiao Building Timog Avenue Cor. Quezon Avenue 1100, Quezon City";
        String phoneNumber3 = "966-889-370";
        String sssNo3 = "30-8870406-2";
        String philhealthNo3 = "177451189665";
        String tinNo3 = "971-711-280-000";
        String pagibig3 = "171519773969";
        String status3 = "Regular";
        String position3 = "Chief Finance Officer";
        String immediateSupervisor3 = "Garcia, Manuel III";
        double basicSalary3 = 60000;
        double riceSubsidy3 = 1500;
        double phoneAllowance3 = 2000;
        double clothingAllowance3 = 1000;
        double grossSemiMonthlyRate3 = 30000;
        double hourlyRate3 = 357.14;

        System.out.println("Here are the details based on the Employee Number you entered: " + "\n"
                + "Employee #:            " + employe3 + "\n"
                + "Last Name:             " + lastName3 + "\n"
                + "First Name:            " + firstName3 + "\n"
                + "Birthday:              " + birthday3 + "\n"
                + "Address:               " + address3 + "\n"
                + "Phone Number:          " + phoneNumber3 + "\n"
                + "SSS Number:            " + sssNo3 + "\n"
                + "Philhealth Number:     " + philhealthNo3 + "\n"
                + "TIN Number:            " + tinNo3 + "\n"
                + "Pag-ibig Number:       " + pagibig3 + "\n"
                + "Status:                " + status3 + "\n"
                + "Position:              " + position3 + "\n"
                + "Immediate Supervisor:  " + immediateSupervisor3 + "\n"
                + "Basic Salary:          " + basicSalary3 + "\n"
                + "Rice Subsidy:          " + riceSubsidy3 + "\n"
                + "Phone Allowance:       " + phoneAllowance3 + "\n"
                + "Clothing Allowance:    " + clothingAllowance3 + "\n"
                + "Gross Semi-monthly Rate:" + grossSemiMonthlyRate3 + "\n"
                + "Hourly Rate:           " + hourlyRate3 + "\n");

//calculate salary
        try {
            double nonTaxableBenefits = riceSubsidy3 + phoneAllowance3 + clothingAllowance3;
            double taxableEarnings = calculateTaxableWage(hourlyRate3);
            double sSS = calculateSSS(basicSalary3);
            double philHealth = calculatePhilHealth(basicSalary3);
            double pagIbig = calculatePagibig(basicSalary3);
            double withEarnings = taxableEarnings - (sSS + philHealth + pagIbig);
            double witHoldingTax = calculateWitholdingTax(withEarnings);

            System.out.println("\n" + "Would you like to add the Non-Taxable Benefits on your calculation? Type yes or no:");
            Scanner refBen = new Scanner(System.in);
            String addBen = refBen.next();

            if ("no".equals(addBen.toLowerCase())) {
                payslipNObenefits(taxableEarnings, sSS, philHealth,
                        pagIbig, witHoldingTax, employe3, lastName3, firstName3);
            } else {
                if ("yes".equals(addBen.toLowerCase())) {
                    payslipWITHbenefits(taxableEarnings, sSS, philHealth,
                            pagIbig, witHoldingTax, nonTaxableBenefits,
                            riceSubsidy3, phoneAllowance3, clothingAllowance3, employe3, lastName3, firstName3);
                }
            }

            System.out.println("\n" + "\n");
            enterEmployeeNo();
        } catch (Exception invalidEntry) {
            System.out.println("!!! INVALID ENTRY ENTERED !!!" + "\n");
            enterEmployeeNo();
        }

    }

    public static void employee4() {
        int employe4 = 4;
        String lastName4 = "Reyes";
        String firstName4 = "Isabella";
        String birthday4 = "06/16/1994";
        String address4 = "460 Solanda Street Intramuros 1000, Manila";
        String phoneNumber4 = "786-868-477";
        String sssNo4 = "40-2511815-0";
        String philhealthNo4 = "341911411254";
        String tinNo4 = "876-809-437-000";
        String pagibig4 = "416946776041";
        String status4 = "Regular";
        String position4 = "Chief Marketing Officer";
        String immediateSupervisor4 = "Garcia, Manuel III";
        double basicSalary4 = 60000;
        double riceSubsidy4 = 1500;
        double phoneAllowance4 = 2000;
        double clothingAllowance4 = 1000;
        double grossSemiMonthlyRate4 = 30000;
        double hourlyRate4 = 357.14;

        System.out.println("Here are the details based on the Employee Number you entered: " + "\n"
                + "Employee #:            " + employe4 + "\n"
                + "Last Name:             " + lastName4 + "\n"
                + "First Name:            " + firstName4 + "\n"
                + "Birthday:              " + birthday4 + "\n"
                + "Address:               " + address4 + "\n"
                + "Phone Number:          " + phoneNumber4 + "\n"
                + "SSS Number:            " + sssNo4 + "\n"
                + "Philhealth Number:     " + philhealthNo4 + "\n"
                + "TIN Number:            " + tinNo4 + "\n"
                + "Pag-ibig Number:       " + pagibig4 + "\n"
                + "Status:                " + status4 + "\n"
                + "Position:              " + position4 + "\n"
                + "Immediate Supervisor:  " + immediateSupervisor4 + "\n"
                + "Basic Salary:          " + basicSalary4 + "\n"
                + "Rice Subsidy:          " + riceSubsidy4 + "\n"
                + "Phone Allowance:       " + phoneAllowance4 + "\n"
                + "Clothing Allowance:    " + clothingAllowance4 + "\n"
                + "Gross Semi-monthly Rate:" + grossSemiMonthlyRate4 + "\n"
                + "Hourly Rate:           " + hourlyRate4 + "\n");

        //calculate salary
        try {
            double nonTaxableBenefits = riceSubsidy4 + phoneAllowance4 + clothingAllowance4;
            double taxableEarnings = calculateTaxableWage(hourlyRate4);
            double sSS = calculateSSS(basicSalary4);
            double philHealth = calculatePhilHealth(basicSalary4);
            double pagIbig = calculatePagibig(basicSalary4);
            double withEarnings = taxableEarnings - (sSS + philHealth + pagIbig);
            double witHoldingTax = calculateWitholdingTax(withEarnings);

            System.out.println("\n" + "Would you like to add the Non-Taxable Benefits on your calculation? Type yes or no:");
            Scanner refBen = new Scanner(System.in);
            String addBen = refBen.next();

            if ("no".equals(addBen.toLowerCase())) {
                payslipNObenefits(taxableEarnings, sSS, philHealth,
                        pagIbig, witHoldingTax, employe4, lastName4, firstName4);
            } else {
                if ("yes".equals(addBen.toLowerCase())) {
                    payslipWITHbenefits(taxableEarnings, sSS, philHealth,
                            pagIbig, witHoldingTax, nonTaxableBenefits,
                            riceSubsidy4, phoneAllowance4, clothingAllowance4, employe4, lastName4, firstName4);
                }
            }

            System.out.println("\n" + "\n");
            enterEmployeeNo();
        } catch (Exception invalidEntry) {
            System.out.println("!!! INVALID ENTRY ENTERED !!!" + "\n");
            enterEmployeeNo();
        }

    }

    public static void employee5() {
        int employe5 = 5;
        String lastName5 = "Hernandez";
        String firstName5 = "Eduard";
        String birthday5 = "09/23/1989";
        String address5 = "National Highway, Gingoog, Misamis Occidental";
        String phoneNumber5 = "088-861-012";
        String sssNo5 = "50-5577638-1";
        String philhealthNo5 = "957436191812";
        String tinNo5 = "031-702-374-000";
        String pagibig5 = "952347222457";
        String status5 = "Regular";
        String position5 = "IT Operations and Systems";
        String immediateSupervisor5 = "Lim, Antonio";
        double basicSalary5 = 52670;
        double riceSubsidy5 = 1500;
        double phoneAllowance5 = 1000;
        double clothingAllowance5 = 1000;
        double grossSemiMonthlyRate5 = 26335;
        double hourlyRate5 = 313.51;

        System.out.println("Here are the details based on the Employee Number you entered: " + "\n"
                + "Employee #:            " + employe5 + "\n"
                + "Last Name:             " + lastName5 + "\n"
                + "First Name:            " + firstName5 + "\n"
                + "Birthday:              " + birthday5 + "\n"
                + "Address:               " + address5 + "\n"
                + "Phone Number:          " + phoneNumber5 + "\n"
                + "SSS Number:            " + sssNo5 + "\n"
                + "Philhealth Number:     " + philhealthNo5 + "\n"
                + "TIN Number:            " + tinNo5 + "\n"
                + "Pag-ibig Number:       " + pagibig5 + "\n"
                + "Status:                " + status5 + "\n"
                + "Position:              " + position5 + "\n"
                + "Immediate Supervisor:  " + immediateSupervisor5 + "\n"
                + "Basic Salary:          " + basicSalary5 + "\n"
                + "Rice Subsidy:          " + riceSubsidy5 + "\n"
                + "Phone Allowance:       " + phoneAllowance5 + "\n"
                + "Clothing Allowance:    " + clothingAllowance5 + "\n"
                + "Gross Semi-monthly Rate:" + grossSemiMonthlyRate5 + "\n"
                + "Hourly Rate:           " + hourlyRate5 + "\n");

//calculate salary
        try {
            double nonTaxableBenefits = riceSubsidy5 + phoneAllowance5 + clothingAllowance5;
            double taxableEarnings = calculateTaxableWage(hourlyRate5);
            double sSS = calculateSSS(basicSalary5);
            double philHealth = calculatePhilHealth(basicSalary5);
            double pagIbig = calculatePagibig(basicSalary5);
            double withEarnings = taxableEarnings - (sSS + philHealth + pagIbig);
            double witHoldingTax = calculateWitholdingTax(withEarnings);

            System.out.println("\n" + "Would you like to add the Non-Taxable Benefits on your calculation? Type yes or no:");
            Scanner refBen = new Scanner(System.in);
            String addBen = refBen.next();

            if ("no".equals(addBen.toLowerCase())) {
                payslipNObenefits(taxableEarnings, sSS, philHealth,
                        pagIbig, witHoldingTax, employe5, lastName5, firstName5);
            } else {
                if ("yes".equals(addBen.toLowerCase())) {
                    payslipWITHbenefits(taxableEarnings, sSS, philHealth,
                            pagIbig, witHoldingTax, nonTaxableBenefits,
                            riceSubsidy5, phoneAllowance5, clothingAllowance5, employe5, lastName5, firstName5);
                }
            }

            System.out.println("\n" + "\n");
            enterEmployeeNo();
        } catch (Exception invalidEntry) {
            System.out.println("!!! INVALID ENTRY ENTERED !!!" + "\n");
            enterEmployeeNo();
        }

    }

    public static void employee6() {
        int employe6 = 6;
        String lastName6 = "Villanueva";
        String firstName6 = "Andrea Mae";
        String birthday6 = "02/14/1988";
        String address6 = "17/85 Stracke Via Suite 042, Poblacion, Las Piñas 4783 Dinagat Islands";
        String phoneNumber6 = "918-621-603";
        String sssNo6 = "49-1632020-8";
        String philhealthNo6 = "382189453145";
        String tinNo6 = "317-674-022-000";
        String pagibig6 = "441093369646";
        String status6 = "Regular";
        String position6 = "HR Manager";
        String immediateSupervisor6 = "Lim, Antonio";
        double basicSalary6 = 52670;
        double riceSubsidy6 = 1500;
        double phoneAllowance6 = 1000;
        double clothingAllowance6 = 1000;
        double grossSemiMonthlyRate6 = 26335;
        double hourlyRate6 = 313.51;

        System.out.println("Here are the details based on the Employee Number you entered: " + "\n"
                + "Employee #:            " + employe6 + "\n"
                + "Last Name:             " + lastName6 + "\n"
                + "First Name:            " + firstName6 + "\n"
                + "Birthday:              " + birthday6 + "\n"
                + "Address:               " + address6 + "\n"
                + "Phone Number:          " + phoneNumber6 + "\n"
                + "SSS Number:            " + sssNo6 + "\n"
                + "Philhealth Number:     " + philhealthNo6 + "\n"
                + "TIN Number:            " + tinNo6 + "\n"
                + "Pag-ibig Number:       " + pagibig6 + "\n"
                + "Status:                " + status6 + "\n"
                + "Position:              " + position6 + "\n"
                + "Immediate Supervisor:  " + immediateSupervisor6 + "\n"
                + "Basic Salary:          " + basicSalary6 + "\n"
                + "Rice Subsidy:          " + riceSubsidy6 + "\n"
                + "Phone Allowance:       " + phoneAllowance6 + "\n"
                + "Clothing Allowance:    " + clothingAllowance6 + "\n"
                + "Gross Semi-monthly Rate:" + grossSemiMonthlyRate6 + "\n"
                + "Hourly Rate:           " + hourlyRate6 + "\n");

        //calculate salary
        try {
            double nonTaxableBenefits = riceSubsidy6 + phoneAllowance6 + clothingAllowance6;
            double taxableEarnings = calculateTaxableWage(hourlyRate6);
            double sSS = calculateSSS(basicSalary6);
            double philHealth = calculatePhilHealth(basicSalary6);
            double pagIbig = calculatePagibig(basicSalary6);
            double withEarnings = taxableEarnings - (sSS + philHealth + pagIbig);
            double witHoldingTax = calculateWitholdingTax(withEarnings);

            System.out.println("\n" + "Would you like to add the Non-Taxable Benefits on your calculation? Type yes or no:");
            Scanner refBen = new Scanner(System.in);
            String addBen = refBen.next();

            if ("no".equals(addBen.toLowerCase())) {
                payslipNObenefits(taxableEarnings, sSS, philHealth,
                        pagIbig, witHoldingTax, employe6, lastName6, firstName6);
            } else {
                if ("yes".equals(addBen.toLowerCase())) {
                    payslipWITHbenefits(taxableEarnings, sSS, philHealth,
                            pagIbig, witHoldingTax, nonTaxableBenefits,
                            riceSubsidy6, phoneAllowance6, clothingAllowance6, employe6, lastName6, firstName6);
                }
            }

            System.out.println("\n" + "\n");
            enterEmployeeNo();
        } catch (Exception invalidEntry) {
            System.out.println("!!! INVALID ENTRY ENTERED !!!" + "\n");
            enterEmployeeNo();
        }

    }

    public static void employee7() {
        int employe7 = 7;
        String lastName7 = "San Jose";
        String firstName7 = "Brad";
        String birthday7 = "03/15/1996";
        String address7 = "99 Strosin Hills, Poblacion, Bislig 5340 Tawi-Tawi";
        String phoneNumber7 = "797-009-261";
        String sssNo7 = "40-2400714-1";
        String philhealthNo7 = "239192926939";
        String tinNo7 = "672-474-690-000";
        String pagibig7 = "210850209964";
        String status7 = "Regular";
        String position7 = "HR Team Leader";
        String immediateSupervisor7 = "Villanueva, Andrea Mae";
        double basicSalary7 = 42975;
        double riceSubsidy7 = 1500;
        double phoneAllowance7 = 800;
        double clothingAllowance7 = 800;
        double grossSemiMonthlyRate7 = 21488;
        double hourlyRate7 = 255.8;

        System.out.println("Here are the details based on the Employee Number you entered: " + "\n"
                + "Employee #:            " + employe7 + "\n"
                + "Last Name:             " + lastName7 + "\n"
                + "First Name:            " + firstName7 + "\n"
                + "Birthday:              " + birthday7 + "\n"
                + "Address:               " + address7 + "\n"
                + "Phone Number:          " + phoneNumber7 + "\n"
                + "SSS Number:            " + sssNo7 + "\n"
                + "Philhealth Number:     " + philhealthNo7 + "\n"
                + "TIN Number:            " + tinNo7 + "\n"
                + "Pag-ibig Number:       " + pagibig7 + "\n"
                + "Status:                " + status7 + "\n"
                + "Position:              " + position7 + "\n"
                + "Immediate Supervisor:  " + immediateSupervisor7 + "\n"
                + "Basic Salary:          " + basicSalary7 + "\n"
                + "Rice Subsidy:          " + riceSubsidy7 + "\n"
                + "Phone Allowance:       " + phoneAllowance7 + "\n"
                + "Clothing Allowance:    " + clothingAllowance7 + "\n"
                + "Gross Semi-monthly Rate:" + grossSemiMonthlyRate7 + "\n"
                + "Hourly Rate:           " + hourlyRate7 + "\n");

        //calculate salary
        try {
            double nonTaxableBenefits = riceSubsidy7 + phoneAllowance7 + clothingAllowance7;
            double taxableEarnings = calculateTaxableWage(hourlyRate7);
            double sSS = calculateSSS(basicSalary7);
            double philHealth = calculatePhilHealth(basicSalary7);
            double pagIbig = calculatePagibig(basicSalary7);
            double withEarnings = taxableEarnings - (sSS + philHealth + pagIbig);
            double witHoldingTax = calculateWitholdingTax(withEarnings);

            System.out.println("\n" + "Would you like to add the Non-Taxable Benefits on your calculation? Type yes or no:");
            Scanner refBen = new Scanner(System.in);
            String addBen = refBen.next();

            if ("no".equals(addBen.toLowerCase())) {
                payslipNObenefits(taxableEarnings, sSS, philHealth,
                        pagIbig, witHoldingTax, employe7, lastName7, firstName7);
            } else {
                if ("yes".equals(addBen.toLowerCase())) {
                    payslipWITHbenefits(taxableEarnings, sSS, philHealth,
                            pagIbig, witHoldingTax, nonTaxableBenefits,
                            riceSubsidy7, phoneAllowance7, clothingAllowance7, employe7, lastName7, firstName7);
                }
            }

            System.out.println("\n" + "\n");
            enterEmployeeNo();
        } catch (Exception invalidEntry) {
            System.out.println("!!! INVALID ENTRY ENTERED !!!" + "\n");
            enterEmployeeNo();
        }

    }

    public static void employee8() {
        int employe8 = 8;
        String lastName8 = "Romualdez";
        String firstName8 = "Alice";
        String birthday8 = "05/14/1992";
        String address8 = "12A/33 Upton Isle Apt. 420, Roxas City 1814 Surigao del Norte";
        String phoneNumber8 = "983-606-799";
        String sssNo8 = "55-4476527-2";
        String philhealthNo8 = "545652640232";
        String tinNo8 = "888-572-294-000";
        String pagibig8 = "211385556888";
        String status8 = "Regular";
        String position8 = "HR Rank and File";
        String immediateSupervisor8 = "San, Jose Brad";
        double basicSalary8 = 22500;
        double riceSubsidy8 = 1500;
        double phoneAllowance8 = 500;
        double clothingAllowance8 = 500;
        double grossSemiMonthlyRate8 = 11250;
        double hourlyRate8 = 133.93;

        System.out.println("Here are the details based on the Employee Number you entered: " + "\n"
                + "Employee #:            " + employe8 + "\n"
                + "Last Name:             " + lastName8 + "\n"
                + "First Name:            " + firstName8 + "\n"
                + "Birthday:              " + birthday8 + "\n"
                + "Address:               " + address8 + "\n"
                + "Phone Number:          " + phoneNumber8 + "\n"
                + "SSS Number:            " + sssNo8 + "\n"
                + "Philhealth Number:     " + philhealthNo8 + "\n"
                + "TIN Number:            " + tinNo8 + "\n"
                + "Pag-ibig Number:       " + pagibig8 + "\n"
                + "Status:                " + status8 + "\n"
                + "Position:              " + position8 + "\n"
                + "Immediate Supervisor:  " + immediateSupervisor8 + "\n"
                + "Basic Salary:          " + basicSalary8 + "\n"
                + "Rice Subsidy:          " + riceSubsidy8 + "\n"
                + "Phone Allowance:       " + phoneAllowance8 + "\n"
                + "Clothing Allowance:    " + clothingAllowance8 + "\n"
                + "Gross Semi-monthly Rate:" + grossSemiMonthlyRate8 + "\n"
                + "Hourly Rate:           " + hourlyRate8 + "\n");

//calculate salary
        try {
            double nonTaxableBenefits = riceSubsidy8 + phoneAllowance8 + clothingAllowance8;
            double taxableEarnings = calculateTaxableWage(hourlyRate8);
            double sSS = calculateSSS(basicSalary8);
            double philHealth = calculatePhilHealth(basicSalary8);
            double pagIbig = calculatePagibig(basicSalary8);
            double withEarnings = taxableEarnings - (sSS + philHealth + pagIbig);
            double witHoldingTax = calculateWitholdingTax(withEarnings);

            System.out.println("\n" + "Would you like to add the Non-Taxable Benefits on your calculation? Type yes or no:");
            Scanner refBen = new Scanner(System.in);
            String addBen = refBen.next();

            if ("no".equals(addBen.toLowerCase())) {
                payslipNObenefits(taxableEarnings, sSS, philHealth,
                        pagIbig, witHoldingTax, employe8, lastName8, firstName8);
            } else {
                if ("yes".equals(addBen.toLowerCase())) {
                    payslipWITHbenefits(taxableEarnings, sSS, philHealth,
                            pagIbig, witHoldingTax, nonTaxableBenefits,
                            riceSubsidy8, phoneAllowance8, clothingAllowance8, employe8, lastName8, firstName8);
                }
            }

            System.out.println("\n" + "\n");
            enterEmployeeNo();
        } catch (Exception invalidEntry) {
            System.out.println("!!! INVALID ENTRY ENTERED !!!" + "\n");
            enterEmployeeNo();
        }

    }

    public static void employee9() {
        int employe9 = 9;
        String lastName9 = "Atienza";
        String firstName9 = "Rosie";
        String birthday9 = "09/24/1948";
        String address9 = "90A Dibbert Terrace Apt. 190, San Lorenzo 6056 Davao del Norte";
        String phoneNumber9 = "266-036-427";
        String sssNo9 = "41-0644692-3";
        String philhealthNo9 = "708988234853";
        String tinNo9 = "604-997-793-000";
        String pagibig9 = "260107732354";
        String status9 = "Regular";
        String position9 = "HR Rank and File";
        String immediateSupervisor9 = "San, Jose Brad";
        double basicSalary9 = 22500;
        double riceSubsidy9 = 1500;
        double phoneAllowance9 = 500;
        double clothingAllowance9 = 500;
        double grossSemiMonthlyRate9 = 11250;
        double hourlyRate9 = 133.93;

        System.out.println("Here are the details based on the Employee Number you entered: " + "\n"
                + "Employee #:            " + employe9 + "\n"
                + "Last Name:             " + lastName9 + "\n"
                + "First Name:            " + firstName9 + "\n"
                + "Birthday:              " + birthday9 + "\n"
                + "Address:               " + address9 + "\n"
                + "Phone Number:          " + phoneNumber9 + "\n"
                + "SSS Number:            " + sssNo9 + "\n"
                + "Philhealth Number:     " + philhealthNo9 + "\n"
                + "TIN Number:            " + tinNo9 + "\n"
                + "Pag-ibig Number:       " + pagibig9 + "\n"
                + "Status:                " + status9 + "\n"
                + "Position:              " + position9 + "\n"
                + "Immediate Supervisor:  " + immediateSupervisor9 + "\n"
                + "Basic Salary:          " + basicSalary9 + "\n"
                + "Rice Subsidy:          " + riceSubsidy9 + "\n"
                + "Phone Allowance:       " + phoneAllowance9 + "\n"
                + "Clothing Allowance:    " + clothingAllowance9 + "\n"
                + "Gross Semi-monthly Rate:" + grossSemiMonthlyRate9 + "\n"
                + "Hourly Rate:           " + hourlyRate9 + "\n");

        //calculate salary
        try {
            double nonTaxableBenefits = riceSubsidy9 + phoneAllowance9 + clothingAllowance9;
            double taxableEarnings = calculateTaxableWage(hourlyRate9);
            double sSS = calculateSSS(basicSalary9);
            double philHealth = calculatePhilHealth(basicSalary9);
            double pagIbig = calculatePagibig(basicSalary9);
            double withEarnings = taxableEarnings - (sSS + philHealth + pagIbig);
            double witHoldingTax = calculateWitholdingTax(withEarnings);

            System.out.println("\n" + "Would you like to add the Non-Taxable Benefits on your calculation? Type yes or no:");
            Scanner refBen = new Scanner(System.in);
            String addBen = refBen.next();

            if ("no".equals(addBen.toLowerCase())) {
                payslipNObenefits(taxableEarnings, sSS, philHealth,
                        pagIbig, witHoldingTax, employe9, lastName9, firstName9);
            } else {
                if ("yes".equals(addBen.toLowerCase())) {
                    payslipWITHbenefits(taxableEarnings, sSS, philHealth,
                            pagIbig, witHoldingTax, nonTaxableBenefits,
                            riceSubsidy9, phoneAllowance9, clothingAllowance9, employe9, lastName9, firstName9);
                }
            }

            System.out.println("\n" + "\n");
            enterEmployeeNo();
        } catch (Exception invalidEntry) {
            System.out.println("!!! INVALID ENTRY ENTERED !!!" + "\n");
            enterEmployeeNo();
        }

    }

    public static void employee10() {
        int employe10 = 10;
        String lastName10 = "Alvaro";
        String firstName10 = "Roderick";
        String birthday10 = "03/30/1988";
        String address10 = "#284 T. Morato corner, Scout Rallos Street, Quezon City";
        String phoneNumber10 = "053-381-386";
        String sssNo10 = "64-7605054-4";
        String philhealthNo10 = "578114853194";
        String tinNo10 = "525-420-419-000";
        String pagibig10 = "799254095212";
        String status10 = "Regular";
        String position10 = "Accounting Head";
        String immediateSupervisor10 = "Aquino, Bianca Sofia";
        double basicSalary10 = 52670;
        double riceSubsidy10 = 1500;
        double phoneAllowance10 = 1000;
        double clothingAllowance10 = 1000;
        double grossSemiMonthlyRate10 = 26335;
        double hourlyRate10 = 313.51;

        System.out.println("Here are the details based on the Employee Number you entered: " + "\n"
                + "Employee #:            " + employe10 + "\n"
                + "Last Name:             " + lastName10 + "\n"
                + "First Name:            " + firstName10 + "\n"
                + "Birthday:              " + birthday10 + "\n"
                + "Address:               " + address10 + "\n"
                + "Phone Number:          " + phoneNumber10 + "\n"
                + "SSS Number:            " + sssNo10 + "\n"
                + "Philhealth Number:     " + philhealthNo10 + "\n"
                + "TIN Number:            " + tinNo10 + "\n"
                + "Pag-ibig Number:       " + pagibig10 + "\n"
                + "Status:                " + status10 + "\n"
                + "Position:              " + position10 + "\n"
                + "Immediate Supervisor:  " + immediateSupervisor10 + "\n"
                + "Basic Salary:          " + basicSalary10 + "\n"
                + "Rice Subsidy:          " + riceSubsidy10 + "\n"
                + "Phone Allowance:       " + phoneAllowance10 + "\n"
                + "Clothing Allowance:    " + clothingAllowance10 + "\n"
                + "Gross Semi-monthly Rate:" + grossSemiMonthlyRate10 + "\n"
                + "Hourly Rate:           " + hourlyRate10 + "\n");

        //calculate salary
        try {
            double nonTaxableBenefits = riceSubsidy10 + phoneAllowance10 + clothingAllowance10;
            double taxableEarnings = calculateTaxableWage(hourlyRate10);
            double sSS = calculateSSS(basicSalary10);
            double philHealth = calculatePhilHealth(basicSalary10);
            double pagIbig = calculatePagibig(basicSalary10);
            double withEarnings = taxableEarnings - (sSS + philHealth + pagIbig);
            double witHoldingTax = calculateWitholdingTax(withEarnings);

            System.out.println("\n" + "Would you like to add the Non-Taxable Benefits on your calculation? Type yes or no:");
            Scanner refBen = new Scanner(System.in);
            String addBen = refBen.next();

            if ("no".equals(addBen.toLowerCase())) {
                payslipNObenefits(taxableEarnings, sSS, philHealth,
                        pagIbig, witHoldingTax, employe10, lastName10, firstName10);
            } else {
                if ("yes".equals(addBen.toLowerCase())) {
                    payslipWITHbenefits(taxableEarnings, sSS, philHealth,
                            pagIbig, witHoldingTax, nonTaxableBenefits,
                            riceSubsidy10, phoneAllowance10, clothingAllowance10, employe10, lastName10, firstName10);
                }
            }

            System.out.println("\n" + "\n");
            enterEmployeeNo();
        } catch (Exception invalidEntry) {
            System.out.println("!!! INVALID ENTRY ENTERED !!!" + "\n");
            enterEmployeeNo();
        }

    }

    public static void employee11() {
        int employe11 = 11;
        String lastName11 = "Salcedo";
        String firstName11 = "Anthony";
        String birthday11 = "09/14/1993";
        String address11 = "93/54 Shanahan Alley Apt. 183, Santo Tomas 1572 Masbate";
        String phoneNumber11 = "070-766-300";
        String sssNo11 = "26-9647608-3";
        String philhealthNo11 = "126445315651";
        String tinNo11 = "210-805-911-000";
        String pagibig11 = "218002473454";
        String status11 = "Regular";
        String position11 = "Payroll Manager";
        String immediateSupervisor11 = "Alvaro, Roderick";
        double basicSalary11 = 50825;
        double riceSubsidy11 = 1500;
        double phoneAllowance11 = 1000;
        double clothingAllowance11 = 1000;
        double grossSemiMonthlyRate11 = 25413;
        double hourlyRate11 = 302.53;

        System.out.println("Here are the details based on the Employee Number you entered: " + "\n"
                + "Employee #:            " + employe11 + "\n"
                + "Last Name:             " + lastName11 + "\n"
                + "First Name:            " + firstName11 + "\n"
                + "Birthday:              " + birthday11 + "\n"
                + "Address:               " + address11 + "\n"
                + "Phone Number:          " + phoneNumber11 + "\n"
                + "SSS Number:            " + sssNo11 + "\n"
                + "Philhealth Number:     " + philhealthNo11 + "\n"
                + "TIN Number:            " + tinNo11 + "\n"
                + "Pag-ibig Number:       " + pagibig11 + "\n"
                + "Status:                " + status11 + "\n"
                + "Position:              " + position11 + "\n"
                + "Immediate Supervisor:  " + immediateSupervisor11 + "\n"
                + "Basic Salary:          " + basicSalary11 + "\n"
                + "Rice Subsidy:          " + riceSubsidy11 + "\n"
                + "Phone Allowance:       " + phoneAllowance11 + "\n"
                + "Clothing Allowance:    " + clothingAllowance11 + "\n"
                + "Gross Semi-monthly Rate:" + grossSemiMonthlyRate11 + "\n"
                + "Hourly Rate:           " + hourlyRate11 + "\n");

//calculate salary
        try {
            double nonTaxableBenefits = riceSubsidy11 + phoneAllowance11 + clothingAllowance11;
            double taxableEarnings = calculateTaxableWage(hourlyRate11);
            double sSS = calculateSSS(basicSalary11);
            double philHealth = calculatePhilHealth(basicSalary11);
            double pagIbig = calculatePagibig(basicSalary11);
            double withEarnings = taxableEarnings - (sSS + philHealth + pagIbig);
            double witHoldingTax = calculateWitholdingTax(withEarnings);

            System.out.println("\n" + "Would you like to add the Non-Taxable Benefits on your calculation? Type yes or no:");
            Scanner refBen = new Scanner(System.in);
            String addBen = refBen.next();

            if ("no".equals(addBen.toLowerCase())) {
                payslipNObenefits(taxableEarnings, sSS, philHealth,
                        pagIbig, witHoldingTax, employe11, lastName11, firstName11);
            } else {
                if ("yes".equals(addBen.toLowerCase())) {
                    payslipWITHbenefits(taxableEarnings, sSS, philHealth,
                            pagIbig, witHoldingTax, nonTaxableBenefits,
                            riceSubsidy11, phoneAllowance11, clothingAllowance11, employe11, lastName11, firstName11);
                }
            }

            System.out.println("\n" + "\n");
            enterEmployeeNo();
        } catch (Exception invalidEntry) {
            System.out.println("!!! INVALID ENTRY ENTERED !!!" + "\n");
            enterEmployeeNo();
        }

    }

    public static void employee12() {
        int employe12 = 12;
        String lastName12 = "Lopez";
        String firstName12 = "Josie";
        String birthday12 = "01/14/1987";
        String address12 = "49 Springs Apt. 266, Poblacion, Taguig 3200 Occidental Mindoro";
        String phoneNumber12 = "478-355-427";
        String sssNo12 = "44-8563448-3";
        String philhealthNo12 = "431709011012";
        String tinNo12 = "218-489-737-000";
        String pagibig12 = "113071293354";
        String status12 = "Regular";
        String position12 = "Payroll Team Leader";
        String immediateSupervisor12 = "Salcedo, Anthony";
        double basicSalary12 = 38475;
        double riceSubsidy12 = 1500;
        double phoneAllowance12 = 800;
        double clothingAllowance12 = 800;
        double grossSemiMonthlyRate12 = 19238;
        double hourlyRate12 = 229.02;

        System.out.println("Here are the details based on the Employee Number you entered: " + "\n"
                + "Employee #:            " + employe12 + "\n"
                + "Last Name:             " + lastName12 + "\n"
                + "First Name:            " + firstName12 + "\n"
                + "Birthday:              " + birthday12 + "\n"
                + "Address:               " + address12 + "\n"
                + "Phone Number:          " + phoneNumber12 + "\n"
                + "SSS Number:            " + sssNo12 + "\n"
                + "Philhealth Number:     " + philhealthNo12 + "\n"
                + "TIN Number:            " + tinNo12 + "\n"
                + "Pag-ibig Number:       " + pagibig12 + "\n"
                + "Status:                " + status12 + "\n"
                + "Position:              " + position12 + "\n"
                + "Immediate Supervisor:  " + immediateSupervisor12 + "\n"
                + "Basic Salary:          " + basicSalary12 + "\n"
                + "Rice Subsidy:          " + riceSubsidy12 + "\n"
                + "Phone Allowance:       " + phoneAllowance12 + "\n"
                + "Clothing Allowance:    " + clothingAllowance12 + "\n"
                + "Gross Semi-monthly Rate:" + grossSemiMonthlyRate12 + "\n"
                + "Hourly Rate:           " + hourlyRate12 + "\n");

        //calculate salary
        try {
            double nonTaxableBenefits = riceSubsidy12 + phoneAllowance12 + clothingAllowance12;
            double taxableEarnings = calculateTaxableWage(hourlyRate12);
            double sSS = calculateSSS(basicSalary12);
            double philHealth = calculatePhilHealth(basicSalary12);
            double pagIbig = calculatePagibig(basicSalary12);
            double withEarnings = taxableEarnings - (sSS + philHealth + pagIbig);
            double witHoldingTax = calculateWitholdingTax(withEarnings);

            System.out.println("\n" + "Would you like to add the Non-Taxable Benefits on your calculation? Type yes or no:");
            Scanner refBen = new Scanner(System.in);
            String addBen = refBen.next();

            if ("no".equals(addBen.toLowerCase())) {
                payslipNObenefits(taxableEarnings, sSS, philHealth,
                        pagIbig, witHoldingTax, employe12, lastName12, firstName12);
            } else {
                if ("yes".equals(addBen.toLowerCase())) {
                    payslipWITHbenefits(taxableEarnings, sSS, philHealth,
                            pagIbig, witHoldingTax, nonTaxableBenefits,
                            riceSubsidy12, phoneAllowance12, clothingAllowance12, employe12, lastName12, firstName12);
                }
            }

            System.out.println("\n" + "\n");
            enterEmployeeNo();
        } catch (Exception invalidEntry) {
            System.out.println("!!! INVALID ENTRY ENTERED !!!" + "\n");
            enterEmployeeNo();
        }

    }

    public static void employee13() {
        int employe13 = 13;
        String lastName13 = "Farala";
        String firstName13 = "Martha";
        String birthday13 = "01/11/1942";
        String address13 = "42/25 Sawayn Stream, Ubay 1208 Zamboanga del Norte";
        String phoneNumber13 = "329-034-366";
        String sssNo13 = "45-5656375-0";
        String philhealthNo13 = "233693897247";
        String tinNo13 = "210-835-851-000";
        String pagibig13 = "631130283546";
        String status13 = "Regular";
        String position13 = "Payroll Rank and File";
        String immediateSupervisor13 = "Salcedo, Anthony";
        double basicSalary13 = 24000;
        double riceSubsidy13 = 1500;
        double phoneAllowance13 = 500;
        double clothingAllowance13 = 500;
        double grossSemiMonthlyRate13 = 12000;
        double hourlyRate13 = 142.86;

        System.out.println("Here are the details based on the Employee Number you entered: " + "\n"
                + "Employee #:            " + employe13 + "\n"
                + "Last Name:             " + lastName13 + "\n"
                + "First Name:            " + firstName13 + "\n"
                + "Birthday:              " + birthday13 + "\n"
                + "Address:               " + address13 + "\n"
                + "Phone Number:          " + phoneNumber13 + "\n"
                + "SSS Number:            " + sssNo13 + "\n"
                + "Philhealth Number:     " + philhealthNo13 + "\n"
                + "TIN Number:            " + tinNo13 + "\n"
                + "Pag-ibig Number:       " + pagibig13 + "\n"
                + "Status:                " + status13 + "\n"
                + "Position:              " + position13 + "\n"
                + "Immediate Supervisor:  " + immediateSupervisor13 + "\n"
                + "Basic Salary:          " + basicSalary13 + "\n"
                + "Rice Subsidy:          " + riceSubsidy13 + "\n"
                + "Phone Allowance:       " + phoneAllowance13 + "\n"
                + "Clothing Allowance:    " + clothingAllowance13 + "\n"
                + "Gross Semi-monthly Rate:" + grossSemiMonthlyRate13 + "\n"
                + "Hourly Rate:           " + hourlyRate13 + "\n");

//calculate salary
        try {
            double nonTaxableBenefits = riceSubsidy13 + phoneAllowance13 + clothingAllowance13;
            double taxableEarnings = calculateTaxableWage(hourlyRate13);
            double sSS = calculateSSS(basicSalary13);
            double philHealth = calculatePhilHealth(basicSalary13);
            double pagIbig = calculatePagibig(basicSalary13);
            double withEarnings = taxableEarnings - (sSS + philHealth + pagIbig);
            double witHoldingTax = calculateWitholdingTax(withEarnings);

            System.out.println("\n" + "Would you like to add the Non-Taxable Benefits on your calculation? Type yes or no:");
            Scanner refBen = new Scanner(System.in);
            String addBen = refBen.next();

            if ("no".equals(addBen.toLowerCase())) {
                payslipNObenefits(taxableEarnings, sSS, philHealth,
                        pagIbig, witHoldingTax, employe13, lastName13, firstName13);
            } else {
                if ("yes".equals(addBen.toLowerCase())) {
                    payslipWITHbenefits(taxableEarnings, sSS, philHealth,
                            pagIbig, witHoldingTax, nonTaxableBenefits,
                            riceSubsidy13, phoneAllowance13, clothingAllowance13, employe13, lastName13, firstName13);
                }
            }

            System.out.println("\n" + "\n");
            enterEmployeeNo();
        } catch (Exception invalidEntry) {
            System.out.println("!!! INVALID ENTRY ENTERED !!!" + "\n");
            enterEmployeeNo();
        }

    }

    public static void employee14() {
        int employe14 = 14;
        String lastName14 = "Martinez";
        String firstName14 = "Leila";
        String birthday14 = "07/11/1970";
        String address14 = "37/46 Kulas Roads, Maragondon 0962 Quirino";
        String phoneNumber14 = "877-110-749";
        String sssNo14 = "27-2090996-4";
        String philhealthNo14 = "515741057496";
        String tinNo14 = "275-792-513-000";
        String pagibig14 = "101205445886";
        String status14 = "Regular";
        String position14 = "Payroll Rank and File";
        String immediateSupervisor14 = "Salcedo, Anthony";
        double basicSalary14 = 24000;
        double riceSubsidy14 = 1500;
        double phoneAllowance14 = 500;
        double clothingAllowance14 = 500;
        double grossSemiMonthlyRate14 = 12000;
        double hourlyRate14 = 142.86;

        System.out.println("Here are the details based on the Employee Number you entered: " + "\n"
                + "Employee #:            " + employe14 + "\n"
                + "Last Name:             " + lastName14 + "\n"
                + "First Name:            " + firstName14 + "\n"
                + "Birthday:              " + birthday14 + "\n"
                + "Address:               " + address14 + "\n"
                + "Phone Number:          " + phoneNumber14 + "\n"
                + "SSS Number:            " + sssNo14 + "\n"
                + "Philhealth Number:     " + philhealthNo14 + "\n"
                + "TIN Number:            " + tinNo14 + "\n"
                + "Pag-ibig Number:       " + pagibig14 + "\n"
                + "Status:                " + status14 + "\n"
                + "Position:              " + position14 + "\n"
                + "Immediate Supervisor:  " + immediateSupervisor14 + "\n"
                + "Basic Salary:          " + basicSalary14 + "\n"
                + "Rice Subsidy:          " + riceSubsidy14 + "\n"
                + "Phone Allowance:       " + phoneAllowance14 + "\n"
                + "Clothing Allowance:    " + clothingAllowance14 + "\n"
                + "Gross Semi-monthly Rate:" + grossSemiMonthlyRate14 + "\n"
                + "Hourly Rate:           " + hourlyRate14 + "\n");

//calculate salary
        try {
            double nonTaxableBenefits = riceSubsidy14 + phoneAllowance14 + clothingAllowance14;
            double taxableEarnings = calculateTaxableWage(hourlyRate14);
            double sSS = calculateSSS(basicSalary14);
            double philHealth = calculatePhilHealth(basicSalary14);
            double pagIbig = calculatePagibig(basicSalary14);
            double withEarnings = taxableEarnings - (sSS + philHealth + pagIbig);
            double witHoldingTax = calculateWitholdingTax(withEarnings);

            System.out.println("\n" + "Would you like to add the Non-Taxable Benefits on your calculation? Type yes or no:");
            Scanner refBen = new Scanner(System.in);
            String addBen = refBen.next();

            if ("no".equals(addBen.toLowerCase())) {
                payslipNObenefits(taxableEarnings, sSS, philHealth,
                        pagIbig, witHoldingTax, employe14, lastName14, firstName14);
            } else {
                if ("yes".equals(addBen.toLowerCase())) {
                    payslipWITHbenefits(taxableEarnings, sSS, philHealth,
                            pagIbig, witHoldingTax, nonTaxableBenefits,
                            riceSubsidy14, phoneAllowance14, clothingAllowance14, employe14, lastName14, firstName14);
                }
            }

            System.out.println("\n" + "\n");
            enterEmployeeNo();
        } catch (Exception invalidEntry) {
            System.out.println("!!! INVALID ENTRY ENTERED !!!" + "\n");
            enterEmployeeNo();
        }

    }

    public static void employee15() {
        int employe15 = 15;
        String lastName15 = "Romualdez";
        String firstName15 = "Fredrick";
        String birthday15 = "03/10/1985";
        String address15 = "22A/52 Lubowitz Meadows, Pililla 4895 Zambales";
        String phoneNumber15 = "023-079-009";
        String sssNo15 = "26-8768374-1";
        String philhealthNo15 = "308366860059";
        String tinNo15 = "598-065-761-000";
        String pagibig15 = "223057707853";
        String status15 = "Regular";
        String position15 = "Account Manager";
        String immediateSupervisor15 = "Lim, Antonio";
        double basicSalary15 = 53500;
        double riceSubsidy15 = 1500;
        double phoneAllowance15 = 1000;
        double clothingAllowance15 = 1000;
        double grossSemiMonthlyRate15 = 26750;
        double hourlyRate15 = 318.45;

        System.out.println("Here are the details based on the Employee Number you entered: " + "\n"
                + "Employee #:            " + employe15 + "\n"
                + "Last Name:             " + lastName15 + "\n"
                + "First Name:            " + firstName15 + "\n"
                + "Birthday:              " + birthday15 + "\n"
                + "Address:               " + address15 + "\n"
                + "Phone Number:          " + phoneNumber15 + "\n"
                + "SSS Number:            " + sssNo15 + "\n"
                + "Philhealth Number:     " + philhealthNo15 + "\n"
                + "TIN Number:            " + tinNo15 + "\n"
                + "Pag-ibig Number:       " + pagibig15 + "\n"
                + "Status:                " + status15 + "\n"
                + "Position:              " + position15 + "\n"
                + "Immediate Supervisor:  " + immediateSupervisor15 + "\n"
                + "Basic Salary:          " + basicSalary15 + "\n"
                + "Rice Subsidy:          " + riceSubsidy15 + "\n"
                + "Phone Allowance:       " + phoneAllowance15 + "\n"
                + "Clothing Allowance:    " + clothingAllowance15 + "\n"
                + "Gross Semi-monthly Rate:" + grossSemiMonthlyRate15 + "\n"
                + "Hourly Rate:           " + hourlyRate15 + "\n");

//calculate salary
        try {
            double nonTaxableBenefits = riceSubsidy15 + phoneAllowance15 + clothingAllowance15;
            double taxableEarnings = calculateTaxableWage(hourlyRate15);
            double sSS = calculateSSS(basicSalary15);
            double philHealth = calculatePhilHealth(basicSalary15);
            double pagIbig = calculatePagibig(basicSalary15);
            double withEarnings = taxableEarnings - (sSS + philHealth + pagIbig);
            double witHoldingTax = calculateWitholdingTax(withEarnings);

            System.out.println("\n" + "Would you like to add the Non-Taxable Benefits on your calculation? Type yes or no:");
            Scanner refBen = new Scanner(System.in);
            String addBen = refBen.next();

            if ("no".equals(addBen.toLowerCase())) {
                payslipNObenefits(taxableEarnings, sSS, philHealth,
                        pagIbig, witHoldingTax, employe15, lastName15, firstName15);
            } else {
                if ("yes".equals(addBen.toLowerCase())) {
                    payslipWITHbenefits(taxableEarnings, sSS, philHealth,
                            pagIbig, witHoldingTax, nonTaxableBenefits,
                            riceSubsidy15, phoneAllowance15, clothingAllowance15, employe15, lastName15, firstName15);
                }
            }

            System.out.println("\n" + "\n");
            enterEmployeeNo();
        } catch (Exception invalidEntry) {
            System.out.println("!!! INVALID ENTRY ENTERED !!!" + "\n");
            enterEmployeeNo();
        }

    }

    public static void employee16() {
        int employe16 = 16;
        String lastName16 = "Mata";
        String firstName16 = "Christian";
        String birthday16 = "10/21/1987";
        String address16 = "90 O'Keefe Spur Apt. 379, Catigbian 2772 Sulu";
        String phoneNumber16 = "783-776-744";
        String sssNo16 = "49-2959312-6";
        String philhealthNo16 = "824187961962";
        String tinNo16 = "103-100-522-000";
        String pagibig16 = "631052853464";
        String status16 = "Regular";
        String position16 = "Account Team Leader";
        String immediateSupervisor16 = "Romualdez, Fredrick";
        double basicSalary16 = 42975;
        double riceSubsidy16 = 1500;
        double phoneAllowance16 = 800;
        double clothingAllowance16 = 800;
        double grossSemiMonthlyRate16 = 21488;
        double hourlyRate16 = 255.8;

        System.out.println("Here are the details based on the Employee Number you entered: " + "\n"
                + "Employee #:            " + employe16 + "\n"
                + "Last Name:             " + lastName16 + "\n"
                + "First Name:            " + firstName16 + "\n"
                + "Birthday:              " + birthday16 + "\n"
                + "Address:               " + address16 + "\n"
                + "Phone Number:          " + phoneNumber16 + "\n"
                + "SSS Number:            " + sssNo16 + "\n"
                + "Philhealth Number:     " + philhealthNo16 + "\n"
                + "TIN Number:            " + tinNo16 + "\n"
                + "Pag-ibig Number:       " + pagibig16 + "\n"
                + "Status:                " + status16 + "\n"
                + "Position:              " + position16 + "\n"
                + "Immediate Supervisor:  " + immediateSupervisor16 + "\n"
                + "Basic Salary:          " + basicSalary16 + "\n"
                + "Rice Subsidy:          " + riceSubsidy16 + "\n"
                + "Phone Allowance:       " + phoneAllowance16 + "\n"
                + "Clothing Allowance:    " + clothingAllowance16 + "\n"
                + "Gross Semi-monthly Rate:" + grossSemiMonthlyRate16 + "\n"
                + "Hourly Rate:           " + hourlyRate16 + "\n");

        //calculate salary
        try {
            double nonTaxableBenefits = riceSubsidy16 + phoneAllowance16 + clothingAllowance16;
            double taxableEarnings = calculateTaxableWage(hourlyRate16);
            double sSS = calculateSSS(basicSalary16);
            double philHealth = calculatePhilHealth(basicSalary16);
            double pagIbig = calculatePagibig(basicSalary16);
            double withEarnings = taxableEarnings - (sSS + philHealth + pagIbig);
            double witHoldingTax = calculateWitholdingTax(withEarnings);

            System.out.println("\n" + "Would you like to add the Non-Taxable Benefits on your calculation? Type yes or no:");
            Scanner refBen = new Scanner(System.in);
            String addBen = refBen.next();

            if ("no".equals(addBen.toLowerCase())) {
                payslipNObenefits(taxableEarnings, sSS, philHealth,
                        pagIbig, witHoldingTax, employe16, lastName16, firstName16);
            } else {
                if ("yes".equals(addBen.toLowerCase())) {
                    payslipWITHbenefits(taxableEarnings, sSS, philHealth,
                            pagIbig, witHoldingTax, nonTaxableBenefits,
                            riceSubsidy16, phoneAllowance16, clothingAllowance16, employe16, lastName16, firstName16);
                }
            }

            System.out.println("\n" + "\n");
            enterEmployeeNo();
        } catch (Exception invalidEntry) {
            System.out.println("!!! INVALID ENTRY ENTERED !!!" + "\n");
            enterEmployeeNo();
        }

    }

    public static void employee17() {
        int employe17 = 17;
        String lastName17 = "De Leon";
        String firstName17 = "Selena";
        String birthday17 = "02/20/1975";
        String address17 = "89A Armstrong Trace, Compostela 7874 Maguindanao";
        String phoneNumber17 = "975-432-139";
        String sssNo17 = "27-2090208-8";
        String philhealthNo17 = "587272469938";
        String tinNo17 = "482-259-498-000";
        String pagibig17 = "719007608464";
        String status17 = "Regular";
        String position17 = "Account Team Leader";
        String immediateSupervisor17 = "Romualdez, Fredrick";
        double basicSalary17 = 41850;
        double riceSubsidy17 = 1500;
        double phoneAllowance17 = 800;
        double clothingAllowance17 = 800;
        double grossSemiMonthlyRate17 = 20925;
        double hourlyRate17 = 249.11;

        System.out.println("Here are the details based on the Employee Number you entered: " + "\n"
                + "Employee #:            " + employe17 + "\n"
                + "Last Name:             " + lastName17 + "\n"
                + "First Name:            " + firstName17 + "\n"
                + "Birthday:              " + birthday17 + "\n"
                + "Address:               " + address17 + "\n"
                + "Phone Number:          " + phoneNumber17 + "\n"
                + "SSS Number:            " + sssNo17 + "\n"
                + "Philhealth Number:     " + philhealthNo17 + "\n"
                + "TIN Number:            " + tinNo17 + "\n"
                + "Pag-ibig Number:       " + pagibig17 + "\n"
                + "Status:                " + status17 + "\n"
                + "Position:              " + position17 + "\n"
                + "Immediate Supervisor:  " + immediateSupervisor17 + "\n"
                + "Basic Salary:          " + basicSalary17 + "\n"
                + "Rice Subsidy:          " + riceSubsidy17 + "\n"
                + "Phone Allowance:       " + phoneAllowance17 + "\n"
                + "Clothing Allowance:    " + clothingAllowance17 + "\n"
                + "Gross Semi-monthly Rate:" + grossSemiMonthlyRate17 + "\n"
                + "Hourly Rate:           " + hourlyRate17 + "\n");

//calculate salary
        try {
            double nonTaxableBenefits = riceSubsidy17 + phoneAllowance17 + clothingAllowance17;
            double taxableEarnings = calculateTaxableWage(hourlyRate17);
            double sSS = calculateSSS(basicSalary17);
            double philHealth = calculatePhilHealth(basicSalary17);
            double pagIbig = calculatePagibig(basicSalary17);
            double withEarnings = taxableEarnings - (sSS + philHealth + pagIbig);
            double witHoldingTax = calculateWitholdingTax(withEarnings);

            System.out.println("\n" + "Would you like to add the Non-Taxable Benefits on your calculation? Type yes or no:");
            Scanner refBen = new Scanner(System.in);
            String addBen = refBen.next();

            if ("no".equals(addBen.toLowerCase())) {
                payslipNObenefits(taxableEarnings, sSS, philHealth,
                        pagIbig, witHoldingTax, employe17, lastName17, firstName17);
            } else {
                if ("yes".equals(addBen.toLowerCase())) {
                    payslipWITHbenefits(taxableEarnings, sSS, philHealth,
                            pagIbig, witHoldingTax, nonTaxableBenefits,
                            riceSubsidy17, phoneAllowance17, clothingAllowance17, employe17, lastName17, firstName17);
                }
            }

            System.out.println("\n" + "\n");
            enterEmployeeNo();
        } catch (Exception invalidEntry) {
            System.out.println("!!! INVALID ENTRY ENTERED !!!" + "\n");
            enterEmployeeNo();
        }

    }

    public static void employee18() {
        int employe18 = 18;
        String lastName18 = "San Jose";
        String firstName18 = "Allison";
        String birthday18 = "06/24/1986";
        String address18 = "08 Grant Drive Suite 406, Poblacion, Iloilo City 9186 La Union";
        String phoneNumber18 = "179-075-129";
        String sssNo18 = "45-3251383-0";
        String philhealthNo18 = "745148459521";
        String tinNo18 = "121-203-336-000";
        String pagibig18 = "114901859343";
        String status18 = "Regular";
        String position18 = "Account Rank and File";
        String immediateSupervisor18 = "Mata, Christian";
        double basicSalary18 = 22500;
        double riceSubsidy18 = 1500;
        double phoneAllowance18 = 500;
        double clothingAllowance18 = 500;
        double grossSemiMonthlyRate18 = 11250;
        double hourlyRate18 = 133.93;

        System.out.println("Here are the details based on the Employee Number you entered: " + "\n"
                + "Employee #:            " + employe18 + "\n"
                + "Last Name:             " + lastName18 + "\n"
                + "First Name:            " + firstName18 + "\n"
                + "Birthday:              " + birthday18 + "\n"
                + "Address:               " + address18 + "\n"
                + "Phone Number:          " + phoneNumber18 + "\n"
                + "SSS Number:            " + sssNo18 + "\n"
                + "Philhealth Number:     " + philhealthNo18 + "\n"
                + "TIN Number:            " + tinNo18 + "\n"
                + "Pag-ibig Number:       " + pagibig18 + "\n"
                + "Status:                " + status18 + "\n"
                + "Position:              " + position18 + "\n"
                + "Immediate Supervisor:  " + immediateSupervisor18 + "\n"
                + "Basic Salary:          " + basicSalary18 + "\n"
                + "Rice Subsidy:          " + riceSubsidy18 + "\n"
                + "Phone Allowance:       " + phoneAllowance18 + "\n"
                + "Clothing Allowance:    " + clothingAllowance18 + "\n"
                + "Gross Semi-monthly Rate:" + grossSemiMonthlyRate18 + "\n"
                + "Hourly Rate:           " + hourlyRate18 + "\n");

        //calculate salary
        try {
            double nonTaxableBenefits = riceSubsidy18 + phoneAllowance18 + clothingAllowance18;
            double taxableEarnings = calculateTaxableWage(hourlyRate18);
            double sSS = calculateSSS(basicSalary18);
            double philHealth = calculatePhilHealth(basicSalary18);
            double pagIbig = calculatePagibig(basicSalary18);
            double withEarnings = taxableEarnings - (sSS + philHealth + pagIbig);
            double witHoldingTax = calculateWitholdingTax(withEarnings);

            System.out.println("\n" + "Would you like to add the Non-Taxable Benefits on your calculation? Type yes or no:");
            Scanner refBen = new Scanner(System.in);
            String addBen = refBen.next();

            if ("no".equals(addBen.toLowerCase())) {
                payslipNObenefits(taxableEarnings, sSS, philHealth,
                        pagIbig, witHoldingTax, employe18, lastName18, firstName18);
            } else {
                if ("yes".equals(addBen.toLowerCase())) {
                    payslipWITHbenefits(taxableEarnings, sSS, philHealth,
                            pagIbig, witHoldingTax, nonTaxableBenefits,
                            riceSubsidy18, phoneAllowance18, clothingAllowance18, employe18, lastName18, firstName18);
                }
            }

            System.out.println("\n" + "\n");
            enterEmployeeNo();
        } catch (Exception invalidEntry) {
            System.out.println("!!! INVALID ENTRY ENTERED !!!" + "\n");
            enterEmployeeNo();
        }

    }

    public static void employee19() {
        int employe19 = 19;
        String lastName19 = "Rosario";
        String firstName19 = "Cydney";
        String birthday19 = "10/06/1996";
        String address19 = "93A/21 Berge Points, Tapaz 2180 Quezon";
        String phoneNumber19 = "868-819-912";
        String sssNo19 = "49-1629900-2";
        String philhealthNo19 = "579253435499";
        String tinNo19 = "122-244-511-000";
        String pagibig19 = "265104358643";
        String status19 = "Regular";
        String position19 = "Account Rank and File";
        String immediateSupervisor19 = "Mata, Christian";
        double basicSalary19 = 22500;
        double riceSubsidy19 = 1500;
        double phoneAllowance19 = 500;
        double clothingAllowance19 = 500;
        double grossSemiMonthlyRate19 = 11250;
        double hourlyRate19 = 133.93;

        System.out.println("Here are the details based on the Employee Number you entered: " + "\n"
                + "Employee #:            " + employe19 + "\n"
                + "Last Name:             " + lastName19 + "\n"
                + "First Name:            " + firstName19 + "\n"
                + "Birthday:              " + birthday19 + "\n"
                + "Address:               " + address19 + "\n"
                + "Phone Number:          " + phoneNumber19 + "\n"
                + "SSS Number:            " + sssNo19 + "\n"
                + "Philhealth Number:     " + philhealthNo19 + "\n"
                + "TIN Number:            " + tinNo19 + "\n"
                + "Pag-ibig Number:       " + pagibig19 + "\n"
                + "Status:                " + status19 + "\n"
                + "Position:              " + position19 + "\n"
                + "Immediate Supervisor:  " + immediateSupervisor19 + "\n"
                + "Basic Salary:          " + basicSalary19 + "\n"
                + "Rice Subsidy:          " + riceSubsidy19 + "\n"
                + "Phone Allowance:       " + phoneAllowance19 + "\n"
                + "Clothing Allowance:    " + clothingAllowance19 + "\n"
                + "Gross Semi-monthly Rate:" + grossSemiMonthlyRate19 + "\n"
                + "Hourly Rate:           " + hourlyRate19 + "\n");

//calculate salary
        try {
            double nonTaxableBenefits = riceSubsidy19 + phoneAllowance19 + clothingAllowance19;
            double taxableEarnings = calculateTaxableWage(hourlyRate19);
            double sSS = calculateSSS(basicSalary19);
            double philHealth = calculatePhilHealth(basicSalary19);
            double pagIbig = calculatePagibig(basicSalary19);
            double withEarnings = taxableEarnings - (sSS + philHealth + pagIbig);
            double witHoldingTax = calculateWitholdingTax(withEarnings);

            System.out.println("\n" + "Would you like to add the Non-Taxable Benefits on your calculation? Type yes or no:");
            Scanner refBen = new Scanner(System.in);
            String addBen = refBen.next();

            if ("no".equals(addBen.toLowerCase())) {
                payslipNObenefits(taxableEarnings, sSS, philHealth,
                        pagIbig, witHoldingTax, employe19, lastName19, firstName19);
            } else {
                if ("yes".equals(addBen.toLowerCase())) {
                    payslipWITHbenefits(taxableEarnings, sSS, philHealth,
                            pagIbig, witHoldingTax, nonTaxableBenefits,
                            riceSubsidy19, phoneAllowance19, clothingAllowance19, employe19, lastName19, firstName19);
                }
            }

            System.out.println("\n" + "\n");
            enterEmployeeNo();
        } catch (Exception invalidEntry) {
            System.out.println("!!! INVALID ENTRY ENTERED !!!" + "\n");
            enterEmployeeNo();
        }

    }

    public static void employee20() {
        int employe20 = 20;
        String lastName20 = "Bautista";
        String firstName20 = "Mark";
        String birthday20 = "02/12/1991";
        String address20 = "65 Murphy Center Suite 094, Poblacion, Palayan 5636 Quirino";
        String phoneNumber20 = "683-725-34833281";
        String sssNo20 = "49-1647342-5";
        String philhealthNo20 = "399665157135";
        String tinNo20 = "273-970-941-000";
        String pagibig20 = "260054585575";
        String status20 = "Regular";
        String position20 = "Account Rank and File";
        String immediateSupervisor20 = "Mata, Christian";
        double basicSalary20 = 23250;
        double riceSubsidy20 = 1500;
        double phoneAllowance20 = 500;
        double clothingAllowance20 = 500;
        double grossSemiMonthlyRate20 = 11625;
        double hourlyRate20 = 138.39;

        System.out.println("Here are the details based on the Employee Number you entered: " + "\n"
                + "Employee #:            " + employe20 + "\n"
                + "Last Name:             " + lastName20 + "\n"
                + "First Name:            " + firstName20 + "\n"
                + "Birthday:              " + birthday20 + "\n"
                + "Address:               " + address20 + "\n"
                + "Phone Number:          " + phoneNumber20 + "\n"
                + "SSS Number:            " + sssNo20 + "\n"
                + "Philhealth Number:     " + philhealthNo20 + "\n"
                + "TIN Number:            " + tinNo20 + "\n"
                + "Pag-ibig Number:       " + pagibig20 + "\n"
                + "Status:                " + status20 + "\n"
                + "Position:              " + position20 + "\n"
                + "Immediate Supervisor:  " + immediateSupervisor20 + "\n"
                + "Basic Salary:          " + basicSalary20 + "\n"
                + "Rice Subsidy:          " + riceSubsidy20 + "\n"
                + "Phone Allowance:       " + phoneAllowance20 + "\n"
                + "Clothing Allowance:    " + clothingAllowance20 + "\n"
                + "Gross Semi-monthly Rate:" + grossSemiMonthlyRate20 + "\n"
                + "Hourly Rate:           " + hourlyRate20 + "\n");

//calculate salary
        try {
            double nonTaxableBenefits = riceSubsidy20 + phoneAllowance20 + clothingAllowance20;
            double taxableEarnings = calculateTaxableWage(hourlyRate20);
            double sSS = calculateSSS(basicSalary20);
            double philHealth = calculatePhilHealth(basicSalary20);
            double pagIbig = calculatePagibig(basicSalary20);
            double withEarnings = taxableEarnings - (sSS + philHealth + pagIbig);
            double witHoldingTax = calculateWitholdingTax(withEarnings);

            System.out.println("\n" + "Would you like to add the Non-Taxable Benefits on your calculation? Type yes or no:");
            Scanner refBen = new Scanner(System.in);
            String addBen = refBen.next();

            if ("no".equals(addBen.toLowerCase())) {
                payslipNObenefits(taxableEarnings, sSS, philHealth,
                        pagIbig, witHoldingTax, employe20, lastName20, firstName20);
            } else {
                if ("yes".equals(addBen.toLowerCase())) {
                    payslipWITHbenefits(taxableEarnings, sSS, philHealth,
                            pagIbig, witHoldingTax, nonTaxableBenefits,
                            riceSubsidy20, phoneAllowance20, clothingAllowance20, employe20, lastName20, firstName20);
                }
            }

            System.out.println("\n" + "\n");
            enterEmployeeNo();
        } catch (Exception invalidEntry) {
            System.out.println("!!! INVALID ENTRY ENTERED !!!" + "\n");
            enterEmployeeNo();
        }

    }

    public static void employee21() {
        int employe21 = 21;
        String lastName21 = "Lazaro";
        String firstName21 = "Darlene";
        String birthday21 = "11/25/1985";
        String address21 = "47A/94 Larkin Plaza Apt. 179, Poblacion, Caloocan 2751 Quirino";
        String phoneNumber21 = "740-721-558";
        String sssNo21 = "45-5617168-2";
        String philhealthNo21 = "606386917510";
        String tinNo21 = "354-650-951-000";
        String pagibig21 = "104907708845";
        String status21 = "Probationary";
        String position21 = "Account Rank and File";
        String immediateSupervisor21 = "Mata, Christian";
        double basicSalary21 = 23250;
        double riceSubsidy21 = 1500;
        double phoneAllowance21 = 500;
        double clothingAllowance21 = 500;
        double grossSemiMonthlyRate21 = 11625;
        double hourlyRate21 = 138.39;

        System.out.println("Here are the details based on the Employee Number you entered: " + "\n"
                + "Employee #:            " + employe21 + "\n"
                + "Last Name:             " + lastName21 + "\n"
                + "First Name:            " + firstName21 + "\n"
                + "Birthday:              " + birthday21 + "\n"
                + "Address:               " + address21 + "\n"
                + "Phone Number:          " + phoneNumber21 + "\n"
                + "SSS Number:            " + sssNo21 + "\n"
                + "Philhealth Number:     " + philhealthNo21 + "\n"
                + "TIN Number:            " + tinNo21 + "\n"
                + "Pag-ibig Number:       " + pagibig21 + "\n"
                + "Status:                " + status21 + "\n"
                + "Position:              " + position21 + "\n"
                + "Immediate Supervisor:  " + immediateSupervisor21 + "\n"
                + "Basic Salary:          " + basicSalary21 + "\n"
                + "Rice Subsidy:          " + riceSubsidy21 + "\n"
                + "Phone Allowance:       " + phoneAllowance21 + "\n"
                + "Clothing Allowance:    " + clothingAllowance21 + "\n"
                + "Gross Semi-monthly Rate:" + grossSemiMonthlyRate21 + "\n"
                + "Hourly Rate:           " + hourlyRate21 + "\n");

//calculate salary
        try {
            double nonTaxableBenefits = riceSubsidy21 + phoneAllowance21 + clothingAllowance21;
            double taxableEarnings = calculateTaxableWage(hourlyRate21);
            double sSS = calculateSSS(basicSalary21);
            double philHealth = calculatePhilHealth(basicSalary21);
            double pagIbig = calculatePagibig(basicSalary21);
            double withEarnings = taxableEarnings - (sSS + philHealth + pagIbig);
            double witHoldingTax = calculateWitholdingTax(withEarnings);

            System.out.println("\n" + "Would you like to add the Non-Taxable Benefits on your calculation? Type yes or no:");
            Scanner refBen = new Scanner(System.in);
            String addBen = refBen.next();

            if ("no".equals(addBen.toLowerCase())) {
                payslipNObenefits(taxableEarnings, sSS, philHealth,
                        pagIbig, witHoldingTax, employe21, lastName21, firstName21);
            } else {
                if ("yes".equals(addBen.toLowerCase())) {
                    payslipWITHbenefits(taxableEarnings, sSS, philHealth,
                            pagIbig, witHoldingTax, nonTaxableBenefits,
                            riceSubsidy21, phoneAllowance21, clothingAllowance21, employe21, lastName21, firstName21);
                }
            }

            System.out.println("\n" + "\n");
            enterEmployeeNo();
        } catch (Exception invalidEntry) {
            System.out.println("!!! INVALID ENTRY ENTERED !!!" + "\n");
            enterEmployeeNo();
        }

    }

    public static void employee22() {
        int employe22 = 22;
        String lastName22 = "Delos Santos";
        String firstName22 = "Kolby";
        String birthday22 = "02/26/1980";
        String address22 = "06A Gulgowski Extensions, Bongabon 6085 Zamboanga del Sur";
        String phoneNumber22 = "739-443-033";
        String sssNo22 = "52-0109570-6";
        String philhealthNo22 = "357451271274";
        String tinNo22 = "187-500-345-000";
        String pagibig22 = "113017988667";
        String status22 = "Probationary";
        String position22 = "Account Rank and File";
        String immediateSupervisor22 = "Mata, Christian";
        double basicSalary22 = 24000;
        double riceSubsidy22 = 1500;
        double phoneAllowance22 = 500;
        double clothingAllowance22 = 500;
        double grossSemiMonthlyRate22 = 12000;
        double hourlyRate22 = 142.86;

        System.out.println("Here are the details based on the Employee Number you entered: " + "\n"
                + "Employee #:            " + employe22 + "\n"
                + "Last Name:             " + lastName22 + "\n"
                + "First Name:            " + firstName22 + "\n"
                + "Birthday:              " + birthday22 + "\n"
                + "Address:               " + address22 + "\n"
                + "Phone Number:          " + phoneNumber22 + "\n"
                + "SSS Number:            " + sssNo22 + "\n"
                + "Philhealth Number:     " + philhealthNo22 + "\n"
                + "TIN Number:            " + tinNo22 + "\n"
                + "Pag-ibig Number:       " + pagibig22 + "\n"
                + "Status:                " + status22 + "\n"
                + "Position:              " + position22 + "\n"
                + "Immediate Supervisor:  " + immediateSupervisor22 + "\n"
                + "Basic Salary:          " + basicSalary22 + "\n"
                + "Rice Subsidy:          " + riceSubsidy22 + "\n"
                + "Phone Allowance:       " + phoneAllowance22 + "\n"
                + "Clothing Allowance:    " + clothingAllowance22 + "\n"
                + "Gross Semi-monthly Rate:" + grossSemiMonthlyRate22 + "\n"
                + "Hourly Rate:           " + hourlyRate22 + "\n");

//calculate salary
        try {
            double nonTaxableBenefits = riceSubsidy22 + phoneAllowance22 + clothingAllowance22;
            double taxableEarnings = calculateTaxableWage(hourlyRate22);
            double sSS = calculateSSS(basicSalary22);
            double philHealth = calculatePhilHealth(basicSalary22);
            double pagIbig = calculatePagibig(basicSalary22);
            double withEarnings = taxableEarnings - (sSS + philHealth + pagIbig);
            double witHoldingTax = calculateWitholdingTax(withEarnings);

            System.out.println("\n" + "Would you like to add the Non-Taxable Benefits on your calculation? Type yes or no:");
            Scanner refBen = new Scanner(System.in);
            String addBen = refBen.next();

            if ("no".equals(addBen.toLowerCase())) {
                payslipNObenefits(taxableEarnings, sSS, philHealth,
                        pagIbig, witHoldingTax, employe22, lastName22, firstName22);
            } else {
                if ("yes".equals(addBen.toLowerCase())) {
                    payslipWITHbenefits(taxableEarnings, sSS, philHealth,
                            pagIbig, witHoldingTax, nonTaxableBenefits,
                            riceSubsidy22, phoneAllowance22, clothingAllowance22, employe22, lastName22, firstName22);
                }
            }

            System.out.println("\n" + "\n");
            enterEmployeeNo();
        } catch (Exception invalidEntry) {
            System.out.println("!!! INVALID ENTRY ENTERED !!!" + "\n");
            enterEmployeeNo();
        }

    }

    public static void employee23() {
        int employe23 = 23;
        String lastName23 = "Santos";
        String firstName23 = "Vella";
        String birthday23 = "12/31/1983";
        String address23 = "99A Padberg Spring, Poblacion, Mabalacat 3959 Lanao del Sur";
        String phoneNumber23 = "955-879-269";
        String sssNo23 = "52-9883524-3";
        String philhealthNo23 = "548670482885";
        String tinNo23 = "101-558-994-000";
        String pagibig23 = "360028104576";
        String status23 = "Probationary";
        String position23 = "Account Rank and File";
        String immediateSupervisor23 = "Mata, Christian";
        double basicSalary23 = 22500;
        double riceSubsidy23 = 1500;
        double phoneAllowance23 = 500;
        double clothingAllowance23 = 500;
        double grossSemiMonthlyRate23 = 11250;
        double hourlyRate23 = 133.93;

        System.out.println("Here are the details based on the Employee Number you entered: " + "\n"
                + "Employee #:            " + employe23 + "\n"
                + "Last Name:             " + lastName23 + "\n"
                + "First Name:            " + firstName23 + "\n"
                + "Birthday:              " + birthday23 + "\n"
                + "Address:               " + address23 + "\n"
                + "Phone Number:          " + phoneNumber23 + "\n"
                + "SSS Number:            " + sssNo23 + "\n"
                + "Philhealth Number:     " + philhealthNo23 + "\n"
                + "TIN Number:            " + tinNo23 + "\n"
                + "Pag-ibig Number:       " + pagibig23 + "\n"
                + "Status:                " + status23 + "\n"
                + "Position:              " + position23 + "\n"
                + "Immediate Supervisor:  " + immediateSupervisor23 + "\n"
                + "Basic Salary:          " + basicSalary23 + "\n"
                + "Rice Subsidy:          " + riceSubsidy23 + "\n"
                + "Phone Allowance:       " + phoneAllowance23 + "\n"
                + "Clothing Allowance:    " + clothingAllowance23 + "\n"
                + "Gross Semi-monthly Rate:" + grossSemiMonthlyRate23 + "\n"
                + "Hourly Rate:           " + hourlyRate23 + "\n");

        //calculate salary
        try {
            double nonTaxableBenefits = riceSubsidy23 + phoneAllowance23 + clothingAllowance23;
            double taxableEarnings = calculateTaxableWage(hourlyRate23);
            double sSS = calculateSSS(basicSalary23);
            double philHealth = calculatePhilHealth(basicSalary23);
            double pagIbig = calculatePagibig(basicSalary23);
            double withEarnings = taxableEarnings - (sSS + philHealth + pagIbig);
            double witHoldingTax = calculateWitholdingTax(withEarnings);

            System.out.println("\n" + "Would you like to add the Non-Taxable Benefits on your calculation? Type yes or no:");
            Scanner refBen = new Scanner(System.in);
            String addBen = refBen.next();

            if ("no".equals(addBen.toLowerCase())) {
                payslipNObenefits(taxableEarnings, sSS, philHealth,
                        pagIbig, witHoldingTax, employe23, lastName23, firstName23);
            } else {
                if ("yes".equals(addBen.toLowerCase())) {
                    payslipWITHbenefits(taxableEarnings, sSS, philHealth,
                            pagIbig, witHoldingTax, nonTaxableBenefits,
                            riceSubsidy23, phoneAllowance23, clothingAllowance23, employe23, lastName23, firstName23);
                }
            }

            System.out.println("\n" + "\n");
            enterEmployeeNo();
        } catch (Exception invalidEntry) {
            System.out.println("!!! INVALID ENTRY ENTERED !!!" + "\n");
            enterEmployeeNo();
        }

    }

    public static void employee24() {
        int employe24 = 24;
        String lastName24 = "Del Rosario";
        String firstName24 = "Tomas";
        String birthday24 = "12/18/1978";
        String address24 = "80A/48 Ledner Ridges, Poblacion, Kabankalan 8870 Marinduque";
        String phoneNumber24 = "882-550-989";
        String sssNo24 = "45-5866331-6";
        String philhealthNo24 = "953901539995";
        String tinNo24 = "560-735-732-000";
        String pagibig24 = "913108649964";
        String status24 = "Probationary";
        String position24 = "Account Rank and File";
        String immediateSupervisor24 = "Mata, Christian";
        double basicSalary24 = 22500;
        double riceSubsidy24 = 1500;
        double phoneAllowance24 = 500;
        double clothingAllowance24 = 500;
        double grossSemiMonthlyRate24 = 11250;
        double hourlyRate24 = 133.93;

        System.out.println("Here are the details based on the Employee Number you entered: " + "\n"
                + "Employee #:            " + employe24 + "\n"
                + "Last Name:             " + lastName24 + "\n"
                + "First Name:            " + firstName24 + "\n"
                + "Birthday:              " + birthday24 + "\n"
                + "Address:               " + address24 + "\n"
                + "Phone Number:          " + phoneNumber24 + "\n"
                + "SSS Number:            " + sssNo24 + "\n"
                + "Philhealth Number:     " + philhealthNo24 + "\n"
                + "TIN Number:            " + tinNo24 + "\n"
                + "Pag-ibig Number:       " + pagibig24 + "\n"
                + "Status:                " + status24 + "\n"
                + "Position:              " + position24 + "\n"
                + "Immediate Supervisor:  " + immediateSupervisor24 + "\n"
                + "Basic Salary:          " + basicSalary24 + "\n"
                + "Rice Subsidy:          " + riceSubsidy24 + "\n"
                + "Phone Allowance:       " + phoneAllowance24 + "\n"
                + "Clothing Allowance:    " + clothingAllowance24 + "\n"
                + "Gross Semi-monthly Rate:" + grossSemiMonthlyRate24 + "\n"
                + "Hourly Rate:           " + hourlyRate24 + "\n");

//calculate salary
        try {
            double nonTaxableBenefits = riceSubsidy24 + phoneAllowance24 + clothingAllowance24;
            double taxableEarnings = calculateTaxableWage(hourlyRate24);
            double sSS = calculateSSS(basicSalary24);
            double philHealth = calculatePhilHealth(basicSalary24);
            double pagIbig = calculatePagibig(basicSalary24);
            double withEarnings = taxableEarnings - (sSS + philHealth + pagIbig);
            double witHoldingTax = calculateWitholdingTax(withEarnings);

            System.out.println("\n" + "Would you like to add the Non-Taxable Benefits on your calculation? Type yes or no:");
            Scanner refBen = new Scanner(System.in);
            String addBen = refBen.next();

            if ("no".equals(addBen.toLowerCase())) {
                payslipNObenefits(taxableEarnings, sSS, philHealth,
                        pagIbig, witHoldingTax, employe24, lastName24, firstName24);
            } else {
                if ("yes".equals(addBen.toLowerCase())) {
                    payslipWITHbenefits(taxableEarnings, sSS, philHealth,
                            pagIbig, witHoldingTax, nonTaxableBenefits,
                            riceSubsidy24, phoneAllowance24, clothingAllowance24, employe24, lastName24, firstName24);
                }
            }

            System.out.println("\n" + "\n");
            enterEmployeeNo();
        } catch (Exception invalidEntry) {
            System.out.println("!!! INVALID ENTRY ENTERED !!!" + "\n");
            enterEmployeeNo();
        }

    }

    public static void employee26() {
        int employe26 = 26;
        String lastName26 = "Gutierrez";
        String firstName26 = "Percival";
        String birthday26 = "12/18/1970";
        String address26 = "58A Wilderman Walks, Poblacion, Digos 5822 Davao del Sur";
        String phoneNumber26 = "512-899-876";
        String sssNo26 = "40-9504657-8";
        String philhealthNo26 = "797639382265";
        String tinNo26 = "502-995-671-000";
        String pagibig26 = "210897095686";
        String status26 = "Probationary";
        String position26 = "Account Rank and File";
        String immediateSupervisor26 = "De Leon, Selena";
        double basicSalary26 = 24750;
        double riceSubsidy26 = 1500;
        double phoneAllowance26 = 500;
        double clothingAllowance26 = 500;
        double grossSemiMonthlyRate26 = 12375;
        double hourlyRate26 = 147.32;

        System.out.println("Here are the details based on the Employee Number you entered: " + "\n"
                + "Employee #:            " + employe26 + "\n"
                + "Last Name:             " + lastName26 + "\n"
                + "First Name:            " + firstName26 + "\n"
                + "Birthday:              " + birthday26 + "\n"
                + "Address:               " + address26 + "\n"
                + "Phone Number:          " + phoneNumber26 + "\n"
                + "SSS Number:            " + sssNo26 + "\n"
                + "Philhealth Number:     " + philhealthNo26 + "\n"
                + "TIN Number:            " + tinNo26 + "\n"
                + "Pag-ibig Number:       " + pagibig26 + "\n"
                + "Status:                " + status26 + "\n"
                + "Position:              " + position26 + "\n"
                + "Immediate Supervisor:  " + immediateSupervisor26 + "\n"
                + "Basic Salary:          " + basicSalary26 + "\n"
                + "Rice Subsidy:          " + riceSubsidy26 + "\n"
                + "Phone Allowance:       " + phoneAllowance26 + "\n"
                + "Clothing Allowance:    " + clothingAllowance26 + "\n"
                + "Gross Semi-monthly Rate:" + grossSemiMonthlyRate26 + "\n"
                + "Hourly Rate:           " + hourlyRate26 + "\n");

//calculate salary
        try {
            double nonTaxableBenefits = riceSubsidy26 + phoneAllowance26 + clothingAllowance26;
            double taxableEarnings = calculateTaxableWage(hourlyRate26);
            double sSS = calculateSSS(basicSalary26);
            double philHealth = calculatePhilHealth(basicSalary26);
            double pagIbig = calculatePagibig(basicSalary26);
            double withEarnings = taxableEarnings - (sSS + philHealth + pagIbig);
            double witHoldingTax = calculateWitholdingTax(withEarnings);

            System.out.println("\n" + "Would you like to add the Non-Taxable Benefits on your calculation? Type yes or no:");
            Scanner refBen = new Scanner(System.in);
            String addBen = refBen.next();

            if ("no".equals(addBen.toLowerCase())) {
                payslipNObenefits(taxableEarnings, sSS, philHealth,
                        pagIbig, witHoldingTax, employe26, lastName26, firstName26);
            } else {
                if ("yes".equals(addBen.toLowerCase())) {
                    payslipWITHbenefits(taxableEarnings, sSS, philHealth,
                            pagIbig, witHoldingTax, nonTaxableBenefits,
                            riceSubsidy26, phoneAllowance26, clothingAllowance26, employe26, lastName26, firstName26);
                }
            }

            System.out.println("\n" + "\n");
            enterEmployeeNo();
        } catch (Exception invalidEntry) {
            System.out.println("!!! INVALID ENTRY ENTERED !!!" + "\n");
            enterEmployeeNo();
        }

    }

    public static void employee25() {
        int employe25 = 25;
        String lastName25 = "Tolentino";
        String firstName25 = "Jacklyn";
        String birthday25 = "05/19/1984";
        String address25 = "96/48 Watsica Flats Suite 734, Poblacion, Malolos 1844 Ifugao";
        String phoneNumber25 = "675-757-366";
        String sssNo25 = "47-1692793-0";
        String philhealthNo25 = "753800654114";
        String tinNo25 = "841-177-857-000";
        String pagibig25 = "210546661243";
        String status25 = "Probationary";
        String position25 = "Account Rank and File";
        String immediateSupervisor25 = "De Leon, Selena";
        double basicSalary25 = 24000;
        double riceSubsidy25 = 1500;
        double phoneAllowance25 = 500;
        double clothingAllowance25 = 500;
        double grossSemiMonthlyRate25 = 12000;
        double hourlyRate25 = 142.86;

        System.out.println("Here are the details based on the Employee Number you entered: " + "\n"
                + "Employee #:            " + employe25 + "\n"
                + "Last Name:             " + lastName25 + "\n"
                + "First Name:            " + firstName25 + "\n"
                + "Birthday:              " + birthday25 + "\n"
                + "Address:               " + address25 + "\n"
                + "Phone Number:          " + phoneNumber25 + "\n"
                + "SSS Number:            " + sssNo25 + "\n"
                + "Philhealth Number:     " + philhealthNo25 + "\n"
                + "TIN Number:            " + tinNo25 + "\n"
                + "Pag-ibig Number:       " + pagibig25 + "\n"
                + "Status:                " + status25 + "\n"
                + "Position:              " + position25 + "\n"
                + "Immediate Supervisor:" + immediateSupervisor25 + "\n"
                + "Basic Salary:          " + basicSalary25 + "\n"
                + "Rice Subsidy:          " + riceSubsidy25 + "\n"
                + "Phone Allowance:       " + phoneAllowance25 + "\n"
                + "Clothing Allowance:    " + clothingAllowance25 + "\n"
                + "Gross Semi-monthly Rate:" + grossSemiMonthlyRate25 + "\n"
                + "Hourly Rate:           " + hourlyRate25 + "\n");

        //calculate salary
        try {
            double nonTaxableBenefits = riceSubsidy25 + phoneAllowance25 + clothingAllowance25;
            double taxableEarnings = calculateTaxableWage(hourlyRate25);
            double sSS = calculateSSS(basicSalary25);
            double philHealth = calculatePhilHealth(basicSalary25);
            double pagIbig = calculatePagibig(basicSalary25);
            double withEarnings = taxableEarnings - (sSS + philHealth + pagIbig);
            double witHoldingTax = calculateWitholdingTax(withEarnings);

            System.out.println("\n" + "Would you like to add the Non-Taxable Benefits on your calculation? Type yes or no:");
            Scanner refBen = new Scanner(System.in);
            String addBen = refBen.next();

            if ("no".equals(addBen.toLowerCase())) {
                payslipNObenefits(taxableEarnings, sSS, philHealth,
                        pagIbig, witHoldingTax, employe25, lastName25, firstName25);
            } else {
                if ("yes".equals(addBen.toLowerCase())) {
                    payslipWITHbenefits(taxableEarnings, sSS, philHealth,
                            pagIbig, witHoldingTax, nonTaxableBenefits,
                            riceSubsidy25, phoneAllowance25, clothingAllowance25, employe25, lastName25, firstName25);
                }
            }

            System.out.println("\n" + "\n");
            enterEmployeeNo();
        } catch (Exception invalidEntry) {
            System.out.println("!!! INVALID ENTRY ENTERED !!!" + "\n");
            enterEmployeeNo();
        }

    }

    public static void employee27() {
        int employe27 = 27;
        String lastName27 = "Manalaysay";
        String firstName27 = "Garfield";
        String birthday27 = "08/28/1986";
        String address27 = "60 Goyette Valley Suite 219, Poblacion, Tabuk 3159 Lanao del Sur";
        String phoneNumber27 = "948-628-136";
        String sssNo27 = "45-3298166-4";
        String philhealthNo27 = "810909286264";
        String tinNo27 = "336-676-445-000";
        String pagibig27 = "211274476563";
        String status27 = "Probationary";
        String position27 = "Account Rank and File";
        String immediateSupervisor27 = "De Leon, Selena";
        double basicSalary27 = 24750;
        double riceSubsidy27 = 1500;
        double phoneAllowance27 = 500;
        double clothingAllowance27 = 500;
        double grossSemiMonthlyRate27 = 12375;
        double hourlyRate27 = 147.32;

        System.out.println("Here are the details based on the Employee Number you entered: " + "\n"
                + "Employee #:            " + employe27 + "\n"
                + "Last Name:             " + lastName27 + "\n"
                + "First Name:            " + firstName27 + "\n"
                + "Birthday:              " + birthday27 + "\n"
                + "Address:               " + address27 + "\n"
                + "Phone Number:          " + phoneNumber27 + "\n"
                + "SSS Number:            " + sssNo27 + "\n"
                + "Philhealth Number:     " + philhealthNo27 + "\n"
                + "TIN Number:            " + tinNo27 + "\n"
                + "Pag-ibig Number:       " + pagibig27 + "\n"
                + "Status:                " + status27 + "\n"
                + "Position:              " + position27 + "\n"
                + "Immediate Supervisor:  " + immediateSupervisor27 + "\n"
                + "Basic Salary:          " + basicSalary27 + "\n"
                + "Rice Subsidy:          " + riceSubsidy27 + "\n"
                + "Phone Allowance:       " + phoneAllowance27 + "\n"
                + "Clothing Allowance:    " + clothingAllowance27 + "\n"
                + "Gross Semi-monthly Rate:" + grossSemiMonthlyRate27 + "\n"
                + "Hourly Rate:           " + hourlyRate27 + "\n");

        //calculate salary
        try {
            double nonTaxableBenefits = riceSubsidy27 + phoneAllowance27 + clothingAllowance27;
            double taxableEarnings = calculateTaxableWage(hourlyRate27);
            double sSS = calculateSSS(basicSalary27);
            double philHealth = calculatePhilHealth(basicSalary27);
            double pagIbig = calculatePagibig(basicSalary27);
            double withEarnings = taxableEarnings - (sSS + philHealth + pagIbig);
            double witHoldingTax = calculateWitholdingTax(withEarnings);

            System.out.println("\n" + "Would you like to add the Non-Taxable Benefits on your calculation? Type yes or no:");
            Scanner refBen = new Scanner(System.in);
            String addBen = refBen.next();

            if ("no".equals(addBen.toLowerCase())) {
                payslipNObenefits(taxableEarnings, sSS, philHealth,
                        pagIbig, witHoldingTax, employe27, lastName27, firstName27);
            } else {
                if ("yes".equals(addBen.toLowerCase())) {
                    payslipWITHbenefits(taxableEarnings, sSS, philHealth,
                            pagIbig, witHoldingTax, nonTaxableBenefits,
                            riceSubsidy27, phoneAllowance27, clothingAllowance27, employe27, lastName27, firstName27);
                }
            }

            System.out.println("\n" + "\n");
            enterEmployeeNo();
        } catch (Exception invalidEntry) {
            System.out.println("!!! INVALID ENTRY ENTERED !!!" + "\n");
            enterEmployeeNo();
        }

    }

    public static void employee29() {
        int employe29 = 29;
        String lastName29 = "Ramos";
        String firstName29 = "Carol";
        String birthday29 = "08/20/1978";
        String address29 = "72/70 Stamm Spurs, Bustos 4550 Iloilo";
        String phoneNumber29 = "250-700-389";
        String sssNo29 = "60-1152206-4";
        String philhealthNo29 = "351830469744";
        String tinNo29 = "395-032-717-000";
        String pagibig29 = "212141893454";
        String status29 = "Probationary";
        String position29 = "Account Rank and File";
        String immediateSupervisor29 = "De Leon, Selena";
        double basicSalary29 = 22500;
        double riceSubsidy29 = 1500;
        double phoneAllowance29 = 500;
        double clothingAllowance29 = 500;
        double grossSemiMonthlyRate29 = 11250;
        double hourlyRate29 = 133.93;

        System.out.println("Here are the details based on the Employee Number you entered: " + "\n"
                + "Employee #:            " + employe29 + "\n"
                + "Last Name:             " + lastName29 + "\n"
                + "First Name:            " + firstName29 + "\n"
                + "Birthday:              " + birthday29 + "\n"
                + "Address:               " + address29 + "\n"
                + "Phone Number:          " + phoneNumber29 + "\n"
                + "SSS Number:            " + sssNo29 + "\n"
                + "Philhealth Number:     " + philhealthNo29 + "\n"
                + "TIN Number:            " + tinNo29 + "\n"
                + "Pag-ibig Number:       " + pagibig29 + "\n"
                + "Status:                " + status29 + "\n"
                + "Position:              " + position29 + "\n"
                + "Immediate Supervisor:  " + immediateSupervisor29 + "\n"
                + "Basic Salary:          " + basicSalary29 + "\n"
                + "Rice Subsidy:          " + riceSubsidy29 + "\n"
                + "Phone Allowance:       " + phoneAllowance29 + "\n"
                + "Clothing Allowance:    " + clothingAllowance29 + "\n"
                + "Gross Semi-monthly Rate:" + grossSemiMonthlyRate29 + "\n"
                + "Hourly Rate:           " + hourlyRate29 + "\n");

        //calculate salary
        try {
            double nonTaxableBenefits = riceSubsidy29 + phoneAllowance29 + clothingAllowance29;
            double taxableEarnings = calculateTaxableWage(hourlyRate29);
            double sSS = calculateSSS(basicSalary29);
            double philHealth = calculatePhilHealth(basicSalary29);
            double pagIbig = calculatePagibig(basicSalary29);
            double withEarnings = taxableEarnings - (sSS + philHealth + pagIbig);
            double witHoldingTax = calculateWitholdingTax(withEarnings);

            System.out.println("\n" + "Would you like to add the Non-Taxable Benefits on your calculation? Type yes or no:");
            Scanner refBen = new Scanner(System.in);
            String addBen = refBen.next();

            if ("no".equals(addBen.toLowerCase())) {
                payslipNObenefits(taxableEarnings, sSS, philHealth,
                        pagIbig, witHoldingTax, employe29, lastName29, firstName29);
            } else {
                if ("yes".equals(addBen.toLowerCase())) {
                    payslipWITHbenefits(taxableEarnings, sSS, philHealth,
                            pagIbig, witHoldingTax, nonTaxableBenefits,
                            riceSubsidy29, phoneAllowance29, clothingAllowance29, employe29, lastName29, firstName29);
                }
            }

            System.out.println("\n" + "\n");
            enterEmployeeNo();
        } catch (Exception invalidEntry) {
            System.out.println("!!! INVALID ENTRY ENTERED !!!" + "\n");
            enterEmployeeNo();
        }

    }

    public static void employee28() {
        int employe28 = 28;
        String lastName28 = "Villegas";
        String firstName28 = "Lizeth";
        String birthday28 = "12/12/1981";
        String address28 = "66/77 Mann Views, Luisiana 1263 Dinagat Islands";
        String phoneNumber28 = "332-372-215";
        String sssNo28 = "40-2400719-4";
        String philhealthNo28 = "934389652994";
        String tinNo28 = "210-395-397-000";
        String pagibig28 = "122238077997";
        String status28 = "Probationary";
        String position28 = "Account Rank and File";
        String immediateSupervisor28 = "De Leon, Selena";
        double basicSalary28 = 24000;
        double riceSubsidy28 = 1500;
        double phoneAllowance28 = 500;
        double clothingAllowance28 = 500;
        double grossSemiMonthlyRate28 = 12000;
        double hourlyRate28 = 142.86;

        System.out.println("Here are the details based on the Employee Number you entered: " + "\n"
                + "Employee #:            " + employe28 + "\n"
                + "Last Name:             " + lastName28 + "\n"
                + "First Name:            " + firstName28 + "\n"
                + "Birthday:              " + birthday28 + "\n"
                + "Address:               " + address28 + "\n"
                + "Phone Number:          " + phoneNumber28 + "\n"
                + "SSS Number:            " + sssNo28 + "\n"
                + "Philhealth Number:     " + philhealthNo28 + "\n"
                + "TIN Number:            " + tinNo28 + "\n"
                + "Pag-ibig Number:       " + pagibig28 + "\n"
                + "Status:                " + status28 + "\n"
                + "Position:              " + position28 + "\n"
                + "Immediate Supervisor:  " + immediateSupervisor28 + "\n"
                + "Basic Salary:          " + basicSalary28 + "\n"
                + "Rice Subsidy:          " + riceSubsidy28 + "\n"
                + "Phone Allowance:       " + phoneAllowance28 + "\n"
                + "Clothing Allowance:    " + clothingAllowance28 + "\n"
                + "Gross Semi-monthly Rate:" + grossSemiMonthlyRate28 + "\n"
                + "Hourly Rate:           " + hourlyRate28 + "\n");

        //calculate salary
        try {
            double nonTaxableBenefits = riceSubsidy28 + phoneAllowance28 + clothingAllowance28;
            double taxableEarnings = calculateTaxableWage(hourlyRate28);
            double sSS = calculateSSS(basicSalary28);
            double philHealth = calculatePhilHealth(basicSalary28);
            double pagIbig = calculatePagibig(basicSalary28);
            double withEarnings = taxableEarnings - (sSS + philHealth + pagIbig);
            double witHoldingTax = calculateWitholdingTax(withEarnings);

            System.out.println("\n" + "Would you like to add the Non-Taxable Benefits on your calculation? Type yes or no:");
            Scanner refBen = new Scanner(System.in);
            String addBen = refBen.next();

            if ("no".equals(addBen.toLowerCase())) {
                payslipNObenefits(taxableEarnings, sSS, philHealth,
                        pagIbig, witHoldingTax, employe28, lastName28, firstName28);
            } else {
                if ("yes".equals(addBen.toLowerCase())) {
                    payslipWITHbenefits(taxableEarnings, sSS, philHealth,
                            pagIbig, witHoldingTax, nonTaxableBenefits,
                            riceSubsidy28, phoneAllowance28, clothingAllowance28, employe28, lastName28, firstName28);
                }
            }

            System.out.println("\n" + "\n");
            enterEmployeeNo();
        } catch (Exception invalidEntry) {
            System.out.println("!!! INVALID ENTRY ENTERED !!!" + "\n");
            enterEmployeeNo();
        }

    }

    public static void employee30() {
        int employe30 = 30;
        String lastName30 = "Maceda";
        String firstName30 = "Emelia";
        String birthday30 = "04/14/1973";
        String address30 = "50A/83 Bahringer Oval Suite 145, Kiamba 7688 Nueva Ecija";
        String phoneNumber30 = "973-358-041";
        String sssNo30 = "54-1331005-0";
        String philhealthNo30 = "465087894112";
        String tinNo30 = "215-973-013-000";
        String pagibig30 = "515012579765";
        String status30 = "Probationary";
        String position30 = "Account Rank and File";
        String immediateSupervisor30 = "De Leon, Selena";
        double basicSalary30 = 22500;
        double riceSubsidy30 = 1500;
        double phoneAllowance30 = 500;
        double clothingAllowance30 = 500;
        double grossSemiMonthlyRate30 = 11250;
        double hourlyRate30 = 133.93;

        System.out.println("Here are the details based on the Employee Number you entered: " + "\n"
                + "Employee #:            " + employe30 + "\n"
                + "Last Name:             " + lastName30 + "\n"
                + "First Name:            " + firstName30 + "\n"
                + "Birthday:              " + birthday30 + "\n"
                + "Address:               " + address30 + "\n"
                + "Phone Number:          " + phoneNumber30 + "\n"
                + "SSS Number:            " + sssNo30 + "\n"
                + "Philhealth Number:     " + philhealthNo30 + "\n"
                + "TIN Number:            " + tinNo30 + "\n"
                + "Pag-ibig Number:       " + pagibig30 + "\n"
                + "Status:                " + status30 + "\n"
                + "Position:              " + position30 + "\n"
                + "Immediate Supervisor:  " + immediateSupervisor30 + "\n"
                + "Basic Salary:          " + basicSalary30 + "\n"
                + "Rice Subsidy:          " + riceSubsidy30 + "\n"
                + "Phone Allowance:       " + phoneAllowance30 + "\n"
                + "Clothing Allowance:    " + clothingAllowance30 + "\n"
                + "Gross Semi-monthly Rate:" + grossSemiMonthlyRate30 + "\n"
                + "Hourly Rate:           " + hourlyRate30 + "\n");

        //calculate salary
        try {
            double nonTaxableBenefits = riceSubsidy30 + phoneAllowance30 + clothingAllowance30;
            double taxableEarnings = calculateTaxableWage(hourlyRate30);
            double sSS = calculateSSS(basicSalary30);
            double philHealth = calculatePhilHealth(basicSalary30);
            double pagIbig = calculatePagibig(basicSalary30);
            double withEarnings = taxableEarnings - (sSS + philHealth + pagIbig);
            double witHoldingTax = calculateWitholdingTax(withEarnings);

            System.out.println("\n" + "Would you like to add the Non-Taxable Benefits on your calculation? Type yes or no:");
            Scanner refBen = new Scanner(System.in);
            String addBen = refBen.next();

            if ("no".equals(addBen.toLowerCase())) {
                payslipNObenefits(taxableEarnings, sSS, philHealth,
                        pagIbig, witHoldingTax, employe30, lastName30, firstName30);
            } else {
                if ("yes".equals(addBen.toLowerCase())) {
                    payslipWITHbenefits(taxableEarnings, sSS, philHealth,
                            pagIbig, witHoldingTax, nonTaxableBenefits,
                            riceSubsidy30, phoneAllowance30, clothingAllowance30, employe30, lastName30, firstName30);
                }
            }

            System.out.println("\n" + "\n");
            enterEmployeeNo();
        } catch (Exception invalidEntry) {
            System.out.println("!!! INVALID ENTRY ENTERED !!!" + "\n");
            enterEmployeeNo();
        }

    }

    public static void employee31() {
        int employe31 = 31;
        String lastName31 = "Aguilar";
        String firstName31 = "Delia";
        String birthday31 = "01/27/1989";
        String address31 = "95 Cremin Junction, Surallah 2809 Cotabato";
        String phoneNumber31 = "529-705-439";
        String sssNo31 = "52-1859253-1";
        String philhealthNo31 = "136451303068";
        String tinNo31 = "599-312-588-000";
        String pagibig31 = "110018813465";
        String status31 = "Probationary";
        String position31 = "Account Rank and File";
        String immediateSupervisor31 = "De Leon, Selena";
        double basicSalary31 = 22500;
        double riceSubsidy31 = 1500;
        double phoneAllowance31 = 500;
        double clothingAllowance31 = 500;
        double grossSemiMonthlyRate31 = 11250;
        double hourlyRate31 = 133.93;

        System.out.println("Here are the details based on the Employee Number you entered: " + "\n"
                + "Employee #:            " + employe31 + "\n"
                + "Last Name:             " + lastName31 + "\n"
                + "First Name:            " + firstName31 + "\n"
                + "Birthday:              " + birthday31 + "\n"
                + "Address:               " + address31 + "\n"
                + "Phone Number:          " + phoneNumber31 + "\n"
                + "SSS Number:            " + sssNo31 + "\n"
                + "Philhealth Number:     " + philhealthNo31 + "\n"
                + "TIN Number:            " + tinNo31 + "\n"
                + "Pag-ibig Number:       " + pagibig31 + "\n"
                + "Status:                " + status31 + "\n"
                + "Position:              " + position31 + "\n"
                + "Immediate Supervisor:  " + immediateSupervisor31 + "\n"
                + "Basic Salary:          " + basicSalary31 + "\n"
                + "Rice Subsidy:          " + riceSubsidy31 + "\n"
                + "Phone Allowance:       " + phoneAllowance31 + "\n"
                + "Clothing Allowance:    " + clothingAllowance31 + "\n"
                + "Gross Semi-monthly Rate:" + grossSemiMonthlyRate31 + "\n"
                + "Hourly Rate:           " + hourlyRate31 + "\n");

//calculate salary
        try {
            double nonTaxableBenefits = riceSubsidy31 + phoneAllowance31 + clothingAllowance31;
            double taxableEarnings = calculateTaxableWage(hourlyRate31);
            double sSS = calculateSSS(basicSalary31);
            double philHealth = calculatePhilHealth(basicSalary31);
            double pagIbig = calculatePagibig(basicSalary31);
            double withEarnings = taxableEarnings - (sSS + philHealth + pagIbig);
            double witHoldingTax = calculateWitholdingTax(withEarnings);

            System.out.println("\n" + "Would you like to add the Non-Taxable Benefits on your calculation? Type yes or no:");
            Scanner refBen = new Scanner(System.in);
            String addBen = refBen.next();

            if ("no".equals(addBen.toLowerCase())) {
                payslipNObenefits(taxableEarnings, sSS, philHealth,
                        pagIbig, witHoldingTax, employe31, lastName31, firstName31);
            } else {
                if ("yes".equals(addBen.toLowerCase())) {
                    payslipWITHbenefits(taxableEarnings, sSS, philHealth,
                            pagIbig, witHoldingTax, nonTaxableBenefits,
                            riceSubsidy31, phoneAllowance31, clothingAllowance31, employe31, lastName31, firstName31);
                }
            }

            System.out.println("\n" + "\n");
            enterEmployeeNo();
        } catch (Exception invalidEntry) {
            System.out.println("!!! INVALID ENTRY ENTERED !!!" + "\n");
            enterEmployeeNo();
        }

    }

    public static void employee32() {
        int employe32 = 32;
        String lastName32 = "Castro";
        String firstName32 = "John Rafael";
        String birthday32 = "02/09/1992";
        String address32 = "Hi-way, Yati, Liloan Cebu";
        String phoneNumber32 = "332-424-955";
        String sssNo32 = "26-7145133-4";
        String philhealthNo32 = "601644902402";
        String tinNo32 = "404-768-309-000";
        String pagibig32 = "697764069311";
        String status32 = "Regular";
        String position32 = "Sales & Marketing";
        String immediateSupervisor32 = "Reyes, Isabella";
        double basicSalary32 = 52670;
        double riceSubsidy32 = 1500;
        double phoneAllowance32 = 1000;
        double clothingAllowance32 = 1000;
        double grossSemiMonthlyRate32 = 26335;
        double hourlyRate32 = 313.51;

        System.out.println("Here are the details based on the Employee Number you entered: " + "\n"
                + "Employee #:            " + employe32 + "\n"
                + "Last Name:             " + lastName32 + "\n"
                + "First Name:            " + firstName32 + "\n"
                + "Birthday:              " + birthday32 + "\n"
                + "Address:               " + address32 + "\n"
                + "Phone Number:          " + phoneNumber32 + "\n"
                + "SSS Number:            " + sssNo32 + "\n"
                + "Philhealth Number:     " + philhealthNo32 + "\n"
                + "TIN Number:            " + tinNo32 + "\n"
                + "Pag-ibig Number:       " + pagibig32 + "\n"
                + "Status:                " + status32 + "\n"
                + "Position:              " + position32 + "\n"
                + "Immediate Supervisor:  " + immediateSupervisor32 + "\n"
                + "Basic Salary:          " + basicSalary32 + "\n"
                + "Rice Subsidy:          " + riceSubsidy32 + "\n"
                + "Phone Allowance:       " + phoneAllowance32 + "\n"
                + "Clothing Allowance:    " + clothingAllowance32 + "\n"
                + "Gross Semi-monthly Rate:" + grossSemiMonthlyRate32 + "\n"
                + "Hourly Rate:           " + hourlyRate32 + "\n");

        //calculate salary
        try {
            double nonTaxableBenefits = riceSubsidy32 + phoneAllowance32 + clothingAllowance32;
            double taxableEarnings = calculateTaxableWage(hourlyRate32);
            double sSS = calculateSSS(basicSalary32);
            double philHealth = calculatePhilHealth(basicSalary32);
            double pagIbig = calculatePagibig(basicSalary32);
            double withEarnings = taxableEarnings - (sSS + philHealth + pagIbig);
            double witHoldingTax = calculateWitholdingTax(withEarnings);

            System.out.println("\n" + "Would you like to add the Non-Taxable Benefits on your calculation? Type yes or no:");
            Scanner refBen = new Scanner(System.in);
            String addBen = refBen.next();

            if ("no".equals(addBen.toLowerCase())) {
                payslipNObenefits(taxableEarnings, sSS, philHealth,
                        pagIbig, witHoldingTax, employe32, lastName32, firstName32);
            } else {
                if ("yes".equals(addBen.toLowerCase())) {
                    payslipWITHbenefits(taxableEarnings, sSS, philHealth,
                            pagIbig, witHoldingTax, nonTaxableBenefits,
                            riceSubsidy32, phoneAllowance32, clothingAllowance32, employe32, lastName32, firstName32);
                }
            }

            System.out.println("\n" + "\n");
            enterEmployeeNo();
        } catch (Exception invalidEntry) {
            System.out.println("!!! INVALID ENTRY ENTERED !!!" + "\n");
            enterEmployeeNo();
        }

    }

    public static void employee33() {
        int employe33 = 33;
        String lastName33 = "Martinez";
        String firstName33 = "Carlos Ian";
        String birthday33 = "11/16/1990";
        String address33 = "Bulala, Camalaniugan";
        String phoneNumber33 = "078-854-208";
        String sssNo33 = "11-5062972-7";
        String philhealthNo33 = "380685387212";
        String tinNo33 = "256-436-296-000";
        String pagibig33 = "993372963726";
        String status33 = "Regular";
        String position33 = "Supply Chain and Logistics";
        String immediateSupervisor33 = "Reyes, Isabella";
        double basicSalary33 = 52670;
        double riceSubsidy33 = 1500;
        double phoneAllowance33 = 1000;
        double clothingAllowance33 = 1000;
        double grossSemiMonthlyRate33 = 26335;
        double hourlyRate33 = 313.51;

        System.out.println("Here are the details based on the Employee Number you entered: " + "\n"
                + "Employee #:            " + employe33 + "\n"
                + "Last Name:             " + lastName33 + "\n"
                + "First Name:            " + firstName33 + "\n"
                + "Birthday:              " + birthday33 + "\n"
                + "Address:               " + address33 + "\n"
                + "Phone Number:          " + phoneNumber33 + "\n"
                + "SSS Number:            " + sssNo33 + "\n"
                + "Philhealth Number:     " + philhealthNo33 + "\n"
                + "TIN Number:            " + tinNo33 + "\n"
                + "Pag-ibig Number:       " + pagibig33 + "\n"
                + "Status:                " + status33 + "\n"
                + "Position:              " + position33 + "\n"
                + "Immediate Supervisor:  " + immediateSupervisor33 + "\n"
                + "Basic Salary:          " + basicSalary33 + "\n"
                + "Rice Subsidy:          " + riceSubsidy33 + "\n"
                + "Phone Allowance:       " + phoneAllowance33 + "\n"
                + "Clothing Allowance:    " + clothingAllowance33 + "\n"
                + "Gross Semi-monthly Rate:" + grossSemiMonthlyRate33 + "\n"
                + "Hourly Rate:           " + hourlyRate33 + "\n");

        //calculate salary
        try {
            double nonTaxableBenefits = riceSubsidy33 + phoneAllowance33 + clothingAllowance33;
            double taxableEarnings = calculateTaxableWage(hourlyRate33);
            double sSS = calculateSSS(basicSalary33);
            double philHealth = calculatePhilHealth(basicSalary33);
            double pagIbig = calculatePagibig(basicSalary33);
            double withEarnings = taxableEarnings - (sSS + philHealth + pagIbig);
            double witHoldingTax = calculateWitholdingTax(withEarnings);

            System.out.println("\n" + "Would you like to add the Non-Taxable Benefits on your calculation? Type yes or no:");
            Scanner refBen = new Scanner(System.in);
            String addBen = refBen.next();

            if ("no".equals(addBen.toLowerCase())) {
                payslipNObenefits(taxableEarnings, sSS, philHealth,
                        pagIbig, witHoldingTax, employe33, lastName33, firstName33);
            } else {
                if ("yes".equals(addBen.toLowerCase())) {
                    payslipWITHbenefits(taxableEarnings, sSS, philHealth,
                            pagIbig, witHoldingTax, nonTaxableBenefits,
                            riceSubsidy33, phoneAllowance33, clothingAllowance33, employe33, lastName33, firstName33);
                }
            }

            System.out.println("\n" + "\n");
            enterEmployeeNo();
        } catch (Exception invalidEntry) {
            System.out.println("!!! INVALID ENTRY ENTERED !!!" + "\n");
            enterEmployeeNo();
        }

    }

    public static void employee34() {
        int employe34 = 34;
        String lastName34 = "Santos";
        String firstName34 = "Beatriz";
        String birthday34 = "08/07/1990";
        String address34 = "Agapita Building, Metro Manila";
        String phoneNumber34 = "526-639-511";
        String sssNo34 = "20-2987501-5";
        String philhealthNo34 = "918460050077";
        String tinNo34 = "911-529-713-000";
        String pagibig34 = "874042259378";
        String status34 = "Regular";
        String position34 = "Customer Service and Relations";
        String immediateSupervisor34 = "Reyes, Isabella";
        double basicSalary34 = 52670;
        double riceSubsidy34 = 1500;
        double phoneAllowance34 = 1000;
        double clothingAllowance34 = 1000;
        double grossSemiMonthlyRate34 = 26335;
        double hourlyRate34 = 313.51;

        System.out.println("Here are the details based on the Employee Number you entered: " + "\n"
                + "Employee #:            " + employe34 + "\n"
                + "Last Name:             " + lastName34 + "\n"
                + "First Name:            " + firstName34 + "\n"
                + "Birthday:              " + birthday34 + "\n"
                + "Address:               " + address34 + "\n"
                + "Phone Number:          " + phoneNumber34 + "\n"
                + "SSS Number:            " + sssNo34 + "\n"
                + "Philhealth Number:     " + philhealthNo34 + "\n"
                + "TIN Number:            " + tinNo34 + "\n"
                + "Pag-ibig Number:       " + pagibig34 + "\n"
                + "Status:                " + status34 + "\n"
                + "Position:              " + position34 + "\n"
                + "Immediate Supervisor:  " + immediateSupervisor34 + "\n"
                + "Basic Salary:          " + basicSalary34 + "\n"
                + "Rice Subsidy:          " + riceSubsidy34 + "\n"
                + "Phone Allowance:       " + phoneAllowance34 + "\n"
                + "Clothing Allowance:    " + clothingAllowance34 + "\n"
                + "Gross Semi-monthly Rate:" + grossSemiMonthlyRate34 + "\n"
                + "Hourly Rate:           " + hourlyRate34 + "\n");

        //calculate salary
        try {
            double nonTaxableBenefits = riceSubsidy34 + phoneAllowance34 + clothingAllowance34;
            double taxableEarnings = calculateTaxableWage(hourlyRate34);
            double sSS = calculateSSS(basicSalary34);
            double philHealth = calculatePhilHealth(basicSalary34);
            double pagIbig = calculatePagibig(basicSalary34);
            double withEarnings = taxableEarnings - (sSS + philHealth + pagIbig);
            double witHoldingTax = calculateWitholdingTax(withEarnings);

            System.out.println("\n" + "Would you like to add the Non-Taxable Benefits on your calculation? Type yes or no:");
            Scanner refBen = new Scanner(System.in);
            String addBen = refBen.next();

            if ("no".equals(addBen.toLowerCase())) {
                payslipNObenefits(taxableEarnings, sSS, philHealth,
                        pagIbig, witHoldingTax, employe34, lastName34, firstName34);
            } else {
                if ("yes".equals(addBen.toLowerCase())) {
                    payslipWITHbenefits(taxableEarnings, sSS, philHealth,
                            pagIbig, witHoldingTax, nonTaxableBenefits,
                            riceSubsidy34, phoneAllowance34, clothingAllowance34, employe34, lastName34, firstName34);
                }
            }

            System.out.println("\n" + "\n");
            enterEmployeeNo();
        } catch (Exception invalidEntry) {
            System.out.println("!!! INVALID ENTRY ENTERED !!! \n");
            enterEmployeeNo();
        }

    }

    public static double calculateTotalHoursWorked(String loginTimeString, String logoutTimeString) {
        // Define office hours
        LocalTime officeStartTime = LocalTime.of(8, 0); // 8:00 AM
        LocalTime officeEndTime = LocalTime.of(17, 0); // 5:00 PM

        // Define grace period for login (10 minutes)
        int gracePeriodMinutes = 10;

        // Prompt the user to enter the login time
        LocalTime loginTime = LocalTime.parse(loginTimeString);

        // Check if the employee logged in within the grace period
        LocalTime actualLoginTime = loginTime;
        if (loginTime.isAfter(officeStartTime)) {
            long minutesAfterStart = officeStartTime.until(loginTime, java.time.temporal.ChronoUnit.MINUTES);
            if (minutesAfterStart > gracePeriodMinutes) {
                // Employee is considered late
                actualLoginTime = loginTime;
            } else {
                // Within the grace period
                actualLoginTime = officeStartTime;
            }
        }

        // Prompt the user to enter the logout time
        LocalTime logoutTime = LocalTime.parse(logoutTimeString);
        double totalHoursWorked = actualLoginTime.until(logoutTime, java.time.temporal.ChronoUnit.MINUTES) / 60.0;

        System.out.print("Would you like to deduct 1 hour lunch for this day? Type yes or no:\n");
        Scanner d_lunch = new Scanner(System.in);
        String lunch = d_lunch.next();
        if ("no".equals(lunch.toLowerCase())) {
            totalHoursWorked = Math.round(totalHoursWorked * 100.0) / 100.0;
            System.out.println("\nTotal hours worked for the day =    " + totalHoursWorked);
        } else {
            if ("yes".equals(lunch.toLowerCase())) {
                totalHoursWorked = (Math.round(totalHoursWorked * 100.0) / 100.0);
                totalHoursWorked = totalHoursWorked - 1;
                System.out.println("\n Total hours worked for the day =    " + totalHoursWorked);
            } else {
                System.out.println("!!! INVALID ENTRY NUMBER ENTERED !!! \n");
            }
        }
        return totalHoursWorked;

    }

    public static double calculateOverTime(double totHrs) {
        double otHrs = 0;
        if (totHrs > 8) {
            otHrs = totHrs - 8;
            System.out.println("Total over-time hours worked for the day =    " + otHrs);
        } else {
            otHrs = 0;
        }
        return otHrs;

    }

    public static double calculateRegularHours(double totHrs) {
        double rgHrs = 0;
        if (totHrs > 8) {
            rgHrs = 8;
        } else {
            rgHrs = totHrs * 1;
        }
        System.out.println("Total regular hours worked for the day =    " + rgHrs);
        return rgHrs;
    }

    public static double calculateTaxableWage(double hrlyRate) {
        double taxableWage = 0;
        double totHrs1 = 0;
        double totHrs2 = 0;
        double totHrs3 = 0;
        double totHrs4 = 0;
        double totHrs5 = 0;
        double totHrs6 = 0;
        double totHrs7 = 0;
        double totHrs8 = 0;
        double totHrs9 = 0;
        double totHrs10 = 0;
        double totHrs11 = 0;
        double totHrs12 = 0;
        double totHrs13 = 0;
        double totHrs14 = 0;
        double totHrs15 = 0;
        double totHrs16 = 0;
        double totHrs17 = 0;
        double totHrs18 = 0;
        double totHrs19 = 0;
        double totHrs20 = 0;
        double regHrs1 = 0;
        double regHrs2 = 0;
        double regHrs3 = 0;
        double regHrs4 = 0;
        double regHrs5 = 0;
        double regHrs6 = 0;
        double regHrs7 = 0;
        double regHrs8 = 0;
        double regHrs9 = 0;
        double regHrs10 = 0;
        double regHrs11 = 0;
        double regHrs12 = 0;
        double regHrs13 = 0;
        double regHrs14 = 0;
        double regHrs15 = 0;
        double regHrs16 = 0;
        double regHrs17 = 0;
        double regHrs18 = 0;
        double regHrs19 = 0;
        double regHrs20 = 0;
        double otHrs1 = 0;
        double otHrs2 = 0;
        double otHrs3 = 0;
        double otHrs4 = 0;
        double otHrs5 = 0;
        double otHrs6 = 0;
        double otHrs7 = 0;
        double otHrs8 = 0;
        double otHrs9 = 0;
        double otHrs10 = 0;
        double otHrs11 = 0;
        double otHrs12 = 0;
        double otHrs13 = 0;
        double otHrs14 = 0;
        double otHrs15 = 0;
        double otHrs16 = 0;
        double otHrs17 = 0;
        double otHrs18 = 0;
        double otHrs19 = 0;
        double otHrs20 = 0;

        System.out.println("Calculate the weekly salary based on the hours worked by entering the number of hours for day below:");
        System.out.println("Enter the number of day/s you would like to make and entry below:");
        Scanner noDays = new Scanner(System.in);
        double noOfDays = noDays.nextDouble();

        if (noOfDays == 1) {
            System.out.println("\n" + "Day 1: ");
            System.out.print("Enter login time (HH:mm): ");
            Scanner login1 = new Scanner(System.in);
            String loginTimeString1 = login1.next();

            System.out.print("Enter logout time (HH:mm): ");
            Scanner logout1 = new Scanner(System.in);
            String logoutTimeString1 = logout1.next();

            totHrs1 = calculateTotalHoursWorked(loginTimeString1, logoutTimeString1);
            regHrs1 = calculateRegularHours(totHrs1);
            otHrs1 = calculateOverTime(totHrs1);

        } else {
            if (noOfDays == 2) {

                System.out.println("\n" + "Day 1: ");
                System.out.print("Enter login time (HH:mm): ");
                Scanner login1 = new Scanner(System.in);
                String loginTimeString1 = login1.next();

                System.out.print("Enter logout time (HH:mm): ");
                Scanner logout1 = new Scanner(System.in);
                String logoutTimeString1 = logout1.next();

                totHrs1 = calculateTotalHoursWorked(loginTimeString1, logoutTimeString1);
                regHrs1 = calculateRegularHours(totHrs1);
                otHrs1 = calculateOverTime(totHrs1);

                System.out.println("\n" + "Day 2: ");
                System.out.print("Enter login time (HH:mm): ");
                Scanner login2 = new Scanner(System.in);
                String loginTimeString2 = login2.next();

                System.out.print("Enter logout time (HH:mm): ");
                Scanner logout2 = new Scanner(System.in);
                String logoutTimeString2 = logout2.next();

                totHrs2 = calculateTotalHoursWorked(loginTimeString2, logoutTimeString2);
                regHrs2 = calculateRegularHours(totHrs2);
                otHrs2 = calculateOverTime(totHrs2);
            } else {
                if (noOfDays == 3) {
                    System.out.println("\n" + "Day 1: ");
                    System.out.print("Enter login time (HH:mm): ");
                    Scanner login1 = new Scanner(System.in);
                    String loginTimeString1 = login1.next();

                    System.out.print("Enter logout time (HH:mm): ");
                    Scanner logout1 = new Scanner(System.in);
                    String logoutTimeString1 = logout1.next();

                    totHrs1 = calculateTotalHoursWorked(loginTimeString1, logoutTimeString1);
                    regHrs1 = calculateRegularHours(totHrs1);
                    otHrs1 = calculateOverTime(totHrs1);

                    System.out.println("\n" + "Day 2: ");
                    System.out.print("Enter login time (HH:mm): ");
                    Scanner login2 = new Scanner(System.in);
                    String loginTimeString2 = login2.next();

                    System.out.print("Enter logout time (HH:mm): ");
                    Scanner logout2 = new Scanner(System.in);
                    String logoutTimeString2 = logout2.next();

                    totHrs2 = calculateTotalHoursWorked(loginTimeString2, logoutTimeString2);
                    regHrs2 = calculateRegularHours(totHrs2);
                    otHrs2 = calculateOverTime(totHrs2);

                    System.out.println("\n" + "Day 3: ");
                    System.out.print("Enter login time (HH:mm): ");
                    Scanner login3 = new Scanner(System.in);
                    String loginTimeString3 = login3.next();

                    System.out.print("Enter logout time (HH:mm): ");
                    Scanner logout3 = new Scanner(System.in);
                    String logoutTimeString3 = logout3.next();

                    totHrs3 = calculateTotalHoursWorked(loginTimeString3, logoutTimeString3);
                    regHrs3 = calculateRegularHours(totHrs3);
                    otHrs3 = calculateOverTime(totHrs3);
                } else {
                    if (noOfDays == 4) {
                        System.out.println("\n" + "Day 1: ");
                        System.out.print("Enter login time (HH:mm): ");
                        Scanner login1 = new Scanner(System.in);
                        String loginTimeString1 = login1.next();

                        System.out.print("Enter logout time (HH:mm): ");
                        Scanner logout1 = new Scanner(System.in);
                        String logoutTimeString1 = logout1.next();

                        totHrs1 = calculateTotalHoursWorked(loginTimeString1, logoutTimeString1);
                        regHrs1 = calculateRegularHours(totHrs1);
                        otHrs1 = calculateOverTime(totHrs1);

                        System.out.println("\n" + "Day 2: ");
                        System.out.print("Enter login time (HH:mm): ");
                        Scanner login2 = new Scanner(System.in);
                        String loginTimeString2 = login2.next();

                        System.out.print("Enter logout time (HH:mm): ");
                        Scanner logout2 = new Scanner(System.in);
                        String logoutTimeString2 = logout2.next();

                        totHrs2 = calculateTotalHoursWorked(loginTimeString2, logoutTimeString2);
                        regHrs2 = calculateRegularHours(totHrs2);
                        otHrs2 = calculateOverTime(totHrs2);

                        System.out.println("\n" + "Day 3: ");
                        System.out.print("Enter login time (HH:mm): ");
                        Scanner login3 = new Scanner(System.in);
                        String loginTimeString3 = login3.next();

                        System.out.print("Enter logout time (HH:mm): ");
                        Scanner logout3 = new Scanner(System.in);
                        String logoutTimeString3 = logout3.next();

                        totHrs3 = calculateTotalHoursWorked(loginTimeString3, logoutTimeString3);
                        regHrs3 = calculateRegularHours(totHrs3);
                        otHrs3 = calculateOverTime(totHrs3);

                        System.out.println("\n" + "Day 4: ");
                        System.out.print("Enter login time (HH:mm): ");
                        Scanner login4 = new Scanner(System.in);
                        String loginTimeString4 = login4.next();

                        System.out.print("Enter logout time (HH:mm): ");
                        Scanner logout4 = new Scanner(System.in);
                        String logoutTimeString4 = logout4.next();

                        totHrs4 = calculateTotalHoursWorked(loginTimeString4, logoutTimeString4);
                        regHrs4 = calculateRegularHours(totHrs4);
                        otHrs4 = calculateOverTime(totHrs4);
                    } else {
                        if (noOfDays == 5) {
                            System.out.println("\n" + "Day 1: ");
                            System.out.print("Enter login time (HH:mm): ");
                            Scanner login1 = new Scanner(System.in);
                            String loginTimeString1 = login1.next();

                            System.out.print("Enter logout time (HH:mm): ");
                            Scanner logout1 = new Scanner(System.in);
                            String logoutTimeString1 = logout1.next();

                            totHrs1 = calculateTotalHoursWorked(loginTimeString1, logoutTimeString1);
                            regHrs1 = calculateRegularHours(totHrs1);
                            otHrs1 = calculateOverTime(totHrs1);

                            System.out.println("\n" + "Day 2: ");
                            System.out.print("Enter login time (HH:mm): ");
                            Scanner login2 = new Scanner(System.in);
                            String loginTimeString2 = login2.next();

                            System.out.print("Enter logout time (HH:mm): ");
                            Scanner logout2 = new Scanner(System.in);
                            String logoutTimeString2 = logout2.next();

                            totHrs2 = calculateTotalHoursWorked(loginTimeString2, logoutTimeString2);
                            regHrs2 = calculateRegularHours(totHrs2);
                            otHrs2 = calculateOverTime(totHrs2);

                            System.out.println("\n" + "Day 3: ");
                            System.out.print("Enter login time (HH:mm): ");
                            Scanner login3 = new Scanner(System.in);
                            String loginTimeString3 = login3.next();

                            System.out.print("Enter logout time (HH:mm): ");
                            Scanner logout3 = new Scanner(System.in);
                            String logoutTimeString3 = logout3.next();

                            totHrs3 = calculateTotalHoursWorked(loginTimeString3, logoutTimeString3);
                            regHrs3 = calculateRegularHours(totHrs3);
                            otHrs3 = calculateOverTime(totHrs3);

                            System.out.println("\n" + "Day 4: ");
                            System.out.print("Enter login time (HH:mm): ");
                            Scanner login4 = new Scanner(System.in);
                            String loginTimeString4 = login4.next();

                            System.out.print("Enter logout time (HH:mm): ");
                            Scanner logout4 = new Scanner(System.in);
                            String logoutTimeString4 = logout4.next();

                            totHrs4 = calculateTotalHoursWorked(loginTimeString4, logoutTimeString4);
                            regHrs4 = calculateRegularHours(totHrs4);
                            otHrs4 = calculateOverTime(totHrs4);

                            System.out.println("\n" + "Day 5: ");
                            System.out.print("Enter login time (HH:mm): ");
                            Scanner login5 = new Scanner(System.in);
                            String loginTimeString5 = login5.next();

                            System.out.print("Enter logout time (HH:mm): ");
                            Scanner logout5 = new Scanner(System.in);
                            String logoutTimeString5 = logout5.next();

                            totHrs5 = calculateTotalHoursWorked(loginTimeString5, logoutTimeString5);
                            regHrs5 = calculateRegularHours(totHrs5);
                            otHrs5 = calculateOverTime(totHrs5);
                        } else {
                            if (noOfDays == 6) {
                                System.out.println("\n" + "Day 1: ");
                                System.out.print("Enter login time (HH:mm): ");
                                Scanner login1 = new Scanner(System.in);
                                String loginTimeString1 = login1.next();

                                System.out.print("Enter logout time (HH:mm): ");
                                Scanner logout1 = new Scanner(System.in);
                                String logoutTimeString1 = logout1.next();

                                totHrs1 = calculateTotalHoursWorked(loginTimeString1, logoutTimeString1);
                                regHrs1 = calculateRegularHours(totHrs1);
                                otHrs1 = calculateOverTime(totHrs1);

                                System.out.println("\n" + "Day 2: ");
                                System.out.print("Enter login time (HH:mm): ");
                                Scanner login2 = new Scanner(System.in);
                                String loginTimeString2 = login2.next();

                                System.out.print("Enter logout time (HH:mm): ");
                                Scanner logout2 = new Scanner(System.in);
                                String logoutTimeString2 = logout2.next();

                                totHrs2 = calculateTotalHoursWorked(loginTimeString2, logoutTimeString2);
                                regHrs2 = calculateRegularHours(totHrs2);
                                otHrs2 = calculateOverTime(totHrs2);

                                System.out.println("\n" + "Day 3: ");
                                System.out.print("Enter login time (HH:mm): ");
                                Scanner login3 = new Scanner(System.in);
                                String loginTimeString3 = login3.next();

                                System.out.print("Enter logout time (HH:mm): ");
                                Scanner logout3 = new Scanner(System.in);
                                String logoutTimeString3 = logout3.next();

                                totHrs3 = calculateTotalHoursWorked(loginTimeString3, logoutTimeString3);
                                regHrs3 = calculateRegularHours(totHrs3);
                                otHrs3 = calculateOverTime(totHrs3);

                                System.out.println("\n" + "Day 4: ");
                                System.out.print("Enter login time (HH:mm): ");
                                Scanner login4 = new Scanner(System.in);
                                String loginTimeString4 = login4.next();

                                System.out.print("Enter logout time (HH:mm): ");
                                Scanner logout4 = new Scanner(System.in);
                                String logoutTimeString4 = logout4.next();

                                totHrs4 = calculateTotalHoursWorked(loginTimeString4, logoutTimeString4);
                                regHrs4 = calculateRegularHours(totHrs4);
                                otHrs4 = calculateOverTime(totHrs4);

                                System.out.println("\n" + "Day 5: ");
                                System.out.print("Enter login time (HH:mm): ");
                                Scanner login5 = new Scanner(System.in);
                                String loginTimeString5 = login5.next();

                                System.out.print("Enter logout time (HH:mm): ");
                                Scanner logout5 = new Scanner(System.in);
                                String logoutTimeString5 = logout5.next();

                                totHrs5 = calculateTotalHoursWorked(loginTimeString5, logoutTimeString5);
                                regHrs5 = calculateRegularHours(totHrs5);
                                otHrs5 = calculateOverTime(totHrs5);

                                System.out.println("\n" + "Day 6: ");
                                System.out.print("Enter login time (HH:mm): ");
                                Scanner login6 = new Scanner(System.in);
                                String loginTimeString6 = login6.next();

                                System.out.print("Enter logout time (HH:mm): ");
                                Scanner logout6 = new Scanner(System.in);
                                String logoutTimeString6 = logout6.next();

                                totHrs6 = calculateTotalHoursWorked(loginTimeString6, logoutTimeString6);
                                regHrs6 = calculateRegularHours(totHrs6);
                                otHrs6 = calculateOverTime(totHrs6);
                            } else {
                                if (noOfDays == 7) {
                                    System.out.println("\n" + "Day 1: ");
                                    System.out.print("Enter login time (HH:mm): ");
                                    Scanner login1 = new Scanner(System.in);
                                    String loginTimeString1 = login1.next();

                                    System.out.print("Enter logout time (HH:mm): ");
                                    Scanner logout1 = new Scanner(System.in);
                                    String logoutTimeString1 = logout1.next();

                                    totHrs1 = calculateTotalHoursWorked(loginTimeString1, logoutTimeString1);
                                    regHrs1 = calculateRegularHours(totHrs1);
                                    otHrs1 = calculateOverTime(totHrs1);

                                    System.out.println("\n" + "Day 2: ");
                                    System.out.print("Enter login time (HH:mm): ");
                                    Scanner login2 = new Scanner(System.in);
                                    String loginTimeString2 = login2.next();

                                    System.out.print("Enter logout time (HH:mm): ");
                                    Scanner logout2 = new Scanner(System.in);
                                    String logoutTimeString2 = logout2.next();

                                    totHrs2 = calculateTotalHoursWorked(loginTimeString2, logoutTimeString2);
                                    regHrs2 = calculateRegularHours(totHrs2);
                                    otHrs2 = calculateOverTime(totHrs2);

                                    System.out.println("\n" + "Day 3: ");
                                    System.out.print("Enter login time (HH:mm): ");
                                    Scanner login3 = new Scanner(System.in);
                                    String loginTimeString3 = login3.next();

                                    System.out.print("Enter logout time (HH:mm): ");
                                    Scanner logout3 = new Scanner(System.in);
                                    String logoutTimeString3 = logout3.next();

                                    totHrs3 = calculateTotalHoursWorked(loginTimeString3, logoutTimeString3);
                                    regHrs3 = calculateRegularHours(totHrs3);
                                    otHrs3 = calculateOverTime(totHrs3);

                                    System.out.println("\n" + "Day 4: ");
                                    System.out.print("Enter login time (HH:mm): ");
                                    Scanner login4 = new Scanner(System.in);
                                    String loginTimeString4 = login4.next();

                                    System.out.print("Enter logout time (HH:mm): ");
                                    Scanner logout4 = new Scanner(System.in);
                                    String logoutTimeString4 = logout4.next();

                                    totHrs4 = calculateTotalHoursWorked(loginTimeString4, logoutTimeString4);
                                    regHrs4 = calculateRegularHours(totHrs4);
                                    otHrs4 = calculateOverTime(totHrs4);

                                    System.out.println("\n" + "Day 5: ");
                                    System.out.print("Enter login time (HH:mm): ");
                                    Scanner login5 = new Scanner(System.in);
                                    String loginTimeString5 = login5.next();

                                    System.out.print("Enter logout time (HH:mm): ");
                                    Scanner logout5 = new Scanner(System.in);
                                    String logoutTimeString5 = logout5.next();

                                    totHrs5 = calculateTotalHoursWorked(loginTimeString5, logoutTimeString5);
                                    regHrs5 = calculateRegularHours(totHrs5);
                                    otHrs5 = calculateOverTime(totHrs5);

                                    System.out.println("\n" + "Day 6: ");
                                    System.out.print("Enter login time (HH:mm): ");
                                    Scanner login6 = new Scanner(System.in);
                                    String loginTimeString6 = login6.next();

                                    System.out.print("Enter logout time (HH:mm): ");
                                    Scanner logout6 = new Scanner(System.in);
                                    String logoutTimeString6 = logout6.next();

                                    totHrs6 = calculateTotalHoursWorked(loginTimeString6, logoutTimeString6);
                                    regHrs6 = calculateRegularHours(totHrs6);
                                    otHrs6 = calculateOverTime(totHrs6);

                                    System.out.println("\n" + "Day 7: ");
                                    System.out.print("Enter login time (HH:mm): ");
                                    Scanner login7 = new Scanner(System.in);
                                    String loginTimeString7 = login7.next();

                                    System.out.print("Enter logout time (HH:mm): ");
                                    Scanner logout7 = new Scanner(System.in);
                                    String logoutTimeString7 = logout7.next();

                                    totHrs7 = calculateTotalHoursWorked(loginTimeString7, logoutTimeString7);
                                    regHrs7 = calculateRegularHours(totHrs7);
                                    otHrs7 = calculateOverTime(totHrs7);
                                } else {
                                    if (noOfDays == 8) {
                                        System.out.println("\n" + "Day 1: ");
                                        System.out.print("Enter login time (HH:mm): ");
                                        Scanner login1 = new Scanner(System.in);
                                        String loginTimeString1 = login1.next();

                                        System.out.print("Enter logout time (HH:mm): ");
                                        Scanner logout1 = new Scanner(System.in);
                                        String logoutTimeString1 = logout1.next();

                                        totHrs1 = calculateTotalHoursWorked(loginTimeString1, logoutTimeString1);
                                        regHrs1 = calculateRegularHours(totHrs1);
                                        otHrs1 = calculateOverTime(totHrs1);

                                        System.out.println("\n" + "Day 2: ");
                                        System.out.print("Enter login time (HH:mm): ");
                                        Scanner login2 = new Scanner(System.in);
                                        String loginTimeString2 = login2.next();

                                        System.out.print("Enter logout time (HH:mm): ");
                                        Scanner logout2 = new Scanner(System.in);
                                        String logoutTimeString2 = logout2.next();

                                        totHrs2 = calculateTotalHoursWorked(loginTimeString2, logoutTimeString2);
                                        regHrs2 = calculateRegularHours(totHrs2);
                                        otHrs2 = calculateOverTime(totHrs2);

                                        System.out.println("\n" + "Day 3: ");
                                        System.out.print("Enter login time (HH:mm): ");
                                        Scanner login3 = new Scanner(System.in);
                                        String loginTimeString3 = login3.next();

                                        System.out.print("Enter logout time (HH:mm): ");
                                        Scanner logout3 = new Scanner(System.in);
                                        String logoutTimeString3 = logout3.next();

                                        totHrs3 = calculateTotalHoursWorked(loginTimeString3, logoutTimeString3);
                                        regHrs3 = calculateRegularHours(totHrs3);
                                        otHrs3 = calculateOverTime(totHrs3);

                                        System.out.println("\n" + "Day 4: ");
                                        System.out.print("Enter login time (HH:mm): ");
                                        Scanner login4 = new Scanner(System.in);
                                        String loginTimeString4 = login4.next();

                                        System.out.print("Enter logout time (HH:mm): ");
                                        Scanner logout4 = new Scanner(System.in);
                                        String logoutTimeString4 = logout4.next();

                                        totHrs4 = calculateTotalHoursWorked(loginTimeString4, logoutTimeString4);
                                        regHrs4 = calculateRegularHours(totHrs4);
                                        otHrs4 = calculateOverTime(totHrs4);

                                        System.out.println("\n" + "Day 5: ");
                                        System.out.print("Enter login time (HH:mm): ");
                                        Scanner login5 = new Scanner(System.in);
                                        String loginTimeString5 = login5.next();

                                        System.out.print("Enter logout time (HH:mm): ");
                                        Scanner logout5 = new Scanner(System.in);
                                        String logoutTimeString5 = logout5.next();

                                        totHrs5 = calculateTotalHoursWorked(loginTimeString5, logoutTimeString5);
                                        regHrs5 = calculateRegularHours(totHrs5);
                                        otHrs5 = calculateOverTime(totHrs5);

                                        System.out.println("\n" + "Day 6: ");
                                        System.out.print("Enter login time (HH:mm): ");
                                        Scanner login6 = new Scanner(System.in);
                                        String loginTimeString6 = login6.next();

                                        System.out.print("Enter logout time (HH:mm): ");
                                        Scanner logout6 = new Scanner(System.in);
                                        String logoutTimeString6 = logout6.next();

                                        totHrs6 = calculateTotalHoursWorked(loginTimeString6, logoutTimeString6);
                                        regHrs6 = calculateRegularHours(totHrs6);
                                        otHrs6 = calculateOverTime(totHrs6);

                                        System.out.println("\n" + "Day 7: ");
                                        System.out.print("Enter login time (HH:mm): ");
                                        Scanner login7 = new Scanner(System.in);
                                        String loginTimeString7 = login7.next();

                                        System.out.print("Enter logout time (HH:mm): ");
                                        Scanner logout7 = new Scanner(System.in);
                                        String logoutTimeString7 = logout7.next();

                                        totHrs7 = calculateTotalHoursWorked(loginTimeString7, logoutTimeString7);
                                        regHrs7 = calculateRegularHours(totHrs7);
                                        otHrs7 = calculateOverTime(totHrs7);

                                        System.out.println("\n" + "Day 8: ");
                                        System.out.print("Enter login time (HH:mm): ");
                                        Scanner login8 = new Scanner(System.in);
                                        String loginTimeString8 = login8.next();

                                        System.out.print("Enter logout time (HH:mm): ");
                                        Scanner logout8 = new Scanner(System.in);
                                        String logoutTimeString8 = logout8.next();

                                        totHrs8 = calculateTotalHoursWorked(loginTimeString8, logoutTimeString8);
                                        regHrs8 = calculateRegularHours(totHrs8);
                                        otHrs8 = calculateOverTime(totHrs8);
                                    } else {
                                        if (noOfDays == 9) {
                                            System.out.println("\n" + "Day 1: ");
                                            System.out.print("Enter login time (HH:mm): ");
                                            Scanner login1 = new Scanner(System.in);
                                            String loginTimeString1 = login1.next();

                                            System.out.print("Enter logout time (HH:mm): ");
                                            Scanner logout1 = new Scanner(System.in);
                                            String logoutTimeString1 = logout1.next();

                                            totHrs1 = calculateTotalHoursWorked(loginTimeString1, logoutTimeString1);
                                            regHrs1 = calculateRegularHours(totHrs1);
                                            otHrs1 = calculateOverTime(totHrs1);

                                            System.out.println("\n" + "Day 2: ");
                                            System.out.print("Enter login time (HH:mm): ");
                                            Scanner login2 = new Scanner(System.in);
                                            String loginTimeString2 = login2.next();

                                            System.out.print("Enter logout time (HH:mm): ");
                                            Scanner logout2 = new Scanner(System.in);
                                            String logoutTimeString2 = logout2.next();

                                            totHrs2 = calculateTotalHoursWorked(loginTimeString2, logoutTimeString2);
                                            regHrs2 = calculateRegularHours(totHrs2);
                                            otHrs2 = calculateOverTime(totHrs2);

                                            System.out.println("\n" + "Day 3: ");
                                            System.out.print("Enter login time (HH:mm): ");
                                            Scanner login3 = new Scanner(System.in);
                                            String loginTimeString3 = login3.next();

                                            System.out.print("Enter logout time (HH:mm): ");
                                            Scanner logout3 = new Scanner(System.in);
                                            String logoutTimeString3 = logout3.next();

                                            totHrs3 = calculateTotalHoursWorked(loginTimeString3, logoutTimeString3);
                                            regHrs3 = calculateRegularHours(totHrs3);
                                            otHrs3 = calculateOverTime(totHrs3);

                                            System.out.println("\n" + "Day 4: ");
                                            System.out.print("Enter login time (HH:mm): ");
                                            Scanner login4 = new Scanner(System.in);
                                            String loginTimeString4 = login4.next();

                                            System.out.print("Enter logout time (HH:mm): ");
                                            Scanner logout4 = new Scanner(System.in);
                                            String logoutTimeString4 = logout4.next();

                                            totHrs4 = calculateTotalHoursWorked(loginTimeString4, logoutTimeString4);
                                            regHrs4 = calculateRegularHours(totHrs4);
                                            otHrs4 = calculateOverTime(totHrs4);

                                            System.out.println("\n" + "Day 5: ");
                                            System.out.print("Enter login time (HH:mm): ");
                                            Scanner login5 = new Scanner(System.in);
                                            String loginTimeString5 = login5.next();

                                            System.out.print("Enter logout time (HH:mm): ");
                                            Scanner logout5 = new Scanner(System.in);
                                            String logoutTimeString5 = logout5.next();

                                            totHrs5 = calculateTotalHoursWorked(loginTimeString5, logoutTimeString5);
                                            regHrs5 = calculateRegularHours(totHrs5);
                                            otHrs5 = calculateOverTime(totHrs5);

                                            System.out.println("\n" + "Day 6: ");
                                            System.out.print("Enter login time (HH:mm): ");
                                            Scanner login6 = new Scanner(System.in);
                                            String loginTimeString6 = login6.next();

                                            System.out.print("Enter logout time (HH:mm): ");
                                            Scanner logout6 = new Scanner(System.in);
                                            String logoutTimeString6 = logout6.next();

                                            totHrs6 = calculateTotalHoursWorked(loginTimeString6, logoutTimeString6);
                                            regHrs6 = calculateRegularHours(totHrs6);
                                            otHrs6 = calculateOverTime(totHrs6);

                                            System.out.println("\n" + "Day 7: ");
                                            System.out.print("Enter login time (HH:mm): ");
                                            Scanner login7 = new Scanner(System.in);
                                            String loginTimeString7 = login7.next();

                                            System.out.print("Enter logout time (HH:mm): ");
                                            Scanner logout7 = new Scanner(System.in);
                                            String logoutTimeString7 = logout7.next();

                                            totHrs7 = calculateTotalHoursWorked(loginTimeString7, logoutTimeString7);
                                            regHrs7 = calculateRegularHours(totHrs7);
                                            otHrs7 = calculateOverTime(totHrs7);

                                            System.out.println("\n" + "Day 8: ");
                                            System.out.print("Enter login time (HH:mm): ");
                                            Scanner login8 = new Scanner(System.in);
                                            String loginTimeString8 = login8.next();

                                            System.out.print("Enter logout time (HH:mm): ");
                                            Scanner logout8 = new Scanner(System.in);
                                            String logoutTimeString8 = logout8.next();

                                            totHrs8 = calculateTotalHoursWorked(loginTimeString8, logoutTimeString8);
                                            regHrs8 = calculateRegularHours(totHrs8);
                                            otHrs8 = calculateOverTime(totHrs8);

                                            System.out.println("\n" + "Day 9: ");
                                            System.out.print("Enter login time (HH:mm): ");
                                            Scanner login9 = new Scanner(System.in);
                                            String loginTimeString9 = login9.next();

                                            System.out.print("Enter logout time (HH:mm): ");
                                            Scanner logout9 = new Scanner(System.in);
                                            String logoutTimeString9 = logout9.next();

                                            totHrs9 = calculateTotalHoursWorked(loginTimeString9, logoutTimeString9);
                                            regHrs9 = calculateRegularHours(totHrs9);
                                            otHrs9 = calculateOverTime(totHrs9);
                                        } else {
                                            if (noOfDays == 10) {
                                                System.out.println("\n" + "Day 1: ");
                                                System.out.print("Enter login time (HH:mm): ");
                                                Scanner login1 = new Scanner(System.in);
                                                String loginTimeString1 = login1.next();

                                                System.out.print("Enter logout time (HH:mm): ");
                                                Scanner logout1 = new Scanner(System.in);
                                                String logoutTimeString1 = logout1.next();

                                                totHrs1 = calculateTotalHoursWorked(loginTimeString1, logoutTimeString1);
                                                regHrs1 = calculateRegularHours(totHrs1);
                                                otHrs1 = calculateOverTime(totHrs1);

                                                System.out.println("\n" + "Day 2: ");
                                                System.out.print("Enter login time (HH:mm): ");
                                                Scanner login2 = new Scanner(System.in);
                                                String loginTimeString2 = login2.next();

                                                System.out.print("Enter logout time (HH:mm): ");
                                                Scanner logout2 = new Scanner(System.in);
                                                String logoutTimeString2 = logout2.next();

                                                totHrs2 = calculateTotalHoursWorked(loginTimeString2, logoutTimeString2);
                                                regHrs2 = calculateRegularHours(totHrs2);
                                                otHrs2 = calculateOverTime(totHrs2);

                                                System.out.println("\n" + "Day 3: ");
                                                System.out.print("Enter login time (HH:mm): ");
                                                Scanner login3 = new Scanner(System.in);
                                                String loginTimeString3 = login3.next();

                                                System.out.print("Enter logout time (HH:mm): ");
                                                Scanner logout3 = new Scanner(System.in);
                                                String logoutTimeString3 = logout3.next();

                                                totHrs3 = calculateTotalHoursWorked(loginTimeString3, logoutTimeString3);
                                                regHrs3 = calculateRegularHours(totHrs3);
                                                otHrs3 = calculateOverTime(totHrs3);

                                                System.out.println("\n" + "Day 4: ");
                                                System.out.print("Enter login time (HH:mm): ");
                                                Scanner login4 = new Scanner(System.in);
                                                String loginTimeString4 = login4.next();

                                                System.out.print("Enter logout time (HH:mm): ");
                                                Scanner logout4 = new Scanner(System.in);
                                                String logoutTimeString4 = logout4.next();

                                                totHrs4 = calculateTotalHoursWorked(loginTimeString4, logoutTimeString4);
                                                regHrs4 = calculateRegularHours(totHrs4);
                                                otHrs4 = calculateOverTime(totHrs4);

                                                System.out.println("\n" + "Day 5: ");
                                                System.out.print("Enter login time (HH:mm): ");
                                                Scanner login5 = new Scanner(System.in);
                                                String loginTimeString5 = login5.next();

                                                System.out.print("Enter logout time (HH:mm): ");
                                                Scanner logout5 = new Scanner(System.in);
                                                String logoutTimeString5 = logout5.next();

                                                totHrs5 = calculateTotalHoursWorked(loginTimeString5, logoutTimeString5);
                                                regHrs5 = calculateRegularHours(totHrs5);
                                                otHrs5 = calculateOverTime(totHrs5);

                                                System.out.println("\n" + "Day 6: ");
                                                System.out.print("Enter login time (HH:mm): ");
                                                Scanner login6 = new Scanner(System.in);
                                                String loginTimeString6 = login6.next();

                                                System.out.print("Enter logout time (HH:mm): ");
                                                Scanner logout6 = new Scanner(System.in);
                                                String logoutTimeString6 = logout6.next();

                                                totHrs6 = calculateTotalHoursWorked(loginTimeString6, logoutTimeString6);
                                                regHrs6 = calculateRegularHours(totHrs6);
                                                otHrs6 = calculateOverTime(totHrs6);

                                                System.out.println("\n" + "Day 7: ");
                                                System.out.print("Enter login time (HH:mm): ");
                                                Scanner login7 = new Scanner(System.in);
                                                String loginTimeString7 = login7.next();

                                                System.out.print("Enter logout time (HH:mm): ");
                                                Scanner logout7 = new Scanner(System.in);
                                                String logoutTimeString7 = logout7.next();

                                                totHrs7 = calculateTotalHoursWorked(loginTimeString7, logoutTimeString7);
                                                regHrs7 = calculateRegularHours(totHrs7);
                                                otHrs7 = calculateOverTime(totHrs7);

                                                System.out.println("\n" + "Day 8: ");
                                                System.out.print("Enter login time (HH:mm): ");
                                                Scanner login8 = new Scanner(System.in);
                                                String loginTimeString8 = login8.next();

                                                System.out.print("Enter logout time (HH:mm): ");
                                                Scanner logout8 = new Scanner(System.in);
                                                String logoutTimeString8 = logout8.next();

                                                totHrs8 = calculateTotalHoursWorked(loginTimeString8, logoutTimeString8);
                                                regHrs8 = calculateRegularHours(totHrs8);
                                                otHrs8 = calculateOverTime(totHrs8);

                                                System.out.println("\n" + "Day 9: ");
                                                System.out.print("Enter login time (HH:mm): ");
                                                Scanner login9 = new Scanner(System.in);
                                                String loginTimeString9 = login9.next();

                                                System.out.print("Enter logout time (HH:mm): ");
                                                Scanner logout9 = new Scanner(System.in);
                                                String logoutTimeString9 = logout9.next();

                                                totHrs9 = calculateTotalHoursWorked(loginTimeString9, logoutTimeString9);
                                                regHrs9 = calculateRegularHours(totHrs9);
                                                otHrs9 = calculateOverTime(totHrs9);

                                                System.out.println("\n" + "Day 10: ");
                                                System.out.print("Enter login time (HH:mm): ");
                                                Scanner login10 = new Scanner(System.in);
                                                String loginTimeString10 = login10.next();

                                                System.out.print("Enter logout time (HH:mm): ");
                                                Scanner logout10 = new Scanner(System.in);
                                                String logoutTimeString10 = logout10.next();

                                                totHrs10 = calculateTotalHoursWorked(loginTimeString10, logoutTimeString10);
                                                regHrs10 = calculateRegularHours(totHrs10);
                                                otHrs10 = calculateOverTime(totHrs10);
                                            } else {
                                                if (noOfDays == 11) {
                                                    System.out.println("\n" + "Day 1: ");
                                                    System.out.print("Enter login time (HH:mm): ");
                                                    Scanner login1 = new Scanner(System.in);
                                                    String loginTimeString1 = login1.next();

                                                    System.out.print("Enter logout time (HH:mm): ");
                                                    Scanner logout1 = new Scanner(System.in);
                                                    String logoutTimeString1 = logout1.next();

                                                    totHrs1 = calculateTotalHoursWorked(loginTimeString1, logoutTimeString1);
                                                    regHrs1 = calculateRegularHours(totHrs1);
                                                    otHrs1 = calculateOverTime(totHrs1);

                                                    System.out.println("\n" + "Day 2: ");
                                                    System.out.print("Enter login time (HH:mm): ");
                                                    Scanner login2 = new Scanner(System.in);
                                                    String loginTimeString2 = login2.next();

                                                    System.out.print("Enter logout time (HH:mm): ");
                                                    Scanner logout2 = new Scanner(System.in);
                                                    String logoutTimeString2 = logout2.next();

                                                    totHrs2 = calculateTotalHoursWorked(loginTimeString2, logoutTimeString2);
                                                    regHrs2 = calculateRegularHours(totHrs2);
                                                    otHrs2 = calculateOverTime(totHrs2);

                                                    System.out.println("\n" + "Day 3: ");
                                                    System.out.print("Enter login time (HH:mm): ");
                                                    Scanner login3 = new Scanner(System.in);
                                                    String loginTimeString3 = login3.next();

                                                    System.out.print("Enter logout time (HH:mm): ");
                                                    Scanner logout3 = new Scanner(System.in);
                                                    String logoutTimeString3 = logout3.next();

                                                    totHrs3 = calculateTotalHoursWorked(loginTimeString3, logoutTimeString3);
                                                    regHrs3 = calculateRegularHours(totHrs3);
                                                    otHrs3 = calculateOverTime(totHrs3);

                                                    System.out.println("\n" + "Day 4: ");
                                                    System.out.print("Enter login time (HH:mm): ");
                                                    Scanner login4 = new Scanner(System.in);
                                                    String loginTimeString4 = login4.next();

                                                    System.out.print("Enter logout time (HH:mm): ");
                                                    Scanner logout4 = new Scanner(System.in);
                                                    String logoutTimeString4 = logout4.next();

                                                    totHrs4 = calculateTotalHoursWorked(loginTimeString4, logoutTimeString4);
                                                    regHrs4 = calculateRegularHours(totHrs4);
                                                    otHrs4 = calculateOverTime(totHrs4);

                                                    System.out.println("\n" + "Day 5: ");
                                                    System.out.print("Enter login time (HH:mm): ");
                                                    Scanner login5 = new Scanner(System.in);
                                                    String loginTimeString5 = login5.next();

                                                    System.out.print("Enter logout time (HH:mm): ");
                                                    Scanner logout5 = new Scanner(System.in);
                                                    String logoutTimeString5 = logout5.next();

                                                    totHrs5 = calculateTotalHoursWorked(loginTimeString5, logoutTimeString5);
                                                    regHrs5 = calculateRegularHours(totHrs5);
                                                    otHrs5 = calculateOverTime(totHrs5);

                                                    System.out.println("\n" + "Day 6: ");
                                                    System.out.print("Enter login time (HH:mm): ");
                                                    Scanner login6 = new Scanner(System.in);
                                                    String loginTimeString6 = login6.next();

                                                    System.out.print("Enter logout time (HH:mm): ");
                                                    Scanner logout6 = new Scanner(System.in);
                                                    String logoutTimeString6 = logout6.next();

                                                    totHrs6 = calculateTotalHoursWorked(loginTimeString6, logoutTimeString6);
                                                    regHrs6 = calculateRegularHours(totHrs6);
                                                    otHrs6 = calculateOverTime(totHrs6);

                                                    System.out.println("\n" + "Day 7: ");
                                                    System.out.print("Enter login time (HH:mm): ");
                                                    Scanner login7 = new Scanner(System.in);
                                                    String loginTimeString7 = login7.next();

                                                    System.out.print("Enter logout time (HH:mm): ");
                                                    Scanner logout7 = new Scanner(System.in);
                                                    String logoutTimeString7 = logout7.next();

                                                    totHrs7 = calculateTotalHoursWorked(loginTimeString7, logoutTimeString7);
                                                    regHrs7 = calculateRegularHours(totHrs7);
                                                    otHrs7 = calculateOverTime(totHrs7);

                                                    System.out.println("\n" + "Day 8: ");
                                                    System.out.print("Enter login time (HH:mm): ");
                                                    Scanner login8 = new Scanner(System.in);
                                                    String loginTimeString8 = login8.next();

                                                    System.out.print("Enter logout time (HH:mm): ");
                                                    Scanner logout8 = new Scanner(System.in);
                                                    String logoutTimeString8 = logout8.next();

                                                    totHrs8 = calculateTotalHoursWorked(loginTimeString8, logoutTimeString8);
                                                    regHrs8 = calculateRegularHours(totHrs8);
                                                    otHrs8 = calculateOverTime(totHrs8);

                                                    System.out.println("\n" + "Day 9: ");
                                                    System.out.print("Enter login time (HH:mm): ");
                                                    Scanner login9 = new Scanner(System.in);
                                                    String loginTimeString9 = login9.next();

                                                    System.out.print("Enter logout time (HH:mm): ");
                                                    Scanner logout9 = new Scanner(System.in);
                                                    String logoutTimeString9 = logout9.next();

                                                    totHrs9 = calculateTotalHoursWorked(loginTimeString9, logoutTimeString9);
                                                    regHrs9 = calculateRegularHours(totHrs9);
                                                    otHrs9 = calculateOverTime(totHrs9);

                                                    System.out.println("\n" + "Day 10: ");
                                                    System.out.print("Enter login time (HH:mm): ");
                                                    Scanner login10 = new Scanner(System.in);
                                                    String loginTimeString10 = login10.next();

                                                    System.out.print("Enter logout time (HH:mm): ");
                                                    Scanner logout10 = new Scanner(System.in);
                                                    String logoutTimeString10 = logout10.next();

                                                    totHrs10 = calculateTotalHoursWorked(loginTimeString10, logoutTimeString10);
                                                    regHrs10 = calculateRegularHours(totHrs10);
                                                    otHrs10 = calculateOverTime(totHrs10);

                                                    System.out.println("\n" + "Day 11: ");
                                                    System.out.print("Enter login time (HH:mm): ");
                                                    Scanner login11 = new Scanner(System.in);
                                                    String loginTimeString11 = login11.next();

                                                    System.out.print("Enter logout time (HH:mm): ");
                                                    Scanner logout11 = new Scanner(System.in);
                                                    String logoutTimeString11 = logout11.next();

                                                    totHrs11 = calculateTotalHoursWorked(loginTimeString11, logoutTimeString11);
                                                    regHrs11 = calculateRegularHours(totHrs11);
                                                    otHrs11 = calculateOverTime(totHrs11);
                                                } else {
                                                    if (noOfDays == 12) {
                                                        System.out.println("\n" + "Day 1: ");
                                                        System.out.print("Enter login time (HH:mm): ");
                                                        Scanner login1 = new Scanner(System.in);
                                                        String loginTimeString1 = login1.next();

                                                        System.out.print("Enter logout time (HH:mm): ");
                                                        Scanner logout1 = new Scanner(System.in);
                                                        String logoutTimeString1 = logout1.next();

                                                        totHrs1 = calculateTotalHoursWorked(loginTimeString1, logoutTimeString1);
                                                        regHrs1 = calculateRegularHours(totHrs1);
                                                        otHrs1 = calculateOverTime(totHrs1);

                                                        System.out.println("\n" + "Day 2: ");
                                                        System.out.print("Enter login time (HH:mm): ");
                                                        Scanner login2 = new Scanner(System.in);
                                                        String loginTimeString2 = login2.next();

                                                        System.out.print("Enter logout time (HH:mm): ");
                                                        Scanner logout2 = new Scanner(System.in);
                                                        String logoutTimeString2 = logout2.next();

                                                        totHrs2 = calculateTotalHoursWorked(loginTimeString2, logoutTimeString2);
                                                        regHrs2 = calculateRegularHours(totHrs2);
                                                        otHrs2 = calculateOverTime(totHrs2);

                                                        System.out.println("\n" + "Day 3: ");
                                                        System.out.print("Enter login time (HH:mm): ");
                                                        Scanner login3 = new Scanner(System.in);
                                                        String loginTimeString3 = login3.next();

                                                        System.out.print("Enter logout time (HH:mm): ");
                                                        Scanner logout3 = new Scanner(System.in);
                                                        String logoutTimeString3 = logout3.next();

                                                        totHrs3 = calculateTotalHoursWorked(loginTimeString3, logoutTimeString3);
                                                        regHrs3 = calculateRegularHours(totHrs3);
                                                        otHrs3 = calculateOverTime(totHrs3);

                                                        System.out.println("\n" + "Day 4: ");
                                                        System.out.print("Enter login time (HH:mm): ");
                                                        Scanner login4 = new Scanner(System.in);
                                                        String loginTimeString4 = login4.next();

                                                        System.out.print("Enter logout time (HH:mm): ");
                                                        Scanner logout4 = new Scanner(System.in);
                                                        String logoutTimeString4 = logout4.next();

                                                        totHrs4 = calculateTotalHoursWorked(loginTimeString4, logoutTimeString4);
                                                        regHrs4 = calculateRegularHours(totHrs4);
                                                        otHrs4 = calculateOverTime(totHrs4);

                                                        System.out.println("\n" + "Day 5: ");
                                                        System.out.print("Enter login time (HH:mm): ");
                                                        Scanner login5 = new Scanner(System.in);
                                                        String loginTimeString5 = login5.next();

                                                        System.out.print("Enter logout time (HH:mm): ");
                                                        Scanner logout5 = new Scanner(System.in);
                                                        String logoutTimeString5 = logout5.next();

                                                        totHrs5 = calculateTotalHoursWorked(loginTimeString5, logoutTimeString5);
                                                        regHrs5 = calculateRegularHours(totHrs5);
                                                        otHrs5 = calculateOverTime(totHrs5);

                                                        System.out.println("\n" + "Day 6: ");
                                                        System.out.print("Enter login time (HH:mm): ");
                                                        Scanner login6 = new Scanner(System.in);
                                                        String loginTimeString6 = login6.next();

                                                        System.out.print("Enter logout time (HH:mm): ");
                                                        Scanner logout6 = new Scanner(System.in);
                                                        String logoutTimeString6 = logout6.next();

                                                        totHrs6 = calculateTotalHoursWorked(loginTimeString6, logoutTimeString6);
                                                        regHrs6 = calculateRegularHours(totHrs6);
                                                        otHrs6 = calculateOverTime(totHrs6);

                                                        System.out.println("\n" + "Day 7: ");
                                                        System.out.print("Enter login time (HH:mm): ");
                                                        Scanner login7 = new Scanner(System.in);
                                                        String loginTimeString7 = login7.next();

                                                        System.out.print("Enter logout time (HH:mm): ");
                                                        Scanner logout7 = new Scanner(System.in);
                                                        String logoutTimeString7 = logout7.next();

                                                        totHrs7 = calculateTotalHoursWorked(loginTimeString7, logoutTimeString7);
                                                        regHrs7 = calculateRegularHours(totHrs7);
                                                        otHrs7 = calculateOverTime(totHrs7);

                                                        System.out.println("\n" + "Day 8: ");
                                                        System.out.print("Enter login time (HH:mm): ");
                                                        Scanner login8 = new Scanner(System.in);
                                                        String loginTimeString8 = login8.next();

                                                        System.out.print("Enter logout time (HH:mm): ");
                                                        Scanner logout8 = new Scanner(System.in);
                                                        String logoutTimeString8 = logout8.next();

                                                        totHrs8 = calculateTotalHoursWorked(loginTimeString8, logoutTimeString8);
                                                        regHrs8 = calculateRegularHours(totHrs8);
                                                        otHrs8 = calculateOverTime(totHrs8);

                                                        System.out.println("\n" + "Day 9: ");
                                                        System.out.print("Enter login time (HH:mm): ");
                                                        Scanner login9 = new Scanner(System.in);
                                                        String loginTimeString9 = login9.next();

                                                        System.out.print("Enter logout time (HH:mm): ");
                                                        Scanner logout9 = new Scanner(System.in);
                                                        String logoutTimeString9 = logout9.next();

                                                        totHrs9 = calculateTotalHoursWorked(loginTimeString9, logoutTimeString9);
                                                        regHrs9 = calculateRegularHours(totHrs9);
                                                        otHrs9 = calculateOverTime(totHrs9);

                                                        System.out.println("\n" + "Day 10: ");
                                                        System.out.print("Enter login time (HH:mm): ");
                                                        Scanner login10 = new Scanner(System.in);
                                                        String loginTimeString10 = login10.next();

                                                        System.out.print("Enter logout time (HH:mm): ");
                                                        Scanner logout10 = new Scanner(System.in);
                                                        String logoutTimeString10 = logout10.next();

                                                        totHrs10 = calculateTotalHoursWorked(loginTimeString10, logoutTimeString10);
                                                        regHrs10 = calculateRegularHours(totHrs10);
                                                        otHrs10 = calculateOverTime(totHrs10);

                                                        System.out.println("\n" + "Day 11: ");
                                                        System.out.print("Enter login time (HH:mm): ");
                                                        Scanner login11 = new Scanner(System.in);
                                                        String loginTimeString11 = login11.next();

                                                        System.out.print("Enter logout time (HH:mm): ");
                                                        Scanner logout11 = new Scanner(System.in);
                                                        String logoutTimeString11 = logout11.next();

                                                        totHrs11 = calculateTotalHoursWorked(loginTimeString11, logoutTimeString11);
                                                        regHrs11 = calculateRegularHours(totHrs11);
                                                        otHrs11 = calculateOverTime(totHrs11);

                                                        System.out.println("\n" + "Day 12: ");
                                                        System.out.print("Enter login time (HH:mm): ");
                                                        Scanner login12 = new Scanner(System.in);
                                                        String loginTimeString12 = login12.next();

                                                        System.out.print("Enter logout time (HH:mm): ");
                                                        Scanner logout12 = new Scanner(System.in);
                                                        String logoutTimeString12 = logout12.next();

                                                        totHrs12 = calculateTotalHoursWorked(loginTimeString12, logoutTimeString12);
                                                        regHrs12 = calculateRegularHours(totHrs12);
                                                        otHrs12 = calculateOverTime(totHrs12);
                                                    } else {
                                                        if (noOfDays == 13) {
                                                            System.out.println("\n" + "Day 1: ");
                                                            System.out.print("Enter login time (HH:mm): ");
                                                            Scanner login1 = new Scanner(System.in);
                                                            String loginTimeString1 = login1.next();

                                                            System.out.print("Enter logout time (HH:mm): ");
                                                            Scanner logout1 = new Scanner(System.in);
                                                            String logoutTimeString1 = logout1.next();

                                                            totHrs1 = calculateTotalHoursWorked(loginTimeString1, logoutTimeString1);
                                                            regHrs1 = calculateRegularHours(totHrs1);
                                                            otHrs1 = calculateOverTime(totHrs1);

                                                            System.out.println("\n" + "Day 2: ");
                                                            System.out.print("Enter login time (HH:mm): ");
                                                            Scanner login2 = new Scanner(System.in);
                                                            String loginTimeString2 = login2.next();

                                                            System.out.print("Enter logout time (HH:mm): ");
                                                            Scanner logout2 = new Scanner(System.in);
                                                            String logoutTimeString2 = logout2.next();

                                                            totHrs2 = calculateTotalHoursWorked(loginTimeString2, logoutTimeString2);
                                                            regHrs2 = calculateRegularHours(totHrs2);
                                                            otHrs2 = calculateOverTime(totHrs2);

                                                            System.out.println("\n" + "Day 3: ");
                                                            System.out.print("Enter login time (HH:mm): ");
                                                            Scanner login3 = new Scanner(System.in);
                                                            String loginTimeString3 = login3.next();

                                                            System.out.print("Enter logout time (HH:mm): ");
                                                            Scanner logout3 = new Scanner(System.in);
                                                            String logoutTimeString3 = logout3.next();

                                                            totHrs3 = calculateTotalHoursWorked(loginTimeString3, logoutTimeString3);
                                                            regHrs3 = calculateRegularHours(totHrs3);
                                                            otHrs3 = calculateOverTime(totHrs3);

                                                            System.out.println("\n" + "Day 4: ");
                                                            System.out.print("Enter login time (HH:mm): ");
                                                            Scanner login4 = new Scanner(System.in);
                                                            String loginTimeString4 = login4.next();

                                                            System.out.print("Enter logout time (HH:mm): ");
                                                            Scanner logout4 = new Scanner(System.in);
                                                            String logoutTimeString4 = logout4.next();

                                                            totHrs4 = calculateTotalHoursWorked(loginTimeString4, logoutTimeString4);
                                                            regHrs4 = calculateRegularHours(totHrs4);
                                                            otHrs4 = calculateOverTime(totHrs4);

                                                            System.out.println("\n" + "Day 5: ");
                                                            System.out.print("Enter login time (HH:mm): ");
                                                            Scanner login5 = new Scanner(System.in);
                                                            String loginTimeString5 = login5.next();

                                                            System.out.print("Enter logout time (HH:mm): ");
                                                            Scanner logout5 = new Scanner(System.in);
                                                            String logoutTimeString5 = logout5.next();

                                                            totHrs5 = calculateTotalHoursWorked(loginTimeString5, logoutTimeString5);
                                                            regHrs5 = calculateRegularHours(totHrs5);
                                                            otHrs5 = calculateOverTime(totHrs5);

                                                            System.out.println("\n" + "Day 6: ");
                                                            System.out.print("Enter login time (HH:mm): ");
                                                            Scanner login6 = new Scanner(System.in);
                                                            String loginTimeString6 = login6.next();

                                                            System.out.print("Enter logout time (HH:mm): ");
                                                            Scanner logout6 = new Scanner(System.in);
                                                            String logoutTimeString6 = logout6.next();

                                                            totHrs6 = calculateTotalHoursWorked(loginTimeString6, logoutTimeString6);
                                                            regHrs6 = calculateRegularHours(totHrs6);
                                                            otHrs6 = calculateOverTime(totHrs6);

                                                            System.out.println("\n" + "Day 7: ");
                                                            System.out.print("Enter login time (HH:mm): ");
                                                            Scanner login7 = new Scanner(System.in);
                                                            String loginTimeString7 = login7.next();

                                                            System.out.print("Enter logout time (HH:mm): ");
                                                            Scanner logout7 = new Scanner(System.in);
                                                            String logoutTimeString7 = logout7.next();

                                                            totHrs7 = calculateTotalHoursWorked(loginTimeString7, logoutTimeString7);
                                                            regHrs7 = calculateRegularHours(totHrs7);
                                                            otHrs7 = calculateOverTime(totHrs7);

                                                            System.out.println("\n" + "Day 8: ");
                                                            System.out.print("Enter login time (HH:mm): ");
                                                            Scanner login8 = new Scanner(System.in);
                                                            String loginTimeString8 = login8.next();

                                                            System.out.print("Enter logout time (HH:mm): ");
                                                            Scanner logout8 = new Scanner(System.in);
                                                            String logoutTimeString8 = logout8.next();

                                                            totHrs8 = calculateTotalHoursWorked(loginTimeString8, logoutTimeString8);
                                                            regHrs8 = calculateRegularHours(totHrs8);
                                                            otHrs8 = calculateOverTime(totHrs8);

                                                            System.out.println("\n" + "Day 9: ");
                                                            System.out.print("Enter login time (HH:mm): ");
                                                            Scanner login9 = new Scanner(System.in);
                                                            String loginTimeString9 = login9.next();

                                                            System.out.print("Enter logout time (HH:mm): ");
                                                            Scanner logout9 = new Scanner(System.in);
                                                            String logoutTimeString9 = logout9.next();

                                                            totHrs9 = calculateTotalHoursWorked(loginTimeString9, logoutTimeString9);
                                                            regHrs9 = calculateRegularHours(totHrs9);
                                                            otHrs9 = calculateOverTime(totHrs9);

                                                            System.out.println("\n" + "Day 10: ");
                                                            System.out.print("Enter login time (HH:mm): ");
                                                            Scanner login10 = new Scanner(System.in);
                                                            String loginTimeString10 = login10.next();

                                                            System.out.print("Enter logout time (HH:mm): ");
                                                            Scanner logout10 = new Scanner(System.in);
                                                            String logoutTimeString10 = logout10.next();

                                                            totHrs10 = calculateTotalHoursWorked(loginTimeString10, logoutTimeString10);
                                                            regHrs10 = calculateRegularHours(totHrs10);
                                                            otHrs10 = calculateOverTime(totHrs10);

                                                            System.out.println("\n" + "Day 11: ");
                                                            System.out.print("Enter login time (HH:mm): ");
                                                            Scanner login11 = new Scanner(System.in);
                                                            String loginTimeString11 = login11.next();

                                                            System.out.print("Enter logout time (HH:mm): ");
                                                            Scanner logout11 = new Scanner(System.in);
                                                            String logoutTimeString11 = logout11.next();

                                                            totHrs11 = calculateTotalHoursWorked(loginTimeString11, logoutTimeString11);
                                                            regHrs11 = calculateRegularHours(totHrs11);
                                                            otHrs11 = calculateOverTime(totHrs11);

                                                            System.out.println("\n" + "Day 12: ");
                                                            System.out.print("Enter login time (HH:mm): ");
                                                            Scanner login12 = new Scanner(System.in);
                                                            String loginTimeString12 = login12.next();

                                                            System.out.print("Enter logout time (HH:mm): ");
                                                            Scanner logout12 = new Scanner(System.in);
                                                            String logoutTimeString12 = logout12.next();

                                                            totHrs12 = calculateTotalHoursWorked(loginTimeString12, logoutTimeString12);
                                                            regHrs12 = calculateRegularHours(totHrs12);
                                                            otHrs12 = calculateOverTime(totHrs12);

                                                            System.out.println("\n" + "Day 13: ");
                                                            System.out.print("Enter login time (HH:mm): ");
                                                            Scanner login13 = new Scanner(System.in);
                                                            String loginTimeString13 = login13.next();

                                                            System.out.print("Enter logout time (HH:mm): ");
                                                            Scanner logout13 = new Scanner(System.in);
                                                            String logoutTimeString13 = logout13.next();

                                                            totHrs13 = calculateTotalHoursWorked(loginTimeString13, logoutTimeString13);
                                                            regHrs13 = calculateRegularHours(totHrs13);
                                                            otHrs13 = calculateOverTime(totHrs13);
                                                        } else {
                                                            if (noOfDays == 14) {
                                                                System.out.println("\n" + "Day 1: ");
                                                                System.out.print("Enter login time (HH:mm): ");
                                                                Scanner login1 = new Scanner(System.in);
                                                                String loginTimeString1 = login1.next();

                                                                System.out.print("Enter logout time (HH:mm): ");
                                                                Scanner logout1 = new Scanner(System.in);
                                                                String logoutTimeString1 = logout1.next();

                                                                totHrs1 = calculateTotalHoursWorked(loginTimeString1, logoutTimeString1);
                                                                regHrs1 = calculateRegularHours(totHrs1);
                                                                otHrs1 = calculateOverTime(totHrs1);

                                                                System.out.println("\n" + "Day 2: ");
                                                                System.out.print("Enter login time (HH:mm): ");
                                                                Scanner login2 = new Scanner(System.in);
                                                                String loginTimeString2 = login2.next();

                                                                System.out.print("Enter logout time (HH:mm): ");
                                                                Scanner logout2 = new Scanner(System.in);
                                                                String logoutTimeString2 = logout2.next();

                                                                totHrs2 = calculateTotalHoursWorked(loginTimeString2, logoutTimeString2);
                                                                regHrs2 = calculateRegularHours(totHrs2);
                                                                otHrs2 = calculateOverTime(totHrs2);

                                                                System.out.println("\n" + "Day 3: ");
                                                                System.out.print("Enter login time (HH:mm): ");
                                                                Scanner login3 = new Scanner(System.in);
                                                                String loginTimeString3 = login3.next();

                                                                System.out.print("Enter logout time (HH:mm): ");
                                                                Scanner logout3 = new Scanner(System.in);
                                                                String logoutTimeString3 = logout3.next();

                                                                totHrs3 = calculateTotalHoursWorked(loginTimeString3, logoutTimeString3);
                                                                regHrs3 = calculateRegularHours(totHrs3);
                                                                otHrs3 = calculateOverTime(totHrs3);

                                                                System.out.println("\n" + "Day 4: ");
                                                                System.out.print("Enter login time (HH:mm): ");
                                                                Scanner login4 = new Scanner(System.in);
                                                                String loginTimeString4 = login4.next();

                                                                System.out.print("Enter logout time (HH:mm): ");
                                                                Scanner logout4 = new Scanner(System.in);
                                                                String logoutTimeString4 = logout4.next();

                                                                totHrs4 = calculateTotalHoursWorked(loginTimeString4, logoutTimeString4);
                                                                regHrs4 = calculateRegularHours(totHrs4);
                                                                otHrs4 = calculateOverTime(totHrs4);

                                                                System.out.println("\n" + "Day 5: ");
                                                                System.out.print("Enter login time (HH:mm): ");
                                                                Scanner login5 = new Scanner(System.in);
                                                                String loginTimeString5 = login5.next();

                                                                System.out.print("Enter logout time (HH:mm): ");
                                                                Scanner logout5 = new Scanner(System.in);
                                                                String logoutTimeString5 = logout5.next();

                                                                totHrs5 = calculateTotalHoursWorked(loginTimeString5, logoutTimeString5);
                                                                regHrs5 = calculateRegularHours(totHrs5);
                                                                otHrs5 = calculateOverTime(totHrs5);

                                                                System.out.println("\n" + "Day 6: ");
                                                                System.out.print("Enter login time (HH:mm): ");
                                                                Scanner login6 = new Scanner(System.in);
                                                                String loginTimeString6 = login6.next();

                                                                System.out.print("Enter logout time (HH:mm): ");
                                                                Scanner logout6 = new Scanner(System.in);
                                                                String logoutTimeString6 = logout6.next();

                                                                totHrs6 = calculateTotalHoursWorked(loginTimeString6, logoutTimeString6);
                                                                regHrs6 = calculateRegularHours(totHrs6);
                                                                otHrs6 = calculateOverTime(totHrs6);

                                                                System.out.println("\n" + "Day 7: ");
                                                                System.out.print("Enter login time (HH:mm): ");
                                                                Scanner login7 = new Scanner(System.in);
                                                                String loginTimeString7 = login7.next();

                                                                System.out.print("Enter logout time (HH:mm): ");
                                                                Scanner logout7 = new Scanner(System.in);
                                                                String logoutTimeString7 = logout7.next();

                                                                totHrs7 = calculateTotalHoursWorked(loginTimeString7, logoutTimeString7);
                                                                regHrs7 = calculateRegularHours(totHrs7);
                                                                otHrs7 = calculateOverTime(totHrs7);

                                                                System.out.println("\n" + "Day 8: ");
                                                                System.out.print("Enter login time (HH:mm): ");
                                                                Scanner login8 = new Scanner(System.in);
                                                                String loginTimeString8 = login8.next();

                                                                System.out.print("Enter logout time (HH:mm): ");
                                                                Scanner logout8 = new Scanner(System.in);
                                                                String logoutTimeString8 = logout8.next();

                                                                totHrs8 = calculateTotalHoursWorked(loginTimeString8, logoutTimeString8);
                                                                regHrs8 = calculateRegularHours(totHrs8);
                                                                otHrs8 = calculateOverTime(totHrs8);

                                                                System.out.println("\n" + "Day 9: ");
                                                                System.out.print("Enter login time (HH:mm): ");
                                                                Scanner login9 = new Scanner(System.in);
                                                                String loginTimeString9 = login9.next();

                                                                System.out.print("Enter logout time (HH:mm): ");
                                                                Scanner logout9 = new Scanner(System.in);
                                                                String logoutTimeString9 = logout9.next();

                                                                totHrs9 = calculateTotalHoursWorked(loginTimeString9, logoutTimeString9);
                                                                regHrs9 = calculateRegularHours(totHrs9);
                                                                otHrs9 = calculateOverTime(totHrs9);

                                                                System.out.println("\n" + "Day 10: ");
                                                                System.out.print("Enter login time (HH:mm): ");
                                                                Scanner login10 = new Scanner(System.in);
                                                                String loginTimeString10 = login10.next();

                                                                System.out.print("Enter logout time (HH:mm): ");
                                                                Scanner logout10 = new Scanner(System.in);
                                                                String logoutTimeString10 = logout10.next();

                                                                totHrs10 = calculateTotalHoursWorked(loginTimeString10, logoutTimeString10);
                                                                regHrs10 = calculateRegularHours(totHrs10);
                                                                otHrs10 = calculateOverTime(totHrs10);

                                                                System.out.println("\n" + "Day 11: ");
                                                                System.out.print("Enter login time (HH:mm): ");
                                                                Scanner login11 = new Scanner(System.in);
                                                                String loginTimeString11 = login11.next();

                                                                System.out.print("Enter logout time (HH:mm): ");
                                                                Scanner logout11 = new Scanner(System.in);
                                                                String logoutTimeString11 = logout11.next();

                                                                totHrs11 = calculateTotalHoursWorked(loginTimeString11, logoutTimeString11);
                                                                regHrs11 = calculateRegularHours(totHrs11);
                                                                otHrs11 = calculateOverTime(totHrs11);

                                                                System.out.println("\n" + "Day 12: ");
                                                                System.out.print("Enter login time (HH:mm): ");
                                                                Scanner login12 = new Scanner(System.in);
                                                                String loginTimeString12 = login12.next();

                                                                System.out.print("Enter logout time (HH:mm): ");
                                                                Scanner logout12 = new Scanner(System.in);
                                                                String logoutTimeString12 = logout12.next();

                                                                totHrs12 = calculateTotalHoursWorked(loginTimeString12, logoutTimeString12);
                                                                regHrs12 = calculateRegularHours(totHrs12);
                                                                otHrs12 = calculateOverTime(totHrs12);

                                                                System.out.println("\n" + "Day 13: ");
                                                                System.out.print("Enter login time (HH:mm): ");
                                                                Scanner login13 = new Scanner(System.in);
                                                                String loginTimeString13 = login13.next();

                                                                System.out.print("Enter logout time (HH:mm): ");
                                                                Scanner logout13 = new Scanner(System.in);
                                                                String logoutTimeString13 = logout13.next();

                                                                totHrs13 = calculateTotalHoursWorked(loginTimeString13, logoutTimeString13);
                                                                regHrs13 = calculateRegularHours(totHrs13);
                                                                otHrs13 = calculateOverTime(totHrs13);

                                                                System.out.println("\n" + "Day 14: ");
                                                                System.out.print("Enter login time (HH:mm): ");
                                                                Scanner login14 = new Scanner(System.in);
                                                                String loginTimeString14 = login14.next();

                                                                System.out.print("Enter logout time (HH:mm): ");
                                                                Scanner logout14 = new Scanner(System.in);
                                                                String logoutTimeString14 = logout14.next();

                                                                totHrs14 = calculateTotalHoursWorked(loginTimeString14, logoutTimeString14);
                                                                regHrs14 = calculateRegularHours(totHrs14);
                                                                otHrs14 = calculateOverTime(totHrs14);
                                                            } else {
                                                                if (noOfDays == 15) {
                                                                    System.out.println("\n" + "Day 1: ");
                                                                    System.out.print("Enter login time (HH:mm): ");
                                                                    Scanner login1 = new Scanner(System.in);
                                                                    String loginTimeString1 = login1.next();

                                                                    System.out.print("Enter logout time (HH:mm): ");
                                                                    Scanner logout1 = new Scanner(System.in);
                                                                    String logoutTimeString1 = logout1.next();

                                                                    totHrs1 = calculateTotalHoursWorked(loginTimeString1, logoutTimeString1);
                                                                    regHrs1 = calculateRegularHours(totHrs1);
                                                                    otHrs1 = calculateOverTime(totHrs1);

                                                                    System.out.println("\n" + "Day 2: ");
                                                                    System.out.print("Enter login time (HH:mm): ");
                                                                    Scanner login2 = new Scanner(System.in);
                                                                    String loginTimeString2 = login2.next();

                                                                    System.out.print("Enter logout time (HH:mm): ");
                                                                    Scanner logout2 = new Scanner(System.in);
                                                                    String logoutTimeString2 = logout2.next();

                                                                    totHrs2 = calculateTotalHoursWorked(loginTimeString2, logoutTimeString2);
                                                                    regHrs2 = calculateRegularHours(totHrs2);
                                                                    otHrs2 = calculateOverTime(totHrs2);

                                                                    System.out.println("\n" + "Day 3: ");
                                                                    System.out.print("Enter login time (HH:mm): ");
                                                                    Scanner login3 = new Scanner(System.in);
                                                                    String loginTimeString3 = login3.next();

                                                                    System.out.print("Enter logout time (HH:mm): ");
                                                                    Scanner logout3 = new Scanner(System.in);
                                                                    String logoutTimeString3 = logout3.next();

                                                                    totHrs3 = calculateTotalHoursWorked(loginTimeString3, logoutTimeString3);
                                                                    regHrs3 = calculateRegularHours(totHrs3);
                                                                    otHrs3 = calculateOverTime(totHrs3);

                                                                    System.out.println("\n" + "Day 4: ");
                                                                    System.out.print("Enter login time (HH:mm): ");
                                                                    Scanner login4 = new Scanner(System.in);
                                                                    String loginTimeString4 = login4.next();

                                                                    System.out.print("Enter logout time (HH:mm): ");
                                                                    Scanner logout4 = new Scanner(System.in);
                                                                    String logoutTimeString4 = logout4.next();

                                                                    totHrs4 = calculateTotalHoursWorked(loginTimeString4, logoutTimeString4);
                                                                    regHrs4 = calculateRegularHours(totHrs4);
                                                                    otHrs4 = calculateOverTime(totHrs4);

                                                                    System.out.println("\n" + "Day 5: ");
                                                                    System.out.print("Enter login time (HH:mm): ");
                                                                    Scanner login5 = new Scanner(System.in);
                                                                    String loginTimeString5 = login5.next();

                                                                    System.out.print("Enter logout time (HH:mm): ");
                                                                    Scanner logout5 = new Scanner(System.in);
                                                                    String logoutTimeString5 = logout5.next();

                                                                    totHrs5 = calculateTotalHoursWorked(loginTimeString5, logoutTimeString5);
                                                                    regHrs5 = calculateRegularHours(totHrs5);
                                                                    otHrs5 = calculateOverTime(totHrs5);

                                                                    System.out.println("\n" + "Day 6: ");
                                                                    System.out.print("Enter login time (HH:mm): ");
                                                                    Scanner login6 = new Scanner(System.in);
                                                                    String loginTimeString6 = login6.next();

                                                                    System.out.print("Enter logout time (HH:mm): ");
                                                                    Scanner logout6 = new Scanner(System.in);
                                                                    String logoutTimeString6 = logout6.next();

                                                                    totHrs6 = calculateTotalHoursWorked(loginTimeString6, logoutTimeString6);
                                                                    regHrs6 = calculateRegularHours(totHrs6);
                                                                    otHrs6 = calculateOverTime(totHrs6);

                                                                    System.out.println("\n" + "Day 7: ");
                                                                    System.out.print("Enter login time (HH:mm): ");
                                                                    Scanner login7 = new Scanner(System.in);
                                                                    String loginTimeString7 = login7.next();

                                                                    System.out.print("Enter logout time (HH:mm): ");
                                                                    Scanner logout7 = new Scanner(System.in);
                                                                    String logoutTimeString7 = logout7.next();

                                                                    totHrs7 = calculateTotalHoursWorked(loginTimeString7, logoutTimeString7);
                                                                    regHrs7 = calculateRegularHours(totHrs7);
                                                                    otHrs7 = calculateOverTime(totHrs7);

                                                                    System.out.println("\n" + "Day 8: ");
                                                                    System.out.print("Enter login time (HH:mm): ");
                                                                    Scanner login8 = new Scanner(System.in);
                                                                    String loginTimeString8 = login8.next();

                                                                    System.out.print("Enter logout time (HH:mm): ");
                                                                    Scanner logout8 = new Scanner(System.in);
                                                                    String logoutTimeString8 = logout8.next();

                                                                    totHrs8 = calculateTotalHoursWorked(loginTimeString8, logoutTimeString8);
                                                                    regHrs8 = calculateRegularHours(totHrs8);
                                                                    otHrs8 = calculateOverTime(totHrs8);

                                                                    System.out.println("\n" + "Day 9: ");
                                                                    System.out.print("Enter login time (HH:mm): ");
                                                                    Scanner login9 = new Scanner(System.in);
                                                                    String loginTimeString9 = login9.next();

                                                                    System.out.print("Enter logout time (HH:mm): ");
                                                                    Scanner logout9 = new Scanner(System.in);
                                                                    String logoutTimeString9 = logout9.next();

                                                                    totHrs9 = calculateTotalHoursWorked(loginTimeString9, logoutTimeString9);
                                                                    regHrs9 = calculateRegularHours(totHrs9);
                                                                    otHrs9 = calculateOverTime(totHrs9);

                                                                    System.out.println("\n" + "Day 10: ");
                                                                    System.out.print("Enter login time (HH:mm): ");
                                                                    Scanner login10 = new Scanner(System.in);
                                                                    String loginTimeString10 = login10.next();

                                                                    System.out.print("Enter logout time (HH:mm): ");
                                                                    Scanner logout10 = new Scanner(System.in);
                                                                    String logoutTimeString10 = logout10.next();

                                                                    totHrs10 = calculateTotalHoursWorked(loginTimeString10, logoutTimeString10);
                                                                    regHrs10 = calculateRegularHours(totHrs10);
                                                                    otHrs10 = calculateOverTime(totHrs10);

                                                                    System.out.println("\n" + "Day 11: ");
                                                                    System.out.print("Enter login time (HH:mm): ");
                                                                    Scanner login11 = new Scanner(System.in);
                                                                    String loginTimeString11 = login11.next();

                                                                    System.out.print("Enter logout time (HH:mm): ");
                                                                    Scanner logout11 = new Scanner(System.in);
                                                                    String logoutTimeString11 = logout11.next();

                                                                    totHrs11 = calculateTotalHoursWorked(loginTimeString11, logoutTimeString11);
                                                                    regHrs11 = calculateRegularHours(totHrs11);
                                                                    otHrs11 = calculateOverTime(totHrs11);

                                                                    System.out.println("\n" + "Day 12: ");
                                                                    System.out.print("Enter login time (HH:mm): ");
                                                                    Scanner login12 = new Scanner(System.in);
                                                                    String loginTimeString12 = login12.next();

                                                                    System.out.print("Enter logout time (HH:mm): ");
                                                                    Scanner logout12 = new Scanner(System.in);
                                                                    String logoutTimeString12 = logout12.next();

                                                                    totHrs12 = calculateTotalHoursWorked(loginTimeString12, logoutTimeString12);
                                                                    regHrs12 = calculateRegularHours(totHrs12);
                                                                    otHrs12 = calculateOverTime(totHrs12);

                                                                    System.out.println("\n" + "Day 13: ");
                                                                    System.out.print("Enter login time (HH:mm): ");
                                                                    Scanner login13 = new Scanner(System.in);
                                                                    String loginTimeString13 = login13.next();

                                                                    System.out.print("Enter logout time (HH:mm): ");
                                                                    Scanner logout13 = new Scanner(System.in);
                                                                    String logoutTimeString13 = logout13.next();

                                                                    totHrs13 = calculateTotalHoursWorked(loginTimeString13, logoutTimeString13);
                                                                    regHrs13 = calculateRegularHours(totHrs13);
                                                                    otHrs13 = calculateOverTime(totHrs13);

                                                                    System.out.println("\n" + "Day 14: ");
                                                                    System.out.print("Enter login time (HH:mm): ");
                                                                    Scanner login14 = new Scanner(System.in);
                                                                    String loginTimeString14 = login14.next();

                                                                    System.out.print("Enter logout time (HH:mm): ");
                                                                    Scanner logout14 = new Scanner(System.in);
                                                                    String logoutTimeString14 = logout14.next();

                                                                    totHrs14 = calculateTotalHoursWorked(loginTimeString14, logoutTimeString14);
                                                                    regHrs14 = calculateRegularHours(totHrs14);
                                                                    otHrs14 = calculateOverTime(totHrs14);

                                                                    System.out.println("\n" + "Day 15: ");
                                                                    System.out.print("Enter login time (HH:mm): ");
                                                                    Scanner login15 = new Scanner(System.in);
                                                                    String loginTimeString15 = login15.next();

                                                                    System.out.print("Enter logout time (HH:mm): ");
                                                                    Scanner logout15 = new Scanner(System.in);
                                                                    String logoutTimeString15 = logout15.next();

                                                                    totHrs15 = calculateTotalHoursWorked(loginTimeString15, logoutTimeString15);
                                                                    regHrs15 = calculateRegularHours(totHrs15);
                                                                    otHrs15 = calculateOverTime(totHrs15);
                                                                } else {
                                                                    if (noOfDays == 16) {
                                                                        System.out.println("\n" + "Day 1: ");
                                                                        System.out.print("Enter login time (HH:mm): ");
                                                                        Scanner login1 = new Scanner(System.in);
                                                                        String loginTimeString1 = login1.next();

                                                                        System.out.print("Enter logout time (HH:mm): ");
                                                                        Scanner logout1 = new Scanner(System.in);
                                                                        String logoutTimeString1 = logout1.next();

                                                                        totHrs1 = calculateTotalHoursWorked(loginTimeString1, logoutTimeString1);
                                                                        regHrs1 = calculateRegularHours(totHrs1);
                                                                        otHrs1 = calculateOverTime(totHrs1);

                                                                        System.out.println("\n" + "Day 2: ");
                                                                        System.out.print("Enter login time (HH:mm): ");
                                                                        Scanner login2 = new Scanner(System.in);
                                                                        String loginTimeString2 = login2.next();

                                                                        System.out.print("Enter logout time (HH:mm): ");
                                                                        Scanner logout2 = new Scanner(System.in);
                                                                        String logoutTimeString2 = logout2.next();

                                                                        totHrs2 = calculateTotalHoursWorked(loginTimeString2, logoutTimeString2);
                                                                        regHrs2 = calculateRegularHours(totHrs2);
                                                                        otHrs2 = calculateOverTime(totHrs2);

                                                                        System.out.println("\n" + "Day 3: ");
                                                                        System.out.print("Enter login time (HH:mm): ");
                                                                        Scanner login3 = new Scanner(System.in);
                                                                        String loginTimeString3 = login3.next();

                                                                        System.out.print("Enter logout time (HH:mm): ");
                                                                        Scanner logout3 = new Scanner(System.in);
                                                                        String logoutTimeString3 = logout3.next();

                                                                        totHrs3 = calculateTotalHoursWorked(loginTimeString3, logoutTimeString3);
                                                                        regHrs3 = calculateRegularHours(totHrs3);
                                                                        otHrs3 = calculateOverTime(totHrs3);

                                                                        System.out.println("\n" + "Day 4: ");
                                                                        System.out.print("Enter login time (HH:mm): ");
                                                                        Scanner login4 = new Scanner(System.in);
                                                                        String loginTimeString4 = login4.next();

                                                                        System.out.print("Enter logout time (HH:mm): ");
                                                                        Scanner logout4 = new Scanner(System.in);
                                                                        String logoutTimeString4 = logout4.next();

                                                                        totHrs4 = calculateTotalHoursWorked(loginTimeString4, logoutTimeString4);
                                                                        regHrs4 = calculateRegularHours(totHrs4);
                                                                        otHrs4 = calculateOverTime(totHrs4);

                                                                        System.out.println("\n" + "Day 5: ");
                                                                        System.out.print("Enter login time (HH:mm): ");
                                                                        Scanner login5 = new Scanner(System.in);
                                                                        String loginTimeString5 = login5.next();

                                                                        System.out.print("Enter logout time (HH:mm): ");
                                                                        Scanner logout5 = new Scanner(System.in);
                                                                        String logoutTimeString5 = logout5.next();

                                                                        totHrs5 = calculateTotalHoursWorked(loginTimeString5, logoutTimeString5);
                                                                        regHrs5 = calculateRegularHours(totHrs5);
                                                                        otHrs5 = calculateOverTime(totHrs5);

                                                                        System.out.println("\n" + "Day 6: ");
                                                                        System.out.print("Enter login time (HH:mm): ");
                                                                        Scanner login6 = new Scanner(System.in);
                                                                        String loginTimeString6 = login6.next();

                                                                        System.out.print("Enter logout time (HH:mm): ");
                                                                        Scanner logout6 = new Scanner(System.in);
                                                                        String logoutTimeString6 = logout6.next();

                                                                        totHrs6 = calculateTotalHoursWorked(loginTimeString6, logoutTimeString6);
                                                                        regHrs6 = calculateRegularHours(totHrs6);
                                                                        otHrs6 = calculateOverTime(totHrs6);

                                                                        System.out.println("\n" + "Day 7: ");
                                                                        System.out.print("Enter login time (HH:mm): ");
                                                                        Scanner login7 = new Scanner(System.in);
                                                                        String loginTimeString7 = login7.next();

                                                                        System.out.print("Enter logout time (HH:mm): ");
                                                                        Scanner logout7 = new Scanner(System.in);
                                                                        String logoutTimeString7 = logout7.next();

                                                                        totHrs7 = calculateTotalHoursWorked(loginTimeString7, logoutTimeString7);
                                                                        regHrs7 = calculateRegularHours(totHrs7);
                                                                        otHrs7 = calculateOverTime(totHrs7);

                                                                        System.out.println("\n" + "Day 8: ");
                                                                        System.out.print("Enter login time (HH:mm): ");
                                                                        Scanner login8 = new Scanner(System.in);
                                                                        String loginTimeString8 = login8.next();

                                                                        System.out.print("Enter logout time (HH:mm): ");
                                                                        Scanner logout8 = new Scanner(System.in);
                                                                        String logoutTimeString8 = logout8.next();

                                                                        totHrs8 = calculateTotalHoursWorked(loginTimeString8, logoutTimeString8);
                                                                        regHrs8 = calculateRegularHours(totHrs8);
                                                                        otHrs8 = calculateOverTime(totHrs8);

                                                                        System.out.println("\n" + "Day 9: ");
                                                                        System.out.print("Enter login time (HH:mm): ");
                                                                        Scanner login9 = new Scanner(System.in);
                                                                        String loginTimeString9 = login9.next();

                                                                        System.out.print("Enter logout time (HH:mm): ");
                                                                        Scanner logout9 = new Scanner(System.in);
                                                                        String logoutTimeString9 = logout9.next();

                                                                        totHrs9 = calculateTotalHoursWorked(loginTimeString9, logoutTimeString9);
                                                                        regHrs9 = calculateRegularHours(totHrs9);
                                                                        otHrs9 = calculateOverTime(totHrs9);

                                                                        System.out.println("\n" + "Day 10: ");
                                                                        System.out.print("Enter login time (HH:mm): ");
                                                                        Scanner login10 = new Scanner(System.in);
                                                                        String loginTimeString10 = login10.next();

                                                                        System.out.print("Enter logout time (HH:mm): ");
                                                                        Scanner logout10 = new Scanner(System.in);
                                                                        String logoutTimeString10 = logout10.next();

                                                                        totHrs10 = calculateTotalHoursWorked(loginTimeString10, logoutTimeString10);
                                                                        regHrs10 = calculateRegularHours(totHrs10);
                                                                        otHrs10 = calculateOverTime(totHrs10);

                                                                        System.out.println("\n" + "Day 11: ");
                                                                        System.out.print("Enter login time (HH:mm): ");
                                                                        Scanner login11 = new Scanner(System.in);
                                                                        String loginTimeString11 = login11.next();

                                                                        System.out.print("Enter logout time (HH:mm): ");
                                                                        Scanner logout11 = new Scanner(System.in);
                                                                        String logoutTimeString11 = logout11.next();

                                                                        totHrs11 = calculateTotalHoursWorked(loginTimeString11, logoutTimeString11);
                                                                        regHrs11 = calculateRegularHours(totHrs11);
                                                                        otHrs11 = calculateOverTime(totHrs11);

                                                                        System.out.println("\n" + "Day 12: ");
                                                                        System.out.print("Enter login time (HH:mm): ");
                                                                        Scanner login12 = new Scanner(System.in);
                                                                        String loginTimeString12 = login12.next();

                                                                        System.out.print("Enter logout time (HH:mm): ");
                                                                        Scanner logout12 = new Scanner(System.in);
                                                                        String logoutTimeString12 = logout12.next();

                                                                        totHrs12 = calculateTotalHoursWorked(loginTimeString12, logoutTimeString12);
                                                                        regHrs12 = calculateRegularHours(totHrs12);
                                                                        otHrs12 = calculateOverTime(totHrs12);

                                                                        System.out.println("\n" + "Day 13: ");
                                                                        System.out.print("Enter login time (HH:mm): ");
                                                                        Scanner login13 = new Scanner(System.in);
                                                                        String loginTimeString13 = login13.next();

                                                                        System.out.print("Enter logout time (HH:mm): ");
                                                                        Scanner logout13 = new Scanner(System.in);
                                                                        String logoutTimeString13 = logout13.next();

                                                                        totHrs13 = calculateTotalHoursWorked(loginTimeString13, logoutTimeString13);
                                                                        regHrs13 = calculateRegularHours(totHrs13);
                                                                        otHrs13 = calculateOverTime(totHrs13);

                                                                        System.out.println("\n" + "Day 14: ");
                                                                        System.out.print("Enter login time (HH:mm): ");
                                                                        Scanner login14 = new Scanner(System.in);
                                                                        String loginTimeString14 = login14.next();

                                                                        System.out.print("Enter logout time (HH:mm): ");
                                                                        Scanner logout14 = new Scanner(System.in);
                                                                        String logoutTimeString14 = logout14.next();

                                                                        totHrs14 = calculateTotalHoursWorked(loginTimeString14, logoutTimeString14);
                                                                        regHrs14 = calculateRegularHours(totHrs14);
                                                                        otHrs14 = calculateOverTime(totHrs14);

                                                                        System.out.println("\n" + "Day 15: ");
                                                                        System.out.print("Enter login time (HH:mm): ");
                                                                        Scanner login15 = new Scanner(System.in);
                                                                        String loginTimeString15 = login15.next();

                                                                        System.out.print("Enter logout time (HH:mm): ");
                                                                        Scanner logout15 = new Scanner(System.in);
                                                                        String logoutTimeString15 = logout15.next();

                                                                        totHrs15 = calculateTotalHoursWorked(loginTimeString15, logoutTimeString15);
                                                                        regHrs15 = calculateRegularHours(totHrs15);
                                                                        otHrs15 = calculateOverTime(totHrs15);

                                                                        System.out.println("\n" + "Day 16: ");
                                                                        System.out.print("Enter login time (HH:mm): ");
                                                                        Scanner login16 = new Scanner(System.in);
                                                                        String loginTimeString16 = login16.next();

                                                                        System.out.print("Enter logout time (HH:mm): ");
                                                                        Scanner logout16 = new Scanner(System.in);
                                                                        String logoutTimeString16 = logout16.next();

                                                                        totHrs16 = calculateTotalHoursWorked(loginTimeString16, logoutTimeString16);
                                                                        regHrs16 = calculateRegularHours(totHrs16);
                                                                        otHrs16 = calculateOverTime(totHrs16);
                                                                    } else {
                                                                        if (noOfDays == 17) {
                                                                            System.out.println("\n" + "Day 1: ");
                                                                            System.out.print("Enter login time (HH:mm): ");
                                                                            Scanner login1 = new Scanner(System.in);
                                                                            String loginTimeString1 = login1.next();

                                                                            System.out.print("Enter logout time (HH:mm): ");
                                                                            Scanner logout1 = new Scanner(System.in);
                                                                            String logoutTimeString1 = logout1.next();

                                                                            totHrs1 = calculateTotalHoursWorked(loginTimeString1, logoutTimeString1);
                                                                            regHrs1 = calculateRegularHours(totHrs1);
                                                                            otHrs1 = calculateOverTime(totHrs1);

                                                                            System.out.println("\n" + "Day 2: ");
                                                                            System.out.print("Enter login time (HH:mm): ");
                                                                            Scanner login2 = new Scanner(System.in);
                                                                            String loginTimeString2 = login2.next();

                                                                            System.out.print("Enter logout time (HH:mm): ");
                                                                            Scanner logout2 = new Scanner(System.in);
                                                                            String logoutTimeString2 = logout2.next();

                                                                            totHrs2 = calculateTotalHoursWorked(loginTimeString2, logoutTimeString2);
                                                                            regHrs2 = calculateRegularHours(totHrs2);
                                                                            otHrs2 = calculateOverTime(totHrs2);

                                                                            System.out.println("\n" + "Day 3: ");
                                                                            System.out.print("Enter login time (HH:mm): ");
                                                                            Scanner login3 = new Scanner(System.in);
                                                                            String loginTimeString3 = login3.next();

                                                                            System.out.print("Enter logout time (HH:mm): ");
                                                                            Scanner logout3 = new Scanner(System.in);
                                                                            String logoutTimeString3 = logout3.next();

                                                                            totHrs3 = calculateTotalHoursWorked(loginTimeString3, logoutTimeString3);
                                                                            regHrs3 = calculateRegularHours(totHrs3);
                                                                            otHrs3 = calculateOverTime(totHrs3);

                                                                            System.out.println("\n" + "Day 4: ");
                                                                            System.out.print("Enter login time (HH:mm): ");
                                                                            Scanner login4 = new Scanner(System.in);
                                                                            String loginTimeString4 = login4.next();

                                                                            System.out.print("Enter logout time (HH:mm): ");
                                                                            Scanner logout4 = new Scanner(System.in);
                                                                            String logoutTimeString4 = logout4.next();

                                                                            totHrs4 = calculateTotalHoursWorked(loginTimeString4, logoutTimeString4);
                                                                            regHrs4 = calculateRegularHours(totHrs4);
                                                                            otHrs4 = calculateOverTime(totHrs4);

                                                                            System.out.println("\n" + "Day 5: ");
                                                                            System.out.print("Enter login time (HH:mm): ");
                                                                            Scanner login5 = new Scanner(System.in);
                                                                            String loginTimeString5 = login5.next();

                                                                            System.out.print("Enter logout time (HH:mm): ");
                                                                            Scanner logout5 = new Scanner(System.in);
                                                                            String logoutTimeString5 = logout5.next();

                                                                            totHrs5 = calculateTotalHoursWorked(loginTimeString5, logoutTimeString5);
                                                                            regHrs5 = calculateRegularHours(totHrs5);
                                                                            otHrs5 = calculateOverTime(totHrs5);

                                                                            System.out.println("\n" + "Day 6: ");
                                                                            System.out.print("Enter login time (HH:mm): ");
                                                                            Scanner login6 = new Scanner(System.in);
                                                                            String loginTimeString6 = login6.next();

                                                                            System.out.print("Enter logout time (HH:mm): ");
                                                                            Scanner logout6 = new Scanner(System.in);
                                                                            String logoutTimeString6 = logout6.next();

                                                                            totHrs6 = calculateTotalHoursWorked(loginTimeString6, logoutTimeString6);
                                                                            regHrs6 = calculateRegularHours(totHrs6);
                                                                            otHrs6 = calculateOverTime(totHrs6);

                                                                            System.out.println("\n" + "Day 7: ");
                                                                            System.out.print("Enter login time (HH:mm): ");
                                                                            Scanner login7 = new Scanner(System.in);
                                                                            String loginTimeString7 = login7.next();

                                                                            System.out.print("Enter logout time (HH:mm): ");
                                                                            Scanner logout7 = new Scanner(System.in);
                                                                            String logoutTimeString7 = logout7.next();

                                                                            totHrs7 = calculateTotalHoursWorked(loginTimeString7, logoutTimeString7);
                                                                            regHrs7 = calculateRegularHours(totHrs7);
                                                                            otHrs7 = calculateOverTime(totHrs7);

                                                                            System.out.println("\n" + "Day 8: ");
                                                                            System.out.print("Enter login time (HH:mm): ");
                                                                            Scanner login8 = new Scanner(System.in);
                                                                            String loginTimeString8 = login8.next();

                                                                            System.out.print("Enter logout time (HH:mm): ");
                                                                            Scanner logout8 = new Scanner(System.in);
                                                                            String logoutTimeString8 = logout8.next();

                                                                            totHrs8 = calculateTotalHoursWorked(loginTimeString8, logoutTimeString8);
                                                                            regHrs8 = calculateRegularHours(totHrs8);
                                                                            otHrs8 = calculateOverTime(totHrs8);

                                                                            System.out.println("\n" + "Day 9: ");
                                                                            System.out.print("Enter login time (HH:mm): ");
                                                                            Scanner login9 = new Scanner(System.in);
                                                                            String loginTimeString9 = login9.next();

                                                                            System.out.print("Enter logout time (HH:mm): ");
                                                                            Scanner logout9 = new Scanner(System.in);
                                                                            String logoutTimeString9 = logout9.next();

                                                                            totHrs9 = calculateTotalHoursWorked(loginTimeString9, logoutTimeString9);
                                                                            regHrs9 = calculateRegularHours(totHrs9);
                                                                            otHrs9 = calculateOverTime(totHrs9);

                                                                            System.out.println("\n" + "Day 10: ");
                                                                            System.out.print("Enter login time (HH:mm): ");
                                                                            Scanner login10 = new Scanner(System.in);
                                                                            String loginTimeString10 = login10.next();

                                                                            System.out.print("Enter logout time (HH:mm): ");
                                                                            Scanner logout10 = new Scanner(System.in);
                                                                            String logoutTimeString10 = logout10.next();

                                                                            totHrs10 = calculateTotalHoursWorked(loginTimeString10, logoutTimeString10);
                                                                            regHrs10 = calculateRegularHours(totHrs10);
                                                                            otHrs10 = calculateOverTime(totHrs10);

                                                                            System.out.println("\n" + "Day 11: ");
                                                                            System.out.print("Enter login time (HH:mm): ");
                                                                            Scanner login11 = new Scanner(System.in);
                                                                            String loginTimeString11 = login11.next();

                                                                            System.out.print("Enter logout time (HH:mm): ");
                                                                            Scanner logout11 = new Scanner(System.in);
                                                                            String logoutTimeString11 = logout11.next();

                                                                            totHrs11 = calculateTotalHoursWorked(loginTimeString11, logoutTimeString11);
                                                                            regHrs11 = calculateRegularHours(totHrs11);
                                                                            otHrs11 = calculateOverTime(totHrs11);

                                                                            System.out.println("\n" + "Day 12: ");
                                                                            System.out.print("Enter login time (HH:mm): ");
                                                                            Scanner login12 = new Scanner(System.in);
                                                                            String loginTimeString12 = login12.next();

                                                                            System.out.print("Enter logout time (HH:mm): ");
                                                                            Scanner logout12 = new Scanner(System.in);
                                                                            String logoutTimeString12 = logout12.next();

                                                                            totHrs12 = calculateTotalHoursWorked(loginTimeString12, logoutTimeString12);
                                                                            regHrs12 = calculateRegularHours(totHrs12);
                                                                            otHrs12 = calculateOverTime(totHrs12);

                                                                            System.out.println("\n" + "Day 13: ");
                                                                            System.out.print("Enter login time (HH:mm): ");
                                                                            Scanner login13 = new Scanner(System.in);
                                                                            String loginTimeString13 = login13.next();

                                                                            System.out.print("Enter logout time (HH:mm): ");
                                                                            Scanner logout13 = new Scanner(System.in);
                                                                            String logoutTimeString13 = logout13.next();

                                                                            totHrs13 = calculateTotalHoursWorked(loginTimeString13, logoutTimeString13);
                                                                            regHrs13 = calculateRegularHours(totHrs13);
                                                                            otHrs13 = calculateOverTime(totHrs13);

                                                                            System.out.println("\n" + "Day 14: ");
                                                                            System.out.print("Enter login time (HH:mm): ");
                                                                            Scanner login14 = new Scanner(System.in);
                                                                            String loginTimeString14 = login14.next();

                                                                            System.out.print("Enter logout time (HH:mm): ");
                                                                            Scanner logout14 = new Scanner(System.in);
                                                                            String logoutTimeString14 = logout14.next();

                                                                            totHrs14 = calculateTotalHoursWorked(loginTimeString14, logoutTimeString14);
                                                                            regHrs14 = calculateRegularHours(totHrs14);
                                                                            otHrs14 = calculateOverTime(totHrs14);

                                                                            System.out.println("\n" + "Day 15: ");
                                                                            System.out.print("Enter login time (HH:mm): ");
                                                                            Scanner login15 = new Scanner(System.in);
                                                                            String loginTimeString15 = login15.next();

                                                                            System.out.print("Enter logout time (HH:mm): ");
                                                                            Scanner logout15 = new Scanner(System.in);
                                                                            String logoutTimeString15 = logout15.next();

                                                                            totHrs15 = calculateTotalHoursWorked(loginTimeString15, logoutTimeString15);
                                                                            regHrs15 = calculateRegularHours(totHrs15);
                                                                            otHrs15 = calculateOverTime(totHrs15);

                                                                            System.out.println("\n" + "Day 16: ");
                                                                            System.out.print("Enter login time (HH:mm): ");
                                                                            Scanner login16 = new Scanner(System.in);
                                                                            String loginTimeString16 = login16.next();

                                                                            System.out.print("Enter logout time (HH:mm): ");
                                                                            Scanner logout16 = new Scanner(System.in);
                                                                            String logoutTimeString16 = logout16.next();

                                                                            totHrs16 = calculateTotalHoursWorked(loginTimeString16, logoutTimeString16);
                                                                            regHrs16 = calculateRegularHours(totHrs16);
                                                                            otHrs16 = calculateOverTime(totHrs16);

                                                                            System.out.println("\n" + "Day 17: ");
                                                                            System.out.print("Enter login time (HH:mm): ");
                                                                            Scanner login17 = new Scanner(System.in);
                                                                            String loginTimeString17 = login17.next();

                                                                            System.out.print("Enter logout time (HH:mm): ");
                                                                            Scanner logout17 = new Scanner(System.in);
                                                                            String logoutTimeString17 = logout17.next();

                                                                            totHrs17 = calculateTotalHoursWorked(loginTimeString17, logoutTimeString17);
                                                                            regHrs17 = calculateRegularHours(totHrs17);
                                                                            otHrs17 = calculateOverTime(totHrs17);
                                                                        } else {
                                                                            if (noOfDays == 18) {
                                                                                System.out.println("\n" + "Day 1: ");
                                                                                System.out.print("Enter login time (HH:mm): ");
                                                                                Scanner login1 = new Scanner(System.in);
                                                                                String loginTimeString1 = login1.next();

                                                                                System.out.print("Enter logout time (HH:mm): ");
                                                                                Scanner logout1 = new Scanner(System.in);
                                                                                String logoutTimeString1 = logout1.next();

                                                                                totHrs1 = calculateTotalHoursWorked(loginTimeString1, logoutTimeString1);
                                                                                regHrs1 = calculateRegularHours(totHrs1);
                                                                                otHrs1 = calculateOverTime(totHrs1);

                                                                                System.out.println("\n" + "Day 2: ");
                                                                                System.out.print("Enter login time (HH:mm): ");
                                                                                Scanner login2 = new Scanner(System.in);
                                                                                String loginTimeString2 = login2.next();

                                                                                System.out.print("Enter logout time (HH:mm): ");
                                                                                Scanner logout2 = new Scanner(System.in);
                                                                                String logoutTimeString2 = logout2.next();

                                                                                totHrs2 = calculateTotalHoursWorked(loginTimeString2, logoutTimeString2);
                                                                                regHrs2 = calculateRegularHours(totHrs2);
                                                                                otHrs2 = calculateOverTime(totHrs2);

                                                                                System.out.println("\n" + "Day 3: ");
                                                                                System.out.print("Enter login time (HH:mm): ");
                                                                                Scanner login3 = new Scanner(System.in);
                                                                                String loginTimeString3 = login3.next();

                                                                                System.out.print("Enter logout time (HH:mm): ");
                                                                                Scanner logout3 = new Scanner(System.in);
                                                                                String logoutTimeString3 = logout3.next();

                                                                                totHrs3 = calculateTotalHoursWorked(loginTimeString3, logoutTimeString3);
                                                                                regHrs3 = calculateRegularHours(totHrs3);
                                                                                otHrs3 = calculateOverTime(totHrs3);

                                                                                System.out.println("\n" + "Day 4: ");
                                                                                System.out.print("Enter login time (HH:mm): ");
                                                                                Scanner login4 = new Scanner(System.in);
                                                                                String loginTimeString4 = login4.next();

                                                                                System.out.print("Enter logout time (HH:mm): ");
                                                                                Scanner logout4 = new Scanner(System.in);
                                                                                String logoutTimeString4 = logout4.next();

                                                                                totHrs4 = calculateTotalHoursWorked(loginTimeString4, logoutTimeString4);
                                                                                regHrs4 = calculateRegularHours(totHrs4);
                                                                                otHrs4 = calculateOverTime(totHrs4);

                                                                                System.out.println("\n" + "Day 5: ");
                                                                                System.out.print("Enter login time (HH:mm): ");
                                                                                Scanner login5 = new Scanner(System.in);
                                                                                String loginTimeString5 = login5.next();

                                                                                System.out.print("Enter logout time (HH:mm): ");
                                                                                Scanner logout5 = new Scanner(System.in);
                                                                                String logoutTimeString5 = logout5.next();

                                                                                totHrs5 = calculateTotalHoursWorked(loginTimeString5, logoutTimeString5);
                                                                                regHrs5 = calculateRegularHours(totHrs5);
                                                                                otHrs5 = calculateOverTime(totHrs5);

                                                                                System.out.println("\n" + "Day 6: ");
                                                                                System.out.print("Enter login time (HH:mm): ");
                                                                                Scanner login6 = new Scanner(System.in);
                                                                                String loginTimeString6 = login6.next();

                                                                                System.out.print("Enter logout time (HH:mm): ");
                                                                                Scanner logout6 = new Scanner(System.in);
                                                                                String logoutTimeString6 = logout6.next();

                                                                                totHrs6 = calculateTotalHoursWorked(loginTimeString6, logoutTimeString6);
                                                                                regHrs6 = calculateRegularHours(totHrs6);
                                                                                otHrs6 = calculateOverTime(totHrs6);

                                                                                System.out.println("\n" + "Day 7: ");
                                                                                System.out.print("Enter login time (HH:mm): ");
                                                                                Scanner login7 = new Scanner(System.in);
                                                                                String loginTimeString7 = login7.next();

                                                                                System.out.print("Enter logout time (HH:mm): ");
                                                                                Scanner logout7 = new Scanner(System.in);
                                                                                String logoutTimeString7 = logout7.next();

                                                                                totHrs7 = calculateTotalHoursWorked(loginTimeString7, logoutTimeString7);
                                                                                regHrs7 = calculateRegularHours(totHrs7);
                                                                                otHrs7 = calculateOverTime(totHrs7);

                                                                                System.out.println("\n" + "Day 8: ");
                                                                                System.out.print("Enter login time (HH:mm): ");
                                                                                Scanner login8 = new Scanner(System.in);
                                                                                String loginTimeString8 = login8.next();

                                                                                System.out.print("Enter logout time (HH:mm): ");
                                                                                Scanner logout8 = new Scanner(System.in);
                                                                                String logoutTimeString8 = logout8.next();

                                                                                totHrs8 = calculateTotalHoursWorked(loginTimeString8, logoutTimeString8);
                                                                                regHrs8 = calculateRegularHours(totHrs8);
                                                                                otHrs8 = calculateOverTime(totHrs8);

                                                                                System.out.println("\n" + "Day 9: ");
                                                                                System.out.print("Enter login time (HH:mm): ");
                                                                                Scanner login9 = new Scanner(System.in);
                                                                                String loginTimeString9 = login9.next();

                                                                                System.out.print("Enter logout time (HH:mm): ");
                                                                                Scanner logout9 = new Scanner(System.in);
                                                                                String logoutTimeString9 = logout9.next();

                                                                                totHrs9 = calculateTotalHoursWorked(loginTimeString9, logoutTimeString9);
                                                                                regHrs9 = calculateRegularHours(totHrs9);
                                                                                otHrs9 = calculateOverTime(totHrs9);

                                                                                System.out.println("\n" + "Day 10: ");
                                                                                System.out.print("Enter login time (HH:mm): ");
                                                                                Scanner login10 = new Scanner(System.in);
                                                                                String loginTimeString10 = login10.next();

                                                                                System.out.print("Enter logout time (HH:mm): ");
                                                                                Scanner logout10 = new Scanner(System.in);
                                                                                String logoutTimeString10 = logout10.next();

                                                                                totHrs10 = calculateTotalHoursWorked(loginTimeString10, logoutTimeString10);
                                                                                regHrs10 = calculateRegularHours(totHrs10);
                                                                                otHrs10 = calculateOverTime(totHrs10);

                                                                                System.out.println("\n" + "Day 11: ");
                                                                                System.out.print("Enter login time (HH:mm): ");
                                                                                Scanner login11 = new Scanner(System.in);
                                                                                String loginTimeString11 = login11.next();

                                                                                System.out.print("Enter logout time (HH:mm): ");
                                                                                Scanner logout11 = new Scanner(System.in);
                                                                                String logoutTimeString11 = logout11.next();

                                                                                totHrs11 = calculateTotalHoursWorked(loginTimeString11, logoutTimeString11);
                                                                                regHrs11 = calculateRegularHours(totHrs11);
                                                                                otHrs11 = calculateOverTime(totHrs11);

                                                                                System.out.println("\n" + "Day 12: ");
                                                                                System.out.print("Enter login time (HH:mm): ");
                                                                                Scanner login12 = new Scanner(System.in);
                                                                                String loginTimeString12 = login12.next();

                                                                                System.out.print("Enter logout time (HH:mm): ");
                                                                                Scanner logout12 = new Scanner(System.in);
                                                                                String logoutTimeString12 = logout12.next();

                                                                                totHrs12 = calculateTotalHoursWorked(loginTimeString12, logoutTimeString12);
                                                                                regHrs12 = calculateRegularHours(totHrs12);
                                                                                otHrs12 = calculateOverTime(totHrs12);

                                                                                System.out.println("\n" + "Day 13: ");
                                                                                System.out.print("Enter login time (HH:mm): ");
                                                                                Scanner login13 = new Scanner(System.in);
                                                                                String loginTimeString13 = login13.next();

                                                                                System.out.print("Enter logout time (HH:mm): ");
                                                                                Scanner logout13 = new Scanner(System.in);
                                                                                String logoutTimeString13 = logout13.next();

                                                                                totHrs13 = calculateTotalHoursWorked(loginTimeString13, logoutTimeString13);
                                                                                regHrs13 = calculateRegularHours(totHrs13);
                                                                                otHrs13 = calculateOverTime(totHrs13);

                                                                                System.out.println("\n" + "Day 14: ");
                                                                                System.out.print("Enter login time (HH:mm): ");
                                                                                Scanner login14 = new Scanner(System.in);
                                                                                String loginTimeString14 = login14.next();

                                                                                System.out.print("Enter logout time (HH:mm): ");
                                                                                Scanner logout14 = new Scanner(System.in);
                                                                                String logoutTimeString14 = logout14.next();

                                                                                totHrs14 = calculateTotalHoursWorked(loginTimeString14, logoutTimeString14);
                                                                                regHrs14 = calculateRegularHours(totHrs14);
                                                                                otHrs14 = calculateOverTime(totHrs14);

                                                                                System.out.println("\n" + "Day 15: ");
                                                                                System.out.print("Enter login time (HH:mm): ");
                                                                                Scanner login15 = new Scanner(System.in);
                                                                                String loginTimeString15 = login15.next();

                                                                                System.out.print("Enter logout time (HH:mm): ");
                                                                                Scanner logout15 = new Scanner(System.in);
                                                                                String logoutTimeString15 = logout15.next();

                                                                                totHrs15 = calculateTotalHoursWorked(loginTimeString15, logoutTimeString15);
                                                                                regHrs15 = calculateRegularHours(totHrs15);
                                                                                otHrs15 = calculateOverTime(totHrs15);

                                                                                System.out.println("\n" + "Day 16: ");
                                                                                System.out.print("Enter login time (HH:mm): ");
                                                                                Scanner login16 = new Scanner(System.in);
                                                                                String loginTimeString16 = login16.next();

                                                                                System.out.print("Enter logout time (HH:mm): ");
                                                                                Scanner logout16 = new Scanner(System.in);
                                                                                String logoutTimeString16 = logout16.next();

                                                                                totHrs16 = calculateTotalHoursWorked(loginTimeString16, logoutTimeString16);
                                                                                regHrs16 = calculateRegularHours(totHrs16);
                                                                                otHrs16 = calculateOverTime(totHrs16);

                                                                                System.out.println("\n" + "Day 17: ");
                                                                                System.out.print("Enter login time (HH:mm): ");
                                                                                Scanner login17 = new Scanner(System.in);
                                                                                String loginTimeString17 = login17.next();

                                                                                System.out.print("Enter logout time (HH:mm): ");
                                                                                Scanner logout17 = new Scanner(System.in);
                                                                                String logoutTimeString17 = logout17.next();

                                                                                totHrs17 = calculateTotalHoursWorked(loginTimeString17, logoutTimeString17);
                                                                                regHrs17 = calculateRegularHours(totHrs17);
                                                                                otHrs17 = calculateOverTime(totHrs17);

                                                                                System.out.println("\n" + "Day 18: ");
                                                                                System.out.print("Enter login time (HH:mm): ");
                                                                                Scanner login18 = new Scanner(System.in);
                                                                                String loginTimeString18 = login18.next();

                                                                                System.out.print("Enter logout time (HH:mm): ");
                                                                                Scanner logout18 = new Scanner(System.in);
                                                                                String logoutTimeString18 = logout18.next();

                                                                                totHrs18 = calculateTotalHoursWorked(loginTimeString18, logoutTimeString18);
                                                                                regHrs18 = calculateRegularHours(totHrs18);
                                                                                otHrs18 = calculateOverTime(totHrs18);
                                                                            } else {
                                                                                if (noOfDays == 19) {
                                                                                    System.out.println("\n" + "Day 1: ");
                                                                                    System.out.print("Enter login time (HH:mm): ");
                                                                                    Scanner login1 = new Scanner(System.in);
                                                                                    String loginTimeString1 = login1.next();

                                                                                    System.out.print("Enter logout time (HH:mm): ");
                                                                                    Scanner logout1 = new Scanner(System.in);
                                                                                    String logoutTimeString1 = logout1.next();

                                                                                    totHrs1 = calculateTotalHoursWorked(loginTimeString1, logoutTimeString1);
                                                                                    regHrs1 = calculateRegularHours(totHrs1);
                                                                                    otHrs1 = calculateOverTime(totHrs1);

                                                                                    System.out.println("\n" + "Day 2: ");
                                                                                    System.out.print("Enter login time (HH:mm): ");
                                                                                    Scanner login2 = new Scanner(System.in);
                                                                                    String loginTimeString2 = login2.next();

                                                                                    System.out.print("Enter logout time (HH:mm): ");
                                                                                    Scanner logout2 = new Scanner(System.in);
                                                                                    String logoutTimeString2 = logout2.next();

                                                                                    totHrs2 = calculateTotalHoursWorked(loginTimeString2, logoutTimeString2);
                                                                                    regHrs2 = calculateRegularHours(totHrs2);
                                                                                    otHrs2 = calculateOverTime(totHrs2);

                                                                                    System.out.println("\n" + "Day 3: ");
                                                                                    System.out.print("Enter login time (HH:mm): ");
                                                                                    Scanner login3 = new Scanner(System.in);
                                                                                    String loginTimeString3 = login3.next();

                                                                                    System.out.print("Enter logout time (HH:mm): ");
                                                                                    Scanner logout3 = new Scanner(System.in);
                                                                                    String logoutTimeString3 = logout3.next();

                                                                                    totHrs3 = calculateTotalHoursWorked(loginTimeString3, logoutTimeString3);
                                                                                    regHrs3 = calculateRegularHours(totHrs3);
                                                                                    otHrs3 = calculateOverTime(totHrs3);

                                                                                    System.out.println("\n" + "Day 4: ");
                                                                                    System.out.print("Enter login time (HH:mm): ");
                                                                                    Scanner login4 = new Scanner(System.in);
                                                                                    String loginTimeString4 = login4.next();

                                                                                    System.out.print("Enter logout time (HH:mm): ");
                                                                                    Scanner logout4 = new Scanner(System.in);
                                                                                    String logoutTimeString4 = logout4.next();

                                                                                    totHrs4 = calculateTotalHoursWorked(loginTimeString4, logoutTimeString4);
                                                                                    regHrs4 = calculateRegularHours(totHrs4);
                                                                                    otHrs4 = calculateOverTime(totHrs4);

                                                                                    System.out.println("\n" + "Day 5: ");
                                                                                    System.out.print("Enter login time (HH:mm): ");
                                                                                    Scanner login5 = new Scanner(System.in);
                                                                                    String loginTimeString5 = login5.next();

                                                                                    System.out.print("Enter logout time (HH:mm): ");
                                                                                    Scanner logout5 = new Scanner(System.in);
                                                                                    String logoutTimeString5 = logout5.next();

                                                                                    totHrs5 = calculateTotalHoursWorked(loginTimeString5, logoutTimeString5);
                                                                                    regHrs5 = calculateRegularHours(totHrs5);
                                                                                    otHrs5 = calculateOverTime(totHrs5);

                                                                                    System.out.println("\n" + "Day 6: ");
                                                                                    System.out.print("Enter login time (HH:mm): ");
                                                                                    Scanner login6 = new Scanner(System.in);
                                                                                    String loginTimeString6 = login6.next();

                                                                                    System.out.print("Enter logout time (HH:mm): ");
                                                                                    Scanner logout6 = new Scanner(System.in);
                                                                                    String logoutTimeString6 = logout6.next();

                                                                                    totHrs6 = calculateTotalHoursWorked(loginTimeString6, logoutTimeString6);
                                                                                    regHrs6 = calculateRegularHours(totHrs6);
                                                                                    otHrs6 = calculateOverTime(totHrs6);

                                                                                    System.out.println("\n" + "Day 7: ");
                                                                                    System.out.print("Enter login time (HH:mm): ");
                                                                                    Scanner login7 = new Scanner(System.in);
                                                                                    String loginTimeString7 = login7.next();

                                                                                    System.out.print("Enter logout time (HH:mm): ");
                                                                                    Scanner logout7 = new Scanner(System.in);
                                                                                    String logoutTimeString7 = logout7.next();

                                                                                    totHrs7 = calculateTotalHoursWorked(loginTimeString7, logoutTimeString7);
                                                                                    regHrs7 = calculateRegularHours(totHrs7);
                                                                                    otHrs7 = calculateOverTime(totHrs7);

                                                                                    System.out.println("\n" + "Day 8: ");
                                                                                    System.out.print("Enter login time (HH:mm): ");
                                                                                    Scanner login8 = new Scanner(System.in);
                                                                                    String loginTimeString8 = login8.next();

                                                                                    System.out.print("Enter logout time (HH:mm): ");
                                                                                    Scanner logout8 = new Scanner(System.in);
                                                                                    String logoutTimeString8 = logout8.next();

                                                                                    totHrs8 = calculateTotalHoursWorked(loginTimeString8, logoutTimeString8);
                                                                                    regHrs8 = calculateRegularHours(totHrs8);
                                                                                    otHrs8 = calculateOverTime(totHrs8);

                                                                                    System.out.println("\n" + "Day 9: ");
                                                                                    System.out.print("Enter login time (HH:mm): ");
                                                                                    Scanner login9 = new Scanner(System.in);
                                                                                    String loginTimeString9 = login9.next();

                                                                                    System.out.print("Enter logout time (HH:mm): ");
                                                                                    Scanner logout9 = new Scanner(System.in);
                                                                                    String logoutTimeString9 = logout9.next();

                                                                                    totHrs9 = calculateTotalHoursWorked(loginTimeString9, logoutTimeString9);
                                                                                    regHrs9 = calculateRegularHours(totHrs9);
                                                                                    otHrs9 = calculateOverTime(totHrs9);

                                                                                    System.out.println("\n" + "Day 10: ");
                                                                                    System.out.print("Enter login time (HH:mm): ");
                                                                                    Scanner login10 = new Scanner(System.in);
                                                                                    String loginTimeString10 = login10.next();

                                                                                    System.out.print("Enter logout time (HH:mm): ");
                                                                                    Scanner logout10 = new Scanner(System.in);
                                                                                    String logoutTimeString10 = logout10.next();

                                                                                    totHrs10 = calculateTotalHoursWorked(loginTimeString10, logoutTimeString10);
                                                                                    regHrs10 = calculateRegularHours(totHrs10);
                                                                                    otHrs10 = calculateOverTime(totHrs10);

                                                                                    System.out.println("\n" + "Day 11: ");
                                                                                    System.out.print("Enter login time (HH:mm): ");
                                                                                    Scanner login11 = new Scanner(System.in);
                                                                                    String loginTimeString11 = login11.next();

                                                                                    System.out.print("Enter logout time (HH:mm): ");
                                                                                    Scanner logout11 = new Scanner(System.in);
                                                                                    String logoutTimeString11 = logout11.next();

                                                                                    totHrs11 = calculateTotalHoursWorked(loginTimeString11, logoutTimeString11);
                                                                                    regHrs11 = calculateRegularHours(totHrs11);
                                                                                    otHrs11 = calculateOverTime(totHrs11);

                                                                                    System.out.println("\n" + "Day 12: ");
                                                                                    System.out.print("Enter login time (HH:mm): ");
                                                                                    Scanner login12 = new Scanner(System.in);
                                                                                    String loginTimeString12 = login12.next();

                                                                                    System.out.print("Enter logout time (HH:mm): ");
                                                                                    Scanner logout12 = new Scanner(System.in);
                                                                                    String logoutTimeString12 = logout12.next();

                                                                                    totHrs12 = calculateTotalHoursWorked(loginTimeString12, logoutTimeString12);
                                                                                    regHrs12 = calculateRegularHours(totHrs12);
                                                                                    otHrs12 = calculateOverTime(totHrs12);

                                                                                    System.out.println("\n" + "Day 13: ");
                                                                                    System.out.print("Enter login time (HH:mm): ");
                                                                                    Scanner login13 = new Scanner(System.in);
                                                                                    String loginTimeString13 = login13.next();

                                                                                    System.out.print("Enter logout time (HH:mm): ");
                                                                                    Scanner logout13 = new Scanner(System.in);
                                                                                    String logoutTimeString13 = logout13.next();

                                                                                    totHrs13 = calculateTotalHoursWorked(loginTimeString13, logoutTimeString13);
                                                                                    regHrs13 = calculateRegularHours(totHrs13);
                                                                                    otHrs13 = calculateOverTime(totHrs13);

                                                                                    System.out.println("\n" + "Day 14: ");
                                                                                    System.out.print("Enter login time (HH:mm): ");
                                                                                    Scanner login14 = new Scanner(System.in);
                                                                                    String loginTimeString14 = login14.next();

                                                                                    System.out.print("Enter logout time (HH:mm): ");
                                                                                    Scanner logout14 = new Scanner(System.in);
                                                                                    String logoutTimeString14 = logout14.next();

                                                                                    totHrs14 = calculateTotalHoursWorked(loginTimeString14, logoutTimeString14);
                                                                                    regHrs14 = calculateRegularHours(totHrs14);
                                                                                    otHrs14 = calculateOverTime(totHrs14);

                                                                                    System.out.println("\n" + "Day 15: ");
                                                                                    System.out.print("Enter login time (HH:mm): ");
                                                                                    Scanner login15 = new Scanner(System.in);
                                                                                    String loginTimeString15 = login15.next();

                                                                                    System.out.print("Enter logout time (HH:mm): ");
                                                                                    Scanner logout15 = new Scanner(System.in);
                                                                                    String logoutTimeString15 = logout15.next();

                                                                                    totHrs15 = calculateTotalHoursWorked(loginTimeString15, logoutTimeString15);
                                                                                    regHrs15 = calculateRegularHours(totHrs15);
                                                                                    otHrs15 = calculateOverTime(totHrs15);

                                                                                    System.out.println("\n" + "Day 16: ");
                                                                                    System.out.print("Enter login time (HH:mm): ");
                                                                                    Scanner login16 = new Scanner(System.in);
                                                                                    String loginTimeString16 = login16.next();

                                                                                    System.out.print("Enter logout time (HH:mm): ");
                                                                                    Scanner logout16 = new Scanner(System.in);
                                                                                    String logoutTimeString16 = logout16.next();

                                                                                    totHrs16 = calculateTotalHoursWorked(loginTimeString16, logoutTimeString16);
                                                                                    regHrs16 = calculateRegularHours(totHrs16);
                                                                                    otHrs16 = calculateOverTime(totHrs16);

                                                                                    System.out.println("\n" + "Day 17: ");
                                                                                    System.out.print("Enter login time (HH:mm): ");
                                                                                    Scanner login17 = new Scanner(System.in);
                                                                                    String loginTimeString17 = login17.next();

                                                                                    System.out.print("Enter logout time (HH:mm): ");
                                                                                    Scanner logout17 = new Scanner(System.in);
                                                                                    String logoutTimeString17 = logout17.next();

                                                                                    totHrs17 = calculateTotalHoursWorked(loginTimeString17, logoutTimeString17);
                                                                                    regHrs17 = calculateRegularHours(totHrs17);
                                                                                    otHrs17 = calculateOverTime(totHrs17);

                                                                                    System.out.println("\n" + "Day 18: ");
                                                                                    System.out.print("Enter login time (HH:mm): ");
                                                                                    Scanner login18 = new Scanner(System.in);
                                                                                    String loginTimeString18 = login18.next();

                                                                                    System.out.print("Enter logout time (HH:mm): ");
                                                                                    Scanner logout18 = new Scanner(System.in);
                                                                                    String logoutTimeString18 = logout18.next();

                                                                                    totHrs18 = calculateTotalHoursWorked(loginTimeString18, logoutTimeString18);
                                                                                    regHrs18 = calculateRegularHours(totHrs18);
                                                                                    otHrs18 = calculateOverTime(totHrs18);

                                                                                    System.out.println("\n" + "Day 19: ");
                                                                                    System.out.print("Enter login time (HH:mm): ");
                                                                                    Scanner login19 = new Scanner(System.in);
                                                                                    String loginTimeString19 = login19.next();

                                                                                    System.out.print("Enter logout time (HH:mm): ");
                                                                                    Scanner logout19 = new Scanner(System.in);
                                                                                    String logoutTimeString19 = logout19.next();

                                                                                    totHrs19 = calculateTotalHoursWorked(loginTimeString19, logoutTimeString19);
                                                                                    regHrs19 = calculateRegularHours(totHrs19);
                                                                                    otHrs19 = calculateOverTime(totHrs19);
                                                                                } else {
                                                                                    if (noOfDays == 20) {
                                                                                        System.out.println("\n" + "Day 1: ");
                                                                                        System.out.print("Enter login time (HH:mm): ");
                                                                                        Scanner login1 = new Scanner(System.in);
                                                                                        String loginTimeString1 = login1.next();

                                                                                        System.out.print("Enter logout time (HH:mm): ");
                                                                                        Scanner logout1 = new Scanner(System.in);
                                                                                        String logoutTimeString1 = logout1.next();

                                                                                        totHrs1 = calculateTotalHoursWorked(loginTimeString1, logoutTimeString1);
                                                                                        regHrs1 = calculateRegularHours(totHrs1);
                                                                                        otHrs1 = calculateOverTime(totHrs1);

                                                                                        System.out.println("\n" + "Day 2: ");
                                                                                        System.out.print("Enter login time (HH:mm): ");
                                                                                        Scanner login2 = new Scanner(System.in);
                                                                                        String loginTimeString2 = login2.next();

                                                                                        System.out.print("Enter logout time (HH:mm): ");
                                                                                        Scanner logout2 = new Scanner(System.in);
                                                                                        String logoutTimeString2 = logout2.next();

                                                                                        totHrs2 = calculateTotalHoursWorked(loginTimeString2, logoutTimeString2);
                                                                                        regHrs2 = calculateRegularHours(totHrs2);
                                                                                        otHrs2 = calculateOverTime(totHrs2);

                                                                                        System.out.println("\n" + "Day 3: ");
                                                                                        System.out.print("Enter login time (HH:mm): ");
                                                                                        Scanner login3 = new Scanner(System.in);
                                                                                        String loginTimeString3 = login3.next();

                                                                                        System.out.print("Enter logout time (HH:mm): ");
                                                                                        Scanner logout3 = new Scanner(System.in);
                                                                                        String logoutTimeString3 = logout3.next();

                                                                                        totHrs3 = calculateTotalHoursWorked(loginTimeString3, logoutTimeString3);
                                                                                        regHrs3 = calculateRegularHours(totHrs3);
                                                                                        otHrs3 = calculateOverTime(totHrs3);

                                                                                        System.out.println("\n" + "Day 4: ");
                                                                                        System.out.print("Enter login time (HH:mm): ");
                                                                                        Scanner login4 = new Scanner(System.in);
                                                                                        String loginTimeString4 = login4.next();

                                                                                        System.out.print("Enter logout time (HH:mm): ");
                                                                                        Scanner logout4 = new Scanner(System.in);
                                                                                        String logoutTimeString4 = logout4.next();

                                                                                        totHrs4 = calculateTotalHoursWorked(loginTimeString4, logoutTimeString4);
                                                                                        regHrs4 = calculateRegularHours(totHrs4);
                                                                                        otHrs4 = calculateOverTime(totHrs4);

                                                                                        System.out.println("\n" + "Day 5: ");
                                                                                        System.out.print("Enter login time (HH:mm): ");
                                                                                        Scanner login5 = new Scanner(System.in);
                                                                                        String loginTimeString5 = login5.next();

                                                                                        System.out.print("Enter logout time (HH:mm): ");
                                                                                        Scanner logout5 = new Scanner(System.in);
                                                                                        String logoutTimeString5 = logout5.next();

                                                                                        totHrs5 = calculateTotalHoursWorked(loginTimeString5, logoutTimeString5);
                                                                                        regHrs5 = calculateRegularHours(totHrs5);
                                                                                        otHrs5 = calculateOverTime(totHrs5);

                                                                                        System.out.println("\n" + "Day 6: ");
                                                                                        System.out.print("Enter login time (HH:mm): ");
                                                                                        Scanner login6 = new Scanner(System.in);
                                                                                        String loginTimeString6 = login6.next();

                                                                                        System.out.print("Enter logout time (HH:mm): ");
                                                                                        Scanner logout6 = new Scanner(System.in);
                                                                                        String logoutTimeString6 = logout6.next();

                                                                                        totHrs6 = calculateTotalHoursWorked(loginTimeString6, logoutTimeString6);
                                                                                        regHrs6 = calculateRegularHours(totHrs6);
                                                                                        otHrs6 = calculateOverTime(totHrs6);

                                                                                        System.out.println("\n" + "Day 7: ");
                                                                                        System.out.print("Enter login time (HH:mm): ");
                                                                                        Scanner login7 = new Scanner(System.in);
                                                                                        String loginTimeString7 = login7.next();

                                                                                        System.out.print("Enter logout time (HH:mm): ");
                                                                                        Scanner logout7 = new Scanner(System.in);
                                                                                        String logoutTimeString7 = logout7.next();

                                                                                        totHrs7 = calculateTotalHoursWorked(loginTimeString7, logoutTimeString7);
                                                                                        regHrs7 = calculateRegularHours(totHrs7);
                                                                                        otHrs7 = calculateOverTime(totHrs7);

                                                                                        System.out.println("\n" + "Day 8: ");
                                                                                        System.out.print("Enter login time (HH:mm): ");
                                                                                        Scanner login8 = new Scanner(System.in);
                                                                                        String loginTimeString8 = login8.next();

                                                                                        System.out.print("Enter logout time (HH:mm): ");
                                                                                        Scanner logout8 = new Scanner(System.in);
                                                                                        String logoutTimeString8 = logout8.next();

                                                                                        totHrs8 = calculateTotalHoursWorked(loginTimeString8, logoutTimeString8);
                                                                                        regHrs8 = calculateRegularHours(totHrs8);
                                                                                        otHrs8 = calculateOverTime(totHrs8);

                                                                                        System.out.println("\n" + "Day 9: ");
                                                                                        System.out.print("Enter login time (HH:mm): ");
                                                                                        Scanner login9 = new Scanner(System.in);
                                                                                        String loginTimeString9 = login9.next();

                                                                                        System.out.print("Enter logout time (HH:mm): ");
                                                                                        Scanner logout9 = new Scanner(System.in);
                                                                                        String logoutTimeString9 = logout9.next();

                                                                                        totHrs9 = calculateTotalHoursWorked(loginTimeString9, logoutTimeString9);
                                                                                        regHrs9 = calculateRegularHours(totHrs9);
                                                                                        otHrs9 = calculateOverTime(totHrs9);

                                                                                        System.out.println("\n" + "Day 10: ");
                                                                                        System.out.print("Enter login time (HH:mm): ");
                                                                                        Scanner login10 = new Scanner(System.in);
                                                                                        String loginTimeString10 = login10.next();

                                                                                        System.out.print("Enter logout time (HH:mm): ");
                                                                                        Scanner logout10 = new Scanner(System.in);
                                                                                        String logoutTimeString10 = logout10.next();

                                                                                        totHrs10 = calculateTotalHoursWorked(loginTimeString10, logoutTimeString10);
                                                                                        regHrs10 = calculateRegularHours(totHrs10);
                                                                                        otHrs10 = calculateOverTime(totHrs10);

                                                                                        System.out.println("\n" + "Day 11: ");
                                                                                        System.out.print("Enter login time (HH:mm): ");
                                                                                        Scanner login11 = new Scanner(System.in);
                                                                                        String loginTimeString11 = login11.next();

                                                                                        System.out.print("Enter logout time (HH:mm): ");
                                                                                        Scanner logout11 = new Scanner(System.in);
                                                                                        String logoutTimeString11 = logout11.next();

                                                                                        totHrs11 = calculateTotalHoursWorked(loginTimeString11, logoutTimeString11);
                                                                                        regHrs11 = calculateRegularHours(totHrs11);
                                                                                        otHrs11 = calculateOverTime(totHrs11);

                                                                                        System.out.println("\n" + "Day 12: ");
                                                                                        System.out.print("Enter login time (HH:mm): ");
                                                                                        Scanner login12 = new Scanner(System.in);
                                                                                        String loginTimeString12 = login12.next();

                                                                                        System.out.print("Enter logout time (HH:mm): ");
                                                                                        Scanner logout12 = new Scanner(System.in);
                                                                                        String logoutTimeString12 = logout12.next();

                                                                                        totHrs12 = calculateTotalHoursWorked(loginTimeString12, logoutTimeString12);
                                                                                        regHrs12 = calculateRegularHours(totHrs12);
                                                                                        otHrs12 = calculateOverTime(totHrs12);

                                                                                        System.out.println("\n" + "Day 13: ");
                                                                                        System.out.print("Enter login time (HH:mm): ");
                                                                                        Scanner login13 = new Scanner(System.in);
                                                                                        String loginTimeString13 = login13.next();

                                                                                        System.out.print("Enter logout time (HH:mm): ");
                                                                                        Scanner logout13 = new Scanner(System.in);
                                                                                        String logoutTimeString13 = logout13.next();

                                                                                        totHrs13 = calculateTotalHoursWorked(loginTimeString13, logoutTimeString13);
                                                                                        regHrs13 = calculateRegularHours(totHrs13);
                                                                                        otHrs13 = calculateOverTime(totHrs13);

                                                                                        System.out.println("\n" + "Day 14: ");
                                                                                        System.out.print("Enter login time (HH:mm): ");
                                                                                        Scanner login14 = new Scanner(System.in);
                                                                                        String loginTimeString14 = login14.next();

                                                                                        System.out.print("Enter logout time (HH:mm): ");
                                                                                        Scanner logout14 = new Scanner(System.in);
                                                                                        String logoutTimeString14 = logout14.next();

                                                                                        totHrs14 = calculateTotalHoursWorked(loginTimeString14, logoutTimeString14);
                                                                                        regHrs14 = calculateRegularHours(totHrs14);
                                                                                        otHrs14 = calculateOverTime(totHrs14);

                                                                                        System.out.println("\n" + "Day 15: ");
                                                                                        System.out.print("Enter login time (HH:mm): ");
                                                                                        Scanner login15 = new Scanner(System.in);
                                                                                        String loginTimeString15 = login15.next();

                                                                                        System.out.print("Enter logout time (HH:mm): ");
                                                                                        Scanner logout15 = new Scanner(System.in);
                                                                                        String logoutTimeString15 = logout15.next();

                                                                                        totHrs15 = calculateTotalHoursWorked(loginTimeString15, logoutTimeString15);
                                                                                        regHrs15 = calculateRegularHours(totHrs15);
                                                                                        otHrs15 = calculateOverTime(totHrs15);

                                                                                        System.out.println("\n" + "Day 16: ");
                                                                                        System.out.print("Enter login time (HH:mm): ");
                                                                                        Scanner login16 = new Scanner(System.in);
                                                                                        String loginTimeString16 = login16.next();

                                                                                        System.out.print("Enter logout time (HH:mm): ");
                                                                                        Scanner logout16 = new Scanner(System.in);
                                                                                        String logoutTimeString16 = logout16.next();

                                                                                        totHrs16 = calculateTotalHoursWorked(loginTimeString16, logoutTimeString16);
                                                                                        regHrs16 = calculateRegularHours(totHrs16);
                                                                                        otHrs16 = calculateOverTime(totHrs16);

                                                                                        System.out.println("\n" + "Day 17: ");
                                                                                        System.out.print("Enter login time (HH:mm): ");
                                                                                        Scanner login17 = new Scanner(System.in);
                                                                                        String loginTimeString17 = login17.next();

                                                                                        System.out.print("Enter logout time (HH:mm): ");
                                                                                        Scanner logout17 = new Scanner(System.in);
                                                                                        String logoutTimeString17 = logout17.next();

                                                                                        totHrs17 = calculateTotalHoursWorked(loginTimeString17, logoutTimeString17);
                                                                                        regHrs17 = calculateRegularHours(totHrs17);
                                                                                        otHrs17 = calculateOverTime(totHrs17);

                                                                                        System.out.println("\n" + "Day 18: ");
                                                                                        System.out.print("Enter login time (HH:mm): ");
                                                                                        Scanner login18 = new Scanner(System.in);
                                                                                        String loginTimeString18 = login18.next();

                                                                                        System.out.print("Enter logout time (HH:mm): ");
                                                                                        Scanner logout18 = new Scanner(System.in);
                                                                                        String logoutTimeString18 = logout18.next();

                                                                                        totHrs18 = calculateTotalHoursWorked(loginTimeString18, logoutTimeString18);
                                                                                        regHrs18 = calculateRegularHours(totHrs18);
                                                                                        otHrs18 = calculateOverTime(totHrs18);

                                                                                        System.out.println("\n" + "Day 19: ");
                                                                                        System.out.print("Enter login time (HH:mm): ");
                                                                                        Scanner login19 = new Scanner(System.in);
                                                                                        String loginTimeString19 = login19.next();

                                                                                        System.out.print("Enter logout time (HH:mm): ");
                                                                                        Scanner logout19 = new Scanner(System.in);
                                                                                        String logoutTimeString19 = logout19.next();

                                                                                        totHrs19 = calculateTotalHoursWorked(loginTimeString19, logoutTimeString19);
                                                                                        regHrs19 = calculateRegularHours(totHrs19);
                                                                                        otHrs19 = calculateOverTime(totHrs19);

                                                                                        System.out.println("\n" + "Day 20: ");
                                                                                        System.out.print("Enter login time (HH:mm): ");
                                                                                        Scanner login20 = new Scanner(System.in);
                                                                                        String loginTimeString20 = login20.next();

                                                                                        System.out.print("Enter logout time (HH:mm): ");
                                                                                        Scanner logout20 = new Scanner(System.in);
                                                                                        String logoutTimeString20 = logout20.next();

                                                                                        totHrs20 = calculateTotalHoursWorked(loginTimeString20, logoutTimeString20);
                                                                                        regHrs20 = calculateRegularHours(totHrs20);
                                                                                        otHrs20 = calculateOverTime(totHrs20);
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        double totHrs = totHrs1 + totHrs2 + totHrs3 + totHrs4 + totHrs5 + totHrs6 + totHrs7 + totHrs8 + totHrs9 + totHrs10
                + totHrs11 + totHrs12 + totHrs13 + totHrs14 + totHrs15 + totHrs16 + totHrs17 + totHrs18 + totHrs19 + totHrs20;
        double totRG = regHrs1 + regHrs2 + regHrs3 + regHrs4 + regHrs5 + regHrs6 + regHrs7 + regHrs8 + regHrs9 + regHrs10
                + regHrs11 + regHrs12 + regHrs13 + regHrs14 + regHrs15 + regHrs16 + regHrs17 + regHrs18 + regHrs19 + regHrs20;
        double totOT = otHrs1 + otHrs2 + otHrs3 + otHrs4 + otHrs5 + otHrs6 + otHrs7 + otHrs8 + otHrs9 + otHrs10
                + otHrs11 + otHrs12 + otHrs13 + otHrs14 + otHrs15 + otHrs16 + otHrs17 + otHrs18 + otHrs19 + otHrs20;

        System.out.println("\n" + "Total Login Hours:     " + totHrs + "\n"
                + "Total Regular Hours:    " + totRG + "\n"
                + "Total Over-Time Hours:  " + totOT + "\n");
        if (totOT == 0) {
            taxableWage = totRG * hrlyRate;
            taxableWage = Math.round(taxableWage * 100.0) / 100.0;
            System.out.println("\n" + "Total taxable earnings =    " + taxableWage);
        } else {

            System.out.println("\n" + "Would you like to pay the overtime hours? Type yes or no: ");
            Scanner otQ = new Scanner(System.in);
            String otAns = otQ.next();
            if ("no".equals(otAns.toLowerCase())) {
                taxableWage = totRG * hrlyRate;
                taxableWage = Math.round(taxableWage * 100.0) / 100.0;
                System.out.println("\n" + "Total taxable earnings =    " + taxableWage);
            } else {
                if ("yes".equals(otAns.toLowerCase())) {
                    System.out.println("\n" + "Enter OverTime Rate: (example enter 1.25 for 125% rate): ");
                    Scanner otR = new Scanner(System.in);
                    double otRate = otR.nextDouble();
                    double taxableRGWage = (totRG * hrlyRate);
                    taxableRGWage = Math.round(taxableRGWage * 100.0) / 100.0;
                    double taxableOTWage = ((totOT * hrlyRate) * otRate);
                    taxableOTWage = Math.round(taxableOTWage * 100.0) / 100.0;
                    taxableWage = taxableRGWage + taxableOTWage;
                    taxableWage = Math.round(taxableWage * 100.0) / 100.0;
                    System.out.println("\n" + "Taxable earnings from regular hours:    " + taxableRGWage + "\n"
                            + "Taxable earnings from overtime hours:   " + taxableOTWage + "\n"
                            + "Total taxable earnings =               " + taxableWage);
                }
            }

        }
        return taxableWage;
    }

    public static double calculateSSS(double netGross) {
        ArrayList<Integer> sssSalary = new ArrayList<>();
        ArrayList<Double> sssContribution = new ArrayList<>();

        // create Salary range
        for (int i = 0; i < 44; i++) {
            int premium = 3250 + 500 * i;
            sssSalary.add(premium);
        }

        // create contribution range
        for (int i = 0; i < 44; i++) {
            double contribution = 135 + 22.5 * i;
            sssContribution.add(contribution);
        }

        // determine SSS deduction
        double sSS = 0;
        for (int i = 0; i < 44; i++) {
            if (netGross < sssSalary.get(i)) {
                sSS = sssContribution.get(i);
                break;
            } else {
                sSS = 1125.0;   // max contribution
            }
        }
        
        sSS = Math.round(sSS * 100.0) / 100.0;
        return sSS;
    }

    public static double calculatePhilHealth(double netGross) {
        double pHealthCalc = netGross * 0.03;
        double philHealth = 0;
        if (netGross < 10000) {
            philHealth = 0;
        } else {
            if (pHealthCalc > 1800) {
                philHealth = 1800 / 2;
            } else {
                if (netGross >= 10000 && netGross <= 60000) {
                    philHealth = (netGross * 0.03) / 2;
                }
            }
        }

        philHealth = Math.round(philHealth * 100.0) / 100.0;
        return philHealth;
    }

    public static double calculatePagibig(double netGross) {
        double pIbigCalc1 = netGross * 0.01;
        double pIbigCalc2 = netGross * 0.02;
        double pagIbig = 0;
        if (netGross >= 1000 && netGross <= 1500 && pIbigCalc1 > 100) {
            pagIbig = 100;
        } else {
            if (netGross >= 1000 && netGross <= 1500 && pIbigCalc1 <= 100) {
                pagIbig = netGross * 0.01;
            } else {
                if (netGross > 1500 && pIbigCalc2 > 100) {
                    pagIbig = 100;
                } else {
                    if (netGross > 1500 && pIbigCalc1 <= 100) {
                        pagIbig = netGross * 0.02;
                    } else {
                        if (netGross < 1000) {
                            pagIbig = 0;
                        }
                    }
                }
            }
        }
             
        
        pagIbig = Math.round(pagIbig * 100.0) / 100.0;
        return pagIbig;
    }

    public static double calculateWitholdingTax(double net) {
        double wTax = 0;
        if (net <= 20832) {
            wTax = 0;
        } else {
            if (net >= 20833 && net < 33333) {
                wTax = (net - 20833) * 0.20;
            } else {
                if (net >= 33333 && net < 66667) {
                    wTax = 2500 + ((net - 33333) * 0.25);
                } else {
                    if (net >= 66667 && net < 166667) {
                        wTax = 10833 + ((net - 66667) * 0.30);
                    } else {
                        if (net >= 166667 && net < 666667) {
                            wTax = 40833.33 + ((net - 166667) * 0.32);
                        } else {
                            if (net > 666667) {
                                wTax = 200833.33 + ((net - 666667) * 0.35);
                            }
                        }
                    }
                }
            }
        }
        wTax = Math.round(wTax * 100.0) / 100.0;
        return wTax;
    }

    public static void payslipNObenefits(double netGross, double sssDed, double pHealthDed,
            double pagIbigDed, double withHTax, int eeNo, String lastN, String firstN) {
        double sssPHpi = sssDed + pHealthDed + pagIbigDed;
        sssPHpi = (Math.round(sssPHpi * 100.0) / 100.0);
        double net = netGross - sssPHpi;
        net = (Math.round(net * 100.0) / 100.0);
        double netPay = net - withHTax;
        netPay = (Math.round(netPay * 100.0) / 100.0);
        String compN = lastN + ", " + firstN;

        System.out.println("\n" + "Employee Number:     " + eeNo);
        System.out.println("Employee Name:      " + compN);
        System.out.println("    ---------------------------------------------------------------");
        System.out.println("    Total Earnings:                                 " + netGross + "\n");
        System.out.println("    SSS Deduction:                                  " + sssDed);
        System.out.println("    Philhealth Deduction:                           " + pHealthDed);
        System.out.println("    Pag-ibig Deduction:                             " + pagIbigDed);
        System.out.println("    TOTAL DEDUCTIONS:                               " + sssPHpi + "\n");
        System.out.println("    TAXABLE INCOME (Salary - Total Deductions):     " + net + "\n");
        System.out.println("    WITHHOLDING TAX:                                " + withHTax + "\n");
        System.out.println("    ---------------------------------------------------------------");
        System.out.println("    NET PAY:                                        " + netPay);
        System.out.println("    ---------------------------------------------------------------" + "\n");

        try {
            FileWriter payOutput = new FileWriter("paySummary.txt", true);
            PrintWriter payOut = new PrintWriter(payOutput);

            payOut.printf("\n%-15d", eeNo);
            payOut.printf("%-33s", compN);
            payOut.printf("%-16s", netGross);
            payOut.printf("%-12s", sssDed);
            payOut.printf("%-20s", pHealthDed);
            payOut.printf("%-16s", pagIbigDed);
            payOut.printf("%-24s", withHTax);
            payOut.printf("%-15s", 0);
            payOut.printf("%-15s", netPay);

            System.out.println("paySummary File updated..." + "\n");
            payOutput.close();
        } catch (IOException ex) {
            System.out.println("File append error...");
        }

        System.out.println("What would you like to do next? " + "\n"
                + "A. Calculate Salary for another employee" + "\n"
                + "B. View payroll input summary file" + "\n"
                + "Enter letter of your choice (a or b)");
        Scanner next = new Scanner(System.in);
        String nextTask = next.next();
        if ("a".equals(nextTask.toLowerCase())) {
            clearConsole();
            enterEmployeeNo();
        } else {
            if ("b".equals(nextTask.toLowerCase())) {
                viewSummary();
            } else {
                System.out.println("!!! INVALID ENTRY ENTERED !!!" + "\n");
            }
        }
        clearConsole();
        enterEmployeeNo();

    }

    public static void payslipWITHbenefits(double netGross, double sssDed, double pHealthDed,
            double pagIbigDed, double withHTax, double nBen,
            double rice, double phone, double clothing, int eeNo, String lastN, String firstN) {
        double sssPHpi = sssDed + pHealthDed + pagIbigDed;
        sssPHpi = (Math.round(sssPHpi * 100.0) / 100.0);
        double net = netGross - sssPHpi;
        net = (Math.round(net * 100.0) / 100.0);
        double netPay = net - withHTax;
        double netPaywithBen = netPay + nBen;
        netPaywithBen = (Math.round(netPaywithBen * 100.0) / 100.0);
        String compN = lastN + ", " + firstN;

        System.out.println("\n" + "Employee Number:     " + eeNo);
        System.out.println("Employee Name:      " + compN);
        System.out.println("    ---------------------------------------------------------------");
        System.out.println("    Total Earnings:                                 " + netGross + "\n");
        System.out.println("    SSS Deduction:                                  " + sssDed);
        System.out.println("    Philhealth Deduction:                           " + pHealthDed);
        System.out.println("    Pag-ibig Deduction:                             " + pagIbigDed);
        System.out.println("    TOTAL DEDUCTIONS:                               " + sssPHpi + "\n");
        System.out.println("    TAXABLE INCOME (Salary - Total Deductions):     " + net + "\n");
        System.out.println("    WITHHOLDING TAX:                                " + withHTax + "\n");
        System.out.println("    Non-Taxable Benefits:                           " + nBen);
        System.out.println("        Rice Subsidy:                      " + rice);
        System.out.println("        Phone Allowance:                   " + phone);
        System.out.println("        Clothing Allowance:                " + clothing + "\n");
        System.out.println("    ---------------------------------------------------------------");
        System.out.println("    NET PAY:                                        " + netPaywithBen);
        System.out.println("    ---------------------------------------------------------------" + "\n");

        try {
            FileWriter payOutput = new FileWriter("paySummary.txt", true);
            PrintWriter payOut = new PrintWriter(payOutput);

            payOut.printf("\n%-15d", eeNo);
            payOut.printf("%-33s", compN);
            payOut.printf("%-16s", netGross);
            payOut.printf("%-12s", sssDed);
            payOut.printf("%-20s", pHealthDed);
            payOut.printf("%-16s", pagIbigDed);
            payOut.printf("%-24s", withHTax);
            payOut.printf("%-15s", nBen);
            payOut.printf("%-15s", netPaywithBen);

            System.out.println("paySummary File updated..." + "\n");
            payOutput.close();
        } catch (IOException ex) {
            System.out.println("File append error...");
        }

        System.out.println("What would you like to do next? " + "\n"
                + "A. Calculate Salary for another employee" + "\n"
                + "B. View payroll input summary file" + "\n"
                + "Enter letter of your choice (a or b)");
        Scanner next = new Scanner(System.in);
        String nextTask = next.next();
        if ("a".equals(nextTask.toLowerCase())) {
            clearConsole();
            enterEmployeeNo();
        } else {
            if ("b".equals(nextTask.toLowerCase())) {
                viewSummary();
            } else {
                System.out.println("!!! INVALID ENTRY ENTERED !!!" + "\n");
            }
        }
        clearConsole();
        enterEmployeeNo();

    }

    public static void viewSummary() {
        clearConsole();
        //print out list of employee
        System.out.println("\nHello, Here's the pay data captured on the Pay Summary file\n");

        try {
            BufferedReader payrollSummary = new BufferedReader(new FileReader("paySummary.txt"));
            String line;
            while ((line = payrollSummary.readLine()) != null) {
                System.out.println(line);
            }
            payrollSummary.close();
        } catch (IOException e) {
            System.out.println("Error ecountered reading the file...");
        }

        System.out.println("\n Continue with payroll calculation.\n");
        enterEmployeeNo();
    }

    public static void clearConsole() {
        // Print 50 empty lines to "clear" the console
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
        System.out.println("Console cleared!");
    }
    
    public static int[] employeeNumberDatabase() {
        int[] employeeNumber = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
            11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
            21, 22, 23, 24, 25, 26, 27, 28, 29, 30,
            31, 32, 33, 34};

        return employeeNumber;
    }

}
