package userinterface.views;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.WindowEvent;
import miscellaneous.constants.Application;
import miscellaneous.models.LogMessage;
import miscellaneous.utilities.*;
import org.json.simple.JSONObject;
import userinterface.enums.SelectionActionType;
import userinterface.fragments.*;
import userinterface.interfaces.ILogObserver;
import userinterface.interfaces.ISelectable;
import userinterface.interfaces.IView;
import userinterface.popups.LogPopup;
import userinterface.popups.OperationPopup;
import userinterface.popups.PopupBrowser;
import userinterface.popups.PreferencesPopup;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

/**
 * Controller main class of the FX-application. Handles everything.
 */

public class StartWindow implements IView, ILogObserver {
    private final BorderPane uiMain;
    private final StartWindowTopBar uiStartWindowTopBar = new StartWindowTopBar();
    private final StartWindowContent uiStartWindowContent = new StartWindowContent();
    private final StartWindowLog uiStartWindowLog = new StartWindowLog();
    private String json;
    private final LogKeeper logKeeper = new LogKeeper(this);

    private ISelectable uiSelectedNode;

    private PreferencesPopup uiPreferencesPopup = new PreferencesPopup();

    /**
     * Constructs the window.
     */

    public StartWindow()
    {
        this.uiMain = new BorderPane();

        HBox topBar = (HBox) uiStartWindowTopBar.getFragment();
        this.uiMain.setTop(topBar);

        SplitPane contentPane = (SplitPane) uiStartWindowContent.getFragment();
        this.uiMain.setCenter(contentPane);

        TextField logBox = (TextField) uiStartWindowLog.getFragment();
        this.uiMain.setBottom(logBox);


        createFolder();
        fillToolbox(Application.FilesPaths.DEFAULT_TOOLBOX_PATH);
        initialize();
        bindActions();
        compileToJson();
    }

    /**
     * Create application folder if not exists.
     */

    private void createFolder() {
        File roblocksDirectory = new File(Application.FilesPaths.ROBLOCKS_FOLDER);
        if (!roblocksDirectory.exists())
            roblocksDirectory.mkdir();
    }

    /**
     * Upload JSON code.
     * @throws Exception If input is incorrect will throw exception.
     */

    private void uploadJson() throws Exception {
        compileToJson();

        URL url = new URL(uiPreferencesPopup.uiIpAddress.getText()+":"+ uiPreferencesPopup.uiPort.getText());
        URLConnection con = url.openConnection();
        HttpURLConnection http = (HttpURLConnection)con;
        http.setRequestMethod("POST"); // PUT is another valid option
        http.setDoOutput(true);

        byte[] out = this.json.getBytes(StandardCharsets.UTF_8);
        int length = out.length;

        http.setFixedLengthStreamingMode(length);
        http.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        http.connect();
        try(OutputStream os = http.getOutputStream()) {
            os.write(out);
        }
    }

    /**
     * Save JSON-data.
     */

    private void saveJson() {
        try (PrintWriter out = new PrintWriter(uiPreferencesPopup.uiSavePath.getText())) {
            out.println(this.json);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Open JSON-data.
     */

    private void openJson() {
        SystemConfigurationReader systemConfigurationReader = new SystemConfigurationReader(uiPreferencesPopup.uiSavePath.getText());

        if (systemConfigurationReader.getFileStatus()==SystemConfigurationReader.FileStatus.NOT_FOUND || systemConfigurationReader.getFileStatus()== SystemConfigurationReader.FileStatus.IO_EXCEPTION) {
            logKeeper.add(Application.Messages.ERROR_CONFIGURATION_READ);
        } else {
            logKeeper.add(Application.Messages.SUCCESS_CONFIGURATION_READ);
            try {
                final String[] read = {""};
                List<String> readList = Files.readAllLines(systemConfigurationReader.getFile().toPath());
                readList.forEach(string -> {
                    read[0] +=string;
                });
                fromJson(read[0]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Initialize view.
     */

    private void initialize() {
        uiStartWindowTopBar.uiViewFlyoutLog.setSelected(true);
        uiStartWindowTopBar.uiViewFlyoutToolbox.setSelected(true);
        uiStartWindowTopBar.uiViewFlyoutBlockSequence.setSelected(true);
        uiStartWindowTopBar.uiViewFlyoutOutput.setSelected(true);

        uiPreferencesPopup.uiToolboxConfigPath.setText(Application.FilesPaths.DEFAULT_TOOLBOX_PATH);
        uiPreferencesPopup.uiSavePath.setText(Application.FilesPaths.DEFAULT_SAVE_PATH);
    }

    /**
     * Bind actions to UI-elements.
     */

    private void bindActions() {

        // TOP BAR ACTIONS

        uiStartWindowTopBar.uiAppFlyoutPreferences.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                uiPreferencesPopup.show();

                uiPreferencesPopup.uiStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                    @Override
                    public void handle(WindowEvent event) {
                        fillToolbox(uiPreferencesPopup.uiToolboxConfigPath.getText());
                    }
                });
            }
        });
        uiStartWindowTopBar.uiAppFlyoutExit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Platform.exit();
                System.exit(0);
            }
        });

        uiStartWindowTopBar.uiFileFlyoutOpenProject.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                openJson();
            }
        });
        uiStartWindowTopBar.uiFileFlyoutCloseProject.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });
        uiStartWindowTopBar.uiFileFlyoutSaveProject.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                compileToJson();
                saveJson();
            }
        });

        uiStartWindowTopBar.uiViewFlyoutOutput.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                uiStartWindowContent.setOutputVisible(uiStartWindowTopBar.uiViewFlyoutOutput.isSelected());
            }
        });
        uiStartWindowTopBar.uiViewFlyoutBlockSequence.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                uiStartWindowContent.setVisualEditVisible(uiStartWindowTopBar.uiViewFlyoutBlockSequence.isSelected());
            }
        });
        uiStartWindowTopBar.uiViewFlyoutToolbox.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                uiStartWindowContent.setToolboxVisible(uiStartWindowTopBar.uiViewFlyoutToolbox.isSelected());
            }
        });
        uiStartWindowTopBar.uiViewFlyoutLog.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                uiStartWindowLog.setLogVisible(uiStartWindowTopBar.uiViewFlyoutLog.isSelected());
                if (!uiStartWindowTopBar.uiViewFlyoutLog.isSelected())
                    uiMain.setBottom(null);
                uiMain.setBottom(uiStartWindowLog.getFragment());
            }
        });
        uiStartWindowTopBar.uiViewFlyoutExpandLog.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                (new LogPopup(logKeeper)).show();
            }
        });

        uiStartWindowTopBar.uiBuildFlyoutCompile.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                fromJson(uiStartWindowContent.output.uiOutput.getText());
            }
        });
        uiStartWindowTopBar.uiBuildFlyoutExport.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            }
        });
        uiStartWindowTopBar.uiBuildFlyoutUpload.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    uploadJson();
                } catch (Exception e) {
                    logKeeper.add(new LogMessage(e.getMessage(), LogMessage.LogMessageType.ERROR));
                }
            }
        });

        uiStartWindowTopBar.uiAboutFlyoutSourceCode.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String url = Application.URLs.GITHUB;

                PopupBrowser popupBrowser = new PopupBrowser("Roblocks Source Code", url);
                popupBrowser.show();
            }
        });

        uiStartWindowTopBar.uiHelpFlyoutProtocol.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                PopupBrowser popupBrowser = new PopupBrowser("Roblocks Help", Application.URLs.GITHUB_PROTOCOL_HELP);
                popupBrowser.show();
            }
        });

        // CONTENT ACTIONS (SPLITPANE)

        uiStartWindowContent.visualEdit.getFragment().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                updateSelectedNode(uiStartWindowContent.visualEdit);
            }
        });
        uiStartWindowContent.toolbox.uiToolboxFragments.forEach(toolboxFragment -> {
            toolboxFragment.uiBorderPane.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    //updateSelectedNode(toolboxFragment);
                    uiStartWindowContent.toolbox.updateSelectedNode(toolboxFragment);
                    LogMessage logMessage = new LogMessage("Selected Operation \""+toolboxFragment.uiToolboxItem.getName()+"\" - \""+toolboxFragment.uiToolboxItem.getDescription()+"\"", LogMessage.LogMessageType.VERBOSE);
                    logKeeper.add(logMessage);
                }
            });
            toolboxFragment.uiBorderPane.setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if (toolboxFragment!= uiStartWindowContent.toolbox.uiSelectedNode)
                    toolboxFragment.hover();
                }
            });
            toolboxFragment.uiBorderPane.setOnMouseExited(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if (toolboxFragment!= uiStartWindowContent.toolbox.uiSelectedNode)
                        toolboxFragment.exit();
                }
            });
        });

        uiStartWindowContent.output.getFragment().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                updateSelectedNode(uiStartWindowContent.output);
            }
        });

        uiStartWindowContent.toolbox.uiButtonBar.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
            }
        });

        uiStartWindowContent.toolbox.uiAdd.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
               evaluateAction(SelectionActionType.ADD);
            }
        });

        uiStartWindowContent.toolbox.uiRemove.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                evaluateAction(SelectionActionType.REMOVE);
            }
        });

        uiStartWindowContent.toolbox.uiSettings.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                evaluateAction(SelectionActionType.SETTINGS);
            }
        });

        StartWindow startWindow=this;
        //  For Dark Mode
        uiPreferencesPopup.uiDarkMode.getIsOn().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                Application.State.isDarkTheme = newValue;

                if (newValue)
                {
                    startWindow.getView().setStyle("-fx-base: rgba(20, 20, 20, 255);");
                    StartWindow.this.uiStartWindowContent.visualEdit.uiVisualEditFragments.forEach(visualEditFragment -> {
                        visualEditFragment.toDarkMode();
                        visualEditFragment.uiOperationFragments.forEach(OperationFragment::toDarkMode);
                    });
                    uiStartWindowLog.toDarkMode();
                    uiStartWindowContent.output.toDarkMode();
                    uiStartWindowTopBar.toDarkMode();
                    uiStartWindowContent.toolbox.toDarkMode();
                }
                else
                {
                    startWindow.getView().setStyle("-fx-base: rgba(255, 255, 255, 255);");
                    StartWindow.this.uiStartWindowContent.visualEdit.uiVisualEditFragments.forEach(visualEditFragment -> {
                        visualEditFragment.toLightMode();
                        visualEditFragment.uiOperationFragments.forEach(OperationFragment::toLightMode);
                    });
                    uiStartWindowLog.toLightMode();
                    uiStartWindowContent.output.toLightMode();
                    uiStartWindowTopBar.toLightMode();
                    uiStartWindowContent.toolbox.toLightMode();
                }
                if (uiSelectedNode!=null)
                    uiSelectedNode.select();
                if (uiStartWindowContent.toolbox.uiSelectedNode!=null)
                    uiStartWindowContent.toolbox.uiSelectedNode.select();
            }
        });
    }

    /**
     * Fill toolbox with items from config directory.
     * @param path Path to config.
     */

    private void fillToolbox(String path) {
        SystemConfigurationReader systemConfigurationReader = new SystemConfigurationReader(path);

        if (systemConfigurationReader.getFileStatus()==SystemConfigurationReader.FileStatus.NOT_FOUND || systemConfigurationReader.getFileStatus()== SystemConfigurationReader.FileStatus.IO_EXCEPTION) {
            logKeeper.add(Application.Messages.ERROR_CONFIGURATION_READ);
        } else {
            logKeeper.add(Application.Messages.SUCCESS_CONFIGURATION_READ);
            SystemConfigurationDecoder systemConfigurationDecoder = new SystemConfigurationDecoder(systemConfigurationReader.getFile());
            uiStartWindowContent.toolbox.setToolbox(systemConfigurationDecoder.getToolboxItemCollection());
        }
        bindActions();


        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                uiStartWindowContent.toolbox.uiMetroToolBox.getChildren().forEach(Node::autosize);
            }
        });
    }

    /**
     * Visualize program from JSON-data.
     * @param json JSON-data.
     */

    private void fromJson(String json) {
        try {
            uiStartWindowContent.visualEdit.uiWindowVisualStack.getChildren().clear();
            uiStartWindowContent.visualEdit.uiVisualEditFragments.clear();

            RoblocksEncDec roblocksEncDec = new RoblocksEncDec(uiStartWindowContent.toolbox.uiToolboxFragments);
            ArrayList<VisualEditFragment> visualEditFragments = roblocksEncDec.decode(json);

            visualEditFragments.forEach(visualEditFragment -> {
                uiStartWindowContent.visualEdit.addVisualEditFragment(visualEditFragment);
                bindVisualEditActions(visualEditFragment);
                visualEditFragment.uiOperationFragments.forEach(this::bindVisualEditItemActions);

                visualEditFragment.uiMenuFlyoutDelete.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        removeVisualEditFragment(visualEditFragment);
                    }
                });
            });

            compileToJson();

        } catch (Exception e) {
            logKeeper.add(new LogMessage(e.getMessage(), LogMessage.LogMessageType.ERROR));
        }
    }

    /**
     * Compile to JSON-data.
     * @return JSON-data String.
     */

    private String compileToJson() {
        RoblocksEncDec roblocksEncDec = new RoblocksEncDec(uiStartWindowContent.toolbox.uiToolboxFragments);
        JSONObject json = roblocksEncDec.encode(uiStartWindowContent.visualEdit.uiVisualEditFragments);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String prettyJson = gson.toJson(json);

        this.json = json.toJSONString();
        uiStartWindowContent.output.uiOutput.setText(prettyJson);

        return json.toJSONString();
    }

    /**
     * Remove a Visual Edit Fragment
     * @param visualEditFragment VisualEditFragment
     */

    private void removeVisualEditFragment(VisualEditFragment visualEditFragment) {
        uiStartWindowContent.visualEdit.removeVisualEditFragment(visualEditFragment);
        uiSelectedNode =null;
        compileToJson();
        logKeeper.add(new LogMessage("Removed Visual Node \""+visualEditFragment.name+"\".", LogMessage.LogMessageType.VERBOSE));
    }

    /**
     * Evaluate program action.
     * @param actionType SelectionActionType enum specifies source of notification.
     */

    private void evaluateAction(SelectionActionType actionType) {
        if (uiSelectedNode !=null)
        switch(uiSelectedNode.getType()) {
            case OUTPUT:
                break;

            case VISUAL_EDIT:

                if (actionType == SelectionActionType.ADD) {
                    uiStartWindowContent.visualEdit.addVisualEditFragment();
                    final VisualEditFragment visualEditFragment = uiStartWindowContent.visualEdit.getLastVisualEditFragment();

                    visualEditFragment.uiMenuFlyoutDelete.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            removeVisualEditFragment(visualEditFragment);
                        }
                    });

                    logKeeper.add(new LogMessage("Added Visual Node \"" + visualEditFragment.name+"\".", LogMessage.LogMessageType.VERBOSE));
                    bindVisualEditActions(visualEditFragment);
                }

                break;

            case VISUAL_EDIT_ITEM:

                if (actionType == SelectionActionType.ADD && uiStartWindowContent.toolbox.uiSelectedNode != null) {
                    VisualEditFragment visualEditFragment = (VisualEditFragment) uiSelectedNode;
                    visualEditFragment.addOperationFragment(uiStartWindowContent.toolbox.uiSelectedNode);
                    OperationFragment operationFragment = visualEditFragment.getLastOperationFragment();
                    logKeeper.add(new LogMessage("Added Operation \"" + operationFragment.name+"\".", LogMessage.LogMessageType.VERBOSE));
                    bindVisualEditItemActions(operationFragment);
                }

                if (actionType == SelectionActionType.REMOVE) {
                    removeVisualEditFragment((VisualEditFragment) uiSelectedNode);
                }

                break;
            case TOOLBOX:
                break;
            case TOOLBOX_ITEM:
                break;
            case OPERATION_ITEM:

                if (actionType==SelectionActionType.REMOVE)
                {
                    uiStartWindowContent.visualEdit.uiVisualEditFragments.forEach(visualFragment -> {
                        visualFragment.removeOperationFragment((OperationFragment) uiSelectedNode);
                        logKeeper.add(new LogMessage("Removed Visual Node.", LogMessage.LogMessageType.VERBOSE));
                    });
                   uiSelectedNode =null;
                }

                if (actionType == SelectionActionType.SETTINGS)
                {
                    OperationFragment operationFragment = (OperationFragment) uiSelectedNode;
                    logKeeper.add(new LogMessage("Opening properties for operation \""+operationFragment.name+"\".", LogMessage.LogMessageType.VERBOSE));
                    OperationPopup operationPopup = new OperationPopup(operationFragment);
                    operationPopup.uiOperationStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                        @Override
                        public void handle(WindowEvent event) {
                            operationPopup.operationFragment.attributeValues.clear();
                            operationPopup.uiAttributeList.uiObjectsRightStack.getChildren().forEach(attribute -> {
                                TextField textField = (TextField)attribute;
                                String attributeText = textField.getText();
                                operationPopup.operationFragment.attributeValues.add(attributeText);
                            });
                            compileToJson();
                        }
                    });
                    operationPopup.show();
                }

                break;
            case LOG:
                break;
        }

        if (actionType==SelectionActionType.ADD || actionType==SelectionActionType.REMOVE) {
            compileToJson();
        }
    }

    /**
     * Bind actions to VisualEditFragment item.
     * @param visualEditFragment VisualEditFragment instance to bind actions to.
     */

    private void bindVisualEditActions(VisualEditFragment visualEditFragment) {
        visualEditFragment.uiBorderPane.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                updateSelectedNode(visualEditFragment);
                event.consume();
            }
        });
    }

    /**
     * Bind actions to OperationFragment view.
     * @param operationFragment OperationFragment.
     */

    private void bindVisualEditItemActions(OperationFragment operationFragment)
    {
        operationFragment.getFragment().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                updateSelectedNode(operationFragment);
                event.consume();
            }
        });
        operationFragment.getFragment().setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                operationFragment.hover();
            }
        });
        operationFragment.getFragment().setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                operationFragment.exit();
            }
        });
    }

    /**
     * Set node to selected.
     * @param node ISelectable node.
     */

    private void updateSelectedNode(ISelectable node) {

        if (uiSelectedNode !=null) {
            uiSelectedNode.deselect();
        }

        uiSelectedNode = node;
        uiSelectedNode.select();
    }

    /**
     * Get View.
     * @return Parent.
     */

    @Override
    public Parent getView()
    {
        return uiMain;
    }

    /**
     * Update log message.
     */

    @Override
    public void update() {
        uiStartWindowLog.uiLog.setText(logKeeper.lastLog().message);
    }
}
