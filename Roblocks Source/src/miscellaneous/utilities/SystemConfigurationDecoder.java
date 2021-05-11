package miscellaneous.utilities;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import userinterface.models.ToolboxItem;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class SystemConfigurationDecoder {
    private ArrayList<ToolboxItem> uiToolboxItems = new ArrayList<ToolboxItem>();
    private DecodeStatus decodeStatus;

    enum DecodeStatus {
        SUCCESS,
        ERROR
    }

    public SystemConfigurationDecoder(File file) {
        Object object = null;
        try {
            object = new JSONParser().parse(new FileReader(file));
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        try {
        JSONObject jsonObject = (JSONObject) object;
        JSONArray componentsObject = (JSONArray) jsonObject.get("components");

        componentsObject.forEach(component -> {

            JSONObject componentObject = (JSONObject)component;
            String componentName = (String)componentObject.get("name");
            String componentImage = (String)componentObject.get("image");
            JSONArray componentAttributes = (JSONArray)componentObject.get("attributes");
            String componentDescription = (String)componentObject.get("description");
            JSONArray componentTags = (JSONArray)componentObject.get("tags");

            String[] componentAttributesStrings = new String[componentAttributes.size()];

            for (int i = 0; i < componentAttributes.size(); i++) {
                componentAttributesStrings[i] = (String)componentAttributes.get(i);
            }

            String[] componentTagsStrings = new String[componentTags.size()];

            for (int i = 0; i < componentTags.size(); i++) {
                componentTagsStrings[i] = (String)componentTags.get(i);
            }

            uiToolboxItems.add(new ToolboxItem(componentName, componentImage, componentAttributesStrings, componentDescription, componentTagsStrings));
        });

        } catch(Exception e) {
            decodeStatus=DecodeStatus.ERROR;
        }
        decodeStatus=DecodeStatus.SUCCESS;
    }

    public DecodeStatus getDecodeStatus() {
        return decodeStatus;
    }

    public ArrayList<ToolboxItem> getToolboxItemCollection() {
        return uiToolboxItems;
    }
}
