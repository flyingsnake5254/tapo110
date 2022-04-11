package com.tplink.iot.widget;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

public class TimeScrollPickerDialog
  extends AppCompatDialogFragment
  implements View.OnClickListener, InnerTimePicker.a
{
  private InnerTimePicker c;
  private a d;
  private TextView f;
  private boolean q = false;
  private int x;
  private boolean y;
  private int z;
  
  public static TimeScrollPickerDialog A0(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    TimeScrollPickerDialog localTimeScrollPickerDialog = new TimeScrollPickerDialog();
    Bundle localBundle = new Bundle();
    localBundle.putInt("time", paramInt1);
    localBundle.putBoolean("is_next_day_mode", paramBoolean1);
    localBundle.putBoolean("is_start_time", paramBoolean2);
    localBundle.putInt("start_or_end_time", paramInt2);
    localTimeScrollPickerDialog.setArguments(localBundle);
    return localTimeScrollPickerDialog;
  }
  
  private void C0(int paramInt)
  {
    if (this.q) {
      if ((this.y) && (this.z > paramInt)) {
        this.f.setVisibility(0);
      } else {
        this.f.setVisibility(8);
      }
    }
  }
  
  public void B0(a parama)
  {
    this.d = parama;
  }
  
  public void m()
  {
    int i = this.c.getMinutesOfDay();
    if (this.z == i) {
      this.c.c(i + 1);
    }
    C0(this.c.getMinutesOfDay());
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131364359)
    {
      if (i == 2131364423)
      {
        if (this.d != null)
        {
          int j = this.c.getMinutesOfDay();
          i = j;
          if (this.q)
          {
            i = j;
            if (j == this.z)
            {
              j++;
              i = j;
              if (j == 1440) {
                i = 0;
              }
            }
          }
          this.d.z0(this, i);
        }
        dismiss();
      }
    }
    else {
      dismiss();
    }
  }
  
  public Dialog onCreateDialog(Bundle paramBundle)
  {
    if (getArguments() != null)
    {
      this.x = getArguments().getInt("time");
      boolean bool = getArguments().getBoolean("is_next_day_mode", false);
      this.q = bool;
      if (bool)
      {
        this.y = getArguments().getBoolean("is_start_time");
        this.z = getArguments().getInt("start_or_end_time");
      }
    }
    paramBundle = new Dialog(getActivity(), 2132017398);
    paramBundle.requestWindowFeature(1);
    Object localObject = LayoutInflater.from(getContext()).inflate(2131558744, null);
    paramBundle.setContentView((View)localObject);
    paramBundle.setCanceledOnTouchOutside(false);
    ((View)localObject).findViewById(2131364359).setOnClickListener(this);
    ((View)localObject).findViewById(2131364423).setOnClickListener(this);
    this.c = ((InnerTimePicker)((View)localObject).findViewById(2131362861));
    this.f = ((TextView)((View)localObject).findViewById(2131364539));
    this.c.setOnTimePickerChangeListener(this);
    this.c.setMinuteOfDay(this.x);
    C0(this.x);
    localObject = paramBundle.getWindow();
    if ((localObject != null) && (((Window)localObject).getAttributes() != null))
    {
      WindowManager.LayoutParams localLayoutParams = ((Window)localObject).getAttributes();
      localLayoutParams.width = -1;
      localLayoutParams.height = -2;
      ((Window)localObject).setAttributes(localLayoutParams);
    }
    ((Window)localObject).setGravity(80);
    ((Window)localObject).setWindowAnimations(2132017398);
    return paramBundle;
  }
  
  public void onViewCreated(@NonNull View paramView, @Nullable Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
  }
  
  public static abstract interface a
  {
    public abstract void z0(TimeScrollPickerDialog paramTimeScrollPickerDialog, int paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\TimeScrollPickerDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */