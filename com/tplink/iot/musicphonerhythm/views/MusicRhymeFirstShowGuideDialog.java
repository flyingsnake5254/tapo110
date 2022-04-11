package com.tplink.iot.musicphonerhythm.views;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;

public class MusicRhymeFirstShowGuideDialog
  extends MusicRhymeBaseSheetDialog
  implements View.OnClickListener
{
  public static final String c = MusicRhymeFirstShowGuideDialog.class.getName();
  private ImageView d;
  private TextView f;
  
  public static MusicRhymeFirstShowGuideDialog G0()
  {
    return new MusicRhymeFirstShowGuideDialog();
  }
  
  protected int A0()
  {
    return 2131558812;
  }
  
  protected void B0(View paramView)
  {
    setCancelable(false);
    this.d = ((ImageView)paramView.findViewById(2131363013));
    this.f = ((TextView)paramView.findViewById(2131362037));
    this.d.setOnClickListener(this);
    this.f.setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if ((i == 2131362037) || (i == 2131363013)) {
      C0();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\musicphonerhythm\views\MusicRhymeFirstShowGuideDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */