/*
 * Author: Juliana Serrano
 * Last Modified: 03/07/2025
 * Lab 6: Hashing
 * The Topic class allows for for a topic node to be created and provides getter methods
*/

public class Topic {
    private String term;
    private String definition;
    protected Topic next;

    public Topic(String term, String definiton) {
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