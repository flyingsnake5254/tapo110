package androidx.lifecycle;

import android.app.Application;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ViewModelProvider
{
  private static final String DEFAULT_KEY = "androidx.lifecycle.ViewModelProvider.DefaultKey";
  private final Factory mFactory;
  private final ViewModelStore mViewModelStore;
  
  public ViewModelProvider(@NonNull ViewModelStore paramViewModelStore, @NonNull Factory paramFactory)
  {
    this.mFactory = paramFactory;
    this.mViewModelStore = paramViewModelStore;
  }
  
  public ViewModelProvider(@NonNull ViewModelStoreOwner paramViewModelStoreOwner)
  {
    this(localViewModelStore, paramViewModelStoreOwner);
  }
  
  public ViewModelProvider(@NonNull ViewModelStoreOwner paramViewModelStoreOwner, @NonNull Factory paramFactory)
  {
    this(paramViewModelStoreOwner.getViewModelStore(), paramFactory);
  }
  
  @MainThread
  @NonNull
  public <T extends ViewModel> T get(@NonNull Class<T> paramClass)
  {
    String str = paramClass.getCanonicalName();
    if (str != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("androidx.lifecycle.ViewModelProvider.DefaultKey:");
      localStringBuilder.append(str);
      return get(localStringBuilder.toString(), paramClass);
    }
    throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
  }
  
  @MainThread
  @NonNull
  public <T extends ViewModel> T get(@NonNull String paramString, @NonNull Class<T> paramClass)
  {
    Object localObject = this.mViewModelStore.get(paramString);
    if (paramClass.isInstance(localObject))
    {
      paramString = this.mFactory;
      if ((paramString instanceof OnRequeryFactory)) {
        ((OnRequeryFactory)paramString).onRequery((ViewModel)localObject);
      }
      return (T)localObject;
    }
    localObject = this.mFactory;
    if ((localObject instanceof KeyedFactory)) {
      paramClass = ((KeyedFactory)localObject).create(paramString, paramClass);
    } else {
      paramClass = ((Factory)localObject).create(paramClass);
    }
    this.mViewModelStore.put(paramString, paramClass);
    return paramClass;
  }
  
  public static class AndroidViewModelFactory
    extends ViewModelProvider.NewInstanceFactory
  {
    private static AndroidViewModelFactory sInstance;
    private Application mApplication;
    
    public AndroidViewModelFactory(@NonNull Application paramApplication)
    {
      this.mApplication = paramApplication;
    }
    
    @NonNull
    public static AndroidViewModelFactory getInstance(@NonNull Application paramApplication)
    {
      if (sInstance == null) {
        sInstance = new AndroidViewModelFactory(paramApplication);
      }
      return sInstance;
    }
    
    @NonNull
    public <T extends ViewModel> T create(@NonNull Class<T> paramClass)
    {
      if (AndroidViewModel.class.isAssignableFrom(paramClass)) {
        try
        {
          ViewModel localViewModel = (ViewModel)paramClass.getConstructor(new Class[] { Application.class }).newInstance(new Object[] { this.mApplication });
          return localViewModel;
        }
        catch (InvocationTargetException localInvocationTargetException)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("Cannot create an instance of ");
          localStringBuilder.append(paramClass);
          throw new RuntimeException(localStringBuilder.toString(), localInvocationTargetException);
        }
        catch (InstantiationException localInstantiationException)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("Cannot create an instance of ");
          localStringBuilder.append(paramClass);
          throw new RuntimeException(localStringBuilder.toString(), localInstantiationException);
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("Cannot create an instance of ");
          localStringBuilder.append(paramClass);
          throw new RuntimeException(localStringBuilder.toString(), localIllegalAccessException);
        }
        catch (NoSuchMethodException localNoSuchMethodException)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Cannot create an instance of ");
          localStringBuilder.append(paramClass);
          throw new RuntimeException(localStringBuilder.toString(), localNoSuchMethodException);
        }
      }
      return super.create(paramClass);
    }
  }
  
  public static abstract interface Factory
  {
    @NonNull
    public abstract <T extends ViewModel> T create(@NonNull Class<T> paramClass);
  }
  
  static abstract class KeyedFactory
    extends ViewModelProvider.OnRequeryFactory
    implements ViewModelProvider.Factory
  {
    @NonNull
    public <T extends ViewModel> T create(@NonNull Class<T> paramClass)
    {
      throw new UnsupportedOperationException("create(String, Class<?>) must be called on implementaions of KeyedFactory");
    }
    
    @NonNull
    public abstract <T extends ViewModel> T create(@NonNull String paramString, @NonNull Class<T> paramClass);
  }
  
  public static class NewInstanceFactory
    implements ViewModelProvider.Factory
  {
    private static NewInstanceFactory sInstance;
    
    @NonNull
    static NewInstanceFactory getInstance()
    {
      if (sInstance == null) {
        sInstance = new NewInstanceFactory();
      }
      return sInstance;
    }
    
    @NonNull
    public <T extends ViewModel> T create(@NonNull Class<T> paramClass)
    {
      try
      {
        localObject = (ViewModel)paramClass.newInstance();
        return (T)localObject;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Cannot create an instance of ");
        ((StringBuilder)localObject).append(paramClass);
        throw new RuntimeException(((StringBuilder)localObject).toString(), localIllegalAccessException);
      }
      catch (InstantiationException localInstantiationException)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Cannot create an instance of ");
        ((StringBuilder)localObject).append(paramClass);
        throw new RuntimeException(((StringBuilder)localObject).toString(), localInstantiationException);
      }
    }
  }
  
  static class OnRequeryFactory
  {
    void onRequery(@NonNull ViewModel paramViewModel) {}
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\lifecycle\ViewModelProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */