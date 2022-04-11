package com.tplink.tdp.common;

public class c<T>
{
  private byte a = (byte)2;
  private short b = (short)1;
  private String c = "255.255.255.255";
  private int d = 20002;
  private int e = 8;
  private int f = 300;
  private int g = 900;
  private String h;
  private Class<T> i;
  
  public c(byte paramByte, Class<T> paramClass)
  {
    this.a = ((byte)paramByte);
    this.i = paramClass;
  }
  
  public c(byte paramByte, Class<T> paramClass, String paramString)
  {
    this(paramByte, paramClass);
    this.c = paramString;
  }
  
  public c(byte paramByte, Class<T> paramClass, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    this(paramByte, paramClass, paramString);
    this.e = paramInt1;
    this.f = paramInt2;
    this.g = paramInt3;
  }
  
  public int a()
  {
    return this.e;
  }
  
  public int b()
  {
    return this.g;
  }
  
  public int c()
  {
    return this.f;
  }
  
  public short d()
  {
    return this.b;
  }
  
  public String e()
  {
    return this.h;
  }
  
  public Class<T> f()
  {
    return this.i;
  }
  
  public String g()
  {
    return this.c;
  }
  
  public int h()
  {
    return this.d;
  }
  
  public byte i()
  {
    return this.a;
  }
  
  public void j(String paramString)
  {
    this.h = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\tdp\common\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */