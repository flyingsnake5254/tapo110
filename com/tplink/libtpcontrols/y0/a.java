package com.tplink.libtpcontrols.y0;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filter.FilterResults;
import android.widget.Filterable;
import android.widget.TextView;
import com.tplink.libtpcontrols.s0;
import com.tplink.libtpcontrols.t0;
import java.util.ArrayList;
import java.util.List;

public class a
  extends BaseAdapter
  implements Filterable
{
  private b c;
  private List<String> d;
  private Context f;
  private ArrayList<String> q;
  
  public a(Context paramContext, List<String> paramList)
  {
    this.d = paramList;
    this.f = paramContext;
  }
  
  public int getCount()
  {
    List localList = this.d;
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
    return this.d.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramViewGroup = new c();
      paramView = LayoutInflater.from(this.f).inflate(t0.auto_complete_email_adapter, null);
      paramViewGroup.a = ((TextView)paramView.findViewById(s0.text1));
      paramView.setTag(paramViewGroup);
    }
    else
    {
      paramViewGroup = (c)paramView.getTag();
    }
    paramViewGroup.a.setText((CharSequence)this.d.get(paramInt));
    return paramView;
  }
  
  private class b
    extends Filter
  {
    private b() {}
    
    protected Filter.FilterResults performFiltering(CharSequence paramCharSequence)
    {
      Filter.FilterResults localFilterResults = new Filter.FilterResults();
      if (a.a(a.this) == null) {
        a.b(a.this, new ArrayList(a.c(a.this)));
      }
      if ((paramCharSequence != null) && (paramCharSequence.length() != 0))
      {
        paramCharSequence = paramCharSequence.toString();
        ArrayList localArrayList1 = a.a(a.this);
        int i = localArrayList1.size();
        ArrayList localArrayList2 = new ArrayList(i);
        int j = paramCharSequence.indexOf("@");
        if (j != 0) {
          for (int k = 0; k < i; k++)
          {
            String str = (String)localArrayList1.get(k);
            if (str != null)
            {
              Object localObject1;
              if (j == -1)
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append(paramCharSequence);
                ((StringBuilder)localObject1).append(str);
                localArrayList2.add(((StringBuilder)localObject1).toString());
              }
              else
              {
                localObject1 = paramCharSequence.substring(0, j);
                Object localObject2 = paramCharSequence.substring(j);
                if ((!str.equals(localObject2)) && (str.startsWith((String)localObject2)))
                {
                  localObject2 = new StringBuilder();
                  ((StringBuilder)localObject2).append((String)localObject1);
                  ((StringBuilder)localObject2).append(str);
                  localArrayList2.add(((StringBuilder)localObject2).toString());
                }
              }
            }
          }
        }
        localFilterResults.values = localArrayList2;
        localFilterResults.count = localArrayList2.size();
      }
      else
      {
        paramCharSequence = a.a(a.this);
        localFilterResults.values = paramCharSequence;
        localFilterResults.count = paramCharSequence.size();
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\y0\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */