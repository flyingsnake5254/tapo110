package io.netty.handler.ssl;

import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class CipherSuiteConverter
{
  private static final Pattern JAVA_AES_CBC_PATTERN;
  private static final Pattern JAVA_AES_PATTERN;
  private static final Pattern JAVA_CIPHERSUITE_PATTERN;
  private static final Pattern OPENSSL_AES_CBC_PATTERN;
  private static final Pattern OPENSSL_AES_PATTERN;
  private static final Pattern OPENSSL_CIPHERSUITE_PATTERN;
  private static final ConcurrentMap<String, String> j2o;
  private static final Map<String, String> j2oTls13;
  private static final InternalLogger logger = InternalLoggerFactory.getInstance(CipherSuiteConverter.class);
  private static final ConcurrentMap<String, Map<String, String>> o2j;
  private static final Map<String, Map<String, String>> o2jTls13;
  
  static
  {
    JAVA_CIPHERSUITE_PATTERN = Pattern.compile("^(?:TLS|SSL)_((?:(?!_WITH_).)+)_WITH_(.*)_(.*)$");
    OPENSSL_CIPHERSUITE_PATTERN = Pattern.compile("^(?:((?:(?:EXP-)?(?:(?:DHE|EDH|ECDH|ECDHE|SRP|RSA)-(?:DSS|RSA|ECDSA|PSK)|(?:ADH|AECDH|KRB5|PSK|SRP)))|EXP)-)?(.*)-(.*)$");
    JAVA_AES_CBC_PATTERN = Pattern.compile("^(AES)_([0-9]+)_CBC$");
    JAVA_AES_PATTERN = Pattern.compile("^(AES)_([0-9]+)_(.*)$");
    OPENSSL_AES_CBC_PATTERN = Pattern.compile("^(AES)([0-9]+)$");
    OPENSSL_AES_PATTERN = Pattern.compile("^(AES)([0-9]+)-(.*)$");
    j2o = PlatformDependent.newConcurrentHashMap();
    o2j = PlatformDependent.newConcurrentHashMap();
    HashMap localHashMap = new HashMap();
    localHashMap.put("TLS_AES_128_GCM_SHA256", "AEAD-AES128-GCM-SHA256");
    localHashMap.put("TLS_AES_256_GCM_SHA384", "AEAD-AES256-GCM-SHA384");
    localHashMap.put("TLS_CHACHA20_POLY1305_SHA256", "AEAD-CHACHA20-POLY1305-SHA256");
    j2oTls13 = Collections.unmodifiableMap(localHashMap);
    localHashMap = new HashMap();
    localHashMap.put("TLS_AES_128_GCM_SHA256", Collections.singletonMap("TLS", "TLS_AES_128_GCM_SHA256"));
    localHashMap.put("TLS_AES_256_GCM_SHA384", Collections.singletonMap("TLS", "TLS_AES_256_GCM_SHA384"));
    localHashMap.put("TLS_CHACHA20_POLY1305_SHA256", Collections.singletonMap("TLS", "TLS_CHACHA20_POLY1305_SHA256"));
    localHashMap.put("AEAD-AES128-GCM-SHA256", Collections.singletonMap("TLS", "TLS_AES_128_GCM_SHA256"));
    localHashMap.put("AEAD-AES256-GCM-SHA384", Collections.singletonMap("TLS", "TLS_AES_256_GCM_SHA384"));
    localHashMap.put("AEAD-CHACHA20-POLY1305-SHA256", Collections.singletonMap("TLS", "TLS_CHACHA20_POLY1305_SHA256"));
    o2jTls13 = Collections.unmodifiableMap(localHashMap);
  }
  
  private static String cacheFromJava(String paramString, boolean paramBoolean)
  {
    Object localObject = (String)j2oTls13.get(paramString);
    if (localObject != null)
    {
      if (paramBoolean) {
        paramString = (String)localObject;
      }
      return paramString;
    }
    String str1 = toOpenSslUncached(paramString, paramBoolean);
    if (str1 == null) {
      return null;
    }
    j2o.putIfAbsent(paramString, str1);
    String str2 = paramString.substring(4);
    localObject = new HashMap(4);
    ((Map)localObject).put("", str2);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SSL_");
    localStringBuilder.append(str2);
    ((Map)localObject).put("SSL", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("TLS_");
    localStringBuilder.append(str2);
    ((Map)localObject).put("TLS", localStringBuilder.toString());
    o2j.put(str1, localObject);
    logger.debug("Cipher suite mapping: {} => {}", paramString, str1);
    return str1;
  }
  
  private static Map<String, String> cacheFromOpenSsl(String paramString)
  {
    Object localObject1 = (Map)o2jTls13.get(paramString);
    if (localObject1 != null) {
      return (Map<String, String>)localObject1;
    }
    Object localObject2 = toJavaUncached0(paramString, false);
    if (localObject2 == null) {
      return null;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("SSL_");
    ((StringBuilder)localObject1).append((String)localObject2);
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("TLS_");
    ((StringBuilder)localObject3).append((String)localObject2);
    localObject3 = ((StringBuilder)localObject3).toString();
    HashMap localHashMap = new HashMap(4);
    localHashMap.put("", localObject2);
    localHashMap.put("SSL", localObject1);
    localHashMap.put("TLS", localObject3);
    o2j.putIfAbsent(paramString, localHashMap);
    localObject2 = j2o;
    ((ConcurrentMap)localObject2).putIfAbsent(localObject3, paramString);
    ((ConcurrentMap)localObject2).putIfAbsent(localObject1, paramString);
    localObject2 = logger;
    ((InternalLogger)localObject2).debug("Cipher suite mapping: {} => {}", localObject3, paramString);
    ((InternalLogger)localObject2).debug("Cipher suite mapping: {} => {}", localObject1, paramString);
    return localHashMap;
  }
  
  static void clearCache()
  {
    j2o.clear();
    o2j.clear();
  }
  
  static void convertToCipherStrings(Iterable<String> paramIterable, StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2, boolean paramBoolean)
  {
    Iterator localIterator = paramIterable.iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      if (str1 != null)
      {
        String str2 = toOpenSsl(str1, paramBoolean);
        paramIterable = str2;
        if (str2 == null) {
          paramIterable = str1;
        }
        if (OpenSsl.isCipherSuiteAvailable(paramIterable))
        {
          if ((!SslUtils.isTLSv13Cipher(paramIterable)) && (!SslUtils.isTLSv13Cipher(str1)))
          {
            paramStringBuilder1.append(paramIterable);
            paramStringBuilder1.append(':');
          }
          else
          {
            paramStringBuilder2.append(paramIterable);
            paramStringBuilder2.append(':');
          }
        }
        else
        {
          paramStringBuilder1 = new StringBuilder();
          paramStringBuilder1.append("unsupported cipher suite: ");
          paramStringBuilder1.append(str1);
          paramStringBuilder1.append('(');
          paramStringBuilder1.append(paramIterable);
          paramStringBuilder1.append(')');
          throw new IllegalArgumentException(paramStringBuilder1.toString());
        }
      }
    }
    if ((paramStringBuilder1.length() == 0) && (paramStringBuilder2.length() == 0)) {
      throw new IllegalArgumentException("empty cipher suites");
    }
    if (paramStringBuilder1.length() > 0) {
      paramStringBuilder1.setLength(paramStringBuilder1.length() - 1);
    }
    if (paramStringBuilder2.length() > 0) {
      paramStringBuilder2.setLength(paramStringBuilder2.length() - 1);
    }
  }
  
  static boolean isJ2OCached(String paramString1, String paramString2)
  {
    return paramString2.equals(j2o.get(paramString1));
  }
  
  static boolean isO2JCached(String paramString1, String paramString2, String paramString3)
  {
    paramString1 = (Map)o2j.get(paramString1);
    if (paramString1 == null) {
      return false;
    }
    return paramString3.equals(paramString1.get(paramString2));
  }
  
  static String toJava(String paramString1, String paramString2)
  {
    Object localObject1 = (Map)o2j.get(paramString1);
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      paramString1 = cacheFromOpenSsl(paramString1);
      localObject2 = paramString1;
      if (paramString1 == null) {
        return null;
      }
    }
    localObject1 = (String)((Map)localObject2).get(paramString2);
    paramString1 = (String)localObject1;
    if (localObject1 == null)
    {
      paramString1 = (String)((Map)localObject2).get("");
      if (paramString1 == null) {
        return null;
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramString2);
      ((StringBuilder)localObject2).append('_');
      ((StringBuilder)localObject2).append(paramString1);
      paramString1 = ((StringBuilder)localObject2).toString();
    }
    return paramString1;
  }
  
  private static String toJavaBulkCipher(String paramString, boolean paramBoolean)
  {
    if (paramString.startsWith("AES"))
    {
      Matcher localMatcher = OPENSSL_AES_CBC_PATTERN.matcher(paramString);
      if (localMatcher.matches()) {
        return localMatcher.replaceFirst("$1_$2_CBC");
      }
      localMatcher = OPENSSL_AES_PATTERN.matcher(paramString);
      if (localMatcher.matches()) {
        return localMatcher.replaceFirst("$1_$2_$3");
      }
    }
    if ("DES-CBC3".equals(paramString)) {
      return "3DES_EDE_CBC";
    }
    if ("RC4".equals(paramString))
    {
      if (paramBoolean) {
        return "RC4_40";
      }
      return "RC4_128";
    }
    if ("DES-CBC".equals(paramString))
    {
      if (paramBoolean) {
        return "DES_CBC_40";
      }
      return "DES_CBC";
    }
    if ("RC2-CBC".equals(paramString))
    {
      if (paramBoolean) {
        return "RC2_CBC_40";
      }
      return "RC2_CBC";
    }
    return paramString.replace('-', '_');
  }
  
  private static String toJavaHandshakeAlgo(String paramString, boolean paramBoolean)
  {
    if (paramString.isEmpty())
    {
      str = "RSA";
    }
    else if ("ADH".equals(paramString))
    {
      str = "DH_anon";
    }
    else
    {
      str = paramString;
      if ("AECDH".equals(paramString)) {
        str = "ECDH_anon";
      }
    }
    String str = str.replace('-', '_');
    paramString = str;
    if (paramBoolean)
    {
      paramString = new StringBuilder();
      paramString.append(str);
      paramString.append("_EXPORT");
      paramString = paramString.toString();
    }
    return paramString;
  }
  
  private static String toJavaHmacAlgo(String paramString)
  {
    return paramString;
  }
  
  static String toJavaUncached(String paramString)
  {
    return toJavaUncached0(paramString, true);
  }
  
  private static String toJavaUncached0(String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localObject1 = (Map)o2jTls13.get(paramString);
      if (localObject1 != null) {
        return (String)((Map)localObject1).get("TLS");
      }
    }
    Object localObject2 = OPENSSL_CIPHERSUITE_PATTERN.matcher(paramString);
    if (!((Matcher)localObject2).matches()) {
      return null;
    }
    paramBoolean = true;
    Object localObject1 = ((Matcher)localObject2).group(1);
    if (localObject1 == null) {
      paramString = "";
    }
    do
    {
      paramBoolean = false;
      break;
      if (((String)localObject1).startsWith("EXP-"))
      {
        paramString = ((String)localObject1).substring(4);
        break;
      }
      paramString = (String)localObject1;
    } while (!"EXP".equals(localObject1));
    paramString = "";
    paramString = toJavaHandshakeAlgo(paramString, paramBoolean);
    String str = toJavaBulkCipher(((Matcher)localObject2).group(2), paramBoolean);
    localObject1 = toJavaHmacAlgo(((Matcher)localObject2).group(3));
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramString);
    ((StringBuilder)localObject2).append("_WITH_");
    ((StringBuilder)localObject2).append(str);
    ((StringBuilder)localObject2).append('_');
    ((StringBuilder)localObject2).append((String)localObject1);
    localObject1 = ((StringBuilder)localObject2).toString();
    paramString = (String)localObject1;
    if (str.contains("CHACHA20"))
    {
      paramString = new StringBuilder();
      paramString.append((String)localObject1);
      paramString.append("_SHA256");
      paramString = paramString.toString();
    }
    return paramString;
  }
  
  static String toOpenSsl(String paramString, boolean paramBoolean)
  {
    String str = (String)j2o.get(paramString);
    if (str != null) {
      return str;
    }
    return cacheFromJava(paramString, paramBoolean);
  }
  
  private static String toOpenSslBulkCipher(String paramString)
  {
    if (paramString.startsWith("AES_"))
    {
      Matcher localMatcher = JAVA_AES_CBC_PATTERN.matcher(paramString);
      if (localMatcher.matches()) {
        return localMatcher.replaceFirst("$1$2");
      }
      localMatcher = JAVA_AES_PATTERN.matcher(paramString);
      if (localMatcher.matches()) {
        return localMatcher.replaceFirst("$1$2-$3");
      }
    }
    if ("3DES_EDE_CBC".equals(paramString)) {
      return "DES-CBC3";
    }
    if ((!"RC4_128".equals(paramString)) && (!"RC4_40".equals(paramString)))
    {
      if ((!"DES40_CBC".equals(paramString)) && (!"DES_CBC_40".equals(paramString)))
      {
        if ("RC2_CBC_40".equals(paramString)) {
          return "RC2-CBC";
        }
        return paramString.replace('_', '-');
      }
      return "DES-CBC";
    }
    return "RC4";
  }
  
  private static String toOpenSslHandshakeAlgo(String paramString)
  {
    boolean bool = paramString.endsWith("_EXPORT");
    Object localObject = paramString;
    if (bool) {
      localObject = paramString.substring(0, paramString.length() - 7);
    }
    if ("RSA".equals(localObject))
    {
      paramString = "";
    }
    else
    {
      paramString = (String)localObject;
      if (((String)localObject).endsWith("_anon"))
      {
        paramString = new StringBuilder();
        paramString.append('A');
        paramString.append(((String)localObject).substring(0, ((String)localObject).length() - 5));
        paramString = paramString.toString();
      }
    }
    localObject = paramString;
    if (bool) {
      if (paramString.isEmpty())
      {
        localObject = "EXP";
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("EXP-");
        ((StringBuilder)localObject).append(paramString);
        localObject = ((StringBuilder)localObject).toString();
      }
    }
    return ((String)localObject).replace('_', '-');
  }
  
  private static String toOpenSslHmacAlgo(String paramString)
  {
    return paramString;
  }
  
  static String toOpenSslUncached(String paramString, boolean paramBoolean)
  {
    Object localObject1 = (String)j2oTls13.get(paramString);
    if (localObject1 != null)
    {
      if (paramBoolean) {
        paramString = (String)localObject1;
      }
      return paramString;
    }
    Object localObject2 = JAVA_CIPHERSUITE_PATTERN.matcher(paramString);
    if (!((Matcher)localObject2).matches()) {
      return null;
    }
    localObject1 = toOpenSslHandshakeAlgo(((Matcher)localObject2).group(1));
    paramString = toOpenSslBulkCipher(((Matcher)localObject2).group(2));
    localObject2 = toOpenSslHmacAlgo(((Matcher)localObject2).group(3));
    if (((String)localObject1).isEmpty())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append('-');
      ((StringBuilder)localObject1).append((String)localObject2);
      return ((StringBuilder)localObject1).toString();
    }
    if (paramString.contains("CHACHA20"))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append('-');
      ((StringBuilder)localObject2).append(paramString);
      return ((StringBuilder)localObject2).toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append('-');
    localStringBuilder.append(paramString);
    localStringBuilder.append('-');
    localStringBuilder.append((String)localObject2);
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\ssl\CipherSuiteConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */