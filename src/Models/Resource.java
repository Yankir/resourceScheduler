package Models;

import java.io.Serializable;

public class Resource implements Serializable
{
    private String name;
    private String description;

    public Resource() {}
    public Resource(String name , String description)
    {
        setName(name);
        setDescription(description);
    }

    private void setName(String name) { this.name = name; }
    private void setDescription(String description) { this.description = description; }

    public String getName() { return name; }
    public String getDescription() { return description; }
}
