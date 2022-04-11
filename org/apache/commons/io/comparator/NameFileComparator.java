package org.apache.commons.io.comparator;

import java.io.File;
import java.io.Serializable;
import java.util.Comparator;
import org.apache.commons.io.IOCase;

public class NameFileComparator
  extends a
  implements Serializable
{
  public static final Comparator<File> NAME_COMPARATOR;
  public static final Comparator<File> NAME_INSENSITIVE_COMPARATOR;
  public static final Comparator<File> NAME_INSENSITIVE_REVERSE;
  public static final Comparator<File> NAME_REVERSE;
  public static final Comparator<File> NAME_SYSTEM_COMPARATOR;
  public static final Comparator<File> NAME_SYSTEM_REVERSE;
  private static final long serialVersionUID = 8397947749814525798L;
  private final IOCase caseSensitivity;
  
  static
  {
    NameFileComparator localNameFileComparator = new NameFileComparator();
    NAME_COMPARATOR = localNameFileComparator;
    NAME_REVERSE = new b(localNameFileComparator);
    localNameFileComparator = new NameFileComparator(IOCase.INSENSITIVE);
    NAME_INSENSITIVE_COMPARATOR = localNameFileComparator;
    NAME_INSENSITIVE_REVERSE = new b(localNameFileComparator);
    localNameFileComparator = new NameFileComparator(IOCase.SYSTEM);
    NAME_SYSTEM_COMPARATOR = localNameFileComparator;
    NAME_SYSTEM_REVERSE = new b(localNameFileComparator);
  }
  
  public NameFileComparator()
  {
    this.caseSensitivity = IOCase.SENSITIVE;
  }
  
  public NameFileComparator(IOCase paramIOCase)
  {
    IOCase localIOCase = paramIOCase;
    if (paramIOCase == null) {
      localIOCase = IOCase.SENSITIVE;
    }
    this.caseSensitivity = localIOCase;
  }
  
  public int compare(File paramFile1, File paramFile2)
  {
    return this.caseSensitivity.checkCompareTo(paramFile1.getName(), paramFile2.getName());
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\apache\commons\io\comparator\NameFileComparator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */