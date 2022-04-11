package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.content.UriMatcher;
import android.net.Uri;
import android.provider.ContactsContract.Contacts;
import androidx.annotation.NonNull;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class n
  extends l<InputStream>
{
  private static final UriMatcher q;
  
  static
  {
    UriMatcher localUriMatcher = new UriMatcher(-1);
    q = localUriMatcher;
    localUriMatcher.addURI("com.android.contacts", "contacts/lookup/*/#", 1);
    localUriMatcher.addURI("com.android.contacts", "contacts/lookup/*", 1);
    localUriMatcher.addURI("com.android.contacts", "contacts/#/photo", 2);
    localUriMatcher.addURI("com.android.contacts", "contacts/#", 3);
    localUriMatcher.addURI("com.android.contacts", "contacts/#/display_photo", 4);
    localUriMatcher.addURI("com.android.contacts", "phone_lookup/*", 5);
  }
  
  public n(ContentResolver paramContentResolver, Uri paramUri)
  {
    super(paramContentResolver, paramUri);
  }
  
  private InputStream i(Uri paramUri, ContentResolver paramContentResolver)
    throws FileNotFoundException
  {
    int i = q.match(paramUri);
    if (i != 1) {
      if (i != 3)
      {
        if (i != 5) {
          return paramContentResolver.openInputStream(paramUri);
        }
      }
      else {
        return j(paramContentResolver, paramUri);
      }
    }
    paramUri = ContactsContract.Contacts.lookupContact(paramContentResolver, paramUri);
    if (paramUri != null) {
      return j(paramContentResolver, paramUri);
    }
    throw new FileNotFoundException("Contact cannot be found");
  }
  
  private InputStream j(ContentResolver paramContentResolver, Uri paramUri)
  {
    return ContactsContract.Contacts.openContactPhotoInputStream(paramContentResolver, paramUri, true);
  }
  
  @NonNull
  public Class<InputStream> a()
  {
    return InputStream.class;
  }
  
  protected void g(InputStream paramInputStream)
    throws IOException
  {
    paramInputStream.close();
  }
  
  protected InputStream h(Uri paramUri, ContentResolver paramContentResolver)
    throws FileNotFoundException
  {
    paramContentResolver = i(paramUri, paramContentResolver);
    if (paramContentResolver != null) {
      return paramContentResolver;
    }
    paramContentResolver = new StringBuilder();
    paramContentResolver.append("InputStream is null for ");
    paramContentResolver.append(paramUri);
    throw new FileNotFoundException(paramContentResolver.toString());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\data\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */