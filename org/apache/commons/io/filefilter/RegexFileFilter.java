package org.apache.commons.io.filefilter;

import java.io.File;
import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.io.IOCase;

public class RegexFileFilter
  extends a
  implements Serializable
{
  private static final long serialVersionUID = 4269646126155225062L;
  private final Pattern pattern;
  
  public RegexFileFilter(String paramString)
  {
    if (paramString != null)
    {
      this.pattern = Pattern.compile(paramString);
      return;
    }
    throw new IllegalArgumentException("Pattern is missing");
  }
  
  public RegexFileFilter(String paramString, int paramInt)
  {
    if (paramString != null)
    {
      this.pattern = Pattern.compile(paramString, paramInt);
      return;
    }
    throw new IllegalArgumentException("Pattern is missing");
  }
  
  public RegexFileFilter(String paramString, IOCase paramIOCase)
  {
    if (paramString != null)
    {
      int i = 0;
      int j = i;
      if (paramIOCase != null)
      {
        j = i;
        if (!paramIOCase.isCaseSensitive()) {
          j = 2;
        }
      }
      this.pattern = Pattern.compile(paramString, j);
      return;
    }
    throw new IllegalArgumentException("Pattern is missing");
  }
  
  public RegexFileFilter(Pattern paramPattern)
  {
    if (paramPattern != null)
    {
      this.pattern = paramPattern;
      return;
    }
    throw new IllegalArgumentException("Pattern is missing");
  }
  
  public boolean accept(File paramFile, String paramString)
  {
    return this.pattern.matcher(paramString).matches();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\apache\commons\io\filefilter\RegexFileFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */