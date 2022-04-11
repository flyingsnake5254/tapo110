package org.apache.commons.io.filefilter;

import java.io.File;
import java.io.Serializable;

public class FileFileFilter
  extends a
  implements Serializable
{
  public static final b FILE = new FileFileFilter();
  private static final long serialVersionUID = 5345244090827540862L;
  
  public boolean accept(File paramFile)
  {
    return paramFile.isFile();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\apache\commons\io\filefilter\FileFileFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */