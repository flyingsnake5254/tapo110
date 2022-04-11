package org.bouncycastle.pqc.jcajce.provider.mceliece;

import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.v0;
import org.bouncycastle.crypto.g;

class c
{
  static org.bouncycastle.asn1.x509.a a(String paramString)
  {
    if (paramString.equals("SHA-1")) {
      return new org.bouncycastle.asn1.x509.a(org.bouncycastle.asn1.m2.b.i, v0.c);
    }
    if (paramString.equals("SHA-224")) {
      return new org.bouncycastle.asn1.x509.a(org.bouncycastle.asn1.j2.b.f, v0.c);
    }
    if (paramString.equals("SHA-256")) {
      return new org.bouncycastle.asn1.x509.a(org.bouncycastle.asn1.j2.b.c, v0.c);
    }
    if (paramString.equals("SHA-384")) {
      return new org.bouncycastle.asn1.x509.a(org.bouncycastle.asn1.j2.b.d, v0.c);
    }
    if (paramString.equals("SHA-512")) {
      return new org.bouncycastle.asn1.x509.a(org.bouncycastle.asn1.j2.b.e, v0.c);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("unrecognised digest algorithm: ");
    localStringBuilder.append(paramString);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  static g b(org.bouncycastle.asn1.x509.a parama)
  {
    if (parama.f().equals(org.bouncycastle.asn1.m2.b.i)) {
      return org.bouncycastle.crypto.util.a.a();
    }
    if (parama.f().equals(org.bouncycastle.asn1.j2.b.f)) {
      return org.bouncycastle.crypto.util.a.b();
    }
    if (parama.f().equals(org.bouncycastle.asn1.j2.b.c)) {
      return org.bouncycastle.crypto.util.a.c();
    }
    if (parama.f().equals(org.bouncycastle.asn1.j2.b.d)) {
      return org.bouncycastle.crypto.util.a.d();
    }
    if (parama.f().equals(org.bouncycastle.asn1.j2.b.e)) {
      return org.bouncycastle.crypto.util.a.e();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("unrecognised OID in digest algorithm identifier: ");
    localStringBuilder.append(parama.f());
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\pqc\jcajce\provider\mceliece\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */