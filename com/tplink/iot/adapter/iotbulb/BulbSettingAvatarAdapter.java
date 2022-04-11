package com.tplink.iot.adapter.iotbulb;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tplink.iot.Utils.z0.g;
import com.tplink.iot.model.iot.a;
import com.tplink.libtpnetwork.enumerate.EnumBulbAvatarType;
import java.util.List;

public class BulbSettingAvatarAdapter
  extends RecyclerView.Adapter<b>
{
  private List<a> a;
  private int b;
  private c c;
  
  public BulbSettingAvatarAdapter(List<a> paramList)
  {
    this.a = paramList;
  }
  
  private void s(int paramInt)
  {
    for (int i = 0; i < getItemCount(); i++) {
      ((a)this.a.get(i)).c(false);
    }
    ((a)this.a.get(paramInt)).c(true);
    notifyDataSetChanged();
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
  
  public EnumBulbAvatarType p()
  {
    return ((a)this.a.get(this.b)).a();
  }
  
  public void q(@NonNull b paramb, final int paramInt)
  {
    a locala = (a)this.a.get(paramInt);
    b.c(paramb).setImageResource(g.e(locala.a()));
    if (locala.b())
    {
      b.d(paramb).setVisibility(0);
      this.b = paramInt;
    }
    else
    {
      b.d(paramb).setVisibility(8);
    }
    paramb.itemView.setOnClickListener(new a(paramInt));
  }
  
  @NonNull
  public b r(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    return new b(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559080, paramViewGroup, false));
  }
  
  public void t(c paramc)
  {
    this.c = paramc;
  }
  
  class a
    implements View.OnClickListener
  {
    a(int paramInt) {}
    
    public void onClick(View paramView)
    {
      BulbSettingAvatarAdapter.m(BulbSettingAvatarAdapter.this, paramInt);
      BulbSettingAvatarAdapter.n(BulbSettingAvatarAdapter.this, paramInt);
      if (BulbSettingAvatarAdapter.o(BulbSettingAvatarAdapter.this) != null) {
        BulbSettingAvatarAdapter.o(BulbSettingAvatarAdapter.this).e(paramInt);
      }
    }
  }
  
  class b
    extends RecyclerView.ViewHolder
  {
    private ImageView a;
    private ImageView b;
    
    public b(View paramView)
    {
      super();
      this.a = ((ImageView)paramView.findViewById(2131362999));
      this.b = ((ImageView)paramView.findViewById(2131363118));
    }
  }
  
  public static abstract interface c
  {
    public abstract void e(int paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\adapter\iotbulb\BulbSettingAvatarAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */