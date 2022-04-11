package org.bouncycastle.asn1.x509;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;
import java.util.TimeZone;
import org.bouncycastle.asn1.d;
import org.bouncycastle.asn1.h;
import org.bouncycastle.asn1.h1;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.s0;
import org.bouncycastle.asn1.y;

public class z
  extends l
  implements d
{
  q c;
  
  public z(Date paramDate)
  {
    Object localObject = new SimpleTimeZone(0, "Z");
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
    localSimpleDateFormat.setTimeZone((TimeZone)localObject);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(localSimpleDateFormat.format(paramDate));
    ((StringBuilder)localObject).append("Z");
    paramDate = ((StringBuilder)localObject).toString();
    int i = Integer.parseInt(paramDate.substring(0, 4));
    if ((i >= 1950) && (i <= 2049)) {
      paramDate = new h1(paramDate.substring(2));
    } else {
      paramDate = new s0(paramDate);
    }
    this.c = paramDate;
  }
  
  public z(q paramq)
  {
    if ((!(paramq instanceof y)) && (!(paramq instanceof h))) {
      throw new IllegalArgumentException("unknown object passed to Time");
    }
    this.c = paramq;
  }
  
  public static z g(Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof z)))
    {
      if ((paramObject instanceof y)) {
        return new z((y)paramObject);
      }
      if ((paramObject instanceof h)) {
        return new z((h)paramObject);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("unknown object in factory: ");
      localStringBuilder.append(paramObject.getClass().getName());
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return (z)paramObject;
  }
  
  public q c()
  {
    return this.c;
  }
  
  public Date f()
  {
    try
    {
      localObject = this.c;
      if ((localObject instanceof y)) {
        return ((y)localObject).m();
      }
      localObject = ((h)localObject).o();
      return (Date)localObject;
    }
    catch (ParseException localParseException)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("invalid date string: ");
      ((StringBuilder)localObject).append(localParseException.getMessage());
      throw new IllegalStateException(((StringBuilder)localObject).toString());
    }
  }
  
  public String h()
  {
    q localq = this.c;
    if ((localq instanceof y)) {
      return ((y)localq).n();
    }
    return ((h)localq).q();
  }
  
  public String toString()
  {
    return h();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\x509\z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */