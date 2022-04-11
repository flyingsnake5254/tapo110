package com.tplink.iot.widget;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

public class TimeOffsetPickerDialog
  extends AppCompatDialogFragment
  implements View.OnClickListener
{
  private InnerTimeOffsetPicker c;
  private a d;
  
  public static TimeOffsetPickerDialog A0(int paramInt, boolean paramBoolean)
  {
    TimeOffsetPickerDialog localTimeOffsetPickerDialog = new TimeOffsetPickerDialog();
    Bundle localBundle = new Bundle();
    localBundle.putInt("time", paramInt);
    localBundle.putBoolean("isAnHourPicker", paramBoolean);
    localTimeOffsetPickerDialog.setArguments(localBundle);
    return localTimeOffsetPickerDialog;
  }
  
  public void B0(a parama)
  {
    this.d = parama;
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131364359)
    {
      if (i == 2131364423)
      {
        paramView = this.d;
        if (paramView != null) {
          paramView.F0(this, this.c.getTimeOffset());
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
    int i;
    boolean bool;
    if (getArguments() != null)
    {
      i = getArguments().getInt("time");
      bool = getArguments().getBoolean("isAnHourPicker");
    }
    else
    {
      i = 0;
      bool = false;
    }
    paramBundle = new Dialog(getActivity(), 2132017398);
    paramBundle.requestWindowFeature(1);
    Object localObject = LayoutInflater.from(getContext()).inflate(2131558780, null);
    paramBundle.setContentView((View)localObject);
    paramBundle.setCanceledOnTouchOutside(false);
    ((View)localObject).findViewById(2131364359).setOnClickListener(this);
    ((View)localObject).findViewById(2131364423).setOnClickListener(this);
    localObject = (InnerTimeOffsetPicker)((View)localObject).findViewById(2131364225);
    this.c = ((InnerTimeOffsetPicker)localObject);
    ((InnerTimeOffsetPicker)localObject).a(i, bool);
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
  
  public static abstract interface a
  {
    public abstract void F0(TimeOffsetPickerDialog paramTimeOffsetPickerDialog, int paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\TimeOffsetPickerDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */