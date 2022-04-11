package com.tplink.iot.view.ipcamera.memories;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import b.d.q.b.o;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bumptech.glide.h;
import com.bumptech.glide.i;
import com.tplink.iot.Utils.o0;
import com.tplink.iot.Utils.r0;
import com.tplink.libtpmediaother.memory.MemoryBean;
import com.tplink.libtpmediaother.memory.q;
import com.tplink.libtpmediaother.memory.r;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MemoriesAdapter
  extends RecyclerView.Adapter
{
  private final int a = 1;
  private final int b = 2;
  private List<q> c = new ArrayList();
  private b d;
  private d e;
  private c f;
  private Context g;
  private boolean h;
  private Set<String> i;
  
  public MemoriesAdapter(Context paramContext)
  {
    this.g = paramContext;
    this.i = new HashSet();
  }
  
  private void F(int paramInt)
  {
    List localList = this.c;
    if ((localList != null) && (paramInt >= 0) && (paramInt < localList.size())) {
      this.c.remove(paramInt);
    }
  }
  
  private void N(List<MemoryBean> paramList)
  {
    if (paramList == null) {
      return;
    }
    paramList = t(paramList);
    this.c.clear();
    paramList = paramList.entrySet().iterator();
    while (paramList.hasNext())
    {
      Object localObject = (Map.Entry)paramList.next();
      this.c.add(new q(0, ((Map.Entry)localObject).getKey()));
      Iterator localIterator = ((List)((Map.Entry)localObject).getValue()).iterator();
      while (localIterator.hasNext())
      {
        localObject = (MemoryBean)localIterator.next();
        this.c.add(new q(1, localObject));
      }
    }
  }
  
  private int O(String paramString)
  {
    int j;
    try
    {
      j = Integer.valueOf(paramString).intValue();
    }
    catch (Exception paramString)
    {
      j = 0;
    }
    return j;
  }
  
  private String r(int paramInt)
  {
    int j = paramInt / 60;
    int k = paramInt % 60;
    if (j >= 60)
    {
      paramInt = j / 60;
      j %= 60;
    }
    else
    {
      paramInt = 0;
    }
    String str1;
    if (paramInt < 10) {
      str1 = "0".concat(String.valueOf(paramInt));
    } else {
      str1 = String.valueOf(paramInt);
    }
    String str2;
    if (j < 10) {
      str2 = "0".concat(String.valueOf(j));
    } else {
      str2 = String.valueOf(j);
    }
    String str3;
    if (k < 10) {
      str3 = "0".concat(String.valueOf(k));
    } else {
      str3 = String.valueOf(k);
    }
    return String.format(Locale.getDefault(), "%s:%s:%s", new Object[] { str1, str2, str3 });
  }
  
  private int s()
  {
    int j = getItemCount();
    int k = 0;
    if (j == 0) {
      return 0;
    }
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      q localq = (q)localIterator.next();
      if ((localq != null) && (localq.b() == 1)) {
        k++;
      }
    }
    return k;
  }
  
  private Map<String, List<MemoryBean>> t(List<MemoryBean> paramList)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        MemoryBean localMemoryBean = (MemoryBean)localIterator.next();
        long l = localMemoryBean.getTimestamp();
        paramList = o0.g(l);
        Object localObject = new Timestamp(l);
        if (r0.e((Timestamp)localObject)) {
          paramList = this.g.getString(2131954302);
        } else if (r0.f((Timestamp)localObject)) {
          paramList = this.g.getString(2131953068);
        }
        if (localLinkedHashMap.containsKey(paramList))
        {
          ((List)localLinkedHashMap.get(paramList)).add(localMemoryBean);
        }
        else
        {
          localObject = new ArrayList();
          ((List)localObject).add(localMemoryBean);
          localLinkedHashMap.put(paramList, localObject);
        }
      }
    }
    return localLinkedHashMap;
  }
  
  void D(boolean paramBoolean)
  {
    if (this.i.size() <= 0) {
      return;
    }
    Iterator localIterator = this.i.iterator();
    while (localIterator.hasNext())
    {
      int j = O((String)localIterator.next());
      if ((j < this.c.size()) && (getItemViewType(j) == 2))
      {
        MemoryBean localMemoryBean = (MemoryBean)((q)this.c.get(j)).a();
        localMemoryBean.setMark(paramBoolean);
        r.f().G(localMemoryBean);
      }
    }
    notifyDataSetChanged();
  }
  
  void E(MemoryBean paramMemoryBean, int paramInt)
  {
    List localList = this.c;
    if ((localList != null) && (paramInt < localList.size()) && (getItemViewType(paramInt) == 2))
    {
      ((MemoryBean)((q)this.c.get(paramInt)).a()).setMark(paramMemoryBean.isMark());
      notifyDataSetChanged();
    }
  }
  
  public void G()
  {
    for (int j = 0; j < this.c.size(); j++) {
      if (getItemViewType(j) == 2) {
        this.i.add(String.valueOf(j));
      }
    }
    notifyDataSetChanged();
  }
  
  public void H(boolean paramBoolean)
  {
    this.h = paramBoolean;
    if (!paramBoolean) {
      this.i.clear();
    }
    notifyDataSetChanged();
  }
  
  public void I(b paramb)
  {
    this.d = paramb;
  }
  
  public void J(List<MemoryBean> paramList)
  {
    N(paramList);
    notifyDataSetChanged();
    paramList = this.e;
    if (paramList != null) {
      paramList.onDataChanged();
    }
  }
  
  public void K(c paramc)
  {
    this.f = paramc;
  }
  
  public void L(d paramd)
  {
    this.e = paramd;
  }
  
  void M()
  {
    if (this.i.size() <= 0)
    {
      localObject1 = this.f;
      if (localObject1 != null) {
        ((c)localObject1).v(new ArrayList());
      }
      return;
    }
    Object localObject1 = new ArrayList();
    Object localObject2 = this.i.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      int j = O((String)((Iterator)localObject2).next());
      if ((j < this.c.size()) && (getItemViewType(j) == 2)) {
        ((List)localObject1).add((MemoryBean)((q)this.c.get(j)).a());
      }
    }
    localObject2 = this.f;
    if (localObject2 != null) {
      ((c)localObject2).v((List)localObject1);
    }
    this.i.clear();
    notifyDataSetChanged();
  }
  
  public int getItemCount()
  {
    List localList = this.c;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  public int getItemViewType(int paramInt)
  {
    if (((q)this.c.get(paramInt)).b() == 0) {
      return 1;
    }
    return 2;
  }
  
  public void n()
  {
    this.i.clear();
    notifyDataSetChanged();
  }
  
  void o()
  {
    if (this.i.size() <= 0) {
      return;
    }
    Iterator localIterator = this.i.iterator();
    while (localIterator.hasNext())
    {
      int j = O((String)localIterator.next());
      if ((j < this.c.size()) && (getItemViewType(j) == 2))
      {
        MemoryBean localMemoryBean = (MemoryBean)((q)this.c.get(j)).a();
        r.f().E(localMemoryBean);
      }
    }
    this.i.clear();
    notifyDataSetChanged();
  }
  
  public void onAttachedToRecyclerView(@NonNull RecyclerView paramRecyclerView)
  {
    ((GridLayoutManager)paramRecyclerView.getLayoutManager()).setSpanSizeLookup(new a());
  }
  
  public void onBindViewHolder(@NonNull RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    Object localObject;
    if ((paramViewHolder instanceof TitleViewHolder))
    {
      localObject = (String)((q)this.c.get(paramInt)).a();
      ((TitleViewHolder)paramViewHolder).mTitleTv.setText((CharSequence)localObject);
    }
    else if ((paramViewHolder instanceof e))
    {
      localObject = (MemoryBean)((q)this.c.get(paramInt)).a();
      e locale = (e)paramViewHolder;
      locale.itemView.setOnClickListener(new b(this, paramInt, locale, (MemoryBean)localObject));
      locale.itemView.setOnLongClickListener(new c(this, paramInt, locale, (MemoryBean)localObject));
      boolean bool = this.i.contains(String.valueOf(paramInt));
      locale.itemView.setSelected(bool);
      locale.d.setChecked(bool);
      paramViewHolder = locale.d;
      bool = this.h;
      int j = 0;
      if (bool) {
        paramInt = 0;
      } else {
        paramInt = 8;
      }
      paramViewHolder.setVisibility(paramInt);
      com.bumptech.glide.c.u(this.g).s(((MemoryBean)localObject).getThumbnailPath()).x0(locale.a);
      if (((MemoryBean)localObject).getVideoPath() == null)
      {
        locale.c.setVisibility(8);
      }
      else
      {
        locale.c.setVisibility(0);
        locale.c.setText(r(((MemoryBean)localObject).getVideoLength()));
      }
      paramViewHolder = locale.b;
      if (org.apache.commons.lang.b.b(Boolean.valueOf(((MemoryBean)localObject).isMark()))) {
        paramInt = j;
      } else {
        paramInt = 8;
      }
      paramViewHolder.setVisibility(paramInt);
    }
  }
  
  @NonNull
  public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    int j = 0;
    if (paramInt == 1)
    {
      paramViewGroup = new TitleViewHolder(LayoutInflater.from(this.g).inflate(2131559055, paramViewGroup, false));
    }
    else
    {
      View localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559065, paramViewGroup, false);
      paramInt = j;
      if (this.g.getResources().getConfiguration().orientation == 1) {
        paramInt = 1;
      }
      if (paramInt != 0) {
        paramInt = o.c(paramViewGroup.getContext());
      } else {
        paramInt = o.b(paramViewGroup.getContext());
      }
      paramInt = (paramInt - o.a(paramViewGroup.getContext(), 10.0F) * 2 - o.a(paramViewGroup.getContext(), 8.0F)) / 2;
      localView.getLayoutParams().height = (paramInt * 9 / 16);
      paramViewGroup = new e(localView);
    }
    return paramViewGroup;
  }
  
  void p(int paramInt)
  {
    F(paramInt);
    notifyDataSetChanged();
    d locald = this.e;
    if (locald != null) {
      locald.onDataChanged();
    }
  }
  
  void q()
  {
    if (this.i.size() <= 0)
    {
      localObject1 = this.f;
      if (localObject1 != null) {
        ((c)localObject1).R(new ArrayList());
      }
      return;
    }
    Object localObject1 = new ArrayList();
    Object localObject2 = this.i.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      int j = O((String)((Iterator)localObject2).next());
      if ((j < this.c.size()) && (getItemViewType(j) == 2)) {
        ((List)localObject1).add((MemoryBean)((q)this.c.get(j)).a());
      }
    }
    localObject2 = this.f;
    if (localObject2 != null) {
      ((c)localObject2).R((List)localObject1);
    }
    this.i.clear();
    notifyDataSetChanged();
  }
  
  boolean u()
  {
    boolean bool;
    if (this.i.size() > 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean v()
  {
    int j = this.i.size();
    boolean bool1 = false;
    if (j <= 0) {
      return false;
    }
    j = s();
    boolean bool2 = bool1;
    if (j > 0)
    {
      bool2 = bool1;
      if (this.i.size() == j) {
        bool2 = true;
      }
    }
    return bool2;
  }
  
  boolean w()
  {
    int j = this.i.size();
    boolean bool = false;
    if (j <= 0) {
      return false;
    }
    Iterator localIterator = this.i.iterator();
    while (localIterator.hasNext())
    {
      j = O((String)localIterator.next());
      if ((j < this.c.size()) && (getItemViewType(j) == 2) && (!((MemoryBean)((q)this.c.get(j)).a()).isMark())) {
        return bool;
      }
    }
    bool = true;
    return bool;
  }
  
  public boolean x()
  {
    return this.h;
  }
  
  public int y()
  {
    return this.i.size();
  }
  
  class TitleViewHolder
    extends RecyclerView.ViewHolder
  {
    @BindView
    TextView mTitleTv;
    
    public TitleViewHolder(View paramView)
    {
      super();
      ButterKnife.b(this, paramView);
    }
  }
  
  class a
    extends GridLayoutManager.SpanSizeLookup
  {
    a() {}
    
    public int getSpanSize(int paramInt)
    {
      if (((q)MemoriesAdapter.m(MemoriesAdapter.this).get(paramInt)).b() == 1) {
        return 1;
      }
      return 2;
    }
  }
  
  static abstract interface b
  {
    public abstract void Z(View paramView, int paramInt, MemoryBean paramMemoryBean);
    
    public abstract void s(View paramView, int paramInt, MemoryBean paramMemoryBean);
    
    public abstract void w0(int paramInt, MemoryBean paramMemoryBean);
  }
  
  static abstract interface c
  {
    public abstract void R(List<MemoryBean> paramList);
    
    public abstract void v(List<MemoryBean> paramList);
  }
  
  static abstract interface d
  {
    public abstract void onDataChanged();
  }
  
  class e
    extends RecyclerView.ViewHolder
  {
    ImageView a;
    ImageView b;
    TextView c;
    CheckBox d;
    
    public e(View paramView)
    {
      super();
      this.a = ((ImageView)paramView.findViewById(2131362939));
      this.b = ((ImageView)paramView.findViewById(2131362940));
      this.c = ((TextView)paramView.findViewById(2131362942));
      this.d = ((CheckBox)paramView.findViewById(2131362941));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\memories\MemoriesAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */