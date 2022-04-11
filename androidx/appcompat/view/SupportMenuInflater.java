package androidx.appcompat.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.util.AttributeSet;
import android.util.Log;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R.styleable;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuItemWrapperICS;
import androidx.appcompat.widget.DrawableUtils;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.view.ActionProvider;
import androidx.core.view.MenuItemCompat;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class SupportMenuInflater
  extends MenuInflater
{
  static final Class<?>[] ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE;
  static final Class<?>[] ACTION_VIEW_CONSTRUCTOR_SIGNATURE;
  static final String LOG_TAG = "SupportMenuInflater";
  static final int NO_ID = 0;
  private static final String XML_GROUP = "group";
  private static final String XML_ITEM = "item";
  private static final String XML_MENU = "menu";
  final Object[] mActionProviderConstructorArguments;
  final Object[] mActionViewConstructorArguments;
  Context mContext;
  private Object mRealOwner;
  
  static
  {
    Class[] arrayOfClass = new Class[1];
    arrayOfClass[0] = Context.class;
    ACTION_VIEW_CONSTRUCTOR_SIGNATURE = arrayOfClass;
    ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE = arrayOfClass;
  }
  
  public SupportMenuInflater(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = paramContext;
    this.mActionViewConstructorArguments = arrayOfObject;
    this.mActionProviderConstructorArguments = arrayOfObject;
  }
  
  private Object findRealOwner(Object paramObject)
  {
    if ((paramObject instanceof Activity)) {
      return paramObject;
    }
    Object localObject = paramObject;
    if ((paramObject instanceof ContextWrapper)) {
      localObject = findRealOwner(((ContextWrapper)paramObject).getBaseContext());
    }
    return localObject;
  }
  
  private void parseMenu(XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Menu paramMenu)
    throws XmlPullParserException, IOException
  {
    MenuState localMenuState = new MenuState(paramMenu);
    int i = paramXmlPullParser.getEventType();
    do
    {
      if (i == 2)
      {
        paramMenu = paramXmlPullParser.getName();
        if (paramMenu.equals("menu"))
        {
          i = paramXmlPullParser.next();
          break;
        }
        paramXmlPullParser = new StringBuilder();
        paramXmlPullParser.append("Expecting menu, got ");
        paramXmlPullParser.append(paramMenu);
        throw new RuntimeException(paramXmlPullParser.toString());
      }
      j = paramXmlPullParser.next();
      i = j;
    } while (j != 1);
    i = j;
    Object localObject = null;
    int k = 0;
    int j = 0;
    while (k == 0) {
      if (i != 1)
      {
        int m;
        if (i != 2)
        {
          if (i != 3)
          {
            m = k;
            i = j;
            paramMenu = (Menu)localObject;
          }
          else
          {
            String str = paramXmlPullParser.getName();
            if ((j != 0) && (str.equals(localObject)))
            {
              paramMenu = null;
              i = 0;
              m = k;
            }
            else if (str.equals("group"))
            {
              localMenuState.resetGroup();
              m = k;
              i = j;
              paramMenu = (Menu)localObject;
            }
            else if (str.equals("item"))
            {
              m = k;
              i = j;
              paramMenu = (Menu)localObject;
              if (!localMenuState.hasAddedItem())
              {
                paramMenu = localMenuState.itemActionProvider;
                if ((paramMenu != null) && (paramMenu.hasSubMenu()))
                {
                  localMenuState.addSubMenuItem();
                  m = k;
                  i = j;
                  paramMenu = (Menu)localObject;
                }
                else
                {
                  localMenuState.addItem();
                  m = k;
                  i = j;
                  paramMenu = (Menu)localObject;
                }
              }
            }
            else
            {
              m = k;
              i = j;
              paramMenu = (Menu)localObject;
              if (str.equals("menu"))
              {
                m = 1;
                i = j;
                paramMenu = (Menu)localObject;
              }
            }
          }
        }
        else if (j != 0)
        {
          m = k;
          i = j;
          paramMenu = (Menu)localObject;
        }
        else
        {
          paramMenu = paramXmlPullParser.getName();
          if (paramMenu.equals("group"))
          {
            localMenuState.readGroup(paramAttributeSet);
            m = k;
            i = j;
            paramMenu = (Menu)localObject;
          }
          else if (paramMenu.equals("item"))
          {
            localMenuState.readItem(paramAttributeSet);
            m = k;
            i = j;
            paramMenu = (Menu)localObject;
          }
          else if (paramMenu.equals("menu"))
          {
            parseMenu(paramXmlPullParser, paramAttributeSet, localMenuState.addSubMenuItem());
            m = k;
            i = j;
            paramMenu = (Menu)localObject;
          }
          else
          {
            i = 1;
            m = k;
          }
        }
        int n = paramXmlPullParser.next();
        k = m;
        j = i;
        localObject = paramMenu;
        i = n;
      }
      else
      {
        throw new RuntimeException("Unexpected end of document");
      }
    }
  }
  
  Object getRealOwner()
  {
    if (this.mRealOwner == null) {
      this.mRealOwner = findRealOwner(this.mContext);
    }
    return this.mRealOwner;
  }
  
  /* Error */
  public void inflate(@androidx.annotation.LayoutRes int paramInt, Menu paramMenu)
  {
    // Byte code:
    //   0: aload_2
    //   1: instanceof 166
    //   4: ifne +10 -> 14
    //   7: aload_0
    //   8: iload_1
    //   9: aload_2
    //   10: invokespecial 168	android/view/MenuInflater:inflate	(ILandroid/view/Menu;)V
    //   13: return
    //   14: aconst_null
    //   15: astore_3
    //   16: aconst_null
    //   17: astore 4
    //   19: aconst_null
    //   20: astore 5
    //   22: aload_0
    //   23: getfield 58	androidx/appcompat/view/SupportMenuInflater:mContext	Landroid/content/Context;
    //   26: invokevirtual 172	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   29: iload_1
    //   30: invokevirtual 178	android/content/res/Resources:getLayout	(I)Landroid/content/res/XmlResourceParser;
    //   33: astore 6
    //   35: aload 6
    //   37: astore 5
    //   39: aload 6
    //   41: astore_3
    //   42: aload 6
    //   44: astore 4
    //   46: aload_0
    //   47: aload 6
    //   49: aload 6
    //   51: invokestatic 184	android/util/Xml:asAttributeSet	(Lorg/xmlpull/v1/XmlPullParser;)Landroid/util/AttributeSet;
    //   54: aload_2
    //   55: invokespecial 154	androidx/appcompat/view/SupportMenuInflater:parseMenu	(Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;Landroid/view/Menu;)V
    //   58: aload 6
    //   60: ifnull +10 -> 70
    //   63: aload 6
    //   65: invokeinterface 189 1 0
    //   70: return
    //   71: astore_2
    //   72: goto +54 -> 126
    //   75: astore 4
    //   77: aload_3
    //   78: astore 5
    //   80: new 191	android/view/InflateException
    //   83: astore_2
    //   84: aload_3
    //   85: astore 5
    //   87: aload_2
    //   88: ldc -63
    //   90: aload 4
    //   92: invokespecial 196	android/view/InflateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   95: aload_3
    //   96: astore 5
    //   98: aload_2
    //   99: athrow
    //   100: astore_2
    //   101: aload 4
    //   103: astore 5
    //   105: new 191	android/view/InflateException
    //   108: astore_3
    //   109: aload 4
    //   111: astore 5
    //   113: aload_3
    //   114: ldc -63
    //   116: aload_2
    //   117: invokespecial 196	android/view/InflateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   120: aload 4
    //   122: astore 5
    //   124: aload_3
    //   125: athrow
    //   126: aload 5
    //   128: ifnull +10 -> 138
    //   131: aload 5
    //   133: invokeinterface 189 1 0
    //   138: aload_2
    //   139: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	140	0	this	SupportMenuInflater
    //   0	140	1	paramInt	int
    //   0	140	2	paramMenu	Menu
    //   15	110	3	localObject1	Object
    //   17	28	4	localObject2	Object
    //   75	46	4	localIOException	IOException
    //   20	112	5	localObject3	Object
    //   33	31	6	localXmlResourceParser	android.content.res.XmlResourceParser
    // Exception table:
    //   from	to	target	type
    //   22	35	71	finally
    //   46	58	71	finally
    //   80	84	71	finally
    //   87	95	71	finally
    //   98	100	71	finally
    //   105	109	71	finally
    //   113	120	71	finally
    //   124	126	71	finally
    //   22	35	75	java/io/IOException
    //   46	58	75	java/io/IOException
    //   22	35	100	org/xmlpull/v1/XmlPullParserException
    //   46	58	100	org/xmlpull/v1/XmlPullParserException
  }
  
  private static class InflatedOnMenuItemClickListener
    implements MenuItem.OnMenuItemClickListener
  {
    private static final Class<?>[] PARAM_TYPES = { MenuItem.class };
    private Method mMethod;
    private Object mRealOwner;
    
    public InflatedOnMenuItemClickListener(Object paramObject, String paramString)
    {
      this.mRealOwner = paramObject;
      Class localClass = paramObject.getClass();
      try
      {
        this.mMethod = localClass.getMethod(paramString, PARAM_TYPES);
        return;
      }
      catch (Exception paramObject)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Couldn't resolve menu item onClick handler ");
        localStringBuilder.append(paramString);
        localStringBuilder.append(" in class ");
        localStringBuilder.append(localClass.getName());
        paramString = new InflateException(localStringBuilder.toString());
        paramString.initCause((Throwable)paramObject);
        throw paramString;
      }
    }
    
    public boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      try
      {
        if (this.mMethod.getReturnType() == Boolean.TYPE) {
          return ((Boolean)this.mMethod.invoke(this.mRealOwner, new Object[] { paramMenuItem })).booleanValue();
        }
        this.mMethod.invoke(this.mRealOwner, new Object[] { paramMenuItem });
        return true;
      }
      catch (Exception paramMenuItem)
      {
        throw new RuntimeException(paramMenuItem);
      }
    }
  }
  
  private class MenuState
  {
    private static final int defaultGroupId = 0;
    private static final int defaultItemCategory = 0;
    private static final int defaultItemCheckable = 0;
    private static final boolean defaultItemChecked = false;
    private static final boolean defaultItemEnabled = true;
    private static final int defaultItemId = 0;
    private static final int defaultItemOrder = 0;
    private static final boolean defaultItemVisible = true;
    private int groupCategory;
    private int groupCheckable;
    private boolean groupEnabled;
    private int groupId;
    private int groupOrder;
    private boolean groupVisible;
    ActionProvider itemActionProvider;
    private String itemActionProviderClassName;
    private String itemActionViewClassName;
    private int itemActionViewLayout;
    private boolean itemAdded;
    private int itemAlphabeticModifiers;
    private char itemAlphabeticShortcut;
    private int itemCategoryOrder;
    private int itemCheckable;
    private boolean itemChecked;
    private CharSequence itemContentDescription;
    private boolean itemEnabled;
    private int itemIconResId;
    private ColorStateList itemIconTintList = null;
    private PorterDuff.Mode itemIconTintMode = null;
    private int itemId;
    private String itemListenerMethodName;
    private int itemNumericModifiers;
    private char itemNumericShortcut;
    private int itemShowAsAction;
    private CharSequence itemTitle;
    private CharSequence itemTitleCondensed;
    private CharSequence itemTooltipText;
    private boolean itemVisible;
    private Menu menu;
    
    public MenuState(Menu paramMenu)
    {
      this.menu = paramMenu;
      resetGroup();
    }
    
    private char getShortcut(String paramString)
    {
      if (paramString == null) {
        return '\000';
      }
      return paramString.charAt(0);
    }
    
    private <T> T newInstance(String paramString, Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject)
    {
      try
      {
        paramArrayOfClass = Class.forName(paramString, false, SupportMenuInflater.this.mContext.getClassLoader()).getConstructor(paramArrayOfClass);
        paramArrayOfClass.setAccessible(true);
        paramArrayOfClass = paramArrayOfClass.newInstance(paramArrayOfObject);
        return paramArrayOfClass;
      }
      catch (Exception paramArrayOfClass)
      {
        paramArrayOfObject = new StringBuilder();
        paramArrayOfObject.append("Cannot instantiate class: ");
        paramArrayOfObject.append(paramString);
        Log.w("SupportMenuInflater", paramArrayOfObject.toString(), paramArrayOfClass);
      }
      return null;
    }
    
    private void setItem(MenuItem paramMenuItem)
    {
      Object localObject = paramMenuItem.setChecked(this.itemChecked).setVisible(this.itemVisible).setEnabled(this.itemEnabled);
      int i = this.itemCheckable;
      int j = 0;
      boolean bool;
      if (i >= 1) {
        bool = true;
      } else {
        bool = false;
      }
      ((MenuItem)localObject).setCheckable(bool).setTitleCondensed(this.itemTitleCondensed).setIcon(this.itemIconResId);
      i = this.itemShowAsAction;
      if (i >= 0) {
        paramMenuItem.setShowAsAction(i);
      }
      if (this.itemListenerMethodName != null) {
        if (!SupportMenuInflater.this.mContext.isRestricted()) {
          paramMenuItem.setOnMenuItemClickListener(new SupportMenuInflater.InflatedOnMenuItemClickListener(SupportMenuInflater.this.getRealOwner(), this.itemListenerMethodName));
        } else {
          throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
        }
      }
      if (this.itemCheckable >= 2) {
        if ((paramMenuItem instanceof MenuItemImpl)) {
          ((MenuItemImpl)paramMenuItem).setExclusiveCheckable(true);
        } else if ((paramMenuItem instanceof MenuItemWrapperICS)) {
          ((MenuItemWrapperICS)paramMenuItem).setExclusiveCheckable(true);
        }
      }
      localObject = this.itemActionViewClassName;
      if (localObject != null)
      {
        paramMenuItem.setActionView((View)newInstance((String)localObject, SupportMenuInflater.ACTION_VIEW_CONSTRUCTOR_SIGNATURE, SupportMenuInflater.this.mActionViewConstructorArguments));
        j = 1;
      }
      i = this.itemActionViewLayout;
      if (i > 0) {
        if (j == 0) {
          paramMenuItem.setActionView(i);
        } else {
          Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
        }
      }
      localObject = this.itemActionProvider;
      if (localObject != null) {
        MenuItemCompat.setActionProvider(paramMenuItem, (ActionProvider)localObject);
      }
      MenuItemCompat.setContentDescription(paramMenuItem, this.itemContentDescription);
      MenuItemCompat.setTooltipText(paramMenuItem, this.itemTooltipText);
      MenuItemCompat.setAlphabeticShortcut(paramMenuItem, this.itemAlphabeticShortcut, this.itemAlphabeticModifiers);
      MenuItemCompat.setNumericShortcut(paramMenuItem, this.itemNumericShortcut, this.itemNumericModifiers);
      localObject = this.itemIconTintMode;
      if (localObject != null) {
        MenuItemCompat.setIconTintMode(paramMenuItem, (PorterDuff.Mode)localObject);
      }
      localObject = this.itemIconTintList;
      if (localObject != null) {
        MenuItemCompat.setIconTintList(paramMenuItem, (ColorStateList)localObject);
      }
    }
    
    public void addItem()
    {
      this.itemAdded = true;
      setItem(this.menu.add(this.groupId, this.itemId, this.itemCategoryOrder, this.itemTitle));
    }
    
    public SubMenu addSubMenuItem()
    {
      this.itemAdded = true;
      SubMenu localSubMenu = this.menu.addSubMenu(this.groupId, this.itemId, this.itemCategoryOrder, this.itemTitle);
      setItem(localSubMenu.getItem());
      return localSubMenu;
    }
    
    public boolean hasAddedItem()
    {
      return this.itemAdded;
    }
    
    public void readGroup(AttributeSet paramAttributeSet)
    {
      paramAttributeSet = SupportMenuInflater.this.mContext.obtainStyledAttributes(paramAttributeSet, R.styleable.MenuGroup);
      this.groupId = paramAttributeSet.getResourceId(R.styleable.MenuGroup_android_id, 0);
      this.groupCategory = paramAttributeSet.getInt(R.styleable.MenuGroup_android_menuCategory, 0);
      this.groupOrder = paramAttributeSet.getInt(R.styleable.MenuGroup_android_orderInCategory, 0);
      this.groupCheckable = paramAttributeSet.getInt(R.styleable.MenuGroup_android_checkableBehavior, 0);
      this.groupVisible = paramAttributeSet.getBoolean(R.styleable.MenuGroup_android_visible, true);
      this.groupEnabled = paramAttributeSet.getBoolean(R.styleable.MenuGroup_android_enabled, true);
      paramAttributeSet.recycle();
    }
    
    public void readItem(AttributeSet paramAttributeSet)
    {
      paramAttributeSet = TintTypedArray.obtainStyledAttributes(SupportMenuInflater.this.mContext, paramAttributeSet, R.styleable.MenuItem);
      this.itemId = paramAttributeSet.getResourceId(R.styleable.MenuItem_android_id, 0);
      this.itemCategoryOrder = (paramAttributeSet.getInt(R.styleable.MenuItem_android_menuCategory, this.groupCategory) & 0xFFFF0000 | paramAttributeSet.getInt(R.styleable.MenuItem_android_orderInCategory, this.groupOrder) & 0xFFFF);
      this.itemTitle = paramAttributeSet.getText(R.styleable.MenuItem_android_title);
      this.itemTitleCondensed = paramAttributeSet.getText(R.styleable.MenuItem_android_titleCondensed);
      this.itemIconResId = paramAttributeSet.getResourceId(R.styleable.MenuItem_android_icon, 0);
      this.itemAlphabeticShortcut = getShortcut(paramAttributeSet.getString(R.styleable.MenuItem_android_alphabeticShortcut));
      this.itemAlphabeticModifiers = paramAttributeSet.getInt(R.styleable.MenuItem_alphabeticModifiers, 4096);
      this.itemNumericShortcut = getShortcut(paramAttributeSet.getString(R.styleable.MenuItem_android_numericShortcut));
      this.itemNumericModifiers = paramAttributeSet.getInt(R.styleable.MenuItem_numericModifiers, 4096);
      int i = R.styleable.MenuItem_android_checkable;
      if (paramAttributeSet.hasValue(i)) {
        this.itemCheckable = paramAttributeSet.getBoolean(i, false);
      } else {
        this.itemCheckable = this.groupCheckable;
      }
      this.itemChecked = paramAttributeSet.getBoolean(R.styleable.MenuItem_android_checked, false);
      this.itemVisible = paramAttributeSet.getBoolean(R.styleable.MenuItem_android_visible, this.groupVisible);
      this.itemEnabled = paramAttributeSet.getBoolean(R.styleable.MenuItem_android_enabled, this.groupEnabled);
      this.itemShowAsAction = paramAttributeSet.getInt(R.styleable.MenuItem_showAsAction, -1);
      this.itemListenerMethodName = paramAttributeSet.getString(R.styleable.MenuItem_android_onClick);
      this.itemActionViewLayout = paramAttributeSet.getResourceId(R.styleable.MenuItem_actionLayout, 0);
      this.itemActionViewClassName = paramAttributeSet.getString(R.styleable.MenuItem_actionViewClass);
      String str = paramAttributeSet.getString(R.styleable.MenuItem_actionProviderClass);
      this.itemActionProviderClassName = str;
      if (str != null) {
        i = 1;
      } else {
        i = 0;
      }
      if ((i != 0) && (this.itemActionViewLayout == 0) && (this.itemActionViewClassName == null))
      {
        this.itemActionProvider = ((ActionProvider)newInstance(str, SupportMenuInflater.ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE, SupportMenuInflater.this.mActionProviderConstructorArguments));
      }
      else
      {
        if (i != 0) {
          Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
        }
        this.itemActionProvider = null;
      }
      this.itemContentDescription = paramAttributeSet.getText(R.styleable.MenuItem_contentDescription);
      this.itemTooltipText = paramAttributeSet.getText(R.styleable.MenuItem_tooltipText);
      i = R.styleable.MenuItem_iconTintMode;
      if (paramAttributeSet.hasValue(i)) {
        this.itemIconTintMode = DrawableUtils.parseTintMode(paramAttributeSet.getInt(i, -1), this.itemIconTintMode);
      } else {
        this.itemIconTintMode = null;
      }
      i = R.styleable.MenuItem_iconTint;
      if (paramAttributeSet.hasValue(i)) {
        this.itemIconTintList = paramAttributeSet.getColorStateList(i);
      } else {
        this.itemIconTintList = null;
      }
      paramAttributeSet.recycle();
      this.itemAdded = false;
    }
    
    public void resetGroup()
    {
      this.groupId = 0;
      this.groupCategory = 0;
      this.groupOrder = 0;
      this.groupCheckable = 0;
      this.groupVisible = true;
      this.groupEnabled = true;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\appcompat\view\SupportMenuInflater.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */