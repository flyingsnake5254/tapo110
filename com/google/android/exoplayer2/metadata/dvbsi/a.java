package com.google.android.exoplayer2.metadata.dvbsi;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.d;
import com.google.android.exoplayer2.metadata.g;
import com.google.android.exoplayer2.util.c0;
import com.google.common.base.e;
import java.nio.ByteBuffer;
import java.util.ArrayList;

public final class a
  extends g
{
  @Nullable
  private static Metadata c(c0 paramc0)
  {
    paramc0.r(12);
    int i = paramc0.h(12);
    int j = paramc0.d();
    paramc0.r(44);
    paramc0.s(paramc0.h(12));
    paramc0.r(16);
    ArrayList localArrayList = new ArrayList();
    Object localObject1;
    for (;;)
    {
      int k = paramc0.d();
      localObject1 = null;
      Object localObject2 = null;
      if (k >= j + i - 4) {
        break;
      }
      paramc0.r(48);
      int m = paramc0.h(8);
      paramc0.r(4);
      k = paramc0.h(12);
      int n = paramc0.d() + k;
      Object localObject4;
      for (localObject1 = null; paramc0.d() < n; localObject1 = localObject4)
      {
        k = paramc0.h(8);
        int i1 = paramc0.h(8);
        int i2 = paramc0.d() + i1;
        Object localObject3;
        if (k == 2)
        {
          k = paramc0.h(16);
          paramc0.r(8);
          localObject3 = localObject2;
          localObject4 = localObject1;
          if (k == 3)
          {
            localObject3 = localObject2;
            localObject4 = localObject1;
            if (paramc0.d() < i2)
            {
              localObject4 = paramc0.l(paramc0.h(8), e.a);
              i1 = paramc0.h(8);
              for (k = 0;; k++)
              {
                localObject2 = localObject4;
                if (k >= i1) {
                  break;
                }
                paramc0.s(paramc0.h(8));
              }
            }
          }
        }
        else
        {
          localObject3 = localObject2;
          localObject4 = localObject1;
          if (k == 21)
          {
            localObject4 = paramc0.l(i1, e.a);
            localObject3 = localObject2;
          }
        }
        paramc0.p(i2 * 8);
        localObject2 = localObject3;
      }
      paramc0.p(n * 8);
      if ((localObject2 != null) && (localObject1 != null))
      {
        if (((String)localObject1).length() != 0) {
          localObject2 = ((String)localObject2).concat((String)localObject1);
        } else {
          localObject2 = new String((String)localObject2);
        }
        localArrayList.add(new AppInfoTable(m, (String)localObject2));
      }
    }
    if (localArrayList.isEmpty()) {
      paramc0 = (c0)localObject1;
    } else {
      paramc0 = new Metadata(localArrayList);
    }
    return paramc0;
  }
  
  @Nullable
  protected Metadata b(d paramd, ByteBuffer paramByteBuffer)
  {
    if (paramByteBuffer.get() == 116) {
      paramd = c(new c0(paramByteBuffer.array(), paramByteBuffer.limit()));
    } else {
      paramd = null;
    }
    return paramd;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\metadata\dvbsi\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */