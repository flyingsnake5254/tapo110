package com.bumptech.glide.load.data;

import android.content.res.AssetManager;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import java.io.IOException;

public abstract class b<T>
  implements d<T>
{
  private final String c;
  private final AssetManager d;
  private T f;
  
  public b(AssetManager paramAssetManager, String paramString)
  {
    this.d = paramAssetManager;
    this.c = paramString;
  }
  
  public void b()
  {
    Object localObject = this.f;
    if (localObject == null) {
      return;
    }
    try
    {
      c(localObject);
      return;
    }
    catch (IOException localIOException)
    {
      for (;;) {}
    }
  }
  
  protected abstract void c(T paramT)
    throws IOException;
  
  public void cancel() {}
  
  @NonNull
  public DataSource d()
  {
    return DataSource.LOCAL;
  }
  
  public void e(@NonNull Priority paramPriority, @NonNull d.a<? super T> parama)
  {
    try
    {
      paramPriority = f(this.d, this.c);
      this.f = paramPriority;
      parama.f(paramPriority);
    }
    catch (IOException paramPriority)
    {
      if (Log.isLoggable("AssetPathFetcher", 3)) {
        Log.d("AssetPathFetcher", "Failed to load data from asset manager", paramPriority);
      }
      parama.c(paramPriority);
    }
  }
  
  protected abstract T f(AssetManager paramAssetManager, String paramString)
    throws IOException;
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\data\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */