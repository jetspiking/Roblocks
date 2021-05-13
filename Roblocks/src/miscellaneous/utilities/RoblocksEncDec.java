package miscellaneous.utilities;

import miscellaneous.constants.Application;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import userinterface.fragments.OperationFragment;
import userinterface.fragments.ToolboxFragment;
import userinterface.fragments.VisualEditFragment;
import userinterface.interfaces.IRoblocksDecoder;
import userinterface.interfaces.IRoblocksEncoder;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

/**
RoblocksEncDec can encode or decode to or from a JSON file.
*/

public class RoblocksEncDec implements IRoblocksEncoder, IRoblocksDecoder {
    public final ArrayList<ToolboxFragment> toolboxFragments;

    /**
     * Construct a RoblocksEncDec.
     * @param toolboxFragments New ArrayList which already contains or can contain the ToolboxFragments.
     */

    public RoblocksEncDec(ArrayList<ToolboxFragment> toolboxFragments) {
        this.toolboxFragments = toolboxFragments;
    }

    /**
     * Decode a JSON String to an ArrayList of VisualEditFragments.
     * @param jsonString JSON-data.
     * @return List of VisualEditFragments.
     */

    @Override
    public ArrayList<VisualEditFragment> decode(String jsonString) {
        ArrayList<VisualEditFragment> visualEditFragments = new ArrayList<VisualEditFragment>();

        JSONObject rootObject = (JSONObject)JSONValue.parse(jsonString);

        JSONArray componentObjects;
        componentObjects = (JSONArray)rootObject.get(Application.Strings.JSON_COMPONENTS);

        componentObjects.forEach(component -> {
            VisualEditFragment visualEditFragment = new VisualEditFragment();

            JSONObject componentObject = (JSONObject) component;
            visualEditFragment.name = (String)componentObject.get(Application.Strings.JSON_NAME);
            visualEditFragment.uiTitleField.setText(visualEditFragment.name);
            JSONArray operationsArray = (JSONArray) componentObject.get(Application.Strings.JSON_OPERATIONS);

            operationsArray.forEach(operation -> {
                JSONObject operationObject = (JSONObject)operation;

                AtomicReference<ToolboxFragment> constructorFragment = new AtomicReference<>();

                toolboxFragments.forEach(toolboxFragment -> {
                    String operationName = (String)operationObject.get(Application.Strings.JSON_NAME);
                    if (toolboxFragment.uiToolboxItem.getName().equals(operationName)) {
                        visualEditFragment.addOperationFragment(toolboxFragment); // Added
                        constructorFragment.set(toolboxFragment);

                        OperationFragment operationFragment = visualEditFragment.getLastOperationFragment();
                        JSONArray attributesArray = (JSONArray)operationObject.get(Application.Strings.JSON_ATTRIBUTES);

                        operationFragment.attributeValues.clear();
                        attributesArray.forEach(attribute -> {
                            JSONObject attributeObject = (JSONObject) attribute;
                            String key = (String)attributeObject.keySet().toArray()[0];
                            String value = (String)attributeObject.get(key);
                            operationFragment.attributeValues.add(value);
                        });

                    }
                });
            });
            visualEditFragments.add(visualEditFragment);
        });

        return visualEditFragments;
    }

    /**
     * Encode an ArrayList of VisualEditFragments to a JSON String.
     * @param visualEditFragmentList List of VisualEditFragments.
     * @return JSON-data.
     */

    @Override
    public JSONObject encode(ArrayList<VisualEditFragment> visualEditFragmentList) {
        JSONObject rootObject = new JSONObject();

        JSONArray componentObjects = new JSONArray();
        rootObject.put(Application.Strings.JSON_COMPONENTS, componentObjects);

        visualEditFragmentList.forEach(visualEditFragment -> {

            visualEditFragment.name = visualEditFragment.uiTitleField.getText();

            JSONObject jsonVisualBlockObject = new JSONObject();

            componentObjects.add(jsonVisualBlockObject);

            jsonVisualBlockObject.put(Application.Strings.JSON_NAME, visualEditFragment.name);

            JSONArray jsonOperationsArray = new JSONArray();
            jsonVisualBlockObject.put(Application.Strings.JSON_OPERATIONS, jsonOperationsArray);

            visualEditFragment.uiOperationFragments.forEach(operationFragment -> {

                JSONObject jsonOperationObject = new JSONObject();
                jsonOperationObject.put(Application.Strings.JSON_NAME, operationFragment.name);
                jsonOperationsArray.add(jsonOperationObject);

                JSONArray jsonOperationAttributesArray = new JSONArray();
                jsonOperationObject.put(Application.Strings.JSON_ATTRIBUTES, jsonOperationAttributesArray);

                for (int attributeIndex =0; attributeIndex < operationFragment.attributes.size(); attributeIndex++) {
                    JSONObject jsonAttributeObject = new JSONObject();
                    jsonAttributeObject.put(operationFragment.attributes.get(attributeIndex),operationFragment.attributeValues.get(attributeIndex));
                    jsonOperationAttributesArray.add(jsonAttributeObject);
                }
            });
        });
        return rootObject;
    }
}
