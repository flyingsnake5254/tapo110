package com.bumptech.glide;

import android.content.Context;
import android.content.ContextWrapper;
import android.widget.ImageView;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.request.a;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class e
  extends ContextWrapper
{
  @VisibleForTesting
  static final j<?, ?> a = new b();
  private final com.bumptech.glide.load.engine.z.b b;
  private final Registry c;
  private final com.bumptech.glide.request.k.g d;
  private final c.a e;
  private final List<com.bumptech.glide.request.f<Object>> f;
  private final Map<Class<?>, j<?, ?>> g;
  private final com.bumptech.glide.load.engine.k h;
  private final f i;
  private final int j;
  @GuardedBy("this")
  @Nullable
  private com.bumptech.glide.request.g k;
  
  public e(@NonNull Context paramContext, @NonNull com.bumptech.glide.load.engine.z.b paramb, @NonNull Registry paramRegistry, @NonNull com.bumptech.glide.request.k.g paramg, @NonNull c.a parama, @NonNull Map<Class<?>, j<?, ?>> paramMap, @NonNull List<com.bumptech.glide.request.f<Object>> paramList, @NonNull com.bumptech.glide.load.engine.k paramk, @NonNull f paramf, int paramInt)
  {
    super(paramContext.getApplicationContext());
    this.b = paramb;
    this.c = paramRegistry;
    this.d = paramg;
    this.e = parama;
    this.f = paramList;
    this.g = paramMap;
    this.h = paramk;
    this.i = paramf;
    this.j = paramInt;
  }
  
  @NonNull
  public <X> com.bumptech.glide.request.k.k<ImageView, X> a(@NonNull ImageView paramImageView, @NonNull Class<X> paramClass)
  {
    return this.d.a(paramImageView, paramClass);
  }
  
  @NonNull
  public com.bumptech.glide.load.engine.z.b b()
  {
    return this.b;
  }
  
  public List<com.bumptech.glide.request.f<Object>> c()
  {
    return this.f;
  }
  
  public com.bumptech.glide.request.g d()
  {
    try
    {
      if (this.k == null) {
        this.k = ((com.bumptech.glide.request.g)this.e.build().O());
      }
      com.bumptech.glide.request.g localg = this.k;
      return localg;
    }
    finally {}
  }
  
  @NonNull
  public <T> j<?, T> e(@NonNull Class<T> paramClass)
  {
    j localj = (j)this.g.get(paramClass);
    Object localObject = localj;
    if (localj == null)
    {
      Iterator localIterator = this.g.entrySet().iterator();
      for (;;)
      {
        localObject = localj;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (Map.Entry)localIterator.next();
        if (((Class)((Map.Entry)localObject).getKey()).isAssignableFrom(paramClass)) {
          localj = (j)((Map.Entry)localObject).getValue();
        }
      }
    }
    paramClass = (Class<T>)localObject;
    if (localObject == null) {
      paramClass = a;
    }
    return paramClass;
  }
  
  @NonNull
  public com.bumptech.glide.load.engine.k f()
  {
    return this.h;
  }
  
  public f g()
  {
    return this.i;
  }
  
  public int h()
  {
    return this.j;
  }
  
  @NonNull
  public Registry i()
  {
    return this.c;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */