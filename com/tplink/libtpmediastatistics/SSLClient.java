package com.tplink.libtpmediastatistics;

import android.text.TextUtils;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import javax.security.auth.x500.X500Principal;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.tls.OkHostnameVerifier;

public class SSLClient
{
  public static final String ACCEPT = "Accept";
  public static final String ACCEPT_CHARSET = "Accept-Charset";
  public static final String ACCEPT_ENCODING = "Accept-Encoding";
  public static final String ACCEPT_LANGUAGE = "Accept-Language";
  public static final String ACCEPT_RANGES = "Accept-Ranges";
  public static final String AUTHORIZATION = "Authorization";
  public static final String CACHE_CONTROL = "Cache-Control";
  public static final String CHUNKED = "chunked";
  public static final String COLON = ":";
  public static final String COMMA = ",";
  public static final String CONNECTION = "Connection";
  public static final String CONTENT_LENGTH = "Content-Length";
  public static final String CONTENT_M5 = "Content-MD5";
  public static final String CONTENT_RANGE = "Content-Range";
  public static final String CONTENT_TYPE = "Content-Type";
  public static final String CONTENT_TYPE_APPLICATION_JSON = "application/json; charset=utf-8";
  public static final String COOKIE = "Cookie";
  public static final String DOUBLE_QUOTATION = "\"";
  public static final String EQUALS = "=";
  public static final String ESCAPE = "\\";
  public static final String FROM = "From";
  public static final String HTTPS_PREFIX = "https://";
  public static final String HTTP_GET = "GET";
  public static final String HTTP_HOST = "Host";
  public static final String HTTP_POST = "POST";
  public static final String HTTP_PREFIX = "http://";
  public static final String HTTP_PUT = "PUT";
  public static final String HTTP_VERSION_1_1 = "HTTP/1.1";
  public static final String KEEP_ALIVE = "keep-alive";
  public static final String KEEP_RELAY = "Keep-Relay";
  public static final String KEY_EXCHANGE = "Key-Exchange";
  public static final String LOCATION = "Location";
  public static final String NEW_LINE = "\r\n";
  public static final String PRAGMA = "Pragma";
  public static final String RANGE = "Range";
  public static final int READ_BUFFER_SIZE = 524288;
  public static final int READ_SNAP_BUFFER_SIZE = 1024;
  public static final String REFERER = "Referer";
  public static final String SERVER_NAME = "/stat";
  public static final String THE_END = "\r\n\r\n";
  public static final String TRANSFER_ENCODING = "Transfer-Encoding";
  public static final String USER_AGENT = "User-Agent";
  public static final String WHITE_SPACE = " ";
  public static final int WRITE_STRING_BUFFER_SIZE = 1024;
  public static final String WWW_AUTHENTICATE = "WWW-Authenticate";
  public static final String X_AUTHORIZATION = "X-Authorization";
  public static final String X_CLIENT_ID = "X-Client-Id";
  public static final String X_CLIENT_MODEL = "X-Client-Model";
  public static final String X_CLIENT_SESSION_ID = "X-Client-SessionID";
  public static final String X_CLIENT_UUID = "X-Client-UUID";
  public static final String X_DATA_RECEIVED = "X-Data-Received";
  public static final String X_DATA_SEQUENCE = "X-Data-Sequence";
  public static final String X_DATA_WINDOW_SIZE = "X-Data-Window-Size";
  public static final String X_DEBUG_INFO = "X-Debug-Info";
  public static final String X_IF_ENCRYPT = "X-If-Encrypt";
  public static final String X_NEED_RESPONSE = "X-Need-Response";
  public static final String X_SESSION_ID = "X-Session-Id";
  public static final String X_TOKEN = "X-Token";
  private String clientType;
  private Map<String, String> contentHeaders;
  private String host;
  private InputStream inputStream;
  private String loginToken;
  private String method;
  private BufferedOutputStream outputStream;
  private int port;
  private byte[] readBuffer;
  private StringBuilder requestBuffer;
  public int respondCode;
  private byte[] respondRawBuffer;
  private int respondRawLength;
  private SSLSocket sslSocket = (SSLSocket)createSocketFactory().createSocket();
  
  public SSLClient(String paramString, int paramInt)
    throws IOException
  {
    this.host = paramString;
    this.port = paramInt;
    this.requestBuffer = new StringBuilder();
    this.contentHeaders = new HashMap();
    this.method = "POST";
    this.readBuffer = new byte['Ѐ'];
    this.respondRawBuffer = new byte[524288];
    this.respondRawLength = 0;
  }
  
  private void addProperty(Map<String, String> paramMap)
  {
    this.requestBuffer.append(getPropertyContent(paramMap));
  }
  
  private void addRequestContent(String paramString)
  {
    this.requestBuffer.append(paramString);
  }
  
  private AssertionError assertionError(String paramString, Exception paramException)
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
  
  private Map<String, String> getContentHeaders()
    throws IOException
  {
    HashMap localHashMap = new HashMap();
    if ((!this.sslSocket.isClosed()) && (!this.sslSocket.isInputShutdown()) && (this.inputStream != null))
    {
      DataInputStream localDataInputStream = new DataInputStream(this.inputStream);
      for (;;)
      {
        Object localObject = localDataInputStream.readLine();
        if (("".equals(localObject)) || (localObject == null)) {
          break;
        }
        localObject = ((String)localObject).split(":", 2);
        if (localObject.length >= 2) {
          localHashMap.put(localObject[0].trim(), localObject[1].trim());
        }
      }
    }
    return localHashMap;
  }
  
  private int getHexValue(String paramString)
  {
    int i;
    try
    {
      i = Integer.valueOf(paramString, 16).intValue();
    }
    catch (Exception paramString)
    {
      i = 0;
    }
    return i;
  }
  
  private int getIntegerValue(String paramString)
  {
    int i;
    try
    {
      i = Integer.parseInt(paramString.trim());
    }
    catch (Exception paramString)
    {
      i = 0;
    }
    return i;
  }
  
  private String getPropertyContent(Map<String, String> paramMap)
  {
    if ((paramMap != null) && (!paramMap.isEmpty()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        String str2 = (String)paramMap.get(str1);
        if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)))
        {
          localStringBuilder.append(str1);
          localStringBuilder.append(":");
          localStringBuilder.append(" ");
          localStringBuilder.append(str2);
          localStringBuilder.append("\r\n");
        }
      }
      return localStringBuilder.toString();
    }
    return "";
  }
  
  private int handleMessageTitle(String paramString)
  {
    paramString = paramString.split(" ", 3);
    if ((paramString != null) && (paramString.length >= 2)) {
      return getIntegerValue(paramString[1]);
    }
    return -1;
  }
  
  private KeyStore newEmptyKeyStore(char[] paramArrayOfChar)
    throws GeneralSecurityException
  {
    try
    {
      KeyStore localKeyStore = KeyStore.getInstance(KeyStore.getDefaultType());
      localKeyStore.load(null, paramArrayOfChar);
      return localKeyStore;
    }
    catch (IOException paramArrayOfChar)
    {
      throw new AssertionError(paramArrayOfChar);
    }
  }
  
  private int parseRespondCode()
    throws IOException
  {
    return parseRespondCode(readTitleLine());
  }
  
  private int parseRespondCode(String paramString)
    throws IOException
  {
    if (paramString == null) {
      return 0;
    }
    if (paramString.equals("")) {
      return 0;
    }
    return handleMessageTitle(paramString);
  }
  
  private String parseStreamRequestTitle(String paramString, int paramInt)
  {
    return this.method.concat(" /stat HTTP/1.1\r\n").concat("Host: ").concat(paramString).concat(":").concat(String.valueOf(paramInt)).concat("\r\n");
  }
  
  private void preparePayload(String paramString)
    throws IOException
  {
    Object localObject = new LinkedHashMap();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("P2P-Midware/");
    localStringBuilder.append(this.clientType);
    ((Map)localObject).put("User-Agent", localStringBuilder.toString());
    ((Map)localObject).put("Connection", "keep-alive");
    ((Map)localObject).put("Content-Type", "application/json; charset=utf-8");
    ((Map)localObject).put("X-Token", this.loginToken);
    byte[] arrayOfByte = paramString.getBytes("UTF-8");
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(String.valueOf(arrayOfByte.length));
    ((Map)localObject).put("Content-Length", localStringBuilder.toString());
    addRequestContent(parseStreamRequestTitle(this.host, this.port));
    addProperty((Map)localObject);
    this.requestBuffer.append("\r\n");
    localObject = this.requestBuffer;
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("\r\n");
  }
  
  private void readContentRawData(int paramInt)
    throws IOException
  {
    if (paramInt <= 524288)
    {
      localObject = this.sslSocket;
      if ((localObject != null) && (!((SSLSocket)localObject).isClosed()) && (!this.sslSocket.isInputShutdown()) && (this.inputStream != null))
      {
        localObject = new DataInputStream(this.inputStream);
        this.respondRawLength = 0;
        int i = paramInt;
        if (paramInt <= 1024) {}
        for (;;)
        {
          i = paramInt;
          do
          {
            int j = 1024;
            paramInt = i;
            i = j;
            if (paramInt <= 0) {
              break;
            }
            i = ((DataInputStream)localObject).read(this.readBuffer, 0, i);
            if (i < 0) {
              break;
            }
            System.arraycopy(this.readBuffer, 0, this.respondRawBuffer, this.respondRawLength, i);
            this.respondRawLength += i;
            paramInt -= i;
            i = paramInt;
          } while (paramInt > 1024);
        }
      }
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("respondRawBuffer length is not enough, contentLength: ");
    ((StringBuilder)localObject).append(paramInt);
    throw new IOException(((StringBuilder)localObject).toString());
  }
  
  private String readTitleLine()
    throws IOException
  {
    SSLSocket localSSLSocket = this.sslSocket;
    if ((localSSLSocket != null) && (!localSSLSocket.isClosed()) && (!this.sslSocket.isInputShutdown()) && (this.inputStream != null)) {
      return new DataInputStream(this.inputStream).readLine();
    }
    return "";
  }
  
  private void request(String paramString)
    throws IOException
  {
    SSLSocket localSSLSocket = this.sslSocket;
    if ((localSSLSocket != null) && (this.outputStream != null) && (!localSSLSocket.isInputShutdown()) && (!this.sslSocket.isClosed()))
    {
      this.outputStream.write(paramString.getBytes());
      this.outputStream.flush();
    }
  }
  
  private SSLSocketFactory systemDefaultSslSocketFactory(X509TrustManager paramX509TrustManager)
  {
    try
    {
      SSLContext localSSLContext = Platform.get().getSSLContext();
      localSSLContext.init(null, new TrustManager[] { paramX509TrustManager }, null);
      paramX509TrustManager = localSSLContext.getSocketFactory();
      return paramX509TrustManager;
    }
    catch (GeneralSecurityException paramX509TrustManager)
    {
      throw assertionError("No System TLS", paramX509TrustManager);
    }
  }
  
  private X509TrustManager systemDefaultTrustManager()
  {
    try
    {
      Object localObject = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
      ((TrustManagerFactory)localObject).init(null);
      TrustManager[] arrayOfTrustManager = ((TrustManagerFactory)localObject).getTrustManagers();
      if ((arrayOfTrustManager.length == 1) && ((arrayOfTrustManager[0] instanceof X509TrustManager))) {
        return (X509TrustManager)arrayOfTrustManager[0];
      }
      localObject = new java/lang/IllegalStateException;
      StringBuilder localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>();
      localStringBuilder.append("Unexpected default trust managers:");
      localStringBuilder.append(Arrays.toString(arrayOfTrustManager));
      ((IllegalStateException)localObject).<init>(localStringBuilder.toString());
      throw ((Throwable)localObject);
    }
    catch (GeneralSecurityException localGeneralSecurityException)
    {
      throw assertionError("No System TLS", localGeneralSecurityException);
    }
  }
  
  private X509TrustManager trustManagerForCertificates(InputStream... paramVarArgs)
    throws GeneralSecurityException
  {
    CertificateFactory localCertificateFactory = CertificateFactory.getInstance("X.509");
    char[] arrayOfChar = "password".toCharArray();
    Object localObject1 = newEmptyKeyStore(arrayOfChar);
    int i = paramVarArgs.length;
    int j = 0;
    while (j < i)
    {
      InputStream localInputStream = paramVarArgs[j];
      Object localObject2 = localCertificateFactory.generateCertificates(localInputStream);
      if (!((Collection)localObject2).isEmpty())
      {
        localObject2 = ((Collection)localObject2).iterator();
        for (int k = 0; ((Iterator)localObject2).hasNext(); k++)
        {
          Certificate localCertificate = (Certificate)((Iterator)localObject2).next();
          ((KeyStore)localObject1).setCertificateEntry(Integer.toString(k), localCertificate);
        }
        if (localInputStream != null) {
          try
          {
            localInputStream.close();
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
          }
        }
        j++;
      }
      else
      {
        throw new IllegalArgumentException("expected non-empty set of trusted certificates");
      }
    }
    KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm()).init((KeyStore)localObject1, arrayOfChar);
    paramVarArgs = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
    paramVarArgs.init((KeyStore)localObject1);
    localObject1 = paramVarArgs.getTrustManagers();
    if ((localObject1.length == 1) && ((localObject1[0] instanceof X509TrustManager))) {
      return (X509TrustManager)localObject1[0];
    }
    paramVarArgs = new StringBuilder();
    paramVarArgs.append("Unexpected default trust managers:");
    paramVarArgs.append(Arrays.toString((Object[])localObject1));
    throw new IllegalStateException(paramVarArgs.toString());
  }
  
  public SSLClient connect()
    throws IOException
  {
    SSLSocket localSSLSocket = this.sslSocket;
    if (localSSLSocket == null) {
      return this;
    }
    if (!localSSLSocket.isConnected())
    {
      this.sslSocket.connect(new InetSocketAddress(this.host, this.port), 15000);
      this.sslSocket.setSoTimeout(15000);
    }
    if ((this.outputStream == null) && (!this.sslSocket.isOutputShutdown())) {
      this.outputStream = new BufferedOutputStream(this.sslSocket.getOutputStream());
    }
    if ((this.inputStream == null) && (!this.sslSocket.isInputShutdown())) {
      this.inputStream = this.sslSocket.getInputStream();
    }
    return this;
  }
  
  public SSLSocketFactory createSocketFactory()
  {
    return defaultCertificates();
  }
  
  public SSLSocketFactory defaultCertificates()
  {
    return systemDefaultSslSocketFactory(systemDefaultTrustManager());
  }
  
  public HostnameVerifier defaultHostnameVerifier()
  {
    return OkHostnameVerifier.INSTANCE;
  }
  
  public void disconnect()
  {
    BufferedOutputStream localBufferedOutputStream = this.outputStream;
    if (localBufferedOutputStream != null) {
      try
      {
        localBufferedOutputStream.close();
        this.outputStream = null;
      }
      catch (IOException localIOException1)
      {
        localIOException1.printStackTrace();
      }
    }
    InputStream localInputStream = this.inputStream;
    if (localInputStream != null) {
      try
      {
        localInputStream.close();
        this.inputStream = null;
      }
      catch (IOException localIOException2)
      {
        localIOException2.printStackTrace();
      }
    }
    SSLSocket localSSLSocket = this.sslSocket;
    if (localSSLSocket != null) {
      try
      {
        localSSLSocket.close();
        this.sslSocket = null;
      }
      catch (IOException localIOException3)
      {
        localIOException3.printStackTrace();
      }
    }
  }
  
  public byte[] getRaw()
  {
    int i = this.respondRawLength;
    byte[] arrayOfByte = new byte[i];
    System.arraycopy(this.respondRawBuffer, 0, arrayOfByte, 0, i);
    this.respondRawLength = 0;
    return arrayOfByte;
  }
  
  public int getRespondCode()
  {
    return this.respondCode;
  }
  
  public Map<String, String> getRespondHeader()
  {
    return this.contentHeaders;
  }
  
  public boolean isSocketAvailable()
  {
    SSLSocket localSSLSocket = this.sslSocket;
    boolean bool;
    if ((localSSLSocket != null) && (!localSSLSocket.isClosed())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void renewSocket()
    throws IOException
  {
    this.sslSocket = ((SSLSocket)createSocketFactory().createSocket());
    Object localObject = this.outputStream;
    if (localObject != null)
    {
      ((BufferedOutputStream)localObject).close();
      this.outputStream = null;
    }
    localObject = this.inputStream;
    if (localObject != null)
    {
      ((InputStream)localObject).close();
      this.inputStream = null;
    }
  }
  
  public void sendPayload(String paramString)
    throws IOException
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    preparePayload(paramString);
    request(this.requestBuffer.toString());
    this.respondCode = parseRespondCode();
    this.contentHeaders.clear();
    if (this.respondCode != 0)
    {
      paramString = getContentHeaders();
      this.contentHeaders = paramString;
      if ((paramString.containsKey("Transfer-Encoding")) && ("chunked".equals(this.contentHeaders.get("Transfer-Encoding")))) {
        return;
      }
      if (this.contentHeaders.containsKey("Content-Length"))
      {
        int i = getIntegerValue((String)this.contentHeaders.get("Content-Length"));
        if (i > 0) {
          readContentRawData(i);
        }
      }
    }
  }
  
  public SSLSocketFactory setCertificates(InputStream... paramVarArgs)
  {
    if (paramVarArgs != null) {
      try
      {
        X509TrustManager localX509TrustManager = trustManagerForCertificates(paramVarArgs);
        paramVarArgs = SSLContext.getInstance("TLS");
        paramVarArgs.init(null, new TrustManager[] { localX509TrustManager }, null);
        paramVarArgs = paramVarArgs.getSocketFactory();
        return paramVarArgs;
      }
      catch (GeneralSecurityException paramVarArgs)
      {
        throw new RuntimeException(paramVarArgs);
      }
    }
    return null;
  }
  
  public void setClientType(String paramString)
  {
    this.clientType = paramString;
  }
  
  public HostnameVerifier setHostnameVerifier(final String paramString)
  {
    new HostnameVerifier()
    {
      public boolean verify(String paramAnonymousString, SSLSession paramAnonymousSSLSession)
      {
        String str = paramAnonymousSSLSession.getPeerHost();
        try
        {
          X509Certificate[] arrayOfX509Certificate = (X509Certificate[])paramAnonymousSSLSession.getPeerCertificates();
          int i = arrayOfX509Certificate.length;
          for (int j = 0; j < i; j++) {
            for (paramAnonymousSSLSession : arrayOfX509Certificate[j].getSubjectX500Principal().getName().split(",")) {
              if ((paramAnonymousSSLSession.startsWith("CN")) && (str.equals(paramAnonymousString)))
              {
                boolean bool = paramAnonymousSSLSession.contains(paramString);
                if (bool) {
                  return true;
                }
              }
            }
          }
          return false;
        }
        catch (SSLPeerUnverifiedException paramAnonymousString)
        {
          paramAnonymousString.printStackTrace();
        }
      }
    };
  }
  
  public void setLoginToken(String paramString)
  {
    this.loginToken = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpmediastatistics\SSLClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */