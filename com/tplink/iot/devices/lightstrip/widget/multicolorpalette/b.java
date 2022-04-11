package com.tplink.iot.devices.lightstrip.widget.multicolorpalette;

public final class b
{
  private final float a;
  private final float b;
  
  public b(float paramFloat1, float paramFloat2)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
  }
  
  public final float a()
  {
    return this.b;
  }
  
  public final float b()
  {
    return this.a;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof b))
      {
        paramObject = (b)paramObject;
        if ((Float.compare(this.a, ((b)paramObject).a) == 0) && (Float.compare(this.b, ((b)paramObject).b) == 0)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    return Float.floatToIntBits(this.a) * 31 + Float.floatToIntBits(this.b);
  }
  
  public String toString()
  {
    float f1 = this.a;
    float f2 = 'Ũ';
    float f3 = this.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ColorSegment(Human readable hue=");
    localStringBuilder.append(f1 * f2);
    localStringBuilder.append(", colorWheelAngle=");
    localStringBuilder.append(f3 * f2);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\lightstrip\widget\multicolorpalette\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */