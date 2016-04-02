package me.thahzan.hirethahzan.fragment;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.ksoichiro.android.observablescrollview.ObservableScrollView;
import com.github.ksoichiro.android.observablescrollview.ScrollUtils;
import com.github.ksoichiro.android.observablescrollview.Scrollable;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import me.thahzan.hirethahzan.MainActivity;
import me.thahzan.hirethahzan.R;
import me.thahzan.hirethahzan.model.BasicInfo;
import me.thahzan.hirethahzan.model.Profile;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PersonalDetailsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PersonalDetailsFragment extends FlexibleSpaceWithImageBaseFragment {

    private static final String BASIC_INFO = "basic_info";
    private static final String SCROLL = "scroll";

    private BasicInfo basicInfo;

//    private int scrollY;

    @Bind(R.id.main_mini_bio_tv_summary)
    TextView summary;

    @Bind(R.id.main_profiles_tv_contact_number)
    TextView contactNumber;

    @Bind(R.id.main_profiles_tv_home_address)
    TextView address;

    @Bind(R.id.main_profiles_container)
    LinearLayout profiles;

    private LayoutInflater layoutInflater;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param basicInfo The {@link BasicInfo} of the {@link me.thahzan.hirethahzan.model.Resume}
     * @return A new instance of fragment PersonalDetailsFragment.
     */
    public static PersonalDetailsFragment newInstance(BasicInfo basicInfo, int scrollY) {
        PersonalDetailsFragment fragment = new PersonalDetailsFragment();
        Bundle args = new Bundle();
        args.putSerializable(BASIC_INFO, basicInfo);
        args.putInt(SCROLL, scrollY);
        fragment.setArguments(args);
        return fragment;
    }

    public PersonalDetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            basicInfo = (BasicInfo) getArguments().getSerializable(BASIC_INFO);
//            scrollY = getArguments().getInt(SCROLL, 0);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_personal_details, container, false);

        ButterKnife.bind(this, rootView);

        final ObservableScrollView scrollView = (ObservableScrollView) rootView.findViewById(R.id.scroll);
        // TouchInterceptionViewGroup should be a parent view other than ViewPager.
        // This is a workaround for the issue #117:
        // https://github.com/ksoichiro/Android-ObservableScrollView/issues/117
        scrollView.setTouchInterceptionViewGroup((ViewGroup) rootView.findViewById(R.id.fragment_root));

        // Scroll to the specified offset after layout
        Bundle args = getArguments();
        if (args != null && args.containsKey(ARG_SCROLL_Y)) {
            final int scrollY = args.getInt(ARG_SCROLL_Y, 0);
            ScrollUtils.addOnGlobalLayoutListener(scrollView, new Runnable() {
                @Override
                public void run() {
                    scrollView.scrollTo(0, scrollY);
                }
            });
            updateFlexibleSpace(scrollY, rootView);
        } else {
            updateFlexibleSpace(0, rootView);
        }

        scrollView.setScrollViewCallbacks(this);

        summary.setText(basicInfo.getSummary());
        contactNumber.setText(basicInfo.getPhone());

        contactNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:" + basicInfo.getPhone()));
                startActivity(callIntent);
            }
        });

        if(basicInfo.getLocation() != null) {
            address.setText(basicInfo.getLocation().getFormattedAddress());
        } else {
            address.setText("N/A");
        }

        List<Profile> profiles = basicInfo.getProfiles();
        if(profiles != null && profiles.size() > 0) {
            for (Profile profile : profiles) {
                populateProfile(profile);
            }
        }

        return rootView;
    }


    @Override
    protected void updateFlexibleSpace(int scrollY, View view) {
        ObservableScrollView scrollView = (ObservableScrollView) view.findViewById(R.id.scroll);

        // Also pass this event to parent Activity
        MainActivity parentActivity =
                (MainActivity) getActivity();
        if (parentActivity != null) {
            parentActivity.onScrollChanged(scrollY, scrollView);
        }
    }

    @Override
    public void updateFlexibleSpace(int scrollY) {
        // Sometimes scrollable.getCurrentScrollY() and the real scrollY has different values.
        // As a workaround, we should call scrollVerticallyTo() to make sure that they match.
        Scrollable s = getScrollable();
        s.scrollVerticallyTo(scrollY);

        // If scrollable.getCurrentScrollY() and the real scrollY has the same values,
        // calling scrollVerticallyTo() won't invoke scroll (or onScrollChanged()), so we call it here.
        // Calling this twice is not a problem as long as updateFlexibleSpace(int, View) has idempotence.
        updateFlexibleSpace(scrollY, getView());
    }

    private void populateProfile(final Profile profile) {

        Object[] details = profile.getAppropriateDetails();
        if(details != null) {
            // Username with appropriate prefix
            String username = details[1] + profile.getUsername();

            if(layoutInflater == null) {
                layoutInflater = LayoutInflater.from(getActivity());
            }

            View profileTemplate = layoutInflater.inflate(R.layout.inflate_view_profile, null, false);

            ImageView logo = (ImageView) profileTemplate.findViewById(R.id.profile_icon);
            TextView label = (TextView) profileTemplate.findViewById(R.id.profile_label);

            logo.setImageDrawable(ContextCompat.getDrawable(getActivity(), (Integer) details[0]));
            label.setText(username);

            profileTemplate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent webIntent = new Intent("android.intent.action.VIEW", Uri.parse(profile.getProfileURL()));
                    startActivity(webIntent);
                }
            });

            profiles.addView(profileTemplate);

        }



    }

}
