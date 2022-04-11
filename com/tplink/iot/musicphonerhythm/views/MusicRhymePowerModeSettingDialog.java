package com.tplink.iot.musicphonerhythm.views;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import b.d.w.c.a;
import com.tplink.iot.devicecommon.view.bottomsheet.BaseBottomSheetDialogFragment;
import com.tplink.iot.musicphonerhythm.adapter.MusicRhythmModeSetRvAdapter;
import com.tplink.iot.musicphonerhythm.adapter.MusicRhythmModeSetRvAdapter.b;
import java.util.ArrayList;

public class MusicRhymePowerModeSettingDialog
  extends BaseBottomSheetDialogFragment
  implements View.OnClickListener
{
  public static final String c = MusicRhymePowerModeSettingDialog.class.getName();
  private RecyclerView d;
  private SeekBar f;
  private int q = -1;
  private c x;
  private int y = 0;
  private int z;
  
  public static MusicRhymePowerModeSettingDialog I0(int paramInt1, int paramInt2)
  {
    MusicRhymePowerModeSettingDialog localMusicRhymePowerModeSettingDialog = new MusicRhymePowerModeSettingDialog();
    Bundle localBundle = new Bundle();
    localBundle.putInt("POWER_MODE_START_POINT", paramInt1);
    localBundle.putInt("POWER_MODE_SENSITIVITY", paramInt2);
    localMusicRhymePowerModeSettingDialog.setArguments(localBundle);
    return localMusicRhymePowerModeSettingDialog;
  }
  
  protected int A0()
  {
    return 2131558816;
  }
  
  protected void B0(View paramView)
  {
    Object localObject = getArguments();
    if (localObject != null)
    {
      this.y = ((Bundle)localObject).getInt("POWER_MODE_START_POINT");
      this.z = ((Bundle)localObject).getInt("POWER_MODE_SENSITIVITY");
    }
    setCancelable(false);
    paramView.findViewById(2131363013).setOnClickListener(this);
    paramView.findViewById(2131364613).setOnClickListener(this);
    this.d = ((RecyclerView)paramView.findViewById(2131364021));
    localObject = new ArrayList();
    ((ArrayList)localObject).add("1");
    ((ArrayList)localObject).add("2");
    ((ArrayList)localObject).add("3");
    ((ArrayList)localObject).add("4");
    ((ArrayList)localObject).add("5");
    localObject = new MusicRhythmModeSetRvAdapter(paramView.getContext(), (ArrayList)localObject, this.z, new a());
    this.d.setAdapter((RecyclerView.Adapter)localObject);
    paramView = (SeekBar)paramView.findViewById(2131363518);
    this.f = paramView;
    paramView.setProgress(this.y);
    this.f.setOnSeekBarChangeListener(new b());
  }
  
  public void J0(c paramc)
  {
    this.x = paramc;
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131363013)
    {
      if (i == 2131364613)
      {
        this.x.M(this.q, this.z);
        C0();
      }
    }
    else {
      C0();
    }
  }
  
  class a
    implements MusicRhythmModeSetRvAdapter.b
  {
    a() {}
    
    public void a(View paramView, int paramInt)
    {
      String str = MusicRhymePowerModeSettingDialog.c;
      paramView = new StringBuilder();
      paramView.append("POSITION=");
      paramView.append(paramInt);
      a.c(str, paramView.toString());
      MusicRhymePowerModeSettingDialog.G0(MusicRhymePowerModeSettingDialog.this, paramInt);
    }
  }
  
  class b
    implements SeekBar.OnSeekBarChangeListener
  {
    b() {}
    
    public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
    {
      paramSeekBar = new StringBuilder();
      paramSeekBar.append("");
      paramSeekBar.append(paramInt);
      a.c("powerMode progress=", paramSeekBar.toString());
      MusicRhymePowerModeSettingDialog.H0(MusicRhymePowerModeSettingDialog.this, paramInt);
    }
    
    public void onStartTrackingTouch(SeekBar paramSeekBar) {}
    
    public void onStopTrackingTouch(SeekBar paramSeekBar) {}
  }
  
  public static abstract interface c
  {
    public abstract void M(int paramInt1, int paramInt2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\musicphonerhythm\views\MusicRhymePowerModeSettingDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */