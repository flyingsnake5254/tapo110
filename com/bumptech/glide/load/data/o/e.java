package com.bumptech.glide.load.data.o;

import android.content.ContentResolver;
import android.net.Uri;
import android.text.TextUtils;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.engine.z.b;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

class e
{
  private static final a a = new a();
  private final a b;
  private final d c;
  private final b d;
  private final ContentResolver e;
  private final List<ImageHeaderParser> f;
  
  e(List<ImageHeaderParser> paramList, a parama, d paramd, b paramb, ContentResolver paramContentResolver)
  {
    this.b = parama;
    this.c = paramd;
    this.d = paramb;
    this.e = paramContentResolver;
    this.f = paramList;
  }
  
  e(List<ImageHeaderParser> paramList, d paramd, b paramb, ContentResolver paramContentResolver)
  {
    this(paramList, a, paramd, paramb, paramContentResolver);
  }
  
  /* Error */
  @androidx.annotation.Nullable
  private String b(@androidx.annotation.NonNull Uri paramUri)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: getfield 32	com/bumptech/glide/load/data/o/e:c	Lcom/bumptech/glide/load/data/o/d;
    //   6: aload_1
    //   7: invokeinterface 54 2 0
    //   12: astore_3
    //   13: aload_3
    //   14: ifnull +38 -> 52
    //   17: aload_3
    //   18: astore 4
    //   20: aload_3
    //   21: invokeinterface 60 1 0
    //   26: ifeq +26 -> 52
    //   29: aload_3
    //   30: astore 4
    //   32: aload_3
    //   33: iconst_0
    //   34: invokeinterface 64 2 0
    //   39: astore_2
    //   40: aload_3
    //   41: invokeinterface 67 1 0
    //   46: aload_2
    //   47: areturn
    //   48: astore_2
    //   49: goto +25 -> 74
    //   52: aload_3
    //   53: ifnull +9 -> 62
    //   56: aload_3
    //   57: invokeinterface 67 1 0
    //   62: aconst_null
    //   63: areturn
    //   64: astore 4
    //   66: aload_2
    //   67: astore_1
    //   68: goto +89 -> 157
    //   71: astore_2
    //   72: aconst_null
    //   73: astore_3
    //   74: aload_3
    //   75: astore 4
    //   77: ldc 69
    //   79: iconst_3
    //   80: invokestatic 75	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   83: ifeq +55 -> 138
    //   86: aload_3
    //   87: astore 4
    //   89: new 77	java/lang/StringBuilder
    //   92: astore 5
    //   94: aload_3
    //   95: astore 4
    //   97: aload 5
    //   99: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   102: aload_3
    //   103: astore 4
    //   105: aload 5
    //   107: ldc 80
    //   109: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: pop
    //   113: aload_3
    //   114: astore 4
    //   116: aload 5
    //   118: aload_1
    //   119: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   122: pop
    //   123: aload_3
    //   124: astore 4
    //   126: ldc 69
    //   128: aload 5
    //   130: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   133: aload_2
    //   134: invokestatic 94	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   137: pop
    //   138: aload_3
    //   139: ifnull +9 -> 148
    //   142: aload_3
    //   143: invokeinterface 67 1 0
    //   148: aconst_null
    //   149: areturn
    //   150: astore_3
    //   151: aload 4
    //   153: astore_1
    //   154: aload_3
    //   155: astore 4
    //   157: aload_1
    //   158: ifnull +9 -> 167
    //   161: aload_1
    //   162: invokeinterface 67 1 0
    //   167: aload 4
    //   169: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	170	0	this	e
    //   0	170	1	paramUri	Uri
    //   1	46	2	str	String
    //   48	19	2	localSecurityException1	SecurityException
    //   71	63	2	localSecurityException2	SecurityException
    //   12	131	3	localCursor1	android.database.Cursor
    //   150	5	3	localObject1	Object
    //   18	13	4	localCursor2	android.database.Cursor
    //   64	1	4	localObject2	Object
    //   75	93	4	localObject3	Object
    //   92	37	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   20	29	48	java/lang/SecurityException
    //   32	40	48	java/lang/SecurityException
    //   2	13	64	finally
    //   2	13	71	java/lang/SecurityException
    //   20	29	150	finally
    //   32	40	150	finally
    //   77	86	150	finally
    //   89	94	150	finally
    //   97	102	150	finally
    //   105	113	150	finally
    //   116	123	150	finally
    //   126	138	150	finally
  }
  
  private boolean c(File paramFile)
  {
    boolean bool;
    if ((this.b.a(paramFile)) && (0L < this.b.c(paramFile))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  /* Error */
  int a(Uri paramUri)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_3
    //   4: aconst_null
    //   5: astore 4
    //   7: aload_0
    //   8: getfield 36	com/bumptech/glide/load/data/o/e:e	Landroid/content/ContentResolver;
    //   11: aload_1
    //   12: invokevirtual 113	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   15: astore 5
    //   17: aload 5
    //   19: astore 4
    //   21: aload 5
    //   23: astore_2
    //   24: aload 5
    //   26: astore_3
    //   27: aload_0
    //   28: getfield 38	com/bumptech/glide/load/data/o/e:f	Ljava/util/List;
    //   31: aload 5
    //   33: aload_0
    //   34: getfield 34	com/bumptech/glide/load/data/o/e:d	Lcom/bumptech/glide/load/engine/z/b;
    //   37: invokestatic 118	com/bumptech/glide/load/b:b	(Ljava/util/List;Ljava/io/InputStream;Lcom/bumptech/glide/load/engine/z/b;)I
    //   40: istore 6
    //   42: aload 5
    //   44: ifnull +8 -> 52
    //   47: aload 5
    //   49: invokevirtual 121	java/io/InputStream:close	()V
    //   52: iload 6
    //   54: ireturn
    //   55: astore_1
    //   56: goto +88 -> 144
    //   59: astore 4
    //   61: aload_2
    //   62: astore_3
    //   63: aload 4
    //   65: astore_2
    //   66: goto +4 -> 70
    //   69: astore_2
    //   70: aload_3
    //   71: astore 4
    //   73: ldc 69
    //   75: iconst_3
    //   76: invokestatic 75	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   79: ifeq +55 -> 134
    //   82: aload_3
    //   83: astore 4
    //   85: new 77	java/lang/StringBuilder
    //   88: astore 5
    //   90: aload_3
    //   91: astore 4
    //   93: aload 5
    //   95: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   98: aload_3
    //   99: astore 4
    //   101: aload 5
    //   103: ldc 123
    //   105: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: pop
    //   109: aload_3
    //   110: astore 4
    //   112: aload 5
    //   114: aload_1
    //   115: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   118: pop
    //   119: aload_3
    //   120: astore 4
    //   122: ldc 69
    //   124: aload 5
    //   126: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   129: aload_2
    //   130: invokestatic 94	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   133: pop
    //   134: aload_3
    //   135: ifnull +7 -> 142
    //   138: aload_3
    //   139: invokevirtual 121	java/io/InputStream:close	()V
    //   142: iconst_m1
    //   143: ireturn
    //   144: aload 4
    //   146: ifnull +8 -> 154
    //   149: aload 4
    //   151: invokevirtual 121	java/io/InputStream:close	()V
    //   154: aload_1
    //   155: athrow
    //   156: astore_1
    //   157: goto -105 -> 52
    //   160: astore_1
    //   161: goto -19 -> 142
    //   164: astore 4
    //   166: goto -12 -> 154
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	169	0	this	e
    //   0	169	1	paramUri	Uri
    //   1	65	2	localObject1	Object
    //   69	61	2	localIOException1	java.io.IOException
    //   3	136	3	localObject2	Object
    //   5	15	4	localObject3	Object
    //   59	5	4	localNullPointerException	NullPointerException
    //   71	79	4	localObject4	Object
    //   164	1	4	localIOException2	java.io.IOException
    //   15	110	5	localObject5	Object
    //   40	13	6	i	int
    // Exception table:
    //   from	to	target	type
    //   7	17	55	finally
    //   27	42	55	finally
    //   73	82	55	finally
    //   85	90	55	finally
    //   93	98	55	finally
    //   101	109	55	finally
    //   112	119	55	finally
    //   122	134	55	finally
    //   7	17	59	java/lang/NullPointerException
    //   27	42	59	java/lang/NullPointerException
    //   7	17	69	java/io/IOException
    //   27	42	69	java/io/IOException
    //   47	52	156	java/io/IOException
    //   138	142	160	java/io/IOException
    //   149	154	164	java/io/IOException
  }
  
  public InputStream d(Uri paramUri)
    throws FileNotFoundException
  {
    Object localObject1 = b(paramUri);
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      return null;
    }
    localObject1 = this.b.b((String)localObject1);
    if (!c((File)localObject1)) {
      return null;
    }
    localObject1 = Uri.fromFile((File)localObject1);
    try
    {
      localObject2 = this.e.openInputStream((Uri)localObject1);
      return (InputStream)localObject2;
    }
    catch (NullPointerException localNullPointerException)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("NPE opening uri: ");
      ((StringBuilder)localObject2).append(paramUri);
      ((StringBuilder)localObject2).append(" -> ");
      ((StringBuilder)localObject2).append(localObject1);
      throw ((FileNotFoundException)new FileNotFoundException(((StringBuilder)localObject2).toString()).initCause(localNullPointerException));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\data\o\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */