package b.a.a.a.a.a;

import android.net.NetworkInfo.State;
import io.reactivex.g0.l;

public class b
{
  protected static int[] a(int[] paramArrayOfInt)
  {
    int[] arrayOfInt = new int[paramArrayOfInt.length + 1];
    int i = paramArrayOfInt.length;
    int j = 0;
    int k = 0;
    while (j < i)
    {
      arrayOfInt[k] = paramArrayOfInt[j];
      k++;
      j++;
    }
    arrayOfInt[k] = -1;
    return arrayOfInt;
  }
  
  public static l<a> b(NetworkInfo.State... paramVarArgs)
  {
    return new a();
  }
  
  public static l<a> c(int... paramVarArgs)
  {
    return new b(a(paramVarArgs));
  }
  
  class a
    implements l<a>
  {
    a() {}
    
    public boolean a(a parama)
      throws Exception
    {
      for (NetworkInfo.State localState : b.this) {
        if (parama.h() == localState) {
          return true;
        }
      }
      return false;
    }
  }
  
  class b
    implements l<a>
  {
    b() {}
    
    public boolean a(a parama)
      throws Exception
    {
      for (int k : b.this) {
        if (parama.i() == k) {
          return true;
        }
      }
      return false;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\a\a\a\a\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */