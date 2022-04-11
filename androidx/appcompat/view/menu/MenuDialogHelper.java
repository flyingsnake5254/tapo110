package androidx.appcompat.view.menu;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.ListAdapter;
import androidx.annotation.NonNull;
import androidx.appcompat.R.layout;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AlertDialog.Builder;
import androidx.appcompat.app.AppCompatDialog;

class MenuDialogHelper
  implements DialogInterface.OnKeyListener, DialogInterface.OnClickListener, DialogInterface.OnDismissListener, MenuPresenter.Callback
{
  private AlertDialog mDialog;
  private MenuBuilder mMenu;
  ListMenuPresenter mPresenter;
  private MenuPresenter.Callback mPresenterCallback;
  
  public MenuDialogHelper(MenuBuilder paramMenuBuilder)
  {
    this.mMenu = paramMenuBuilder;
  }
  
  public void dismiss()
  {
    AlertDialog localAlertDialog = this.mDialog;
    if (localAlertDialog != null) {
      localAlertDialog.dismiss();
    }
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.mMenu.performItemAction((MenuItemImpl)this.mPresenter.getAdapter().getItem(paramInt), 0);
  }
  
  public void onCloseMenu(@NonNull MenuBuilder paramMenuBuilder, boolean paramBoolean)
  {
    if ((paramBoolean) || (paramMenuBuilder == this.mMenu)) {
      dismiss();
    }
    MenuPresenter.Callback localCallback = this.mPresenterCallback;
    if (localCallback != null) {
      localCallback.onCloseMenu(paramMenuBuilder, paramBoolean);
    }
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.mPresenter.onCloseMenu(this.mMenu, true);
  }
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 82) || (paramInt == 4)) {
      if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getRepeatCount() == 0))
      {
        paramDialogInterface = this.mDialog.getWindow();
        if (paramDialogInterface != null)
        {
          paramDialogInterface = paramDialogInterface.getDecorView();
          if (paramDialogInterface != null)
          {
            paramDialogInterface = paramDialogInterface.getKeyDispatcherState();
            if (paramDialogInterface != null)
            {
              paramDialogInterface.startTracking(paramKeyEvent, this);
              return true;
            }
          }
        }
      }
      else if ((paramKeyEvent.getAction() == 1) && (!paramKeyEvent.isCanceled()))
      {
        Object localObject = this.mDialog.getWindow();
        if (localObject != null)
        {
          localObject = ((Window)localObject).getDecorView();
          if (localObject != null)
          {
            localObject = ((View)localObject).getKeyDispatcherState();
            if ((localObject != null) && (((KeyEvent.DispatcherState)localObject).isTracking(paramKeyEvent)))
            {
              this.mMenu.close(true);
              paramDialogInterface.dismiss();
              return true;
            }
          }
        }
      }
    }
    return this.mMenu.performShortcut(paramInt, paramKeyEvent, 0);
  }
  
  public boolean onOpenSubMenu(@NonNull MenuBuilder paramMenuBuilder)
  {
    MenuPresenter.Callback localCallback = this.mPresenterCallback;
    if (localCallback != null) {
      return localCallback.onOpenSubMenu(paramMenuBuilder);
    }
    return false;
  }
  
  public void setPresenterCallback(MenuPresenter.Callback paramCallback)
  {
    this.mPresenterCallback = paramCallback;
  }
  
  public void show(IBinder paramIBinder)
  {
    Object localObject1 = this.mMenu;
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(((MenuBuilder)localObject1).getContext());
    Object localObject2 = new ListMenuPresenter(localBuilder.getContext(), R.layout.abc_list_menu_item_layout);
    this.mPresenter = ((ListMenuPresenter)localObject2);
    ((ListMenuPresenter)localObject2).setCallback(this);
    this.mMenu.addMenuPresenter(this.mPresenter);
    localBuilder.setAdapter(this.mPresenter.getAdapter(), this);
    localObject2 = ((MenuBuilder)localObject1).getHeaderView();
    if (localObject2 != null) {
      localBuilder.setCustomTitle((View)localObject2);
    } else {
      localBuilder.setIcon(((MenuBuilder)localObject1).getHeaderIcon()).setTitle(((MenuBuilder)localObject1).getHeaderTitle());
    }
    localBuilder.setOnKeyListener(this);
    localObject1 = localBuilder.create();
    this.mDialog = ((AlertDialog)localObject1);
    ((Dialog)localObject1).setOnDismissListener(this);
    localObject1 = this.mDialog.getWindow().getAttributes();
    ((WindowManager.LayoutParams)localObject1).type = 1003;
    if (paramIBinder != null) {
      ((WindowManager.LayoutParams)localObject1).token = paramIBinder;
    }
    ((WindowManager.LayoutParams)localObject1).flags |= 0x20000;
    this.mDialog.show();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\appcompat\view\menu\MenuDialogHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */