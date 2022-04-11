package com.google.android.exoplayer2.o2;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Format.b;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.flac.PictureFrame;
import com.google.android.exoplayer2.metadata.flac.VorbisComment;
import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.u;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class s
{
  public final int a;
  public final int b;
  public final int c;
  public final int d;
  public final int e;
  public final int f;
  public final int g;
  public final int h;
  public final int i;
  public final long j;
  @Nullable
  public final a k;
  @Nullable
  private final Metadata l;
  
  private s(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, long paramLong, @Nullable a parama, @Nullable Metadata paramMetadata)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
    this.e = paramInt5;
    this.f = k(paramInt5);
    this.g = paramInt6;
    this.h = paramInt7;
    this.i = f(paramInt7);
    this.j = paramLong;
    this.k = parama;
    this.l = paramMetadata;
  }
  
  public s(byte[] paramArrayOfByte, int paramInt)
  {
    paramArrayOfByte = new c0(paramArrayOfByte);
    paramArrayOfByte.p(paramInt * 8);
    this.a = paramArrayOfByte.h(16);
    this.b = paramArrayOfByte.h(16);
    this.c = paramArrayOfByte.h(24);
    this.d = paramArrayOfByte.h(24);
    paramInt = paramArrayOfByte.h(20);
    this.e = paramInt;
    this.f = k(paramInt);
    this.g = (paramArrayOfByte.h(3) + 1);
    paramInt = paramArrayOfByte.h(5) + 1;
    this.h = paramInt;
    this.i = f(paramInt);
    this.j = paramArrayOfByte.j(36);
    this.k = null;
    this.l = null;
  }
  
  @Nullable
  private static Metadata a(List<String> paramList, List<PictureFrame> paramList1)
  {
    boolean bool = paramList.isEmpty();
    Object localObject1 = null;
    if ((bool) && (paramList1.isEmpty())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    for (int m = 0; m < paramList.size(); m++)
    {
      String str = (String)paramList.get(m);
      Object localObject2 = o0.F0(str, "=");
      if (localObject2.length != 2)
      {
        localObject2 = String.valueOf(str);
        if (((String)localObject2).length() != 0) {
          localObject2 = "Failed to parse Vorbis comment: ".concat((String)localObject2);
        } else {
          localObject2 = new String("Failed to parse Vorbis comment: ");
        }
        u.h("FlacStreamMetadata", (String)localObject2);
      }
      else
      {
        localArrayList.add(new VorbisComment(localObject2[0], localObject2[1]));
      }
    }
    localArrayList.addAll(paramList1);
    if (localArrayList.isEmpty()) {
      paramList = (List<String>)localObject1;
    } else {
      paramList = new Metadata(localArrayList);
    }
    return paramList;
  }
  
  private static int f(int paramInt)
  {
    if (paramInt != 8)
    {
      if (paramInt != 12)
      {
        if (paramInt != 16)
        {
          if (paramInt != 20)
          {
            if (paramInt != 24) {
              return -1;
            }
            return 6;
          }
          return 5;
        }
        return 4;
      }
      return 2;
    }
    return 1;
  }
  
  private static int k(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return -1;
    case 192000: 
      return 3;
    case 176400: 
      return 2;
    case 96000: 
      return 11;
    case 88200: 
      return 1;
    case 48000: 
      return 10;
    case 44100: 
      return 9;
    case 32000: 
      return 8;
    case 24000: 
      return 7;
    case 22050: 
      return 6;
    case 16000: 
      return 5;
    }
    return 4;
  }
  
  public s b(List<PictureFrame> paramList)
  {
    paramList = i(a(Collections.emptyList(), paramList));
    return new s(this.a, this.b, this.c, this.d, this.e, this.g, this.h, this.j, this.k, paramList);
  }
  
  public s c(@Nullable a parama)
  {
    return new s(this.a, this.b, this.c, this.d, this.e, this.g, this.h, this.j, parama, this.l);
  }
  
  public s d(List<String> paramList)
  {
    paramList = i(a(paramList, Collections.emptyList()));
    return new s(this.a, this.b, this.c, this.d, this.e, this.g, this.h, this.j, this.k, paramList);
  }
  
  public long e()
  {
    int m = this.d;
    long l1;
    if (m > 0) {
      l1 = (m + this.c) / 2L;
    }
    for (long l2 = 1L;; l2 = 64L)
    {
      break;
      m = this.a;
      if ((m == this.b) && (m > 0)) {
        l2 = m;
      } else {
        l2 = 4096L;
      }
      l1 = l2 * this.g * this.h / 8L;
    }
    return l1 + l2;
  }
  
  public long g()
  {
    long l1 = this.j;
    if (l1 == 0L) {
      l1 = -9223372036854775807L;
    } else {
      l1 = l1 * 1000000L / this.e;
    }
    return l1;
  }
  
  public Format h(byte[] paramArrayOfByte, @Nullable Metadata paramMetadata)
  {
    paramArrayOfByte[4] = ((byte)Byte.MIN_VALUE);
    int m = this.d;
    if (m <= 0) {
      m = -1;
    }
    paramMetadata = i(paramMetadata);
    return new Format.b().e0("audio/flac").W(m).H(this.g).f0(this.e).T(Collections.singletonList(paramArrayOfByte)).X(paramMetadata).E();
  }
  
  @Nullable
  public Metadata i(@Nullable Metadata paramMetadata)
  {
    Metadata localMetadata = this.l;
    if (localMetadata != null) {
      paramMetadata = localMetadata.b(paramMetadata);
    }
    return paramMetadata;
  }
  
  public long j(long paramLong)
  {
    return o0.q(paramLong * this.e / 1000000L, 0L, this.j - 1L);
  }
  
  public static class a
  {
    public final long[] a;
    public final long[] b;
    
    public a(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
    {
      this.a = paramArrayOfLong1;
      this.b = paramArrayOfLong2;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\o2\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */