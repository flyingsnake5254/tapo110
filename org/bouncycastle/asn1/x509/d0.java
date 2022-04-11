package org.bouncycastle.asn1.x509;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.bouncycastle.asn1.b1;
import org.bouncycastle.asn1.d1;
import org.bouncycastle.asn1.e;
import org.bouncycastle.asn1.f;
import org.bouncycastle.asn1.j1;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.m;
import org.bouncycastle.asn1.n2.g;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.r;
import org.bouncycastle.asn1.t;
import org.bouncycastle.asn1.t2.c;
import org.bouncycastle.asn1.w;
import org.bouncycastle.util.encoders.d;
import org.bouncycastle.util.i;

public class d0
  extends l
{
  public static final m H3;
  public static final m I3;
  public static final m J3;
  public static final m K3;
  public static final m L3;
  public static final m M3;
  public static final m N3;
  public static final m O3;
  public static final m P3;
  public static final m Q3;
  public static final m R3;
  public static final m S3;
  public static final m T3;
  public static final m U3;
  public static final m V3;
  public static final m W3;
  public static final m X3;
  public static final m Y3;
  public static final m Z3;
  public static final m a4;
  public static final m b4;
  public static final m c;
  public static final m c4;
  public static final m d;
  public static final m d4;
  public static final m e4;
  public static final m f;
  public static boolean f4;
  public static final Hashtable g4;
  public static final Hashtable h4;
  public static final Hashtable i4;
  public static final Hashtable j4;
  public static final Hashtable k4;
  public static final Hashtable l4;
  private static final Boolean m4;
  private static final Boolean n4;
  public static final m p0;
  public static final m p1;
  public static final m p2;
  public static final m p3;
  public static final m q;
  public static final m x;
  public static final m y;
  public static final m z;
  private Vector o4 = new Vector();
  private Vector p4 = new Vector();
  private Vector q4 = new Vector();
  private r r4;
  private boolean s4;
  private int t4;
  
  static
  {
    m localm1 = new m("2.5.4.6");
    c = localm1;
    m localm2 = new m("2.5.4.10");
    d = localm2;
    m localm3 = new m("2.5.4.11");
    f = localm3;
    m localm4 = new m("2.5.4.12");
    q = localm4;
    m localm5 = new m("2.5.4.3");
    x = localm5;
    m localm6 = new m("2.5.4.5");
    y = localm6;
    m localm7 = new m("2.5.4.9");
    z = localm7;
    p0 = localm6;
    m localm8 = new m("2.5.4.7");
    p1 = localm8;
    m localm9 = new m("2.5.4.8");
    p2 = localm9;
    m localm10 = new m("2.5.4.4");
    p3 = localm10;
    m localm11 = new m("2.5.4.42");
    H3 = localm11;
    m localm12 = new m("2.5.4.43");
    I3 = localm12;
    m localm13 = new m("2.5.4.44");
    J3 = localm13;
    m localm14 = new m("2.5.4.45");
    K3 = localm14;
    m localm15 = new m("2.5.4.15");
    L3 = localm15;
    m localm16 = new m("2.5.4.17");
    M3 = localm16;
    m localm17 = new m("2.5.4.46");
    N3 = localm17;
    m localm18 = new m("2.5.4.65");
    O3 = localm18;
    m localm19 = new m("1.3.6.1.5.5.7.9.1");
    P3 = localm19;
    m localm20 = new m("1.3.6.1.5.5.7.9.2");
    Q3 = localm20;
    m localm21 = new m("1.3.6.1.5.5.7.9.3");
    R3 = localm21;
    m localm22 = new m("1.3.6.1.5.5.7.9.4");
    S3 = localm22;
    m localm23 = new m("1.3.6.1.5.5.7.9.5");
    T3 = localm23;
    m localm24 = new m("1.3.36.8.3.14");
    U3 = localm24;
    m localm25 = new m("2.5.4.16");
    V3 = localm25;
    W3 = new m("2.5.4.54");
    m localm26 = e0.g;
    X3 = localm26;
    m localm27 = e0.h;
    Y3 = localm27;
    m localm28 = g.y0;
    Z3 = localm28;
    m localm29 = g.z0;
    a4 = localm29;
    m localm30 = g.F0;
    b4 = localm30;
    c4 = localm28;
    m localm31 = new m("0.9.2342.19200300.100.1.25");
    d4 = localm31;
    m localm32 = new m("0.9.2342.19200300.100.1.1");
    e4 = localm32;
    f4 = false;
    Hashtable localHashtable1 = new Hashtable();
    g4 = localHashtable1;
    Hashtable localHashtable2 = new Hashtable();
    h4 = localHashtable2;
    Hashtable localHashtable3 = new Hashtable();
    i4 = localHashtable3;
    Hashtable localHashtable4 = new Hashtable();
    j4 = localHashtable4;
    k4 = localHashtable1;
    l4 = localHashtable4;
    m4 = new Boolean(true);
    n4 = new Boolean(false);
    localHashtable1.put(localm1, "C");
    localHashtable1.put(localm2, "O");
    localHashtable1.put(localm4, "T");
    localHashtable1.put(localm3, "OU");
    localHashtable1.put(localm5, "CN");
    localHashtable1.put(localm8, "L");
    localHashtable1.put(localm9, "ST");
    localHashtable1.put(localm6, "SERIALNUMBER");
    localHashtable1.put(localm28, "E");
    localHashtable1.put(localm31, "DC");
    localHashtable1.put(localm32, "UID");
    localHashtable1.put(localm7, "STREET");
    localHashtable1.put(localm10, "SURNAME");
    localHashtable1.put(localm11, "GIVENNAME");
    localHashtable1.put(localm12, "INITIALS");
    localHashtable1.put(localm13, "GENERATION");
    localHashtable1.put(localm30, "unstructuredAddress");
    localHashtable1.put(localm29, "unstructuredName");
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
    localHashtable2.put(localm1, "C");
    localHashtable2.put(localm2, "O");
    localHashtable2.put(localm3, "OU");
    localHashtable2.put(localm5, "CN");
    localHashtable2.put(localm8, "L");
    localHashtable2.put(localm9, "ST");
    localHashtable2.put(localm7, "STREET");
    localHashtable2.put(localm31, "DC");
    localHashtable2.put(localm32, "UID");
    localHashtable3.put(localm1, "C");
    localHashtable3.put(localm2, "O");
    localHashtable3.put(localm3, "OU");
    localHashtable3.put(localm5, "CN");
    localHashtable3.put(localm8, "L");
    localHashtable3.put(localm9, "ST");
    localHashtable3.put(localm7, "STREET");
    localHashtable4.put("c", localm1);
    localHashtable4.put("o", localm2);
    localHashtable4.put("t", localm4);
    localHashtable4.put("ou", localm3);
    localHashtable4.put("cn", localm5);
    localHashtable4.put("l", localm8);
    localHashtable4.put("st", localm9);
    localHashtable4.put("sn", localm6);
    localHashtable4.put("serialnumber", localm6);
    localHashtable4.put("street", localm7);
    localHashtable4.put("emailaddress", localm28);
    localHashtable4.put("dc", localm31);
    localHashtable4.put("e", localm28);
    localHashtable4.put("uid", localm32);
    localHashtable4.put("surname", localm10);
    localHashtable4.put("givenname", localm11);
    localHashtable4.put("initials", localm12);
    localHashtable4.put("generation", localm13);
    localHashtable4.put("unstructuredaddress", localm30);
    localHashtable4.put("unstructuredname", localm29);
    localHashtable4.put("uniqueidentifier", localm14);
    localHashtable4.put("dn", localm17);
    localHashtable4.put("pseudonym", localm18);
    localHashtable4.put("postaladdress", localm25);
    localHashtable4.put("nameofbirth", localm24);
    localHashtable4.put("countryofcitizenship", localm22);
    localHashtable4.put("countryofresidence", localm23);
    localHashtable4.put("gender", localm21);
    localHashtable4.put("placeofbirth", localm20);
    localHashtable4.put("dateofbirth", localm19);
    localHashtable4.put("postalcode", localm16);
    localHashtable4.put("businesscategory", localm15);
    localHashtable4.put("telephonenumber", localm26);
    localHashtable4.put("name", localm27);
  }
  
  protected d0() {}
  
  public d0(r paramr)
  {
    this.r4 = paramr;
    Enumeration localEnumeration = paramr.q();
    if (localEnumeration.hasMoreElements())
    {
      t localt = t.n(((e)localEnumeration.nextElement()).c());
      int i = 0;
      while (i < localt.size())
      {
        paramr = r.m(localt.q(i).c());
        if (paramr.size() == 2)
        {
          this.o4.addElement(m.r(paramr.p(0)));
          paramr = paramr.p(1);
          Object localObject1;
          Object localObject2;
          if (((paramr instanceof w)) && (!(paramr instanceof j1)))
          {
            localObject1 = ((w)paramr).getString();
            if ((((String)localObject1).length() > 0) && (((String)localObject1).charAt(0) == '#'))
            {
              paramr = this.p4;
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("\\");
              ((StringBuilder)localObject2).append((String)localObject1);
              localObject1 = ((StringBuilder)localObject2).toString();
            }
            else
            {
              paramr = this.p4;
            }
            paramr.addElement(localObject1);
          }
          try
          {
            localObject2 = this.p4;
            localObject1 = new java/lang/StringBuilder;
            ((StringBuilder)localObject1).<init>();
            ((StringBuilder)localObject1).append("#");
            ((StringBuilder)localObject1).append(g(d.b(paramr.c().e("DER"))));
            ((Vector)localObject2).addElement(((StringBuilder)localObject1).toString());
            localObject1 = this.q4;
            if (i != 0) {
              paramr = m4;
            } else {
              paramr = n4;
            }
            ((Vector)localObject1).addElement(paramr);
            i++;
          }
          catch (IOException paramr)
          {
            throw new IllegalArgumentException("cannot encode value");
          }
        }
      }
      throw new IllegalArgumentException("badly sized pair");
    }
  }
  
  private void f(StringBuffer paramStringBuffer, Hashtable paramHashtable, m paramm, String paramString)
  {
    paramHashtable = (String)paramHashtable.get(paramm);
    if (paramHashtable == null) {
      paramHashtable = paramm.q();
    }
    paramStringBuffer.append(paramHashtable);
    paramStringBuffer.append('=');
    int i = paramStringBuffer.length();
    paramStringBuffer.append(paramString);
    int j = paramStringBuffer.length();
    int k = i;
    int m = j;
    if (paramString.length() >= 2)
    {
      k = i;
      m = j;
      if (paramString.charAt(0) == '\\')
      {
        k = i;
        m = j;
        if (paramString.charAt(1) == '#') {
          k = i + 2;
        }
      }
    }
    for (m = j;; m++)
    {
      i = m;
      if (k >= m) {
        break;
      }
      i = m;
      if (paramStringBuffer.charAt(k) != ' ') {
        break;
      }
      paramStringBuffer.insert(k, "\\");
      k += 2;
    }
    for (;;)
    {
      i--;
      m = k;
      j = i;
      if (i <= k) {
        break;
      }
      m = k;
      j = i;
      if (paramStringBuffer.charAt(i) != ' ') {
        break;
      }
      paramStringBuffer.insert(i, '\\');
    }
    while (m <= j)
    {
      k = paramStringBuffer.charAt(m);
      if ((k != 34) && (k != 92) && (k != 43) && (k != 44)) {}
      switch (k)
      {
      default: 
        m++;
        break;
      case 59: 
      case 60: 
      case 61: 
      case 62: 
        paramStringBuffer.insert(m, "\\");
        m += 2;
        j++;
      }
    }
  }
  
  private String g(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length;
    char[] arrayOfChar = new char[i];
    for (int j = 0; j != i; j++) {
      arrayOfChar[j] = ((char)(char)(paramArrayOfByte[j] & 0xFF));
    }
    return new String(arrayOfChar);
  }
  
  private String h(String paramString)
  {
    String str = i.f(paramString.trim());
    paramString = str;
    if (str.length() > 0)
    {
      paramString = str;
      if (str.charAt(0) == '#')
      {
        q localq = i(str);
        paramString = str;
        if ((localq instanceof w)) {
          paramString = i.f(((w)localq).getString().trim());
        }
      }
    }
    return paramString;
  }
  
  private q i(String paramString)
  {
    try
    {
      paramString = q.i(d.a(paramString.substring(1)));
      return paramString;
    }
    catch (IOException localIOException)
    {
      paramString = new StringBuilder();
      paramString.append("unknown encoding in name: ");
      paramString.append(localIOException);
      throw new IllegalStateException(paramString.toString());
    }
  }
  
  private boolean j(String paramString1, String paramString2)
  {
    paramString1 = h(paramString1);
    paramString2 = h(paramString2);
    return (paramString1.equals(paramString2)) || (l(paramString1).equals(l(paramString2)));
  }
  
  public static d0 k(Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof d0)))
    {
      if ((paramObject instanceof c)) {
        return new d0(r.m(((c)paramObject).c()));
      }
      return new d0(r.m(paramObject));
    }
    return (d0)paramObject;
  }
  
  private String l(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (paramString.length() != 0)
    {
      char c1 = paramString.charAt(0);
      localStringBuffer.append(c1);
      int i = 1;
      for (char c2 = c1; i < paramString.length(); c2 = c1)
      {
        c1 = paramString.charAt(i);
        if ((c2 != ' ') || (c1 != ' ')) {
          localStringBuffer.append(c1);
        }
        i++;
      }
    }
    return localStringBuffer.toString();
  }
  
  public q c()
  {
    if (this.r4 == null)
    {
      f localf = new f();
      Object localObject = new f();
      if (this.o4.size() == 0)
      {
        localf.a(new d1((f)localObject));
        this.r4 = new b1(localf);
      }
      else
      {
        new f().a((m)this.o4.elementAt(0));
        localObject = (String)this.p4.elementAt(0);
        throw null;
      }
    }
    return this.r4;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((!(paramObject instanceof d0)) && (!(paramObject instanceof r))) {
      return false;
    }
    Object localObject = ((e)paramObject).c();
    if (c().equals(localObject)) {
      return true;
    }
    try
    {
      d0 locald0 = k(paramObject);
      int i = this.o4.size();
      if (i != locald0.o4.size()) {
        return false;
      }
      localObject = new boolean[i];
      boolean bool = this.o4.elementAt(0).equals(locald0.o4.elementAt(0));
      int j = -1;
      int k;
      int m;
      if (bool)
      {
        j = i;
        k = 0;
        m = 1;
      }
      else
      {
        k = i - 1;
        m = -1;
      }
      while (k != j)
      {
        paramObject = (m)this.o4.elementAt(k);
        String str = (String)this.p4.elementAt(k);
        for (int n = 0; n < i; n++) {
          if ((localObject[n] == 0) && (((q)paramObject).equals((m)locald0.o4.elementAt(n))) && (j(str, (String)locald0.p4.elementAt(n))))
          {
            localObject[n] = 1;
            n = 1;
            break label244;
          }
        }
        n = 0;
        label244:
        if (n == 0) {
          return false;
        }
        k += m;
      }
      return true;
    }
    catch (IllegalArgumentException paramObject) {}
    return false;
  }
  
  public int hashCode()
  {
    if (this.s4) {
      return this.t4;
    }
    this.s4 = true;
    for (int i = 0; i != this.o4.size(); i++)
    {
      String str = l(h((String)this.p4.elementAt(i)));
      int j = this.t4 ^ this.o4.elementAt(i).hashCode();
      this.t4 = j;
      this.t4 = (str.hashCode() ^ j);
    }
    return this.t4;
  }
  
  public String m(boolean paramBoolean, Hashtable paramHashtable)
  {
    StringBuffer localStringBuffer1 = new StringBuffer();
    Vector localVector = new Vector();
    StringBuffer localStringBuffer2 = null;
    for (int i = 0; i < this.o4.size(); i++) {
      if (((Boolean)this.q4.elementAt(i)).booleanValue())
      {
        localStringBuffer2.append('+');
        f(localStringBuffer2, paramHashtable, (m)this.o4.elementAt(i), (String)this.p4.elementAt(i));
      }
      else
      {
        localStringBuffer2 = new StringBuffer();
        f(localStringBuffer2, paramHashtable, (m)this.o4.elementAt(i), (String)this.p4.elementAt(i));
        localVector.addElement(localStringBuffer2);
      }
    }
    int j = 1;
    int k = 1;
    if (paramBoolean) {
      for (i = localVector.size() - 1; i >= 0; i--)
      {
        if (k != 0) {
          k = 0;
        } else {
          localStringBuffer1.append(',');
        }
        localStringBuffer1.append(localVector.elementAt(i).toString());
      }
    }
    i = 0;
    k = j;
    while (i < localVector.size())
    {
      if (k != 0) {
        k = 0;
      } else {
        localStringBuffer1.append(',');
      }
      localStringBuffer1.append(localVector.elementAt(i).toString());
      i++;
    }
    return localStringBuffer1.toString();
  }
  
  public String toString()
  {
    return m(f4, g4);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\x509\d0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */