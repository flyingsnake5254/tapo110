package com.tplink.iot.adapter.deviceshare;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tplink.iot.Utils.z0.l;
import com.tplink.iot.cloud.bean.share.result.ShareDeviceResult;
import com.tplink.iot.g.b.c.c;
import com.tplink.libtpnetwork.Utils.v;
import com.tplink.libtpnetwork.enumerate.EnumDeviceType;
import java.util.List;

public class DeviceSharePullingAdapter
  extends RecyclerView.Adapter<c>
{
  private Activity a;
  private List<ShareDeviceResult> b;
  private d c;
  
  public DeviceSharePullingAdapter(Activity paramActivity, List<ShareDeviceResult> paramList)
  {
    this.a = paramActivity;
    this.b = paramList;
  }
  
  private int n(EnumDeviceType paramEnumDeviceType, String paramString)
  {
    if (paramEnumDeviceType == EnumDeviceType.BULB)
    {
      if (c.i(paramString)) {
        return 2131690034;
      }
      return 2131689965;
    }
    if (paramEnumDeviceType == EnumDeviceType.CAMERA) {
      return 2131689971;
    }
    if (paramEnumDeviceType == EnumDeviceType.HUB) {
      return 2131690022;
    }
    if (paramEnumDeviceType == EnumDeviceType.SENSOR)
    {
      if ("T100".equals(paramString)) {
        return 2131690049;
      }
      if ("T110".equals(paramString)) {
        return 2131690052;
      }
      if ("S200B".equals(paramString)) {
        return 2131689969;
      }
      return 2131690054;
    }
    if (paramEnumDeviceType == EnumDeviceType.SWITCH)
    {
      if ("S210".equals(paramString)) {
        return 2131690072;
      }
      return 2131690062;
    }
    if (paramEnumDeviceType == EnumDeviceType.ENERGY) {
      return 2131690097;
    }
    return 2131690039;
  }
  
  private static String o(Context paramContext, String paramString1, String paramString2)
  {
    EnumDeviceType localEnumDeviceType = EnumDeviceType.fromType(paramString1);
    if (!TextUtils.isEmpty(paramString2))
    {
      if (localEnumDeviceType == EnumDeviceType.CAMERA) {
        return paramString2;
      }
      return v.a(paramString2);
    }
    if ((paramContext != null) && (localEnumDeviceType != null)) {
      return l.d(paramContext, paramString1, null);
    }
    return "";
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
  
  public void p(@NonNull c paramc, int paramInt)
  {
    final ShareDeviceResult localShareDeviceResult = (ShareDeviceResult)this.b.get(paramInt);
    Object localObject1 = EnumDeviceType.fromType(localShareDeviceResult.getDeviceType());
    Object localObject2 = localShareDeviceResult.getDeviceName();
    paramc.a.setImageResource(n((EnumDeviceType)localObject1, (String)localObject2));
    paramc.b.setText(o(this.a, localShareDeviceResult.getDeviceType(), localShareDeviceResult.getNickname()));
    localObject1 = paramc.c;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.a.getString(2131953934));
    ((StringBuilder)localObject2).append(" ");
    ((StringBuilder)localObject2).append(localShareDeviceResult.getOwnerNickname());
    ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
    paramc.d.setOnClickListener(new a(localShareDeviceResult));
    paramc.e.setOnClickListener(new b(localShareDeviceResult));
  }
  
  @NonNull
  public c q(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    return new c(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559026, paramViewGroup, false));
  }
  
  public void r(List<ShareDeviceResult> paramList)
  {
    this.b = paramList;
    notifyDataSetChanged();
  }
  
  public void s(d paramd)
  {
    this.c = paramd;
  }
  
  class a
    implements View.OnClickListener
  {
    a(ShareDeviceResult paramShareDeviceResult) {}
    
    public void onClick(View paramView)
    {
      if (DeviceSharePullingAdapter.m(DeviceSharePullingAdapter.this) != null) {
        DeviceSharePullingAdapter.m(DeviceSharePullingAdapter.this).L0(localShareDeviceResult);
      }
    }
  }
  
  class b
    implements View.OnClickListener
  {
    b(ShareDeviceResult paramShareDeviceResult) {}
    
    public void onClick(View paramView)
    {
      if (DeviceSharePullingAdapter.m(DeviceSharePullingAdapter.this) != null) {
        DeviceSharePullingAdapter.m(DeviceSharePullingAdapter.this).S(localShareDeviceResult);
      }
    }
  }
  
  static class c
    extends RecyclerView.ViewHolder
  {
    ImageView a;
    TextView b;
    TextView c;
    TextView d;
    TextView e;
    
    public c(View paramView)
    {
      super();
      this.a = ((ImageView)paramView.findViewById(2131363071));
      this.b = ((TextView)paramView.findViewById(2131364492));
      this.c = ((TextView)paramView.findViewById(2131364462));
      this.d = ((TextView)paramView.findViewById(2131364398));
      this.e = ((TextView)paramView.findViewById(2131364324));
    }
  }
  
  public static abstract interface d
  {
    public abstract void L0(ShareDeviceResult paramShareDeviceResult);
    
    public abstract void S(ShareDeviceResult paramShareDeviceResult);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\adapter\deviceshare\DeviceSharePullingAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */