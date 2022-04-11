package io.netty.handler.codec.http.multipart;

import java.io.Serializable;
import java.util.Comparator;

final class CaseIgnoringComparator
  implements Comparator<CharSequence>, Serializable
{
  static final CaseIgnoringComparator INSTANCE = new CaseIgnoringComparator();
  private static final long serialVersionUID = 4582133183775373862L;
  
  private Object readResolve()
  {
    return INSTANCE;
  }
  
  public int compare(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    int i = paramCharSequence1.length();
    int j = paramCharSequence2.length();
    int k = Math.min(i, j);
    for (int m = 0; m < k; m++)
    {
      char c1 = paramCharSequence1.charAt(m);
      char c2 = paramCharSequence2.charAt(m);
      if (c1 != c2)
      {
        c1 = Character.toUpperCase(c1);
        c2 = Character.toUpperCase(c2);
        if (c1 != c2)
        {
          int n = Character.toLowerCase(c1);
          int i1 = Character.toLowerCase(c2);
          if (n != i1) {
            return n - i1;
          }
        }
      }
    }
    return i - j;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\multipart\CaseIgnoringComparator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */