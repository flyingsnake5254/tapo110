package org.apache.commons.io.comparator;

import java.io.File;
import java.io.Serializable;
import java.util.Comparator;

public class LastModifiedFileComparator
  extends a
  implements Serializable
{
  public static final Comparator<File> LASTMODIFIED_COMPARATOR;
  public static final Comparator<File> LASTMODIFIED_REVERSE;
  private static final long serialVersionUID = 7372168004395734046L;
  
  static
  {
    LastModifiedFileComparator localLastModifiedFileComparator = new LastModifiedFileComparator();
    LASTMODIFIED_COMPARATOR = localLastModifiedFileComparator;
    LASTMODIFIED_REVERSE = new b(localLastModifiedFileComparator);
  }
  
  public int compare(File paramFile1, File paramFile2)
  {
    boolean bool = paramFile1.lastModified() - paramFile2.lastModified() < 0L;
    if (bool) {
      return -1;
    }
    if (bool) {
      return 1;
    }
    return 0;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\apache\commons\io\comparator\LastModifiedFileComparator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */