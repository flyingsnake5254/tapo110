package com.tplink.iot.model.home;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

public class TitleHolder
  extends RecyclerView.ViewHolder
{
  private TextView a;
  
  public TitleHolder(View paramView)
  {
    super(paramView);
    this.a = ((TextView)paramView.findViewById(2131364362));
  }
  
  public void c(j paramj)
  {
    if (paramj != null) {
      this.a.setText(paramj.d());
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\model\home\TitleHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */