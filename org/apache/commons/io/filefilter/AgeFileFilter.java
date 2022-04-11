package org.apache.commons.io.filefilter;

import java.io.File;
import java.io.Serializable;
import java.util.Date;

public class AgeFileFilter
  extends a
  implements Serializable
{
  private static final long serialVersionUID = -2132740084016138541L;
  private final boolean acceptOlder;
  private final long cutoff;
  
  public AgeFileFilter(long paramLong)
  {
    this(paramLong, true);
  }
  
  public AgeFileFilter(long paramLong, boolean paramBoolean)
  {
    this.acceptOlder = paramBoolean;
    this.cutoff = paramLong;
  }
  
  public AgeFileFilter(File paramFile)
  {
    this(paramFile, true);
  }
  
  public AgeFileFilter(File paramFile, boolean paramBoolean)
  {
    this(paramFile.lastModified(), paramBoolean);
  }
  
  public AgeFileFilter(Date paramDate)
  {
    this(paramDate, true);
  }
  
  public AgeFileFilter(Date paramDate, boolean paramBoolean)
  {
    this(paramDate.getTime(), paramBoolean);
  }
  
  public boolean accept(File paramFile)
  {
    boolean bool1 = org.apache.commons.io.a.j(paramFile, this.cutoff);
    boolean bool2 = bool1;
    if (this.acceptOlder) {
      if (!bool1) {
        bool2 = true;
      } else {
        bool2 = false;
      }
    }
    return bool2;
  }
  
  public String toString()
  {
    String str;
    if (this.acceptOlder) {
      str = "<=";
    } else {
      str = ">";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.toString());
    localStringBuilder.append("(");
    localStringBuilder.append(str);
    localStringBuilder.append(this.cutoff);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\apache\commons\io\filefilter\AgeFileFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */