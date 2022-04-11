package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d.a;
import com.bumptech.glide.load.engine.a0.a;
import com.bumptech.glide.load.j.n;
import com.bumptech.glide.load.j.n.a;
import java.io.File;
import java.util.List;

class c
  implements f, d.a<Object>
{
  private final List<com.bumptech.glide.load.c> c;
  private final g<?> d;
  private final f.a f;
  private volatile n.a<?> p0;
  private File p1;
  private int q = -1;
  private com.bumptech.glide.load.c x;
  private List<n<File, ?>> y;
  private int z;
  
  c(g<?> paramg, f.a parama)
  {
    this(paramg.c(), paramg, parama);
  }
  
  c(List<com.bumptech.glide.load.c> paramList, g<?> paramg, f.a parama)
  {
    this.c = paramList;
    this.d = paramg;
    this.f = parama;
  }
  
  private boolean a()
  {
    boolean bool;
    if (this.z < this.y.size()) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean b()
  {
    for (;;)
    {
      Object localObject1 = this.y;
      boolean bool = false;
      if ((localObject1 != null) && (a()))
      {
        this.p0 = null;
        while ((!bool) && (a()))
        {
          localObject1 = this.y;
          i = this.z;
          this.z = (i + 1);
          this.p0 = ((n)((List)localObject1).get(i)).b(this.p1, this.d.s(), this.d.f(), this.d.k());
          if ((this.p0 != null) && (this.d.t(this.p0.c.a())))
          {
            this.p0.c.e(this.d.l(), this);
            bool = true;
          }
        }
        return bool;
      }
      int i = this.q + 1;
      this.q = i;
      if (i >= this.c.size()) {
        return false;
      }
      localObject1 = (com.bumptech.glide.load.c)this.c.get(this.q);
      Object localObject2 = new d((com.bumptech.glide.load.c)localObject1, this.d.o());
      localObject2 = this.d.d().b((com.bumptech.glide.load.c)localObject2);
      this.p1 = ((File)localObject2);
      if (localObject2 != null)
      {
        this.x = ((com.bumptech.glide.load.c)localObject1);
        this.y = this.d.j((File)localObject2);
        this.z = 0;
      }
    }
  }
  
  public void c(@NonNull Exception paramException)
  {
    this.f.a(this.x, paramException, this.p0.c, DataSource.DATA_DISK_CACHE);
  }
  
  public void cancel()
  {
    n.a locala = this.p0;
    if (locala != null) {
      locala.c.cancel();
    }
  }
  
  public void f(Object paramObject)
  {
    this.f.e(this.x, paramObject, this.p0.c, DataSource.DATA_DISK_CACHE, this.x);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\engine\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */