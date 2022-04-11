package androidx.navigation;

import kotlin.jvm.internal.j;

@NavDestinationDsl
public final class NavArgumentBuilder
{
  private NavType<?> _type;
  private final NavArgument.Builder builder = new NavArgument.Builder();
  private Object defaultValue;
  private boolean nullable;
  
  public final NavArgument build()
  {
    NavArgument localNavArgument = this.builder.build();
    j.b(localNavArgument, "builder.build()");
    return localNavArgument;
  }
  
  public final Object getDefaultValue()
  {
    return this.defaultValue;
  }
  
  public final boolean getNullable()
  {
    return this.nullable;
  }
  
  public final NavType<?> getType()
  {
    NavType localNavType = this._type;
    if (localNavType != null) {
      return localNavType;
    }
    throw new IllegalStateException("NavType has not been set on this builder.");
  }
  
  public final void setDefaultValue(Object paramObject)
  {
    this.defaultValue = paramObject;
    this.builder.setDefaultValue(paramObject);
  }
  
  public final void setNullable(boolean paramBoolean)
  {
    this.nullable = paramBoolean;
    this.builder.setIsNullable(paramBoolean);
  }
  
  public final void setType(NavType<?> paramNavType)
  {
    j.f(paramNavType, "value");
    this._type = paramNavType;
    this.builder.setType(paramNavType);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\navigation\NavArgumentBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */