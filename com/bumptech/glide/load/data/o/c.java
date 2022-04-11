package com.bumptech.glide.load.data.o;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore.Images.Thumbnails;
import android.provider.MediaStore.Video.Thumbnails;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.Priority;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d.a;
import com.bumptech.glide.load.data.g;
import com.bumptech.glide.load.engine.z.b;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class c
  implements com.bumptech.glide.load.data.d<InputStream>
{
  private final Uri c;
  private final e d;
  private InputStream f;
  
  @VisibleForTesting
  c(Uri paramUri, e parame)
  {
    this.c = paramUri;
    this.d = parame;
  }
  
  private static c c(Context paramContext, Uri paramUri, d paramd)
  {
    b localb = com.bumptech.glide.c.c(paramContext).e();
    return new c(paramUri, new e(com.bumptech.glide.c.c(paramContext).j().g(), paramd, localb, paramContext.getContentResolver()));
  }
  
  public static c f(Context paramContext, Uri paramUri)
  {
    return c(paramContext, paramUri, new a(paramContext.getContentResolver()));
  }
  
  public static c g(Context paramContext, Uri paramUri)
  {
    return c(paramContext, paramUri, new b(paramContext.getContentResolver()));
  }
  
  private InputStream h()
    throws FileNotFoundException
  {
    InputStream localInputStream = this.d.d(this.c);
    int i;
    if (localInputStream != null) {
      i = this.d.a(this.c);
    } else {
      i = -1;
    }
    Object localObject = localInputStream;
    if (i != -1) {
      localObject = new g(localInputStream, i);
    }
    return (InputStream)localObject;
  }
  
  @NonNull
  public Class<InputStream> a()
  {
    return InputStream.class;
  }
  
  public void b()
  {
    InputStream localInputStream = this.f;
    if (localInputStream != null) {}
    try
    {
      localInputStream.close();
      return;
    }
    catch (IOException localIOException)
    {
      for (;;) {}
    }
  }
  
  public void cancel() {}
  
  @NonNull
  public DataSource d()
  {
    return DataSource.LOCAL;
  }
  
  public void e(@NonNull Priority paramPriority, @NonNull d.a<? super InputStream> parama)
  {
    try
    {
      paramPriority = h();
      this.f = paramPriority;
      parama.f(paramPriority);
    }
    catch (FileNotFoundException paramPriority)
    {
      if (Log.isLoggable("MediaStoreThumbFetcher", 3)) {
        Log.d("MediaStoreThumbFetcher", "Failed to find thumbnail file", paramPriority);
      }
      parama.c(paramPriority);
    }
  }
  
  static class a
    implements d
  {
    private static final String[] a = { "_data" };
    private final ContentResolver b;
    
    a(ContentResolver paramContentResolver)
    {
      this.b = paramContentResolver;
    }
    
    public Cursor a(Uri paramUri)
    {
      paramUri = paramUri.getLastPathSegment();
      return this.b.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, a, "kind = 1 AND image_id = ?", new String[] { paramUri }, null);
    }
  }
  
  static class b
    implements d
  {
    private static final String[] a = { "_data" };
    private final ContentResolver b;
    
    b(ContentResolver paramContentResolver)
    {
      this.b = paramContentResolver;
    }
    
    public Cursor a(Uri paramUri)
    {
      paramUri = paramUri.getLastPathSegment();
      return this.b.query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, a, "kind = 1 AND video_id = ?", new String[] { paramUri }, null);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\data\o\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */