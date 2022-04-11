package org.apache.commons.io.filefilter;

import java.io.File;
import java.io.Serializable;
import java.util.List;
import org.apache.commons.io.b;

@Deprecated
public class WildcardFilter
  extends a
  implements Serializable
{
  private static final long serialVersionUID = -5037645902506953517L;
  private final String[] wildcards;
  
  public WildcardFilter(String paramString)
  {
    if (paramString != null)
    {
      this.wildcards = new String[] { paramString };
      return;
    }
    throw new IllegalArgumentException("The wildcard must not be null");
  }
  
  public WildcardFilter(List<String> paramList)
  {
    if (paramList != null)
    {
      this.wildcards = ((String[])paramList.toArray(new String[paramList.size()]));
      return;
    }
    throw new IllegalArgumentException("The wildcard list must not be null");
  }
  
  public WildcardFilter(String[] paramArrayOfString)
  {
    if (paramArrayOfString != null)
    {
      String[] arrayOfString = new String[paramArrayOfString.length];
      this.wildcards = arrayOfString;
      System.arraycopy(paramArrayOfString, 0, arrayOfString, 0, paramArrayOfString.length);
      return;
    }
    throw new IllegalArgumentException("The wildcard array must not be null");
  }
  
  public boolean accept(File paramFile)
  {
    if (paramFile.isDirectory()) {
      return false;
    }
    for (String str : this.wildcards) {
      if (b.f(paramFile.getName(), str)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean accept(File paramFile, String paramString)
  {
    if ((paramFile != null) && (new File(paramFile, paramString).isDirectory())) {
      return false;
    }
    paramFile = this.wildcards;
    int i = paramFile.length;
    for (int j = 0; j < i; j++) {
      if (b.f(paramString, paramFile[j])) {
        return true;
      }
    }
    return false;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\apache\commons\io\filefilter\WildcardFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */