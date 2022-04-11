package com.tplink.iot.view.ipcamera.setting;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import com.tplink.libtpcontrols.wheelpickerview.LoopView;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TimeWheelDialog
  extends DialogFragment
  implements View.OnClickListener
{
  private a c;
  private LoopView d;
  private LoopView f;
  private TextView q;
  private boolean x;
  private int y;
  private int z;
  
  private void B0()
  {
    Object localObject1 = this.d;
    Object localObject2 = getContext();
    Objects.requireNonNull(localObject2);
    ((LoopView)localObject1).setCenterTextColor(ContextCompat.getColor((Context)localObject2, 2131099727));
    localObject1 = this.f;
    localObject2 = getContext();
    Objects.requireNonNull(localObject2);
    ((LoopView)localObject1).setCenterTextColor(ContextCompat.getColor((Context)localObject2, 2131099727));
    localObject1 = this.q;
    localObject2 = getContext();
    Objects.requireNonNull(localObject2);
    ((TextView)localObject1).setTextColor(ContextCompat.getColor((Context)localObject2, 2131099727));
    localObject2 = new ArrayList();
    int i = 0;
    for (int j = 0; j < 24; j++)
    {
      if (j > 9)
      {
        localObject1 = String.valueOf(j);
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("0");
        ((StringBuilder)localObject1).append(j);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      ((ArrayList)localObject2).add(localObject1);
    }
    this.d.setItems((List)localObject2);
    localObject2 = new ArrayList();
    for (j = i; j < 60; j++)
    {
      if (j > 9)
      {
        localObject1 = String.valueOf(j);
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("0");
        ((StringBuilder)localObject1).append(j);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      ((ArrayList)localObject2).add(localObject1);
    }
    this.f.setItems((List)localObject2);
    this.d.setInitPosition(this.y);
    this.f.setInitPosition(this.z);
  }
  
  public static TimeWheelDialog C0()
  {
    return new TimeWheelDialog();
  }
  
  public void A0(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.y = paramInt1;
    this.z = paramInt2;
    this.x = paramBoolean;
  }
  
  public void G0(a parama)
  {
    this.c = parama;
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131362441)
    {
      if (i == 2131362443)
      {
        int j = this.d.getSelectedItem();
        i = this.f.getSelectedItem();
        this.c.n(j, i, this.x);
        dismiss();
      }
    }
    else {
      dismiss();
    }
  }
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131558749, paramViewGroup, false);
    this.d = ((LoopView)paramLayoutInflater.findViewById(2131363385));
    this.f = ((LoopView)paramLayoutInflater.findViewById(2131363386));
    this.q = ((TextView)paramLayoutInflater.findViewById(2131364642));
    paramLayoutInflater.findViewById(2131362441).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131362443).setOnClickListener(this);
    B0();
    return paramLayoutInflater;
  }
  
  public static abstract interface a
  {
    public abstract void n(int paramInt1, int paramInt2, boolean paramBoolean);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\setting\TimeWheelDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */