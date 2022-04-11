package org.bouncycastle.asn1.t2.f;

import java.util.Hashtable;
import org.bouncycastle.asn1.a1;
import org.bouncycastle.asn1.h;
import org.bouncycastle.asn1.m;
import org.bouncycastle.asn1.n2.g;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.u0;
import org.bouncycastle.asn1.x509.e0;

public class b
  extends a
{
  public static final m A;
  public static final m B;
  public static final m C;
  public static final m D;
  public static final m E;
  public static final m F;
  public static final m G;
  public static final m H;
  public static final m I;
  public static final m J;
  private static final Hashtable K;
  private static final Hashtable L;
  public static final org.bouncycastle.asn1.t2.e M = new b();
  public static final m a;
  public static final m b;
  public static final m c;
  public static final m d;
  public static final m e;
  public static final m f;
  public static final m g;
  public static final m h;
  public static final m i;
  public static final m j;
  public static final m k;
  public static final m l;
  public static final m m;
  public static final m n;
  public static final m o;
  public static final m p;
  public static final m q;
  public static final m r;
  public static final m s;
  public static final m t;
  public static final m u;
  public static final m v;
  public static final m w;
  public static final m x;
  public static final m y;
  public static final m z;
  protected final Hashtable N = a.h(L);
  protected final Hashtable O = a.h(K);
  
  static
  {
    m localm1 = new m("2.5.4.6").t();
    a = localm1;
    m localm2 = new m("2.5.4.10").t();
    b = localm2;
    m localm3 = new m("2.5.4.11").t();
    c = localm3;
    m localm4 = new m("2.5.4.12").t();
    d = localm4;
    m localm5 = new m("2.5.4.3").t();
    e = localm5;
    m localm6 = new m("2.5.4.5").t();
    f = localm6;
    m localm7 = new m("2.5.4.9").t();
    g = localm7;
    h = localm6;
    m localm8 = new m("2.5.4.7").t();
    i = localm8;
    m localm9 = new m("2.5.4.8").t();
    j = localm9;
    m localm10 = new m("2.5.4.4").t();
    k = localm10;
    m localm11 = new m("2.5.4.42").t();
    l = localm11;
    m localm12 = new m("2.5.4.43").t();
    m = localm12;
    m localm13 = new m("2.5.4.44").t();
    n = localm13;
    m localm14 = new m("2.5.4.45").t();
    o = localm14;
    m localm15 = new m("2.5.4.15").t();
    p = localm15;
    m localm16 = new m("2.5.4.17").t();
    q = localm16;
    m localm17 = new m("2.5.4.46").t();
    r = localm17;
    m localm18 = new m("2.5.4.65").t();
    s = localm18;
    m localm19 = new m("1.3.6.1.5.5.7.9.1").t();
    t = localm19;
    m localm20 = new m("1.3.6.1.5.5.7.9.2").t();
    u = localm20;
    m localm21 = new m("1.3.6.1.5.5.7.9.3").t();
    v = localm21;
    m localm22 = new m("1.3.6.1.5.5.7.9.4").t();
    w = localm22;
    m localm23 = new m("1.3.6.1.5.5.7.9.5").t();
    x = localm23;
    m localm24 = new m("1.3.36.8.3.14").t();
    y = localm24;
    m localm25 = new m("2.5.4.16").t();
    z = localm25;
    A = new m("2.5.4.54").t();
    m localm26 = e0.g;
    B = localm26;
    m localm27 = e0.h;
    C = localm27;
    m localm28 = e0.i;
    D = localm28;
    m localm29 = g.y0;
    E = localm29;
    m localm30 = g.z0;
    F = localm30;
    m localm31 = g.F0;
    G = localm31;
    H = localm29;
    m localm32 = new m("0.9.2342.19200300.100.1.25");
    I = localm32;
    m localm33 = new m("0.9.2342.19200300.100.1.1");
    J = localm33;
    Hashtable localHashtable1 = new Hashtable();
    K = localHashtable1;
    Hashtable localHashtable2 = new Hashtable();
    L = localHashtable2;
    localHashtable1.put(localm1, "C");
    localHashtable1.put(localm2, "O");
    localHashtable1.put(localm4, "T");
    localHashtable1.put(localm3, "OU");
    localHashtable1.put(localm5, "CN");
    localHashtable1.put(localm8, "L");
    localHashtable1.put(localm9, "ST");
    localHashtable1.put(localm6, "SERIALNUMBER");
    localHashtable1.put(localm29, "E");
    localHashtable1.put(localm32, "DC");
    localHashtable1.put(localm33, "UID");
    localHashtable1.put(localm7, "STREET");
    localHashtable1.put(localm10, "SURNAME");
    localHashtable1.put(localm11, "GIVENNAME");
    localHashtable1.put(localm12, "INITIALS");
    localHashtable1.put(localm13, "GENERATION");
    localHashtable1.put(localm31, "unstructuredAddress");
    localHashtable1.put(localm30, "unstructuredName");
    localHashtable1.put(localm14, "UniqueIdentifier");
    localHashtable1.put(localm17, "DN");
    localHashtable1.put(localm18, "Pseudonym");
    localHashtable1.put(localm25, "PostalAddress");
    localHashtable1.put(localm24, "NameAtBirth");
    localHashtable1.put(localm22, "CountryOfCitizenship");
    localHashtable1.put(localm23, "CountryOfResidence");
    localHashtable1.put(localm21, "Gender");
    localHashtable1.put(localm20, "PlaceOfBirth");
    localHashtable1.put(localm19, "DateOfBirth");
    localHashtable1.put(localm16, "PostalCode");
    localHashtable1.put(localm15, "BusinessCategory");
    localHashtable1.put(localm26, "TelephoneNumber");
    localHashtable1.put(localm27, "Name");
    localHashtable1.put(localm28, "organizationIdentifier");
    localHashtable2.put("c", localm1);
    localHashtable2.put("o", localm2);
    localHashtable2.put("t", localm4);
    localHashtable2.put("ou", localm3);
    localHashtable2.put("cn", localm5);
    localHashtable2.put("l", localm8);
    localHashtable2.put("st", localm9);
    localHashtable2.put("sn", localm6);
    localHashtable2.put("serialnumber", localm6);
    localHashtable2.put("street", localm7);
    localHashtable2.put("emailaddress", localm29);
    localHashtable2.put("dc", localm32);
    localHashtable2.put("e", localm29);
    localHashtable2.put("uid", localm33);
    localHashtable2.put("surname", localm10);
    localHashtable2.put("givenname", localm11);
    localHashtable2.put("initials", localm12);
    localHashtable2.put("generation", localm13);
    localHashtable2.put("unstructuredaddress", localm31);
    localHashtable2.put("unstructuredname", localm30);
    localHashtable2.put("uniqueidentifier", localm14);
    localHashtable2.put("dn", localm17);
    localHashtable2.put("pseudonym", localm18);
    localHashtable2.put("postaladdress", localm25);
    localHashtable2.put("nameofbirth", localm24);
    localHashtable2.put("countryofcitizenship", localm22);
    localHashtable2.put("countryofresidence", localm23);
    localHashtable2.put("gender", localm21);
    localHashtable2.put("placeofbirth", localm20);
    localHashtable2.put("dateofbirth", localm19);
    localHashtable2.put("postalcode", localm16);
    localHashtable2.put("businesscategory", localm15);
    localHashtable2.put("telephonenumber", localm26);
    localHashtable2.put("name", localm27);
    localHashtable2.put("organizationidentifier", localm28);
  }
  
  public org.bouncycastle.asn1.t2.b[] b(String paramString)
  {
    return c.k(paramString, this);
  }
  
  public m c(String paramString)
  {
    return c.g(paramString, this.N);
  }
  
  public String f(org.bouncycastle.asn1.t2.c paramc)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    paramc = paramc.i();
    int i1 = 1;
    for (int i2 = 0; i2 < paramc.length; i2++)
    {
      if (i1 != 0) {
        i1 = 0;
      } else {
        localStringBuffer.append(',');
      }
      c.a(localStringBuffer, paramc[i2], this.O);
    }
    return localStringBuffer.toString();
  }
  
  protected org.bouncycastle.asn1.e i(m paramm, String paramString)
  {
    if ((!paramm.equals(E)) && (!paramm.equals(I)))
    {
      if (paramm.equals(t)) {
        return new h(paramString);
      }
      if ((!paramm.equals(a)) && (!paramm.equals(f)) && (!paramm.equals(r)) && (!paramm.equals(B))) {
        return super.i(paramm, paramString);
      }
      return new a1(paramString);
    }
    return new u0(paramString);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\t2\f\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */