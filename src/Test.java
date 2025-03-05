public class Test {
    public static void main(String[] args) throws Exception {
       StudyReview myStudy = new StudyReview();

       myStudy.subjectOpt();
       myStudy.addAtStart();
       myStudy.startStudy(myStudy.subjectChoice());
    }
}
