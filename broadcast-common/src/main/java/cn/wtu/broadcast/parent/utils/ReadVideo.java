/*
package cn.wtu.broadcast.parent.utils;
import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.MultimediaInfo;
import java.io.File;

public class ReadVideo {
	
	public static long readVideo(File file)
	{
        long ls = 0;
	    Encoder encoder = new Encoder();
	    try {
	        MultimediaInfo m = encoder.getInfo(file);
	        ls = m.getDuration()/1000;
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
		return ls;
	}
}
*/
