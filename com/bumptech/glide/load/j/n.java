package com.bumptech.glide.load.j;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.c;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.f;
import com.bumptech.glide.util.i;
import java.util.Collections;
import java.util.List;

public abstract interface n<Model, Data>
{
  public abstract boolean a(@NonNull Model paramModel);
  
  @Nullable
  public abstract a<Data> b(@NonNull Model paramModel, int paramInt1, int paramInt2, @NonNull f paramf);
  
  public static class a<Data>
  {
    public final c a;
    public final List<c> b;
    public final d<Data> c;
    
    public a(@NonNull c paramc, @NonNull d<Data> paramd)
    {
      this(paramc, Collections.emptyList(), paramd);
    }
    
    public a(@NonNull c paramc, @NonNull List<c> paramList, @NonNull d<Data> paramd)
    {
      this.a = ((c)i.d(paramc));
      this.b = ((List)i.d(paramList));
      this.c = ((d)i.d(paramd));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\j\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */