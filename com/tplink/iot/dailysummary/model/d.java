package com.tplink.iot.dailysummary.model;

public final class d
{
  private boolean a;
  private boolean b;
  private boolean c;
  
  public d()
  {
    this(false, false, false, 7, null);
  }
  
  public d(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.a = paramBoolean1;
    this.b = paramBoolean2;
    this.c = paramBoolean3;
  }
  
  public final d a()
  {
    return new d(this.a, this.b, this.c);
  }
  
  public final boolean b()
  {
    return this.a;
  }
  
  public final int c()
  {
    if (this.a) {
      return 2131952477;
    }
    return 2131952476;
  }
  
  public final int d()
  {
    if (this.c) {
      return 2131952492;
    }
    return 2131952491;
  }
  
  public final boolean e()
  {
    return this.c;
  }
  
  public final boolean f()
  {
    return this.b;
  }
  
  public final int g()
  {
    if (this.b) {
      return 2131952507;
    }
    return 2131952508;
  }
  
  public final void h(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public final void i(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public final void j(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SummarySetting\n ");
    localStringBuilder.append("( mAutoRotation=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", mRotationAll=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", mNotify = ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" )");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\dailysummary\model\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */