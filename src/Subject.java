import java.util.ArrayList;
import java.util.Objects;

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

    public final int hashCode(String term) {
        return Objects.hashCode(term);
    }

    private int getBucketIndex(String term) {
        int hashCode = hashCode(term);
        int index = hashCode % arraySize;
        index = index < 0 ? index * -1: index;
        return index;
    }

    public void add(String term, String definition) {
        int bucketIndex = getBucketIndex(term);
        int hashCode = hashCode(term);
        Topic head = reviewItems[bucketIndex];
        Topic newNode = new Topic(term, definition, hashCode);

        if (head != null) {
            while (head.next != null) {
                if(head.getTerm() == term) {
                    head.setDefinition(definition);
                    return;
                }
                head = head.next;
            }
            head.next = newNode;
            termList.add(head.next.getTerm());
        } else {
            reviewItems[bucketIndex] = newNode;
            termList.add(newNode.getTerm());
        }

        size++;

        if ((1.0 * size) / arraySize >= 0.75) {
            rehash();
        }
    }

    public void rehash() {
        Topic[] temp = reviewItems;
            arraySize = arraySize * 2;
            reviewItems = new Topic[arraySize];
            size = 0;
            termList.clear();
            Topic current;
            for (int i = 0; i < temp.length; i++) {
                if (temp[i] != null) {
                    current = temp[i];
                    while (current != null) {
                        add(current.getTerm(), current.getDefinition());
                        current = current.next;
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
        Topic current = reviewItems[bucketIndex];
        Topic head = null;

        while(current != null) {
            head = current;
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