
package hms;

import java.util.Scanner;

public class HMS {

    public static void main(String[] args) {

        PatientList plist = new PatientList();
        DoctorList dlist = new DoctorList();
        Scanner sc = new Scanner(System.in);

        while (true) {
            MainMenu();
            String choice = sc.nextLine();
            if (choice.equals("1")) {
                System.out.println("\n Doctor ID: ");
                String Id = sc.nextLine();

                System.out.println("\n Doctor Name: ");
                String name = sc.nextLine();

                System.out.println("\n Doctor Contact ");
                String contact = sc.nextLine();

                System.out.println("\n Doctor Specialty ");
                String specialty = sc.nextLine();

                System.out.println("\n Doctor Fee ");
                int fee = sc.nextInt();
                sc.nextLine();

                Doctor doctor = new Doctor(Id, name, contact, specialty, fee);
                dlist.insertNode(doctor);

            }
            else if (choice.equals("2")) {
                System.out.println("\n Patient ID: ");
                String Id = sc.nextLine();

                System.out.println("\n Patient Name: ");
                String name = sc.nextLine();

                System.out.println("\n Patient Contact ");
                String contact = sc.nextLine();
                sc.nextLine();

                Patient patient = new Patient(Id, name, contact);
                plist.insertNode(patient);

            }
            else if (choice.equals("3")) {
                dlist.printData();
            } else if (choice.equals("4")) {
                plist.printData();
            }
            else if (choice.equals("5")) {
                System.out.println("Welcome to checkUp Menu");
                CheckupList[] clist = new CheckupList[dlist.size()];

                for (int i = 0; i < clist.length; i++) {
                    clist[i] = new CheckupList();
                    Doctor doctor = dlist.getAtIndex(i);
                    System.out.println("\n\n Enter Patient for Doctor");
                    System.out.println("Name    " + doctor.getName());
                    System.out.println("specialty    " + doctor.getSpeciality());
                    System.out.println("fee    " + doctor.getFees());

                    System.out.println("All patients");
                    plist.printData();

                    while (true) {
                        System.out.println("Enter patient Id or print null to exit");
                        String id = sc.nextLine();

                        if (id.equals("null")) {
                            break;
                        }
                        System.out.println("priority 3 for emergency 2 for intermediate any other key for normal");
                        String per = sc.nextLine();

                        int p = 1;
                        if (per.equals("3")) {
                            p = 3;
                        } else if (per.equals("2")) {
                            p = 2;
                        }
                        
                        Patient patient = plist.searchById(id);
                        if (patient.equals(null)) {
                            System.out.println("\n Invalid patient ID: \n");
                        } else {
                            CheckUp checkUp = new CheckUp(doctor, patient, p, "", "" + java.util.Calendar.getInstance().getTime().toString());
                            clist[i].enQueue(checkUp);
                        }
                    }
                }
                for(int i = 0; i<clist.length; i++){
                    System.out.println("\n\nPatient  "+(i+1)+"In Queue for Doctor "+dlist.getAtIndex(i).getName());
                    for(int j =0; j<clist[i].size(); j++){
                        System.out.println("Enter recommendation for patient"+clist[i].getPatient(j));
                        String rec = sc.nextLine();
                        clist[i].addRecommendation(j, rec);
                    }
                }
                
            }
            else if(choice.equals("0"))
            {
                break;
            }
            else{
                System.out.println("\n Invalid choice: \n");
            }
            
         }  
    }

    private static void MainMenu() {
        System.out.println("\nn ||      ***HMS***       ||");
        System.out.println("        ||Main Menu||       ");
        System.out.println("Enter 1 to insert new Doctor");
        System.out.println("Enter 2 to insert new patient");
        System.out.println("Enter 3 to print all Doctors");
        System.out.println("Enter 4 to print all patients");
        System.out.println("Enter 5 for Checkup Menu");
        System.out.println("Enter 0 to exit");
    }
    
}

