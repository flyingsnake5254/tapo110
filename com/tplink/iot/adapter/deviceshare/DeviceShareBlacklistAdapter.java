package com.tplink.iot.adapter.deviceshare;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tplink.cloud.bean.share.result.ShareBlacklistItemResult;
import com.tplink.libtpcontrols.TPCircleMaskView;
import java.util.List;

public class DeviceShareBlacklistAdapter
  extends RecyclerView.Adapter<b>
{
  private List<ShareBlacklistItemResult> a;
  private Context b;
  private c c;
  
  public DeviceShareBlacklistAdapter(Activity paramActivity, List<ShareBlacklistItemResult> paramList)
  {
    this.b = paramActivity;
    this.a = paramList;
  }
  
  public int getItemCount()
  {
    List localList = this.a;
    int i;
    if (localList == null) {
      i = 0;
    } else {
      i = localList.size();
    }
    return i;
  }
  
  public void n(@NonNull b paramb, int paramInt)
  {
    final ShareBlacklistItemResult localShareBlacklistItemResult = (ShareBlacklistItemResult)this.a.get(paramInt);
    paramb.a.setImageUrl(localShareBlacklistItemResult.getAvatarUrl());
    paramb.b.setText(localShareBlacklistItemResult.getNickname());
    paramb.c.setText(localShareBlacklistItemResult.getEmail());
    paramb.d.setOnClickListener(new a(localShareBlacklistItemResult));
  }
  
  @NonNull
  public b o(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    return new b(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559024, paramViewGroup, false));
  }
  
  public void p(List<ShareBlacklistItemResult> paramList)
  {
    this.a = paramList;
    notifyDataSetChanged();
  }
  
  public void q(c paramc)
  {
    this.c = paramc;
  }
  
  class a
    implements View.OnClickListener
  {
    a(ShareBlacklistItemResult paramShareBlacklistItemResult) {}
    
    public void onClick(View paramView)
    {
      if (DeviceShareBlacklistAdapter.m(DeviceShareBlacklistAdapter.this) != null) {
        DeviceShareBlacklistAdapter.m(DeviceShareBlacklistAdapter.this).G0(localShareBlacklistItemResult);
      }
    }
  }
  
  static class b
    extends RecyclerView.ViewHolder
  {
    TPCircleMaskView a;
    TextView b;
    TextView c;
    ImageView d;
    
    public b(View paramView)
    {
      super();
      this.a = ((TPCircleMaskView)paramView.findViewById(2131362837));
      this.b = ((TextView)paramView.findViewById(2131364544));
      this.c = ((TextView)paramView.findViewById(2131364444));
      this.d = ((ImageView)paramView.findViewById(2131363024));
    }
  }
  
  public static abstract interface c
  {
    public abstract void G0(ShareBlacklistItemResult paramShareBlacklistItemResult);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\adapter\deviceshare\DeviceShareBlacklistAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */