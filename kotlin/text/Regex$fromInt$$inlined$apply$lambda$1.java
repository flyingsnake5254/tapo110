package kotlin.text;

import kotlin.jvm.b.l;
import kotlin.jvm.internal.Lambda;

public final class Regex$fromInt$$inlined$apply$lambda$1
  extends Lambda
  implements l<T, Boolean>
{
  public Regex$fromInt$$inlined$apply$lambda$1(int paramInt)
  {
    super(1);
  }
  
  public final boolean invoke(T paramT)
  {
    int i = this.$value$inlined;
    paramT = (f)paramT;
    boolean bool;
    if ((i & paramT.getMask()) == paramT.getValue()) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\text\Regex$fromInt$$inlined$apply$lambda$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */