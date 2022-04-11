package org.apache.commons.io.filefilter;

import java.io.File;
import java.io.Serializable;

public class CanReadFileFilter
  extends a
  implements Serializable
{
  public static final b CANNOT_READ;
  public static final b CAN_READ;
  public static final b READ_ONLY;
  private static final long serialVersionUID = 3179904805251622989L;
  
  static
  {
    CanReadFileFilter localCanReadFileFilter = new CanReadFileFilter();
    CAN_READ = localCanReadFileFilter;
    CANNOT_READ = new NotFileFilter(localCanReadFileFilter);
    READ_ONLY = new AndFileFilter(localCanReadFileFilter, CanWriteFileFilter.CANNOT_WRITE);
  }
  
  public boolean accept(File paramFile)
  {
    return paramFile.canRead();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\apache\commons\io\filefilter\CanReadFileFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */