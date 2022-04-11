package com.google.android.exoplayer2.upstream;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.o0;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;

public final class ContentDataSource
  extends h
{
  private final ContentResolver f;
  @Nullable
  private Uri g;
  @Nullable
  private AssetFileDescriptor h;
  @Nullable
  private FileInputStream i;
  private long j;
  private boolean k;
  
  public ContentDataSource(Context paramContext)
  {
    super(false);
    this.f = paramContext.getContentResolver();
  }
  
  /* Error */
  public void close()
    throws ContentDataSource.ContentDataSourceException
  {
    // Byte code:
    //   0: aload_0
    //   1: aconst_null
    //   2: putfield 40	com/google/android/exoplayer2/upstream/ContentDataSource:g	Landroid/net/Uri;
    //   5: aload_0
    //   6: getfield 42	com/google/android/exoplayer2/upstream/ContentDataSource:i	Ljava/io/FileInputStream;
    //   9: astore_1
    //   10: aload_1
    //   11: ifnull +7 -> 18
    //   14: aload_1
    //   15: invokevirtual 46	java/io/FileInputStream:close	()V
    //   18: aload_0
    //   19: aconst_null
    //   20: putfield 42	com/google/android/exoplayer2/upstream/ContentDataSource:i	Ljava/io/FileInputStream;
    //   23: aload_0
    //   24: getfield 48	com/google/android/exoplayer2/upstream/ContentDataSource:h	Landroid/content/res/AssetFileDescriptor;
    //   27: astore_1
    //   28: aload_1
    //   29: ifnull +7 -> 36
    //   32: aload_1
    //   33: invokevirtual 51	android/content/res/AssetFileDescriptor:close	()V
    //   36: aload_0
    //   37: aconst_null
    //   38: putfield 48	com/google/android/exoplayer2/upstream/ContentDataSource:h	Landroid/content/res/AssetFileDescriptor;
    //   41: aload_0
    //   42: getfield 53	com/google/android/exoplayer2/upstream/ContentDataSource:k	Z
    //   45: ifeq +12 -> 57
    //   48: aload_0
    //   49: iconst_0
    //   50: putfield 53	com/google/android/exoplayer2/upstream/ContentDataSource:k	Z
    //   53: aload_0
    //   54: invokevirtual 56	com/google/android/exoplayer2/upstream/h:p	()V
    //   57: return
    //   58: astore_1
    //   59: goto +18 -> 77
    //   62: astore_1
    //   63: new 6	com/google/android/exoplayer2/upstream/ContentDataSource$ContentDataSourceException
    //   66: astore_2
    //   67: aload_2
    //   68: aload_1
    //   69: sipush 2000
    //   72: invokespecial 59	com/google/android/exoplayer2/upstream/ContentDataSource$ContentDataSourceException:<init>	(Ljava/io/IOException;I)V
    //   75: aload_2
    //   76: athrow
    //   77: aload_0
    //   78: aconst_null
    //   79: putfield 48	com/google/android/exoplayer2/upstream/ContentDataSource:h	Landroid/content/res/AssetFileDescriptor;
    //   82: aload_0
    //   83: getfield 53	com/google/android/exoplayer2/upstream/ContentDataSource:k	Z
    //   86: ifeq +12 -> 98
    //   89: aload_0
    //   90: iconst_0
    //   91: putfield 53	com/google/android/exoplayer2/upstream/ContentDataSource:k	Z
    //   94: aload_0
    //   95: invokevirtual 56	com/google/android/exoplayer2/upstream/h:p	()V
    //   98: aload_1
    //   99: athrow
    //   100: astore_1
    //   101: goto +18 -> 119
    //   104: astore_2
    //   105: new 6	com/google/android/exoplayer2/upstream/ContentDataSource$ContentDataSourceException
    //   108: astore_1
    //   109: aload_1
    //   110: aload_2
    //   111: sipush 2000
    //   114: invokespecial 59	com/google/android/exoplayer2/upstream/ContentDataSource$ContentDataSourceException:<init>	(Ljava/io/IOException;I)V
    //   117: aload_1
    //   118: athrow
    //   119: aload_0
    //   120: aconst_null
    //   121: putfield 42	com/google/android/exoplayer2/upstream/ContentDataSource:i	Ljava/io/FileInputStream;
    //   124: aload_0
    //   125: getfield 48	com/google/android/exoplayer2/upstream/ContentDataSource:h	Landroid/content/res/AssetFileDescriptor;
    //   128: astore_2
    //   129: aload_2
    //   130: ifnull +7 -> 137
    //   133: aload_2
    //   134: invokevirtual 51	android/content/res/AssetFileDescriptor:close	()V
    //   137: aload_0
    //   138: aconst_null
    //   139: putfield 48	com/google/android/exoplayer2/upstream/ContentDataSource:h	Landroid/content/res/AssetFileDescriptor;
    //   142: aload_0
    //   143: getfield 53	com/google/android/exoplayer2/upstream/ContentDataSource:k	Z
    //   146: ifeq +12 -> 158
    //   149: aload_0
    //   150: iconst_0
    //   151: putfield 53	com/google/android/exoplayer2/upstream/ContentDataSource:k	Z
    //   154: aload_0
    //   155: invokevirtual 56	com/google/android/exoplayer2/upstream/h:p	()V
    //   158: aload_1
    //   159: athrow
    //   160: astore_1
    //   161: goto +18 -> 179
    //   164: astore_1
    //   165: new 6	com/google/android/exoplayer2/upstream/ContentDataSource$ContentDataSourceException
    //   168: astore_2
    //   169: aload_2
    //   170: aload_1
    //   171: sipush 2000
    //   174: invokespecial 59	com/google/android/exoplayer2/upstream/ContentDataSource$ContentDataSourceException:<init>	(Ljava/io/IOException;I)V
    //   177: aload_2
    //   178: athrow
    //   179: aload_0
    //   180: aconst_null
    //   181: putfield 48	com/google/android/exoplayer2/upstream/ContentDataSource:h	Landroid/content/res/AssetFileDescriptor;
    //   184: aload_0
    //   185: getfield 53	com/google/android/exoplayer2/upstream/ContentDataSource:k	Z
    //   188: ifeq +12 -> 200
    //   191: aload_0
    //   192: iconst_0
    //   193: putfield 53	com/google/android/exoplayer2/upstream/ContentDataSource:k	Z
    //   196: aload_0
    //   197: invokevirtual 56	com/google/android/exoplayer2/upstream/h:p	()V
    //   200: aload_1
    //   201: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	202	0	this	ContentDataSource
    //   9	24	1	localObject1	Object
    //   58	1	1	localObject2	Object
    //   62	37	1	localIOException1	IOException
    //   100	1	1	localObject3	Object
    //   108	51	1	localContentDataSourceException1	ContentDataSourceException
    //   160	1	1	localObject4	Object
    //   164	37	1	localIOException2	IOException
    //   66	10	2	localContentDataSourceException2	ContentDataSourceException
    //   104	7	2	localIOException3	IOException
    //   128	50	2	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   23	28	58	finally
    //   32	36	58	finally
    //   63	77	58	finally
    //   23	28	62	java/io/IOException
    //   32	36	62	java/io/IOException
    //   5	10	100	finally
    //   14	18	100	finally
    //   105	119	100	finally
    //   5	10	104	java/io/IOException
    //   14	18	104	java/io/IOException
    //   124	129	160	finally
    //   133	137	160	finally
    //   165	179	160	finally
    //   124	129	164	java/io/IOException
    //   133	137	164	java/io/IOException
  }
  
  @Nullable
  public Uri getUri()
  {
    return this.g;
  }
  
  public long j(n paramn)
    throws ContentDataSource.ContentDataSourceException
  {
    int m = 2000;
    try
    {
      Object localObject1 = paramn.a;
      this.g = ((Uri)localObject1);
      q(paramn);
      Object localObject2 = this.f.openAssetFileDescriptor((Uri)localObject1, "r");
      this.h = ((AssetFileDescriptor)localObject2);
      if (localObject2 != null)
      {
        long l1 = ((AssetFileDescriptor)localObject2).getLength();
        localObject1 = new java/io/FileInputStream;
        ((FileInputStream)localObject1).<init>(((AssetFileDescriptor)localObject2).getFileDescriptor());
        this.i = ((FileInputStream)localObject1);
        boolean bool = l1 < -1L;
        if ((bool) && (paramn.g > l1))
        {
          paramn = new com/google/android/exoplayer2/upstream/ContentDataSource$ContentDataSourceException;
          paramn.<init>(null, 2008);
          throw paramn;
        }
        long l2 = ((AssetFileDescriptor)localObject2).getStartOffset();
        l2 = ((FileInputStream)localObject1).skip(paramn.g + l2) - l2;
        if (l2 == paramn.g)
        {
          if (!bool)
          {
            localObject1 = ((FileInputStream)localObject1).getChannel();
            l1 = ((FileChannel)localObject1).size();
            if (l1 == 0L)
            {
              this.j = -1L;
            }
            else
            {
              l1 -= ((FileChannel)localObject1).position();
              this.j = l1;
              if (l1 < 0L)
              {
                paramn = new com/google/android/exoplayer2/upstream/ContentDataSource$ContentDataSourceException;
                paramn.<init>(null, 2008);
                throw paramn;
              }
            }
          }
          else
          {
            l1 -= l2;
            this.j = l1;
            if (l1 < 0L) {
              break label317;
            }
          }
          l1 = paramn.h;
          if (l1 != -1L)
          {
            l2 = this.j;
            if (l2 != -1L) {
              l1 = Math.min(l2, l1);
            }
            this.j = l1;
          }
          this.k = true;
          r(paramn);
          l1 = paramn.h;
          if (l1 == -1L) {
            l1 = this.j;
          }
          return l1;
          label317:
          paramn = new com/google/android/exoplayer2/upstream/ContentDataSource$ContentDataSourceException;
          paramn.<init>(null, 2008);
          throw paramn;
        }
        paramn = new com/google/android/exoplayer2/upstream/ContentDataSource$ContentDataSourceException;
        paramn.<init>(null, 2008);
        throw paramn;
      }
      localObject2 = new com/google/android/exoplayer2/upstream/ContentDataSource$ContentDataSourceException;
      paramn = new java/io/IOException;
      String str = String.valueOf(localObject1);
      int n = str.length();
      localObject1 = new java/lang/StringBuilder;
      ((StringBuilder)localObject1).<init>(n + 36);
      ((StringBuilder)localObject1).append("Could not open file descriptor for: ");
      ((StringBuilder)localObject1).append(str);
      paramn.<init>(((StringBuilder)localObject1).toString());
      ((ContentDataSourceException)localObject2).<init>(paramn, 2000);
      throw ((Throwable)localObject2);
    }
    catch (IOException paramn)
    {
      if ((paramn instanceof FileNotFoundException)) {
        m = 2005;
      }
      throw new ContentDataSourceException(paramn, m);
    }
    catch (ContentDataSourceException paramn)
    {
      throw paramn;
    }
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws ContentDataSource.ContentDataSourceException
  {
    if (paramInt2 == 0) {
      return 0;
    }
    long l1 = this.j;
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
      paramInt1 = ((FileInputStream)o0.i(this.i)).read(paramArrayOfByte, paramInt1, paramInt2);
      if (paramInt1 == -1) {
        return -1;
      }
      l1 = this.j;
      if (l1 != -1L) {
        this.j = (l1 - paramInt1);
      }
      o(paramInt1);
      return paramInt1;
    }
    catch (IOException paramArrayOfByte)
    {
      throw new ContentDataSourceException(paramArrayOfByte, 2000);
    }
  }
  
  public static class ContentDataSourceException
    extends DataSourceException
  {
    @Deprecated
    public ContentDataSourceException(IOException paramIOException)
    {
      this(paramIOException, 2000);
    }
    
    public ContentDataSourceException(@Nullable IOException paramIOException, int paramInt)
    {
      super(paramInt);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\upstream\ContentDataSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */