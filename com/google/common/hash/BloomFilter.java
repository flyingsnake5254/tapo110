package com.google.common.hash;

import com.google.common.base.k;
import com.google.common.base.n;
import com.google.common.base.o;
import com.google.common.math.a;
import com.google.common.primitives.g;
import com.google.common.primitives.h;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.math.RoundingMode;
import java.util.concurrent.atomic.AtomicLongArray;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class BloomFilter<T>
  implements o<T>, Serializable
{
  private final d.c bits;
  private final Funnel<? super T> funnel;
  private final int numHashFunctions;
  private final c strategy;
  
  private BloomFilter(d.c paramc, int paramInt, Funnel<? super T> paramFunnel, c paramc1)
  {
    boolean bool1 = true;
    boolean bool2;
    if (paramInt > 0) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    n.f(bool2, "numHashFunctions (%s) must be > 0", paramInt);
    if (paramInt <= 255) {
      bool2 = bool1;
    } else {
      bool2 = false;
    }
    n.f(bool2, "numHashFunctions (%s) must be <= 255", paramInt);
    this.bits = ((d.c)n.o(paramc));
    this.numHashFunctions = paramInt;
    this.funnel = ((Funnel)n.o(paramFunnel));
    this.strategy = ((c)n.o(paramc1));
  }
  
  public static <T> BloomFilter<T> create(Funnel<? super T> paramFunnel, int paramInt)
  {
    return create(paramFunnel, paramInt);
  }
  
  public static <T> BloomFilter<T> create(Funnel<? super T> paramFunnel, int paramInt, double paramDouble)
  {
    return create(paramFunnel, paramInt, paramDouble);
  }
  
  public static <T> BloomFilter<T> create(Funnel<? super T> paramFunnel, long paramLong)
  {
    return create(paramFunnel, paramLong, 0.03D);
  }
  
  public static <T> BloomFilter<T> create(Funnel<? super T> paramFunnel, long paramLong, double paramDouble)
  {
    return create(paramFunnel, paramLong, paramDouble, d.d);
  }
  
  static <T> BloomFilter<T> create(Funnel<? super T> paramFunnel, long paramLong, double paramDouble, c paramc)
  {
    n.o(paramFunnel);
    boolean bool1 = true;
    boolean bool2 = paramLong < 0L;
    boolean bool3;
    if (!bool2) {
      bool3 = true;
    } else {
      bool3 = false;
    }
    n.h(bool3, "Expected insertions (%s) must be >= 0", paramLong);
    if (paramDouble > 0.0D) {
      bool3 = true;
    } else {
      bool3 = false;
    }
    n.j(bool3, "False positive probability (%s) must be > 0.0", Double.valueOf(paramDouble));
    if (paramDouble < 1.0D) {
      bool3 = bool1;
    } else {
      bool3 = false;
    }
    n.j(bool3, "False positive probability (%s) must be < 1.0", Double.valueOf(paramDouble));
    n.o(paramc);
    if (!bool2) {
      paramLong = 1L;
    }
    long l = optimalNumOfBits(paramLong, paramDouble);
    int i = optimalNumOfHashFunctions(paramLong, l);
    try
    {
      d.c localc = new com/google/common/hash/d$c;
      localc.<init>(l);
      paramFunnel = new BloomFilter(localc, i, paramFunnel, paramc);
      return paramFunnel;
    }
    catch (IllegalArgumentException paramFunnel)
    {
      paramc = new StringBuilder();
      paramc.append("Could not create BloomFilter of ");
      paramc.append(l);
      paramc.append(" bits");
      throw new IllegalArgumentException(paramc.toString(), paramFunnel);
    }
  }
  
  static long optimalNumOfBits(long paramLong, double paramDouble)
  {
    double d = paramDouble;
    if (paramDouble == 0.0D) {
      d = Double.MIN_VALUE;
    }
    return (-paramLong * Math.log(d) / (Math.log(2.0D) * Math.log(2.0D)));
  }
  
  static int optimalNumOfHashFunctions(long paramLong1, long paramLong2)
  {
    return Math.max(1, (int)Math.round(paramLong2 / paramLong1 * Math.log(2.0D)));
  }
  
  /* Error */
  public static <T> BloomFilter<T> readFrom(java.io.InputStream paramInputStream, Funnel<? super T> paramFunnel)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc -80
    //   3: invokestatic 180	com/google/common/base/n:p	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   6: pop
    //   7: aload_1
    //   8: ldc -74
    //   10: invokestatic 180	com/google/common/base/n:p	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   13: pop
    //   14: iconst_m1
    //   15: istore_2
    //   16: new 184	java/io/DataInputStream
    //   19: astore_3
    //   20: aload_3
    //   21: aload_0
    //   22: invokespecial 187	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   25: aload_3
    //   26: invokevirtual 191	java/io/DataInputStream:readByte	()B
    //   29: istore 4
    //   31: aload_3
    //   32: invokevirtual 191	java/io/DataInputStream:readByte	()B
    //   35: invokestatic 196	com/google/common/primitives/h:b	(B)I
    //   38: istore 5
    //   40: aload_3
    //   41: invokevirtual 200	java/io/DataInputStream:readInt	()I
    //   44: istore_2
    //   45: invokestatic 204	com/google/common/hash/d:values	()[Lcom/google/common/hash/d;
    //   48: iload 4
    //   50: aaload
    //   51: astore 6
    //   53: iload_2
    //   54: newarray <illegal type>
    //   56: astore_0
    //   57: iconst_0
    //   58: istore 7
    //   60: iload 7
    //   62: iload_2
    //   63: if_icmpge +17 -> 80
    //   66: aload_0
    //   67: iload 7
    //   69: aload_3
    //   70: invokevirtual 208	java/io/DataInputStream:readLong	()J
    //   73: lastore
    //   74: iinc 7 1
    //   77: goto -17 -> 60
    //   80: new 47	com/google/common/hash/d$c
    //   83: astore_3
    //   84: aload_3
    //   85: aload_0
    //   86: invokespecial 211	com/google/common/hash/d$c:<init>	([J)V
    //   89: new 2	com/google/common/hash/BloomFilter
    //   92: dup
    //   93: aload_3
    //   94: iload 5
    //   96: aload_1
    //   97: aload 6
    //   99: invokespecial 63	com/google/common/hash/BloomFilter:<init>	(Lcom/google/common/hash/d$c;ILcom/google/common/hash/Funnel;Lcom/google/common/hash/BloomFilter$c;)V
    //   102: astore_0
    //   103: aload_0
    //   104: areturn
    //   105: astore_0
    //   106: iload_2
    //   107: istore 7
    //   109: goto +27 -> 136
    //   112: astore_0
    //   113: goto +7 -> 120
    //   116: astore_0
    //   117: iconst_m1
    //   118: istore 5
    //   120: iconst_m1
    //   121: istore 7
    //   123: goto +13 -> 136
    //   126: astore_0
    //   127: iconst_m1
    //   128: istore 7
    //   130: iconst_m1
    //   131: istore 5
    //   133: iload_2
    //   134: istore 4
    //   136: new 130	java/lang/StringBuilder
    //   139: dup
    //   140: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   143: astore_1
    //   144: aload_1
    //   145: ldc -43
    //   147: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: pop
    //   151: aload_1
    //   152: iload 4
    //   154: invokevirtual 216	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   157: pop
    //   158: aload_1
    //   159: ldc -38
    //   161: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: aload_1
    //   166: iload 5
    //   168: invokevirtual 216	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   171: pop
    //   172: aload_1
    //   173: ldc -36
    //   175: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: pop
    //   179: aload_1
    //   180: iload 7
    //   182: invokevirtual 216	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   185: pop
    //   186: new 172	java/io/IOException
    //   189: dup
    //   190: aload_1
    //   191: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   194: aload_0
    //   195: invokespecial 221	java/io/IOException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   198: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	199	0	paramInputStream	java.io.InputStream
    //   0	199	1	paramFunnel	Funnel<? super T>
    //   15	119	2	i	int
    //   19	75	3	localObject	Object
    //   29	124	4	j	int
    //   38	129	5	k	int
    //   51	47	6	locald	d
    //   58	123	7	m	int
    // Exception table:
    //   from	to	target	type
    //   45	57	105	java/lang/RuntimeException
    //   66	74	105	java/lang/RuntimeException
    //   80	103	105	java/lang/RuntimeException
    //   40	45	112	java/lang/RuntimeException
    //   31	40	116	java/lang/RuntimeException
    //   16	31	126	java/lang/RuntimeException
  }
  
  private Object writeReplace()
  {
    return new b(this);
  }
  
  @Deprecated
  public boolean apply(T paramT)
  {
    return mightContain(paramT);
  }
  
  public long approximateElementCount()
  {
    long l = this.bits.b();
    double d1 = this.bits.a();
    double d2 = l;
    return a.c(-Math.log1p(-(d1 / d2)) * d2 / this.numHashFunctions, RoundingMode.HALF_UP);
  }
  
  long bitSize()
  {
    return this.bits.b();
  }
  
  public BloomFilter<T> copy()
  {
    return new BloomFilter(this.bits.c(), this.numHashFunctions, this.funnel, this.strategy);
  }
  
  public boolean equals(@NullableDecl Object paramObject)
  {
    boolean bool = true;
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof BloomFilter))
    {
      paramObject = (BloomFilter)paramObject;
      if ((this.numHashFunctions != ((BloomFilter)paramObject).numHashFunctions) || (!this.funnel.equals(((BloomFilter)paramObject).funnel)) || (!this.bits.equals(((BloomFilter)paramObject).bits)) || (!this.strategy.equals(((BloomFilter)paramObject).strategy))) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public double expectedFpp()
  {
    return Math.pow(this.bits.a() / bitSize(), this.numHashFunctions);
  }
  
  public int hashCode()
  {
    return k.b(new Object[] { Integer.valueOf(this.numHashFunctions), this.funnel, this.strategy, this.bits });
  }
  
  public boolean isCompatible(BloomFilter<T> paramBloomFilter)
  {
    n.o(paramBloomFilter);
    boolean bool;
    if ((this != paramBloomFilter) && (this.numHashFunctions == paramBloomFilter.numHashFunctions) && (bitSize() == paramBloomFilter.bitSize()) && (this.strategy.equals(paramBloomFilter.strategy)) && (this.funnel.equals(paramBloomFilter.funnel))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean mightContain(T paramT)
  {
    return this.strategy.c(paramT, this.funnel, this.numHashFunctions, this.bits);
  }
  
  @CanIgnoreReturnValue
  public boolean put(T paramT)
  {
    return this.strategy.e(paramT, this.funnel, this.numHashFunctions, this.bits);
  }
  
  public void putAll(BloomFilter<T> paramBloomFilter)
  {
    n.o(paramBloomFilter);
    boolean bool;
    if (this != paramBloomFilter) {
      bool = true;
    } else {
      bool = false;
    }
    n.e(bool, "Cannot combine a BloomFilter with itself.");
    int i = this.numHashFunctions;
    int j = paramBloomFilter.numHashFunctions;
    if (i == j) {
      bool = true;
    } else {
      bool = false;
    }
    n.g(bool, "BloomFilters must have the same number of hash functions (%s != %s)", i, j);
    if (bitSize() == paramBloomFilter.bitSize()) {
      bool = true;
    } else {
      bool = false;
    }
    n.i(bool, "BloomFilters must have the same size underlying bit arrays (%s != %s)", bitSize(), paramBloomFilter.bitSize());
    n.k(this.strategy.equals(paramBloomFilter.strategy), "BloomFilters must have equal strategies (%s != %s)", this.strategy, paramBloomFilter.strategy);
    n.k(this.funnel.equals(paramBloomFilter.funnel), "BloomFilters must have equal funnels (%s != %s)", this.funnel, paramBloomFilter.funnel);
    this.bits.e(paramBloomFilter.bits);
  }
  
  public void writeTo(OutputStream paramOutputStream)
    throws IOException
  {
    paramOutputStream = new DataOutputStream(paramOutputStream);
    paramOutputStream.writeByte(g.a(this.strategy.ordinal()));
    paramOutputStream.writeByte(h.a(this.numHashFunctions));
    paramOutputStream.writeInt(this.bits.a.length());
    for (int i = 0; i < this.bits.a.length(); i++) {
      paramOutputStream.writeLong(this.bits.a.get(i));
    }
  }
  
  private static class b<T>
    implements Serializable
  {
    final long[] c;
    final int d;
    final Funnel<? super T> f;
    final BloomFilter.c q;
    
    b(BloomFilter<T> paramBloomFilter)
    {
      this.c = d.c.g(paramBloomFilter.bits.a);
      this.d = paramBloomFilter.numHashFunctions;
      this.f = paramBloomFilter.funnel;
      this.q = paramBloomFilter.strategy;
    }
  }
  
  static abstract interface c
    extends Serializable
  {
    public abstract <T> boolean c(T paramT, Funnel<? super T> paramFunnel, int paramInt, d.c paramc);
    
    public abstract <T> boolean e(T paramT, Funnel<? super T> paramFunnel, int paramInt, d.c paramc);
    
    public abstract int ordinal();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\hash\BloomFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */