package com.google.android.libraries.barhopper;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.apps.common.proguard.UsedByNative;

@UsedByNative("barhopper-v2-jni.cc")
public class Barcode
  implements Parcelable
{
  public static final Parcelable.Creator<Barcode> CREATOR = new a();
  @UsedByNative("barhopper-v2-jni.cc")
  public BoardingPass boardingPass;
  @UsedByNative("barhopper-v2-jni.cc")
  public CalendarEvent calendarEvent;
  @UsedByNative("barhopper-v2-jni.cc")
  public ContactInfo contactInfo;
  @UsedByNative("barhopper-v2-jni.cc")
  public Point[] cornerPoints;
  @UsedByNative("barhopper-v2-jni.cc")
  public String displayValue;
  @UsedByNative("barhopper-v2-jni.cc")
  public DriverLicense driverLicense;
  @UsedByNative("barhopper-v2-jni.cc")
  public Email email;
  @UsedByNative("barhopper-v2-jni.cc")
  public int format;
  @UsedByNative("barhopper-v2-jni.cc")
  public GeoPoint geoPoint;
  @UsedByNative("barhopper-v2-jni.cc")
  public boolean isRecognized;
  @UsedByNative("barhopper-v2-jni.cc")
  public Phone phone;
  @UsedByNative("barhopper-v2-jni.cc")
  public byte[] rawBytes;
  @UsedByNative("barhopper-v2-jni.cc")
  public String rawValue;
  @UsedByNative("barhopper-v2-jni.cc")
  public Sms sms;
  @UsedByNative("barhopper-v2-jni.cc")
  public UrlBookmark url;
  @UsedByNative("barhopper-v2-jni.cc")
  public int valueFormat;
  @UsedByNative("barhopper-v2-jni.cc")
  public WiFi wifi;
  
  @UsedByNative("barhopper-v2-jni.cc")
  public Barcode() {}
  
  private Barcode(Parcel paramParcel)
  {
    this.format = paramParcel.readInt();
    this.rawValue = paramParcel.readString();
    this.displayValue = paramParcel.readString();
    this.valueFormat = paramParcel.readInt();
    this.cornerPoints = ((Point[])paramParcel.createTypedArray(Point.CREATOR));
    this.email = ((Email)paramParcel.readParcelable(Email.class.getClassLoader()));
    this.phone = ((Phone)paramParcel.readParcelable(Phone.class.getClassLoader()));
    this.sms = ((Sms)paramParcel.readParcelable(Sms.class.getClassLoader()));
    this.wifi = ((WiFi)paramParcel.readParcelable(WiFi.class.getClassLoader()));
    this.url = ((UrlBookmark)paramParcel.readParcelable(UrlBookmark.class.getClassLoader()));
    this.geoPoint = ((GeoPoint)paramParcel.readParcelable(GeoPoint.class.getClassLoader()));
    this.calendarEvent = ((CalendarEvent)paramParcel.readParcelable(CalendarEvent.class.getClassLoader()));
    this.contactInfo = ((ContactInfo)paramParcel.readParcelable(ContactInfo.class.getClassLoader()));
    this.driverLicense = ((DriverLicense)paramParcel.readParcelable(DriverLicense.class.getClassLoader()));
    this.boardingPass = ((BoardingPass)paramParcel.readParcelable(BoardingPass.class.getClassLoader()));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.format);
    paramParcel.writeString(this.rawValue);
    paramParcel.writeString(this.displayValue);
    paramParcel.writeInt(this.valueFormat);
    paramParcel.writeTypedArray(this.cornerPoints, 0);
    paramParcel.writeParcelable(this.email, 0);
    paramParcel.writeParcelable(this.phone, 0);
    paramParcel.writeParcelable(this.sms, 0);
    paramParcel.writeParcelable(this.wifi, 0);
    paramParcel.writeParcelable(this.url, 0);
    paramParcel.writeParcelable(this.geoPoint, 0);
    paramParcel.writeParcelable(this.calendarEvent, 0);
    paramParcel.writeParcelable(this.contactInfo, 0);
    paramParcel.writeParcelable(this.driverLicense, 0);
    paramParcel.writeParcelable(this.boardingPass, 0);
  }
  
  @UsedByNative("barhopper-v2-jni.cc")
  public static class Address
    implements Parcelable
  {
    public static final Parcelable.Creator<Address> CREATOR = new a();
    @UsedByNative("barhopper-v2-jni.cc")
    public String[] addressLines;
    @UsedByNative("barhopper-v2-jni.cc")
    public int type;
    
    @UsedByNative("barhopper-v2-jni.cc")
    public Address() {}
    
    private Address(Parcel paramParcel)
    {
      this.type = paramParcel.readInt();
      this.addressLines = paramParcel.createStringArray();
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(this.type);
      paramParcel.writeStringArray(this.addressLines);
    }
  }
  
  @UsedByNative("barhopper-v2-jni.cc")
  public static class BoardingPass
    implements Parcelable
  {
    public static final Parcelable.Creator<BoardingPass> CREATOR = new b();
    @UsedByNative("barhopper-v2-jni.cc")
    public Barcode.FlightSegment[] flightSegment;
    @UsedByNative("barhopper-v2-jni.cc")
    public String passengerName;
    
    @UsedByNative("barhopper-v2-jni.cc")
    public BoardingPass() {}
    
    private BoardingPass(Parcel paramParcel)
    {
      this.passengerName = paramParcel.readString();
      this.flightSegment = ((Barcode.FlightSegment[])paramParcel.createTypedArray(Barcode.FlightSegment.CREATOR));
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.passengerName);
      paramParcel.writeTypedArray(this.flightSegment, 0);
    }
  }
  
  @UsedByNative("barhopper-v2-jni.cc")
  public static class CalendarDateTime
    implements Parcelable
  {
    public static final Parcelable.Creator<CalendarDateTime> CREATOR = new c();
    @UsedByNative("barhopper-v2-jni.cc")
    public int day;
    @UsedByNative("barhopper-v2-jni.cc")
    public int hours;
    @UsedByNative("barhopper-v2-jni.cc")
    public boolean isUtc;
    @UsedByNative("barhopper-v2-jni.cc")
    public int minutes;
    @UsedByNative("barhopper-v2-jni.cc")
    public int month;
    @UsedByNative("barhopper-v2-jni.cc")
    public String rawValue;
    @UsedByNative("barhopper-v2-jni.cc")
    public int seconds;
    @UsedByNative("barhopper-v2-jni.cc")
    public int year;
    
    @UsedByNative("barhopper-v2-jni.cc")
    public CalendarDateTime() {}
    
    private CalendarDateTime(Parcel paramParcel)
    {
      this.year = paramParcel.readInt();
      this.month = paramParcel.readInt();
      this.day = paramParcel.readInt();
      this.hours = paramParcel.readInt();
      this.minutes = paramParcel.readInt();
      this.seconds = paramParcel.readInt();
      boolean bool;
      if (paramParcel.readByte() != 0) {
        bool = true;
      } else {
        bool = false;
      }
      this.isUtc = bool;
      this.rawValue = paramParcel.readString();
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(this.year);
      paramParcel.writeInt(this.month);
      paramParcel.writeInt(this.day);
      paramParcel.writeInt(this.hours);
      paramParcel.writeInt(this.minutes);
      paramParcel.writeInt(this.seconds);
      paramParcel.writeByte((byte)this.isUtc);
      paramParcel.writeString(this.rawValue);
    }
  }
  
  @UsedByNative("barhopper-v2-jni.cc")
  public static class CalendarEvent
    implements Parcelable
  {
    public static final Parcelable.Creator<CalendarEvent> CREATOR = new d();
    @UsedByNative("barhopper-v2-jni.cc")
    public String description;
    @UsedByNative("barhopper-v2-jni.cc")
    public Barcode.CalendarDateTime end;
    @UsedByNative("barhopper-v2-jni.cc")
    public String location;
    @UsedByNative("barhopper-v2-jni.cc")
    public String organizer;
    @UsedByNative("barhopper-v2-jni.cc")
    public Barcode.CalendarDateTime start;
    @UsedByNative("barhopper-v2-jni.cc")
    public String status;
    @UsedByNative("barhopper-v2-jni.cc")
    public String summary;
    
    @UsedByNative("barhopper-v2-jni.cc")
    public CalendarEvent() {}
    
    private CalendarEvent(Parcel paramParcel)
    {
      this.summary = paramParcel.readString();
      this.description = paramParcel.readString();
      this.location = paramParcel.readString();
      this.organizer = paramParcel.readString();
      this.status = paramParcel.readString();
      this.start = ((Barcode.CalendarDateTime)paramParcel.readParcelable(Barcode.CalendarDateTime.class.getClassLoader()));
      this.end = ((Barcode.CalendarDateTime)paramParcel.readParcelable(Barcode.CalendarDateTime.class.getClassLoader()));
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.summary);
      paramParcel.writeString(this.description);
      paramParcel.writeString(this.location);
      paramParcel.writeString(this.organizer);
      paramParcel.writeString(this.status);
      paramParcel.writeParcelable(this.start, 0);
      paramParcel.writeParcelable(this.end, 0);
    }
  }
  
  @UsedByNative("barhopper-v2-jni.cc")
  public static class ContactInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<ContactInfo> CREATOR = new e();
    @UsedByNative("barhopper-v2-jni.cc")
    public Barcode.Address[] addresses;
    @UsedByNative("barhopper-v2-jni.cc")
    public Barcode.Email[] emails;
    @UsedByNative("barhopper-v2-jni.cc")
    public Barcode.PersonName name;
    @UsedByNative("barhopper-v2-jni.cc")
    public String note;
    @UsedByNative("barhopper-v2-jni.cc")
    public String organization;
    @UsedByNative("barhopper-v2-jni.cc")
    public Barcode.Phone[] phones;
    @UsedByNative("barhopper-v2-jni.cc")
    public String title;
    @UsedByNative("barhopper-v2-jni.cc")
    public String[] urls;
    
    @UsedByNative("barhopper-v2-jni.cc")
    public ContactInfo() {}
    
    private ContactInfo(Parcel paramParcel)
    {
      this.name = ((Barcode.PersonName)paramParcel.readParcelable(Barcode.PersonName.class.getClassLoader()));
      this.organization = paramParcel.readString();
      this.title = paramParcel.readString();
      this.phones = ((Barcode.Phone[])paramParcel.createTypedArray(Barcode.Phone.CREATOR));
      this.emails = ((Barcode.Email[])paramParcel.createTypedArray(Barcode.Email.CREATOR));
      this.urls = paramParcel.createStringArray();
      this.addresses = ((Barcode.Address[])paramParcel.createTypedArray(Barcode.Address.CREATOR));
      this.note = paramParcel.readString();
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeParcelable(this.name, 0);
      paramParcel.writeString(this.organization);
      paramParcel.writeString(this.title);
      paramParcel.writeTypedArray(this.phones, 0);
      paramParcel.writeTypedArray(this.emails, 0);
      paramParcel.writeStringArray(this.urls);
      paramParcel.writeTypedArray(this.addresses, 0);
      paramParcel.writeString(this.note);
    }
  }
  
  @UsedByNative("barhopper-v2-jni.cc")
  public static class DriverLicense
    implements Parcelable
  {
    public static final Parcelable.Creator<DriverLicense> CREATOR = new f();
    @UsedByNative("barhopper-v2-jni.cc")
    public String addressCity;
    @UsedByNative("barhopper-v2-jni.cc")
    public String addressState;
    @UsedByNative("barhopper-v2-jni.cc")
    public String addressStreet;
    @UsedByNative("barhopper-v2-jni.cc")
    public String addressZip;
    @UsedByNative("barhopper-v2-jni.cc")
    public String birthDate;
    @UsedByNative("barhopper-v2-jni.cc")
    public String documentType;
    @UsedByNative("barhopper-v2-jni.cc")
    public String expiryDate;
    @UsedByNative("barhopper-v2-jni.cc")
    public String firstName;
    @UsedByNative("barhopper-v2-jni.cc")
    public String gender;
    @UsedByNative("barhopper-v2-jni.cc")
    public String issueDate;
    @UsedByNative("barhopper-v2-jni.cc")
    public String issuingCountry;
    @UsedByNative("barhopper-v2-jni.cc")
    public String lastName;
    @UsedByNative("barhopper-v2-jni.cc")
    public String licenseNumber;
    @UsedByNative("barhopper-v2-jni.cc")
    public String middleName;
    
    @UsedByNative("barhopper-v2-jni.cc")
    public DriverLicense() {}
    
    private DriverLicense(Parcel paramParcel)
    {
      this.documentType = paramParcel.readString();
      this.firstName = paramParcel.readString();
      this.middleName = paramParcel.readString();
      this.lastName = paramParcel.readString();
      this.gender = paramParcel.readString();
      this.addressStreet = paramParcel.readString();
      this.addressCity = paramParcel.readString();
      this.addressState = paramParcel.readString();
      this.addressZip = paramParcel.readString();
      this.licenseNumber = paramParcel.readString();
      this.issueDate = paramParcel.readString();
      this.expiryDate = paramParcel.readString();
      this.birthDate = paramParcel.readString();
      this.issuingCountry = paramParcel.readString();
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.documentType);
      paramParcel.writeString(this.firstName);
      paramParcel.writeString(this.middleName);
      paramParcel.writeString(this.lastName);
      paramParcel.writeString(this.gender);
      paramParcel.writeString(this.addressStreet);
      paramParcel.writeString(this.addressCity);
      paramParcel.writeString(this.addressState);
      paramParcel.writeString(this.addressZip);
      paramParcel.writeString(this.licenseNumber);
      paramParcel.writeString(this.issueDate);
      paramParcel.writeString(this.expiryDate);
      paramParcel.writeString(this.birthDate);
      paramParcel.writeString(this.issuingCountry);
    }
  }
  
  @UsedByNative("barhopper-v2-jni.cc")
  public static class Email
    implements Parcelable
  {
    public static final Parcelable.Creator<Email> CREATOR = new g();
    @UsedByNative("barhopper-v2-jni.cc")
    public String address;
    @UsedByNative("barhopper-v2-jni.cc")
    public String body;
    @UsedByNative("barhopper-v2-jni.cc")
    public String subject;
    @UsedByNative("barhopper-v2-jni.cc")
    public int type;
    
    @UsedByNative("barhopper-v2-jni.cc")
    public Email() {}
    
    private Email(Parcel paramParcel)
    {
      this.type = paramParcel.readInt();
      this.address = paramParcel.readString();
      this.subject = paramParcel.readString();
      this.body = paramParcel.readString();
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(this.type);
      paramParcel.writeString(this.address);
      paramParcel.writeString(this.subject);
      paramParcel.writeString(this.body);
    }
  }
  
  @UsedByNative("barhopper-v2-jni.cc")
  public static class FlightSegment
    implements Parcelable
  {
    public static final Parcelable.Creator<FlightSegment> CREATOR = new h();
    @UsedByNative("barhopper-v2-jni.cc")
    public String carrier;
    @UsedByNative("barhopper-v2-jni.cc")
    public String compartmentCode;
    @UsedByNative("barhopper-v2-jni.cc")
    public String dateOfFlightJulian;
    @UsedByNative("barhopper-v2-jni.cc")
    public String destination;
    @UsedByNative("barhopper-v2-jni.cc")
    public String flightNumber;
    @UsedByNative("barhopper-v2-jni.cc")
    public String origin;
    @UsedByNative("barhopper-v2-jni.cc")
    public String pnrCode;
    @UsedByNative("barhopper-v2-jni.cc")
    public String seatNumber;
    @UsedByNative("barhopper-v2-jni.cc")
    public String selecteeIndicator;
    
    @UsedByNative("barhopper-v2-jni.cc")
    public FlightSegment() {}
    
    private FlightSegment(Parcel paramParcel)
    {
      this.pnrCode = paramParcel.readString();
      this.origin = paramParcel.readString();
      this.destination = paramParcel.readString();
      this.carrier = paramParcel.readString();
      this.flightNumber = paramParcel.readString();
      this.dateOfFlightJulian = paramParcel.readString();
      this.compartmentCode = paramParcel.readString();
      this.seatNumber = paramParcel.readString();
      this.selecteeIndicator = paramParcel.readString();
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.pnrCode);
      paramParcel.writeString(this.origin);
      paramParcel.writeString(this.destination);
      paramParcel.writeString(this.carrier);
      paramParcel.writeString(this.flightNumber);
      paramParcel.writeString(this.dateOfFlightJulian);
      paramParcel.writeString(this.compartmentCode);
      paramParcel.writeString(this.seatNumber);
      paramParcel.writeString(this.selecteeIndicator);
    }
  }
  
  @UsedByNative("barhopper-v2-jni.cc")
  public static class GeoPoint
    implements Parcelable
  {
    public static final Parcelable.Creator<GeoPoint> CREATOR = new i();
    @UsedByNative("barhopper-v2-jni.cc")
    public double lat;
    @UsedByNative("barhopper-v2-jni.cc")
    public double lng;
    
    @UsedByNative("barhopper-v2-jni.cc")
    public GeoPoint() {}
    
    private GeoPoint(Parcel paramParcel)
    {
      this.lat = paramParcel.readDouble();
      this.lng = paramParcel.readDouble();
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeDouble(this.lat);
      paramParcel.writeDouble(this.lng);
    }
  }
  
  @UsedByNative("barhopper-v2-jni.cc")
  public static class PersonName
    implements Parcelable
  {
    public static final Parcelable.Creator<PersonName> CREATOR = new j();
    @UsedByNative("barhopper-v2-jni.cc")
    public String first;
    @UsedByNative("barhopper-v2-jni.cc")
    public String formattedName;
    @UsedByNative("barhopper-v2-jni.cc")
    public String last;
    @UsedByNative("barhopper-v2-jni.cc")
    public String middle;
    @UsedByNative("barhopper-v2-jni.cc")
    public String prefix;
    @UsedByNative("barhopper-v2-jni.cc")
    public String pronunciation;
    @UsedByNative("barhopper-v2-jni.cc")
    public String suffix;
    
    @UsedByNative("barhopper-v2-jni.cc")
    public PersonName() {}
    
    private PersonName(Parcel paramParcel)
    {
      this.formattedName = paramParcel.readString();
      this.pronunciation = paramParcel.readString();
      this.prefix = paramParcel.readString();
      this.first = paramParcel.readString();
      this.middle = paramParcel.readString();
      this.last = paramParcel.readString();
      this.suffix = paramParcel.readString();
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.formattedName);
      paramParcel.writeString(this.pronunciation);
      paramParcel.writeString(this.prefix);
      paramParcel.writeString(this.first);
      paramParcel.writeString(this.middle);
      paramParcel.writeString(this.last);
      paramParcel.writeString(this.suffix);
    }
  }
  
  @UsedByNative("barhopper-v2-jni.cc")
  public static class Phone
    implements Parcelable
  {
    public static final Parcelable.Creator<Phone> CREATOR = new k();
    @UsedByNative("barhopper-v2-jni.cc")
    public String number;
    @UsedByNative("barhopper-v2-jni.cc")
    public int type;
    
    @UsedByNative("barhopper-v2-jni.cc")
    public Phone() {}
    
    private Phone(Parcel paramParcel)
    {
      this.type = paramParcel.readInt();
      this.number = paramParcel.readString();
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(this.type);
      paramParcel.writeString(this.number);
    }
  }
  
  @UsedByNative("barhopper-v2-jni.cc")
  public static class Sms
    implements Parcelable
  {
    public static final Parcelable.Creator<Sms> CREATOR = new l();
    @UsedByNative("barhopper-v2-jni.cc")
    public String message;
    @UsedByNative("barhopper-v2-jni.cc")
    public String phoneNumber;
    
    @UsedByNative("barhopper-v2-jni.cc")
    public Sms() {}
    
    private Sms(Parcel paramParcel)
    {
      this.message = paramParcel.readString();
      this.phoneNumber = paramParcel.readString();
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.message);
      paramParcel.writeString(this.phoneNumber);
    }
  }
  
  @UsedByNative("barhopper-v2-jni.cc")
  public static class UrlBookmark
    implements Parcelable
  {
    public static final Parcelable.Creator<UrlBookmark> CREATOR = new m();
    @UsedByNative("barhopper-v2-jni.cc")
    public String title;
    @UsedByNative("barhopper-v2-jni.cc")
    public String url;
    
    @UsedByNative("barhopper-v2-jni.cc")
    public UrlBookmark() {}
    
    private UrlBookmark(Parcel paramParcel)
    {
      this.title = paramParcel.readString();
      this.url = paramParcel.readString();
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.title);
      paramParcel.writeString(this.url);
    }
  }
  
  @UsedByNative("barhopper-v2-jni.cc")
  public static class WiFi
    implements Parcelable
  {
    public static final Parcelable.Creator<WiFi> CREATOR = new n();
    @UsedByNative("barhopper-v2-jni.cc")
    public int encryptionType;
    @UsedByNative("barhopper-v2-jni.cc")
    public boolean isHidden;
    @UsedByNative("barhopper-v2-jni.cc")
    public String password;
    @UsedByNative("barhopper-v2-jni.cc")
    public String ssid;
    
    @UsedByNative("barhopper-v2-jni.cc")
    public WiFi() {}
    
    private WiFi(Parcel paramParcel)
    {
      this.ssid = paramParcel.readString();
      this.password = paramParcel.readString();
      this.encryptionType = paramParcel.readInt();
      boolean bool;
      if (paramParcel.readByte() != 0) {
        bool = true;
      } else {
        bool = false;
      }
      this.isHidden = bool;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.ssid);
      paramParcel.writeString(this.password);
      paramParcel.writeInt(this.encryptionType);
      paramParcel.writeByte((byte)this.isHidden);
    }
  }
  
  class a
    implements Parcelable.Creator<Barcode>
  {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\libraries\barhopper\Barcode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */