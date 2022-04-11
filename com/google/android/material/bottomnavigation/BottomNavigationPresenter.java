package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuPresenter.Callback;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.SubMenuBuilder;
import com.google.android.material.badge.BadgeUtils;
import com.google.android.material.internal.ParcelableSparseArray;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class BottomNavigationPresenter
  implements MenuPresenter
{
  private int id;
  private MenuBuilder menu;
  private BottomNavigationMenuView menuView;
  private boolean updateSuspended = false;
  
  public boolean collapseItemActionView(MenuBuilder paramMenuBuilder, MenuItemImpl paramMenuItemImpl)
  {
    return false;
  }
  
  public boolean expandItemActionView(MenuBuilder paramMenuBuilder, MenuItemImpl paramMenuItemImpl)
  {
    return false;
  }
  
  public boolean flagActionItems()
  {
    return false;
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public MenuView getMenuView(ViewGroup paramViewGroup)
  {
    return this.menuView;
  }
  
  public void initForMenu(Context paramContext, MenuBuilder paramMenuBuilder)
  {
    this.menu = paramMenuBuilder;
    this.menuView.initialize(paramMenuBuilder);
  }
  
  public void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean) {}
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof SavedState))
    {
      BottomNavigationMenuView localBottomNavigationMenuView = this.menuView;
      paramParcelable = (SavedState)paramParcelable;
      localBottomNavigationMenuView.tryRestoreSelectedItemId(paramParcelable.selectedItemId);
      paramParcelable = BadgeUtils.createBadgeDrawablesFromSavedStates(this.menuView.getContext(), paramParcelable.badgeSavedStates);
      this.menuView.setBadgeDrawables(paramParcelable);
    }
  }
  
  @NonNull
  public Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState();
    localSavedState.selectedItemId = this.menuView.getSelectedItemId();
    localSavedState.badgeSavedStates = BadgeUtils.createParcelableBadgeStates(this.menuView.getBadgeDrawables());
    return localSavedState;
  }
  
  public boolean onSubMenuSelected(SubMenuBuilder paramSubMenuBuilder)
  {
    return false;
  }
  
  public void setBottomNavigationMenuView(BottomNavigationMenuView paramBottomNavigationMenuView)
  {
    this.menuView = paramBottomNavigationMenuView;
  }
  
  public void setCallback(MenuPresenter.Callback paramCallback) {}
  
  public void setId(int paramInt)
  {
    this.id = paramInt;
  }
  
  public void setUpdateSuspended(boolean paramBoolean)
  {
    this.updateSuspended = paramBoolean;
  }
  
  public void updateMenuView(boolean paramBoolean)
  {
    if (this.updateSuspended) {
      return;
    }
    if (paramBoolean) {
      this.menuView.buildMenuView();
    } else {
      this.menuView.updateMenuView();
    }
  }
  
  static class SavedState
    implements Parcelable
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator()
    {
      @NonNull
      public BottomNavigationPresenter.SavedState createFromParcel(@NonNull Parcel paramAnonymousParcel)
      {
        return new BottomNavigationPresenter.SavedState(paramAnonymousParcel);
      }
      
      @NonNull
      public BottomNavigationPresenter.SavedState[] newArray(int paramAnonymousInt)
      {
        return new BottomNavigationPresenter.SavedState[paramAnonymousInt];
      }
    };
    @Nullable
    ParcelableSparseArray badgeSavedStates;
    int selectedItemId;
    
    SavedState() {}
    
    SavedState(@NonNull Parcel paramParcel)
    {
      this.selectedItemId = paramParcel.readInt();
      this.badgeSavedStates = ((ParcelableSparseArray)paramParcel.readParcelable(getClass().getClassLoader()));
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(@NonNull Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(this.selectedItemId);
      paramParcel.writeParcelable(this.badgeSavedStates, 0);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\bottomnavigation\BottomNavigationPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */