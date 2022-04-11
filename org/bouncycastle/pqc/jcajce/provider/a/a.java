package org.bouncycastle.pqc.jcajce.provider.a;

import org.bouncycastle.asn1.e;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.x509.w;

public class a
{
  public static byte[] a(org.bouncycastle.asn1.x509.a parama, e parame)
  {
    try
    {
      w localw = new org/bouncycastle/asn1/x509/w;
      localw.<init>(parama, parame);
      parama = b(localw);
      return parama;
    }
    catch (Exception parama) {}
    return null;
  }
  
  public static byte[] b(w paramw)
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\pqc\jcajce\provider\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */