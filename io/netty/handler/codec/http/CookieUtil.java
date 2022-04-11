package io.netty.handler.codec.http;

import java.util.BitSet;

@Deprecated
final class CookieUtil
{
  private static final BitSet VALID_COOKIE_NAME_OCTETS;
  private static final BitSet VALID_COOKIE_VALUE_OCTETS;
  
  static
  {
    BitSet localBitSet = validCookieValueOctets();
    VALID_COOKIE_VALUE_OCTETS = localBitSet;
    VALID_COOKIE_NAME_OCTETS = validCookieNameOctets(localBitSet);
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
  
  private static BitSet validCookieNameOctets(BitSet paramBitSet)
  {
    BitSet localBitSet = new BitSet(8);
    localBitSet.or(paramBitSet);
    localBitSet.set(40, false);
    localBitSet.set(41, false);
    localBitSet.set(60, false);
    localBitSet.set(62, false);
    localBitSet.set(64, false);
    localBitSet.set(58, false);
    localBitSet.set(47, false);
    localBitSet.set(91, false);
    localBitSet.set(93, false);
    localBitSet.set(63, false);
    localBitSet.set(61, false);
    localBitSet.set(123, false);
    localBitSet.set(125, false);
    localBitSet.set(32, false);
    localBitSet.set(9, false);
    return localBitSet;
  }
  
  private static BitSet validCookieValueOctets()
  {
    BitSet localBitSet = new BitSet(8);
    for (int i = 35; i < 127; i++) {
      localBitSet.set(i);
    }
    localBitSet.set(34, false);
    localBitSet.set(44, false);
    localBitSet.set(59, false);
    localBitSet.set(92, false);
    return localBitSet;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\CookieUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */