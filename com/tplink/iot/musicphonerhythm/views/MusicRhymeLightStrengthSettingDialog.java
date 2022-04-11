package com.tplink.iot.musicphonerhythm.views;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import b.d.w.c.a;

public class MusicRhymeLightStrengthSettingDialog
  extends MusicRhymeBaseSheetDialog
  implements View.OnClickListener, SeekBar.OnSeekBarChangeListener
{
  public static final String c = MusicRhymeLightStrengthSettingDialog.class.getName();
  private TextView d;
  private TextView f;
  private SeekBar q;
  private a x;
  private int y;
  
  public static MusicRhymeLightStrengthSettingDialog G0(int paramInt)
  {
    MusicRhymeLightStrengthSettingDialog localMusicRhymeLightStrengthSettingDialog = new MusicRhymeLightStrengthSettingDialog();
    Bundle localBundle = new Bundle();
    localBundle.putInt("light_percent", paramInt);
    localMusicRhymeLightStrengthSettingDialog.setArguments(localBundle);
    return localMusicRhymeLightStrengthSettingDialog;
  }
  
  protected int A0()
  {
    return 2131558815;
  }
  
  protected void B0(View paramView)
  {
    Object localObject = getArguments();
    if (localObject != null) {
      this.y = ((Bundle)localObject).getInt("light_percent");
    }
    setCancelable(false);
    paramView.findViewById(2131364363).setOnClickListener(this);
    localObject = (TextView)paramView.findViewById(2131364613);
    this.d = ((TextView)localObject);
    ((TextView)localObject).setOnClickListener(this);
    this.d.setClickable(false);
    this.f = ((TextView)paramView.findViewById(2131364376));
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.y);
    ((StringBuilder)localObject).append("%");
    localObject = ((StringBuilder)localObject).toString();
    this.f.setText((CharSequence)localObject);
    paramView = (SeekBar)paramView.findViewById(2131363514);
    this.q = paramView;
    paramView.setOnSeekBarChangeListener(this);
    this.q.setProgress(this.y);
  }
  
  public void H0(a parama)
  {
    this.x = parama;
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131364363)
    {
      if (i == 2131364613)
      {
        this.x.y(this.y);
        C0();
      }
    }
    else {
      C0();
    }
  }
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    String str = c;
    paramSeekBar = new StringBuilder();
    paramSeekBar.append("onBrightnessChange: ");
    paramSeekBar.append(paramInt);
    a.c(str, paramSeekBar.toString());
    int i = paramInt;
    if (paramInt < 1)
    {
      this.q.setProgress(1);
      i = 1;
    }
    paramInt = i;
    if (i > 100) {
      paramInt = 100;
    }
    this.y = paramInt;
    paramSeekBar = new StringBuilder();
    paramSeekBar.append(this.y);
    paramSeekBar.append("%");
    paramSeekBar = paramSeekBar.toString();
    if (paramBoolean)
    {
      this.f.setText(paramSeekBar);
      this.d.setClickable(true);
      this.d.setTextColor(getResources().getColor(2131099808));
    }
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar) {}
  
  public void onStopTrackingTouch(SeekBar paramSeekBar) {}
  
  public static abstract interface a
  {
    public abstract void y(int paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\musicphonerhythm\views\MusicRhymeLightStrengthSettingDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */