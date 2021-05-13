package miscellaneous.utilities;

import miscellaneous.constants.Application;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import userinterface.models.ToolboxItem;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * The SystemConfigurationDecoder attempts to decode the Toolbox-items JSON-file.
 */

public class SystemConfigurationDecoder {
    private ArrayList<ToolboxItem> uiToolboxItems = new ArrayList<ToolboxItem>();
    private DecodeStatus decodeStatus;

    /**
     * DecodeStatus which can be either SUCCESS or ERROR.
     */

    enum DecodeStatus {
        SUCCESS,
        ERROR
    }

    /**
     * Construct a SystemConfigurationReader.
     * @param file JSON-data file.
     */

    public SystemConfigurationDecoder(File file) {
        Object object = null;

        try {
            object = new JSONParser().parse(new FileReader(file));
        } catch(Exception e) {}

        if (object==null) return;

        try {
        JSONObject jsonObject = (JSONObject) object;
        JSONArray componentsObject = (JSONArray) jsonObject.get(Application.Strings.JSON_COMPONENTS);

        componentsObject.forEach(component -> {

            JSONObject componentObject = (JSONObject)component;
            String componentName = (String)componentObject.get(Application.Strings.JSON_NAME);
            String componentImage = (String)componentObject.get(Application.Strings.JSON_IMAGE);
            JSONArray componentAttributes = (JSONArray)componentObject.get(Application.Strings.JSON_ATTRIBUTES);
            String componentDescription = (String)componentObject.get(Application.Strings.JSON_DESCRIPTION);
            JSONArray componentTags = (JSONArray)componentObject.get(Application.Strings.JSON_TAGS);

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

    /**
     * Check decoding status, which shows whether errors decoding are present.
     * @return DecodeStatus
     */

    public DecodeStatus getDecodeStatus() {
        return decodeStatus;
    }

    /**
     * Get the list of ToolboxItems.
     * @return ToolboxItems list.
     */

    public ArrayList<ToolboxItem> getToolboxItemCollection() {
        return uiToolboxItems;
    }
}
