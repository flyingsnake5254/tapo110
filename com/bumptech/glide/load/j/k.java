package com.bumptech.glide.load.j;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.data.d.a;
import com.bumptech.glide.load.f;
import java.io.File;
import java.io.FileNotFoundException;

public final class k
  implements n<Uri, File>
{
  private final Context a;
  
  public k(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public n.a<File> c(@NonNull Uri paramUri, int paramInt1, int paramInt2, @NonNull f paramf)
  {
    return new n.a(new com.bumptech.glide.o.b(paramUri), new b(this.a, paramUri));
  }
  
  public boolean d(@NonNull Uri paramUri)
  {
    return com.bumptech.glide.load.data.o.b.b(paramUri);
  }
  
  public static final class a
    implements o<Uri, File>
  {
    private final Context a;
    
    public a(Context paramContext)
    {
      this.a = paramContext;
    }
    
    public void a() {}
    
    @NonNull
    public n<Uri, File> c(r paramr)
    {
      return new k(this.a);
    }
  }
  
  private static class b
    implements d<File>
  {
    private static final String[] c = { "_data" };
    private final Context d;
    private final Uri f;
    
    b(Context paramContext, Uri paramUri)
    {
      this.d = paramContext;
      this.f = paramUri;
    }
    
    @NonNull
    public Class<File> a()
    {
      return File.class;
    }
    
    public void b() {}
    
    public void cancel() {}
    
    @NonNull
    public DataSource d()
    {
      return DataSource.LOCAL;
    }
    
    public void e(@NonNull Priority paramPriority, @NonNull d.a<? super File> parama)
    {
      Cursor localCursor = this.d.getContentResolver().query(this.f, c, null, null, null);
      paramPriority = null;
      Object localObject = null;
      if (localCursor != null) {
        paramPriority = (Priority)localObject;
      }
      try
      {
        if (localCursor.moveToFirst()) {
          paramPriority = localCursor.getString(localCursor.getColumnIndexOrThrow("_data"));
        }
        localCursor.close();
      }
      finally
      {
        localCursor.close();
      }
      paramPriority = new StringBuilder();
      paramPriority.append("Failed to find file path for: ");
      paramPriority.append(this.f);
      parama.c(new FileNotFoundException(paramPriority.toString()));
      return;
      parama.f(new File(paramPriority));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\j\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */