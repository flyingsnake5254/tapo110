package com.google.android.gms.common.util;

import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@KeepForSdk
public final class CollectionUtils
{
  @KeepForSdk
  public static boolean isEmpty(@Nullable Collection<?> paramCollection)
  {
    if (paramCollection == null) {
      return true;
    }
    return paramCollection.isEmpty();
  }
  
  @Deprecated
  @KeepForSdk
  public static <T> List<T> listOf()
  {
    return Collections.emptyList();
  }
  
  @Deprecated
  @KeepForSdk
  public static <T> List<T> listOf(T paramT)
  {
    return Collections.singletonList(paramT);
  }
  
  @Deprecated
  @KeepForSdk
  public static <T> List<T> listOf(T... paramVarArgs)
  {
    int i = paramVarArgs.length;
    if (i != 0)
    {
      if (i != 1) {
        return Collections.unmodifiableList(Arrays.asList(paramVarArgs));
      }
      return listOf(paramVarArgs[0]);
    }
    return listOf();
  }
  
  @KeepForSdk
  public static <K, V> Map<K, V> mapOf(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3)
  {
    Map localMap = zzb(3, false);
    localMap.put(paramK1, paramV1);
    localMap.put(paramK2, paramV2);
    localMap.put(paramK3, paramV3);
    return Collections.unmodifiableMap(localMap);
  }
  
  @KeepForSdk
  public static <K, V> Map<K, V> mapOf(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3, K paramK4, V paramV4, K paramK5, V paramV5, K paramK6, V paramV6)
  {
    Map localMap = zzb(6, false);
    localMap.put(paramK1, paramV1);
    localMap.put(paramK2, paramV2);
    localMap.put(paramK3, paramV3);
    localMap.put(paramK4, paramV4);
    localMap.put(paramK5, paramV5);
    localMap.put(paramK6, paramV6);
    return Collections.unmodifiableMap(localMap);
  }
  
  @KeepForSdk
  public static <K, V> Map<K, V> mapOfKeyValueArrays(K[] paramArrayOfK, V[] paramArrayOfV)
  {
    if (paramArrayOfK.length == paramArrayOfV.length)
    {
      i = paramArrayOfK.length;
      if (i != 0)
      {
        j = 0;
        if (i != 1)
        {
          Map localMap = zzb(paramArrayOfK.length, false);
          while (j < paramArrayOfK.length)
          {
            localMap.put(paramArrayOfK[j], paramArrayOfV[j]);
            j++;
          }
          return Collections.unmodifiableMap(localMap);
        }
        return Collections.singletonMap(paramArrayOfK[0], paramArrayOfV[0]);
      }
      return Collections.emptyMap();
    }
    int j = paramArrayOfK.length;
    int i = paramArrayOfV.length;
    paramArrayOfK = new StringBuilder(66);
    paramArrayOfK.append("Key and values array lengths not equal: ");
    paramArrayOfK.append(j);
    paramArrayOfK.append(" != ");
    paramArrayOfK.append(i);
    throw new IllegalArgumentException(paramArrayOfK.toString());
  }
  
  @KeepForSdk
  public static <T> Set<T> mutableSetOfWithSize(int paramInt)
  {
    if (paramInt == 0) {
      return new ArraySet();
    }
    return zza(paramInt, true);
  }
  
  @Deprecated
  @KeepForSdk
  public static <T> Set<T> setOf(T paramT1, T paramT2, T paramT3)
  {
    Set localSet = zza(3, false);
    localSet.add(paramT1);
    localSet.add(paramT2);
    localSet.add(paramT3);
    return Collections.unmodifiableSet(localSet);
  }
  
  @Deprecated
  @KeepForSdk
  public static <T> Set<T> setOf(T... paramVarArgs)
  {
    int i = paramVarArgs.length;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4)
            {
              localObject1 = zza(paramVarArgs.length, false);
              Collections.addAll((Collection)localObject1, paramVarArgs);
              return Collections.unmodifiableSet((Set)localObject1);
            }
            localObject2 = paramVarArgs[0];
            localObject1 = paramVarArgs[1];
            T ? = paramVarArgs[2];
            paramVarArgs = paramVarArgs[3];
            Set localSet = zza(4, false);
            localSet.add(localObject2);
            localSet.add(localObject1);
            localSet.add(?);
            localSet.add(paramVarArgs);
            return Collections.unmodifiableSet(localSet);
          }
          return setOf(paramVarArgs[0], paramVarArgs[1], paramVarArgs[2]);
        }
        Object localObject1 = paramVarArgs[0];
        paramVarArgs = paramVarArgs[1];
        Object localObject2 = zza(2, false);
        ((Set)localObject2).add(localObject1);
        ((Set)localObject2).add(paramVarArgs);
        return Collections.unmodifiableSet((Set)localObject2);
      }
      return Collections.singleton(paramVarArgs[0]);
    }
    return Collections.emptySet();
  }
  
  private static <T> Set<T> zza(int paramInt, boolean paramBoolean)
  {
    float f;
    if (paramBoolean) {
      f = 0.75F;
    } else {
      f = 1.0F;
    }
    int i;
    if (paramBoolean) {
      i = 128;
    } else {
      i = 256;
    }
    if (paramInt <= i) {
      return new ArraySet(paramInt);
    }
    return new HashSet(paramInt, f);
  }
  
  private static <K, V> Map<K, V> zzb(int paramInt, boolean paramBoolean)
  {
    if (paramInt <= 256) {
      return new ArrayMap(paramInt);
    }
    return new HashMap(paramInt, 1.0F);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\util\CollectionUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */