package com.google.android.datatransport.cct;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.datatransport.b;
import com.google.android.datatransport.h.g;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public final class c
  implements g
{
  static final String a;
  static final String b;
  private static final String c;
  private static final Set<b> d;
  public static final c e;
  public static final c f;
  @NonNull
  private final String g;
  @Nullable
  private final String h;
  
  static
  {
    String str1 = e.a("hts/frbslgiggolai.o/0clgbthfra=snpoo", "tp:/ieaeogn.ogepscmvc/o/ac?omtjo_rt3");
    a = str1;
    String str2 = e.a("hts/frbslgigp.ogepscmv/ieo/eaybtho", "tp:/ieaeogn-agolai.o/1frlglgc/aclg");
    b = str2;
    String str3 = e.a("AzSCki82AwsLzKd5O8zo", "IayckHiZRO1EFl1aGoK");
    c = str3;
    d = Collections.unmodifiableSet(new HashSet(Arrays.asList(new b[] { b.b("proto"), b.b("json") })));
    e = new c(str1, null);
    f = new c(str2, str3);
  }
  
  public c(@NonNull String paramString1, @Nullable String paramString2)
  {
    this.g = paramString1;
    this.h = paramString2;
  }
  
  @NonNull
  public static c c(@NonNull byte[] paramArrayOfByte)
  {
    paramArrayOfByte = new String(paramArrayOfByte, Charset.forName("UTF-8"));
    if (paramArrayOfByte.startsWith("1$"))
    {
      paramArrayOfByte = paramArrayOfByte.substring(2).split(Pattern.quote("\\"), 2);
      if (paramArrayOfByte.length == 2)
      {
        byte b1 = paramArrayOfByte[0];
        if (!b1.isEmpty())
        {
          byte b2 = paramArrayOfByte[1];
          paramArrayOfByte = b2;
          if (b2.isEmpty()) {
            paramArrayOfByte = null;
          }
          return new c(b1, paramArrayOfByte);
        }
        throw new IllegalArgumentException("Missing endpoint in CCTDestination extras");
      }
      throw new IllegalArgumentException("Extra is not a valid encoded LegacyFlgDestination");
    }
    throw new IllegalArgumentException("Version marker missing from extras");
  }
  
  public Set<b> a()
  {
    return d;
  }
  
  @Nullable
  public byte[] b()
  {
    String str1 = this.h;
    if ((str1 == null) && (this.g == null)) {
      return null;
    }
    String str2 = this.g;
    String str3 = str1;
    if (str1 == null) {
      str3 = "";
    }
    return String.format("%s%s%s%s", new Object[] { "1$", str2, "\\", str3 }).getBytes(Charset.forName("UTF-8"));
  }
  
  @Nullable
  public String d()
  {
    return this.h;
  }
  
  @NonNull
  public String e()
  {
    return this.g;
  }
  
  @Nullable
  public byte[] getExtras()
  {
    return b();
  }
  
  @NonNull
  public String getName()
  {
    return "cct";
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\datatransport\cct\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */