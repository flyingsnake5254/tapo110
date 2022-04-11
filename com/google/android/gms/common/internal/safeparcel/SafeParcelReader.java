package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.util.SparseLongArray;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class SafeParcelReader
{
  public static BigDecimal createBigDecimal(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    paramInt = paramParcel.dataPosition();
    if (i == 0) {
      return null;
    }
    byte[] arrayOfByte = paramParcel.createByteArray();
    int j = paramParcel.readInt();
    paramParcel.setDataPosition(paramInt + i);
    return new BigDecimal(new BigInteger(arrayOfByte), j);
  }
  
  public static BigDecimal[] createBigDecimalArray(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0) {
      return null;
    }
    int k = paramParcel.readInt();
    BigDecimal[] arrayOfBigDecimal = new BigDecimal[k];
    for (paramInt = 0; paramInt < k; paramInt++)
    {
      byte[] arrayOfByte = paramParcel.createByteArray();
      int m = paramParcel.readInt();
      arrayOfBigDecimal[paramInt] = new BigDecimal(new BigInteger(arrayOfByte), m);
    }
    paramParcel.setDataPosition(j + i);
    return arrayOfBigDecimal;
  }
  
  public static BigInteger createBigInteger(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    paramInt = paramParcel.dataPosition();
    if (i == 0) {
      return null;
    }
    byte[] arrayOfByte = paramParcel.createByteArray();
    paramParcel.setDataPosition(paramInt + i);
    return new BigInteger(arrayOfByte);
  }
  
  public static BigInteger[] createBigIntegerArray(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0) {
      return null;
    }
    int k = paramParcel.readInt();
    BigInteger[] arrayOfBigInteger = new BigInteger[k];
    for (paramInt = 0; paramInt < k; paramInt++) {
      arrayOfBigInteger[paramInt] = new BigInteger(paramParcel.createByteArray());
    }
    paramParcel.setDataPosition(j + i);
    return arrayOfBigInteger;
  }
  
  public static boolean[] createBooleanArray(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    paramInt = paramParcel.dataPosition();
    if (i == 0) {
      return null;
    }
    boolean[] arrayOfBoolean = paramParcel.createBooleanArray();
    paramParcel.setDataPosition(paramInt + i);
    return arrayOfBoolean;
  }
  
  public static ArrayList<Boolean> createBooleanList(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int k = paramParcel.readInt();
    for (paramInt = 0; paramInt < k; paramInt++)
    {
      boolean bool;
      if (paramParcel.readInt() != 0) {
        bool = true;
      } else {
        bool = false;
      }
      localArrayList.add(Boolean.valueOf(bool));
    }
    paramParcel.setDataPosition(j + i);
    return localArrayList;
  }
  
  public static Bundle createBundle(Parcel paramParcel, int paramInt)
  {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0) {
      return null;
    }
    Bundle localBundle = paramParcel.readBundle();
    paramParcel.setDataPosition(i + paramInt);
    return localBundle;
  }
  
  public static byte[] createByteArray(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    paramInt = paramParcel.dataPosition();
    if (i == 0) {
      return null;
    }
    byte[] arrayOfByte = paramParcel.createByteArray();
    paramParcel.setDataPosition(paramInt + i);
    return arrayOfByte;
  }
  
  public static byte[][] createByteArrayArray(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0) {
      return null;
    }
    int k = paramParcel.readInt();
    byte[][] arrayOfByte = new byte[k][];
    for (paramInt = 0; paramInt < k; paramInt++) {
      arrayOfByte[paramInt] = paramParcel.createByteArray();
    }
    paramParcel.setDataPosition(j + i);
    return arrayOfByte;
  }
  
  public static SparseArray<byte[]> createByteArraySparseArray(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0) {
      return null;
    }
    int k = paramParcel.readInt();
    SparseArray localSparseArray = new SparseArray(k);
    for (paramInt = 0; paramInt < k; paramInt++) {
      localSparseArray.append(paramParcel.readInt(), paramParcel.createByteArray());
    }
    paramParcel.setDataPosition(j + i);
    return localSparseArray;
  }
  
  public static char[] createCharArray(Parcel paramParcel, int paramInt)
  {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0) {
      return null;
    }
    char[] arrayOfChar = paramParcel.createCharArray();
    paramParcel.setDataPosition(i + paramInt);
    return arrayOfChar;
  }
  
  public static double[] createDoubleArray(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    paramInt = paramParcel.dataPosition();
    if (i == 0) {
      return null;
    }
    double[] arrayOfDouble = paramParcel.createDoubleArray();
    paramParcel.setDataPosition(paramInt + i);
    return arrayOfDouble;
  }
  
  public static ArrayList<Double> createDoubleList(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int k = paramParcel.readInt();
    for (paramInt = 0; paramInt < k; paramInt++) {
      localArrayList.add(Double.valueOf(paramParcel.readDouble()));
    }
    paramParcel.setDataPosition(j + i);
    return localArrayList;
  }
  
  public static SparseArray<Double> createDoubleSparseArray(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0) {
      return null;
    }
    SparseArray localSparseArray = new SparseArray();
    int k = paramParcel.readInt();
    for (paramInt = 0; paramInt < k; paramInt++) {
      localSparseArray.append(paramParcel.readInt(), Double.valueOf(paramParcel.readDouble()));
    }
    paramParcel.setDataPosition(j + i);
    return localSparseArray;
  }
  
  public static float[] createFloatArray(Parcel paramParcel, int paramInt)
  {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0) {
      return null;
    }
    float[] arrayOfFloat = paramParcel.createFloatArray();
    paramParcel.setDataPosition(i + paramInt);
    return arrayOfFloat;
  }
  
  public static ArrayList<Float> createFloatList(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int k = paramParcel.readInt();
    for (paramInt = 0; paramInt < k; paramInt++) {
      localArrayList.add(Float.valueOf(paramParcel.readFloat()));
    }
    paramParcel.setDataPosition(j + i);
    return localArrayList;
  }
  
  public static SparseArray<Float> createFloatSparseArray(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0) {
      return null;
    }
    SparseArray localSparseArray = new SparseArray();
    int k = paramParcel.readInt();
    for (paramInt = 0; paramInt < k; paramInt++) {
      localSparseArray.append(paramParcel.readInt(), Float.valueOf(paramParcel.readFloat()));
    }
    paramParcel.setDataPosition(j + i);
    return localSparseArray;
  }
  
  public static IBinder[] createIBinderArray(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    paramInt = paramParcel.dataPosition();
    if (i == 0) {
      return null;
    }
    IBinder[] arrayOfIBinder = paramParcel.createBinderArray();
    paramParcel.setDataPosition(paramInt + i);
    return arrayOfIBinder;
  }
  
  public static ArrayList<IBinder> createIBinderList(Parcel paramParcel, int paramInt)
  {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0) {
      return null;
    }
    ArrayList localArrayList = paramParcel.createBinderArrayList();
    paramParcel.setDataPosition(i + paramInt);
    return localArrayList;
  }
  
  public static SparseArray<IBinder> createIBinderSparseArray(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0) {
      return null;
    }
    int k = paramParcel.readInt();
    SparseArray localSparseArray = new SparseArray(k);
    for (paramInt = 0; paramInt < k; paramInt++) {
      localSparseArray.append(paramParcel.readInt(), paramParcel.readStrongBinder());
    }
    paramParcel.setDataPosition(j + i);
    return localSparseArray;
  }
  
  public static int[] createIntArray(Parcel paramParcel, int paramInt)
  {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0) {
      return null;
    }
    int[] arrayOfInt = paramParcel.createIntArray();
    paramParcel.setDataPosition(i + paramInt);
    return arrayOfInt;
  }
  
  public static ArrayList<Integer> createIntegerList(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int k = paramParcel.readInt();
    for (paramInt = 0; paramInt < k; paramInt++) {
      localArrayList.add(Integer.valueOf(paramParcel.readInt()));
    }
    paramParcel.setDataPosition(j + i);
    return localArrayList;
  }
  
  public static long[] createLongArray(Parcel paramParcel, int paramInt)
  {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0) {
      return null;
    }
    long[] arrayOfLong = paramParcel.createLongArray();
    paramParcel.setDataPosition(i + paramInt);
    return arrayOfLong;
  }
  
  public static ArrayList<Long> createLongList(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int k = paramParcel.readInt();
    for (paramInt = 0; paramInt < k; paramInt++) {
      localArrayList.add(Long.valueOf(paramParcel.readLong()));
    }
    paramParcel.setDataPosition(j + i);
    return localArrayList;
  }
  
  public static Parcel createParcel(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    paramInt = paramParcel.dataPosition();
    if (i == 0) {
      return null;
    }
    Parcel localParcel = Parcel.obtain();
    localParcel.appendFrom(paramParcel, paramInt, i);
    paramParcel.setDataPosition(paramInt + i);
    return localParcel;
  }
  
  public static Parcel[] createParcelArray(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0) {
      return null;
    }
    int k = paramParcel.readInt();
    Parcel[] arrayOfParcel = new Parcel[k];
    for (paramInt = 0; paramInt < k; paramInt++)
    {
      int m = paramParcel.readInt();
      if (m != 0)
      {
        int n = paramParcel.dataPosition();
        Parcel localParcel = Parcel.obtain();
        localParcel.appendFrom(paramParcel, n, m);
        arrayOfParcel[paramInt] = localParcel;
        paramParcel.setDataPosition(n + m);
      }
      else
      {
        arrayOfParcel[paramInt] = null;
      }
    }
    paramParcel.setDataPosition(j + i);
    return arrayOfParcel;
  }
  
  public static ArrayList<Parcel> createParcelList(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0) {
      return null;
    }
    int k = paramParcel.readInt();
    ArrayList localArrayList = new ArrayList();
    for (paramInt = 0; paramInt < k; paramInt++)
    {
      int m = paramParcel.readInt();
      if (m != 0)
      {
        int n = paramParcel.dataPosition();
        Parcel localParcel = Parcel.obtain();
        localParcel.appendFrom(paramParcel, n, m);
        localArrayList.add(localParcel);
        paramParcel.setDataPosition(n + m);
      }
      else
      {
        localArrayList.add(null);
      }
    }
    paramParcel.setDataPosition(j + i);
    return localArrayList;
  }
  
  public static SparseArray<Parcel> createParcelSparseArray(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0) {
      return null;
    }
    int k = paramParcel.readInt();
    SparseArray localSparseArray = new SparseArray();
    for (paramInt = 0; paramInt < k; paramInt++)
    {
      int m = paramParcel.readInt();
      int n = paramParcel.readInt();
      if (n != 0)
      {
        int i1 = paramParcel.dataPosition();
        Parcel localParcel = Parcel.obtain();
        localParcel.appendFrom(paramParcel, i1, n);
        localSparseArray.append(m, localParcel);
        paramParcel.setDataPosition(i1 + n);
      }
      else
      {
        localSparseArray.append(m, null);
      }
    }
    paramParcel.setDataPosition(j + i);
    return localSparseArray;
  }
  
  public static <T extends Parcelable> T createParcelable(Parcel paramParcel, int paramInt, Parcelable.Creator<T> paramCreator)
  {
    int i = readSize(paramParcel, paramInt);
    paramInt = paramParcel.dataPosition();
    if (i == 0) {
      return null;
    }
    paramCreator = (Parcelable)paramCreator.createFromParcel(paramParcel);
    paramParcel.setDataPosition(paramInt + i);
    return paramCreator;
  }
  
  public static SparseBooleanArray createSparseBooleanArray(Parcel paramParcel, int paramInt)
  {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0) {
      return null;
    }
    SparseBooleanArray localSparseBooleanArray = paramParcel.readSparseBooleanArray();
    paramParcel.setDataPosition(i + paramInt);
    return localSparseBooleanArray;
  }
  
  public static SparseIntArray createSparseIntArray(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0) {
      return null;
    }
    SparseIntArray localSparseIntArray = new SparseIntArray();
    int k = paramParcel.readInt();
    for (paramInt = 0; paramInt < k; paramInt++) {
      localSparseIntArray.append(paramParcel.readInt(), paramParcel.readInt());
    }
    paramParcel.setDataPosition(j + i);
    return localSparseIntArray;
  }
  
  public static SparseLongArray createSparseLongArray(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0) {
      return null;
    }
    SparseLongArray localSparseLongArray = new SparseLongArray();
    int k = paramParcel.readInt();
    for (paramInt = 0; paramInt < k; paramInt++) {
      localSparseLongArray.append(paramParcel.readInt(), paramParcel.readLong());
    }
    paramParcel.setDataPosition(j + i);
    return localSparseLongArray;
  }
  
  public static String createString(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    paramInt = paramParcel.dataPosition();
    if (i == 0) {
      return null;
    }
    String str = paramParcel.readString();
    paramParcel.setDataPosition(paramInt + i);
    return str;
  }
  
  public static String[] createStringArray(Parcel paramParcel, int paramInt)
  {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0) {
      return null;
    }
    String[] arrayOfString = paramParcel.createStringArray();
    paramParcel.setDataPosition(i + paramInt);
    return arrayOfString;
  }
  
  public static ArrayList<String> createStringList(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    paramInt = paramParcel.dataPosition();
    if (i == 0) {
      return null;
    }
    ArrayList localArrayList = paramParcel.createStringArrayList();
    paramParcel.setDataPosition(paramInt + i);
    return localArrayList;
  }
  
  public static SparseArray<String> createStringSparseArray(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0) {
      return null;
    }
    SparseArray localSparseArray = new SparseArray();
    int k = paramParcel.readInt();
    for (paramInt = 0; paramInt < k; paramInt++) {
      localSparseArray.append(paramParcel.readInt(), paramParcel.readString());
    }
    paramParcel.setDataPosition(j + i);
    return localSparseArray;
  }
  
  public static <T> T[] createTypedArray(Parcel paramParcel, int paramInt, Parcelable.Creator<T> paramCreator)
  {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0) {
      return null;
    }
    paramCreator = paramParcel.createTypedArray(paramCreator);
    paramParcel.setDataPosition(i + paramInt);
    return paramCreator;
  }
  
  public static <T> ArrayList<T> createTypedList(Parcel paramParcel, int paramInt, Parcelable.Creator<T> paramCreator)
  {
    int i = readSize(paramParcel, paramInt);
    paramInt = paramParcel.dataPosition();
    if (i == 0) {
      return null;
    }
    paramCreator = paramParcel.createTypedArrayList(paramCreator);
    paramParcel.setDataPosition(paramInt + i);
    return paramCreator;
  }
  
  public static <T> SparseArray<T> createTypedSparseArray(Parcel paramParcel, int paramInt, Parcelable.Creator<T> paramCreator)
  {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0) {
      return null;
    }
    int k = paramParcel.readInt();
    SparseArray localSparseArray = new SparseArray();
    for (paramInt = 0; paramInt < k; paramInt++)
    {
      int m = paramParcel.readInt();
      Object localObject;
      if (paramParcel.readInt() != 0) {
        localObject = paramCreator.createFromParcel(paramParcel);
      } else {
        localObject = null;
      }
      localSparseArray.append(m, localObject);
    }
    paramParcel.setDataPosition(j + i);
    return localSparseArray;
  }
  
  public static void ensureAtEnd(Parcel paramParcel, int paramInt)
  {
    if (paramParcel.dataPosition() == paramInt) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder(37);
    localStringBuilder.append("Overread allowed size end=");
    localStringBuilder.append(paramInt);
    throw new ParseException(localStringBuilder.toString(), paramParcel);
  }
  
  public static int getFieldId(int paramInt)
  {
    return paramInt & 0xFFFF;
  }
  
  public static boolean readBoolean(Parcel paramParcel, int paramInt)
  {
    zza(paramParcel, paramInt, 4);
    return paramParcel.readInt() != 0;
  }
  
  public static Boolean readBooleanObject(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    if (i == 0) {
      return null;
    }
    zza(paramParcel, paramInt, i, 4);
    boolean bool;
    if (paramParcel.readInt() != 0) {
      bool = true;
    } else {
      bool = false;
    }
    return Boolean.valueOf(bool);
  }
  
  public static byte readByte(Parcel paramParcel, int paramInt)
  {
    zza(paramParcel, paramInt, 4);
    return (byte)paramParcel.readInt();
  }
  
  public static char readChar(Parcel paramParcel, int paramInt)
  {
    zza(paramParcel, paramInt, 4);
    return (char)paramParcel.readInt();
  }
  
  public static double readDouble(Parcel paramParcel, int paramInt)
  {
    zza(paramParcel, paramInt, 8);
    return paramParcel.readDouble();
  }
  
  public static Double readDoubleObject(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    if (i == 0) {
      return null;
    }
    zza(paramParcel, paramInt, i, 8);
    return Double.valueOf(paramParcel.readDouble());
  }
  
  public static float readFloat(Parcel paramParcel, int paramInt)
  {
    zza(paramParcel, paramInt, 4);
    return paramParcel.readFloat();
  }
  
  public static Float readFloatObject(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    if (i == 0) {
      return null;
    }
    zza(paramParcel, paramInt, i, 4);
    return Float.valueOf(paramParcel.readFloat());
  }
  
  public static int readHeader(Parcel paramParcel)
  {
    return paramParcel.readInt();
  }
  
  public static IBinder readIBinder(Parcel paramParcel, int paramInt)
  {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0) {
      return null;
    }
    IBinder localIBinder = paramParcel.readStrongBinder();
    paramParcel.setDataPosition(i + paramInt);
    return localIBinder;
  }
  
  public static int readInt(Parcel paramParcel, int paramInt)
  {
    zza(paramParcel, paramInt, 4);
    return paramParcel.readInt();
  }
  
  public static Integer readIntegerObject(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    if (i == 0) {
      return null;
    }
    zza(paramParcel, paramInt, i, 4);
    return Integer.valueOf(paramParcel.readInt());
  }
  
  public static void readList(Parcel paramParcel, int paramInt, List paramList, ClassLoader paramClassLoader)
  {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0) {
      return;
    }
    paramParcel.readList(paramList, paramClassLoader);
    paramParcel.setDataPosition(i + paramInt);
  }
  
  public static long readLong(Parcel paramParcel, int paramInt)
  {
    zza(paramParcel, paramInt, 8);
    return paramParcel.readLong();
  }
  
  public static Long readLongObject(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    if (i == 0) {
      return null;
    }
    zza(paramParcel, paramInt, i, 8);
    return Long.valueOf(paramParcel.readLong());
  }
  
  public static short readShort(Parcel paramParcel, int paramInt)
  {
    zza(paramParcel, paramInt, 4);
    return (short)paramParcel.readInt();
  }
  
  public static int readSize(Parcel paramParcel, int paramInt)
  {
    if ((paramInt & 0xFFFF0000) != -65536) {
      return paramInt >> 16 & 0xFFFF;
    }
    return paramParcel.readInt();
  }
  
  public static void skipUnknownField(Parcel paramParcel, int paramInt)
  {
    paramInt = readSize(paramParcel, paramInt);
    paramParcel.setDataPosition(paramParcel.dataPosition() + paramInt);
  }
  
  public static int validateObjectHeader(Parcel paramParcel)
  {
    int i = readHeader(paramParcel);
    int j = readSize(paramParcel, i);
    int k = paramParcel.dataPosition();
    if (getFieldId(i) != 20293)
    {
      localObject = String.valueOf(Integer.toHexString(i));
      if (((String)localObject).length() != 0) {
        localObject = "Expected object header. Got 0x".concat((String)localObject);
      } else {
        localObject = new String("Expected object header. Got 0x");
      }
      throw new ParseException((String)localObject, paramParcel);
    }
    i = j + k;
    if ((i >= k) && (i <= paramParcel.dataSize())) {
      return i;
    }
    Object localObject = new StringBuilder(54);
    ((StringBuilder)localObject).append("Size read is invalid start=");
    ((StringBuilder)localObject).append(k);
    ((StringBuilder)localObject).append(" end=");
    ((StringBuilder)localObject).append(i);
    throw new ParseException(((StringBuilder)localObject).toString(), paramParcel);
  }
  
  private static void zza(Parcel paramParcel, int paramInt1, int paramInt2)
  {
    paramInt1 = readSize(paramParcel, paramInt1);
    if (paramInt1 == paramInt2) {
      return;
    }
    String str = Integer.toHexString(paramInt1);
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(str).length() + 46);
    localStringBuilder.append("Expected size ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(" got ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" (0x");
    localStringBuilder.append(str);
    localStringBuilder.append(")");
    throw new ParseException(localStringBuilder.toString(), paramParcel);
  }
  
  private static void zza(Parcel paramParcel, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 == paramInt3) {
      return;
    }
    String str = Integer.toHexString(paramInt2);
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(str).length() + 46);
    localStringBuilder.append("Expected size ");
    localStringBuilder.append(paramInt3);
    localStringBuilder.append(" got ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(" (0x");
    localStringBuilder.append(str);
    localStringBuilder.append(")");
    throw new ParseException(localStringBuilder.toString(), paramParcel);
  }
  
  public static class ParseException
    extends RuntimeException
  {
    public ParseException(String paramString, Parcel paramParcel)
    {
      super();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\internal\safeparcel\SafeParcelReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */