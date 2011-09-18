package generateCsvReportsP;
import java.io.File;
import java.util.ArrayList; 
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.io.FileInputStream;
import java.io.FileOutputStream;
/**
 *
 * @author n.sutas
 */
public class Utils {
   public static void deleteFile(File file){
       
        if (file.exists()){
            while (file.exists()){
                file.delete();
//                System.out.println("Deleting file:"+file);
            }
        }
   }
   
   public static void renameFile(File fileFrom, File fileTo){
       
        if (fileFrom.exists()){
            while (fileFrom.exists()){
                fileFrom.renameTo(fileTo);
//                System.out.println("Renaming file...");

            }
        }
   }
   
   public static void printArrayList(ArrayList<String> anArrayList){
       System.err.println("Printing an ArrayList:");
       for (int bl=0;bl<anArrayList.size();bl++){           
           System.out.println(anArrayList.get(bl));        
       }
       
   }
   
   public static void copyFileNIO(File fileFrom, File fileTo){

        try {
            // Create channel on the source
            FileChannel srcChannel = new FileInputStream(fileFrom).getChannel();

            // Create channel on the destination
            FileChannel dstChannel = new FileOutputStream(fileTo).getChannel();

            // Copy file contents from source to destination
            dstChannel.transferFrom(srcChannel, 0, srcChannel.size());

            // Close the channels
            srcChannel.close();
            dstChannel.close();
        } catch (IOException e) {
        }
       
   }
   
}
