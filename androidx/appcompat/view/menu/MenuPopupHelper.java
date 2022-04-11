package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.R.attr;
import androidx.appcompat.R.dimen;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class MenuPopupHelper
  implements MenuHelper
{
  private static final int TOUCH_EPICENTER_SIZE_DP = 48;
  private View mAnchorView;
  private final Context mContext;
  private int mDropDownGravity = 8388611;
  private boolean mForceShowIcon;
  private final PopupWindow.OnDismissListener mInternalOnDismissListener = new PopupWindow.OnDismissListener()
  {
    public void onDismiss()
    {
      MenuPopupHelper.this.onDismiss();
    }
  };
  private final MenuBuilder mMenu;
  private PopupWindow.OnDismissListener mOnDismissListener;
  private final boolean mOverflowOnly;
  private MenuPopup mPopup;
  private final int mPopupStyleAttr;
  private final int mPopupStyleRes;
  private MenuPresenter.Callback mPresenterCallback;
  
  public MenuPopupHelper(@NonNull Context paramContext, @NonNull MenuBuilder paramMenuBuilder)
  {
    this(paramContext, paramMenuBuilder, null, false, R.attr.popupMenuStyle, 0);
  }
  
  public MenuPopupHelper(@NonNull Context paramContext, @NonNull MenuBuilder paramMenuBuilder, @NonNull View paramView)
  {
    this(paramContext, paramMenuBuilder, paramView, false, R.attr.popupMenuStyle, 0);
  }
  
  public MenuPopupHelper(@NonNull Context paramContext, @NonNull MenuBuilder paramMenuBuilder, @NonNull View paramView, boolean paramBoolean, @AttrRes int paramInt)
  {
    this(paramContext, paramMenuBuilder, paramView, paramBoolean, paramInt, 0);
  }
  
  public MenuPopupHelper(@NonNull Context paramContext, @NonNull MenuBuilder paramMenuBuilder, @NonNull View paramView, boolean paramBoolean, @AttrRes int paramInt1, @StyleRes int paramInt2)
  {
    this.mContext = paramContext;
    this.mMenu = paramMenuBuilder;
    this.mAnchorView = paramView;
    this.mOverflowOnly = paramBoolean;
    this.mPopupStyleAttr = paramInt1;
    this.mPopupStyleRes = paramInt2;
  }
  
  @NonNull
  private MenuPopup createPopup()
  {
    Display localDisplay = ((WindowManager)this.mContext.getSystemService("window")).getDefaultDisplay();
    Object localObject = new Point();
    if (Build.VERSION.SDK_INT >= 17) {
      localDisplay.getRealSize((Point)localObject);
    } else {
      localDisplay.getSize((Point)localObject);
    }
    int i;
    if (Math.min(((Point)localObject).x, ((Point)localObject).y) >= this.mContext.getResources().getDimensionPixelSize(R.dimen.abc_cascading_menus_min_smallest_width)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      localObject = new CascadingMenuPopup(this.mContext, this.mAnchorView, this.mPopupStyleAttr, this.mPopupStyleRes, this.mOverflowOnly);
    } else {
      localObject = new StandardMenuPopup(this.mContext, this.mMenu, this.mAnchorView, this.mPopupStyleAttr, this.mPopupStyleRes, this.mOverflowOnly);
    }
    ((MenuPopup)localObject).addMenu(this.mMenu);
    ((MenuPopup)localObject).setOnDismissListener(this.mInternalOnDismissListener);
    ((MenuPopup)localObject).setAnchorView(this.mAnchorView);
    ((MenuPresenter)localObject).setCallback(this.mPresenterCallback);
    ((MenuPopup)localObject).setForceShowIcon(this.mForceShowIcon);
    ((MenuPopup)localObject).setGravity(this.mDropDownGravity);
    return (MenuPopup)localObject;
  }
  
  private void showPopup(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    MenuPopup localMenuPopup = getPopup();
    localMenuPopup.setShowTitle(paramBoolean2);
    if (paramBoolean1)
    {
      int i = paramInt1;
      if ((GravityCompat.getAbsoluteGravity(this.mDropDownGravity, ViewCompat.getLayoutDirection(this.mAnchorView)) & 0x7) == 5) {
        i = paramInt1 - this.mAnchorView.getWidth();
      }
      localMenuPopup.setHorizontalOffset(i);
      localMenuPopup.setVerticalOffset(paramInt2);
      paramInt1 = (int)(this.mContext.getResources().getDisplayMetrics().density * 48.0F / 2.0F);
      localMenuPopup.setEpicenterBounds(new Rect(i - paramInt1, paramInt2 - paramInt1, i + paramInt1, paramInt2 + paramInt1));
    }
    localMenuPopup.show();
  }
  
  public void dismiss()
  {
    if (isShowing()) {
      this.mPopup.dismiss();
    }
  }
  
  public int getGravity()
  {
    return this.mDropDownGravity;
  }
  
  public ListView getListView()
  {
    return getPopup().getListView();
  }
  
  @NonNull
  public MenuPopup getPopup()
  {
    if (this.mPopup == null) {
      this.mPopup = createPopup();
    }
    return this.mPopup;
  }
  
  public boolean isShowing()
  {
    MenuPopup localMenuPopup = this.mPopup;
    boolean bool;
    if ((localMenuPopup != null) && (localMenuPopup.isShowing())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  protected void onDismiss()
  {
    this.mPopup = null;
    PopupWindow.OnDismissListener localOnDismissListener = this.mOnDismissListener;
    if (localOnDismissListener != null) {
      localOnDismissListener.onDismiss();
    }
  }
  
  public void setAnchorView(@NonNull View paramView)
  {
    this.mAnchorView = paramView;
  }
  
  public void setForceShowIcon(boolean paramBoolean)
  {
    this.mForceShowIcon = paramBoolean;
    MenuPopup localMenuPopup = this.mPopup;
    if (localMenuPopup != null) {
      localMenuPopup.setForceShowIcon(paramBoolean);
    }
  }
  
  public void setGravity(int paramInt)
  {
    this.mDropDownGravity = paramInt;
  }
  
  public void setOnDismissListener(@Nullable PopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.mOnDismissListener = paramOnDismissListener;
  }
  
  public void setPresenterCallback(@Nullable MenuPresenter.Callback paramCallback)
  {
    this.mPresenterCallback = paramCallback;
    MenuPopup localMenuPopup = this.mPopup;
    if (localMenuPopup != null) {
      localMenuPopup.setCallback(paramCallback);
    }
  }
  
  public void show()
  {
    if (tryShow()) {
      return;
    }
    throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
  }
  
  public void show(int paramInt1, int paramInt2)
  {
    if (tryShow(paramInt1, paramInt2)) {
      return;
    }
    throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
  }
  
  public boolean tryShow()
  {
    if (isShowing()) {
      return true;
    }
    if (this.mAnchorView == null) {
      return false;
    }
    showPopup(0, 0, false, false);
    return true;
  }
  
  public boolean tryShow(int paramInt1, int paramInt2)
  {
    if (isShowing()) {
      return true;
    }
    if (this.mAnchorView == null) {
      return false;
    }
    showPopup(paramInt1, paramInt2, true, true);
    return true;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\appcompat\view\menu\MenuPopupHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */