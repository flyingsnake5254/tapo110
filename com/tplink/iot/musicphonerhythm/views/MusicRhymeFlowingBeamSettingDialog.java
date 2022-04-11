package com.tplink.iot.musicphonerhythm.views;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import b.d.w.c.a;
import com.tplink.iot.devicecommon.view.bottomsheet.BaseBottomSheetDialogFragment;
import com.tplink.iot.musicphonerhythm.adapter.MusicRhythmModeSetRvAdapter;
import com.tplink.iot.musicphonerhythm.adapter.MusicRhythmModeSetRvAdapter.b;
import java.util.ArrayList;

public class MusicRhymeFlowingBeamSettingDialog
  extends BaseBottomSheetDialogFragment
  implements View.OnClickListener
{
  public static final String c = MusicRhymeFlowingBeamSettingDialog.class.getName();
  private RecyclerView d;
  private b f;
  private int q = 2;
  
  public static MusicRhymeFlowingBeamSettingDialog H0(int paramInt)
  {
    MusicRhymeFlowingBeamSettingDialog localMusicRhymeFlowingBeamSettingDialog = new MusicRhymeFlowingBeamSettingDialog();
    Bundle localBundle = new Bundle();
    localBundle.putInt("FLOWING_BEAN_SPEED_GAP", paramInt);
    localMusicRhymeFlowingBeamSettingDialog.setArguments(localBundle);
    return localMusicRhymeFlowingBeamSettingDialog;
  }
  
  protected int A0()
  {
    return 2131558814;
  }
  
  protected void B0(View paramView)
  {
    Object localObject = getArguments();
    if (localObject != null) {
      this.q = ((Bundle)localObject).getInt("FLOWING_BEAN_SPEED_GAP");
    }
    setCancelable(false);
    paramView.findViewById(2131363013).setOnClickListener(this);
    paramView.findViewById(2131364613).setOnClickListener(this);
    this.d = ((RecyclerView)paramView.findViewById(2131364081));
    localObject = new ArrayList();
    ((ArrayList)localObject).add(getString(2131953194));
    ((ArrayList)localObject).add(getString(2131951828));
    ((ArrayList)localObject).add(getString(2131953104));
    ((ArrayList)localObject).add(getString(2131951827));
    ((ArrayList)localObject).add(getString(2131953193));
    paramView = new MusicRhythmModeSetRvAdapter(paramView.getContext(), (ArrayList)localObject, this.q, new a());
    this.d.setAdapter(paramView);
  }
  
  public void I0(b paramb)
  {
    this.f = paramb;
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131363013)
    {
      if (i == 2131364613)
      {
        this.f.U(this.q);
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
      String str = MusicRhymeFlowingBeamSettingDialog.c;
      paramView = new StringBuilder();
      paramView.append("POSITION=");
      paramView.append(paramInt);
      a.c(str, paramView.toString());
      MusicRhymeFlowingBeamSettingDialog.G0(MusicRhymeFlowingBeamSettingDialog.this, paramInt);
    }
  }
  
  public static abstract interface b
  {
    public abstract void U(int paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\musicphonerhythm\views\MusicRhymeFlowingBeamSettingDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */