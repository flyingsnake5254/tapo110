package org.apache.commons.io.filefilter;

import java.io.File;
import java.io.Serializable;

public class FalseFileFilter
  implements b, Serializable
{
  public static final b FALSE;
  public static final b INSTANCE;
  private static final long serialVersionUID = 6210271677940926200L;
  
  static
  {
    FalseFileFilter localFalseFileFilter = new FalseFileFilter();
    FALSE = localFalseFileFilter;
    INSTANCE = localFalseFileFilter;
  }
  
  public boolean accept(File paramFile)
  {
    return false;
  }
  
  public boolean accept(File paramFile, String paramString)
  {
    return false;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\apache\commons\io\filefilter\FalseFileFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */