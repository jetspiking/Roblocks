package miscellaneous.models;

import java.util.ArrayList;

/**
This class keeps track of multiple operation-blocks.
*/

public class VisualBlock {
    public final String name;
    public final ArrayList<OperationBlock> operationBlocks;

    /**
     * Construct a VisualBlock.
     * @param name Name of the block.
     * @param operationBlocks List of added OperationBlocks, can be null on initialization.
     */

    public VisualBlock(String name, ArrayList<OperationBlock> operationBlocks) {
        this.name = name;
        this.operationBlocks = operationBlocks;
    }
}
