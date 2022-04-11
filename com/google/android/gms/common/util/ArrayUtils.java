package com.google.android.gms.common.util;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

@KeepForSdk
@VisibleForTesting
public final class ArrayUtils
{
  @KeepForSdk
  public static <T> T[] appendToArray(T[] paramArrayOfT, T paramT)
  {
    if ((paramArrayOfT == null) && (paramT == null)) {
      throw new IllegalArgumentException("Cannot generate array of generic type w/o class info");
    }
    if (paramArrayOfT == null) {
      paramArrayOfT = (Object[])Array.newInstance(paramT.getClass(), 1);
    } else {
      paramArrayOfT = Arrays.copyOf(paramArrayOfT, paramArrayOfT.length + 1);
    }
    paramArrayOfT[(paramArrayOfT.length - 1)] = paramT;
    return paramArrayOfT;
  }
  
  @KeepForSdk
  public static <T> T[] concat(T[]... paramVarArgs)
  {
    if (paramVarArgs.length == 0) {
      return (Object[])Array.newInstance(paramVarArgs.getClass(), 0);
    }
    int i = 0;
    int j = 0;
    while (i < paramVarArgs.length)
    {
      j += paramVarArgs[i].length;
      i++;
    }
    Object[] arrayOfObject = Arrays.copyOf(paramVarArgs[0], j);
    i = paramVarArgs[0].length;
    for (j = 1; j < paramVarArgs.length; j++)
    {
      T[] arrayOfT = paramVarArgs[j];
      System.arraycopy(arrayOfT, 0, arrayOfObject, i, arrayOfT.length);
      i += arrayOfT.length;
    }
    return arrayOfObject;
  }
  
  @KeepForSdk
  public static byte[] concatByteArrays(byte[]... paramVarArgs)
  {
    if (paramVarArgs.length == 0) {
      return new byte[0];
    }
    int i = 0;
    int j = 0;
    while (i < paramVarArgs.length)
    {
      j += paramVarArgs[i].length;
      i++;
    }
    byte[] arrayOfByte1 = Arrays.copyOf(paramVarArgs[0], j);
    j = paramVarArgs[0].length;
    for (i = 1; i < paramVarArgs.length; i++)
    {
      byte[] arrayOfByte2 = paramVarArgs[i];
      System.arraycopy(arrayOfByte2, 0, arrayOfByte1, j, arrayOfByte2.length);
      j += arrayOfByte2.length;
    }
    return arrayOfByte1;
  }
  
  @KeepForSdk
  public static boolean contains(int[] paramArrayOfInt, int paramInt)
  {
    if (paramArrayOfInt == null) {
      return false;
    }
    int i = paramArrayOfInt.length;
    for (int j = 0; j < i; j++) {
      if (paramArrayOfInt[j] == paramInt) {
        return true;
      }
    }
    return false;
  }
  
  @KeepForSdk
  public static <T> boolean contains(T[] paramArrayOfT, T paramT)
  {
    int i;
    if (paramArrayOfT != null) {
      i = paramArrayOfT.length;
    } else {
      i = 0;
    }
    for (int j = 0; j < i; j++) {
      if (Objects.equal(paramArrayOfT[j], paramT)) {
        break label40;
      }
    }
    j = -1;
    label40:
    return j >= 0;
  }
  
  @KeepForSdk
  public static <T> ArrayList<T> newArrayList()
  {
    return new ArrayList();
  }
  
  @KeepForSdk
  public static <T> T[] removeAll(T[] paramArrayOfT1, T... paramVarArgs)
  {
    if (paramArrayOfT1 == null) {
      return null;
    }
    if ((paramVarArgs != null) && (paramVarArgs.length != 0))
    {
      Object[] arrayOfObject = (Object[])Array.newInstance(paramVarArgs.getClass().getComponentType(), paramArrayOfT1.length);
      int i = paramVarArgs.length;
      int j = 0;
      int m;
      T ?;
      if (i == 1)
      {
        k = paramArrayOfT1.length;
        m = 0;
        for (i = 0;; i = j)
        {
          j = i;
          if (m >= k) {
            break;
          }
          ? = paramArrayOfT1[m];
          j = i;
          if (!Objects.equal(paramVarArgs[0], ?))
          {
            arrayOfObject[i] = ?;
            j = i + 1;
          }
          m++;
        }
      }
      int k = paramArrayOfT1.length;
      for (i = 0; j < k; i = m)
      {
        ? = paramArrayOfT1[j];
        m = i;
        if (!contains(paramVarArgs, ?))
        {
          arrayOfObject[i] = ?;
          m = i + 1;
        }
        j++;
      }
      j = i;
      if (arrayOfObject == null) {
        return null;
      }
      paramArrayOfT1 = arrayOfObject;
      if (j != arrayOfObject.length) {
        paramArrayOfT1 = Arrays.copyOf(arrayOfObject, j);
      }
      return paramArrayOfT1;
    }
    return Arrays.copyOf(paramArrayOfT1, paramArrayOfT1.length);
  }
  
  @KeepForSdk
  public static <T> ArrayList<T> toArrayList(T[] paramArrayOfT)
  {
    int i = paramArrayOfT.length;
    ArrayList localArrayList = new ArrayList(i);
    for (int j = 0; j < i; j++) {
      localArrayList.add(paramArrayOfT[j]);
    }
    return localArrayList;
  }
  
  @KeepForSdk
  public static int[] toPrimitiveArray(Collection<Integer> paramCollection)
  {
    int i = 0;
    if ((paramCollection != null) && (paramCollection.size() != 0))
    {
      int[] arrayOfInt = new int[paramCollection.size()];
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        arrayOfInt[i] = ((Integer)paramCollection.next()).intValue();
        i++;
      }
      return arrayOfInt;
    }
    return new int[0];
  }
  
  @KeepForSdk
  public static Integer[] toWrapperArray(int[] paramArrayOfInt)
  {
    if (paramArrayOfInt == null) {
      return null;
    }
    int i = paramArrayOfInt.length;
    Integer[] arrayOfInteger = new Integer[i];
    for (int j = 0; j < i; j++) {
      arrayOfInteger[j] = Integer.valueOf(paramArrayOfInt[j]);
    }
    return arrayOfInteger;
  }
  
  @KeepForSdk
  public static void writeArray(StringBuilder paramStringBuilder, double[] paramArrayOfDouble)
  {
    int i = paramArrayOfDouble.length;
    for (int j = 0; j < i; j++)
    {
      if (j != 0) {
        paramStringBuilder.append(",");
      }
      paramStringBuilder.append(Double.toString(paramArrayOfDouble[j]));
    }
  }
  
  @KeepForSdk
  public static void writeArray(StringBuilder paramStringBuilder, float[] paramArrayOfFloat)
  {
    int i = paramArrayOfFloat.length;
    for (int j = 0; j < i; j++)
    {
      if (j != 0) {
        paramStringBuilder.append(",");
      }
      paramStringBuilder.append(Float.toString(paramArrayOfFloat[j]));
    }
  }
  
  @KeepForSdk
  public static void writeArray(StringBuilder paramStringBuilder, int[] paramArrayOfInt)
  {
    int i = paramArrayOfInt.length;
    for (int j = 0; j < i; j++)
    {
      if (j != 0) {
        paramStringBuilder.append(",");
      }
      paramStringBuilder.append(Integer.toString(paramArrayOfInt[j]));
    }
  }
  
  @KeepForSdk
  public static void writeArray(StringBuilder paramStringBuilder, long[] paramArrayOfLong)
  {
    int i = paramArrayOfLong.length;
    for (int j = 0; j < i; j++)
    {
      if (j != 0) {
        paramStringBuilder.append(",");
      }
      paramStringBuilder.append(Long.toString(paramArrayOfLong[j]));
    }
  }
  
  @KeepForSdk
  public static <T> void writeArray(StringBuilder paramStringBuilder, T[] paramArrayOfT)
  {
    int i = paramArrayOfT.length;
    for (int j = 0; j < i; j++)
    {
      if (j != 0) {
        paramStringBuilder.append(",");
      }
      paramStringBuilder.append(paramArrayOfT[j].toString());
    }
  }
  
  @KeepForSdk
  public static void writeArray(StringBuilder paramStringBuilder, boolean[] paramArrayOfBoolean)
  {
    int i = paramArrayOfBoolean.length;
    for (int j = 0; j < i; j++)
    {
      if (j != 0) {
        paramStringBuilder.append(",");
      }
      paramStringBuilder.append(Boolean.toString(paramArrayOfBoolean[j]));
    }
  }
  
  @KeepForSdk
  public static void writeStringArray(StringBuilder paramStringBuilder, String[] paramArrayOfString)
  {
    int i = paramArrayOfString.length;
    for (int j = 0; j < i; j++)
    {
      if (j != 0) {
        paramStringBuilder.append(",");
      }
      paramStringBuilder.append("\"");
      paramStringBuilder.append(paramArrayOfString[j]);
      paramStringBuilder.append("\"");
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\util\ArrayUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */