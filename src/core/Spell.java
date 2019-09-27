package core;

/**
 * Similar to Equipment, Spell has its own title and description is categorized differently.
 */
public class Spell {
    private String title;
    private String description;

    public Spell(String title, String description){
        if(title == null)
            throw new NullPointerException("Title is null");
        if(description == null)
            throw new NullPointerException("Description is null");
    }
}
