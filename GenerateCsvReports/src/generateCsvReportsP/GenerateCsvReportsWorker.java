package generateCsvReportsP;

import org.jdesktop.application.Action;
import org.jdesktop.application.SingleFrameApplication;
import org.jdesktop.application.FrameView;
import org.jdesktop.application.Task;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileFilter;
import javax.swing.ToolTipManager;
import java.awt.Dimension;
import java.io.File;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.util.ArrayList; 
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class GenerateCsvReportsWorker extends FrameView {

    //TODO: ~big feature: print all multi reports on one xlsx file   
    //TODO: ~settings.ini
    //TODO: 46 46 46 46 <-- only last value is starting of trimm
    //TODO: in trimmed report number order is bad 8 9 10 1    
    //TODO: TAB sep in csv's
    //TODO: ~connect plugins with this, gensettignsworker having role of pluginsCMDWorker
    //TODO: global vars in capital letters
    //TODO: ~good way of attaching extension for savingResultFileAs
    //TODO: only 1 processF for 4All
    //TODO: why theF I use background tasks?
    public GenerateCsvReportsWorker(SingleFrameApplication app) {
        super(app);
        
        initComponents();
        setExtensionsToSearchFor("jtl");
        setExtensionsToSearchFor("JTL");
        graphXFF.setValue(1000);
        graphYFF.setValue(800);
        statusMessageLabel.setText("Welcome.");

        java.net.URL url = ClassLoader.getSystemResource("generateCsvReportsP/resources/report-go-icon.png");
        getFrame().setIconImage(java.awt.Toolkit.getDefaultToolkit().getImage(url));
        //x,y
        getFrame().setMinimumSize(new Dimension(560, 455));
//        getFrame().setMaximumSize(new Dimension(1410, 1280));
        
        genB_4All.setEnabled(false);
        genCsvB_multi.setEnabled(false);
        stopB_multi.setEnabled(false);
        genCsvB_trimmed.setEnabled(false);
        joinJTLsB.setEnabled(false);
        stopB_join.setEnabled(false);
        genB_RTOT.setEnabled(false);
        stopB_RTOT.setEnabled(false);
        stopB_4All.setEnabled(false);
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        mainPanel = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4All = new javax.swing.JPanel();
        buttonsPane_4All = new javax.swing.JPanel();
        stopB_4All = new javax.swing.JButton();
        genB_4All = new javax.swing.JButton();
        browseB_4All = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        resultF_4All = new javax.swing.JTextField();
        inputF_4All = new javax.swing.JTextField();
        jPanelMulti = new javax.swing.JPanel();
        buttonsPane_multi = new javax.swing.JPanel();
        stopB_multi = new javax.swing.JButton();
        saveResB_multi = new javax.swing.JButton();
        genCsvB_multi = new javax.swing.JButton();
        browseB_multi = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        resultF_multi = new javax.swing.JTextField();
        inputF_multi = new javax.swing.JTextField();
        jPanelRTOT = new javax.swing.JPanel();
        buttonsPane_RTOT = new javax.swing.JPanel();
        stopB_RTOT = new javax.swing.JButton();
        saveResB_RTOT = new javax.swing.JButton();
        genB_RTOT = new javax.swing.JButton();
        browseB_RTOT = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        resultF_RTOT = new javax.swing.JTextField();
        inputF_RTOT = new javax.swing.JTextField();
        jPanelJoin = new javax.swing.JPanel();
        buttonsPane_join = new javax.swing.JPanel();
        stopB_join = new javax.swing.JButton();
        joinJTLsB = new javax.swing.JButton();
        browseB_join = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        selectedField_join = new javax.swing.JTextField();
        jPanelTrimmed = new javax.swing.JPanel();
        buttonsPane_trimmed = new javax.swing.JPanel();
        genCsvB_trimmed = new javax.swing.JButton();
        browseB_trimmed = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        resultF_trimmed = new javax.swing.JTextField();
        inputF_trimmed = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        timelineF = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        trimmedJTLF = new javax.swing.JTextField();
        timelineStartFF = new javax.swing.JFormattedTextField();
        timelineEndFF = new javax.swing.JFormattedTextField();
        jLabel20 = new javax.swing.JLabel();
        jPanelSettings = new javax.swing.JPanel();
        graphsPane = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        graphXFF = new javax.swing.JFormattedTextField();
        graphYFF = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        realTimelineChk = new javax.swing.JCheckBox();
        limitRowsChk = new javax.swing.JCheckBox();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        forceYFF = new javax.swing.JFormattedTextField();
        csvPane = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        localeSepCmb = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        colsList = new javax.swing.JList();
        commonPane = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        mainCommOnlyC = new javax.swing.JCheckBox();
        jLabel16 = new javax.swing.JLabel();
        statusPanel = new javax.swing.JPanel();
        javax.swing.JSeparator statusPanelSeparator = new javax.swing.JSeparator();
        statusMessageLabel = new javax.swing.JLabel();
        chooseJTL_multi = new javax.swing.JFileChooser();
        chooseSave_multi = new javax.swing.JFileChooser();
        chooseJTL_trimmed = new javax.swing.JFileChooser();
        chooseJTL_RTOT = new javax.swing.JFileChooser();
        chooseSave_RTOT = new javax.swing.JFileChooser();
        chooseJTL_join = new javax.swing.JFileChooser();
        chooseJTL_4All = new javax.swing.JFileChooser();

        mainPanel.setFont(mainPanel.getFont());
        mainPanel.setName("mainPanel"); // NOI18N
        mainPanel.setLayout(new java.awt.GridBagLayout());

        jTabbedPane1.setName("jTabbedPane1"); // NOI18N

        jPanel4All.setEnabled(false);
        jPanel4All.setName("jPanel4All"); // NOI18N
        jPanel4All.setLayout(new java.awt.GridBagLayout());

        buttonsPane_4All.setName("buttonsPane_4All"); // NOI18N
        buttonsPane_4All.setLayout(new java.awt.GridBagLayout());

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(generateCsvReportsP.GenerateCsvReportsApp.class).getContext().getActionMap(GenerateCsvReportsWorker.class, this);
        stopB_4All.setAction(actionMap.get("Stop")); // NOI18N
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(generateCsvReportsP.GenerateCsvReportsApp.class).getContext().getResourceMap(GenerateCsvReportsWorker.class);
        stopB_4All.setText(resourceMap.getString("stopB.text")); // NOI18N
        stopB_4All.setName("stopB_4All"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 0);
        buttonsPane_4All.add(stopB_4All, gridBagConstraints);

        genB_4All.setAction(actionMap.get("initReportsGen4All")); // NOI18N
        genB_4All.setText(resourceMap.getString("genB_4All.text")); // NOI18N
        genB_4All.setName("genB_4All"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 5);
        buttonsPane_4All.add(genB_4All, gridBagConstraints);

        browseB_4All.setAction(actionMap.get("Browse_4All")); // NOI18N
        browseB_4All.setText(resourceMap.getString("selectFolder.text")); // NOI18N
        browseB_4All.setName("browseB_4All"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        buttonsPane_4All.add(browseB_4All, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 0);
        jPanel4All.add(buttonsPane_4All, gridBagConstraints);

        jLabel17.setText(resourceMap.getString("selectedFolder.label")); // NOI18N
        jLabel17.setName("jLabel17"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        jPanel4All.add(jLabel17, gridBagConstraints);

        jLabel19.setText(resourceMap.getString("jLabel19.text")); // NOI18N
        jLabel19.setName("jLabel19"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        jPanel4All.add(jLabel19, gridBagConstraints);

        resultF_4All.setColumns(20);
        resultF_4All.setEditable(false);
        resultF_4All.setText(resourceMap.getString("selectFolderField.text")); // NOI18N
        resultF_4All.setName("resultF_4All"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 10);
        jPanel4All.add(resultF_4All, gridBagConstraints);

        inputF_4All.setColumns(20);
        inputF_4All.setEditable(false);
        inputF_4All.setText(resourceMap.getString("selectFolderField.text")); // NOI18N
        inputF_4All.setName("inputF_4All"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 10);
        jPanel4All.add(inputF_4All, gridBagConstraints);

        jTabbedPane1.addTab(resourceMap.getString("jPanel4All.TabConstraints.tabTitle"), jPanel4All); // NOI18N

        jPanelMulti.setName("jPanelMulti"); // NOI18N
        jPanelMulti.setLayout(new java.awt.GridBagLayout());

        buttonsPane_multi.setName("buttonsPane_multi"); // NOI18N
        buttonsPane_multi.setLayout(new java.awt.GridBagLayout());

        stopB_multi.setAction(actionMap.get("Stop")); // NOI18N
        stopB_multi.setText(resourceMap.getString("stopB.text")); // NOI18N
        stopB_multi.setName("stopB_multi"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 0);
        buttonsPane_multi.add(stopB_multi, gridBagConstraints);

        saveResB_multi.setAction(actionMap.get("SaveRes_multiAction")); // NOI18N
        saveResB_multi.setText(resourceMap.getString("saveResultsIn.text")); // NOI18N
        saveResB_multi.setName("saveResB_multi"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        buttonsPane_multi.add(saveResB_multi, gridBagConstraints);

        genCsvB_multi.setAction(actionMap.get("Generate_multiAction")); // NOI18N
        genCsvB_multi.setText(resourceMap.getString("genCsvB_multi.text")); // NOI18N
        genCsvB_multi.setName("genCsvB_multi"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 5);
        buttonsPane_multi.add(genCsvB_multi, gridBagConstraints);

        browseB_multi.setAction(actionMap.get("Browse_multiAction")); // NOI18N
        browseB_multi.setText(resourceMap.getString("selectFolder.text")); // NOI18N
        browseB_multi.setName("browseB_multi"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        buttonsPane_multi.add(browseB_multi, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 0);
        jPanelMulti.add(buttonsPane_multi, gridBagConstraints);

        jLabel3.setText(resourceMap.getString("selectedFolder.label")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        jPanelMulti.add(jLabel3, gridBagConstraints);

        jLabel4.setText(resourceMap.getString("jLabel4.text")); // NOI18N
        jLabel4.setName("jLabel4"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        jPanelMulti.add(jLabel4, gridBagConstraints);

        resultF_multi.setColumns(20);
        resultF_multi.setEditable(false);
        resultF_multi.setFont(resourceMap.getFont("TextFields.font")); // NOI18N
        resultF_multi.setText(resourceMap.getString("selectFolderField.text")); // NOI18N
        resultF_multi.setName("resultF_multi"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 10);
        jPanelMulti.add(resultF_multi, gridBagConstraints);

        inputF_multi.setColumns(20);
        inputF_multi.setEditable(false);
        inputF_multi.setFont(resourceMap.getFont("TextFields.font")); // NOI18N
        inputF_multi.setText(resourceMap.getString("selectFolderField.text")); // NOI18N
        inputF_multi.setName("inputF_multi"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 10);
        jPanelMulti.add(inputF_multi, gridBagConstraints);

        jTabbedPane1.addTab(resourceMap.getString("jPanelMulti.TabConstraints.tabTitle"), jPanelMulti); // NOI18N

        jPanelRTOT.setName("jPanelRTOT"); // NOI18N
        jPanelRTOT.setLayout(new java.awt.GridBagLayout());

        buttonsPane_RTOT.setName("buttonsPane_RTOT"); // NOI18N
        buttonsPane_RTOT.setLayout(new java.awt.GridBagLayout());

        stopB_RTOT.setAction(actionMap.get("Stop")); // NOI18N
        stopB_RTOT.setText(resourceMap.getString("stopB.text")); // NOI18N
        stopB_RTOT.setName("stopB_RTOT"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 0);
        buttonsPane_RTOT.add(stopB_RTOT, gridBagConstraints);

        saveResB_RTOT.setAction(actionMap.get("SaveRes_RTOTAction")); // NOI18N
        saveResB_RTOT.setText(resourceMap.getString("saveResultsIn.text")); // NOI18N
        saveResB_RTOT.setName("saveResB_RTOT"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        buttonsPane_RTOT.add(saveResB_RTOT, gridBagConstraints);

        genB_RTOT.setAction(actionMap.get("Generate_RTOT")); // NOI18N
        genB_RTOT.setText(resourceMap.getString("genB_RTOT.text")); // NOI18N
        genB_RTOT.setName("genB_RTOT"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 5);
        buttonsPane_RTOT.add(genB_RTOT, gridBagConstraints);

        browseB_RTOT.setAction(actionMap.get("Browse_RTOTAction")); // NOI18N
        browseB_RTOT.setText(resourceMap.getString("selectFolder.text")); // NOI18N
        browseB_RTOT.setName("browseB_RTOT"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        buttonsPane_RTOT.add(browseB_RTOT, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 0);
        jPanelRTOT.add(buttonsPane_RTOT, gridBagConstraints);

        jLabel11.setText(resourceMap.getString("selectedFolder.label")); // NOI18N
        jLabel11.setName("jLabel11"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        jPanelRTOT.add(jLabel11, gridBagConstraints);

        jLabel12.setText(resourceMap.getString("jLabel12.text")); // NOI18N
        jLabel12.setName("jLabel12"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        jPanelRTOT.add(jLabel12, gridBagConstraints);

        resultF_RTOT.setColumns(20);
        resultF_RTOT.setEditable(false);
        resultF_RTOT.setFont(resourceMap.getFont("TextFields.font")); // NOI18N
        resultF_RTOT.setText(resourceMap.getString("selectFolderField.text")); // NOI18N
        resultF_RTOT.setName("resultF_RTOT"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 10);
        jPanelRTOT.add(resultF_RTOT, gridBagConstraints);

        inputF_RTOT.setColumns(20);
        inputF_RTOT.setEditable(false);
        inputF_RTOT.setFont(resourceMap.getFont("TextFields.font")); // NOI18N
        inputF_RTOT.setText(resourceMap.getString("selectFolderField.text")); // NOI18N
        inputF_RTOT.setName("inputF_RTOT"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 10);
        jPanelRTOT.add(inputF_RTOT, gridBagConstraints);

        jTabbedPane1.addTab(resourceMap.getString("jPanelRTOT.TabConstraints.tabTitle"), jPanelRTOT); // NOI18N

        jPanelJoin.setName("jPanelJoin"); // NOI18N
        jPanelJoin.setLayout(new java.awt.GridBagLayout());

        buttonsPane_join.setName("buttonsPane_join"); // NOI18N
        buttonsPane_join.setLayout(new java.awt.GridBagLayout());

        stopB_join.setAction(actionMap.get("Stop")); // NOI18N
        stopB_join.setText(resourceMap.getString("stopB.text")); // NOI18N
        stopB_join.setName("stopB_join"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 0);
        buttonsPane_join.add(stopB_join, gridBagConstraints);

        joinJTLsB.setAction(actionMap.get("Join_JTLsAction")); // NOI18N
        joinJTLsB.setText(resourceMap.getString("joinJTLsB.text")); // NOI18N
        joinJTLsB.setName("joinJTLsB"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 5);
        buttonsPane_join.add(joinJTLsB, gridBagConstraints);

        browseB_join.setAction(actionMap.get("Browse_joinAction")); // NOI18N
        browseB_join.setText(resourceMap.getString("selectFolder.text")); // NOI18N
        browseB_join.setName("browseB_join"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        buttonsPane_join.add(browseB_join, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(20, 10, 10, 0);
        jPanelJoin.add(buttonsPane_join, gridBagConstraints);

        jLabel18.setText(resourceMap.getString("jLabel18.text")); // NOI18N
        jLabel18.setName("jLabel18"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        jPanelJoin.add(jLabel18, gridBagConstraints);

        selectedField_join.setColumns(20);
        selectedField_join.setEditable(false);
        selectedField_join.setFont(resourceMap.getFont("TextFields.font")); // NOI18N
        selectedField_join.setText(resourceMap.getString("selectFolderField.text")); // NOI18N
        selectedField_join.setName("selectedField_join"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 10);
        jPanelJoin.add(selectedField_join, gridBagConstraints);

        jTabbedPane1.addTab(resourceMap.getString("jPanelJoin.TabConstraints.tabTitle"), jPanelJoin); // NOI18N

        jPanelTrimmed.setName("jPanelTrimmed"); // NOI18N
        jPanelTrimmed.setLayout(new java.awt.GridBagLayout());

        buttonsPane_trimmed.setName("buttonsPane_trimmed"); // NOI18N
        buttonsPane_trimmed.setLayout(new java.awt.GridBagLayout());

        genCsvB_trimmed.setAction(actionMap.get("Generate_trimmedAction")); // NOI18N
        genCsvB_trimmed.setText(resourceMap.getString("genCsvB_trimmed.text")); // NOI18N
        genCsvB_trimmed.setName("genCsvB_trimmed"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 5);
        buttonsPane_trimmed.add(genCsvB_trimmed, gridBagConstraints);

        browseB_trimmed.setAction(actionMap.get("Browse_trimmedAction")); // NOI18N
        browseB_trimmed.setText(resourceMap.getString("selectFile.text")); // NOI18N
        browseB_trimmed.setName("browseB_trimmed"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        buttonsPane_trimmed.add(browseB_trimmed, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 0);
        jPanelTrimmed.add(buttonsPane_trimmed, gridBagConstraints);

        jLabel5.setText(resourceMap.getString("jLabel5.text")); // NOI18N
        jLabel5.setName("jLabel5"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        jPanelTrimmed.add(jLabel5, gridBagConstraints);

        jLabel6.setText(resourceMap.getString("jLabel6.text")); // NOI18N
        jLabel6.setName("jLabel6"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        jPanelTrimmed.add(jLabel6, gridBagConstraints);

        resultF_trimmed.setColumns(20);
        resultF_trimmed.setEditable(false);
        resultF_trimmed.setFont(resourceMap.getFont("TextFields.font")); // NOI18N
        resultF_trimmed.setText(resourceMap.getString("selectFile.text")); // NOI18N
        resultF_trimmed.setName("resultF_trimmed"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 10);
        jPanelTrimmed.add(resultF_trimmed, gridBagConstraints);

        inputF_trimmed.setColumns(20);
        inputF_trimmed.setEditable(false);
        inputF_trimmed.setFont(resourceMap.getFont("TextFields.font")); // NOI18N
        inputF_trimmed.setText(resourceMap.getString("selectFile.text")); // NOI18N
        inputF_trimmed.setName("inputF_trimmed"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 10);
        jPanelTrimmed.add(inputF_trimmed, gridBagConstraints);

        jLabel7.setText(resourceMap.getString("jLabel7.text")); // NOI18N
        jLabel7.setName("jLabel7"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 5, 0);
        jPanelTrimmed.add(jLabel7, gridBagConstraints);

        timelineF.setColumns(3);
        timelineF.setEditable(false);
        timelineF.setEnabled(false);
        timelineF.setName("timelineF"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        jPanelTrimmed.add(timelineF, gridBagConstraints);

        jLabel8.setText(resourceMap.getString("jLabel8.text")); // NOI18N
        jLabel8.setName("jLabel8"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 0);
        jPanelTrimmed.add(jLabel8, gridBagConstraints);

        jLabel9.setText(resourceMap.getString("jLabel9.text")); // NOI18N
        jLabel9.setName("jLabel9"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 5, 0);
        jPanelTrimmed.add(jLabel9, gridBagConstraints);

        jLabel10.setText(resourceMap.getString("jLabel10.text")); // NOI18N
        jLabel10.setName("jLabel10"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        jPanelTrimmed.add(jLabel10, gridBagConstraints);

        trimmedJTLF.setColumns(20);
        trimmedJTLF.setEditable(false);
        trimmedJTLF.setFont(resourceMap.getFont("TextFields.font")); // NOI18N
        trimmedJTLF.setText(resourceMap.getString("selectFile.text")); // NOI18N
        trimmedJTLF.setName("trimmedJTLF"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 10);
        jPanelTrimmed.add(trimmedJTLF, gridBagConstraints);

        timelineStartFF.setBorder(javax.swing.BorderFactory.createEtchedBorder(resourceMap.getColor("timelineStartFF.border.highlightColor"), null)); // NOI18N
        timelineStartFF.setColumns(3);
        timelineStartFF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        timelineStartFF.setEnabled(false);
        timelineStartFF.setName("timelineStartFF"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        jPanelTrimmed.add(timelineStartFF, gridBagConstraints);

        timelineEndFF.setBorder(javax.swing.BorderFactory.createEtchedBorder(resourceMap.getColor("timelineEndFF.border.highlightColor"), null)); // NOI18N
        timelineEndFF.setColumns(3);
        timelineEndFF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        timelineEndFF.setEnabled(false);
        timelineEndFF.setName("timelineEndFF"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        jPanelTrimmed.add(timelineEndFF, gridBagConstraints);

        jLabel20.setFont(resourceMap.getFont("jLabel20.font")); // NOI18N
        jLabel20.setText(resourceMap.getString("jLabel20.text")); // NOI18N
        jLabel20.setName("jLabel20"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        jPanelTrimmed.add(jLabel20, gridBagConstraints);

        jTabbedPane1.addTab(resourceMap.getString("jPanelTrimmed.TabConstraints.tabTitle"), jPanelTrimmed); // NOI18N

        jPanelSettings.setName("jPanelSettings"); // NOI18N
        jPanelSettings.setLayout(new java.awt.GridBagLayout());

        graphsPane.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED), resourceMap.getString("graphsPane.border.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        graphsPane.setName("graphsPane"); // NOI18N
        graphsPane.setLayout(new java.awt.GridBagLayout());

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(resourceMap.getString("jPanel4.border.title"))); // NOI18N
        jPanel4.setName("jPanel4"); // NOI18N
        jPanel4.setLayout(new java.awt.GridBagLayout());

        graphXFF.setColumns(4);
        graphXFF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        graphXFF.setName("graphXFF"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 5, 0);
        jPanel4.add(graphXFF, gridBagConstraints);

        graphYFF.setColumns(4);
        graphYFF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        graphYFF.setName("graphYFF"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 5, 0);
        jPanel4.add(graphYFF, gridBagConstraints);

        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 5, 0);
        jPanel4.add(jLabel1, gridBagConstraints);

        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 5, 0);
        jPanel4.add(jLabel2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        graphsPane.add(jPanel4, gridBagConstraints);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(resourceMap.getString("jPanel6.border.title"))); // NOI18N
        jPanel6.setName("jPanel6"); // NOI18N
        jPanel6.setLayout(new java.awt.GridBagLayout());

        realTimelineChk.setSelected(true);
        realTimelineChk.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        realTimelineChk.setName("realTimelineChk"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 5, 0);
        jPanel6.add(realTimelineChk, gridBagConstraints);

        limitRowsChk.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        limitRowsChk.setName("limitRowsChk"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 5, 0);
        jPanel6.add(limitRowsChk, gridBagConstraints);

        jLabel13.setText(resourceMap.getString("jLabel13.text")); // NOI18N
        jLabel13.setName("jLabel13"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 5, 0);
        jPanel6.add(jLabel13, gridBagConstraints);

        jLabel14.setText(resourceMap.getString("jLabel14.text")); // NOI18N
        jLabel14.setName("jLabel14"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 5, 0);
        jPanel6.add(jLabel14, gridBagConstraints);

        jLabel15.setText(resourceMap.getString("jLabel15.text")); // NOI18N
        jLabel15.setName("jLabel15"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 5, 0);
        jPanel6.add(jLabel15, gridBagConstraints);

        forceYFF.setColumns(6);
        forceYFF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        forceYFF.setName("forceYFF"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 13, 5, 0);
        jPanel6.add(forceYFF, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 5, 5);
        graphsPane.add(jPanel6, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        jPanelSettings.add(graphsPane, gridBagConstraints);

        csvPane.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED), resourceMap.getString("csvPane.border.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, resourceMap.getFont("csvPane.border.titleFont"))); // NOI18N
        csvPane.setName("csvPane"); // NOI18N
        csvPane.setLayout(new java.awt.GridBagLayout());

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(resourceMap.getString("jPanel3.border.title"))); // NOI18N
        jPanel3.setName("jPanel3"); // NOI18N
        jPanel3.setLayout(new java.awt.GridBagLayout());

        localeSepCmb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { ";", "," }));
        localeSepCmb.setName("localeSepCmb"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 0, 15);
        jPanel3.add(localeSepCmb, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 5);
        csvPane.add(jPanel3, gridBagConstraints);

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(resourceMap.getString("jScrollPane1.border.title"))); // NOI18N
        jScrollPane1.setName("jScrollPane1"); // NOI18N

        colsList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Step", "Samples", "Average", "Median", "90% line", "Minimum", "Maximum", "Errors%" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        colsList.setName("colsList"); // NOI18N
        colsList.setSelectedIndices(filledArray10);
        jScrollPane1.setViewportView(colsList);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 10, 5);
        csvPane.add(jScrollPane1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 3);
        jPanelSettings.add(csvPane, gridBagConstraints);

        commonPane.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED), resourceMap.getString("commonPane.border.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        commonPane.setName("commonPane"); // NOI18N
        commonPane.setLayout(new java.awt.GridBagLayout());

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(resourceMap.getString("jPanel5.border.title"))); // NOI18N
        jPanel5.setName("jPanel5"); // NOI18N
        jPanel5.setLayout(new java.awt.GridBagLayout());

        mainCommOnlyC.setText(resourceMap.getString("mainCommOnlyC.text")); // NOI18N
        mainCommOnlyC.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        mainCommOnlyC.setName("mainCommOnlyC"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 0, 15);
        jPanel5.add(mainCommOnlyC, gridBagConstraints);

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/generateCsvReportsP/resources/information.png"))); // NOI18N
        jLabel16.setToolTipText(resourceMap.getString("mainStepsC.toolTipText")); // NOI18N
        jLabel16.setName("jLabel16"); // NOI18N
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                infoLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                infoLabelMouseExited(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel5.add(jLabel16, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 5, 5);
        commonPane.add(jPanel5, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 3, 5);
        jPanelSettings.add(commonPane, gridBagConstraints);

        jTabbedPane1.addTab(resourceMap.getString("jPanelSettings.TabConstraints.tabTitle"), jPanelSettings); // NOI18N

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 0.2;
        mainPanel.add(jTabbedPane1, gridBagConstraints);

        //getFrame().setIconImage(resourceMap.getImageIcon("app.icon"));

        statusPanel.setName("statusPanel"); // NOI18N

        statusPanelSeparator.setName("statusPanelSeparator"); // NOI18N

        statusMessageLabel.setFont(resourceMap.getFont("statusMessageLabel.font")); // NOI18N
        statusMessageLabel.setName("statusMessageLabel"); // NOI18N

        javax.swing.GroupLayout statusPanelLayout = new javax.swing.GroupLayout(statusPanel);
        statusPanel.setLayout(statusPanelLayout);
        statusPanelLayout.setHorizontalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(statusPanelSeparator, javax.swing.GroupLayout.DEFAULT_SIZE, 634, Short.MAX_VALUE)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(statusMessageLabel)
                .addContainerGap(624, Short.MAX_VALUE))
        );
        statusPanelLayout.setVerticalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addComponent(statusPanelSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(statusMessageLabel)
                .addGap(3, 3, 3))
        );

        chooseJTL_multi.setApproveButtonText(resourceMap.getString("chooseJTL.approveButtonText")); // NOI18N
        chooseJTL_multi.setCurrentDirectory(new java.io.File("C:\\results"));
        chooseJTL_multi.setDialogTitle(resourceMap.getString("selectFolderContJTLs")); // NOI18N
        chooseJTL_multi.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);
        chooseJTL_multi.setName("chooseJTL_multi"); // NOI18N

        chooseSave_multi.setApproveButtonText(resourceMap.getString("chooseJTL.approveButtonText")); // NOI18N
        chooseSave_multi.setDialogTitle(resourceMap.getString("saveFolder.dialogTitle")); // NOI18N
        chooseSave_multi.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);
        chooseSave_multi.setName("chooseSave_multi"); // NOI18N

        chooseJTL_trimmed.setCurrentDirectory(new java.io.File("C:\\results"));
        chooseJTL_trimmed.setDialogTitle(resourceMap.getString("chooseFile.dialogTitle")); // NOI18N
        chooseJTL_trimmed.setFileFilter(filter);
        chooseJTL_trimmed.setName("chooseJTL_trimmed"); // NOI18N

        chooseJTL_RTOT.setApproveButtonText(resourceMap.getString("chooseJTL.approveButtonText")); // NOI18N
        chooseJTL_RTOT.setCurrentDirectory(new java.io.File("C:\\results"));
        chooseJTL_RTOT.setDialogTitle(resourceMap.getString("selectFolderContJTLs")); // NOI18N
        chooseJTL_RTOT.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);
        chooseJTL_RTOT.setName("chooseJTL_RTOT"); // NOI18N

        chooseSave_RTOT.setApproveButtonText(resourceMap.getString("chooseJTL.approveButtonText")); // NOI18N
        chooseSave_RTOT.setDialogTitle(resourceMap.getString("saveFolder.dialogTitle")); // NOI18N
        chooseSave_RTOT.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);
        chooseSave_RTOT.setName("chooseSave_RTOT"); // NOI18N

        chooseJTL_join.setCurrentDirectory(new java.io.File("C:\\results"));
        chooseJTL_join.setDialogTitle(resourceMap.getString("selectFolderContJTLs")); // NOI18N
        chooseJTL_join.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);
        chooseJTL_join.setName("chooseJTL_join"); // NOI18N

        chooseJTL_4All.setCurrentDirectory(new java.io.File("C:\\results"));
        chooseJTL_4All.setDialogTitle(resourceMap.getString("selectFolderContJTLs")); // NOI18N
        chooseJTL_4All.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);
        chooseJTL_4All.setName("chooseJTL_4All"); // NOI18N

        setComponent(mainPanel);
        setStatusBar(statusPanel);
    }// </editor-fold>//GEN-END:initComponents

    private void infoLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_infoLabelMouseEntered
        ToolTipManager.sharedInstance().setDismissDelay(60000);
    }//GEN-LAST:event_infoLabelMouseEntered

    private void infoLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_infoLabelMouseExited
        ToolTipManager.sharedInstance().setDismissDelay(0);
    }//GEN-LAST:event_infoLabelMouseExited
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton browseB_4All;
    private javax.swing.JButton browseB_RTOT;
    private javax.swing.JButton browseB_join;
    private javax.swing.JButton browseB_multi;
    private javax.swing.JButton browseB_trimmed;
    private javax.swing.JPanel buttonsPane_4All;
    private javax.swing.JPanel buttonsPane_RTOT;
    private javax.swing.JPanel buttonsPane_join;
    private javax.swing.JPanel buttonsPane_multi;
    private javax.swing.JPanel buttonsPane_trimmed;
    private javax.swing.JFileChooser chooseJTL_4All;
    private javax.swing.JFileChooser chooseJTL_RTOT;
    private javax.swing.JFileChooser chooseJTL_join;
    private javax.swing.JFileChooser chooseJTL_multi;
    private javax.swing.JFileChooser chooseJTL_trimmed;
    private javax.swing.JFileChooser chooseSave_RTOT;
    private javax.swing.JFileChooser chooseSave_multi;
    private static javax.swing.JList colsList;
    private javax.swing.JPanel commonPane;
    private javax.swing.JPanel csvPane;
    private javax.swing.JFormattedTextField forceYFF;
    private javax.swing.JButton genB_4All;
    private javax.swing.JButton genB_RTOT;
    private javax.swing.JButton genCsvB_multi;
    private javax.swing.JButton genCsvB_trimmed;
    private javax.swing.JFormattedTextField graphXFF;
    private javax.swing.JFormattedTextField graphYFF;
    private javax.swing.JPanel graphsPane;
    private javax.swing.JTextField inputF_4All;
    private javax.swing.JTextField inputF_RTOT;
    private javax.swing.JTextField inputF_multi;
    private javax.swing.JTextField inputF_trimmed;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel4All;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanelJoin;
    private javax.swing.JPanel jPanelMulti;
    private javax.swing.JPanel jPanelRTOT;
    private javax.swing.JPanel jPanelSettings;
    private javax.swing.JPanel jPanelTrimmed;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton joinJTLsB;
    private static javax.swing.JCheckBox limitRowsChk;
    private javax.swing.JComboBox localeSepCmb;
    private static javax.swing.JCheckBox mainCommOnlyC;
    private javax.swing.JPanel mainPanel;
    private static javax.swing.JCheckBox realTimelineChk;
    private javax.swing.JTextField resultF_4All;
    private javax.swing.JTextField resultF_RTOT;
    private javax.swing.JTextField resultF_multi;
    private javax.swing.JTextField resultF_trimmed;
    private javax.swing.JButton saveResB_RTOT;
    private javax.swing.JButton saveResB_multi;
    private javax.swing.JTextField selectedField_join;
    private static javax.swing.JLabel statusMessageLabel;
    private javax.swing.JPanel statusPanel;
    private javax.swing.JButton stopB_4All;
    private javax.swing.JButton stopB_RTOT;
    private javax.swing.JButton stopB_join;
    private javax.swing.JButton stopB_multi;
    private javax.swing.JFormattedTextField timelineEndFF;
    private javax.swing.JTextField timelineF;
    private javax.swing.JFormattedTextField timelineStartFF;
    private javax.swing.JTextField trimmedJTLF;
    // End of variables declaration//GEN-END:variables

    private File resultSavingFolder_4All;
    private File inputJTL_multi;
    private File resultSavingFolder_multi;
    private Boolean savResUsed_multi = false;
    private File inputJTL_RTOT;
    private File resultSavingFolder_RTOT;
    private Boolean savResUsed_RTOT = false;
    private Boolean gen4AllUsed = false;
    private Boolean doAgg = false;
    private Boolean doRTOT = false;
    private Integer totalElapsedTime = 0;
    private File inputJTL_trimmed;
    private File trimmedJTL;
    private File resultCSV_trimmed;
    private File resultFolder_join;
    private int firstValLine;
    private int lastValLine;  
    
    public List<String> extensionsToIgnore;
    public List<String> extensionsToSearchFor;    
    private ArrayList<File> aListOfJTLFiles = new ArrayList<File>(); 
    private ArrayList<String> aListOfScripts = new ArrayList<String>();
    private boolean doCont = true;
    private final GenSettingsWorker ow = new GenSettingsWorker();
    private final int[] filledArray10 = {0,1,2,4,5,6,7};
    private final FileFilter filter = new FileNameExtensionFilter("jtl", "JTL");
    private final String newLine = System.getProperty("line.separator");
    private String[][] matrixArr;
    private String[][] sortedArray;
    private final String HeadLine1 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
    private final String HeadLine2 = "<testResults version=\"1.2\">";
    private final String FooterLine = "</testResults>";
    private final String attachStringTrimmed = "TRIMMED_";
    private final String attachStringError = "ERRORS_";
    private final String attach4AllReports = "_reports";
    private final String attachReports = "_AggregatedReports";
    private final String attachRTOT = "_ResponseTimesOverTime";
    private final char quote = '"';
    private final String TStart = "\" ts=\"";  
    
    // <editor-fold defaultstate="collapsed" desc="processF">
    private void processF(File aFile) {

        if (doCont){ //Listen for "Stop"

        if(extensionsToIgnore==null)
                extensionsToIgnore = new ArrayList<String>();
        if(extensionsToSearchFor==null)
                extensionsToSearchFor = new ArrayList<String>();

        if (aFile.isFile() && aFile.getName()!=null && !aFile.toString().contains("~$")) {
                String extension = aFile.getName().substring(aFile.getName().lastIndexOf(".")+1, aFile.getName().length());

            if(extensionsToSearchFor.size()>0) {//if ext list is empty, then search for all
                    if(!extensionsToIgnore.contains(extension) && extensionsToSearchFor.contains(extension)
                            ){
                        aListOfJTLFiles.add(aFile);
                        
                    }
                }else if(!extensionsToIgnore.contains(extension)){
                 //THIS is called only if no extension is set, and get all except ignored ext
                }

        }
        else if (aFile.isDirectory()) {
//            System.out.println("Looking inside: "+aFile);
            statusMessageLabel.setText("Scanning files inside: "+aFile.toString());
                File[] listOfFiles = aFile.listFiles();
                if (listOfFiles != null) {
                        for (int i = 0; i < listOfFiles.length; i++)
                                processF(listOfFiles[i]);
                } else {
//                        System.out.println("[ACCESS DENIED]");
                }
        }
        }
    }

    private void setExtensionsToIgnore(String ext) {
            if(extensionsToIgnore==null)
                    extensionsToIgnore = new ArrayList<String>();

            extensionsToIgnore.add(ext);
    }

    private void setExtensionsToSearchFor(String ext) {
            if(extensionsToSearchFor==null)
                    extensionsToSearchFor = new ArrayList<String>();

            extensionsToSearchFor.add(ext);
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Multi">
    @Action
    public Task Generate_multiAction() {
        return new Generate_multiActionTask(getApplication());
    }
    private class Generate_multiActionTask extends org.jdesktop.application.Task<Object, Void> {
        Generate_multiActionTask(org.jdesktop.application.Application app) {
            super(app);
            System.out.println("Executing multiple reports mode.");
            browseB_multi.setEnabled(false);
            genCsvB_multi.setEnabled(false);
            saveResB_multi.setEnabled(false);
            stopB_multi.setEnabled(true);
            statusMessageLabel.setText("Searching for files...");
        }
        @Override protected Object doInBackground() {
            
            processF(inputJTL_multi); //FILL aListOfJTLFiles
            if (aListOfJTLFiles.isEmpty()) return 0;
            if (!resultSavingFolder_multi.exists()) resultSavingFolder_multi.mkdir();
            formCsvParams();
            
            File jtlF;
            File csvF;
            File csvF_Err;
            String fileNameEx;

            for (int bl=0;bl<aListOfJTLFiles.size()&doCont;bl++){ 

                jtlF = aListOfJTLFiles.get(bl);
                statusMessageLabel.setText("Creating CSV: "+jtlF.toString());
                fileNameEx = jtlF.getName();
                fileNameEx = fileNameEx.substring(0, fileNameEx.length()-4);
                csvF = new File(resultSavingFolder_multi+File.separator+fileNameEx+".csv");                
                ow.init_CSV(jtlF.toString(),csvF.toString());

                if(ow.checkForErrors()){
                    csvF_Err = new File(csvF.getParentFile()+File.separator+attachStringError+csvF.getName());
                    Utils.deleteFile(csvF_Err);//delete (needed to rename)
                    Utils.renameFile(csvF, csvF_Err);
                }
                }
            if (!doCont) return 1;
            else return 2;
        }
        @Override protected void cancelled() {                      
            doCont = false;
        }
        @Override protected void succeeded(Object result) {

            String message;
            switch (((Integer)result).intValue()){
                case 0: message = "Selected folder did not contain any JTL files. Aborted."; break;
                case 1: message = "Aborted by user."; break;
                case 2:
                    totalElapsedTime += (int) this.getExecutionDuration(TimeUnit.SECONDS);
                    int mins = totalElapsedTime / 60;
                    int secs = totalElapsedTime % 60;
                    if (totalElapsedTime>59) message = "Done. Operation took "+String.valueOf(mins)+" minutes and "+String.valueOf(secs)+" seconds to complete.";
                    else message = "Done. Operation took "+String.valueOf(secs)+" seconds to complete.";
                    break;
                default: message = "Error."; break;    
            }
            statusMessageLabel.setText(message);            
                
            browseB_multi.setEnabled(true);
            genCsvB_multi.setEnabled(true);
            saveResB_multi.setEnabled(true);
            stopB_multi.setEnabled(false);
            aListOfJTLFiles.clear();
            if (!gen4AllUsed){
                totalElapsedTime = 0;
                doCont = true;
            }
            System.out.println("-----Aggregated done.-----");  
            if (doRTOT) Generate_RTOT().execute(); //used by whole reports
            doRTOT = false;            
        }
    }
    
    @Action
    public void Browse_multiAction() throws Exception {

        int rr = chooseJTL_multi.showOpenDialog(null);
        if(rr == JFileChooser.APPROVE_OPTION){
            inputJTL_multi = chooseJTL_multi.getSelectedFile();

            inputF_multi.setText(inputJTL_multi.toString());
            
            if (!savResUsed_multi){
                resultSavingFolder_multi = new File(inputJTL_multi.getCanonicalPath()+attachReports);
                resultF_multi.setText(resultSavingFolder_multi.toString());                
            }
            inputF_multi.setCaretPosition(0);
            resultF_multi.setCaretPosition(0);
            genCsvB_multi.setEnabled(true);
        }
        else if(rr == JFileChooser.CANCEL_OPTION);

    }

    @Action
    public void SaveRes_multiAction() {
        chooseSave_multi.setCurrentDirectory(chooseJTL_multi.getCurrentDirectory());
        int tt = chooseSave_multi.showSaveDialog(null);
        if(tt == JFileChooser.APPROVE_OPTION){
            resultSavingFolder_multi = chooseSave_multi.getSelectedFile();
            resultF_multi.setText(resultSavingFolder_multi.toString()); 
            resultF_multi.setCaretPosition(0);
            savResUsed_multi = true;
        }
        else if (tt == JFileChooser.CANCEL_OPTION);
    }   
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Trimmed">
    @Action 
    public Task Generate_trimmedAction() {
        return new Generate_trimmedActionTask(getApplication());
    }
    private class Generate_trimmedActionTask extends org.jdesktop.application.Task<Object, Void> {
        Generate_trimmedActionTask(org.jdesktop.application.Application app) {
            super(app);
            statusMessageLabel.setText("");      
            browseB_trimmed.setEnabled(false);
            genCsvB_trimmed.setEnabled(false);
            statusMessageLabel.setText("Calculating...");
        }
        @Override protected Object doInBackground() {
            
            if (timelineStartFF.getValue() == null | timelineEndFF.getValue() == null) return 0;
            Integer startP = ((Number)timelineStartFF.getValue()).intValue();
            Integer endP = ((Number)timelineEndFF.getValue()).intValue();  
            if (startP > endP) return 1;
            statusMessageLabel.setText("Preparing environment...");  
            formCsvParams();
            
            statusMessageLabel.setText("Reading JTL...");
            getSELinesNo(inputJTL_trimmed,startP,endP);
            statusMessageLabel.setText("Forming new JTL...");
            formTrimmedJTL(inputJTL_trimmed, trimmedJTL, firstValLine, lastValLine);
            statusMessageLabel.setText("Generating CSV report..");
            ow.init_CSV(trimmedJTL.toString(),resultCSV_trimmed.toString());
            return 2; 
        }
        @Override protected void cancelled() {                      
            doCont = false;
        }
        @Override protected void succeeded(Object result) {
            
            String message;
            switch (((Integer)result).intValue()){
                case 0: message = "Please define starting and ending point."; break;
                case 1: message = "Starting point cannot be bigger than ending point."; break;
                case 2:
                    totalElapsedTime += (int) this.getExecutionDuration(TimeUnit.SECONDS);
                    int mins = totalElapsedTime / 60;
                    int secs = totalElapsedTime % 60;
                    if (totalElapsedTime>59) message = "Done. Operation took "+String.valueOf(mins)+" minutes and "+String.valueOf(secs)+" seconds to complete.";
                    else message = "Done. Operation took "+String.valueOf(secs)+" seconds to complete."; 
                    break;
                default: message = "Error."; break;    
            }
            statusMessageLabel.setText(message);
            
            System.out.println("DONE.");
            browseB_trimmed.setEnabled(true);
            genCsvB_trimmed.setEnabled(true);
            totalElapsedTime = 0;
            doCont = true;
        }
    }

    @Action
    public void Browse_trimmedAction() {
        int rr = chooseJTL_trimmed.showOpenDialog(null);
        if(rr == JFileChooser.APPROVE_OPTION){
            
            inputJTL_trimmed = chooseJTL_trimmed.getSelectedFile();                       
            String fileName = inputJTL_trimmed.getName();
            String fileNameWExt = fileName.substring(0, fileName.length()-4);
            String filePathEx = inputJTL_trimmed.getParentFile().toString();
            
            trimmedJTL = new File(filePathEx+File.separator+attachStringTrimmed+fileName);            
            resultCSV_trimmed = new File(filePathEx+File.separator+attachStringTrimmed+fileNameWExt+".csv");            
            
            trimmedJTLF.setText(trimmedJTL.toString());
            inputF_trimmed.setText(inputJTL_trimmed.toString()); 
            resultF_trimmed.setText(resultCSV_trimmed.toString());
            statusMessageLabel.setText("Reading JTL's timeline...");
            timelineF.setText(String.valueOf(getTimeline(inputJTL_trimmed)));
            timelineStartFF.setText("");
            timelineEndFF.setText("");
            
            trimmedJTLF.setCaretPosition(0);
            inputF_trimmed.setCaretPosition(0);    
            resultF_trimmed.setCaretPosition(0);
            genCsvB_trimmed.setEnabled(true);
            timelineStartFF.setEnabled(true);
            timelineEndFF.setEnabled(true);
            timelineF.setEnabled(true);
            statusMessageLabel.setText("Please define both starting and ending points before starting.");

        }
        else if (rr == JFileChooser.CANCEL_OPTION);
    }
    
    private int getTimeline(File inputJTL){
       
       try{
           BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(inputJTL)));
           String line;
           int iStartT;
           int iEndT;
           String currT;
           long currT_Long;
           int currT_mins = 0;
           int cntInner = 0;
           long firstVal = 0;
           
           while((line = bf.readLine()) !=null){

               if(line.startsWith("<sample") || line.startsWith("<httpSample")){ 
                   cntInner++;
                   iStartT = line.indexOf(TStart)+TStart.length();
                   iEndT = line.indexOf(quote, iStartT);
                   currT = line.substring(iStartT,iEndT);
                   currT_Long = Long.parseLong(currT);

                   if (cntInner==1)
                       firstVal = currT_Long;
                   
                   currT_mins = (int) (currT_Long-firstVal)/60000;
//                   System.out.println(currT_mins);
               }               
           }           
//           System.out.println(currT_mins);
           return currT_mins;//== last value

       }
       catch(Exception erp){
//           erp.printStackTrace();
           return 0;
       }       
    }
   
    private void getSELinesNo(File inputJTL, int globStart, int globEnd){ // AKA get dates for StartEnd

       try{
           BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(inputJTL)));
           ArrayList<Integer> aListLines = new ArrayList<Integer>();
           String line;
           int iStartT;
           int iEndT;
           String currT;
           long currT_Long;
           long currT_mins;    
           int cnt = 0;
           int cntInner = 0;
           long firstVal = 0;
           
           while((line = bf.readLine()) !=null){
               cnt++;

               if(line.startsWith("<sample") || line.startsWith("<httpSample")){ 
                   cntInner++;
                   iStartT = line.indexOf(TStart)+TStart.length();
                   iEndT = line.indexOf(quote, iStartT);
                   currT = line.substring(iStartT,iEndT);
                   currT_Long = Long.parseLong(currT);

                   if (cntInner==1)
                       firstVal = currT_Long;                   

                   currT_mins = (currT_Long-firstVal)/60000;
//                   System.out.println(currT_mins);
                   if (currT_mins >= globStart && currT_mins <=globEnd){
                       aListLines.add(cnt);
                   }
               }               
           }

           firstValLine = aListLines.get(0);
           System.out.println("Starting point line: "+firstValLine);           
           lastValLine = aListLines.get(aListLines.size()-1);
           System.out.println("Ending point line: "+lastValLine);
       }
       catch(Exception erp){
//           erp.printStackTrace();
       }       
    }

    private void formTrimmedJTL(File inputJTL, File resultJTL, int firstValLine, int lastValLine){

       try{
           BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(inputJTL)));
           BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(resultJTL,false))); 
           String line;
           int cnt=0;
           bw.append(HeadLine1+newLine+HeadLine2+newLine);
           while((line = bf.readLine()) !=null){
               cnt++;
               if(cnt>=firstValLine && cnt <= lastValLine){
                   bw.append(line+newLine);
               }               
           }
           bw.append(FooterLine+newLine);
           bf.close();
           bw.close();
          
       }
       catch(Exception erp){
//           erp.printStackTrace();
       }       
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="RTOT">
    @Action
    public Task Generate_RTOT() {
        return new Generate_RTOTTask(getApplication());
    }
    private class Generate_RTOTTask extends org.jdesktop.application.Task<Object, Void> {
        Generate_RTOTTask(org.jdesktop.application.Application app) {
            super(app);
            System.out.println("Executing Response Times Over Time graphs mode.");

            browseB_RTOT.setEnabled(false);
            genB_RTOT.setEnabled(false);
            saveResB_RTOT.setEnabled(false);
            stopB_RTOT.setEnabled(true);
            statusMessageLabel.setText("Searching for files..."); 
        }
        @Override protected Object doInBackground() { 
            
            processF(inputJTL_RTOT); //FILL aListOfJTLFiles
            if (aListOfJTLFiles.isEmpty()) return 0;                
            if (!resultSavingFolder_RTOT.exists()) resultSavingFolder_RTOT.mkdir();            
            formPngParams();
            
            File jtlF;
            File pngF;
            String fileNameEx;    
            
            for (int bl=0;bl<aListOfJTLFiles.size()&doCont;bl++){ 

                jtlF = aListOfJTLFiles.get(bl);
                statusMessageLabel.setText("Creating PNG: "+jtlF.toString());
                fileNameEx = jtlF.getName();
                fileNameEx = fileNameEx.substring(0, fileNameEx.length()-4);
                pngF = new File(resultSavingFolder_RTOT+File.separator+fileNameEx+".png");
                
                ow.init_PNG(jtlF.toString(), pngF.toString());              
            }
            if (!doCont) return 1;
            else return 2;
        }
        @Override protected void cancelled() {                      
            doCont = false;
        }
        @Override protected void succeeded(Object result) {
            String message;
            switch (((Integer)result).intValue()){
                case 0: message = "Selected folder did not contain any JTL files. Aborted."; break;
                case 1: message = "Aborted by user."; break;
                case 2:
                    totalElapsedTime += (int) this.getExecutionDuration(TimeUnit.SECONDS);
                    int mins = totalElapsedTime / 60;
                    int secs = totalElapsedTime % 60;
                    if (totalElapsedTime>59) message = "Done. Operation took "+String.valueOf(mins)+" minutes and "+String.valueOf(secs)+" seconds to complete.";
                    else message = "Done. Operation took "+String.valueOf(secs)+" seconds to complete.";
                    break;
                default: message = "Error."; break;    
            }
            statusMessageLabel.setText(message);
            browseB_RTOT.setEnabled(true);
            genB_RTOT.setEnabled(true);
            saveResB_RTOT.setEnabled(true);
            stopB_RTOT.setEnabled(false);
            aListOfJTLFiles.clear();
            if (!gen4AllUsed){
                totalElapsedTime = 0;
                doCont = true;
            }
            System.out.println("-----RTOT done.-----"); 
            if (gen4AllUsed) initSumUpActionsTime();
             
        }
    }

    @Action
    public void Browse_RTOTAction() throws Exception {

        int rr = chooseJTL_RTOT.showOpenDialog(null);
        if(rr == JFileChooser.APPROVE_OPTION){
            inputJTL_RTOT = chooseJTL_RTOT.getSelectedFile();

            inputF_RTOT.setText(inputJTL_RTOT.toString());
            if (!savResUsed_RTOT){
                resultSavingFolder_RTOT = new File(inputJTL_RTOT.getCanonicalPath()+attachRTOT);
                resultF_RTOT.setText(resultSavingFolder_RTOT.toString());
            }
            resultF_RTOT.setCaretPosition(0);
            inputF_RTOT.setCaretPosition(0);
            genB_RTOT.setEnabled(true);
        }
        else if (rr == JFileChooser.CANCEL_OPTION);
    }

    @Action
    public void SaveRes_RTOTAction() {
        chooseSave_RTOT.setCurrentDirectory(chooseJTL_RTOT.getCurrentDirectory());
        int tt = chooseSave_RTOT.showSaveDialog(null);
        if(tt == JFileChooser.APPROVE_OPTION){
            resultSavingFolder_RTOT = chooseSave_RTOT.getSelectedFile();
            resultF_RTOT.setText(resultSavingFolder_RTOT.toString());
            savResUsed_RTOT = true;
            resultF_RTOT.setCaretPosition(0);
        }
        else if (tt == JFileChooser.CANCEL_OPTION);
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="JOIN">
    @Action
    public Task Join_JTLsAction() {
        return new Join_JTLsActionTask(getApplication());
    }

    private class Join_JTLsActionTask extends org.jdesktop.application.Task<Object, Void> {
        Join_JTLsActionTask(org.jdesktop.application.Application app) {
            super(app);
            browseB_join.setEnabled(false);
            joinJTLsB.setEnabled(false);
            stopB_join.setEnabled(true);
            System.out.println("Executing joining.");
        }
        @Override protected Object doInBackground() {
            try{
                setExtensionsToSearchFor("jtl");        
                processF(resultFolder_join); //get JTL's
                if (aListOfJTLFiles.isEmpty()) return 0;
                matrixArr = new String[aListOfJTLFiles.size()][3];
                sortedArray = new String[aListOfJTLFiles.size()][2];
                
                statusMessageLabel.setText("Reading start times of each file...");                
                for (int bl=0;bl<aListOfJTLFiles.size();bl++)
                    getStartTimes(aListOfJTLFiles.get(bl),bl); //fills matrixArr with starting times & forms aListOfScripts      
                
                statusMessageLabel.setText("Sorting files by start times...");
                sortArr(matrixArr); //sorts array to sortedArray by starting times               
                
                statusMessageLabel.setText("Printing headers...");
                for (int f=0;f<aListOfScripts.size() && doCont;f++)
                    doHeader_join(resultFolder_join+File.separator+aListOfScripts.get(f)+".jtl");
                
                for (int i=0; i <sortedArray.length;i++){
                    statusMessageLabel.setText("Joining JTL's for: "+sortedArray[i][1]);
                    doAppendJTL_join(sortedArray[i][0],resultFolder_join+File.separator+sortedArray[i][1]+".jtl");
                }
                
                statusMessageLabel.setText("Printing footers...");
                for (int f=0;f<aListOfScripts.size() && doCont;f++)
                    doFooter_join(resultFolder_join+File.separator+aListOfScripts.get(f)+".jtl");                            
            }
            catch (Exception hm){
                hm.printStackTrace();
                return 3;}
            if (!doCont) return 1;
            return 2;
        }
        @Override protected void cancelled() {                      
            doCont = false;
        }
        @Override protected void succeeded(Object result) {
            String message;
            switch (((Integer)result).intValue()){
                case 0: message = "Selected folder did not contain any JTL files. Aborted."; break;                
                case 1: message = "Aborted by user."; break;
                case 2:
                    totalElapsedTime += (int) this.getExecutionDuration(TimeUnit.SECONDS);
                    int mins = totalElapsedTime / 60;
                    int secs = totalElapsedTime % 60;
                    if (totalElapsedTime>59) message = "Done. Operation took "+String.valueOf(mins)+" minutes and "+String.valueOf(secs)+" seconds to complete.";
                    else message = "Done. Operation took "+String.valueOf(secs)+" seconds to complete.";
                    break;
                case 3: message = "Error occured."; break;
                default: message = "Error."; break;    
            }
            statusMessageLabel.setText(message);
            browseB_join.setEnabled(true);
            joinJTLsB.setEnabled(true);
            stopB_join.setEnabled(false);
            aListOfJTLFiles.clear();
            if (!gen4AllUsed){
                totalElapsedTime = 0;
                doCont = true;
            }
            System.out.println("-----Joining done.-----");
            if (doAgg) Generate_multiAction().execute(); //used by whole reports
            doAgg = false;              
        }
    }
    @Action
    public void Browse_joinAction() {
        int rr = chooseJTL_join.showOpenDialog(null);
        if(rr == JFileChooser.APPROVE_OPTION){

            resultFolder_join = chooseJTL_join.getSelectedFile();
            selectedField_join.setText(resultFolder_join.toString());
            joinJTLsB.setEnabled(true);
        }
        else if (rr == JFileChooser.CANCEL_OPTION);
    }
    
    private void getStartTimes(File jtl, int bl){
       try{
           FileInputStream fs= new FileInputStream(jtl);
           BufferedReader br = new BufferedReader(new InputStreamReader(fs));
           for(int i = 0; i < 2; ++i){
               br.readLine();
           }
           String exStr = br.readLine();
           //get threadName
           String tnStr = "\" tn=\"";
           int iTn = exStr.indexOf(tnStr)+tnStr.length();
           String threadName = exStr.substring(iTn,exStr.indexOf("-", iTn));
           if (threadName.contains(" ")) threadName = threadName.substring(0, threadName.indexOf(" ")); //why?
           //get timestamp
           int iSt = exStr.indexOf(TStart)+TStart.length();
           String timeStamp = exStr.substring(iSt, iSt+13);
           
           br.close();
           fs.close();
           matrixArr[bl][0] = timeStamp;
           matrixArr[bl][1] = jtl.toString();
           matrixArr[bl][2] = threadName;
          
           if (!aListOfScripts.contains(threadName))
               aListOfScripts.add(threadName);
       }
       catch (Exception fm){fm.printStackTrace();}
    }
    
    private void doHeader_join(String result){
        try{
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(result,false),"UTF8"));
            bw.write(HeadLine1);
            bw.newLine();
            bw.write(HeadLine2);

            bw.flush();
            bw.close();
        }
        catch(Exception erp){
    //      erp.printStackTrace();        
        }
    }

    private void doFooter_join(String result){
        try{
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(result,true),"UTF8"));
            bw.newLine();
            bw.write(FooterLine);
            bw.flush();
            bw.close();
        }
        catch(Exception erp){
    //      erp.printStackTrace();  
        }
    }
    
    private void doAppendJTL_join(String fileToAppend, String resultJTL){
        try{             
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(resultJTL,true),"UTF8"));  
            BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(fileToAppend),"UTF8"));
            String line;

            while (( line = bf.readLine()) != null) //&&do Cont
                {
                if (!line.startsWith("<?xml") && !line.startsWith("<test") && !line.startsWith("</test")){     

                    bw.newLine();
                    bw.append(line); 
                }
            }
            bw.close();
            bf.close();

        }
        catch (Exception erp){
            erp.printStackTrace();
        }
    }
    
    private void sortArr(String[][] data){
        Arrays.sort(data, new Comparator<String[]>() {
            @Override
            public int compare(String[] entry1,String[] entry2) {
                String time1 = entry1[0];
                String time2 = entry2[0];
                return time1.compareTo(time2);
            }
        });

        int ite = 0;
        for (String[] s : data) {            
//            System.out.println(s[0] + " " + s[1] + " " + s[2]);
            sortedArray[ite][0] = s[1]; //path+file
            sortedArray[ite][1] = s[2]; //scriptsName
            ite++;
        }
        
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="4All">
    @Action
    public void initReportsGen4All() {
        genB_4All.setEnabled(false);
        stopB_4All.setEnabled(true);
        if (!resultSavingFolder_4All.exists()) resultSavingFolder_4All.mkdir();
        if (!resultSavingFolder_multi.exists()) resultSavingFolder_multi.mkdir();
        if (!resultSavingFolder_RTOT.exists()) resultSavingFolder_RTOT.mkdir();
        doAgg = true;
        doRTOT = true;
        gen4AllUsed = true;
        //pradeda grandinine reakcija        
        Join_JTLsAction().execute(); //do JOIN  
    }
    
    @Action
    public void initSumUpActionsTime() {       
       gen4AllUsed = false;
       if (!doCont) statusMessageLabel.setText("Aborted by user.");
       else{
           int mins = totalElapsedTime / 60;
           int secs = totalElapsedTime % 60;
//           System.out.println("Total elapsed:"+totalElapsedTime);
           if (totalElapsedTime>59) statusMessageLabel.setText("Done. Operation took "+String.valueOf(mins)+" minutes and "+String.valueOf(secs)+" seconds to complete.");
           else statusMessageLabel.setText("Done. Operation took "+String.valueOf(secs)+" seconds to complete.");
       }
       totalElapsedTime = 0;
       genB_4All.setEnabled(true);
       doCont = true;
    }
    
    @Action
    public void Browse_4All() throws Exception {

        int rr = chooseJTL_4All.showOpenDialog(null);
        if(rr == JFileChooser.APPROVE_OPTION){
            
            File inputJTL_4All = chooseJTL_4All.getSelectedFile();//get selected dir
            resultSavingFolder_4All = new File(inputJTL_4All.getCanonicalPath()+attach4AllReports); //set [parent]dest dir

            resultFolder_join = inputJTL_4All; //joining JTL's input & dest
            inputJTL_multi = inputJTL_4All; //input folder for Aggregated
            inputJTL_RTOT = inputJTL_4All; //input folder for RTOT
            
            resultSavingFolder_multi = new File(resultSavingFolder_4All.getCanonicalPath()
                    +File.separator+inputJTL_4All.getName()+attachReports); //dest for Aggregated

            resultSavingFolder_RTOT = new File(resultSavingFolder_4All.getCanonicalPath()
                    +File.separator+inputJTL_4All.getName()+attachRTOT); //dest for RTOT

            
            inputF_4All.setText(inputJTL_4All.toString());  
            resultF_4All.setText(resultSavingFolder_4All.toString());                
            
            inputF_4All.setCaretPosition(0);
            resultF_4All.setCaretPosition(0);
            genB_4All.setEnabled(true);
        }
        else if(rr == JFileChooser.CANCEL_OPTION);

    }
    // </editor-fold>
    
    @Action
    public void Stop() {
        doCont = false;
    }
    
    private void fillStepsArray(){
        Boolean [] colsArray = new Boolean [8];
        for(int ite=0;ite<8;ite++){
            if (colsList.isSelectedIndex(ite)) colsArray[ite]=true;
            else colsArray[ite]=false;           
        }
        ow.setColsArray(colsArray);
    }
    
    private char getSelectedDelim(){
        if(localeSepCmb.getSelectedIndex()==0)
            return ';';
//        if(localeSepCmb.getSelectedIndex()==1)
        else
            return ',';
    }
    
    private void formCsvParams(){
        ow.setShowMainStepsOnly(mainCommOnlyC.isSelected());
        ow.setExportMode(2);
        ow.setPluginType(2);
        ow.setCSVDelim(getSelectedDelim());
        fillStepsArray();
        
    }
    
    private void formPngParams(){
        ow.setShowMainStepsOnly(mainCommOnlyC.isSelected());
        ow.setRealTime(realTimelineChk.isSelected());
        ow.setLimitRows(limitRowsChk.isSelected());
        if (forceYFF.getValue()!=null) ow.setForceY(((Number)forceYFF.getValue()).intValue());
        ow.setGraphSize(((Number)graphXFF.getValue()).intValue(),((Number)graphYFF.getValue()).intValue());
        ow.setExportMode(1);
        ow.setPluginType(1);
    }

}
