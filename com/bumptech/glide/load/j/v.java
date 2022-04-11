package com.bumptech.glide.load.j;

import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.data.d.a;
import com.bumptech.glide.load.f;
import com.bumptech.glide.o.b;

public class v<Model>
  implements n<Model, Model>
{
  private static final v<?> a = new v();
  
  public static <T> v<T> c()
  {
    return a;
  }
  
  public boolean a(@NonNull Model paramModel)
  {
    return true;
  }
  
  public n.a<Model> b(@NonNull Model paramModel, int paramInt1, int paramInt2, @NonNull f paramf)
  {
    return new n.a(new b(paramModel), new b(paramModel));
  }
  
  public static class a<Model>
    implements o<Model, Model>
  {
    private static final a<?> a = new a();
    
    public static <T> a<T> b()
    {
      return a;
    }
    
    public void a() {}
    
    @NonNull
    public n<Model, Model> c(r paramr)
    {
      return v.c();
    }
  }
  
  private static class b<Model>
    implements d<Model>
  {
    private final Model c;
    
    b(Model paramModel)
    {
      this.c = paramModel;
    }
    
    @NonNull
    public Class<Model> a()
    {
      return this.c.getClass();
    }
    
    public void b() {}
    
    public void cancel() {}
    
    @NonNull
    public DataSource d()
    {
      return DataSource.LOCAL;
    }
    
    public void e(@NonNull Priority paramPriority, @NonNull d.a<? super Model> parama)
    {
      parama.f(this.c);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\j\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */