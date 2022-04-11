package com.tplink.iot.adapter.about;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tplink.iot.view.about.LicenseItemActivity;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

public class LicenseListAdapter
  extends RecyclerView.Adapter<b>
{
  private LayoutInflater a;
  private Map<String, Integer> b;
  
  public LicenseListAdapter(Context paramContext)
  {
    this.a = LayoutInflater.from(paramContext);
    paramContext = new LinkedHashMap();
    this.b = paramContext;
    paramContext.put("BottomBar", Integer.valueOf(2131951660));
    this.b.put("CircularReveal", Integer.valueOf(2131951662));
    this.b.put("DiscreteScrollView", Integer.valueOf(2131951664));
    this.b.put("EventBus", Integer.valueOf(2131951666));
    this.b.put("EasyPermissions", Integer.valueOf(2131951665));
    paramContext = this.b;
    Integer localInteger = Integer.valueOf(2131951667);
    paramContext.put("gcm", localInteger);
    this.b.put("greenDAO", Integer.valueOf(2131951668));
    this.b.put("Gson", localInteger);
    this.b.put("Logger", Integer.valueOf(2131951674));
    this.b.put("lottie-android", Integer.valueOf(2131951675));
    this.b.put("MagicIndicator", Integer.valueOf(2131951676));
    this.b.put("Material DateTime Picker", Integer.valueOf(2131951677));
    this.b.put("Mosby", Integer.valueOf(2131951679));
    this.b.put("MySnackBar", Integer.valueOf(2131951682));
    this.b.put("NativeStackBlur", Integer.valueOf(2131951683));
    this.b.put("OkHttp", Integer.valueOf(2131951685));
    this.b.put("RippleBackground", Integer.valueOf(2131951691));
    this.b.put("RippleEffect", Integer.valueOf(2131951692));
    this.b.put("RoundedImageView", Integer.valueOf(2131951693));
    this.b.put("WheelPicker", Integer.valueOf(2131951699));
    this.b.put("RxJava", Integer.valueOf(2131951695));
    this.b.put("RxAndroid", Integer.valueOf(2131951694));
    this.b.put("ReactiveNetwork", Integer.valueOf(2131951689));
    this.b.put("Retrofit", Integer.valueOf(2131951690));
    this.b.put("ButterKnife", Integer.valueOf(2131951661));
    this.b.put("PhotoView", Integer.valueOf(2131951688));
    this.b.put("MPAndroidChart", Integer.valueOf(2131951680));
    this.b.put("SmartRefreshLayout", Integer.valueOf(2131951698));
    this.b.put("Okio", Integer.valueOf(2131951686));
    this.b.put("ScrollLayout", Integer.valueOf(2131951696));
    this.b.put("Netty", Integer.valueOf(2131951684));
    this.b.put("Mqtt", Integer.valueOf(2131951681));
    this.b.put("JavaHamcrest", Integer.valueOf(2131951670));
    this.b.put("JUnit 4", Integer.valueOf(2131951671));
    this.b.put("Mockito", Integer.valueOf(2131951678));
    this.b.put("Android-skin-support", Integer.valueOf(2131951697));
  }
  
  public int getItemCount()
  {
    return this.b.size();
  }
  
  public void o(@NonNull b paramb, int paramInt)
  {
    final String str = (String)this.b.keySet().toArray()[paramInt];
    paramb.a.setText(str);
    paramb.itemView.setOnClickListener(new a(str));
  }
  
  @NonNull
  public b p(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    return new b(this.a.inflate(2131559169, paramViewGroup, false));
  }
  
  class a
    implements View.OnClickListener
  {
    a(String paramString) {}
    
    public void onClick(View paramView)
    {
      paramView = new Intent(LicenseListAdapter.m(LicenseListAdapter.this).getContext(), LicenseItemActivity.class);
      paramView.putExtra("toolbar_title", str);
      paramView.putExtra("content", (Serializable)LicenseListAdapter.n(LicenseListAdapter.this).get(str));
      LicenseListAdapter.m(LicenseListAdapter.this).getContext().startActivity(paramView);
    }
  }
  
  static class b
    extends RecyclerView.ViewHolder
  {
    TextView a;
    
    b(View paramView)
    {
      super();
      this.a = ((TextView)paramView.findViewById(2131363224));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\adapter\about\LicenseListAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */