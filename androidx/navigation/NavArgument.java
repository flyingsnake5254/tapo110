package androidx.navigation;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public final class NavArgument
{
  @Nullable
  private final Object mDefaultValue;
  private final boolean mDefaultValuePresent;
  private final boolean mIsNullable;
  @NonNull
  private final NavType mType;
  
  NavArgument(@NonNull NavType<?> paramNavType, boolean paramBoolean1, @Nullable Object paramObject, boolean paramBoolean2)
  {
    if ((!paramNavType.isNullableAllowed()) && (paramBoolean1))
    {
      paramObject = new StringBuilder();
      ((StringBuilder)paramObject).append(paramNavType.getName());
      ((StringBuilder)paramObject).append(" does not allow nullable values");
      throw new IllegalArgumentException(((StringBuilder)paramObject).toString());
    }
    if ((!paramBoolean1) && (paramBoolean2) && (paramObject == null))
    {
      paramObject = new StringBuilder();
      ((StringBuilder)paramObject).append("Argument with type ");
      ((StringBuilder)paramObject).append(paramNavType.getName());
      ((StringBuilder)paramObject).append(" has null value but is not nullable.");
      throw new IllegalArgumentException(((StringBuilder)paramObject).toString());
    }
    this.mType = paramNavType;
    this.mIsNullable = paramBoolean1;
    this.mDefaultValue = paramObject;
    this.mDefaultValuePresent = paramBoolean2;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (NavArgument.class == paramObject.getClass()))
    {
      paramObject = (NavArgument)paramObject;
      if (this.mIsNullable != ((NavArgument)paramObject).mIsNullable) {
        return false;
      }
      if (this.mDefaultValuePresent != ((NavArgument)paramObject).mDefaultValuePresent) {
        return false;
      }
      if (!this.mType.equals(((NavArgument)paramObject).mType)) {
        return false;
      }
      Object localObject = this.mDefaultValue;
      if (localObject != null) {
        bool = localObject.equals(((NavArgument)paramObject).mDefaultValue);
      } else if (((NavArgument)paramObject).mDefaultValue != null) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  @Nullable
  public Object getDefaultValue()
  {
    return this.mDefaultValue;
  }
  
  @NonNull
  public NavType<?> getType()
  {
    return this.mType;
  }
  
  public int hashCode()
  {
    int i = this.mType.hashCode();
    int j = this.mIsNullable;
    int k = this.mDefaultValuePresent;
    Object localObject = this.mDefaultValue;
    int m;
    if (localObject != null) {
      m = localObject.hashCode();
    } else {
      m = 0;
    }
    return ((i * 31 + j) * 31 + k) * 31 + m;
  }
  
  public boolean isDefaultValuePresent()
  {
    return this.mDefaultValuePresent;
  }
  
  public boolean isNullable()
  {
    return this.mIsNullable;
  }
  
  void putDefaultValue(@NonNull String paramString, @NonNull Bundle paramBundle)
  {
    if (this.mDefaultValuePresent) {
      this.mType.put(paramBundle, paramString, this.mDefaultValue);
    }
  }
  
  boolean verify(@NonNull String paramString, @NonNull Bundle paramBundle)
  {
    if ((!this.mIsNullable) && (paramBundle.containsKey(paramString)) && (paramBundle.get(paramString) == null)) {
      return false;
    }
    try
    {
      this.mType.get(paramBundle, paramString);
      return true;
    }
    catch (ClassCastException paramString) {}
    return false;
  }
  
  public static final class Builder
  {
    @Nullable
    private Object mDefaultValue;
    private boolean mDefaultValuePresent = false;
    private boolean mIsNullable = false;
    @Nullable
    private NavType<?> mType;
    
    @NonNull
    public NavArgument build()
    {
      if (this.mType == null) {
        this.mType = NavType.inferFromValueType(this.mDefaultValue);
      }
      return new NavArgument(this.mType, this.mIsNullable, this.mDefaultValue, this.mDefaultValuePresent);
    }
    
    @NonNull
    public Builder setDefaultValue(@Nullable Object paramObject)
    {
      this.mDefaultValue = paramObject;
      this.mDefaultValuePresent = true;
      return this;
    }
    
    @NonNull
    public Builder setIsNullable(boolean paramBoolean)
    {
      this.mIsNullable = paramBoolean;
      return this;
    }
    
    @NonNull
    public Builder setType(@NonNull NavType<?> paramNavType)
    {
      this.mType = paramNavType;
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\navigation\NavArgument.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */