package com.tplink.iot.view.ipcamera.memories;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class MemoryDeleteDialogFragment
  extends DialogFragment
  implements View.OnClickListener
{
  private a c;
  
  public static MemoryDeleteDialogFragment A0()
  {
    return new MemoryDeleteDialogFragment();
  }
  
  public void B0(a parama)
  {
    this.c = parama;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131362438: 
      paramView = this.c;
      if (paramView != null) {
        paramView.b();
      }
      break;
    case 2131362437: 
      paramView = this.c;
      if (paramView != null) {
        paramView.a();
      }
      break;
    }
  }
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131558807, paramViewGroup, false);
    paramLayoutInflater.findViewById(2131362437).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131362438).setOnClickListener(this);
    return paramLayoutInflater;
  }
  
  static abstract interface a
  {
    public abstract void a();
    
    public abstract void b();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\memories\MemoryDeleteDialogFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */