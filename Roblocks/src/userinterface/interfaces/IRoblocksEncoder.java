package userinterface.interfaces;

import org.json.simple.JSONObject;
import userinterface.fragments.VisualEditFragment;

import java.util.ArrayList;

/**
 * Interface for encoders.
 */

public interface IRoblocksEncoder {
    JSONObject encode(ArrayList<VisualEditFragment> visualEditFragmentList);
}
