package com.google.android.exoplayer2.video;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.e0;
import com.google.android.exoplayer2.util.i;
import com.google.android.exoplayer2.util.z;
import java.util.Collections;
import java.util.List;

public final class p
{
  @Nullable
  public final List<byte[]> a;
  public final int b;
  @Nullable
  public final String c;
  
  private p(@Nullable List<byte[]> paramList, int paramInt, @Nullable String paramString)
  {
    this.a = paramList;
    this.b = paramInt;
    this.c = paramString;
  }
  
  public static p a(d0 paramd0)
    throws ParserException
  {
    try
    {
      paramd0.Q(21);
      int i = paramd0.D();
      int j = paramd0.D();
      int k = paramd0.e();
      int m = 0;
      int n = 0;
      int i1;
      int i2;
      int i3;
      while (m < j)
      {
        paramd0.Q(1);
        i1 = paramd0.J();
        for (i2 = 0; i2 < i1; i2++)
        {
          i3 = paramd0.J();
          n += i3 + 4;
          paramd0.Q(i3);
        }
        m++;
      }
      paramd0.P(k);
      byte[] arrayOfByte = new byte[n];
      m = 0;
      Object localObject1 = null;
      k = 0;
      while (m < j)
      {
        i3 = paramd0.D();
        i1 = paramd0.J();
        i2 = 0;
        while (i2 < i1)
        {
          int i4 = paramd0.J();
          Object localObject2 = z.a;
          System.arraycopy(localObject2, 0, arrayOfByte, k, localObject2.length);
          k += localObject2.length;
          System.arraycopy(paramd0.d(), paramd0.e(), arrayOfByte, k, i4);
          localObject2 = localObject1;
          if ((i3 & 0x7F) == 33)
          {
            localObject2 = localObject1;
            if (i2 == 0)
            {
              localObject1 = new com/google/android/exoplayer2/util/e0;
              ((e0)localObject1).<init>(arrayOfByte, k, k + i4);
              localObject2 = i.c((e0)localObject1);
            }
          }
          k += i4;
          paramd0.Q(i4);
          i2++;
          localObject1 = localObject2;
        }
        m++;
      }
      if (n == 0) {
        paramd0 = null;
      } else {
        paramd0 = Collections.singletonList(arrayOfByte);
      }
      paramd0 = new p(paramd0, (i & 0x3) + 1, (String)localObject1);
      return paramd0;
    }
    catch (ArrayIndexOutOfBoundsException paramd0)
    {
      throw ParserException.createForMalformedContainer("Error parsing HEVC config", paramd0);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\video\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */