package com.tplink.iot.view.ipcamera.play;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import b.d.w.f.a;
import com.tplink.iot.databinding.ViewCloudTerraceControlSensitivityPanelBinding;
import com.tplink.iot.view.ipcamera.widget.touchlayout.TouchListenerCardView;

public class CloudTerraceSensitivityDialogFragment
  extends DialogFragment
{
  public static final String c = CloudTerraceSensitivityDialogFragment.class.getSimpleName();
  public final MutableLiveData<Integer> d = new MutableLiveData();
  ViewCloudTerraceControlSensitivityPanelBinding f;
  private View.OnTouchListener q;
  private int x = -1;
  private int y = -1;
  private a z;
  
  public static CloudTerraceSensitivityDialogFragment N0()
  {
    return new CloudTerraceSensitivityDialogFragment();
  }
  
  public void A0(View paramView, int paramInt1, int paramInt2)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    this.y = (arrayOfInt[0] + paramInt1 + paramView.getWidth());
    this.x = (arrayOfInt[1] + paramInt2);
  }
  
  public void O0(View.OnTouchListener paramOnTouchListener)
  {
    this.q = paramOnTouchListener;
    ViewCloudTerraceControlSensitivityPanelBinding localViewCloudTerraceControlSensitivityPanelBinding = this.f;
    if (localViewCloudTerraceControlSensitivityPanelBinding != null) {
      localViewCloudTerraceControlSensitivityPanelBinding.c.setDispatchEventListener(paramOnTouchListener);
    }
  }
  
  public void P0(a parama)
  {
    this.z = parama;
    this.d.setValue(Integer.valueOf(parama.c()));
  }
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    paramLayoutInflater = (ViewCloudTerraceControlSensitivityPanelBinding)DataBindingUtil.inflate(paramLayoutInflater, 2131559405, paramViewGroup, true);
    this.f = paramLayoutInflater;
    if (paramLayoutInflater != null)
    {
      paramLayoutInflater.setLifecycleOwner(this);
      this.f.h(this.d);
      this.f.q.setOnClickListener(new k(this));
      this.f.x.setOnClickListener(new m(this));
      this.f.f.setOnClickListener(new j(this));
      this.f.i(new l(this));
      paramLayoutInflater = this.q;
      if (paramLayoutInflater != null) {
        this.f.c.setDispatchEventListener(paramLayoutInflater);
      }
      return this.f.getRoot();
    }
    return null;
  }
  
  public void onStart()
  {
    super.onStart();
    Window localWindow = getDialog().getWindow();
    localWindow.setBackgroundDrawable(new ColorDrawable(-1));
    localWindow.setDimAmount(0.0F);
    Object localObject = new DisplayMetrics();
    getActivity().getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
    localObject = localWindow.getAttributes();
    int i = a.a(getActivity(), 280.0F);
    ((WindowManager.LayoutParams)localObject).width = i;
    ((WindowManager.LayoutParams)localObject).height = -2;
    ((WindowManager.LayoutParams)localObject).gravity = 8388659;
    ((WindowManager.LayoutParams)localObject).x = (this.y - i);
    ((WindowManager.LayoutParams)localObject).y = this.x;
    localWindow.setAttributes((WindowManager.LayoutParams)localObject);
  }
  
  public void onStop()
  {
    super.onStop();
    a locala = this.z;
    if (locala != null) {
      locala.d(((Integer)this.d.getValue()).intValue());
    }
  }
  
  public static abstract interface a
  {
    public abstract int c();
    
    public abstract void d(int paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\play\CloudTerraceSensitivityDialogFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */