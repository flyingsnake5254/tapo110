package androidx.documentfile.provider;

import android.content.Context;
import android.net.Uri;
import android.provider.DocumentsContract;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

@RequiresApi(21)
class TreeDocumentFile
  extends DocumentFile
{
  private Context mContext;
  private Uri mUri;
  
  TreeDocumentFile(@Nullable DocumentFile paramDocumentFile, Context paramContext, Uri paramUri)
  {
    super(paramDocumentFile);
    this.mContext = paramContext;
    this.mUri = paramUri;
  }
  
  private static void closeQuietly(@Nullable AutoCloseable paramAutoCloseable)
  {
    if (paramAutoCloseable != null) {}
    try
    {
      try
      {
        paramAutoCloseable.close();
      }
      catch (RuntimeException paramAutoCloseable)
      {
        throw paramAutoCloseable;
      }
      return;
    }
    catch (Exception paramAutoCloseable)
    {
      for (;;) {}
    }
  }
  
  @Nullable
  private static Uri createFile(Context paramContext, Uri paramUri, String paramString1, String paramString2)
  {
    try
    {
      paramContext = DocumentsContract.createDocument(paramContext.getContentResolver(), paramUri, paramString1, paramString2);
      return paramContext;
    }
    catch (Exception paramContext) {}
    return null;
  }
  
  public boolean canRead()
  {
    return DocumentsContractApi19.canRead(this.mContext, this.mUri);
  }
  
  public boolean canWrite()
  {
    return DocumentsContractApi19.canWrite(this.mContext, this.mUri);
  }
  
  @Nullable
  public DocumentFile createDirectory(String paramString)
  {
    paramString = createFile(this.mContext, this.mUri, "vnd.android.document/directory", paramString);
    if (paramString != null) {
      paramString = new TreeDocumentFile(this, this.mContext, paramString);
    } else {
      paramString = null;
    }
    return paramString;
  }
  
  @Nullable
  public DocumentFile createFile(String paramString1, String paramString2)
  {
    paramString1 = createFile(this.mContext, this.mUri, paramString1, paramString2);
    if (paramString1 != null) {
      paramString1 = new TreeDocumentFile(this, this.mContext, paramString1);
    } else {
      paramString1 = null;
    }
    return paramString1;
  }
  
  public boolean delete()
  {
    try
    {
      boolean bool = DocumentsContract.deleteDocument(this.mContext.getContentResolver(), this.mUri);
      return bool;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public boolean exists()
  {
    return DocumentsContractApi19.exists(this.mContext, this.mUri);
  }
  
  @Nullable
  public String getName()
  {
    return DocumentsContractApi19.getName(this.mContext, this.mUri);
  }
  
  @Nullable
  public String getType()
  {
    return DocumentsContractApi19.getType(this.mContext, this.mUri);
  }
  
  public Uri getUri()
  {
    return this.mUri;
  }
  
  public boolean isDirectory()
  {
    return DocumentsContractApi19.isDirectory(this.mContext, this.mUri);
  }
  
  public boolean isFile()
  {
    return DocumentsContractApi19.isFile(this.mContext, this.mUri);
  }
  
  public boolean isVirtual()
  {
    return DocumentsContractApi19.isVirtual(this.mContext, this.mUri);
  }
  
  public long lastModified()
  {
    return DocumentsContractApi19.lastModified(this.mContext, this.mUri);
  }
  
  public long length()
  {
    return DocumentsContractApi19.length(this.mContext, this.mUri);
  }
  
  /* Error */
  public DocumentFile[] listFiles()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 19	androidx/documentfile/provider/TreeDocumentFile:mContext	Landroid/content/Context;
    //   4: invokevirtual 43	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   7: astore_1
    //   8: aload_0
    //   9: getfield 21	androidx/documentfile/provider/TreeDocumentFile:mUri	Landroid/net/Uri;
    //   12: astore_2
    //   13: aload_2
    //   14: aload_2
    //   15: invokestatic 110	android/provider/DocumentsContract:getDocumentId	(Landroid/net/Uri;)Ljava/lang/String;
    //   18: invokestatic 114	android/provider/DocumentsContract:buildChildDocumentsUriUsingTree	(Landroid/net/Uri;Ljava/lang/String;)Landroid/net/Uri;
    //   21: astore_3
    //   22: new 116	java/util/ArrayList
    //   25: dup
    //   26: invokespecial 118	java/util/ArrayList:<init>	()V
    //   29: astore 4
    //   31: iconst_0
    //   32: istore 5
    //   34: aconst_null
    //   35: astore_2
    //   36: aconst_null
    //   37: astore 6
    //   39: aload_1
    //   40: aload_3
    //   41: iconst_1
    //   42: anewarray 120	java/lang/String
    //   45: dup
    //   46: iconst_0
    //   47: ldc 122
    //   49: aastore
    //   50: aconst_null
    //   51: aconst_null
    //   52: aconst_null
    //   53: invokevirtual 128	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   56: astore_1
    //   57: aload_1
    //   58: astore_3
    //   59: aload_1
    //   60: astore 6
    //   62: aload_1
    //   63: astore_2
    //   64: aload_1
    //   65: invokeinterface 133 1 0
    //   70: ifeq +38 -> 108
    //   73: aload_1
    //   74: astore 6
    //   76: aload_1
    //   77: astore_2
    //   78: aload_1
    //   79: iconst_0
    //   80: invokeinterface 137 2 0
    //   85: astore_3
    //   86: aload_1
    //   87: astore 6
    //   89: aload_1
    //   90: astore_2
    //   91: aload 4
    //   93: aload_0
    //   94: getfield 21	androidx/documentfile/provider/TreeDocumentFile:mUri	Landroid/net/Uri;
    //   97: aload_3
    //   98: invokestatic 140	android/provider/DocumentsContract:buildDocumentUriUsingTree	(Landroid/net/Uri;Ljava/lang/String;)Landroid/net/Uri;
    //   101: invokevirtual 144	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   104: pop
    //   105: goto -48 -> 57
    //   108: aload_3
    //   109: invokestatic 146	androidx/documentfile/provider/TreeDocumentFile:closeQuietly	(Ljava/lang/AutoCloseable;)V
    //   112: goto +59 -> 171
    //   115: astore_2
    //   116: goto +116 -> 232
    //   119: astore_1
    //   120: aload_2
    //   121: astore 6
    //   123: new 148	java/lang/StringBuilder
    //   126: astore_3
    //   127: aload_2
    //   128: astore 6
    //   130: aload_3
    //   131: invokespecial 149	java/lang/StringBuilder:<init>	()V
    //   134: aload_2
    //   135: astore 6
    //   137: aload_3
    //   138: ldc -105
    //   140: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: pop
    //   144: aload_2
    //   145: astore 6
    //   147: aload_3
    //   148: aload_1
    //   149: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   152: pop
    //   153: aload_2
    //   154: astore 6
    //   156: ldc -96
    //   158: aload_3
    //   159: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   162: invokestatic 169	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   165: pop
    //   166: aload_2
    //   167: astore_3
    //   168: goto -60 -> 108
    //   171: aload 4
    //   173: aload 4
    //   175: invokevirtual 173	java/util/ArrayList:size	()I
    //   178: anewarray 175	android/net/Uri
    //   181: invokevirtual 179	java/util/ArrayList:toArray	([Ljava/lang/Object;)[Ljava/lang/Object;
    //   184: checkcast 181	[Landroid/net/Uri;
    //   187: astore_2
    //   188: aload_2
    //   189: arraylength
    //   190: anewarray 4	androidx/documentfile/provider/DocumentFile
    //   193: astore 6
    //   195: iload 5
    //   197: aload_2
    //   198: arraylength
    //   199: if_icmpge +30 -> 229
    //   202: aload 6
    //   204: iload 5
    //   206: new 2	androidx/documentfile/provider/TreeDocumentFile
    //   209: dup
    //   210: aload_0
    //   211: aload_0
    //   212: getfield 19	androidx/documentfile/provider/TreeDocumentFile:mContext	Landroid/content/Context;
    //   215: aload_2
    //   216: iload 5
    //   218: aaload
    //   219: invokespecial 68	androidx/documentfile/provider/TreeDocumentFile:<init>	(Landroidx/documentfile/provider/DocumentFile;Landroid/content/Context;Landroid/net/Uri;)V
    //   222: aastore
    //   223: iinc 5 1
    //   226: goto -31 -> 195
    //   229: aload 6
    //   231: areturn
    //   232: aload 6
    //   234: invokestatic 146	androidx/documentfile/provider/TreeDocumentFile:closeQuietly	(Ljava/lang/AutoCloseable;)V
    //   237: aload_2
    //   238: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	239	0	this	TreeDocumentFile
    //   7	83	1	localObject1	Object
    //   119	30	1	localException	Exception
    //   12	79	2	localObject2	Object
    //   115	52	2	localObject3	Object
    //   187	51	2	arrayOfUri	Uri[]
    //   21	147	3	localObject4	Object
    //   29	145	4	localArrayList	java.util.ArrayList
    //   32	192	5	i	int
    //   37	196	6	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   39	57	115	finally
    //   64	73	115	finally
    //   78	86	115	finally
    //   91	105	115	finally
    //   123	127	115	finally
    //   130	134	115	finally
    //   137	144	115	finally
    //   147	153	115	finally
    //   156	166	115	finally
    //   39	57	119	java/lang/Exception
    //   64	73	119	java/lang/Exception
    //   78	86	119	java/lang/Exception
    //   91	105	119	java/lang/Exception
  }
  
  public boolean renameTo(String paramString)
  {
    try
    {
      paramString = DocumentsContract.renameDocument(this.mContext.getContentResolver(), this.mUri, paramString);
      if (paramString != null)
      {
        this.mUri = paramString;
        return true;
      }
    }
    catch (Exception paramString)
    {
      for (;;) {}
    }
    return false;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\documentfile\provider\TreeDocumentFile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */