package com.bumptech.glide.l;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.util.Log;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class e
  implements a
{
  private static final String a = "e";
  @ColorInt
  private int[] b;
  @ColorInt
  private final int[] c = new int['Ā'];
  private final a.a d;
  private ByteBuffer e;
  private byte[] f;
  private short[] g;
  private byte[] h;
  private byte[] i;
  private byte[] j;
  @ColorInt
  private int[] k;
  private int l;
  private c m;
  private Bitmap n;
  private boolean o;
  private int p;
  private int q;
  private int r;
  private int s;
  @Nullable
  private Boolean t;
  @NonNull
  private Bitmap.Config u = Bitmap.Config.ARGB_8888;
  
  public e(@NonNull a.a parama)
  {
    this.d = parama;
    this.m = new c();
  }
  
  public e(@NonNull a.a parama, c paramc, ByteBuffer paramByteBuffer, int paramInt)
  {
    this(parama);
    q(paramc, paramByteBuffer, paramInt);
  }
  
  @ColorInt
  private int i(int paramInt1, int paramInt2, int paramInt3)
  {
    int i1 = paramInt1;
    int i2 = 0;
    int i3 = 0;
    int i4 = 0;
    int i5 = 0;
    byte[] arrayOfByte;
    int i7;
    int i9;
    int i11;
    for (int i6 = 0; i1 < this.q + paramInt1; i6 = i7)
    {
      arrayOfByte = this.j;
      if ((i1 >= arrayOfByte.length) || (i1 >= paramInt2)) {
        break;
      }
      i7 = arrayOfByte[i1];
      int i8 = this.b[(i7 & 0xFF)];
      i9 = i2;
      i10 = i3;
      i11 = i4;
      i12 = i5;
      i7 = i6;
      if (i8 != 0)
      {
        i9 = i2 + (i8 >> 24 & 0xFF);
        i10 = i3 + (i8 >> 16 & 0xFF);
        i11 = i4 + (i8 >> 8 & 0xFF);
        i12 = i5 + (i8 & 0xFF);
        i7 = i6 + 1;
      }
      i1++;
      i2 = i9;
      i3 = i10;
      i4 = i11;
      i5 = i12;
    }
    int i10 = paramInt1 + paramInt3;
    paramInt1 = i10;
    int i12 = i2;
    while (paramInt1 < this.q + i10)
    {
      arrayOfByte = this.j;
      if ((paramInt1 >= arrayOfByte.length) || (paramInt1 >= paramInt2)) {
        break;
      }
      paramInt3 = arrayOfByte[paramInt1];
      i9 = this.b[(paramInt3 & 0xFF)];
      i11 = i12;
      i7 = i3;
      i1 = i4;
      i2 = i5;
      paramInt3 = i6;
      if (i9 != 0)
      {
        i11 = i12 + (i9 >> 24 & 0xFF);
        i7 = i3 + (i9 >> 16 & 0xFF);
        i1 = i4 + (i9 >> 8 & 0xFF);
        i2 = i5 + (i9 & 0xFF);
        paramInt3 = i6 + 1;
      }
      paramInt1++;
      i12 = i11;
      i3 = i7;
      i4 = i1;
      i5 = i2;
      i6 = paramInt3;
    }
    if (i6 == 0) {
      return 0;
    }
    return i12 / i6 << 24 | i3 / i6 << 16 | i4 / i6 << 8 | i5 / i6;
  }
  
  private void j(b paramb)
  {
    int[] arrayOfInt1 = this.k;
    int i1 = paramb.d;
    int i2 = this.q;
    int i3 = i1 / i2;
    int i4 = paramb.b / i2;
    int i5 = paramb.c / i2;
    int i6 = paramb.a / i2;
    int i7;
    if (this.l == 0) {
      i7 = 1;
    } else {
      i7 = 0;
    }
    int i8 = this.s;
    int i9 = this.r;
    byte[] arrayOfByte = this.j;
    int[] arrayOfInt2 = this.b;
    Object localObject1 = this.t;
    int i10 = 8;
    int i11 = 0;
    int i12 = 0;
    int i14;
    for (i1 = 1; i11 < i3; i1 = i14)
    {
      int i13;
      if (paramb.e)
      {
        if (i12 >= i3)
        {
          i1++;
          if (i1 != 2)
          {
            if (i1 != 3)
            {
              if (i1 == 4)
              {
                i12 = 1;
                i10 = 2;
              }
            }
            else
            {
              i12 = 2;
              i10 = 4;
            }
          }
          else {
            i12 = 4;
          }
        }
        i13 = i12 + i10;
        i14 = i1;
      }
      else
      {
        i13 = i12;
        i12 = i11;
        i14 = i1;
      }
      i12 += i4;
      if (i2 == 1) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if (i12 < i9)
      {
        int i15 = i12 * i8;
        int i16 = i15 + i6;
        i12 = i16 + i5;
        int i17 = i15 + i8;
        i15 = i12;
        if (i17 < i12) {
          i15 = i17;
        }
        i17 = i11 * i2 * paramb.c;
        if (i1 != 0)
        {
          i12 = i16;
          for (;;)
          {
            i1 = i4;
            localObject2 = localObject1;
            if (i12 >= i15) {
              break;
            }
            i1 = arrayOfInt2[(arrayOfByte[i17] & 0xFF)];
            if (i1 != 0)
            {
              arrayOfInt1[i12] = i1;
              localObject2 = localObject1;
            }
            else
            {
              localObject2 = localObject1;
              if (i7 != 0)
              {
                localObject2 = localObject1;
                if (localObject1 == null) {
                  localObject2 = Boolean.TRUE;
                }
              }
            }
            i17 += i2;
            i12++;
            localObject1 = localObject2;
          }
        }
        int i18 = i4;
        i12 = i16;
        i4 = i17;
        i1 = i5;
        i5 = i12;
        for (;;)
        {
          int i19 = i4;
          i12 = i18;
          localObject2 = localObject1;
          i4 = i1;
          if (i5 >= i15) {
            break;
          }
          i4 = i(i19, (i15 - i16) * i2 + i17, paramb.c);
          if (i4 != 0)
          {
            arrayOfInt1[i5] = i4;
            localObject2 = localObject1;
          }
          else
          {
            localObject2 = localObject1;
            if (i7 != 0)
            {
              localObject2 = localObject1;
              if (localObject1 == null) {
                localObject2 = Boolean.TRUE;
              }
            }
          }
          i4 = i19 + i2;
          i5++;
          localObject1 = localObject2;
        }
      }
      Object localObject2 = localObject1;
      i1 = i4;
      i4 = i5;
      i12 = i1;
      localObject1 = localObject2;
      i11++;
      i1 = i12;
      i5 = i4;
      i12 = i13;
      i4 = i1;
    }
    if (this.t == null)
    {
      boolean bool;
      if (localObject1 == null) {
        bool = false;
      } else {
        bool = ((Boolean)localObject1).booleanValue();
      }
      this.t = Boolean.valueOf(bool);
    }
  }
  
  private void k(b paramb)
  {
    Object localObject = paramb;
    int[] arrayOfInt1 = this.k;
    int i1 = ((b)localObject).d;
    int i2 = ((b)localObject).b;
    int i3 = ((b)localObject).c;
    int i4 = ((b)localObject).a;
    int i5;
    if (this.l == 0) {
      i5 = 1;
    } else {
      i5 = 0;
    }
    int i6 = this.s;
    localObject = this.j;
    int[] arrayOfInt2 = this.b;
    int i7 = 0;
    int i8 = -1;
    while (i7 < i1)
    {
      int i9 = (i7 + i2) * i6;
      int i10 = i9 + i4;
      int i11 = i10 + i3;
      int i12 = i9 + i6;
      i9 = i11;
      if (i12 < i11) {
        i9 = i12;
      }
      i11 = paramb.c * i7;
      while (i10 < i9)
      {
        int i13 = localObject[i11];
        int i14 = i13 & 0xFF;
        i12 = i8;
        if (i14 != i8)
        {
          i12 = arrayOfInt2[i14];
          if (i12 != 0)
          {
            arrayOfInt1[i10] = i12;
            i12 = i8;
          }
          else
          {
            i12 = i13;
          }
        }
        i11++;
        i10++;
        i8 = i12;
      }
      i7++;
    }
    paramb = this.t;
    boolean bool;
    if (((paramb != null) && (paramb.booleanValue())) || ((this.t == null) && (i5 != 0) && (i8 != -1))) {
      bool = true;
    } else {
      bool = false;
    }
    this.t = Boolean.valueOf(bool);
  }
  
  private void l(b paramb)
  {
    Object localObject = this;
    if (paramb != null) {
      ((e)localObject).e.position(paramb.j);
    }
    if (paramb == null)
    {
      paramb = ((e)localObject).m;
      i1 = paramb.f;
      i2 = paramb.g;
    }
    else
    {
      i1 = paramb.c;
      i2 = paramb.d;
    }
    int i3 = i1 * i2;
    paramb = ((e)localObject).j;
    if ((paramb == null) || (paramb.length < i3)) {
      ((e)localObject).j = ((e)localObject).d.b(i3);
    }
    byte[] arrayOfByte1 = ((e)localObject).j;
    if (((e)localObject).g == null) {
      ((e)localObject).g = new short['က'];
    }
    short[] arrayOfShort = ((e)localObject).g;
    if (((e)localObject).h == null) {
      ((e)localObject).h = new byte['က'];
    }
    byte[] arrayOfByte2 = ((e)localObject).h;
    if (((e)localObject).i == null) {
      ((e)localObject).i = new byte['ခ'];
    }
    paramb = ((e)localObject).i;
    int i1 = p();
    int i4 = 1 << i1;
    int i5 = i4 + 2;
    int i6 = i1 + 1;
    int i7 = (1 << i6) - 1;
    int i8 = 0;
    for (i1 = 0; i1 < i4; i1++)
    {
      arrayOfShort[i1] = ((short)0);
      arrayOfByte2[i1] = ((byte)(byte)i1);
    }
    localObject = ((e)localObject).f;
    i1 = i6;
    int i9 = i5;
    int i10 = i7;
    int i11 = 0;
    int i12 = 0;
    int i13 = 0;
    int i14 = 0;
    int i15 = 0;
    int i2 = -1;
    int i16 = 0;
    int i17 = 0;
    while (i8 < i3)
    {
      int i18 = i11;
      if (i11 == 0)
      {
        i18 = o();
        if (i18 <= 0)
        {
          this.p = 3;
          break;
        }
        i12 = 0;
      }
      i14 += ((localObject[i12] & 0xFF) << i13);
      int i19 = i12 + 1;
      int i20 = i18 - 1;
      i18 = i13 + 8;
      i13 = i9;
      i9 = i1;
      i1 = i2;
      i12 = i16;
      i11 = i8;
      i2 = i5;
      i16 = i13;
      i5 = i12;
      i13 = i18;
      for (;;)
      {
        if (i13 < i9) {
          break label741;
        }
        i12 = i14 & i10;
        i14 >>= i9;
        i13 -= i9;
        if (i12 == i4)
        {
          i10 = i7;
          i9 = i6;
          i12 = i2;
          i1 = -1;
          i16 = i2;
          i2 = i12;
        }
        else
        {
          if (i12 == i4 + 1)
          {
            i18 = i5;
            i5 = i2;
            i2 = i1;
            i1 = i9;
            i8 = i11;
            i11 = i20;
            i12 = i19;
            i9 = i16;
            i16 = i18;
            break;
          }
          if (i1 == -1)
          {
            arrayOfByte1[i15] = ((byte)arrayOfByte2[i12]);
            i15++;
            i11++;
            i1 = i12;
            i5 = i1;
          }
          else
          {
            if (i12 >= i16)
            {
              paramb[i17] = ((byte)(byte)i5);
              i5 = i17 + 1;
              i17 = i1;
            }
            else
            {
              i8 = i12;
              i5 = i17;
            }
            for (i17 = i8; i17 >= i4; i17 = arrayOfShort[i17])
            {
              paramb[i5] = ((byte)arrayOfByte2[i17]);
              i5++;
            }
            int i21 = arrayOfByte2[i17] & 0xFF;
            int i22 = (byte)i21;
            arrayOfByte1[i15] = ((byte)i22);
            i17 = i5;
            for (;;)
            {
              i15++;
              i11++;
              if (i17 <= 0) {
                break;
              }
              i17--;
              arrayOfByte1[i15] = ((byte)paramb[i17]);
            }
            i23 = i16;
            i18 = i9;
            i8 = i10;
            if (i16 < 4096)
            {
              arrayOfShort[i16] = ((short)(short)i1);
              arrayOfByte2[i16] = ((byte)i22);
              i1 = i16 + 1;
              i23 = i1;
              i18 = i9;
              i8 = i10;
              if ((i1 & i10) == 0)
              {
                i23 = i1;
                i18 = i9;
                i8 = i10;
                if (i1 < 4096)
                {
                  i18 = i9 + 1;
                  i8 = i10 + i1;
                  i23 = i1;
                }
              }
            }
            i1 = i12;
            i5 = i21;
            i16 = i23;
            i9 = i18;
            i10 = i8;
          }
        }
      }
      label741:
      i18 = i1;
      i1 = i16;
      i16 = i5;
      int i23 = i9;
      i5 = i2;
      i8 = i11;
      i11 = i20;
      i12 = i19;
      i9 = i1;
      i1 = i23;
      i2 = i18;
    }
    Arrays.fill(arrayOfByte1, i15, i3, (byte)0);
  }
  
  private Bitmap n()
  {
    Object localObject = this.t;
    if ((localObject != null) && (!((Boolean)localObject).booleanValue())) {
      localObject = this.u;
    } else {
      localObject = Bitmap.Config.ARGB_8888;
    }
    localObject = this.d.c(this.s, this.r, (Bitmap.Config)localObject);
    ((Bitmap)localObject).setHasAlpha(true);
    return (Bitmap)localObject;
  }
  
  private int o()
  {
    int i1 = p();
    if (i1 <= 0) {
      return i1;
    }
    ByteBuffer localByteBuffer = this.e;
    localByteBuffer.get(this.f, 0, Math.min(i1, localByteBuffer.remaining()));
    return i1;
  }
  
  private int p()
  {
    return this.e.get() & 0xFF;
  }
  
  private Bitmap r(b paramb1, b paramb2)
  {
    int[] arrayOfInt = this.k;
    int i1 = 0;
    Object localObject;
    if (paramb2 == null)
    {
      localObject = this.n;
      if (localObject != null) {
        this.d.a((Bitmap)localObject);
      }
      this.n = null;
      Arrays.fill(arrayOfInt, 0);
    }
    if ((paramb2 != null) && (paramb2.g == 3) && (this.n == null)) {
      Arrays.fill(arrayOfInt, 0);
    }
    if (paramb2 != null)
    {
      int i2 = paramb2.g;
      if (i2 > 0)
      {
        if (i2 == 2)
        {
          i2 = i1;
          if (!paramb1.f)
          {
            localObject = this.m;
            i2 = ((c)localObject).l;
            if ((paramb1.k != null) && (((c)localObject).j == paramb1.h)) {
              i2 = i1;
            }
          }
          i1 = paramb2.d;
          int i3 = this.q;
          int i4 = i1 / i3;
          i1 = paramb2.b / i3;
          int i5 = paramb2.c / i3;
          i3 = paramb2.a / i3;
          int i6 = this.s;
          int i7 = i1 * i6 + i3;
          i1 = i7;
          while (i1 < i4 * i6 + i7)
          {
            for (i3 = i1; i3 < i1 + i5; i3++) {
              arrayOfInt[i3] = i2;
            }
            i1 += this.s;
          }
        }
        if (i2 == 3)
        {
          paramb2 = this.n;
          if (paramb2 != null)
          {
            i1 = this.s;
            paramb2.getPixels(arrayOfInt, 0, i1, 0, 0, i1, this.r);
          }
        }
      }
    }
    l(paramb1);
    if ((!paramb1.e) && (this.q == 1)) {
      k(paramb1);
    } else {
      j(paramb1);
    }
    if (this.o)
    {
      i1 = paramb1.g;
      if ((i1 == 0) || (i1 == 1))
      {
        if (this.n == null) {
          this.n = n();
        }
        paramb1 = this.n;
        i1 = this.s;
        paramb1.setPixels(arrayOfInt, 0, i1, 0, 0, i1, this.r);
      }
    }
    paramb1 = n();
    i1 = this.s;
    paramb1.setPixels(arrayOfInt, 0, i1, 0, 0, i1, this.r);
    return paramb1;
  }
  
  @Nullable
  public Bitmap a()
  {
    try
    {
      Object localObject2;
      if ((this.m.c <= 0) || (this.l < 0))
      {
        localObject1 = a;
        if (Log.isLoggable((String)localObject1, 3))
        {
          localObject2 = new java/lang/StringBuilder;
          ((StringBuilder)localObject2).<init>();
          ((StringBuilder)localObject2).append("Unable to decode frame, frameCount=");
          ((StringBuilder)localObject2).append(this.m.c);
          ((StringBuilder)localObject2).append(", framePointer=");
          ((StringBuilder)localObject2).append(this.l);
          Log.d((String)localObject1, ((StringBuilder)localObject2).toString());
        }
        this.p = 1;
      }
      int i1 = this.p;
      if ((i1 != 1) && (i1 != 2))
      {
        this.p = 0;
        if (this.f == null) {
          this.f = this.d.b(255);
        }
        b localb = (b)this.m.e.get(this.l);
        i1 = this.l - 1;
        if (i1 >= 0) {
          localObject2 = (b)this.m.e.get(i1);
        } else {
          localObject2 = null;
        }
        localObject1 = localb.k;
        if (localObject1 == null) {
          localObject1 = this.m.a;
        }
        this.b = ((int[])localObject1);
        if (localObject1 == null)
        {
          localObject2 = a;
          if (Log.isLoggable((String)localObject2, 3))
          {
            localObject1 = new java/lang/StringBuilder;
            ((StringBuilder)localObject1).<init>();
            ((StringBuilder)localObject1).append("No valid color table found for frame #");
            ((StringBuilder)localObject1).append(this.l);
            Log.d((String)localObject2, ((StringBuilder)localObject1).toString());
          }
          this.p = 1;
          return null;
        }
        if (localb.f)
        {
          System.arraycopy(localObject1, 0, this.c, 0, localObject1.length);
          localObject1 = this.c;
          this.b = ((int[])localObject1);
          localObject1[localb.h] = 0;
          if ((localb.g == 2) && (this.l == 0)) {
            this.t = Boolean.TRUE;
          }
        }
        localObject2 = r(localb, (b)localObject2);
        return (Bitmap)localObject2;
      }
      Object localObject1 = a;
      if (Log.isLoggable((String)localObject1, 3))
      {
        localObject2 = new java/lang/StringBuilder;
        ((StringBuilder)localObject2).<init>();
        ((StringBuilder)localObject2).append("Unable to decode frame, status=");
        ((StringBuilder)localObject2).append(this.p);
        Log.d((String)localObject1, ((StringBuilder)localObject2).toString());
      }
      return null;
    }
    finally {}
  }
  
  public void b()
  {
    this.l = ((this.l + 1) % this.m.c);
  }
  
  public int c()
  {
    return this.m.c;
  }
  
  public void clear()
  {
    this.m = null;
    Object localObject = this.j;
    if (localObject != null) {
      this.d.e((byte[])localObject);
    }
    localObject = this.k;
    if (localObject != null) {
      this.d.f((int[])localObject);
    }
    localObject = this.n;
    if (localObject != null) {
      this.d.a((Bitmap)localObject);
    }
    this.n = null;
    this.e = null;
    this.t = null;
    localObject = this.f;
    if (localObject != null) {
      this.d.e((byte[])localObject);
    }
  }
  
  public void d(@NonNull Bitmap.Config paramConfig)
  {
    if ((paramConfig != Bitmap.Config.ARGB_8888) && (paramConfig != Bitmap.Config.RGB_565))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Unsupported format: ");
      localStringBuilder.append(paramConfig);
      localStringBuilder.append(", must be one of ");
      localStringBuilder.append(Bitmap.Config.ARGB_8888);
      localStringBuilder.append(" or ");
      localStringBuilder.append(Bitmap.Config.RGB_565);
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    this.u = paramConfig;
  }
  
  public int e()
  {
    if (this.m.c > 0)
    {
      int i1 = this.l;
      if (i1 >= 0) {
        return m(i1);
      }
    }
    return 0;
  }
  
  public void f()
  {
    this.l = -1;
  }
  
  public int g()
  {
    return this.l;
  }
  
  @NonNull
  public ByteBuffer getData()
  {
    return this.e;
  }
  
  public int h()
  {
    return this.e.limit() + this.j.length + this.k.length * 4;
  }
  
  public int m(int paramInt)
  {
    if (paramInt >= 0)
    {
      c localc = this.m;
      if (paramInt < localc.c) {
        return ((b)localc.e.get(paramInt)).i;
      }
    }
    paramInt = -1;
    return paramInt;
  }
  
  public void q(@NonNull c paramc, @NonNull ByteBuffer paramByteBuffer, int paramInt)
  {
    if (paramInt > 0) {
      try
      {
        paramInt = Integer.highestOneBit(paramInt);
        this.p = 0;
        this.m = paramc;
        this.l = -1;
        paramByteBuffer = paramByteBuffer.asReadOnlyBuffer();
        this.e = paramByteBuffer;
        paramByteBuffer.position(0);
        this.e.order(ByteOrder.LITTLE_ENDIAN);
        this.o = false;
        paramByteBuffer = paramc.e.iterator();
        while (paramByteBuffer.hasNext()) {
          if (((b)paramByteBuffer.next()).g == 3) {
            this.o = true;
          }
        }
        this.q = paramInt;
        int i1 = paramc.f;
        this.s = (i1 / paramInt);
        int i2 = paramc.g;
        this.r = (i2 / paramInt);
        this.j = this.d.b(i1 * i2);
        this.k = this.d.d(this.s * this.r);
        return;
      }
      finally
      {
        break label214;
      }
    }
    paramc = new java/lang/IllegalArgumentException;
    paramByteBuffer = new java/lang/StringBuilder;
    paramByteBuffer.<init>();
    paramByteBuffer.append("Sample size must be >=0, not: ");
    paramByteBuffer.append(paramInt);
    paramc.<init>(paramByteBuffer.toString());
    throw paramc;
    label214:
    throw paramc;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\l\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */