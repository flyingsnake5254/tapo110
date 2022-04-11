package com.tplink.iot.view.ipcamera.onboardingv2;

import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tplink.iot.databinding.ItemCameraSsidLayoutBinding;
import com.tplink.iot.view.quicksetup.base.c;
import java.util.ArrayList;
import java.util.List;

public class CameraSSIDAdapter
  extends RecyclerView.Adapter
{
  private List<ScanResult> a = new ArrayList();
  private final a b;
  
  public CameraSSIDAdapter(a parama)
  {
    this.b = parama;
  }
  
  private int m(int paramInt)
  {
    paramInt = WifiManager.calculateSignalLevel(paramInt, 100);
    if (paramInt < 35) {
      return 1;
    }
    if (paramInt < 70) {
      return 2;
    }
    return 3;
  }
  
  private int n(int paramInt)
  {
    return c.j0(m(paramInt));
  }
  
  public int getItemCount()
  {
    return this.a.size();
  }
  
  public void onBindViewHolder(@NonNull RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    paramViewHolder = (b)paramViewHolder;
    ScanResult localScanResult = (ScanResult)this.a.get(paramInt);
    paramViewHolder.f(localScanResult.SSID);
    b.c(paramViewHolder).c.setImageResource(n(localScanResult.level));
    paramViewHolder.e(new v0(this, paramInt));
  }
  
  @NonNull
  public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = (ItemCameraSsidLayoutBinding)DataBindingUtil.inflate(LayoutInflater.from(paramViewGroup.getContext()), 2131559007, paramViewGroup, false);
    b localb = new b(paramViewGroup.getRoot());
    localb.d(paramViewGroup);
    return localb;
  }
  
  public void q(List<ScanResult> paramList)
  {
    this.a = paramList;
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString);
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\onboardingv2\CameraSSIDAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */