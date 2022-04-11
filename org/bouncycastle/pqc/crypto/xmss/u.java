package org.bouncycastle.pqc.crypto.xmss;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import org.bouncycastle.crypto.g;

public class u
{
  public static long a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    Objects.requireNonNull(paramArrayOfByte, "in == null");
    long l = 0L;
    for (int i = paramInt1; i < paramInt1 + paramInt2; i++) {
      l = l << 8 | paramArrayOfByte[i] & 0xFF;
    }
    return l;
  }
  
  public static int b(int paramInt1, int paramInt2)
  {
    int i = 0;
    int k;
    for (int j = 0;; j++)
    {
      k = i;
      if (j >= paramInt2) {
        break;
      }
      if ((paramInt1 >> j & 0x1) == 0)
      {
        k = j;
        break;
      }
    }
    return k;
  }
  
  public static byte[] c(byte[] paramArrayOfByte)
  {
    Objects.requireNonNull(paramArrayOfByte, "in == null");
    byte[] arrayOfByte = new byte[paramArrayOfByte.length];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramArrayOfByte.length);
    return arrayOfByte;
  }
  
  public static byte[][] d(byte[][] paramArrayOfByte)
  {
    if (!k(paramArrayOfByte))
    {
      byte[][] arrayOfByte = new byte[paramArrayOfByte.length][];
      for (int i = 0; i < paramArrayOfByte.length; i++)
      {
        arrayOfByte[i] = new byte[paramArrayOfByte[i].length];
        System.arraycopy(paramArrayOfByte[i], 0, arrayOfByte[i], 0, paramArrayOfByte[i].length);
      }
      return arrayOfByte;
    }
    throw new NullPointerException("in has null pointers");
  }
  
  public static void e(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt)
  {
    Objects.requireNonNull(paramArrayOfByte1, "dst == null");
    Objects.requireNonNull(paramArrayOfByte2, "src == null");
    if (paramInt >= 0)
    {
      if (paramArrayOfByte2.length + paramInt <= paramArrayOfByte1.length)
      {
        for (int i = 0; i < paramArrayOfByte2.length; i++) {
          paramArrayOfByte1[(paramInt + i)] = ((byte)paramArrayOfByte2[i]);
        }
        return;
      }
      throw new IllegalArgumentException("src length + offset must not be greater than size of destination");
    }
    throw new IllegalArgumentException("offset hast to be >= 0");
  }
  
  public static Object f(byte[] paramArrayOfByte, Class paramClass)
    throws IOException, ClassNotFoundException
  {
    paramArrayOfByte = new a(paramClass, new ByteArrayInputStream(paramArrayOfByte));
    Object localObject = paramArrayOfByte.readObject();
    if (paramArrayOfByte.available() == 0)
    {
      if (paramClass.isInstance(localObject)) {
        return localObject;
      }
      throw new IOException("unexpected class found in ObjectInputStream");
    }
    throw new IOException("unexpected data found at end of ObjectInputStream");
  }
  
  public static byte[] g(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    Objects.requireNonNull(paramArrayOfByte, "src == null");
    if (paramInt1 >= 0)
    {
      if (paramInt2 >= 0)
      {
        if (paramInt1 + paramInt2 <= paramArrayOfByte.length)
        {
          byte[] arrayOfByte = new byte[paramInt2];
          for (int i = 0; i < paramInt2; i++) {
            arrayOfByte[i] = ((byte)paramArrayOfByte[(paramInt1 + i)]);
          }
          return arrayOfByte;
        }
        throw new IllegalArgumentException("offset + length must not be greater then size of source array");
      }
      throw new IllegalArgumentException("length hast to be >= 0");
    }
    throw new IllegalArgumentException("offset hast to be >= 0");
  }
  
  public static int h(g paramg)
  {
    Objects.requireNonNull(paramg, "digest == null");
    String str = paramg.b();
    if (str.equals("SHAKE128")) {
      return 32;
    }
    if (str.equals("SHAKE256")) {
      return 64;
    }
    return paramg.e();
  }
  
  public static int i(long paramLong, int paramInt)
  {
    return (int)(paramLong & (1L << paramInt) - 1L);
  }
  
  public static long j(long paramLong, int paramInt)
  {
    return paramLong >> paramInt;
  }
  
  public static boolean k(byte[][] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return true;
    }
    for (int i = 0; i < paramArrayOfByte.length; i++) {
      if (paramArrayOfByte[i] == null) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean l(int paramInt, long paramLong)
  {
    if (paramLong >= 0L)
    {
      boolean bool;
      if (paramLong < 1L << paramInt) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    throw new IllegalStateException("index must not be negative");
  }
  
  public static boolean m(long paramLong, int paramInt1, int paramInt2)
  {
    boolean bool = false;
    if (paramLong == 0L) {
      return false;
    }
    if ((paramLong + 1L) % Math.pow(1 << paramInt1, paramInt2) == 0L) {
      bool = true;
    }
    return bool;
  }
  
  public static int n(int paramInt)
  {
    int i = 0;
    int j = paramInt;
    for (paramInt = i;; paramInt++)
    {
      j >>= 1;
      if (j == 0) {
        break;
      }
    }
    return paramInt;
  }
  
  public static byte[] o(Object paramObject)
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    ObjectOutputStream localObjectOutputStream = new ObjectOutputStream(localByteArrayOutputStream);
    localObjectOutputStream.writeObject(paramObject);
    localObjectOutputStream.flush();
    return localByteArrayOutputStream.toByteArray();
  }
  
  public static byte[] p(long paramLong, int paramInt)
  {
    byte[] arrayOfByte = new byte[paramInt];
    paramInt--;
    while (paramInt >= 0)
    {
      arrayOfByte[paramInt] = ((byte)(byte)(int)paramLong);
      paramLong >>>= 8;
      paramInt--;
    }
    return arrayOfByte;
  }
  
  private static class a
    extends ObjectInputStream
  {
    private static final Set c;
    private final Class d;
    private boolean f = false;
    
    static
    {
      HashSet localHashSet = new HashSet();
      c = localHashSet;
      localHashSet.add("java.util.TreeMap");
      localHashSet.add("java.lang.Integer");
      localHashSet.add("java.lang.Number");
      localHashSet.add("org.bouncycastle.pqc.crypto.xmss.BDS");
      localHashSet.add("java.util.ArrayList");
      localHashSet.add("org.bouncycastle.pqc.crypto.xmss.XMSSNode");
      localHashSet.add("[B");
      localHashSet.add("java.util.LinkedList");
      localHashSet.add("java.util.Stack");
      localHashSet.add("java.util.Vector");
      localHashSet.add("[Ljava.lang.Object;");
      localHashSet.add("org.bouncycastle.pqc.crypto.xmss.BDSTreeHash");
    }
    
    a(Class paramClass, InputStream paramInputStream)
      throws IOException
    {
      super();
      this.d = paramClass;
    }
    
    protected Class<?> resolveClass(ObjectStreamClass paramObjectStreamClass)
      throws IOException, ClassNotFoundException
    {
      if (!this.f)
      {
        if (paramObjectStreamClass.getName().equals(this.d.getName())) {
          this.f = true;
        } else {
          throw new InvalidClassException("unexpected class: ", paramObjectStreamClass.getName());
        }
      }
      else {
        if (!c.contains(paramObjectStreamClass.getName())) {
          break label67;
        }
      }
      return super.resolveClass(paramObjectStreamClass);
      label67:
      throw new InvalidClassException("unexpected class: ", paramObjectStreamClass.getName());
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\pqc\crypto\xmss\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */