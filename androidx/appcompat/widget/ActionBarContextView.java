package androidx.appcompat.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R.attr;
import androidx.appcompat.R.id;
import androidx.appcompat.R.layout;
import androidx.appcompat.R.styleable;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.core.view.ViewCompat;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ActionBarContextView
  extends AbsActionBarView
{
  private View mClose;
  private int mCloseItemLayout;
  private View mCustomView;
  private CharSequence mSubtitle;
  private int mSubtitleStyleRes;
  private TextView mSubtitleView;
  private CharSequence mTitle;
  private LinearLayout mTitleLayout;
  private boolean mTitleOptional;
  private int mTitleStyleRes;
  private TextView mTitleView;
  
  public ActionBarContextView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ActionBarContextView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.actionModeStyle);
  }
  
  public ActionBarContextView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = TintTypedArray.obtainStyledAttributes(paramContext, paramAttributeSet, R.styleable.ActionMode, paramInt, 0);
    ViewCompat.setBackground(this, paramContext.getDrawable(R.styleable.ActionMode_background));
    this.mTitleStyleRes = paramContext.getResourceId(R.styleable.ActionMode_titleTextStyle, 0);
    this.mSubtitleStyleRes = paramContext.getResourceId(R.styleable.ActionMode_subtitleTextStyle, 0);
    this.mContentHeight = paramContext.getLayoutDimension(R.styleable.ActionMode_height, 0);
    this.mCloseItemLayout = paramContext.getResourceId(R.styleable.ActionMode_closeItemLayout, R.layout.abc_action_mode_close_item_material);
    paramContext.recycle();
  }
  
  private void initTitle()
  {
    if (this.mTitleLayout == null)
    {
      LayoutInflater.from(getContext()).inflate(R.layout.abc_action_bar_title_item, this);
      localObject = (LinearLayout)getChildAt(getChildCount() - 1);
      this.mTitleLayout = ((LinearLayout)localObject);
      this.mTitleView = ((TextView)((LinearLayout)localObject).findViewById(R.id.action_bar_title));
      this.mSubtitleView = ((TextView)this.mTitleLayout.findViewById(R.id.action_bar_subtitle));
      if (this.mTitleStyleRes != 0) {
        this.mTitleView.setTextAppearance(getContext(), this.mTitleStyleRes);
      }
      if (this.mSubtitleStyleRes != 0) {
        this.mSubtitleView.setTextAppearance(getContext(), this.mSubtitleStyleRes);
      }
    }
    this.mTitleView.setText(this.mTitle);
    this.mSubtitleView.setText(this.mSubtitle);
    boolean bool1 = TextUtils.isEmpty(this.mTitle);
    boolean bool2 = TextUtils.isEmpty(this.mSubtitle) ^ true;
    Object localObject = this.mSubtitleView;
    int i = 0;
    if (bool2) {
      j = 0;
    } else {
      j = 8;
    }
    ((TextView)localObject).setVisibility(j);
    localObject = this.mTitleLayout;
    int j = i;
    if (!(bool1 ^ true)) {
      if (bool2) {
        j = i;
      } else {
        j = 8;
      }
    }
    ((LinearLayout)localObject).setVisibility(j);
    if (this.mTitleLayout.getParent() == null) {
      addView(this.mTitleLayout);
    }
  }
  
  public void closeMode()
  {
    if (this.mClose == null) {
      killMode();
    }
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new ViewGroup.MarginLayoutParams(-1, -2);
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new ViewGroup.MarginLayoutParams(getContext(), paramAttributeSet);
  }
  
  public CharSequence getSubtitle()
  {
    return this.mSubtitle;
  }
  
  public CharSequence getTitle()
  {
    return this.mTitle;
  }
  
  public boolean hideOverflowMenu()
  {
    ActionMenuPresenter localActionMenuPresenter = this.mActionMenuPresenter;
    if (localActionMenuPresenter != null) {
      return localActionMenuPresenter.hideOverflowMenu();
    }
    return false;
  }
  
  public void initForMode(final ActionMode paramActionMode)
  {
    Object localObject = this.mClose;
    if (localObject == null)
    {
      localObject = LayoutInflater.from(getContext()).inflate(this.mCloseItemLayout, this, false);
      this.mClose = ((View)localObject);
      addView((View)localObject);
    }
    else if (((View)localObject).getParent() == null)
    {
      addView(this.mClose);
    }
    this.mClose.findViewById(R.id.action_mode_close_button).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramActionMode.finish();
      }
    });
    paramActionMode = (MenuBuilder)paramActionMode.getMenu();
    localObject = this.mActionMenuPresenter;
    if (localObject != null) {
      ((ActionMenuPresenter)localObject).dismissPopupMenus();
    }
    localObject = new ActionMenuPresenter(getContext());
    this.mActionMenuPresenter = ((ActionMenuPresenter)localObject);
    ((ActionMenuPresenter)localObject).setReserveOverflow(true);
    localObject = new ViewGroup.LayoutParams(-2, -1);
    paramActionMode.addMenuPresenter(this.mActionMenuPresenter, this.mPopupContext);
    paramActionMode = (ActionMenuView)this.mActionMenuPresenter.getMenuView(this);
    this.mMenuView = paramActionMode;
    ViewCompat.setBackground(paramActionMode, null);
    addView(this.mMenuView, (ViewGroup.LayoutParams)localObject);
  }
  
  public boolean isOverflowMenuShowing()
  {
    ActionMenuPresenter localActionMenuPresenter = this.mActionMenuPresenter;
    if (localActionMenuPresenter != null) {
      return localActionMenuPresenter.isOverflowMenuShowing();
    }
    return false;
  }
  
  public boolean isTitleOptional()
  {
    return this.mTitleOptional;
  }
  
  public void killMode()
  {
    removeAllViews();
    this.mCustomView = null;
    this.mMenuView = null;
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    ActionMenuPresenter localActionMenuPresenter = this.mActionMenuPresenter;
    if (localActionMenuPresenter != null)
    {
      localActionMenuPresenter.hideOverflowMenu();
      this.mActionMenuPresenter.hideSubMenus();
    }
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    if (paramAccessibilityEvent.getEventType() == 32)
    {
      paramAccessibilityEvent.setSource(this);
      paramAccessibilityEvent.setClassName(getClass().getName());
      paramAccessibilityEvent.setPackageName(getContext().getPackageName());
      paramAccessibilityEvent.setContentDescription(this.mTitle);
    }
    else
    {
      super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramBoolean = ViewUtils.isLayoutRtl(this);
    int i;
    if (paramBoolean) {
      i = paramInt3 - paramInt1 - getPaddingRight();
    } else {
      i = getPaddingLeft();
    }
    int j = getPaddingTop();
    int k = paramInt4 - paramInt2 - getPaddingTop() - getPaddingBottom();
    Object localObject = this.mClose;
    paramInt2 = i;
    if (localObject != null)
    {
      paramInt2 = i;
      if (((View)localObject).getVisibility() != 8)
      {
        localObject = (ViewGroup.MarginLayoutParams)this.mClose.getLayoutParams();
        if (paramBoolean) {
          paramInt2 = ((ViewGroup.MarginLayoutParams)localObject).rightMargin;
        } else {
          paramInt2 = ((ViewGroup.MarginLayoutParams)localObject).leftMargin;
        }
        if (paramBoolean) {
          paramInt4 = ((ViewGroup.MarginLayoutParams)localObject).leftMargin;
        } else {
          paramInt4 = ((ViewGroup.MarginLayoutParams)localObject).rightMargin;
        }
        paramInt2 = AbsActionBarView.next(i, paramInt2, paramBoolean);
        paramInt2 = AbsActionBarView.next(paramInt2 + positionChild(this.mClose, paramInt2, j, k, paramBoolean), paramInt4, paramBoolean);
      }
    }
    localObject = this.mTitleLayout;
    paramInt4 = paramInt2;
    if (localObject != null)
    {
      paramInt4 = paramInt2;
      if (this.mCustomView == null)
      {
        paramInt4 = paramInt2;
        if (((LinearLayout)localObject).getVisibility() != 8) {
          paramInt4 = paramInt2 + positionChild(this.mTitleLayout, paramInt2, j, k, paramBoolean);
        }
      }
    }
    localObject = this.mCustomView;
    if (localObject != null) {
      positionChild((View)localObject, paramInt4, j, k, paramBoolean);
    }
    if (paramBoolean) {
      paramInt1 = getPaddingLeft();
    } else {
      paramInt1 = paramInt3 - paramInt1 - getPaddingRight();
    }
    localObject = this.mMenuView;
    if (localObject != null) {
      positionChild((View)localObject, paramInt1, j, k, paramBoolean ^ true);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getMode(paramInt1);
    int j = 1073741824;
    if (i == 1073741824)
    {
      if (View.MeasureSpec.getMode(paramInt2) != 0)
      {
        int k = View.MeasureSpec.getSize(paramInt1);
        i = this.mContentHeight;
        if (i <= 0) {
          i = View.MeasureSpec.getSize(paramInt2);
        }
        int m = getPaddingTop() + getPaddingBottom();
        paramInt1 = k - getPaddingLeft() - getPaddingRight();
        int n = i - m;
        int i1 = View.MeasureSpec.makeMeasureSpec(n, Integer.MIN_VALUE);
        localObject = this.mClose;
        int i2 = 0;
        paramInt2 = paramInt1;
        if (localObject != null)
        {
          paramInt1 = measureChildView((View)localObject, paramInt1, i1, 0);
          localObject = (ViewGroup.MarginLayoutParams)this.mClose.getLayoutParams();
          paramInt2 = paramInt1 - (((ViewGroup.MarginLayoutParams)localObject).leftMargin + ((ViewGroup.MarginLayoutParams)localObject).rightMargin);
        }
        localObject = this.mMenuView;
        paramInt1 = paramInt2;
        if (localObject != null)
        {
          paramInt1 = paramInt2;
          if (((ViewGroup)localObject).getParent() == this) {
            paramInt1 = measureChildView(this.mMenuView, paramInt2, i1, 0);
          }
        }
        localObject = this.mTitleLayout;
        paramInt2 = paramInt1;
        int i3;
        if (localObject != null)
        {
          paramInt2 = paramInt1;
          if (this.mCustomView == null) {
            if (this.mTitleOptional)
            {
              paramInt2 = View.MeasureSpec.makeMeasureSpec(0, 0);
              this.mTitleLayout.measure(paramInt2, i1);
              i3 = this.mTitleLayout.getMeasuredWidth();
              if (i3 <= paramInt1) {
                i1 = 1;
              } else {
                i1 = 0;
              }
              paramInt2 = paramInt1;
              if (i1 != 0) {
                paramInt2 = paramInt1 - i3;
              }
              localObject = this.mTitleLayout;
              if (i1 != 0) {
                paramInt1 = 0;
              } else {
                paramInt1 = 8;
              }
              ((LinearLayout)localObject).setVisibility(paramInt1);
            }
            else
            {
              paramInt2 = measureChildView((View)localObject, paramInt1, i1, 0);
            }
          }
        }
        localObject = this.mCustomView;
        if (localObject != null)
        {
          localObject = ((View)localObject).getLayoutParams();
          i3 = ((ViewGroup.LayoutParams)localObject).width;
          if (i3 != -2) {
            paramInt1 = 1073741824;
          } else {
            paramInt1 = Integer.MIN_VALUE;
          }
          i1 = paramInt2;
          if (i3 >= 0) {
            i1 = Math.min(i3, paramInt2);
          }
          i3 = ((ViewGroup.LayoutParams)localObject).height;
          if (i3 != -2) {
            paramInt2 = j;
          } else {
            paramInt2 = Integer.MIN_VALUE;
          }
          j = n;
          if (i3 >= 0) {
            j = Math.min(i3, n);
          }
          this.mCustomView.measure(View.MeasureSpec.makeMeasureSpec(i1, paramInt1), View.MeasureSpec.makeMeasureSpec(j, paramInt2));
        }
        if (this.mContentHeight <= 0)
        {
          j = getChildCount();
          paramInt2 = 0;
          paramInt1 = i2;
          while (paramInt1 < j)
          {
            i1 = getChildAt(paramInt1).getMeasuredHeight() + m;
            i = paramInt2;
            if (i1 > paramInt2) {
              i = i1;
            }
            paramInt1++;
            paramInt2 = i;
          }
          setMeasuredDimension(k, paramInt2);
        }
        else
        {
          setMeasuredDimension(k, i);
        }
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(getClass().getSimpleName());
      ((StringBuilder)localObject).append(" can only be used with android:layout_height=\"wrap_content\"");
      throw new IllegalStateException(((StringBuilder)localObject).toString());
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(getClass().getSimpleName());
    ((StringBuilder)localObject).append(" can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  public void setContentHeight(int paramInt)
  {
    this.mContentHeight = paramInt;
  }
  
  public void setCustomView(View paramView)
  {
    Object localObject = this.mCustomView;
    if (localObject != null) {
      removeView((View)localObject);
    }
    this.mCustomView = paramView;
    if (paramView != null)
    {
      localObject = this.mTitleLayout;
      if (localObject != null)
      {
        removeView((View)localObject);
        this.mTitleLayout = null;
      }
    }
    if (paramView != null) {
      addView(paramView);
    }
    requestLayout();
  }
  
  public void setSubtitle(CharSequence paramCharSequence)
  {
    this.mSubtitle = paramCharSequence;
    initTitle();
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    this.mTitle = paramCharSequence;
    initTitle();
  }
  
  public void setTitleOptional(boolean paramBoolean)
  {
    if (paramBoolean != this.mTitleOptional) {
      requestLayout();
    }
    this.mTitleOptional = paramBoolean;
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return false;
  }
  
  public boolean showOverflowMenu()
  {
    ActionMenuPresenter localActionMenuPresenter = this.mActionMenuPresenter;
    if (localActionMenuPresenter != null) {
      return localActionMenuPresenter.showOverflowMenu();
    }
    return false;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\appcompat\widget\ActionBarContextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */