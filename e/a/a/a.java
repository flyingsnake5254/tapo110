package e.a.a;

import org.bouncycastle.asn1.m;
import org.bouncycastle.crypto.w.n;

public class a
{
  public static org.bouncycastle.jce.spec.b a(String paramString)
  {
    n localn = org.bouncycastle.asn1.d2.b.a(paramString);
    Object localObject = localn;
    if (localn == null) {
      try
      {
        localObject = new org/bouncycastle/asn1/m;
        ((m)localObject).<init>(paramString);
        localObject = org.bouncycastle.asn1.d2.b.b((m)localObject);
      }
      catch (IllegalArgumentException paramString)
      {
        return null;
      }
    }
    if (localObject == null) {
      return null;
    }
    return new org.bouncycastle.jce.spec.b(paramString, ((n)localObject).a(), ((n)localObject).b(), ((n)localObject).e(), ((n)localObject).c(), ((n)localObject).f());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */