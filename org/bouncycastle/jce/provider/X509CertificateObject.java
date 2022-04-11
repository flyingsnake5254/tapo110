package org.bouncycastle.jce.provider;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Principal;
import java.security.Provider;
import java.security.PublicKey;
import java.security.Security;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import org.bouncycastle.asn1.e;
import org.bouncycastle.asn1.j;
import org.bouncycastle.asn1.n;
import org.bouncycastle.asn1.n0;
import org.bouncycastle.asn1.p;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.r;
import org.bouncycastle.asn1.u0;
import org.bouncycastle.asn1.v0;
import org.bouncycastle.asn1.w;
import org.bouncycastle.asn1.x509.g;
import org.bouncycastle.asn1.x509.h;
import org.bouncycastle.asn1.x509.o;
import org.bouncycastle.asn1.x509.t;
import org.bouncycastle.asn1.x509.y;
import org.bouncycastle.asn1.x509.z;

public class X509CertificateObject
  extends X509Certificate
  implements org.bouncycastle.jce.interfaces.b
{
  private org.bouncycastle.jce.interfaces.b attrCarrier;
  private g basicConstraints;
  private h c;
  private int hashValue;
  private boolean hashValueSet;
  private boolean[] keyUsage;
  
  /* Error */
  public X509CertificateObject(h paramh)
    throws CertificateParsingException
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 27	java/security/cert/X509Certificate:<init>	()V
    //   4: aload_0
    //   5: new 29	org/bouncycastle/jcajce/provider/asymmetric/util/d
    //   8: dup
    //   9: invokespecial 30	org/bouncycastle/jcajce/provider/asymmetric/util/d:<init>	()V
    //   12: putfield 32	org/bouncycastle/jce/provider/X509CertificateObject:attrCarrier	Lorg/bouncycastle/jce/interfaces/b;
    //   15: aload_0
    //   16: aload_1
    //   17: putfield 34	org/bouncycastle/jce/provider/X509CertificateObject:c	Lorg/bouncycastle/asn1/x509/h;
    //   20: aload_0
    //   21: ldc 36
    //   23: invokespecial 40	org/bouncycastle/jce/provider/X509CertificateObject:getExtensionBytes	(Ljava/lang/String;)[B
    //   26: astore_1
    //   27: aload_1
    //   28: ifnull +14 -> 42
    //   31: aload_0
    //   32: aload_1
    //   33: invokestatic 46	org/bouncycastle/asn1/q:i	([B)Lorg/bouncycastle/asn1/q;
    //   36: invokestatic 52	org/bouncycastle/asn1/x509/g:f	(Ljava/lang/Object;)Lorg/bouncycastle/asn1/x509/g;
    //   39: putfield 54	org/bouncycastle/jce/provider/X509CertificateObject:basicConstraints	Lorg/bouncycastle/asn1/x509/g;
    //   42: aload_0
    //   43: ldc 56
    //   45: invokespecial 40	org/bouncycastle/jce/provider/X509CertificateObject:getExtensionBytes	(Ljava/lang/String;)[B
    //   48: astore_1
    //   49: aload_1
    //   50: ifnull +106 -> 156
    //   53: aload_1
    //   54: invokestatic 46	org/bouncycastle/asn1/q:i	([B)Lorg/bouncycastle/asn1/q;
    //   57: invokestatic 62	org/bouncycastle/asn1/n0:s	(Ljava/lang/Object;)Lorg/bouncycastle/asn1/n0;
    //   60: astore_2
    //   61: aload_2
    //   62: invokevirtual 68	org/bouncycastle/asn1/b:o	()[B
    //   65: astore_1
    //   66: aload_1
    //   67: arraylength
    //   68: bipush 8
    //   70: imul
    //   71: aload_2
    //   72: invokevirtual 72	org/bouncycastle/asn1/b:q	()I
    //   75: isub
    //   76: istore_3
    //   77: bipush 9
    //   79: istore 4
    //   81: iload_3
    //   82: bipush 9
    //   84: if_icmpge +6 -> 90
    //   87: goto +6 -> 93
    //   90: iload_3
    //   91: istore 4
    //   93: aload_0
    //   94: iload 4
    //   96: newarray <illegal type>
    //   98: putfield 74	org/bouncycastle/jce/provider/X509CertificateObject:keyUsage	[Z
    //   101: iconst_0
    //   102: istore 4
    //   104: iload 4
    //   106: iload_3
    //   107: if_icmpeq +54 -> 161
    //   110: aload_0
    //   111: getfield 74	org/bouncycastle/jce/provider/X509CertificateObject:keyUsage	[Z
    //   114: astore_2
    //   115: aload_1
    //   116: iload 4
    //   118: bipush 8
    //   120: idiv
    //   121: baload
    //   122: sipush 128
    //   125: iload 4
    //   127: bipush 8
    //   129: irem
    //   130: iushr
    //   131: iand
    //   132: ifeq +9 -> 141
    //   135: iconst_1
    //   136: istore 5
    //   138: goto +6 -> 144
    //   141: iconst_0
    //   142: istore 5
    //   144: aload_2
    //   145: iload 4
    //   147: iload 5
    //   149: bastore
    //   150: iinc 4 1
    //   153: goto -49 -> 104
    //   156: aload_0
    //   157: aconst_null
    //   158: putfield 74	org/bouncycastle/jce/provider/X509CertificateObject:keyUsage	[Z
    //   161: return
    //   162: astore_2
    //   163: new 76	java/lang/StringBuilder
    //   166: dup
    //   167: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   170: astore_1
    //   171: aload_1
    //   172: ldc 79
    //   174: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: pop
    //   178: aload_1
    //   179: aload_2
    //   180: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   183: pop
    //   184: new 22	java/security/cert/CertificateParsingException
    //   187: dup
    //   188: aload_1
    //   189: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   192: invokespecial 93	java/security/cert/CertificateParsingException:<init>	(Ljava/lang/String;)V
    //   195: athrow
    //   196: astore_1
    //   197: new 76	java/lang/StringBuilder
    //   200: dup
    //   201: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   204: astore_2
    //   205: aload_2
    //   206: ldc 95
    //   208: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: pop
    //   212: aload_2
    //   213: aload_1
    //   214: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   217: pop
    //   218: new 22	java/security/cert/CertificateParsingException
    //   221: dup
    //   222: aload_2
    //   223: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   226: invokespecial 93	java/security/cert/CertificateParsingException:<init>	(Ljava/lang/String;)V
    //   229: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	230	0	this	X509CertificateObject
    //   0	230	1	paramh	h
    //   60	85	2	localObject	Object
    //   162	18	2	localException	Exception
    //   204	19	2	localStringBuilder	StringBuilder
    //   76	32	3	i	int
    //   79	72	4	j	int
    //   136	12	5	k	int
    // Exception table:
    //   from	to	target	type
    //   42	49	162	java/lang/Exception
    //   53	77	162	java/lang/Exception
    //   93	101	162	java/lang/Exception
    //   110	135	162	java/lang/Exception
    //   156	161	162	java/lang/Exception
    //   20	27	196	java/lang/Exception
    //   31	42	196	java/lang/Exception
  }
  
  private int calculateHashCode()
  {
    try
    {
      byte[] arrayOfByte = getEncoded();
      int i = 1;
      int j = 0;
      while (i < arrayOfByte.length)
      {
        int k = arrayOfByte[i];
        j += k * i;
        i++;
      }
      return j;
    }
    catch (CertificateEncodingException localCertificateEncodingException) {}
    return 0;
  }
  
  private void checkSignature(PublicKey paramPublicKey, Signature paramSignature)
    throws CertificateException, NoSuchAlgorithmException, SignatureException, InvalidKeyException
  {
    if (isAlgIdEqual(this.c.k(), this.c.o().l()))
    {
      d.c(paramSignature, this.c.k().i());
      paramSignature.initVerify(paramPublicKey);
      paramSignature.update(getTBSCertificate());
      if (paramSignature.verify(getSignature())) {
        return;
      }
      throw new SignatureException("certificate does not verify with supplied key");
    }
    throw new CertificateException("signature algorithm in TBS cert not same as outer cert");
  }
  
  private static Collection getAlternativeNames(byte[] paramArrayOfByte)
    throws CertificateParsingException
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    for (;;)
    {
      try
      {
        localObject1 = new java/util/ArrayList;
        ((ArrayList)localObject1).<init>();
        localObject2 = r.m(paramArrayOfByte).q();
        if (((Enumeration)localObject2).hasMoreElements())
        {
          paramArrayOfByte = o.f(((Enumeration)localObject2).nextElement());
          localArrayList = new java/util/ArrayList;
          localArrayList.<init>();
          localArrayList.add(org.bouncycastle.util.d.b(paramArrayOfByte.h()));
          switch (paramArrayOfByte.h())
          {
          default: 
            localObject2 = new java/io/IOException;
            break;
          case 8: 
            paramArrayOfByte = org.bouncycastle.asn1.m.r(paramArrayOfByte.g()).q();
            localArrayList.add(paramArrayOfByte);
            break;
          case 7: 
            paramArrayOfByte = n.m(paramArrayOfByte.g()).o();
          }
        }
      }
      catch (Exception paramArrayOfByte)
      {
        Object localObject1;
        Object localObject2;
        ArrayList localArrayList;
        throw new CertificateParsingException(paramArrayOfByte.getMessage());
      }
      try
      {
        paramArrayOfByte = InetAddress.getByAddress(paramArrayOfByte).getHostAddress();
      }
      catch (UnknownHostException paramArrayOfByte) {}
      paramArrayOfByte = org.bouncycastle.asn1.t2.c.h(org.bouncycastle.asn1.t2.f.d.T, paramArrayOfByte.g()).toString();
      continue;
      paramArrayOfByte = ((w)paramArrayOfByte.g()).getString();
      continue;
      localArrayList.add(paramArrayOfByte.d());
      ((Collection)localObject1).add(Collections.unmodifiableList(localArrayList));
      continue;
      localObject1 = new java/lang/StringBuilder;
      ((StringBuilder)localObject1).<init>();
      ((StringBuilder)localObject1).append("Bad tag number: ");
      ((StringBuilder)localObject1).append(paramArrayOfByte.h());
      ((IOException)localObject2).<init>(((StringBuilder)localObject1).toString());
      throw ((Throwable)localObject2);
      if (((Collection)localObject1).size() == 0) {
        return null;
      }
      paramArrayOfByte = Collections.unmodifiableCollection((Collection)localObject1);
      return paramArrayOfByte;
    }
  }
  
  private byte[] getExtensionBytes(String paramString)
  {
    org.bouncycastle.asn1.x509.m localm = this.c.o().g();
    if (localm != null)
    {
      paramString = localm.g(new org.bouncycastle.asn1.m(paramString));
      if (paramString != null) {
        return paramString.h().o();
      }
    }
    return null;
  }
  
  private boolean isAlgIdEqual(org.bouncycastle.asn1.x509.a parama1, org.bouncycastle.asn1.x509.a parama2)
  {
    if (!parama1.f().equals(parama2.f())) {
      return false;
    }
    if (parama1.i() == null) {
      return (parama2.i() == null) || (parama2.i().equals(v0.c));
    }
    if (parama2.i() == null) {
      return (parama1.i() == null) || (parama1.i().equals(v0.c));
    }
    return parama1.i().equals(parama2.i());
  }
  
  public void checkValidity()
    throws CertificateExpiredException, CertificateNotYetValidException
  {
    checkValidity(new Date());
  }
  
  public void checkValidity(Date paramDate)
    throws CertificateExpiredException, CertificateNotYetValidException
  {
    if (paramDate.getTime() <= getNotAfter().getTime())
    {
      if (paramDate.getTime() >= getNotBefore().getTime()) {
        return;
      }
      paramDate = new StringBuilder();
      paramDate.append("certificate not valid till ");
      paramDate.append(this.c.l().h());
      throw new CertificateNotYetValidException(paramDate.toString());
    }
    paramDate = new StringBuilder();
    paramDate.append("certificate expired on ");
    paramDate.append(this.c.f().h());
    throw new CertificateExpiredException(paramDate.toString());
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof Certificate)) {
      return false;
    }
    paramObject = (Certificate)paramObject;
    try
    {
      boolean bool = org.bouncycastle.util.a.c(getEncoded(), ((Certificate)paramObject).getEncoded());
      return bool;
    }
    catch (CertificateEncodingException paramObject) {}
    return false;
  }
  
  public e getBagAttribute(org.bouncycastle.asn1.m paramm)
  {
    return this.attrCarrier.getBagAttribute(paramm);
  }
  
  public Enumeration getBagAttributeKeys()
  {
    return this.attrCarrier.getBagAttributeKeys();
  }
  
  public int getBasicConstraints()
  {
    g localg = this.basicConstraints;
    if ((localg != null) && (localg.h()))
    {
      if (this.basicConstraints.g() == null) {
        return Integer.MAX_VALUE;
      }
      return this.basicConstraints.g().intValue();
    }
    return -1;
  }
  
  public Set getCriticalExtensionOIDs()
  {
    if (getVersion() == 3)
    {
      HashSet localHashSet = new HashSet();
      org.bouncycastle.asn1.x509.m localm = this.c.o().g();
      if (localm != null)
      {
        Enumeration localEnumeration = localm.m();
        while (localEnumeration.hasMoreElements())
        {
          org.bouncycastle.asn1.m localm1 = (org.bouncycastle.asn1.m)localEnumeration.nextElement();
          if (localm.g(localm1).k()) {
            localHashSet.add(localm1.q());
          }
        }
        return localHashSet;
      }
    }
    return null;
  }
  
  public byte[] getEncoded()
    throws CertificateEncodingException
  {
    try
    {
      byte[] arrayOfByte = this.c.e("DER");
      return arrayOfByte;
    }
    catch (IOException localIOException)
    {
      throw new CertificateEncodingException(localIOException.toString());
    }
  }
  
  public List getExtendedKeyUsage()
    throws CertificateParsingException
  {
    Object localObject1 = getExtensionBytes("2.5.29.37");
    if (localObject1 != null) {
      try
      {
        Object localObject2 = new org/bouncycastle/asn1/i;
        ((org.bouncycastle.asn1.i)localObject2).<init>((byte[])localObject1);
        localObject1 = (r)((org.bouncycastle.asn1.i)localObject2).t();
        localObject2 = new java/util/ArrayList;
        ((ArrayList)localObject2).<init>();
        for (int i = 0; i != ((r)localObject1).size(); i++) {
          ((List)localObject2).add(((org.bouncycastle.asn1.m)((r)localObject1).p(i)).q());
        }
        localObject2 = Collections.unmodifiableList((List)localObject2);
        return (List)localObject2;
      }
      catch (Exception localException)
      {
        throw new CertificateParsingException("error processing extended key usage extension");
      }
    }
    return null;
  }
  
  public byte[] getExtensionValue(String paramString)
  {
    Object localObject = this.c.o().g();
    if (localObject != null)
    {
      paramString = ((org.bouncycastle.asn1.x509.m)localObject).g(new org.bouncycastle.asn1.m(paramString));
      if (paramString != null) {
        try
        {
          paramString = paramString.h().d();
          return paramString;
        }
        catch (Exception paramString)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("error parsing ");
          ((StringBuilder)localObject).append(paramString.toString());
          throw new IllegalStateException(((StringBuilder)localObject).toString());
        }
      }
    }
    return null;
  }
  
  public Collection getIssuerAlternativeNames()
    throws CertificateParsingException
  {
    return getAlternativeNames(getExtensionBytes(org.bouncycastle.asn1.x509.l.y.q()));
  }
  
  public Principal getIssuerDN()
  {
    try
    {
      e.a.a.b localb = new e.a.a.b(org.bouncycastle.asn1.t2.c.f(this.c.h().d()));
      return localb;
    }
    catch (IOException localIOException) {}
    return null;
  }
  
  public boolean[] getIssuerUniqueID()
  {
    Object localObject = this.c.o().j();
    if (localObject != null)
    {
      byte[] arrayOfByte = ((org.bouncycastle.asn1.b)localObject).o();
      int i = arrayOfByte.length * 8 - ((org.bouncycastle.asn1.b)localObject).q();
      localObject = new boolean[i];
      for (int j = 0; j != i; j++)
      {
        int k;
        if ((arrayOfByte[(j / 8)] & 128 >>> j % 8) != 0) {
          k = 1;
        } else {
          k = 0;
        }
        localObject[j] = k;
      }
      return (boolean[])localObject;
    }
    return null;
  }
  
  public X500Principal getIssuerX500Principal()
  {
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new java/io/ByteArrayOutputStream;
      localByteArrayOutputStream.<init>();
      Object localObject = new org/bouncycastle/asn1/p;
      ((p)localObject).<init>(localByteArrayOutputStream);
      ((p)localObject).j(this.c.h());
      localObject = new X500Principal(localByteArrayOutputStream.toByteArray());
      return (X500Principal)localObject;
    }
    catch (IOException localIOException)
    {
      throw new IllegalStateException("can't encode issuer DN");
    }
  }
  
  public boolean[] getKeyUsage()
  {
    return this.keyUsage;
  }
  
  public Set getNonCriticalExtensionOIDs()
  {
    if (getVersion() == 3)
    {
      HashSet localHashSet = new HashSet();
      org.bouncycastle.asn1.x509.m localm = this.c.o().g();
      if (localm != null)
      {
        Enumeration localEnumeration = localm.m();
        while (localEnumeration.hasMoreElements())
        {
          org.bouncycastle.asn1.m localm1 = (org.bouncycastle.asn1.m)localEnumeration.nextElement();
          if (!localm.g(localm1).k()) {
            localHashSet.add(localm1.q());
          }
        }
        return localHashSet;
      }
    }
    return null;
  }
  
  public Date getNotAfter()
  {
    return this.c.f().f();
  }
  
  public Date getNotBefore()
  {
    return this.c.l().f();
  }
  
  public PublicKey getPublicKey()
  {
    try
    {
      PublicKey localPublicKey = BouncyCastleProvider.getPublicKey(this.c.n());
      return localPublicKey;
    }
    catch (IOException localIOException) {}
    return null;
  }
  
  public BigInteger getSerialNumber()
  {
    return this.c.i().p();
  }
  
  public String getSigAlgName()
  {
    Object localObject1 = Security.getProvider("BC");
    if (localObject1 != null)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Alg.Alias.Signature.");
      ((StringBuilder)localObject2).append(getSigAlgOID());
      localObject2 = ((Provider)localObject1).getProperty(((StringBuilder)localObject2).toString());
      if (localObject2 != null) {
        return (String)localObject2;
      }
    }
    Object localObject2 = Security.getProviders();
    for (int i = 0; i != localObject2.length; i++)
    {
      localObject1 = localObject2[i];
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Alg.Alias.Signature.");
      localStringBuilder.append(getSigAlgOID());
      localObject1 = ((Provider)localObject1).getProperty(localStringBuilder.toString());
      if (localObject1 != null) {
        return (String)localObject1;
      }
    }
    return getSigAlgOID();
  }
  
  public String getSigAlgOID()
  {
    return this.c.k().f().q();
  }
  
  public byte[] getSigAlgParams()
  {
    if (this.c.k().i() != null) {}
    try
    {
      byte[] arrayOfByte = this.c.k().i().c().e("DER");
      return arrayOfByte;
    }
    catch (IOException localIOException)
    {
      for (;;) {}
    }
    return null;
  }
  
  public byte[] getSignature()
  {
    return this.c.j().p();
  }
  
  public Collection getSubjectAlternativeNames()
    throws CertificateParsingException
  {
    return getAlternativeNames(getExtensionBytes(org.bouncycastle.asn1.x509.l.x.q()));
  }
  
  public Principal getSubjectDN()
  {
    return new e.a.a.b(org.bouncycastle.asn1.t2.c.f(this.c.m().c()));
  }
  
  public boolean[] getSubjectUniqueID()
  {
    Object localObject = this.c.o().p();
    if (localObject != null)
    {
      byte[] arrayOfByte = ((org.bouncycastle.asn1.b)localObject).o();
      int i = arrayOfByte.length * 8 - ((org.bouncycastle.asn1.b)localObject).q();
      localObject = new boolean[i];
      for (int j = 0; j != i; j++)
      {
        int k;
        if ((arrayOfByte[(j / 8)] & 128 >>> j % 8) != 0) {
          k = 1;
        } else {
          k = 0;
        }
        localObject[j] = k;
      }
      return (boolean[])localObject;
    }
    return null;
  }
  
  public X500Principal getSubjectX500Principal()
  {
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new java/io/ByteArrayOutputStream;
      localByteArrayOutputStream.<init>();
      Object localObject = new org/bouncycastle/asn1/p;
      ((p)localObject).<init>(localByteArrayOutputStream);
      ((p)localObject).j(this.c.m());
      localObject = new X500Principal(localByteArrayOutputStream.toByteArray());
      return (X500Principal)localObject;
    }
    catch (IOException localIOException)
    {
      throw new IllegalStateException("can't encode issuer DN");
    }
  }
  
  public byte[] getTBSCertificate()
    throws CertificateEncodingException
  {
    try
    {
      byte[] arrayOfByte = this.c.o().e("DER");
      return arrayOfByte;
    }
    catch (IOException localIOException)
    {
      throw new CertificateEncodingException(localIOException.toString());
    }
  }
  
  public int getVersion()
  {
    return this.c.p();
  }
  
  public boolean hasUnsupportedCriticalExtension()
  {
    if (getVersion() == 3)
    {
      org.bouncycastle.asn1.x509.m localm = this.c.o().g();
      if (localm != null)
      {
        Enumeration localEnumeration = localm.m();
        while (localEnumeration.hasMoreElements())
        {
          org.bouncycastle.asn1.m localm1 = (org.bouncycastle.asn1.m)localEnumeration.nextElement();
          String str = localm1.q();
          if ((!str.equals(c.n)) && (!str.equals(c.b)) && (!str.equals(c.c)) && (!str.equals(c.d)) && (!str.equals(c.j)) && (!str.equals(c.e)) && (!str.equals(c.g)) && (!str.equals(c.h)) && (!str.equals(c.i)) && (!str.equals(c.k)) && (!str.equals(c.l)) && (localm.g(localm1).k())) {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  public int hashCode()
  {
    try
    {
      if (!this.hashValueSet)
      {
        this.hashValue = calculateHashCode();
        this.hashValueSet = true;
      }
      int i = this.hashValue;
      return i;
    }
    finally {}
  }
  
  public void setBagAttribute(org.bouncycastle.asn1.m paramm, e parame)
  {
    this.attrCarrier.setBagAttribute(paramm, parame);
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    String str = org.bouncycastle.util.i.d();
    localStringBuffer.append("  [0]         Version: ");
    localStringBuffer.append(getVersion());
    localStringBuffer.append(str);
    localStringBuffer.append("         SerialNumber: ");
    localStringBuffer.append(getSerialNumber());
    localStringBuffer.append(str);
    localStringBuffer.append("             IssuerDN: ");
    localStringBuffer.append(getIssuerDN());
    localStringBuffer.append(str);
    localStringBuffer.append("           Start Date: ");
    localStringBuffer.append(getNotBefore());
    localStringBuffer.append(str);
    localStringBuffer.append("           Final Date: ");
    localStringBuffer.append(getNotAfter());
    localStringBuffer.append(str);
    localStringBuffer.append("            SubjectDN: ");
    localStringBuffer.append(getSubjectDN());
    localStringBuffer.append(str);
    localStringBuffer.append("           Public Key: ");
    localStringBuffer.append(getPublicKey());
    localStringBuffer.append(str);
    localStringBuffer.append("  Signature Algorithm: ");
    localStringBuffer.append(getSigAlgName());
    localStringBuffer.append(str);
    Object localObject1 = getSignature();
    localStringBuffer.append("            Signature: ");
    localStringBuffer.append(new String(org.bouncycastle.util.encoders.d.c((byte[])localObject1, 0, 20)));
    localStringBuffer.append(str);
    Object localObject2;
    for (int i = 20; i < localObject1.length; i += 20)
    {
      int j = localObject1.length;
      localStringBuffer.append("                       ");
      if (i < j - 20) {
        localObject2 = new String(org.bouncycastle.util.encoders.d.c((byte[])localObject1, i, 20));
      } else {
        localObject2 = new String(org.bouncycastle.util.encoders.d.c((byte[])localObject1, i, localObject1.length - i));
      }
      localStringBuffer.append((String)localObject2);
      localStringBuffer.append(str);
    }
    org.bouncycastle.asn1.x509.m localm = this.c.o().g();
    if (localm != null)
    {
      Enumeration localEnumeration = localm.m();
      if (localEnumeration.hasMoreElements()) {
        localStringBuffer.append("       Extensions: \n");
      }
      while (localEnumeration.hasMoreElements())
      {
        localObject1 = (org.bouncycastle.asn1.m)localEnumeration.nextElement();
        org.bouncycastle.asn1.x509.l locall = localm.g((org.bouncycastle.asn1.m)localObject1);
        if (locall.h() != null)
        {
          localObject2 = new org.bouncycastle.asn1.i(locall.h().o());
          localStringBuffer.append("                       critical(");
          localStringBuffer.append(locall.k());
          localStringBuffer.append(") ");
          try
          {
            if (((q)localObject1).equals(org.bouncycastle.asn1.x509.l.z))
            {
              localObject2 = g.f(((org.bouncycastle.asn1.i)localObject2).t());
              label468:
              localStringBuffer.append(localObject2);
            }
            for (;;)
            {
              localStringBuffer.append(str);
              break;
              if (((q)localObject1).equals(org.bouncycastle.asn1.x509.l.f))
              {
                localObject2 = t.h(((org.bouncycastle.asn1.i)localObject2).t());
                break label468;
              }
              if (((q)localObject1).equals(org.bouncycastle.asn1.i2.a.b))
              {
                localObject2 = new org.bouncycastle.asn1.i2.b((n0)((org.bouncycastle.asn1.i)localObject2).t());
                break label468;
              }
              if (((q)localObject1).equals(org.bouncycastle.asn1.i2.a.d))
              {
                localObject2 = new org.bouncycastle.asn1.i2.c((u0)((org.bouncycastle.asn1.i)localObject2).t());
                break label468;
              }
              if (((q)localObject1).equals(org.bouncycastle.asn1.i2.a.k))
              {
                localObject2 = new org.bouncycastle.asn1.i2.d((u0)((org.bouncycastle.asn1.i)localObject2).t());
                break label468;
              }
              localStringBuffer.append(((org.bouncycastle.asn1.m)localObject1).q());
              localStringBuffer.append(" value = ");
              localStringBuffer.append(org.bouncycastle.asn1.s2.a.c(((org.bouncycastle.asn1.i)localObject2).t()));
            }
            localStringBuffer.append(str);
          }
          catch (Exception localException)
          {
            localStringBuffer.append(((org.bouncycastle.asn1.m)localObject1).q());
            localStringBuffer.append(" value = ");
            localStringBuffer.append("*****");
          }
        }
      }
    }
    return localStringBuffer.toString();
  }
  
  public final void verify(PublicKey paramPublicKey)
    throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException
  {
    String str = d.b(this.c.k());
    Signature localSignature2;
    try
    {
      Signature localSignature1 = Signature.getInstance(str, "BC");
    }
    catch (Exception localException)
    {
      localSignature2 = Signature.getInstance(str);
    }
    checkSignature(paramPublicKey, localSignature2);
  }
  
  public final void verify(PublicKey paramPublicKey, String paramString)
    throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException
  {
    String str = d.b(this.c.k());
    if (paramString != null) {
      paramString = Signature.getInstance(str, paramString);
    } else {
      paramString = Signature.getInstance(str);
    }
    checkSignature(paramPublicKey, paramString);
  }
  
  public final void verify(PublicKey paramPublicKey, Provider paramProvider)
    throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, SignatureException
  {
    String str = d.b(this.c.k());
    if (paramProvider != null) {
      paramProvider = Signature.getInstance(str, paramProvider);
    } else {
      paramProvider = Signature.getInstance(str);
    }
    checkSignature(paramPublicKey, paramProvider);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\jce\provider\X509CertificateObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */