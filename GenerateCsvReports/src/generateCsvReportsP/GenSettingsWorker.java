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
    
    PluginsCMDWorker worker = new PluginsCMDWorker();
    
    public void init_PNG(String in, String out){
        worker.setInputFile(in);
        worker.setOutputPNGFile(out);
        worker.doJob();
    }
    
    public void init_CSV(String in, String out){        
        worker.setInputFile(in);
        worker.setOutputCSVFile(out);
        worker.doJob();
    }
    public Boolean checkForErrors(){
        if (org.apache.jmeter.save.CSVSaveService.CONTAINS_ERRORS) return true;
        else return false;
    }    
    public void setShowMainStepsOnly(boolean chk){
        kg.apc.jmeter.graphs.GraphPanel.MAIN_COMMS_ONLY = chk;
        org.apache.jmeter.save.CSVSaveService.MAIN_COMMS_ONLY = chk; 
    }
    public void setColsArray(Boolean [] arr){
        org.apache.jmeter.save.CSVSaveService.colsArr = arr;
    }
    public void initJMeterProps(){
//        worker.initializeProperties();
    }
    public void setExportMode(int mode){
        if (mode == 1) worker.setExportMode(1);// PNG
        else worker.setExportMode(2);//CSV
    }
    public void setPluginType(int type){
        if (type == 1) worker.setPluginType("ResponseTimesOverTime");
        else worker.setPluginType("AggregateReport");
    }
    public void setCSVDelim(char delim){
        org.apache.jmeter.save.CSVSaveService.setDelim(delim);
    }
    public void setRealTime(boolean chk){
        if (chk) worker.setRelativeTimes(0);
        else worker.setRelativeTimes(1);
    }
    public void setGraphSize(int x, int y){
        worker.setGraphWidth(x);
        worker.setGraphHeight(y);
    }
    public void setLimitRows(boolean chk){
        if (chk) worker.setRowsLimit(200);
        else worker.setRowsLimit(0);
    }
    public void setForceY(int val){
        worker.setForceY(val);
    }
}
