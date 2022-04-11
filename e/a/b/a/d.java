package e.a.b.a;

import java.math.BigInteger;
import java.util.Random;

public abstract class d
{
  protected e.a.b.b.a a;
  protected e b;
  protected e c;
  protected BigInteger d;
  protected BigInteger e;
  protected int f = 0;
  protected e.a.b.a.b0.a g = null;
  protected g h = null;
  
  protected d(e.a.b.b.a parama)
  {
    this.a = parama;
  }
  
  public void A(h[] paramArrayOfh, int paramInt1, int paramInt2, e parame)
  {
    b(paramArrayOfh, paramInt1, paramInt2);
    int i = r();
    if ((i != 0) && (i != 5))
    {
      e[] arrayOfe = new e[paramInt2];
      int[] arrayOfInt = new int[paramInt2];
      int j = 0;
      int k = 0;
      int n;
      for (i = 0; k < paramInt2; i = n)
      {
        int m = paramInt1 + k;
        h localh = paramArrayOfh[m];
        n = i;
        if (localh != null) {
          if (parame == null)
          {
            n = i;
            if (localh.v()) {}
          }
          else
          {
            arrayOfe[i] = localh.s(0);
            arrayOfInt[i] = m;
            n = i + 1;
          }
        }
        k++;
      }
      if (i == 0) {
        return;
      }
      b.k(arrayOfe, 0, i, parame);
      for (paramInt1 = j; paramInt1 < i; paramInt1++)
      {
        paramInt2 = arrayOfInt[paramInt1];
        paramArrayOfh[paramInt2] = paramArrayOfh[paramInt2].B(arrayOfe[paramInt1]);
      }
      return;
    }
    if (parame == null) {
      return;
    }
    throw new IllegalArgumentException("'iso' not valid for affine coordinates");
  }
  
  /* Error */
  public p B(h paramh, String paramString, o paramo)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokevirtual 88	e/a/b/a/d:a	(Le/a/b/a/h;)V
    //   5: aload_1
    //   6: monitorenter
    //   7: aload_1
    //   8: getfield 91	e/a/b/a/h:g	Ljava/util/Hashtable;
    //   11: astore 4
    //   13: aload 4
    //   15: astore 5
    //   17: aload 4
    //   19: ifnonnull +20 -> 39
    //   22: new 93	java/util/Hashtable
    //   25: astore 5
    //   27: aload 5
    //   29: iconst_4
    //   30: invokespecial 96	java/util/Hashtable:<init>	(I)V
    //   33: aload_1
    //   34: aload 5
    //   36: putfield 91	e/a/b/a/h:g	Ljava/util/Hashtable;
    //   39: aload_1
    //   40: monitorexit
    //   41: aload 5
    //   43: monitorenter
    //   44: aload 5
    //   46: aload_2
    //   47: invokevirtual 100	java/util/Hashtable:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   50: checkcast 102	e/a/b/a/p
    //   53: astore_1
    //   54: aload_3
    //   55: aload_1
    //   56: invokeinterface 107 2 0
    //   61: astore_3
    //   62: aload_3
    //   63: aload_1
    //   64: if_acmpeq +11 -> 75
    //   67: aload 5
    //   69: aload_2
    //   70: aload_3
    //   71: invokevirtual 111	java/util/Hashtable:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   74: pop
    //   75: aload 5
    //   77: monitorexit
    //   78: aload_3
    //   79: areturn
    //   80: astore_1
    //   81: aload 5
    //   83: monitorexit
    //   84: aload_1
    //   85: athrow
    //   86: astore_2
    //   87: aload_1
    //   88: monitorexit
    //   89: aload_2
    //   90: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	91	0	this	d
    //   0	91	1	paramh	h
    //   0	91	2	paramString	String
    //   0	91	3	paramo	o
    //   11	7	4	localHashtable1	java.util.Hashtable
    //   15	67	5	localHashtable2	java.util.Hashtable
    // Exception table:
    //   from	to	target	type
    //   44	62	80	finally
    //   67	75	80	finally
    //   75	78	80	finally
    //   81	84	80	finally
    //   7	13	86	finally
    //   22	39	86	finally
    //   39	41	86	finally
    //   87	89	86	finally
  }
  
  public boolean C(int paramInt)
  {
    boolean bool;
    if (paramInt == 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public h D(BigInteger paramBigInteger1, BigInteger paramBigInteger2)
  {
    paramBigInteger1 = g(paramBigInteger1, paramBigInteger2);
    if (paramBigInteger1.w()) {
      return paramBigInteger1;
    }
    throw new IllegalArgumentException("Invalid point coordinates");
  }
  
  protected void a(h paramh)
  {
    if ((paramh != null) && (this == paramh.i())) {
      return;
    }
    throw new IllegalArgumentException("'point' must be non-null and on this curve");
  }
  
  protected void b(h[] paramArrayOfh, int paramInt1, int paramInt2)
  {
    if (paramArrayOfh != null)
    {
      if ((paramInt1 >= 0) && (paramInt2 >= 0) && (paramInt1 <= paramArrayOfh.length - paramInt2))
      {
        for (int i = 0; i < paramInt2; i++)
        {
          h localh = paramArrayOfh[(paramInt1 + i)];
          if ((localh != null) && (this != localh.i())) {
            throw new IllegalArgumentException("'points' entries must be null or on this curve");
          }
        }
        return;
      }
      throw new IllegalArgumentException("invalid range specified for 'points'");
    }
    throw new IllegalArgumentException("'points' cannot be null");
  }
  
  protected abstract d c();
  
  public d d()
  {
    try
    {
      d locald = new d(this.f, this.g, this.h);
      return locald;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public f e(h[] paramArrayOfh, int paramInt1, final int paramInt2)
  {
    final int i = t() + 7 >>> 3;
    final byte[] arrayOfByte1 = new byte[paramInt2 * i * 2];
    int j = 0;
    int k = 0;
    while (j < paramInt2)
    {
      Object localObject = paramArrayOfh[(paramInt1 + j)];
      byte[] arrayOfByte2 = ((h)localObject).n().t().toByteArray();
      localObject = ((h)localObject).o().t().toByteArray();
      int m = arrayOfByte2.length;
      int n = 1;
      if (m > i) {
        m = 1;
      } else {
        m = 0;
      }
      int i1 = arrayOfByte2.length - m;
      if (localObject.length <= i) {
        n = 0;
      }
      int i2 = localObject.length - n;
      k += i;
      System.arraycopy(arrayOfByte2, m, arrayOfByte1, k - i1, i1);
      k += i;
      System.arraycopy(localObject, n, arrayOfByte1, k - i2, i2);
      j++;
    }
    return new a(paramInt2, i, arrayOfByte1);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool;
    if ((this != paramObject) && ((!(paramObject instanceof d)) || (!m((d)paramObject)))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  protected g f()
  {
    e.a.b.a.b0.a locala = this.g;
    if ((locala instanceof e.a.b.a.b0.b)) {
      return new m(this, (e.a.b.a.b0.b)locala);
    }
    return new u();
  }
  
  public h g(BigInteger paramBigInteger1, BigInteger paramBigInteger2)
  {
    return h(paramBigInteger1, paramBigInteger2, false);
  }
  
  public h h(BigInteger paramBigInteger1, BigInteger paramBigInteger2, boolean paramBoolean)
  {
    return i(n(paramBigInteger1), n(paramBigInteger2), paramBoolean);
  }
  
  public int hashCode()
  {
    return s().hashCode() ^ org.bouncycastle.util.d.a(o().t().hashCode(), 8) ^ org.bouncycastle.util.d.a(p().t().hashCode(), 16);
  }
  
  protected abstract h i(e parame1, e parame2, boolean paramBoolean);
  
  protected abstract h j(e parame1, e parame2, e[] paramArrayOfe, boolean paramBoolean);
  
  public h k(byte[] paramArrayOfByte)
  {
    int i = (t() + 7) / 8;
    boolean bool1 = false;
    int j = paramArrayOfByte[0];
    if (j != 0)
    {
      if ((j != 2) && (j != 3))
      {
        if (j != 4)
        {
          if ((j != 6) && (j != 7))
          {
            paramArrayOfByte = new StringBuilder();
            paramArrayOfByte.append("Invalid point encoding 0x");
            paramArrayOfByte.append(Integer.toString(j, 16));
            throw new IllegalArgumentException(paramArrayOfByte.toString());
          }
          if (paramArrayOfByte.length == i * 2 + 1)
          {
            BigInteger localBigInteger = org.bouncycastle.util.b.d(paramArrayOfByte, 1, i);
            paramArrayOfByte = org.bouncycastle.util.b.d(paramArrayOfByte, i + 1, i);
            boolean bool2 = paramArrayOfByte.testBit(0);
            if (j == 7) {
              bool1 = true;
            }
            if (bool2 == bool1) {
              paramArrayOfByte = D(localBigInteger, paramArrayOfByte);
            } else {
              throw new IllegalArgumentException("Inconsistent Y coordinate in hybrid encoding");
            }
          }
          else
          {
            throw new IllegalArgumentException("Incorrect length for hybrid encoding");
          }
        }
        else if (paramArrayOfByte.length == i * 2 + 1)
        {
          paramArrayOfByte = D(org.bouncycastle.util.b.d(paramArrayOfByte, 1, i), org.bouncycastle.util.b.d(paramArrayOfByte, i + 1, i));
        }
        else
        {
          throw new IllegalArgumentException("Incorrect length for uncompressed encoding");
        }
      }
      else if (paramArrayOfByte.length == i + 1)
      {
        paramArrayOfByte = l(j & 0x1, org.bouncycastle.util.b.d(paramArrayOfByte, 1, i));
        if (!paramArrayOfByte.w()) {
          throw new IllegalArgumentException("Invalid point");
        }
      }
      else
      {
        throw new IllegalArgumentException("Incorrect length for compressed encoding");
      }
    }
    else
    {
      if (paramArrayOfByte.length != 1) {
        break label311;
      }
      paramArrayOfByte = u();
    }
    if ((j != 0) && (paramArrayOfByte.u())) {
      throw new IllegalArgumentException("Invalid infinity encoding");
    }
    return paramArrayOfByte;
    label311:
    throw new IllegalArgumentException("Incorrect length for infinity encoding");
  }
  
  protected abstract h l(int paramInt, BigInteger paramBigInteger);
  
  public boolean m(d paramd)
  {
    boolean bool;
    if ((this != paramd) && ((paramd == null) || (!s().equals(paramd.s())) || (!o().t().equals(paramd.o().t())) || (!p().t().equals(paramd.p().t())))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public abstract e n(BigInteger paramBigInteger);
  
  public e o()
  {
    return this.b;
  }
  
  public e p()
  {
    return this.c;
  }
  
  public BigInteger q()
  {
    return this.e;
  }
  
  public int r()
  {
    return this.f;
  }
  
  public e.a.b.b.a s()
  {
    return this.a;
  }
  
  public abstract int t();
  
  public abstract h u();
  
  public g v()
  {
    try
    {
      if (this.h == null) {
        this.h = f();
      }
      g localg = this.h;
      return localg;
    }
    finally {}
  }
  
  public BigInteger w()
  {
    return this.d;
  }
  
  /* Error */
  public p x(h paramh, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokevirtual 88	e/a/b/a/d:a	(Le/a/b/a/h;)V
    //   5: aload_1
    //   6: monitorenter
    //   7: aload_1
    //   8: getfield 91	e/a/b/a/h:g	Ljava/util/Hashtable;
    //   11: astore_3
    //   12: aload_1
    //   13: monitorexit
    //   14: aload_3
    //   15: ifnonnull +5 -> 20
    //   18: aconst_null
    //   19: areturn
    //   20: aload_3
    //   21: monitorenter
    //   22: aload_3
    //   23: aload_2
    //   24: invokevirtual 100	java/util/Hashtable:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   27: checkcast 102	e/a/b/a/p
    //   30: astore_1
    //   31: aload_3
    //   32: monitorexit
    //   33: aload_1
    //   34: areturn
    //   35: astore_1
    //   36: aload_3
    //   37: monitorexit
    //   38: aload_1
    //   39: athrow
    //   40: astore_2
    //   41: aload_1
    //   42: monitorexit
    //   43: aload_2
    //   44: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	45	0	this	d
    //   0	45	1	paramh	h
    //   0	45	2	paramString	String
    //   11	26	3	localHashtable	java.util.Hashtable
    // Exception table:
    //   from	to	target	type
    //   22	33	35	finally
    //   36	38	35	finally
    //   7	14	40	finally
    //   41	43	40	finally
  }
  
  public h y(h paramh)
  {
    if (this == paramh.i()) {
      return paramh;
    }
    if (paramh.u()) {
      return u();
    }
    paramh = paramh.A();
    return h(paramh.q().t(), paramh.r().t(), paramh.f);
  }
  
  public void z(h[] paramArrayOfh)
  {
    A(paramArrayOfh, 0, paramArrayOfh.length, null);
  }
  
  class a
    implements f
  {
    a(int paramInt1, int paramInt2, byte[] paramArrayOfByte) {}
    
    public int a()
    {
      return paramInt2;
    }
    
    public h b(int paramInt)
    {
      int i = i;
      byte[] arrayOfByte1 = new byte[i];
      byte[] arrayOfByte2 = new byte[i];
      i = 0;
      int j = 0;
      while (i < paramInt2)
      {
        int k = (i ^ paramInt) - 1 >> 31;
        int n;
        for (int m = 0;; m++)
        {
          n = i;
          if (m >= n) {
            break;
          }
          int i1 = arrayOfByte1[m];
          localObject = arrayOfByte1;
          arrayOfByte1[m] = ((byte)(byte)(i1 ^ localObject[(j + m)] & k));
          i1 = arrayOfByte2[m];
          arrayOfByte2[m] = ((byte)(byte)(localObject[(n + j + m)] & k ^ i1));
        }
        j += n * 2;
        i++;
      }
      Object localObject = d.this;
      return ((d)localObject).i(((d)localObject).n(new BigInteger(1, arrayOfByte1)), d.this.n(new BigInteger(1, arrayOfByte2)), false);
    }
  }
  
  public static abstract class b
    extends d
  {
    private BigInteger[] i = null;
    
    protected b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      super();
    }
    
    private static e.a.b.b.a E(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      if (paramInt2 != 0)
      {
        if (paramInt3 == 0)
        {
          if (paramInt4 == 0) {
            return e.a.b.b.b.a(new int[] { 0, paramInt2, paramInt1 });
          }
          throw new IllegalArgumentException("k3 must be 0 if k2 == 0");
        }
        if (paramInt3 > paramInt2)
        {
          if (paramInt4 > paramInt3) {
            return e.a.b.b.b.a(new int[] { 0, paramInt2, paramInt3, paramInt4, paramInt1 });
          }
          throw new IllegalArgumentException("k3 must be > k2");
        }
        throw new IllegalArgumentException("k2 must be > k1");
      }
      throw new IllegalArgumentException("k1 must be > 0");
    }
    
    BigInteger[] F()
    {
      try
      {
        if (this.i == null) {
          this.i = s.f(this);
        }
        BigInteger[] arrayOfBigInteger = this.i;
        return arrayOfBigInteger;
      }
      finally {}
    }
    
    public boolean G()
    {
      boolean bool;
      if ((this.d != null) && (this.e != null) && (this.c.h()) && ((this.b.i()) || (this.b.h()))) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    protected e H(e parame)
    {
      if (parame.i()) {
        return parame;
      }
      e locale1 = n(c.a);
      int j = t();
      Random localRandom = new Random();
      e locale4;
      do
      {
        e locale2 = n(new BigInteger(j, localRandom));
        int k = 1;
        e locale3 = parame;
        locale4 = locale1;
        while (k < j)
        {
          locale3 = locale3.o();
          locale4 = locale4.o().a(locale3.j(locale2));
          locale3 = locale3.a(parame);
          k++;
        }
        if (!locale3.i()) {
          return null;
        }
      } while (locale4.o().a(locale4).i());
      return locale4;
    }
    
    public h h(BigInteger paramBigInteger1, BigInteger paramBigInteger2, boolean paramBoolean)
    {
      e locale = n(paramBigInteger1);
      paramBigInteger1 = n(paramBigInteger2);
      int j = r();
      if ((j == 5) || (j == 6)) {
        if (locale.i())
        {
          if (!paramBigInteger1.o().equals(p())) {
            throw new IllegalArgumentException();
          }
        }
        else {
          paramBigInteger1 = paramBigInteger1.d(locale).a(locale);
        }
      }
      return i(locale, paramBigInteger1, paramBoolean);
    }
    
    protected h l(int paramInt, BigInteger paramBigInteger)
    {
      e locale1 = n(paramBigInteger);
      if (locale1.i())
      {
        paramBigInteger = p().n();
      }
      else
      {
        e locale2 = H(locale1.o().g().j(p()).a(o()).a(locale1));
        if (locale2 != null)
        {
          boolean bool1 = locale2.s();
          boolean bool2;
          if (paramInt == 1) {
            bool2 = true;
          } else {
            bool2 = false;
          }
          paramBigInteger = locale2;
          if (bool1 != bool2) {
            paramBigInteger = locale2.b();
          }
          paramInt = r();
          if ((paramInt != 5) && (paramInt != 6)) {
            paramBigInteger = paramBigInteger.j(locale1);
          } else {
            paramBigInteger = paramBigInteger.a(locale1);
          }
        }
        else
        {
          paramBigInteger = null;
        }
      }
      if (paramBigInteger != null) {
        return i(locale1, paramBigInteger, true);
      }
      throw new IllegalArgumentException("Invalid point compression");
    }
  }
  
  public static abstract class c
    extends d
  {
    protected c(BigInteger paramBigInteger)
    {
      super();
    }
    
    protected h l(int paramInt, BigInteger paramBigInteger)
    {
      e locale1 = n(paramBigInteger);
      e locale2 = locale1.o().a(this.b).j(locale1).a(this.c).n();
      if (locale2 != null)
      {
        boolean bool1 = locale2.s();
        boolean bool2;
        if (paramInt == 1) {
          bool2 = true;
        } else {
          bool2 = false;
        }
        paramBigInteger = locale2;
        if (bool1 != bool2) {
          paramBigInteger = locale2.m();
        }
        return i(locale1, paramBigInteger, true);
      }
      throw new IllegalArgumentException("Invalid point compression");
    }
  }
  
  public class d
  {
    protected int a;
    protected e.a.b.a.b0.a b;
    protected g c;
    
    d(int paramInt, e.a.b.a.b0.a parama, g paramg)
    {
      this.a = paramInt;
      this.b = parama;
      this.c = paramg;
    }
    
    public d a()
    {
      if (d.this.C(this.a))
      {
        d locald = d.this.c();
        if (locald != d.this) {
          try
          {
            locald.f = this.a;
            locald.g = this.b;
            locald.h = this.c;
            return locald;
          }
          finally {}
        }
        throw new IllegalStateException("implementation returned current curve");
      }
      throw new IllegalStateException("unsupported coordinate system");
    }
    
    public d b(e.a.b.a.b0.a parama)
    {
      this.b = parama;
      return this;
    }
  }
  
  public static class e
    extends d.b
  {
    private int j;
    private int k;
    private int l;
    private int m;
    private h.d n;
    
    protected e(int paramInt1, int paramInt2, int paramInt3, int paramInt4, e parame1, e parame2, BigInteger paramBigInteger1, BigInteger paramBigInteger2)
    {
      super(paramInt2, paramInt3, paramInt4);
      this.j = paramInt1;
      this.k = paramInt2;
      this.l = paramInt3;
      this.m = paramInt4;
      this.d = paramBigInteger1;
      this.e = paramBigInteger2;
      this.n = new h.d(this, null, null, false);
      this.b = parame1;
      this.c = parame2;
      this.f = 6;
    }
    
    public e(int paramInt1, int paramInt2, int paramInt3, int paramInt4, BigInteger paramBigInteger1, BigInteger paramBigInteger2)
    {
      this(paramInt1, paramInt2, paramInt3, paramInt4, paramBigInteger1, paramBigInteger2, null, null);
    }
    
    public e(int paramInt1, int paramInt2, int paramInt3, int paramInt4, BigInteger paramBigInteger1, BigInteger paramBigInteger2, BigInteger paramBigInteger3, BigInteger paramBigInteger4)
    {
      super(paramInt2, paramInt3, paramInt4);
      this.j = paramInt1;
      this.k = paramInt2;
      this.l = paramInt3;
      this.m = paramInt4;
      this.d = paramBigInteger3;
      this.e = paramBigInteger4;
      this.n = new h.d(this, null, null, false);
      this.b = n(paramBigInteger1);
      this.c = n(paramBigInteger2);
      this.f = 6;
    }
    
    public e(int paramInt1, int paramInt2, BigInteger paramBigInteger1, BigInteger paramBigInteger2, BigInteger paramBigInteger3, BigInteger paramBigInteger4)
    {
      this(paramInt1, paramInt2, 0, 0, paramBigInteger1, paramBigInteger2, paramBigInteger3, paramBigInteger4);
    }
    
    public boolean C(int paramInt)
    {
      return (paramInt == 0) || (paramInt == 1) || (paramInt == 6);
    }
    
    public boolean J()
    {
      boolean bool;
      if ((this.l == 0) && (this.m == 0)) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    protected d c()
    {
      return new e(this.j, this.k, this.l, this.m, this.b, this.c, this.d, this.e);
    }
    
    public f e(h[] paramArrayOfh, int paramInt1, final int paramInt2)
    {
      final int i = this.j + 63 >>> 6;
      boolean bool = J();
      int i1 = 0;
      final int[] arrayOfInt;
      if (bool)
      {
        arrayOfInt = new int[1];
        arrayOfInt[0] = this.k;
      }
      else
      {
        arrayOfInt = new int[3];
        arrayOfInt[0] = this.k;
        arrayOfInt[1] = this.l;
        arrayOfInt[2] = this.m;
      }
      final long[] arrayOfLong = new long[paramInt2 * i * 2];
      int i2 = 0;
      while (i1 < paramInt2)
      {
        h localh = paramArrayOfh[(paramInt1 + i1)];
        ((e.c)localh.n()).j.k(arrayOfLong, i2);
        i2 += i;
        ((e.c)localh.o()).j.k(arrayOfLong, i2);
        i2 += i;
        i1++;
      }
      return new a(paramInt2, i, arrayOfLong, arrayOfInt);
    }
    
    protected g f()
    {
      if (G()) {
        return new x();
      }
      return super.f();
    }
    
    protected h i(e parame1, e parame2, boolean paramBoolean)
    {
      return new h.d(this, parame1, parame2, paramBoolean);
    }
    
    protected h j(e parame1, e parame2, e[] paramArrayOfe, boolean paramBoolean)
    {
      return new h.d(this, parame1, parame2, paramArrayOfe, paramBoolean);
    }
    
    public e n(BigInteger paramBigInteger)
    {
      return new e.c(this.j, this.k, this.l, this.m, paramBigInteger);
    }
    
    public int t()
    {
      return this.j;
    }
    
    public h u()
    {
      return this.n;
    }
    
    class a
      implements f
    {
      a(int paramInt1, int paramInt2, long[] paramArrayOfLong, int[] paramArrayOfInt) {}
      
      public int a()
      {
        return paramInt2;
      }
      
      public h b(int paramInt)
      {
        long[] arrayOfLong1 = e.a.b.c.m.k(i);
        long[] arrayOfLong2 = e.a.b.c.m.k(i);
        int i = 0;
        int j = 0;
        while (i < paramInt2)
        {
          long l1 = (i ^ paramInt) - 1 >> 31;
          int m;
          for (int k = 0;; k++)
          {
            m = i;
            if (k >= m) {
              break;
            }
            long l2 = arrayOfLong1[k];
            long[] arrayOfLong3 = arrayOfLong;
            arrayOfLong1[k] = (l2 ^ arrayOfLong3[(j + k)] & l1);
            arrayOfLong2[k] ^= arrayOfLong3[(m + j + k)] & l1;
          }
          j += m * 2;
          i++;
        }
        return d.e.this.i(new e.c(d.e.I(d.e.this), arrayOfInt, new n(arrayOfLong1)), new e.c(d.e.I(d.e.this), arrayOfInt, new n(arrayOfLong2)), false);
      }
    }
  }
  
  public static class f
    extends d.c
  {
    BigInteger i;
    BigInteger j;
    h.e k;
    
    protected f(BigInteger paramBigInteger1, BigInteger paramBigInteger2, e parame1, e parame2, BigInteger paramBigInteger3, BigInteger paramBigInteger4)
    {
      super();
      this.i = paramBigInteger1;
      this.j = paramBigInteger2;
      this.k = new h.e(this, null, null, false);
      this.b = parame1;
      this.c = parame2;
      this.d = paramBigInteger3;
      this.e = paramBigInteger4;
      this.f = 4;
    }
    
    public f(BigInteger paramBigInteger1, BigInteger paramBigInteger2, BigInteger paramBigInteger3)
    {
      this(paramBigInteger1, paramBigInteger2, paramBigInteger3, null, null);
    }
    
    public f(BigInteger paramBigInteger1, BigInteger paramBigInteger2, BigInteger paramBigInteger3, BigInteger paramBigInteger4, BigInteger paramBigInteger5)
    {
      super();
      this.i = paramBigInteger1;
      this.j = e.d.u(paramBigInteger1);
      this.k = new h.e(this, null, null, false);
      this.b = n(paramBigInteger2);
      this.c = n(paramBigInteger3);
      this.d = paramBigInteger4;
      this.e = paramBigInteger5;
      this.f = 4;
    }
    
    public boolean C(int paramInt)
    {
      return (paramInt == 0) || (paramInt == 1) || (paramInt == 2) || (paramInt == 4);
    }
    
    protected d c()
    {
      return new f(this.i, this.j, this.b, this.c, this.d, this.e);
    }
    
    protected h i(e parame1, e parame2, boolean paramBoolean)
    {
      return new h.e(this, parame1, parame2, paramBoolean);
    }
    
    protected h j(e parame1, e parame2, e[] paramArrayOfe, boolean paramBoolean)
    {
      return new h.e(this, parame1, parame2, paramArrayOfe, paramBoolean);
    }
    
    public e n(BigInteger paramBigInteger)
    {
      return new e.d(this.i, this.j, paramBigInteger);
    }
    
    public int t()
    {
      return this.i.bitLength();
    }
    
    public h u()
    {
      return this.k;
    }
    
    public h y(h paramh)
    {
      if ((this != paramh.i()) && (r() == 2) && (!paramh.u()))
      {
        int m = paramh.i().r();
        if ((m == 2) || (m == 3) || (m == 4))
        {
          e locale1 = n(paramh.c.t());
          e locale2 = n(paramh.d.t());
          e locale3 = n(paramh.e[0].t());
          boolean bool = paramh.f;
          return new h.e(this, locale1, locale2, new e[] { locale3 }, bool);
        }
      }
      return super.y(paramh);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\b\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */