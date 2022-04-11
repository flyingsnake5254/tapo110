package com.tplink.iot.adapter.deviceshare;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filter.FilterResults;
import android.widget.Filterable;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.tplink.iot.Utils.d0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class a
  extends BaseAdapter
  implements Filterable
{
  private b c;
  private HashMap<String, RecordUserBean> d = f(paramList);
  private List<String> f = new ArrayList();
  private List<RecordUserBean> q = new ArrayList();
  private String x;
  private Context y;
  
  public a(Context paramContext, List<RecordUserBean> paramList, List<String> paramList1)
  {
    if (paramList1 != null) {
      this.f = new ArrayList(paramList1);
    }
    this.y = paramContext;
  }
  
  private String e(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    int i = paramString.indexOf("@");
    if (i == -1) {
      return paramString;
    }
    if (i == 0) {
      return "";
    }
    return paramString.substring(0, i);
  }
  
  private HashMap<String, RecordUserBean> f(List<RecordUserBean> paramList)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      paramList = (RecordUserBean)localIterator.next();
      String str = e(paramList.getCloudUserName());
      if (!TextUtils.isEmpty(str)) {
        localHashMap.put(str, paramList);
      }
    }
    return localHashMap;
  }
  
  public int getCount()
  {
    List localList = this.q;
    int i;
    if (localList == null) {
      i = 0;
    } else {
      i = localList.size();
    }
    return i;
  }
  
  public Filter getFilter()
  {
    if (this.c == null) {
      this.c = new b(null);
    }
    return this.c;
  }
  
  public Object getItem(int paramInt)
  {
    return this.q.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = new c();
      paramViewGroup = LayoutInflater.from(this.y).inflate(2131559132, null);
      paramView.a = ((TextView)paramViewGroup.findViewById(2131364177));
      paramViewGroup.setTag(paramView);
    }
    else
    {
      c localc = (c)paramView.getTag();
      paramViewGroup = paramView;
      paramView = localc;
    }
    if (TextUtils.isEmpty(this.x)) {
      paramView.a.setText(((RecordUserBean)this.q.get(paramInt)).getCloudUserName());
    } else {
      d0.a(paramView.a, ((RecordUserBean)this.q.get(paramInt)).getCloudUserName(), this.x, ContextCompat.getColor(this.y, 2131099808));
    }
    return paramViewGroup;
  }
  
  private class b
    extends Filter
  {
    private b() {}
    
    protected Filter.FilterResults performFiltering(CharSequence paramCharSequence)
    {
      Filter.FilterResults localFilterResults = new Filter.FilterResults();
      if ((paramCharSequence != null) && (paramCharSequence.length() != 0))
      {
        a.a(a.this, paramCharSequence.toString());
        String str = paramCharSequence.toString();
        paramCharSequence = new ArrayList();
        int i = str.indexOf("@");
        Object localObject1;
        Object localObject2;
        if (i != -1)
        {
          if (i != 0)
          {
            int j = a.b(a.this).size();
            for (int k = 0; k < j; k++)
            {
              localObject1 = (String)a.b(a.this).get(k);
              if (localObject1 != null)
              {
                localObject2 = str.substring(0, i);
                Object localObject3 = str.substring(i);
                if ((!((String)localObject1).equals(localObject3)) && (((String)localObject1).startsWith((String)localObject3)))
                {
                  localObject3 = new StringBuilder();
                  ((StringBuilder)localObject3).append((String)localObject2);
                  ((StringBuilder)localObject3).append((String)localObject1);
                  paramCharSequence.add(new RecordUserBean(((StringBuilder)localObject3).toString()));
                }
              }
            }
          }
        }
        else
        {
          localObject2 = a.c(a.this).entrySet().iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject1 = (Map.Entry)((Iterator)localObject2).next();
            if (((String)((Map.Entry)localObject1).getKey()).contains(str)) {
              paramCharSequence.add(((Map.Entry)localObject1).getValue());
            }
          }
        }
        localFilterResults.values = paramCharSequence;
        localFilterResults.count = paramCharSequence.size();
      }
      else
      {
        a.a(a.this, "");
        localFilterResults.values = new ArrayList();
        localFilterResults.count = 0;
      }
      return localFilterResults;
    }
    
    protected void publishResults(CharSequence paramCharSequence, Filter.FilterResults paramFilterResults)
    {
      a.d(a.this, (List)paramFilterResults.values);
      if (paramFilterResults.count > 0) {
        a.this.notifyDataSetChanged();
      } else {
        a.this.notifyDataSetInvalidated();
      }
    }
  }
  
  static class c
  {
    public TextView a;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\adapter\deviceshare\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */