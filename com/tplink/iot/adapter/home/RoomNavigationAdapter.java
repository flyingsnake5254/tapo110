package com.tplink.iot.adapter.home;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tplink.iot.model.home.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class RoomNavigationAdapter
  extends RecyclerView.Adapter<ItemViewHolder>
  implements k
{
  private int a = 0;
  private List<a> b = new ArrayList();
  private Activity c;
  private c d;
  
  public RoomNavigationAdapter(Activity paramActivity)
  {
    this.c = paramActivity;
  }
  
  private static String o(Context paramContext, int paramInt)
  {
    if (paramInt <= 0) {
      return paramContext.getResources().getString(2131953204);
    }
    if (paramInt == 1)
    {
      localObject = paramContext.getResources();
      paramContext = new StringBuilder();
      paramContext.append(paramInt);
      paramContext.append("");
      return ((Resources)localObject).getString(2131954041, new Object[] { paramContext.toString() });
    }
    paramContext = paramContext.getResources();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append("");
    return paramContext.getString(2131954042, new Object[] { ((StringBuilder)localObject).toString() });
  }
  
  public boolean e()
  {
    int i = this.a;
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    return bool;
  }
  
  public void f(int paramInt1, int paramInt2)
  {
    List localList = this.b;
    if ((localList != null) && (localList.size() > 1) && (paramInt1 != paramInt2) && (paramInt1 >= 0) && (paramInt1 < this.b.size()) && (paramInt2 >= 0) && (paramInt2 < this.b.size()))
    {
      Collections.swap(this.b, paramInt1, paramInt2);
      notifyItemMoved(paramInt1, paramInt2);
    }
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
  
  public List<String> p()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((a)localIterator.next()).c());
    }
    return localArrayList;
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public void q(@NonNull final ItemViewHolder paramItemViewHolder, final int paramInt)
  {
    final a locala = (a)this.b.get(paramInt);
    paramItemViewHolder.a.setText(locala.a());
    paramItemViewHolder.b.setText(o(this.c, locala.b()));
    if (this.a == 0) {
      paramItemViewHolder.c.setImageResource(2131689680);
    } else {
      paramItemViewHolder.c.setImageResource(2131689841);
    }
    paramItemViewHolder.itemView.setOnClickListener(new a(paramInt, locala));
    paramItemViewHolder.c.setOnTouchListener(new b(paramItemViewHolder));
  }
  
  @NonNull
  public ItemViewHolder r(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    return new ItemViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559042, paramViewGroup, false));
  }
  
  public void s(List<a> paramList)
  {
    this.b.clear();
    if ((paramList != null) && (!paramList.isEmpty())) {
      this.b.addAll(paramList);
    }
    notifyDataSetChanged();
  }
  
  public void t(int paramInt)
  {
    this.a = paramInt;
    notifyDataSetChanged();
  }
  
  public void u(c paramc)
  {
    this.d = paramc;
  }
  
  public class ItemViewHolder
    extends RecyclerView.ViewHolder
  {
    TextView a;
    TextView b;
    ImageView c;
    
    public ItemViewHolder(View paramView)
    {
      super();
      this.a = ((TextView)paramView.findViewById(2131364610));
      this.b = ((TextView)paramView.findViewById(2131364611));
      this.c = ((ImageView)paramView.findViewById(2131363869));
    }
  }
  
  class a
    implements View.OnClickListener
  {
    a(int paramInt, a parama) {}
    
    public void onClick(View paramView)
    {
      if ((RoomNavigationAdapter.m(RoomNavigationAdapter.this) == 0) && (RoomNavigationAdapter.n(RoomNavigationAdapter.this) != null)) {
        RoomNavigationAdapter.n(RoomNavigationAdapter.this).O0(paramInt, locala);
      }
    }
  }
  
  class b
    implements View.OnTouchListener
  {
    b(RoomNavigationAdapter.ItemViewHolder paramItemViewHolder) {}
    
    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      if ((paramMotionEvent.getAction() == 0) && (RoomNavigationAdapter.m(RoomNavigationAdapter.this) == 1) && (RoomNavigationAdapter.n(RoomNavigationAdapter.this) != null))
      {
        RoomNavigationAdapter.n(RoomNavigationAdapter.this).f0(paramItemViewHolder);
        return true;
      }
      return false;
    }
  }
  
  public static abstract interface c
  {
    public abstract void O0(int paramInt, a parama);
    
    public abstract void f0(RoomNavigationAdapter.ItemViewHolder paramItemViewHolder);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\adapter\home\RoomNavigationAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */