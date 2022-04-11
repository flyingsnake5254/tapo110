package org.bouncycastle.asn1;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;
import java.util.TimeZone;
import org.bouncycastle.util.a;
import org.bouncycastle.util.i;

public class h
  extends q
{
  protected byte[] c;
  
  public h(String paramString)
  {
    this.c = i.e(paramString);
    try
    {
      o();
      return;
    }
    catch (ParseException paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("invalid date string: ");
      localStringBuilder.append(paramString.getMessage());
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
  }
  
  h(byte[] paramArrayOfByte)
  {
    this.c = paramArrayOfByte;
  }
  
  private String m()
  {
    Object localObject = TimeZone.getDefault();
    i = ((TimeZone)localObject).getRawOffset();
    String str;
    if (i < 0)
    {
      i = -i;
      str = "-";
    }
    else
    {
      str = "+";
    }
    j = i / 3600000;
    int k = (i - j * 60 * 60 * 1000) / 60000;
    i = j;
    try
    {
      if (((TimeZone)localObject).useDaylightTime())
      {
        i = j;
        if (((TimeZone)localObject).inDaylightTime(o()))
        {
          boolean bool = str.equals("+");
          if (bool) {
            i = 1;
          } else {
            i = -1;
          }
          i = j + i;
        }
      }
    }
    catch (ParseException localParseException)
    {
      for (;;)
      {
        i = j;
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("GMT");
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append(n(i));
    ((StringBuilder)localObject).append(":");
    ((StringBuilder)localObject).append(n(k));
    return ((StringBuilder)localObject).toString();
  }
  
  private String n(int paramInt)
  {
    if (paramInt < 10)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("0");
      localStringBuilder.append(paramInt);
      return localStringBuilder.toString();
    }
    return Integer.toString(paramInt);
  }
  
  public static h p(Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof h)))
    {
      if ((paramObject instanceof byte[])) {
        try
        {
          paramObject = (h)q.i((byte[])paramObject);
          return (h)paramObject;
        }
        catch (Exception localException)
        {
          paramObject = new StringBuilder();
          ((StringBuilder)paramObject).append("encoding error in getInstance: ");
          ((StringBuilder)paramObject).append(localException.toString());
          throw new IllegalArgumentException(((StringBuilder)paramObject).toString());
        }
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("illegal object in getInstance: ");
      localStringBuilder.append(paramObject.getClass().getName());
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return (h)paramObject;
  }
  
  private boolean u(int paramInt)
  {
    byte[] arrayOfByte = this.c;
    boolean bool;
    if ((arrayOfByte.length > paramInt) && (arrayOfByte[paramInt] >= 48) && (arrayOfByte[paramInt] <= 57)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  boolean f(q paramq)
  {
    if (!(paramq instanceof h)) {
      return false;
    }
    return a.c(this.c, ((h)paramq).c);
  }
  
  void g(p paramp)
    throws IOException
  {
    paramp.g(24, this.c);
  }
  
  int h()
  {
    int i = this.c.length;
    return y1.a(i) + 1 + i;
  }
  
  public int hashCode()
  {
    return a.w(this.c);
  }
  
  boolean j()
  {
    return false;
  }
  
  q k()
  {
    return new s0(this.c);
  }
  
  public Date o()
    throws ParseException
  {
    Object localObject1 = i.b(this.c);
    Object localObject2;
    Object localObject3;
    if (((String)localObject1).endsWith("Z"))
    {
      if (r()) {
        localObject2 = new SimpleDateFormat("yyyyMMddHHmmss.SSS'Z'");
      } else if (t()) {
        localObject2 = new SimpleDateFormat("yyyyMMddHHmmss'Z'");
      } else if (s()) {
        localObject2 = new SimpleDateFormat("yyyyMMddHHmm'Z'");
      } else {
        localObject2 = new SimpleDateFormat("yyyyMMddHH'Z'");
      }
      localObject3 = new SimpleTimeZone(0, "Z");
    }
    for (Object localObject4 = localObject2;; localObject4 = localObject2)
    {
      ((SimpleDateFormat)localObject4).setTimeZone((TimeZone)localObject3);
      localObject2 = localObject1;
      localObject3 = localObject4;
      break;
      if ((((String)localObject1).indexOf('-') <= 0) && (((String)localObject1).indexOf('+') <= 0))
      {
        if (r()) {
          localObject2 = new SimpleDateFormat("yyyyMMddHHmmss.SSS");
        }
        for (;;)
        {
          localObject3 = localObject2;
          break;
          if (t()) {
            localObject2 = new SimpleDateFormat("yyyyMMddHHmmss");
          } else if (s()) {
            localObject2 = new SimpleDateFormat("yyyyMMddHHmm");
          } else {
            localObject2 = new SimpleDateFormat("yyyyMMddHH");
          }
        }
        ((SimpleDateFormat)localObject3).setTimeZone(new SimpleTimeZone(0, TimeZone.getDefault().getID()));
        localObject2 = localObject1;
        break;
      }
      localObject1 = q();
      if (r()) {
        localObject2 = new SimpleDateFormat("yyyyMMddHHmmss.SSSz");
      } else if (t()) {
        localObject2 = new SimpleDateFormat("yyyyMMddHHmmssz");
      } else if (s()) {
        localObject2 = new SimpleDateFormat("yyyyMMddHHmmz");
      } else {
        localObject2 = new SimpleDateFormat("yyyyMMddHHz");
      }
      localObject3 = new SimpleTimeZone(0, "Z");
    }
    localObject4 = localObject2;
    if (r())
    {
      localObject1 = ((String)localObject2).substring(14);
      for (int i = 1; i < ((String)localObject1).length(); i++)
      {
        j = ((String)localObject1).charAt(i);
        if ((48 > j) || (j > 57)) {
          break;
        }
      }
      int j = i - 1;
      if (j > 3)
      {
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append(((String)localObject1).substring(0, 4));
        ((StringBuilder)localObject4).append(((String)localObject1).substring(i));
        localObject4 = ((StringBuilder)localObject4).toString();
        localObject1 = new StringBuilder();
      }
      for (;;)
      {
        ((StringBuilder)localObject1).append(((String)localObject2).substring(0, 14));
        ((StringBuilder)localObject1).append((String)localObject4);
        localObject4 = ((StringBuilder)localObject1).toString();
        break;
        if (j == 1)
        {
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append(((String)localObject1).substring(0, i));
          ((StringBuilder)localObject4).append("00");
          ((StringBuilder)localObject4).append(((String)localObject1).substring(i));
          localObject4 = ((StringBuilder)localObject4).toString();
          localObject1 = new StringBuilder();
        }
        else
        {
          localObject4 = localObject2;
          if (j != 2) {
            break;
          }
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append(((String)localObject1).substring(0, i));
          ((StringBuilder)localObject4).append("0");
          ((StringBuilder)localObject4).append(((String)localObject1).substring(i));
          localObject4 = ((StringBuilder)localObject4).toString();
          localObject1 = new StringBuilder();
        }
      }
    }
    return ((SimpleDateFormat)localObject3).parse((String)localObject4);
  }
  
  public String q()
  {
    String str = i.b(this.c);
    if (str.charAt(str.length() - 1) == 'Z')
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str.substring(0, str.length() - 1));
      localStringBuilder.append("GMT+00:00");
      return localStringBuilder.toString();
    }
    int i = str.length() - 5;
    int j = str.charAt(i);
    if ((j != 45) && (j != 43))
    {
      i = str.length() - 3;
      j = str.charAt(i);
      if ((j != 45) && (j != 43))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append(m());
        return localStringBuilder.toString();
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str.substring(0, i));
      localStringBuilder.append("GMT");
      localStringBuilder.append(str.substring(i));
      localStringBuilder.append(":00");
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str.substring(0, i));
    localStringBuilder.append("GMT");
    j = i + 3;
    localStringBuilder.append(str.substring(i, j));
    localStringBuilder.append(":");
    localStringBuilder.append(str.substring(j));
    return localStringBuilder.toString();
  }
  
  protected boolean r()
  {
    for (int i = 0;; i++)
    {
      byte[] arrayOfByte = this.c;
      if (i == arrayOfByte.length) {
        break;
      }
      if ((arrayOfByte[i] == 46) && (i == 14)) {
        return true;
      }
    }
    return false;
  }
  
  protected boolean s()
  {
    boolean bool;
    if ((u(10)) && (u(11))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  protected boolean t()
  {
    boolean bool;
    if ((u(12)) && (u(13))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */