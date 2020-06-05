package week12.visitor;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Date;

public class FSDetails {
    public static String returnDetails(File file, boolean isFile){
        StringBuilder sb = new StringBuilder();
        

        if (isFile) {
            Date lastMod = new Date (file.lastModified());
            long length = file.length();
            sb.append(readableFileSize(length));
            sb.append(" ");
            sb.append(lastMod.toString());
        }else{
            sb.append("DIR");
        }
        return sb.toString();
    }
    
    public static String readableFileSize(long size) {
        //https://hungwei0331.pixnet.net/blog/post/355794924
        if(size <= 0) return "0";
        final String[] units = new String[] { "B", "kB", "MB", "GB", "TB" };
        int digitGroups = (int) (Math.log10(size)/Math.log10(1024));
        return new DecimalFormat("#,##0.#").format(size/Math.pow(1024, digitGroups)) + " " + units[digitGroups];
    }
}