import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

class Student{
    int id;
    String name;
    String gender;
    String className;
    float score;


    Student(){}
    Student(int id,String name,String gender,String className,float score){
        this.id=id;
        this.name=name;
        this.gender=gender;
        this.className=className;
        this.score=score;
    }

    void InputStudent(Scanner input){
        boolean isValid=false;
        boolean isScoreValid=false;

        do {
            try {
                System.out.println("Input Student Id: ");
                id = input.nextInt();
                isValid=true;
            }catch (Exception ex){
                isValid=false;
                System.out.println("!!!!!!!InputId Must be input with Number! Try again. ");
                input.nextLine();
            }

        }while (!isValid);

        System.out.println("Input Student Name: ");
        input.nextLine();
        name = input.nextLine();
        System.out.println("Input Student Gender: ");
        gender = input.nextLine();
        System.out.println("Input Student ClassName: ");
        className = input.nextLine();

        do {
            try {
                System.out.println("Input Student Score: ");
                score = input.nextFloat();
                isScoreValid=true;
            }catch (Exception ex){
                isScoreValid=false;
                System.out.println("!!!!!Input score must be number!!!!!");
                input.nextLine();
            }
        }while (!isScoreValid);


    }

    void OutputStudent(){
        System.out.println("==================================================");
        System.out.println("Student Id: "+id);
        System.out.println("Student Name: "+name);
        System.out.println("Student Gender: "+gender);
        System.out.println("Student ClassName: "+className);
        System.out.println("Student Score: "+score);
    }
    void updateStudent(Scanner input){

        boolean isScoreValid=false;
        System.out.println("Input Student to Update Name: ");
        input.nextLine();
        name = input.nextLine();
        System.out.println("Input Student to Update Gender: ");
        gender = input.nextLine();
        System.out.println("Input Student to Update ClassName: ");
        className = input.nextLine();

        do {
            try {
                System.out.println("Input Student to Update Score: ");
                score = input.nextFloat();
                isScoreValid=true;
            }catch (Exception ex){
                isScoreValid=false;
                System.out.println("!!!!!Input score must be number!!!!!");
                input.nextLine();
            }
        }while (!isScoreValid);
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Student> listStudent = new ArrayList<>();
        int op=0;
        do {

            System.out.println("-----------------------Student Management System-----------------------");
            System.out.println("1. Input Student ");
            System.out.println("2. Update Student Information");
            System.out.println("3. Delete Student");
            System.out.println("4. Search Student ");
            System.out.println("5. Show Student Information");
            System.out.println("6. Exit");
            System.out.println("Choose 1-6 from option");
            op=0;
            try {
                op = input.nextInt();
            }catch (Exception ex){
                System.out.println("You cannot enter option with String! ");
                input.nextLine();
            }


            switch (op){
                case 1:
                    int NOS;
                    int count=0;
                    System.out.println("===================Input Student=================");
                    System.out.println("How many Student you want to Input: ");
                    NOS=input.nextInt();
                    for (int i=0; i<NOS; i++){
                        System.out.println(">>>>>>Input Student: "+(i+1));
                        Student student = new Student();
                        student.InputStudent(input);
                        listStudent.add(student);
                        count++;
                    }
                    System.out.println("Succes to Input of "+count+" Students ");

                    break;
                case 2:
                    int updateId;
                    boolean isStudentfound=false;
                    System.out.println("==================Update Student Information==================");
                    System.out.println("Input Student Id to update: ");
                    updateId=input.nextInt();
                    for (int i=0;i<listStudent.size();i++){
                        if (updateId==listStudent.get(i).id){
                            isStudentfound=true;
                            Student udStudentID = listStudent.get(i);
                            udStudentID.updateStudent(input);
                            listStudent.set(i,udStudentID);
                        }else {
                            isStudentfound=false;
                        }
                    }
                    if (!isStudentfound){
                        System.out.println("the provided ID doesn't exists in the system ");
                    }else {
                        System.out.println("Update Student Succesful ");
                    }
                    break;
                case 3:
                    int deleteId;
                    boolean isRecordE=false;
                    System.out.println("==================Delete Student==================");
                    System.out.println("Input Student Id to delete: ");
                    deleteId=input.nextInt();
                    for (int i=0;i<listStudent.size();i++){
                        if (deleteId==listStudent.get(i).id){
                            isRecordE=true;
                            listStudent.remove(i);
                            System.out.println("Succesful to Delete");
                        }else
                            isRecordE=false;
                    }
                    if (!isRecordE){
                        System.out.println("Failed to Delete Student!");
                    }
                    break;
                case 4:
                    System.out.println("==================Search Student===================");
                    System.out.println("1. Search By Id");
                    System.out.println("2. Search By Name");
                    System.out.println("3. Search By Gender");
                    System.out.println("4. Search By ClassName");
                    System.out.println("5. Search By Score");
                    System.out.println("Chosse 1 option to search: ");
                    int searchOption;
                    searchOption = input.nextInt();
                    switch(searchOption){
                        case 1 :
                            int searchID;
                            boolean idStudentExist = false;
                            System.out.println("*********** Search By ID *********** ");
                            System.out.println("Enter ID to search : ");
                            searchID = input.nextInt();

                            for(int i = 0; i < listStudent.size(); i++){
                                if(searchID== listStudent.get(i).id){
                                    idStudentExist = true;
                                    listStudent.get(i).OutputStudent();
                                }
                            }
                            if(!idStudentExist){
                                System.out.println("Student with ID = "+searchID+" doesn't exist !!!");
                            }
                            input.nextLine();
                            break;
                        case 2 :
                            input.nextLine();
                            String searchName ;
                            boolean isNameExist=false;
                            System.out.println("*********** Search By Name *********** ");
                            System.out.println("Enter name to search : ");
                            searchName = input.nextLine();
                            for(int i =0; i < listStudent.size(); i++){
                                if(searchName.equalsIgnoreCase(listStudent.get(i).name)){
                                    isNameExist=true;
                                    listStudent.get(i).OutputStudent();
                                }
                            }
                            if (!isNameExist){
                                System.out.println("Student with Name = "+searchName+" doesn't exist !!!!!");
                            }
                            input.nextLine();
                            break;
                        case 3:
                            input.nextLine();
                            boolean isGenderExist=false;
                            String searchGender;
                            System.out.println("*********** Search By Gender *********** ");
                            System.out.println("Enter Gender to search: ");
                            searchGender = input.nextLine();
                            for (int i=0;i<listStudent.size(); i++){
                                if (searchGender.equalsIgnoreCase(listStudent.get(i).gender)){
                                    isGenderExist=true;
                                    listStudent.get(i).OutputStudent();
                                }
                            }
                            if (!isGenderExist){
                                System.out.println("Student with Gender= "+searchGender+" doesn't exist!!!!");
                            }
                            input.nextLine();
                            break;
                        case 4:
                            input.nextLine();
                            boolean isClassNExist=false;
                            String searchClassName;
                            System.out.println("*********** Search By ClassName *********** ");
                            System.out.println("Enter ClassName to search: ");
                            searchClassName = input.nextLine();
                            for (int i=0;i<listStudent.size(); i++){
                                if (searchClassName.equalsIgnoreCase(listStudent.get(i).className)){
                                    isClassNExist=true;
                                    listStudent.get(i).OutputStudent();
                                }
                            }
                            if (!isClassNExist){
                                System.out.println("Student with Gender= "+searchClassName+" doesn't exist!!!!");
                            }
                            input.nextLine();
                            break;
                        case 5 :
                            int searchScore;
                            boolean scoreStudentExist = false;
                            System.out.println("*********** Search By Score *********** ");
                            System.out.println("Enter Score to search : ");
                            searchScore = input.nextInt();

                            for(int i = 0; i < listStudent.size(); i++){
                                if(searchScore== listStudent.get(i).score){
                                    scoreStudentExist = true;
                                    listStudent.get(i).OutputStudent();
                                }
                            }
                            if(!scoreStudentExist){
                                System.out.println("Student with ID = "+searchScore+" doesn't exist !!!");
                            }
                            break;
                    }
                    input.nextLine();
                    break;
                case 5:
                    System.out.println("==================Show Student Information==================");
                    for (int i=0; i< listStudent.size(); i++){
                        listStudent.get(i).OutputStudent();
                    }
                    break;
                case 6:
                    System.out.println("Exit the system......<3");
                    break;
                default:
                    System.out.println("Wrong option!");

            }

        }while (op!=6);
    }


}