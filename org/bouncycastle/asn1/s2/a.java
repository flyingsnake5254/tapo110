package org.bouncycastle.asn1.s2;

import java.io.IOException;
import java.util.Enumeration;
import org.bouncycastle.asn1.a1;
import org.bouncycastle.asn1.b;
import org.bouncycastle.asn1.b1;
import org.bouncycastle.asn1.c;
import org.bouncycastle.asn1.c0;
import org.bouncycastle.asn1.e;
import org.bouncycastle.asn1.e0;
import org.bouncycastle.asn1.f1;
import org.bouncycastle.asn1.g;
import org.bouncycastle.asn1.g0;
import org.bouncycastle.asn1.h;
import org.bouncycastle.asn1.i0;
import org.bouncycastle.asn1.i1;
import org.bouncycastle.asn1.j;
import org.bouncycastle.asn1.k1;
import org.bouncycastle.asn1.l0;
import org.bouncycastle.asn1.l1;
import org.bouncycastle.asn1.m;
import org.bouncycastle.asn1.m0;
import org.bouncycastle.asn1.n;
import org.bouncycastle.asn1.n0;
import org.bouncycastle.asn1.o0;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.r;
import org.bouncycastle.asn1.t;
import org.bouncycastle.asn1.t0;
import org.bouncycastle.asn1.u0;
import org.bouncycastle.asn1.v0;
import org.bouncycastle.asn1.x;
import org.bouncycastle.asn1.y;
import org.bouncycastle.asn1.z;
import org.bouncycastle.util.encoders.d;
import org.bouncycastle.util.i;

public class a
{
  static void a(String paramString, boolean paramBoolean, q paramq, StringBuffer paramStringBuffer)
  {
    String str = i.d();
    Object localObject1;
    Object localObject2;
    if ((paramq instanceof r))
    {
      localObject1 = ((r)paramq).q();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append("    ");
      localObject2 = ((StringBuilder)localObject2).toString();
      paramStringBuffer.append(paramString);
      if ((paramq instanceof e0)) {
        paramString = "BER Sequence";
      }
      for (;;)
      {
        paramStringBuffer.append(paramString);
        break;
        if ((paramq instanceof b1)) {
          paramString = "DER Sequence";
        } else {
          paramString = "Sequence";
        }
      }
      for (;;)
      {
        paramStringBuffer.append(str);
        for (;;)
        {
          if (!((Enumeration)localObject1).hasMoreElements()) {
            break label1777;
          }
          paramString = ((Enumeration)localObject1).nextElement();
          if ((paramString == null) || (paramString.equals(v0.c))) {
            break;
          }
          if ((paramString instanceof q)) {
            paramString = (q)paramString;
          } else {
            paramString = ((e)paramString).c();
          }
          a((String)localObject2, paramBoolean, paramString, paramStringBuffer);
        }
        paramStringBuffer.append((String)localObject2);
        paramStringBuffer.append("NULL");
      }
    }
    if ((paramq instanceof x))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append("    ");
      localObject1 = ((StringBuilder)localObject1).toString();
      paramStringBuffer.append(paramString);
      if ((paramq instanceof i0)) {
        paramString = "BER Tagged [";
      } else {
        paramString = "Tagged [";
      }
      paramStringBuffer.append(paramString);
      paramString = (x)paramq;
      paramStringBuffer.append(Integer.toString(paramString.p()));
      paramStringBuffer.append(']');
      if (!paramString.q()) {
        paramStringBuffer.append(" IMPLICIT ");
      }
      paramStringBuffer.append(str);
      if (paramString.isEmpty())
      {
        paramStringBuffer.append((String)localObject1);
        paramStringBuffer.append("EMPTY");
      }
    }
    do
    {
      paramStringBuffer.append(str);
      break label1777;
      a((String)localObject1, paramBoolean, paramString.o(), paramStringBuffer);
      break label1777;
      if ((paramq instanceof t))
      {
        localObject1 = ((t)paramq).r();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramString);
        ((StringBuilder)localObject2).append("    ");
        localObject2 = ((StringBuilder)localObject2).toString();
        paramStringBuffer.append(paramString);
        if ((paramq instanceof g0)) {
          paramString = "BER Set";
        } else {
          paramString = "DER Set";
        }
        paramStringBuffer.append(paramString);
        paramStringBuffer.append(str);
        for (;;)
        {
          if (!((Enumeration)localObject1).hasMoreElements()) {
            break label1777;
          }
          paramString = ((Enumeration)localObject1).nextElement();
          if (paramString == null)
          {
            paramStringBuffer.append((String)localObject2);
            paramStringBuffer.append("NULL");
            break;
          }
          if ((paramString instanceof q)) {
            paramString = (q)paramString;
          } else {
            paramString = ((e)paramString).c();
          }
          a((String)localObject2, paramBoolean, paramString, paramStringBuffer);
        }
      }
      if (!(paramq instanceof n)) {
        break;
      }
      localObject1 = (n)paramq;
      int i;
      if ((paramq instanceof c0))
      {
        paramq = new StringBuilder();
        paramq.append(paramString);
        paramq.append("BER Constructed Octet String[");
        i = ((n)localObject1).o().length;
      }
      else
      {
        paramq = new StringBuilder();
        paramq.append(paramString);
        paramq.append("DER Octet String[");
        i = ((n)localObject1).o().length;
      }
      paramq.append(i);
      paramq.append("] ");
      paramStringBuffer.append(paramq.toString());
    } while (!paramBoolean);
    paramString = e(paramString, ((n)localObject1).o());
    break label691;
    if ((paramq instanceof m))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append("ObjectIdentifier(");
      ((StringBuilder)localObject1).append(((m)paramq).q());
      paramString = (String)localObject1;
      label672:
      paramString.append(")");
    }
    for (;;)
    {
      paramString.append(str);
      paramString = paramString.toString();
      label691:
      paramStringBuffer.append(paramString);
      break label1777;
      if ((paramq instanceof c))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append("Boolean(");
        ((StringBuilder)localObject1).append(((c)paramq).q());
        paramString = (String)localObject1;
        break label672;
      }
      if ((paramq instanceof j))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append("Integer(");
        paramq = ((j)paramq).p();
      }
      for (paramString = (String)localObject1;; paramString = (String)localObject1)
      {
        paramString.append(paramq);
        break label672;
        if ((paramq instanceof n0))
        {
          paramq = (n0)paramq;
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(paramString);
          ((StringBuilder)localObject1).append("DER Bit String[");
          ((StringBuilder)localObject1).append(paramq.o().length);
          ((StringBuilder)localObject1).append(", ");
          ((StringBuilder)localObject1).append(paramq.q());
          ((StringBuilder)localObject1).append("] ");
          paramStringBuffer.append(((StringBuilder)localObject1).toString());
          if (!paramBoolean) {
            break;
          }
          paramString = e(paramString, paramq.o());
          break label691;
        }
        if ((paramq instanceof u0))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(paramString);
          ((StringBuilder)localObject1).append("IA5String(");
          paramq = ((u0)paramq).getString();
          paramString = (String)localObject1;
        }
        for (;;)
        {
          paramString.append(paramq);
          paramString.append(") ");
          break;
          if ((paramq instanceof i1))
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(paramString);
            ((StringBuilder)localObject1).append("UTF8String(");
            paramq = ((i1)paramq).getString();
            paramString = (String)localObject1;
          }
          else if ((paramq instanceof a1))
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(paramString);
            ((StringBuilder)localObject1).append("PrintableString(");
            paramq = ((a1)paramq).getString();
            paramString = (String)localObject1;
          }
          else if ((paramq instanceof l1))
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(paramString);
            ((StringBuilder)localObject1).append("VisibleString(");
            paramq = ((l1)paramq).getString();
            paramString = (String)localObject1;
          }
          else if ((paramq instanceof m0))
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(paramString);
            ((StringBuilder)localObject1).append("BMPString(");
            paramq = ((m0)paramq).getString();
            paramString = (String)localObject1;
          }
          else if ((paramq instanceof f1))
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(paramString);
            ((StringBuilder)localObject1).append("T61String(");
            paramq = ((f1)paramq).getString();
            paramString = (String)localObject1;
          }
          else if ((paramq instanceof t0))
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(paramString);
            ((StringBuilder)localObject1).append("GraphicString(");
            paramq = ((t0)paramq).getString();
            paramString = (String)localObject1;
          }
          else if ((paramq instanceof k1))
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(paramString);
            ((StringBuilder)localObject1).append("VideotexString(");
            paramq = ((k1)paramq).getString();
            paramString = (String)localObject1;
          }
          else if ((paramq instanceof y))
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(paramString);
            ((StringBuilder)localObject1).append("UTCTime(");
            paramq = ((y)paramq).p();
            paramString = (String)localObject1;
          }
          else
          {
            if (!(paramq instanceof h)) {
              break label1363;
            }
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(paramString);
            ((StringBuilder)localObject1).append("GeneralizedTime(");
            paramq = ((h)paramq).q();
            paramString = (String)localObject1;
          }
        }
        label1363:
        if ((paramq instanceof z)) {}
        for (localObject1 = "BER";; localObject1 = "DER")
        {
          paramString = f((String)localObject1, paramString, paramBoolean, paramq, str);
          break;
          if (!(paramq instanceof l0)) {
            break label1402;
          }
        }
        label1402:
        if (!(paramq instanceof g)) {
          break label1449;
        }
        paramq = (g)paramq;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append("DER Enumerated(");
        paramq = paramq.o();
      }
      label1449:
      if ((paramq instanceof o0))
      {
        paramq = (o0)paramq;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append("External ");
        ((StringBuilder)localObject1).append(str);
        paramStringBuffer.append(((StringBuilder)localObject1).toString());
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append("    ");
        paramString = ((StringBuilder)localObject1).toString();
        if (paramq.n() != null)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(paramString);
          ((StringBuilder)localObject1).append("Direct Reference: ");
          ((StringBuilder)localObject1).append(paramq.n().q());
          ((StringBuilder)localObject1).append(str);
          paramStringBuffer.append(((StringBuilder)localObject1).toString());
        }
        if (paramq.q() != null)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(paramString);
          ((StringBuilder)localObject1).append("Indirect Reference: ");
          ((StringBuilder)localObject1).append(paramq.q().toString());
          ((StringBuilder)localObject1).append(str);
          paramStringBuffer.append(((StringBuilder)localObject1).toString());
        }
        if (paramq.m() != null) {
          a(paramString, paramBoolean, paramq.m(), paramStringBuffer);
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append("Encoding: ");
        ((StringBuilder)localObject1).append(paramq.o());
        ((StringBuilder)localObject1).append(str);
        paramStringBuffer.append(((StringBuilder)localObject1).toString());
        paramq = paramq.p();
      }
      try
      {
        a(paramString, paramBoolean, paramq, paramStringBuffer);
        break label1777;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append(paramq.toString());
        paramString = (String)localObject1;
        continue;
        label1777:
        return;
      }
      finally {}
    }
  }
  
  private static String b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    for (int i = paramInt1; i != paramInt1 + paramInt2; i++) {
      if ((paramArrayOfByte[i] >= 32) && (paramArrayOfByte[i] <= 126)) {
        localStringBuffer.append((char)paramArrayOfByte[i]);
      }
    }
    return localStringBuffer.toString();
  }
  
  public static String c(Object paramObject)
  {
    return d(paramObject, false);
  }
  
  public static String d(Object paramObject, boolean paramBoolean)
  {
    Object localObject = new StringBuffer();
    if ((paramObject instanceof q)) {}
    for (paramObject = (q)paramObject;; paramObject = ((e)paramObject).c())
    {
      a("", paramBoolean, (q)paramObject, (StringBuffer)localObject);
      break;
      if (!(paramObject instanceof e)) {
        break label57;
      }
    }
    return ((StringBuffer)localObject).toString();
    label57:
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("unknown object type ");
    ((StringBuilder)localObject).append(paramObject.toString());
    return ((StringBuilder)localObject).toString();
  }
  
  private static String e(String paramString, byte[] paramArrayOfByte)
  {
    String str = i.d();
    StringBuffer localStringBuffer = new StringBuffer();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("    ");
    localObject = ((StringBuilder)localObject).toString();
    localStringBuffer.append(str);
    for (int i = 0; i < paramArrayOfByte.length; i += 32)
    {
      int j = paramArrayOfByte.length;
      localStringBuffer.append((String)localObject);
      if (j - i > 32)
      {
        localStringBuffer.append(i.b(d.c(paramArrayOfByte, i, 32)));
        localStringBuffer.append("    ");
      }
      for (paramString = b(paramArrayOfByte, i, 32);; paramString = b(paramArrayOfByte, i, paramArrayOfByte.length - i))
      {
        localStringBuffer.append(paramString);
        localStringBuffer.append(str);
        break;
        localStringBuffer.append(i.b(d.c(paramArrayOfByte, i, paramArrayOfByte.length - i)));
        for (j = paramArrayOfByte.length - i; j != 32; j++) {
          localStringBuffer.append("  ");
        }
        localStringBuffer.append("    ");
      }
    }
    return localStringBuffer.toString();
  }
  
  private static String f(String paramString1, String paramString2, boolean paramBoolean, q paramq, String paramString3)
  {
    org.bouncycastle.asn1.a locala = org.bouncycastle.asn1.a.o(paramq);
    paramq = new StringBuffer();
    if (locala.j()) {
      try
      {
        r localr = r.m(locala.p(16));
        StringBuilder localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>();
        localStringBuilder.append(paramString2);
        localStringBuilder.append(paramString1);
        localStringBuilder.append(" ApplicationSpecific[");
        localStringBuilder.append(locala.m());
        localStringBuilder.append("]");
        localStringBuilder.append(paramString3);
        paramq.append(localStringBuilder.toString());
        paramString3 = localr.q();
        while (paramString3.hasMoreElements())
        {
          paramString1 = new java/lang/StringBuilder;
          paramString1.<init>();
          paramString1.append(paramString2);
          paramString1.append("    ");
          a(paramString1.toString(), paramBoolean, (q)paramString3.nextElement(), paramq);
        }
        return paramq.toString();
      }
      catch (IOException paramString1)
      {
        paramq.append(paramString1);
      }
    }
    paramq = new StringBuilder();
    paramq.append(paramString2);
    paramq.append(paramString1);
    paramq.append(" ApplicationSpecific[");
    paramq.append(locala.m());
    paramq.append("] (");
    paramq.append(i.b(d.b(locala.n())));
    paramq.append(")");
    paramq.append(paramString3);
    return paramq.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\s2\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */