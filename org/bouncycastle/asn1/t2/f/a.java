package org.bouncycastle.asn1.t2.f;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;
import org.bouncycastle.asn1.ASN1ParsingException;
import org.bouncycastle.asn1.i1;
import org.bouncycastle.asn1.m;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.t2.b;

public abstract class a
  implements org.bouncycastle.asn1.t2.e
{
  private int g(org.bouncycastle.asn1.e parame)
  {
    return c.e(c.q(parame)).hashCode();
  }
  
  public static Hashtable h(Hashtable paramHashtable)
  {
    Hashtable localHashtable = new Hashtable();
    Enumeration localEnumeration = paramHashtable.keys();
    while (localEnumeration.hasMoreElements())
    {
      Object localObject = localEnumeration.nextElement();
      localHashtable.put(localObject, paramHashtable.get(localObject));
    }
    return localHashtable;
  }
  
  private boolean j(boolean paramBoolean, b paramb, b[] paramArrayOfb)
  {
    if (paramBoolean) {
      for (i = paramArrayOfb.length - 1; i >= 0; i--) {
        if ((paramArrayOfb[i] != null) && (k(paramb, paramArrayOfb[i])))
        {
          paramArrayOfb[i] = null;
          return true;
        }
      }
    }
    for (int i = 0; i != paramArrayOfb.length; i++) {
      if ((paramArrayOfb[i] != null) && (k(paramb, paramArrayOfb[i])))
      {
        paramArrayOfb[i] = null;
        return true;
      }
    }
    return false;
  }
  
  public boolean a(org.bouncycastle.asn1.t2.c paramc1, org.bouncycastle.asn1.t2.c paramc2)
  {
    paramc1 = paramc1.i();
    paramc2 = paramc2.i();
    if (paramc1.length != paramc2.length) {
      return false;
    }
    boolean bool;
    if ((paramc1[0].f() != null) && (paramc2[0].f() != null)) {
      bool = paramc1[0].f().g().equals(paramc2[0].f().g()) ^ true;
    } else {
      bool = false;
    }
    for (int i = 0; i != paramc1.length; i++) {
      if (!j(bool, paramc1[i], paramc2)) {
        return false;
      }
    }
    return true;
  }
  
  public int d(org.bouncycastle.asn1.t2.c paramc)
  {
    paramc = paramc.i();
    int i = 0;
    int j = 0;
    while (i != paramc.length)
    {
      if (paramc[i].i())
      {
        org.bouncycastle.asn1.t2.a[] arrayOfa = paramc[i].h();
        int k = 0;
        int m = j;
        for (;;)
        {
          j = m;
          if (k == arrayOfa.length) {
            break;
          }
          m = m ^ arrayOfa[k].g().hashCode() ^ g(arrayOfa[k].h());
          k++;
        }
      }
      j = j ^ paramc[i].f().g().hashCode() ^ g(paramc[i].f().h());
      i++;
    }
    return j;
  }
  
  public org.bouncycastle.asn1.e e(m paramm, String paramString)
  {
    if ((paramString.length() != 0) && (paramString.charAt(0) == '#')) {
      try
      {
        paramString = c.p(paramString, 1);
        return paramString;
      }
      catch (IOException paramString)
      {
        paramString = new StringBuilder();
        paramString.append("can't recode value for oid ");
        paramString.append(paramm.q());
        throw new ASN1ParsingException(paramString.toString());
      }
    }
    String str = paramString;
    if (paramString.length() != 0)
    {
      str = paramString;
      if (paramString.charAt(0) == '\\') {
        str = paramString.substring(1);
      }
    }
    return i(paramm, str);
  }
  
  protected org.bouncycastle.asn1.e i(m paramm, String paramString)
  {
    return new i1(paramString);
  }
  
  protected boolean k(b paramb1, b paramb2)
  {
    return c.j(paramb1, paramb2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\t2\f\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */