package org.apache.commons.io.filefilter;

import java.io.File;
import java.io.Serializable;
import java.util.List;
import org.apache.commons.io.IOCase;

public class PrefixFileFilter
  extends a
  implements Serializable
{
  private static final long serialVersionUID = 8533897440809599867L;
  private final IOCase caseSensitivity;
  private final String[] prefixes;
  
  public PrefixFileFilter(String paramString)
  {
    this(paramString, IOCase.SENSITIVE);
  }
  
  public PrefixFileFilter(String paramString, IOCase paramIOCase)
  {
    if (paramString != null)
    {
      this.prefixes = new String[] { paramString };
      paramString = paramIOCase;
      if (paramIOCase == null) {
        paramString = IOCase.SENSITIVE;
      }
      this.caseSensitivity = paramString;
      return;
    }
    throw new IllegalArgumentException("The prefix must not be null");
  }
  
  public PrefixFileFilter(List<String> paramList)
  {
    this(paramList, IOCase.SENSITIVE);
  }
  
  public PrefixFileFilter(List<String> paramList, IOCase paramIOCase)
  {
    if (paramList != null)
    {
      this.prefixes = ((String[])paramList.toArray(new String[paramList.size()]));
      paramList = paramIOCase;
      if (paramIOCase == null) {
        paramList = IOCase.SENSITIVE;
      }
      this.caseSensitivity = paramList;
      return;
    }
    throw new IllegalArgumentException("The list of prefixes must not be null");
  }
  
  public PrefixFileFilter(String[] paramArrayOfString)
  {
    this(paramArrayOfString, IOCase.SENSITIVE);
  }
  
  public PrefixFileFilter(String[] paramArrayOfString, IOCase paramIOCase)
  {
    if (paramArrayOfString != null)
    {
      String[] arrayOfString = new String[paramArrayOfString.length];
      this.prefixes = arrayOfString;
      System.arraycopy(paramArrayOfString, 0, arrayOfString, 0, paramArrayOfString.length);
      paramArrayOfString = paramIOCase;
      if (paramIOCase == null) {
        paramArrayOfString = IOCase.SENSITIVE;
      }
      this.caseSensitivity = paramArrayOfString;
      return;
    }
    throw new IllegalArgumentException("The array of prefixes must not be null");
  }
  
  public boolean accept(File paramFile)
  {
    String str1 = paramFile.getName();
    for (String str2 : this.prefixes) {
      if (this.caseSensitivity.checkStartsWith(str1, str2)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean accept(File paramFile, String paramString)
  {
    for (String str : this.prefixes) {
      if (this.caseSensitivity.checkStartsWith(paramString, str)) {
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
    if (this.prefixes != null) {
      for (int i = 0; i < this.prefixes.length; i++)
      {
        if (i > 0) {
          localStringBuilder.append(",");
        }
        localStringBuilder.append(this.prefixes[i]);
      }
    }
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\apache\commons\io\filefilter\PrefixFileFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */