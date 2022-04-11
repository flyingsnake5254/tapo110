package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.c;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.data.d.a;
import com.bumptech.glide.load.engine.a0.a;
import com.bumptech.glide.load.i;
import com.bumptech.glide.load.j.n;
import com.bumptech.glide.load.j.n.a;
import java.io.File;
import java.util.List;

class v
  implements f, d.a<Object>
{
  private final f.a c;
  private final g<?> d;
  private int f;
  private volatile n.a<?> p0;
  private File p1;
  private w p2;
  private int q = -1;
  private c x;
  private List<n<File, ?>> y;
  private int z;
  
  v(g<?> paramg, f.a parama)
  {
    this.d = paramg;
    this.c = parama;
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
    Object localObject1 = this.d.c();
    boolean bool1 = ((List)localObject1).isEmpty();
    boolean bool2 = false;
    if (bool1) {
      return false;
    }
    List localList = this.d.m();
    if (localList.isEmpty())
    {
      if (File.class.equals(this.d.q())) {
        return false;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Failed to find any load path from ");
      ((StringBuilder)localObject1).append(this.d.i());
      ((StringBuilder)localObject1).append(" to ");
      ((StringBuilder)localObject1).append(this.d.q());
      throw new IllegalStateException(((StringBuilder)localObject1).toString());
    }
    for (;;)
    {
      if ((this.y != null) && (a()))
      {
        this.p0 = null;
        while ((!bool2) && (a()))
        {
          localObject1 = this.y;
          i = this.z;
          this.z = (i + 1);
          this.p0 = ((n)((List)localObject1).get(i)).b(this.p1, this.d.s(), this.d.f(), this.d.k());
          if ((this.p0 != null) && (this.d.t(this.p0.c.a())))
          {
            this.p0.c.e(this.d.l(), this);
            bool2 = true;
          }
        }
        return bool2;
      }
      int i = this.q + 1;
      this.q = i;
      if (i >= localList.size())
      {
        i = this.f + 1;
        this.f = i;
        if (i >= ((List)localObject1).size()) {
          return false;
        }
        this.q = 0;
      }
      c localc = (c)((List)localObject1).get(this.f);
      Class localClass = (Class)localList.get(this.q);
      Object localObject2 = this.d.r(localClass);
      this.p2 = new w(this.d.b(), localc, this.d.o(), this.d.s(), this.d.f(), (i)localObject2, localClass, this.d.k());
      localObject2 = this.d.d().b(this.p2);
      this.p1 = ((File)localObject2);
      if (localObject2 != null)
      {
        this.x = localc;
        this.y = this.d.j((File)localObject2);
        this.z = 0;
      }
    }
  }
  
  public void c(@NonNull Exception paramException)
  {
    this.c.a(this.p2, paramException, this.p0.c, DataSource.RESOURCE_DISK_CACHE);
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
    this.c.e(this.x, paramObject, this.p0.c, DataSource.RESOURCE_DISK_CACHE, this.p2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\engine\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */