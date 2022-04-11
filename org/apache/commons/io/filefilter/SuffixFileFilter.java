package org.apache.commons.io.filefilter;

import java.io.File;
import java.io.Serializable;
import java.util.List;
import org.apache.commons.io.IOCase;

public class SuffixFileFilter
  extends a
  implements Serializable
{
  private static final long serialVersionUID = -3389157631240246157L;
  private final IOCase caseSensitivity;
  private final String[] suffixes;
  
  public SuffixFileFilter(String paramString)
  {
    this(paramString, IOCase.SENSITIVE);
  }
  
  public SuffixFileFilter(String paramString, IOCase paramIOCase)
  {
    if (paramString != null)
    {
      this.suffixes = new String[] { paramString };
      paramString = paramIOCase;
      if (paramIOCase == null) {
        paramString = IOCase.SENSITIVE;
      }
      this.caseSensitivity = paramString;
      return;
    }
    throw new IllegalArgumentException("The suffix must not be null");
  }
  
  public SuffixFileFilter(List<String> paramList)
  {
    this(paramList, IOCase.SENSITIVE);
  }
  
  public SuffixFileFilter(List<String> paramList, IOCase paramIOCase)
  {
    if (paramList != null)
    {
      this.suffixes = ((String[])paramList.toArray(new String[paramList.size()]));
      paramList = paramIOCase;
      if (paramIOCase == null) {
        paramList = IOCase.SENSITIVE;
      }
      this.caseSensitivity = paramList;
      return;
    }
    throw new IllegalArgumentException("The list of suffixes must not be null");
  }
  
  public SuffixFileFilter(String[] paramArrayOfString)
  {
    this(paramArrayOfString, IOCase.SENSITIVE);
  }
  
  public SuffixFileFilter(String[] paramArrayOfString, IOCase paramIOCase)
  {
    if (paramArrayOfString != null)
    {
      String[] arrayOfString = new String[paramArrayOfString.length];
      this.suffixes = arrayOfString;
      System.arraycopy(paramArrayOfString, 0, arrayOfString, 0, paramArrayOfString.length);
      paramArrayOfString = paramIOCase;
      if (paramIOCase == null) {
        paramArrayOfString = IOCase.SENSITIVE;
      }
      this.caseSensitivity = paramArrayOfString;
      return;
    }
    throw new IllegalArgumentException("The array of suffixes must not be null");
  }
  
  public boolean accept(File paramFile)
  {
    String str1 = paramFile.getName();
    for (String str2 : this.suffixes) {
      if (this.caseSensitivity.checkEndsWith(str1, str2)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean accept(File paramFile, String paramString)
  {
    for (paramFile : this.suffixes) {
      if (this.caseSensitivity.checkEndsWith(paramString, paramFile)) {
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
    if (this.suffixes != null) {
      for (int i = 0; i < this.suffixes.length; i++)
      {
        if (i > 0) {
          localStringBuilder.append(",");
        }
        localStringBuilder.append(this.suffixes[i]);
      }
    }
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\apache\commons\io\filefilter\SuffixFileFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */