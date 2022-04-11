package androidx.navigation;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.AnyRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.Serializable;

public abstract class NavType<T>
{
  @NonNull
  public static final NavType<boolean[]> BoolArrayType;
  @NonNull
  public static final NavType<Boolean> BoolType;
  @NonNull
  public static final NavType<float[]> FloatArrayType;
  @NonNull
  public static final NavType<Float> FloatType;
  @NonNull
  public static final NavType<int[]> IntArrayType;
  @NonNull
  public static final NavType<Integer> IntType = new NavType(false)
  {
    public Integer get(@NonNull Bundle paramAnonymousBundle, @NonNull String paramAnonymousString)
    {
      return (Integer)paramAnonymousBundle.get(paramAnonymousString);
    }
    
    @NonNull
    public String getName()
    {
      return "integer";
    }
    
    @NonNull
    public Integer parseValue(@NonNull String paramAnonymousString)
    {
      if (paramAnonymousString.startsWith("0x")) {
        return Integer.valueOf(Integer.parseInt(paramAnonymousString.substring(2), 16));
      }
      return Integer.valueOf(Integer.parseInt(paramAnonymousString));
    }
    
    public void put(@NonNull Bundle paramAnonymousBundle, @NonNull String paramAnonymousString, @NonNull Integer paramAnonymousInteger)
    {
      paramAnonymousBundle.putInt(paramAnonymousString, paramAnonymousInteger.intValue());
    }
  };
  @NonNull
  public static final NavType<long[]> LongArrayType;
  @NonNull
  public static final NavType<Long> LongType;
  @NonNull
  public static final NavType<Integer> ReferenceType = new NavType(false)
  {
    @AnyRes
    public Integer get(@NonNull Bundle paramAnonymousBundle, @NonNull String paramAnonymousString)
    {
      return (Integer)paramAnonymousBundle.get(paramAnonymousString);
    }
    
    @NonNull
    public String getName()
    {
      return "reference";
    }
    
    @NonNull
    public Integer parseValue(@NonNull String paramAnonymousString)
    {
      throw new UnsupportedOperationException("References don't support parsing string values.");
    }
    
    public void put(@NonNull Bundle paramAnonymousBundle, @NonNull String paramAnonymousString, @AnyRes @NonNull Integer paramAnonymousInteger)
    {
      paramAnonymousBundle.putInt(paramAnonymousString, paramAnonymousInteger.intValue());
    }
  };
  @NonNull
  public static final NavType<String[]> StringArrayType = new NavType(true)
  {
    public String[] get(@NonNull Bundle paramAnonymousBundle, @NonNull String paramAnonymousString)
    {
      return (String[])paramAnonymousBundle.get(paramAnonymousString);
    }
    
    @NonNull
    public String getName()
    {
      return "string[]";
    }
    
    @NonNull
    public String[] parseValue(@NonNull String paramAnonymousString)
    {
      throw new UnsupportedOperationException("Arrays don't support default values.");
    }
    
    public void put(@NonNull Bundle paramAnonymousBundle, @NonNull String paramAnonymousString, @Nullable String[] paramAnonymousArrayOfString)
    {
      paramAnonymousBundle.putStringArray(paramAnonymousString, paramAnonymousArrayOfString);
    }
  };
  @NonNull
  public static final NavType<String> StringType;
  private final boolean mNullableAllowed;
  
  static
  {
    IntArrayType = new NavType(true)
    {
      public int[] get(@NonNull Bundle paramAnonymousBundle, @NonNull String paramAnonymousString)
      {
        return (int[])paramAnonymousBundle.get(paramAnonymousString);
      }
      
      @NonNull
      public String getName()
      {
        return "integer[]";
      }
      
      @NonNull
      public int[] parseValue(@NonNull String paramAnonymousString)
      {
        throw new UnsupportedOperationException("Arrays don't support default values.");
      }
      
      public void put(@NonNull Bundle paramAnonymousBundle, @NonNull String paramAnonymousString, @Nullable int[] paramAnonymousArrayOfInt)
      {
        paramAnonymousBundle.putIntArray(paramAnonymousString, paramAnonymousArrayOfInt);
      }
    };
    LongType = new NavType(false)
    {
      public Long get(@NonNull Bundle paramAnonymousBundle, @NonNull String paramAnonymousString)
      {
        return (Long)paramAnonymousBundle.get(paramAnonymousString);
      }
      
      @NonNull
      public String getName()
      {
        return "long";
      }
      
      @NonNull
      public Long parseValue(@NonNull String paramAnonymousString)
      {
        String str = paramAnonymousString;
        if (paramAnonymousString.endsWith("L")) {
          str = paramAnonymousString.substring(0, paramAnonymousString.length() - 1);
        }
        if (str.startsWith("0x")) {
          return Long.valueOf(Long.parseLong(str.substring(2), 16));
        }
        return Long.valueOf(Long.parseLong(str));
      }
      
      public void put(@NonNull Bundle paramAnonymousBundle, @NonNull String paramAnonymousString, @NonNull Long paramAnonymousLong)
      {
        paramAnonymousBundle.putLong(paramAnonymousString, paramAnonymousLong.longValue());
      }
    };
    LongArrayType = new NavType(true)
    {
      public long[] get(@NonNull Bundle paramAnonymousBundle, @NonNull String paramAnonymousString)
      {
        return (long[])paramAnonymousBundle.get(paramAnonymousString);
      }
      
      @NonNull
      public String getName()
      {
        return "long[]";
      }
      
      @NonNull
      public long[] parseValue(@NonNull String paramAnonymousString)
      {
        throw new UnsupportedOperationException("Arrays don't support default values.");
      }
      
      public void put(@NonNull Bundle paramAnonymousBundle, @NonNull String paramAnonymousString, @Nullable long[] paramAnonymousArrayOfLong)
      {
        paramAnonymousBundle.putLongArray(paramAnonymousString, paramAnonymousArrayOfLong);
      }
    };
    FloatType = new NavType(false)
    {
      public Float get(@NonNull Bundle paramAnonymousBundle, @NonNull String paramAnonymousString)
      {
        return (Float)paramAnonymousBundle.get(paramAnonymousString);
      }
      
      @NonNull
      public String getName()
      {
        return "float";
      }
      
      @NonNull
      public Float parseValue(@NonNull String paramAnonymousString)
      {
        return Float.valueOf(Float.parseFloat(paramAnonymousString));
      }
      
      public void put(@NonNull Bundle paramAnonymousBundle, @NonNull String paramAnonymousString, @NonNull Float paramAnonymousFloat)
      {
        paramAnonymousBundle.putFloat(paramAnonymousString, paramAnonymousFloat.floatValue());
      }
    };
    FloatArrayType = new NavType(true)
    {
      public float[] get(@NonNull Bundle paramAnonymousBundle, @NonNull String paramAnonymousString)
      {
        return (float[])paramAnonymousBundle.get(paramAnonymousString);
      }
      
      @NonNull
      public String getName()
      {
        return "float[]";
      }
      
      @NonNull
      public float[] parseValue(@NonNull String paramAnonymousString)
      {
        throw new UnsupportedOperationException("Arrays don't support default values.");
      }
      
      public void put(@NonNull Bundle paramAnonymousBundle, @NonNull String paramAnonymousString, @Nullable float[] paramAnonymousArrayOfFloat)
      {
        paramAnonymousBundle.putFloatArray(paramAnonymousString, paramAnonymousArrayOfFloat);
      }
    };
    BoolType = new NavType(false)
    {
      public Boolean get(@NonNull Bundle paramAnonymousBundle, @NonNull String paramAnonymousString)
      {
        return (Boolean)paramAnonymousBundle.get(paramAnonymousString);
      }
      
      @NonNull
      public String getName()
      {
        return "boolean";
      }
      
      @NonNull
      public Boolean parseValue(@NonNull String paramAnonymousString)
      {
        if ("true".equals(paramAnonymousString)) {
          return Boolean.TRUE;
        }
        if ("false".equals(paramAnonymousString)) {
          return Boolean.FALSE;
        }
        throw new IllegalArgumentException("A boolean NavType only accepts \"true\" or \"false\" values.");
      }
      
      public void put(@NonNull Bundle paramAnonymousBundle, @NonNull String paramAnonymousString, @NonNull Boolean paramAnonymousBoolean)
      {
        paramAnonymousBundle.putBoolean(paramAnonymousString, paramAnonymousBoolean.booleanValue());
      }
    };
    BoolArrayType = new NavType(true)
    {
      public boolean[] get(@NonNull Bundle paramAnonymousBundle, @NonNull String paramAnonymousString)
      {
        return (boolean[])paramAnonymousBundle.get(paramAnonymousString);
      }
      
      @NonNull
      public String getName()
      {
        return "boolean[]";
      }
      
      @NonNull
      public boolean[] parseValue(@NonNull String paramAnonymousString)
      {
        throw new UnsupportedOperationException("Arrays don't support default values.");
      }
      
      public void put(@NonNull Bundle paramAnonymousBundle, @NonNull String paramAnonymousString, @Nullable boolean[] paramAnonymousArrayOfBoolean)
      {
        paramAnonymousBundle.putBooleanArray(paramAnonymousString, paramAnonymousArrayOfBoolean);
      }
    };
    StringType = new NavType(true)
    {
      public String get(@NonNull Bundle paramAnonymousBundle, @NonNull String paramAnonymousString)
      {
        return (String)paramAnonymousBundle.get(paramAnonymousString);
      }
      
      @NonNull
      public String getName()
      {
        return "string";
      }
      
      @NonNull
      public String parseValue(@NonNull String paramAnonymousString)
      {
        return paramAnonymousString;
      }
      
      public void put(@NonNull Bundle paramAnonymousBundle, @NonNull String paramAnonymousString1, @Nullable String paramAnonymousString2)
      {
        paramAnonymousBundle.putString(paramAnonymousString1, paramAnonymousString2);
      }
    };
  }
  
  NavType(boolean paramBoolean)
  {
    this.mNullableAllowed = paramBoolean;
  }
  
  @NonNull
  public static NavType<?> fromArgType(@Nullable String paramString1, @Nullable String paramString2)
  {
    Object localObject = IntType;
    if (((NavType)localObject).getName().equals(paramString1)) {
      return (NavType<?>)localObject;
    }
    localObject = IntArrayType;
    if (((NavType)localObject).getName().equals(paramString1)) {
      return (NavType<?>)localObject;
    }
    localObject = LongType;
    if (((NavType)localObject).getName().equals(paramString1)) {
      return (NavType<?>)localObject;
    }
    localObject = LongArrayType;
    if (((NavType)localObject).getName().equals(paramString1)) {
      return (NavType<?>)localObject;
    }
    localObject = BoolType;
    if (((NavType)localObject).getName().equals(paramString1)) {
      return (NavType<?>)localObject;
    }
    localObject = BoolArrayType;
    if (((NavType)localObject).getName().equals(paramString1)) {
      return (NavType<?>)localObject;
    }
    localObject = StringType;
    if (((NavType)localObject).getName().equals(paramString1)) {
      return (NavType<?>)localObject;
    }
    NavType localNavType = StringArrayType;
    if (localNavType.getName().equals(paramString1)) {
      return localNavType;
    }
    localNavType = FloatType;
    if (localNavType.getName().equals(paramString1)) {
      return localNavType;
    }
    localNavType = FloatArrayType;
    if (localNavType.getName().equals(paramString1)) {
      return localNavType;
    }
    localNavType = ReferenceType;
    if (localNavType.getName().equals(paramString1)) {
      return localNavType;
    }
    if ((paramString1 != null) && (!paramString1.isEmpty())) {
      try
      {
        if ((paramString1.startsWith(".")) && (paramString2 != null))
        {
          localObject = new java/lang/StringBuilder;
          ((StringBuilder)localObject).<init>();
          ((StringBuilder)localObject).append(paramString2);
          ((StringBuilder)localObject).append(paramString1);
          paramString2 = ((StringBuilder)localObject).toString();
        }
        else
        {
          paramString2 = paramString1;
        }
        if (paramString1.endsWith("[]"))
        {
          paramString2 = paramString2.substring(0, paramString2.length() - 2);
          paramString1 = Class.forName(paramString2);
          if (Parcelable.class.isAssignableFrom(paramString1)) {
            return new ParcelableArrayType(paramString1);
          }
          if (Serializable.class.isAssignableFrom(paramString1)) {
            return new SerializableArrayType(paramString1);
          }
        }
        else
        {
          paramString1 = Class.forName(paramString2);
          if (Parcelable.class.isAssignableFrom(paramString1)) {
            return new ParcelableType(paramString1);
          }
          if (Enum.class.isAssignableFrom(paramString1)) {
            return new EnumType(paramString1);
          }
          if (Serializable.class.isAssignableFrom(paramString1)) {
            return new SerializableType(paramString1);
          }
        }
        paramString1 = new java/lang/IllegalArgumentException;
        localObject = new java/lang/StringBuilder;
        ((StringBuilder)localObject).<init>();
        ((StringBuilder)localObject).append(paramString2);
        ((StringBuilder)localObject).append(" is not Serializable or Parcelable.");
        paramString1.<init>(((StringBuilder)localObject).toString());
        throw paramString1;
      }
      catch (ClassNotFoundException paramString1)
      {
        throw new RuntimeException(paramString1);
      }
    }
    return (NavType<?>)localObject;
  }
  
  @NonNull
  static NavType inferFromValue(@NonNull String paramString)
  {
    try
    {
      NavType localNavType1 = IntType;
      localNavType1.parseValue(paramString);
      return localNavType1;
    }
    catch (IllegalArgumentException localIllegalArgumentException1)
    {
      try
      {
        NavType localNavType2 = LongType;
        localNavType2.parseValue(paramString);
        return localNavType2;
      }
      catch (IllegalArgumentException localIllegalArgumentException2)
      {
        try
        {
          NavType localNavType3 = FloatType;
          localNavType3.parseValue(paramString);
          return localNavType3;
        }
        catch (IllegalArgumentException localIllegalArgumentException3)
        {
          try
          {
            NavType localNavType4 = BoolType;
            localNavType4.parseValue(paramString);
            return localNavType4;
          }
          catch (IllegalArgumentException paramString) {}
        }
      }
    }
    return StringType;
  }
  
  @NonNull
  static NavType inferFromValueType(@Nullable Object paramObject)
  {
    if ((paramObject instanceof Integer)) {
      return IntType;
    }
    if ((paramObject instanceof int[])) {
      return IntArrayType;
    }
    if ((paramObject instanceof Long)) {
      return LongType;
    }
    if ((paramObject instanceof long[])) {
      return LongArrayType;
    }
    if ((paramObject instanceof Float)) {
      return FloatType;
    }
    if ((paramObject instanceof float[])) {
      return FloatArrayType;
    }
    if ((paramObject instanceof Boolean)) {
      return BoolType;
    }
    if ((paramObject instanceof boolean[])) {
      return BoolArrayType;
    }
    if ((!(paramObject instanceof String)) && (paramObject != null))
    {
      if ((paramObject instanceof String[])) {
        return StringArrayType;
      }
      if ((paramObject.getClass().isArray()) && (Parcelable.class.isAssignableFrom(paramObject.getClass().getComponentType()))) {
        return new ParcelableArrayType(paramObject.getClass().getComponentType());
      }
      if ((paramObject.getClass().isArray()) && (Serializable.class.isAssignableFrom(paramObject.getClass().getComponentType()))) {
        return new SerializableArrayType(paramObject.getClass().getComponentType());
      }
      if ((paramObject instanceof Parcelable)) {
        return new ParcelableType(paramObject.getClass());
      }
      if ((paramObject instanceof Enum)) {
        return new EnumType(paramObject.getClass());
      }
      if ((paramObject instanceof Serializable)) {
        return new SerializableType(paramObject.getClass());
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Object of type ");
      localStringBuilder.append(paramObject.getClass().getName());
      localStringBuilder.append(" is not supported for navigation arguments.");
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return StringType;
  }
  
  @Nullable
  public abstract T get(@NonNull Bundle paramBundle, @NonNull String paramString);
  
  @NonNull
  public abstract String getName();
  
  public boolean isNullableAllowed()
  {
    return this.mNullableAllowed;
  }
  
  @NonNull
  T parseAndPut(@NonNull Bundle paramBundle, @NonNull String paramString1, @NonNull String paramString2)
  {
    paramString2 = parseValue(paramString2);
    put(paramBundle, paramString1, paramString2);
    return paramString2;
  }
  
  @NonNull
  public abstract T parseValue(@NonNull String paramString);
  
  public abstract void put(@NonNull Bundle paramBundle, @NonNull String paramString, @Nullable T paramT);
  
  @NonNull
  public String toString()
  {
    return getName();
  }
  
  public static final class EnumType<D extends Enum>
    extends NavType.SerializableType<D>
  {
    @NonNull
    private final Class<D> mType;
    
    public EnumType(@NonNull Class<D> paramClass)
    {
      super(paramClass);
      if (paramClass.isEnum())
      {
        this.mType = paramClass;
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramClass);
      localStringBuilder.append(" is not an Enum type.");
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    
    @NonNull
    public String getName()
    {
      return this.mType.getName();
    }
    
    @NonNull
    public D parseValue(@NonNull String paramString)
    {
      for (localObject : (Enum[])this.mType.getEnumConstants()) {
        if (((Enum)localObject).name().equals(paramString)) {
          return (D)localObject;
        }
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Enum value ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" not found for type ");
      ((StringBuilder)localObject).append(this.mType.getName());
      ((StringBuilder)localObject).append(".");
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
  }
  
  public static final class ParcelableArrayType<D extends Parcelable>
    extends NavType<D[]>
  {
    @NonNull
    private final Class<D[]> mArrayType;
    
    public ParcelableArrayType(@NonNull Class<D> paramClass)
    {
      super();
      if (Parcelable.class.isAssignableFrom(paramClass)) {
        try
        {
          localStringBuilder = new java/lang/StringBuilder;
          localStringBuilder.<init>();
          localStringBuilder.append("[L");
          localStringBuilder.append(paramClass.getName());
          localStringBuilder.append(";");
          paramClass = Class.forName(localStringBuilder.toString());
          this.mArrayType = paramClass;
          return;
        }
        catch (ClassNotFoundException paramClass)
        {
          throw new RuntimeException(paramClass);
        }
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramClass);
      localStringBuilder.append(" does not implement Parcelable.");
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {
        return true;
      }
      if ((paramObject != null) && (ParcelableArrayType.class == paramObject.getClass()))
      {
        paramObject = (ParcelableArrayType)paramObject;
        return this.mArrayType.equals(((ParcelableArrayType)paramObject).mArrayType);
      }
      return false;
    }
    
    @Nullable
    public D[] get(@NonNull Bundle paramBundle, @NonNull String paramString)
    {
      return (Parcelable[])paramBundle.get(paramString);
    }
    
    @NonNull
    public String getName()
    {
      return this.mArrayType.getName();
    }
    
    public int hashCode()
    {
      return this.mArrayType.hashCode();
    }
    
    @NonNull
    public D[] parseValue(@NonNull String paramString)
    {
      throw new UnsupportedOperationException("Arrays don't support default values.");
    }
    
    public void put(@NonNull Bundle paramBundle, @NonNull String paramString, @Nullable D[] paramArrayOfD)
    {
      this.mArrayType.cast(paramArrayOfD);
      paramBundle.putParcelableArray(paramString, paramArrayOfD);
    }
  }
  
  public static final class ParcelableType<D>
    extends NavType<D>
  {
    @NonNull
    private final Class<D> mType;
    
    public ParcelableType(@NonNull Class<D> paramClass)
    {
      super();
      if ((!Parcelable.class.isAssignableFrom(paramClass)) && (!Serializable.class.isAssignableFrom(paramClass)))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramClass);
        localStringBuilder.append(" does not implement Parcelable or Serializable.");
        throw new IllegalArgumentException(localStringBuilder.toString());
      }
      this.mType = paramClass;
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {
        return true;
      }
      if ((paramObject != null) && (ParcelableType.class == paramObject.getClass()))
      {
        paramObject = (ParcelableType)paramObject;
        return this.mType.equals(((ParcelableType)paramObject).mType);
      }
      return false;
    }
    
    @Nullable
    public D get(@NonNull Bundle paramBundle, @NonNull String paramString)
    {
      return (D)paramBundle.get(paramString);
    }
    
    @NonNull
    public String getName()
    {
      return this.mType.getName();
    }
    
    public int hashCode()
    {
      return this.mType.hashCode();
    }
    
    @NonNull
    public D parseValue(@NonNull String paramString)
    {
      throw new UnsupportedOperationException("Parcelables don't support default values.");
    }
    
    public void put(@NonNull Bundle paramBundle, @NonNull String paramString, @Nullable D paramD)
    {
      this.mType.cast(paramD);
      if ((paramD != null) && (!(paramD instanceof Parcelable)))
      {
        if ((paramD instanceof Serializable)) {
          paramBundle.putSerializable(paramString, (Serializable)paramD);
        }
      }
      else {
        paramBundle.putParcelable(paramString, (Parcelable)paramD);
      }
    }
  }
  
  public static final class SerializableArrayType<D extends Serializable>
    extends NavType<D[]>
  {
    @NonNull
    private final Class<D[]> mArrayType;
    
    public SerializableArrayType(@NonNull Class<D> paramClass)
    {
      super();
      if (Serializable.class.isAssignableFrom(paramClass)) {
        try
        {
          localStringBuilder = new java/lang/StringBuilder;
          localStringBuilder.<init>();
          localStringBuilder.append("[L");
          localStringBuilder.append(paramClass.getName());
          localStringBuilder.append(";");
          paramClass = Class.forName(localStringBuilder.toString());
          this.mArrayType = paramClass;
          return;
        }
        catch (ClassNotFoundException paramClass)
        {
          throw new RuntimeException(paramClass);
        }
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramClass);
      localStringBuilder.append(" does not implement Serializable.");
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {
        return true;
      }
      if ((paramObject != null) && (SerializableArrayType.class == paramObject.getClass()))
      {
        paramObject = (SerializableArrayType)paramObject;
        return this.mArrayType.equals(((SerializableArrayType)paramObject).mArrayType);
      }
      return false;
    }
    
    @Nullable
    public D[] get(@NonNull Bundle paramBundle, @NonNull String paramString)
    {
      return (Serializable[])paramBundle.get(paramString);
    }
    
    @NonNull
    public String getName()
    {
      return this.mArrayType.getName();
    }
    
    public int hashCode()
    {
      return this.mArrayType.hashCode();
    }
    
    @NonNull
    public D[] parseValue(@NonNull String paramString)
    {
      throw new UnsupportedOperationException("Arrays don't support default values.");
    }
    
    public void put(@NonNull Bundle paramBundle, @NonNull String paramString, @Nullable D[] paramArrayOfD)
    {
      this.mArrayType.cast(paramArrayOfD);
      paramBundle.putSerializable(paramString, paramArrayOfD);
    }
  }
  
  public static class SerializableType<D extends Serializable>
    extends NavType<D>
  {
    @NonNull
    private final Class<D> mType;
    
    public SerializableType(@NonNull Class<D> paramClass)
    {
      super();
      if (Serializable.class.isAssignableFrom(paramClass))
      {
        if (!paramClass.isEnum())
        {
          this.mType = paramClass;
          return;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramClass);
        localStringBuilder.append(" is an Enum. You should use EnumType instead.");
        throw new IllegalArgumentException(localStringBuilder.toString());
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramClass);
      localStringBuilder.append(" does not implement Serializable.");
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    
    SerializableType(boolean paramBoolean, @NonNull Class<D> paramClass)
    {
      super();
      if (Serializable.class.isAssignableFrom(paramClass))
      {
        this.mType = paramClass;
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramClass);
      localStringBuilder.append(" does not implement Serializable.");
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {
        return true;
      }
      if (!(paramObject instanceof SerializableType)) {
        return false;
      }
      paramObject = (SerializableType)paramObject;
      return this.mType.equals(((SerializableType)paramObject).mType);
    }
    
    @Nullable
    public D get(@NonNull Bundle paramBundle, @NonNull String paramString)
    {
      return (Serializable)paramBundle.get(paramString);
    }
    
    @NonNull
    public String getName()
    {
      return this.mType.getName();
    }
    
    public int hashCode()
    {
      return this.mType.hashCode();
    }
    
    @NonNull
    public D parseValue(@NonNull String paramString)
    {
      throw new UnsupportedOperationException("Serializables don't support default values.");
    }
    
    public void put(@NonNull Bundle paramBundle, @NonNull String paramString, @Nullable D paramD)
    {
      this.mType.cast(paramD);
      paramBundle.putSerializable(paramString, paramD);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\navigation\NavType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */