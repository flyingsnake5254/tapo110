package com.google.android.exoplayer2.offline;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.scheduler.Requirements;
import com.google.android.exoplayer2.scheduler.c;
import com.google.android.exoplayer2.scheduler.c.c;
import com.google.android.exoplayer2.util.g;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

public final class d
{
  public static final Requirements a = new Requirements(1);
  private final Context b;
  private final c.c c;
  private final CopyOnWriteArraySet<a> d;
  private int e;
  private int f;
  private boolean g;
  private boolean h;
  private int i;
  private boolean j;
  private List<b> k;
  private c l;
  
  private void i()
  {
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).a(this, this.j);
    }
  }
  
  private void j(c paramc, int paramInt)
  {
    Requirements localRequirements = paramc.f();
    if (this.i == paramInt)
    {
      boolean bool = r();
      paramc = this.d.iterator();
      while (paramc.hasNext()) {
        ((a)paramc.next()).b(this, localRequirements, paramInt);
      }
      if (bool) {
        i();
      }
      return;
    }
    this.i = paramInt;
    this.e += 1;
    throw null;
  }
  
  private void o(boolean paramBoolean)
  {
    if (this.h == paramBoolean) {
      return;
    }
    this.h = paramBoolean;
    this.e += 1;
    throw null;
  }
  
  private boolean r()
  {
    boolean bool1 = this.h;
    boolean bool2 = true;
    if ((!bool1) && (this.i != 0)) {
      for (int m = 0; m < this.k.size(); m++) {
        if (((b)this.k.get(m)).a == 0)
        {
          bool1 = true;
          break label65;
        }
      }
    }
    bool1 = false;
    label65:
    if (this.j == bool1) {
      bool2 = false;
    }
    this.j = bool1;
    return bool2;
  }
  
  public void a(DownloadRequest paramDownloadRequest, int paramInt)
  {
    this.e += 1;
    throw null;
  }
  
  public void b(a parama)
  {
    g.e(parama);
    this.d.add(parama);
  }
  
  public List<b> c()
  {
    return this.k;
  }
  
  public boolean d()
  {
    return this.h;
  }
  
  public Requirements e()
  {
    return this.l.f();
  }
  
  public boolean f()
  {
    boolean bool;
    if ((this.f == 0) && (this.e == 0)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean g()
  {
    return this.g;
  }
  
  public boolean h()
  {
    return this.j;
  }
  
  public void k()
  {
    o(true);
  }
  
  public void l()
  {
    this.e += 1;
    throw null;
  }
  
  public void m(String paramString)
  {
    this.e += 1;
    throw null;
  }
  
  public void n()
  {
    o(false);
  }
  
  public void p(Requirements paramRequirements)
  {
    if (paramRequirements.equals(this.l.f())) {
      return;
    }
    this.l.j();
    paramRequirements = new c(this.b, this.c, paramRequirements);
    this.l = paramRequirements;
    int m = paramRequirements.i();
    j(this.l, m);
  }
  
  public void q(@Nullable String paramString, int paramInt)
  {
    this.e += 1;
    throw null;
  }
  
  public static abstract interface a
  {
    public abstract void a(d paramd, boolean paramBoolean);
    
    public abstract void b(d paramd, Requirements paramRequirements, int paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\offline\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */