package org.apache.commons.io.filefilter;

import java.io.Serializable;
import java.nio.charset.Charset;

public class MagicNumberFileFilter
  extends a
  implements Serializable
{
  private static final long serialVersionUID = -547733176983104172L;
  private final long byteOffset;
  private final byte[] magicNumbers;
  
  public MagicNumberFileFilter(String paramString)
  {
    this(paramString, 0L);
  }
  
  public MagicNumberFileFilter(String paramString, long paramLong)
  {
    if (paramString != null)
    {
      if (!paramString.isEmpty())
      {
        if (paramLong >= 0L)
        {
          this.magicNumbers = paramString.getBytes(Charset.defaultCharset());
          this.byteOffset = paramLong;
          return;
        }
        throw new IllegalArgumentException("The offset cannot be negative");
      }
      throw new IllegalArgumentException("The magic number must contain at least one byte");
    }
    throw new IllegalArgumentException("The magic number cannot be null");
  }
  
  public MagicNumberFileFilter(byte[] paramArrayOfByte)
  {
    this(paramArrayOfByte, 0L);
  }
  
  public MagicNumberFileFilter(byte[] paramArrayOfByte, long paramLong)
  {
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length != 0)
      {
        if (paramLong >= 0L)
        {
          byte[] arrayOfByte = new byte[paramArrayOfByte.length];
          this.magicNumbers = arrayOfByte;
          System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramArrayOfByte.length);
          this.byteOffset = paramLong;
          return;
        }
        throw new IllegalArgumentException("The offset cannot be negative");
      }
      throw new IllegalArgumentException("The magic number must contain at least one byte");
    }
    throw new IllegalArgumentException("The magic number cannot be null");
  }
  
  /* Error */
  public boolean accept(java.io.File paramFile)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +109 -> 110
    //   4: aload_1
    //   5: invokevirtual 71	java/io/File:isFile	()Z
    //   8: ifeq +102 -> 110
    //   11: aload_1
    //   12: invokevirtual 74	java/io/File:canRead	()Z
    //   15: ifeq +95 -> 110
    //   18: new 76	java/io/RandomAccessFile
    //   21: astore_2
    //   22: aload_2
    //   23: aload_1
    //   24: ldc 78
    //   26: invokespecial 81	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   29: aload_0
    //   30: getfield 40	org/apache/commons/io/filefilter/MagicNumberFileFilter:magicNumbers	[B
    //   33: arraylength
    //   34: newarray <illegal type>
    //   36: astore_1
    //   37: aload_2
    //   38: aload_0
    //   39: getfield 42	org/apache/commons/io/filefilter/MagicNumberFileFilter:byteOffset	J
    //   42: invokevirtual 85	java/io/RandomAccessFile:seek	(J)V
    //   45: aload_2
    //   46: aload_1
    //   47: invokevirtual 89	java/io/RandomAccessFile:read	([B)I
    //   50: istore_3
    //   51: aload_0
    //   52: getfield 40	org/apache/commons/io/filefilter/MagicNumberFileFilter:magicNumbers	[B
    //   55: astore 4
    //   57: aload 4
    //   59: arraylength
    //   60: istore 5
    //   62: iload_3
    //   63: iload 5
    //   65: if_icmpeq +9 -> 74
    //   68: aload_2
    //   69: invokevirtual 92	java/io/RandomAccessFile:close	()V
    //   72: iconst_0
    //   73: ireturn
    //   74: aload 4
    //   76: aload_1
    //   77: invokestatic 98	java/util/Arrays:equals	([B[B)Z
    //   80: istore 6
    //   82: aload_2
    //   83: invokevirtual 92	java/io/RandomAccessFile:close	()V
    //   86: iload 6
    //   88: ireturn
    //   89: astore_1
    //   90: aload_1
    //   91: athrow
    //   92: astore 4
    //   94: aload_2
    //   95: invokevirtual 92	java/io/RandomAccessFile:close	()V
    //   98: goto +9 -> 107
    //   101: astore_2
    //   102: aload_1
    //   103: aload_2
    //   104: invokevirtual 104	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   107: aload 4
    //   109: athrow
    //   110: iconst_0
    //   111: ireturn
    //   112: astore_1
    //   113: goto -3 -> 110
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	116	0	this	MagicNumberFileFilter
    //   0	116	1	paramFile	java.io.File
    //   21	74	2	localRandomAccessFile	java.io.RandomAccessFile
    //   101	3	2	localThrowable	Throwable
    //   50	16	3	i	int
    //   55	20	4	arrayOfByte	byte[]
    //   92	16	4	localObject	Object
    //   60	6	5	j	int
    //   80	7	6	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   29	62	89	finally
    //   74	82	89	finally
    //   90	92	92	finally
    //   94	98	101	finally
    //   18	29	112	java/io/IOException
    //   68	72	112	java/io/IOException
    //   82	86	112	java/io/IOException
    //   102	107	112	java/io/IOException
    //   107	110	112	java/io/IOException
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(super.toString());
    localStringBuilder.append("(");
    localStringBuilder.append(new String(this.magicNumbers, Charset.defaultCharset()));
    localStringBuilder.append(",");
    localStringBuilder.append(this.byteOffset);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\apache\commons\io\filefilter\MagicNumberFileFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */