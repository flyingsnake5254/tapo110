package androidx.core.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.view.ActionProvider;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ShareActionProvider;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.core.util.Preconditions;
import java.util.ArrayList;

public final class ShareCompat
{
  public static final String EXTRA_CALLING_ACTIVITY = "androidx.core.app.EXTRA_CALLING_ACTIVITY";
  public static final String EXTRA_CALLING_ACTIVITY_INTEROP = "android.support.v4.app.EXTRA_CALLING_ACTIVITY";
  public static final String EXTRA_CALLING_PACKAGE = "androidx.core.app.EXTRA_CALLING_PACKAGE";
  public static final String EXTRA_CALLING_PACKAGE_INTEROP = "android.support.v4.app.EXTRA_CALLING_PACKAGE";
  private static final String HISTORY_FILENAME_PREFIX = ".sharecompat_";
  
  public static void configureMenuItem(@NonNull Menu paramMenu, @IdRes int paramInt, @NonNull IntentBuilder paramIntentBuilder)
  {
    paramMenu = paramMenu.findItem(paramInt);
    if (paramMenu != null)
    {
      configureMenuItem(paramMenu, paramIntentBuilder);
      return;
    }
    paramMenu = new StringBuilder();
    paramMenu.append("Could not find menu item with id ");
    paramMenu.append(paramInt);
    paramMenu.append(" in the supplied menu");
    throw new IllegalArgumentException(paramMenu.toString());
  }
  
  public static void configureMenuItem(@NonNull MenuItem paramMenuItem, @NonNull IntentBuilder paramIntentBuilder)
  {
    Object localObject = paramMenuItem.getActionProvider();
    if (!(localObject instanceof ShareActionProvider)) {
      localObject = new ShareActionProvider(paramIntentBuilder.getContext());
    } else {
      localObject = (ShareActionProvider)localObject;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(".sharecompat_");
    localStringBuilder.append(paramIntentBuilder.getContext().getClass().getName());
    ((ShareActionProvider)localObject).setShareHistoryFileName(localStringBuilder.toString());
    ((ShareActionProvider)localObject).setShareIntent(paramIntentBuilder.getIntent());
    paramMenuItem.setActionProvider((ActionProvider)localObject);
    if ((Build.VERSION.SDK_INT < 16) && (!paramMenuItem.hasSubMenu())) {
      paramMenuItem.setIntent(paramIntentBuilder.createChooserIntent());
    }
  }
  
  @Nullable
  public static ComponentName getCallingActivity(@NonNull Activity paramActivity)
  {
    Intent localIntent = paramActivity.getIntent();
    ComponentName localComponentName = paramActivity.getCallingActivity();
    paramActivity = localComponentName;
    if (localComponentName == null) {
      paramActivity = getCallingActivity(localIntent);
    }
    return paramActivity;
  }
  
  @Nullable
  static ComponentName getCallingActivity(@NonNull Intent paramIntent)
  {
    ComponentName localComponentName1 = (ComponentName)paramIntent.getParcelableExtra("androidx.core.app.EXTRA_CALLING_ACTIVITY");
    ComponentName localComponentName2 = localComponentName1;
    if (localComponentName1 == null) {
      localComponentName2 = (ComponentName)paramIntent.getParcelableExtra("android.support.v4.app.EXTRA_CALLING_ACTIVITY");
    }
    return localComponentName2;
  }
  
  @Nullable
  public static String getCallingPackage(@NonNull Activity paramActivity)
  {
    Intent localIntent = paramActivity.getIntent();
    String str = paramActivity.getCallingPackage();
    paramActivity = str;
    if (str == null)
    {
      paramActivity = str;
      if (localIntent != null) {
        paramActivity = getCallingPackage(localIntent);
      }
    }
    return paramActivity;
  }
  
  @Nullable
  static String getCallingPackage(@NonNull Intent paramIntent)
  {
    String str1 = paramIntent.getStringExtra("androidx.core.app.EXTRA_CALLING_PACKAGE");
    String str2 = str1;
    if (str1 == null) {
      str2 = paramIntent.getStringExtra("android.support.v4.app.EXTRA_CALLING_PACKAGE");
    }
    return str2;
  }
  
  public static class IntentBuilder
  {
    @Nullable
    private ArrayList<String> mBccAddresses;
    @Nullable
    private ArrayList<String> mCcAddresses;
    @Nullable
    private CharSequence mChooserTitle;
    @NonNull
    private final Context mContext;
    @NonNull
    private final Intent mIntent;
    @Nullable
    private ArrayList<Uri> mStreams;
    @Nullable
    private ArrayList<String> mToAddresses;
    
    private IntentBuilder(@NonNull Context paramContext, @Nullable ComponentName paramComponentName)
    {
      this.mContext = ((Context)Preconditions.checkNotNull(paramContext));
      Intent localIntent = new Intent().setAction("android.intent.action.SEND");
      this.mIntent = localIntent;
      localIntent.putExtra("androidx.core.app.EXTRA_CALLING_PACKAGE", paramContext.getPackageName());
      localIntent.putExtra("android.support.v4.app.EXTRA_CALLING_PACKAGE", paramContext.getPackageName());
      localIntent.putExtra("androidx.core.app.EXTRA_CALLING_ACTIVITY", paramComponentName);
      localIntent.putExtra("android.support.v4.app.EXTRA_CALLING_ACTIVITY", paramComponentName);
      localIntent.addFlags(524288);
    }
    
    private void combineArrayExtra(String paramString, ArrayList<String> paramArrayList)
    {
      String[] arrayOfString1 = this.mIntent.getStringArrayExtra(paramString);
      int i;
      if (arrayOfString1 != null) {
        i = arrayOfString1.length;
      } else {
        i = 0;
      }
      String[] arrayOfString2 = new String[paramArrayList.size() + i];
      paramArrayList.toArray(arrayOfString2);
      if (arrayOfString1 != null) {
        System.arraycopy(arrayOfString1, 0, arrayOfString2, paramArrayList.size(), i);
      }
      this.mIntent.putExtra(paramString, arrayOfString2);
    }
    
    private void combineArrayExtra(@Nullable String paramString, @NonNull String[] paramArrayOfString)
    {
      Intent localIntent = getIntent();
      String[] arrayOfString1 = localIntent.getStringArrayExtra(paramString);
      int i;
      if (arrayOfString1 != null) {
        i = arrayOfString1.length;
      } else {
        i = 0;
      }
      String[] arrayOfString2 = new String[paramArrayOfString.length + i];
      if (arrayOfString1 != null) {
        System.arraycopy(arrayOfString1, 0, arrayOfString2, 0, i);
      }
      System.arraycopy(paramArrayOfString, 0, arrayOfString2, i, paramArrayOfString.length);
      localIntent.putExtra(paramString, arrayOfString2);
    }
    
    @NonNull
    public static IntentBuilder from(@NonNull Activity paramActivity)
    {
      return from((Context)Preconditions.checkNotNull(paramActivity), paramActivity.getComponentName());
    }
    
    @NonNull
    private static IntentBuilder from(@NonNull Context paramContext, @Nullable ComponentName paramComponentName)
    {
      return new IntentBuilder(paramContext, paramComponentName);
    }
    
    @NonNull
    public IntentBuilder addEmailBcc(@NonNull String paramString)
    {
      if (this.mBccAddresses == null) {
        this.mBccAddresses = new ArrayList();
      }
      this.mBccAddresses.add(paramString);
      return this;
    }
    
    @NonNull
    public IntentBuilder addEmailBcc(@NonNull String[] paramArrayOfString)
    {
      combineArrayExtra("android.intent.extra.BCC", paramArrayOfString);
      return this;
    }
    
    @NonNull
    public IntentBuilder addEmailCc(@NonNull String paramString)
    {
      if (this.mCcAddresses == null) {
        this.mCcAddresses = new ArrayList();
      }
      this.mCcAddresses.add(paramString);
      return this;
    }
    
    @NonNull
    public IntentBuilder addEmailCc(@NonNull String[] paramArrayOfString)
    {
      combineArrayExtra("android.intent.extra.CC", paramArrayOfString);
      return this;
    }
    
    @NonNull
    public IntentBuilder addEmailTo(@NonNull String paramString)
    {
      if (this.mToAddresses == null) {
        this.mToAddresses = new ArrayList();
      }
      this.mToAddresses.add(paramString);
      return this;
    }
    
    @NonNull
    public IntentBuilder addEmailTo(@NonNull String[] paramArrayOfString)
    {
      combineArrayExtra("android.intent.extra.EMAIL", paramArrayOfString);
      return this;
    }
    
    @NonNull
    public IntentBuilder addStream(@NonNull Uri paramUri)
    {
      Uri localUri = (Uri)this.mIntent.getParcelableExtra("android.intent.extra.STREAM");
      ArrayList localArrayList = this.mStreams;
      if ((localArrayList == null) && (localUri == null)) {
        return setStream(paramUri);
      }
      if (localArrayList == null) {
        this.mStreams = new ArrayList();
      }
      if (localUri != null)
      {
        this.mIntent.removeExtra("android.intent.extra.STREAM");
        this.mStreams.add(localUri);
      }
      this.mStreams.add(paramUri);
      return this;
    }
    
    @NonNull
    public Intent createChooserIntent()
    {
      return Intent.createChooser(getIntent(), this.mChooserTitle);
    }
    
    @NonNull
    Context getContext()
    {
      return this.mContext;
    }
    
    @NonNull
    public Intent getIntent()
    {
      ArrayList localArrayList = this.mToAddresses;
      if (localArrayList != null)
      {
        combineArrayExtra("android.intent.extra.EMAIL", localArrayList);
        this.mToAddresses = null;
      }
      localArrayList = this.mCcAddresses;
      if (localArrayList != null)
      {
        combineArrayExtra("android.intent.extra.CC", localArrayList);
        this.mCcAddresses = null;
      }
      localArrayList = this.mBccAddresses;
      if (localArrayList != null)
      {
        combineArrayExtra("android.intent.extra.BCC", localArrayList);
        this.mBccAddresses = null;
      }
      localArrayList = this.mStreams;
      int i = 1;
      if ((localArrayList == null) || (localArrayList.size() <= 1)) {
        i = 0;
      }
      boolean bool = "android.intent.action.SEND_MULTIPLE".equals(this.mIntent.getAction());
      if ((i == 0) && (bool))
      {
        this.mIntent.setAction("android.intent.action.SEND");
        localArrayList = this.mStreams;
        if ((localArrayList != null) && (!localArrayList.isEmpty())) {
          this.mIntent.putExtra("android.intent.extra.STREAM", (Parcelable)this.mStreams.get(0));
        } else {
          this.mIntent.removeExtra("android.intent.extra.STREAM");
        }
        this.mStreams = null;
      }
      if ((i != 0) && (!bool))
      {
        this.mIntent.setAction("android.intent.action.SEND_MULTIPLE");
        localArrayList = this.mStreams;
        if ((localArrayList != null) && (!localArrayList.isEmpty())) {
          this.mIntent.putParcelableArrayListExtra("android.intent.extra.STREAM", this.mStreams);
        } else {
          this.mIntent.removeExtra("android.intent.extra.STREAM");
        }
      }
      return this.mIntent;
    }
    
    @NonNull
    public IntentBuilder setChooserTitle(@StringRes int paramInt)
    {
      return setChooserTitle(this.mContext.getText(paramInt));
    }
    
    @NonNull
    public IntentBuilder setChooserTitle(@Nullable CharSequence paramCharSequence)
    {
      this.mChooserTitle = paramCharSequence;
      return this;
    }
    
    @NonNull
    public IntentBuilder setEmailBcc(@Nullable String[] paramArrayOfString)
    {
      this.mIntent.putExtra("android.intent.extra.BCC", paramArrayOfString);
      return this;
    }
    
    @NonNull
    public IntentBuilder setEmailCc(@Nullable String[] paramArrayOfString)
    {
      this.mIntent.putExtra("android.intent.extra.CC", paramArrayOfString);
      return this;
    }
    
    @NonNull
    public IntentBuilder setEmailTo(@Nullable String[] paramArrayOfString)
    {
      if (this.mToAddresses != null) {
        this.mToAddresses = null;
      }
      this.mIntent.putExtra("android.intent.extra.EMAIL", paramArrayOfString);
      return this;
    }
    
    @NonNull
    public IntentBuilder setHtmlText(@Nullable String paramString)
    {
      this.mIntent.putExtra("android.intent.extra.HTML_TEXT", paramString);
      if (!this.mIntent.hasExtra("android.intent.extra.TEXT")) {
        setText(Html.fromHtml(paramString));
      }
      return this;
    }
    
    @NonNull
    public IntentBuilder setStream(@Nullable Uri paramUri)
    {
      if (!"android.intent.action.SEND".equals(this.mIntent.getAction())) {
        this.mIntent.setAction("android.intent.action.SEND");
      }
      this.mStreams = null;
      this.mIntent.putExtra("android.intent.extra.STREAM", paramUri);
      return this;
    }
    
    @NonNull
    public IntentBuilder setSubject(@Nullable String paramString)
    {
      this.mIntent.putExtra("android.intent.extra.SUBJECT", paramString);
      return this;
    }
    
    @NonNull
    public IntentBuilder setText(@Nullable CharSequence paramCharSequence)
    {
      this.mIntent.putExtra("android.intent.extra.TEXT", paramCharSequence);
      return this;
    }
    
    @NonNull
    public IntentBuilder setType(@Nullable String paramString)
    {
      this.mIntent.setType(paramString);
      return this;
    }
    
    public void startChooser()
    {
      this.mContext.startActivity(createChooserIntent());
    }
  }
  
  public static class IntentReader
  {
    private static final String TAG = "IntentReader";
    @Nullable
    private final ComponentName mCallingActivity;
    @Nullable
    private final String mCallingPackage;
    @NonNull
    private final Context mContext;
    @NonNull
    private final Intent mIntent;
    @Nullable
    private ArrayList<Uri> mStreams;
    
    private IntentReader(@NonNull Context paramContext, @NonNull Intent paramIntent)
    {
      this.mContext = ((Context)Preconditions.checkNotNull(paramContext));
      this.mIntent = ((Intent)Preconditions.checkNotNull(paramIntent));
      this.mCallingPackage = ShareCompat.getCallingPackage(paramIntent);
      this.mCallingActivity = ShareCompat.getCallingActivity(paramIntent);
    }
    
    @NonNull
    public static IntentReader from(@NonNull Activity paramActivity)
    {
      return from((Context)Preconditions.checkNotNull(paramActivity), paramActivity.getIntent());
    }
    
    @NonNull
    private static IntentReader from(@NonNull Context paramContext, @NonNull Intent paramIntent)
    {
      return new IntentReader(paramContext, paramIntent);
    }
    
    private static void withinStyle(StringBuilder paramStringBuilder, CharSequence paramCharSequence, int paramInt1, int paramInt2)
    {
      while (paramInt1 < paramInt2)
      {
        char c = paramCharSequence.charAt(paramInt1);
        if (c == '<')
        {
          paramStringBuilder.append("&lt;");
        }
        else if (c == '>')
        {
          paramStringBuilder.append("&gt;");
        }
        else if (c == '&')
        {
          paramStringBuilder.append("&amp;");
        }
        else if ((c <= '~') && (c >= ' '))
        {
          if (c == ' ')
          {
            for (;;)
            {
              int i = paramInt1 + 1;
              if ((i >= paramInt2) || (paramCharSequence.charAt(i) != ' ')) {
                break;
              }
              paramStringBuilder.append("&nbsp;");
              paramInt1 = i;
            }
            paramStringBuilder.append(' ');
          }
          else
          {
            paramStringBuilder.append(c);
          }
        }
        else
        {
          paramStringBuilder.append("&#");
          paramStringBuilder.append(c);
          paramStringBuilder.append(";");
        }
        paramInt1++;
      }
    }
    
    @Nullable
    public ComponentName getCallingActivity()
    {
      return this.mCallingActivity;
    }
    
    @Nullable
    public Drawable getCallingActivityIcon()
    {
      if (this.mCallingActivity == null) {
        return null;
      }
      Object localObject = this.mContext.getPackageManager();
      try
      {
        localObject = ((PackageManager)localObject).getActivityIcon(this.mCallingActivity);
        return (Drawable)localObject;
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        Log.e("IntentReader", "Could not retrieve icon for calling activity", localNameNotFoundException);
      }
      return null;
    }
    
    @Nullable
    public Drawable getCallingApplicationIcon()
    {
      if (this.mCallingPackage == null) {
        return null;
      }
      Object localObject = this.mContext.getPackageManager();
      try
      {
        localObject = ((PackageManager)localObject).getApplicationIcon(this.mCallingPackage);
        return (Drawable)localObject;
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        Log.e("IntentReader", "Could not retrieve icon for calling application", localNameNotFoundException);
      }
      return null;
    }
    
    @Nullable
    public CharSequence getCallingApplicationLabel()
    {
      if (this.mCallingPackage == null) {
        return null;
      }
      Object localObject = this.mContext.getPackageManager();
      try
      {
        localObject = ((PackageManager)localObject).getApplicationLabel(((PackageManager)localObject).getApplicationInfo(this.mCallingPackage, 0));
        return (CharSequence)localObject;
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        Log.e("IntentReader", "Could not retrieve label for calling application", localNameNotFoundException);
      }
      return null;
    }
    
    @Nullable
    public String getCallingPackage()
    {
      return this.mCallingPackage;
    }
    
    @Nullable
    public String[] getEmailBcc()
    {
      return this.mIntent.getStringArrayExtra("android.intent.extra.BCC");
    }
    
    @Nullable
    public String[] getEmailCc()
    {
      return this.mIntent.getStringArrayExtra("android.intent.extra.CC");
    }
    
    @Nullable
    public String[] getEmailTo()
    {
      return this.mIntent.getStringArrayExtra("android.intent.extra.EMAIL");
    }
    
    @Nullable
    public String getHtmlText()
    {
      String str = this.mIntent.getStringExtra("android.intent.extra.HTML_TEXT");
      Object localObject = str;
      if (str == null)
      {
        CharSequence localCharSequence = getText();
        if ((localCharSequence instanceof Spanned))
        {
          localObject = Html.toHtml((Spanned)localCharSequence);
        }
        else
        {
          localObject = str;
          if (localCharSequence != null) {
            if (Build.VERSION.SDK_INT >= 16)
            {
              localObject = Html.escapeHtml(localCharSequence);
            }
            else
            {
              localObject = new StringBuilder();
              withinStyle((StringBuilder)localObject, localCharSequence, 0, localCharSequence.length());
              localObject = ((StringBuilder)localObject).toString();
            }
          }
        }
      }
      return (String)localObject;
    }
    
    @Nullable
    public Uri getStream()
    {
      return (Uri)this.mIntent.getParcelableExtra("android.intent.extra.STREAM");
    }
    
    @Nullable
    public Uri getStream(int paramInt)
    {
      if ((this.mStreams == null) && (isMultipleShare())) {
        this.mStreams = this.mIntent.getParcelableArrayListExtra("android.intent.extra.STREAM");
      }
      Object localObject = this.mStreams;
      if (localObject != null) {
        return (Uri)((ArrayList)localObject).get(paramInt);
      }
      if (paramInt == 0) {
        return (Uri)this.mIntent.getParcelableExtra("android.intent.extra.STREAM");
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Stream items available: ");
      ((StringBuilder)localObject).append(getStreamCount());
      ((StringBuilder)localObject).append(" index requested: ");
      ((StringBuilder)localObject).append(paramInt);
      throw new IndexOutOfBoundsException(((StringBuilder)localObject).toString());
    }
    
    public int getStreamCount()
    {
      if ((this.mStreams == null) && (isMultipleShare())) {
        this.mStreams = this.mIntent.getParcelableArrayListExtra("android.intent.extra.STREAM");
      }
      ArrayList localArrayList = this.mStreams;
      if (localArrayList != null) {
        return localArrayList.size();
      }
      return this.mIntent.hasExtra("android.intent.extra.STREAM");
    }
    
    @Nullable
    public String getSubject()
    {
      return this.mIntent.getStringExtra("android.intent.extra.SUBJECT");
    }
    
    @Nullable
    public CharSequence getText()
    {
      return this.mIntent.getCharSequenceExtra("android.intent.extra.TEXT");
    }
    
    @Nullable
    public String getType()
    {
      return this.mIntent.getType();
    }
    
    public boolean isMultipleShare()
    {
      return "android.intent.action.SEND_MULTIPLE".equals(this.mIntent.getAction());
    }
    
    public boolean isShareIntent()
    {
      String str = this.mIntent.getAction();
      boolean bool;
      if ((!"android.intent.action.SEND".equals(str)) && (!"android.intent.action.SEND_MULTIPLE".equals(str))) {
        bool = false;
      } else {
        bool = true;
      }
      return bool;
    }
    
    public boolean isSingleShare()
    {
      return "android.intent.action.SEND".equals(this.mIntent.getAction());
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\app\ShareCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */