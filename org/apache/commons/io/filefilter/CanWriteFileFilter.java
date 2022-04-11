package org.apache.commons.io.filefilter;

import java.io.File;
import java.io.Serializable;

public class CanWriteFileFilter
  extends a
  implements Serializable
{
  public static final b CANNOT_WRITE;
  public static final b CAN_WRITE;
  private static final long serialVersionUID = 5132005214688990379L;
  
  static
  {
    CanWriteFileFilter localCanWriteFileFilter = new CanWriteFileFilter();
    CAN_WRITE = localCanWriteFileFilter;
    CANNOT_WRITE = new NotFileFilter(localCanWriteFileFilter);
  }
  
  public boolean accept(File paramFile)
  {
    return paramFile.canWrite();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\apache\commons\io\filefilter\CanWriteFileFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */