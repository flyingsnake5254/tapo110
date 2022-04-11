package com.tplink.iot.widget;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import java.util.HashMap;
import kotlin.jvm.internal.j;
import kotlin.p;

public final class HMSPickerDialog
  extends AppCompatDialogFragment
  implements View.OnClickListener
{
  public static final a c = new a(null);
  private b d;
  private View f;
  private int p0 = 60;
  private final int p1 = 86399;
  private HashMap p2;
  private View q;
  private NumberPickerView x;
  private NumberPickerView y;
  private NumberPickerView z;
  
  private final int B0()
  {
    NumberPickerView localNumberPickerView = this.x;
    if (localNumberPickerView == null) {
      j.t("hourPicker");
    }
    int i = localNumberPickerView.getValue();
    localNumberPickerView = this.y;
    if (localNumberPickerView == null) {
      j.t("minPicker");
    }
    int j = localNumberPickerView.getValue();
    localNumberPickerView = this.z;
    if (localNumberPickerView == null) {
      j.t("secPicker");
    }
    return 3600 * i + 60 * j + localNumberPickerView.getValue();
  }
  
  private final void C0(Dialog paramDialog)
  {
    View localView = LayoutInflater.from(getContext()).inflate(2131558791, null);
    paramDialog.requestWindowFeature(1);
    paramDialog.setContentView(localView);
    paramDialog.setCanceledOnTouchOutside(false);
    Window localWindow = paramDialog.getWindow();
    if (localWindow != null)
    {
      j.d(localWindow, "dialogWindow");
      paramDialog = localWindow.getAttributes();
      if (paramDialog != null)
      {
        paramDialog.width = -1;
        paramDialog.height = -2;
        localWindow.setAttributes(paramDialog);
      }
      localWindow.setGravity(80);
      localWindow.setWindowAnimations(2132017398);
    }
    j.d(localView, "view");
    G0(localView);
  }
  
  private final void G0(View paramView)
  {
    Object localObject = paramView.findViewById(2131364359);
    j.d(localObject, "view.findViewById(R.id.tv_cancel)");
    this.f = ((View)localObject);
    localObject = paramView.findViewById(2131364423);
    j.d(localObject, "view.findViewById(R.id.tv_done)");
    this.q = ((View)localObject);
    localObject = this.f;
    if (localObject == null) {
      j.t("cancelView");
    }
    ((View)localObject).setOnClickListener(this);
    localObject = this.q;
    if (localObject == null) {
      j.t("doneView");
    }
    ((View)localObject).setOnClickListener(this);
    localObject = paramView.findViewById(2131362784);
    j.d(localObject, "view.findViewById(R.id.hour_picker)");
    localObject = (NumberPickerView)localObject;
    this.x = ((NumberPickerView)localObject);
    if (localObject == null) {
      j.t("hourPicker");
    }
    ((NumberPickerView)localObject).setWrapSelectorWheel(false);
    localObject = paramView.findViewById(2131363458);
    j.d(localObject, "view.findViewById(R.id.min_picker)");
    localObject = (NumberPickerView)localObject;
    this.y = ((NumberPickerView)localObject);
    if (localObject == null) {
      j.t("minPicker");
    }
    ((NumberPickerView)localObject).setWrapSelectorWheel(false);
    paramView = paramView.findViewById(2131363994);
    j.d(paramView, "view.findViewById(R.id.sec_picker)");
    paramView = (NumberPickerView)paramView;
    this.z = paramView;
    if (paramView == null) {
      j.t("secPicker");
    }
    paramView.setWrapSelectorWheel(false);
    paramView = this.x;
    if (paramView == null) {
      j.t("hourPicker");
    }
    paramView.S(h.b());
    paramView = this.y;
    if (paramView == null) {
      j.t("minPicker");
    }
    paramView.S(h.f());
    paramView = this.z;
    if (paramView == null) {
      j.t("secPicker");
    }
    paramView.S(h.i());
    I0(this.p0);
  }
  
  private final void I0(int paramInt)
  {
    if ((paramInt > 0) && (paramInt <= this.p1))
    {
      int i = paramInt / 3600;
      paramInt %= 3600;
      int j = paramInt / 60;
      NumberPickerView localNumberPickerView = this.x;
      if (localNumberPickerView == null) {
        j.t("hourPicker");
      }
      localNumberPickerView.setValue(i);
      localNumberPickerView = this.y;
      if (localNumberPickerView == null) {
        j.t("minPicker");
      }
      localNumberPickerView.setValue(j);
      localNumberPickerView = this.z;
      if (localNumberPickerView == null) {
        j.t("secPicker");
      }
      localNumberPickerView.setValue(paramInt % 60);
    }
  }
  
  public void A0()
  {
    HashMap localHashMap = this.p2;
    if (localHashMap != null) {
      localHashMap.clear();
    }
  }
  
  public final void H0(b paramb)
  {
    j.e(paramb, "onTimeSelectListener");
    this.d = paramb;
  }
  
  public void onClick(View paramView)
  {
    j.e(paramView, "v");
    View localView = this.f;
    if (localView == null) {
      j.t("cancelView");
    }
    if (j.a(paramView, localView))
    {
      dismiss();
    }
    else
    {
      localView = this.q;
      if (localView == null) {
        j.t("doneView");
      }
      if (j.a(paramView, localView))
      {
        paramView = this.d;
        if (paramView != null) {
          paramView.a(this, B0());
        }
        dismiss();
      }
    }
  }
  
  public Dialog onCreateDialog(Bundle paramBundle)
  {
    paramBundle = getArguments();
    if (paramBundle != null) {
      this.p0 = paramBundle.getInt("time");
    }
    paramBundle = getActivity();
    j.c(paramBundle);
    paramBundle = new Dialog(paramBundle, 2132017398);
    C0(paramBundle);
    return paramBundle;
  }
  
  public static final class a
  {
    public final HMSPickerDialog a(int paramInt)
    {
      HMSPickerDialog localHMSPickerDialog = new HMSPickerDialog();
      Bundle localBundle = new Bundle();
      localBundle.putInt("time", paramInt);
      p localp = p.a;
      localHMSPickerDialog.setArguments(localBundle);
      return localHMSPickerDialog;
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(HMSPickerDialog paramHMSPickerDialog, int paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\HMSPickerDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */