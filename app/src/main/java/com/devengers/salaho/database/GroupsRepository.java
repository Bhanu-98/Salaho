package com.devengers.salaho.ui.groups;

import android.content.Context;

import com.devengers.salaho.BaseFirestoreRepository;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.SetOptions;

public class GroupsRepository extends BaseFirestoreRepository {
    public GroupsRepository(Context context) {
        super(context);
    }

    public Task<Void> createNewGroup(GroupDetailsModel groupDetailsModel) {
        final DocumentReference newGroupDocument = groupsRef.document(groupDetailsModel.getGroupUniqueId());
        return newGroupDocument.set(groupDetailsModel, SetOptions.merge());
    }
}
