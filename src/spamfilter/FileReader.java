package spamfilter;

import java.nio.*;
import java.io.*;
import java.nio.channels.*;

public class FileReader
{
  private String filename;
  private String content;
  
  public FileReader(String name) throws IOException {
    filename = name;
    readContent();
  }
  
  public void readContent() throws IOException {
    
    FileInputStream fis = new FileInputStream(filename);
    FileChannel fc = fis.getChannel();

    ByteBuffer bb = ByteBuffer.allocate((int)fc.size());
    fc.read(bb);
    fc.close();
    content = new String(bb.array());
  }
  
  public String getContent() {
    return content;
  }
}




