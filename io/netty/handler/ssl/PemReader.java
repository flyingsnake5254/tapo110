package io.netty.handler.ssl;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.base64.Base64;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCounted;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.KeyException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class PemReader
{
  private static final Pattern CERT_PATTERN = Pattern.compile("-+BEGIN\\s+.*CERTIFICATE[^-]*-+(?:\\s|\\r|\\n)+([a-z0-9+/=\\r\\n]+)-+END\\s+.*CERTIFICATE[^-]*-+", 2);
  private static final Pattern KEY_PATTERN = Pattern.compile("-+BEGIN\\s+.*PRIVATE\\s+KEY[^-]*-+(?:\\s|\\r|\\n)+([a-z0-9+/=\\r\\n]+)-+END\\s+.*PRIVATE\\s+KEY[^-]*-+", 2);
  private static final InternalLogger logger = InternalLoggerFactory.getInstance(PemReader.class);
  
  /* Error */
  static ByteBuf[] readCertificates(java.io.File paramFile)
    throws java.security.cert.CertificateException
  {
    // Byte code:
    //   0: new 45	java/io/FileInputStream
    //   3: astore_1
    //   4: aload_1
    //   5: aload_0
    //   6: invokespecial 48	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   9: aload_1
    //   10: invokestatic 51	io/netty/handler/ssl/PemReader:readCertificates	(Ljava/io/InputStream;)[Lio/netty/buffer/ByteBuf;
    //   13: astore_2
    //   14: aload_1
    //   15: invokestatic 55	io/netty/handler/ssl/PemReader:safeClose	(Ljava/io/InputStream;)V
    //   18: aload_2
    //   19: areturn
    //   20: astore_2
    //   21: aload_1
    //   22: invokestatic 55	io/netty/handler/ssl/PemReader:safeClose	(Ljava/io/InputStream;)V
    //   25: aload_2
    //   26: athrow
    //   27: astore_1
    //   28: new 57	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   35: astore_1
    //   36: aload_1
    //   37: ldc 60
    //   39: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: pop
    //   43: aload_1
    //   44: aload_0
    //   45: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: new 41	java/security/cert/CertificateException
    //   52: dup
    //   53: aload_1
    //   54: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: invokespecial 74	java/security/cert/CertificateException:<init>	(Ljava/lang/String;)V
    //   60: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	61	0	paramFile	java.io.File
    //   3	19	1	localFileInputStream	java.io.FileInputStream
    //   27	1	1	localFileNotFoundException	java.io.FileNotFoundException
    //   35	19	1	localStringBuilder	StringBuilder
    //   13	6	2	arrayOfByteBuf	ByteBuf[]
    //   20	6	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   9	14	20	finally
    //   0	9	27	java/io/FileNotFoundException
    //   14	18	27	java/io/FileNotFoundException
    //   21	27	27	java/io/FileNotFoundException
  }
  
  /* Error */
  static ByteBuf[] readCertificates(InputStream paramInputStream)
    throws java.security.cert.CertificateException
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 81	io/netty/handler/ssl/PemReader:readContent	(Ljava/io/InputStream;)Ljava/lang/String;
    //   4: astore_1
    //   5: new 83	java/util/ArrayList
    //   8: dup
    //   9: invokespecial 84	java/util/ArrayList:<init>	()V
    //   12: astore_0
    //   13: getstatic 29	io/netty/handler/ssl/PemReader:CERT_PATTERN	Ljava/util/regex/Pattern;
    //   16: aload_1
    //   17: invokevirtual 88	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   20: astore_1
    //   21: iconst_0
    //   22: istore_2
    //   23: aload_1
    //   24: iload_2
    //   25: invokevirtual 94	java/util/regex/Matcher:find	(I)Z
    //   28: ifne +36 -> 64
    //   31: aload_0
    //   32: invokeinterface 100 1 0
    //   37: ifne +17 -> 54
    //   40: aload_0
    //   41: iconst_0
    //   42: anewarray 102	io/netty/buffer/ByteBuf
    //   45: invokeinterface 106 2 0
    //   50: checkcast 108	[Lio/netty/buffer/ByteBuf;
    //   53: areturn
    //   54: new 41	java/security/cert/CertificateException
    //   57: dup
    //   58: ldc 110
    //   60: invokespecial 74	java/security/cert/CertificateException:<init>	(Ljava/lang/String;)V
    //   63: athrow
    //   64: aload_1
    //   65: iconst_1
    //   66: invokevirtual 114	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   69: getstatic 120	io/netty/util/CharsetUtil:US_ASCII	Ljava/nio/charset/Charset;
    //   72: invokestatic 126	io/netty/buffer/Unpooled:copiedBuffer	(Ljava/lang/CharSequence;Ljava/nio/charset/Charset;)Lio/netty/buffer/ByteBuf;
    //   75: astore_3
    //   76: aload_3
    //   77: invokestatic 132	io/netty/handler/codec/base64/Base64:decode	(Lio/netty/buffer/ByteBuf;)Lio/netty/buffer/ByteBuf;
    //   80: astore 4
    //   82: aload_3
    //   83: invokeinterface 137 1 0
    //   88: pop
    //   89: aload_0
    //   90: aload 4
    //   92: invokeinterface 141 2 0
    //   97: pop
    //   98: aload_1
    //   99: invokevirtual 145	java/util/regex/Matcher:end	()I
    //   102: istore_2
    //   103: goto -80 -> 23
    //   106: astore_0
    //   107: new 41	java/security/cert/CertificateException
    //   110: dup
    //   111: ldc -109
    //   113: aload_0
    //   114: invokespecial 150	java/security/cert/CertificateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   117: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	118	0	paramInputStream	InputStream
    //   4	95	1	localObject	Object
    //   22	81	2	i	int
    //   75	8	3	localByteBuf1	ByteBuf
    //   80	11	4	localByteBuf2	ByteBuf
    // Exception table:
    //   from	to	target	type
    //   0	5	106	java/io/IOException
  }
  
  /* Error */
  private static String readContent(InputStream paramInputStream)
    throws IOException
  {
    // Byte code:
    //   0: new 152	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 153	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore_1
    //   8: sipush 8192
    //   11: newarray <illegal type>
    //   13: astore_2
    //   14: aload_0
    //   15: aload_2
    //   16: invokevirtual 159	java/io/InputStream:read	([B)I
    //   19: istore_3
    //   20: iload_3
    //   21: ifge +20 -> 41
    //   24: aload_1
    //   25: getstatic 120	io/netty/util/CharsetUtil:US_ASCII	Ljava/nio/charset/Charset;
    //   28: invokevirtual 164	java/nio/charset/Charset:name	()Ljava/lang/String;
    //   31: invokevirtual 167	java/io/ByteArrayOutputStream:toString	(Ljava/lang/String;)Ljava/lang/String;
    //   34: astore_0
    //   35: aload_1
    //   36: invokestatic 170	io/netty/handler/ssl/PemReader:safeClose	(Ljava/io/OutputStream;)V
    //   39: aload_0
    //   40: areturn
    //   41: aload_1
    //   42: aload_2
    //   43: iconst_0
    //   44: iload_3
    //   45: invokevirtual 174	java/io/ByteArrayOutputStream:write	([BII)V
    //   48: goto -34 -> 14
    //   51: astore_0
    //   52: aload_1
    //   53: invokestatic 170	io/netty/handler/ssl/PemReader:safeClose	(Ljava/io/OutputStream;)V
    //   56: aload_0
    //   57: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	58	0	paramInputStream	InputStream
    //   7	46	1	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   13	30	2	arrayOfByte	byte[]
    //   19	26	3	i	int
    // Exception table:
    //   from	to	target	type
    //   8	14	51	finally
    //   14	20	51	finally
    //   24	35	51	finally
    //   41	48	51	finally
  }
  
  /* Error */
  static ByteBuf readPrivateKey(java.io.File paramFile)
    throws KeyException
  {
    // Byte code:
    //   0: new 45	java/io/FileInputStream
    //   3: astore_1
    //   4: aload_1
    //   5: aload_0
    //   6: invokespecial 48	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   9: aload_1
    //   10: invokestatic 181	io/netty/handler/ssl/PemReader:readPrivateKey	(Ljava/io/InputStream;)Lio/netty/buffer/ByteBuf;
    //   13: astore_2
    //   14: aload_1
    //   15: invokestatic 55	io/netty/handler/ssl/PemReader:safeClose	(Ljava/io/InputStream;)V
    //   18: aload_2
    //   19: areturn
    //   20: astore_2
    //   21: aload_1
    //   22: invokestatic 55	io/netty/handler/ssl/PemReader:safeClose	(Ljava/io/InputStream;)V
    //   25: aload_2
    //   26: athrow
    //   27: astore_1
    //   28: new 57	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   35: astore_1
    //   36: aload_1
    //   37: ldc -73
    //   39: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: pop
    //   43: aload_1
    //   44: aload_0
    //   45: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: new 178	java/security/KeyException
    //   52: dup
    //   53: aload_1
    //   54: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: invokespecial 184	java/security/KeyException:<init>	(Ljava/lang/String;)V
    //   60: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	61	0	paramFile	java.io.File
    //   3	19	1	localFileInputStream	java.io.FileInputStream
    //   27	1	1	localFileNotFoundException	java.io.FileNotFoundException
    //   35	19	1	localStringBuilder	StringBuilder
    //   13	6	2	localByteBuf	ByteBuf
    //   20	6	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   9	14	20	finally
    //   0	9	27	java/io/FileNotFoundException
    //   14	18	27	java/io/FileNotFoundException
    //   21	27	27	java/io/FileNotFoundException
  }
  
  static ByteBuf readPrivateKey(InputStream paramInputStream)
    throws KeyException
  {
    try
    {
      paramInputStream = readContent(paramInputStream);
      paramInputStream = KEY_PATTERN.matcher(paramInputStream);
      if (paramInputStream.find())
      {
        ByteBuf localByteBuf = Unpooled.copiedBuffer(paramInputStream.group(1), CharsetUtil.US_ASCII);
        paramInputStream = Base64.decode(localByteBuf);
        localByteBuf.release();
        return paramInputStream;
      }
      throw new KeyException("could not find a PKCS #8 private key in input stream (see https://netty.io/wiki/sslcontextbuilder-and-private-key.html for more information)");
    }
    catch (IOException paramInputStream)
    {
      throw new KeyException("failed to read key input stream", paramInputStream);
    }
  }
  
  private static void safeClose(InputStream paramInputStream)
  {
    try
    {
      paramInputStream.close();
    }
    catch (IOException paramInputStream)
    {
      logger.warn("Failed to close a stream.", paramInputStream);
    }
  }
  
  private static void safeClose(OutputStream paramOutputStream)
  {
    try
    {
      paramOutputStream.close();
    }
    catch (IOException paramOutputStream)
    {
      logger.warn("Failed to close a stream.", paramOutputStream);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\ssl\PemReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */