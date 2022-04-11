package com.google.common.base;

import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public enum CaseFormat
{
  private final d wordBoundary;
  private final String wordSeparator;
  
  static
  {
    a locala = new a("LOWER_HYPHEN", 0, d.e('-'), "-");
    LOWER_HYPHEN = locala;
    b localb = new b("LOWER_UNDERSCORE", 1, d.e('_'), "_");
    LOWER_UNDERSCORE = localb;
    c localc = new c("LOWER_CAMEL", 2, d.c('A', 'Z'), "");
    LOWER_CAMEL = localc;
    d locald = new d("UPPER_CAMEL", 3, d.c('A', 'Z'), "");
    UPPER_CAMEL = locald;
    e locale = new e("UPPER_UNDERSCORE", 4, d.e('_'), "_");
    UPPER_UNDERSCORE = locale;
    $VALUES = new CaseFormat[] { locala, localb, localc, locald, locale };
  }
  
  private CaseFormat(d paramd, String paramString)
  {
    this.wordBoundary = paramd;
    this.wordSeparator = paramString;
  }
  
  private static String firstCharOnlyToUpper(String paramString)
  {
    if (!paramString.isEmpty())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(c.f(paramString.charAt(0)));
      localStringBuilder.append(c.e(paramString.substring(1)));
      paramString = localStringBuilder.toString();
    }
    return paramString;
  }
  
  private String normalizeFirstWord(String paramString)
  {
    if (this == LOWER_CAMEL) {
      paramString = c.e(paramString);
    } else {
      paramString = normalizeWord(paramString);
    }
    return paramString;
  }
  
  String convert(CaseFormat paramCaseFormat, String paramString)
  {
    StringBuilder localStringBuilder = null;
    int i = 0;
    int j = -1;
    for (;;)
    {
      j = this.wordBoundary.d(paramString, j + 1);
      if (j == -1) {
        break;
      }
      if (i == 0)
      {
        localStringBuilder = new StringBuilder(paramString.length() + this.wordSeparator.length() * 4);
        localStringBuilder.append(paramCaseFormat.normalizeFirstWord(paramString.substring(i, j)));
      }
      else
      {
        localStringBuilder.append(paramCaseFormat.normalizeWord(paramString.substring(i, j)));
      }
      localStringBuilder.append(paramCaseFormat.wordSeparator);
      i = this.wordSeparator.length() + j;
    }
    if (i == 0)
    {
      paramCaseFormat = paramCaseFormat.normalizeFirstWord(paramString);
    }
    else
    {
      localStringBuilder.append(paramCaseFormat.normalizeWord(paramString.substring(i)));
      paramCaseFormat = localStringBuilder.toString();
    }
    return paramCaseFormat;
  }
  
  public f<String, String> converterTo(CaseFormat paramCaseFormat)
  {
    return new f(this, paramCaseFormat);
  }
  
  abstract String normalizeWord(String paramString);
  
  public final String to(CaseFormat paramCaseFormat, String paramString)
  {
    n.o(paramCaseFormat);
    n.o(paramString);
    if (paramCaseFormat != this) {
      paramString = convert(paramCaseFormat, paramString);
    }
    return paramString;
  }
  
  static enum a
  {
    a(d paramd, String paramString1)
    {
      super(paramInt, paramd, paramString1, null);
    }
    
    String convert(CaseFormat paramCaseFormat, String paramString)
    {
      if (paramCaseFormat == CaseFormat.LOWER_UNDERSCORE) {
        return paramString.replace('-', '_');
      }
      if (paramCaseFormat == CaseFormat.UPPER_UNDERSCORE) {
        return c.g(paramString.replace('-', '_'));
      }
      return super.convert(paramCaseFormat, paramString);
    }
    
    String normalizeWord(String paramString)
    {
      return c.e(paramString);
    }
  }
  
  static enum b
  {
    b(d paramd, String paramString1)
    {
      super(paramInt, paramd, paramString1, null);
    }
    
    String convert(CaseFormat paramCaseFormat, String paramString)
    {
      if (paramCaseFormat == CaseFormat.LOWER_HYPHEN) {
        return paramString.replace('_', '-');
      }
      if (paramCaseFormat == CaseFormat.UPPER_UNDERSCORE) {
        return c.g(paramString);
      }
      return super.convert(paramCaseFormat, paramString);
    }
    
    String normalizeWord(String paramString)
    {
      return c.e(paramString);
    }
  }
  
  static enum c
  {
    c(d paramd, String paramString1)
    {
      super(paramInt, paramd, paramString1, null);
    }
    
    String normalizeWord(String paramString)
    {
      return CaseFormat.firstCharOnlyToUpper(paramString);
    }
  }
  
  static enum d
  {
    d(d paramd, String paramString1)
    {
      super(paramInt, paramd, paramString1, null);
    }
    
    String normalizeWord(String paramString)
    {
      return CaseFormat.firstCharOnlyToUpper(paramString);
    }
  }
  
  static enum e
  {
    e(d paramd, String paramString1)
    {
      super(paramInt, paramd, paramString1, null);
    }
    
    String convert(CaseFormat paramCaseFormat, String paramString)
    {
      if (paramCaseFormat == CaseFormat.LOWER_HYPHEN) {
        return c.e(paramString.replace('_', '-'));
      }
      if (paramCaseFormat == CaseFormat.LOWER_UNDERSCORE) {
        return c.e(paramString);
      }
      return super.convert(paramCaseFormat, paramString);
    }
    
    String normalizeWord(String paramString)
    {
      return c.g(paramString);
    }
  }
  
  private static final class f
    extends f<String, String>
    implements Serializable
  {
    private final CaseFormat d;
    private final CaseFormat f;
    
    f(CaseFormat paramCaseFormat1, CaseFormat paramCaseFormat2)
    {
      this.d = ((CaseFormat)n.o(paramCaseFormat1));
      this.f = ((CaseFormat)n.o(paramCaseFormat2));
    }
    
    public boolean equals(@NullableDecl Object paramObject)
    {
      boolean bool1 = paramObject instanceof f;
      boolean bool2 = false;
      boolean bool3 = bool2;
      if (bool1)
      {
        paramObject = (f)paramObject;
        bool3 = bool2;
        if (this.d.equals(((f)paramObject).d))
        {
          bool3 = bool2;
          if (this.f.equals(((f)paramObject).f)) {
            bool3 = true;
          }
        }
      }
      return bool3;
    }
    
    protected String f(String paramString)
    {
      return this.d.to(this.f, paramString);
    }
    
    public int hashCode()
    {
      return this.d.hashCode() ^ this.f.hashCode();
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.d);
      localStringBuilder.append(".converterTo(");
      localStringBuilder.append(this.f);
      localStringBuilder.append(")");
      return localStringBuilder.toString();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\base\CaseFormat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */