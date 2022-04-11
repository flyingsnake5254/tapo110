package androidx.databinding.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.annotation.RestrictTo;
import androidx.databinding.ObservableList;
import androidx.databinding.ObservableList.OnListChangedCallback;
import java.util.List;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
class ObservableListAdapter<T>
  extends BaseAdapter
{
  private final Context mContext;
  private final int mDropDownResourceId;
  private final LayoutInflater mLayoutInflater;
  private List<T> mList;
  private ObservableList.OnListChangedCallback mListChangedCallback;
  private final int mResourceId;
  private final int mTextViewResourceId;
  
  public ObservableListAdapter(Context paramContext, List<T> paramList, int paramInt1, int paramInt2, int paramInt3)
  {
    this.mContext = paramContext;
    this.mResourceId = paramInt1;
    this.mDropDownResourceId = paramInt2;
    this.mTextViewResourceId = paramInt3;
    if (paramInt1 == 0) {
      paramContext = null;
    } else {
      paramContext = (LayoutInflater)paramContext.getSystemService("layout_inflater");
    }
    this.mLayoutInflater = paramContext;
    setList(paramList);
  }
  
  public int getCount()
  {
    return this.mList.size();
  }
  
  public View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return getViewForResource(this.mDropDownResourceId, paramInt, paramView, paramViewGroup);
  }
  
  public Object getItem(int paramInt)
  {
    return this.mList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return getViewForResource(this.mResourceId, paramInt, paramView, paramViewGroup);
  }
  
  public View getViewForResource(int paramInt1, int paramInt2, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = paramView;
    if (paramView == null) {
      if (paramInt1 == 0) {
        localObject = new TextView(this.mContext);
      } else {
        localObject = this.mLayoutInflater.inflate(paramInt1, paramViewGroup, false);
      }
    }
    paramInt1 = this.mTextViewResourceId;
    if (paramInt1 == 0) {
      paramView = (View)localObject;
    } else {
      paramView = ((View)localObject).findViewById(paramInt1);
    }
    paramViewGroup = (TextView)paramView;
    paramView = this.mList.get(paramInt2);
    if ((paramView instanceof CharSequence)) {
      paramView = (CharSequence)paramView;
    } else {
      paramView = String.valueOf(paramView);
    }
    paramViewGroup.setText(paramView);
    return (View)localObject;
  }
  
  public void setList(List<T> paramList)
  {
    List localList = this.mList;
    if (localList == paramList) {
      return;
    }
    if ((localList instanceof ObservableList)) {
      ((ObservableList)localList).removeOnListChangedCallback(this.mListChangedCallback);
    }
    this.mList = paramList;
    if ((paramList instanceof ObservableList))
    {
      if (this.mListChangedCallback == null) {
        this.mListChangedCallback = new ObservableList.OnListChangedCallback()
        {
          public void onChanged(ObservableList paramAnonymousObservableList)
          {
            ObservableListAdapter.this.notifyDataSetChanged();
          }
          
          public void onItemRangeChanged(ObservableList paramAnonymousObservableList, int paramAnonymousInt1, int paramAnonymousInt2)
          {
            ObservableListAdapter.this.notifyDataSetChanged();
          }
          
          public void onItemRangeInserted(ObservableList paramAnonymousObservableList, int paramAnonymousInt1, int paramAnonymousInt2)
          {
            ObservableListAdapter.this.notifyDataSetChanged();
          }
          
          public void onItemRangeMoved(ObservableList paramAnonymousObservableList, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
          {
            ObservableListAdapter.this.notifyDataSetChanged();
          }
          
          public void onItemRangeRemoved(ObservableList paramAnonymousObservableList, int paramAnonymousInt1, int paramAnonymousInt2)
          {
            ObservableListAdapter.this.notifyDataSetChanged();
          }
        };
      }
      ((ObservableList)this.mList).addOnListChangedCallback(this.mListChangedCallback);
    }
    notifyDataSetChanged();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\databinding\adapters\ObservableListAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */