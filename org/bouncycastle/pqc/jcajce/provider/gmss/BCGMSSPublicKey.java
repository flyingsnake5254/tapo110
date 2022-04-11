package org.bouncycastle.pqc.jcajce.provider.gmss;

import e.a.c.a.f;
import e.a.c.b.a.b;
import e.a.c.b.a.c;
import java.security.PublicKey;
import org.bouncycastle.util.encoders.d;

public class BCGMSSPublicKey
  implements org.bouncycastle.crypto.e, PublicKey
{
  private static final long serialVersionUID = 1L;
  private b gmssParameterSet;
  private b gmssParams;
  private byte[] publicKeyBytes;
  
  public BCGMSSPublicKey(c paramc) {}
  
  public BCGMSSPublicKey(byte[] paramArrayOfByte, b paramb)
  {
    this.publicKeyBytes = paramArrayOfByte;
  }
  
  public String getAlgorithm()
  {
    return "GMSS";
  }
  
  public byte[] getEncoded()
  {
    Object localObject = e.a.c.a.e.g;
    localObject = new e/a/c/a/f;
    throw null;
  }
  
  public String getFormat()
  {
    return "X.509";
  }
  
  public b getParameterSet()
  {
    return this.gmssParameterSet;
  }
  
  public byte[] getPublicKeyBytes()
  {
    return this.publicKeyBytes;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GMSS public key : ");
    localStringBuilder.append(new String(d.b(this.publicKeyBytes)));
    localStringBuilder.append("\nHeight of Trees: \n");
    localStringBuilder.toString();
    throw null;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\pqc\jcajce\provider\gmss\BCGMSSPublicKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */