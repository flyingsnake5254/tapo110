package com.tplink.iot.view.ipcamera.setting;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.tplink.iot.widget.CustomTimePicker;

public class ModeTimePickerDialog
  extends DialogFragment
{
  String c;
  int d;
  int f;
  boolean q;
  @BindView
  TextView startOrEndTv;
  @BindView
  CustomTimePicker timePicker;
  private Unbinder x;
  a y;
  
  protected View A0(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2131558827, paramViewGroup);
  }
  
  protected void B0() {}
  
  protected void C0()
  {
    this.startOrEndTv.setText(this.c);
    this.timePicker.setCurrentHour(this.d);
    this.timePicker.setCurrentMinute(this.f);
  }
  
  @OnClick
  public void onCancelClick()
  {
    dismiss();
  }
  
  @OnClick
  public void onConfirmClick()
  {
    dismiss();
    a locala = this.y;
    if (locala != null) {
      locala.n(this.timePicker.getCurrentHour(), this.timePicker.getCurrentMinute(), this.q);
    }
  }
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    getDialog().requestWindowFeature(1);
    return A0(paramLayoutInflater, paramViewGroup, paramBundle);
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    this.x.a();
  }
  
  public void onViewCreated(View paramView, @Nullable Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.x = ButterKnife.b(this, paramView);
    B0();
    C0();
  }
  
  public static abstract interface a
  {
    public abstract void n(int paramInt1, int paramInt2, boolean paramBoolean);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\setting\ModeTimePickerDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */