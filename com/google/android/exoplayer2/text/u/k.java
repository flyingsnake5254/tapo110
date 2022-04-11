package com.google.android.exoplayer2.text.u;

import com.google.android.exoplayer2.text.c;
import com.google.android.exoplayer2.text.c.b;
import com.google.android.exoplayer2.text.f;
import com.google.android.exoplayer2.util.o0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

final class k
  implements f
{
  private final List<g> c;
  private final long[] d;
  private final long[] f;
  
  public k(List<g> paramList)
  {
    this.c = Collections.unmodifiableList(new ArrayList(paramList));
    this.d = new long[paramList.size() * 2];
    for (int i = 0; i < paramList.size(); i++)
    {
      g localg = (g)paramList.get(i);
      int j = i * 2;
      long[] arrayOfLong = this.d;
      arrayOfLong[j] = localg.b;
      arrayOfLong[(j + 1)] = localg.c;
    }
    paramList = this.d;
    paramList = Arrays.copyOf(paramList, paramList.length);
    this.f = paramList;
    Arrays.sort(paramList);
  }
  
  public int a(long paramLong)
  {
    int i = o0.d(this.f, paramLong, false, false);
    if (i >= this.f.length) {
      i = -1;
    }
    return i;
  }
  
  public List<c> b(long paramLong)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int i = 0;
    for (int j = 0; j < this.c.size(); j++)
    {
      Object localObject = this.d;
      int k = j * 2;
      if ((localObject[k] <= paramLong) && (paramLong < localObject[(k + 1)]))
      {
        localObject = (g)this.c.get(j);
        c localc = ((g)localObject).a;
        if (localc.g == -3.4028235E38F) {
          localArrayList2.add(localObject);
        } else {
          localArrayList1.add(localc);
        }
      }
    }
    Collections.sort(localArrayList2, b.c);
    for (j = i; j < localArrayList2.size(); j++) {
      localArrayList1.add(((g)localArrayList2.get(j)).a.a().h(-1 - j, 1).a());
    }
    return localArrayList1;
  }
  
  public long c(int paramInt)
  {
    boolean bool1 = true;
    boolean bool2;
    if (paramInt >= 0) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    com.google.android.exoplayer2.util.g.a(bool2);
    if (paramInt < this.f.length) {
      bool2 = bool1;
    } else {
      bool2 = false;
    }
    com.google.android.exoplayer2.util.g.a(bool2);
    return this.f[paramInt];
  }
  
  public int d()
  {
    return this.f.length;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\text\u\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */