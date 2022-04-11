package com.tplink.iot.adapter.quicksetup;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tplink.iot.view.quicksetup.base.c;
import java.util.List;

public class BulbSSIDAdapter
  extends RecyclerView.Adapter
{
  private Context a;
  private List<ScanResult> b;
  private f c;
  
  public BulbSSIDAdapter(Context paramContext, List<ScanResult> paramList)
  {
    this.a = paramContext;
    this.b = paramList;
  }
  
  private int n(int paramInt)
  {
    return c.j0(paramInt);
  }
  
  public int getItemCount()
  {
    List localList = this.b;
    int i;
    if (localList == null) {
      i = 0;
    } else {
      i = localList.size();
    }
    return i;
  }
  
  public void o(f paramf)
  {
    this.c = paramf;
  }
  
  public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    b localb = (b)paramViewHolder;
    ScanResult localScanResult = (ScanResult)this.b.get(paramInt);
    localb.a.setText(localScanResult.SSID);
    localb.b.setImageResource(n(WifiManager.calculateSignalLevel(localScanResult.level, 4)));
    localb.itemView.setOnClickListener(new a(paramViewHolder));
  }
  
  @NonNull
  public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    return new b(LayoutInflater.from(this.a).inflate(2131559000, paramViewGroup, false));
  }
  
  class a
    implements View.OnClickListener
  {
    a(RecyclerView.ViewHolder paramViewHolder) {}
    
    public void onClick(View paramView)
    {
      if (BulbSSIDAdapter.m(BulbSSIDAdapter.this) != null) {
        BulbSSIDAdapter.m(BulbSSIDAdapter.this).a(paramView, paramViewHolder.getAdapterPosition());
      }
    }
  }
  
  private class b
    extends RecyclerView.ViewHolder
  {
    TextView a;
    ImageView b;
    
    b(View paramView)
    {
      super();
      this.a = ((TextView)paramView.findViewById(2131364322));
      this.b = ((ImageView)paramView.findViewById(2131362848));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\adapter\quicksetup\BulbSSIDAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */