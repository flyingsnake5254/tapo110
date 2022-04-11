package io.netty.handler.codec.http.cookie;

import io.netty.util.internal.InternalThreadLocalMap;
import java.util.BitSet;

final class CookieUtil
{
  private static final BitSet VALID_COOKIE_ATTRIBUTE_VALUE_OCTETS = validCookieAttributeValueOctets();
  private static final BitSet VALID_COOKIE_NAME_OCTETS = ;
  private static final BitSet VALID_COOKIE_VALUE_OCTETS = validCookieValueOctets();
  
  static void add(StringBuilder paramStringBuilder, String paramString)
  {
    paramStringBuilder.append(paramString);
    paramStringBuilder.append(';');
    paramStringBuilder.append(' ');
  }
  
  static void add(StringBuilder paramStringBuilder, String paramString, long paramLong)
  {
    paramStringBuilder.append(paramString);
    paramStringBuilder.append('=');
    paramStringBuilder.append(paramLong);
    paramStringBuilder.append(';');
    paramStringBuilder.append(' ');
  }
  
  static void add(StringBuilder paramStringBuilder, String paramString1, String paramString2)
  {
    paramStringBuilder.append(paramString1);
    paramStringBuilder.append('=');
    paramStringBuilder.append(paramString2);
    paramStringBuilder.append(';');
    paramStringBuilder.append(' ');
  }
  
  static void addQuoted(StringBuilder paramStringBuilder, String paramString1, String paramString2)
  {
    String str = paramString2;
    if (paramString2 == null) {
      str = "";
    }
    paramStringBuilder.append(paramString1);
    paramStringBuilder.append('=');
    paramStringBuilder.append('"');
    paramStringBuilder.append(str);
    paramStringBuilder.append('"');
    paramStringBuilder.append(';');
    paramStringBuilder.append(' ');
  }
  
  static int firstInvalidCookieNameOctet(CharSequence paramCharSequence)
  {
    return firstInvalidOctet(paramCharSequence, VALID_COOKIE_NAME_OCTETS);
  }
  
  static int firstInvalidCookieValueOctet(CharSequence paramCharSequence)
  {
    return firstInvalidOctet(paramCharSequence, VALID_COOKIE_VALUE_OCTETS);
  }
  
  static int firstInvalidOctet(CharSequence paramCharSequence, BitSet paramBitSet)
  {
    for (int i = 0; i < paramCharSequence.length(); i++) {
      if (!paramBitSet.get(paramCharSequence.charAt(i))) {
        return i;
      }
    }
    return -1;
  }
  
  static StringBuilder stringBuilder()
  {
    return InternalThreadLocalMap.get().stringBuilder();
  }
  
  static String stripTrailingSeparator(StringBuilder paramStringBuilder)
  {
    if (paramStringBuilder.length() > 0) {
      paramStringBuilder.setLength(paramStringBuilder.length() - 2);
    }
    return paramStringBuilder.toString();
  }
  
  static String stripTrailingSeparatorOrNull(StringBuilder paramStringBuilder)
  {
    if (paramStringBuilder.length() == 0) {
      paramStringBuilder = null;
    } else {
      paramStringBuilder = stripTrailingSeparator(paramStringBuilder);
    }
    return paramStringBuilder;
  }
  
  static CharSequence unwrapValue(CharSequence paramCharSequence)
  {
    int i = paramCharSequence.length();
    CharSequence localCharSequence = paramCharSequence;
    if (i > 0)
    {
      localCharSequence = paramCharSequence;
      if (paramCharSequence.charAt(0) == '"')
      {
        if (i >= 2)
        {
          int j = i - 1;
          if (paramCharSequence.charAt(j) == '"')
          {
            if (i == 2) {
              paramCharSequence = "";
            } else {
              paramCharSequence = paramCharSequence.subSequence(1, j);
            }
            return paramCharSequence;
          }
        }
        localCharSequence = null;
      }
    }
    return localCharSequence;
  }
  
  private static BitSet validCookieAttributeValueOctets()
  {
    BitSet localBitSet = new BitSet();
    for (int i = 32; i < 127; i++) {
      localBitSet.set(i);
    }
    localBitSet.set(59, false);
    return localBitSet;
  }
  
  private static BitSet validCookieNameOctets()
  {
    BitSet localBitSet = new BitSet();
    for (int i = 32; i < 127; i++) {
      localBitSet.set(i);
    }
    for (i = 0; i < 19; i++) {
      localBitSet.set(new int[] { 40, 41, 60, 62, 64, 44, 59, 58, 92, 34, 47, 91, 93, 63, 61, 123, 125, 32, 9 }[i], false);
    }
    return localBitSet;
  }
  
  private static BitSet validCookieValueOctets()
  {
    BitSet localBitSet = new BitSet();
    localBitSet.set(33);
    for (int i = 35; i <= 43; i++) {
      localBitSet.set(i);
    }
    for (i = 45; i <= 58; i++) {
      localBitSet.set(i);
    }
    for (i = 60; i <= 91; i++) {
      localBitSet.set(i);
    }
    for (i = 93; i <= 126; i++) {
      localBitSet.set(i);
    }
    return localBitSet;
  }
  
  static String validateAttributeValue(String paramString1, String paramString2)
  {
    if (paramString2 == null) {
      return null;
    }
    String str = paramString2.trim();
    if (str.isEmpty()) {
      return null;
    }
    int i = firstInvalidOctet(str, VALID_COOKIE_ATTRIBUTE_VALUE_OCTETS);
    if (i == -1) {
      return str;
    }
    paramString2 = new StringBuilder();
    paramString2.append(paramString1);
    paramString2.append(" contains the prohibited characters: ");
    paramString2.append(str.charAt(i));
    throw new IllegalArgumentException(paramString2.toString());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\cookie\CookieUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */