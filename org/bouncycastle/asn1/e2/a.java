package org.bouncycastle.asn1.e2;

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
  static k b = new b();
  static final Hashtable c = new Hashtable();
  static final Hashtable d = new Hashtable();
  static final Hashtable e = new Hashtable();
  
  static
  {
    d("wapip192v1", b.J, b);
    d("sm2p256v1", b.F, a);
  }
  
  private static e.a.b.a.d c(e.a.b.a.d paramd)
  {
    return paramd;
  }
  
  static void d(String paramString, m paramm, k paramk)
  {
    c.put(i.f(paramString), paramm);
    e.put(paramm, paramString);
    d.put(paramm, paramk);
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
    paramm = (k)d.get(paramm);
    if (paramm == null) {
      paramm = null;
    } else {
      paramm = paramm.b();
    }
    return paramm;
  }
  
  public static String h(m paramm)
  {
    return (String)e.get(paramm);
  }
  
  public static m i(String paramString)
  {
    return (m)c.get(i.f(paramString));
  }
  
  static final class a
    extends k
  {
    protected j a()
    {
      Object localObject = a.a("FFFFFFFEFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF00000000FFFFFFFFFFFFFFFF");
      BigInteger localBigInteger1 = a.a("FFFFFFFEFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF00000000FFFFFFFFFFFFFFFC");
      BigInteger localBigInteger2 = a.a("28E9FA9E9D9F5E344D5A9E4BCF6509A7F39789F515AB8F92DDBCBD414D940E93");
      BigInteger localBigInteger3 = a.a("FFFFFFFEFFFFFFFFFFFFFFFFFFFFFFFF7203DF6B21C6052B53BBF40939D54123");
      BigInteger localBigInteger4 = BigInteger.valueOf(1L);
      localObject = a.b(new d.f((BigInteger)localObject, localBigInteger1, localBigInteger2, localBigInteger3, localBigInteger4));
      return new j((e.a.b.a.d)localObject, new l((e.a.b.a.d)localObject, org.bouncycastle.util.encoders.d.a("0432C4AE2C1F1981195F9904466A39C9948FE30BBFF2660BE1715A4589334C74C7BC3736A2F4F6779C59BDCEE36B692153D0A9877CC62A474002DF32E52139F0A0")), localBigInteger3, localBigInteger4, null);
    }
  }
  
  static final class b
    extends k
  {
    protected j a()
    {
      BigInteger localBigInteger1 = a.a("BDB6F4FE3E8B1D9E0DA8C0D46F4C318CEFE4AFE3B6B8551F");
      Object localObject = a.a("BB8E5E8FBC115E139FE6A814FE48AAA6F0ADA1AA5DF91985");
      BigInteger localBigInteger2 = a.a("1854BEBDC31B21B7AEFC80AB0ECD10D5B1B3308E6DBF11C1");
      BigInteger localBigInteger3 = a.a("BDB6F4FE3E8B1D9E0DA8C0D40FC962195DFAE76F56564677");
      BigInteger localBigInteger4 = BigInteger.valueOf(1L);
      localObject = a.b(new d.f(localBigInteger1, (BigInteger)localObject, localBigInteger2, localBigInteger3, localBigInteger4));
      return new j((e.a.b.a.d)localObject, new l((e.a.b.a.d)localObject, org.bouncycastle.util.encoders.d.a("044AD5F7048DE709AD51236DE65E4D4B482C836DC6E410664002BB3A02D4AAADACAE24817A4CA3A1B014B5270432DB27D2")), localBigInteger3, localBigInteger4, null);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\e2\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */