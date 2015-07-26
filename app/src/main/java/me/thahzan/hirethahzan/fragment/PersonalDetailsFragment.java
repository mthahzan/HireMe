package me.thahzan.hirethahzan.fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.ksoichiro.android.observablescrollview.ObservableScrollView;
import com.github.ksoichiro.android.observablescrollview.ScrollUtils;
import com.github.ksoichiro.android.observablescrollview.Scrollable;

import butterknife.Bind;
import butterknife.ButterKnife;
import me.thahzan.hirethahzan.MainActivity;
import me.thahzan.hirethahzan.R;
import me.thahzan.hirethahzan.model.BasicInfo;
import me.thahzan.hirethahzan.widget.CircularImageView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PersonalDetailsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PersonalDetailsFragment extends FlexibleSpaceWithImageBaseFragment {

    private static final String BASIC_INFO = "basic_info";
    private static final String SCROLL = "scroll";

    private BasicInfo basicInfo;

    private int scrollY;

    @Bind(R.id.main_avatar_imageview) CircularImageView avatar;

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
            scrollY = getArguments().getInt(SCROLL, 0);
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
}
