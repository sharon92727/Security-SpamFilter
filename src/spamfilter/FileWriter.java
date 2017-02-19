package spamfilter;


import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileWriter {
	  private String filename;
	  
	  public FileWriter(String name) {
	    filename = name;
	  }
	  
	  public void writeContent(String content) throws IOException {
	    
	    FileOutputStream fos = new FileOutputStream(filename);
	    FileChannel outfc = fos.getChannel();
	    
	    ByteBuffer bb = ByteBuffer.wrap(content.getBytes());
	  
	    outfc.write(bb);
	    outfc.close();
	  }	  
}


