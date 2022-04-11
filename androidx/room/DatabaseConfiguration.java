package androidx.room;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Factory;
import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

public class DatabaseConfiguration
{
  public final boolean allowDestructiveMigrationOnDowngrade;
  public final boolean allowMainThreadQueries;
  @Nullable
  public final List<RoomDatabase.Callback> callbacks;
  @NonNull
  public final Context context;
  @Nullable
  public final String copyFromAssetPath;
  @Nullable
  public final File copyFromFile;
  public final RoomDatabase.JournalMode journalMode;
  private final Set<Integer> mMigrationNotRequiredFrom;
  @NonNull
  public final RoomDatabase.MigrationContainer migrationContainer;
  public final boolean multiInstanceInvalidation;
  @Nullable
  public final String name;
  @NonNull
  public final Executor queryExecutor;
  public final boolean requireMigration;
  @NonNull
  public final SupportSQLiteOpenHelper.Factory sqliteOpenHelperFactory;
  @NonNull
  public final Executor transactionExecutor;
  
  @Deprecated
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public DatabaseConfiguration(@NonNull Context paramContext, @Nullable String paramString, @NonNull SupportSQLiteOpenHelper.Factory paramFactory, @NonNull RoomDatabase.MigrationContainer paramMigrationContainer, @Nullable List<RoomDatabase.Callback> paramList, boolean paramBoolean1, RoomDatabase.JournalMode paramJournalMode, @NonNull Executor paramExecutor1, @NonNull Executor paramExecutor2, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, @Nullable Set<Integer> paramSet)
  {
    this(paramContext, paramString, paramFactory, paramMigrationContainer, paramList, paramBoolean1, paramJournalMode, paramExecutor1, paramExecutor2, paramBoolean2, paramBoolean3, paramBoolean4, paramSet, null, null);
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public DatabaseConfiguration(@NonNull Context paramContext, @Nullable String paramString1, @NonNull SupportSQLiteOpenHelper.Factory paramFactory, @NonNull RoomDatabase.MigrationContainer paramMigrationContainer, @Nullable List<RoomDatabase.Callback> paramList, boolean paramBoolean1, RoomDatabase.JournalMode paramJournalMode, @NonNull Executor paramExecutor1, @NonNull Executor paramExecutor2, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, @Nullable Set<Integer> paramSet, @Nullable String paramString2, @Nullable File paramFile)
  {
    this.sqliteOpenHelperFactory = paramFactory;
    this.context = paramContext;
    this.name = paramString1;
    this.migrationContainer = paramMigrationContainer;
    this.callbacks = paramList;
    this.allowMainThreadQueries = paramBoolean1;
    this.journalMode = paramJournalMode;
    this.queryExecutor = paramExecutor1;
    this.transactionExecutor = paramExecutor2;
    this.multiInstanceInvalidation = paramBoolean2;
    this.requireMigration = paramBoolean3;
    this.allowDestructiveMigrationOnDowngrade = paramBoolean4;
    this.mMigrationNotRequiredFrom = paramSet;
    this.copyFromAssetPath = paramString2;
    this.copyFromFile = paramFile;
  }
  
  @Deprecated
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public DatabaseConfiguration(@NonNull Context paramContext, @Nullable String paramString, @NonNull SupportSQLiteOpenHelper.Factory paramFactory, @NonNull RoomDatabase.MigrationContainer paramMigrationContainer, @Nullable List<RoomDatabase.Callback> paramList, boolean paramBoolean1, RoomDatabase.JournalMode paramJournalMode, @NonNull Executor paramExecutor, boolean paramBoolean2, @Nullable Set<Integer> paramSet)
  {
    this(paramContext, paramString, paramFactory, paramMigrationContainer, paramList, paramBoolean1, paramJournalMode, paramExecutor, paramExecutor, false, paramBoolean2, false, paramSet, null, null);
  }
  
  public boolean isMigrationRequired(int paramInt1, int paramInt2)
  {
    boolean bool1 = true;
    if (paramInt1 > paramInt2) {
      paramInt2 = 1;
    } else {
      paramInt2 = 0;
    }
    if ((paramInt2 != 0) && (this.allowDestructiveMigrationOnDowngrade)) {
      return false;
    }
    if (this.requireMigration)
    {
      Set localSet = this.mMigrationNotRequiredFrom;
      bool2 = bool1;
      if (localSet == null) {
        break label71;
      }
      if (!localSet.contains(Integer.valueOf(paramInt1)))
      {
        bool2 = bool1;
        break label71;
      }
    }
    boolean bool2 = false;
    label71:
    return bool2;
  }
  
  @Deprecated
  public boolean isMigrationRequiredFrom(int paramInt)
  {
    return isMigrationRequired(paramInt, paramInt + 1);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\room\DatabaseConfiguration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */