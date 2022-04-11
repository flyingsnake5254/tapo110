package com.tplink.libtputility.log.tiny.bean;

import android.util.Base64;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class b
{
  private byte a;
  private byte b;
  private int c;
  private byte[] d;
  private int e;
  private List<byte[]> f;
  
  public b(List<a> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      this.a = ((byte)1);
      this.b = ((byte)0);
      Object localObject = new LogFactoryBean(paramList).toJsonByte();
      this.d = ((byte[])localObject);
      if (localObject != null)
      {
        this.c = localObject.length;
        this.f = new ArrayList();
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localObject = (a)paramList.next();
          if ((((a)localObject).h() != null) && (((a)localObject).g() > 0))
          {
            this.f.add(((a)localObject).h());
            this.e += ((a)localObject).g();
          }
        }
      }
    }
  }
  
  public String a()
  {
    byte[] arrayOfByte = this.d;
    if (arrayOfByte == null) {
      return "";
    }
    try
    {
      int i = this.c;
      Object localObject = new byte[i + 4 + this.e];
      localObject[0] = ((byte)this.a);
      localObject[1] = ((byte)this.b);
      localObject[2] = ((byte)(byte)(i >> 8 & 0xFF));
      localObject[3] = ((byte)(byte)(i & 0xFF));
      System.arraycopy(arrayOfByte, 0, localObject, 4, i);
      i = this.c + 4;
      Iterator localIterator = this.f.iterator();
      while (localIterator.hasNext())
      {
        arrayOfByte = (byte[])localIterator.next();
        System.arraycopy(arrayOfByte, 0, localObject, i, arrayOfByte.length);
        i += arrayOfByte.length;
      }
      localObject = new String(Base64.encode((byte[])localObject, 2), "UTF-8");
      return (String)localObject;
    }
    catch (Exception localException) {}
    return "";
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtputility\log\tiny\bean\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */