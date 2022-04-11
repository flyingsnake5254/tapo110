package org.apache.commons.io.filefilter;

import java.io.File;
import java.io.Serializable;

public class TrueFileFilter
  implements b, Serializable
{
  public static final b INSTANCE;
  public static final b TRUE;
  private static final long serialVersionUID = 8782512160909720199L;
  
  static
  {
    TrueFileFilter localTrueFileFilter = new TrueFileFilter();
    TRUE = localTrueFileFilter;
    INSTANCE = localTrueFileFilter;
  }
  
  public boolean accept(File paramFile)
  {
    return true;
  }
  
  public boolean accept(File paramFile, String paramString)
  {
    return true;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\apache\commons\io\filefilter\TrueFileFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */