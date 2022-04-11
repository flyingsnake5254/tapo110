package com.google.gson;

public enum LongSerializationPolicy
{
  static
  {
    a locala = new a("DEFAULT", 0);
    DEFAULT = locala;
    b localb = new b("STRING", 1);
    STRING = localb;
    $VALUES = new LongSerializationPolicy[] { locala, localb };
  }
  
  public abstract i serialize(Long paramLong);
  
  enum a
  {
    a()
    {
      super(paramInt, null);
    }
    
    public i serialize(Long paramLong)
    {
      return new m(paramLong);
    }
  }
  
  enum b
  {
    b()
    {
      super(paramInt, null);
    }
    
    public i serialize(Long paramLong)
    {
      return new m(String.valueOf(paramLong));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\gson\LongSerializationPolicy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */