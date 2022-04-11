package androidx.core.os;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.UserManager;
import androidx.annotation.NonNull;

public class UserManagerCompat
{
  public static boolean isUserUnlocked(@NonNull Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return ((UserManager)paramContext.getSystemService(UserManager.class)).isUserUnlocked();
    }
    return true;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\os\UserManagerCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */