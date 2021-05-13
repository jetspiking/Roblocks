package userinterface.interfaces;

import userinterface.fragments.VisualEditFragment;
import java.util.ArrayList;

/**
 * Interface for decoders.
 */

public interface IRoblocksDecoder {
    ArrayList<VisualEditFragment> decode(String jsonString);
}
