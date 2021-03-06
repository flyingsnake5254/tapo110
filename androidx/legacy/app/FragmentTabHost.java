package androidx.legacy.app;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.BaseSavedState;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabContentFactory;
import android.widget.TabHost.TabSpec;
import android.widget.TabWidget;
import java.util.ArrayList;

@Deprecated
public class FragmentTabHost
  extends TabHost
  implements TabHost.OnTabChangeListener
{
  private boolean mAttached;
  private int mContainerId;
  private Context mContext;
  private FragmentManager mFragmentManager;
  private TabInfo mLastTab;
  private TabHost.OnTabChangeListener mOnTabChangeListener;
  private FrameLayout mRealTabContent;
  private final ArrayList<TabInfo> mTabs = new ArrayList();
  
  @Deprecated
  public FragmentTabHost(Context paramContext)
  {
    super(paramContext, null);
    initFragmentTabHost(paramContext, null);
  }
  
  @Deprecated
  public FragmentTabHost(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initFragmentTabHost(paramContext, paramAttributeSet);
  }
  
  private FragmentTransaction doTabChanged(String paramString, FragmentTransaction paramFragmentTransaction)
  {
    Object localObject = null;
    for (int i = 0; i < this.mTabs.size(); i++)
    {
      TabInfo localTabInfo = (TabInfo)this.mTabs.get(i);
      if (localTabInfo.tag.equals(paramString)) {
        localObject = localTabInfo;
      }
    }
    if (localObject != null)
    {
      paramString = paramFragmentTransaction;
      if (this.mLastTab != localObject)
      {
        paramString = paramFragmentTransaction;
        if (paramFragmentTransaction == null) {
          paramString = this.mFragmentManager.beginTransaction();
        }
        paramFragmentTransaction = this.mLastTab;
        if (paramFragmentTransaction != null)
        {
          paramFragmentTransaction = paramFragmentTransaction.fragment;
          if (paramFragmentTransaction != null) {
            paramString.detach(paramFragmentTransaction);
          }
        }
        paramFragmentTransaction = ((TabInfo)localObject).fragment;
        if (paramFragmentTransaction == null)
        {
          paramFragmentTransaction = Fragment.instantiate(this.mContext, ((TabInfo)localObject).clss.getName(), ((TabInfo)localObject).args);
          ((TabInfo)localObject).fragment = paramFragmentTransaction;
          paramString.add(this.mContainerId, paramFragmentTransaction, ((TabInfo)localObject).tag);
        }
        else
        {
          paramString.attach(paramFragmentTransaction);
        }
        this.mLastTab = ((TabInfo)localObject);
      }
      return paramString;
    }
    paramFragmentTransaction = new StringBuilder();
    paramFragmentTransaction.append("No tab known for tag ");
    paramFragmentTransaction.append(paramString);
    throw new IllegalStateException(paramFragmentTransaction.toString());
  }
  
  private void ensureContent()
  {
    if (this.mRealTabContent == null)
    {
      Object localObject = (FrameLayout)findViewById(this.mContainerId);
      this.mRealTabContent = ((FrameLayout)localObject);
      if (localObject == null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("No tab content FrameLayout found for id ");
        ((StringBuilder)localObject).append(this.mContainerId);
        throw new IllegalStateException(((StringBuilder)localObject).toString());
      }
    }
  }
  
  private void ensureHierarchy(Context paramContext)
  {
    if (findViewById(16908307) == null)
    {
      LinearLayout localLinearLayout = new LinearLayout(paramContext);
      localLinearLayout.setOrientation(1);
      addView(localLinearLayout, new FrameLayout.LayoutParams(-1, -1));
      Object localObject = new TabWidget(paramContext);
      ((TabWidget)localObject).setId(16908307);
      ((TabWidget)localObject).setOrientation(0);
      localLinearLayout.addView((View)localObject, new LinearLayout.LayoutParams(-1, -2, 0.0F));
      localObject = new FrameLayout(paramContext);
      ((FrameLayout)localObject).setId(16908305);
      localLinearLayout.addView((View)localObject, new LinearLayout.LayoutParams(0, 0, 0.0F));
      paramContext = new FrameLayout(paramContext);
      this.mRealTabContent = paramContext;
      paramContext.setId(this.mContainerId);
      localLinearLayout.addView(paramContext, new LinearLayout.LayoutParams(-1, 0, 1.0F));
    }
  }
  
  private void initFragmentTabHost(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, new int[] { 16842995 }, 0, 0);
    this.mContainerId = paramContext.getResourceId(0, 0);
    paramContext.recycle();
    super.setOnTabChangedListener(this);
  }
  
  @Deprecated
  public void addTab(TabHost.TabSpec paramTabSpec, Class<?> paramClass, Bundle paramBundle)
  {
    paramTabSpec.setContent(new DummyTabFactory(this.mContext));
    String str = paramTabSpec.getTag();
    paramClass = new TabInfo(str, paramClass, paramBundle);
    if (this.mAttached)
    {
      paramBundle = this.mFragmentManager.findFragmentByTag(str);
      paramClass.fragment = paramBundle;
      if ((paramBundle != null) && (!paramBundle.isDetached()))
      {
        paramBundle = this.mFragmentManager.beginTransaction();
        paramBundle.detach(paramClass.fragment);
        paramBundle.commit();
      }
    }
    this.mTabs.add(paramClass);
    addTab(paramTabSpec);
  }
  
  @Deprecated
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    String str = getCurrentTabTag();
    Object localObject1 = null;
    int i = 0;
    while (i < this.mTabs.size())
    {
      TabInfo localTabInfo = (TabInfo)this.mTabs.get(i);
      Fragment localFragment = this.mFragmentManager.findFragmentByTag(localTabInfo.tag);
      localTabInfo.fragment = localFragment;
      Object localObject2 = localObject1;
      if (localFragment != null)
      {
        localObject2 = localObject1;
        if (!localFragment.isDetached()) {
          if (localTabInfo.tag.equals(str))
          {
            this.mLastTab = localTabInfo;
            localObject2 = localObject1;
          }
          else
          {
            localObject2 = localObject1;
            if (localObject1 == null) {
              localObject2 = this.mFragmentManager.beginTransaction();
            }
            ((FragmentTransaction)localObject2).detach(localTabInfo.fragment);
          }
        }
      }
      i++;
      localObject1 = localObject2;
    }
    this.mAttached = true;
    localObject1 = doTabChanged(str, (FragmentTransaction)localObject1);
    if (localObject1 != null)
    {
      ((FragmentTransaction)localObject1).commit();
      this.mFragmentManager.executePendingTransactions();
    }
  }
  
  @Deprecated
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.mAttached = false;
  }
  
  @Deprecated
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    setCurrentTabByTag(paramParcelable.curTab);
  }
  
  @Deprecated
  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    localSavedState.curTab = getCurrentTabTag();
    return localSavedState;
  }
  
  @Deprecated
  public void onTabChanged(String paramString)
  {
    if (this.mAttached)
    {
      localObject = doTabChanged(paramString, null);
      if (localObject != null) {
        ((FragmentTransaction)localObject).commit();
      }
    }
    Object localObject = this.mOnTabChangeListener;
    if (localObject != null) {
      ((TabHost.OnTabChangeListener)localObject).onTabChanged(paramString);
    }
  }
  
  @Deprecated
  public void setOnTabChangedListener(TabHost.OnTabChangeListener paramOnTabChangeListener)
  {
    this.mOnTabChangeListener = paramOnTabChangeListener;
  }
  
  @Deprecated
  public void setup()
  {
    throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
  }
  
  @Deprecated
  public void setup(Context paramContext, FragmentManager paramFragmentManager)
  {
    ensureHierarchy(paramContext);
    super.setup();
    this.mContext = paramContext;
    this.mFragmentManager = paramFragmentManager;
    ensureContent();
  }
  
  @Deprecated
  public void setup(Context paramContext, FragmentManager paramFragmentManager, int paramInt)
  {
    ensureHierarchy(paramContext);
    super.setup();
    this.mContext = paramContext;
    this.mFragmentManager = paramFragmentManager;
    this.mContainerId = paramInt;
    ensureContent();
    this.mRealTabContent.setId(paramInt);
    if (getId() == -1) {
      setId(16908306);
    }
  }
  
  static class DummyTabFactory
    implements TabHost.TabContentFactory
  {
    private final Context mContext;
    
    public DummyTabFactory(Context paramContext)
    {
      this.mContext = paramContext;
    }
    
    public View createTabContent(String paramString)
    {
      paramString = new View(this.mContext);
      paramString.setMinimumWidth(0);
      paramString.setMinimumHeight(0);
      return paramString;
    }
  }
  
  static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator()
    {
      public FragmentTabHost.SavedState createFromParcel(Parcel paramAnonymousParcel)
      {
        return new FragmentTabHost.SavedState(paramAnonymousParcel);
      }
      
      public FragmentTabHost.SavedState[] newArray(int paramAnonymousInt)
      {
        return new FragmentTabHost.SavedState[paramAnonymousInt];
      }
    };
    String curTab;
    
    SavedState(Parcel paramParcel)
    {
      super();
      this.curTab = paramParcel.readString();
    }
    
    SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("FragmentTabHost.SavedState{");
      localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
      localStringBuilder.append(" curTab=");
      localStringBuilder.append(this.curTab);
      localStringBuilder.append("}");
      return localStringBuilder.toString();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeString(this.curTab);
    }
  }
  
  static final class TabInfo
  {
    final Bundle args;
    final Class<?> clss;
    Fragment fragment;
    final String tag;
    
    TabInfo(String paramString, Class<?> paramClass, Bundle paramBundle)
    {
      this.tag = paramString;
      this.clss = paramClass;
      this.args = paramBundle;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\legacy\app\FragmentTabHost.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */