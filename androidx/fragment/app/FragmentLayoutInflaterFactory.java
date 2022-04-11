package androidx.fragment.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater.Factory2;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.R.styleable;

class FragmentLayoutInflaterFactory
  implements LayoutInflater.Factory2
{
  private static final String TAG = "FragmentManager";
  private final FragmentManager mFragmentManager;
  
  FragmentLayoutInflaterFactory(FragmentManager paramFragmentManager)
  {
    this.mFragmentManager = paramFragmentManager;
  }
  
  @Nullable
  public View onCreateView(@Nullable View paramView, @NonNull String paramString, @NonNull Context paramContext, @NonNull AttributeSet paramAttributeSet)
  {
    if (FragmentContainerView.class.getName().equals(paramString)) {
      return new FragmentContainerView(paramContext, paramAttributeSet, this.mFragmentManager);
    }
    boolean bool = "fragment".equals(paramString);
    paramString = null;
    if (!bool) {
      return null;
    }
    String str1 = paramAttributeSet.getAttributeValue(null, "class");
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.Fragment);
    String str2 = str1;
    if (str1 == null) {
      str2 = localTypedArray.getString(R.styleable.Fragment_android_name);
    }
    int i = localTypedArray.getResourceId(R.styleable.Fragment_android_id, -1);
    str1 = localTypedArray.getString(R.styleable.Fragment_android_tag);
    localTypedArray.recycle();
    if ((str2 != null) && (FragmentFactory.isFragmentClass(paramContext.getClassLoader(), str2)))
    {
      int j;
      if (paramView != null) {
        j = paramView.getId();
      } else {
        j = 0;
      }
      if ((j == -1) && (i == -1) && (str1 == null))
      {
        paramView = new StringBuilder();
        paramView.append(paramAttributeSet.getPositionDescription());
        paramView.append(": Must specify unique android:id, android:tag, or have a parent with an id for ");
        paramView.append(str2);
        throw new IllegalArgumentException(paramView.toString());
      }
      paramView = paramString;
      if (i != -1) {
        paramView = this.mFragmentManager.findFragmentById(i);
      }
      paramString = paramView;
      if (paramView == null)
      {
        paramString = paramView;
        if (str1 != null) {
          paramString = this.mFragmentManager.findFragmentByTag(str1);
        }
      }
      paramView = paramString;
      if (paramString == null)
      {
        paramView = paramString;
        if (j != -1) {
          paramView = this.mFragmentManager.findFragmentById(j);
        }
      }
      if (FragmentManager.isLoggingEnabled(2))
      {
        paramString = new StringBuilder();
        paramString.append("onCreateView: id=0x");
        paramString.append(Integer.toHexString(i));
        paramString.append(" fname=");
        paramString.append(str2);
        paramString.append(" existing=");
        paramString.append(paramView);
        Log.v("FragmentManager", paramString.toString());
      }
      if (paramView == null)
      {
        paramView = this.mFragmentManager.getFragmentFactory().instantiate(paramContext.getClassLoader(), str2);
        paramView.mFromLayout = true;
        int k;
        if (i != 0) {
          k = i;
        } else {
          k = j;
        }
        paramView.mFragmentId = k;
        paramView.mContainerId = j;
        paramView.mTag = str1;
        paramView.mInLayout = true;
        paramString = this.mFragmentManager;
        paramView.mFragmentManager = paramString;
        paramString = paramString.mHost;
        paramView.mHost = paramString;
        paramView.onInflate(paramString.getContext(), paramAttributeSet, paramView.mSavedFragmentState);
        this.mFragmentManager.addFragment(paramView);
        this.mFragmentManager.moveToState(paramView);
      }
      else
      {
        if (paramView.mInLayout) {
          break label624;
        }
        paramView.mInLayout = true;
        paramString = this.mFragmentManager.mHost;
        paramView.mHost = paramString;
        paramView.onInflate(paramString.getContext(), paramAttributeSet, paramView.mSavedFragmentState);
      }
      paramString = this.mFragmentManager;
      if ((paramString.mCurState < 1) && (paramView.mFromLayout)) {
        paramString.moveToState(paramView, 1);
      } else {
        paramString.moveToState(paramView);
      }
      paramString = paramView.mView;
      if (paramString != null)
      {
        if (i != 0) {
          paramString.setId(i);
        }
        if (paramView.mView.getTag() == null) {
          paramView.mView.setTag(str1);
        }
        return paramView.mView;
      }
      paramView = new StringBuilder();
      paramView.append("Fragment ");
      paramView.append(str2);
      paramView.append(" did not create a view.");
      throw new IllegalStateException(paramView.toString());
      label624:
      paramView = new StringBuilder();
      paramView.append(paramAttributeSet.getPositionDescription());
      paramView.append(": Duplicate id 0x");
      paramView.append(Integer.toHexString(i));
      paramView.append(", tag ");
      paramView.append(str1);
      paramView.append(", or parent id 0x");
      paramView.append(Integer.toHexString(j));
      paramView.append(" with another fragment for ");
      paramView.append(str2);
      throw new IllegalArgumentException(paramView.toString());
    }
    return null;
  }
  
  @Nullable
  public View onCreateView(@NonNull String paramString, @NonNull Context paramContext, @NonNull AttributeSet paramAttributeSet)
  {
    return onCreateView(null, paramString, paramContext, paramAttributeSet);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\fragment\app\FragmentLayoutInflaterFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */