package com.tplink.iot.view.ipcamera.setting.firmware;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import com.tplink.iot.widget.NumberPickerView;
import com.tplink.iot.widget.h;

public class AutoUpdateTimePickerDialog
  extends AppCompatDialogFragment
  implements View.OnClickListener
{
  private float c;
  private int d = 2;
  private a f;
  private NumberPickerView q;
  
  public static AutoUpdateTimePickerDialog A0(int paramInt)
  {
    AutoUpdateTimePickerDialog localAutoUpdateTimePickerDialog = new AutoUpdateTimePickerDialog();
    Bundle localBundle = new Bundle();
    localBundle.putInt("tag_current_time", paramInt);
    localAutoUpdateTimePickerDialog.setArguments(localBundle);
    return localAutoUpdateTimePickerDialog;
  }
  
  public void B0(a parama)
  {
    this.f = parama;
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131364359)
    {
      if (i == 2131364423)
      {
        if (this.f != null)
        {
          paramView = this.q;
          if (paramView != null)
          {
            i = paramView.getValue();
            this.f.v(i);
          }
        }
        dismiss();
      }
    }
    else {
      dismiss();
    }
  }
  
  @NonNull
  public Dialog onCreateDialog(@Nullable Bundle paramBundle)
  {
    paramBundle = getArguments();
    if (paramBundle != null)
    {
      float f1 = paramBundle.getInt("tag_current_time", 180);
      this.c = f1;
      this.d = ((int)(f1 / 60.0F % 24.0F));
    }
    paramBundle = new Dialog(getActivity(), 2132017398);
    paramBundle.requestWindowFeature(1);
    Object localObject = LayoutInflater.from(getContext()).inflate(2131558786, null);
    paramBundle.setContentView((View)localObject);
    paramBundle.setCancelable(false);
    paramBundle.setCanceledOnTouchOutside(false);
    this.q = ((NumberPickerView)((View)localObject).findViewById(2131364226));
    ((View)localObject).findViewById(2131364359).setOnClickListener(this);
    ((View)localObject).findViewById(2131364423).setOnClickListener(this);
    this.q.S(h.d());
    this.q.setValue(this.d);
    localObject = paramBundle.getWindow();
    if ((localObject != null) && (((Window)localObject).getAttributes() != null))
    {
      WindowManager.LayoutParams localLayoutParams = ((Window)localObject).getAttributes();
      localLayoutParams.width = -1;
      localLayoutParams.height = -2;
      ((Window)localObject).setAttributes(localLayoutParams);
    }
    ((Window)localObject).setGravity(80);
    ((Window)localObject).setWindowAnimations(2132017164);
    return paramBundle;
  }
  
  public static abstract interface a
  {
    public abstract void v(int paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\setting\firmware\AutoUpdateTimePickerDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */