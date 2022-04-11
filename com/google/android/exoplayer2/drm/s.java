package com.google.android.exoplayer2.drm;

import android.net.Uri;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.l1;
import com.google.android.exoplayer2.l1.e;
import com.google.android.exoplayer2.l1.g;
import com.google.android.exoplayer2.upstream.HttpDataSource.a;
import com.google.android.exoplayer2.upstream.s.b;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;
import com.google.common.primitives.d;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class s
  implements z
{
  private final Object a = new Object();
  @GuardedBy("lock")
  private l1.e b;
  @GuardedBy("lock")
  private x c;
  @Nullable
  private HttpDataSource.a d;
  @Nullable
  private String e;
  
  @RequiresApi(18)
  private x b(l1.e parame)
  {
    Object localObject1 = this.d;
    if (localObject1 == null) {
      localObject1 = new s.b().c(this.e);
    }
    Object localObject2 = parame.b;
    if (localObject2 == null) {
      localObject2 = null;
    } else {
      localObject2 = ((Uri)localObject2).toString();
    }
    localObject2 = new h0((String)localObject2, parame.f, (HttpDataSource.a)localObject1);
    Iterator localIterator = parame.c.entrySet().iterator();
    while (localIterator.hasNext())
    {
      localObject1 = (Map.Entry)localIterator.next();
      ((h0)localObject2).e((String)((Map.Entry)localObject1).getKey(), (String)((Map.Entry)localObject1).getValue());
    }
    localObject1 = new DefaultDrmSessionManager.b().e(parame.a, g0.a).b(parame.d).c(parame.e).d(d.j(parame.g)).a((i0)localObject2);
    ((DefaultDrmSessionManager)localObject1).C(0, parame.a());
    return (x)localObject1;
  }
  
  public x a(l1 arg1)
  {
    g.e(???.d);
    Object localObject1 = ???.d.c;
    if ((localObject1 != null) && (o0.a >= 18)) {
      synchronized (this.a)
      {
        if (!o0.b(localObject1, this.b))
        {
          this.b = ((l1.e)localObject1);
          this.c = b((l1.e)localObject1);
        }
        localObject1 = (x)g.e(this.c);
        return (x)localObject1;
      }
    }
    return x.a;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\drm\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */