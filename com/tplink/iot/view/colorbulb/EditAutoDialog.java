package com.tplink.iot.view.colorbulb;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import com.tplink.iot.devicecommon.view.bottomsheet.BaseBottomSheetDialogFragment;

public class EditAutoDialog
  extends BaseBottomSheetDialogFragment
  implements View.OnClickListener
{
  private String c = "light_compensate";
  private ImageView d;
  private ImageView f;
  private View q;
  private View x;
  private a y;
  
  public static EditAutoDialog G0(String paramString)
  {
    EditAutoDialog localEditAutoDialog = new EditAutoDialog();
    Bundle localBundle = new Bundle();
    localBundle.putString("light_mode", paramString);
    localEditAutoDialog.setArguments(localBundle);
    return localEditAutoDialog;
  }
  
  private void H0()
  {
    a locala = this.y;
    if (locala != null) {
      locala.J0(this.c);
    }
    C0();
  }
  
  private void J0()
  {
    if ("light_compensate".equals(this.c))
    {
      this.q.setBackground(getResources().getDrawable(2131230865));
      this.d.setImageResource(2131690143);
      this.x.setBackground(getResources().getDrawable(2131230864));
      this.f.setImageResource(2131690160);
    }
    else
    {
      this.q.setBackground(getResources().getDrawable(2131230864));
      this.d.setImageResource(2131690144);
      this.x.setBackground(getResources().getDrawable(2131230865));
      this.f.setImageResource(2131690159);
    }
  }
  
  protected int A0()
  {
    return 2131558784;
  }
  
  protected void B0(View paramView)
  {
    Bundle localBundle = getArguments();
    if (localBundle != null) {
      this.c = localBundle.getString("light_mode", "light_compensate");
    }
    this.q = paramView.findViewById(2131363302);
    this.x = paramView.findViewById(2131363303);
    this.d = ((ImageView)paramView.findViewById(2131363076));
    this.f = ((ImageView)paramView.findViewById(2131363079));
    this.q.setOnClickListener(this);
    this.x.setOnClickListener(this);
    paramView.findViewById(2131363013).setOnClickListener(this);
    J0();
  }
  
  public void I0(a parama)
  {
    this.y = parama;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131363303: 
      this.c = "light_track";
      J0();
      H0();
      break;
    case 2131363302: 
      this.c = "light_compensate";
      J0();
      H0();
      break;
    case 2131363013: 
      C0();
    }
  }
  
  public static abstract interface a
  {
    public abstract void J0(String paramString);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\colorbulb\EditAutoDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */