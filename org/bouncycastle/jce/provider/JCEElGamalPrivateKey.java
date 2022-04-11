package org.bouncycastle.jce.provider;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.util.Enumeration;
import javax.crypto.interfaces.DHPrivateKey;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.DHPrivateKeySpec;
import org.bouncycastle.asn1.e;
import org.bouncycastle.asn1.j;
import org.bouncycastle.asn1.m;
import org.bouncycastle.crypto.w.v;
import org.bouncycastle.jcajce.provider.asymmetric.util.c;
import org.bouncycastle.jcajce.provider.asymmetric.util.d;
import org.bouncycastle.jce.interfaces.ElGamalPrivateKey;
import org.bouncycastle.jce.spec.i;

public class JCEElGamalPrivateKey
  implements ElGamalPrivateKey, DHPrivateKey, org.bouncycastle.jce.interfaces.b
{
  static final long serialVersionUID = 4819350091141529678L;
  private d attrCarrier = new d();
  org.bouncycastle.jce.spec.h elSpec;
  BigInteger x;
  
  protected JCEElGamalPrivateKey() {}
  
  JCEElGamalPrivateKey(DHPrivateKey paramDHPrivateKey)
  {
    this.x = paramDHPrivateKey.getX();
    this.elSpec = new org.bouncycastle.jce.spec.h(paramDHPrivateKey.getParams().getP(), paramDHPrivateKey.getParams().getG());
  }
  
  JCEElGamalPrivateKey(DHPrivateKeySpec paramDHPrivateKeySpec)
  {
    this.x = paramDHPrivateKeySpec.getX();
    this.elSpec = new org.bouncycastle.jce.spec.h(paramDHPrivateKeySpec.getP(), paramDHPrivateKeySpec.getG());
  }
  
  JCEElGamalPrivateKey(org.bouncycastle.asn1.n2.h paramh)
    throws IOException
  {
    org.bouncycastle.asn1.m2.a locala = org.bouncycastle.asn1.m2.a.g(paramh.h().i());
    this.x = j.m(paramh.i()).p();
    this.elSpec = new org.bouncycastle.jce.spec.h(locala.h(), locala.f());
  }
  
  JCEElGamalPrivateKey(v paramv)
  {
    throw null;
  }
  
  JCEElGamalPrivateKey(ElGamalPrivateKey paramElGamalPrivateKey)
  {
    this.x = paramElGamalPrivateKey.getX();
    this.elSpec = paramElGamalPrivateKey.getParameters();
  }
  
  JCEElGamalPrivateKey(i parami)
  {
    throw null;
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    this.x = ((BigInteger)paramObjectInputStream.readObject());
    this.elSpec = new org.bouncycastle.jce.spec.h((BigInteger)paramObjectInputStream.readObject(), (BigInteger)paramObjectInputStream.readObject());
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.writeObject(getX());
    paramObjectOutputStream.writeObject(this.elSpec.b());
    paramObjectOutputStream.writeObject(this.elSpec.a());
  }
  
  public String getAlgorithm()
  {
    return "ElGamal";
  }
  
  public e getBagAttribute(m paramm)
  {
    return this.attrCarrier.getBagAttribute(paramm);
  }
  
  public Enumeration getBagAttributeKeys()
  {
    return this.attrCarrier.getBagAttributeKeys();
  }
  
  public byte[] getEncoded()
  {
    return c.b(new org.bouncycastle.asn1.x509.a(org.bouncycastle.asn1.m2.b.l, new org.bouncycastle.asn1.m2.a(this.elSpec.b(), this.elSpec.a())), new j(getX()));
  }
  
  public String getFormat()
  {
    return "PKCS#8";
  }
  
  public org.bouncycastle.jce.spec.h getParameters()
  {
    return this.elSpec;
  }
  
  public DHParameterSpec getParams()
  {
    return new DHParameterSpec(this.elSpec.b(), this.elSpec.a());
  }
  
  public BigInteger getX()
  {
    return this.x;
  }
  
  public void setBagAttribute(m paramm, e parame)
  {
    this.attrCarrier.setBagAttribute(paramm, parame);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\jce\provider\JCEElGamalPrivateKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */