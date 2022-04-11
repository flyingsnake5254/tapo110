package org.greenrobot.eventbus.util;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

public class ErrorDialogFragments
{
  public static int a;
  public static Class<?> b;
  
  public static Dialog a(Context paramContext, Bundle paramBundle, DialogInterface.OnClickListener paramOnClickListener)
  {
    paramContext = new AlertDialog.Builder(paramContext);
    paramContext.setTitle(paramBundle.getString("de.greenrobot.eventbus.errordialog.title"));
    paramContext.setMessage(paramBundle.getString("de.greenrobot.eventbus.errordialog.message"));
    int i = a;
    if (i != 0) {
      paramContext.setIcon(i);
    }
    paramContext.setPositiveButton(17039370, paramOnClickListener);
    return paramContext.create();
  }
  
  public static void b(DialogInterface paramDialogInterface, int paramInt, Activity paramActivity, Bundle paramBundle)
  {
    paramDialogInterface = b;
    if (paramDialogInterface == null)
    {
      if ((paramBundle.getBoolean("de.greenrobot.eventbus.errordialog.finish_after_dialog", false)) && (paramActivity != null)) {
        paramActivity.finish();
      }
      return;
    }
    try
    {
      paramDialogInterface.newInstance();
      throw null;
    }
    catch (Exception paramDialogInterface)
    {
      throw new RuntimeException("Event cannot be constructed", paramDialogInterface);
    }
  }
  
  public static class Support
    extends DialogFragment
    implements DialogInterface.OnClickListener
  {
    public void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      ErrorDialogFragments.b(paramDialogInterface, paramInt, getActivity(), getArguments());
    }
    
    public Dialog onCreateDialog(Bundle paramBundle)
    {
      return ErrorDialogFragments.a(getActivity(), getArguments(), this);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\greenrobot\eventbus\util\ErrorDialogFragments.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */