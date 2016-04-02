package me.thahzan.hirethahzan.model;

import android.support.annotation.Nullable;

import java.io.Serializable;
import java.util.List;

/**
 * Created by TaZ on 7/4/15.
 * <p/>
 * Used to hold basic information (ie, Name, Image URL, Email, etc.)
 */
public class BasicInfo implements Serializable {

    private String name;
    private String label;
    private String email;
    @Nullable
    private String picture;
    private String phone;
    @Nullable
    private String website;
    private String summary;
    private UserLocation location;
    private List<Profile> profiles;

    public BasicInfo(String name, String label, String email, @Nullable String picture, String phone,
                     @Nullable String website, String summary, UserLocation location, List<Profile> profiles) {
        this.name = name;
        this.label = label;
        this.email = email;
        this.picture = picture;
        this.phone = phone;
        this.website = website;
        this.summary = summary;
        this.location = location;
        this.profiles = profiles;
    }

    public String getName() {
        return name;
    }

//    public void setName(String name) {
//        this.name = name;
//    }

    public String getLabel() {
        return label;
    }

//    public void setLabel(String label) {
//        this.label = label;
//    }

    public String getEmail() {
        return email;
    }

//    public void setEmail(String email) {
//        this.email = email;
//    }

    @Nullable
    public String getPicture() {
        return picture;
    }

//    public void setPicture(@Nullable String picture) {
//        this.picture = picture;
//    }

    public String getPhone() {
        return phone;
    }

//    public void setPhone(String phone) {
//        this.phone = phone;
//    }

    @Nullable
    public String getWebsite() {
        return website;
    }

//    public void setWebsite(@Nullable String website) {
//        this.website = website;
//    }

    public String getSummary() {
        return summary;
    }

//    public void setSummary(String summary) {
//        this.summary = summary;
//    }

    public UserLocation getLocation() {
        return location;
    }

//    public void setLocation(UserLocation location) {
//        this.location = location;
//    }

    public List<Profile> getProfiles() {
        return profiles;
    }

//    public void setProfiles(List<Profile> profiles) {
//        this.profiles = profiles;
//    }

    public static class UserLocation implements Serializable {
        private String address;
        private String postalCode;
        private String city;
        private String countryCode;
        private String region;

//        public UserLocation(String address, String postalCode, String city, String countryCode, String region) {
//            this.address = address;
//            this.postalCode = postalCode;
//            this.city = city;
//            this.countryCode = countryCode;
//            this.region = region;
//        }

        public String getAddress() {
            return address;
        }

//        public void setAddress(String address) {
//            this.address = address;
//        }

        public String getPostalCode() {
            return postalCode;
        }

//        public void setPostalCode(String postalCode) {
//            this.postalCode = postalCode;
//        }

        public String getCity() {
            return city;
        }

//        public void setCity(String city) {
//            this.city = city;
//        }

        public String getCountryCode() {
            return countryCode;
        }

//        public void setCountryCode(String countryCode) {
//            this.countryCode = countryCode;
//        }

        public String getRegion() {
            return region;
        }

        public String getFormattedAddress() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(address).append(", ").append(city);

            if(postalCode != null && postalCode.length() > 0) {
                stringBuilder.append(" (").append(postalCode).append(")");
            }

            stringBuilder.append("\n").append(region).append("\n").append(countryCode);

            return stringBuilder.toString();
        }

//        public void setRegion(String region) {
//            this.region = region;
//        }

    }

}
