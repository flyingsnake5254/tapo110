package org.bouncycastle.cert;

import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.bouncycastle.asn1.b;
import org.bouncycastle.asn1.b1;
import org.bouncycastle.asn1.e;
import org.bouncycastle.asn1.f;
import org.bouncycastle.asn1.n0;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.v0;
import org.bouncycastle.asn1.x509.m;
import org.bouncycastle.asn1.x509.y;
import org.bouncycastle.asn1.z0;

class c
{
  private static Set a = Collections.unmodifiableSet(new HashSet());
  private static List b = Collections.unmodifiableList(new ArrayList());
  
  static boolean[] a(n0 paramn0)
  {
    if (paramn0 != null)
    {
      byte[] arrayOfByte = paramn0.o();
      int i = arrayOfByte.length * 8 - paramn0.q();
      paramn0 = new boolean[i];
      for (int j = 0; j != i; j++)
      {
        int k;
        if ((arrayOfByte[(j / 8)] & 128 >>> j % 8) != 0) {
          k = 1;
        } else {
          k = 0;
        }
        paramn0[j] = k;
      }
      return paramn0;
    }
    return null;
  }
  
  static X509CertificateHolder b(org.bouncycastle.operator.a parama, y paramy)
  {
    try
    {
      parama = new X509CertificateHolder(d(paramy, parama.a(), c(parama, paramy)));
      return parama;
    }
    catch (IOException parama)
    {
      throw new IllegalStateException("cannot produce certificate signature");
    }
  }
  
  private static byte[] c(org.bouncycastle.operator.a parama, e parame)
    throws IOException
  {
    OutputStream localOutputStream = parama.getOutputStream();
    new z0(localOutputStream).j(parame);
    localOutputStream.close();
    return parama.b();
  }
  
  private static org.bouncycastle.asn1.x509.h d(y paramy, org.bouncycastle.asn1.x509.a parama, byte[] paramArrayOfByte)
  {
    f localf = new f();
    localf.a(paramy);
    localf.a(parama);
    localf.a(new n0(paramArrayOfByte));
    return org.bouncycastle.asn1.x509.h.g(new b1(localf));
  }
  
  static Set e(m paramm)
  {
    if (paramm == null) {
      return a;
    }
    return Collections.unmodifiableSet(new HashSet(Arrays.asList(paramm.f())));
  }
  
  static List f(m paramm)
  {
    if (paramm == null) {
      return b;
    }
    return Collections.unmodifiableList(Arrays.asList(paramm.h()));
  }
  
  static Set g(m paramm)
  {
    if (paramm == null) {
      return a;
    }
    return Collections.unmodifiableSet(new HashSet(Arrays.asList(paramm.l())));
  }
  
  static boolean h(org.bouncycastle.asn1.x509.a parama1, org.bouncycastle.asn1.x509.a parama2)
  {
    if (!parama1.f().equals(parama2.f())) {
      return false;
    }
    if (parama1.i() == null) {
      return (parama2.i() == null) || (parama2.i().equals(v0.c));
    }
    if (parama2.i() == null) {
      return (parama1.i() == null) || (parama1.i().equals(v0.c));
    }
    return parama1.i().equals(parama2.i());
  }
  
  static q i(byte[] paramArrayOfByte)
    throws IOException
  {
    paramArrayOfByte = q.i(paramArrayOfByte);
    if (paramArrayOfByte != null) {
      return paramArrayOfByte;
    }
    throw new IOException("no content found");
  }
  
  static Date j(org.bouncycastle.asn1.h paramh)
  {
    try
    {
      paramh = paramh.o();
      return paramh;
    }
    catch (ParseException paramh)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("unable to recover date: ");
      localStringBuilder.append(paramh.getMessage());
      throw new IllegalStateException(localStringBuilder.toString());
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\cert\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */