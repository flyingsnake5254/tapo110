package com.tplink.libtpanalytics.utils.l;

import android.util.Base64;
import android.util.Log;
import b.d.c.c.c;
import java.math.BigInteger;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.MGF1ParameterSpec;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource.PSpecified;

public class d
  implements c
{
  private static final String a = "d";
  private int b;
  private int c;
  private int d;
  private PrivateKey e;
  private PublicKey f;
  private String g;
  private Cipher h;
  private Cipher i;
  
  private byte[] m(byte[] paramArrayOfByte, Cipher paramCipher)
    throws Exception
  {
    return paramCipher.doFinal(paramArrayOfByte);
  }
  
  public String a(String paramString)
  {
    try
    {
      paramString = o(paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  public byte[] n(byte[] paramArrayOfByte)
    throws Exception
  {
    try
    {
      int j = paramArrayOfByte.length;
      if (j <= this.c)
      {
        paramArrayOfByte = m(paramArrayOfByte, this.h);
        return paramArrayOfByte;
      }
      Object localObject = new java/util/ArrayList;
      ((ArrayList)localObject).<init>(2048);
      int k = 0;
      int m = 0;
      for (;;)
      {
        int n = j - m;
        if (n <= 0) {
          break;
        }
        int i1 = this.c;
        if (n > i1)
        {
          arrayOfByte = new byte[i1];
          System.arraycopy(paramArrayOfByte, m, arrayOfByte, 0, i1);
          arrayOfByte = m(arrayOfByte, this.h);
          n = arrayOfByte.length;
          for (i1 = 0; i1 < n; i1++) {
            ((List)localObject).add(Byte.valueOf(arrayOfByte[i1]));
          }
        }
        byte[] arrayOfByte = new byte[n];
        System.arraycopy(paramArrayOfByte, m, arrayOfByte, 0, n);
        arrayOfByte = m(arrayOfByte, this.h);
        n = arrayOfByte.length;
        for (i1 = 0; i1 < n; i1++) {
          ((List)localObject).add(Byte.valueOf(arrayOfByte[i1]));
        }
        m += this.c;
      }
      paramArrayOfByte = new byte[((List)localObject).size()];
      localObject = ((List)localObject).iterator();
      for (m = k; ((Iterator)localObject).hasNext(); m++) {
        paramArrayOfByte[m] = ((Byte)((Iterator)localObject).next()).byteValue();
      }
      return paramArrayOfByte;
    }
    finally {}
  }
  
  public String o(String paramString)
    throws Exception
  {
    try
    {
      byte[] arrayOfByte1 = paramString.getBytes("UTF8");
      int j = arrayOfByte1.length;
      if (j <= this.c)
      {
        paramString = Base64.encodeToString(m(arrayOfByte1, this.h), 2);
        return paramString;
      }
      paramString = new java/util/ArrayList;
      paramString.<init>(2048);
      int k = 0;
      int m = 0;
      for (;;)
      {
        int n = j - m;
        if (n <= 0) {
          break;
        }
        int i1 = this.c;
        if (n > i1)
        {
          arrayOfByte2 = new byte[i1];
          System.arraycopy(arrayOfByte1, m, arrayOfByte2, 0, i1);
          arrayOfByte2 = m(arrayOfByte2, this.h);
          i1 = arrayOfByte2.length;
          for (n = 0; n < i1; n++) {
            paramString.add(Byte.valueOf(arrayOfByte2[n]));
          }
        }
        byte[] arrayOfByte2 = new byte[n];
        System.arraycopy(arrayOfByte1, m, arrayOfByte2, 0, n);
        arrayOfByte2 = m(arrayOfByte2, this.h);
        i1 = arrayOfByte2.length;
        for (n = 0; n < i1; n++) {
          paramString.add(Byte.valueOf(arrayOfByte2[n]));
        }
        m += this.c;
      }
      arrayOfByte1 = new byte[paramString.size()];
      paramString = paramString.iterator();
      for (m = k; paramString.hasNext(); m++) {
        arrayOfByte1[m] = ((Byte)paramString.next()).byteValue();
      }
      paramString = Base64.encodeToString(arrayOfByte1, 2);
      return paramString;
    }
    finally {}
  }
  
  public static class b
  {
    private PublicKey a;
    private PrivateKey b;
    private String c;
    private int d;
    private int e;
    private int f;
    
    private int b(PrivateKey paramPrivateKey)
    {
      int i = 1024;
      try
      {
        int j = ((RSAPrivateKey)paramPrivateKey).getModulus().bitLength();
        i = j;
        paramPrivateKey = d.l();
        i = j;
        StringBuilder localStringBuilder = new java/lang/StringBuilder;
        i = j;
        localStringBuilder.<init>();
        i = j;
        localStringBuilder.append("From private keylength is:");
        i = j;
        localStringBuilder.append(j);
        i = j;
        Log.d(paramPrivateKey, localStringBuilder.toString());
        i = j;
      }
      catch (Exception paramPrivateKey)
      {
        paramPrivateKey.printStackTrace();
      }
      return i;
    }
    
    private int c(PublicKey paramPublicKey)
    {
      int i = 1024;
      try
      {
        int j = ((RSAPublicKey)paramPublicKey).getModulus().bitLength();
        i = j;
        paramPublicKey = d.l();
        i = j;
        StringBuilder localStringBuilder = new java/lang/StringBuilder;
        i = j;
        localStringBuilder.<init>();
        i = j;
        localStringBuilder.append("keylength is:");
        i = j;
        localStringBuilder.append(j);
        i = j;
        Log.d(paramPublicKey, localStringBuilder.toString());
        i = j;
      }
      catch (Exception paramPublicKey)
      {
        paramPublicKey.printStackTrace();
      }
      return i;
    }
    
    private void d(d paramd)
    {
      Object localObject = this.a;
      if (localObject != null) {
        this.d = c((PublicKey)localObject);
      } else {
        this.d = b(this.b);
      }
      localObject = this.c;
      if ((localObject != null) && (!((String)localObject).equals("")))
      {
        g(this.c);
      }
      else
      {
        this.c = "RSA/ECB/PKCS1Padding";
        this.e = (this.d / 8 - 11);
      }
      this.f = (this.d / 8);
      d.b(paramd, this.a);
      d.c(paramd, this.b);
      d.d(paramd, this.d);
      d.e(paramd, this.e);
      d.f(paramd, this.f);
      d.g(paramd, this.c);
      try
      {
        localObject = this.a;
        if ((localObject != null) && (!localObject.equals("")))
        {
          d.i(paramd, Cipher.getInstance(this.c));
          f(d.h(paramd), this.a);
        }
        localObject = this.b;
        if ((localObject != null) && (!localObject.equals(""))) {
          if ((!this.c.equals("RSA/ECB/NoPadding")) && (!this.c.equals("RSA/NONE/NoPadding")))
          {
            d.k(paramd, Cipher.getInstance(this.c));
            e(d.j(paramd), this.b);
          }
          else
          {
            d.k(paramd, Cipher.getInstance("RSA"));
            e(d.j(paramd), this.b);
          }
        }
      }
      catch (Exception paramd)
      {
        paramd.printStackTrace();
      }
    }
    
    private void e(Cipher paramCipher, PrivateKey paramPrivateKey)
      throws Exception
    {
      if ((!this.c.equals("RSA/ECB/PKCS1Padding")) && (!this.c.equals("RSA/ECB/OAEPPadding")) && (!this.c.equals("RSA/ECB/NoPadding")) && (!this.c.equals("RSA/NONE/PKCS1Padding")) && (!this.c.equals("RSA/NONE/OAEPPadding")) && (!this.c.equals("RSA/NONE/NoPadding")))
      {
        if ((!this.c.equals("RSA/ECB/OAEPWithSHA-256AndMGF1Padding")) && (!this.c.equals("RSA/NONE/OAEPWithSHA-256AndMGF1Padding")))
        {
          if ((this.c.equals("RSA/ECB/OAEPWithSHA-1AndMGF1Padding")) || (this.c.equals("RSA/NONE/OAEPWithSHA-1AndMGF1Padding"))) {
            paramCipher.init(2, paramPrivateKey);
          }
        }
        else {
          paramCipher.init(2, paramPrivateKey, new OAEPParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, PSource.PSpecified.DEFAULT));
        }
      }
      else {
        paramCipher.init(2, paramPrivateKey);
      }
    }
    
    private void f(Cipher paramCipher, PublicKey paramPublicKey)
      throws Exception
    {
      if ((!this.c.equals("RSA/ECB/PKCS1Padding")) && (!this.c.equals("RSA/ECB/OAEPPadding")) && (!this.c.equals("RSA/ECB/NoPadding")) && (!this.c.equals("RSA/NONE/PKCS1Padding")) && (!this.c.equals("RSA/NONE/OAEPPadding")) && (!this.c.equals("RSA/NONE/NoPadding")))
      {
        if ((!this.c.equals("RSA/ECB/OAEPWithSHA-256AndMGF1Padding")) && (!this.c.equals("RSA/NONE/OAEPWithSHA-256AndMGF1Padding")))
        {
          if ((this.c.equals("RSA/ECB/OAEPWithSHA-1AndMGF1Padding")) || (this.c.equals("RSA/NONE/OAEPWithSHA-1AndMGF1Padding"))) {
            paramCipher.init(1, paramPublicKey);
          }
        }
        else {
          paramCipher.init(1, paramPublicKey, new OAEPParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, PSource.PSpecified.DEFAULT));
        }
      }
      else {
        paramCipher.init(1, paramPublicKey);
      }
    }
    
    private void g(String paramString)
    {
      paramString = paramString.split("/");
      if (paramString.length == 3) {
        if (paramString[2].equals("PKCS1Padding")) {
          this.e = (this.d / 8 - 11);
        } else if ((!paramString[2].equals("OAEPPadding")) && (!paramString[2].equals("OAEPWithSHA-1AndMGF1Padding")))
        {
          if (paramString[2].equals("OAEPWithSHA-256AndMGF1Padding")) {
            this.e = (this.d / 8 - 66);
          } else if (paramString[2].equals("NoPadding")) {
            this.e = (this.d / 8 - 11);
          }
        }
        else {
          this.e = (this.d / 8 - 42);
        }
      }
    }
    
    public d a()
    {
      d locald = new d(null);
      d(locald);
      return locald;
    }
    
    public b h(PrivateKey paramPrivateKey)
    {
      this.b = paramPrivateKey;
      return this;
    }
    
    public b i(PublicKey paramPublicKey)
    {
      this.a = paramPublicKey;
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpanalytics\utils\l\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */