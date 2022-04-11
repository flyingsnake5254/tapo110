package androidx.databinding.adapters;

import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import androidx.annotation.RestrictTo;
import androidx.databinding.BindingAdapter;
import androidx.databinding.InverseBindingAdapter;
import androidx.databinding.InverseBindingListener;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
public class TabHostBindingAdapter
{
  @InverseBindingAdapter(attribute="android:currentTab")
  public static int getCurrentTab(TabHost paramTabHost)
  {
    return paramTabHost.getCurrentTab();
  }
  
  @InverseBindingAdapter(attribute="android:currentTab")
  public static String getCurrentTabTag(TabHost paramTabHost)
  {
    return paramTabHost.getCurrentTabTag();
  }
  
  @BindingAdapter({"android:currentTab"})
  public static void setCurrentTab(TabHost paramTabHost, int paramInt)
  {
    if (paramTabHost.getCurrentTab() != paramInt) {
      paramTabHost.setCurrentTab(paramInt);
    }
  }
  
  @BindingAdapter({"android:currentTab"})
  public static void setCurrentTabTag(TabHost paramTabHost, String paramString)
  {
    String str = paramTabHost.getCurrentTabTag();
    if (((str != null) && (!str.equals(paramString))) || ((str == null) && (paramString != null))) {
      paramTabHost.setCurrentTabByTag(paramString);
    }
  }
  
  @BindingAdapter(requireAll=false, value={"android:onTabChanged", "android:currentTabAttrChanged"})
  public static void setListeners(TabHost paramTabHost, TabHost.OnTabChangeListener paramOnTabChangeListener, final InverseBindingListener paramInverseBindingListener)
  {
    if (paramInverseBindingListener == null) {
      paramTabHost.setOnTabChangedListener(paramOnTabChangeListener);
    } else {
      paramTabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener()
      {
        public void onTabChanged(String paramAnonymousString)
        {
          TabHost.OnTabChangeListener localOnTabChangeListener = this.val$listener;
          if (localOnTabChangeListener != null) {
            localOnTabChangeListener.onTabChanged(paramAnonymousString);
          }
          paramInverseBindingListener.onChange();
        }
      });
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\databinding\adapters\TabHostBindingAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */