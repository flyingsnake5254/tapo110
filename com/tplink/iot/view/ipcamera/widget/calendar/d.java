package com.tplink.iot.view.ipcamera.widget.calendar;

public class d
{
  int a;
  int b;
  int c;
  
  public d(int paramInt1, int paramInt2, int paramInt3)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
  }
  
  public d a()
  {
    return new d(this.a, this.b, this.c);
  }
  
  public int b(d paramd)
  {
    if (this.a < paramd.e()) {
      return -1;
    }
    if (this.a > paramd.e()) {
      return 1;
    }
    if (this.b < paramd.d()) {
      return -1;
    }
    if (this.b > paramd.d()) {
      return 1;
    }
    if (this.c < paramd.c()) {
      return -1;
    }
    if (this.c > paramd.c()) {
      return 1;
    }
    return 0;
  }
  
  public int c()
  {
    return this.c;
  }
  
  public int d()
  {
    return this.b;
  }
  
  public int e()
  {
    return this.a;
  }
  
  public void f()
  {
    int i = this.b;
    if (i == 1)
    {
      this.a -= 1;
      this.b = 12;
    }
    else
    {
      this.b = (i - 1);
    }
    this.c = 1;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(this.a);
    localStringBuffer.append("-");
    if (this.b < 10) {
      localStringBuffer.append("0");
    }
    localStringBuffer.append(this.b);
    localStringBuffer.append("-");
    if (this.c < 10) {
      localStringBuffer.append("0");
    }
    localStringBuffer.append(this.c);
    return localStringBuffer.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\widget\calendar\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */