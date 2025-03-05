public class Topic {
    private String term;
    private String definition;
    protected Topic next;

    public Topic(String term, String definiton) {
        this.term = term;
        this.definition = definiton;
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