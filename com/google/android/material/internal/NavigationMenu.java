package com.google.android.material.internal;

import android.content.Context;
import android.view.SubMenu;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class NavigationMenu
  extends MenuBuilder
{
  public NavigationMenu(Context paramContext)
  {
    super(paramContext);
  }
  
  @NonNull
  public SubMenu addSubMenu(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    MenuItemImpl localMenuItemImpl = (MenuItemImpl)addInternal(paramInt1, paramInt2, paramInt3, paramCharSequence);
    paramCharSequence = new NavigationSubMenu(getContext(), this, localMenuItemImpl);
    localMenuItemImpl.setSubMenu(paramCharSequence);
    return paramCharSequence;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\internal\NavigationMenu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */