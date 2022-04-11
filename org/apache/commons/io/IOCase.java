package org.apache.commons.io;

import java.io.Serializable;

public enum IOCase
  implements Serializable
{
  private static final long serialVersionUID = -6343169151696340687L;
  private final String name;
  private final transient boolean sensitive;
  
  static
  {
    IOCase localIOCase1 = new IOCase("SENSITIVE", 0, "Sensitive", true);
    SENSITIVE = localIOCase1;
    IOCase localIOCase2 = new IOCase("INSENSITIVE", 1, "Insensitive", false);
    INSENSITIVE = localIOCase2;
    IOCase localIOCase3 = new IOCase("SYSTEM", 2, "System", b.d() ^ true);
    SYSTEM = localIOCase3;
    $VALUES = new IOCase[] { localIOCase1, localIOCase2, localIOCase3 };
  }
  
  private IOCase(String paramString, boolean paramBoolean)
  {
    this.name = paramString;
    this.sensitive = paramBoolean;
  }
  
  public static IOCase forName(String paramString)
  {
    for (localObject : ) {
      if (((IOCase)localObject).getName().equals(paramString)) {
        return (IOCase)localObject;
      }
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Invalid IOCase name: ");
    ((StringBuilder)localObject).append(paramString);
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  private Object readResolve()
  {
    return forName(this.name);
  }
  
  public int checkCompareTo(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString2 != null))
    {
      int i;
      if (this.sensitive) {
        i = paramString1.compareTo(paramString2);
      } else {
        i = paramString1.compareToIgnoreCase(paramString2);
      }
      return i;
    }
    throw new NullPointerException("The strings must not be null");
  }
  
  public boolean checkEndsWith(String paramString1, String paramString2)
  {
    int i = paramString2.length();
    return paramString1.regionMatches(this.sensitive ^ true, paramString1.length() - i, paramString2, 0, i);
  }
  
  public boolean checkEquals(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString2 != null))
    {
      boolean bool;
      if (this.sensitive) {
        bool = paramString1.equals(paramString2);
      } else {
        bool = paramString1.equalsIgnoreCase(paramString2);
      }
      return bool;
    }
    throw new NullPointerException("The strings must not be null");
  }
  
  public int checkIndexOf(String paramString1, int paramInt, String paramString2)
  {
    int i = paramString1.length() - paramString2.length();
    if (i >= paramInt) {
      while (paramInt <= i)
      {
        if (checkRegionMatches(paramString1, paramInt, paramString2)) {
          return paramInt;
        }
        paramInt++;
      }
    }
    return -1;
  }
  
  public boolean checkRegionMatches(String paramString1, int paramInt, String paramString2)
  {
    return paramString1.regionMatches(this.sensitive ^ true, paramInt, paramString2, 0, paramString2.length());
  }
  
  public boolean checkStartsWith(String paramString1, String paramString2)
  {
    return paramString1.regionMatches(this.sensitive ^ true, 0, paramString2, 0, paramString2.length());
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public boolean isCaseSensitive()
  {
    return this.sensitive;
  }
  
  public String toString()
  {
    return this.name;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\apache\commons\io\IOCase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */