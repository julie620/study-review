import java.util.ArrayList;

public class Subject {

    private int arraySize;
    private int size;
    private String subjectName;

    private Topic[] reviewItems;
    private ArrayList<String> termList = new ArrayList<String>();

    public Subject(String subjectName) {
        size = 0;
        arraySize = 13;
        reviewItems = new Topic[arraySize];
        this.subjectName = subjectName;
    }

    public String getSubjectName() {
        return subjectName;
    }

    private int getBucketIndex(String term) {
        char firstLetter = term.toLowerCase().charAt(0);
        int key = (int) firstLetter;
        int index = key % arraySize;
        return index;
    }

    public void add(String term, String definition) {
        int bucketIndex = getBucketIndex(term);
        Topic head = reviewItems[bucketIndex];
        Topic newNode = new Topic(term, definition);

        if (head != null) {
            while (head.next != null) {
                if(head.getTerm() == term) {
                    head.setDefinition(definition);
                    return;
                }
                head = head.next;
            }
            size++;
            head.next = newNode;
            termList.add(head.next.getTerm());
        } else {
            newNode.toString();
            size++;
            reviewItems[bucketIndex] = newNode;
            termList.add(newNode.getTerm());
        }

        if (size / arraySize >= 0.75) {
            Topic[] temp = reviewItems;
            arraySize = arraySize * 2;
            reviewItems = new Topic[arraySize];
            Topic current;
            for (int i = 0; i < temp.length; i++) {
                if (temp[i] != null) {
                    current = temp[i];
                    while (current.next != null) {
                        add(current.getTerm(), current.getDefinition());
                        current = current.next;
                    }
                } 
            }
        }
    }

    public void remove(String term) {
        int bucketIndex = getBucketIndex(term);
        Topic current = reviewItems[bucketIndex];
        Topic head = null;

        while(current != null) {
            head = current;
            current = current.next;
            if (current.getTerm() == term) {
                break;
            }
        }

        if(current == null && head == null) {
            System.out.println("Term Not Found");
            return;
        }

        size--;
        head.next = null;
    }

    public String get(String term) {
        int bucketIndex = getBucketIndex(term);
        System.out.println(bucketIndex);
        Topic current = reviewItems[bucketIndex];
        Topic head = null;

        while(current != null) {
            head = current;
            System.out.println(head.getTerm());
            current = current.next;
            if (head.getTerm() == term) {
                return head.getDefinition();
            }
        }

        System.out.println("Term Not Found");
        return null;
    }

    public ArrayList<String> getTermList() {
        return termList;
    }

}