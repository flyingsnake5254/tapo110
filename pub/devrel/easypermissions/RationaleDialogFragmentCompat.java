package pub.devrel.easypermissions;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

@RequiresApi(17)
public class RationaleDialogFragmentCompat
  extends AppCompatDialogFragment
{
  private EasyPermissions.PermissionCallbacks c;
  
  static RationaleDialogFragmentCompat A0(@StringRes int paramInt1, @StringRes int paramInt2, @NonNull String paramString, int paramInt3, @NonNull String[] paramArrayOfString)
  {
    RationaleDialogFragmentCompat localRationaleDialogFragmentCompat = new RationaleDialogFragmentCompat();
    localRationaleDialogFragmentCompat.setArguments(new d(paramInt1, paramInt2, paramString, paramInt3, paramArrayOfString).b());
    return localRationaleDialogFragmentCompat;
  }
  
  public void onAttach(Context paramContext)
  {
    super.onAttach(paramContext);
    if ((getParentFragment() != null) && ((getParentFragment() instanceof EasyPermissions.PermissionCallbacks))) {
      this.c = ((EasyPermissions.PermissionCallbacks)getParentFragment());
    } else if ((paramContext instanceof EasyPermissions.PermissionCallbacks)) {
      this.c = ((EasyPermissions.PermissionCallbacks)paramContext);
    }
  }
  
  @NonNull
  public Dialog onCreateDialog(Bundle paramBundle)
  {
    setCancelable(false);
    paramBundle = new d(getArguments());
    c localc = new c(this, paramBundle, this.c);
    return paramBundle.a(getContext(), localc);
  }
  
  public void onDetach()
  {
    super.onDetach();
    this.c = null;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\pub\devrel\easypermissions\RationaleDialogFragmentCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */