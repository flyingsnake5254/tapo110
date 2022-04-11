package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.datatransport.h.n;
import com.google.android.datatransport.h.x.j.e0;
import com.google.android.datatransport.h.x.j.y;
import com.google.android.datatransport.runtime.backends.BackendResponse;
import com.google.android.datatransport.runtime.backends.BackendResponse.Status;
import com.google.android.datatransport.runtime.backends.f.a;
import com.google.android.datatransport.runtime.backends.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

public class q
{
  private final Context a;
  private final com.google.android.datatransport.runtime.backends.e b;
  private final y c;
  private final u d;
  private final Executor e;
  private final com.google.android.datatransport.runtime.synchronization.a f;
  private final com.google.android.datatransport.h.y.a g;
  
  public q(Context paramContext, com.google.android.datatransport.runtime.backends.e parame, y paramy, u paramu, Executor paramExecutor, com.google.android.datatransport.runtime.synchronization.a parama, com.google.android.datatransport.h.y.a parama1)
  {
    this.a = paramContext;
    this.b = parame;
    this.c = paramy;
    this.d = paramu;
    this.e = paramExecutor;
    this.f = parama;
    this.g = parama1;
  }
  
  boolean a()
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)this.a.getSystemService("connectivity")).getActiveNetworkInfo();
    boolean bool;
    if ((localNetworkInfo != null) && (localNetworkInfo.isConnected())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  void p(n paramn, int paramInt)
  {
    l locall = this.b.get(paramn.b());
    long l = 0L;
    while (((Boolean)this.f.a(new e(this, paramn))).booleanValue())
    {
      Iterable localIterable = (Iterable)this.f.a(new f(this, paramn));
      if (!localIterable.iterator().hasNext()) {
        return;
      }
      Object localObject;
      if (locall == null)
      {
        com.google.android.datatransport.h.v.a.a("Uploader", "Unknown backend for %s, deleting event batch for it...", paramn);
        localObject = BackendResponse.a();
      }
      else
      {
        ArrayList localArrayList = new ArrayList();
        localObject = localIterable.iterator();
        while (((Iterator)localObject).hasNext()) {
          localArrayList.add(((e0)((Iterator)localObject).next()).b());
        }
        localObject = locall.b(com.google.android.datatransport.runtime.backends.f.a().b(localArrayList).c(paramn.c()).a());
      }
      if (((BackendResponse)localObject).c() == BackendResponse.Status.TRANSIENT_ERROR)
      {
        this.f.a(new g(this, localIterable, paramn, l));
        this.d.b(paramn, paramInt + 1, true);
        return;
      }
      this.f.a(new i(this, localIterable));
      if (((BackendResponse)localObject).c() == BackendResponse.Status.OK) {
        l = Math.max(l, ((BackendResponse)localObject).b());
      }
    }
    this.f.a(new h(this, paramn, l));
  }
  
  public void q(n paramn, int paramInt, Runnable paramRunnable)
  {
    this.e.execute(new d(this, paramn, paramInt, paramRunnable));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\datatransport\runtime\scheduling\jobscheduling\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */