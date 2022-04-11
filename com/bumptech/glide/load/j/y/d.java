package com.bumptech.glide.load.j.y;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.j.n;
import com.bumptech.glide.load.j.n.a;
import com.bumptech.glide.load.j.o;
import com.bumptech.glide.load.j.r;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

@RequiresApi(29)
public final class d<DataT>
  implements n<Uri, DataT>
{
  private final Context a;
  private final n<File, DataT> b;
  private final n<Uri, DataT> c;
  private final Class<DataT> d;
  
  d(Context paramContext, n<File, DataT> paramn, n<Uri, DataT> paramn1, Class<DataT> paramClass)
  {
    this.a = paramContext.getApplicationContext();
    this.b = paramn;
    this.c = paramn1;
    this.d = paramClass;
  }
  
  public n.a<DataT> c(@NonNull Uri paramUri, int paramInt1, int paramInt2, @NonNull f paramf)
  {
    return new n.a(new com.bumptech.glide.o.b(paramUri), new d(this.a, this.b, this.c, paramUri, paramInt1, paramInt2, paramf, this.d));
  }
  
  public boolean d(@NonNull Uri paramUri)
  {
    boolean bool;
    if ((Build.VERSION.SDK_INT >= 29) && (com.bumptech.glide.load.data.o.b.b(paramUri))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private static abstract class a<DataT>
    implements o<Uri, DataT>
  {
    private final Context a;
    private final Class<DataT> b;
    
    a(Context paramContext, Class<DataT> paramClass)
    {
      this.a = paramContext;
      this.b = paramClass;
    }
    
    public final void a() {}
    
    @NonNull
    public final n<Uri, DataT> c(@NonNull r paramr)
    {
      return new d(this.a, paramr.d(File.class, this.b), paramr.d(Uri.class, this.b), this.b);
    }
  }
  
  @RequiresApi(29)
  public static final class b
    extends d.a<ParcelFileDescriptor>
  {
    public b(Context paramContext)
    {
      super(ParcelFileDescriptor.class);
    }
  }
  
  @RequiresApi(29)
  public static final class c
    extends d.a<InputStream>
  {
    public c(Context paramContext)
    {
      super(InputStream.class);
    }
  }
  
  private static final class d<DataT>
    implements com.bumptech.glide.load.data.d<DataT>
  {
    private static final String[] c = { "_data" };
    private final Context d;
    private final n<File, DataT> f;
    private final f p0;
    private final Class<DataT> p1;
    private volatile boolean p2;
    @Nullable
    private volatile com.bumptech.glide.load.data.d<DataT> p3;
    private final n<Uri, DataT> q;
    private final Uri x;
    private final int y;
    private final int z;
    
    d(Context paramContext, n<File, DataT> paramn, n<Uri, DataT> paramn1, Uri paramUri, int paramInt1, int paramInt2, f paramf, Class<DataT> paramClass)
    {
      this.d = paramContext.getApplicationContext();
      this.f = paramn;
      this.q = paramn1;
      this.x = paramUri;
      this.y = paramInt1;
      this.z = paramInt2;
      this.p0 = paramf;
      this.p1 = paramClass;
    }
    
    @Nullable
    private n.a<DataT> c()
      throws FileNotFoundException
    {
      if (Environment.isExternalStorageLegacy()) {
        return this.f.b(h(this.x), this.y, this.z, this.p0);
      }
      Uri localUri;
      if (g()) {
        localUri = MediaStore.setRequireOriginal(this.x);
      } else {
        localUri = this.x;
      }
      return this.q.b(localUri, this.y, this.z, this.p0);
    }
    
    @Nullable
    private com.bumptech.glide.load.data.d<DataT> f()
      throws FileNotFoundException
    {
      Object localObject = c();
      if (localObject != null) {
        localObject = ((n.a)localObject).c;
      } else {
        localObject = null;
      }
      return (com.bumptech.glide.load.data.d<DataT>)localObject;
    }
    
    private boolean g()
    {
      boolean bool;
      if (this.d.checkSelfPermission("android.permission.ACCESS_MEDIA_LOCATION") == 0) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    @NonNull
    private File h(Uri paramUri)
      throws FileNotFoundException
    {
      Object localObject1 = null;
      try
      {
        Cursor localCursor = this.d.getContentResolver().query(paramUri, c, null, null, null);
        if (localCursor != null)
        {
          localObject1 = localCursor;
          if (localCursor.moveToFirst())
          {
            localObject1 = localCursor;
            localObject2 = localCursor.getString(localCursor.getColumnIndexOrThrow("_data"));
            localObject1 = localCursor;
            if (!TextUtils.isEmpty((CharSequence)localObject2))
            {
              localObject1 = localCursor;
              paramUri = new File((String)localObject2);
              localCursor.close();
              return paramUri;
            }
            localObject1 = localCursor;
            localFileNotFoundException = new java/io/FileNotFoundException;
            localObject1 = localCursor;
            localObject2 = new java/lang/StringBuilder;
            localObject1 = localCursor;
            ((StringBuilder)localObject2).<init>();
            localObject1 = localCursor;
            ((StringBuilder)localObject2).append("File path was empty in media store for: ");
            localObject1 = localCursor;
            ((StringBuilder)localObject2).append(paramUri);
            localObject1 = localCursor;
            localFileNotFoundException.<init>(((StringBuilder)localObject2).toString());
            localObject1 = localCursor;
            throw localFileNotFoundException;
          }
        }
        localObject1 = localCursor;
        FileNotFoundException localFileNotFoundException = new java/io/FileNotFoundException;
        localObject1 = localCursor;
        Object localObject2 = new java/lang/StringBuilder;
        localObject1 = localCursor;
        ((StringBuilder)localObject2).<init>();
        localObject1 = localCursor;
        ((StringBuilder)localObject2).append("Failed to media store entry for: ");
        localObject1 = localCursor;
        ((StringBuilder)localObject2).append(paramUri);
        localObject1 = localCursor;
        localFileNotFoundException.<init>(((StringBuilder)localObject2).toString());
        localObject1 = localCursor;
        throw localFileNotFoundException;
      }
      finally
      {
        if (localObject1 != null) {
          ((Cursor)localObject1).close();
        }
      }
    }
    
    @NonNull
    public Class<DataT> a()
    {
      return this.p1;
    }
    
    public void b()
    {
      com.bumptech.glide.load.data.d locald = this.p3;
      if (locald != null) {
        locald.b();
      }
    }
    
    public void cancel()
    {
      this.p2 = true;
      com.bumptech.glide.load.data.d locald = this.p3;
      if (locald != null) {
        locald.cancel();
      }
    }
    
    @NonNull
    public DataSource d()
    {
      return DataSource.LOCAL;
    }
    
    public void e(@NonNull Priority paramPriority, @NonNull com.bumptech.glide.load.data.d.a<? super DataT> parama)
    {
      try
      {
        Object localObject = f();
        if (localObject == null)
        {
          localObject = new java/lang/IllegalArgumentException;
          paramPriority = new java/lang/StringBuilder;
          paramPriority.<init>();
          paramPriority.append("Failed to build fetcher for: ");
          paramPriority.append(this.x);
          ((IllegalArgumentException)localObject).<init>(paramPriority.toString());
          parama.c((Exception)localObject);
          return;
        }
        this.p3 = ((com.bumptech.glide.load.data.d)localObject);
        if (this.p2) {
          cancel();
        } else {
          ((com.bumptech.glide.load.data.d)localObject).e(paramPriority, parama);
        }
      }
      catch (FileNotFoundException paramPriority)
      {
        parama.c(paramPriority);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\j\y\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */