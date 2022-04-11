package androidx.databinding.adapters;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;
import android.widget.SearchView.OnSuggestionListener;
import androidx.annotation.RestrictTo;
import androidx.databinding.BindingAdapter;
import androidx.databinding.BindingMethods;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
@BindingMethods({@androidx.databinding.BindingMethod(attribute="android:onQueryTextFocusChange", method="setOnQueryTextFocusChangeListener", type=SearchView.class), @androidx.databinding.BindingMethod(attribute="android:onSearchClick", method="setOnSearchClickListener", type=SearchView.class), @androidx.databinding.BindingMethod(attribute="android:onClose", method="setOnCloseListener", type=SearchView.class)})
public class SearchViewBindingAdapter
{
  @BindingAdapter(requireAll=false, value={"android:onQueryTextSubmit", "android:onQueryTextChange"})
  public static void setOnQueryTextListener(SearchView paramSearchView, OnQueryTextSubmit paramOnQueryTextSubmit, final OnQueryTextChange paramOnQueryTextChange)
  {
    if (Build.VERSION.SDK_INT >= 11) {
      if ((paramOnQueryTextSubmit == null) && (paramOnQueryTextChange == null)) {
        paramSearchView.setOnQueryTextListener(null);
      } else {
        paramSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener()
        {
          public boolean onQueryTextChange(String paramAnonymousString)
          {
            SearchViewBindingAdapter.OnQueryTextChange localOnQueryTextChange = paramOnQueryTextChange;
            if (localOnQueryTextChange != null) {
              return localOnQueryTextChange.onQueryTextChange(paramAnonymousString);
            }
            return false;
          }
          
          public boolean onQueryTextSubmit(String paramAnonymousString)
          {
            SearchViewBindingAdapter.OnQueryTextSubmit localOnQueryTextSubmit = this.val$submit;
            if (localOnQueryTextSubmit != null) {
              return localOnQueryTextSubmit.onQueryTextSubmit(paramAnonymousString);
            }
            return false;
          }
        });
      }
    }
  }
  
  @BindingAdapter(requireAll=false, value={"android:onSuggestionSelect", "android:onSuggestionClick"})
  public static void setOnSuggestListener(SearchView paramSearchView, OnSuggestionSelect paramOnSuggestionSelect, final OnSuggestionClick paramOnSuggestionClick)
  {
    if (Build.VERSION.SDK_INT >= 11) {
      if ((paramOnSuggestionSelect == null) && (paramOnSuggestionClick == null)) {
        paramSearchView.setOnSuggestionListener(null);
      } else {
        paramSearchView.setOnSuggestionListener(new SearchView.OnSuggestionListener()
        {
          public boolean onSuggestionClick(int paramAnonymousInt)
          {
            SearchViewBindingAdapter.OnSuggestionClick localOnSuggestionClick = paramOnSuggestionClick;
            if (localOnSuggestionClick != null) {
              return localOnSuggestionClick.onSuggestionClick(paramAnonymousInt);
            }
            return false;
          }
          
          public boolean onSuggestionSelect(int paramAnonymousInt)
          {
            SearchViewBindingAdapter.OnSuggestionSelect localOnSuggestionSelect = this.val$submit;
            if (localOnSuggestionSelect != null) {
              return localOnSuggestionSelect.onSuggestionSelect(paramAnonymousInt);
            }
            return false;
          }
        });
      }
    }
  }
  
  @TargetApi(11)
  public static abstract interface OnQueryTextChange
  {
    public abstract boolean onQueryTextChange(String paramString);
  }
  
  @TargetApi(11)
  public static abstract interface OnQueryTextSubmit
  {
    public abstract boolean onQueryTextSubmit(String paramString);
  }
  
  @TargetApi(11)
  public static abstract interface OnSuggestionClick
  {
    public abstract boolean onSuggestionClick(int paramInt);
  }
  
  @TargetApi(11)
  public static abstract interface OnSuggestionSelect
  {
    public abstract boolean onSuggestionSelect(int paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\databinding\adapters\SearchViewBindingAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */