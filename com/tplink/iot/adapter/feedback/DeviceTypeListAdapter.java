package com.tplink.iot.adapter.feedback;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import b.d.s.c.a;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.tplink.iot.model.about.d;
import com.tplink.iot.view.feedback.EnumFeedbackCategory;
import com.tplink.libtpnetwork.enumerate.EnumDeviceType;
import java.util.ArrayList;
import java.util.List;

public class DeviceTypeListAdapter
  extends RecyclerView.Adapter
{
  private Context a;
  private List<b> b;
  private c c;
  
  public DeviceTypeListAdapter(Context paramContext)
  {
    this.a = paramContext;
  }
  
  private void n()
  {
    Resources localResources = this.a.getResources();
    String str = d.a();
    Object localObject1 = this.b;
    Object localObject2 = localResources.getString(2131952870);
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("https://www.tapo.com/app/#/faqList2?categoryType=");
    ((StringBuilder)localObject3).append(localResources.getString(2131952028));
    ((StringBuilder)localObject3).append(str);
    ((List)localObject1).add(new b(2131689544, (String)localObject2, ((StringBuilder)localObject3).toString(), EnumFeedbackCategory.CAMERA));
    localObject2 = this.b;
    localObject3 = localResources.getString(2131952881);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("https://www.tapo.com/app/#/faqList2?categoryType=");
    ((StringBuilder)localObject1).append(localResources.getString(2131953386));
    ((StringBuilder)localObject1).append(str);
    ((List)localObject2).add(new b(2131689670, (String)localObject3, ((StringBuilder)localObject1).toString(), EnumFeedbackCategory.PLUG));
    localObject3 = this.b;
    localObject2 = localResources.getString(2131952867);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("https://www.tapo.com/app/#/faqList2?categoryType=");
    ((StringBuilder)localObject1).append(localResources.getString(2131951844));
    ((StringBuilder)localObject1).append(str);
    ((List)localObject3).add(new b(2131689965, (String)localObject2, ((StringBuilder)localObject1).toString(), EnumFeedbackCategory.BULB));
    localObject2 = this.b;
    localObject3 = localResources.getString(2131952875);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("https://www.tapo.com/app/#/faqList2?categoryType=");
    ((StringBuilder)localObject1).append(localResources.getString(2131951844));
    ((StringBuilder)localObject1).append(str);
    ((List)localObject2).add(new b(2131690034, (String)localObject3, ((StringBuilder)localObject1).toString(), EnumFeedbackCategory.LIGHT_STRIP));
    if (q(EnumDeviceType.HUB))
    {
      localObject3 = this.b;
      localObject2 = localResources.getString(2131952874);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("https://www.tapo.com/app/#/faqList2?categoryType=");
      ((StringBuilder)localObject1).append(localResources.getString(2131952857));
      ((StringBuilder)localObject1).append(str);
      ((List)localObject3).add(new b(2131690022, (String)localObject2, ((StringBuilder)localObject1).toString(), EnumFeedbackCategory.HUB));
    }
    if (q(EnumDeviceType.SENSOR))
    {
      localObject2 = this.b;
      localObject3 = localResources.getString(2131952878);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("https://www.tapo.com/app/#/faqList2?categoryType=");
      ((StringBuilder)localObject1).append(localResources.getString(2131953130));
      ((StringBuilder)localObject1).append(str);
      ((List)localObject2).add(new b(2131690049, (String)localObject3, ((StringBuilder)localObject1).toString(), EnumFeedbackCategory.MOTION_SENSOR));
      localObject3 = this.b;
      localObject2 = localResources.getString(2131952872);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("https://www.tapo.com/app/#/faqList2?categoryType=");
      ((StringBuilder)localObject1).append(localResources.getString(2131952471));
      ((StringBuilder)localObject1).append(str);
      ((List)localObject3).add(new b(2131690052, (String)localObject2, ((StringBuilder)localObject1).toString(), EnumFeedbackCategory.CONTACT_SENSOR));
      localObject3 = this.b;
      localObject1 = localResources.getString(2131952868);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("https://www.tapo.com/app/#/faqList2?categoryType=");
      ((StringBuilder)localObject2).append(localResources.getString(2131951847));
      ((StringBuilder)localObject2).append(str);
      ((List)localObject3).add(new b(2131689969, (String)localObject1, ((StringBuilder)localObject2).toString(), EnumFeedbackCategory.BUTTON));
    }
    if (q(EnumDeviceType.SWITCH))
    {
      localObject3 = this.b;
      localObject2 = localResources.getString(2131952883);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("https://www.tapo.com/app/#/faqList2?categoryType=");
      ((StringBuilder)localObject1).append(localResources.getString(2131954191));
      ((StringBuilder)localObject1).append(str);
      ((List)localObject3).add(new b(2131690062, (String)localObject2, ((StringBuilder)localObject1).toString(), EnumFeedbackCategory.SWITCH));
    }
    if (q(EnumDeviceType.ENERGY))
    {
      localObject1 = this.b;
      localObject3 = localResources.getString(2131952884);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("https://www.tapo.com/app/#/faqList2?categoryType=");
      ((StringBuilder)localObject2).append(localResources.getString(2131954280));
      ((StringBuilder)localObject2).append(str);
      ((List)localObject1).add(new b(2131690097, (String)localObject3, ((StringBuilder)localObject2).toString(), EnumFeedbackCategory.TRV));
    }
    localObject1 = this.b;
    localObject3 = this.a.getResources().getString(2131952445);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("https://www.tapo.com/app/#/faqList2?categoryType=");
    ((StringBuilder)localObject2).append(localResources.getString(2131953336));
    ((StringBuilder)localObject2).append(str);
    ((List)localObject1).add(new b(2131689669, (String)localObject3, ((StringBuilder)localObject2).toString(), EnumFeedbackCategory.OTHER));
  }
  
  private boolean q(EnumDeviceType paramEnumDeviceType)
  {
    String[] arrayOfString = a.a();
    int i = arrayOfString.length;
    for (int j = 0; j < i; j++) {
      if (arrayOfString[j].equals(paramEnumDeviceType.getDeviceType())) {
        return true;
      }
    }
    return false;
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
  
  public void o()
  {
    if (this.b == null) {
      this.b = new ArrayList();
    }
    this.b.clear();
    n();
    notifyDataSetChanged();
  }
  
  public void onBindViewHolder(@NonNull RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    final b localb = (b)this.b.get(paramInt);
    paramViewHolder = (DeviceTypeListViewHolder)paramViewHolder;
    paramViewHolder.mDeviceTypeIv.setImageResource(localb.a);
    paramViewHolder.mDeviceTypeNameTv.setText(localb.b);
    paramViewHolder.itemView.setOnClickListener(new a(localb));
  }
  
  @NonNull
  public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    return new DeviceTypeListViewHolder(LayoutInflater.from(this.a).inflate(2131559027, paramViewGroup, false));
  }
  
  public void p(c paramc)
  {
    this.c = paramc;
  }
  
  class DeviceTypeListViewHolder
    extends RecyclerView.ViewHolder
  {
    @BindView
    ImageView mDeviceTypeIv;
    @BindView
    TextView mDeviceTypeNameTv;
    
    public DeviceTypeListViewHolder(View paramView)
    {
      super();
      ButterKnife.b(this, paramView);
    }
  }
  
  class a
    implements View.OnClickListener
  {
    a(DeviceTypeListAdapter.b paramb) {}
    
    public void onClick(View paramView)
    {
      if (DeviceTypeListAdapter.m(DeviceTypeListAdapter.this) != null)
      {
        paramView = DeviceTypeListAdapter.m(DeviceTypeListAdapter.this);
        DeviceTypeListAdapter.b localb = localb;
        paramView.O(localb.c, localb.b, localb.d);
      }
    }
  }
  
  private static class b
  {
    int a;
    String b;
    String c;
    EnumFeedbackCategory d;
    
    public b(int paramInt, String paramString1, String paramString2, EnumFeedbackCategory paramEnumFeedbackCategory)
    {
      this.a = paramInt;
      this.b = paramString1;
      this.c = paramString2;
      this.d = paramEnumFeedbackCategory;
    }
  }
  
  public static abstract interface c
  {
    public abstract void O(String paramString1, String paramString2, EnumFeedbackCategory paramEnumFeedbackCategory);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\adapter\feedback\DeviceTypeListAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */