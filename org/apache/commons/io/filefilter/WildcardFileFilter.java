package org.apache.commons.io.filefilter;

import java.io.File;
import java.io.Serializable;
import java.util.List;
import org.apache.commons.io.IOCase;
import org.apache.commons.io.b;

public class WildcardFileFilter
  extends a
  implements Serializable
{
  private static final long serialVersionUID = -7426486598995782105L;
  private final IOCase caseSensitivity;
  private final String[] wildcards;
  
  public WildcardFileFilter(String paramString)
  {
    this(paramString, IOCase.SENSITIVE);
  }
  
  public WildcardFileFilter(String paramString, IOCase paramIOCase)
  {
    if (paramString != null)
    {
      this.wildcards = new String[] { paramString };
      paramString = paramIOCase;
      if (paramIOCase == null) {
        paramString = IOCase.SENSITIVE;
      }
      this.caseSensitivity = paramString;
      return;
    }
    throw new IllegalArgumentException("The wildcard must not be null");
  }
  
  public WildcardFileFilter(List<String> paramList)
  {
    this(paramList, IOCase.SENSITIVE);
  }
  
  public WildcardFileFilter(List<String> paramList, IOCase paramIOCase)
  {
    if (paramList != null)
    {
      this.wildcards = ((String[])paramList.toArray(new String[paramList.size()]));
      paramList = paramIOCase;
      if (paramIOCase == null) {
        paramList = IOCase.SENSITIVE;
      }
      this.caseSensitivity = paramList;
      return;
    }
    throw new IllegalArgumentException("The wildcard list must not be null");
  }
  
  public WildcardFileFilter(String[] paramArrayOfString)
  {
    this(paramArrayOfString, IOCase.SENSITIVE);
  }
  
  public WildcardFileFilter(String[] paramArrayOfString, IOCase paramIOCase)
  {
    if (paramArrayOfString != null)
    {
      String[] arrayOfString = new String[paramArrayOfString.length];
      this.wildcards = arrayOfString;
      System.arraycopy(paramArrayOfString, 0, arrayOfString, 0, paramArrayOfString.length);
      paramArrayOfString = paramIOCase;
      if (paramIOCase == null) {
        paramArrayOfString = IOCase.SENSITIVE;
      }
      this.caseSensitivity = paramArrayOfString;
      return;
    }
    throw new IllegalArgumentException("The wildcard array must not be null");
  }
  
  public boolean accept(File paramFile)
  {
    String str = paramFile.getName();
    paramFile = this.wildcards;
    int i = paramFile.length;
    for (int j = 0; j < i; j++) {
      if (b.g(str, paramFile[j], this.caseSensitivity)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean accept(File paramFile, String paramString)
  {
    paramFile = this.wildcards;
    int i = paramFile.length;
    for (int j = 0; j < i; j++) {
      if (b.g(paramString, paramFile[j], this.caseSensitivity)) {
        return true;
      }
    }
    return false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.toString());
    localStringBuilder.append("(");
    if (this.wildcards != null) {
      for (int i = 0; i < this.wildcards.length; i++)
      {
        if (i > 0) {
          localStringBuilder.append(",");
        }
        localStringBuilder.append(this.wildcards[i]);
      }
    }
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\apache\commons\io\filefilter\WildcardFileFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */