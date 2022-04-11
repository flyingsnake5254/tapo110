package okhttp3.internal.publicsuffix;

import java.net.IDN;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.internal.Util;

public final class PublicSuffixDatabase
{
  private static final String[] EMPTY_RULE = new String[0];
  private static final byte EXCEPTION_MARKER = 33;
  private static final String[] PREVAILING_RULE = { "*" };
  public static final String PUBLIC_SUFFIX_RESOURCE = "publicsuffixes.gz";
  private static final byte[] WILDCARD_LABEL = { 42 };
  private static final PublicSuffixDatabase instance = new PublicSuffixDatabase();
  private final AtomicBoolean listRead = new AtomicBoolean(false);
  private byte[] publicSuffixExceptionListBytes;
  private byte[] publicSuffixListBytes;
  private final CountDownLatch readCompleteLatch = new CountDownLatch(1);
  
  private static String binarySearchBytes(byte[] paramArrayOfByte, byte[][] paramArrayOfByte1, int paramInt)
  {
    int i = paramArrayOfByte.length;
    int j = 0;
    if (j < i)
    {
      for (int k = (j + i) / 2; (k > -1) && (paramArrayOfByte[k] != 10); k--) {}
      int m = k + 1;
      int n;
      for (k = 1;; k++)
      {
        n = m + k;
        if (paramArrayOfByte[n] == 10) {
          break;
        }
      }
      int i1 = n - m;
      int i2 = paramInt;
      int i3 = 0;
      k = 0;
      int i4 = 0;
      label187:
      label288:
      label300:
      for (;;)
      {
        int i5;
        if (i3 != 0)
        {
          i5 = 46;
          i3 = 0;
        }
        else
        {
          i5 = paramArrayOfByte1[i2][k];
          i5 &= 0xFF;
        }
        i5 -= (paramArrayOfByte[(m + i4)] & 0xFF);
        if (i5 == 0)
        {
          i4++;
          k++;
          if (i4 != i1)
          {
            if (paramArrayOfByte1[i2].length != k) {
              break label300;
            }
            if (i2 != paramArrayOfByte1.length - 1) {
              break label288;
            }
          }
        }
        if (i5 < 0)
        {
          i = m - 1;
          break;
        }
        if (i5 > 0) {}
        do
        {
          j = n + 1;
          break;
          i3 = i1 - i4;
          k = paramArrayOfByte1[i2].length - k;
          for (;;)
          {
            i2++;
            if (i2 >= paramArrayOfByte1.length) {
              break;
            }
            k += paramArrayOfByte1[i2].length;
          }
          if (k < i3) {
            break label187;
          }
        } while (k > i3);
        return new String(paramArrayOfByte, m, i1, Util.UTF_8);
        i2++;
        i3 = 1;
        k = -1;
      }
    }
    paramArrayOfByte = null;
    return paramArrayOfByte;
  }
  
  private String[] findMatchingRule(String[] paramArrayOfString)
  {
    boolean bool = this.listRead.get();
    int i = 0;
    if ((!bool) && (this.listRead.compareAndSet(false, true))) {
      readTheListUninterruptibly();
    } else {
      try
      {
        this.readCompleteLatch.await();
      }
      catch (InterruptedException localInterruptedException)
      {
        Thread.currentThread().interrupt();
      }
    }
    try
    {
      if (this.publicSuffixListBytes != null)
      {
        int j = paramArrayOfString.length;
        byte[][] arrayOfByte = new byte[j][];
        for (int k = 0; k < paramArrayOfString.length; k++) {
          arrayOfByte[k] = paramArrayOfString[k].getBytes(Util.UTF_8);
        }
        Object localObject2;
        for (k = 0;; k++)
        {
          localObject2 = null;
          if (k >= j) {
            break;
          }
          paramArrayOfString = binarySearchBytes(this.publicSuffixListBytes, arrayOfByte, k);
          if (paramArrayOfString != null) {
            break label144;
          }
        }
        paramArrayOfString = null;
        label144:
        if (j > 1)
        {
          localObject3 = (byte[][])arrayOfByte.clone();
          for (k = 0; k < localObject3.length - 1; k++)
          {
            localObject3[k] = WILDCARD_LABEL;
            localObject1 = binarySearchBytes(this.publicSuffixListBytes, (byte[][])localObject3, k);
            if (localObject1 != null) {
              break label211;
            }
          }
        }
        Object localObject1 = null;
        label211:
        Object localObject3 = localObject2;
        if (localObject1 != null) {
          for (k = i;; k++)
          {
            localObject3 = localObject2;
            if (k >= j - 1) {
              break;
            }
            localObject3 = binarySearchBytes(this.publicSuffixExceptionListBytes, arrayOfByte, k);
            if (localObject3 != null) {
              break;
            }
          }
        }
        if (localObject3 != null)
        {
          paramArrayOfString = new StringBuilder();
          paramArrayOfString.append("!");
          paramArrayOfString.append((String)localObject3);
          return paramArrayOfString.toString().split("\\.");
        }
        if ((paramArrayOfString == null) && (localObject1 == null)) {
          return PREVAILING_RULE;
        }
        if (paramArrayOfString != null) {
          paramArrayOfString = paramArrayOfString.split("\\.");
        } else {
          paramArrayOfString = EMPTY_RULE;
        }
        if (localObject1 != null) {
          localObject1 = ((String)localObject1).split("\\.");
        } else {
          localObject1 = EMPTY_RULE;
        }
        if (paramArrayOfString.length <= localObject1.length) {
          paramArrayOfString = (String[])localObject1;
        }
        return paramArrayOfString;
      }
      paramArrayOfString = new java/lang/IllegalStateException;
      paramArrayOfString.<init>("Unable to load publicsuffixes.gz resource from the classpath.");
      throw paramArrayOfString;
    }
    finally {}
  }
  
  public static PublicSuffixDatabase get()
  {
    return instance;
  }
  
  /* Error */
  private void readTheList()
    throws java.io.IOException
  {
    // Byte code:
    //   0: ldc 2
    //   2: ldc 14
    //   4: invokevirtual 148	java/lang/Class:getResourceAsStream	(Ljava/lang/String;)Ljava/io/InputStream;
    //   7: astore_1
    //   8: aload_1
    //   9: ifnonnull +4 -> 13
    //   12: return
    //   13: new 150	okio/GzipSource
    //   16: dup
    //   17: aload_1
    //   18: invokestatic 156	okio/Okio:source	(Ljava/io/InputStream;)Lokio/Source;
    //   21: invokespecial 159	okio/GzipSource:<init>	(Lokio/Source;)V
    //   24: invokestatic 163	okio/Okio:buffer	(Lokio/Source;)Lokio/BufferedSource;
    //   27: astore_1
    //   28: aload_1
    //   29: invokeinterface 169 1 0
    //   34: newarray <illegal type>
    //   36: astore_2
    //   37: aload_1
    //   38: aload_2
    //   39: invokeinterface 173 2 0
    //   44: aload_1
    //   45: invokeinterface 169 1 0
    //   50: newarray <illegal type>
    //   52: astore_3
    //   53: aload_1
    //   54: aload_3
    //   55: invokeinterface 173 2 0
    //   60: aload_1
    //   61: invokestatic 177	okhttp3/internal/Util:closeQuietly	(Ljava/io/Closeable;)V
    //   64: aload_0
    //   65: monitorenter
    //   66: aload_0
    //   67: aload_2
    //   68: putfield 97	okhttp3/internal/publicsuffix/PublicSuffixDatabase:publicSuffixListBytes	[B
    //   71: aload_0
    //   72: aload_3
    //   73: putfield 112	okhttp3/internal/publicsuffix/PublicSuffixDatabase:publicSuffixExceptionListBytes	[B
    //   76: aload_0
    //   77: monitorexit
    //   78: aload_0
    //   79: getfield 57	okhttp3/internal/publicsuffix/PublicSuffixDatabase:readCompleteLatch	Ljava/util/concurrent/CountDownLatch;
    //   82: invokevirtual 180	java/util/concurrent/CountDownLatch:countDown	()V
    //   85: return
    //   86: astore_1
    //   87: aload_0
    //   88: monitorexit
    //   89: aload_1
    //   90: athrow
    //   91: astore_3
    //   92: aload_1
    //   93: invokestatic 177	okhttp3/internal/Util:closeQuietly	(Ljava/io/Closeable;)V
    //   96: aload_3
    //   97: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	98	0	this	PublicSuffixDatabase
    //   7	54	1	localObject1	Object
    //   86	7	1	localCloseable	java.io.Closeable
    //   36	32	2	arrayOfByte1	byte[]
    //   52	21	3	arrayOfByte2	byte[]
    //   91	6	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   66	78	86	finally
    //   87	89	86	finally
    //   28	60	91	finally
  }
  
  /* Error */
  private void readTheListUninterruptibly()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: invokespecial 185	okhttp3/internal/publicsuffix/PublicSuffixDatabase:readTheList	()V
    //   6: iload_1
    //   7: ifeq +9 -> 16
    //   10: invokestatic 92	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   13: invokevirtual 95	java/lang/Thread:interrupt	()V
    //   16: return
    //   17: astore_2
    //   18: goto +35 -> 53
    //   21: astore_2
    //   22: invokestatic 190	okhttp3/internal/platform/Platform:get	()Lokhttp3/internal/platform/Platform;
    //   25: iconst_5
    //   26: ldc -64
    //   28: aload_2
    //   29: invokevirtual 196	okhttp3/internal/platform/Platform:log	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   32: iload_1
    //   33: ifeq +9 -> 42
    //   36: invokestatic 92	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   39: invokevirtual 95	java/lang/Thread:interrupt	()V
    //   42: return
    //   43: astore_2
    //   44: invokestatic 199	java/lang/Thread:interrupted	()Z
    //   47: pop
    //   48: iconst_1
    //   49: istore_1
    //   50: goto -48 -> 2
    //   53: iload_1
    //   54: ifeq +9 -> 63
    //   57: invokestatic 92	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   60: invokevirtual 95	java/lang/Thread:interrupt	()V
    //   63: aload_2
    //   64: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	this	PublicSuffixDatabase
    //   1	53	1	i	int
    //   17	1	2	localObject	Object
    //   21	8	2	localIOException	java.io.IOException
    //   43	21	2	localInterruptedIOException	java.io.InterruptedIOException
    // Exception table:
    //   from	to	target	type
    //   2	6	17	finally
    //   22	32	17	finally
    //   44	48	17	finally
    //   2	6	21	java/io/IOException
    //   2	6	43	java/io/InterruptedIOException
  }
  
  public String getEffectiveTldPlusOne(String paramString)
  {
    Objects.requireNonNull(paramString, "domain == null");
    Object localObject = IDN.toUnicode(paramString).split("\\.");
    String[] arrayOfString = findMatchingRule((String[])localObject);
    if ((localObject.length == arrayOfString.length) && (arrayOfString[0].charAt(0) != '!')) {
      return null;
    }
    int i;
    int j;
    if (arrayOfString[0].charAt(0) == '!')
    {
      i = localObject.length;
      j = arrayOfString.length;
    }
    else
    {
      i = localObject.length;
      j = arrayOfString.length + 1;
    }
    i -= j;
    localObject = new StringBuilder();
    paramString = paramString.split("\\.");
    while (i < paramString.length)
    {
      ((StringBuilder)localObject).append(paramString[i]);
      ((StringBuilder)localObject).append('.');
      i++;
    }
    ((StringBuilder)localObject).deleteCharAt(((StringBuilder)localObject).length() - 1);
    return ((StringBuilder)localObject).toString();
  }
  
  void setListBytes(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    this.publicSuffixListBytes = paramArrayOfByte1;
    this.publicSuffixExceptionListBytes = paramArrayOfByte2;
    this.listRead.set(true);
    this.readCompleteLatch.countDown();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\okhttp3\internal\publicsuffix\PublicSuffixDatabase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */