package org.bouncycastle.asn1.t2.f;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Vector;
import org.bouncycastle.asn1.j1;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.m;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.t2.a;
import org.bouncycastle.asn1.t2.b;
import org.bouncycastle.asn1.w;
import org.bouncycastle.util.i;

public class c
{
  public static void a(StringBuffer paramStringBuffer, b paramb, Hashtable paramHashtable)
  {
    if (paramb.i())
    {
      paramb = paramb.h();
      int i = 1;
      for (int j = 0; j != paramb.length; j++)
      {
        if (i != 0) {
          i = 0;
        } else {
          paramStringBuffer.append('+');
        }
        b(paramStringBuffer, paramb[j], paramHashtable);
      }
    }
    if (paramb.f() != null) {
      b(paramStringBuffer, paramb.f(), paramHashtable);
    }
  }
  
  public static void b(StringBuffer paramStringBuffer, a parama, Hashtable paramHashtable)
  {
    paramHashtable = (String)paramHashtable.get(parama.g());
    if (paramHashtable == null) {
      paramHashtable = parama.g().q();
    }
    paramStringBuffer.append(paramHashtable);
    paramStringBuffer.append('=');
    paramStringBuffer.append(q(parama.h()));
  }
  
  private static boolean c(a parama1, a parama2)
  {
    if (parama1 == parama2) {
      return true;
    }
    if (parama1 == null) {
      return false;
    }
    if (parama2 == null) {
      return false;
    }
    if (!parama1.g().equals(parama2.g())) {
      return false;
    }
    return e(q(parama1.h())).equals(e(q(parama2.h())));
  }
  
  private static String d(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length;
    char[] arrayOfChar = new char[i];
    for (int j = 0; j != i; j++) {
      arrayOfChar[j] = ((char)(char)(paramArrayOfByte[j] & 0xFF));
    }
    return new String(arrayOfChar);
  }
  
  public static String e(String paramString)
  {
    String str = i.f(paramString);
    int i = str.length();
    int j = 0;
    paramString = str;
    if (i > 0)
    {
      paramString = str;
      if (str.charAt(0) == '#')
      {
        q localq = h(str);
        paramString = str;
        if ((localq instanceof w)) {
          paramString = i.f(((w)localq).getString());
        }
      }
    }
    str = paramString;
    if (paramString.length() > 1)
    {
      for (;;)
      {
        i = j + 1;
        if ((i >= paramString.length()) || (paramString.charAt(j) != '\\') || (paramString.charAt(i) != ' ')) {
          break;
        }
        j += 2;
      }
      for (i = paramString.length() - 1;; i -= 2)
      {
        int k = i - 1;
        if ((k <= 0) || (paramString.charAt(k) != '\\') || (paramString.charAt(i) != ' ')) {
          break;
        }
      }
      if (j <= 0)
      {
        str = paramString;
        if (i >= paramString.length() - 1) {}
      }
      else
      {
        str = paramString.substring(j, i + 1);
      }
    }
    return l(str);
  }
  
  private static int f(char paramChar)
  {
    if (('0' <= paramChar) && (paramChar <= '9')) {
      return paramChar - '0';
    }
    if (('a' <= paramChar) && (paramChar <= 'f')) {
      paramChar -= 97;
    }
    for (;;)
    {
      return paramChar + '\n';
      paramChar -= 65;
    }
  }
  
  public static m g(String paramString, Hashtable paramHashtable)
  {
    if (i.j(paramString).startsWith("OID.")) {
      return new m(paramString.substring(4));
    }
    if ((paramString.charAt(0) >= '0') && (paramString.charAt(0) <= '9')) {
      return new m(paramString);
    }
    paramHashtable = (m)paramHashtable.get(i.f(paramString));
    if (paramHashtable != null) {
      return paramHashtable;
    }
    paramHashtable = new StringBuilder();
    paramHashtable.append("Unknown object id - ");
    paramHashtable.append(paramString);
    paramHashtable.append(" - passed to distinguished name");
    throw new IllegalArgumentException(paramHashtable.toString());
  }
  
  private static q h(String paramString)
  {
    try
    {
      paramString = q.i(org.bouncycastle.util.encoders.d.a(paramString.substring(1)));
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
  
  private static boolean i(char paramChar)
  {
    boolean bool;
    if ((('0' <= paramChar) && (paramChar <= '9')) || (('a' <= paramChar) && (paramChar <= 'f')) || (('A' <= paramChar) && (paramChar <= 'F'))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static boolean j(b paramb1, b paramb2)
  {
    if (paramb1.i())
    {
      if (paramb2.i())
      {
        paramb1 = paramb1.h();
        paramb2 = paramb2.h();
        if (paramb1.length != paramb2.length) {
          return false;
        }
        for (int i = 0; i != paramb1.length; i++) {
          if (!c(paramb1[i], paramb2[i])) {
            return false;
          }
        }
        return true;
      }
      return false;
    }
    if (!paramb2.i()) {
      return c(paramb1.f(), paramb2.f());
    }
    return false;
  }
  
  public static b[] k(String paramString, org.bouncycastle.asn1.t2.e parame)
  {
    e locale1 = new e(paramString);
    org.bouncycastle.asn1.t2.d locald = new org.bouncycastle.asn1.t2.d(parame);
    while (locale1.a())
    {
      paramString = locale1.b();
      Object localObject;
      if (paramString.indexOf('+') > 0)
      {
        e locale2 = new e(paramString, '+');
        localObject = new e(locale2.b(), '=');
        paramString = ((e)localObject).b();
        if (((e)localObject).a())
        {
          localObject = ((e)localObject).b();
          paramString = parame.c(paramString.trim());
          if (locale2.a())
          {
            Vector localVector1 = new Vector();
            Vector localVector2 = new Vector();
            for (;;)
            {
              localVector1.addElement(paramString);
              localVector2.addElement(o((String)localObject));
              if (!locale2.a()) {
                break label210;
              }
              localObject = new e(locale2.b(), '=');
              paramString = ((e)localObject).b();
              if (!((e)localObject).a()) {
                break;
              }
              localObject = ((e)localObject).b();
              paramString = parame.c(paramString.trim());
            }
            throw new IllegalArgumentException("badly formatted directory string");
            label210:
            locald.a(m(localVector1), n(localVector2));
          }
          else
          {
            locald.d(paramString, o((String)localObject));
          }
        }
        else
        {
          throw new IllegalArgumentException("badly formatted directory string");
        }
      }
      else
      {
        localObject = new e(paramString, '=');
        paramString = ((e)localObject).b();
        if (((e)localObject).a())
        {
          localObject = ((e)localObject).b();
          locald.d(parame.c(paramString.trim()), o((String)localObject));
        }
        else
        {
          throw new IllegalArgumentException("badly formatted directory string");
        }
      }
    }
    return locald.f().i();
  }
  
  public static String l(String paramString)
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
  
  private static m[] m(Vector paramVector)
  {
    int i = paramVector.size();
    m[] arrayOfm = new m[i];
    for (int j = 0; j != i; j++) {
      arrayOfm[j] = ((m)paramVector.elementAt(j));
    }
    return arrayOfm;
  }
  
  private static String[] n(Vector paramVector)
  {
    int i = paramVector.size();
    String[] arrayOfString = new String[i];
    for (int j = 0; j != i; j++) {
      arrayOfString[j] = ((String)paramVector.elementAt(j));
    }
    return arrayOfString;
  }
  
  private static String o(String paramString)
  {
    if ((paramString.length() != 0) && ((paramString.indexOf('\\') >= 0) || (paramString.indexOf('"') >= 0)))
    {
      char[] arrayOfChar = paramString.toCharArray();
      paramString = new StringBuffer(paramString.length());
      int i;
      if ((arrayOfChar[0] == '\\') && (arrayOfChar[1] == '#'))
      {
        i = 2;
        paramString.append("\\#");
      }
      else
      {
        i = 0;
      }
      int j = 0;
      int k = 0;
      int m = 0;
      int n = 0;
      int i1 = 0;
      int i2 = i1;
      i1 = i;
      while (i1 != arrayOfChar.length)
      {
        int i3 = arrayOfChar[i1];
        if (i3 != 32) {
          n = 1;
        }
        if (i3 == 34)
        {
          if (j != 0) {
            break label255;
          }
          m ^= 0x1;
        }
        int i5;
        for (;;)
        {
          i = 0;
          int i4 = i2;
          break;
          if ((i3 == 92) && (j == 0) && (m == 0))
          {
            k = paramString.length();
            i = 1;
            i4 = i2;
            break;
          }
          if ((i3 == 32) && (j == 0) && (n == 0))
          {
            i = j;
            i4 = i2;
            break;
          }
          if ((j != 0) && (i(i3)))
          {
            if (i2 != 0)
            {
              paramString.append((char)(f(i2) * 16 + f(i3)));
              i = 0;
              i5 = 0;
              break;
            }
            i5 = i3;
            i = j;
            break;
          }
          label255:
          paramString.append(i3);
        }
        i1++;
        j = i;
        i2 = i5;
      }
      if (paramString.length() > 0) {
        while ((paramString.charAt(paramString.length() - 1) == ' ') && (k != paramString.length() - 1)) {
          paramString.setLength(paramString.length() - 1);
        }
      }
      return paramString.toString();
    }
    return paramString.trim();
  }
  
  public static org.bouncycastle.asn1.e p(String paramString, int paramInt)
    throws IOException
  {
    int i = (paramString.length() - paramInt) / 2;
    byte[] arrayOfByte = new byte[i];
    for (int j = 0; j != i; j++)
    {
      int k = j * 2 + paramInt;
      char c1 = paramString.charAt(k);
      char c2 = paramString.charAt(k + 1);
      k = f(c1);
      arrayOfByte[j] = ((byte)(byte)(f(c2) | k << 4));
    }
    return q.i(arrayOfByte);
  }
  
  public static String q(org.bouncycastle.asn1.e parame)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    boolean bool = parame instanceof w;
    int i = 0;
    Object localObject;
    if ((bool) && (!(parame instanceof j1)))
    {
      localObject = ((w)parame).getString();
      parame = (org.bouncycastle.asn1.e)localObject;
      if (((String)localObject).length() > 0)
      {
        parame = (org.bouncycastle.asn1.e)localObject;
        if (((String)localObject).charAt(0) == '#')
        {
          parame = new StringBuilder();
          parame.append("\\");
          parame.append((String)localObject);
          parame = parame.toString();
        }
      }
      localStringBuffer.append(parame);
    }
    try
    {
      localObject = new java/lang/StringBuilder;
      ((StringBuilder)localObject).<init>();
      ((StringBuilder)localObject).append("#");
      ((StringBuilder)localObject).append(d(org.bouncycastle.util.encoders.d.b(parame.c().e("DER"))));
      localStringBuffer.append(((StringBuilder)localObject).toString());
      int j = localStringBuffer.length();
      int k = localStringBuffer.length();
      int m = 2;
      if ((k < 2) || (localStringBuffer.charAt(0) != '\\') || (localStringBuffer.charAt(1) != '#')) {
        m = 0;
      }
      while (m != j)
      {
        int n;
        if ((localStringBuffer.charAt(m) != ',') && (localStringBuffer.charAt(m) != '"') && (localStringBuffer.charAt(m) != '\\') && (localStringBuffer.charAt(m) != '+') && (localStringBuffer.charAt(m) != '=') && (localStringBuffer.charAt(m) != '<') && (localStringBuffer.charAt(m) != '>'))
        {
          n = m;
          k = j;
          if (localStringBuffer.charAt(m) != ';') {}
        }
        else
        {
          localStringBuffer.insert(m, "\\");
          n = m + 1;
          k = j + 1;
        }
        m = n + 1;
        j = k;
      }
      if (localStringBuffer.length() > 0) {
        for (m = i; (localStringBuffer.length() > m) && (localStringBuffer.charAt(m) == ' '); m += 2) {
          localStringBuffer.insert(m, "\\");
        }
      }
      for (m = localStringBuffer.length() - 1; (m >= 0) && (localStringBuffer.charAt(m) == ' '); m--) {
        localStringBuffer.insert(m, '\\');
      }
      return localStringBuffer.toString();
    }
    catch (IOException parame)
    {
      throw new IllegalArgumentException("Other value has no encoded form");
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\t2\f\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */