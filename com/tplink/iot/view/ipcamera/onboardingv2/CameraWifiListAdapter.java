package com.tplink.iot.view.ipcamera.onboardingv2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tplink.iot.databinding.ItemCameraSsidLayoutBinding;
import com.tplink.iot.view.quicksetup.base.c;
import com.tplink.libtpnetwork.cameranetwork.model.Wifi;
import java.util.ArrayList;
import java.util.List;

public class CameraWifiListAdapter
  extends RecyclerView.Adapter
{
  private List<Wifi> a = new ArrayList();
  private boolean b = false;
  private final a c;
  
  public CameraWifiListAdapter(a parama)
  {
    this.c = parama;
  }
  
  private int m(int paramInt)
  {
    return c.j0(paramInt);
  }
  
  private boolean n(int paramInt)
  {
    List localList = this.a;
    boolean bool = true;
    if (localList == null) {
      return true;
    }
    if (paramInt < localList.size()) {
      bool = false;
    }
    return bool;
  }
  
  public int getItemCount()
  {
    List localList = this.a;
    int i = 1;
    if (localList != null) {
      i = 1 + localList.size();
    }
    return i;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (n(paramInt)) {
      return 1;
    }
    return 0;
  }
  
  public void onBindViewHolder(@NonNull RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    paramViewHolder = (b)paramViewHolder;
    boolean bool = n(paramInt);
    float f = 1.0F;
    if (!bool)
    {
      Wifi localWifi = (Wifi)this.a.get(paramInt);
      paramViewHolder.f(localWifi.getSsid());
      bool = this.b;
      int i = 0;
      if (!bool)
      {
        if ((!localWifi.isWEP()) && (!localWifi.isWPA3())) {
          bool = true;
        } else {
          bool = false;
        }
      }
      else {
        bool = localWifi.isWEP() ^ true;
      }
      b.c(paramViewHolder).q.setEnabled(bool);
      Object localObject = b.c(paramViewHolder).q;
      if (!bool) {
        f = 0.3F;
      }
      ((RelativeLayout)localObject).setAlpha(f);
      localObject = b.c(paramViewHolder).c;
      int j;
      if (bool) {
        j = m(localWifi.getRssi());
      } else if (localWifi.isWEP()) {
        j = 2131690448;
      } else {
        j = 2131689918;
      }
      ((ImageView)localObject).setImageResource(j);
      localObject = b.c(paramViewHolder).d;
      if ((localWifi.getAuth() != 0) && (localWifi.getAuth() != 1)) {
        j = i;
      } else {
        j = 4;
      }
      ((ImageView)localObject).setVisibility(j);
      paramViewHolder.itemView.setClickable(true);
      paramViewHolder.e(new e1(this, paramInt));
    }
    else
    {
      paramViewHolder.itemView.setAlpha(1.0F);
      paramViewHolder.itemView.setClickable(true);
      paramViewHolder.itemView.setOnClickListener(new d1(this));
    }
  }
  
  @NonNull
  public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject = LayoutInflater.from(paramViewGroup.getContext());
    if (paramInt == 0)
    {
      localObject = (ItemCameraSsidLayoutBinding)DataBindingUtil.inflate((LayoutInflater)localObject, 2131559007, paramViewGroup, false);
      paramViewGroup = new b(((ViewDataBinding)localObject).getRoot());
      paramViewGroup.d((ItemCameraSsidLayoutBinding)localObject);
    }
    else
    {
      paramViewGroup = new b(((LayoutInflater)localObject).inflate(2131559202, paramViewGroup, false));
    }
    return paramViewGroup;
  }
  
  public void s(List<Wifi> paramList)
  {
    this.a = paramList;
  }
  
  public void t(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public static abstract interface a
  {
    public abstract void a(Wifi paramWifi);
  }
  
  static class b
    extends RecyclerView.ViewHolder
  {
    private ItemCameraSsidLayoutBinding a;
    
    b(View paramView)
    {
      super();
    }
    
    void d(ItemCameraSsidLayoutBinding paramItemCameraSsidLayoutBinding)
    {
      this.a = paramItemCameraSsidLayoutBinding;
    }
    
    void e(View.OnClickListener paramOnClickListener)
    {
      this.a.h(paramOnClickListener);
    }
    
    void f(String paramString)
    {
      this.a.i(paramString);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\onboardingv2\CameraWifiListAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */