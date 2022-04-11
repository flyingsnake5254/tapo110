package com.tplink.iot.adapter.smart;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.Utils.o0;
import com.tplink.iot.cloud.bean.smart.common.SmartLog;
import com.tplink.iot.cloud.bean.smart.common.SmartLogAction;
import com.tplink.iot.cloud.bean.smart.common.SmartThingAction;
import com.tplink.iot.view.smart.a.c.a;
import com.tplink.iot.viewmodel.smart.SmartActionViewModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class q
  extends BaseExpandableListAdapter
{
  private FragmentActivity a;
  private SmartActionViewModel b;
  private List<b> c = new ArrayList();
  private List<List<SmartLog>> d = new ArrayList();
  
  public q(FragmentActivity paramFragmentActivity)
  {
    this.a = paramFragmentActivity;
    this.b = ((SmartActionViewModel)ViewModelProviders.of(paramFragmentActivity).get(SmartActionViewModel.class));
  }
  
  private String f(SmartLog paramSmartLog)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramSmartLog.getTriggerId());
    localStringBuilder.append(paramSmartLog.getTriggerCount());
    return localStringBuilder.toString();
  }
  
  private String g(SmartLog paramSmartLog)
  {
    return o0.a(this.a, o0.l(Long.parseLong(paramSmartLog.getTimestamp())));
  }
  
  public SmartLog d(int paramInt1, int paramInt2)
  {
    return (SmartLog)((List)this.d.get(paramInt1)).get(paramInt2);
  }
  
  public b e(int paramInt)
  {
    return (b)this.c.get(paramInt);
  }
  
  public long getChildId(int paramInt1, int paramInt2)
  {
    return paramInt2;
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559085, paramViewGroup, false);
      paramView = new c(paramViewGroup);
      paramViewGroup.setTag(paramView);
    }
    else
    {
      c localc = (c)paramView.getTag();
      paramViewGroup = paramView;
      paramView = localc;
    }
    paramView.a((SmartLog)((List)this.d.get(paramInt1)).get(paramInt2));
    return paramViewGroup;
  }
  
  public int getChildrenCount(int paramInt)
  {
    return ((List)this.d.get(paramInt)).size();
  }
  
  public int getGroupCount()
  {
    return this.c.size();
  }
  
  public long getGroupId(int paramInt)
  {
    return paramInt;
  }
  
  public View getGroupView(int paramInt, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559084, paramViewGroup, false);
      paramViewGroup = new a(paramView);
      paramView.setTag(paramViewGroup);
    }
    else
    {
      paramViewGroup = (a)paramView.getTag();
    }
    paramViewGroup.a((b)this.c.get(paramInt));
    return paramView;
  }
  
  public void h(List<SmartLog> paramList)
  {
    this.c.clear();
    this.d = new ArrayList();
    if (paramList == null)
    {
      notifyDataSetChanged();
      return;
    }
    LinkedHashMap localLinkedHashMap = new LinkedHashMap(16);
    paramList = paramList.iterator();
    Object localObject2;
    while (paramList.hasNext())
    {
      localObject1 = (SmartLog)paramList.next();
      localObject2 = f((SmartLog)localObject1);
      if (localLinkedHashMap.get(localObject2) == null) {
        localLinkedHashMap.put(localObject2, new ArrayList());
      }
      localObject2 = localLinkedHashMap.get(localObject2);
      Objects.requireNonNull(localObject2);
      ((List)localObject2).add(localObject1);
    }
    Iterator localIterator = localLinkedHashMap.keySet().iterator();
    for (Object localObject1 = ""; localIterator.hasNext(); localObject1 = paramList)
    {
      label146:
      List localList = (List)localLinkedHashMap.get((String)localIterator.next());
      if ((localList == null) || (localList.isEmpty())) {
        break label146;
      }
      localObject2 = o0.h(Long.parseLong(((SmartLog)localList.get(0)).getTimestamp()));
      paramList = (List<SmartLog>)localObject1;
      if (!((String)localObject1).equals(localObject2))
      {
        this.c.add(new b((String)localObject2));
        this.d.add(new ArrayList());
        paramList = (List<SmartLog>)localObject2;
      }
      boolean bool1 = true;
      localObject1 = localList.iterator();
      do
      {
        bool2 = bool1;
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
      } while (((SmartLog)((Iterator)localObject1).next()).getCode() == 0);
      boolean bool2 = false;
      this.c.add(new b((SmartLog)localList.get(0), bool2));
      this.d.add(localList);
    }
    notifyDataSetChanged();
  }
  
  public boolean hasStableIds()
  {
    return true;
  }
  
  public boolean isChildSelectable(int paramInt1, int paramInt2)
  {
    return false;
  }
  
  private class a
  {
    private RelativeLayout a;
    private TextView b;
    private ImageView c;
    private TextView d;
    private TextView e;
    
    a(View paramView)
    {
      this.a = ((RelativeLayout)paramView.findViewById(2131363889));
      this.b = ((TextView)paramView.findViewById(2131364329));
      this.c = ((ImageView)paramView.findViewById(2131362994));
      this.d = ((TextView)paramView.findViewById(2131364638));
      this.e = ((TextView)paramView.findViewById(2131364637));
    }
    
    public void a(q.b paramb)
    {
      int i = paramb.a();
      boolean bool = true;
      int j = 0;
      if (i != 1) {
        bool = false;
      }
      Object localObject = this.a;
      if (bool) {
        i = 0;
      } else {
        i = 8;
      }
      ((RelativeLayout)localObject).setVisibility(i);
      localObject = this.e;
      if (bool) {
        i = 8;
      } else {
        i = 0;
      }
      ((TextView)localObject).setVisibility(i);
      b(bool);
      if (bool)
      {
        localObject = paramb.b();
        this.b.setText(q.a(q.this, (SmartLog)localObject));
        this.d.setText(q.b(q.this).G(((SmartLog)localObject).getSmartName(), ((SmartLog)localObject).getSmartId()));
        localObject = this.c;
        i = j;
        if (paramb.d()) {
          i = 8;
        }
        ((ImageView)localObject).setVisibility(i);
      }
      else
      {
        this.e.setText(paramb.c());
      }
    }
    
    void b(boolean paramBoolean)
    {
      Drawable localDrawable;
      if (paramBoolean) {
        localDrawable = q.c(q.this).getResources().getDrawable(2131689486);
      } else {
        localDrawable = null;
      }
      this.d.setCompoundDrawablesWithIntrinsicBounds(null, null, localDrawable, null);
    }
  }
  
  public class b
  {
    private String a;
    private SmartLog b;
    private int c;
    private boolean d;
    
    b(SmartLog paramSmartLog, boolean paramBoolean)
    {
      this.b = paramSmartLog;
      this.d = paramBoolean;
      this.c = 1;
    }
    
    b(String paramString)
    {
      this.a = paramString;
      this.c = 0;
    }
    
    int a()
    {
      return this.c;
    }
    
    SmartLog b()
    {
      return this.b;
    }
    
    String c()
    {
      return this.a;
    }
    
    public boolean d()
    {
      return this.d;
    }
  }
  
  private class c
  {
    private ImageView a;
    private TextView b;
    
    c(View paramView)
    {
      this.a = ((ImageView)paramView.findViewById(2131362994));
      this.b = ((TextView)paramView.findViewById(2131364518));
    }
    
    private String b(@NonNull SmartThingAction paramSmartThingAction)
    {
      c.a locala = new c.a().g(true).e(true);
      return q.b(q.this).L(paramSmartThingAction, locala);
    }
    
    public void a(SmartLog paramSmartLog)
    {
      if (paramSmartLog.getActionSetting() != null)
      {
        TextView localTextView = this.b;
        if (paramSmartLog.getActionSetting().getThing() != null) {
          localObject = b(paramSmartLog.getActionSetting().getThing());
        } else {
          localObject = q.b(q.this).E(paramSmartLog.getActionSetting().getSmart());
        }
        localTextView.setText((CharSequence)localObject);
      }
      else
      {
        this.b.setText("");
      }
      Object localObject = this.a;
      int i;
      if (paramSmartLog.getCode() == 0) {
        i = 4;
      } else {
        i = 0;
      }
      ((ImageView)localObject).setVisibility(i);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\adapter\smart\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */