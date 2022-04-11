package androidx.lifecycle;

import android.annotation.SuppressLint;
import android.app.Application;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public final class SavedStateViewModelFactory
  extends ViewModelProvider.KeyedFactory
{
  private static final Class<?>[] ANDROID_VIEWMODEL_SIGNATURE = { Application.class, SavedStateHandle.class };
  private static final Class<?>[] VIEWMODEL_SIGNATURE = { SavedStateHandle.class };
  private final Application mApplication;
  private final Bundle mDefaultArgs;
  private final ViewModelProvider.AndroidViewModelFactory mFactory;
  private final Lifecycle mLifecycle;
  private final SavedStateRegistry mSavedStateRegistry;
  
  public SavedStateViewModelFactory(@NonNull Application paramApplication, @NonNull SavedStateRegistryOwner paramSavedStateRegistryOwner)
  {
    this(paramApplication, paramSavedStateRegistryOwner, null);
  }
  
  @SuppressLint({"LambdaLast"})
  public SavedStateViewModelFactory(@NonNull Application paramApplication, @NonNull SavedStateRegistryOwner paramSavedStateRegistryOwner, @Nullable Bundle paramBundle)
  {
    this.mSavedStateRegistry = paramSavedStateRegistryOwner.getSavedStateRegistry();
    this.mLifecycle = paramSavedStateRegistryOwner.getLifecycle();
    this.mDefaultArgs = paramBundle;
    this.mApplication = paramApplication;
    this.mFactory = ViewModelProvider.AndroidViewModelFactory.getInstance(paramApplication);
  }
  
  private static <T> Constructor<T> findMatchingConstructor(Class<T> paramClass, Class<?>[] paramArrayOfClass)
  {
    for (paramClass : paramClass.getConstructors()) {
      if (Arrays.equals(paramArrayOfClass, paramClass.getParameterTypes())) {
        return paramClass;
      }
    }
    return null;
  }
  
  @NonNull
  public <T extends ViewModel> T create(@NonNull Class<T> paramClass)
  {
    String str = paramClass.getCanonicalName();
    if (str != null) {
      return create(str, paramClass);
    }
    throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
  }
  
  @NonNull
  public <T extends ViewModel> T create(@NonNull String paramString, @NonNull Class<T> paramClass)
  {
    boolean bool = AndroidViewModel.class.isAssignableFrom(paramClass);
    Object localObject;
    if (bool) {
      localObject = findMatchingConstructor(paramClass, ANDROID_VIEWMODEL_SIGNATURE);
    } else {
      localObject = findMatchingConstructor(paramClass, VIEWMODEL_SIGNATURE);
    }
    if (localObject == null) {
      return this.mFactory.create(paramClass);
    }
    SavedStateHandleController localSavedStateHandleController = SavedStateHandleController.create(this.mSavedStateRegistry, this.mLifecycle, paramString, this.mDefaultArgs);
    if (bool) {}
    try
    {
      paramString = (ViewModel)((Constructor)localObject).newInstance(new Object[] { this.mApplication, localSavedStateHandleController.getHandle() });
      break label120;
      paramString = (ViewModel)((Constructor)localObject).newInstance(new Object[] { localSavedStateHandleController.getHandle() });
      label120:
      paramString.setTagIfAbsent("androidx.lifecycle.savedstate.vm.tag", localSavedStateHandleController);
      return paramString;
    }
    catch (InvocationTargetException paramString)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("An exception happened in constructor of ");
      ((StringBuilder)localObject).append(paramClass);
      throw new RuntimeException(((StringBuilder)localObject).toString(), paramString.getCause());
    }
    catch (InstantiationException localInstantiationException)
    {
      paramString = new StringBuilder();
      paramString.append("A ");
      paramString.append(paramClass);
      paramString.append(" cannot be instantiated.");
      throw new RuntimeException(paramString.toString(), localInstantiationException);
    }
    catch (IllegalAccessException paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Failed to access ");
      localStringBuilder.append(paramClass);
      throw new RuntimeException(localStringBuilder.toString(), paramString);
    }
  }
  
  void onRequery(@NonNull ViewModel paramViewModel)
  {
    SavedStateHandleController.attachHandleIfNeeded(paramViewModel, this.mSavedStateRegistry, this.mLifecycle);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\lifecycle\SavedStateViewModelFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */