package androidx.core.app;

import android.app.Notification;
import android.app.Notification.Action.Builder;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.graphics.drawable.Icon;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.widget.RemoteViews;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
class NotificationCompatBuilder
  implements NotificationBuilderWithBuilderAccessor
{
  private final List<Bundle> mActionExtrasList = new ArrayList();
  private RemoteViews mBigContentView;
  private final Notification.Builder mBuilder;
  private final NotificationCompat.Builder mBuilderCompat;
  private RemoteViews mContentView;
  private final Bundle mExtras = new Bundle();
  private int mGroupAlertBehavior;
  private RemoteViews mHeadsUpContentView;
  
  NotificationCompatBuilder(NotificationCompat.Builder paramBuilder)
  {
    this.mBuilderCompat = paramBuilder;
    int i = Build.VERSION.SDK_INT;
    if (i >= 26) {
      this.mBuilder = new Notification.Builder(paramBuilder.mContext, paramBuilder.mChannelId);
    } else {
      this.mBuilder = new Notification.Builder(paramBuilder.mContext);
    }
    Notification localNotification = paramBuilder.mNotification;
    Object localObject1 = this.mBuilder.setWhen(localNotification.when).setSmallIcon(localNotification.icon, localNotification.iconLevel).setContent(localNotification.contentView).setTicker(localNotification.tickerText, paramBuilder.mTickerView).setVibrate(localNotification.vibrate).setLights(localNotification.ledARGB, localNotification.ledOnMS, localNotification.ledOffMS);
    boolean bool;
    if ((localNotification.flags & 0x2) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    localObject1 = ((Notification.Builder)localObject1).setOngoing(bool);
    if ((localNotification.flags & 0x8) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    localObject1 = ((Notification.Builder)localObject1).setOnlyAlertOnce(bool);
    if ((localNotification.flags & 0x10) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    Object localObject2 = ((Notification.Builder)localObject1).setAutoCancel(bool).setDefaults(localNotification.defaults).setContentTitle(paramBuilder.mContentTitle).setContentText(paramBuilder.mContentText).setContentInfo(paramBuilder.mContentInfo).setContentIntent(paramBuilder.mContentIntent).setDeleteIntent(localNotification.deleteIntent);
    localObject1 = paramBuilder.mFullScreenIntent;
    if ((localNotification.flags & 0x80) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    ((Notification.Builder)localObject2).setFullScreenIntent((PendingIntent)localObject1, bool).setLargeIcon(paramBuilder.mLargeIcon).setNumber(paramBuilder.mNumber).setProgress(paramBuilder.mProgressMax, paramBuilder.mProgress, paramBuilder.mProgressIndeterminate);
    if (i < 21) {
      this.mBuilder.setSound(localNotification.sound, localNotification.audioStreamType);
    }
    if (i >= 16)
    {
      this.mBuilder.setSubText(paramBuilder.mSubText).setUsesChronometer(paramBuilder.mUseChronometer).setPriority(paramBuilder.mPriority);
      localObject1 = paramBuilder.mActions.iterator();
      while (((Iterator)localObject1).hasNext()) {
        addAction((NotificationCompat.Action)((Iterator)localObject1).next());
      }
      localObject1 = paramBuilder.mExtras;
      if (localObject1 != null) {
        this.mExtras.putAll((Bundle)localObject1);
      }
      if (Build.VERSION.SDK_INT < 20)
      {
        if (paramBuilder.mLocalOnly) {
          this.mExtras.putBoolean("android.support.localOnly", true);
        }
        localObject1 = paramBuilder.mGroupKey;
        if (localObject1 != null)
        {
          this.mExtras.putString("android.support.groupKey", (String)localObject1);
          if (paramBuilder.mGroupSummary) {
            this.mExtras.putBoolean("android.support.isGroupSummary", true);
          } else {
            this.mExtras.putBoolean("android.support.useSideChannel", true);
          }
        }
        localObject1 = paramBuilder.mSortKey;
        if (localObject1 != null) {
          this.mExtras.putString("android.support.sortKey", (String)localObject1);
        }
      }
      this.mContentView = paramBuilder.mContentView;
      this.mBigContentView = paramBuilder.mBigContentView;
    }
    i = Build.VERSION.SDK_INT;
    if (i >= 19)
    {
      this.mBuilder.setShowWhen(paramBuilder.mShowWhen);
      if (i < 21)
      {
        localObject1 = paramBuilder.mPeople;
        if ((localObject1 != null) && (!((ArrayList)localObject1).isEmpty()))
        {
          localObject2 = this.mExtras;
          localObject1 = paramBuilder.mPeople;
          ((Bundle)localObject2).putStringArray("android.people", (String[])((ArrayList)localObject1).toArray(new String[((ArrayList)localObject1).size()]));
        }
      }
    }
    if (i >= 20)
    {
      this.mBuilder.setLocalOnly(paramBuilder.mLocalOnly).setGroup(paramBuilder.mGroupKey).setGroupSummary(paramBuilder.mGroupSummary).setSortKey(paramBuilder.mSortKey);
      this.mGroupAlertBehavior = paramBuilder.mGroupAlertBehavior;
    }
    if (i >= 21)
    {
      this.mBuilder.setCategory(paramBuilder.mCategory).setColor(paramBuilder.mColor).setVisibility(paramBuilder.mVisibility).setPublicVersion(paramBuilder.mPublicVersion).setSound(localNotification.sound, localNotification.audioAttributes);
      localObject2 = paramBuilder.mPeople.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject1 = (String)((Iterator)localObject2).next();
        this.mBuilder.addPerson((String)localObject1);
      }
      this.mHeadsUpContentView = paramBuilder.mHeadsUpContentView;
      if (paramBuilder.mInvisibleActions.size() > 0)
      {
        localObject2 = paramBuilder.getExtras().getBundle("android.car.EXTENSIONS");
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new Bundle();
        }
        localObject2 = new Bundle();
        for (i = 0; i < paramBuilder.mInvisibleActions.size(); i++) {
          ((Bundle)localObject2).putBundle(Integer.toString(i), NotificationCompatJellybean.getBundleForAction((NotificationCompat.Action)paramBuilder.mInvisibleActions.get(i)));
        }
        ((Bundle)localObject1).putBundle("invisible_actions", (Bundle)localObject2);
        paramBuilder.getExtras().putBundle("android.car.EXTENSIONS", (Bundle)localObject1);
        this.mExtras.putBundle("android.car.EXTENSIONS", (Bundle)localObject1);
      }
    }
    i = Build.VERSION.SDK_INT;
    if (i >= 24)
    {
      this.mBuilder.setExtras(paramBuilder.mExtras).setRemoteInputHistory(paramBuilder.mRemoteInputHistory);
      localObject1 = paramBuilder.mContentView;
      if (localObject1 != null) {
        this.mBuilder.setCustomContentView((RemoteViews)localObject1);
      }
      localObject1 = paramBuilder.mBigContentView;
      if (localObject1 != null) {
        this.mBuilder.setCustomBigContentView((RemoteViews)localObject1);
      }
      localObject1 = paramBuilder.mHeadsUpContentView;
      if (localObject1 != null) {
        this.mBuilder.setCustomHeadsUpContentView((RemoteViews)localObject1);
      }
    }
    if (i >= 26)
    {
      this.mBuilder.setBadgeIconType(paramBuilder.mBadgeIcon).setShortcutId(paramBuilder.mShortcutId).setTimeoutAfter(paramBuilder.mTimeout).setGroupAlertBehavior(paramBuilder.mGroupAlertBehavior);
      if (paramBuilder.mColorizedSet) {
        this.mBuilder.setColorized(paramBuilder.mColorized);
      }
      if (!TextUtils.isEmpty(paramBuilder.mChannelId)) {
        this.mBuilder.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
      }
    }
    if (i >= 29)
    {
      this.mBuilder.setAllowSystemGeneratedContextualActions(paramBuilder.mAllowSystemGeneratedContextualActions);
      this.mBuilder.setBubbleMetadata(NotificationCompat.BubbleMetadata.toPlatform(paramBuilder.mBubbleMetadata));
    }
    if (paramBuilder.mSilent)
    {
      if (this.mBuilderCompat.mGroupSummary) {
        this.mGroupAlertBehavior = 2;
      } else {
        this.mGroupAlertBehavior = 1;
      }
      this.mBuilder.setVibrate(null);
      this.mBuilder.setSound(null);
      int j = localNotification.defaults & 0xFFFFFFFE;
      localNotification.defaults = j;
      j &= 0xFFFFFFFD;
      localNotification.defaults = j;
      this.mBuilder.setDefaults(j);
      if (i >= 26)
      {
        if (TextUtils.isEmpty(this.mBuilderCompat.mGroupKey)) {
          this.mBuilder.setGroup("silent");
        }
        this.mBuilder.setGroupAlertBehavior(this.mGroupAlertBehavior);
      }
    }
  }
  
  private void addAction(NotificationCompat.Action paramAction)
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 20)
    {
      Object localObject1 = paramAction.getIconCompat();
      int j = 0;
      if (i >= 23)
      {
        if (localObject1 != null) {
          localObject1 = ((IconCompat)localObject1).toIcon();
        } else {
          localObject1 = null;
        }
        localObject1 = new Notification.Action.Builder((Icon)localObject1, paramAction.getTitle(), paramAction.getActionIntent());
      }
      else
      {
        if (localObject1 != null) {
          i = ((IconCompat)localObject1).getResId();
        } else {
          i = 0;
        }
        localObject1 = new Notification.Action.Builder(i, paramAction.getTitle(), paramAction.getActionIntent());
      }
      Object localObject2;
      if (paramAction.getRemoteInputs() != null)
      {
        localObject2 = RemoteInput.fromCompat(paramAction.getRemoteInputs());
        int k = localObject2.length;
        for (i = j; i < k; i++) {
          ((Notification.Action.Builder)localObject1).addRemoteInput(localObject2[i]);
        }
      }
      if (paramAction.getExtras() != null) {
        localObject2 = new Bundle(paramAction.getExtras());
      } else {
        localObject2 = new Bundle();
      }
      ((Bundle)localObject2).putBoolean("android.support.allowGeneratedReplies", paramAction.getAllowGeneratedReplies());
      i = Build.VERSION.SDK_INT;
      if (i >= 24) {
        ((Notification.Action.Builder)localObject1).setAllowGeneratedReplies(paramAction.getAllowGeneratedReplies());
      }
      ((Bundle)localObject2).putInt("android.support.action.semanticAction", paramAction.getSemanticAction());
      if (i >= 28) {
        ((Notification.Action.Builder)localObject1).setSemanticAction(paramAction.getSemanticAction());
      }
      if (i >= 29) {
        ((Notification.Action.Builder)localObject1).setContextual(paramAction.isContextual());
      }
      ((Bundle)localObject2).putBoolean("android.support.action.showsUserInterface", paramAction.getShowsUserInterface());
      ((Notification.Action.Builder)localObject1).addExtras((Bundle)localObject2);
      this.mBuilder.addAction(((Notification.Action.Builder)localObject1).build());
    }
    else if (i >= 16)
    {
      this.mActionExtrasList.add(NotificationCompatJellybean.writeActionAndGetExtras(this.mBuilder, paramAction));
    }
  }
  
  private void removeSoundAndVibration(Notification paramNotification)
  {
    paramNotification.sound = null;
    paramNotification.vibrate = null;
    int i = paramNotification.defaults & 0xFFFFFFFE;
    paramNotification.defaults = i;
    paramNotification.defaults = (i & 0xFFFFFFFD);
  }
  
  public Notification build()
  {
    NotificationCompat.Style localStyle = this.mBuilderCompat.mStyle;
    if (localStyle != null) {
      localStyle.apply(this);
    }
    Object localObject;
    if (localStyle != null) {
      localObject = localStyle.makeContentView(this);
    } else {
      localObject = null;
    }
    Notification localNotification = buildInternal();
    if (localObject != null)
    {
      localNotification.contentView = ((RemoteViews)localObject);
    }
    else
    {
      localObject = this.mBuilderCompat.mContentView;
      if (localObject != null) {
        localNotification.contentView = ((RemoteViews)localObject);
      }
    }
    int i = Build.VERSION.SDK_INT;
    if ((i >= 16) && (localStyle != null))
    {
      localObject = localStyle.makeBigContentView(this);
      if (localObject != null) {
        localNotification.bigContentView = ((RemoteViews)localObject);
      }
    }
    if ((i >= 21) && (localStyle != null))
    {
      localObject = this.mBuilderCompat.mStyle.makeHeadsUpContentView(this);
      if (localObject != null) {
        localNotification.headsUpContentView = ((RemoteViews)localObject);
      }
    }
    if ((i >= 16) && (localStyle != null))
    {
      localObject = NotificationCompat.getExtras(localNotification);
      if (localObject != null) {
        localStyle.addCompatExtras((Bundle)localObject);
      }
    }
    return localNotification;
  }
  
  protected Notification buildInternal()
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 26) {
      return this.mBuilder.build();
    }
    Object localObject1;
    if (i >= 24)
    {
      localObject1 = this.mBuilder.build();
      if (this.mGroupAlertBehavior != 0)
      {
        if ((((Notification)localObject1).getGroup() != null) && ((((Notification)localObject1).flags & 0x200) != 0) && (this.mGroupAlertBehavior == 2)) {
          removeSoundAndVibration((Notification)localObject1);
        }
        if ((((Notification)localObject1).getGroup() != null) && ((((Notification)localObject1).flags & 0x200) == 0) && (this.mGroupAlertBehavior == 1)) {
          removeSoundAndVibration((Notification)localObject1);
        }
      }
      return (Notification)localObject1;
    }
    Object localObject2;
    if (i >= 21)
    {
      this.mBuilder.setExtras(this.mExtras);
      localObject1 = this.mBuilder.build();
      localObject2 = this.mContentView;
      if (localObject2 != null) {
        ((Notification)localObject1).contentView = ((RemoteViews)localObject2);
      }
      localObject2 = this.mBigContentView;
      if (localObject2 != null) {
        ((Notification)localObject1).bigContentView = ((RemoteViews)localObject2);
      }
      localObject2 = this.mHeadsUpContentView;
      if (localObject2 != null) {
        ((Notification)localObject1).headsUpContentView = ((RemoteViews)localObject2);
      }
      if (this.mGroupAlertBehavior != 0)
      {
        if ((((Notification)localObject1).getGroup() != null) && ((((Notification)localObject1).flags & 0x200) != 0) && (this.mGroupAlertBehavior == 2)) {
          removeSoundAndVibration((Notification)localObject1);
        }
        if ((((Notification)localObject1).getGroup() != null) && ((((Notification)localObject1).flags & 0x200) == 0) && (this.mGroupAlertBehavior == 1)) {
          removeSoundAndVibration((Notification)localObject1);
        }
      }
      return (Notification)localObject1;
    }
    if (i >= 20)
    {
      this.mBuilder.setExtras(this.mExtras);
      localObject1 = this.mBuilder.build();
      localObject2 = this.mContentView;
      if (localObject2 != null) {
        ((Notification)localObject1).contentView = ((RemoteViews)localObject2);
      }
      localObject2 = this.mBigContentView;
      if (localObject2 != null) {
        ((Notification)localObject1).bigContentView = ((RemoteViews)localObject2);
      }
      if (this.mGroupAlertBehavior != 0)
      {
        if ((((Notification)localObject1).getGroup() != null) && ((((Notification)localObject1).flags & 0x200) != 0) && (this.mGroupAlertBehavior == 2)) {
          removeSoundAndVibration((Notification)localObject1);
        }
        if ((((Notification)localObject1).getGroup() != null) && ((((Notification)localObject1).flags & 0x200) == 0) && (this.mGroupAlertBehavior == 1)) {
          removeSoundAndVibration((Notification)localObject1);
        }
      }
      return (Notification)localObject1;
    }
    if (i >= 19)
    {
      localObject1 = NotificationCompatJellybean.buildActionExtrasMap(this.mActionExtrasList);
      if (localObject1 != null) {
        this.mExtras.putSparseParcelableArray("android.support.actionExtras", (SparseArray)localObject1);
      }
      this.mBuilder.setExtras(this.mExtras);
      localObject1 = this.mBuilder.build();
      localObject2 = this.mContentView;
      if (localObject2 != null) {
        ((Notification)localObject1).contentView = ((RemoteViews)localObject2);
      }
      localObject2 = this.mBigContentView;
      if (localObject2 != null) {
        ((Notification)localObject1).bigContentView = ((RemoteViews)localObject2);
      }
      return (Notification)localObject1;
    }
    if (i >= 16)
    {
      localObject1 = this.mBuilder.build();
      Bundle localBundle1 = NotificationCompat.getExtras((Notification)localObject1);
      Bundle localBundle2 = new Bundle(this.mExtras);
      localObject2 = this.mExtras.keySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        if (localBundle1.containsKey(str)) {
          localBundle2.remove(str);
        }
      }
      localBundle1.putAll(localBundle2);
      localObject2 = NotificationCompatJellybean.buildActionExtrasMap(this.mActionExtrasList);
      if (localObject2 != null) {
        NotificationCompat.getExtras((Notification)localObject1).putSparseParcelableArray("android.support.actionExtras", (SparseArray)localObject2);
      }
      localObject2 = this.mContentView;
      if (localObject2 != null) {
        ((Notification)localObject1).contentView = ((RemoteViews)localObject2);
      }
      localObject2 = this.mBigContentView;
      if (localObject2 != null) {
        ((Notification)localObject1).bigContentView = ((RemoteViews)localObject2);
      }
      return (Notification)localObject1;
    }
    return this.mBuilder.getNotification();
  }
  
  public Notification.Builder getBuilder()
  {
    return this.mBuilder;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\app\NotificationCompatBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */