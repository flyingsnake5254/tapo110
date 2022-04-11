package com.bumptech.glide;

public enum MemoryCategory
{
  private final float multiplier;
  
  static
  {
    MemoryCategory localMemoryCategory1 = new MemoryCategory("LOW", 0, 0.5F);
    LOW = localMemoryCategory1;
    MemoryCategory localMemoryCategory2 = new MemoryCategory("NORMAL", 1, 1.0F);
    NORMAL = localMemoryCategory2;
    MemoryCategory localMemoryCategory3 = new MemoryCategory("HIGH", 2, 1.5F);
    HIGH = localMemoryCategory3;
    $VALUES = new MemoryCategory[] { localMemoryCategory1, localMemoryCategory2, localMemoryCategory3 };
  }
  
  private MemoryCategory(float paramFloat)
  {
    this.multiplier = paramFloat;
  }
  
  public float getMultiplier()
  {
    return this.multiplier;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\MemoryCategory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */