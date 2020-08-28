package com.devengers.salaho.ui.groups;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.devengers.salaho.BaseFirestoreRepository;
import com.devengers.salaho.R;
import com.devengers.salaho.Utils;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;

import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CreateGroupFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CreateGroupFragment extends Fragment {
    private EditText groupNameEt, groupDescriptionEt;
    private Button uploadImageButton, createGroupButton;
    private ImageView uploadedImageView;
    private GroupsRepository groupsRepository;

    public CreateGroupFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_create_group, container, false);
        groupNameEt = view.findViewById(R.id.group_name_et);
        groupDescriptionEt = view.findViewById(R.id.group_description_et);
        uploadImageButton = view.findViewById(R.id.upload_group_image_icon);
        uploadedImageView = view.findViewById(R.id.uploaded_group_image);
        groupsRepository = new GroupsRepository(getContext());
        createGroupButton = view.findViewById(R.id.create_group_button);

        uploadImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadGroupImage();
            }
        });
        createGroupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createGroup();
            }
        });
        return view;

    }

    private void uploadGroupImage() {
    }

    private void createGroup() {
        if (!TextUtils.isEmpty(groupNameEt.getText().toString())) {
            String groupName = groupNameEt.getText().toString();
            String groupDescrption = groupDescriptionEt.getText().toString();
            GroupDetailsModel groupDetailsModel = new GroupDetailsModel();
            groupDetailsModel.setGroupName(groupName);
            groupDetailsModel.setGroupDescription(groupDescrption);
            groupDetailsModel.setGroupUniqueId(getGroupUniqueIdentifier(groupDetailsModel.getGroupName()));
            groupsRepository.createNewGroup(groupDetailsModel).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    Utils utils = new Utils();
                    utils.hideKeyboard(getActivity());
                    Snackbar.make(requireView(), "Group Creation Success", Snackbar.LENGTH_LONG).show();
                }
            });

        }
    }

    private String getGroupUniqueIdentifier(String groupName) {
//        String group
        return null;
    }
}