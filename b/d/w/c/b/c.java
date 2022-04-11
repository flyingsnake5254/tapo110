package b.d.w.c.b;

import android.os.Handler;
import android.os.Looper;
import b.d.w.b.b;
import com.tplink.libtputility.security.a;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class c
  extends Handler
{
  private static final String a = System.getProperty("line.separator");
  private final File b;
  private final int c;
  private final long d;
  private final a e;
  private File f;
  private int g;
  
  public c(Looper paramLooper, String paramString, int paramInt, byte[] paramArrayOfByte, long paramLong)
  {
    super(paramLooper);
    paramLooper = new File(paramString);
    this.b = paramLooper;
    this.g = a(paramLooper);
    this.c = paramInt;
    this.d = paramLong;
    if (paramArrayOfByte != null) {
      this.e = new a(paramArrayOfByte, null, "AES");
    } else {
      this.e = null;
    }
  }
  
  private int a(File paramFile)
  {
    if (!paramFile.exists()) {
      paramFile.mkdirs();
    }
    if ((!paramFile.isFile()) && (paramFile.listFiles() != null)) {
      i = 0;
    } else {
      i = 1;
    }
    Object localObject = null;
    this.f = new File(paramFile, String.format(Locale.US, "logs_%04d.dat", new Object[] { Integer.valueOf(0) }));
    int j = 0;
    int k = i;
    File localFile;
    do
    {
      if ((!this.f.exists()) && (k != 0))
      {
        i = 0;
        break;
      }
      if (this.f.exists()) {
        k = 1;
      }
      localFile = this.f;
      i = j + 1;
      this.f = new File(paramFile, String.format(Locale.US, "logs_%04d.dat", new Object[] { Integer.valueOf(i) }));
      localObject = localFile;
      j = i;
    } while (i < 10000);
    k = 1;
    j = i;
    localObject = localFile;
    int i = k;
    k = j;
    if (localObject != null)
    {
      k = j;
      if (((File)localObject).length() >= this.c)
      {
        if (i != 0) {
          j = d();
        }
        this.f = new File(paramFile, String.format(Locale.US, "logs_%04d.dat", new Object[] { Integer.valueOf(j) }));
        k = j;
      }
    }
    return k;
  }
  
  private void b()
  {
    if (this.d <= 0L) {
      return;
    }
    if ((this.b.exists()) && (!this.b.isFile()) && (b.e(this.b) >= this.d))
    {
      List localList = b.f(this.b.listFiles());
      if (localList.size() > 0) {
        ((File)localList.get(0)).delete();
      }
    }
  }
  
  private File c()
  {
    if (this.f.length() >= this.c)
    {
      int i = this.g + 1;
      this.g = i;
      if (i >= 10000) {
        this.g = d();
      }
      this.f = new File(this.b, String.format(Locale.US, "logs_%04d.dat", new Object[] { Integer.valueOf(this.g) }));
    }
    return this.f;
  }
  
  private int d()
  {
    if ((this.b.exists()) && (!this.b.isFile()))
    {
      List localList = b.f(this.b.listFiles());
      if (localList.isEmpty()) {
        return 0;
      }
      if ("logs_0000.dat".equals(((File)localList.get(0)).getName())) {
        return 0;
      }
      Iterator localIterator = localList.iterator();
      for (int i = 0; localIterator.hasNext(); i++) {
        ((File)localIterator.next()).renameTo(new File(this.b, String.format(Locale.US, "logs_%04d.dat", new Object[] { Integer.valueOf(i) })));
      }
      return localList.size();
    }
    return 0;
  }
  
  /* Error */
  public void handleMessage(android.os.Message paramMessage)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 168	android/os/Message:obj	Ljava/lang/Object;
    //   4: checkcast 91	java/lang/String
    //   7: astore_2
    //   8: aload_0
    //   9: invokespecial 170	b/d/w/c/b/c:b	()V
    //   12: aload_0
    //   13: invokespecial 172	b/d/w/c/b/c:c	()Ljava/io/File;
    //   16: astore_1
    //   17: new 174	java/io/FileWriter
    //   20: astore_3
    //   21: aload_3
    //   22: aload_1
    //   23: iconst_1
    //   24: invokespecial 177	java/io/FileWriter:<init>	(Ljava/io/File;Z)V
    //   27: aload_0
    //   28: getfield 59	b/d/w/c/b/c:e	Lcom/tplink/libtputility/security/a;
    //   31: astore 4
    //   33: aload_2
    //   34: astore_1
    //   35: aload 4
    //   37: ifnull +16 -> 53
    //   40: aload 4
    //   42: aload_2
    //   43: invokevirtual 181	java/lang/String:getBytes	()[B
    //   46: invokevirtual 184	com/tplink/libtputility/security/a:d	([B)[B
    //   49: invokestatic 190	b/d/w/h/a:l	([B)Ljava/lang/String;
    //   52: astore_1
    //   53: aload_3
    //   54: aload_1
    //   55: invokevirtual 194	java/io/FileWriter:append	(Ljava/lang/CharSequence;)Ljava/io/Writer;
    //   58: pop
    //   59: aload_3
    //   60: getstatic 28	b/d/w/c/b/c:a	Ljava/lang/String;
    //   63: invokevirtual 194	java/io/FileWriter:append	(Ljava/lang/CharSequence;)Ljava/io/Writer;
    //   66: pop
    //   67: aload_3
    //   68: invokevirtual 197	java/io/FileWriter:flush	()V
    //   71: aload_3
    //   72: invokevirtual 200	java/io/FileWriter:close	()V
    //   75: goto +22 -> 97
    //   78: astore_1
    //   79: aload_1
    //   80: athrow
    //   81: astore_2
    //   82: aload_3
    //   83: invokevirtual 200	java/io/FileWriter:close	()V
    //   86: goto +9 -> 95
    //   89: astore_3
    //   90: aload_1
    //   91: aload_3
    //   92: invokevirtual 206	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   95: aload_2
    //   96: athrow
    //   97: return
    //   98: astore_1
    //   99: goto -2 -> 97
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	this	c
    //   0	102	1	paramMessage	android.os.Message
    //   7	36	2	str	String
    //   81	15	2	localObject	Object
    //   20	63	3	localFileWriter	java.io.FileWriter
    //   89	3	3	localThrowable	Throwable
    //   31	10	4	locala	a
    // Exception table:
    //   from	to	target	type
    //   27	33	78	finally
    //   40	53	78	finally
    //   53	71	78	finally
    //   79	81	81	finally
    //   82	86	89	finally
    //   17	27	98	java/lang/Exception
    //   71	75	98	java/lang/Exception
    //   90	95	98	java/lang/Exception
    //   95	97	98	java/lang/Exception
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\w\c\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */