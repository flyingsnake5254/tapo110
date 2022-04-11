package org.apache.commons.lang;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.text.b;

public class e
{
  public static boolean a(String paramString)
  {
    boolean bool;
    if ((paramString != null) && (paramString.length() != 0)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public static String b(Object[] paramArrayOfObject, String paramString)
  {
    if (paramArrayOfObject == null) {
      return null;
    }
    return c(paramArrayOfObject, paramString, 0, paramArrayOfObject.length);
  }
  
  public static String c(Object[] paramArrayOfObject, String paramString, int paramInt1, int paramInt2)
  {
    if (paramArrayOfObject == null) {
      return null;
    }
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    int i = paramInt2 - paramInt1;
    if (i <= 0) {
      return "";
    }
    if (paramArrayOfObject[paramInt1] == null) {
      j = 16;
    } else {
      j = paramArrayOfObject[paramInt1].toString().length();
    }
    paramString = new b(i * (j + str.length()));
    for (int j = paramInt1; j < paramInt2; j++)
    {
      if (j > paramInt1) {
        paramString.f(str);
      }
      if (paramArrayOfObject[j] != null) {
        paramString.e(paramArrayOfObject[j]);
      }
    }
    return paramString.toString();
  }
  
  public static String[] d(String paramString1, String paramString2)
  {
    return e(paramString1, paramString2, -1, false);
  }
  
  private static String[] e(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    if (paramString1 == null) {
      return null;
    }
    int i = paramString1.length();
    if (i == 0) {
      return a.c;
    }
    ArrayList localArrayList = new ArrayList();
    int i1;
    if (paramString2 == null)
    {
      j = 0;
      k = 0;
      m = 0;
      n = 0;
      i1 = 1;
      for (;;)
      {
        i2 = k;
        i3 = m;
        i4 = n;
        i5 = j;
        if (j >= i) {
          break;
        }
        if (Character.isWhitespace(paramString1.charAt(j)))
        {
          if (k == 0)
          {
            i4 = k;
            i5 = i1;
            k = j;
            if (!paramBoolean) {}
          }
          else
          {
            if (i1 == paramInt)
            {
              m = i;
              j = 0;
            }
            else
            {
              k = 1;
              m = j;
              j = k;
            }
            localArrayList.add(paramString1.substring(n, m));
            i5 = i1 + 1;
            i4 = 0;
            k = m;
            m = j;
          }
          n = k + 1;
          j = n;
          k = i4;
          i1 = i5;
        }
        else
        {
          j++;
          k = 1;
          m = 0;
        }
      }
    }
    if (paramString2.length() == 1)
    {
      int i6 = paramString2.charAt(0);
      j = 0;
      k = 0;
      m = 0;
      n = 0;
      i2 = 1;
      for (;;)
      {
        i3 = j;
        i4 = k;
        i5 = m;
        i1 = n;
        if (j >= i) {
          break;
        }
        if (paramString1.charAt(j) == i6)
        {
          if (k == 0)
          {
            i5 = j;
            i1 = i2;
            if (!paramBoolean) {}
          }
          else
          {
            if (i2 == paramInt)
            {
              j = i;
              m = 0;
            }
            else
            {
              m = 1;
            }
            localArrayList.add(paramString1.substring(n, j));
            i1 = i2 + 1;
            k = 0;
            i5 = j;
          }
          n = i5 + 1;
          j = n;
          i2 = i1;
        }
        else
        {
          j++;
          k = 1;
          m = 0;
        }
      }
    }
    int j = 0;
    int k = 0;
    int m = 0;
    int n = 0;
    int i2 = 1;
    for (;;)
    {
      i3 = j;
      i4 = k;
      i5 = m;
      i1 = n;
      if (j >= i) {
        break;
      }
      if (paramString2.indexOf(paramString1.charAt(j)) >= 0)
      {
        if (k == 0)
        {
          i5 = j;
          i1 = i2;
          if (!paramBoolean) {}
        }
        else
        {
          if (i2 == paramInt)
          {
            j = i;
            m = 0;
          }
          else
          {
            m = 1;
          }
          localArrayList.add(paramString1.substring(n, j));
          i1 = i2 + 1;
          k = 0;
          i5 = j;
        }
        n = i5 + 1;
        j = n;
        i2 = i1;
      }
      else
      {
        j++;
        k = 1;
        m = 0;
      }
    }
    i2 = i4;
    paramInt = i5;
    int i5 = i3;
    int i4 = i1;
    int i3 = paramInt;
    if ((i2 != 0) || ((paramBoolean) && (i3 != 0))) {
      localArrayList.add(paramString1.substring(i4, i5));
    }
    return (String[])localArrayList.toArray(new String[localArrayList.size()]);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\apache\commons\lang\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */