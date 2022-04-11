package pub.devrel.easypermissions;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Build.VERSION;
import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;
import java.util.Arrays;

class c
  implements DialogInterface.OnClickListener
{
  private Object c;
  private d d;
  private EasyPermissions.PermissionCallbacks f;
  
  c(RationaleDialogFragmentCompat paramRationaleDialogFragmentCompat, d paramd, EasyPermissions.PermissionCallbacks paramPermissionCallbacks)
  {
    if (paramRationaleDialogFragmentCompat.getParentFragment() != null) {
      paramRationaleDialogFragmentCompat = paramRationaleDialogFragmentCompat.getParentFragment();
    } else {
      paramRationaleDialogFragmentCompat = paramRationaleDialogFragmentCompat.getActivity();
    }
    this.c = paramRationaleDialogFragmentCompat;
    this.d = paramd;
    this.f = paramPermissionCallbacks;
  }
  
  @RequiresApi(api=11)
  c(e parame, d paramd, EasyPermissions.PermissionCallbacks paramPermissionCallbacks)
  {
    if (Build.VERSION.SDK_INT >= 17)
    {
      if (parame.getParentFragment() != null) {
        parame = parame.getParentFragment();
      } else {
        parame = parame.getActivity();
      }
      this.c = parame;
    }
    else
    {
      this.c = parame.getActivity();
    }
    this.d = paramd;
    this.f = paramPermissionCallbacks;
  }
  
  private void a()
  {
    EasyPermissions.PermissionCallbacks localPermissionCallbacks = this.f;
    if (localPermissionCallbacks != null)
    {
      d locald = this.d;
      localPermissionCallbacks.t(locald.c, Arrays.asList(locald.e));
    }
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == -1)
    {
      paramDialogInterface = this.c;
      Object localObject;
      if ((paramDialogInterface instanceof androidx.fragment.app.Fragment))
      {
        paramDialogInterface = (androidx.fragment.app.Fragment)paramDialogInterface;
        localObject = this.d;
        paramDialogInterface.requestPermissions(((d)localObject).e, ((d)localObject).c);
      }
      else if ((paramDialogInterface instanceof android.app.Fragment))
      {
        if (Build.VERSION.SDK_INT >= 23)
        {
          localObject = (android.app.Fragment)paramDialogInterface;
          paramDialogInterface = this.d;
          ((android.app.Fragment)localObject).requestPermissions(paramDialogInterface.e, paramDialogInterface.c);
        }
        else
        {
          throw new IllegalArgumentException("Target SDK needs to be greater than 23 if caller is android.app.Fragment");
        }
      }
      else if ((paramDialogInterface instanceof FragmentActivity))
      {
        localObject = (FragmentActivity)paramDialogInterface;
        paramDialogInterface = this.d;
        ActivityCompat.requestPermissions((Activity)localObject, paramDialogInterface.e, paramDialogInterface.c);
      }
    }
    else
    {
      a();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\pub\devrel\easypermissions\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */