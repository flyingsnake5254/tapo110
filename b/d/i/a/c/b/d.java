package b.d.i.a.c.b;

import android.text.TextUtils;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class d
{
  private final c a;
  private final a b;
  private b c;
  private byte[] d;
  private String e;
  
  public d(c paramc, a parama)
  {
    this.a = paramc;
    this.b = parama;
  }
  
  private void a()
  {
    this.c = new b();
    e();
    b();
    d();
    c();
    h();
    j();
  }
  
  private void b()
  {
    String str = this.b.a();
    if (str == null)
    {
      this.c.j("md5");
      return;
    }
    this.c.j(str);
  }
  
  private void c()
  {
    String str1 = this.b.d();
    int i = str1.trim().indexOf(",");
    String str2 = str1;
    if (i > -1) {
      str2 = str1.trim().substring(0, i);
    }
    this.c.l(str2);
  }
  
  private void d()
  {
    try
    {
      Object localObject = new java/net/URL;
      ((URL)localObject).<init>(this.a.c());
      String str = ((URL)localObject).getAuthority();
      localObject = ((URL)localObject).toString();
      str = ((String)localObject).substring(((String)localObject).indexOf(str) + str.length());
      this.c.n(str);
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException) {}catch (MalformedURLException localMalformedURLException) {}
    localMalformedURLException.printStackTrace();
    this.c.n("/stream");
  }
  
  private void e()
  {
    if ("true".equals(this.b.f()))
    {
      b localb = this.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.a.d());
      localStringBuilder.append(":");
      localStringBuilder.append(this.b.e());
      localb.p(l(localStringBuilder.toString().getBytes()));
      this.c.o("true");
    }
    else
    {
      this.c.p(this.a.d());
    }
  }
  
  private String f()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.a.d());
    ((StringBuilder)localObject).append(":");
    ((StringBuilder)localObject).append(this.b.e());
    ((StringBuilder)localObject).append(":");
    ((StringBuilder)localObject).append(this.a.a());
    String str = ((StringBuilder)localObject).toString();
    localObject = str;
    if (this.c.a().endsWith("-sess"))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(":");
      ((StringBuilder)localObject).append(l(str.getBytes()));
      ((StringBuilder)localObject).append(":");
      ((StringBuilder)localObject).append(this.b.b());
      ((StringBuilder)localObject).append(":");
      ((StringBuilder)localObject).append(this.c.b());
      localObject = ((StringBuilder)localObject).toString();
    }
    return (String)localObject;
  }
  
  private String g()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.a.b());
    ((StringBuilder)localObject).append(":");
    ((StringBuilder)localObject).append(this.c.f());
    String str = ((StringBuilder)localObject).toString();
    localObject = str;
    if (this.b.d().equals("auth-int"))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(":");
      ((StringBuilder)localObject).append(l(this.d));
      localObject = ((StringBuilder)localObject).toString();
    }
    return (String)localObject;
  }
  
  private void h()
  {
    String str = this.e;
    if (str != null)
    {
      this.c.k(str);
      b.i();
      return;
    }
    new SecureRandom().nextBytes(new byte[64]);
    str = n(16);
    this.c.k(str);
    b.i();
  }
  
  private String i()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Digest username=\"");
    localStringBuilder.append(this.c.h());
    localStringBuilder.append("\"");
    localStringBuilder.append(",");
    localStringBuilder.append("realm");
    localStringBuilder.append("=");
    localStringBuilder.append("\"");
    localStringBuilder.append(this.b.e());
    localStringBuilder.append("\"");
    localStringBuilder.append(",");
    localStringBuilder.append("uri");
    localStringBuilder.append("=");
    localStringBuilder.append("\"");
    localStringBuilder.append(this.c.f());
    localStringBuilder.append("\"");
    localStringBuilder.append(",");
    localStringBuilder.append("algorithm");
    localStringBuilder.append("=");
    localStringBuilder.append(this.b.a());
    localStringBuilder.append(",");
    localStringBuilder.append("nonce");
    localStringBuilder.append("=");
    localStringBuilder.append("\"");
    localStringBuilder.append(this.b.b());
    localStringBuilder.append("\"");
    localStringBuilder.append(",");
    localStringBuilder.append("nc");
    localStringBuilder.append("=");
    localStringBuilder.append(this.c.c());
    localStringBuilder.append(",");
    localStringBuilder.append("cnonce");
    localStringBuilder.append("=");
    localStringBuilder.append("\"");
    localStringBuilder.append(this.c.b());
    localStringBuilder.append("\"");
    localStringBuilder.append(",");
    localStringBuilder.append("qop");
    localStringBuilder.append("=");
    localStringBuilder.append(this.c.d());
    localStringBuilder.append(",");
    localStringBuilder.append("response");
    localStringBuilder.append("=");
    localStringBuilder.append("\"");
    localStringBuilder.append(this.c.e());
    localStringBuilder.append("\"");
    localStringBuilder.append(",");
    localStringBuilder.append("opaque");
    localStringBuilder.append("=");
    localStringBuilder.append("\"");
    localStringBuilder.append(this.b.c());
    localStringBuilder.append("\"");
    String str;
    if (this.c.g() == null) {
      str = "";
    } else {
      str = this.c.g();
    }
    localStringBuilder.append(str);
    return localStringBuilder.toString();
  }
  
  private void j()
  {
    String str1 = f();
    String str2 = g();
    this.c.m(m(l(str1.getBytes()), l(str2.getBytes())));
  }
  
  private String l(byte[] paramArrayOfByte)
  {
    try
    {
      Object localObject = MessageDigest.getInstance(this.c.a().replace("-sess", ""));
      ((MessageDigest)localObject).update(paramArrayOfByte);
      paramArrayOfByte = ((MessageDigest)localObject).digest();
      localObject = new java/lang/StringBuilder;
      ((StringBuilder)localObject).<init>();
      int i = paramArrayOfByte.length;
      for (int j = 0; j < i; j++) {
        ((StringBuilder)localObject).append(String.format("%02x", new Object[] { Byte.valueOf(paramArrayOfByte[j]) }));
      }
      paramArrayOfByte = ((StringBuilder)localObject).toString();
    }
    catch (NoSuchAlgorithmException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      paramArrayOfByte = null;
    }
    return paramArrayOfByte;
  }
  
  private String m(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.b.b());
    localStringBuilder.append(":");
    localStringBuilder.append(this.c.c());
    localStringBuilder.append(":");
    localStringBuilder.append(this.c.b());
    localStringBuilder.append(":");
    localStringBuilder.append(this.c.d());
    localStringBuilder.append(":");
    localStringBuilder.append(paramString2);
    paramString2 = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(":");
    localStringBuilder.append(paramString2);
    return l(localStringBuilder.toString().getBytes());
  }
  
  public String k()
  {
    if (this.c == null) {
      a();
    }
    return i();
  }
  
  public String n(int paramInt)
  {
    SecureRandom localSecureRandom = new SecureRandom();
    int i = 0;
    Object localObject1 = "";
    String str = "";
    label134:
    Object localObject2;
    for (;;)
    {
      if (i < paramInt)
      {
        if (i % 2 > 0) {}
        try
        {
          int j = localSecureRandom.nextInt();
          StringBuilder localStringBuilder = new java/lang/StringBuilder;
          localStringBuilder.<init>();
          localStringBuilder.append(str);
          localStringBuilder.append(Integer.toHexString(j % 10 + 48).toLowerCase());
          str = localStringBuilder.toString();
          break label134;
          j = localSecureRandom.nextInt();
          localStringBuilder = new java/lang/StringBuilder;
          localStringBuilder.<init>();
          localStringBuilder.append(str);
          localStringBuilder.append(Integer.toHexString(j % 26 + 97).toLowerCase());
          str = localStringBuilder.toString();
          i++;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          localObject2 = localObject1;
        }
      }
    }
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject1 = localObject2;
      if (((String)localObject2).length() == paramInt) {}
    }
    else
    {
      localObject1 = "a9h5b7i3j2y8c0a6";
    }
    return (String)localObject1;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\i\a\c\b\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */