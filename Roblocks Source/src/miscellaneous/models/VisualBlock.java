package miscellaneous.models;

import java.util.ArrayList;

public class VisualBlock {
    public final String name;
    public final ArrayList<OperationBlock> operationBlocks;

    public VisualBlock(String name, ArrayList<OperationBlock> operationBlocks) {
        this.name = name;
        this.operationBlocks = operationBlocks;
    }
}
