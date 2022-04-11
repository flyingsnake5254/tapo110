package org.apache.commons.io.comparator;

import java.io.File;
import java.io.Serializable;
import java.util.Comparator;

class b
  extends a
  implements Serializable
{
  private final Comparator<File> c;
  
  public b(Comparator<File> paramComparator)
  {
    if (paramComparator != null)
    {
      this.c = paramComparator;
      return;
    }
    throw new IllegalArgumentException("Delegate comparator is missing");
  }
  
  public int compare(File paramFile1, File paramFile2)
  {
    return this.c.compare(paramFile2, paramFile1);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.toString());
    localStringBuilder.append("[");
    localStringBuilder.append(this.c.toString());
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\apache\commons\io\comparator\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */