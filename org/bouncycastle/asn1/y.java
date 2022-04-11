package org.bouncycastle.asn1;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;
import org.bouncycastle.util.a;
import org.bouncycastle.util.i;

public class y
  extends q
{
  private byte[] c;
  
  public y(String paramString)
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
  
  y(byte[] paramArrayOfByte)
  {
    this.c = paramArrayOfByte;
  }
  
  boolean f(q paramq)
  {
    if (!(paramq instanceof y)) {
      return false;
    }
    return a.c(this.c, ((y)paramq).c);
  }
  
  void g(p paramp)
    throws IOException
  {
    paramp.c(23);
    int i = this.c.length;
    paramp.i(i);
    for (int j = 0; j != i; j++) {
      paramp.c(this.c[j]);
    }
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
  
  public Date m()
    throws ParseException
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssz");
    localSimpleDateFormat.setTimeZone(new SimpleTimeZone(0, "Z"));
    return localSimpleDateFormat.parse(n());
  }
  
  public String n()
  {
    String str1 = p();
    StringBuilder localStringBuilder;
    if (str1.charAt(0) < '5') {
      localStringBuilder = new StringBuilder();
    }
    for (String str2 = "20";; str2 = "19")
    {
      localStringBuilder.append(str2);
      localStringBuilder.append(str1);
      return localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
    }
  }
  
  public Date o()
    throws ParseException
  {
    return new SimpleDateFormat("yyMMddHHmmssz").parse(p());
  }
  
  public String p()
  {
    Object localObject1 = i.b(this.c);
    StringBuilder localStringBuilder;
    Object localObject2;
    if ((((String)localObject1).indexOf('-') < 0) && (((String)localObject1).indexOf('+') < 0)) {
      if (((String)localObject1).length() == 11)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(((String)localObject1).substring(0, 10));
        localObject2 = "00GMT+00:00";
        localObject1 = localStringBuilder;
      }
    }
    for (;;)
    {
      ((StringBuilder)localObject1).append((String)localObject2);
      return ((StringBuilder)localObject1).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(((String)localObject1).substring(0, 12));
      localObject2 = "GMT+00:00";
      localObject1 = localStringBuilder;
      continue;
      int i = ((String)localObject1).indexOf('-');
      int j = i;
      if (i < 0) {
        j = ((String)localObject1).indexOf('+');
      }
      localObject2 = localObject1;
      if (j == ((String)localObject1).length() - 3)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("00");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      if (j == 10)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(((String)localObject2).substring(0, 10));
        ((StringBuilder)localObject1).append("00GMT");
        ((StringBuilder)localObject1).append(((String)localObject2).substring(10, 13));
        ((StringBuilder)localObject1).append(":");
        localObject2 = ((String)localObject2).substring(13, 15);
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(((String)localObject2).substring(0, 12));
        ((StringBuilder)localObject1).append("GMT");
        ((StringBuilder)localObject1).append(((String)localObject2).substring(12, 15));
        ((StringBuilder)localObject1).append(":");
        localObject2 = ((String)localObject2).substring(15, 17);
      }
    }
  }
  
  public String toString()
  {
    return i.b(this.c);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */