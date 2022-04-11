package kotlin.collections;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class h
  extends g
{
  public static <T> List<T> b(T[] paramArrayOfT)
  {
    kotlin.jvm.internal.j.e(paramArrayOfT, "$this$asList");
    paramArrayOfT = j.a(paramArrayOfT);
    kotlin.jvm.internal.j.d(paramArrayOfT, "ArraysUtilJVM.asList(this)");
    return paramArrayOfT;
  }
  
  public static final <T> T[] c(T[] paramArrayOfT1, T[] paramArrayOfT2, int paramInt1, int paramInt2, int paramInt3)
  {
    kotlin.jvm.internal.j.e(paramArrayOfT1, "$this$copyInto");
    kotlin.jvm.internal.j.e(paramArrayOfT2, "destination");
    System.arraycopy(paramArrayOfT1, paramInt2, paramArrayOfT2, paramInt1, paramInt3 - paramInt2);
    return paramArrayOfT2;
  }
  
  public static byte[] e(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    kotlin.jvm.internal.j.e(paramArrayOfByte, "$this$copyOfRangeImpl");
    f.a(paramInt2, paramArrayOfByte.length);
    paramArrayOfByte = Arrays.copyOfRange(paramArrayOfByte, paramInt1, paramInt2);
    kotlin.jvm.internal.j.d(paramArrayOfByte, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
    return paramArrayOfByte;
  }
  
  public static final void f(int[] paramArrayOfInt)
  {
    kotlin.jvm.internal.j.e(paramArrayOfInt, "$this$sort");
    if (paramArrayOfInt.length > 1) {
      Arrays.sort(paramArrayOfInt);
    }
  }
  
  public static final <T> void g(T[] paramArrayOfT)
  {
    kotlin.jvm.internal.j.e(paramArrayOfT, "$this$sort");
    if (paramArrayOfT.length > 1) {
      Arrays.sort(paramArrayOfT);
    }
  }
  
  public static final <T> void h(T[] paramArrayOfT, Comparator<? super T> paramComparator)
  {
    kotlin.jvm.internal.j.e(paramArrayOfT, "$this$sortWith");
    kotlin.jvm.internal.j.e(paramComparator, "comparator");
    if (paramArrayOfT.length > 1) {
      Arrays.sort(paramArrayOfT, paramComparator);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\collections\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */