package androidx.databinding;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DataBindingUtil
{
  private static DataBindingComponent sDefaultComponent = null;
  private static DataBinderMapper sMapper = new DataBinderMapperImpl();
  
  @Nullable
  public static <T extends ViewDataBinding> T bind(@NonNull View paramView)
  {
    return bind(paramView, sDefaultComponent);
  }
  
  @Nullable
  public static <T extends ViewDataBinding> T bind(@NonNull View paramView, DataBindingComponent paramDataBindingComponent)
  {
    Object localObject = getBinding(paramView);
    if (localObject != null) {
      return (T)localObject;
    }
    localObject = paramView.getTag();
    if ((localObject instanceof String))
    {
      String str = (String)localObject;
      int i = sMapper.getLayoutId(str);
      if (i != 0) {
        return sMapper.getDataBinder(paramDataBindingComponent, paramView, i);
      }
      paramView = new StringBuilder();
      paramView.append("View is not a binding layout. Tag: ");
      paramView.append(localObject);
      throw new IllegalArgumentException(paramView.toString());
    }
    throw new IllegalArgumentException("View is not a binding layout");
  }
  
  static <T extends ViewDataBinding> T bind(DataBindingComponent paramDataBindingComponent, View paramView, int paramInt)
  {
    return sMapper.getDataBinder(paramDataBindingComponent, paramView, paramInt);
  }
  
  static <T extends ViewDataBinding> T bind(DataBindingComponent paramDataBindingComponent, View[] paramArrayOfView, int paramInt)
  {
    return sMapper.getDataBinder(paramDataBindingComponent, paramArrayOfView, paramInt);
  }
  
  private static <T extends ViewDataBinding> T bindToAddedViews(DataBindingComponent paramDataBindingComponent, ViewGroup paramViewGroup, int paramInt1, int paramInt2)
  {
    int i = paramViewGroup.getChildCount();
    int j = i - paramInt1;
    if (j == 1) {
      return bind(paramDataBindingComponent, paramViewGroup.getChildAt(i - 1), paramInt2);
    }
    View[] arrayOfView = new View[j];
    for (i = 0; i < j; i++) {
      arrayOfView[i] = paramViewGroup.getChildAt(i + paramInt1);
    }
    return bind(paramDataBindingComponent, arrayOfView, paramInt2);
  }
  
  @Nullable
  public static String convertBrIdToString(int paramInt)
  {
    return sMapper.convertBrIdToString(paramInt);
  }
  
  @Nullable
  public static <T extends ViewDataBinding> T findBinding(@NonNull View paramView)
  {
    while (paramView != null)
    {
      Object localObject = ViewDataBinding.getBinding(paramView);
      if (localObject != null) {
        return (T)localObject;
      }
      localObject = paramView.getTag();
      if ((localObject instanceof String))
      {
        localObject = (String)localObject;
        if ((((String)localObject).startsWith("layout")) && (((String)localObject).endsWith("_0")))
        {
          int i = ((String)localObject).charAt(6);
          int j = ((String)localObject).indexOf('/', 7);
          int k = 1;
          int m = 0;
          if (i == 47) {
            if (j == -1) {
              n = k;
            }
          }
          for (int n = 0;; n = k)
          {
            break label135;
            n = m;
            if (i != 45) {
              break label135;
            }
            n = m;
            if (j == -1) {
              break label135;
            }
            if (((String)localObject).indexOf('/', j + 1) != -1) {
              break;
            }
          }
          label135:
          if (n != 0) {
            return null;
          }
        }
      }
      paramView = paramView.getParent();
      if ((paramView instanceof View)) {
        paramView = (View)paramView;
      } else {
        paramView = null;
      }
    }
    return null;
  }
  
  @Nullable
  public static <T extends ViewDataBinding> T getBinding(@NonNull View paramView)
  {
    return ViewDataBinding.getBinding(paramView);
  }
  
  @Nullable
  public static DataBindingComponent getDefaultComponent()
  {
    return sDefaultComponent;
  }
  
  public static <T extends ViewDataBinding> T inflate(@NonNull LayoutInflater paramLayoutInflater, int paramInt, @Nullable ViewGroup paramViewGroup, boolean paramBoolean)
  {
    return inflate(paramLayoutInflater, paramInt, paramViewGroup, paramBoolean, sDefaultComponent);
  }
  
  public static <T extends ViewDataBinding> T inflate(@NonNull LayoutInflater paramLayoutInflater, int paramInt, @Nullable ViewGroup paramViewGroup, boolean paramBoolean, @Nullable DataBindingComponent paramDataBindingComponent)
  {
    int i = 0;
    int j;
    if ((paramViewGroup != null) && (paramBoolean)) {
      j = 1;
    } else {
      j = 0;
    }
    if (j != 0) {
      i = paramViewGroup.getChildCount();
    }
    paramLayoutInflater = paramLayoutInflater.inflate(paramInt, paramViewGroup, paramBoolean);
    if (j != 0) {
      return bindToAddedViews(paramDataBindingComponent, paramViewGroup, i, paramInt);
    }
    return bind(paramDataBindingComponent, paramLayoutInflater, paramInt);
  }
  
  public static <T extends ViewDataBinding> T setContentView(@NonNull Activity paramActivity, int paramInt)
  {
    return setContentView(paramActivity, paramInt, sDefaultComponent);
  }
  
  public static <T extends ViewDataBinding> T setContentView(@NonNull Activity paramActivity, int paramInt, @Nullable DataBindingComponent paramDataBindingComponent)
  {
    paramActivity.setContentView(paramInt);
    return bindToAddedViews(paramDataBindingComponent, (ViewGroup)paramActivity.getWindow().getDecorView().findViewById(16908290), 0, paramInt);
  }
  
  public static void setDefaultComponent(@Nullable DataBindingComponent paramDataBindingComponent)
  {
    sDefaultComponent = paramDataBindingComponent;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\databinding\DataBindingUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */