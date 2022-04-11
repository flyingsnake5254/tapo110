package org.apache.commons.io.comparator;

import java.io.File;
import java.io.Serializable;
import java.util.Comparator;
import org.apache.commons.io.IOCase;

public class PathFileComparator
  extends a
  implements Serializable
{
  public static final Comparator<File> PATH_COMPARATOR;
  public static final Comparator<File> PATH_INSENSITIVE_COMPARATOR;
  public static final Comparator<File> PATH_INSENSITIVE_REVERSE;
  public static final Comparator<File> PATH_REVERSE;
  public static final Comparator<File> PATH_SYSTEM_COMPARATOR;
  public static final Comparator<File> PATH_SYSTEM_REVERSE;
  private static final long serialVersionUID = 6527501707585768673L;
  private final IOCase caseSensitivity;
  
  static
  {
    PathFileComparator localPathFileComparator = new PathFileComparator();
    PATH_COMPARATOR = localPathFileComparator;
    PATH_REVERSE = new b(localPathFileComparator);
    localPathFileComparator = new PathFileComparator(IOCase.INSENSITIVE);
    PATH_INSENSITIVE_COMPARATOR = localPathFileComparator;
    PATH_INSENSITIVE_REVERSE = new b(localPathFileComparator);
    localPathFileComparator = new PathFileComparator(IOCase.SYSTEM);
    PATH_SYSTEM_COMPARATOR = localPathFileComparator;
    PATH_SYSTEM_REVERSE = new b(localPathFileComparator);
  }
  
  public PathFileComparator()
  {
    this.caseSensitivity = IOCase.SENSITIVE;
  }
  
  public PathFileComparator(IOCase paramIOCase)
  {
    IOCase localIOCase = paramIOCase;
    if (paramIOCase == null) {
      localIOCase = IOCase.SENSITIVE;
    }
    this.caseSensitivity = localIOCase;
  }
  
  public int compare(File paramFile1, File paramFile2)
  {
    return this.caseSensitivity.checkCompareTo(paramFile1.getPath(), paramFile2.getPath());
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.toString());
    localStringBuilder.append("[caseSensitivity=");
    localStringBuilder.append(this.caseSensitivity);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\apache\commons\io\comparator\PathFileComparator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */