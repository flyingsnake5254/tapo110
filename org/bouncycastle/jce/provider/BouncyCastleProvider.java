package org.bouncycastle.jce.provider;

import e.a.c.a.e;
import java.io.IOException;
import java.security.AccessController;
import java.security.PrivateKey;
import java.security.PrivilegedAction;
import java.security.Provider;
import java.security.PublicKey;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.bouncycastle.asn1.m;
import org.bouncycastle.asn1.n2.h;
import org.bouncycastle.asn1.x509.w;
import org.bouncycastle.pqc.jcajce.provider.xmss.c;

public final class BouncyCastleProvider
  extends Provider
  implements org.bouncycastle.jcajce.provider.config.a
{
  private static final String[] ASYMMETRIC_CIPHERS = { "DSA", "DH", "EC", "RSA", "GOST", "ECGOST", "ElGamal", "DSTU4145", "GM" };
  private static final String[] ASYMMETRIC_GENERIC;
  private static final String ASYMMETRIC_PACKAGE = "org.bouncycastle.jcajce.provider.asymmetric.";
  public static final org.bouncycastle.jcajce.provider.config.b CONFIGURATION = new a();
  private static final String[] DIGESTS = { "GOST3411", "Keccak", "MD2", "MD4", "MD5", "SHA1", "RIPEMD128", "RIPEMD160", "RIPEMD256", "RIPEMD320", "SHA224", "SHA256", "SHA384", "SHA512", "SHA3", "Skein", "SM3", "Tiger", "Whirlpool", "Blake2b", "Blake2s", "DSTU7564" };
  private static final String DIGEST_PACKAGE = "org.bouncycastle.jcajce.provider.digest.";
  private static final String[] KEYSTORES = { "BC", "BCFKS", "PKCS12" };
  private static final String KEYSTORE_PACKAGE = "org.bouncycastle.jcajce.provider.keystore.";
  public static final String PROVIDER_NAME = "BC";
  private static final String[] SECURE_RANDOMS = { "DRBG" };
  private static final String SECURE_RANDOM_PACKAGE = "org.bouncycastle.jcajce.provider.drbg.";
  private static final String[] SYMMETRIC_CIPHERS;
  private static final String[] SYMMETRIC_GENERIC;
  private static final String[] SYMMETRIC_MACS;
  private static final String SYMMETRIC_PACKAGE = "org.bouncycastle.jcajce.provider.symmetric.";
  private static String info = "BouncyCastle Security Provider v1.60";
  private static final Map keyInfoConverters = new HashMap();
  
  static
  {
    SYMMETRIC_GENERIC = new String[] { "PBEPBKDF1", "PBEPBKDF2", "PBEPKCS12", "TLSKDF", "SCRYPT" };
    SYMMETRIC_MACS = new String[] { "SipHash", "Poly1305" };
    SYMMETRIC_CIPHERS = new String[] { "AES", "ARC4", "ARIA", "Blowfish", "Camellia", "CAST5", "CAST6", "ChaCha", "DES", "DESede", "GOST28147", "Grainv1", "Grain128", "HC128", "HC256", "IDEA", "Noekeon", "RC2", "RC5", "RC6", "Rijndael", "Salsa20", "SEED", "Serpent", "Shacal2", "Skipjack", "SM4", "TEA", "Twofish", "Threefish", "VMPC", "VMPCKSA3", "XTEA", "XSalsa20", "OpenSSLPBKDF", "DSTU7624", "GOST3412_2015" };
    ASYMMETRIC_GENERIC = new String[] { "X509", "IES" };
  }
  
  public BouncyCastleProvider()
  {
    super("BC", 1.6D, info);
    AccessController.doPrivileged(new a());
  }
  
  private static org.bouncycastle.jcajce.provider.util.b getAsymmetricKeyInfoConverter(m paramm)
  {
    synchronized (keyInfoConverters)
    {
      paramm = (org.bouncycastle.jcajce.provider.util.b)???.get(paramm);
      return paramm;
    }
  }
  
  public static PrivateKey getPrivateKey(h paramh)
    throws IOException
  {
    org.bouncycastle.jcajce.provider.util.b localb = getAsymmetricKeyInfoConverter(paramh.h().f());
    if (localb == null) {
      return null;
    }
    return localb.a(paramh);
  }
  
  public static PublicKey getPublicKey(w paramw)
    throws IOException
  {
    org.bouncycastle.jcajce.provider.util.b localb = getAsymmetricKeyInfoConverter(paramw.f().f());
    if (localb == null) {
      return null;
    }
    return localb.b(paramw);
  }
  
  private void loadAlgorithms(String paramString, String[] paramArrayOfString)
  {
    for (int i = 0; i != paramArrayOfString.length; i++)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(paramArrayOfString[i]);
      ((StringBuilder)localObject).append("$Mappings");
      localObject = org.bouncycastle.jcajce.provider.symmetric.util.a.a(BouncyCastleProvider.class, ((StringBuilder)localObject).toString());
      if (localObject != null) {
        try
        {
          ((org.bouncycastle.jcajce.provider.util.a)((Class)localObject).newInstance()).a(this);
        }
        catch (Exception localException)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("cannot create instance of ");
          ((StringBuilder)localObject).append(paramString);
          ((StringBuilder)localObject).append(paramArrayOfString[i]);
          ((StringBuilder)localObject).append("$Mappings : ");
          ((StringBuilder)localObject).append(localException);
          throw new InternalError(((StringBuilder)localObject).toString());
        }
      }
    }
  }
  
  private void loadPQCKeys()
  {
    addKeyInfoConverter(e.r, new org.bouncycastle.pqc.jcajce.provider.sphincs.a());
    addKeyInfoConverter(e.v, new org.bouncycastle.pqc.jcajce.provider.newhope.a());
    addKeyInfoConverter(e.w, new org.bouncycastle.pqc.jcajce.provider.xmss.b());
    addKeyInfoConverter(e.B, new c());
    addKeyInfoConverter(e.m, new org.bouncycastle.pqc.jcajce.provider.mceliece.b());
    addKeyInfoConverter(e.n, new org.bouncycastle.pqc.jcajce.provider.mceliece.a());
    addKeyInfoConverter(e.a, new org.bouncycastle.pqc.jcajce.provider.rainbow.a());
  }
  
  private void setup()
  {
    loadAlgorithms("org.bouncycastle.jcajce.provider.digest.", DIGESTS);
    loadAlgorithms("org.bouncycastle.jcajce.provider.symmetric.", SYMMETRIC_GENERIC);
    loadAlgorithms("org.bouncycastle.jcajce.provider.symmetric.", SYMMETRIC_MACS);
    loadAlgorithms("org.bouncycastle.jcajce.provider.symmetric.", SYMMETRIC_CIPHERS);
    loadAlgorithms("org.bouncycastle.jcajce.provider.asymmetric.", ASYMMETRIC_GENERIC);
    loadAlgorithms("org.bouncycastle.jcajce.provider.asymmetric.", ASYMMETRIC_CIPHERS);
    loadAlgorithms("org.bouncycastle.jcajce.provider.keystore.", KEYSTORES);
    loadAlgorithms("org.bouncycastle.jcajce.provider.drbg.", SECURE_RANDOMS);
    loadPQCKeys();
    put("X509Store.CERTIFICATE/COLLECTION", "org.bouncycastle.jce.provider.X509StoreCertCollection");
    put("X509Store.ATTRIBUTECERTIFICATE/COLLECTION", "org.bouncycastle.jce.provider.X509StoreAttrCertCollection");
    put("X509Store.CRL/COLLECTION", "org.bouncycastle.jce.provider.X509StoreCRLCollection");
    put("X509Store.CERTIFICATEPAIR/COLLECTION", "org.bouncycastle.jce.provider.X509StoreCertPairCollection");
    put("X509Store.CERTIFICATE/LDAP", "org.bouncycastle.jce.provider.X509StoreLDAPCerts");
    put("X509Store.CRL/LDAP", "org.bouncycastle.jce.provider.X509StoreLDAPCRLs");
    put("X509Store.ATTRIBUTECERTIFICATE/LDAP", "org.bouncycastle.jce.provider.X509StoreLDAPAttrCerts");
    put("X509Store.CERTIFICATEPAIR/LDAP", "org.bouncycastle.jce.provider.X509StoreLDAPCertPairs");
    put("X509StreamParser.CERTIFICATE", "org.bouncycastle.jce.provider.X509CertParser");
    put("X509StreamParser.ATTRIBUTECERTIFICATE", "org.bouncycastle.jce.provider.X509AttrCertParser");
    put("X509StreamParser.CRL", "org.bouncycastle.jce.provider.X509CRLParser");
    put("X509StreamParser.CERTIFICATEPAIR", "org.bouncycastle.jce.provider.X509CertPairParser");
    put("Cipher.BROKENPBEWITHMD5ANDDES", "org.bouncycastle.jce.provider.BrokenJCEBlockCipher$BrokePBEWithMD5AndDES");
    put("Cipher.BROKENPBEWITHSHA1ANDDES", "org.bouncycastle.jce.provider.BrokenJCEBlockCipher$BrokePBEWithSHA1AndDES");
    put("Cipher.OLDPBEWITHSHAANDTWOFISH-CBC", "org.bouncycastle.jce.provider.BrokenJCEBlockCipher$OldPBEWithSHAAndTwofish");
    put("CertPathValidator.RFC3281", "org.bouncycastle.jce.provider.PKIXAttrCertPathValidatorSpi");
    put("CertPathBuilder.RFC3281", "org.bouncycastle.jce.provider.PKIXAttrCertPathBuilderSpi");
    put("CertPathValidator.RFC3280", "org.bouncycastle.jce.provider.PKIXCertPathValidatorSpi");
    put("CertPathBuilder.RFC3280", "org.bouncycastle.jce.provider.PKIXCertPathBuilderSpi");
    put("CertPathValidator.PKIX", "org.bouncycastle.jce.provider.PKIXCertPathValidatorSpi");
    put("CertPathBuilder.PKIX", "org.bouncycastle.jce.provider.PKIXCertPathBuilderSpi");
    put("CertStore.Collection", "org.bouncycastle.jce.provider.CertStoreCollectionSpi");
    put("CertStore.LDAP", "org.bouncycastle.jce.provider.X509LDAPCertStoreSpi");
    put("CertStore.Multi", "org.bouncycastle.jce.provider.MultiCertStoreSpi");
    put("Alg.Alias.CertStore.X509LDAP", "LDAP");
  }
  
  public void addAlgorithm(String paramString1, String paramString2)
  {
    if (!containsKey(paramString1))
    {
      put(paramString1, paramString2);
      return;
    }
    paramString2 = new StringBuilder();
    paramString2.append("duplicate provider key (");
    paramString2.append(paramString1);
    paramString2.append(") found");
    throw new IllegalStateException(paramString2.toString());
  }
  
  public void addAlgorithm(String paramString1, m paramm, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(".");
    localStringBuilder.append(paramm);
    addAlgorithm(localStringBuilder.toString(), paramString2);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(".OID.");
    localStringBuilder.append(paramm);
    addAlgorithm(localStringBuilder.toString(), paramString2);
  }
  
  public void addAttributes(String paramString, Map<String, String> paramMap)
  {
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(str);
      localObject = ((StringBuilder)localObject).toString();
      if (!containsKey(localObject))
      {
        put(localObject, paramMap.get(str));
      }
      else
      {
        paramString = new StringBuilder();
        paramString.append("duplicate provider attribute key (");
        paramString.append((String)localObject);
        paramString.append(") found");
        throw new IllegalStateException(paramString.toString());
      }
    }
  }
  
  public void addKeyInfoConverter(m paramm, org.bouncycastle.jcajce.provider.util.b paramb)
  {
    synchronized (keyInfoConverters)
    {
      ???.put(paramm, paramb);
      return;
    }
  }
  
  public boolean hasAlgorithm(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(".");
    localStringBuilder.append(paramString2);
    if (!containsKey(localStringBuilder.toString()))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Alg.Alias.");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(".");
      localStringBuilder.append(paramString2);
      if (!containsKey(localStringBuilder.toString()))
      {
        bool = false;
        break label98;
      }
    }
    boolean bool = true;
    label98:
    return bool;
  }
  
  public void setParameter(String paramString, Object paramObject)
  {
    synchronized (CONFIGURATION)
    {
      ((a)???).d(paramString, paramObject);
      return;
    }
  }
  
  class a
    implements PrivilegedAction
  {
    a() {}
    
    public Object run()
    {
      BouncyCastleProvider.this.setup();
      return null;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\jce\provider\BouncyCastleProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */