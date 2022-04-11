package org.eclipse.paho.client.mqttv3.persist;

import java.io.File;
import java.io.FileFilter;

public class PersistanceFileFilter
  implements FileFilter
{
  private final String fileExtension;
  
  public PersistanceFileFilter(String paramString)
  {
    this.fileExtension = paramString;
  }
  
  public boolean accept(File paramFile)
  {
    return paramFile.getName().endsWith(this.fileExtension);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\eclipse\paho\client\mqttv3\persist\PersistanceFileFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */