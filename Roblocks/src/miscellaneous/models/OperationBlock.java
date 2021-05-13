package miscellaneous.models;

import java.util.ArrayList;

/**
This class stores information of an operation block.
*/

public class OperationBlock {
    public final String name;
    public final ArrayList<String> attributes;
    public final ArrayList<String> attributeValues;

    /**
     * Construct an OperationBlock.
     * @param name Name of the operation.
     * @param attributes Attributes of the operation.
     * @param attributeValues Values of the operation (can be empty on initialization).
     */

    public OperationBlock(String name, ArrayList<String> attributes, ArrayList<String> attributeValues) {
        this.name = name;
        this.attributes = attributes;
        this.attributeValues = attributeValues;
    }
}
