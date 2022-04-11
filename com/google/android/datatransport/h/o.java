package com.google.android.datatransport.h;

import com.google.android.datatransport.b;
import com.google.android.datatransport.d;
import com.google.android.datatransport.e;
import com.google.android.datatransport.f;
import java.util.Set;

final class o
  implements f
{
  private final Set<b> a;
  private final n b;
  private final q c;
  
  o(Set<b> paramSet, n paramn, q paramq)
  {
    this.a = paramSet;
    this.b = paramn;
    this.c = paramq;
  }
  
  public <T> e<T> a(String paramString, Class<T> paramClass, d<T, byte[]> paramd)
  {
    return b(paramString, paramClass, b.b("proto"), paramd);
  }
  
  public <T> e<T> b(String paramString, Class<T> paramClass, b paramb, d<T, byte[]> paramd)
  {
    if (this.a.contains(paramb)) {
      return new p(this.b, paramString, paramb, paramd, this.c);
    }
    throw new IllegalArgumentException(String.format("%s is not supported byt this factory. Supported encodings are: %s.", new Object[] { paramb, this.a }));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\datatransport\h\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */