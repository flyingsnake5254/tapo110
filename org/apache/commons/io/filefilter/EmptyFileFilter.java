package org.apache.commons.io.filefilter;

import java.io.File;
import java.io.Serializable;

public class EmptyFileFilter
  extends a
  implements Serializable
{
  public static final b EMPTY;
  public static final b NOT_EMPTY;
  private static final long serialVersionUID = 3631422087512832211L;
  
  static
  {
    EmptyFileFilter localEmptyFileFilter = new EmptyFileFilter();
    EMPTY = localEmptyFileFilter;
    NOT_EMPTY = new NotFileFilter(localEmptyFileFilter);
  }
  
  public boolean accept(File paramFile)
  {
    boolean bool1 = paramFile.isDirectory();
    boolean bool2 = true;
    boolean bool3 = true;
    if (bool1)
    {
      paramFile = paramFile.listFiles();
      bool2 = bool3;
      if (paramFile != null) {
        if (paramFile.length == 0) {
          bool2 = bool3;
        } else {
          bool2 = false;
        }
      }
      return bool2;
    }
    if (paramFile.length() != 0L) {
      bool2 = false;
    }
    return bool2;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\apache\commons\io\filefilter\EmptyFileFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */