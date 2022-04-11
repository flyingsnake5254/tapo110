package com.google.android.exoplayer2.o2;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.flac.PictureFrame;
import com.google.android.exoplayer2.metadata.id3.b;
import com.google.android.exoplayer2.metadata.id3.b.a;
import com.google.android.exoplayer2.util.c0;
import com.google.common.base.e;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class q
{
  public static boolean a(k paramk)
    throws IOException
  {
    com.google.android.exoplayer2.util.d0 locald0 = new com.google.android.exoplayer2.util.d0(4);
    byte[] arrayOfByte = locald0.d();
    boolean bool = false;
    paramk.n(arrayOfByte, 0, 4);
    if (locald0.F() == 1716281667L) {
      bool = true;
    }
    return bool;
  }
  
  public static int b(k paramk)
    throws IOException
  {
    paramk.e();
    com.google.android.exoplayer2.util.d0 locald0 = new com.google.android.exoplayer2.util.d0(2);
    paramk.n(locald0.d(), 0, 2);
    int i = locald0.J();
    if (i >> 2 == 16382)
    {
      paramk.e();
      return i;
    }
    paramk.e();
    throw ParserException.createForMalformedContainer("First frame does not start with sync code.", null);
  }
  
  @Nullable
  public static Metadata c(k paramk, boolean paramBoolean)
    throws IOException
  {
    Object localObject1 = null;
    if (paramBoolean) {
      localObject2 = null;
    } else {
      localObject2 = b.a;
    }
    Object localObject2 = new v().a(paramk, (b.a)localObject2);
    paramk = (k)localObject1;
    if (localObject2 != null) {
      if (((Metadata)localObject2).d() == 0) {
        paramk = (k)localObject1;
      } else {
        paramk = (k)localObject2;
      }
    }
    return paramk;
  }
  
  @Nullable
  public static Metadata d(k paramk, boolean paramBoolean)
    throws IOException
  {
    paramk.e();
    long l = paramk.g();
    Metadata localMetadata = c(paramk, paramBoolean);
    paramk.l((int)(paramk.g() - l));
    return localMetadata;
  }
  
  public static boolean e(k paramk, a parama)
    throws IOException
  {
    paramk.e();
    Object localObject = new c0(new byte[4]);
    paramk.n(((c0)localObject).a, 0, 4);
    boolean bool = ((c0)localObject).g();
    int i = ((c0)localObject).h(7);
    int j = ((c0)localObject).h(24) + 4;
    if (i == 0)
    {
      parama.a = i(paramk);
    }
    else
    {
      localObject = parama.a;
      if (localObject == null) {
        break label160;
      }
      if (i == 3) {
        parama.a = ((s)localObject).c(g(paramk, j));
      } else if (i == 4) {
        parama.a = ((s)localObject).d(k(paramk, j));
      } else if (i == 6) {
        parama.a = ((s)localObject).b(Collections.singletonList(f(paramk, j)));
      } else {
        paramk.l(j);
      }
    }
    return bool;
    label160:
    throw new IllegalArgumentException();
  }
  
  private static PictureFrame f(k paramk, int paramInt)
    throws IOException
  {
    com.google.android.exoplayer2.util.d0 locald0 = new com.google.android.exoplayer2.util.d0(paramInt);
    paramk.readFully(locald0.d(), 0, paramInt);
    locald0.Q(4);
    int i = locald0.n();
    String str = locald0.B(locald0.n(), e.a);
    paramk = locald0.A(locald0.n());
    int j = locald0.n();
    int k = locald0.n();
    paramInt = locald0.n();
    int m = locald0.n();
    int n = locald0.n();
    byte[] arrayOfByte = new byte[n];
    locald0.j(arrayOfByte, 0, n);
    return new PictureFrame(i, str, paramk, j, k, paramInt, m, arrayOfByte);
  }
  
  private static s.a g(k paramk, int paramInt)
    throws IOException
  {
    com.google.android.exoplayer2.util.d0 locald0 = new com.google.android.exoplayer2.util.d0(paramInt);
    paramk.readFully(locald0.d(), 0, paramInt);
    return h(locald0);
  }
  
  public static s.a h(com.google.android.exoplayer2.util.d0 paramd0)
  {
    paramd0.Q(1);
    int i = paramd0.G();
    long l1 = paramd0.e();
    long l2 = i;
    int j = i / 18;
    long[] arrayOfLong1 = new long[j];
    long[] arrayOfLong2 = new long[j];
    long[] arrayOfLong3;
    long[] arrayOfLong4;
    for (i = 0;; i++)
    {
      arrayOfLong3 = arrayOfLong1;
      arrayOfLong4 = arrayOfLong2;
      if (i >= j) {
        break;
      }
      long l3 = paramd0.w();
      if (l3 == -1L)
      {
        arrayOfLong3 = Arrays.copyOf(arrayOfLong1, i);
        arrayOfLong4 = Arrays.copyOf(arrayOfLong2, i);
        break;
      }
      arrayOfLong1[i] = l3;
      arrayOfLong2[i] = paramd0.w();
      paramd0.Q(2);
    }
    paramd0.Q((int)(l1 + l2 - paramd0.e()));
    return new s.a(arrayOfLong3, arrayOfLong4);
  }
  
  private static s i(k paramk)
    throws IOException
  {
    byte[] arrayOfByte = new byte[38];
    paramk.readFully(arrayOfByte, 0, 38);
    return new s(arrayOfByte, 4);
  }
  
  public static void j(k paramk)
    throws IOException
  {
    com.google.android.exoplayer2.util.d0 locald0 = new com.google.android.exoplayer2.util.d0(4);
    paramk.readFully(locald0.d(), 0, 4);
    if (locald0.F() == 1716281667L) {
      return;
    }
    throw ParserException.createForMalformedContainer("Failed to read FLAC stream marker.", null);
  }
  
  private static List<String> k(k paramk, int paramInt)
    throws IOException
  {
    com.google.android.exoplayer2.util.d0 locald0 = new com.google.android.exoplayer2.util.d0(paramInt);
    paramk.readFully(locald0.d(), 0, paramInt);
    locald0.Q(4);
    return Arrays.asList(d0.i(locald0, false, false).b);
  }
  
  public static final class a
  {
    @Nullable
    public s a;
    
    public a(@Nullable s params)
    {
      this.a = params;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\o2\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */