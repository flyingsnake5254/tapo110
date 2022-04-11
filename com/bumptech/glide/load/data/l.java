package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import java.io.FileNotFoundException;
import java.io.IOException;

public abstract class l<T>
  implements d<T>
{
  private final Uri c;
  private final ContentResolver d;
  private T f;
  
  public l(ContentResolver paramContentResolver, Uri paramUri)
  {
    this.d = paramContentResolver;
    this.c = paramUri;
  }
  
  public void b()
  {
    Object localObject = this.f;
    if (localObject != null) {}
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
  
  public final void e(@NonNull Priority paramPriority, @NonNull d.a<? super T> parama)
  {
    try
    {
      paramPriority = f(this.c, this.d);
      this.f = paramPriority;
      parama.f(paramPriority);
    }
    catch (FileNotFoundException paramPriority)
    {
      if (Log.isLoggable("LocalUriFetcher", 3)) {
        Log.d("LocalUriFetcher", "Failed to open Uri", paramPriority);
      }
      parama.c(paramPriority);
    }
  }
  
  protected abstract T f(Uri paramUri, ContentResolver paramContentResolver)
    throws FileNotFoundException;
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\data\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */