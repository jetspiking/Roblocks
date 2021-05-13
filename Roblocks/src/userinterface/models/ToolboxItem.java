package userinterface.models;

/**
 * Model to store ToolboxItem information.
 */

public class ToolboxItem {
    private String name;
    private String imageName;
    private String[] attributes;
    private String description;
    private String[] tags;

    /**
     * Constructs a ToolboxItem object.
     * @param name Name.
     * @param imageName Name of image.
     * @param attributes Attribute list.
     * @param description Description.
     * @param tags Tags list.
     */

    public ToolboxItem(String name, String imageName, String[] attributes, String description, String[] tags) {
        this.name = name;
        this.imageName = imageName;
        this.attributes = attributes;
        this.description = description;
        this.tags = tags;
    }

    /**
     * Get ToolboxItem name.
     * @return Name.
     */

    public String getName() {
        return this.name;
    }

    /**
     * Get ToolboxItem image name.
     * @return Image name.
     */

    public String getImageName() {
        return this.imageName;
    }

    /**
     * Get all ToolboxItem attributes.
     * @return Attributes list.
     */

    public String[] getAttributes() {
        return this.attributes;
    }

    /**
     * Get ToolboxItem description.
     * @return Description.
     */

    public String getDescription() {
        return this.description;
    }

    /**
     * Get ToolboxItem tags.
     * @return Tags list.
     */

    public String[] getTags() {
        return this.tags;
    }
}
