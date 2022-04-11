package com.tplink.iot.widget.dialog;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import com.tplink.iot.devicecommon.view.bottomsheet.BaseBottomSheetDialogFragment;
import com.tplink.iot.widget.colorbulb.ColorPresetEditWrapView;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.LightStateBean;

public class LightEffectColorEditDialog
  extends BaseBottomSheetDialogFragment
  implements View.OnClickListener
{
  private ImageView c;
  private ImageView d;
  private View f;
  private LightStateBean p0;
  private ColorPresetEditWrapView q;
  private a x;
  private boolean y = false;
  private int z;
  
  public static LightEffectColorEditDialog G0(boolean paramBoolean, int paramInt, LightStateBean paramLightStateBean)
  {
    LightEffectColorEditDialog localLightEffectColorEditDialog = new LightEffectColorEditDialog();
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("tag_is_edit_mode", paramBoolean);
    localBundle.putInt("tag_edit_preset_index", paramInt);
    localBundle.putSerializable("tag_edit_preset_info", paramLightStateBean);
    localLightEffectColorEditDialog.setArguments(localBundle);
    return localLightEffectColorEditDialog;
  }
  
  protected int A0()
  {
    return 2131558803;
  }
  
  protected void B0(View paramView)
  {
    Object localObject = getArguments();
    int i = 0;
    if (localObject != null)
    {
      this.y = ((Bundle)localObject).getBoolean("tag_is_edit_mode", false);
      this.p0 = ((LightStateBean)((Bundle)localObject).getSerializable("tag_edit_preset_info"));
      if (this.y) {
        this.z = ((Bundle)localObject).getInt("tag_edit_preset_index", 0);
      }
    }
    setCancelable(false);
    this.q = ((ColorPresetEditWrapView)paramView.findViewById(2131362292));
    this.c = ((ImageView)paramView.findViewById(2131363013));
    this.d = ((ImageView)paramView.findViewById(2131363111));
    this.f = paramView.findViewById(2131362046);
    paramView = (TextView)paramView.findViewById(2131364422);
    localObject = getContext();
    if (this.y) {
      j = 2131953702;
    } else {
      j = 2131953677;
    }
    localObject = ((Context)localObject).getString(j);
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      paramView.setText((CharSequence)localObject);
    }
    this.c.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.f.setOnClickListener(this);
    paramView = this.f;
    int j = i;
    if (this.z < 2) {
      j = 4;
    }
    paramView.setVisibility(j);
    paramView = this.p0;
    if (paramView != null) {
      this.q.setLightStates(paramView);
    }
  }
  
  public void H0(a parama)
  {
    this.x = parama;
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131362046)
    {
      if (i != 2131363013)
      {
        if (i == 2131363111)
        {
          if (this.x != null)
          {
            paramView = this.q.getLightState();
            if (this.y) {
              this.x.g(this.z, paramView);
            } else {
              this.x.h(paramView);
            }
          }
          C0();
        }
      }
      else {
        C0();
      }
    }
    else
    {
      paramView = this.x;
      if ((paramView != null) && (this.y)) {
        paramView.b(this.z);
      }
      C0();
    }
  }
  
  public static abstract interface a
  {
    public abstract void b(int paramInt);
    
    public abstract void g(int paramInt, LightStateBean paramLightStateBean);
    
    public abstract void h(LightStateBean paramLightStateBean);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\dialog\LightEffectColorEditDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */