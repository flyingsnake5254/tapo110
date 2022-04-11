package com.jcraft.jsch;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

public class JSch
{
  private static final Logger DEVNULL;
  public static final String VERSION = "0.1.54";
  static Hashtable config;
  static Logger logger;
  private ConfigRepository configRepository;
  private IdentityRepository defaultIdentityRepository;
  private IdentityRepository identityRepository;
  private HostKeyRepository known_hosts;
  private Vector sessionPool = new Vector();
  
  static
  {
    Object localObject = new Hashtable();
    config = (Hashtable)localObject;
    ((Hashtable)localObject).put("kex", "ecdh-sha2-nistp256,ecdh-sha2-nistp384,ecdh-sha2-nistp521,diffie-hellman-group14-sha1,diffie-hellman-group-exchange-sha256,diffie-hellman-group-exchange-sha1,diffie-hellman-group1-sha1");
    config.put("server_host_key", "ssh-rsa,ssh-dss,ecdsa-sha2-nistp256,ecdsa-sha2-nistp384,ecdsa-sha2-nistp521");
    config.put("cipher.s2c", "aes128-ctr,aes128-cbc,3des-ctr,3des-cbc,blowfish-cbc,aes192-ctr,aes192-cbc,aes256-ctr,aes256-cbc");
    config.put("cipher.c2s", "aes128-ctr,aes128-cbc,3des-ctr,3des-cbc,blowfish-cbc,aes192-ctr,aes192-cbc,aes256-ctr,aes256-cbc");
    config.put("mac.s2c", "hmac-md5,hmac-sha1,hmac-sha2-256,hmac-sha1-96,hmac-md5-96");
    config.put("mac.c2s", "hmac-md5,hmac-sha1,hmac-sha2-256,hmac-sha1-96,hmac-md5-96");
    config.put("compression.s2c", "none");
    config.put("compression.c2s", "none");
    config.put("lang.s2c", "");
    config.put("lang.c2s", "");
    config.put("compression_level", "6");
    config.put("diffie-hellman-group-exchange-sha1", "com.jcraft.jsch.DHGEX");
    config.put("diffie-hellman-group1-sha1", "com.jcraft.jsch.DHG1");
    config.put("diffie-hellman-group14-sha1", "com.jcraft.jsch.DHG14");
    config.put("diffie-hellman-group-exchange-sha256", "com.jcraft.jsch.DHGEX256");
    config.put("ecdsa-sha2-nistp256", "com.jcraft.jsch.jce.SignatureECDSA256");
    config.put("ecdsa-sha2-nistp384", "com.jcraft.jsch.jce.SignatureECDSA384");
    config.put("ecdsa-sha2-nistp521", "com.jcraft.jsch.jce.SignatureECDSA521");
    config.put("ecdh-sha2-nistp256", "com.jcraft.jsch.DHEC256");
    config.put("ecdh-sha2-nistp384", "com.jcraft.jsch.DHEC384");
    config.put("ecdh-sha2-nistp521", "com.jcraft.jsch.DHEC521");
    config.put("ecdh-sha2-nistp", "com.jcraft.jsch.jce.ECDHN");
    config.put("dh", "com.jcraft.jsch.jce.DH");
    config.put("3des-cbc", "com.jcraft.jsch.jce.TripleDESCBC");
    config.put("blowfish-cbc", "com.jcraft.jsch.jce.BlowfishCBC");
    config.put("hmac-sha1", "com.jcraft.jsch.jce.HMACSHA1");
    config.put("hmac-sha1-96", "com.jcraft.jsch.jce.HMACSHA196");
    config.put("hmac-sha2-256", "com.jcraft.jsch.jce.HMACSHA256");
    config.put("hmac-md5", "com.jcraft.jsch.jce.HMACMD5");
    config.put("hmac-md5-96", "com.jcraft.jsch.jce.HMACMD596");
    config.put("sha-1", "com.jcraft.jsch.jce.SHA1");
    config.put("sha-256", "com.jcraft.jsch.jce.SHA256");
    config.put("sha-384", "com.jcraft.jsch.jce.SHA384");
    config.put("sha-512", "com.jcraft.jsch.jce.SHA512");
    config.put("md5", "com.jcraft.jsch.jce.MD5");
    config.put("signature.dss", "com.jcraft.jsch.jce.SignatureDSA");
    config.put("signature.rsa", "com.jcraft.jsch.jce.SignatureRSA");
    config.put("keypairgen.dsa", "com.jcraft.jsch.jce.KeyPairGenDSA");
    config.put("keypairgen.rsa", "com.jcraft.jsch.jce.KeyPairGenRSA");
    config.put("keypairgen.ecdsa", "com.jcraft.jsch.jce.KeyPairGenECDSA");
    config.put("random", "com.jcraft.jsch.jce.Random");
    config.put("none", "com.jcraft.jsch.CipherNone");
    config.put("aes128-cbc", "com.jcraft.jsch.jce.AES128CBC");
    config.put("aes192-cbc", "com.jcraft.jsch.jce.AES192CBC");
    config.put("aes256-cbc", "com.jcraft.jsch.jce.AES256CBC");
    config.put("aes128-ctr", "com.jcraft.jsch.jce.AES128CTR");
    config.put("aes192-ctr", "com.jcraft.jsch.jce.AES192CTR");
    config.put("aes256-ctr", "com.jcraft.jsch.jce.AES256CTR");
    config.put("3des-ctr", "com.jcraft.jsch.jce.TripleDESCTR");
    config.put("arcfour", "com.jcraft.jsch.jce.ARCFOUR");
    config.put("arcfour128", "com.jcraft.jsch.jce.ARCFOUR128");
    config.put("arcfour256", "com.jcraft.jsch.jce.ARCFOUR256");
    config.put("userauth.none", "com.jcraft.jsch.UserAuthNone");
    config.put("userauth.password", "com.jcraft.jsch.UserAuthPassword");
    config.put("userauth.keyboard-interactive", "com.jcraft.jsch.UserAuthKeyboardInteractive");
    config.put("userauth.publickey", "com.jcraft.jsch.UserAuthPublicKey");
    config.put("userauth.gssapi-with-mic", "com.jcraft.jsch.UserAuthGSSAPIWithMIC");
    config.put("gssapi-with-mic.krb5", "com.jcraft.jsch.jgss.GSSContextKrb5");
    config.put("zlib", "com.jcraft.jsch.jcraft.Compression");
    config.put("zlib@openssh.com", "com.jcraft.jsch.jcraft.Compression");
    config.put("pbkdf", "com.jcraft.jsch.jce.PBKDF");
    config.put("StrictHostKeyChecking", "ask");
    config.put("HashKnownHosts", "no");
    config.put("PreferredAuthentications", "gssapi-with-mic,publickey,keyboard-interactive,password");
    config.put("CheckCiphers", "aes256-ctr,aes192-ctr,aes128-ctr,aes256-cbc,aes192-cbc,aes128-cbc,3des-ctr,arcfour,arcfour128,arcfour256");
    config.put("CheckKexes", "diffie-hellman-group14-sha1,ecdh-sha2-nistp256,ecdh-sha2-nistp384,ecdh-sha2-nistp521");
    config.put("CheckSignatures", "ecdsa-sha2-nistp256,ecdsa-sha2-nistp384,ecdsa-sha2-nistp521");
    config.put("MaxAuthTries", "6");
    config.put("ClearAllForwardings", "no");
    localObject = new Logger()
    {
      public boolean isEnabled(int paramAnonymousInt)
      {
        return false;
      }
      
      public void log(int paramAnonymousInt, String paramAnonymousString) {}
    };
    DEVNULL = (Logger)localObject;
    logger = (Logger)localObject;
  }
  
  public JSch()
  {
    LocalIdentityRepository localLocalIdentityRepository = new LocalIdentityRepository(this);
    this.defaultIdentityRepository = localLocalIdentityRepository;
    this.identityRepository = localLocalIdentityRepository;
    this.configRepository = null;
    this.known_hosts = null;
  }
  
  public static String getConfig(String paramString)
  {
    synchronized (config)
    {
      paramString = (String)config.get(paramString);
      return paramString;
    }
  }
  
  static Logger getLogger()
  {
    return logger;
  }
  
  public static void setConfig(String paramString1, String paramString2)
  {
    config.put(paramString1, paramString2);
  }
  
  public static void setConfig(Hashtable paramHashtable)
  {
    synchronized (config)
    {
      Enumeration localEnumeration = paramHashtable.keys();
      while (localEnumeration.hasMoreElements())
      {
        String str = (String)localEnumeration.nextElement();
        config.put(str, (String)paramHashtable.get(str));
      }
      return;
    }
  }
  
  public static void setLogger(Logger paramLogger)
  {
    Logger localLogger = paramLogger;
    if (paramLogger == null) {
      localLogger = DEVNULL;
    }
    logger = localLogger;
  }
  
  /* Error */
  public void addIdentity(Identity paramIdentity, byte[] paramArrayOfByte)
    throws JSchException
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnull +49 -> 50
    //   4: aload_2
    //   5: arraylength
    //   6: newarray <illegal type>
    //   8: astore_3
    //   9: aload_2
    //   10: iconst_0
    //   11: aload_3
    //   12: iconst_0
    //   13: aload_2
    //   14: arraylength
    //   15: invokestatic 361	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   18: aload_1
    //   19: aload_3
    //   20: invokeinterface 367 2 0
    //   25: pop
    //   26: aload_3
    //   27: invokestatic 373	com/jcraft/jsch/Util:bzero	([B)V
    //   30: goto +20 -> 50
    //   33: astore_2
    //   34: aload_3
    //   35: astore_1
    //   36: goto +8 -> 44
    //   39: astore_3
    //   40: aload_2
    //   41: astore_1
    //   42: aload_3
    //   43: astore_2
    //   44: aload_1
    //   45: invokestatic 373	com/jcraft/jsch/Util:bzero	([B)V
    //   48: aload_2
    //   49: athrow
    //   50: aload_0
    //   51: getfield 318	com/jcraft/jsch/JSch:identityRepository	Lcom/jcraft/jsch/IdentityRepository;
    //   54: astore_2
    //   55: aload_2
    //   56: instanceof 311
    //   59: ifeq +14 -> 73
    //   62: aload_2
    //   63: checkcast 311	com/jcraft/jsch/LocalIdentityRepository
    //   66: aload_1
    //   67: invokevirtual 377	com/jcraft/jsch/LocalIdentityRepository:add	(Lcom/jcraft/jsch/Identity;)V
    //   70: goto +83 -> 153
    //   73: aload_1
    //   74: instanceof 379
    //   77: ifeq +35 -> 112
    //   80: aload_1
    //   81: invokeinterface 382 1 0
    //   86: ifne +26 -> 112
    //   89: aload_0
    //   90: getfield 318	com/jcraft/jsch/JSch:identityRepository	Lcom/jcraft/jsch/IdentityRepository;
    //   93: aload_1
    //   94: checkcast 379	com/jcraft/jsch/IdentityFile
    //   97: invokevirtual 386	com/jcraft/jsch/IdentityFile:getKeyPair	()Lcom/jcraft/jsch/KeyPair;
    //   100: invokevirtual 392	com/jcraft/jsch/KeyPair:forSSHAgent	()[B
    //   103: invokeinterface 396 2 0
    //   108: pop
    //   109: goto +44 -> 153
    //   112: aload_0
    //   113: monitorenter
    //   114: aload_0
    //   115: getfield 318	com/jcraft/jsch/JSch:identityRepository	Lcom/jcraft/jsch/IdentityRepository;
    //   118: astore_3
    //   119: aload_3
    //   120: instanceof 398
    //   123: ifne +17 -> 140
    //   126: new 398	com/jcraft/jsch/IdentityRepository$Wrapper
    //   129: astore_2
    //   130: aload_2
    //   131: aload_3
    //   132: invokespecial 401	com/jcraft/jsch/IdentityRepository$Wrapper:<init>	(Lcom/jcraft/jsch/IdentityRepository;)V
    //   135: aload_0
    //   136: aload_2
    //   137: invokevirtual 404	com/jcraft/jsch/JSch:setIdentityRepository	(Lcom/jcraft/jsch/IdentityRepository;)V
    //   140: aload_0
    //   141: monitorexit
    //   142: aload_0
    //   143: getfield 318	com/jcraft/jsch/JSch:identityRepository	Lcom/jcraft/jsch/IdentityRepository;
    //   146: checkcast 398	com/jcraft/jsch/IdentityRepository$Wrapper
    //   149: aload_1
    //   150: invokevirtual 405	com/jcraft/jsch/IdentityRepository$Wrapper:add	(Lcom/jcraft/jsch/Identity;)V
    //   153: return
    //   154: astore_1
    //   155: aload_0
    //   156: monitorexit
    //   157: aload_1
    //   158: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	159	0	this	JSch
    //   0	159	1	paramIdentity	Identity
    //   0	159	2	paramArrayOfByte	byte[]
    //   8	27	3	arrayOfByte	byte[]
    //   39	4	3	localObject	Object
    //   118	14	3	localIdentityRepository	IdentityRepository
    // Exception table:
    //   from	to	target	type
    //   18	26	33	finally
    //   4	18	39	finally
    //   114	140	154	finally
    //   140	142	154	finally
    //   155	157	154	finally
  }
  
  public void addIdentity(String paramString)
    throws JSchException
  {
    addIdentity(paramString, null);
  }
  
  public void addIdentity(String paramString1, String paramString2)
    throws JSchException
  {
    if (paramString2 != null) {
      paramString2 = Util.str2byte(paramString2);
    } else {
      paramString2 = null;
    }
    addIdentity(paramString1, paramString2);
    if (paramString2 != null) {
      Util.bzero(paramString2);
    }
  }
  
  public void addIdentity(String paramString1, String paramString2, byte[] paramArrayOfByte)
    throws JSchException
  {
    addIdentity(IdentityFile.newInstance(paramString1, paramString2, this), paramArrayOfByte);
  }
  
  public void addIdentity(String paramString, byte[] paramArrayOfByte)
    throws JSchException
  {
    addIdentity(IdentityFile.newInstance(paramString, null, this), paramArrayOfByte);
  }
  
  public void addIdentity(String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
    throws JSchException
  {
    addIdentity(IdentityFile.newInstance(paramString, paramArrayOfByte1, paramArrayOfByte2, this), paramArrayOfByte3);
  }
  
  protected void addSession(Session paramSession)
  {
    synchronized (this.sessionPool)
    {
      this.sessionPool.addElement(paramSession);
      return;
    }
  }
  
  public ConfigRepository getConfigRepository()
  {
    return this.configRepository;
  }
  
  public HostKeyRepository getHostKeyRepository()
  {
    if (this.known_hosts == null) {
      this.known_hosts = new KnownHosts(this);
    }
    return this.known_hosts;
  }
  
  public Vector getIdentityNames()
    throws JSchException
  {
    Vector localVector1 = new Vector();
    Vector localVector2 = this.identityRepository.getIdentities();
    for (int i = 0; i < localVector2.size(); i++) {
      localVector1.addElement(((Identity)localVector2.elementAt(i)).getName());
    }
    return localVector1;
  }
  
  public IdentityRepository getIdentityRepository()
  {
    try
    {
      IdentityRepository localIdentityRepository = this.identityRepository;
      return localIdentityRepository;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public Session getSession(String paramString)
    throws JSchException
  {
    return getSession(null, paramString, 22);
  }
  
  public Session getSession(String paramString1, String paramString2)
    throws JSchException
  {
    return getSession(paramString1, paramString2, 22);
  }
  
  public Session getSession(String paramString1, String paramString2, int paramInt)
    throws JSchException
  {
    if (paramString2 != null) {
      return new Session(this, paramString1, paramString2, paramInt);
    }
    throw new JSchException("host must not be null.");
  }
  
  public void removeAllIdentity()
    throws JSchException
  {
    this.identityRepository.removeAll();
  }
  
  public void removeIdentity(Identity paramIdentity)
    throws JSchException
  {
    this.identityRepository.remove(paramIdentity.getPublicKeyBlob());
  }
  
  public void removeIdentity(String paramString)
    throws JSchException
  {
    Vector localVector = this.identityRepository.getIdentities();
    for (int i = 0; i < localVector.size(); i++)
    {
      Identity localIdentity = (Identity)localVector.elementAt(i);
      if (localIdentity.getName().equals(paramString))
      {
        IdentityRepository localIdentityRepository = this.identityRepository;
        if ((localIdentityRepository instanceof LocalIdentityRepository)) {
          ((LocalIdentityRepository)localIdentityRepository).remove(localIdentity);
        } else {
          localIdentityRepository.remove(localIdentity.getPublicKeyBlob());
        }
      }
    }
  }
  
  protected boolean removeSession(Session paramSession)
  {
    synchronized (this.sessionPool)
    {
      boolean bool = this.sessionPool.remove(paramSession);
      return bool;
    }
  }
  
  public void setConfigRepository(ConfigRepository paramConfigRepository)
  {
    this.configRepository = paramConfigRepository;
  }
  
  public void setHostKeyRepository(HostKeyRepository paramHostKeyRepository)
  {
    this.known_hosts = paramHostKeyRepository;
  }
  
  public void setIdentityRepository(IdentityRepository paramIdentityRepository)
  {
    if (paramIdentityRepository == null) {}
    try
    {
      this.identityRepository = this.defaultIdentityRepository;
      break label22;
      this.identityRepository = paramIdentityRepository;
      label22:
      return;
    }
    finally {}
  }
  
  public void setKnownHosts(InputStream paramInputStream)
    throws JSchException
  {
    if (this.known_hosts == null) {
      this.known_hosts = new KnownHosts(this);
    }
    HostKeyRepository localHostKeyRepository = this.known_hosts;
    if ((localHostKeyRepository instanceof KnownHosts)) {
      try
      {
        ((KnownHosts)this.known_hosts).setKnownHosts(paramInputStream);
      }
      finally {}
    }
  }
  
  public void setKnownHosts(String paramString)
    throws JSchException
  {
    if (this.known_hosts == null) {
      this.known_hosts = new KnownHosts(this);
    }
    HostKeyRepository localHostKeyRepository = this.known_hosts;
    if ((localHostKeyRepository instanceof KnownHosts)) {
      try
      {
        ((KnownHosts)this.known_hosts).setKnownHosts(paramString);
      }
      finally {}
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\JSch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */