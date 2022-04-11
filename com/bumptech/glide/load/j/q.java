package com.bumptech.glide.load.j;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pools.Pool;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.c;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.data.d.a;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.f;
import com.bumptech.glide.util.i;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class q<Model, Data>
  implements n<Model, Data>
{
  private final List<n<Model, Data>> a;
  private final Pools.Pool<List<Throwable>> b;
  
  q(@NonNull List<n<Model, Data>> paramList, @NonNull Pools.Pool<List<Throwable>> paramPool)
  {
    this.a = paramList;
    this.b = paramPool;
  }
  
  public boolean a(@NonNull Model paramModel)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      if (((n)localIterator.next()).a(paramModel)) {
        return true;
      }
    }
    return false;
  }
  
  public n.a<Data> b(@NonNull Model paramModel, int paramInt1, int paramInt2, @NonNull f paramf)
  {
    int i = this.a.size();
    ArrayList localArrayList = new ArrayList(i);
    Object localObject1 = null;
    int j = 0;
    Object localObject4;
    for (Object localObject2 = null; j < i; localObject2 = localObject4)
    {
      Object localObject3 = (n)this.a.get(j);
      localObject4 = localObject2;
      if (((n)localObject3).a(paramModel))
      {
        localObject3 = ((n)localObject3).b(paramModel, paramInt1, paramInt2, paramf);
        localObject4 = localObject2;
        if (localObject3 != null)
        {
          localObject4 = ((n.a)localObject3).a;
          localArrayList.add(((n.a)localObject3).c);
        }
      }
      j++;
    }
    paramModel = (Model)localObject1;
    if (!localArrayList.isEmpty())
    {
      paramModel = (Model)localObject1;
      if (localObject2 != null) {
        paramModel = new n.a((c)localObject2, new a(localArrayList, this.b));
      }
    }
    return paramModel;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MultiModelLoader{modelLoaders=");
    localStringBuilder.append(Arrays.toString(this.a.toArray()));
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  static class a<Data>
    implements d<Data>, d.a<Data>
  {
    private final List<d<Data>> c;
    private final Pools.Pool<List<Throwable>> d;
    private int f;
    private Priority q;
    private d.a<? super Data> x;
    @Nullable
    private List<Throwable> y;
    private boolean z;
    
    a(@NonNull List<d<Data>> paramList, @NonNull Pools.Pool<List<Throwable>> paramPool)
    {
      this.d = paramPool;
      i.c(paramList);
      this.c = paramList;
      this.f = 0;
    }
    
    private void g()
    {
      if (this.z) {
        return;
      }
      if (this.f < this.c.size() - 1)
      {
        this.f += 1;
        e(this.q, this.x);
      }
      else
      {
        i.d(this.y);
        this.x.c(new GlideException("Fetch failed", new ArrayList(this.y)));
      }
    }
    
    @NonNull
    public Class<Data> a()
    {
      return ((d)this.c.get(0)).a();
    }
    
    public void b()
    {
      Object localObject = this.y;
      if (localObject != null) {
        this.d.release(localObject);
      }
      this.y = null;
      localObject = this.c.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((d)((Iterator)localObject).next()).b();
      }
    }
    
    public void c(@NonNull Exception paramException)
    {
      ((List)i.d(this.y)).add(paramException);
      g();
    }
    
    public void cancel()
    {
      this.z = true;
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext()) {
        ((d)localIterator.next()).cancel();
      }
    }
    
    @NonNull
    public DataSource d()
    {
      return ((d)this.c.get(0)).d();
    }
    
    public void e(@NonNull Priority paramPriority, @NonNull d.a<? super Data> parama)
    {
      this.q = paramPriority;
      this.x = parama;
      this.y = ((List)this.d.acquire());
      ((d)this.c.get(this.f)).e(paramPriority, this);
      if (this.z) {
        cancel();
      }
    }
    
    public void f(@Nullable Data paramData)
    {
      if (paramData != null) {
        this.x.f(paramData);
      } else {
        g();
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\j\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */