package generateCsvReportsP;

import org.jdesktop.application.Action;
import org.jdesktop.application.SingleFrameApplication;
import org.jdesktop.application.FrameView;
import org.jdesktop.application.Task;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileFilter;
import javax.swing.JOptionPane;
import java.awt.Dimension;
import java.io.File;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.math.RoundingMode;
import java.util.ArrayList; 
import java.util.List;
import java.text.DecimalFormat;
import javax.swing.JDialog;
import javax.swing.JFrame;

public class GenerateCsvReportsWorker extends FrameView {
    // (start - end)/1000ms/3600 = hours
    // date    =((currT_Long+7200000)/86400000+25569)+1/24 
    //TODO: which lines(for main comms) in array
    //TODO: one big project: connect all jmeter tools into one
    //TODO: test with RU
    //TODO: Math.Round errors,
    //TODO: change e.printStackTrace(); to printString(smth like that)
    //TODO: everything by acctions?
    //TODO: try bars once again
    //TODO: settings.ini
    //TODO: 46 46 46 46 <-- only last value is starting of trimm
    //TODO: prevent empty fields
    //TODO: test stop
    //TODO: disable fields when working
    //TODO: MANO jtl aggregated skaiciavimas OR OR OR make this project with png generation(maybe only for main comms?OMG!)
    //^^^^bl, gi jam reik JMETER, tai gal tada savo plugins versija isleist(ir toliau daryt kopinima plugins->JMeter\lib)?
    //TODO: in trimmed report number order is bad 8 9 10 1
    //TODO: big feature: print all multi reports on one xlsx file    
    //TODO: array of main comms!
    //TODO: && || instead of & | might cause additional lag

    public GenerateCsvReportsWorker(SingleFrameApplication app) {
        super(app);       
        initComponents();
        setLocaleLT(); // init default locale
        
        statusMessageLabel.setText("Welcome.");
//        URL url = ClassLoader.getSystemResource("iceteareplacer/resources/icon.png");
//        getFrame().setIconImage(java.awt.Toolkit.getDefaultToolkit().getImage(url));
        //x,y
        getFrame().setMinimumSize(new Dimension(475, 430));
//        getFrame().setMaximumSize(new Dimension(1410, 1280));
//        stopB.setVisible(false);

        genCsvB_single.setEnabled(false);
        stopB_single.setEnabled(false);
        genCsvB_multi.setEnabled(false);
        stopB_multi.setEnabled(false);
        genCsvB_trimmed.setEnabled(false);
        stopB_trimmed.setEnabled(false);
        
        File pluginsPathF = new File(jMeterPath+compilerPath);
        
         if (!pluginsPathF.exists()){
            System.out.println(newLine+quote+jMeterPath+compilerPath+quote+" Not found."+newLine+errLabelSpecJM+newLine+newLine);
            JOptionPane.showMessageDialog(null,errLabelSpecJM,messTitleLabel,JOptionPane.WARNING_MESSAGE);
            
            int rr = chooseJMeter.showOpenDialog(null);
            if(rr == JFileChooser.APPROVE_OPTION){
                setJMeterHome(chooseJMeter.getSelectedFile().toString());

                if (!pluginsPathF.exists()){
                    String appsJar = GenerateCsvReportsApp.class.getProtectionDomain().getCodeSource().getLocation().getPath();
                    System.err.println("Plugin was not found. Initiating install.");
                    File appsJarLoc = new File(appsJar);
                    
                    File JMeterPluginsCMD = new File(appsJarLoc.getParent()+File.separator+"lib"+File.separator+"JMeterPluginsCMD.jar");
                    File JMeterPlugins = new File(appsJarLoc.getParent()+File.separator+"lib"+File.separator+"JMeterPlugins.jar");

                    File cmdLoc = new File(jMeterPath+File.separator+"bin"+File.separator+"cmd");
                    File extLoc = new File(jMeterPath+File.separator+"lib"+File.separator+"ext");
                    
                    if (!cmdLoc.exists()) cmdLoc.mkdirs();
                    if (!extLoc.exists()) extLoc.mkdirs();

                    File JMeterPluginsCMD_DEST = new File(cmdLoc+File.separator+"JMeterPluginsCMD.jar");
                    File JMeterPlugins_DEST = new File(extLoc+File.separator+"JMeterPlugins.jar");
                    
                    System.out.println("Copying... "+quote+JMeterPluginsCMD+quote+" TO: "+quote+JMeterPluginsCMD_DEST+quote);
                    Utils.copyFileNIO(JMeterPluginsCMD, JMeterPluginsCMD_DEST);                     
                    System.out.println("Copying... "+quote+JMeterPlugins+quote+" TO: "+quote+JMeterPlugins_DEST+quote);
                    Utils.copyFileNIO(JMeterPlugins, JMeterPlugins_DEST);                
                    
                }
                
            }
            else if (rr == JFileChooser.CANCEL_OPTION) System.exit(0);
            else
                JOptionPane.showMessageDialog(null,errLabelSpecJM,messTitleLabel,JOptionPane.WARNING_MESSAGE);
        }
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        mainPanel = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanelSingle = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        resultF_single = new javax.swing.JTextField();
        inputF_single = new javax.swing.JTextField();
        buttonsPane_single = new javax.swing.JPanel();
        stopB_single = new javax.swing.JButton();
        genCsvB_single = new javax.swing.JButton();
        browseB_single = new javax.swing.JButton();
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
        jPanelTrimmed = new javax.swing.JPanel();
        buttonsPane_trimmed = new javax.swing.JPanel();
        stopB_trimmed = new javax.swing.JButton();
        genCsvB_trimmed = new javax.swing.JButton();
        browseB_trimmed = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        resultF_trimmed = new javax.swing.JTextField();
        inputF_trimmed = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        timelineF = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        timelineStartF = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        timelineEndF = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        trimmedJTLF = new javax.swing.JTextField();
        jPanelOptions = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        colsList = new javax.swing.JList();
        jPanel3 = new javax.swing.JPanel();
        localeCmb = new javax.swing.JComboBox();
        jPanel5 = new javax.swing.JPanel();
        mainCommOnlyC = new javax.swing.JCheckBox();
        statusPanel = new javax.swing.JPanel();
        javax.swing.JSeparator statusPanelSeparator = new javax.swing.JSeparator();
        statusMessageLabel = new javax.swing.JLabel();
        chooseJTL_single = new javax.swing.JFileChooser();
        chooseJMeter = new javax.swing.JFileChooser();
        chooseJTL_multi = new javax.swing.JFileChooser();
        chooseSave_multi = new javax.swing.JFileChooser();
        chooseJTL_trimmed = new javax.swing.JFileChooser();

        mainPanel.setFont(mainPanel.getFont());
        mainPanel.setName("mainPanel"); // NOI18N
        mainPanel.setLayout(new java.awt.GridBagLayout());

        jTabbedPane1.setName("jTabbedPane1"); // NOI18N

        jPanelSingle.setName("jPanelSingle"); // NOI18N
        jPanelSingle.setLayout(new java.awt.GridBagLayout());

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(generateCsvReportsP.GenerateCsvReportsApp.class).getContext().getResourceMap(GenerateCsvReportsWorker.class);
        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        jPanelSingle.add(jLabel1, gridBagConstraints);

        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        jPanelSingle.add(jLabel2, gridBagConstraints);

        resultF_single.setColumns(20);
        resultF_single.setEditable(false);
        resultF_single.setText(specifyTargetFile);
        resultF_single.setName("resultF_single"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 10);
        jPanelSingle.add(resultF_single, gridBagConstraints);

        inputF_single.setColumns(20);
        inputF_single.setEditable(false);
        inputF_single.setText(specifyTargetFile);
        inputF_single.setName("inputF_single"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 10);
        jPanelSingle.add(inputF_single, gridBagConstraints);

        buttonsPane_single.setName("buttonsPane_single"); // NOI18N
        buttonsPane_single.setLayout(new java.awt.GridBagLayout());

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(generateCsvReportsP.GenerateCsvReportsApp.class).getContext().getActionMap(GenerateCsvReportsWorker.class, this);
        stopB_single.setAction(actionMap.get("Stop_singleAction")); // NOI18N
        stopB_single.setText(resourceMap.getString("stopB_single.text")); // NOI18N
        stopB_single.setName("stopB_single"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 0);
        buttonsPane_single.add(stopB_single, gridBagConstraints);

        genCsvB_single.setAction(actionMap.get("Generate_singleAction")); // NOI18N
        genCsvB_single.setText(resourceMap.getString("genCsvB_single.text")); // NOI18N
        genCsvB_single.setName("genCsvB_single"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 5);
        buttonsPane_single.add(genCsvB_single, gridBagConstraints);

        browseB_single.setAction(actionMap.get("Browse_singleAction")); // NOI18N
        browseB_single.setText(resourceMap.getString("browseB_single.text")); // NOI18N
        browseB_single.setName("browseB_single"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        buttonsPane_single.add(browseB_single, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 0);
        jPanelSingle.add(buttonsPane_single, gridBagConstraints);

        jTabbedPane1.addTab(resourceMap.getString("jPanelSingle.TabConstraints.tabTitle"), jPanelSingle); // NOI18N

        jPanelMulti.setName("jPanelMulti"); // NOI18N
        jPanelMulti.setLayout(new java.awt.GridBagLayout());

        buttonsPane_multi.setName("buttonsPane_multi"); // NOI18N
        buttonsPane_multi.setLayout(new java.awt.GridBagLayout());

        stopB_multi.setAction(actionMap.get("Stop_multiAction")); // NOI18N
        stopB_multi.setText(resourceMap.getString("stopB_multi.text")); // NOI18N
        stopB_multi.setName("stopB_multi"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 0);
        buttonsPane_multi.add(stopB_multi, gridBagConstraints);

        saveResB_multi.setAction(actionMap.get("SaveRes_multiAction")); // NOI18N
        saveResB_multi.setText(resourceMap.getString("saveResB_multi.text")); // NOI18N
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
        browseB_multi.setText(resourceMap.getString("browseB_multi.text")); // NOI18N
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

        jLabel3.setText(resourceMap.getString("jLabel3.text")); // NOI18N
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
        resultF_multi.setText(specifyTargetFld);
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
        inputF_multi.setText(specifyTargetFld);
        inputF_multi.setName("inputF_multi"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 10);
        jPanelMulti.add(inputF_multi, gridBagConstraints);

        jTabbedPane1.addTab(resourceMap.getString("jPanelMulti.TabConstraints.tabTitle"), jPanelMulti); // NOI18N

        jPanelTrimmed.setName("jPanelTrimmed"); // NOI18N
        jPanelTrimmed.setLayout(new java.awt.GridBagLayout());

        buttonsPane_trimmed.setName("buttonsPane_trimmed"); // NOI18N
        buttonsPane_trimmed.setLayout(new java.awt.GridBagLayout());

        stopB_trimmed.setAction(actionMap.get("Stop_trimmedAction")); // NOI18N
        stopB_trimmed.setText(resourceMap.getString("stopB_trimmed.text")); // NOI18N
        stopB_trimmed.setName("stopB_trimmed"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 0);
        buttonsPane_trimmed.add(stopB_trimmed, gridBagConstraints);

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
        browseB_trimmed.setText(resourceMap.getString("browseB_trimmed.text")); // NOI18N
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
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 0);
        jPanelTrimmed.add(buttonsPane_trimmed, gridBagConstraints);

        jLabel5.setText(resourceMap.getString("jLabel5.text")); // NOI18N
        jLabel5.setName("jLabel5"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        jPanelTrimmed.add(jLabel5, gridBagConstraints);

        jLabel6.setText(resourceMap.getString("jLabel6.text")); // NOI18N
        jLabel6.setName("jLabel6"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        jPanelTrimmed.add(jLabel6, gridBagConstraints);

        resultF_trimmed.setColumns(20);
        resultF_trimmed.setEditable(false);
        resultF_trimmed.setText(specifyTargetFile);
        resultF_trimmed.setName("resultF_trimmed"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 10);
        jPanelTrimmed.add(resultF_trimmed, gridBagConstraints);

        inputF_trimmed.setColumns(20);
        inputF_trimmed.setEditable(false);
        inputF_trimmed.setText(specifyTargetFile);
        inputF_trimmed.setName("inputF_trimmed"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 10);
        jPanelTrimmed.add(inputF_trimmed, gridBagConstraints);

        jLabel7.setText(resourceMap.getString("jLabel7.text")); // NOI18N
        jLabel7.setName("jLabel7"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        jPanelTrimmed.add(jLabel7, gridBagConstraints);

        timelineF.setColumns(3);
        timelineF.setEditable(false);
        timelineF.setText(specifyTargetFile);
        timelineF.setEnabled(false);
        timelineF.setName("timelineF"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 10);
        jPanelTrimmed.add(timelineF, gridBagConstraints);

        jLabel8.setText(resourceMap.getString("jLabel8.text")); // NOI18N
        jLabel8.setName("jLabel8"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        jPanelTrimmed.add(jLabel8, gridBagConstraints);

        timelineStartF.setColumns(3);
        timelineStartF.setText(specifyTargetFile);
        timelineStartF.setEnabled(false);
        timelineStartF.setName("timelineStartF"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 10);
        jPanelTrimmed.add(timelineStartF, gridBagConstraints);

        jLabel9.setText(resourceMap.getString("jLabel9.text")); // NOI18N
        jLabel9.setName("jLabel9"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        jPanelTrimmed.add(jLabel9, gridBagConstraints);

        timelineEndF.setColumns(3);
        timelineEndF.setText(specifyTargetFile);
        timelineEndF.setEnabled(false);
        timelineEndF.setName("timelineEndF"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 10);
        jPanelTrimmed.add(timelineEndF, gridBagConstraints);

        jLabel10.setText(resourceMap.getString("jLabel10.text")); // NOI18N
        jLabel10.setName("jLabel10"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        jPanelTrimmed.add(jLabel10, gridBagConstraints);

        trimmedJTLF.setColumns(20);
        trimmedJTLF.setEditable(false);
        trimmedJTLF.setText(specifyTargetFile);
        trimmedJTLF.setName("trimmedJTLF"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 10);
        jPanelTrimmed.add(trimmedJTLF, gridBagConstraints);

        jTabbedPane1.addTab(resourceMap.getString("jPanelTrimmed.TabConstraints.tabTitle"), jPanelTrimmed); // NOI18N

        jPanelOptions.setName("jPanelOptions"); // NOI18N
        jPanelOptions.setLayout(new java.awt.GridBagLayout());

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, resourceMap.getString("jScrollPane1.border.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, resourceMap.getFont("jScrollPane1.border.titleFont"))); // NOI18N
        jScrollPane1.setName("jScrollPane1"); // NOI18N

        colsList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Command", "Samples", "Average", "Median", "90% line", "Minimum", "Maximum", "Errors%", "Throughput", "KB/sec" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        colsList.setName("colsList"); // NOI18N
        colsList.setSelectedIndices(filledArray10);
        colsList.setVisibleRowCount(10);
        jScrollPane1.setViewportView(colsList);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 10, 10);
        jPanelOptions.add(jScrollPane1, gridBagConstraints);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, resourceMap.getString("jPanel3.border.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, resourceMap.getFont("jPanel3.border.titleFont"))); // NOI18N
        jPanel3.setName("jPanel3"); // NOI18N
        jPanel3.setLayout(new java.awt.GridBagLayout());

        localeCmb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "lt-LT", "en-US" }));
        localeCmb.setName("localeCmb"); // NOI18N
        localeCmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                localeCmbActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 0, 15);
        jPanel3.add(localeCmb, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 10);
        jPanelOptions.add(jPanel3, gridBagConstraints);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, resourceMap.getString("jPanel5.border.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, resourceMap.getFont("jPanel5.border.titleFont"))); // NOI18N
        jPanel5.setName("jPanel5"); // NOI18N
        jPanel5.setLayout(new java.awt.GridBagLayout());

        mainCommOnlyC.setSelected(true);
        mainCommOnlyC.setText(resourceMap.getString("mainCommOnlyC.text")); // NOI18N
        mainCommOnlyC.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        mainCommOnlyC.setName("mainCommOnlyC"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 0, 15);
        jPanel5.add(mainCommOnlyC, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 5, 10);
        jPanelOptions.add(jPanel5, gridBagConstraints);

        jTabbedPane1.addTab(resourceMap.getString("jPanelOptions.TabConstraints.tabTitle"), jPanelOptions); // NOI18N

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
            .addComponent(statusPanelSeparator, javax.swing.GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(statusMessageLabel)
                .addContainerGap(644, Short.MAX_VALUE))
        );
        statusPanelLayout.setVerticalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addComponent(statusPanelSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(statusMessageLabel)
                .addGap(3, 3, 3))
        );

        chooseJTL_single.setCurrentDirectory(new java.io.File("C:\\results"));
        chooseJTL_single.setDialogTitle(resourceMap.getString("chooseJTL_single.dialogTitle")); // NOI18N
        FileFilter filter = new FileNameExtensionFilter("jtl", "JTL");
        chooseJTL_single.setFileFilter(filter);
        chooseJTL_single.setName("chooseJTL_single"); // NOI18N

        chooseJMeter.setApproveButtonText(resourceMap.getString("chooseJMeter.approveButtonText")); // NOI18N
        chooseJMeter.setCurrentDirectory(new java.io.File("C:\\"));
            chooseJMeter.setDialogTitle(resourceMap.getString("chooseJMeter.dialogTitle")); // NOI18N
            chooseJMeter.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);
            chooseJMeter.setName("chooseJMeter"); // NOI18N

            chooseJTL_multi.setCurrentDirectory(new java.io.File("C:\\results"));
            chooseJTL_multi.setDialogTitle(resourceMap.getString("chooseJTL_multi.dialogTitle")); // NOI18N
            chooseJTL_multi.setFileFilter(filter);
            chooseJTL_multi.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);
            chooseJTL_multi.setName("chooseJTL_multi"); // NOI18N

            chooseSave_multi.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);
            chooseSave_multi.setName("chooseSave_multi"); // NOI18N

            chooseJTL_trimmed.setCurrentDirectory(new java.io.File("C:\\results"));
            chooseJTL_trimmed.setDialogTitle(resourceMap.getString("chooseJTL_trimmed.dialogTitle")); // NOI18N
            chooseJTL_trimmed.setFileFilter(filter);
            chooseJTL_trimmed.setName("chooseJTL_trimmed"); // NOI18N

            setComponent(mainPanel);
            setStatusBar(statusPanel);
        }// </editor-fold>//GEN-END:initComponents

    private void localeCmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_localeCmbActionPerformed
        if(localeCmb.getSelectedIndex()==0)
            setLocaleLT();

        if(localeCmb.getSelectedIndex()==1)
            setLocaleEN();
    }//GEN-LAST:event_localeCmbActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton browseB_multi;
    private javax.swing.JButton browseB_single;
    private javax.swing.JButton browseB_trimmed;
    private javax.swing.JPanel buttonsPane_multi;
    private javax.swing.JPanel buttonsPane_single;
    private javax.swing.JPanel buttonsPane_trimmed;
    private javax.swing.JFileChooser chooseJMeter;
    private javax.swing.JFileChooser chooseJTL_multi;
    private javax.swing.JFileChooser chooseJTL_single;
    private javax.swing.JFileChooser chooseJTL_trimmed;
    private javax.swing.JFileChooser chooseSave_multi;
    private static javax.swing.JList colsList;
    private javax.swing.JButton genCsvB_multi;
    private javax.swing.JButton genCsvB_single;
    private javax.swing.JButton genCsvB_trimmed;
    private javax.swing.JTextField inputF_multi;
    private javax.swing.JTextField inputF_single;
    private javax.swing.JTextField inputF_trimmed;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanelMulti;
    private javax.swing.JPanel jPanelOptions;
    private javax.swing.JPanel jPanelSingle;
    private javax.swing.JPanel jPanelTrimmed;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JComboBox localeCmb;
    private static javax.swing.JCheckBox mainCommOnlyC;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTextField resultF_multi;
    private javax.swing.JTextField resultF_single;
    private javax.swing.JTextField resultF_trimmed;
    private javax.swing.JButton saveResB_multi;
    private static javax.swing.JLabel statusMessageLabel;
    private javax.swing.JPanel statusPanel;
    private javax.swing.JButton stopB_multi;
    private javax.swing.JButton stopB_single;
    private javax.swing.JButton stopB_trimmed;
    private javax.swing.JTextField timelineEndF;
    private javax.swing.JTextField timelineF;
    private javax.swing.JTextField timelineStartF;
    private javax.swing.JTextField trimmedJTLF;
    // End of variables declaration//GEN-END:variables
    public static String newLine = System.getProperty("line.separator"); 
    public String errLabelTargetFolder = "Please choose a directory.";
    private final String specifyTargetFile = "Please select a file first...";
    private final String specifyTargetFld = "Please select a Folder first...";
    public String messTitleLabel = "Message";
    public String errLabelSpecJM = "Please specify JMeter directory.";
  
    private static boolean doCont = true;    
   
    private static File inputJTL_single;    
    private static File resultCSV_single;    
    private static File inputJTL_multi;
    private static File resultCSV_multi;
    private static File resultSavingFolder_multi;
    private static boolean savResUsed_multi = false;     
    private static File inputJTL_trimmed;
    private static File trimmedJTL;
    private static File resultCSV_trimmed;
    private static int firstValLine;
    private static int lastValLine;
    private static ArrayList<Integer> aListLines = new ArrayList<Integer>();
    private static final String HeadLine1 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
    private static final String HeadLine2 = "<testResults version=\"1.2\">";
    private static final String FooterLine = "</testResults>";
    
    public static List<String> extensionsToIgnore;
    public static List<String> extensionsToSearchFor;
    private static ArrayList<File> aListOfJTLFiles = new ArrayList<File>();
    private static int[] filledArray10 = {0,1,2,4,5,6,7};
    
    private static String jMeterPath = "C:\\jakarta-jmeter-2.4";
    private static String compilerPath = "\\bin\\cmd\\JMeterPluginsCMD.jar";
    private static final String attachString = "_REPORT";
    private static final String attachString2 = "_SUMMARIZED"; //TODO: listener for checkboxes and changing of resultField_ ?~~
    private static final String attachStringTrimmed = "TRIMMED_"; //TODO: print used timeline(or in csv?)
    private static final String attachStringError = "ERRORS_";
    private static boolean containsErrors = false;
    private static final String quote = "\"";
    private static final String TStart = "\" ts=\"";
    private static boolean LOCALE_LT;
    private static boolean LOCALE_EN;    
    public static final String comma = ",";
    public static final String semicolon = ";";
    public static final String dot = ".";
    public static String sepTO;
    public static String percTO;

   public static void jtlToCsv(String inputJTL, String resultCSV){      
                      
       try {
           
           Runtime rt = Runtime.getRuntime();
           String cmd ="cmd /c java -jar "+jMeterPath+compilerPath+" --generate-csv "+quote+resultCSV+quote+" --plugin-type AggregateReport --input-jtl "+quote+inputJTL+quote;
//           System.out.println(cmd);         
           Process pr = rt.exec(cmd);
           pr.waitFor(); //TODO: doCont
//           
//           BufferedReader input = new BufferedReader(new InputStreamReader(pr.getInputStream()));
//           String line=null;
//
//           while((line=input.readLine()) != null) {
//                System.out.println(line);
//           }
//
//           int exitVal = pr.waitFor();
//
//           System.out.println("Exited with error code "+exitVal);
           System.out.println("Conversion done.");

      } catch(Exception e) {
           System.err.println("Compatible only with Windows.");   
           System.err.println(e.toString());
//           e.printStackTrace();
           }
    
        }
   
   public static void adjustCsv(File csvFile, File csvFileCorr){
       try{
           
           Utils.deleteFile(csvFileCorr);
           BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(csvFileCorr,true),"UTF8"));           
           BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(csvFile),"UTF8"));
           String line;
           int lineCount=0;          
           
          String firstLineTo = "Command"+sepTO+"Samples"+sepTO+"Average"+sepTO+"Median"+sepTO+"90% line"+sepTO+"Minimum"+sepTO+"Maximum"+sepTO+"Errors%"+sepTO+"Throughput"+sepTO+"KB/sec";
           //TODO: append first line here
          while (( line = bf.readLine()) != null && doCont){
              
               lineCount++;               
               if (LOCALE_LT) line = line.replaceAll(comma, semicolon);              
               
               if (mainCommOnlyC.isSelected()){
                   
                   if(lineCount==1){
                       line = splitLineByCol(firstLineTo, true);
                       bw.append(line+newLine);
                   }
                   
                   if (
                           line.substring(1,2).matches(" ")
//                           ||line.substring(0,5).matches("TOTAL")
//                           ||line.contains("Pacing")
                           ||line.substring(2,3).matches("-")
                           ||line.substring(2,3).matches(" ")
//                           ||line.substring(0,7).matches("Timeout")
                           ||line.contains("ViewFirstPage")
//                           ||line.substring(0,6).matches("Wakeup")
                           ||line.substring(0,8).matches("WaitTime")
//                           ||line.substring(0,5).matches("Dummy")
                           ){
                       //TODO: fill with other, maybe scan JTL's first to catch HAHAOHWOW
                        line = splitLineByCol(line, false);
                        bw.append(line+newLine);
                   }
                   
               }
               else{
                   
                   if(lineCount==1){
                       line = splitLineByCol(firstLineTo, true);
                       bw.append(line+newLine);
                   }
                   else{
                       line = splitLineByCol(line, false);
                       bw.append(line+newLine);
                       
                   }
               }                 
           }
           bw.close();
           bf.close();
           //delete old, rename new one
           Utils.deleteFile(csvFile);
           
           if (containsErrors){
               
              csvFile = new File(csvFile.getParentFile().toString()+File.separator+attachStringError+csvFile.getName()); //reuse, atatch Error 
              Utils.renameFile(csvFileCorr,csvFile);
              containsErrors = false;
           }
           else{
              Utils.renameFile(csvFileCorr,csvFile); 
           }
           
           
           System.out.println("Adjustion done.");
           
       }
       catch(Exception e){
         e.printStackTrace();  
       }
   }
   
   public static void processF(File aFile) {

        if (doCont){ //Listen for "Stop"

        if(extensionsToIgnore==null)
                extensionsToIgnore = new ArrayList<String>();
        if(extensionsToSearchFor==null)
                extensionsToSearchFor = new ArrayList<String>();

        if (aFile.isFile() && aFile.getName()!=null && !aFile.toString().contains("~$")) {
                String extension = aFile.getName().substring(aFile.getName().lastIndexOf(".")+1, aFile.getName().length());

            if(extensionsToSearchFor.size()>0) {//if ext list is empty, then search for all
                    if(!extensionsToIgnore.contains(extension) && extensionsToSearchFor.contains(extension)){
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

   public static void setExtensionsToIgnore(String ext) {
            if(extensionsToIgnore==null)
                    extensionsToIgnore = new ArrayList<String>();

            extensionsToIgnore.add(ext);
    }

   public static void setExtensionsToSearchFor(String ext) {
            if(extensionsToSearchFor==null)
                    extensionsToSearchFor = new ArrayList<String>();

            extensionsToSearchFor.add(ext);
    }
   
   public static String splitLineByCol(String line, Boolean firstLine){
       String[] splitArray = new String[9];
       splitArray = line.split(sepTO);       
       line = "";       
       
       if(!firstLine){
//           System.out.println("Before multiply:"+splitArray[7]);
           splitArray[7] = multiplyString(splitArray[7]);
//           System.out.println("After multiply:"+splitArray[7]);
//           splitArray[7] = roundString(splitArray[7]); //TODO: two numbers after comma
           if (!splitArray[7].substring(0, 3).matches("0.0") ){
               containsErrors = true;
           }
           if (LOCALE_LT) splitArray[7] = splitArray[7].replace(".",comma); // LT
       }

       for(int ite=0;ite<10;ite++){
           if (colsList.isSelectedIndex(ite)) line+=splitArray[ite]+sepTO;
       }

       return line;
       
   }
   
   public static void setJMeterHome(String path){       
       String propPath = path + File.separator+ "bin" + File.separator+ "jmeter.properties";
       File propF = new File(propPath);
       if (propF.exists()){
           jMeterPath = path;
           System.out.println("JMeter directory set to: "+jMeterPath);
       }
       else{
           String messThis = "This is not JMeter path. Please select \"jakarta-jmeter-2.4\" folder. Exiting...";
           System.out.println(messThis);
           JOptionPane.showMessageDialog(null,messThis,"WARNING",JOptionPane.WARNING_MESSAGE);
           System.exit(0);
       }
   }
   
   private static void setLocaleLT(){
       System.out.println("LOCALE has been set to lt-LT");
       sepTO = semicolon;
       percTO = comma;
       LOCALE_LT = true;
       LOCALE_EN = false;
              
   }
   
   private static void setLocaleEN(){
       System.out.println("LOCALE has been set to en-US");
       sepTO = comma;
       percTO = dot;
       LOCALE_LT = false;
       LOCALE_EN = true;
       
   }
   
   private static String roundString(String value){
       
       DecimalFormat twoDForm = new DecimalFormat("#.##");                   
       return String.valueOf(Double.valueOf(twoDForm.format(Double.parseDouble(value))));
   }
   
   private static String multiplyString(String value){
       value = String.valueOf(Double.valueOf(value)*100);
       return value;
   }
   
   public static int getTimeline(File inputJTL){
       
       try{
           BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(inputJTL),"UTF8")); //TODO: simplify reader for better perf?
           String line;
           int iStartT;
           int iEndT;
           String currT;
           long currT_Long;
           int currT_mins = 0;
           int cntInner = 0;
           long firstVal = 0;
           
           while((line = bf.readLine()) !=null){

               if(line.startsWith("<sample") || line.startsWith("<httpSample")){ //TODO: maybe shorten?
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
           erp.printStackTrace();
           return 0;
       }       
   }
   
   public static void getSELinesNo(File inputJTL, int globStart, int globEnd){ // AKA get dates for StartEnd

       try{
           BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(inputJTL),"UTF8")); //TODO: simplify reader for better perf?
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

               if(line.startsWith("<sample") || line.startsWith("<httpSample")){ //TODO: maybe shorten?
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
           erp.printStackTrace();
       }       
   }

 public static void formTrimmedJTL(File inputJTL, File resultJTL, int firstValLine, int lastValLine){

       try{
           BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(inputJTL),"UTF8"));
           BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(resultJTL,false),"UTF8")); 
           String line;
           int cnt=0;
           bw.append(HeadLine1+newLine+HeadLine2+newLine); //TODO: if from start?
           while((line = bf.readLine()) !=null){
               cnt++;
               if(cnt>=firstValLine && cnt <= lastValLine){
                   bw.append(line+newLine);
               }               
           }
           bw.append(FooterLine+newLine);//TODO: if to END?
           bf.close();
           bw.close();
          
       }
       catch(Exception erp){
//           erp.printStackTrace();
       }       
   } 
////////////////////////////////////////////////////////////////////////////////////////////////////////
    //SiNGlE
    @Action
//    @Action(block = Task.BlockingScope.ACTION)
    public Task Generate_singleAction() {
        return new Generate_singleActionTask(getApplication());
    }
    private class Generate_singleActionTask extends org.jdesktop.application.Task<Object, Void> {
        Generate_singleActionTask(org.jdesktop.application.Application app) {
            super(app);
            statusMessageLabel.setText("");      
            System.err.println("Executing single report mode.");
            browseB_single.setEnabled(false);
            genCsvB_single.setEnabled(false);
            stopB_single.setEnabled(true);
            statusMessageLabel.setText("Calculating...");
        }
        @Override protected Object doInBackground() {
            statusMessageLabel.setText("Working with: "+inputJTL_single);  
            Utils.deleteFile(resultCSV_single);
            jtlToCsv(inputJTL_single.toString(),resultCSV_single.toString());
            adjustCsv(resultCSV_single, new File(resultCSV_single+"2"));
            System.out.println("DONE");
            return null;  // return your result
        }
        @Override protected void cancelled() {                      
            doCont = false;
            System.err.println("ABORTED");
        }
        @Override protected void succeeded(Object result) {
//            super.succeeded(result);
            if (!doCont) statusMessageLabel.setText("Aborted by user.");
            if (doCont)  statusMessageLabel.setText("Done.");

                browseB_single.setEnabled(true);
                genCsvB_single.setEnabled(true);
                stopB_single.setEnabled(false);
                doCont = true;
        }
    }

    @Action
    public void Stop_singleAction() {
        Generate_singleAction().cancel(true);
    }

    @Action
    public void Browse_singleAction() {
        int rr = chooseJTL_single.showOpenDialog(null); //TODO: filter for jtl
        if(rr == JFileChooser.APPROVE_OPTION){
            inputJTL_single = chooseJTL_single.getSelectedFile();                       
            String fileNameEx = inputJTL_single.getName();
            fileNameEx = fileNameEx.substring(0, fileNameEx.length()-4);
            String filePathEx = inputJTL_single.getParentFile().toString();
            if (mainCommOnlyC.isSelected())
                resultCSV_single = new File(filePathEx+File.separator+fileNameEx+attachString+attachString2+".csv");            
            else
                resultCSV_single = new File(filePathEx+File.separator+fileNameEx+attachString+".csv");
            
            inputF_single.setText(inputJTL_single.toString()); 
            resultF_single.setText(resultCSV_single.toString());
            genCsvB_single.setEnabled(true);
        }
        else if (rr == JFileChooser.CANCEL_OPTION);
        else
            JOptionPane.showMessageDialog(null,errLabelTargetFolder,messTitleLabel,JOptionPane.WARNING_MESSAGE);
    }
    
    //MuLTI
    @Action
    public Task Generate_multiAction() {
        return new Generate_multiActionTask(getApplication());
    }
    private class Generate_multiActionTask extends org.jdesktop.application.Task<Object, Void> {
        Generate_multiActionTask(org.jdesktop.application.Application app) {
            super(app);
            System.err.println("Executing multiple reports mode.");
            setExtensionsToSearchFor("jtl");
            setExtensionsToSearchFor("JTL");
            browseB_multi.setEnabled(false);
            genCsvB_multi.setEnabled(false);
            saveResB_multi.setEnabled(false);
            stopB_multi.setEnabled(true);
            statusMessageLabel.setText("Calculating[M]..."); 
        }
        @Override protected Object doInBackground() {
            
            processF(inputJTL_multi); //FILL aListOfJTLFiles
            
            for (int bl=0;bl<aListOfJTLFiles.size()&&doCont;bl++){ 

                inputJTL_multi = aListOfJTLFiles.get(bl);
                statusMessageLabel.setText("Working with: "+aListOfJTLFiles.get(bl).toString());
                String fileNameEx = inputJTL_multi.getName();
                fileNameEx = fileNameEx.substring(0, fileNameEx.length()-4);
                String filePathEx;
                if (savResUsed_multi)
                    filePathEx = resultSavingFolder_multi.toString();
                else
                    filePathEx = inputJTL_multi.getParentFile().toString();
                
                if (mainCommOnlyC.isSelected())
                    resultCSV_multi = new File(filePathEx+File.separator+fileNameEx+attachString+attachString2+".csv");                
                else
                    resultCSV_multi = new File(filePathEx+File.separator+fileNameEx+attachString+".csv");
                
                Utils.deleteFile(resultCSV_multi);
                jtlToCsv(inputJTL_multi.toString(),resultCSV_multi.toString());
                adjustCsv(resultCSV_multi, new File(resultCSV_multi+"2"));
            }


            System.out.println("DONE.");
            return null;  // return your result
        }
        @Override protected void cancelled() {                      
            doCont = false;
            System.err.println("ABORTED");
        }
        @Override protected void succeeded(Object result) {
            if (!doCont) statusMessageLabel.setText("Aborted by user.");
            if (doCont)  statusMessageLabel.setText("Done Multiple files.");

                browseB_multi.setEnabled(true);
                genCsvB_multi.setEnabled(true);
                saveResB_multi.setEnabled(true);
                stopB_multi.setEnabled(false);
                aListOfJTLFiles.clear();
                doCont = true;
        }
    }

    @Action
    public void Stop_multiAction() {
        Generate_multiAction().cancel(true);
    }

    @Action
    public void Browse_multiAction() {
        int rr = chooseJTL_multi.showOpenDialog(null);
        if(rr == JFileChooser.APPROVE_OPTION){
            inputJTL_multi = chooseJTL_multi.getSelectedFile();
            
            inputF_multi.setText(inputJTL_multi.toString());
            if (savResUsed_multi)
                resultF_multi.setText(resultSavingFolder_multi.toString());
            else
                resultF_multi.setText(inputJTL_multi.toString());     //TODO: children folders?~~                   
            genCsvB_multi.setEnabled(true);
        }
        else if (rr == JFileChooser.CANCEL_OPTION);
        else
            JOptionPane.showMessageDialog(null,errLabelTargetFolder,messTitleLabel,JOptionPane.WARNING_MESSAGE);
    }

    @Action
    public void SaveRes_multiAction() {
        chooseSave_multi.setCurrentDirectory(chooseJTL_multi.getCurrentDirectory());
        int tt = chooseSave_multi.showSaveDialog(null);
        if(tt == JFileChooser.APPROVE_OPTION){
            resultSavingFolder_multi = chooseSave_multi.getSelectedFile();
            resultF_multi.setText(resultSavingFolder_multi.toString()); 
            savResUsed_multi = true;
        }
        else if (tt == JFileChooser.CANCEL_OPTION);
        else
            JOptionPane.showMessageDialog(null,errLabelTargetFolder,messTitleLabel,JOptionPane.WARNING_MESSAGE);
    }   
    
    //TRiMMED
    @Action 
    public Task Generate_trimmedAction() {
        return new Generate_trimmedActionTask(getApplication());
    }
    private class Generate_trimmedActionTask extends org.jdesktop.application.Task<Object, Void> {
        Generate_trimmedActionTask(org.jdesktop.application.Application app) {
            super(app);
            statusMessageLabel.setText("");      
            System.err.println("Executing trimmed report mode.");
            browseB_trimmed.setEnabled(false);
            genCsvB_trimmed.setEnabled(false);
            stopB_trimmed.setEnabled(true);
            statusMessageLabel.setText("Calculating...");
        }
        @Override protected Object doInBackground() {
            statusMessageLabel.setText("Working with: "+inputJTL_trimmed);  
            Utils.deleteFile(resultCSV_trimmed);
            Utils.deleteFile(trimmedJTL);

            getSELinesNo(inputJTL_trimmed,Integer.parseInt(timelineStartF.getText()),Integer.parseInt(timelineEndF.getText())); //TODO: fields for ints only
            formTrimmedJTL(inputJTL_trimmed, trimmedJTL, firstValLine, lastValLine);
            jtlToCsv(trimmedJTL.toString(),resultCSV_trimmed.toString());
            adjustCsv(resultCSV_trimmed, new File(resultCSV_trimmed+"2"));
            System.out.println("DONE");
            return null;  // return your result
        }
        @Override protected void cancelled() {                      
            doCont = false;
            System.err.println("ABORTED");
        }
        @Override protected void succeeded(Object result) {
//            super.succeeded(result);
            if (!doCont) statusMessageLabel.setText("Aborted by user.");
            if (doCont)  statusMessageLabel.setText("Done. Results file: "+resultCSV_trimmed);

                browseB_trimmed.setEnabled(true);
                genCsvB_trimmed.setEnabled(true);
                stopB_trimmed.setEnabled(false);
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
            
            if (mainCommOnlyC.isSelected())
                resultCSV_trimmed = new File(filePathEx+File.separator+attachStringTrimmed+fileNameWExt+attachString+attachString2+".csv");            
            else
                resultCSV_trimmed = new File(filePathEx+File.separator+attachStringTrimmed+fileNameWExt+attachString+".csv");
            
            trimmedJTLF.setText(trimmedJTL.toString());
            inputF_trimmed.setText(inputJTL_trimmed.toString()); 
            resultF_trimmed.setText(resultCSV_trimmed.toString());
            timelineF.setText(String.valueOf(getTimeline(inputJTL_trimmed)));
            genCsvB_trimmed.setEnabled(true);
            timelineStartF.setEnabled(true);
            timelineEndF.setEnabled(true);
            timelineF.setEnabled(true);
            timelineStartF.setText("");
            timelineEndF.setText("");
        }
        else if (rr == JFileChooser.CANCEL_OPTION);
        else
            JOptionPane.showMessageDialog(null,errLabelTargetFolder,messTitleLabel,JOptionPane.WARNING_MESSAGE);
    }

    @Action
    public void Stop_trimmedAction() {
        Generate_trimmedAction().cancel(true);
    }

    
}
