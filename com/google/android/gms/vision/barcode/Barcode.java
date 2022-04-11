package com.google.android.gms.vision.barcode;

import android.graphics.Point;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;

@SafeParcelable.Class(creator="BarcodeCreator")
@SafeParcelable.Reserved({1})
public class Barcode
  extends AbstractSafeParcelable
{
  public static final int ALL_FORMATS = 0;
  public static final int AZTEC = 4096;
  public static final int CALENDAR_EVENT = 11;
  public static final int CODABAR = 8;
  public static final int CODE_128 = 1;
  public static final int CODE_39 = 2;
  public static final int CODE_93 = 4;
  public static final int CONTACT_INFO = 1;
  public static final Parcelable.Creator<Barcode> CREATOR = new zzb();
  public static final int DATA_MATRIX = 16;
  public static final int DRIVER_LICENSE = 12;
  public static final int EAN_13 = 32;
  public static final int EAN_8 = 64;
  public static final int EMAIL = 2;
  public static final int GEO = 10;
  public static final int ISBN = 3;
  public static final int ITF = 128;
  public static final int PDF417 = 2048;
  public static final int PHONE = 4;
  public static final int PRODUCT = 5;
  public static final int QR_CODE = 256;
  public static final int SMS = 6;
  public static final int TEXT = 7;
  public static final int UPC_A = 512;
  public static final int UPC_E = 1024;
  public static final int URL = 8;
  public static final int WIFI = 9;
  @SafeParcelable.Field(id=13)
  public CalendarEvent calendarEvent;
  @SafeParcelable.Field(id=14)
  public ContactInfo contactInfo;
  @SafeParcelable.Field(id=6)
  public Point[] cornerPoints;
  @SafeParcelable.Field(id=4)
  public String displayValue;
  @SafeParcelable.Field(id=15)
  public DriverLicense driverLicense;
  @SafeParcelable.Field(id=7)
  public Email email;
  @SafeParcelable.Field(id=2)
  public int format;
  @SafeParcelable.Field(id=12)
  public GeoPoint geoPoint;
  @SafeParcelable.Field(id=17)
  public boolean isRecognized;
  @SafeParcelable.Field(id=8)
  public Phone phone;
  @SafeParcelable.Field(id=16)
  public byte[] rawBytes;
  @SafeParcelable.Field(id=3)
  public String rawValue;
  @SafeParcelable.Field(id=9)
  public Sms sms;
  @SafeParcelable.Field(id=11)
  public UrlBookmark url;
  @SafeParcelable.Field(id=5)
  public int valueFormat;
  @SafeParcelable.Field(id=10)
  public WiFi wifi;
  
  public Barcode() {}
  
  @SafeParcelable.Constructor
  public Barcode(@SafeParcelable.Param(id=2) int paramInt1, @SafeParcelable.Param(id=3) String paramString1, @SafeParcelable.Param(id=4) String paramString2, @SafeParcelable.Param(id=5) int paramInt2, @SafeParcelable.Param(id=6) Point[] paramArrayOfPoint, @SafeParcelable.Param(id=7) Email paramEmail, @SafeParcelable.Param(id=8) Phone paramPhone, @SafeParcelable.Param(id=9) Sms paramSms, @SafeParcelable.Param(id=10) WiFi paramWiFi, @SafeParcelable.Param(id=11) UrlBookmark paramUrlBookmark, @SafeParcelable.Param(id=12) GeoPoint paramGeoPoint, @SafeParcelable.Param(id=13) CalendarEvent paramCalendarEvent, @SafeParcelable.Param(id=14) ContactInfo paramContactInfo, @SafeParcelable.Param(id=15) DriverLicense paramDriverLicense, @SafeParcelable.Param(id=16) byte[] paramArrayOfByte, @SafeParcelable.Param(id=17) boolean paramBoolean)
  {
    this.format = paramInt1;
    this.rawValue = paramString1;
    this.rawBytes = paramArrayOfByte;
    this.displayValue = paramString2;
    this.valueFormat = paramInt2;
    this.cornerPoints = paramArrayOfPoint;
    this.isRecognized = paramBoolean;
    this.email = paramEmail;
    this.phone = paramPhone;
    this.sms = paramSms;
    this.wifi = paramWiFi;
    this.url = paramUrlBookmark;
    this.geoPoint = paramGeoPoint;
    this.calendarEvent = paramCalendarEvent;
    this.contactInfo = paramContactInfo;
    this.driverLicense = paramDriverLicense;
  }
  
  public Rect getBoundingBox()
  {
    int i = Integer.MIN_VALUE;
    int j = Integer.MIN_VALUE;
    int k = Integer.MAX_VALUE;
    int m = Integer.MAX_VALUE;
    for (int n = 0;; n++)
    {
      Object localObject = this.cornerPoints;
      if (n >= localObject.length) {
        break;
      }
      localObject = localObject[n];
      k = Math.min(k, ((Point)localObject).x);
      i = Math.max(i, ((Point)localObject).x);
      m = Math.min(m, ((Point)localObject).y);
      j = Math.max(j, ((Point)localObject).y);
    }
    return new Rect(k, m, i, j);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 2, this.format);
    SafeParcelWriter.writeString(paramParcel, 3, this.rawValue, false);
    SafeParcelWriter.writeString(paramParcel, 4, this.displayValue, false);
    SafeParcelWriter.writeInt(paramParcel, 5, this.valueFormat);
    SafeParcelWriter.writeTypedArray(paramParcel, 6, this.cornerPoints, paramInt, false);
    SafeParcelWriter.writeParcelable(paramParcel, 7, this.email, paramInt, false);
    SafeParcelWriter.writeParcelable(paramParcel, 8, this.phone, paramInt, false);
    SafeParcelWriter.writeParcelable(paramParcel, 9, this.sms, paramInt, false);
    SafeParcelWriter.writeParcelable(paramParcel, 10, this.wifi, paramInt, false);
    SafeParcelWriter.writeParcelable(paramParcel, 11, this.url, paramInt, false);
    SafeParcelWriter.writeParcelable(paramParcel, 12, this.geoPoint, paramInt, false);
    SafeParcelWriter.writeParcelable(paramParcel, 13, this.calendarEvent, paramInt, false);
    SafeParcelWriter.writeParcelable(paramParcel, 14, this.contactInfo, paramInt, false);
    SafeParcelWriter.writeParcelable(paramParcel, 15, this.driverLicense, paramInt, false);
    SafeParcelWriter.writeByteArray(paramParcel, 16, this.rawBytes, false);
    SafeParcelWriter.writeBoolean(paramParcel, 17, this.isRecognized);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
  
  @SafeParcelable.Class(creator="AddressCreator")
  @SafeParcelable.Reserved({1})
  public static class Address
    extends AbstractSafeParcelable
  {
    public static final Parcelable.Creator<Address> CREATOR = new zza();
    public static final int HOME = 2;
    public static final int UNKNOWN = 0;
    public static final int WORK = 1;
    @SafeParcelable.Field(id=3)
    public String[] addressLines;
    @SafeParcelable.Field(id=2)
    public int type;
    
    public Address() {}
    
    @SafeParcelable.Constructor
    public Address(@SafeParcelable.Param(id=2) int paramInt, @SafeParcelable.Param(id=3) String[] paramArrayOfString)
    {
      this.type = paramInt;
      this.addressLines = paramArrayOfString;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
      SafeParcelWriter.writeInt(paramParcel, 2, this.type);
      SafeParcelWriter.writeStringArray(paramParcel, 3, this.addressLines, false);
      SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
    }
  }
  
  @SafeParcelable.Class(creator="CalendarDateTimeCreator")
  @SafeParcelable.Reserved({1})
  public static class CalendarDateTime
    extends AbstractSafeParcelable
  {
    public static final Parcelable.Creator<CalendarDateTime> CREATOR = new zzd();
    @SafeParcelable.Field(id=4)
    public int day;
    @SafeParcelable.Field(id=5)
    public int hours;
    @SafeParcelable.Field(id=8)
    public boolean isUtc;
    @SafeParcelable.Field(id=6)
    public int minutes;
    @SafeParcelable.Field(id=3)
    public int month;
    @SafeParcelable.Field(id=9)
    public String rawValue;
    @SafeParcelable.Field(id=7)
    public int seconds;
    @SafeParcelable.Field(id=2)
    public int year;
    
    public CalendarDateTime() {}
    
    @SafeParcelable.Constructor
    public CalendarDateTime(@SafeParcelable.Param(id=2) int paramInt1, @SafeParcelable.Param(id=3) int paramInt2, @SafeParcelable.Param(id=4) int paramInt3, @SafeParcelable.Param(id=5) int paramInt4, @SafeParcelable.Param(id=6) int paramInt5, @SafeParcelable.Param(id=7) int paramInt6, @SafeParcelable.Param(id=8) boolean paramBoolean, @SafeParcelable.Param(id=9) String paramString)
    {
      this.year = paramInt1;
      this.month = paramInt2;
      this.day = paramInt3;
      this.hours = paramInt4;
      this.minutes = paramInt5;
      this.seconds = paramInt6;
      this.isUtc = paramBoolean;
      this.rawValue = paramString;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
      SafeParcelWriter.writeInt(paramParcel, 2, this.year);
      SafeParcelWriter.writeInt(paramParcel, 3, this.month);
      SafeParcelWriter.writeInt(paramParcel, 4, this.day);
      SafeParcelWriter.writeInt(paramParcel, 5, this.hours);
      SafeParcelWriter.writeInt(paramParcel, 6, this.minutes);
      SafeParcelWriter.writeInt(paramParcel, 7, this.seconds);
      SafeParcelWriter.writeBoolean(paramParcel, 8, this.isUtc);
      SafeParcelWriter.writeString(paramParcel, 9, this.rawValue, false);
      SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
    }
  }
  
  @SafeParcelable.Class(creator="CalendarEventCreator")
  @SafeParcelable.Reserved({1})
  public static class CalendarEvent
    extends AbstractSafeParcelable
  {
    public static final Parcelable.Creator<CalendarEvent> CREATOR = new zzf();
    @SafeParcelable.Field(id=3)
    public String description;
    @SafeParcelable.Field(id=8)
    public Barcode.CalendarDateTime end;
    @SafeParcelable.Field(id=4)
    public String location;
    @SafeParcelable.Field(id=5)
    public String organizer;
    @SafeParcelable.Field(id=7)
    public Barcode.CalendarDateTime start;
    @SafeParcelable.Field(id=6)
    public String status;
    @SafeParcelable.Field(id=2)
    public String summary;
    
    public CalendarEvent() {}
    
    @SafeParcelable.Constructor
    public CalendarEvent(@SafeParcelable.Param(id=2) String paramString1, @SafeParcelable.Param(id=3) String paramString2, @SafeParcelable.Param(id=4) String paramString3, @SafeParcelable.Param(id=5) String paramString4, @SafeParcelable.Param(id=6) String paramString5, @SafeParcelable.Param(id=7) Barcode.CalendarDateTime paramCalendarDateTime1, @SafeParcelable.Param(id=8) Barcode.CalendarDateTime paramCalendarDateTime2)
    {
      this.summary = paramString1;
      this.description = paramString2;
      this.location = paramString3;
      this.organizer = paramString4;
      this.status = paramString5;
      this.start = paramCalendarDateTime1;
      this.end = paramCalendarDateTime2;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      int i = SafeParcelWriter.beginObjectHeader(paramParcel);
      SafeParcelWriter.writeString(paramParcel, 2, this.summary, false);
      SafeParcelWriter.writeString(paramParcel, 3, this.description, false);
      SafeParcelWriter.writeString(paramParcel, 4, this.location, false);
      SafeParcelWriter.writeString(paramParcel, 5, this.organizer, false);
      SafeParcelWriter.writeString(paramParcel, 6, this.status, false);
      SafeParcelWriter.writeParcelable(paramParcel, 7, this.start, paramInt, false);
      SafeParcelWriter.writeParcelable(paramParcel, 8, this.end, paramInt, false);
      SafeParcelWriter.finishObjectHeader(paramParcel, i);
    }
  }
  
  @SafeParcelable.Class(creator="ContactInfoCreator")
  @SafeParcelable.Reserved({1})
  public static class ContactInfo
    extends AbstractSafeParcelable
  {
    public static final Parcelable.Creator<ContactInfo> CREATOR = new zze();
    @SafeParcelable.Field(id=8)
    public Barcode.Address[] addresses;
    @SafeParcelable.Field(id=6)
    public Barcode.Email[] emails;
    @SafeParcelable.Field(id=2)
    public Barcode.PersonName name;
    @SafeParcelable.Field(id=3)
    public String organization;
    @SafeParcelable.Field(id=5)
    public Barcode.Phone[] phones;
    @SafeParcelable.Field(id=4)
    public String title;
    @SafeParcelable.Field(id=7)
    public String[] urls;
    
    public ContactInfo() {}
    
    @SafeParcelable.Constructor
    public ContactInfo(@SafeParcelable.Param(id=2) Barcode.PersonName paramPersonName, @SafeParcelable.Param(id=3) String paramString1, @SafeParcelable.Param(id=4) String paramString2, @SafeParcelable.Param(id=5) Barcode.Phone[] paramArrayOfPhone, @SafeParcelable.Param(id=6) Barcode.Email[] paramArrayOfEmail, @SafeParcelable.Param(id=7) String[] paramArrayOfString, @SafeParcelable.Param(id=8) Barcode.Address[] paramArrayOfAddress)
    {
      this.name = paramPersonName;
      this.organization = paramString1;
      this.title = paramString2;
      this.phones = paramArrayOfPhone;
      this.emails = paramArrayOfEmail;
      this.urls = paramArrayOfString;
      this.addresses = paramArrayOfAddress;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      int i = SafeParcelWriter.beginObjectHeader(paramParcel);
      SafeParcelWriter.writeParcelable(paramParcel, 2, this.name, paramInt, false);
      SafeParcelWriter.writeString(paramParcel, 3, this.organization, false);
      SafeParcelWriter.writeString(paramParcel, 4, this.title, false);
      SafeParcelWriter.writeTypedArray(paramParcel, 5, this.phones, paramInt, false);
      SafeParcelWriter.writeTypedArray(paramParcel, 6, this.emails, paramInt, false);
      SafeParcelWriter.writeStringArray(paramParcel, 7, this.urls, false);
      SafeParcelWriter.writeTypedArray(paramParcel, 8, this.addresses, paramInt, false);
      SafeParcelWriter.finishObjectHeader(paramParcel, i);
    }
  }
  
  @SafeParcelable.Class(creator="DriverLicenseCreator")
  @SafeParcelable.Reserved({1})
  public static class DriverLicense
    extends AbstractSafeParcelable
  {
    public static final Parcelable.Creator<DriverLicense> CREATOR = new zzh();
    @SafeParcelable.Field(id=8)
    public String addressCity;
    @SafeParcelable.Field(id=9)
    public String addressState;
    @SafeParcelable.Field(id=7)
    public String addressStreet;
    @SafeParcelable.Field(id=10)
    public String addressZip;
    @SafeParcelable.Field(id=14)
    public String birthDate;
    @SafeParcelable.Field(id=2)
    public String documentType;
    @SafeParcelable.Field(id=13)
    public String expiryDate;
    @SafeParcelable.Field(id=3)
    public String firstName;
    @SafeParcelable.Field(id=6)
    public String gender;
    @SafeParcelable.Field(id=12)
    public String issueDate;
    @SafeParcelable.Field(id=15)
    public String issuingCountry;
    @SafeParcelable.Field(id=5)
    public String lastName;
    @SafeParcelable.Field(id=11)
    public String licenseNumber;
    @SafeParcelable.Field(id=4)
    public String middleName;
    
    public DriverLicense() {}
    
    @SafeParcelable.Constructor
    public DriverLicense(@SafeParcelable.Param(id=2) String paramString1, @SafeParcelable.Param(id=3) String paramString2, @SafeParcelable.Param(id=4) String paramString3, @SafeParcelable.Param(id=5) String paramString4, @SafeParcelable.Param(id=6) String paramString5, @SafeParcelable.Param(id=7) String paramString6, @SafeParcelable.Param(id=8) String paramString7, @SafeParcelable.Param(id=9) String paramString8, @SafeParcelable.Param(id=10) String paramString9, @SafeParcelable.Param(id=11) String paramString10, @SafeParcelable.Param(id=12) String paramString11, @SafeParcelable.Param(id=13) String paramString12, @SafeParcelable.Param(id=14) String paramString13, @SafeParcelable.Param(id=15) String paramString14)
    {
      this.documentType = paramString1;
      this.firstName = paramString2;
      this.middleName = paramString3;
      this.lastName = paramString4;
      this.gender = paramString5;
      this.addressStreet = paramString6;
      this.addressCity = paramString7;
      this.addressState = paramString8;
      this.addressZip = paramString9;
      this.licenseNumber = paramString10;
      this.issueDate = paramString11;
      this.expiryDate = paramString12;
      this.birthDate = paramString13;
      this.issuingCountry = paramString14;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
      SafeParcelWriter.writeString(paramParcel, 2, this.documentType, false);
      SafeParcelWriter.writeString(paramParcel, 3, this.firstName, false);
      SafeParcelWriter.writeString(paramParcel, 4, this.middleName, false);
      SafeParcelWriter.writeString(paramParcel, 5, this.lastName, false);
      SafeParcelWriter.writeString(paramParcel, 6, this.gender, false);
      SafeParcelWriter.writeString(paramParcel, 7, this.addressStreet, false);
      SafeParcelWriter.writeString(paramParcel, 8, this.addressCity, false);
      SafeParcelWriter.writeString(paramParcel, 9, this.addressState, false);
      SafeParcelWriter.writeString(paramParcel, 10, this.addressZip, false);
      SafeParcelWriter.writeString(paramParcel, 11, this.licenseNumber, false);
      SafeParcelWriter.writeString(paramParcel, 12, this.issueDate, false);
      SafeParcelWriter.writeString(paramParcel, 13, this.expiryDate, false);
      SafeParcelWriter.writeString(paramParcel, 14, this.birthDate, false);
      SafeParcelWriter.writeString(paramParcel, 15, this.issuingCountry, false);
      SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
    }
  }
  
  @SafeParcelable.Class(creator="EmailCreator")
  @SafeParcelable.Reserved({1})
  public static class Email
    extends AbstractSafeParcelable
  {
    public static final Parcelable.Creator<Email> CREATOR = new zzg();
    public static final int HOME = 2;
    public static final int UNKNOWN = 0;
    public static final int WORK = 1;
    @SafeParcelable.Field(id=3)
    public String address;
    @SafeParcelable.Field(id=5)
    public String body;
    @SafeParcelable.Field(id=4)
    public String subject;
    @SafeParcelable.Field(id=2)
    public int type;
    
    public Email() {}
    
    @SafeParcelable.Constructor
    public Email(@SafeParcelable.Param(id=2) int paramInt, @SafeParcelable.Param(id=3) String paramString1, @SafeParcelable.Param(id=4) String paramString2, @SafeParcelable.Param(id=5) String paramString3)
    {
      this.type = paramInt;
      this.address = paramString1;
      this.subject = paramString2;
      this.body = paramString3;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
      SafeParcelWriter.writeInt(paramParcel, 2, this.type);
      SafeParcelWriter.writeString(paramParcel, 3, this.address, false);
      SafeParcelWriter.writeString(paramParcel, 4, this.subject, false);
      SafeParcelWriter.writeString(paramParcel, 5, this.body, false);
      SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
    }
  }
  
  @SafeParcelable.Class(creator="GeoPointCreator")
  @SafeParcelable.Reserved({1})
  public static class GeoPoint
    extends AbstractSafeParcelable
  {
    public static final Parcelable.Creator<GeoPoint> CREATOR = new zzj();
    @SafeParcelable.Field(id=2)
    public double lat;
    @SafeParcelable.Field(id=3)
    public double lng;
    
    public GeoPoint() {}
    
    @SafeParcelable.Constructor
    public GeoPoint(@SafeParcelable.Param(id=2) double paramDouble1, @SafeParcelable.Param(id=3) double paramDouble2)
    {
      this.lat = paramDouble1;
      this.lng = paramDouble2;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
      SafeParcelWriter.writeDouble(paramParcel, 2, this.lat);
      SafeParcelWriter.writeDouble(paramParcel, 3, this.lng);
      SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
    }
  }
  
  @SafeParcelable.Class(creator="PersonNameCreator")
  @SafeParcelable.Reserved({1})
  public static class PersonName
    extends AbstractSafeParcelable
  {
    public static final Parcelable.Creator<PersonName> CREATOR = new zzi();
    @SafeParcelable.Field(id=5)
    public String first;
    @SafeParcelable.Field(id=2)
    public String formattedName;
    @SafeParcelable.Field(id=7)
    public String last;
    @SafeParcelable.Field(id=6)
    public String middle;
    @SafeParcelable.Field(id=4)
    public String prefix;
    @SafeParcelable.Field(id=3)
    public String pronunciation;
    @SafeParcelable.Field(id=8)
    public String suffix;
    
    public PersonName() {}
    
    @SafeParcelable.Constructor
    public PersonName(@SafeParcelable.Param(id=2) String paramString1, @SafeParcelable.Param(id=3) String paramString2, @SafeParcelable.Param(id=4) String paramString3, @SafeParcelable.Param(id=5) String paramString4, @SafeParcelable.Param(id=6) String paramString5, @SafeParcelable.Param(id=7) String paramString6, @SafeParcelable.Param(id=8) String paramString7)
    {
      this.formattedName = paramString1;
      this.pronunciation = paramString2;
      this.prefix = paramString3;
      this.first = paramString4;
      this.middle = paramString5;
      this.last = paramString6;
      this.suffix = paramString7;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
      SafeParcelWriter.writeString(paramParcel, 2, this.formattedName, false);
      SafeParcelWriter.writeString(paramParcel, 3, this.pronunciation, false);
      SafeParcelWriter.writeString(paramParcel, 4, this.prefix, false);
      SafeParcelWriter.writeString(paramParcel, 5, this.first, false);
      SafeParcelWriter.writeString(paramParcel, 6, this.middle, false);
      SafeParcelWriter.writeString(paramParcel, 7, this.last, false);
      SafeParcelWriter.writeString(paramParcel, 8, this.suffix, false);
      SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
    }
  }
  
  @SafeParcelable.Class(creator="PhoneCreator")
  @SafeParcelable.Reserved({1})
  public static class Phone
    extends AbstractSafeParcelable
  {
    public static final Parcelable.Creator<Phone> CREATOR = new zzl();
    public static final int FAX = 3;
    public static final int HOME = 2;
    public static final int MOBILE = 4;
    public static final int UNKNOWN = 0;
    public static final int WORK = 1;
    @SafeParcelable.Field(id=3)
    public String number;
    @SafeParcelable.Field(id=2)
    public int type;
    
    public Phone() {}
    
    @SafeParcelable.Constructor
    public Phone(@SafeParcelable.Param(id=2) int paramInt, @SafeParcelable.Param(id=3) String paramString)
    {
      this.type = paramInt;
      this.number = paramString;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
      SafeParcelWriter.writeInt(paramParcel, 2, this.type);
      SafeParcelWriter.writeString(paramParcel, 3, this.number, false);
      SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
    }
  }
  
  @SafeParcelable.Class(creator="SmsCreator")
  @SafeParcelable.Reserved({1})
  public static class Sms
    extends AbstractSafeParcelable
  {
    public static final Parcelable.Creator<Sms> CREATOR = new zzk();
    @SafeParcelable.Field(id=2)
    public String message;
    @SafeParcelable.Field(id=3)
    public String phoneNumber;
    
    public Sms() {}
    
    @SafeParcelable.Constructor
    public Sms(@SafeParcelable.Param(id=2) String paramString1, @SafeParcelable.Param(id=3) String paramString2)
    {
      this.message = paramString1;
      this.phoneNumber = paramString2;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
      SafeParcelWriter.writeString(paramParcel, 2, this.message, false);
      SafeParcelWriter.writeString(paramParcel, 3, this.phoneNumber, false);
      SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
    }
  }
  
  @SafeParcelable.Class(creator="UrlBookmarkCreator")
  @SafeParcelable.Reserved({1})
  public static class UrlBookmark
    extends AbstractSafeParcelable
  {
    public static final Parcelable.Creator<UrlBookmark> CREATOR = new zzn();
    @SafeParcelable.Field(id=2)
    public String title;
    @SafeParcelable.Field(id=3)
    public String url;
    
    public UrlBookmark() {}
    
    @SafeParcelable.Constructor
    public UrlBookmark(@SafeParcelable.Param(id=2) String paramString1, @SafeParcelable.Param(id=3) String paramString2)
    {
      this.title = paramString1;
      this.url = paramString2;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
      SafeParcelWriter.writeString(paramParcel, 2, this.title, false);
      SafeParcelWriter.writeString(paramParcel, 3, this.url, false);
      SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
    }
  }
  
  @SafeParcelable.Class(creator="WiFiCreator")
  @SafeParcelable.Reserved({1})
  public static class WiFi
    extends AbstractSafeParcelable
  {
    public static final Parcelable.Creator<WiFi> CREATOR = new zzm();
    public static final int OPEN = 1;
    public static final int WEP = 3;
    public static final int WPA = 2;
    @SafeParcelable.Field(id=4)
    public int encryptionType;
    @SafeParcelable.Field(id=3)
    public String password;
    @SafeParcelable.Field(id=2)
    public String ssid;
    
    public WiFi() {}
    
    @SafeParcelable.Constructor
    public WiFi(@SafeParcelable.Param(id=2) String paramString1, @SafeParcelable.Param(id=3) String paramString2, @SafeParcelable.Param(id=4) int paramInt)
    {
      this.ssid = paramString1;
      this.password = paramString2;
      this.encryptionType = paramInt;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
      SafeParcelWriter.writeString(paramParcel, 2, this.ssid, false);
      SafeParcelWriter.writeString(paramParcel, 3, this.password, false);
      SafeParcelWriter.writeInt(paramParcel, 4, this.encryptionType);
      SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\vision\barcode\Barcode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */