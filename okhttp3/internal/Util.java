package okhttp3.internal;

import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.IDN;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.Headers;
import okhttp3.Headers.Builder;
import okhttp3.HttpUrl;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.internal.http2.Header;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Source;

public final class Util
{
  public static final byte[] EMPTY_BYTE_ARRAY;
  public static final RequestBody EMPTY_REQUEST;
  public static final ResponseBody EMPTY_RESPONSE;
  public static final String[] EMPTY_STRING_ARRAY;
  public static final Charset ISO_8859_1;
  public static final Comparator<String> NATURAL_ORDER;
  public static final TimeZone UTC;
  private static final Charset UTF_16_BE;
  private static final ByteString UTF_16_BE_BOM;
  private static final Charset UTF_16_LE;
  private static final ByteString UTF_16_LE_BOM;
  private static final Charset UTF_32_BE;
  private static final ByteString UTF_32_BE_BOM;
  private static final Charset UTF_32_LE;
  private static final ByteString UTF_32_LE_BOM;
  public static final Charset UTF_8;
  private static final ByteString UTF_8_BOM;
  private static final Pattern VERIFY_AS_IP_ADDRESS = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
  private static final Method addSuppressedExceptionMethod;
  
  static
  {
    Object localObject1 = new byte[0];
    EMPTY_BYTE_ARRAY = (byte[])localObject1;
    EMPTY_STRING_ARRAY = new String[0];
    Object localObject2 = null;
    EMPTY_RESPONSE = ResponseBody.create(null, (byte[])localObject1);
    EMPTY_REQUEST = RequestBody.create(null, (byte[])localObject1);
    UTF_8_BOM = ByteString.decodeHex("efbbbf");
    UTF_16_BE_BOM = ByteString.decodeHex("feff");
    UTF_16_LE_BOM = ByteString.decodeHex("fffe");
    UTF_32_BE_BOM = ByteString.decodeHex("0000ffff");
    UTF_32_LE_BOM = ByteString.decodeHex("ffff0000");
    UTF_8 = Charset.forName("UTF-8");
    ISO_8859_1 = Charset.forName("ISO-8859-1");
    UTF_16_BE = Charset.forName("UTF-16BE");
    UTF_16_LE = Charset.forName("UTF-16LE");
    UTF_32_BE = Charset.forName("UTF-32BE");
    UTF_32_LE = Charset.forName("UTF-32LE");
    UTC = TimeZone.getTimeZone("GMT");
    NATURAL_ORDER = new Comparator()
    {
      public int compare(String paramAnonymousString1, String paramAnonymousString2)
      {
        return paramAnonymousString1.compareTo(paramAnonymousString2);
      }
    };
    try
    {
      localObject1 = Throwable.class.getDeclaredMethod("addSuppressed", new Class[] { Throwable.class });
      localObject2 = localObject1;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    addSuppressedExceptionMethod = (Method)localObject2;
  }
  
  public static void addSuppressedIfPossible(Throwable paramThrowable1, Throwable paramThrowable2)
  {
    Method localMethod = addSuppressedExceptionMethod;
    if (localMethod != null) {}
    try
    {
      localMethod.invoke(paramThrowable1, new Object[] { paramThrowable2 });
      return;
    }
    catch (InvocationTargetException|IllegalAccessException paramThrowable1)
    {
      for (;;) {}
    }
  }
  
  public static AssertionError assertionError(String paramString, Exception paramException)
  {
    paramString = new AssertionError(paramString);
    try
    {
      paramString.initCause(paramException);
      return paramString;
    }
    catch (IllegalStateException paramException)
    {
      for (;;) {}
    }
  }
  
  public static Charset bomAwareCharset(BufferedSource paramBufferedSource, Charset paramCharset)
    throws IOException
  {
    ByteString localByteString = UTF_8_BOM;
    if (paramBufferedSource.rangeEquals(0L, localByteString))
    {
      paramBufferedSource.skip(localByteString.size());
      return UTF_8;
    }
    localByteString = UTF_16_BE_BOM;
    if (paramBufferedSource.rangeEquals(0L, localByteString))
    {
      paramBufferedSource.skip(localByteString.size());
      return UTF_16_BE;
    }
    localByteString = UTF_16_LE_BOM;
    if (paramBufferedSource.rangeEquals(0L, localByteString))
    {
      paramBufferedSource.skip(localByteString.size());
      return UTF_16_LE;
    }
    localByteString = UTF_32_BE_BOM;
    if (paramBufferedSource.rangeEquals(0L, localByteString))
    {
      paramBufferedSource.skip(localByteString.size());
      return UTF_32_BE;
    }
    localByteString = UTF_32_LE_BOM;
    if (paramBufferedSource.rangeEquals(0L, localByteString))
    {
      paramBufferedSource.skip(localByteString.size());
      return UTF_32_LE;
    }
    return paramCharset;
  }
  
  public static String canonicalizeHost(String paramString)
  {
    if (paramString.contains(":"))
    {
      if ((paramString.startsWith("[")) && (paramString.endsWith("]"))) {
        localObject = decodeIpv6(paramString, 1, paramString.length() - 1);
      } else {
        localObject = decodeIpv6(paramString, 0, paramString.length());
      }
      if (localObject == null) {
        return null;
      }
      Object localObject = ((InetAddress)localObject).getAddress();
      if (localObject.length == 16) {
        return inet6AddressToAscii((byte[])localObject);
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Invalid IPv6 address: '");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("'");
      throw new AssertionError(((StringBuilder)localObject).toString());
    }
    try
    {
      paramString = IDN.toASCII(paramString).toLowerCase(Locale.US);
      if (paramString.isEmpty()) {
        return null;
      }
      boolean bool = containsInvalidHostnameAsciiCodes(paramString);
      if (bool) {
        return null;
      }
      return paramString;
    }
    catch (IllegalArgumentException paramString) {}
    return null;
  }
  
  public static int checkDuration(String paramString, long paramLong, TimeUnit paramTimeUnit)
  {
    boolean bool = paramLong < 0L;
    if (!bool)
    {
      Objects.requireNonNull(paramTimeUnit, "unit == null");
      paramLong = paramTimeUnit.toMillis(paramLong);
      if (paramLong <= 2147483647L)
      {
        if ((paramLong == 0L) && (bool))
        {
          paramTimeUnit = new StringBuilder();
          paramTimeUnit.append(paramString);
          paramTimeUnit.append(" too small.");
          throw new IllegalArgumentException(paramTimeUnit.toString());
        }
        return (int)paramLong;
      }
      paramTimeUnit = new StringBuilder();
      paramTimeUnit.append(paramString);
      paramTimeUnit.append(" too large.");
      throw new IllegalArgumentException(paramTimeUnit.toString());
    }
    paramTimeUnit = new StringBuilder();
    paramTimeUnit.append(paramString);
    paramTimeUnit.append(" < 0");
    throw new IllegalArgumentException(paramTimeUnit.toString());
  }
  
  public static void checkOffsetAndCount(long paramLong1, long paramLong2, long paramLong3)
  {
    if (((paramLong2 | paramLong3) >= 0L) && (paramLong2 <= paramLong1) && (paramLong1 - paramLong2 >= paramLong3)) {
      return;
    }
    throw new ArrayIndexOutOfBoundsException();
  }
  
  public static void closeQuietly(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      try
      {
        paramCloseable.close();
      }
      catch (RuntimeException paramCloseable)
      {
        throw paramCloseable;
      }
      return;
    }
    catch (Exception paramCloseable)
    {
      for (;;) {}
    }
  }
  
  public static void closeQuietly(ServerSocket paramServerSocket)
  {
    if (paramServerSocket != null) {}
    try
    {
      try
      {
        paramServerSocket.close();
      }
      catch (RuntimeException paramServerSocket)
      {
        throw paramServerSocket;
      }
      return;
    }
    catch (Exception paramServerSocket)
    {
      for (;;) {}
    }
  }
  
  public static void closeQuietly(Socket paramSocket)
  {
    if (paramSocket != null) {}
    try
    {
      try
      {
        paramSocket.close();
      }
      catch (RuntimeException paramSocket)
      {
        if ("bio == null".equals(paramSocket.getMessage())) {
          return;
        }
        throw paramSocket;
      }
      catch (AssertionError paramSocket)
      {
        if (!isAndroidGetsocknameError(paramSocket)) {
          throw paramSocket;
        }
      }
      return;
    }
    catch (Exception paramSocket)
    {
      for (;;) {}
    }
  }
  
  public static String[] concat(String[] paramArrayOfString, String paramString)
  {
    int i = paramArrayOfString.length + 1;
    String[] arrayOfString = new String[i];
    System.arraycopy(paramArrayOfString, 0, arrayOfString, 0, paramArrayOfString.length);
    arrayOfString[(i - 1)] = paramString;
    return arrayOfString;
  }
  
  private static boolean containsInvalidHostnameAsciiCodes(String paramString)
  {
    int i = 0;
    while (i < paramString.length())
    {
      int j = paramString.charAt(i);
      if ((j > 31) && (j < 127))
      {
        if (" #%/:?@[\\]".indexOf(j) != -1) {
          return true;
        }
        i++;
      }
      else
      {
        return true;
      }
    }
    return false;
  }
  
  public static int decodeHexDigit(char paramChar)
  {
    if ((paramChar >= '0') && (paramChar <= '9')) {
      return paramChar - '0';
    }
    char c = 'a';
    if ((paramChar >= 'a') && (paramChar <= 'f')) {}
    do
    {
      return paramChar - c + 10;
      c = 'A';
    } while ((paramChar >= 'A') && (paramChar <= 'F'));
    return -1;
  }
  
  private static boolean decodeIpv4Suffix(String paramString, int paramInt1, int paramInt2, byte[] paramArrayOfByte, int paramInt3)
  {
    int i = paramInt3;
    int j = paramInt1;
    while (j < paramInt2)
    {
      if (i == paramArrayOfByte.length) {
        return false;
      }
      paramInt1 = j;
      if (i != paramInt3)
      {
        if (paramString.charAt(j) != '.') {
          return false;
        }
        paramInt1 = j + 1;
      }
      j = paramInt1;
      int k = 0;
      while (j < paramInt2)
      {
        int m = paramString.charAt(j);
        if ((m < 48) || (m > 57)) {
          break;
        }
        if ((k == 0) && (paramInt1 != j)) {
          return false;
        }
        k = k * 10 + m - 48;
        if (k > 255) {
          return false;
        }
        j++;
      }
      if (j - paramInt1 == 0) {
        return false;
      }
      paramArrayOfByte[i] = ((byte)(byte)k);
      i++;
    }
    return i == paramInt3 + 4;
  }
  
  @Nullable
  private static InetAddress decodeIpv6(String paramString, int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte = new byte[16];
    int i = 0;
    int j = -1;
    int k = -1;
    int m;
    int n;
    for (;;)
    {
      m = i;
      n = j;
      if (paramInt1 >= paramInt2) {
        break label299;
      }
      if (i == 16) {
        return null;
      }
      n = paramInt1 + 2;
      if ((n <= paramInt2) && (paramString.regionMatches(paramInt1, "::", 0, 2)))
      {
        if (j != -1) {
          return null;
        }
        m = i + 2;
        paramInt1 = m;
        if (n == paramInt2)
        {
          n = paramInt1;
          break label299;
        }
        k = n;
        i = m;
        j = paramInt1;
        paramInt1 = k;
      }
      else
      {
        m = paramInt1;
        if (i != 0) {
          if (paramString.regionMatches(paramInt1, ":", 0, 1))
          {
            m = paramInt1 + 1;
          }
          else
          {
            if (paramString.regionMatches(paramInt1, ".", 0, 1))
            {
              if (!decodeIpv4Suffix(paramString, k, paramInt2, arrayOfByte, i - 2)) {
                return null;
              }
              m = i + 2;
              n = j;
              break label299;
            }
            return null;
          }
        }
        paramInt1 = m;
      }
      m = paramInt1;
      k = 0;
      while (m < paramInt2)
      {
        n = decodeHexDigit(paramString.charAt(m));
        if (n == -1) {
          break;
        }
        k = (k << 4) + n;
        m++;
      }
      n = m - paramInt1;
      if ((n == 0) || (n > 4)) {
        break;
      }
      n = i + 1;
      arrayOfByte[i] = ((byte)(byte)(k >>> 8 & 0xFF));
      i = n + 1;
      arrayOfByte[n] = ((byte)(byte)(k & 0xFF));
      k = paramInt1;
      paramInt1 = m;
    }
    return null;
    label299:
    if (m != 16)
    {
      if (n == -1) {
        return null;
      }
      paramInt1 = m - n;
      System.arraycopy(arrayOfByte, n, arrayOfByte, 16 - paramInt1, paramInt1);
      Arrays.fill(arrayOfByte, n, 16 - m + n, (byte)0);
    }
    try
    {
      paramString = InetAddress.getByAddress(arrayOfByte);
      return paramString;
    }
    catch (UnknownHostException paramString)
    {
      throw new AssertionError();
    }
  }
  
  public static int delimiterOffset(String paramString, int paramInt1, int paramInt2, char paramChar)
  {
    while (paramInt1 < paramInt2)
    {
      if (paramString.charAt(paramInt1) == paramChar) {
        return paramInt1;
      }
      paramInt1++;
    }
    return paramInt2;
  }
  
  public static int delimiterOffset(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    while (paramInt1 < paramInt2)
    {
      if (paramString2.indexOf(paramString1.charAt(paramInt1)) != -1) {
        return paramInt1;
      }
      paramInt1++;
    }
    return paramInt2;
  }
  
  public static boolean discard(Source paramSource, int paramInt, TimeUnit paramTimeUnit)
  {
    try
    {
      boolean bool = skipAll(paramSource, paramInt, paramTimeUnit);
      return bool;
    }
    catch (IOException paramSource) {}
    return false;
  }
  
  public static boolean equal(Object paramObject1, Object paramObject2)
  {
    boolean bool;
    if ((paramObject1 != paramObject2) && ((paramObject1 == null) || (!paramObject1.equals(paramObject2)))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public static String format(String paramString, Object... paramVarArgs)
  {
    return String.format(Locale.US, paramString, paramVarArgs);
  }
  
  public static String hostHeader(HttpUrl paramHttpUrl, boolean paramBoolean)
  {
    Object localObject1;
    if (paramHttpUrl.host().contains(":"))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[");
      ((StringBuilder)localObject1).append(paramHttpUrl.host());
      ((StringBuilder)localObject1).append("]");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    else
    {
      localObject1 = paramHttpUrl.host();
    }
    Object localObject2;
    if (!paramBoolean)
    {
      localObject2 = localObject1;
      if (paramHttpUrl.port() == HttpUrl.defaultPort(paramHttpUrl.scheme())) {}
    }
    else
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(":");
      ((StringBuilder)localObject2).append(paramHttpUrl.port());
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    return (String)localObject2;
  }
  
  public static <T> List<T> immutableList(List<T> paramList)
  {
    return Collections.unmodifiableList(new ArrayList(paramList));
  }
  
  public static <T> List<T> immutableList(T... paramVarArgs)
  {
    return Collections.unmodifiableList(Arrays.asList((Object[])paramVarArgs.clone()));
  }
  
  public static <K, V> Map<K, V> immutableMap(Map<K, V> paramMap)
  {
    if (paramMap.isEmpty()) {
      paramMap = Collections.emptyMap();
    } else {
      paramMap = Collections.unmodifiableMap(new LinkedHashMap(paramMap));
    }
    return paramMap;
  }
  
  public static int indexOf(Comparator<String> paramComparator, String[] paramArrayOfString, String paramString)
  {
    int i = paramArrayOfString.length;
    for (int j = 0; j < i; j++) {
      if (paramComparator.compare(paramArrayOfString[j], paramString) == 0) {
        return j;
      }
    }
    return -1;
  }
  
  public static int indexOfControlOrNonAscii(String paramString)
  {
    int i = paramString.length();
    int j = 0;
    while (j < i)
    {
      int k = paramString.charAt(j);
      if ((k > 31) && (k < 127)) {
        j++;
      } else {
        return j;
      }
    }
    return -1;
  }
  
  private static String inet6AddressToAscii(byte[] paramArrayOfByte)
  {
    int i = 0;
    int j = -1;
    int k = 0;
    int n;
    int i3;
    for (int m = 0; k < paramArrayOfByte.length; m = i3)
    {
      for (n = k; (n < 16) && (paramArrayOfByte[n] == 0) && (paramArrayOfByte[(n + 1)] == 0); n += 2) {}
      int i1 = n - k;
      int i2 = j;
      i3 = m;
      if (i1 > m)
      {
        i2 = j;
        i3 = m;
        if (i1 >= 4)
        {
          i3 = i1;
          i2 = k;
        }
      }
      k = n + 2;
      j = i2;
    }
    Buffer localBuffer = new Buffer();
    k = i;
    while (k < paramArrayOfByte.length) {
      if (k == j)
      {
        localBuffer.writeByte(58);
        n = k + m;
        k = n;
        if (n == 16)
        {
          localBuffer.writeByte(58);
          k = n;
        }
      }
      else
      {
        if (k > 0) {
          localBuffer.writeByte(58);
        }
        localBuffer.writeHexadecimalUnsignedLong((paramArrayOfByte[k] & 0xFF) << 8 | paramArrayOfByte[(k + 1)] & 0xFF);
        k += 2;
      }
    }
    return localBuffer.readUtf8();
  }
  
  public static String[] intersect(Comparator<? super String> paramComparator, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    ArrayList localArrayList = new ArrayList();
    int i = paramArrayOfString1.length;
    for (int j = 0; j < i; j++)
    {
      String str = paramArrayOfString1[j];
      int k = paramArrayOfString2.length;
      for (int m = 0; m < k; m++) {
        if (paramComparator.compare(str, paramArrayOfString2[m]) == 0)
        {
          localArrayList.add(str);
          break;
        }
      }
    }
    return (String[])localArrayList.toArray(new String[localArrayList.size()]);
  }
  
  public static boolean isAndroidGetsocknameError(AssertionError paramAssertionError)
  {
    boolean bool;
    if ((paramAssertionError.getCause() != null) && (paramAssertionError.getMessage() != null) && (paramAssertionError.getMessage().contains("getsockname failed"))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static boolean nonEmptyIntersection(Comparator<String> paramComparator, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    if ((paramArrayOfString1 != null) && (paramArrayOfString2 != null) && (paramArrayOfString1.length != 0) && (paramArrayOfString2.length != 0))
    {
      int i = paramArrayOfString1.length;
      for (int j = 0; j < i; j++)
      {
        String str = paramArrayOfString1[j];
        int k = paramArrayOfString2.length;
        for (int m = 0; m < k; m++) {
          if (paramComparator.compare(str, paramArrayOfString2[m]) == 0) {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  public static X509TrustManager platformTrustManager()
  {
    try
    {
      Object localObject = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
      ((TrustManagerFactory)localObject).init(null);
      localObject = ((TrustManagerFactory)localObject).getTrustManagers();
      if ((localObject.length == 1) && ((localObject[0] instanceof X509TrustManager))) {
        return (X509TrustManager)localObject[0];
      }
      IllegalStateException localIllegalStateException = new java/lang/IllegalStateException;
      StringBuilder localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>();
      localStringBuilder.append("Unexpected default trust managers:");
      localStringBuilder.append(Arrays.toString((Object[])localObject));
      localIllegalStateException.<init>(localStringBuilder.toString());
      throw localIllegalStateException;
    }
    catch (GeneralSecurityException localGeneralSecurityException)
    {
      throw assertionError("No System TLS", localGeneralSecurityException);
    }
  }
  
  /* Error */
  public static boolean skipAll(Source paramSource, int paramInt, TimeUnit paramTimeUnit)
    throws IOException
  {
    // Byte code:
    //   0: invokestatic 554	java/lang/System:nanoTime	()J
    //   3: lstore_3
    //   4: aload_0
    //   5: invokeinterface 560 1 0
    //   10: invokevirtual 565	okio/Timeout:hasDeadline	()Z
    //   13: ifeq +19 -> 32
    //   16: aload_0
    //   17: invokeinterface 560 1 0
    //   22: invokevirtual 568	okio/Timeout:deadlineNanoTime	()J
    //   25: lload_3
    //   26: lsub
    //   27: lstore 5
    //   29: goto +8 -> 37
    //   32: ldc2_w 569
    //   35: lstore 5
    //   37: aload_0
    //   38: invokeinterface 560 1 0
    //   43: lload 5
    //   45: aload_2
    //   46: iload_1
    //   47: i2l
    //   48: invokevirtual 573	java/util/concurrent/TimeUnit:toNanos	(J)J
    //   51: invokestatic 579	java/lang/Math:min	(JJ)J
    //   54: lload_3
    //   55: ladd
    //   56: invokevirtual 582	okio/Timeout:deadlineNanoTime	(J)Lokio/Timeout;
    //   59: pop
    //   60: new 478	okio/Buffer
    //   63: astore_2
    //   64: aload_2
    //   65: invokespecial 479	okio/Buffer:<init>	()V
    //   68: aload_0
    //   69: aload_2
    //   70: ldc2_w 583
    //   73: invokeinterface 588 4 0
    //   78: ldc2_w 589
    //   81: lcmp
    //   82: ifeq +10 -> 92
    //   85: aload_2
    //   86: invokevirtual 593	okio/Buffer:clear	()V
    //   89: goto -21 -> 68
    //   92: lload 5
    //   94: ldc2_w 569
    //   97: lcmp
    //   98: ifne +16 -> 114
    //   101: aload_0
    //   102: invokeinterface 560 1 0
    //   107: invokevirtual 596	okio/Timeout:clearDeadline	()Lokio/Timeout;
    //   110: pop
    //   111: goto +17 -> 128
    //   114: aload_0
    //   115: invokeinterface 560 1 0
    //   120: lload_3
    //   121: lload 5
    //   123: ladd
    //   124: invokevirtual 582	okio/Timeout:deadlineNanoTime	(J)Lokio/Timeout;
    //   127: pop
    //   128: iconst_1
    //   129: ireturn
    //   130: astore_2
    //   131: lload 5
    //   133: ldc2_w 569
    //   136: lcmp
    //   137: ifne +16 -> 153
    //   140: aload_0
    //   141: invokeinterface 560 1 0
    //   146: invokevirtual 596	okio/Timeout:clearDeadline	()Lokio/Timeout;
    //   149: pop
    //   150: goto +17 -> 167
    //   153: aload_0
    //   154: invokeinterface 560 1 0
    //   159: lload_3
    //   160: lload 5
    //   162: ladd
    //   163: invokevirtual 582	okio/Timeout:deadlineNanoTime	(J)Lokio/Timeout;
    //   166: pop
    //   167: aload_2
    //   168: athrow
    //   169: astore_2
    //   170: lload 5
    //   172: ldc2_w 569
    //   175: lcmp
    //   176: ifne +16 -> 192
    //   179: aload_0
    //   180: invokeinterface 560 1 0
    //   185: invokevirtual 596	okio/Timeout:clearDeadline	()Lokio/Timeout;
    //   188: pop
    //   189: goto +17 -> 206
    //   192: aload_0
    //   193: invokeinterface 560 1 0
    //   198: lload_3
    //   199: lload 5
    //   201: ladd
    //   202: invokevirtual 582	okio/Timeout:deadlineNanoTime	(J)Lokio/Timeout;
    //   205: pop
    //   206: iconst_0
    //   207: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	208	0	paramSource	Source
    //   0	208	1	paramInt	int
    //   0	208	2	paramTimeUnit	TimeUnit
    //   3	196	3	l1	long
    //   27	173	5	l2	long
    // Exception table:
    //   from	to	target	type
    //   60	68	130	finally
    //   68	89	130	finally
    //   60	68	169	java/io/InterruptedIOException
    //   68	89	169	java/io/InterruptedIOException
  }
  
  public static int skipLeadingAsciiWhitespace(String paramString, int paramInt1, int paramInt2)
  {
    while (paramInt1 < paramInt2)
    {
      int i = paramString.charAt(paramInt1);
      if ((i != 9) && (i != 10) && (i != 12) && (i != 13) && (i != 32)) {
        return paramInt1;
      }
      paramInt1++;
    }
    return paramInt2;
  }
  
  public static int skipTrailingAsciiWhitespace(String paramString, int paramInt1, int paramInt2)
  {
    
    while (paramInt2 >= paramInt1)
    {
      int i = paramString.charAt(paramInt2);
      if ((i != 9) && (i != 10) && (i != 12) && (i != 13) && (i != 32)) {
        return paramInt2 + 1;
      }
      paramInt2--;
    }
    return paramInt1;
  }
  
  public static ThreadFactory threadFactory(String paramString, final boolean paramBoolean)
  {
    new ThreadFactory()
    {
      public Thread newThread(Runnable paramAnonymousRunnable)
      {
        paramAnonymousRunnable = new Thread(paramAnonymousRunnable, Util.this);
        paramAnonymousRunnable.setDaemon(paramBoolean);
        return paramAnonymousRunnable;
      }
    };
  }
  
  public static Headers toHeaders(List<Header> paramList)
  {
    Headers.Builder localBuilder = new Headers.Builder();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Header localHeader = (Header)paramList.next();
      Internal.instance.addLenient(localBuilder, localHeader.name.utf8(), localHeader.value.utf8());
    }
    return localBuilder.build();
  }
  
  public static String trimSubstring(String paramString, int paramInt1, int paramInt2)
  {
    paramInt1 = skipLeadingAsciiWhitespace(paramString, paramInt1, paramInt2);
    return paramString.substring(paramInt1, skipTrailingAsciiWhitespace(paramString, paramInt1, paramInt2));
  }
  
  public static boolean verifyAsIpAddress(String paramString)
  {
    return VERIFY_AS_IP_ADDRESS.matcher(paramString).matches();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\okhttp3\internal\Util.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */