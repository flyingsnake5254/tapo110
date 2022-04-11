package com.google.common.hash;

import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@Immutable
final class l
  extends a
  implements Serializable
{
  static final f c = new l(0);
  static final f d = new l(h.a);
  private final int f;
  
  l(int paramInt)
  {
    this.f = paramInt;
  }
  
  public g a()
  {
    return new a(this.f);
  }
  
  public boolean equals(@NullableDecl Object paramObject)
  {
    boolean bool1 = paramObject instanceof l;
    boolean bool2 = false;
    boolean bool3 = bool2;
    if (bool1)
    {
      paramObject = (l)paramObject;
      bool3 = bool2;
      if (this.f == ((l)paramObject).f) {
        bool3 = true;
      }
    }
    return bool3;
  }
  
  public int hashCode()
  {
    return l.class.hashCode() ^ this.f;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Hashing.murmur3_128(");
    localStringBuilder.append(this.f);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  private static final class a
    extends c
  {
    private long d;
    private long e;
    private int f;
    
    a(int paramInt)
    {
      super();
      long l = paramInt;
      this.d = l;
      this.e = l;
      this.f = 0;
    }
    
    private void f(long paramLong1, long paramLong2)
    {
      long l = this.d;
      paramLong1 = h(paramLong1) ^ l;
      this.d = paramLong1;
      l = Long.rotateLeft(paramLong1, 27);
      this.d = l;
      paramLong1 = this.e;
      l += paramLong1;
      this.d = l;
      this.d = (l * 5L + 1390208809L);
      paramLong1 = i(paramLong2) ^ paramLong1;
      this.e = paramLong1;
      paramLong1 = Long.rotateLeft(paramLong1, 31);
      this.e = paramLong1;
      paramLong1 += this.d;
      this.e = paramLong1;
      this.e = (paramLong1 * 5L + 944331445L);
    }
    
    private static long g(long paramLong)
    {
      paramLong = (paramLong ^ paramLong >>> 33) * -49064778989728563L;
      paramLong = (paramLong ^ paramLong >>> 33) * -4265267296055464877L;
      return paramLong ^ paramLong >>> 33;
    }
    
    private static long h(long paramLong)
    {
      return Long.rotateLeft(paramLong * -8663945395140668459L, 31) * 5545529020109919103L;
    }
    
    private static long i(long paramLong)
    {
      return Long.rotateLeft(paramLong * 5545529020109919103L, 33) * -8663945395140668459L;
    }
    
    public e b()
    {
      long l1 = this.d;
      int i = this.f;
      long l2 = l1 ^ i;
      this.d = l2;
      l1 = this.e ^ i;
      this.e = l1;
      l2 += l1;
      this.d = l2;
      this.e = (l1 + l2);
      this.d = g(l2);
      l1 = g(this.e);
      this.e = l1;
      l2 = this.d + l1;
      this.d = l2;
      this.e = (l1 + l2);
      return e.h(ByteBuffer.wrap(new byte[16]).order(ByteOrder.LITTLE_ENDIAN).putLong(this.d).putLong(this.e).array());
    }
    
    protected void d(ByteBuffer paramByteBuffer)
    {
      f(paramByteBuffer.getLong(), paramByteBuffer.getLong());
      this.f += 16;
    }
    
    protected void e(ByteBuffer paramByteBuffer)
    {
      this.f += paramByteBuffer.remaining();
      int i = paramByteBuffer.remaining();
      long l1 = 0L;
      switch (i)
      {
      default: 
        throw new AssertionError("Should never get here.");
      case 15: 
        l2 = com.google.common.primitives.h.b(paramByteBuffer.get(14)) << 48 ^ 0L;
        break;
      case 14: 
        l2 = 0L;
        l2 ^= com.google.common.primitives.h.b(paramByteBuffer.get(13)) << 40;
        break;
      case 13: 
        l2 = 0L;
        l2 ^= com.google.common.primitives.h.b(paramByteBuffer.get(12)) << 32;
        break;
      case 12: 
        l2 = 0L;
        l2 ^= com.google.common.primitives.h.b(paramByteBuffer.get(11)) << 24;
        break;
      case 11: 
        l2 = 0L;
        l2 ^= com.google.common.primitives.h.b(paramByteBuffer.get(10)) << 16;
        break;
      case 10: 
        l2 = 0L;
        l2 ^= com.google.common.primitives.h.b(paramByteBuffer.get(9)) << 8;
        break;
      case 9: 
        l2 = 0L;
        l2 ^= com.google.common.primitives.h.b(paramByteBuffer.get(8));
        break;
      case 8: 
        l2 = 0L;
        l1 = paramByteBuffer.getLong() ^ 0L;
        break;
      case 7: 
        l2 = com.google.common.primitives.h.b(paramByteBuffer.get(6)) << 48 ^ 0L;
        break;
      case 6: 
        l2 = 0L;
        l2 ^= com.google.common.primitives.h.b(paramByteBuffer.get(5)) << 40;
        break;
      case 5: 
        l2 = 0L;
        l2 ^= com.google.common.primitives.h.b(paramByteBuffer.get(4)) << 32;
        break;
      case 4: 
        l2 = 0L;
        l2 ^= com.google.common.primitives.h.b(paramByteBuffer.get(3)) << 24;
        break;
      case 3: 
        l2 = 0L;
        l2 ^= com.google.common.primitives.h.b(paramByteBuffer.get(2)) << 16;
        break;
      case 2: 
        l2 = 0L;
        l2 ^= com.google.common.primitives.h.b(paramByteBuffer.get(1)) << 8;
        break;
      }
      long l2 = 0L;
      long l3 = com.google.common.primitives.h.b(paramByteBuffer.get(0)) ^ l2;
      l2 = l1;
      l1 = l3;
      this.d ^= h(l1);
      this.e ^= i(l2);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\hash\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */