package userinterface.models;

import java.util.Arrays;

public class ToolboxItem {
    private String name;
    private String imageName;
    private String[] attributes;
    private String description;
    private String[] tags;

    public ToolboxItem(String name, String imageName, String[] attributes, String description, String[] tags) {
        this.name = name;
        this.imageName = imageName;
        this.attributes = attributes;
        this.description = description;
        this.tags = tags;
    }

    public String getName() {
        return this.name;
    }

    public String getImageName() {
        return this.imageName;
    }

    public String[] getAttributes() {
        return this.attributes;
    }

    public String getDescription() {
        return this.description;
    }

    public String[] getTags() {
        return this.tags;
    }

    @Override
    public String toString() {
        return "ToolboxItem{" +
                "name='" + name + '\'' +
                ", imageName='" + imageName + '\'' +
                ", attributes=" + Arrays.toString(attributes) +
                ", description='" + description + '\'' +
                ", tags=" + Arrays.toString(tags) +
                '}';
    }
}
