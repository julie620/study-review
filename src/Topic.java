public class Topic {
    private String term;
    private String definition;
    private int hashCode;
    protected Topic next;

    public Topic(String term, String definiton, int hashCode) {
        this.term = term;
        this.definition = definiton;
        this.hashCode = hashCode;
        next = null;

    }

    public void setDefinition(String newdefinition) {
        this.definition = definition;
    }

    public String getTerm() {
        return term;
    }

    public String getDefinition() {
        return definition;
    }
}