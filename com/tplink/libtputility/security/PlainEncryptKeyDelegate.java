package com.tplink.libtputility.security;

import android.content.Context;
import androidx.annotation.RequiresPermission;
import java.io.IOException;
import java.io.StringReader;
import java.security.KeyPair;
import java.security.PublicKey;
import java.util.UUID;
import org.bouncycastle.asn1.x509.w;
import org.bouncycastle.openssl.c;
import org.bouncycastle.openssl.e;

public class PlainEncryptKeyDelegate
{
  private static volatile PlainEncryptKeyDelegate a;
  private b.d.w.g.a b;
  
  static
  {
    System.loadLibrary("tpcommontool");
  }
  
  private PlainEncryptKeyDelegate(Context paramContext)
  {
    this.b = new b.d.w.g.a(paramContext, "aria_sp");
  }
  
  @Deprecated
  @RequiresPermission("android.permission.ACCESS_WIFI_STATE")
  public static String a(Context paramContext)
  {
    Object localObject1 = c(paramContext).d();
    Object localObject2 = localObject1;
    if (b.d.w.h.b.d((CharSequence)localObject1)) {
      localObject2 = b.d.w.f.b.a(paramContext);
    }
    localObject1 = localObject2;
    if (b.d.w.h.b.d((CharSequence)localObject2)) {
      localObject1 = UUID.randomUUID().toString();
    }
    if (!b.d.w.h.b.d((CharSequence)localObject1)) {
      c(paramContext).g((String)localObject1);
    }
    return generateAccountKey((String)localObject1);
  }
  
  @Deprecated
  public static String b()
  {
    return generateEncryptKey();
  }
  
  private static PlainEncryptKeyDelegate c(Context paramContext)
  {
    if (a == null) {
      try
      {
        if (a == null)
        {
          PlainEncryptKeyDelegate localPlainEncryptKeyDelegate = new com/tplink/libtputility/security/PlainEncryptKeyDelegate;
          localPlainEncryptKeyDelegate.<init>(paramContext);
          a = localPlainEncryptKeyDelegate;
        }
      }
      finally {}
    }
    return a;
  }
  
  private String d()
  {
    return this.b.f("ENCRYPT_UUID_KEY", null);
  }
  
  public static PublicKey e()
  {
    return f("-----BEGIN PUBLIC KEY-----\nMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAviMEj2Kss5OZzWS1Qyfz\nErRbg9wjDRvLem1enx/cr8CvSETdMtEctRSQdwvdpOWVFEhGQXeNSbs5me55u8ZI\neE3ph2JOW5PU++PsnvUIqqf8AJB1h+j0DcE+7tlsLRquskpNK9p6L/ziB8s/MaeA\nr//Nkhvdo32ax16UyzpeaOuReaLspDEHPN6+C7q6GFRZ8v0ILkQAFfGAEy94DI6Q\nCeXwBA90zLDDwKnyFwfp6r1Yi/1pUWzyXQLKmxzZJoiYO/J16fvyR4ILqzt40fyY\ncPsg+hpZUeGotBEt3AqTToeWPHbHKPCTgjMmYYGI0eqwbnMKKYMdZ34fViEDHhUy\newIDAQAB\n-----END PUBLIC KEY-----\n");
  }
  
  public static PublicKey f(String paramString)
  {
    paramString = new e(new StringReader(paramString));
    try
    {
      paramString = paramString.readObject();
      org.bouncycastle.openssl.g.a locala;
      if ((paramString instanceof w))
      {
        locala = new org/bouncycastle/openssl/g/a;
        locala.<init>();
        return locala.d((w)paramString);
      }
      if ((paramString instanceof c))
      {
        locala = new org/bouncycastle/openssl/g/a;
        locala.<init>();
        paramString = locala.b((c)paramString).getPublic();
        return paramString;
      }
    }
    catch (IOException paramString)
    {
      b.d.w.c.a.f(PlainEncryptKeyDelegate.class.getSimpleName(), paramString, "readPublicKey", new Object[0]);
    }
    return null;
  }
  
  private void g(String paramString)
  {
    this.b.k("ENCRYPT_UUID_KEY", paramString);
  }
  
  private static native String generateAccountKey(String paramString);
  
  private static native String generateEncryptKey();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtputility\security\PlainEncryptKeyDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */