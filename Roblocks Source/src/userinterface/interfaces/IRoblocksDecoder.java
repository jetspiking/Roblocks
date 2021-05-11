package userinterface.interfaces;

import userinterface.fragments.VisualEditFragment;

import java.util.ArrayList;

public interface IRoblocksDecoder {
    ArrayList<VisualEditFragment> decode(String jsonString);
}
