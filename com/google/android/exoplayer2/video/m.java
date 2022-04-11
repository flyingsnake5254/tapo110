package com.google.android.exoplayer2.video;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.i;
import com.google.android.exoplayer2.util.z;
import com.google.android.exoplayer2.util.z.b;
import java.util.ArrayList;
import java.util.List;

public final class m
{
  public final List<byte[]> a;
  public final int b;
  public final int c;
  public final int d;
  public final float e;
  @Nullable
  public final String f;
  
  private m(List<byte[]> paramList, int paramInt1, int paramInt2, int paramInt3, float paramFloat, @Nullable String paramString)
  {
    this.a = paramList;
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramInt3;
    this.e = paramFloat;
    this.f = paramString;
  }
  
  private static byte[] a(d0 paramd0)
  {
    int i = paramd0.J();
    int j = paramd0.e();
    paramd0.Q(i);
    return i.d(paramd0.d(), j, i);
  }
  
  public static m b(d0 paramd0)
    throws ParserException
  {
    try
    {
      paramd0.Q(4);
      int i = (paramd0.D() & 0x3) + 1;
      if (i != 3)
      {
        ArrayList localArrayList = new java/util/ArrayList;
        localArrayList.<init>();
        int j = paramd0.D() & 0x1F;
        for (int k = 0; k < j; k++) {
          localArrayList.add(a(paramd0));
        }
        int m = paramd0.D();
        for (k = 0; k < m; k++) {
          localArrayList.add(a(paramd0));
        }
        m = -1;
        float f1;
        if (j > 0)
        {
          paramd0 = (byte[])localArrayList.get(0);
          paramd0 = z.i((byte[])localArrayList.get(0), i, paramd0.length);
          m = paramd0.e;
          k = paramd0.f;
          f1 = paramd0.g;
          paramd0 = i.a(paramd0.a, paramd0.b, paramd0.c);
        }
        else
        {
          paramd0 = null;
          k = -1;
          f1 = 1.0F;
        }
        return new m(localArrayList, i, m, k, f1, paramd0);
      }
      paramd0 = new java/lang/IllegalStateException;
      paramd0.<init>();
      throw paramd0;
    }
    catch (ArrayIndexOutOfBoundsException paramd0)
    {
      throw ParserException.createForMalformedContainer("Error parsing AVC config", paramd0);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\video\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */