package miscellaneous.utilities;

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

public class RoblocksEncDec implements IRoblocksEncoder, IRoblocksDecoder {
    public final ArrayList<ToolboxFragment> toolboxFragments;

    public RoblocksEncDec(ArrayList<ToolboxFragment> toolboxFragments) {
        this.toolboxFragments = toolboxFragments;
    }

    @Override
    public ArrayList<VisualEditFragment> decode(String jsonString) {
        ArrayList<VisualEditFragment> visualEditFragments = new ArrayList<VisualEditFragment>();

        JSONObject rootObject = (JSONObject)JSONValue.parse(jsonString);

        JSONArray componentObjects;
        componentObjects = (JSONArray)rootObject.get("components");

        componentObjects.forEach(component -> {
            VisualEditFragment visualEditFragment = new VisualEditFragment();

            JSONObject componentObject = (JSONObject) component;
            visualEditFragment.name = (String)componentObject.get("name");
            visualEditFragment.uiTitleField.setText(visualEditFragment.name);
            JSONArray operationsArray = (JSONArray) componentObject.get("operations");

            operationsArray.forEach(operation -> {
                JSONObject operationObject = (JSONObject)operation;

                AtomicReference<ToolboxFragment> constructorFragment = new AtomicReference<>();

                toolboxFragments.forEach(toolboxFragment -> {
                    String operationName = (String)operationObject.get("name");
                    if (toolboxFragment.uiToolboxItem.getName().equals(operationName)) {
                        visualEditFragment.addOperationFragment(toolboxFragment); // Added
                        constructorFragment.set(toolboxFragment);

                        OperationFragment operationFragment = visualEditFragment.getLastOperationFragment();
                        JSONArray attributesArray = (JSONArray)operationObject.get("attributes");

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

    @Override
    public JSONObject encode(ArrayList<VisualEditFragment> visualEditFragmentList) {
        JSONObject rootObject = new JSONObject();

        JSONArray componentObjects = new JSONArray();
        rootObject.put("components", componentObjects);

        visualEditFragmentList.forEach(visualEditFragment -> {

            visualEditFragment.name = visualEditFragment.uiTitleField.getText();

            JSONObject jsonVisualBlockObject = new JSONObject();

            componentObjects.add(jsonVisualBlockObject);

            jsonVisualBlockObject.put("name", visualEditFragment.name);

            JSONArray jsonOperationsArray = new JSONArray();
            jsonVisualBlockObject.put("operations", jsonOperationsArray);

            visualEditFragment.uiOperationFragments.forEach(operationFragment -> {

                JSONObject jsonOperationObject = new JSONObject();
                jsonOperationObject.put("name", operationFragment.name);
                jsonOperationsArray.add(jsonOperationObject);

                JSONArray jsonOperationAttributesArray = new JSONArray();
                jsonOperationObject.put("attributes", jsonOperationAttributesArray);

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
