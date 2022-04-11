package com.tplink.iot.musicphonerhythm.views;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import b.d.w.c.a;
import com.tplink.iot.Utils.z0.i;
import com.tplink.iot.musicphonerhythm.bean.MusicRhythmGlobalConfigBean;
import com.tplink.iot.widget.colorbulb.TPCircleColorView;
import com.tplink.iot.widget.colorbulb.TPCircleColorView.b;

public class MusicRhymeColorSettingDialog
  extends MusicRhymeBaseSheetDialog
  implements View.OnClickListener, TPCircleColorView.b
{
  public static final String c = MusicRhymeColorSettingDialog.class.getName();
  private TextView d;
  private CheckBox f;
  private FrameLayout p0;
  private boolean p1 = false;
  private int p2 = 0;
  private int p3 = 0;
  private TPCircleColorView q;
  private b x;
  private int y;
  private int z;
  
  public static MusicRhymeColorSettingDialog L0(MusicRhythmGlobalConfigBean paramMusicRhythmGlobalConfigBean)
  {
    MusicRhymeColorSettingDialog localMusicRhymeColorSettingDialog = new MusicRhymeColorSettingDialog();
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("single_color_mode", paramMusicRhythmGlobalConfigBean.isSingleColorEnable());
    localBundle.putInt("single_color_user_hue", paramMusicRhythmGlobalConfigBean.getHue());
    localBundle.putInt("single_color_user_sat", paramMusicRhythmGlobalConfigBean.getSaturation());
    localMusicRhymeColorSettingDialog.setArguments(localBundle);
    return localMusicRhymeColorSettingDialog;
  }
  
  protected int A0()
  {
    return 2131558813;
  }
  
  protected void B0(View paramView)
  {
    Object localObject = getArguments();
    if (localObject != null)
    {
      this.p1 = ((Bundle)localObject).getBoolean("single_color_mode");
      this.p2 = ((Bundle)localObject).getInt("single_color_user_hue");
      this.p3 = ((Bundle)localObject).getInt("single_color_user_sat");
    }
    setCancelable(false);
    paramView.findViewById(2131364363).setOnClickListener(this);
    localObject = (TextView)paramView.findViewById(2131364613);
    this.d = ((TextView)localObject);
    ((TextView)localObject).setOnClickListener(this);
    this.d.setClickable(false);
    localObject = (CheckBox)paramView.findViewById(2131363119);
    this.f = ((CheckBox)localObject);
    ((CheckBox)localObject).setChecked(this.p1);
    localObject = (TPCircleColorView)paramView.findViewById(2131362287);
    this.q = ((TPCircleColorView)localObject);
    ((TPCircleColorView)localObject).setOnColorListener(this);
    this.p0 = ((FrameLayout)paramView.findViewById(2131362288));
    this.q.setSelectedStatus(true);
    int i = i.a(this.p2, this.p3);
    this.q.setColor(0xFFFFFF & i);
    if (this.p1)
    {
      this.q.setVisibility(0);
      this.p0.setVisibility(8);
    }
    else
    {
      this.q.setVisibility(8);
      this.p0.setVisibility(0);
    }
    this.z = i;
    this.f.setOnCheckedChangeListener(new a());
  }
  
  public void J() {}
  
  public void N0(b paramb)
  {
    this.x = paramb;
  }
  
  public void g(int paramInt, boolean paramBoolean)
  {
    String str = c;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateColor color=");
    localStringBuilder.append(paramInt);
    a.c(str, localStringBuilder.toString());
    if (paramBoolean)
    {
      this.d.setClickable(true);
      this.d.setTextColor(getResources().getColor(2131099808));
      this.z = (paramInt | 0xFF000000);
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131364363)
    {
      if (i == 2131364613)
      {
        if (this.p1) {
          this.y = this.z;
        } else {
          this.y = 0;
        }
        this.x.N(this.y);
        C0();
      }
    }
    else {
      C0();
    }
  }
  
  public void w(int paramInt) {}
  
  class a
    implements CompoundButton.OnCheckedChangeListener
  {
    a() {}
    
    public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
    {
      MusicRhymeColorSettingDialog.G0(MusicRhymeColorSettingDialog.this).setClickable(true);
      MusicRhymeColorSettingDialog.G0(MusicRhymeColorSettingDialog.this).setTextColor(MusicRhymeColorSettingDialog.this.getResources().getColor(2131099808));
      if (paramBoolean)
      {
        MusicRhymeColorSettingDialog.H0(MusicRhymeColorSettingDialog.this).setVisibility(0);
        MusicRhymeColorSettingDialog.I0(MusicRhymeColorSettingDialog.this).setVisibility(8);
        MusicRhymeColorSettingDialog.J0(MusicRhymeColorSettingDialog.this, true);
      }
      else
      {
        MusicRhymeColorSettingDialog.H0(MusicRhymeColorSettingDialog.this).setVisibility(8);
        MusicRhymeColorSettingDialog.I0(MusicRhymeColorSettingDialog.this).setVisibility(0);
        MusicRhymeColorSettingDialog.J0(MusicRhymeColorSettingDialog.this, false);
        MusicRhymeColorSettingDialog.K0(MusicRhymeColorSettingDialog.this, 0);
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void N(int paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\musicphonerhythm\views\MusicRhymeColorSettingDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */