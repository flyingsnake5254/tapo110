package com.tplink.iot.h.h;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class a
{
  private String a;
  private List<b> b = new ArrayList();
  private long c;
  private long d;
  private long e;
  private long f;
  
  public void a(b paramb)
  {
    this.b.add(paramb);
  }
  
  public String b()
  {
    return this.a;
  }
  
  public List<b> c()
  {
    return this.b;
  }
  
  public void d(String paramString)
  {
    this.a = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("\nbasepath: ");
    ((StringBuilder)localObject).append(this.a);
    localStringBuilder1.append(((StringBuilder)localObject).toString());
    localObject = this.b.iterator();
    while (((Iterator)localObject).hasNext())
    {
      b localb = (b)((Iterator)localObject).next();
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("\nts_file_name = ");
      localStringBuilder2.append(localb);
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("\nstartTime = ");
    ((StringBuilder)localObject).append(this.c);
    localStringBuilder1.append(((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("\nendTime = ");
    ((StringBuilder)localObject).append(this.d);
    localStringBuilder1.append(((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("\nstartDownloadTime = ");
    ((StringBuilder)localObject).append(this.e);
    localStringBuilder1.append(((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("\nendDownloadTime = ");
    ((StringBuilder)localObject).append(this.f);
    localStringBuilder1.append(((StringBuilder)localObject).toString());
    return localStringBuilder1.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\h\h\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */