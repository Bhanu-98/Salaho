package com.devengers.salaho.ui.groups;

import com.devengers.salaho.UserModel;
import com.google.firebase.firestore.PropertyName;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class GroupDetailsModel {

    @PropertyName("group_unique_id")
    private String groupUniqueId;

    @PropertyName("group_name")
    private String groupName;

    @PropertyName("group_description")
    private String groupDescription;

    @PropertyName("group_image_url")
    private String groupImageUrl;

    @PropertyName("group_members")
    private ArrayList<String> groupMemberUniqueIdentifier;


    @PropertyName("group_unique_id")
    public String getGroupUniqueId() {
        return groupUniqueId;
    }

    @PropertyName("group_unique_id")
    public void setGroupUniqueId(String groupUniqueId) {
        this.groupUniqueId = groupUniqueId;
    }


    @PropertyName("group_name")
    public String getGroupName() {
        return groupName;
    }

    @PropertyName("group_name")
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @PropertyName("group_description")
    public String getGroupDescription() {
        return groupDescription;
    }

    @PropertyName("group_description")
    public void setGroupDescription(String groupDescription) {
        this.groupDescription = groupDescription;
    }

    @PropertyName("group_image_url")
    public String getGroupImageUrl() {
        return groupImageUrl;
    }

    @PropertyName("group_image_url")
    public void setGroupImageUrl(String groupImageUrl) {
        this.groupImageUrl = groupImageUrl;
    }

    @PropertyName("group_members")
    public ArrayList<String> getGroupMemberUniqueIdentifier() {
        return groupMemberUniqueIdentifier;
    }

    @PropertyName("group_members")
    public void setGroupMemberUniqueIdentifier(ArrayList<String> groupMemberUniqueIdentifier) {
        this.groupMemberUniqueIdentifier = groupMemberUniqueIdentifier;
    }


}
