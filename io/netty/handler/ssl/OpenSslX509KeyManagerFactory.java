package io.netty.handler.ssl;

import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.UnpooledByteBufAllocator;
import io.netty.internal.tcnative.SSL;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.internal.ObjectUtil;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.KeyStoreSpi;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.KeyManagerFactorySpi;
import javax.net.ssl.ManagerFactoryParameters;
import javax.net.ssl.X509KeyManager;

public final class OpenSslX509KeyManagerFactory
  extends KeyManagerFactory
{
  private final OpenSslKeyManagerFactorySpi spi;
  
  public OpenSslX509KeyManagerFactory()
  {
    this(newOpenSslKeyManagerFactorySpi(null));
  }
  
  private OpenSslX509KeyManagerFactory(OpenSslKeyManagerFactorySpi paramOpenSslKeyManagerFactorySpi)
  {
    super(paramOpenSslKeyManagerFactorySpi, paramOpenSslKeyManagerFactorySpi.kmf.getProvider(), paramOpenSslKeyManagerFactorySpi.kmf.getAlgorithm());
    this.spi = paramOpenSslKeyManagerFactorySpi;
  }
  
  public OpenSslX509KeyManagerFactory(String paramString, Provider paramProvider)
    throws NoSuchAlgorithmException
  {
    this(newOpenSslKeyManagerFactorySpi(paramString, paramProvider));
  }
  
  public OpenSslX509KeyManagerFactory(Provider paramProvider)
  {
    this(newOpenSslKeyManagerFactorySpi(paramProvider));
  }
  
  public static OpenSslX509KeyManagerFactory newEngineBased(File paramFile, String paramString)
    throws CertificateException, IOException, KeyStoreException, NoSuchAlgorithmException, UnrecoverableKeyException
  {
    return newEngineBased(SslContext.toX509Certificates(paramFile), paramString);
  }
  
  public static OpenSslX509KeyManagerFactory newEngineBased(X509Certificate[] paramArrayOfX509Certificate, String paramString)
    throws CertificateException, IOException, KeyStoreException, NoSuchAlgorithmException, UnrecoverableKeyException
  {
    Object localObject = (X509Certificate[])paramArrayOfX509Certificate.clone();
    paramArrayOfX509Certificate = null;
    localObject = new OpenSslKeyStore((X509Certificate[])localObject, false, null);
    ((KeyStore)localObject).load(null, null);
    OpenSslX509KeyManagerFactory localOpenSslX509KeyManagerFactory = new OpenSslX509KeyManagerFactory();
    if (paramString != null) {
      paramArrayOfX509Certificate = paramString.toCharArray();
    }
    localOpenSslX509KeyManagerFactory.init((KeyStore)localObject, paramArrayOfX509Certificate);
    return localOpenSslX509KeyManagerFactory;
  }
  
  public static OpenSslX509KeyManagerFactory newKeyless(File paramFile)
    throws CertificateException, IOException, KeyStoreException, NoSuchAlgorithmException, UnrecoverableKeyException
  {
    return newKeyless(SslContext.toX509Certificates(paramFile));
  }
  
  public static OpenSslX509KeyManagerFactory newKeyless(InputStream paramInputStream)
    throws CertificateException, IOException, KeyStoreException, NoSuchAlgorithmException, UnrecoverableKeyException
  {
    return newKeyless(SslContext.toX509Certificates(paramInputStream));
  }
  
  public static OpenSslX509KeyManagerFactory newKeyless(X509Certificate... paramVarArgs)
    throws CertificateException, IOException, KeyStoreException, NoSuchAlgorithmException, UnrecoverableKeyException
  {
    OpenSslKeyStore localOpenSslKeyStore = new OpenSslKeyStore((X509Certificate[])paramVarArgs.clone(), true, null);
    localOpenSslKeyStore.load(null, null);
    paramVarArgs = new OpenSslX509KeyManagerFactory();
    paramVarArgs.init(localOpenSslKeyStore, null);
    return paramVarArgs;
  }
  
  private static OpenSslKeyManagerFactorySpi newOpenSslKeyManagerFactorySpi(String paramString, Provider paramProvider)
    throws NoSuchAlgorithmException
  {
    String str = paramString;
    if (paramString == null) {
      str = KeyManagerFactory.getDefaultAlgorithm();
    }
    if (paramProvider == null) {
      paramString = KeyManagerFactory.getInstance(str);
    } else {
      paramString = KeyManagerFactory.getInstance(str, paramProvider);
    }
    return new OpenSslKeyManagerFactorySpi(paramString);
  }
  
  private static OpenSslKeyManagerFactorySpi newOpenSslKeyManagerFactorySpi(Provider paramProvider)
  {
    try
    {
      paramProvider = newOpenSslKeyManagerFactorySpi(null, paramProvider);
      return paramProvider;
    }
    catch (NoSuchAlgorithmException paramProvider)
    {
      throw new IllegalStateException(paramProvider);
    }
  }
  
  OpenSslKeyMaterialProvider newProvider()
  {
    return this.spi.newProvider();
  }
  
  private static final class OpenSslKeyManagerFactorySpi
    extends KeyManagerFactorySpi
  {
    final KeyManagerFactory kmf;
    private volatile ProviderFactory providerFactory;
    
    OpenSslKeyManagerFactorySpi(KeyManagerFactory paramKeyManagerFactory)
    {
      this.kmf = ((KeyManagerFactory)ObjectUtil.checkNotNull(paramKeyManagerFactory, "kmf"));
    }
    
    private static String password(char[] paramArrayOfChar)
    {
      if ((paramArrayOfChar != null) && (paramArrayOfChar.length != 0)) {
        return new String(paramArrayOfChar);
      }
      return null;
    }
    
    protected KeyManager[] engineGetKeyManagers()
    {
      ProviderFactory localProviderFactory = this.providerFactory;
      if (localProviderFactory != null) {
        return new KeyManager[] { localProviderFactory.keyManager };
      }
      throw new IllegalStateException("engineInit(...) not called yet");
    }
    
    protected void engineInit(KeyStore paramKeyStore, char[] paramArrayOfChar)
      throws KeyStoreException, NoSuchAlgorithmException, UnrecoverableKeyException
    {
      try
      {
        if (this.providerFactory == null)
        {
          if (paramKeyStore.aliases().hasMoreElements())
          {
            this.kmf.init(paramKeyStore, paramArrayOfChar);
            ProviderFactory localProviderFactory = new io/netty/handler/ssl/OpenSslX509KeyManagerFactory$OpenSslKeyManagerFactorySpi$ProviderFactory;
            localProviderFactory.<init>(ReferenceCountedOpenSslContext.chooseX509KeyManager(this.kmf.getKeyManagers()), password(paramArrayOfChar), Collections.list(paramKeyStore.aliases()));
            this.providerFactory = localProviderFactory;
            return;
          }
          paramKeyStore = new java/security/KeyStoreException;
          paramKeyStore.<init>("No aliases found");
          throw paramKeyStore;
        }
        paramKeyStore = new java/security/KeyStoreException;
        paramKeyStore.<init>("Already initialized");
        throw paramKeyStore;
      }
      finally {}
    }
    
    protected void engineInit(ManagerFactoryParameters paramManagerFactoryParameters)
      throws InvalidAlgorithmParameterException
    {
      throw new InvalidAlgorithmParameterException("Not supported");
    }
    
    OpenSslKeyMaterialProvider newProvider()
    {
      ProviderFactory localProviderFactory = this.providerFactory;
      if (localProviderFactory != null) {
        return localProviderFactory.newProvider();
      }
      throw new IllegalStateException("engineInit(...) not called yet");
    }
    
    private static final class ProviderFactory
    {
      private final Iterable<String> aliases;
      private final X509KeyManager keyManager;
      private final String password;
      
      ProviderFactory(X509KeyManager paramX509KeyManager, String paramString, Iterable<String> paramIterable)
      {
        this.keyManager = paramX509KeyManager;
        this.password = paramString;
        this.aliases = paramIterable;
      }
      
      OpenSslKeyMaterialProvider newProvider()
      {
        return new OpenSslPopulatedKeyMaterialProvider(this.keyManager, this.password, this.aliases);
      }
      
      private static final class OpenSslPopulatedKeyMaterialProvider
        extends OpenSslKeyMaterialProvider
      {
        private final Map<String, Object> materialMap = new HashMap();
        
        OpenSslPopulatedKeyMaterialProvider(X509KeyManager paramX509KeyManager, String paramString, Iterable<String> paramIterable)
        {
          super(paramString);
          try
          {
            paramIterable = paramIterable.iterator();
            while (paramIterable.hasNext())
            {
              paramX509KeyManager = (String)paramIterable.next();
              if (paramX509KeyManager != null)
              {
                boolean bool = this.materialMap.containsKey(paramX509KeyManager);
                if (!bool) {
                  try
                  {
                    this.materialMap.put(paramX509KeyManager, super.chooseKeyMaterial(UnpooledByteBufAllocator.DEFAULT, paramX509KeyManager));
                  }
                  catch (Exception paramString)
                  {
                    this.materialMap.put(paramX509KeyManager, paramString);
                  }
                }
              }
            }
            if (!this.materialMap.isEmpty()) {
              return;
            }
            throw new IllegalArgumentException("aliases must be non-empty");
          }
          finally
          {
            destroy();
          }
        }
        
        OpenSslKeyMaterial chooseKeyMaterial(ByteBufAllocator paramByteBufAllocator, String paramString)
          throws Exception
        {
          paramByteBufAllocator = this.materialMap.get(paramString);
          if (paramByteBufAllocator == null) {
            return null;
          }
          if ((paramByteBufAllocator instanceof OpenSslKeyMaterial)) {
            return ((OpenSslKeyMaterial)paramByteBufAllocator).retain();
          }
          throw ((Exception)paramByteBufAllocator);
        }
        
        void destroy()
        {
          Iterator localIterator = this.materialMap.values().iterator();
          while (localIterator.hasNext()) {
            ReferenceCountUtil.release(localIterator.next());
          }
          this.materialMap.clear();
        }
      }
    }
  }
  
  private static final class OpenSslKeyStore
    extends KeyStore
  {
    private OpenSslKeyStore(final X509Certificate[] paramArrayOfX509Certificate, boolean paramBoolean)
    {
      super(
      {
        private final Date creationDate = new Date();
        
        public Enumeration<String> engineAliases()
        {
          return Collections.enumeration(Collections.singleton("key"));
        }
        
        public boolean engineContainsAlias(String paramAnonymousString)
        {
          return "key".equals(paramAnonymousString);
        }
        
        public void engineDeleteEntry(String paramAnonymousString)
          throws KeyStoreException
        {
          throw new KeyStoreException("Not supported");
        }
        
        public Certificate engineGetCertificate(String paramAnonymousString)
        {
          if (engineContainsAlias(paramAnonymousString)) {
            paramAnonymousString = paramArrayOfX509Certificate[0];
          } else {
            paramAnonymousString = null;
          }
          return paramAnonymousString;
        }
        
        public String engineGetCertificateAlias(Certificate paramAnonymousCertificate)
        {
          if ((paramAnonymousCertificate instanceof X509Certificate))
          {
            X509Certificate[] arrayOfX509Certificate = paramArrayOfX509Certificate;
            int i = arrayOfX509Certificate.length;
            for (int j = 0; j < i; j++) {
              if (arrayOfX509Certificate[j].equals(paramAnonymousCertificate)) {
                return "key";
              }
            }
          }
          return null;
        }
        
        public Certificate[] engineGetCertificateChain(String paramAnonymousString)
        {
          if (engineContainsAlias(paramAnonymousString)) {
            paramAnonymousString = (X509Certificate[])paramArrayOfX509Certificate.clone();
          } else {
            paramAnonymousString = null;
          }
          return paramAnonymousString;
        }
        
        public Date engineGetCreationDate(String paramAnonymousString)
        {
          if (engineContainsAlias(paramAnonymousString)) {
            paramAnonymousString = this.creationDate;
          } else {
            paramAnonymousString = null;
          }
          return paramAnonymousString;
        }
        
        public Key engineGetKey(String paramAnonymousString, char[] paramAnonymousArrayOfChar)
          throws UnrecoverableKeyException
        {
          boolean bool = engineContainsAlias(paramAnonymousString);
          Object localObject = null;
          if (bool)
          {
            long l;
            if (this.val$keyless) {
              l = 0L;
            } else if (paramAnonymousArrayOfChar == null) {
              paramAnonymousArrayOfChar = (char[])localObject;
            }
            try
            {
              paramAnonymousArrayOfChar = new String(paramAnonymousArrayOfChar);
              l = SSL.loadPrivateKeyFromEngine(paramAnonymousString, paramAnonymousArrayOfChar);
              return new OpenSslPrivateKey(l);
            }
            catch (Exception paramAnonymousArrayOfChar)
            {
              paramAnonymousString = new UnrecoverableKeyException("Unable to load key from engine");
              paramAnonymousString.initCause(paramAnonymousArrayOfChar);
              throw paramAnonymousString;
            }
          }
          return null;
        }
        
        public boolean engineIsCertificateEntry(String paramAnonymousString)
        {
          return engineContainsAlias(paramAnonymousString);
        }
        
        public boolean engineIsKeyEntry(String paramAnonymousString)
        {
          return engineContainsAlias(paramAnonymousString);
        }
        
        public void engineLoad(InputStream paramAnonymousInputStream, char[] paramAnonymousArrayOfChar)
        {
          if ((paramAnonymousInputStream != null) && (paramAnonymousArrayOfChar != null)) {
            throw new UnsupportedOperationException();
          }
        }
        
        public void engineSetCertificateEntry(String paramAnonymousString, Certificate paramAnonymousCertificate)
          throws KeyStoreException
        {
          throw new KeyStoreException("Not supported");
        }
        
        public void engineSetKeyEntry(String paramAnonymousString, Key paramAnonymousKey, char[] paramAnonymousArrayOfChar, Certificate[] paramAnonymousArrayOfCertificate)
          throws KeyStoreException
        {
          throw new KeyStoreException("Not supported");
        }
        
        public void engineSetKeyEntry(String paramAnonymousString, byte[] paramAnonymousArrayOfByte, Certificate[] paramAnonymousArrayOfCertificate)
          throws KeyStoreException
        {
          throw new KeyStoreException("Not supported");
        }
        
        public int engineSize()
        {
          return 1;
        }
        
        public void engineStore(OutputStream paramAnonymousOutputStream, char[] paramAnonymousArrayOfChar)
        {
          throw new UnsupportedOperationException();
        }
      }, "native");
      OpenSsl.ensureAvailability();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\ssl\OpenSslX509KeyManagerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */