package com.google.android.exoplayer2.source.hls;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Format.b;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.o2.j0.i;
import com.google.android.exoplayer2.o2.l0.h;
import com.google.android.exoplayer2.o2.l0.h0;
import com.google.android.exoplayer2.o2.l0.l;
import com.google.android.exoplayer2.util.l0;
import com.google.android.exoplayer2.util.o;
import com.google.android.exoplayer2.util.y;
import com.google.common.primitives.d;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class g
  implements k
{
  private static final int[] b = { 8, 13, 11, 2, 0, 1, 7 };
  private final int c;
  private final boolean d;
  
  public g()
  {
    this(0, true);
  }
  
  public g(int paramInt, boolean paramBoolean)
  {
    this.c = paramInt;
    this.d = paramBoolean;
  }
  
  private static void b(int paramInt, List<Integer> paramList)
  {
    if ((d.f(b, paramInt) != -1) && (!paramList.contains(Integer.valueOf(paramInt)))) {
      paramList.add(Integer.valueOf(paramInt));
    }
  }
  
  @SuppressLint({"SwitchIntDef"})
  @Nullable
  private com.google.android.exoplayer2.o2.j d(int paramInt, Format paramFormat, @Nullable List<Format> paramList, l0 paraml0)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 7)
          {
            if (paramInt != 8)
            {
              if (paramInt != 11)
              {
                if (paramInt != 13) {
                  return null;
                }
                return new s(paramFormat.f, paraml0);
              }
              return f(this.c, this.d, paramFormat, paramList, paraml0);
            }
            return e(paraml0, paramFormat, paramList);
          }
          return new com.google.android.exoplayer2.o2.i0.f(0, 0L);
        }
        return new com.google.android.exoplayer2.o2.l0.j();
      }
      return new h();
    }
    return new com.google.android.exoplayer2.o2.l0.f();
  }
  
  private static i e(l0 paraml0, Format paramFormat, @Nullable List<Format> paramList)
  {
    int i;
    if (g(paramFormat)) {
      i = 4;
    } else {
      i = 0;
    }
    if (paramList == null) {
      paramList = Collections.emptyList();
    }
    return new i(i, paraml0, null, paramList);
  }
  
  private static h0 f(int paramInt, boolean paramBoolean, Format paramFormat, @Nullable List<Format> paramList, l0 paraml0)
  {
    paramInt |= 0x10;
    if (paramList != null) {
      paramInt |= 0x20;
    } else if (paramBoolean) {
      paramList = Collections.singletonList(new Format.b().e0("application/cea-608").E());
    } else {
      paramList = Collections.emptyList();
    }
    paramFormat = paramFormat.p1;
    int i = paramInt;
    if (!TextUtils.isEmpty(paramFormat))
    {
      int j = paramInt;
      if (!y.b(paramFormat, "audio/mp4a-latm")) {
        j = paramInt | 0x2;
      }
      i = j;
      if (!y.b(paramFormat, "video/avc")) {
        i = j | 0x4;
      }
    }
    return new h0(2, paraml0, new l(i, paramList));
  }
  
  private static boolean g(Format paramFormat)
  {
    Metadata localMetadata = paramFormat.p2;
    if (localMetadata == null) {
      return false;
    }
    for (int i = 0; i < localMetadata.d(); i++)
    {
      paramFormat = localMetadata.c(i);
      if ((paramFormat instanceof HlsTrackMetadataEntry)) {
        return ((HlsTrackMetadataEntry)paramFormat).f.isEmpty() ^ true;
      }
    }
    return false;
  }
  
  /* Error */
  private static boolean h(com.google.android.exoplayer2.o2.j paramj, com.google.android.exoplayer2.o2.k paramk)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokeinterface 182 2 0
    //   7: istore_2
    //   8: aload_1
    //   9: invokeinterface 186 1 0
    //   14: goto +21 -> 35
    //   17: astore_0
    //   18: aload_1
    //   19: invokeinterface 186 1 0
    //   24: aload_0
    //   25: athrow
    //   26: astore_0
    //   27: aload_1
    //   28: invokeinterface 186 1 0
    //   33: iconst_0
    //   34: istore_2
    //   35: iload_2
    //   36: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	37	0	paramj	com.google.android.exoplayer2.o2.j
    //   0	37	1	paramk	com.google.android.exoplayer2.o2.k
    //   7	29	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   0	8	17	finally
    //   0	8	26	java/io/EOFException
  }
  
  public e c(Uri paramUri, Format paramFormat, @Nullable List<Format> paramList, l0 paraml0, Map<String, List<String>> paramMap, com.google.android.exoplayer2.o2.k paramk)
    throws IOException
  {
    int i = o.a(paramFormat.H3);
    int j = o.b(paramMap);
    int k = o.c(paramUri);
    paramUri = b;
    ArrayList localArrayList = new ArrayList(paramUri.length);
    b(i, localArrayList);
    b(j, localArrayList);
    b(k, localArrayList);
    int m = paramUri.length;
    int n = 0;
    for (int i1 = 0; i1 < m; i1++) {
      b(paramUri[i1], localArrayList);
    }
    paramMap = null;
    paramk.e();
    i1 = n;
    while (i1 < localArrayList.size())
    {
      n = ((Integer)localArrayList.get(i1)).intValue();
      com.google.android.exoplayer2.o2.j localj = (com.google.android.exoplayer2.o2.j)com.google.android.exoplayer2.util.g.e(d(n, paramFormat, paramList, paraml0));
      if (h(localj, paramk)) {
        return new e(localj, paramFormat, paraml0);
      }
      paramUri = paramMap;
      if (paramMap == null) {
        if ((n != i) && (n != j) && (n != k))
        {
          paramUri = paramMap;
          if (n != 11) {}
        }
        else
        {
          paramUri = localj;
        }
      }
      i1++;
      paramMap = paramUri;
    }
    return new e((com.google.android.exoplayer2.o2.j)com.google.android.exoplayer2.util.g.e(paramMap), paramFormat, paraml0);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\source\hls\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */