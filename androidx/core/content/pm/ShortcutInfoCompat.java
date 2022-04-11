package androidx.core.content.pm;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutInfo.Builder;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.PersistableBundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.graphics.drawable.IconCompat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ShortcutInfoCompat
{
  private static final String EXTRA_LONG_LIVED = "extraLongLived";
  private static final String EXTRA_PERSON_ = "extraPerson_";
  private static final String EXTRA_PERSON_COUNT = "extraPersonCount";
  ComponentName mActivity;
  Set<String> mCategories;
  Context mContext;
  CharSequence mDisabledMessage;
  IconCompat mIcon;
  String mId;
  Intent[] mIntents;
  boolean mIsAlwaysBadged;
  boolean mIsLongLived;
  CharSequence mLabel;
  CharSequence mLongLabel;
  androidx.core.app.Person[] mPersons;
  int mRank;
  
  @RequiresApi(22)
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  private PersistableBundle buildLegacyExtrasBundle()
  {
    PersistableBundle localPersistableBundle = new PersistableBundle();
    Object localObject = this.mPersons;
    if ((localObject != null) && (localObject.length > 0))
    {
      localPersistableBundle.putInt("extraPersonCount", localObject.length);
      int j;
      for (int i = 0; i < this.mPersons.length; i = j)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("extraPerson_");
        j = i + 1;
        ((StringBuilder)localObject).append(j);
        localPersistableBundle.putPersistableBundle(((StringBuilder)localObject).toString(), this.mPersons[i].toPersistableBundle());
      }
    }
    localPersistableBundle.putBoolean("extraLongLived", this.mIsLongLived);
    return localPersistableBundle;
  }
  
  @RequiresApi(25)
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  @VisibleForTesting
  static boolean getLongLivedFromExtra(@NonNull PersistableBundle paramPersistableBundle)
  {
    if ((paramPersistableBundle != null) && (paramPersistableBundle.containsKey("extraLongLived"))) {
      return paramPersistableBundle.getBoolean("extraLongLived");
    }
    return false;
  }
  
  @Nullable
  @RequiresApi(25)
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  @VisibleForTesting
  static androidx.core.app.Person[] getPersonsFromExtra(@NonNull PersistableBundle paramPersistableBundle)
  {
    if ((paramPersistableBundle != null) && (paramPersistableBundle.containsKey("extraPersonCount")))
    {
      int i = paramPersistableBundle.getInt("extraPersonCount");
      androidx.core.app.Person[] arrayOfPerson = new androidx.core.app.Person[i];
      int k;
      for (int j = 0; j < i; j = k)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("extraPerson_");
        k = j + 1;
        localStringBuilder.append(k);
        arrayOfPerson[j] = androidx.core.app.Person.fromPersistableBundle(paramPersistableBundle.getPersistableBundle(localStringBuilder.toString()));
      }
      return arrayOfPerson;
    }
    return null;
  }
  
  Intent addToIntent(Intent paramIntent)
  {
    Object localObject1 = this.mIntents;
    paramIntent.putExtra("android.intent.extra.shortcut.INTENT", localObject1[(localObject1.length - 1)]).putExtra("android.intent.extra.shortcut.NAME", this.mLabel.toString());
    if (this.mIcon != null)
    {
      Object localObject3 = null;
      Object localObject4 = null;
      if (this.mIsAlwaysBadged)
      {
        PackageManager localPackageManager = this.mContext.getPackageManager();
        localObject3 = this.mActivity;
        localObject1 = localObject4;
        Object localObject2;
        if (localObject3 != null) {
          try
          {
            localObject1 = localPackageManager.getActivityIcon((ComponentName)localObject3);
          }
          catch (PackageManager.NameNotFoundException localNameNotFoundException)
          {
            localObject2 = localObject4;
          }
        }
        localObject3 = localObject2;
        if (localObject2 == null) {
          localObject3 = this.mContext.getApplicationInfo().loadIcon(localPackageManager);
        }
      }
      this.mIcon.addToShortcutIntent(paramIntent, (Drawable)localObject3, this.mContext);
    }
    return paramIntent;
  }
  
  @Nullable
  public ComponentName getActivity()
  {
    return this.mActivity;
  }
  
  @Nullable
  public Set<String> getCategories()
  {
    return this.mCategories;
  }
  
  @Nullable
  public CharSequence getDisabledMessage()
  {
    return this.mDisabledMessage;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public IconCompat getIcon()
  {
    return this.mIcon;
  }
  
  @NonNull
  public String getId()
  {
    return this.mId;
  }
  
  @NonNull
  public Intent getIntent()
  {
    Intent[] arrayOfIntent = this.mIntents;
    return arrayOfIntent[(arrayOfIntent.length - 1)];
  }
  
  @NonNull
  public Intent[] getIntents()
  {
    Intent[] arrayOfIntent = this.mIntents;
    return (Intent[])Arrays.copyOf(arrayOfIntent, arrayOfIntent.length);
  }
  
  @Nullable
  public CharSequence getLongLabel()
  {
    return this.mLongLabel;
  }
  
  public int getRank()
  {
    return this.mRank;
  }
  
  @NonNull
  public CharSequence getShortLabel()
  {
    return this.mLabel;
  }
  
  @RequiresApi(25)
  public ShortcutInfo toShortcutInfo()
  {
    ShortcutInfo.Builder localBuilder = new ShortcutInfo.Builder(this.mContext, this.mId).setShortLabel(this.mLabel).setIntents(this.mIntents);
    Object localObject = this.mIcon;
    if (localObject != null) {
      localBuilder.setIcon(((IconCompat)localObject).toIcon(this.mContext));
    }
    if (!TextUtils.isEmpty(this.mLongLabel)) {
      localBuilder.setLongLabel(this.mLongLabel);
    }
    if (!TextUtils.isEmpty(this.mDisabledMessage)) {
      localBuilder.setDisabledMessage(this.mDisabledMessage);
    }
    localObject = this.mActivity;
    if (localObject != null) {
      localBuilder.setActivity((ComponentName)localObject);
    }
    localObject = this.mCategories;
    if (localObject != null) {
      localBuilder.setCategories((Set)localObject);
    }
    localBuilder.setRank(this.mRank);
    if (Build.VERSION.SDK_INT >= 29)
    {
      localObject = this.mPersons;
      if ((localObject != null) && (localObject.length > 0))
      {
        int i = localObject.length;
        localObject = new android.app.Person[i];
        for (int j = 0; j < i; j++) {
          localObject[j] = this.mPersons[j].toAndroidPerson();
        }
        localBuilder.setPersons((android.app.Person[])localObject);
      }
      localBuilder.setLongLived(this.mIsLongLived);
    }
    else
    {
      localBuilder.setExtras(buildLegacyExtrasBundle());
    }
    return localBuilder.build();
  }
  
  public static class Builder
  {
    private final ShortcutInfoCompat mInfo;
    
    @RequiresApi(25)
    @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public Builder(@NonNull Context paramContext, @NonNull ShortcutInfo paramShortcutInfo)
    {
      ShortcutInfoCompat localShortcutInfoCompat = new ShortcutInfoCompat();
      this.mInfo = localShortcutInfoCompat;
      localShortcutInfoCompat.mContext = paramContext;
      localShortcutInfoCompat.mId = paramShortcutInfo.getId();
      paramContext = paramShortcutInfo.getIntents();
      localShortcutInfoCompat.mIntents = ((Intent[])Arrays.copyOf(paramContext, paramContext.length));
      localShortcutInfoCompat.mActivity = paramShortcutInfo.getActivity();
      localShortcutInfoCompat.mLabel = paramShortcutInfo.getShortLabel();
      localShortcutInfoCompat.mLongLabel = paramShortcutInfo.getLongLabel();
      localShortcutInfoCompat.mDisabledMessage = paramShortcutInfo.getDisabledMessage();
      localShortcutInfoCompat.mCategories = paramShortcutInfo.getCategories();
      localShortcutInfoCompat.mPersons = ShortcutInfoCompat.getPersonsFromExtra(paramShortcutInfo.getExtras());
      localShortcutInfoCompat.mRank = paramShortcutInfo.getRank();
    }
    
    public Builder(@NonNull Context paramContext, @NonNull String paramString)
    {
      ShortcutInfoCompat localShortcutInfoCompat = new ShortcutInfoCompat();
      this.mInfo = localShortcutInfoCompat;
      localShortcutInfoCompat.mContext = paramContext;
      localShortcutInfoCompat.mId = paramString;
    }
    
    @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public Builder(@NonNull ShortcutInfoCompat paramShortcutInfoCompat)
    {
      ShortcutInfoCompat localShortcutInfoCompat = new ShortcutInfoCompat();
      this.mInfo = localShortcutInfoCompat;
      localShortcutInfoCompat.mContext = paramShortcutInfoCompat.mContext;
      localShortcutInfoCompat.mId = paramShortcutInfoCompat.mId;
      Object localObject = paramShortcutInfoCompat.mIntents;
      localShortcutInfoCompat.mIntents = ((Intent[])Arrays.copyOf((Object[])localObject, localObject.length));
      localShortcutInfoCompat.mActivity = paramShortcutInfoCompat.mActivity;
      localShortcutInfoCompat.mLabel = paramShortcutInfoCompat.mLabel;
      localShortcutInfoCompat.mLongLabel = paramShortcutInfoCompat.mLongLabel;
      localShortcutInfoCompat.mDisabledMessage = paramShortcutInfoCompat.mDisabledMessage;
      localShortcutInfoCompat.mIcon = paramShortcutInfoCompat.mIcon;
      localShortcutInfoCompat.mIsAlwaysBadged = paramShortcutInfoCompat.mIsAlwaysBadged;
      localShortcutInfoCompat.mIsLongLived = paramShortcutInfoCompat.mIsLongLived;
      localShortcutInfoCompat.mRank = paramShortcutInfoCompat.mRank;
      localObject = paramShortcutInfoCompat.mPersons;
      if (localObject != null) {
        localShortcutInfoCompat.mPersons = ((androidx.core.app.Person[])Arrays.copyOf((Object[])localObject, localObject.length));
      }
      if (paramShortcutInfoCompat.mCategories != null) {
        localShortcutInfoCompat.mCategories = new HashSet(paramShortcutInfoCompat.mCategories);
      }
    }
    
    @NonNull
    public ShortcutInfoCompat build()
    {
      if (!TextUtils.isEmpty(this.mInfo.mLabel))
      {
        ShortcutInfoCompat localShortcutInfoCompat = this.mInfo;
        Intent[] arrayOfIntent = localShortcutInfoCompat.mIntents;
        if ((arrayOfIntent != null) && (arrayOfIntent.length != 0)) {
          return localShortcutInfoCompat;
        }
        throw new IllegalArgumentException("Shortcut must have an intent");
      }
      throw new IllegalArgumentException("Shortcut must have a non-empty label");
    }
    
    @NonNull
    public Builder setActivity(@NonNull ComponentName paramComponentName)
    {
      this.mInfo.mActivity = paramComponentName;
      return this;
    }
    
    @NonNull
    public Builder setAlwaysBadged()
    {
      this.mInfo.mIsAlwaysBadged = true;
      return this;
    }
    
    @NonNull
    public Builder setCategories(@NonNull Set<String> paramSet)
    {
      this.mInfo.mCategories = paramSet;
      return this;
    }
    
    @NonNull
    public Builder setDisabledMessage(@NonNull CharSequence paramCharSequence)
    {
      this.mInfo.mDisabledMessage = paramCharSequence;
      return this;
    }
    
    @NonNull
    public Builder setIcon(IconCompat paramIconCompat)
    {
      this.mInfo.mIcon = paramIconCompat;
      return this;
    }
    
    @NonNull
    public Builder setIntent(@NonNull Intent paramIntent)
    {
      return setIntents(new Intent[] { paramIntent });
    }
    
    @NonNull
    public Builder setIntents(@NonNull Intent[] paramArrayOfIntent)
    {
      this.mInfo.mIntents = paramArrayOfIntent;
      return this;
    }
    
    @NonNull
    public Builder setLongLabel(@NonNull CharSequence paramCharSequence)
    {
      this.mInfo.mLongLabel = paramCharSequence;
      return this;
    }
    
    @Deprecated
    @NonNull
    public Builder setLongLived()
    {
      this.mInfo.mIsLongLived = true;
      return this;
    }
    
    @NonNull
    public Builder setLongLived(boolean paramBoolean)
    {
      this.mInfo.mIsLongLived = paramBoolean;
      return this;
    }
    
    @NonNull
    public Builder setPerson(@NonNull androidx.core.app.Person paramPerson)
    {
      return setPersons(new androidx.core.app.Person[] { paramPerson });
    }
    
    @NonNull
    public Builder setPersons(@NonNull androidx.core.app.Person[] paramArrayOfPerson)
    {
      this.mInfo.mPersons = paramArrayOfPerson;
      return this;
    }
    
    @NonNull
    public Builder setRank(int paramInt)
    {
      this.mInfo.mRank = paramInt;
      return this;
    }
    
    @NonNull
    public Builder setShortLabel(@NonNull CharSequence paramCharSequence)
    {
      this.mInfo.mLabel = paramCharSequence;
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\content\pm\ShortcutInfoCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */