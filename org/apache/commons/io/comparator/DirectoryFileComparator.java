package org.apache.commons.io.comparator;

import java.io.File;
import java.io.Serializable;
import java.util.Comparator;

public class DirectoryFileComparator
  extends a
  implements Serializable
{
  public static final Comparator<File> DIRECTORY_COMPARATOR;
  public static final Comparator<File> DIRECTORY_REVERSE;
  private static final long serialVersionUID = 296132640160964395L;
  
  static
  {
    DirectoryFileComparator localDirectoryFileComparator = new DirectoryFileComparator();
    DIRECTORY_COMPARATOR = localDirectoryFileComparator;
    DIRECTORY_REVERSE = new b(localDirectoryFileComparator);
  }
  
  private int getType(File paramFile)
  {
    if (paramFile.isDirectory()) {
      return 1;
    }
    return 2;
  }
  
  public int compare(File paramFile1, File paramFile2)
  {
    return getType(paramFile1) - getType(paramFile2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\apache\commons\io\comparator\DirectoryFileComparator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */