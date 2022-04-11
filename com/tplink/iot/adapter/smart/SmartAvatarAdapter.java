package com.tplink.iot.adapter.smart;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.bumptech.glide.c;
import com.bumptech.glide.h;
import com.bumptech.glide.i;
import com.bumptech.glide.load.engine.j;
import com.bumptech.glide.request.a;
import com.bumptech.glide.request.g;
import com.tplink.libtpnetwork.IoTNetwork.repository.SmartRepository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SmartAvatarAdapter
  extends RecyclerView.Adapter<b>
{
  private List<String> a = new ArrayList(Arrays.asList(SmartRepository.i));
  private Context b;
  private c c;
  
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
    final String str = (String)this.a.get(paramInt);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("file:///android_asset/smart_icons/");
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append(".png");
    localObject = ((StringBuilder)localObject).toString();
    c.u(this.b).s((String)localObject).m0(new g().f(j.d)).x0(b.c(paramb));
    paramb.itemView.setOnClickListener(new a(str));
  }
  
  @NonNull
  public b o(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    this.b = paramViewGroup.getContext();
    return new b(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559086, paramViewGroup, false));
  }
  
  public void p(c paramc)
  {
    this.c = paramc;
  }
  
  class a
    implements View.OnClickListener
  {
    a(String paramString) {}
    
    public void onClick(View paramView)
    {
      if (SmartAvatarAdapter.m(SmartAvatarAdapter.this) != null) {
        SmartAvatarAdapter.m(SmartAvatarAdapter.this).a(str);
      }
    }
  }
  
  class b
    extends RecyclerView.ViewHolder
  {
    private ImageView a;
    
    b(View paramView)
    {
      super();
      this.a = ((ImageView)paramView.findViewById(2131362999));
    }
  }
  
  public static abstract interface c
  {
    public abstract void a(String paramString);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\adapter\smart\SmartAvatarAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */