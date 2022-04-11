package org.eclipse.paho.client.mqttv3.persist;

import java.io.File;
import java.io.FilenameFilter;

public class PersistanceFileNameFilter
  implements FilenameFilter
{
  private final String fileExtension;
  
  public PersistanceFileNameFilter(String paramString)
  {
    this.fileExtension = paramString;
  }
  
  public boolean accept(File paramFile, String paramString)
  {
    return paramString.endsWith(this.fileExtension);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\eclipse\paho\client\mqttv3\persist\PersistanceFileNameFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */