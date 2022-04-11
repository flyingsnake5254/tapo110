package org.apache.commons.io.comparator;

import java.io.File;
import java.io.Serializable;
import java.util.Comparator;
import org.apache.commons.io.IOCase;

public class ExtensionFileComparator
  extends a
  implements Serializable
{
  public static final Comparator<File> EXTENSION_COMPARATOR;
  public static final Comparator<File> EXTENSION_INSENSITIVE_COMPARATOR;
  public static final Comparator<File> EXTENSION_INSENSITIVE_REVERSE;
  public static final Comparator<File> EXTENSION_REVERSE;
  public static final Comparator<File> EXTENSION_SYSTEM_COMPARATOR;
  public static final Comparator<File> EXTENSION_SYSTEM_REVERSE;
  private static final long serialVersionUID = 1928235200184222815L;
  private final IOCase caseSensitivity;
  
  static
  {
    ExtensionFileComparator localExtensionFileComparator = new ExtensionFileComparator();
    EXTENSION_COMPARATOR = localExtensionFileComparator;
    EXTENSION_REVERSE = new b(localExtensionFileComparator);
    localExtensionFileComparator = new ExtensionFileComparator(IOCase.INSENSITIVE);
    EXTENSION_INSENSITIVE_COMPARATOR = localExtensionFileComparator;
    EXTENSION_INSENSITIVE_REVERSE = new b(localExtensionFileComparator);
    localExtensionFileComparator = new ExtensionFileComparator(IOCase.SYSTEM);
    EXTENSION_SYSTEM_COMPARATOR = localExtensionFileComparator;
    EXTENSION_SYSTEM_REVERSE = new b(localExtensionFileComparator);
  }
  
  public ExtensionFileComparator()
  {
    this.caseSensitivity = IOCase.SENSITIVE;
  }
  
  public ExtensionFileComparator(IOCase paramIOCase)
  {
    IOCase localIOCase = paramIOCase;
    if (paramIOCase == null) {
      localIOCase = IOCase.SENSITIVE;
    }
    this.caseSensitivity = localIOCase;
  }
  
  public int compare(File paramFile1, File paramFile2)
  {
    paramFile1 = org.apache.commons.io.b.a(paramFile1.getName());
    paramFile2 = org.apache.commons.io.b.a(paramFile2.getName());
    return this.caseSensitivity.checkCompareTo(paramFile1, paramFile2);
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\apache\commons\io\comparator\ExtensionFileComparator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */