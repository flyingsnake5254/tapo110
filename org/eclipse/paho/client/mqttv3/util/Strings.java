package org.eclipse.paho.client.mqttv3.util;

public final class Strings
{
  private static final int INDEX_NOT_FOUND = -1;
  
  public static boolean containsAny(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    if (paramCharSequence2 == null) {
      return false;
    }
    return containsAny(paramCharSequence1, toCharArray(paramCharSequence2));
  }
  
  public static boolean containsAny(CharSequence paramCharSequence, char[] paramArrayOfChar)
  {
    if ((!isEmpty(paramCharSequence)) && (!isEmpty(paramArrayOfChar)))
    {
      int i = paramCharSequence.length();
      int j = paramArrayOfChar.length;
      int k = 0;
      if (k >= i) {
        return false;
      }
      char c = paramCharSequence.charAt(k);
      for (int m = 0;; m++)
      {
        if (m >= j)
        {
          k++;
          break;
        }
        if (paramArrayOfChar[m] == c) {
          if (Character.isHighSurrogate(c))
          {
            if (m == j - 1) {
              return true;
            }
            if ((k >= i - 1) || (paramArrayOfChar[(m + 1)] != paramCharSequence.charAt(k + 1))) {}
          }
          else
          {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  public static int countMatches(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    boolean bool = isEmpty(paramCharSequence1);
    int i = 0;
    if ((!bool) && (!isEmpty(paramCharSequence2)))
    {
      int j = 0;
      for (;;)
      {
        i = indexOf(paramCharSequence1, paramCharSequence2, i);
        if (i == -1) {
          return j;
        }
        j++;
        i += paramCharSequence2.length();
      }
    }
    return 0;
  }
  
  public static boolean equalsAny(CharSequence paramCharSequence, CharSequence[] paramArrayOfCharSequence)
  {
    boolean bool1;
    if ((paramCharSequence == null) && (paramArrayOfCharSequence == null)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2 = bool1;
    if (paramArrayOfCharSequence != null)
    {
      int i = paramArrayOfCharSequence.length;
      for (int j = 0;; j++)
      {
        if (j >= i)
        {
          bool2 = bool1;
          break;
        }
        CharSequence localCharSequence = paramArrayOfCharSequence[j];
        if ((!bool1) && (!localCharSequence.equals(paramCharSequence))) {
          bool1 = false;
        } else {
          bool1 = true;
        }
      }
    }
    return bool2;
  }
  
  private static int indexOf(CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt)
  {
    return paramCharSequence1.toString().indexOf(paramCharSequence2.toString(), paramInt);
  }
  
  public static boolean isEmpty(CharSequence paramCharSequence)
  {
    return (paramCharSequence == null) || (paramCharSequence.length() == 0);
  }
  
  private static boolean isEmpty(char[] paramArrayOfChar)
  {
    return (paramArrayOfChar == null) || (paramArrayOfChar.length == 0);
  }
  
  private static char[] toCharArray(CharSequence paramCharSequence)
  {
    if ((paramCharSequence instanceof String)) {
      return ((String)paramCharSequence).toCharArray();
    }
    int i = paramCharSequence.length();
    char[] arrayOfChar = new char[paramCharSequence.length()];
    for (int j = 0;; j++)
    {
      if (j >= i) {
        return arrayOfChar;
      }
      arrayOfChar[j] = paramCharSequence.charAt(j);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\eclipse\paho\client\mqttv3\util\Strings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */