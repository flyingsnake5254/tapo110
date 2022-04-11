package androidx.navigation;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.content.ContextCompat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Navigator.Name("activity")
public class ActivityNavigator
  extends Navigator<Destination>
{
  private static final String EXTRA_NAV_CURRENT = "android-support-navigation:ActivityNavigator:current";
  private static final String EXTRA_NAV_SOURCE = "android-support-navigation:ActivityNavigator:source";
  private static final String EXTRA_POP_ENTER_ANIM = "android-support-navigation:ActivityNavigator:popEnterAnim";
  private static final String EXTRA_POP_EXIT_ANIM = "android-support-navigation:ActivityNavigator:popExitAnim";
  private static final String LOG_TAG = "ActivityNavigator";
  private Context mContext;
  private Activity mHostActivity;
  
  public ActivityNavigator(@NonNull Context paramContext)
  {
    this.mContext = paramContext;
    while ((paramContext instanceof ContextWrapper))
    {
      if ((paramContext instanceof Activity))
      {
        this.mHostActivity = ((Activity)paramContext);
        break;
      }
      paramContext = ((ContextWrapper)paramContext).getBaseContext();
    }
  }
  
  public static void applyPopAnimationsToPendingTransition(@NonNull Activity paramActivity)
  {
    Intent localIntent = paramActivity.getIntent();
    if (localIntent == null) {
      return;
    }
    int i = localIntent.getIntExtra("android-support-navigation:ActivityNavigator:popEnterAnim", -1);
    int j = localIntent.getIntExtra("android-support-navigation:ActivityNavigator:popExitAnim", -1);
    if ((i != -1) || (j != -1))
    {
      if (i == -1) {
        i = 0;
      }
      if (j == -1) {
        j = 0;
      }
      paramActivity.overridePendingTransition(i, j);
    }
  }
  
  @NonNull
  public Destination createDestination()
  {
    return new Destination(this);
  }
  
  @NonNull
  final Context getContext()
  {
    return this.mContext;
  }
  
  @Nullable
  public NavDestination navigate(@NonNull Destination paramDestination, @Nullable Bundle paramBundle, @Nullable NavOptions paramNavOptions, @Nullable Navigator.Extras paramExtras)
  {
    if (paramDestination.getIntent() != null)
    {
      Intent localIntent = new Intent(paramDestination.getIntent());
      Object localObject;
      if (paramBundle != null)
      {
        localIntent.putExtras(paramBundle);
        localObject = paramDestination.getDataPattern();
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          StringBuffer localStringBuffer = new StringBuffer();
          Matcher localMatcher = Pattern.compile("\\{(.+?)\\}").matcher((CharSequence)localObject);
          while (localMatcher.find())
          {
            String str = localMatcher.group(1);
            if (paramBundle.containsKey(str))
            {
              localMatcher.appendReplacement(localStringBuffer, "");
              localStringBuffer.append(Uri.encode(paramBundle.get(str).toString()));
            }
            else
            {
              paramDestination = new StringBuilder();
              paramDestination.append("Could not find ");
              paramDestination.append(str);
              paramDestination.append(" in ");
              paramDestination.append(paramBundle);
              paramDestination.append(" to fill data pattern ");
              paramDestination.append((String)localObject);
              throw new IllegalArgumentException(paramDestination.toString());
            }
          }
          localMatcher.appendTail(localStringBuffer);
          localIntent.setData(Uri.parse(localStringBuffer.toString()));
        }
      }
      boolean bool = paramExtras instanceof Extras;
      if (bool) {
        localIntent.addFlags(((Extras)paramExtras).getFlags());
      }
      if (!(this.mContext instanceof Activity)) {
        localIntent.addFlags(268435456);
      }
      if ((paramNavOptions != null) && (paramNavOptions.shouldLaunchSingleTop())) {
        localIntent.addFlags(536870912);
      }
      paramBundle = this.mHostActivity;
      int i = 0;
      int j;
      if (paramBundle != null)
      {
        paramBundle = paramBundle.getIntent();
        if (paramBundle != null)
        {
          j = paramBundle.getIntExtra("android-support-navigation:ActivityNavigator:current", 0);
          if (j != 0) {
            localIntent.putExtra("android-support-navigation:ActivityNavigator:source", j);
          }
        }
      }
      localIntent.putExtra("android-support-navigation:ActivityNavigator:current", paramDestination.getId());
      paramBundle = getContext().getResources();
      int k;
      if (paramNavOptions != null)
      {
        k = paramNavOptions.getPopEnterAnim();
        j = paramNavOptions.getPopExitAnim();
        if (((k != -1) && (paramBundle.getResourceTypeName(k).equals("animator"))) || ((j != -1) && (paramBundle.getResourceTypeName(j).equals("animator"))))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Activity destinations do not support Animator resource. Ignoring popEnter resource ");
          ((StringBuilder)localObject).append(paramBundle.getResourceName(k));
          ((StringBuilder)localObject).append(" and popExit resource ");
          ((StringBuilder)localObject).append(paramBundle.getResourceName(j));
          ((StringBuilder)localObject).append("when launching ");
          ((StringBuilder)localObject).append(paramDestination);
          Log.w("ActivityNavigator", ((StringBuilder)localObject).toString());
        }
        else
        {
          localIntent.putExtra("android-support-navigation:ActivityNavigator:popEnterAnim", k);
          localIntent.putExtra("android-support-navigation:ActivityNavigator:popExitAnim", j);
        }
      }
      if (bool)
      {
        paramExtras = ((Extras)paramExtras).getActivityOptions();
        if (paramExtras != null) {
          ContextCompat.startActivity(this.mContext, localIntent, paramExtras.toBundle());
        } else {
          this.mContext.startActivity(localIntent);
        }
      }
      else
      {
        this.mContext.startActivity(localIntent);
      }
      if ((paramNavOptions != null) && (this.mHostActivity != null))
      {
        j = paramNavOptions.getEnterAnim();
        k = paramNavOptions.getExitAnim();
        if ((j != -1) || (k != -1)) {
          if ((!paramBundle.getResourceTypeName(j).equals("animator")) && (!paramBundle.getResourceTypeName(k).equals("animator")))
          {
            if (j == -1) {
              j = 0;
            }
            if (k != -1) {
              i = k;
            }
            this.mHostActivity.overridePendingTransition(j, i);
          }
          else
          {
            paramNavOptions = new StringBuilder();
            paramNavOptions.append("Activity destinations do not support Animator resource. Ignoring enter resource ");
            paramNavOptions.append(paramBundle.getResourceName(j));
            paramNavOptions.append(" and exit resource ");
            paramNavOptions.append(paramBundle.getResourceName(k));
            paramNavOptions.append("when launching ");
            paramNavOptions.append(paramDestination);
            Log.w("ActivityNavigator", paramNavOptions.toString());
          }
        }
      }
      return null;
    }
    paramBundle = new StringBuilder();
    paramBundle.append("Destination ");
    paramBundle.append(paramDestination.getId());
    paramBundle.append(" does not have an Intent set.");
    throw new IllegalStateException(paramBundle.toString());
  }
  
  public boolean popBackStack()
  {
    Activity localActivity = this.mHostActivity;
    if (localActivity != null)
    {
      localActivity.finish();
      return true;
    }
    return false;
  }
  
  @NavDestination.ClassType(Activity.class)
  public static class Destination
    extends NavDestination
  {
    private String mDataPattern;
    private Intent mIntent;
    
    public Destination(@NonNull Navigator<? extends Destination> paramNavigator)
    {
      super();
    }
    
    public Destination(@NonNull NavigatorProvider paramNavigatorProvider)
    {
      this(paramNavigatorProvider.getNavigator(ActivityNavigator.class));
    }
    
    @Nullable
    public final String getAction()
    {
      Intent localIntent = this.mIntent;
      if (localIntent == null) {
        return null;
      }
      return localIntent.getAction();
    }
    
    @Nullable
    public final ComponentName getComponent()
    {
      Intent localIntent = this.mIntent;
      if (localIntent == null) {
        return null;
      }
      return localIntent.getComponent();
    }
    
    @Nullable
    public final Uri getData()
    {
      Intent localIntent = this.mIntent;
      if (localIntent == null) {
        return null;
      }
      return localIntent.getData();
    }
    
    @Nullable
    public final String getDataPattern()
    {
      return this.mDataPattern;
    }
    
    @Nullable
    public final Intent getIntent()
    {
      return this.mIntent;
    }
    
    @Nullable
    public final String getTargetPackage()
    {
      Intent localIntent = this.mIntent;
      if (localIntent == null) {
        return null;
      }
      return localIntent.getPackage();
    }
    
    @CallSuper
    public void onInflate(@NonNull Context paramContext, @NonNull AttributeSet paramAttributeSet)
    {
      super.onInflate(paramContext, paramAttributeSet);
      TypedArray localTypedArray = paramContext.getResources().obtainAttributes(paramAttributeSet, R.styleable.ActivityNavigator);
      String str = localTypedArray.getString(R.styleable.ActivityNavigator_targetPackage);
      paramAttributeSet = str;
      if (str != null) {
        paramAttributeSet = str.replace("${applicationId}", paramContext.getPackageName());
      }
      setTargetPackage(paramAttributeSet);
      str = localTypedArray.getString(R.styleable.ActivityNavigator_android_name);
      if (str != null)
      {
        paramAttributeSet = str;
        if (str.charAt(0) == '.')
        {
          paramAttributeSet = new StringBuilder();
          paramAttributeSet.append(paramContext.getPackageName());
          paramAttributeSet.append(str);
          paramAttributeSet = paramAttributeSet.toString();
        }
        setComponentName(new ComponentName(paramContext, paramAttributeSet));
      }
      setAction(localTypedArray.getString(R.styleable.ActivityNavigator_action));
      paramContext = localTypedArray.getString(R.styleable.ActivityNavigator_data);
      if (paramContext != null) {
        setData(Uri.parse(paramContext));
      }
      setDataPattern(localTypedArray.getString(R.styleable.ActivityNavigator_dataPattern));
      localTypedArray.recycle();
    }
    
    @NonNull
    public final Destination setAction(@Nullable String paramString)
    {
      if (this.mIntent == null) {
        this.mIntent = new Intent();
      }
      this.mIntent.setAction(paramString);
      return this;
    }
    
    @NonNull
    public final Destination setComponentName(@Nullable ComponentName paramComponentName)
    {
      if (this.mIntent == null) {
        this.mIntent = new Intent();
      }
      this.mIntent.setComponent(paramComponentName);
      return this;
    }
    
    @NonNull
    public final Destination setData(@Nullable Uri paramUri)
    {
      if (this.mIntent == null) {
        this.mIntent = new Intent();
      }
      this.mIntent.setData(paramUri);
      return this;
    }
    
    @NonNull
    public final Destination setDataPattern(@Nullable String paramString)
    {
      this.mDataPattern = paramString;
      return this;
    }
    
    @NonNull
    public final Destination setIntent(@Nullable Intent paramIntent)
    {
      this.mIntent = paramIntent;
      return this;
    }
    
    @NonNull
    public final Destination setTargetPackage(@Nullable String paramString)
    {
      if (this.mIntent == null) {
        this.mIntent = new Intent();
      }
      this.mIntent.setPackage(paramString);
      return this;
    }
    
    boolean supportsActions()
    {
      return false;
    }
    
    @NonNull
    public String toString()
    {
      Object localObject = getComponent();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(super.toString());
      if (localObject != null)
      {
        localStringBuilder.append(" class=");
        localStringBuilder.append(((ComponentName)localObject).getClassName());
      }
      else
      {
        localObject = getAction();
        if (localObject != null)
        {
          localStringBuilder.append(" action=");
          localStringBuilder.append((String)localObject);
        }
      }
      return localStringBuilder.toString();
    }
  }
  
  public static final class Extras
    implements Navigator.Extras
  {
    private final ActivityOptionsCompat mActivityOptions;
    private final int mFlags;
    
    Extras(int paramInt, @Nullable ActivityOptionsCompat paramActivityOptionsCompat)
    {
      this.mFlags = paramInt;
      this.mActivityOptions = paramActivityOptionsCompat;
    }
    
    @Nullable
    public ActivityOptionsCompat getActivityOptions()
    {
      return this.mActivityOptions;
    }
    
    public int getFlags()
    {
      return this.mFlags;
    }
    
    public static final class Builder
    {
      private ActivityOptionsCompat mActivityOptions;
      private int mFlags;
      
      @NonNull
      public Builder addFlags(int paramInt)
      {
        this.mFlags = (paramInt | this.mFlags);
        return this;
      }
      
      @NonNull
      public ActivityNavigator.Extras build()
      {
        return new ActivityNavigator.Extras(this.mFlags, this.mActivityOptions);
      }
      
      @NonNull
      public Builder setActivityOptions(@NonNull ActivityOptionsCompat paramActivityOptionsCompat)
      {
        this.mActivityOptions = paramActivityOptionsCompat;
        return this;
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\navigation\ActivityNavigator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */