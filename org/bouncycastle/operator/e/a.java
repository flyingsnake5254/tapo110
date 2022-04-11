package org.bouncycastle.operator.e;

import java.io.IOException;
import java.io.OutputStream;
import java.security.GeneralSecurityException;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.operator.OperatorStreamException;
import org.bouncycastle.operator.RuntimeOperatorException;
import org.bouncycastle.operator.d;

public class a
{
  private b a = new b(new org.bouncycastle.jcajce.a.b());
  private SecureRandom b;
  private String c;
  private org.bouncycastle.asn1.x509.a d;
  private AlgorithmParameterSpec e;
  
  public a(String paramString)
  {
    this.c = paramString;
    this.d = new d().b(paramString);
    this.e = null;
  }
  
  public org.bouncycastle.operator.a a(PrivateKey paramPrivateKey)
    throws OperatorCreationException
  {
    try
    {
      final Signature localSignature = this.a.b(this.d);
      final org.bouncycastle.asn1.x509.a locala = this.d;
      SecureRandom localSecureRandom = this.b;
      if (localSecureRandom != null) {
        localSignature.initSign(paramPrivateKey, localSecureRandom);
      } else {
        localSignature.initSign(paramPrivateKey);
      }
      paramPrivateKey = new a(localSignature, locala);
      return paramPrivateKey;
    }
    catch (GeneralSecurityException localGeneralSecurityException)
    {
      paramPrivateKey = new StringBuilder();
      paramPrivateKey.append("cannot create signer: ");
      paramPrivateKey.append(localGeneralSecurityException.getMessage());
      throw new OperatorCreationException(paramPrivateKey.toString(), localGeneralSecurityException);
    }
  }
  
  class a
    implements org.bouncycastle.operator.a
  {
    private a.b a;
    
    a(Signature paramSignature, org.bouncycastle.asn1.x509.a parama)
    {
      this.a = new a.b(a.this, paramSignature);
    }
    
    public org.bouncycastle.asn1.x509.a a()
    {
      return locala;
    }
    
    public byte[] b()
    {
      try
      {
        byte[] arrayOfByte = this.a.a();
        return arrayOfByte;
      }
      catch (SignatureException localSignatureException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("exception obtaining signature: ");
        localStringBuilder.append(localSignatureException.getMessage());
        throw new RuntimeOperatorException(localStringBuilder.toString(), localSignatureException);
      }
    }
    
    public OutputStream getOutputStream()
    {
      return this.a;
    }
  }
  
  private class b
    extends OutputStream
  {
    private Signature c;
    
    b(Signature paramSignature)
    {
      this.c = paramSignature;
    }
    
    byte[] a()
      throws SignatureException
    {
      return this.c.sign();
    }
    
    public void write(int paramInt)
      throws IOException
    {
      try
      {
        this.c.update((byte)paramInt);
        return;
      }
      catch (SignatureException localSignatureException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("exception in content signer: ");
        localStringBuilder.append(localSignatureException.getMessage());
        throw new OperatorStreamException(localStringBuilder.toString(), localSignatureException);
      }
    }
    
    public void write(byte[] paramArrayOfByte)
      throws IOException
    {
      try
      {
        this.c.update(paramArrayOfByte);
        return;
      }
      catch (SignatureException paramArrayOfByte)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("exception in content signer: ");
        localStringBuilder.append(paramArrayOfByte.getMessage());
        throw new OperatorStreamException(localStringBuilder.toString(), paramArrayOfByte);
      }
    }
    
    public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      try
      {
        this.c.update(paramArrayOfByte, paramInt1, paramInt2);
        return;
      }
      catch (SignatureException paramArrayOfByte)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("exception in content signer: ");
        localStringBuilder.append(paramArrayOfByte.getMessage());
        throw new OperatorStreamException(localStringBuilder.toString(), paramArrayOfByte);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\operator\e\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */