package com.tplink.iot.view.colorbulb;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.tplink.iot.devicecommon.view.bottomsheet.BaseBottomSheetDialogFragment;
import com.tplink.iot.widget.colorbulb.ColorPresetEditWrapView;
import com.tplink.iot.widget.colorbulb.ColorPresetEditWrapView.b;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.LightStateBean;

public class EditColorBulbPresetDialog
  extends BaseBottomSheetDialogFragment
  implements View.OnClickListener
{
  private View c;
  private ImageView d;
  private ImageView f;
  private int p0;
  private LightStateBean p1;
  private ColorPresetEditWrapView q;
  private b x;
  private boolean y = false;
  private String z;
  
  public static EditColorBulbPresetDialog H0(LightStateBean paramLightStateBean, String paramString)
  {
    EditColorBulbPresetDialog localEditColorBulbPresetDialog = new EditColorBulbPresetDialog();
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("tag_edit_preset_info", paramLightStateBean);
    localBundle.putString("tag_dialog_title", paramString);
    localEditColorBulbPresetDialog.setArguments(localBundle);
    return localEditColorBulbPresetDialog;
  }
  
  public static EditColorBulbPresetDialog I0(boolean paramBoolean, int paramInt, LightStateBean paramLightStateBean)
  {
    EditColorBulbPresetDialog localEditColorBulbPresetDialog = new EditColorBulbPresetDialog();
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("tag_is_edit_mode", paramBoolean);
    localBundle.putInt("tag_edit_preset_index", paramInt);
    localBundle.putSerializable("tag_edit_preset_info", paramLightStateBean);
    localEditColorBulbPresetDialog.setArguments(localBundle);
    return localEditColorBulbPresetDialog;
  }
  
  protected int A0()
  {
    return 2131558785;
  }
  
  protected void B0(View paramView)
  {
    Bundle localBundle = getArguments();
    if (localBundle != null)
    {
      this.y = localBundle.getBoolean("tag_is_edit_mode", false);
      this.p1 = ((LightStateBean)localBundle.getSerializable("tag_edit_preset_info"));
      this.z = localBundle.getString("tag_dialog_title");
      if (this.y) {
        this.p0 = localBundle.getInt("tag_edit_preset_index", 0);
      }
    }
    this.c = paramView.findViewById(2131363299);
    this.q = ((ColorPresetEditWrapView)paramView.findViewById(2131362292));
    this.d = ((ImageView)paramView.findViewById(2131363013));
    this.f = ((ImageView)paramView.findViewById(2131363111));
    paramView = (TextView)paramView.findViewById(2131364422);
    if (!TextUtils.isEmpty(this.z)) {
      paramView.setText(this.z);
    }
    this.d.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.q.setOnSampleLightStateChangeCallback(new a());
    paramView = this.p1;
    if (paramView != null) {
      this.q.setLightStates(paramView);
    }
  }
  
  public void J0(b paramb)
  {
    this.x = paramb;
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131363013)
    {
      if (i == 2131363111)
      {
        if (this.x != null)
        {
          paramView = this.q.getLightState();
          if (this.y) {
            this.x.g(this.p0, paramView);
          } else {
            this.x.h(paramView);
          }
        }
        dismiss();
      }
    }
    else {
      dismiss();
    }
  }
  
  class a
    implements ColorPresetEditWrapView.b
  {
    a() {}
    
    public void a(LightStateBean paramLightStateBean)
    {
      if (EditColorBulbPresetDialog.G0(EditColorBulbPresetDialog.this) != null) {
        EditColorBulbPresetDialog.G0(EditColorBulbPresetDialog.this).U(paramLightStateBean);
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void U(LightStateBean paramLightStateBean);
    
    public abstract void g(int paramInt, LightStateBean paramLightStateBean);
    
    public abstract void h(LightStateBean paramLightStateBean);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\colorbulb\EditColorBulbPresetDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */