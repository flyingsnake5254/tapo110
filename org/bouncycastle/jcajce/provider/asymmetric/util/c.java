package org.bouncycastle.jcajce.provider.asymmetric.util;

import org.bouncycastle.asn1.e;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.n2.h;
import org.bouncycastle.asn1.x509.a;
import org.bouncycastle.asn1.x509.w;

public class c
{
  public static byte[] a(h paramh)
  {
    try
    {
      paramh = paramh.e("DER");
      return paramh;
    }
    catch (Exception paramh) {}
    return null;
  }
  
  public static byte[] b(a parama, e parame)
  {
    try
    {
      h localh = new org/bouncycastle/asn1/n2/h;
      localh.<init>(parama, parame.c());
      parama = a(localh);
      return parama;
    }
    catch (Exception parama) {}
    return null;
  }
  
  public static byte[] c(a parama, e parame)
  {
    try
    {
      w localw = new org/bouncycastle/asn1/x509/w;
      localw.<init>(parama, parame);
      parama = d(localw);
      return parama;
    }
    catch (Exception parama) {}
    return null;
  }
  
  public static byte[] d(w paramw)
  {
    try
    {
      paramw = paramw.e("DER");
      return paramw;
    }
    catch (Exception paramw) {}
    return null;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\jcajce\provider\asymmetric\util\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */