package org.apache.commons.io.filefilter;

import java.io.File;
import java.io.Serializable;

public class NotFileFilter
  extends a
  implements Serializable
{
  private static final long serialVersionUID = 6131563330944994230L;
  private final b filter;
  
  public NotFileFilter(b paramb)
  {
    if (paramb != null)
    {
      this.filter = paramb;
      return;
    }
    throw new IllegalArgumentException("The filter must not be null");
  }
  
  public boolean accept(File paramFile)
  {
    return this.filter.accept(paramFile) ^ true;
  }
  
  public boolean accept(File paramFile, String paramString)
  {
    return this.filter.accept(paramFile, paramString) ^ true;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.toString());
    localStringBuilder.append("(");
    localStringBuilder.append(this.filter.toString());
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\apache\commons\io\filefilter\NotFileFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */