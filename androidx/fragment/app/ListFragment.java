package androidx.fragment.app;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ListFragment
  extends Fragment
{
  static final int INTERNAL_EMPTY_ID = 16711681;
  static final int INTERNAL_LIST_CONTAINER_ID = 16711683;
  static final int INTERNAL_PROGRESS_CONTAINER_ID = 16711682;
  ListAdapter mAdapter;
  CharSequence mEmptyText;
  View mEmptyView;
  private final Handler mHandler = new Handler();
  ListView mList;
  View mListContainer;
  boolean mListShown;
  private final AdapterView.OnItemClickListener mOnClickListener = new AdapterView.OnItemClickListener()
  {
    public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
    {
      ListFragment.this.onListItemClick((ListView)paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
    }
  };
  View mProgressContainer;
  private final Runnable mRequestFocus = new Runnable()
  {
    public void run()
    {
      ListView localListView = ListFragment.this.mList;
      localListView.focusableViewAvailable(localListView);
    }
  };
  TextView mStandardEmptyView;
  
  private void ensureList()
  {
    if (this.mList != null) {
      return;
    }
    View localView = getView();
    if (localView != null)
    {
      if ((localView instanceof ListView))
      {
        this.mList = ((ListView)localView);
      }
      else
      {
        localObject = (TextView)localView.findViewById(16711681);
        this.mStandardEmptyView = ((TextView)localObject);
        if (localObject == null) {
          this.mEmptyView = localView.findViewById(16908292);
        } else {
          ((TextView)localObject).setVisibility(8);
        }
        this.mProgressContainer = localView.findViewById(16711682);
        this.mListContainer = localView.findViewById(16711683);
        localObject = localView.findViewById(16908298);
        if (!(localObject instanceof ListView))
        {
          if (localObject == null) {
            throw new RuntimeException("Your content must have a ListView whose id attribute is 'android.R.id.list'");
          }
          throw new RuntimeException("Content has view with id attribute 'android.R.id.list' that is not a ListView class");
        }
        localObject = (ListView)localObject;
        this.mList = ((ListView)localObject);
        localView = this.mEmptyView;
        if (localView != null)
        {
          ((ListView)localObject).setEmptyView(localView);
        }
        else
        {
          localObject = this.mEmptyText;
          if (localObject != null)
          {
            this.mStandardEmptyView.setText((CharSequence)localObject);
            this.mList.setEmptyView(this.mStandardEmptyView);
          }
        }
      }
      this.mListShown = true;
      this.mList.setOnItemClickListener(this.mOnClickListener);
      Object localObject = this.mAdapter;
      if (localObject != null)
      {
        this.mAdapter = null;
        setListAdapter((ListAdapter)localObject);
      }
      else if (this.mProgressContainer != null)
      {
        setListShown(false, false);
      }
      this.mHandler.post(this.mRequestFocus);
      return;
    }
    throw new IllegalStateException("Content view not yet created");
  }
  
  private void setListShown(boolean paramBoolean1, boolean paramBoolean2)
  {
    ensureList();
    View localView = this.mProgressContainer;
    if (localView != null)
    {
      if (this.mListShown == paramBoolean1) {
        return;
      }
      this.mListShown = paramBoolean1;
      if (paramBoolean1)
      {
        if (paramBoolean2)
        {
          localView.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432577));
          this.mListContainer.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432576));
        }
        else
        {
          localView.clearAnimation();
          this.mListContainer.clearAnimation();
        }
        this.mProgressContainer.setVisibility(8);
        this.mListContainer.setVisibility(0);
      }
      else
      {
        if (paramBoolean2)
        {
          localView.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432576));
          this.mListContainer.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432577));
        }
        else
        {
          localView.clearAnimation();
          this.mListContainer.clearAnimation();
        }
        this.mProgressContainer.setVisibility(0);
        this.mListContainer.setVisibility(8);
      }
      return;
    }
    throw new IllegalStateException("Can't be used with a custom content view");
  }
  
  @Nullable
  public ListAdapter getListAdapter()
  {
    return this.mAdapter;
  }
  
  @NonNull
  public ListView getListView()
  {
    ensureList();
    return this.mList;
  }
  
  public long getSelectedItemId()
  {
    ensureList();
    return this.mList.getSelectedItemId();
  }
  
  public int getSelectedItemPosition()
  {
    ensureList();
    return this.mList.getSelectedItemPosition();
  }
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    paramBundle = requireContext();
    paramLayoutInflater = new FrameLayout(paramBundle);
    paramViewGroup = new LinearLayout(paramBundle);
    paramViewGroup.setId(16711682);
    paramViewGroup.setOrientation(1);
    paramViewGroup.setVisibility(8);
    paramViewGroup.setGravity(17);
    paramViewGroup.addView(new ProgressBar(paramBundle, null, 16842874), new FrameLayout.LayoutParams(-2, -2));
    paramLayoutInflater.addView(paramViewGroup, new FrameLayout.LayoutParams(-1, -1));
    paramViewGroup = new FrameLayout(paramBundle);
    paramViewGroup.setId(16711683);
    TextView localTextView = new TextView(paramBundle);
    localTextView.setId(16711681);
    localTextView.setGravity(17);
    paramViewGroup.addView(localTextView, new FrameLayout.LayoutParams(-1, -1));
    paramBundle = new ListView(paramBundle);
    paramBundle.setId(16908298);
    paramBundle.setDrawSelectorOnTop(false);
    paramViewGroup.addView(paramBundle, new FrameLayout.LayoutParams(-1, -1));
    paramLayoutInflater.addView(paramViewGroup, new FrameLayout.LayoutParams(-1, -1));
    paramLayoutInflater.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    this.mHandler.removeCallbacks(this.mRequestFocus);
    this.mList = null;
    this.mListShown = false;
    this.mListContainer = null;
    this.mProgressContainer = null;
    this.mEmptyView = null;
    this.mStandardEmptyView = null;
    super.onDestroyView();
  }
  
  public void onListItemClick(@NonNull ListView paramListView, @NonNull View paramView, int paramInt, long paramLong) {}
  
  public void onViewCreated(@NonNull View paramView, @Nullable Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    ensureList();
  }
  
  @NonNull
  public final ListAdapter requireListAdapter()
  {
    Object localObject = getListAdapter();
    if (localObject != null) {
      return (ListAdapter)localObject;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("ListFragment ");
    ((StringBuilder)localObject).append(this);
    ((StringBuilder)localObject).append(" does not have a ListAdapter.");
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  public void setEmptyText(@Nullable CharSequence paramCharSequence)
  {
    ensureList();
    TextView localTextView = this.mStandardEmptyView;
    if (localTextView != null)
    {
      localTextView.setText(paramCharSequence);
      if (this.mEmptyText == null) {
        this.mList.setEmptyView(this.mStandardEmptyView);
      }
      this.mEmptyText = paramCharSequence;
      return;
    }
    throw new IllegalStateException("Can't be used with a custom content view");
  }
  
  public void setListAdapter(@Nullable ListAdapter paramListAdapter)
  {
    Object localObject = this.mAdapter;
    boolean bool = false;
    int i;
    if (localObject != null) {
      i = 1;
    } else {
      i = 0;
    }
    this.mAdapter = paramListAdapter;
    localObject = this.mList;
    if (localObject != null)
    {
      ((ListView)localObject).setAdapter(paramListAdapter);
      if ((!this.mListShown) && (i == 0))
      {
        if (requireView().getWindowToken() != null) {
          bool = true;
        }
        setListShown(true, bool);
      }
    }
  }
  
  public void setListShown(boolean paramBoolean)
  {
    setListShown(paramBoolean, true);
  }
  
  public void setListShownNoAnimation(boolean paramBoolean)
  {
    setListShown(paramBoolean, false);
  }
  
  public void setSelection(int paramInt)
  {
    ensureList();
    this.mList.setSelection(paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\fragment\app\ListFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */