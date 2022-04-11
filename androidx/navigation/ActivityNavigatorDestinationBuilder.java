package androidx.navigation;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.net.Uri;
import androidx.annotation.IdRes;
import kotlin.jvm.a;
import kotlin.jvm.internal.j;
import kotlin.reflect.c;

@NavDestinationDsl
public final class ActivityNavigatorDestinationBuilder
  extends NavDestinationBuilder<ActivityNavigator.Destination>
{
  private String action;
  private c<? extends Activity> activityClass;
  private final Context context;
  private Uri data;
  private String dataPattern;
  private String targetPackage;
  
  public ActivityNavigatorDestinationBuilder(ActivityNavigator paramActivityNavigator, @IdRes int paramInt)
  {
    super(paramActivityNavigator, paramInt);
    paramActivityNavigator = paramActivityNavigator.getContext();
    j.b(paramActivityNavigator, "navigator.context");
    this.context = paramActivityNavigator;
  }
  
  public ActivityNavigator.Destination build()
  {
    ActivityNavigator.Destination localDestination = (ActivityNavigator.Destination)super.build();
    localDestination.setTargetPackage(this.targetPackage);
    c localc = this.activityClass;
    if (localc != null) {
      localDestination.setComponentName(new ComponentName(this.context, a.a(localc)));
    }
    localDestination.setAction(this.action);
    localDestination.setData(this.data);
    localDestination.setDataPattern(this.dataPattern);
    return localDestination;
  }
  
  public final String getAction()
  {
    return this.action;
  }
  
  public final c<? extends Activity> getActivityClass()
  {
    return this.activityClass;
  }
  
  public final Uri getData()
  {
    return this.data;
  }
  
  public final String getDataPattern()
  {
    return this.dataPattern;
  }
  
  public final String getTargetPackage()
  {
    return this.targetPackage;
  }
  
  public final void setAction(String paramString)
  {
    this.action = paramString;
  }
  
  public final void setActivityClass(c<? extends Activity> paramc)
  {
    this.activityClass = paramc;
  }
  
  public final void setData(Uri paramUri)
  {
    this.data = paramUri;
  }
  
  public final void setDataPattern(String paramString)
  {
    this.dataPattern = paramString;
  }
  
  public final void setTargetPackage(String paramString)
  {
    this.targetPackage = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\navigation\ActivityNavigatorDestinationBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */