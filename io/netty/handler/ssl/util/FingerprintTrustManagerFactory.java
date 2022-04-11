package io.netty.handler.ssl.util;

import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.util.concurrent.FastThreadLocal;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.security.KeyStore;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.ManagerFactoryParameters;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public final class FingerprintTrustManagerFactory
  extends SimpleTrustManagerFactory
{
  private static final Pattern FINGERPRINT_PATTERN = Pattern.compile("^[0-9a-fA-F:]+$");
  private static final Pattern FINGERPRINT_STRIP_PATTERN = Pattern.compile(":");
  private static final int SHA1_BYTE_LEN = 20;
  private static final int SHA1_HEX_LEN = 40;
  private static final FastThreadLocal<MessageDigest> tlmd = new FastThreadLocal()
  {
    protected MessageDigest initialValue()
    {
      try
      {
        MessageDigest localMessageDigest = MessageDigest.getInstance("SHA1");
        return localMessageDigest;
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
      {
        throw new Error(localNoSuchAlgorithmException);
      }
    }
  };
  private final byte[][] fingerprints;
  private final TrustManager tm = new X509TrustManager()
  {
    private void checkTrusted(String paramAnonymousString, X509Certificate[] paramAnonymousArrayOfX509Certificate)
      throws CertificateException
    {
      int i = 0;
      paramAnonymousArrayOfX509Certificate = paramAnonymousArrayOfX509Certificate[0];
      Object localObject = fingerprint(paramAnonymousArrayOfX509Certificate);
      byte[][] arrayOfByte = FingerprintTrustManagerFactory.this.fingerprints;
      int j = arrayOfByte.length;
      int m;
      for (int k = 0;; k++)
      {
        m = i;
        if (k >= j) {
          break;
        }
        if (Arrays.equals((byte[])localObject, arrayOfByte[k]))
        {
          m = 1;
          break;
        }
      }
      if (m != 0) {
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramAnonymousString);
      ((StringBuilder)localObject).append(" certificate with unknown fingerprint: ");
      ((StringBuilder)localObject).append(paramAnonymousArrayOfX509Certificate.getSubjectDN());
      throw new CertificateException(((StringBuilder)localObject).toString());
    }
    
    private byte[] fingerprint(X509Certificate paramAnonymousX509Certificate)
      throws CertificateEncodingException
    {
      MessageDigest localMessageDigest = (MessageDigest)FingerprintTrustManagerFactory.tlmd.get();
      localMessageDigest.reset();
      return localMessageDigest.digest(paramAnonymousX509Certificate.getEncoded());
    }
    
    public void checkClientTrusted(X509Certificate[] paramAnonymousArrayOfX509Certificate, String paramAnonymousString)
      throws CertificateException
    {
      checkTrusted("client", paramAnonymousArrayOfX509Certificate);
    }
    
    public void checkServerTrusted(X509Certificate[] paramAnonymousArrayOfX509Certificate, String paramAnonymousString)
      throws CertificateException
    {
      checkTrusted("server", paramAnonymousArrayOfX509Certificate);
    }
    
    public X509Certificate[] getAcceptedIssuers()
    {
      return EmptyArrays.EMPTY_X509_CERTIFICATES;
    }
  };
  
  public FingerprintTrustManagerFactory(Iterable<String> paramIterable)
  {
    this(toFingerprintArray(paramIterable));
  }
  
  public FingerprintTrustManagerFactory(String... paramVarArgs)
  {
    this(toFingerprintArray(Arrays.asList(paramVarArgs)));
  }
  
  public FingerprintTrustManagerFactory(byte[]... paramVarArgs)
  {
    ObjectUtil.checkNotNull(paramVarArgs, "fingerprints");
    ArrayList localArrayList = new ArrayList(paramVarArgs.length);
    int i = paramVarArgs.length;
    int j = 0;
    while (j < i)
    {
      byte[] arrayOfByte = paramVarArgs[j];
      if (arrayOfByte != null) {
        if (arrayOfByte.length == 20)
        {
          localArrayList.add(arrayOfByte.clone());
          j++;
        }
        else
        {
          paramVarArgs = new StringBuilder();
          paramVarArgs.append("malformed fingerprint: ");
          paramVarArgs.append(ByteBufUtil.hexDump(Unpooled.wrappedBuffer(arrayOfByte)));
          paramVarArgs.append(" (expected: SHA1)");
          throw new IllegalArgumentException(paramVarArgs.toString());
        }
      }
    }
    this.fingerprints = ((byte[][])localArrayList.toArray(new byte[0][]));
  }
  
  private static byte[][] toFingerprintArray(Iterable<String> paramIterable)
  {
    ObjectUtil.checkNotNull(paramIterable, "fingerprints");
    Object localObject = new ArrayList();
    Iterator localIterator = paramIterable.iterator();
    while (localIterator.hasNext())
    {
      paramIterable = (String)localIterator.next();
      if (paramIterable != null) {
        if (FINGERPRINT_PATTERN.matcher(paramIterable).matches())
        {
          paramIterable = FINGERPRINT_STRIP_PATTERN.matcher(paramIterable).replaceAll("");
          if (paramIterable.length() == 40)
          {
            ((List)localObject).add(StringUtil.decodeHexDump(paramIterable));
          }
          else
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("malformed fingerprint: ");
            ((StringBuilder)localObject).append(paramIterable);
            ((StringBuilder)localObject).append(" (expected: SHA1)");
            throw new IllegalArgumentException(((StringBuilder)localObject).toString());
          }
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("malformed fingerprint: ");
          ((StringBuilder)localObject).append(paramIterable);
          throw new IllegalArgumentException(((StringBuilder)localObject).toString());
        }
      }
    }
    return (byte[][])((List)localObject).toArray(new byte[0][]);
  }
  
  protected TrustManager[] engineGetTrustManagers()
  {
    return new TrustManager[] { this.tm };
  }
  
  protected void engineInit(KeyStore paramKeyStore)
    throws Exception
  {}
  
  protected void engineInit(ManagerFactoryParameters paramManagerFactoryParameters)
    throws Exception
  {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\ssl\util\FingerprintTrustManagerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */