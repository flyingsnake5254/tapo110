package b.c.a;

import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class b
  implements e
{
  @NonNull
  private final Handler a;
  
  public b(@NonNull Handler paramHandler)
  {
    this.a = ((Handler)k.a(paramHandler));
  }
  
  public void a(int paramInt, @Nullable String paramString1, @NonNull String paramString2)
  {
    k.a(paramString2);
    paramString1 = this.a;
    paramString1.sendMessage(paramString1.obtainMessage(paramInt, paramString2));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\c\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */