package com.tplink.libtpnetwork.IoTNetwork.transport.http;

import android.text.TextUtils;
import android.util.Base64;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;

public class a
{
  private String a;
  private Map<Integer, String> b = new HashMap();
  private com.tplink.libtputility.security.a c;
  
  public String a(String paramString)
  {
    try
    {
      Object localObject = this.c;
      if (localObject != null)
      {
        localObject = ((com.tplink.libtputility.security.a)localObject).a(paramString);
        return (String)localObject;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return paramString;
  }
  
  public void b(String paramString)
    throws Exception
  {
    Object localObject1 = (String)this.b.get(Integer.valueOf(1));
    paramString = Base64.decode(paramString.getBytes("UTF-8"), 0);
    localObject1 = Base64.decode((String)localObject1, 0);
    Object localObject2 = (RSAPrivateKey)KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec((byte[])localObject1));
    localObject1 = Cipher.getInstance("RSA/NONE/PKCS1Padding");
    ((Cipher)localObject1).init(2, (Key)localObject2);
    localObject2 = ((Cipher)localObject1).doFinal(paramString);
    paramString = new byte[16];
    localObject1 = new byte[16];
    System.arraycopy(localObject2, 0, paramString, 0, 16);
    System.arraycopy(localObject2, 16, localObject1, 0, 16);
    String str = Base64.encodeToString(paramString, 0);
    localObject2 = Base64.encodeToString((byte[])localObject1, 0);
    this.c = new com.tplink.libtputility.security.a(paramString, (byte[])localObject1);
    h(str, (String)localObject2);
  }
  
  public String c(String paramString)
  {
    try
    {
      Object localObject = this.c;
      if (localObject != null)
      {
        localObject = ((com.tplink.libtputility.security.a)localObject).c(paramString);
        return (String)localObject;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return paramString;
  }
  
  public void d()
    throws NoSuchAlgorithmException
  {
    Object localObject1 = KeyPairGenerator.getInstance("RSA");
    ((KeyPairGenerator)localObject1).initialize(1024, new SecureRandom());
    Object localObject2 = ((KeyPairGenerator)localObject1).generateKeyPair();
    localObject1 = (RSAPrivateKey)((KeyPair)localObject2).getPrivate();
    localObject2 = new String(Base64.encode(((RSAPublicKey)((KeyPair)localObject2).getPublic()).getEncoded(), 0));
    localObject1 = new String(Base64.encode(((RSAPrivateKey)localObject1).getEncoded(), 0));
    this.b.put(Integer.valueOf(0), localObject2);
    this.b.put(Integer.valueOf(1), localObject1);
  }
  
  public String e()
    throws NoSuchAlgorithmException
  {
    Object localObject = this.b;
    Integer localInteger = Integer.valueOf(0);
    if (TextUtils.isEmpty((CharSequence)((Map)localObject).get(localInteger))) {
      d();
    }
    localObject = new StringBuilder("-----BEGIN PUBLIC KEY-----\n");
    ((StringBuilder)localObject).append((String)this.b.get(localInteger));
    ((StringBuilder)localObject).append("-----END PUBLIC KEY-----\n");
    return ((StringBuilder)localObject).toString();
  }
  
  public boolean f()
  {
    return TextUtils.isEmpty(this.a) ^ true;
  }
  
  public void g()
  {
    this.a = "";
    this.c = null;
  }
  
  public void h(String paramString1, String paramString2)
  {
    this.a = paramString1;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\transport\http\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */