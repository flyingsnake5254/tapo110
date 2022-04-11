package org.apache.commons.io.filefilter;

import java.io.File;
import java.io.Serializable;

public class SizeFileFilter
  extends a
  implements Serializable
{
  private static final long serialVersionUID = 7388077430788600069L;
  private final boolean acceptLarger;
  private final long size;
  
  public SizeFileFilter(long paramLong)
  {
    this(paramLong, true);
  }
  
  public SizeFileFilter(long paramLong, boolean paramBoolean)
  {
    if (paramLong >= 0L)
    {
      this.size = paramLong;
      this.acceptLarger = paramBoolean;
      return;
    }
    throw new IllegalArgumentException("The size must be non-negative");
  }
  
  public boolean accept(File paramFile)
  {
    long l1 = paramFile.length();
    long l2 = this.size;
    boolean bool1 = true;
    boolean bool2;
    if (l1 < l2) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    if (this.acceptLarger) {
      if (!bool2) {
        bool2 = bool1;
      } else {
        bool2 = false;
      }
    }
    return bool2;
  }
  
  public String toString()
  {
    String str;
    if (this.acceptLarger) {
      str = ">=";
    } else {
      str = "<";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.toString());
    localStringBuilder.append("(");
    localStringBuilder.append(str);
    localStringBuilder.append(this.size);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\apache\commons\io\filefilter\SizeFileFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */