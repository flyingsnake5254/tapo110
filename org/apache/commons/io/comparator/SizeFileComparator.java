package org.apache.commons.io.comparator;

import java.io.File;
import java.io.Serializable;
import java.util.Comparator;

public class SizeFileComparator
  extends a
  implements Serializable
{
  public static final Comparator<File> SIZE_COMPARATOR;
  public static final Comparator<File> SIZE_REVERSE;
  public static final Comparator<File> SIZE_SUMDIR_COMPARATOR;
  public static final Comparator<File> SIZE_SUMDIR_REVERSE;
  private static final long serialVersionUID = -1201561106411416190L;
  private final boolean sumDirectoryContents;
  
  static
  {
    SizeFileComparator localSizeFileComparator = new SizeFileComparator();
    SIZE_COMPARATOR = localSizeFileComparator;
    SIZE_REVERSE = new b(localSizeFileComparator);
    localSizeFileComparator = new SizeFileComparator(true);
    SIZE_SUMDIR_COMPARATOR = localSizeFileComparator;
    SIZE_SUMDIR_REVERSE = new b(localSizeFileComparator);
  }
  
  public SizeFileComparator()
  {
    this.sumDirectoryContents = false;
  }
  
  public SizeFileComparator(boolean paramBoolean)
  {
    this.sumDirectoryContents = paramBoolean;
  }
  
  public int compare(File paramFile1, File paramFile2)
  {
    long l1;
    if (paramFile1.isDirectory())
    {
      if ((this.sumDirectoryContents) && (paramFile1.exists())) {
        l1 = org.apache.commons.io.a.n(paramFile1);
      } else {
        l1 = 0L;
      }
    }
    else {
      l1 = paramFile1.length();
    }
    long l2;
    if (paramFile2.isDirectory())
    {
      if ((this.sumDirectoryContents) && (paramFile2.exists())) {
        l2 = org.apache.commons.io.a.n(paramFile2);
      } else {
        l2 = 0L;
      }
    }
    else {
      l2 = paramFile2.length();
    }
    boolean bool = l1 - l2 < 0L;
    if (bool) {
      return -1;
    }
    if (bool) {
      return 1;
    }
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.toString());
    localStringBuilder.append("[sumDirectoryContents=");
    localStringBuilder.append(this.sumDirectoryContents);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\apache\commons\io\comparator\SizeFileComparator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */