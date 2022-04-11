package com.hannesdorfmann.mosby3;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.hannesdorfmann.mosby3.k.a;
import com.hannesdorfmann.mosby3.k.b;
import java.util.Map;
import java.util.Objects;

class c
{
  private final Map<String, a> a = new ArrayMap();
  
  public void a()
  {
    this.a.clear();
  }
  
  @Nullable
  public <P> P b(@NonNull String paramString)
  {
    paramString = (a)this.a.get(paramString);
    if (paramString == null) {
      paramString = null;
    } else {
      paramString = a.a(paramString);
    }
    return paramString;
  }
  
  public void c(@NonNull String paramString, @NonNull a<? extends b> parama)
  {
    Objects.requireNonNull(paramString, "ViewId is null");
    Objects.requireNonNull(parama, "Presenter is null");
    a locala = (a)this.a.get(paramString);
    if (locala == null)
    {
      locala = new a();
      a.b(locala, parama);
      this.a.put(paramString, locala);
    }
    else
    {
      a.b(locala, parama);
    }
  }
  
  public void d(@NonNull String paramString)
  {
    Objects.requireNonNull(paramString, "View Id is null");
    this.a.remove(paramString);
  }
  
  static final class a
  {
    private a<?> a;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\hannesdorfmann\mosby3\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */