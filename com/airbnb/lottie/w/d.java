package com.airbnb.lottie.w;

public class d
{
  private float a;
  private float b;
  
  public d()
  {
    this(1.0F, 1.0F);
  }
  
  public d(float paramFloat1, float paramFloat2)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
  }
  
  public boolean a(float paramFloat1, float paramFloat2)
  {
    boolean bool;
    if ((this.a == paramFloat1) && (this.b == paramFloat2)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public float b()
  {
    return this.a;
  }
  
  public float c()
  {
    return this.b;
  }
  
  public void d(float paramFloat1, float paramFloat2)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b());
    localStringBuilder.append("x");
    localStringBuilder.append(c());
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\w\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */