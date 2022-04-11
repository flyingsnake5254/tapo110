package androidx.appcompat.widget;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;
import androidx.annotation.AttrRes;
import androidx.annotation.MenuRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.R.attr;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuBuilder.Callback;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.appcompat.view.menu.ShowableListMenu;

public class PopupMenu
{
  private final View mAnchor;
  private final Context mContext;
  private View.OnTouchListener mDragListener;
  private final MenuBuilder mMenu;
  OnMenuItemClickListener mMenuItemClickListener;
  OnDismissListener mOnDismissListener;
  final MenuPopupHelper mPopup;
  
  public PopupMenu(@NonNull Context paramContext, @NonNull View paramView)
  {
    this(paramContext, paramView, 0);
  }
  
  public PopupMenu(@NonNull Context paramContext, @NonNull View paramView, int paramInt)
  {
    this(paramContext, paramView, paramInt, R.attr.popupMenuStyle, 0);
  }
  
  public PopupMenu(@NonNull Context paramContext, @NonNull View paramView, int paramInt1, @AttrRes int paramInt2, @StyleRes int paramInt3)
  {
    this.mContext = paramContext;
    this.mAnchor = paramView;
    MenuBuilder localMenuBuilder = new MenuBuilder(paramContext);
    this.mMenu = localMenuBuilder;
    localMenuBuilder.setCallback(new MenuBuilder.Callback()
    {
      public boolean onMenuItemSelected(@NonNull MenuBuilder paramAnonymousMenuBuilder, @NonNull MenuItem paramAnonymousMenuItem)
      {
        paramAnonymousMenuBuilder = PopupMenu.this.mMenuItemClickListener;
        if (paramAnonymousMenuBuilder != null) {
          return paramAnonymousMenuBuilder.onMenuItemClick(paramAnonymousMenuItem);
        }
        return false;
      }
      
      public void onMenuModeChange(@NonNull MenuBuilder paramAnonymousMenuBuilder) {}
    });
    paramContext = new MenuPopupHelper(paramContext, localMenuBuilder, paramView, false, paramInt2, paramInt3);
    this.mPopup = paramContext;
    paramContext.setGravity(paramInt1);
    paramContext.setOnDismissListener(new PopupWindow.OnDismissListener()
    {
      public void onDismiss()
      {
        PopupMenu localPopupMenu = PopupMenu.this;
        PopupMenu.OnDismissListener localOnDismissListener = localPopupMenu.mOnDismissListener;
        if (localOnDismissListener != null) {
          localOnDismissListener.onDismiss(localPopupMenu);
        }
      }
    });
  }
  
  public void dismiss()
  {
    this.mPopup.dismiss();
  }
  
  @NonNull
  public View.OnTouchListener getDragToOpenListener()
  {
    if (this.mDragListener == null) {
      this.mDragListener = new ForwardingListener(this.mAnchor)
      {
        public ShowableListMenu getPopup()
        {
          return PopupMenu.this.mPopup.getPopup();
        }
        
        protected boolean onForwardingStarted()
        {
          PopupMenu.this.show();
          return true;
        }
        
        protected boolean onForwardingStopped()
        {
          PopupMenu.this.dismiss();
          return true;
        }
      };
    }
    return this.mDragListener;
  }
  
  public int getGravity()
  {
    return this.mPopup.getGravity();
  }
  
  @NonNull
  public Menu getMenu()
  {
    return this.mMenu;
  }
  
  @NonNull
  public MenuInflater getMenuInflater()
  {
    return new SupportMenuInflater(this.mContext);
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  ListView getMenuListView()
  {
    if (!this.mPopup.isShowing()) {
      return null;
    }
    return this.mPopup.getListView();
  }
  
  public void inflate(@MenuRes int paramInt)
  {
    getMenuInflater().inflate(paramInt, this.mMenu);
  }
  
  public void setGravity(int paramInt)
  {
    this.mPopup.setGravity(paramInt);
  }
  
  public void setOnDismissListener(@Nullable OnDismissListener paramOnDismissListener)
  {
    this.mOnDismissListener = paramOnDismissListener;
  }
  
  public void setOnMenuItemClickListener(@Nullable OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    this.mMenuItemClickListener = paramOnMenuItemClickListener;
  }
  
  public void show()
  {
    this.mPopup.show();
  }
  
  public static abstract interface OnDismissListener
  {
    public abstract void onDismiss(PopupMenu paramPopupMenu);
  }
  
  public static abstract interface OnMenuItemClickListener
  {
    public abstract boolean onMenuItemClick(MenuItem paramMenuItem);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\appcompat\widget\PopupMenu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */