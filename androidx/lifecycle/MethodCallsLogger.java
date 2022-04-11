package androidx.lifecycle;

import androidx.annotation.RestrictTo;
import java.util.HashMap;
import java.util.Map;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class MethodCallsLogger
{
  private Map<String, Integer> mCalledMethods = new HashMap();
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public boolean approveCall(String paramString, int paramInt)
  {
    Integer localInteger = (Integer)this.mCalledMethods.get(paramString);
    int i = 0;
    int j;
    if (localInteger != null) {
      j = localInteger.intValue();
    } else {
      j = 0;
    }
    if ((j & paramInt) != 0) {
      i = 1;
    }
    this.mCalledMethods.put(paramString, Integer.valueOf(paramInt | j));
    return i ^ 0x1;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\lifecycle\MethodCallsLogger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */