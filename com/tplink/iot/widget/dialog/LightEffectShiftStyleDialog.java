package com.tplink.iot.widget.dialog;

import android.app.Application;
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
import com.tplink.iot.core.AppContext;
import com.tplink.iot.widget.NumberPickerView;

public class LightEffectShiftStyleDialog
  extends AppCompatDialogFragment
  implements View.OnClickListener
{
  private static final String[] c = { AppContext.c.getString(2131953720), AppContext.c.getString(2131953719) };
  private int d = 1;
  private a f;
  private NumberPickerView q;
  
  public static LightEffectShiftStyleDialog A0(int paramInt)
  {
    LightEffectShiftStyleDialog localLightEffectShiftStyleDialog = new LightEffectShiftStyleDialog();
    Bundle localBundle = new Bundle();
    localBundle.putInt("tag_current_type", paramInt);
    localLightEffectShiftStyleDialog.setArguments(localBundle);
    return localLightEffectShiftStyleDialog;
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
        a locala = this.f;
        if (locala != null)
        {
          paramView = this.q;
          if (paramView != null) {
            locala.u0(paramView.getValue());
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
      int i = paramBundle.getInt("tag_current_type", 0);
      this.d = i;
      this.d = (i % 2);
    }
    paramBundle = new Dialog(getActivity(), 2132017398);
    paramBundle.requestWindowFeature(1);
    Object localObject = LayoutInflater.from(getContext()).inflate(2131558801, null);
    paramBundle.setContentView((View)localObject);
    paramBundle.setCancelable(false);
    paramBundle.setCanceledOnTouchOutside(false);
    this.q = ((NumberPickerView)((View)localObject).findViewById(2131364226));
    ((View)localObject).findViewById(2131364359).setOnClickListener(this);
    ((View)localObject).findViewById(2131364423).setOnClickListener(this);
    this.q.S(c);
    this.q.setValue(this.d);
    Window localWindow = paramBundle.getWindow();
    if ((localWindow != null) && (localWindow.getAttributes() != null))
    {
      localObject = localWindow.getAttributes();
      ((WindowManager.LayoutParams)localObject).width = -1;
      ((WindowManager.LayoutParams)localObject).height = -2;
      localWindow.setAttributes((WindowManager.LayoutParams)localObject);
    }
    localWindow.setGravity(80);
    localWindow.setWindowAnimations(2132017164);
    return paramBundle;
  }
  
  public static abstract interface a
  {
    public abstract void u0(int paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\dialog\LightEffectShiftStyleDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */