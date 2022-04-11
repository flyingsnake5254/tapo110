package e.a.b.a;

import java.math.BigInteger;

class s
{
  private static final BigInteger a;
  private static final BigInteger b;
  private static final BigInteger c;
  public static final z[] d;
  public static final byte[][] e;
  public static final z[] f;
  public static final byte[][] g = { null, { 1 }, null, { -1, 0, 1 }, null, { 1, 0, 1 }, null, { -1, 0, 0, -1 } };
  
  static
  {
    BigInteger localBigInteger1 = c.b;
    BigInteger localBigInteger2 = localBigInteger1.negate();
    a = localBigInteger2;
    b = c.c.negate();
    BigInteger localBigInteger3 = c.d.negate();
    c = localBigInteger3;
    BigInteger localBigInteger4 = c.a;
    d = new z[] { null, new z(localBigInteger1, localBigInteger4), null, new z(localBigInteger3, localBigInteger2), null, new z(localBigInteger2, localBigInteger2), null, new z(localBigInteger1, localBigInteger2), null };
    e = new byte[][] { null, { 1 }, null, { -1, 0, 1 }, null, { 1, 0, 1 }, null, { -1, 0, 0, 1 } };
    f = new z[] { null, new z(localBigInteger1, localBigInteger4), null, new z(localBigInteger3, localBigInteger1), null, new z(localBigInteger2, localBigInteger1), null, new z(localBigInteger1, localBigInteger1), null };
  }
  
  public static r a(BigInteger paramBigInteger1, BigInteger paramBigInteger2, BigInteger paramBigInteger3, byte paramByte, int paramInt1, int paramInt2)
  {
    int i = (paramInt1 + 5) / 2 + paramInt2;
    paramBigInteger1 = paramBigInteger2.multiply(paramBigInteger1.shiftRight(paramInt1 - i - 2 + paramByte));
    paramBigInteger3 = paramBigInteger1.add(paramBigInteger3.multiply(paramBigInteger1.shiftRight(paramInt1)));
    paramByte = i - paramInt2;
    paramBigInteger2 = paramBigInteger3.shiftRight(paramByte);
    paramBigInteger1 = paramBigInteger2;
    if (paramBigInteger3.testBit(paramByte - 1)) {
      paramBigInteger1 = paramBigInteger2.add(c.b);
    }
    return new r(paramBigInteger1, paramInt2);
  }
  
  public static BigInteger[] b(byte paramByte, int paramInt, boolean paramBoolean)
  {
    if ((paramByte != 1) && (paramByte != -1)) {
      throw new IllegalArgumentException("mu must be 1 or -1");
    }
    Object localObject1;
    Object localObject2;
    if (paramBoolean)
    {
      localObject1 = c.c;
      localObject2 = BigInteger.valueOf(paramByte);
    }
    else
    {
      localObject1 = c.a;
      localObject2 = c.b;
    }
    int i = 1;
    while (i < paramInt)
    {
      if (paramByte == 1) {
        localObject3 = localObject2;
      } else {
        localObject3 = ((BigInteger)localObject2).negate();
      }
      localObject1 = ((BigInteger)localObject3).subtract(((BigInteger)localObject1).shiftLeft(1));
      i++;
      Object localObject3 = localObject2;
      localObject2 = localObject1;
      localObject1 = localObject3;
    }
    return new BigInteger[] { localObject1, localObject2 };
  }
  
  public static byte c(int paramInt)
  {
    if (paramInt == 0) {
      paramInt = -1;
    } else {
      paramInt = 1;
    }
    return (byte)paramInt;
  }
  
  public static h.b[] d(h.b paramb, byte paramByte)
  {
    byte[][] arrayOfByte;
    if (paramByte == 0) {
      arrayOfByte = e;
    } else {
      arrayOfByte = g;
    }
    h.b[] arrayOfb = new h.b[arrayOfByte.length + 1 >>> 1];
    arrayOfb[0] = paramb;
    byte b1 = arrayOfByte.length;
    for (paramByte = 3; paramByte < b1; paramByte += 2) {
      arrayOfb[(paramByte >>> 1)] = h(paramb, arrayOfByte[paramByte]);
    }
    paramb.i().z(arrayOfb);
    return arrayOfb;
  }
  
  protected static int e(BigInteger paramBigInteger)
  {
    if (paramBigInteger != null)
    {
      if (paramBigInteger.equals(c.c)) {
        return 1;
      }
      if (paramBigInteger.equals(c.e)) {
        return 2;
      }
    }
    throw new IllegalArgumentException("h (Cofactor) must be 2 or 4");
  }
  
  public static BigInteger[] f(d.b paramb)
  {
    if (paramb.G())
    {
      int i = paramb.t();
      int j = paramb.o().t().intValue();
      byte b1 = c(j);
      int k = e(paramb.q());
      BigInteger[] arrayOfBigInteger = b(b1, i + 3 - j, false);
      if (b1 == 1)
      {
        arrayOfBigInteger[0] = arrayOfBigInteger[0].negate();
        arrayOfBigInteger[1] = arrayOfBigInteger[1].negate();
      }
      paramb = c.b;
      return new BigInteger[] { paramb.add(arrayOfBigInteger[1]).shiftRight(k), paramb.add(arrayOfBigInteger[0]).shiftRight(k).negate() };
    }
    throw new IllegalArgumentException("si is defined for Koblitz curves only");
  }
  
  public static BigInteger g(byte paramByte, int paramInt)
  {
    if (paramInt == 4)
    {
      if (paramByte == 1) {
        return BigInteger.valueOf(6L);
      }
      return BigInteger.valueOf(10L);
    }
    BigInteger[] arrayOfBigInteger = b(paramByte, paramInt, false);
    BigInteger localBigInteger1 = c.a.setBit(paramInt);
    BigInteger localBigInteger2 = arrayOfBigInteger[1].modInverse(localBigInteger1);
    return c.c.multiply(arrayOfBigInteger[0]).multiply(localBigInteger2).mod(localBigInteger1);
  }
  
  public static h.b h(h.b paramb, byte[] paramArrayOfByte)
  {
    Object localObject1 = (h.b)paramb.i().u();
    h.b localb = (h.b)paramb.z();
    int i = paramArrayOfByte.length - 1;
    int j = 0;
    while (i >= 0)
    {
      int k = j + 1;
      int m = paramArrayOfByte[i];
      Object localObject2 = localObject1;
      j = k;
      if (m != 0)
      {
        localObject2 = ((h.b)localObject1).L(k);
        if (m > 0) {
          localObject1 = paramb;
        } else {
          localObject1 = localb;
        }
        localObject2 = (h.b)((h)localObject2).a((h)localObject1);
        j = 0;
      }
      i--;
      localObject1 = localObject2;
    }
    paramb = (h.b)localObject1;
    if (j > 0) {
      paramb = ((h.b)localObject1).L(j);
    }
    return paramb;
  }
  
  public static BigInteger i(byte paramByte, z paramz)
  {
    BigInteger localBigInteger1 = paramz.a;
    BigInteger localBigInteger2 = localBigInteger1.multiply(localBigInteger1);
    BigInteger localBigInteger3 = paramz.a.multiply(paramz.b);
    paramz = paramz.b;
    localBigInteger1 = paramz.multiply(paramz).shiftLeft(1);
    if (paramByte == 1) {}
    for (paramz = localBigInteger2.add(localBigInteger3);; paramz = localBigInteger2.subtract(localBigInteger3))
    {
      paramz = paramz.add(localBigInteger1);
      break;
      if (paramByte != -1) {
        break label77;
      }
    }
    return paramz;
    label77:
    throw new IllegalArgumentException("mu must be 1 or -1");
  }
  
  public static z j(BigInteger paramBigInteger, int paramInt, byte paramByte1, BigInteger[] paramArrayOfBigInteger, byte paramByte2, byte paramByte3)
  {
    BigInteger localBigInteger;
    if (paramByte2 == 1) {
      localBigInteger = paramArrayOfBigInteger[0].add(paramArrayOfBigInteger[1]);
    } else {
      localBigInteger = paramArrayOfBigInteger[0].subtract(paramArrayOfBigInteger[1]);
    }
    Object localObject = b(paramByte2, paramInt, true)[1];
    localObject = k(a(paramBigInteger, paramArrayOfBigInteger[0], (BigInteger)localObject, paramByte1, paramInt, paramByte3), a(paramBigInteger, paramArrayOfBigInteger[1], (BigInteger)localObject, paramByte1, paramInt, paramByte3), paramByte2);
    return new z(paramBigInteger.subtract(localBigInteger.multiply(((z)localObject).a)).subtract(BigInteger.valueOf(2L).multiply(paramArrayOfBigInteger[1]).multiply(((z)localObject).b)), paramArrayOfBigInteger[1].multiply(((z)localObject).a).subtract(paramArrayOfBigInteger[0].multiply(((z)localObject).b)));
  }
  
  public static z k(r paramr1, r paramr2, byte paramByte)
  {
    int i = paramr1.f();
    if (paramr2.f() == i)
    {
      int j = -1;
      int k = 1;
      if ((paramByte != 1) && (paramByte != -1)) {
        throw new IllegalArgumentException("mu must be 1 or -1");
      }
      BigInteger localBigInteger1 = paramr1.h();
      BigInteger localBigInteger2 = paramr2.h();
      r localr1 = paramr1.i(localBigInteger1);
      paramr2 = paramr2.i(localBigInteger2);
      paramr1 = localr1.a(localr1);
      if (paramByte == 1) {
        paramr1 = paramr1.a(paramr2);
      } else {
        paramr1 = paramr1.j(paramr2);
      }
      r localr2 = paramr2.a(paramr2).a(paramr2);
      Object localObject = localr2.a(paramr2);
      if (paramByte == 1)
      {
        paramr2 = localr1.j(localr2);
        localr1 = localr1.a((r)localObject);
      }
      else
      {
        paramr2 = localr1.a(localr2);
        localr1 = localr1.j((r)localObject);
      }
      localObject = c.b;
      int m = paramr1.d((BigInteger)localObject);
      i = 0;
      int n = 0;
      if (m >= 0)
      {
        n = k;
        if (paramr2.d(a) >= 0) {
          break label217;
        }
      }
      else
      {
        i = n;
        if (localr1.d(c.c) < 0) {
          break label214;
        }
      }
      i = paramByte;
      label214:
      n = 0;
      label217:
      if (paramr1.d(a) < 0) {
        if (paramr2.d((BigInteger)localObject) < 0) {
          break label258;
        }
      } else {
        if (localr1.d(b) >= 0) {
          break label254;
        }
      }
      i = (byte)-paramByte;
      label254:
      j = n;
      label258:
      return new z(localBigInteger1.add(BigInteger.valueOf(j)), localBigInteger2.add(BigInteger.valueOf(i)));
    }
    throw new IllegalArgumentException("lambda0 and lambda1 do not have same scale");
  }
  
  public static byte[] l(byte paramByte1, z paramz, byte paramByte2, BigInteger paramBigInteger1, BigInteger paramBigInteger2, z[] paramArrayOfz)
  {
    if ((paramByte1 != 1) && (paramByte1 != -1)) {
      throw new IllegalArgumentException("mu must be 1 or -1");
    }
    int i = i(paramByte1, paramz).bitLength();
    if (i > 30) {
      paramByte2 = i + 4 + paramByte2;
    } else {
      paramByte2 += 34;
    }
    byte[] arrayOfByte = new byte[paramByte2];
    BigInteger localBigInteger1 = paramBigInteger1.shiftRight(1);
    BigInteger localBigInteger2 = paramz.a;
    paramz = paramz.b;
    for (paramByte2 = 0;; paramByte2++)
    {
      Object localObject = c.a;
      if ((localBigInteger2.equals(localObject)) && (paramz.equals(localObject))) {
        return arrayOfByte;
      }
      if (localBigInteger2.testBit(0))
      {
        BigInteger localBigInteger3 = localBigInteger2.add(paramz.multiply(paramBigInteger2)).mod(paramBigInteger1);
        localObject = localBigInteger3;
        if (localBigInteger3.compareTo(localBigInteger1) >= 0) {
          localObject = localBigInteger3.subtract(paramBigInteger1);
        }
        int j = (byte)((BigInteger)localObject).intValue();
        arrayOfByte[paramByte2] = ((byte)j);
        if (j < 0)
        {
          j = (byte)-j;
          i = 0;
        }
        else
        {
          i = 1;
        }
        if (i != 0)
        {
          localBigInteger2 = localBigInteger2.subtract(paramArrayOfz[j].a);
          localObject = paramz.subtract(paramArrayOfz[j].b);
          paramz = localBigInteger2;
        }
        else
        {
          localBigInteger2 = localBigInteger2.add(paramArrayOfz[j].a);
          localObject = paramz.add(paramArrayOfz[j].b);
          paramz = localBigInteger2;
        }
      }
      else
      {
        arrayOfByte[paramByte2] = ((byte)0);
        localObject = paramz;
        paramz = localBigInteger2;
      }
      localBigInteger2 = paramz.shiftRight(1);
      if (paramByte1 == 1) {
        localBigInteger2 = ((BigInteger)localObject).add(localBigInteger2);
      } else {
        localBigInteger2 = ((BigInteger)localObject).subtract(localBigInteger2);
      }
      paramz = paramz.shiftRight(1).negate();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\b\a\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */