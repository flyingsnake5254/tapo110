package com.tplink.iot.view.ipcamera.play;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.view.ipcamera.widget.touchlayout.TouchListenerConstraintLayout;
import com.tplink.iot.viewmodel.ipcamera.play.TalkViewModel;
import io.reactivex.q;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class CameraAudioDialogFragment
  extends AppCompatDialogFragment
{
  @SuppressLint({"ClickableViewAccessibility"})
  protected View.OnTouchListener H3 = new b(this);
  protected boolean c;
  protected boolean d;
  protected DialogInterface.OnDismissListener f;
  protected int p0 = -1;
  protected int p1 = -1;
  protected TalkViewModel p2;
  protected io.reactivex.e0.c p3;
  protected boolean q;
  protected View.OnTouchListener x;
  protected TouchListenerConstraintLayout y;
  protected int z = -1;
  
  private void G0(Window paramWindow)
  {
    paramWindow.setFlags(1024, 1024);
    paramWindow.getDecorView().setSystemUiVisibility(2566);
  }
  
  public void A0(View paramView, int paramInt1, int paramInt2)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    this.p0 = (arrayOfInt[0] + paramInt1 + paramView.getWidth());
    this.p1 = (arrayOfInt[1] + paramInt2);
  }
  
  public void B0(View paramView, int paramInt1, int paramInt2)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    this.p0 = (arrayOfInt[0] + paramInt1 + paramView.getWidth());
    this.z = (arrayOfInt[1] + paramInt2);
  }
  
  public void C0(boolean paramBoolean)
  {
    if (this.q) {
      return;
    }
    this.d = paramBoolean;
    dismissAllowingStateLoss();
  }
  
  protected void O0()
  {
    io.reactivex.e0.c localc = this.p3;
    if ((localc != null) && (!localc.isDisposed())) {
      this.p3.dispose();
    }
    this.p3 = q.W0(1L, TimeUnit.SECONDS).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).G0(new a(this));
  }
  
  public void P0(View.OnTouchListener paramOnTouchListener)
  {
    this.x = paramOnTouchListener;
    TouchListenerConstraintLayout localTouchListenerConstraintLayout = this.y;
    if (localTouchListenerConstraintLayout != null) {
      localTouchListenerConstraintLayout.setDispatchEventListener(paramOnTouchListener);
    }
  }
  
  public void Q0(DialogInterface.OnDismissListener paramOnDismissListener)
  {
    this.f = paramOnDismissListener;
  }
  
  protected void R0(TouchListenerConstraintLayout paramTouchListenerConstraintLayout)
  {
    this.y = paramTouchListenerConstraintLayout;
    View.OnTouchListener localOnTouchListener = this.x;
    if (localOnTouchListener != null) {
      paramTouchListenerConstraintLayout.setDispatchEventListener(localOnTouchListener);
    }
  }
  
  public void onActivityCreated(@Nullable Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    if (getActivity() != null) {
      this.p2 = ((TalkViewModel)ViewModelProviders.of(getActivity()).get(TalkViewModel.class));
    }
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if (!this.d)
    {
      localObject = this.p3;
      if ((localObject != null) && (!((io.reactivex.e0.c)localObject).isDisposed())) {
        this.p3.dispose();
      }
    }
    Object localObject = this.p2;
    if (localObject != null) {
      ((TalkViewModel)localObject).N();
    }
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.q) {
      return;
    }
    this.q = true;
    super.onDismiss(paramDialogInterface);
    DialogInterface.OnDismissListener localOnDismissListener = this.f;
    if (localOnDismissListener != null) {
      localOnDismissListener.onDismiss(paramDialogInterface);
    }
  }
  
  public void onViewCreated(@NonNull View paramView, @Nullable Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    paramView = getArguments();
    Objects.requireNonNull(paramView);
    this.c = ((Bundle)paramView).getBoolean("isFullScreen");
    if ((getDialog() != null) && (this.c))
    {
      paramView = getDialog().getWindow();
      if (paramView != null)
      {
        paramView.addFlags(8);
        getDialog().setOnShowListener(new c(this, paramView));
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\play\CameraAudioDialogFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */