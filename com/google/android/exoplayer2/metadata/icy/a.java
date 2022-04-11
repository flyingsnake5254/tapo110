package com.google.android.exoplayer2.metadata.icy;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.Metadata.Entry;
import com.google.android.exoplayer2.metadata.d;
import com.google.android.exoplayer2.metadata.g;
import com.google.common.base.c;
import com.google.common.base.e;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a
  extends g
{
  private static final Pattern a = Pattern.compile("(.+?)='(.*?)';", 32);
  private final CharsetDecoder b = e.c.newDecoder();
  private final CharsetDecoder c = e.b.newDecoder();
  
  /* Error */
  @androidx.annotation.Nullable
  private String c(ByteBuffer paramByteBuffer)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 38	com/google/android/exoplayer2/metadata/icy/a:b	Ljava/nio/charset/CharsetDecoder;
    //   4: aload_1
    //   5: invokevirtual 52	java/nio/charset/CharsetDecoder:decode	(Ljava/nio/ByteBuffer;)Ljava/nio/CharBuffer;
    //   8: invokevirtual 58	java/nio/CharBuffer:toString	()Ljava/lang/String;
    //   11: astore_2
    //   12: aload_0
    //   13: getfield 38	com/google/android/exoplayer2/metadata/icy/a:b	Ljava/nio/charset/CharsetDecoder;
    //   16: invokevirtual 61	java/nio/charset/CharsetDecoder:reset	()Ljava/nio/charset/CharsetDecoder;
    //   19: pop
    //   20: aload_1
    //   21: invokevirtual 67	java/nio/ByteBuffer:rewind	()Ljava/nio/Buffer;
    //   24: pop
    //   25: aload_2
    //   26: areturn
    //   27: astore_2
    //   28: aload_0
    //   29: getfield 38	com/google/android/exoplayer2/metadata/icy/a:b	Ljava/nio/charset/CharsetDecoder;
    //   32: invokevirtual 61	java/nio/charset/CharsetDecoder:reset	()Ljava/nio/charset/CharsetDecoder;
    //   35: pop
    //   36: aload_1
    //   37: invokevirtual 67	java/nio/ByteBuffer:rewind	()Ljava/nio/Buffer;
    //   40: pop
    //   41: aload_2
    //   42: athrow
    //   43: astore_2
    //   44: aload_0
    //   45: getfield 38	com/google/android/exoplayer2/metadata/icy/a:b	Ljava/nio/charset/CharsetDecoder;
    //   48: invokevirtual 61	java/nio/charset/CharsetDecoder:reset	()Ljava/nio/charset/CharsetDecoder;
    //   51: pop
    //   52: aload_1
    //   53: invokevirtual 67	java/nio/ByteBuffer:rewind	()Ljava/nio/Buffer;
    //   56: pop
    //   57: aload_0
    //   58: getfield 42	com/google/android/exoplayer2/metadata/icy/a:c	Ljava/nio/charset/CharsetDecoder;
    //   61: aload_1
    //   62: invokevirtual 52	java/nio/charset/CharsetDecoder:decode	(Ljava/nio/ByteBuffer;)Ljava/nio/CharBuffer;
    //   65: invokevirtual 58	java/nio/CharBuffer:toString	()Ljava/lang/String;
    //   68: astore_2
    //   69: aload_0
    //   70: getfield 42	com/google/android/exoplayer2/metadata/icy/a:c	Ljava/nio/charset/CharsetDecoder;
    //   73: invokevirtual 61	java/nio/charset/CharsetDecoder:reset	()Ljava/nio/charset/CharsetDecoder;
    //   76: pop
    //   77: aload_1
    //   78: invokevirtual 67	java/nio/ByteBuffer:rewind	()Ljava/nio/Buffer;
    //   81: pop
    //   82: aload_2
    //   83: areturn
    //   84: astore_2
    //   85: aload_0
    //   86: getfield 42	com/google/android/exoplayer2/metadata/icy/a:c	Ljava/nio/charset/CharsetDecoder;
    //   89: invokevirtual 61	java/nio/charset/CharsetDecoder:reset	()Ljava/nio/charset/CharsetDecoder;
    //   92: pop
    //   93: aload_1
    //   94: invokevirtual 67	java/nio/ByteBuffer:rewind	()Ljava/nio/Buffer;
    //   97: pop
    //   98: aload_2
    //   99: athrow
    //   100: astore_2
    //   101: aload_0
    //   102: getfield 42	com/google/android/exoplayer2/metadata/icy/a:c	Ljava/nio/charset/CharsetDecoder;
    //   105: invokevirtual 61	java/nio/charset/CharsetDecoder:reset	()Ljava/nio/charset/CharsetDecoder;
    //   108: pop
    //   109: aload_1
    //   110: invokevirtual 67	java/nio/ByteBuffer:rewind	()Ljava/nio/Buffer;
    //   113: pop
    //   114: aconst_null
    //   115: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	116	0	this	a
    //   0	116	1	paramByteBuffer	ByteBuffer
    //   11	15	2	str1	String
    //   27	15	2	localObject1	Object
    //   43	1	2	localCharacterCodingException1	java.nio.charset.CharacterCodingException
    //   68	15	2	str2	String
    //   84	15	2	localObject2	Object
    //   100	1	2	localCharacterCodingException2	java.nio.charset.CharacterCodingException
    // Exception table:
    //   from	to	target	type
    //   0	12	27	finally
    //   0	12	43	java/nio/charset/CharacterCodingException
    //   57	69	84	finally
    //   57	69	100	java/nio/charset/CharacterCodingException
  }
  
  protected Metadata b(d paramd, ByteBuffer paramByteBuffer)
  {
    paramd = c(paramByteBuffer);
    byte[] arrayOfByte = new byte[paramByteBuffer.limit()];
    paramByteBuffer.get(arrayOfByte);
    paramByteBuffer = null;
    if (paramd == null) {
      return new Metadata(new Metadata.Entry[] { new IcyInfo(arrayOfByte, null, null) });
    }
    Matcher localMatcher = a.matcher(paramd);
    paramd = null;
    int i = 0;
    while (localMatcher.find(i))
    {
      String str1 = localMatcher.group(1);
      String str2 = localMatcher.group(2);
      Object localObject1 = paramByteBuffer;
      Object localObject2 = paramd;
      if (str1 != null)
      {
        localObject2 = c.e(str1);
        ((String)localObject2).hashCode();
        if (!((String)localObject2).equals("streamurl"))
        {
          if (!((String)localObject2).equals("streamtitle"))
          {
            localObject1 = paramByteBuffer;
            localObject2 = paramd;
          }
          else
          {
            localObject1 = str2;
            localObject2 = paramd;
          }
        }
        else
        {
          localObject2 = str2;
          localObject1 = paramByteBuffer;
        }
      }
      i = localMatcher.end();
      paramByteBuffer = (ByteBuffer)localObject1;
      paramd = (d)localObject2;
    }
    return new Metadata(new Metadata.Entry[] { new IcyInfo(arrayOfByte, paramByteBuffer, paramd) });
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\metadata\icy\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */