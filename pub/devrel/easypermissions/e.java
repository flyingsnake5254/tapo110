package pub.devrel.easypermissions;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.StringRes;

@RequiresApi(11)
public class e
  extends DialogFragment
{
  private EasyPermissions.PermissionCallbacks c;
  
  static e a(@StringRes int paramInt1, @StringRes int paramInt2, @NonNull String paramString, int paramInt3, @NonNull String[] paramArrayOfString)
  {
    e locale = new e();
    locale.setArguments(new d(paramInt1, paramInt2, paramString, paramInt3, paramArrayOfString).b());
    return locale;
  }
  
  @SuppressLint({"NewApi"})
  public void onAttach(Context paramContext)
  {
    super.onAttach(paramContext);
    int i;
    if (Build.VERSION.SDK_INT >= 17) {
      i = 1;
    } else {
      i = 0;
    }
    if ((i != 0) && (getParentFragment() != null) && ((getParentFragment() instanceof EasyPermissions.PermissionCallbacks))) {
      this.c = ((EasyPermissions.PermissionCallbacks)getParentFragment());
    } else if ((paramContext instanceof EasyPermissions.PermissionCallbacks)) {
      this.c = ((EasyPermissions.PermissionCallbacks)paramContext);
    }
  }
  
  @NonNull
  public Dialog onCreateDialog(Bundle paramBundle)
  {
    setCancelable(false);
    d locald = new d(getArguments());
    paramBundle = new c(this, locald, this.c);
    return locald.a(getActivity(), paramBundle);
  }
  
  public void onDetach()
  {
    super.onDetach();
    this.c = null;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\pub\devrel\easypermissions\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */