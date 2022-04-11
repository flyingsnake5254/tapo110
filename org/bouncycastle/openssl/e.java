package org.bouncycastle.openssl;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import org.bouncycastle.asn1.m;
import org.bouncycastle.asn1.n2.g;
import org.bouncycastle.asn1.n2.h;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.r;
import org.bouncycastle.asn1.u2.p;
import org.bouncycastle.asn1.v0;
import org.bouncycastle.asn1.x509.w;
import org.bouncycastle.cert.X509AttributeCertificateHolder;
import org.bouncycastle.cert.X509CRLHolder;
import org.bouncycastle.cert.X509CertificateHolder;

public class e
  extends org.bouncycastle.util.io.pem.e
{
  private final Map c;
  
  public e(Reader paramReader)
  {
    super(paramReader);
    paramReader = new HashMap();
    this.c = paramReader;
    paramReader.put("CERTIFICATE REQUEST", new g(null));
    paramReader.put("NEW CERTIFICATE REQUEST", new g(null));
    paramReader.put("CERTIFICATE", new o(null));
    paramReader.put("TRUSTED CERTIFICATE", new p(null));
    paramReader.put("X509 CERTIFICATE", new o(null));
    paramReader.put("X509 CRL", new n(null));
    paramReader.put("PKCS7", new h(null));
    paramReader.put("CMS", new h(null));
    paramReader.put("ATTRIBUTE CERTIFICATE", new m(null));
    paramReader.put("EC PARAMETERS", new c(null));
    paramReader.put("PUBLIC KEY", new j());
    paramReader.put("RSA PUBLIC KEY", new l());
    paramReader.put("RSA PRIVATE KEY", new f(new k(null)));
    paramReader.put("DSA PRIVATE KEY", new f(new b(null)));
    paramReader.put("EC PRIVATE KEY", new f(new d(null)));
    paramReader.put("ENCRYPTED PRIVATE KEY", new e());
    paramReader.put("PRIVATE KEY", new i());
  }
  
  public Object readObject()
    throws IOException
  {
    Object localObject = c();
    if (localObject != null)
    {
      String str = ((org.bouncycastle.util.io.pem.b)localObject).d();
      if (this.c.containsKey(str)) {
        return ((org.bouncycastle.util.io.pem.d)this.c.get(str)).a((org.bouncycastle.util.io.pem.b)localObject);
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("unrecognised object: ");
      ((StringBuilder)localObject).append(str);
      throw new IOException(((StringBuilder)localObject).toString());
    }
    return null;
  }
  
  private class b
    implements d
  {
    private b() {}
    
    public c a(byte[] paramArrayOfByte)
      throws IOException
    {
      try
      {
        Object localObject1 = r.m(paramArrayOfByte);
        if (((r)localObject1).size() == 6)
        {
          org.bouncycastle.asn1.j localj = org.bouncycastle.asn1.j.m(((r)localObject1).p(1));
          paramArrayOfByte = org.bouncycastle.asn1.j.m(((r)localObject1).p(2));
          localObject2 = org.bouncycastle.asn1.j.m(((r)localObject1).p(3));
          Object localObject3 = org.bouncycastle.asn1.j.m(((r)localObject1).p(4));
          localObject1 = org.bouncycastle.asn1.j.m(((r)localObject1).p(5));
          w localw = new org/bouncycastle/asn1/x509/w;
          Object localObject4 = new org/bouncycastle/asn1/x509/a;
          m localm = p.l3;
          Object localObject5 = new org/bouncycastle/asn1/x509/j;
          ((org.bouncycastle.asn1.x509.j)localObject5).<init>(localj.p(), paramArrayOfByte.p(), ((org.bouncycastle.asn1.j)localObject2).p());
          ((org.bouncycastle.asn1.x509.a)localObject4).<init>(localm, (org.bouncycastle.asn1.e)localObject5);
          localw.<init>((org.bouncycastle.asn1.x509.a)localObject4, (org.bouncycastle.asn1.e)localObject3);
          localObject5 = new org/bouncycastle/asn1/n2/h;
          localObject3 = new org/bouncycastle/asn1/x509/a;
          localObject4 = new org/bouncycastle/asn1/x509/j;
          ((org.bouncycastle.asn1.x509.j)localObject4).<init>(localj.p(), paramArrayOfByte.p(), ((org.bouncycastle.asn1.j)localObject2).p());
          ((org.bouncycastle.asn1.x509.a)localObject3).<init>(localm, (org.bouncycastle.asn1.e)localObject4);
          ((h)localObject5).<init>((org.bouncycastle.asn1.x509.a)localObject3, (org.bouncycastle.asn1.e)localObject1);
          return new c(localw, (h)localObject5);
        }
        paramArrayOfByte = new org/bouncycastle/openssl/PEMException;
        paramArrayOfByte.<init>("malformed sequence in DSA private key");
        throw paramArrayOfByte;
      }
      catch (Exception paramArrayOfByte)
      {
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("problem creating DSA private key: ");
        ((StringBuilder)localObject2).append(paramArrayOfByte.toString());
        throw new PEMException(((StringBuilder)localObject2).toString(), paramArrayOfByte);
      }
      catch (IOException paramArrayOfByte)
      {
        throw paramArrayOfByte;
      }
    }
  }
  
  private class c
    implements org.bouncycastle.util.io.pem.d
  {
    private c() {}
    
    public Object a(org.bouncycastle.util.io.pem.b paramb)
      throws IOException
    {
      try
      {
        q localq = q.i(paramb.b());
        if ((localq instanceof m)) {
          return q.i(paramb.b());
        }
        if ((localq instanceof r))
        {
          paramb = org.bouncycastle.asn1.u2.j.i(localq);
          return paramb;
        }
        return null;
      }
      catch (Exception localException)
      {
        paramb = new StringBuilder();
        paramb.append("exception extracting EC named curve: ");
        paramb.append(localException.toString());
        throw new PEMException(paramb.toString());
      }
      catch (IOException paramb)
      {
        throw paramb;
      }
    }
  }
  
  private class d
    implements d
  {
    private d() {}
    
    public c a(byte[] paramArrayOfByte)
      throws IOException
    {
      try
      {
        paramArrayOfByte = org.bouncycastle.asn1.p2.a.f(r.m(paramArrayOfByte));
        org.bouncycastle.asn1.x509.a locala = new org/bouncycastle/asn1/x509/a;
        locala.<init>(p.B2, paramArrayOfByte.i());
        h localh = new org/bouncycastle/asn1/n2/h;
        localh.<init>(locala, paramArrayOfByte);
        if (paramArrayOfByte.j() != null)
        {
          w localw = new org/bouncycastle/asn1/x509/w;
          localw.<init>(locala, paramArrayOfByte.j().o());
          return new c(localw, localh);
        }
        paramArrayOfByte = new c(null, localh);
        return paramArrayOfByte;
      }
      catch (Exception localException)
      {
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("problem creating EC private key: ");
        paramArrayOfByte.append(localException.toString());
        throw new PEMException(paramArrayOfByte.toString(), localException);
      }
      catch (IOException paramArrayOfByte)
      {
        throw paramArrayOfByte;
      }
    }
  }
  
  private class e
    implements org.bouncycastle.util.io.pem.d
  {
    public e() {}
    
    public Object a(org.bouncycastle.util.io.pem.b paramb)
      throws IOException
    {
      try
      {
        paramb = new org.bouncycastle.pkcs.b(org.bouncycastle.asn1.n2.f.f(paramb.b()));
        return paramb;
      }
      catch (Exception paramb)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("problem parsing ENCRYPTED PRIVATE KEY: ");
        localStringBuilder.append(paramb.toString());
        throw new PEMException(localStringBuilder.toString(), paramb);
      }
    }
  }
  
  private class f
    implements org.bouncycastle.util.io.pem.d
  {
    private final d a;
    
    public f(d paramd)
    {
      this.a = paramd;
    }
    
    public Object a(org.bouncycastle.util.io.pem.b paramb)
      throws IOException
    {
      Object localObject = paramb.c().iterator();
      i = 0;
      String str = null;
      while (((Iterator)localObject).hasNext())
      {
        org.bouncycastle.util.io.pem.a locala = (org.bouncycastle.util.io.pem.a)((Iterator)localObject).next();
        if ((locala.b().equals("Proc-Type")) && (locala.c().equals("4,ENCRYPTED"))) {
          i = 1;
        } else if (locala.b().equals("DEK-Info")) {
          str = locala.c();
        }
      }
      paramb = paramb.b();
      if (i != 0) {}
      try
      {
        localObject = new java/util/StringTokenizer;
        ((StringTokenizer)localObject).<init>(str, ",");
        return new b(((StringTokenizer)localObject).nextToken(), org.bouncycastle.util.encoders.d.a(((StringTokenizer)localObject).nextToken()), paramb, this.a);
      }
      catch (IllegalArgumentException paramb)
      {
        if (i == 0) {
          break label163;
        }
        throw new PEMException("exception decoding - please check password and data.", paramb);
        throw new PEMException(paramb.getMessage(), paramb);
      }
      catch (IOException paramb)
      {
        if (i == 0) {
          break label192;
        }
        throw new PEMException("exception decoding - please check password and data.", paramb);
        throw new PEMException(paramb.getMessage(), paramb);
      }
      paramb = this.a.a(paramb);
      return paramb;
    }
  }
  
  private class g
    implements org.bouncycastle.util.io.pem.d
  {
    private g() {}
    
    public Object a(org.bouncycastle.util.io.pem.b paramb)
      throws IOException
    {
      try
      {
        paramb = new org.bouncycastle.pkcs.a(paramb.b());
        return paramb;
      }
      catch (Exception localException)
      {
        paramb = new StringBuilder();
        paramb.append("problem parsing certrequest: ");
        paramb.append(localException.toString());
        throw new PEMException(paramb.toString(), localException);
      }
    }
  }
  
  private class h
    implements org.bouncycastle.util.io.pem.d
  {
    private h() {}
    
    public Object a(org.bouncycastle.util.io.pem.b paramb)
      throws IOException
    {
      try
      {
        org.bouncycastle.asn1.i locali = new org/bouncycastle/asn1/i;
        locali.<init>(paramb.b());
        paramb = org.bouncycastle.asn1.c2.b.f(locali.t());
        return paramb;
      }
      catch (Exception localException)
      {
        paramb = new StringBuilder();
        paramb.append("problem parsing PKCS7 object: ");
        paramb.append(localException.toString());
        throw new PEMException(paramb.toString(), localException);
      }
    }
  }
  
  private class i
    implements org.bouncycastle.util.io.pem.d
  {
    public i() {}
    
    public Object a(org.bouncycastle.util.io.pem.b paramb)
      throws IOException
    {
      try
      {
        paramb = h.g(paramb.b());
        return paramb;
      }
      catch (Exception paramb)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("problem parsing PRIVATE KEY: ");
        localStringBuilder.append(paramb.toString());
        throw new PEMException(localStringBuilder.toString(), paramb);
      }
    }
  }
  
  private class j
    implements org.bouncycastle.util.io.pem.d
  {
    public j() {}
    
    public Object a(org.bouncycastle.util.io.pem.b paramb)
      throws IOException
    {
      return w.h(paramb.b());
    }
  }
  
  private class k
    implements d
  {
    private k() {}
    
    public c a(byte[] paramArrayOfByte)
      throws IOException
    {
      try
      {
        paramArrayOfByte = r.m(paramArrayOfByte);
        if (paramArrayOfByte.size() == 9)
        {
          paramArrayOfByte = org.bouncycastle.asn1.n2.i.i(paramArrayOfByte);
          Object localObject = new org/bouncycastle/asn1/n2/j;
          ((org.bouncycastle.asn1.n2.j)localObject).<init>(paramArrayOfByte.j(), paramArrayOfByte.n());
          org.bouncycastle.asn1.x509.a locala = new org/bouncycastle/asn1/x509/a;
          locala.<init>(g.B, v0.c);
          w localw = new org/bouncycastle/asn1/x509/w;
          localw.<init>(locala, (org.bouncycastle.asn1.e)localObject);
          localObject = new org/bouncycastle/asn1/n2/h;
          ((h)localObject).<init>(locala, paramArrayOfByte);
          return new c(localw, (h)localObject);
        }
        paramArrayOfByte = new org/bouncycastle/openssl/PEMException;
        paramArrayOfByte.<init>("malformed sequence in RSA private key");
        throw paramArrayOfByte;
      }
      catch (Exception localException)
      {
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("problem creating RSA private key: ");
        paramArrayOfByte.append(localException.toString());
        throw new PEMException(paramArrayOfByte.toString(), localException);
      }
      catch (IOException paramArrayOfByte)
      {
        throw paramArrayOfByte;
      }
    }
  }
  
  private class l
    implements org.bouncycastle.util.io.pem.d
  {
    public l() {}
    
    public Object a(org.bouncycastle.util.io.pem.b paramb)
      throws IOException
    {
      try
      {
        localObject = org.bouncycastle.asn1.n2.j.f(paramb.b());
        paramb = new org/bouncycastle/asn1/x509/a;
        paramb.<init>(g.B, v0.c);
        paramb = new w(paramb, (org.bouncycastle.asn1.e)localObject);
        return paramb;
      }
      catch (Exception paramb)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("problem extracting key: ");
        ((StringBuilder)localObject).append(paramb.toString());
        throw new PEMException(((StringBuilder)localObject).toString(), paramb);
      }
      catch (IOException paramb)
      {
        throw paramb;
      }
    }
  }
  
  private class m
    implements org.bouncycastle.util.io.pem.d
  {
    private m() {}
    
    public Object a(org.bouncycastle.util.io.pem.b paramb)
      throws IOException
    {
      return new X509AttributeCertificateHolder(paramb.b());
    }
  }
  
  private class n
    implements org.bouncycastle.util.io.pem.d
  {
    private n() {}
    
    public Object a(org.bouncycastle.util.io.pem.b paramb)
      throws IOException
    {
      try
      {
        paramb = new X509CRLHolder(paramb.b());
        return paramb;
      }
      catch (Exception paramb)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("problem parsing cert: ");
        localStringBuilder.append(paramb.toString());
        throw new PEMException(localStringBuilder.toString(), paramb);
      }
    }
  }
  
  private class o
    implements org.bouncycastle.util.io.pem.d
  {
    private o() {}
    
    public Object a(org.bouncycastle.util.io.pem.b paramb)
      throws IOException
    {
      try
      {
        paramb = new X509CertificateHolder(paramb.b());
        return paramb;
      }
      catch (Exception paramb)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("problem parsing cert: ");
        localStringBuilder.append(paramb.toString());
        throw new PEMException(localStringBuilder.toString(), paramb);
      }
    }
  }
  
  private class p
    implements org.bouncycastle.util.io.pem.d
  {
    private p() {}
    
    public Object a(org.bouncycastle.util.io.pem.b paramb)
      throws IOException
    {
      try
      {
        paramb = new f(paramb.b());
        return paramb;
      }
      catch (Exception paramb)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("problem parsing cert: ");
        localStringBuilder.append(paramb.toString());
        throw new PEMException(localStringBuilder.toString(), paramb);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\openssl\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */