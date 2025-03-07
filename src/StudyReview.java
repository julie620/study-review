/*
 * Author: Juliana Serrano
 * Last Modified: 03/07/2025
 * Lab 6: Hashing
 * The StudyReview Class provides methods to study and modify different subjects and topics
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class StudyReview {
    private ArrayList<Subject> subjectList = new ArrayList<Subject>();
    private ArrayList<File> subjectFiles = new ArrayList<File>();
    private Scanner input = new Scanner(System.in);
    private ASCII letterArt = new ASCII();

    public void run() {
        letterArt.introArt();
        System.out.println("Welcome to your Study Reviewer");
        System.out.println("With this program you can review topics from different subjects.");
        System.out.println("Have Fun Studying!");
        addAtStart();
        Boolean studying = true;
        do {
            studying = menuOpt();
        }
        while(studying);
    }

    //displays menu options
    public Boolean menuOpt() {
        letterArt.sectionLines();
        System.out.println("Please Choose One of the Following Options:");
        System.out.println("1) Browse Subjects");
        System.out.println("2) Exit");
        int choice = input.nextInt();
        input.nextLine();
        switch (choice) {
            case 1:
                subjectOpt();
                break;
            case 2:
                return false;
            default:
                System.out.println("That choice was invalid.");
                break;
        }
        return true;
    }

    // displays available subjects and study/modify options
    public void subjectOpt() {
        letterArt.sectionLines();
        System.out.println("The available subjects are: ");
        String regex = ".txt";
        for (int i = 0; i < subjectFiles.size(); i++) {
            int subjectNum = i + 1;
            String subjectName = subjectFiles.get(i).getName().replaceAll(regex, "");
            System.out.println(subjectNum + ") " + subjectName);
        }
        int subjectChoice = subjectChoice();
        letterArt.sectionLines();
        System.out.println("What would you like to do?");
        System.out.println("1) Study Subject");
        System.out.println("2) Modify Subject");
        int choice = input.nextInt();
        input.nextLine();
        switch (choice) {
            case 1:
                startStudy(subjectChoice);
                break;
            case 2:
                modOpt(subjectChoice);
                break;
            default:
                System.out.println("That choice was invalid");
                break;
        }
    }

    // displays modification options add/remove
    public void modOpt(int subjectChoice) {
        letterArt.sectionLines();
        Subject currentSubject = subjectList.get(subjectChoice);
        System.out.println("Please Choose One of the Following Options:");
        System.out.println("1) Add Topic");
        System.out.println("2) Remove Topic");
        int choice = input.nextInt();
        input.nextLine();
        switch (choice) {
            case 1:
                addTopic(currentSubject);
                break;
            case 2:
                removeTopic(currentSubject);
                break;
            default:
                System.out.println("That choice was invalid");
                break;
        }
    }

    public void addTopic(Subject currentSubject) {
        String term;
        String defintion;
        if (currentSubject.getSubjectName().equals("MATH")) {
            System.out.println("Enter Problem: ");
            term = input.nextLine();
            System.out.println("Enter Answer: ");
            defintion = input.nextLine();
        } else {
            System.out.println("Enter Term: ");
            term = input.nextLine();
            System.out.println("Enter Defninition: ");
            defintion = input.nextLine();
        }
        currentSubject.add(term, defintion); // adds new topic with usier input for term/definition
        //adds new topic to subejct file
        String fileName = "src\\Subjects\\" + currentSubject.getSubjectName() + ".txt";
        String newTopic = "\nT:" + term + "\nD:" + defintion;
        try ( FileWriter fw = new FileWriter(fileName, true)){
            fw.write(newTopic);
        } catch (IOException e) {
            System.out.println("An error occured.");
            e.printStackTrace();
        }
        System.out.println("Topic Successfully Added!");
    }

    public void removeTopic(Subject currentSubject) {
        String term = termChoice(currentSubject);
        //creates temporary file to copy all topics except the one to be removed
        String fileName = "src\\Subjects\\" + currentSubject.getSubjectName() + ".txt";
        File subjectFile = new File(fileName);
        String tempPath = "src\\Subjects\\temp.txt";
        File tempFile = new File(tempPath);
        String termLine = "T:" + term;
        String definitionLine = "D:" + currentSubject.get(term);
        try {
            Scanner myReader = new Scanner(subjectFile);
            while(myReader.hasNextLine()) {
                String line = myReader.nextLine();
                if (line.equals(termLine) || line.equals(definitionLine)) {
                } else {
                    try ( FileWriter fw = new FileWriter(tempFile, true)){
                        fw.write(line + "\n");
                    } catch (IOException e) {
                        System.out.println("An error occured.");
                        e.printStackTrace();
                    }
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occured."); {
            e.printStackTrace();
            }
        }
        subjectFile.delete(); // deletes old subject folder
        File saveFile = new File (fileName);
        tempFile.renameTo(saveFile); // saves new modified subejct folder
        currentSubject.remove(term); // removes specified topic
        System.out.println("Topic Successfully Removed");
    }

    // returns the term that the user would like to remove
    public String termChoice(Subject currentSubject) {
        letterArt.sectionLines();
        ArrayList<String> termList = currentSubject.getTermList();
        if (currentSubject.getSubjectName().equals("MATH")) {
            System.out.println("The available problems are: ");
        } else {
            System.out.println("The available terms are: ");
        }
        for (int i = 0; i < termList.size(); i++) {
            int termNum = i + 1;
            System.out.println(termNum + ") " + termList.get(i));
        }
        letterArt.sectionLines();
        if (currentSubject.getSubjectName().equals("MATH")) {
            System.out.println("Enter the number of the problem you would like to remove: ");
        } else {
            System.out.println("Enter the number of the term you would like to remove: ");
        }
        int num = input.nextInt();
        input.nextLine();
        String term = termList.get(num - 1);
        return term;
    }

    // returns the users subject choice
    public int subjectChoice() {
        letterArt.sectionLines();
        System.out.println("Choose a Subject: ");
        int choice = input.nextInt();
        input.nextLine();
        return choice - 1;
    }

    // starts study "session" for a subject
    public void startStudy(int choice) {
        Subject currentSubject = subjectList.get(choice);
        letterArt.sectionLines();
        System.out.println("You are now studying " + currentSubject.getSubjectName());
        letterArt.printStart();
        ArrayList<String> termList = currentSubject.getTermList();
        for (int i = 0; i < termList.size(); i++) {
            letterArt.sectionLines();
            if(currentSubject.getSubjectName().equals("MATH")) {
                System.out.println("What is the answer to: " + termList.get(i));
            } else {
                System.out.println("What does this term mean: " + termList.get(i));
            }
            String answer = input.nextLine();
            if (checkAnswer(answer, termList.get(i), currentSubject) == true) {
                System.out.println("CORRECT");
            } else {
                System.out.println("INCORRECT");
            }
        }
        letterArt.printDone();
    }

    // checks the user's answers against stored definitons
    public Boolean checkAnswer(String answer, String term, Subject currentSubject) {
        Boolean validAnswer = false;
        String definition = currentSubject.get(term);
        if (answer.equals(definition)) {
            validAnswer = true;
            return validAnswer;
        } else {
            return validAnswer;
        }
    }

    // adds all saved information from previous runs or modified files
    public void addAtStart() {
        String folderPath = "src\\Subjects";
        File folder = new File(folderPath);
        File[] files = folder.listFiles();
        for (int i = 0; i < files.length; i++) {
            String regex = ".txt";
            String subjectName = files[i].getName().replaceAll(regex, "");
            subjectFiles.add(files[i]);
            retrieve(subjectName);
        }
    }

    // adds topics to subjects from subject files and adds subjects to subject list
    public void retrieve(String subjectName) {
        Subject newSubject = new Subject(subjectName);
        try {
            File subjectFile = new File("src\\Subjects\\" + subjectName + ".txt");
            Scanner myReader = new Scanner(subjectFile);
            String term = null;
            String definiton = null;;
            while(myReader.hasNextLine()) {
                String data = myReader.nextLine();
                char type = data.charAt(0);
                if (type == 'T') {
                    String regex = "T:";
                    term = data.replaceAll(regex, "");
                } else {
                    String regex = "D:";
                    definiton = data.replaceAll(regex, "");
                    newSubject.add(term, definiton);
                }
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