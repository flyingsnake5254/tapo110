package org.apache.commons.io.comparator;

import java.io.File;
import java.io.Serializable;
import java.util.Comparator;

public class DefaultFileComparator
  extends a
  implements Serializable
{
  public static final Comparator<File> DEFAULT_COMPARATOR;
  public static final Comparator<File> DEFAULT_REVERSE;
  private static final long serialVersionUID = 3260141861365313518L;
  
  static
  {
    DefaultFileComparator localDefaultFileComparator = new DefaultFileComparator();
    DEFAULT_COMPARATOR = localDefaultFileComparator;
    DEFAULT_REVERSE = new b(localDefaultFileComparator);
  }
  
  public int compare(File paramFile1, File paramFile2)
  {
    return paramFile1.compareTo(paramFile2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\apache\commons\io\comparator\DefaultFileComparator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */