package com.google.android.exoplayer2.upstream;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public final class AssetDataSource
  extends h
{
  private final AssetManager f;
  @Nullable
  private Uri g;
  @Nullable
  private InputStream h;
  private long i;
  private boolean j;
  
  public AssetDataSource(Context paramContext)
  {
    super(false);
    this.f = paramContext.getAssets();
  }
  
  /* Error */
  public void close()
    throws AssetDataSource.AssetDataSourceException
  {
    // Byte code:
    //   0: aload_0
    //   1: aconst_null
    //   2: putfield 38	com/google/android/exoplayer2/upstream/AssetDataSource:g	Landroid/net/Uri;
    //   5: aload_0
    //   6: getfield 40	com/google/android/exoplayer2/upstream/AssetDataSource:h	Ljava/io/InputStream;
    //   9: astore_1
    //   10: aload_1
    //   11: ifnull +7 -> 18
    //   14: aload_1
    //   15: invokevirtual 44	java/io/InputStream:close	()V
    //   18: aload_0
    //   19: aconst_null
    //   20: putfield 40	com/google/android/exoplayer2/upstream/AssetDataSource:h	Ljava/io/InputStream;
    //   23: aload_0
    //   24: getfield 46	com/google/android/exoplayer2/upstream/AssetDataSource:j	Z
    //   27: ifeq +12 -> 39
    //   30: aload_0
    //   31: iconst_0
    //   32: putfield 46	com/google/android/exoplayer2/upstream/AssetDataSource:j	Z
    //   35: aload_0
    //   36: invokevirtual 49	com/google/android/exoplayer2/upstream/h:p	()V
    //   39: return
    //   40: astore_1
    //   41: goto +18 -> 59
    //   44: astore_1
    //   45: new 6	com/google/android/exoplayer2/upstream/AssetDataSource$AssetDataSourceException
    //   48: astore_2
    //   49: aload_2
    //   50: aload_1
    //   51: sipush 2000
    //   54: invokespecial 52	com/google/android/exoplayer2/upstream/AssetDataSource$AssetDataSourceException:<init>	(Ljava/lang/Throwable;I)V
    //   57: aload_2
    //   58: athrow
    //   59: aload_0
    //   60: aconst_null
    //   61: putfield 40	com/google/android/exoplayer2/upstream/AssetDataSource:h	Ljava/io/InputStream;
    //   64: aload_0
    //   65: getfield 46	com/google/android/exoplayer2/upstream/AssetDataSource:j	Z
    //   68: ifeq +12 -> 80
    //   71: aload_0
    //   72: iconst_0
    //   73: putfield 46	com/google/android/exoplayer2/upstream/AssetDataSource:j	Z
    //   76: aload_0
    //   77: invokevirtual 49	com/google/android/exoplayer2/upstream/h:p	()V
    //   80: aload_1
    //   81: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	this	AssetDataSource
    //   9	6	1	localInputStream	InputStream
    //   40	1	1	localObject	Object
    //   44	37	1	localIOException	IOException
    //   48	10	2	localAssetDataSourceException	AssetDataSourceException
    // Exception table:
    //   from	to	target	type
    //   5	10	40	finally
    //   14	18	40	finally
    //   45	59	40	finally
    //   5	10	44	java/io/IOException
    //   14	18	44	java/io/IOException
  }
  
  @Nullable
  public Uri getUri()
  {
    return this.g;
  }
  
  public long j(n paramn)
    throws AssetDataSource.AssetDataSourceException
  {
    try
    {
      Object localObject = paramn.a;
      this.g = ((Uri)localObject);
      String str = (String)g.e(((Uri)localObject).getPath());
      if (str.startsWith("/android_asset/"))
      {
        localObject = str.substring(15);
      }
      else
      {
        localObject = str;
        if (str.startsWith("/")) {
          localObject = str.substring(1);
        }
      }
      q(paramn);
      localObject = this.f.open((String)localObject, 1);
      this.h = ((InputStream)localObject);
      if (((InputStream)localObject).skip(paramn.g) >= paramn.g)
      {
        long l = paramn.h;
        if (l != -1L)
        {
          this.i = l;
        }
        else
        {
          l = this.h.available();
          this.i = l;
          if (l == 2147483647L) {
            this.i = -1L;
          }
        }
        this.j = true;
        r(paramn);
        return this.i;
      }
      paramn = new com/google/android/exoplayer2/upstream/AssetDataSource$AssetDataSourceException;
      paramn.<init>(null, 2008);
      throw paramn;
    }
    catch (IOException paramn)
    {
      int k;
      if ((paramn instanceof FileNotFoundException)) {
        k = 2005;
      } else {
        k = 2000;
      }
      throw new AssetDataSourceException(paramn, k);
    }
    catch (AssetDataSourceException paramn)
    {
      throw paramn;
    }
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws AssetDataSource.AssetDataSourceException
  {
    if (paramInt2 == 0) {
      return 0;
    }
    long l1 = this.i;
    if (l1 == 0L) {
      return -1;
    }
    long l2;
    if (l1 != -1L) {
      l2 = paramInt2;
    }
    try
    {
      paramInt2 = (int)Math.min(l1, l2);
      paramInt1 = ((InputStream)o0.i(this.h)).read(paramArrayOfByte, paramInt1, paramInt2);
      if (paramInt1 == -1) {
        return -1;
      }
      l1 = this.i;
      if (l1 != -1L) {
        this.i = (l1 - paramInt1);
      }
      o(paramInt1);
      return paramInt1;
    }
    catch (IOException paramArrayOfByte)
    {
      throw new AssetDataSourceException(paramArrayOfByte, 2000);
    }
  }
  
  public static final class AssetDataSourceException
    extends DataSourceException
  {
    @Deprecated
    public AssetDataSourceException(IOException paramIOException)
    {
      super(2000);
    }
    
    public AssetDataSourceException(@Nullable Throwable paramThrowable, int paramInt)
    {
      super(paramInt);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\upstream\AssetDataSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */