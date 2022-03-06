package com.example.skycore.pojo

import com.google.gson.annotations.SerializedName

data class Restaurant(val name: String, val image_url: String, val alias: String, val is_closed: Boolean)

//class      Message {
//
//    @SerializedName("Emp_Id")
//    @Expose
//    private Integer empId;
//    @SerializedName("Emp_First_Name")
//    @Expose
//    private String empFirstName;
//    @SerializedName("Emp_Last_Name")
//    @Expose
//    private String empLastName;
//    @SerializedName("Emp_Email")
//    @Expose
//    private String empEmail;
//    @SerializedName("Emp_Address")
//    @Expose
//    private String empAddress;
//    @SerializedName("Emp_Phone_No")
//    @Expose
//    private String empPhoneNo;
//    @SerializedName("Emp_Password")
//    @Expose
//    private String empPassword;
//    @SerializedName("Emp_Photo")
//    @Expose
//    private String empPhoto;
//    @SerializedName("Is_Resign")
//    @Expose
//    private Integer isResign;
//    @SerializedName("Joining_Date")
//    @Expose
//    private String joiningDate;
//    @SerializedName("Resign_Date")
//    @Expose
//    private String resignDate;
//    @SerializedName("sms_status")
//    @Expose
//    private Integer smsStatus;
//}
