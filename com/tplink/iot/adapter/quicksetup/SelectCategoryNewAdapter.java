package com.tplink.iot.adapter.quicksetup;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tplink.iot.view.quicksetup.base.a;
import com.tplink.iot.view.quicksetup.base.c;
import java.util.List;

public class SelectCategoryNewAdapter
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  private Context a;
  private List<DeviceCategoryBean> b;
  private e c;
  
  public SelectCategoryNewAdapter(Context paramContext, List<DeviceCategoryBean> paramList)
  {
    this.a = paramContext;
    this.b = paramList;
  }
  
  private int o(String paramString)
  {
    paramString.hashCode();
    int i = paramString.hashCode();
    int j = -1;
    switch (i)
    {
    default: 
      break;
    case 1966791146: 
      if (paramString.equals("C320WS")) {
        j = 25;
      }
      break;
    case 78189475: 
      if (paramString.equals("S200B")) {
        j = 24;
      }
      break;
    case 2568584: 
      if (paramString.equals("TC70")) {
        j = 23;
      }
      break;
    case 2568558: 
      if (paramString.equals("TC65")) {
        j = 22;
      }
      break;
    case 2568553: 
      if (paramString.equals("TC60")) {
        j = 21;
      }
      break;
    case 2551100: 
      if (paramString.equals("T110")) {
        j = 20;
      }
      break;
    case 2551069: 
      if (paramString.equals("T100")) {
        j = 19;
      }
      break;
    case 2522301: 
      if (paramString.equals("S220")) {
        j = 18;
      }
      break;
    case 2522270: 
      if (paramString.equals("S210")) {
        j = 17;
      }
      break;
    case 2431941: 
      if (paramString.equals("P115")) {
        j = 16;
      }
      break;
    case 2431936: 
      if (paramString.equals("P110")) {
        j = 15;
      }
      break;
    case 2431910: 
      if (paramString.equals("P105")) {
        j = 14;
      }
      break;
    case 2431905: 
      if (paramString.equals("P100")) {
        j = 13;
      }
      break;
    case 2320522: 
      if (paramString.equals("L930")) {
        j = 12;
      }
      break;
    case 2320491: 
      if (paramString.equals("L920")) {
        j = 11;
      }
      break;
    case 2320429: 
      if (paramString.equals("L900")) {
        j = 10;
      }
      break;
    case 2316678: 
      if (paramString.equals("L530")) {
        j = 9;
      }
      break;
    case 2316647: 
      if (paramString.equals("L520")) {
        j = 8;
      }
      break;
    case 2316616: 
      if (paramString.equals("L510")) {
        j = 7;
      }
      break;
    case 2193577: 
      if (paramString.equals("H100")) {
        j = 6;
      }
      break;
    case 2104204: 
      if (paramString.equals("E100")) {
        j = 5;
      }
      break;
    case 2046575: 
      if (paramString.equals("C310")) {
        j = 4;
      }
      break;
    case 2045614: 
      if (paramString.equals("C210")) {
        j = 3;
      }
      break;
    case 2045583: 
      if (paramString.equals("C200")) {
        j = 2;
      }
      break;
    case 2044653: 
      if (paramString.equals("C110")) {
        j = 1;
      }
      break;
    case 2044622: 
      if (paramString.equals("C100")) {
        j = 0;
      }
      break;
    }
    switch (j)
    {
    default: 
      return c.T(paramString);
    case 24: 
      return 2131231475;
    case 20: 
      return 2131690428;
    case 19: 
      return 2131231599;
    case 18: 
      return 2131231477;
    case 17: 
      return 2131231476;
    case 13: 
    case 14: 
    case 15: 
    case 16: 
      return c.T(paramString);
    case 11: 
    case 12: 
      return 2131690118;
    case 10: 
      return 2131690117;
    case 9: 
      return 2131689529;
    case 8: 
      return 2131690116;
    case 7: 
      return 2131689528;
    case 6: 
      return 2131689691;
    case 5: 
      return 2131231653;
    case 4: 
    case 22: 
    case 25: 
      return 2131689542;
    case 2: 
    case 3: 
    case 23: 
      return 2131689540;
    }
    return 2131689538;
  }
  
  private String p(String paramString)
  {
    String str = this.a.getString(2131951830);
    paramString.hashCode();
    int i = paramString.hashCode();
    int j = -1;
    switch (i)
    {
    default: 
      break;
    case 1966791146: 
      if (paramString.equals("C320WS")) {
        j = 25;
      }
      break;
    case 78189475: 
      if (paramString.equals("S200B")) {
        j = 24;
      }
      break;
    case 2568584: 
      if (paramString.equals("TC70")) {
        j = 23;
      }
      break;
    case 2568558: 
      if (paramString.equals("TC65")) {
        j = 22;
      }
      break;
    case 2568553: 
      if (paramString.equals("TC60")) {
        j = 21;
      }
      break;
    case 2551100: 
      if (paramString.equals("T110")) {
        j = 20;
      }
      break;
    case 2551069: 
      if (paramString.equals("T100")) {
        j = 19;
      }
      break;
    case 2522301: 
      if (paramString.equals("S220")) {
        j = 18;
      }
      break;
    case 2522270: 
      if (paramString.equals("S210")) {
        j = 17;
      }
      break;
    case 2431941: 
      if (paramString.equals("P115")) {
        j = 16;
      }
      break;
    case 2431936: 
      if (paramString.equals("P110")) {
        j = 15;
      }
      break;
    case 2431910: 
      if (paramString.equals("P105")) {
        j = 14;
      }
      break;
    case 2431905: 
      if (paramString.equals("P100")) {
        j = 13;
      }
      break;
    case 2320522: 
      if (paramString.equals("L930")) {
        j = 12;
      }
      break;
    case 2320491: 
      if (paramString.equals("L920")) {
        j = 11;
      }
      break;
    case 2320429: 
      if (paramString.equals("L900")) {
        j = 10;
      }
      break;
    case 2316678: 
      if (paramString.equals("L530")) {
        j = 9;
      }
      break;
    case 2316647: 
      if (paramString.equals("L520")) {
        j = 8;
      }
      break;
    case 2316616: 
      if (paramString.equals("L510")) {
        j = 7;
      }
      break;
    case 2193577: 
      if (paramString.equals("H100")) {
        j = 6;
      }
      break;
    case 2104204: 
      if (paramString.equals("E100")) {
        j = 5;
      }
      break;
    case 2046575: 
      if (paramString.equals("C310")) {
        j = 4;
      }
      break;
    case 2045614: 
      if (paramString.equals("C210")) {
        j = 3;
      }
      break;
    case 2045583: 
      if (paramString.equals("C200")) {
        j = 2;
      }
      break;
    case 2044653: 
      if (paramString.equals("C110")) {
        j = 1;
      }
      break;
    case 2044622: 
      if (paramString.equals("C100")) {
        j = 0;
      }
      break;
    }
    switch (j)
    {
    default: 
      return this.a.getString(2131953370);
    case 25: 
      paramString = new StringBuilder();
      paramString.append(str);
      paramString.append(" ");
      paramString.append(this.a.getString(2131951877));
      return paramString.toString();
    case 24: 
      paramString = new StringBuilder();
      paramString.append(str);
      paramString.append(" ");
      paramString.append(this.a.getString(2131951848));
      return paramString.toString();
    case 23: 
      return this.a.getString(2131952057);
    case 22: 
      return this.a.getString(2131952056);
    case 21: 
      return this.a.getString(2131952055);
    case 20: 
      paramString = new StringBuilder();
      paramString.append(str);
      paramString.append(" ");
      paramString.append(this.a.getString(2131953770));
      return paramString.toString();
    case 19: 
      paramString = new StringBuilder();
      paramString.append(str);
      paramString.append(" ");
      paramString.append(this.a.getString(2131953763));
      return paramString.toString();
    case 18: 
      paramString = new StringBuilder();
      paramString.append(str);
      paramString.append(" ");
      paramString.append(this.a.getString(2131954212));
      return paramString.toString();
    case 17: 
      paramString = new StringBuilder();
      paramString.append(str);
      paramString.append(" ");
      paramString.append(this.a.getString(2131954211));
      return paramString.toString();
    case 16: 
      paramString = new StringBuilder();
      paramString.append(str);
      paramString.append(" ");
      paramString.append(this.a.getString(2131953380));
      return paramString.toString();
    case 15: 
      paramString = new StringBuilder();
      paramString.append(str);
      paramString.append(" ");
      paramString.append(this.a.getString(2131953379));
      return paramString.toString();
    case 14: 
      paramString = new StringBuilder();
      paramString.append(str);
      paramString.append(" ");
      paramString.append(this.a.getString(2131953378));
      return paramString.toString();
    case 13: 
      paramString = new StringBuilder();
      paramString.append(str);
      paramString.append(" ");
      paramString.append(this.a.getString(2131953377));
      return paramString.toString();
    case 12: 
      paramString = new StringBuilder();
      paramString.append(str);
      paramString.append(" ");
      paramString.append(this.a.getString(2131952948));
      return paramString.toString();
    case 11: 
      paramString = new StringBuilder();
      paramString.append(str);
      paramString.append(" ");
      paramString.append(this.a.getString(2131952947));
      return paramString.toString();
    case 10: 
      paramString = new StringBuilder();
      paramString.append(str);
      paramString.append(" ");
      paramString.append(this.a.getString(2131952946));
      return paramString.toString();
    case 9: 
      paramString = new StringBuilder();
      paramString.append(str);
      paramString.append(" ");
      paramString.append(this.a.getString(2131951843));
      return paramString.toString();
    case 8: 
      paramString = new StringBuilder();
      paramString.append(str);
      paramString.append(" ");
      paramString.append(this.a.getString(2131951842));
      return paramString.toString();
    case 7: 
      paramString = new StringBuilder();
      paramString.append(str);
      paramString.append(" ");
      paramString.append(this.a.getString(2131951841));
      return paramString.toString();
    case 6: 
      paramString = new StringBuilder();
      paramString.append(str);
      paramString.append(" ");
      paramString.append(this.a.getString(2131952854));
      return paramString.toString();
    case 5: 
      return this.a.getString(2131954315);
    case 4: 
      paramString = new StringBuilder();
      paramString.append(str);
      paramString.append(" ");
      paramString.append(this.a.getString(2131951876));
      return paramString.toString();
    case 3: 
      paramString = new StringBuilder();
      paramString.append(str);
      paramString.append(" ");
      paramString.append(this.a.getString(2131951875));
      return paramString.toString();
    case 2: 
      paramString = new StringBuilder();
      paramString.append(str);
      paramString.append(" ");
      paramString.append(this.a.getString(2131951874));
      return paramString.toString();
    case 1: 
      paramString = new StringBuilder();
      paramString.append(str);
      paramString.append(" ");
      paramString.append(this.a.getString(2131951873));
      return paramString.toString();
    }
    paramString = new StringBuilder();
    paramString.append(str);
    paramString.append(" ");
    paramString.append(this.a.getString(2131951872));
    return paramString.toString();
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
  
  public int getItemViewType(int paramInt)
  {
    if (((DeviceCategoryBean)this.b.get(paramInt)).isCategory()) {
      return 0;
    }
    return 1;
  }
  
  public void onAttachedToRecyclerView(@NonNull RecyclerView paramRecyclerView)
  {
    ((GridLayoutManager)paramRecyclerView.getLayoutManager()).setSpanSizeLookup(new b());
  }
  
  public void onBindViewHolder(@NonNull RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    final DeviceCategoryBean localDeviceCategoryBean = (DeviceCategoryBean)this.b.get(paramInt);
    if (localDeviceCategoryBean.isCategory())
    {
      ((c)paramViewHolder).a.setText(localDeviceCategoryBean.getCategoryName());
    }
    else
    {
      paramViewHolder = (d)paramViewHolder;
      paramViewHolder.a.setImageResource(o(localDeviceCategoryBean.getDevice()));
      paramViewHolder.b.setText(p(localDeviceCategoryBean.getDevice()));
      if (localDeviceCategoryBean.isEnable())
      {
        paramViewHolder.a.setAlpha(1.0F);
        paramViewHolder.b.setTextColor(this.a.getResources().getColor(2131099799));
        paramViewHolder.c.setVisibility(4);
      }
      else
      {
        paramViewHolder.a.setAlpha(0.3F);
        paramViewHolder.b.setTextColor(this.a.getResources().getColor(2131099788));
        paramViewHolder.c.setVisibility(0);
      }
      paramViewHolder.itemView.setOnClickListener(new a(localDeviceCategoryBean));
    }
  }
  
  @NonNull
  public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 0) {
      return new c(LayoutInflater.from(this.a).inflate(2131559165, paramViewGroup, false));
    }
    return new d(LayoutInflater.from(this.a).inflate(2131559166, paramViewGroup, false));
  }
  
  public void q(e parame)
  {
    this.c = parame;
  }
  
  class a
    extends a
  {
    a(DeviceCategoryBean paramDeviceCategoryBean) {}
    
    public void a(View paramView)
    {
      if (SelectCategoryNewAdapter.m(SelectCategoryNewAdapter.this) != null) {
        SelectCategoryNewAdapter.m(SelectCategoryNewAdapter.this).a(localDeviceCategoryBean);
      }
    }
  }
  
  class b
    extends GridLayoutManager.SpanSizeLookup
  {
    b() {}
    
    public int getSpanSize(int paramInt)
    {
      if (((DeviceCategoryBean)SelectCategoryNewAdapter.n(SelectCategoryNewAdapter.this).get(paramInt)).isCategory()) {
        return 2;
      }
      return 1;
    }
  }
  
  class c
    extends RecyclerView.ViewHolder
  {
    final TextView a;
    
    public c(View paramView)
    {
      super();
      this.a = ((TextView)paramView.findViewById(2131364362));
    }
  }
  
  class d
    extends RecyclerView.ViewHolder
  {
    final ImageView a;
    final TextView b;
    final TextView c;
    
    public d(View paramView)
    {
      super();
      this.a = ((ImageView)paramView.findViewById(2131362818));
      this.b = ((TextView)paramView.findViewById(2131364406));
      this.c = ((TextView)paramView.findViewById(2131364379));
    }
  }
  
  public static abstract interface e
  {
    public abstract void a(DeviceCategoryBean paramDeviceCategoryBean);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\adapter\quicksetup\SelectCategoryNewAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */