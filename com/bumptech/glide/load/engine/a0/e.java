package com.bumptech.glide.load.engine.a0;

import android.util.Log;
import com.bumptech.glide.k.a.e;
import java.io.File;
import java.io.IOException;

public class e
  implements a
{
  private final j a;
  private final File b;
  private final long c;
  private final c d = new c();
  private com.bumptech.glide.k.a e;
  
  @Deprecated
  protected e(File paramFile, long paramLong)
  {
    this.b = paramFile;
    this.c = paramLong;
    this.a = new j();
  }
  
  public static a c(File paramFile, long paramLong)
  {
    return new e(paramFile, paramLong);
  }
  
  private com.bumptech.glide.k.a d()
    throws IOException
  {
    try
    {
      if (this.e == null) {
        this.e = com.bumptech.glide.k.a.C(this.b, 1, 1, this.c);
      }
      com.bumptech.glide.k.a locala = this.e;
      return locala;
    }
    finally {}
  }
  
  /* Error */
  public void a(com.bumptech.glide.load.c paramc, a.b paramb)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 36	com/bumptech/glide/load/engine/a0/e:a	Lcom/bumptech/glide/load/engine/a0/j;
    //   4: aload_1
    //   5: invokevirtual 57	com/bumptech/glide/load/engine/a0/j:b	(Lcom/bumptech/glide/load/c;)Ljava/lang/String;
    //   8: astore_3
    //   9: aload_0
    //   10: getfield 27	com/bumptech/glide/load/engine/a0/e:d	Lcom/bumptech/glide/load/engine/a0/c;
    //   13: aload_3
    //   14: invokevirtual 60	com/bumptech/glide/load/engine/a0/c:a	(Ljava/lang/String;)V
    //   17: ldc 62
    //   19: iconst_2
    //   20: invokestatic 68	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   23: ifeq +54 -> 77
    //   26: new 70	java/lang/StringBuilder
    //   29: astore 4
    //   31: aload 4
    //   33: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   36: aload 4
    //   38: ldc 73
    //   40: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: pop
    //   44: aload 4
    //   46: aload_3
    //   47: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: aload 4
    //   53: ldc 79
    //   55: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: aload 4
    //   61: aload_1
    //   62: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: ldc 62
    //   68: aload 4
    //   70: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: invokestatic 90	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   76: pop
    //   77: aload_0
    //   78: invokespecial 92	com/bumptech/glide/load/engine/a0/e:d	()Lcom/bumptech/glide/k/a;
    //   81: astore 4
    //   83: aload 4
    //   85: aload_3
    //   86: invokevirtual 96	com/bumptech/glide/k/a:A	(Ljava/lang/String;)Lcom/bumptech/glide/k/a$e;
    //   89: astore_1
    //   90: aload_1
    //   91: ifnull +12 -> 103
    //   94: aload_0
    //   95: getfield 27	com/bumptech/glide/load/engine/a0/e:d	Lcom/bumptech/glide/load/engine/a0/c;
    //   98: aload_3
    //   99: invokevirtual 98	com/bumptech/glide/load/engine/a0/c:b	(Ljava/lang/String;)V
    //   102: return
    //   103: aload 4
    //   105: aload_3
    //   106: invokevirtual 102	com/bumptech/glide/k/a:x	(Ljava/lang/String;)Lcom/bumptech/glide/k/a$c;
    //   109: astore_1
    //   110: aload_1
    //   111: ifnull +35 -> 146
    //   114: aload_2
    //   115: aload_1
    //   116: iconst_0
    //   117: invokevirtual 108	com/bumptech/glide/k/a$c:f	(I)Ljava/io/File;
    //   120: invokeinterface 113 2 0
    //   125: ifeq +7 -> 132
    //   128: aload_1
    //   129: invokevirtual 115	com/bumptech/glide/k/a$c:e	()V
    //   132: aload_1
    //   133: invokevirtual 117	com/bumptech/glide/k/a$c:b	()V
    //   136: goto +64 -> 200
    //   139: astore_2
    //   140: aload_1
    //   141: invokevirtual 117	com/bumptech/glide/k/a$c:b	()V
    //   144: aload_2
    //   145: athrow
    //   146: new 119	java/lang/IllegalStateException
    //   149: astore_2
    //   150: new 70	java/lang/StringBuilder
    //   153: astore_1
    //   154: aload_1
    //   155: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   158: aload_1
    //   159: ldc 121
    //   161: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: aload_1
    //   166: aload_3
    //   167: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: pop
    //   171: aload_2
    //   172: aload_1
    //   173: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   176: invokespecial 123	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   179: aload_2
    //   180: athrow
    //   181: astore_1
    //   182: ldc 62
    //   184: iconst_5
    //   185: invokestatic 68	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   188: ifeq +12 -> 200
    //   191: ldc 62
    //   193: ldc 125
    //   195: aload_1
    //   196: invokestatic 129	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   199: pop
    //   200: aload_0
    //   201: getfield 27	com/bumptech/glide/load/engine/a0/e:d	Lcom/bumptech/glide/load/engine/a0/c;
    //   204: aload_3
    //   205: invokevirtual 98	com/bumptech/glide/load/engine/a0/c:b	(Ljava/lang/String;)V
    //   208: return
    //   209: astore_1
    //   210: aload_0
    //   211: getfield 27	com/bumptech/glide/load/engine/a0/e:d	Lcom/bumptech/glide/load/engine/a0/c;
    //   214: aload_3
    //   215: invokevirtual 98	com/bumptech/glide/load/engine/a0/c:b	(Ljava/lang/String;)V
    //   218: aload_1
    //   219: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	220	0	this	e
    //   0	220	1	paramc	com.bumptech.glide.load.c
    //   0	220	2	paramb	a.b
    //   8	207	3	str	String
    //   29	75	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   114	132	139	finally
    //   77	90	181	java/io/IOException
    //   103	110	181	java/io/IOException
    //   132	136	181	java/io/IOException
    //   140	146	181	java/io/IOException
    //   146	181	181	java/io/IOException
    //   17	77	209	finally
    //   77	90	209	finally
    //   103	110	209	finally
    //   132	136	209	finally
    //   140	146	209	finally
    //   146	181	209	finally
    //   182	200	209	finally
  }
  
  public File b(com.bumptech.glide.load.c paramc)
  {
    Object localObject = this.a.b(paramc);
    if (Log.isLoggable("DiskLruCacheWrapper", 2))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Get: Obtained: ");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(" for for Key: ");
      localStringBuilder.append(paramc);
      Log.v("DiskLruCacheWrapper", localStringBuilder.toString());
    }
    StringBuilder localStringBuilder = null;
    try
    {
      localObject = d().A((String)localObject);
      paramc = localStringBuilder;
      if (localObject != null) {
        paramc = ((a.e)localObject).a(0);
      }
    }
    catch (IOException localIOException)
    {
      paramc = localStringBuilder;
      if (Log.isLoggable("DiskLruCacheWrapper", 5))
      {
        Log.w("DiskLruCacheWrapper", "Unable to get from disk cache", localIOException);
        paramc = localStringBuilder;
      }
    }
    return paramc;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\engine\a0\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */