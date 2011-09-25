
package generateCsvReportsP;

import kg.apc.jmeter.PluginsCMDWorker;
import java.io.File;
import java.util.Locale;
import java.util.ArrayList;

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
public class GenSettingsWorker {
    public static char CSV_DELIM = ';';   
//    public static ArrayList<Boolean> colsArr = new ArrayList<Boolean>();
    public static void init_PNG(File in, File out){

        PluginsCMDWorker.addExportMode(1); //PNG
        PluginsCMDWorker.setInputFile(in.toString());
        PluginsCMDWorker.setOutputPNGFile(out.toString());
        PluginsCMDWorker.setPluginType("ResponseTimesOverTime");
        PluginsCMDWorker.initializeProperties();
        PluginsCMDWorker.doJob();
    }
    
    public static void init_CSV(File in, File out){
        
        PluginsCMDWorker.addExportMode(2); //CSV
        PluginsCMDWorker.setInputFile(in.toString());
        PluginsCMDWorker.setOutputCSVFile(out.toString());
        PluginsCMDWorker.setPluginType("AggregateReport");
        PluginsCMDWorker.initializeProperties();
//        org.apache.jmeter.save.CSVSaveService.colsArr = colsArr;
        org.apache.jmeter.save.CSVSaveService.setDelim(CSV_DELIM);
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
        
    //TODO: check if everything is set. Maybe in doJob()'s class?
}
