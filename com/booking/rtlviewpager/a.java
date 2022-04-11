package com.booking.rtlviewpager;

import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

class a
  extends PagerAdapter
{
  @NonNull
  private final PagerAdapter a;
  
  protected a(@NonNull PagerAdapter paramPagerAdapter)
  {
    this.a = paramPagerAdapter;
  }
  
  @NonNull
  public PagerAdapter a()
  {
    return this.a;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    this.a.destroyItem(paramViewGroup, paramInt, paramObject);
  }
  
  public void finishUpdate(ViewGroup paramViewGroup)
  {
    this.a.finishUpdate(paramViewGroup);
  }
  
  public int getCount()
  {
    return this.a.getCount();
  }
  
  public int getItemPosition(Object paramObject)
  {
    return this.a.getItemPosition(paramObject);
  }
  
  public CharSequence getPageTitle(int paramInt)
  {
    return this.a.getPageTitle(paramInt);
  }
  
  public float getPageWidth(int paramInt)
  {
    return this.a.getPageWidth(paramInt);
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    return this.a.instantiateItem(paramViewGroup, paramInt);
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return this.a.isViewFromObject(paramView, paramObject);
  }
  
  public void notifyDataSetChanged()
  {
    this.a.notifyDataSetChanged();
  }
  
  public void registerDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    this.a.registerDataSetObserver(paramDataSetObserver);
  }
  
  public void restoreState(Parcelable paramParcelable, ClassLoader paramClassLoader)
  {
    this.a.restoreState(paramParcelable, paramClassLoader);
  }
  
  public Parcelable saveState()
  {
    return this.a.saveState();
  }
  
  public void setPrimaryItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    this.a.setPrimaryItem(paramViewGroup, paramInt, paramObject);
  }
  
  public void startUpdate(ViewGroup paramViewGroup)
  {
    this.a.startUpdate(paramViewGroup);
  }
  
  public void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    this.a.unregisterDataSetObserver(paramDataSetObserver);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\booking\rtlviewpager\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */