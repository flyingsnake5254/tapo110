package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import android.system.ErrnoException;
import android.system.OsConstants;
import android.text.TextUtils;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public final class FileDataSource
  extends h
{
  @Nullable
  private RandomAccessFile f;
  @Nullable
  private Uri g;
  private long h;
  private boolean i;
  
  public FileDataSource()
  {
    super(false);
  }
  
  private static RandomAccessFile s(Uri paramUri)
    throws FileDataSource.FileDataSourceException
  {
    int j = 2006;
    try
    {
      RandomAccessFile localRandomAccessFile = new RandomAccessFile((String)g.e(paramUri.getPath()), "r");
      return localRandomAccessFile;
    }
    catch (RuntimeException paramUri)
    {
      throw new FileDataSourceException(paramUri, 2000);
    }
    catch (SecurityException paramUri)
    {
      throw new FileDataSourceException(paramUri, 2006);
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      if ((TextUtils.isEmpty(paramUri.getQuery())) && (TextUtils.isEmpty(paramUri.getFragment())))
      {
        if ((o0.a < 21) || (!a.a(localFileNotFoundException.getCause()))) {
          j = 2005;
        }
        throw new FileDataSourceException(localFileNotFoundException, j);
      }
      throw new FileDataSourceException(String.format("uri has query and/or fragment, which are not supported. Did you call Uri.parse() on a string containing '?' or '#'? Use Uri.fromFile(new File(path)) to avoid this. path=%s,query=%s,fragment=%s", new Object[] { paramUri.getPath(), paramUri.getQuery(), paramUri.getFragment() }), localFileNotFoundException, 1004);
    }
  }
  
  /* Error */
  public void close()
    throws FileDataSource.FileDataSourceException
  {
    // Byte code:
    //   0: aload_0
    //   1: aconst_null
    //   2: putfield 98	com/google/android/exoplayer2/upstream/FileDataSource:g	Landroid/net/Uri;
    //   5: aload_0
    //   6: getfield 100	com/google/android/exoplayer2/upstream/FileDataSource:f	Ljava/io/RandomAccessFile;
    //   9: astore_1
    //   10: aload_1
    //   11: ifnull +7 -> 18
    //   14: aload_1
    //   15: invokevirtual 102	java/io/RandomAccessFile:close	()V
    //   18: aload_0
    //   19: aconst_null
    //   20: putfield 100	com/google/android/exoplayer2/upstream/FileDataSource:f	Ljava/io/RandomAccessFile;
    //   23: aload_0
    //   24: getfield 104	com/google/android/exoplayer2/upstream/FileDataSource:i	Z
    //   27: ifeq +12 -> 39
    //   30: aload_0
    //   31: iconst_0
    //   32: putfield 104	com/google/android/exoplayer2/upstream/FileDataSource:i	Z
    //   35: aload_0
    //   36: invokevirtual 107	com/google/android/exoplayer2/upstream/h:p	()V
    //   39: return
    //   40: astore_1
    //   41: goto +18 -> 59
    //   44: astore_1
    //   45: new 6	com/google/android/exoplayer2/upstream/FileDataSource$FileDataSourceException
    //   48: astore_2
    //   49: aload_2
    //   50: aload_1
    //   51: sipush 2000
    //   54: invokespecial 57	com/google/android/exoplayer2/upstream/FileDataSource$FileDataSourceException:<init>	(Ljava/lang/Throwable;I)V
    //   57: aload_2
    //   58: athrow
    //   59: aload_0
    //   60: aconst_null
    //   61: putfield 100	com/google/android/exoplayer2/upstream/FileDataSource:f	Ljava/io/RandomAccessFile;
    //   64: aload_0
    //   65: getfield 104	com/google/android/exoplayer2/upstream/FileDataSource:i	Z
    //   68: ifeq +12 -> 80
    //   71: aload_0
    //   72: iconst_0
    //   73: putfield 104	com/google/android/exoplayer2/upstream/FileDataSource:i	Z
    //   76: aload_0
    //   77: invokevirtual 107	com/google/android/exoplayer2/upstream/h:p	()V
    //   80: aload_1
    //   81: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	this	FileDataSource
    //   9	6	1	localRandomAccessFile	RandomAccessFile
    //   40	1	1	localObject	Object
    //   44	37	1	localIOException	IOException
    //   48	10	2	localFileDataSourceException	FileDataSourceException
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
    throws FileDataSource.FileDataSourceException
  {
    Object localObject = paramn.a;
    this.g = ((Uri)localObject);
    q(paramn);
    localObject = s((Uri)localObject);
    this.f = ((RandomAccessFile)localObject);
    try
    {
      ((RandomAccessFile)localObject).seek(paramn.g);
      long l1 = paramn.h;
      long l2 = l1;
      if (l1 == -1L) {
        l2 = this.f.length() - paramn.g;
      }
      this.h = l2;
      if (l2 >= 0L)
      {
        this.i = true;
        r(paramn);
        return this.h;
      }
      throw new FileDataSourceException(null, null, 2008);
    }
    catch (IOException paramn)
    {
      throw new FileDataSourceException(paramn, 2000);
    }
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws FileDataSource.FileDataSourceException
  {
    if (paramInt2 == 0) {
      return 0;
    }
    if (this.h == 0L) {
      return -1;
    }
    try
    {
      paramInt1 = ((RandomAccessFile)o0.i(this.f)).read(paramArrayOfByte, paramInt1, (int)Math.min(this.h, paramInt2));
      if (paramInt1 > 0)
      {
        this.h -= paramInt1;
        o(paramInt1);
      }
      return paramInt1;
    }
    catch (IOException paramArrayOfByte)
    {
      throw new FileDataSourceException(paramArrayOfByte, 2000);
    }
  }
  
  public static class FileDataSourceException
    extends DataSourceException
  {
    @Deprecated
    public FileDataSourceException(Exception paramException)
    {
      super(2000);
    }
    
    @Deprecated
    public FileDataSourceException(String paramString, IOException paramIOException)
    {
      super(paramIOException, 2000);
    }
    
    public FileDataSourceException(@Nullable String paramString, @Nullable Throwable paramThrowable, int paramInt)
    {
      super(paramThrowable, paramInt);
    }
    
    public FileDataSourceException(Throwable paramThrowable, int paramInt)
    {
      super(paramInt);
    }
  }
  
  @RequiresApi(21)
  private static final class a
  {
    @DoNotInline
    private static boolean b(@Nullable Throwable paramThrowable)
    {
      boolean bool;
      if (((paramThrowable instanceof ErrnoException)) && (((ErrnoException)paramThrowable).errno == OsConstants.EACCES)) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\upstream\FileDataSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */