package org.bouncycastle.asn1.z1;

import e.a.b.a.d.f;
import java.math.BigInteger;
import java.util.Hashtable;
import org.bouncycastle.asn1.m;
import org.bouncycastle.asn1.u2.j;
import org.bouncycastle.asn1.u2.k;
import org.bouncycastle.asn1.u2.l;
import org.bouncycastle.util.i;

public class a
{
  static k a = new a();
  static final Hashtable b = new Hashtable();
  static final Hashtable c = new Hashtable();
  static final Hashtable d = new Hashtable();
  
  static
  {
    d("FRP256v1", b.a, a);
  }
  
  private static e.a.b.a.d c(e.a.b.a.d paramd)
  {
    return paramd;
  }
  
  static void d(String paramString, m paramm, k paramk)
  {
    b.put(i.f(paramString), paramm);
    d.put(paramm, paramString);
    c.put(paramm, paramk);
  }
  
  private static BigInteger e(String paramString)
  {
    return new BigInteger(1, org.bouncycastle.util.encoders.d.a(paramString));
  }
  
  public static j f(String paramString)
  {
    paramString = i(paramString);
    if (paramString == null) {
      paramString = null;
    } else {
      paramString = g(paramString);
    }
    return paramString;
  }
  
  public static j g(m paramm)
  {
    paramm = (k)c.get(paramm);
    if (paramm == null) {
      paramm = null;
    } else {
      paramm = paramm.b();
    }
    return paramm;
  }
  
  public static String h(m paramm)
  {
    return (String)d.get(paramm);
  }
  
  public static m i(String paramString)
  {
    return (m)b.get(i.f(paramString));
  }
  
  static final class a
    extends k
  {
    protected j a()
    {
      BigInteger localBigInteger1 = a.a("F1FD178C0B3AD58F10126DE8CE42435B3961ADBCABC8CA6DE8FCF353D86E9C03");
      Object localObject = a.a("F1FD178C0B3AD58F10126DE8CE42435B3961ADBCABC8CA6DE8FCF353D86E9C00");
      BigInteger localBigInteger2 = a.a("EE353FCA5428A9300D4ABA754A44C00FDFEC0C9AE4B1A1803075ED967B7BB73F");
      BigInteger localBigInteger3 = a.a("F1FD178C0B3AD58F10126DE8CE42435B53DC67E140D2BF941FFDD459C6D655E1");
      BigInteger localBigInteger4 = BigInteger.valueOf(1L);
      localObject = a.b(new d.f(localBigInteger1, (BigInteger)localObject, localBigInteger2, localBigInteger3, localBigInteger4));
      return new j((e.a.b.a.d)localObject, new l((e.a.b.a.d)localObject, org.bouncycastle.util.encoders.d.a("04B6B3D4C356C139EB31183D4749D423958C27D2DCAF98B70164C97A2DD98F5CFF6142E0F7C8B204911F9271F0F3ECEF8C2701C307E8E4C9E183115A1554062CFB")), localBigInteger3, localBigInteger4, null);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\z1\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */