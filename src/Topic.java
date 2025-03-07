public class Topic {
    private String term;
    private String definition;
    protected Topic next;

    public Topic(String term, String definiton, int hashCode) {
        this.term = term;
        this.definition = definiton;
        next = null;

    }

    public String getTerm() {
        return term;
    }

    public String getDefinition() {
        return definition;
    }
}