package androidx.databinding.adapters;

import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import androidx.annotation.RestrictTo;
import androidx.databinding.BindingAdapter;
import androidx.databinding.BindingMethods;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.InverseBindingMethods;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
@BindingMethods({@androidx.databinding.BindingMethod(attribute="android:onItemClick", method="setOnItemClickListener", type=AdapterView.class), @androidx.databinding.BindingMethod(attribute="android:onItemLongClick", method="setOnItemLongClickListener", type=AdapterView.class)})
@InverseBindingMethods({@androidx.databinding.InverseBindingMethod(attribute="android:selectedItemPosition", type=AdapterView.class), @androidx.databinding.InverseBindingMethod(attribute="android:selection", event="android:selectedItemPositionAttrChanged", method="getSelectedItemPosition", type=AdapterView.class)})
public class AdapterViewBindingAdapter
{
  @BindingAdapter(requireAll=false, value={"android:onItemSelected", "android:onNothingSelected", "android:selectedItemPositionAttrChanged"})
  public static void setOnItemSelectedListener(AdapterView paramAdapterView, OnItemSelected paramOnItemSelected, OnNothingSelected paramOnNothingSelected, InverseBindingListener paramInverseBindingListener)
  {
    if ((paramOnItemSelected == null) && (paramOnNothingSelected == null) && (paramInverseBindingListener == null)) {
      paramAdapterView.setOnItemSelectedListener(null);
    } else {
      paramAdapterView.setOnItemSelectedListener(new OnItemSelectedComponentListener(paramOnItemSelected, paramOnNothingSelected, paramInverseBindingListener));
    }
  }
  
  @BindingAdapter({"android:selectedItemPosition"})
  public static void setSelectedItemPosition(AdapterView paramAdapterView, int paramInt)
  {
    if (paramAdapterView.getSelectedItemPosition() != paramInt) {
      paramAdapterView.setSelection(paramInt);
    }
  }
  
  @BindingAdapter({"android:selectedItemPosition", "android:adapter"})
  public static void setSelectedItemPosition(AdapterView paramAdapterView, int paramInt, Adapter paramAdapter)
  {
    if (paramAdapter != paramAdapterView.getAdapter())
    {
      paramAdapterView.setAdapter(paramAdapter);
      paramAdapterView.setSelection(paramInt);
    }
    else if (paramAdapterView.getSelectedItemPosition() != paramInt)
    {
      paramAdapterView.setSelection(paramInt);
    }
  }
  
  @BindingAdapter({"android:selection"})
  public static void setSelection(AdapterView paramAdapterView, int paramInt)
  {
    setSelectedItemPosition(paramAdapterView, paramInt);
  }
  
  @BindingAdapter({"android:selection", "android:adapter"})
  public static void setSelection(AdapterView paramAdapterView, int paramInt, Adapter paramAdapter)
  {
    setSelectedItemPosition(paramAdapterView, paramInt, paramAdapter);
  }
  
  public static abstract interface OnItemSelected
  {
    public abstract void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong);
  }
  
  public static class OnItemSelectedComponentListener
    implements AdapterView.OnItemSelectedListener
  {
    private final InverseBindingListener mAttrChanged;
    private final AdapterViewBindingAdapter.OnNothingSelected mNothingSelected;
    private final AdapterViewBindingAdapter.OnItemSelected mSelected;
    
    public OnItemSelectedComponentListener(AdapterViewBindingAdapter.OnItemSelected paramOnItemSelected, AdapterViewBindingAdapter.OnNothingSelected paramOnNothingSelected, InverseBindingListener paramInverseBindingListener)
    {
      this.mSelected = paramOnItemSelected;
      this.mNothingSelected = paramOnNothingSelected;
      this.mAttrChanged = paramInverseBindingListener;
    }
    
    public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
    {
      AdapterViewBindingAdapter.OnItemSelected localOnItemSelected = this.mSelected;
      if (localOnItemSelected != null) {
        localOnItemSelected.onItemSelected(paramAdapterView, paramView, paramInt, paramLong);
      }
      paramAdapterView = this.mAttrChanged;
      if (paramAdapterView != null) {
        paramAdapterView.onChange();
      }
    }
    
    public void onNothingSelected(AdapterView<?> paramAdapterView)
    {
      AdapterViewBindingAdapter.OnNothingSelected localOnNothingSelected = this.mNothingSelected;
      if (localOnNothingSelected != null) {
        localOnNothingSelected.onNothingSelected(paramAdapterView);
      }
      paramAdapterView = this.mAttrChanged;
      if (paramAdapterView != null) {
        paramAdapterView.onChange();
      }
    }
  }
  
  public static abstract interface OnNothingSelected
  {
    public abstract void onNothingSelected(AdapterView<?> paramAdapterView);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\databinding\adapters\AdapterViewBindingAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */