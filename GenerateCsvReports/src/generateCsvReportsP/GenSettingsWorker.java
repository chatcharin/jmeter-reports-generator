
package generateCsvReportsP;

import kg.apc.jmeter.PluginsCMDWorker;
import java.io.File;
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
    public static Boolean [] colsArray = new Boolean [8];

    public static void init_PNG(File in, File out){

        PluginsCMDWorker.setInputFile(in.toString());
        PluginsCMDWorker.setOutputPNGFile(out.toString());
        PluginsCMDWorker.doJob();
    }
    
    public static void init_CSV(File in, File out){
        
        PluginsCMDWorker.setInputFile(in.toString());
        PluginsCMDWorker.setOutputCSVFile(out.toString());
        PluginsCMDWorker.doJob();
    }
    public static Boolean checkForErrors(){
        if (org.apache.jmeter.save.CSVSaveService.CONTAINS_ERRORS) return true;
        else return false;
    }    
    public static void setMainComms(){
        PluginsCMDWorker.setMainCommsOnly(Boolean.TRUE);
    }
    public static void setAllComms(){
        PluginsCMDWorker.setMainCommsOnly(Boolean.FALSE);
    }
    public static void setStepsArray(){
        org.apache.jmeter.save.CSVSaveService.colsArr = colsArray;
    }
    public static void initJMeterProps(){
        PluginsCMDWorker.initializeProperties();
    }
    public static void setExportMode(int mode){
        if (mode == 1) PluginsCMDWorker.addExportMode(1);// PNG
        else PluginsCMDWorker.addExportMode(2);//CSV
    }
    public static void setPluginType(int type){
        if (type == 1) PluginsCMDWorker.setPluginType("ResponseTimesOverTime");
        else PluginsCMDWorker.setPluginType("AggregateReport");
    }
    public static void setCSVDelim(char delim){
        org.apache.jmeter.save.CSVSaveService.setDelim(delim);
    }
        
    //TODO: check if everything is set. Maybe in doJob()'s class?
}
