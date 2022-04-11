package org.apache.commons.io.filefilter;

import java.io.File;
import java.io.Serializable;
import java.util.List;
import org.apache.commons.io.IOCase;

public class NameFileFilter
  extends a
  implements Serializable
{
  private static final long serialVersionUID = 176844364689077340L;
  private final IOCase caseSensitivity;
  private final String[] names;
  
  public NameFileFilter(String paramString)
  {
    this(paramString, null);
  }
  
  public NameFileFilter(String paramString, IOCase paramIOCase)
  {
    if (paramString != null)
    {
      this.names = new String[] { paramString };
      paramString = paramIOCase;
      if (paramIOCase == null) {
        paramString = IOCase.SENSITIVE;
      }
      this.caseSensitivity = paramString;
      return;
    }
    throw new IllegalArgumentException("The wildcard must not be null");
  }
  
  public NameFileFilter(List<String> paramList)
  {
    this(paramList, null);
  }
  
  public NameFileFilter(List<String> paramList, IOCase paramIOCase)
  {
    if (paramList != null)
    {
      this.names = ((String[])paramList.toArray(new String[paramList.size()]));
      paramList = paramIOCase;
      if (paramIOCase == null) {
        paramList = IOCase.SENSITIVE;
      }
      this.caseSensitivity = paramList;
      return;
    }
    throw new IllegalArgumentException("The list of names must not be null");
  }
  
  public NameFileFilter(String[] paramArrayOfString)
  {
    this(paramArrayOfString, null);
  }
  
  public NameFileFilter(String[] paramArrayOfString, IOCase paramIOCase)
  {
    if (paramArrayOfString != null)
    {
      String[] arrayOfString = new String[paramArrayOfString.length];
      this.names = arrayOfString;
      System.arraycopy(paramArrayOfString, 0, arrayOfString, 0, paramArrayOfString.length);
      paramArrayOfString = paramIOCase;
      if (paramIOCase == null) {
        paramArrayOfString = IOCase.SENSITIVE;
      }
      this.caseSensitivity = paramArrayOfString;
      return;
    }
    throw new IllegalArgumentException("The array of names must not be null");
  }
  
  public boolean accept(File paramFile)
  {
    String str = paramFile.getName();
    for (paramFile : this.names) {
      if (this.caseSensitivity.checkEquals(str, paramFile)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean accept(File paramFile, String paramString)
  {
    for (String str : this.names) {
      if (this.caseSensitivity.checkEquals(paramString, str)) {
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
    if (this.names != null) {
      for (int i = 0; i < this.names.length; i++)
      {
        if (i > 0) {
          localStringBuilder.append(",");
        }
        localStringBuilder.append(this.names[i]);
      }
    }
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\apache\commons\io\filefilter\NameFileFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */