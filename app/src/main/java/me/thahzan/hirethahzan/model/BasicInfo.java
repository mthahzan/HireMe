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

//    public static BasicInfo parseBasicInfo(JSONObject instance) throws JSONException {
//
//        BasicInfo basicInfo = new BasicInfoBuilder()
//                .setName(instance.getString("name"))
//                .setLabel(instance.getString("label"))
//                .setEmail(instance.getString("email"))
//                .setContactNumber(instance.getString("phone"))
//                .setProfileSummary(instance.getString("summary"))
//                .setUserLocation(UserLocation.parseUserLocation(instance.getJSONObject("location")))
//                .createBasicInfo();
//
//        String imageURL = instance.getString("picture");
//        if(StringHandlerUtil.isValidString(imageURL)) {
//            basicInfo.setPicture(imageURL);
//        }
//
//        String website = instance.getString("website");
//        if(StringHandlerUtil.isValidString(website)){
//            basicInfo.setWebsite(website);
//        }
//
//        return basicInfo;
//    }
//
//    public JSONObject toJSON() {
//
//        HashMap<String, Object> map = new HashMap<>();
//        map.put("name", name);
//        map.put("name", label);
//        map.put("name", email);
//        map.put("name", picture);
//        map.put("name", website);
//        map.put("name", phone);
//        map.put("name", summary);
//        map.put("name", location.toJSON());
//
//        return new JSONObject(map);
//    }

    public static class UserLocation {
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

//        public void setRegion(String region) {
//            this.region = region;
//        }

//        public static UserLocation parseUserLocation(JSONObject instance) throws JSONException {
//            return new UserLocation(instance.getString("address"),
//                    instance.getString("postalCode"), instance.getString("city"),
//                    instance.getString("countryCode"), instance.getString("region"));
//
//        }
//
//        public JSONObject toJSON() {
//
//            HashMap<String, String> map = new HashMap<>();
//            map.put("address", address);
//            map.put("postalCode", postalCode);
//            map.put("city", city);
//            map.put("countryCode", countryCode);
//            map.put("region", region);
//
//            return new JSONObject(map);
//        }

    }

//    public static class BasicInfoBuilder {
//
//        private String name;
//        private String label;
//        private String email;
//        private String imageURL;
//        private String contactNumber;
//        private String website;
//        private String profileSummary;
//        private UserLocation userLocation;
//        private List<Profile> profiles;
//
//        public BasicInfoBuilder setName(String name) {
//            this.name = name;
//            return this;
//        }
//
//        public BasicInfoBuilder setLabel(String label) {
//            this.label = label;
//            return this;
//        }
//
//        public BasicInfoBuilder setEmail(String email) {
//            this.email = email;
//            return this;
//        }
//
//        public BasicInfoBuilder setImageURL(String imageURL) {
//            this.imageURL = imageURL;
//            return this;
//        }
//
//        public BasicInfoBuilder setContactNumber(String contactNumber) {
//            this.contactNumber = contactNumber;
//            return this;
//        }
//
//        public BasicInfoBuilder setWebsite(String website) {
//            this.website = website;
//            return this;
//        }
//
//        public BasicInfoBuilder setProfileSummary(String profileSummary) {
//            this.profileSummary = profileSummary;
//            return this;
//        }
//
//        public BasicInfoBuilder setUserLocation(UserLocation userLocation) {
//            this.userLocation = userLocation;
//            return this;
//        }
//
//        public BasicInfoBuilder setProfiles(List<Profile> profiles) {
//            this.profiles = profiles;
//            return this;
//        }
//
//        public BasicInfo createBasicInfo() {
//            return new BasicInfo(name, label, email, imageURL, contactNumber, website, profileSummary,
//                    userLocation, profiles);
//        }
//    }

}
