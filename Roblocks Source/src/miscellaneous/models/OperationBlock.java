package miscellaneous.models;

import java.util.ArrayList;

public class OperationBlock {
    public final String name;
    public final ArrayList<String> attributes;
    public final ArrayList<String> attributeValues;

    public OperationBlock(String name, ArrayList<String> attributes, ArrayList<String> attributeValues) {
        this.name = name;
        this.attributes = attributes;
        this.attributeValues = attributeValues;
    }
}
