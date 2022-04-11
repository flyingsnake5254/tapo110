package org.apache.commons.io.filefilter;

import java.io.File;
import java.io.Serializable;

public class DirectoryFileFilter
  extends a
  implements Serializable
{
  public static final b DIRECTORY;
  public static final b INSTANCE;
  private static final long serialVersionUID = -5148237843784525732L;
  
  static
  {
    DirectoryFileFilter localDirectoryFileFilter = new DirectoryFileFilter();
    DIRECTORY = localDirectoryFileFilter;
    INSTANCE = localDirectoryFileFilter;
  }
  
  public boolean accept(File paramFile)
  {
    return paramFile.isDirectory();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\apache\commons\io\filefilter\DirectoryFileFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */