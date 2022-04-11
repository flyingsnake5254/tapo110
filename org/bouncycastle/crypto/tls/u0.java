package org.bouncycastle.crypto.tls;

import java.io.IOException;
import java.util.Hashtable;
import org.bouncycastle.util.d;

public class u0
{
  public static final Integer a = d.b(22);
  public static final Integer b = d.b(23);
  public static final Integer c = d.b(15);
  public static final Integer d = d.b(1);
  public static final Integer e = d.b(21);
  public static final Integer f = d.b(0);
  public static final Integer g = d.b(5);
  public static final Integer h = d.b(4);
  
  public static Hashtable a(Hashtable paramHashtable)
  {
    Hashtable localHashtable = paramHashtable;
    if (paramHashtable == null) {
      localHashtable = new Hashtable();
    }
    return localHashtable;
  }
  
  public static short b(Hashtable paramHashtable)
    throws IOException
  {
    paramHashtable = m1.B(paramHashtable, d);
    short s1;
    short s2;
    if (paramHashtable == null)
    {
      s1 = -1;
      s2 = s1;
    }
    else
    {
      s1 = i(paramHashtable);
      s2 = s1;
    }
    return s2;
  }
  
  public static boolean c(Hashtable paramHashtable)
    throws IOException
  {
    paramHashtable = m1.B(paramHashtable, a);
    boolean bool;
    if (paramHashtable == null) {
      bool = false;
    } else {
      bool = g(paramHashtable);
    }
    return bool;
  }
  
  public static boolean d(Hashtable paramHashtable)
    throws IOException
  {
    paramHashtable = m1.B(paramHashtable, b);
    boolean bool;
    if (paramHashtable == null) {
      bool = false;
    } else {
      bool = h(paramHashtable);
    }
    return bool;
  }
  
  public static boolean e(Hashtable paramHashtable)
    throws IOException
  {
    paramHashtable = m1.B(paramHashtable, h);
    boolean bool;
    if (paramHashtable == null) {
      bool = false;
    } else {
      bool = j(paramHashtable);
    }
    return bool;
  }
  
  private static boolean f(byte[] paramArrayOfByte)
    throws IOException
  {
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length == 0) {
        return true;
      }
      throw new TlsFatalAlert((short)47);
    }
    throw new IllegalArgumentException("'extensionData' cannot be null");
  }
  
  public static boolean g(byte[] paramArrayOfByte)
    throws IOException
  {
    return f(paramArrayOfByte);
  }
  
  public static boolean h(byte[] paramArrayOfByte)
    throws IOException
  {
    return f(paramArrayOfByte);
  }
  
  public static short i(byte[] paramArrayOfByte)
    throws IOException
  {
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length == 1) {
        return m1.k0(paramArrayOfByte, 0);
      }
      throw new TlsFatalAlert((short)50);
    }
    throw new IllegalArgumentException("'extensionData' cannot be null");
  }
  
  public static boolean j(byte[] paramArrayOfByte)
    throws IOException
  {
    return f(paramArrayOfByte);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\tls\u0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */