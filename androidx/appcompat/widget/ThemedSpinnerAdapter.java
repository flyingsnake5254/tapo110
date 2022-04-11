package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.view.LayoutInflater;
import android.widget.SpinnerAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.view.ContextThemeWrapper;

public abstract interface ThemedSpinnerAdapter
  extends SpinnerAdapter
{
  @Nullable
  public abstract Resources.Theme getDropDownViewTheme();
  
  public abstract void setDropDownViewTheme(@Nullable Resources.Theme paramTheme);
  
  public static final class Helper
  {
    private final Context mContext;
    private LayoutInflater mDropDownInflater;
    private final LayoutInflater mInflater;
    
    public Helper(@NonNull Context paramContext)
    {
      this.mContext = paramContext;
      this.mInflater = LayoutInflater.from(paramContext);
    }
    
    @NonNull
    public LayoutInflater getDropDownViewInflater()
    {
      LayoutInflater localLayoutInflater = this.mDropDownInflater;
      if (localLayoutInflater == null) {
        localLayoutInflater = this.mInflater;
      }
      return localLayoutInflater;
    }
    
    @Nullable
    public Resources.Theme getDropDownViewTheme()
    {
      Object localObject = this.mDropDownInflater;
      if (localObject == null) {
        localObject = null;
      } else {
        localObject = ((LayoutInflater)localObject).getContext().getTheme();
      }
      return (Resources.Theme)localObject;
    }
    
    public void setDropDownViewTheme(@Nullable Resources.Theme paramTheme)
    {
      if (paramTheme == null) {
        this.mDropDownInflater = null;
      } else if (paramTheme == this.mContext.getTheme()) {
        this.mDropDownInflater = this.mInflater;
      } else {
        this.mDropDownInflater = LayoutInflater.from(new ContextThemeWrapper(this.mContext, paramTheme));
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\appcompat\widget\ThemedSpinnerAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */