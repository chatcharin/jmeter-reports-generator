package generateCsvReportsP;

import kg.apc.jmeter.PluginsCMDWorker;
/**
 *
 * @author Jovaras * 
//        pluginType = "ResponseTimesOverTime";
//        pluginType = "ResponseTimesDistribution";
//        pluginType = "ResponseCodesPerSecond";
//        pluginType = "ResponseTimesPercentiles";
//        pluginType = "ThroughputOverTime";
//        pluginType = "ThroughputVsThreads";
//        pluginType = "TimesVsThreads";
//        pluginType = "TransactionsPerSecond";
//        pluginType = "ThreadsStateOverTime";
//        pluginType = "BytesThroughputOverTime";
//        pluginType = "HitsPerSecond";
//        pluginType = "LatenciesOverTime";
 */
//OUTSIDE WORLD COMMUNICATOR
public class GenSettingsWorker {

    public static void init_PNG(String in, String out){
        PluginsCMDWorker.setInputFile(in);
        PluginsCMDWorker.setOutputPNGFile(out);
        PluginsCMDWorker.doJob();
    }
    
    public static void init_CSV(String in, String out){        
        PluginsCMDWorker.setInputFile(in);
        PluginsCMDWorker.setOutputCSVFile(out);
        PluginsCMDWorker.doJob();
    }
    public static Boolean checkForErrors(){
        if (org.apache.jmeter.save.CSVSaveService.CONTAINS_ERRORS) return true;
        else return false;
    }    
    public static void setShowMainStepsOnly(boolean chk){
        if (chk) PluginsCMDWorker.setMainCommsOnly(true);
        else PluginsCMDWorker.setMainCommsOnly(false);
    }
    public static void setColsArray(Boolean [] arr){
        org.apache.jmeter.save.CSVSaveService.colsArr = arr;
    }
    public static void initJMeterProps(){
        PluginsCMDWorker.initializeProperties();
    }
    public static void setExportMode(int mode){
        if (mode == 1) PluginsCMDWorker.setExportMode(1);// PNG
        else PluginsCMDWorker.setExportMode(2);//CSV
    }
    public static void setPluginType(int type){
        if (type == 1) PluginsCMDWorker.setPluginType("ResponseTimesOverTime");
        else PluginsCMDWorker.setPluginType("AggregateReport");
    }
    public static void setCSVDelim(char delim){
        org.apache.jmeter.save.CSVSaveService.setDelim(delim);
    }
    public static void setRealTime(boolean chk){
        if (chk) PluginsCMDWorker.setRealTime(true);
        else PluginsCMDWorker.setRealTime(false);
    }
    public static void setGraphSize(int x, int y){
        PluginsCMDWorker.setGraphWidth(x);
        PluginsCMDWorker.setGraphHeight(y);
    }
    public static void setLimitRows(boolean chk){
        if (chk) PluginsCMDWorker.setRowsLimit(200);
        else PluginsCMDWorker.setRowsLimit(0);
    }
    public static void setForceY(int val){
        PluginsCMDWorker.setForceY(val);
    }
}
