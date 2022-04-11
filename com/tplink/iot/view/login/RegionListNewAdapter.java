package com.tplink.iot.view.login;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tplink.iot.databinding.ItemRegionListContentBinding;
import com.tplink.iot.databinding.ItemRegionListTitleBinding;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RegionListNewAdapter
  extends RecyclerView.Adapter
{
  private List<com.tplink.iot.j.b.a> a = new ArrayList();
  private List<b> b = new ArrayList();
  private Context c;
  private String[] d;
  private int[] e;
  private int[] f;
  private c g;
  private int h;
  
  public RegionListNewAdapter(Context paramContext, c paramc)
  {
    String[] arrayOfString = new String[26];
    arrayOfString[0] = "A";
    arrayOfString[1] = "B";
    arrayOfString[2] = "C";
    arrayOfString[3] = "D";
    arrayOfString[4] = "E";
    arrayOfString[5] = "F";
    arrayOfString[6] = "G";
    arrayOfString[7] = "H";
    arrayOfString[8] = "I";
    arrayOfString[9] = "J";
    arrayOfString[10] = "K";
    arrayOfString[11] = "L";
    arrayOfString[12] = "M";
    arrayOfString[13] = "N";
    arrayOfString[14] = "O";
    arrayOfString[15] = "P";
    arrayOfString[16] = "Q";
    arrayOfString[17] = "R";
    arrayOfString[18] = "S";
    arrayOfString[19] = "T";
    arrayOfString[20] = "U";
    arrayOfString[21] = "V";
    arrayOfString[22] = "W";
    arrayOfString[23] = "X";
    arrayOfString[24] = "Y";
    arrayOfString[25] = "Z";
    this.d = arrayOfString;
    this.e = new int[arrayOfString.length];
    this.h = -1;
    this.c = paramContext;
    this.g = paramc;
  }
  
  private void m()
  {
    this.b.clear();
    int i = 0;
    int j = 1;
    int k = 0;
    int m = 0;
    int n;
    for (;;)
    {
      n = k;
      if (i >= this.a.size()) {
        break;
      }
      n = j;
      int i1 = k;
      int i2 = m;
      if (j != 0)
      {
        localObject1 = o(i);
        Object localObject2 = new b();
        ((b)localObject2).a = true;
        ((b)localObject2).c = ((String)localObject1);
        this.b.add(localObject2);
        for (j = k;; j++)
        {
          localObject2 = this.d;
          if ((j >= localObject2.length) || (localObject2[j].equalsIgnoreCase((String)localObject1))) {
            break;
          }
          this.e[j] = m;
        }
        k = j;
        if (j < this.d.length)
        {
          this.e[j] = m;
          k = j + 1;
        }
        i2 = m + 1;
        n = 0;
        i1 = k;
      }
      Object localObject1 = new b();
      ((b)localObject1).a = false;
      ((b)localObject1).b = i;
      j = n;
      if (i != this.a.size() - 1)
      {
        j = n;
        if (!o(i).equalsIgnoreCase(o(i + 1))) {
          j = 1;
        }
      }
      if (((com.tplink.iot.j.b.a)this.a.get(i)).c()) {
        this.h = i2;
      }
      this.b.add(localObject1);
      this.f[i] = i2;
      m = i2 + 1;
      i++;
      k = i1;
    }
    while (n < this.d.length)
    {
      this.e[n] = (this.b.size() - 1);
      n++;
    }
  }
  
  private void n()
  {
    this.b.clear();
    int i = 0;
    int j = 0;
    while (i < this.a.size())
    {
      b localb = new b();
      localb.a = false;
      localb.b = i;
      if (((com.tplink.iot.j.b.a)this.a.get(i)).c()) {
        this.h = j;
      }
      this.b.add(localb);
      j++;
      i++;
    }
  }
  
  private String o(int paramInt)
  {
    if (paramInt >= this.a.size()) {
      return "";
    }
    String str = ((com.tplink.iot.j.b.a)this.a.get(paramInt)).b();
    if ((str != null) && (str.length() != 0)) {
      return com.tplink.iot.j.b.a.e(str.substring(0, 1));
    }
    return "";
  }
  
  public int getItemCount()
  {
    List localList = this.b;
    int i;
    if (localList != null) {
      i = localList.size();
    } else {
      i = 0;
    }
    return i;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (((b)this.b.get(paramInt)).a) {
      return 1;
    }
    return super.getItemViewType(paramInt);
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((paramViewHolder instanceof e))
    {
      paramViewHolder = (ItemRegionListContentBinding)DataBindingUtil.getBinding(paramViewHolder.itemView);
      com.tplink.iot.j.b.a locala = (com.tplink.iot.j.b.a)this.a.get(((b)this.b.get(paramInt)).b);
      paramViewHolder.i(new com.tplink.iot.viewmodel.login.a(locala.b(), locala.a(), locala.c()));
      paramViewHolder.h(this.g);
      paramViewHolder.executePendingBindings();
    }
    else if ((paramViewHolder instanceof d))
    {
      paramViewHolder = (ItemRegionListTitleBinding)DataBindingUtil.getBinding(paramViewHolder.itemView);
      paramViewHolder.h(new com.tplink.iot.viewmodel.login.a(((b)this.b.get(paramInt)).c, null, false));
      paramViewHolder.executePendingBindings();
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 1) {
      return new d(((ItemRegionListTitleBinding)DataBindingUtil.inflate(LayoutInflater.from(paramViewGroup.getContext()), 2131559074, paramViewGroup, false)).getRoot());
    }
    return new e(((ItemRegionListContentBinding)DataBindingUtil.inflate(LayoutInflater.from(paramViewGroup.getContext()), 2131559073, paramViewGroup, false)).getRoot());
  }
  
  public int p()
  {
    return this.h;
  }
  
  public int q(String paramString)
  {
    for (int i = 0;; i++)
    {
      String[] arrayOfString = this.d;
      if (i >= arrayOfString.length) {
        break;
      }
      if (arrayOfString[i].equalsIgnoreCase(paramString)) {
        return this.e[i];
      }
    }
    return -1;
  }
  
  public void r(List<com.tplink.iot.j.b.a> paramList, boolean paramBoolean)
  {
    this.a.clear();
    this.a.addAll(paramList);
    this.f = new int[paramList.size()];
    Collections.sort(this.a, new a());
    if (paramBoolean) {
      m();
    } else {
      n();
    }
    notifyDataSetChanged();
  }
  
  public void s(String paramString)
  {
    for (int i = 0; i < this.a.size(); i++)
    {
      ((com.tplink.iot.j.b.a)this.a.get(i)).d(false);
      if (((com.tplink.iot.j.b.a)this.a.get(i)).b().equalsIgnoreCase(paramString))
      {
        ((com.tplink.iot.j.b.a)this.a.get(i)).d(true);
        this.h = this.f[i];
      }
    }
    notifyDataSetChanged();
  }
  
  class a
    implements Comparator<com.tplink.iot.j.b.a>
  {
    a() {}
    
    public int a(com.tplink.iot.j.b.a parama1, com.tplink.iot.j.b.a parama2)
    {
      return com.tplink.iot.j.b.a.e(parama1.b()).toUpperCase().compareTo(com.tplink.iot.j.b.a.e(parama2.b()).toUpperCase());
    }
  }
  
  class b
  {
    public boolean a = false;
    public int b = 0;
    public String c = "";
    
    public b() {}
  }
  
  public static abstract interface c
  {
    public abstract void a(String paramString1, String paramString2);
  }
  
  static class d
    extends RecyclerView.ViewHolder
  {
    public d(View paramView)
    {
      super();
    }
  }
  
  static class e
    extends RecyclerView.ViewHolder
  {
    public e(View paramView)
    {
      super();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\login\RegionListNewAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */