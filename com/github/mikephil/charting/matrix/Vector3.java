package com.github.mikephil.charting.matrix;

public final class Vector3
{
  public static final Vector3 UNIT_X = new Vector3(1.0F, 0.0F, 0.0F);
  public static final Vector3 UNIT_Y = new Vector3(0.0F, 1.0F, 0.0F);
  public static final Vector3 UNIT_Z = new Vector3(0.0F, 0.0F, 1.0F);
  public static final Vector3 ZERO = new Vector3(0.0F, 0.0F, 0.0F);
  public float x;
  public float y;
  public float z;
  
  public Vector3() {}
  
  public Vector3(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    set(paramFloat1, paramFloat2, paramFloat3);
  }
  
  public Vector3(Vector3 paramVector3)
  {
    set(paramVector3);
  }
  
  public Vector3(float[] paramArrayOfFloat)
  {
    set(paramArrayOfFloat[0], paramArrayOfFloat[1], paramArrayOfFloat[2]);
  }
  
  public final void add(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.x += paramFloat1;
    this.y += paramFloat2;
    this.z += paramFloat3;
  }
  
  public final void add(Vector3 paramVector3)
  {
    this.x += paramVector3.x;
    this.y += paramVector3.y;
    this.z += paramVector3.z;
  }
  
  public final Vector3 cross(Vector3 paramVector3)
  {
    float f1 = this.y;
    float f2 = paramVector3.z;
    float f3 = this.z;
    float f4 = paramVector3.y;
    float f5 = paramVector3.x;
    float f6 = this.x;
    return new Vector3(f1 * f2 - f3 * f4, f3 * f5 - f2 * f6, f6 * f4 - f1 * f5);
  }
  
  public final float distance2(Vector3 paramVector3)
  {
    float f1 = this.x - paramVector3.x;
    float f2 = this.y - paramVector3.y;
    float f3 = this.z - paramVector3.z;
    return f1 * f1 + f2 * f2 + f3 * f3;
  }
  
  public final void divide(float paramFloat)
  {
    if (paramFloat != 0.0F)
    {
      this.x /= paramFloat;
      this.y /= paramFloat;
      this.z /= paramFloat;
    }
  }
  
  public final float dot(Vector3 paramVector3)
  {
    return this.x * paramVector3.x + this.y * paramVector3.y + this.z * paramVector3.z;
  }
  
  public final float length()
  {
    return (float)Math.sqrt(length2());
  }
  
  public final float length2()
  {
    float f1 = this.x;
    float f2 = this.y;
    float f3 = this.z;
    return f1 * f1 + f2 * f2 + f3 * f3;
  }
  
  public final void multiply(float paramFloat)
  {
    this.x *= paramFloat;
    this.y *= paramFloat;
    this.z *= paramFloat;
  }
  
  public final void multiply(Vector3 paramVector3)
  {
    this.x *= paramVector3.x;
    this.y *= paramVector3.y;
    this.z *= paramVector3.z;
  }
  
  public final float normalize()
  {
    float f = length();
    if (f != 0.0F)
    {
      this.x /= f;
      this.y /= f;
      this.z /= f;
    }
    return f;
  }
  
  public final boolean pointsInSameDirection(Vector3 paramVector3)
  {
    boolean bool;
    if (dot(paramVector3) > 0.0F) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public final void set(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.x = paramFloat1;
    this.y = paramFloat2;
    this.z = paramFloat3;
  }
  
  public final void set(Vector3 paramVector3)
  {
    this.x = paramVector3.x;
    this.y = paramVector3.y;
    this.z = paramVector3.z;
  }
  
  public final void subtract(Vector3 paramVector3)
  {
    this.x -= paramVector3.x;
    this.y -= paramVector3.y;
    this.z -= paramVector3.z;
  }
  
  public final void subtractMultiple(Vector3 paramVector3, float paramFloat)
  {
    this.x -= paramVector3.x * paramFloat;
    this.y -= paramVector3.y * paramFloat;
    this.z -= paramVector3.z * paramFloat;
  }
  
  public final void zero()
  {
    set(0.0F, 0.0F, 0.0F);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\matrix\Vector3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */