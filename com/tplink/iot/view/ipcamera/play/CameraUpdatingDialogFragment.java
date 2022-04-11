package com.tplink.iot.view.ipcamera.play;

import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.fragment.app.DialogFragment;
import java.util.HashMap;
import kotlin.jvm.internal.j;

public final class CameraUpdatingDialogFragment
  extends AppCompatDialogFragment
{
  private final Handler c = new Handler(Looper.getMainLooper());
  private final Runnable d = new a(this);
  private HashMap f;
  
  public void A0()
  {
    HashMap localHashMap = this.f;
    if (localHashMap != null) {
      localHashMap.clear();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setStyle(1, 2132017401);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    j.e(paramLayoutInflater, "inflater");
    paramBundle = getDialog();
    if (paramBundle != null) {
      paramBundle.setCanceledOnTouchOutside(false);
    }
    return paramLayoutInflater.inflate(2131558777, paramViewGroup, false);
  }
  
  public void onStart()
  {
    super.onStart();
    Object localObject = getDialog();
    if (localObject != null)
    {
      localObject = ((Dialog)localObject).getWindow();
      if (localObject != null)
      {
        localObject = ((Window)localObject).getAttributes();
        if (localObject != null) {
          ((WindowManager.LayoutParams)localObject).dimAmount = 0.0F;
        }
      }
    }
    localObject = getDialog();
    if (localObject != null)
    {
      localObject = ((Dialog)localObject).getWindow();
      if (localObject != null) {
        ((Window)localObject).addFlags(2);
      }
    }
    this.c.removeCallbacks(this.d);
    this.c.postDelayed(this.d, 1250L);
  }
  
  static final class a
    implements Runnable
  {
    a(CameraUpdatingDialogFragment paramCameraUpdatingDialogFragment) {}
    
    public final void run()
    {
      this.c.dismissAllowingStateLoss();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\play\CameraUpdatingDialogFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */