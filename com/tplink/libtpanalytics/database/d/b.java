package com.tplink.libtpanalytics.database.d;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName="EVENT")
public class b
{
  @NonNull
  @ColumnInfo(name="EVENT_ID")
  @PrimaryKey
  private String a;
  @NonNull
  @ColumnInfo(name="EVENT_NAME")
  private String b;
  @ColumnInfo(name="USER_ID")
  private String c;
  @NonNull
  @ColumnInfo(name="TIME")
  private long d;
  @ColumnInfo(name="ENCRYPTED_PARAM")
  private String e;
  @ColumnInfo(name="PLAINTEXT_PARAM")
  private String f;
  @NonNull
  @ColumnInfo(name="LEN")
  private int g;
  @ColumnInfo(name="ENCRYPT_VER")
  private int h;
  @ColumnInfo(name="APP_VER")
  private String i;
  @ColumnInfo(name="REGION")
  private String j;
  @ColumnInfo(name="OS_VER")
  private String k;
  @ColumnInfo(name="LANGUAGE")
  private String l;
  @NonNull
  @ColumnInfo(name="ENCRYPT_VERSION_ID")
  private String m;
  
  public String a()
  {
    return this.i;
  }
  
  public int b()
  {
    return this.h;
  }
  
  @NonNull
  public String c()
  {
    return this.m;
  }
  
  public String d()
  {
    return this.e;
  }
  
  public String e()
  {
    return this.a;
  }
  
  public String f()
  {
    return this.b;
  }
  
  public String g()
  {
    return this.l;
  }
  
  public int h()
  {
    return this.g;
  }
  
  public String i()
  {
    return this.k;
  }
  
  public String j()
  {
    return this.f;
  }
  
  public String k()
  {
    return this.j;
  }
  
  public long l()
  {
    return this.d;
  }
  
  public String m()
  {
    return this.c;
  }
  
  public void n(String paramString)
  {
    this.i = paramString;
  }
  
  public void o(int paramInt)
  {
    this.h = paramInt;
  }
  
  public void p(@NonNull String paramString)
  {
    this.m = paramString;
  }
  
  public void q(String paramString)
  {
    this.e = paramString;
  }
  
  public void r(String paramString)
  {
    this.a = paramString;
  }
  
  public void s(String paramString)
  {
    this.b = paramString;
  }
  
  public void t(String paramString)
  {
    this.l = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Event{eventId='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", eventName='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", userId='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", time=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", encryptedParam='");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\'');
    localStringBuilder.append(", plaintextParam='");
    localStringBuilder.append(this.f);
    localStringBuilder.append('\'');
    localStringBuilder.append(", len=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", encryptVer=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", appVer='");
    localStringBuilder.append(this.i);
    localStringBuilder.append('\'');
    localStringBuilder.append(", region='");
    localStringBuilder.append(this.j);
    localStringBuilder.append('\'');
    localStringBuilder.append(", osVer='");
    localStringBuilder.append(this.k);
    localStringBuilder.append('\'');
    localStringBuilder.append(", language='");
    localStringBuilder.append(this.l);
    localStringBuilder.append('\'');
    localStringBuilder.append(", encryptVersionId='");
    localStringBuilder.append(this.m);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void u(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void v(String paramString)
  {
    this.k = paramString;
  }
  
  public void w(String paramString)
  {
    this.f = paramString;
  }
  
  public void x(String paramString)
  {
    this.j = paramString;
  }
  
  public void y(long paramLong)
  {
    this.d = paramLong;
  }
  
  public void z(String paramString)
  {
    this.c = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpanalytics\database\d\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */