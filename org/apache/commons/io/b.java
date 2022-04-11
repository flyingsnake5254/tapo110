package org.apache.commons.io;

import java.io.File;
import java.util.ArrayList;
import java.util.Stack;

public class b
{
  public static final String a = Character.toString('.');
  private static final char b = (char)File.separatorChar;
  private static final char c;
  
  static
  {
    if (d()) {
      c = (char)47;
    } else {
      c = (char)92;
    }
  }
  
  public static String a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    int i = b(paramString);
    if (i == -1) {
      return "";
    }
    return paramString.substring(i + 1);
  }
  
  public static int b(String paramString)
  {
    int i = -1;
    if (paramString == null) {
      return -1;
    }
    int j = paramString.lastIndexOf('.');
    if (c(paramString) <= j) {
      i = j;
    }
    return i;
  }
  
  public static int c(String paramString)
  {
    if (paramString == null) {
      return -1;
    }
    return Math.max(paramString.lastIndexOf('/'), paramString.lastIndexOf('\\'));
  }
  
  static boolean d()
  {
    boolean bool;
    if (b == '\\') {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  static String[] e(String paramString)
  {
    if ((paramString.indexOf('?') == -1) && (paramString.indexOf('*') == -1)) {
      return new String[] { paramString };
    }
    paramString = paramString.toCharArray();
    ArrayList localArrayList = new ArrayList();
    StringBuilder localStringBuilder = new StringBuilder();
    int i = paramString.length;
    int j = 0;
    char c1;
    for (int k = 0; j < i; k = c1)
    {
      c1 = paramString[j];
      if ((c1 != '?') && (c1 != '*'))
      {
        localStringBuilder.append(c1);
      }
      else
      {
        if (localStringBuilder.length() != 0)
        {
          localArrayList.add(localStringBuilder.toString());
          localStringBuilder.setLength(0);
        }
        if (c1 == '?') {
          localArrayList.add("?");
        } else if (k != 42) {
          localArrayList.add("*");
        }
      }
      j++;
    }
    if (localStringBuilder.length() != 0) {
      localArrayList.add(localStringBuilder.toString());
    }
    return (String[])localArrayList.toArray(new String[localArrayList.size()]);
  }
  
  public static boolean f(String paramString1, String paramString2)
  {
    return g(paramString1, paramString2, IOCase.SENSITIVE);
  }
  
  public static boolean g(String paramString1, String paramString2, IOCase paramIOCase)
  {
    if ((paramString1 == null) && (paramString2 == null)) {
      return true;
    }
    if ((paramString1 != null) && (paramString2 != null))
    {
      IOCase localIOCase = paramIOCase;
      if (paramIOCase == null) {
        localIOCase = IOCase.SENSITIVE;
      }
      String[] arrayOfString = e(paramString2);
      paramString2 = new Stack();
      int i = 0;
      int j = 0;
      int k = 0;
      label300:
      do
      {
        if (paramString2.size() > 0)
        {
          paramIOCase = (int[])paramString2.pop();
          k = paramIOCase[0];
          j = paramIOCase[1];
          i = 1;
        }
        int m;
        for (;;)
        {
          m = j;
          if (k >= arrayOfString.length) {
            break;
          }
          if (arrayOfString[k].equals("?"))
          {
            m = j + 1;
            j = m;
            if (m > paramString1.length()) {
              break;
            }
          }
          for (;;)
          {
            i = 0;
            break;
            if (arrayOfString[k].equals("*"))
            {
              if (k == arrayOfString.length - 1) {
                j = paramString1.length();
              }
              i = 1;
              break;
            }
            if (i != 0)
            {
              j = localIOCase.checkIndexOf(paramString1, j, arrayOfString[k]);
              if (j == -1)
              {
                m = j;
                break label300;
              }
              i = localIOCase.checkIndexOf(paramString1, j + 1, arrayOfString[k]);
              m = j;
              if (i >= 0)
              {
                paramString2.push(new int[] { k, i });
                m = j;
              }
            }
            else
            {
              m = j;
              if (!localIOCase.checkRegionMatches(paramString1, j, arrayOfString[k]))
              {
                m = j;
                break label300;
              }
            }
            j = m + arrayOfString[k].length();
          }
          k++;
        }
        if ((k == arrayOfString.length) && (m == paramString1.length())) {
          return true;
        }
        j = m;
      } while (paramString2.size() > 0);
    }
    return false;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\apache\commons\io\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */