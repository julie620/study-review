import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class StudyReview {
    private ArrayList<Subject> subjectList = new ArrayList<Subject>();
    private File[] subjectFiles;

    public void menuOpt() {
        System.out.println("Welcome to your Study Reviewer!");
        System.out.println("Please Choose One of the Following Options:");
        System.out.println("1) Browse Subjects");
        System.out.println("2) Add Subject");
        System.out.println("3) Remove Subject");
        System.out.println("4) Exit");
    }

    public void subjectOpt() {
        String folderPath = "src\\Subjects";
        File folder = new File(folderPath);
        subjectFiles = folder.listFiles();
        System.out.println("The available subjects to study are: ");
        for (int i = 0; i < subjectFiles.length; i++) {
            int subjectNum = i + 1;
            System.out.println(subjectNum + ") " + subjectFiles[i].getName());
        }
    }

    public int subjectChoice() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number of subject to start studying");
        int choice = input.nextInt();
        input.nextLine();
        return choice;
    }

    public void startStudy(int choice) {
        Scanner input = new Scanner(System.in);
        Subject currentSubject = subjectList.get(choice - 1);
        System.out.println("You are now studying " + currentSubject.getSubjectName());
        ArrayList<String> termList = currentSubject.getTermList();
        for (int i = 0; i < termList.size(); i++) {
            System.out.println("What does this term mean: " + termList.get(i));
            String answer = input.nextLine();
            if (checkAnswer(answer, termList.get(i), currentSubject) == true) {
                System.out.println("CORRECT");
            } else {
                System.out.println("INCORRECT");
            }
        }

        System.out.println("STUDY SESSION DONE");
    }

    public Boolean checkAnswer(String answer, String term, Subject currentSubject) {
        Boolean validAnswer = false;
        String definition = currentSubject.get(term);
        //System.out.println(definition);
        if (answer.equals(definition)) {
            validAnswer = true;
            return validAnswer;
        } else {
            return validAnswer;
        }
    }

    public void addAtStart() {
        for (int i = 0; i < subjectFiles.length; i++) {
            String regex = ".txt";
            String subjectName = subjectFiles[i].getName().replaceAll(regex, "");
            retrieve(subjectName);
        }
    }

    public void retrieve(String subjectName) {
        Subject newSubject = new Subject(subjectName);
        try {
            File myObj = new File("src\\Subjects\\" + subjectName + ".txt");
            Scanner myReader = new Scanner(myObj);
            String term = null;
            String definiton = null;;
            while(myReader.hasNextLine()) {
                String data = myReader.nextLine();
                char type = data.charAt(0);
                if (type == 'T') {
                    String regex = "T:";
                    term = data.replaceAll(regex, "");
                    //System.out.println(term);
                    //System.out.println("Got term ");
                } else {
                    String regex = "D:";
                    definiton = data.replaceAll(regex, "");
                    newSubject.add(term, definiton);
                    //System.out.println(definiton);
                    //System.out.println("Got topic");
                }
                //System.out.println("next line");
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occured."); {
            e.printStackTrace();
            }
        }
        subjectList.add(newSubject);
    }


}
