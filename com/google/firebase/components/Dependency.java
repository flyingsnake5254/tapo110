package com.google.firebase.components;

public final class Dependency
{
  private final Class<?> anInterface;
  private final int injection;
  private final int type;
  
  private Dependency(Class<?> paramClass, int paramInt1, int paramInt2)
  {
    this.anInterface = ((Class)Preconditions.checkNotNull(paramClass, "Null dependency anInterface."));
    this.type = paramInt1;
    this.injection = paramInt2;
  }
  
  public static Dependency deferred(Class<?> paramClass)
  {
    return new Dependency(paramClass, 0, 2);
  }
  
  private static String describeInjection(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt == 2) {
          return "deferred";
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Unsupported injection: ");
        localStringBuilder.append(paramInt);
        throw new AssertionError(localStringBuilder.toString());
      }
      return "provider";
    }
    return "direct";
  }
  
  @Deprecated
  public static Dependency optional(Class<?> paramClass)
  {
    return new Dependency(paramClass, 0, 0);
  }
  
  public static Dependency optionalProvider(Class<?> paramClass)
  {
    return new Dependency(paramClass, 0, 1);
  }
  
  public static Dependency required(Class<?> paramClass)
  {
    return new Dependency(paramClass, 1, 0);
  }
  
  public static Dependency requiredProvider(Class<?> paramClass)
  {
    return new Dependency(paramClass, 1, 1);
  }
  
  public static Dependency setOf(Class<?> paramClass)
  {
    return new Dependency(paramClass, 2, 0);
  }
  
  public static Dependency setOfProvider(Class<?> paramClass)
  {
    return new Dependency(paramClass, 2, 1);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof Dependency;
    boolean bool2 = false;
    boolean bool3 = bool2;
    if (bool1)
    {
      paramObject = (Dependency)paramObject;
      bool3 = bool2;
      if (this.anInterface == ((Dependency)paramObject).anInterface)
      {
        bool3 = bool2;
        if (this.type == ((Dependency)paramObject).type)
        {
          bool3 = bool2;
          if (this.injection == ((Dependency)paramObject).injection) {
            bool3 = true;
          }
        }
      }
    }
    return bool3;
  }
  
  public Class<?> getInterface()
  {
    return this.anInterface;
  }
  
  public int hashCode()
  {
    return ((this.anInterface.hashCode() ^ 0xF4243) * 1000003 ^ this.type) * 1000003 ^ this.injection;
  }
  
  public boolean isDeferred()
  {
    boolean bool;
    if (this.injection == 2) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isDirectInjection()
  {
    boolean bool;
    if (this.injection == 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isRequired()
  {
    int i = this.type;
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    return bool;
  }
  
  public boolean isSet()
  {
    boolean bool;
    if (this.type == 2) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("Dependency{anInterface=");
    localStringBuilder.append(this.anInterface);
    localStringBuilder.append(", type=");
    int i = this.type;
    String str;
    if (i == 1) {
      str = "required";
    } else if (i == 0) {
      str = "optional";
    } else {
      str = "set";
    }
    localStringBuilder.append(str);
    localStringBuilder.append(", injection=");
    localStringBuilder.append(describeInjection(this.injection));
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\components\Dependency.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */