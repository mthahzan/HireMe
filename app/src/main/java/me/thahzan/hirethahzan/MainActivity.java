package me.thahzan.hirethahzan;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.graphics.Palette;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.ksoichiro.android.observablescrollview.CacheFragmentStatePagerAdapter;
import com.github.ksoichiro.android.observablescrollview.ScrollUtils;
import com.github.ksoichiro.android.observablescrollview.Scrollable;
import com.nineoldandroids.view.ViewHelper;
import com.nineoldandroids.view.ViewPropertyAnimator;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

import me.thahzan.hirethahzan.fragment.FlexibleSpaceWithImageBaseFragment;
import me.thahzan.hirethahzan.fragment.FlexibleSpaceWithImageScrollViewFragment;
import me.thahzan.hirethahzan.fragment.PersonalDetailsFragment;
import me.thahzan.hirethahzan.model.Resume;
import me.thahzan.hirethahzan.widget.SlidingTabLayout;

public class MainActivity extends BaseActivity {

    protected static final float MAX_TEXT_SCALE_DELTA = 0.3f;
    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    private ViewPager mPager;
    private NavigationAdapter mPagerAdapter;
    private SlidingTabLayout mSlidingTabLayout;
    private int mFlexibleSpaceHeight;
    private int mTabHeight;

    private Resume resume;

    private TextView titleView;
    private View overlayView;
    private ImageView profileImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resume = Resume.getInstance("{\n" +
                "  \"basics\": {\n" +
                "    \"name\": \"M. N. Mohomed Thahzan\",\n" +
                "    \"label\": \"Android Application Developer\",\n" +
                "    \"picture\": \"https://lh3.googleusercontent.com/S2AbRJNM8HIqpDLNP8xMRmSUXgoBQ1QPm2zSJ6L2WhL2sNmfEdjlpE2FinI3ttQA415tyHbVR9BldxVQuabYrP_tsYSpe-_02exXYXGndf0suTSeYf8_PxVYmOG1F0TGn4_nX7i7ecU2zuU9wIKRjWOjqyQB2p5UFLDYIyrPSHjUUBecrH33q03OcxCEbUqb7r1iqfMHXvr8LxaBa7SkT8bNTRiVEaT-ua58-XcM-sgUNcOcCS2DFvIVhbXNIjMxI-zItYklkMORwF69KMmwS2OM5qWZ52zcmuf0X3dlEEfg3U1APLP5sMaZdFdsU0tMDQrsbs8lxx85hE8MogbJ71XpBLOqcSSvpV-kLqA6c95U3DTx33YIR540t1nov_5zKdOd53TNtTDIbb3gZeSeW2W5Q7QqfU506zA2Bv8isj90YXybJcrKQoaifPA_s8_7Uju_LGfRw1Q5dmyGT77qSi9Oko4GFlcDKbR1QLepy6ad0ztuSLuDyUZaSbk13ewriL0NRJYZ8hcvZZjJaPbg0tyBHIVKwOG2U0NbcTHklN4=s608-no\",\n" +
                "    \"email\": \"mthahzan@gmail.com\",\n" +
                "    \"phone\": \"+94 711 911 644\",\n" +
                "    \"website\": \"\",\n" +
                "    \"summary\": \"A summary of Mohomed Thahzan.\\nThis may take a few lines...\",\n" +
                "    \"location\": {\n" +
                "      \"address\": \"95, Se Street\",\n" +
                "      \"postalCode\": \"11500\",\n" +
                "      \"city\": \"Negombo\",\n" +
                "      \"countryCode\": \"SL\",\n" +
                "      \"region\": \"Western Province\"\n" +
                "    },\n" +
                "    \"profiles\": [\n" +
                "      {\n" +
                "        \"network\": \"Twitter\",\n" +
                "        \"username\": \"mthahzan\",\n" +
                "        \"url\": \"https://twitter.com/mthahzan\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"network\": \"Facebook\",\n" +
                "        \"username\": \"mthahzan\",\n" +
                "        \"url\": \"https://www.facebook.com/mthahzan\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"network\": \"Google Plus\",\n" +
                "        \"username\": \"ThahzanMohomed\",\n" +
                "        \"url\": \"https://plus.google.com/+ThahzanMohomed/\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"network\": \"Linkedin\",\n" +
                "        \"username\": \"mthahzan\",\n" +
                "        \"url\": \"https://lk.linkedin.com/in/mthahzan\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"network\": \"StackOverflow\",\n" +
                "        \"username\": \"thahzan-mohomed\",\n" +
                "        \"url\": \"http://stackoverflow.com/users/2857164/thahzan-mohomed\"\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  \"work\": [\n" +
                "    {\n" +
                "      \"company\": \"Ceylon Linux\",\n" +
                "      \"position\": \"Android Application Developer\",\n" +
                "      \"website\": \"http://www.ceylonlinux.com\",\n" +
                "      \"startDate\": \"2014-01-21\",\n" +
                "      \"endDate\": \"2015-08-26\",\n" +
                "      \"summary\": \"Rose through the ranks from an intern to senior developer\",\n" +
                "      \"highlights\": [\n" +
                "        \"Developed Edna Sales Force Automation System (Android Application) and Laugfs Dealer Mapping Android Application from the scratch.\",\n" +
                "        \"Debugged and enhanced several other Android applications (ie : Lucky Lanka, Laugfs, Ceylon and Foriegn Trades, etc.)\"\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"company\": \"Calcey Technologies\",\n" +
                "      \"position\": \"Software Engineer\",\n" +
                "      \"website\": \"http://www.calcey.com\",\n" +
                "      \"startDate\": \"2014-08-28\",\n" +
                "      \"endDate\": \"\",\n" +
                "      \"summary\": \"Starting life as a Software Engineer\",\n" +
                "      \"highlights\": [\n" +
                "        \"Developed the product - Project Dashboard\"\n" +
                "      ]\n" +
                "    }\n" +
                "  ],\n" +
                "  \"volunteer\": [],\n" +
                "  \"education\": [\n" +
                "    {\n" +
                "      \"institution\": \"ESoft\",\n" +
                "      \"area\": \"BCS - Certificate Level\",\n" +
                "      \"studyType\": \"Certificate\",\n" +
                "      \"startDate\": \"2013-04-01\",\n" +
                "      \"endDate\": \"2013-09-01\",\n" +
                "      \"gpa\": \"\",\n" +
                "      \"courses\": [\n" +
                "        \"Information Systems\",\n" +
                "        \"Software Development\",\n" +
                "        \"Computer and Network Technology\"\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"institution\": \"ESoft\",\n" +
                "      \"area\": \"BCS - Diploma Level\",\n" +
                "      \"studyType\": \"Diploma\",\n" +
                "      \"startDate\": \"2013-10-01\",\n" +
                "      \"endDate\": \"2014-03-01\",\n" +
                "      \"gpa\": \"\",\n" +
                "      \"courses\": [\n" +
                "        \"Computer Networks\",\n" +
                "        \"Database Systems\",\n" +
                "        \"Object Oriented Programming\",\n" +
                "        \"Professional Issues in Information Systems Practice\"\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"institution\": \"ESoft\",\n" +
                "      \"area\": \"BCS - Professional Graduate Diploma Level\",\n" +
                "      \"studyType\": \"Bachelor\",\n" +
                "      \"startDate\": \"2014-10-01\",\n" +
                "      \"endDate\": \"2015-03-01\",\n" +
                "      \"gpa\": \"\",\n" +
                "      \"courses\": [\n" +
                "        \"Network Information Systems\",\n" +
                "        \"Distributed and Parrallel Systems\",\n" +
                "        \"Knowledge Based Systems\",\n" +
                "        \"Web Engineering\"\n" +
                "      ]\n" +
                "    }\n" +
                "  ],\n" +
                "  \"awards\": [],\n" +
                "  \"publications\": [],\n" +
                "  \"skills\": [\n" +
                "    {\n" +
                "      \"name\": \"Android App Development\",\n" +
                "      \"level\": \"Intermediate\",\n" +
                "      \"keywords\": [\n" +
                "        \"Java\",\n" +
                "        \"Android\",\n" +
                "        \"XML\",\n" +
                "        \"JSON\"\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"name\": \"iOS Development\",\n" +
                "      \"level\": \"Beginner\",\n" +
                "      \"keywords\": [\n" +
                "        \"Objective-C\",\n" +
                "        \"Swift\"\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"name\": \"Web Application Development\",\n" +
                "      \"level\": \"Beginner\",\n" +
                "      \"keywords\": [\n" +
                "        \"Javascript\",\n" +
                "        \"Single Page Applications\",\n" +
                "        \"NodeJS\",\n" +
                "        \"EmberJS\",\n" +
                "        \"SailsJS\"\n" +
                "      ]\n" +
                "    }\n" +
                "  ],\n" +
                "  \"languages\": [\n" +
                "    {\n" +
                "      \"language\": \"English\",\n" +
                "      \"fluency\": \"Fluent both written and orally\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"language\": \"Singhalese\",\n" +
                "      \"fluency\": \"Native speaker\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"language\": \"Tamil\",\n" +
                "      \"fluency\": \"Native Speaker\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"interests\": [\n" +
                "    {\n" +
                "      \"name\": \"Football\",\n" +
                "      \"keywords\": [\n" +
                "        \"Manchester United\",\n" +
                "        \"Barclays Premier League\",\n" +
                "        \"UEFA Champions League\"\n" +
                "      ]\n" +
                "    }\n" +
                "  ],\n" +
                "  \"references\": [\n" +
                "    {\n" +
                "      \"name\": \"Waruna Buwaneka\",\n" +
                "      \"reference\": \"Director - EI&M Private Limited.\"\n" +
                "    }\n" +
                "  ]\n" +
                "}");

        mPagerAdapter = new NavigationAdapter(getSupportFragmentManager(), resume);
        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setAdapter(mPagerAdapter);
        mFlexibleSpaceHeight = getResources().getDimensionPixelSize(R.dimen.flexible_space_image_height);
        mTabHeight = getResources().getDimensionPixelSize(R.dimen.tab_height);

        titleView = (TextView) findViewById(R.id.title);
        titleView.setText("Hire ME");

        profileImage = (ImageView) findViewById(R.id.image);
        overlayView = findViewById(R.id.overlay);

        mSlidingTabLayout = (SlidingTabLayout) findViewById(R.id.sliding_tabs);
        mSlidingTabLayout.setCustomTabView(R.layout.tab_indicator, android.R.id.text1);
        mSlidingTabLayout.setSelectedIndicatorColors(getResources().getColor(R.color.accent));
        mSlidingTabLayout.setDistributeEvenly(true);
        mSlidingTabLayout.setViewPager(mPager);

        // Initialize the first Fragment's state when layout is completed.
        ScrollUtils.addOnGlobalLayoutListener(mSlidingTabLayout, new Runnable() {
            @Override
            public void run() {
                translateTab(0, false);
            }
        });

        if(resume.getBasics().getPicture() != null) {
            Picasso
                .with(MainActivity.this).load(resume.getBasics().getPicture()).resize(512, 512).centerCrop()
                .into(profileImage, new Callback() {
                    @Override
                    public void onSuccess() {
                        Bitmap bitmap = ((BitmapDrawable)profileImage.getDrawable()).getBitmap();
                        if(bitmap != null) {
                            Palette palette = Palette.from(bitmap).generate();
                            int vibrantColor = palette.getVibrantColor(getResources().getColor(R.color.primary));
                            changeThemeColor(vibrantColor);
                        }
                    }

                    @Override
                    public void onError() {
                        Log.e(LOG_TAG, "onError called");
                    }
                });
        }

    }

    /**
     * Incremental color change of views.
     * @param newColor The color to change to.
     */
    private void changeThemeColor(int newColor) {
        //Animated colour change
        int colorFrom = getResources().getColor(R.color.primary);
        ValueAnimator colorAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), colorFrom, newColor);
        colorAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animator) {
                overlayView.setBackgroundColor((Integer)animator.getAnimatedValue());

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Window window = getWindow();
                    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                    window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                    window.setStatusBarColor(darkerColor((Integer)animator.getAnimatedValue()));
                }

            }

        });
        colorAnimation.setDuration(800);
        colorAnimation.start();
    }

    private int darkerColor(int color) {
        float[] hsv = new float[3];
        Color.colorToHSV(color, hsv);
        hsv[2] *= 0.9f; // value component
        return Color.HSVToColor(hsv);
    }

    /**
     * Called by children Fragments when their scrollY are changed.
     * They all call this method even when they are inactive
     * but this Activity should listen only the active child,
     * so each Fragments will pass themselves for Activity to check if they are active.
     *
     * @param scrollY scroll position of Scrollable
     * @param s       caller Scrollable view
     */
    public void onScrollChanged(int scrollY, Scrollable s) {
        FlexibleSpaceWithImageBaseFragment fragment =
                (FlexibleSpaceWithImageBaseFragment) mPagerAdapter.getItemAt(mPager.getCurrentItem());
        if (fragment == null) {
            return;
        }
        View view = fragment.getView();
        if (view == null) {
            return;
        }
        Scrollable scrollable = (Scrollable) view.findViewById(R.id.scroll);
        if (scrollable == null) {
            return;
        }
        if (scrollable == s) {
            // This method is called by not only the current fragment but also other fragments
            // when their scrollY is changed.
            // So we need to check the caller(S) is the current fragment.
            int adjustedScrollY = Math.min(scrollY, mFlexibleSpaceHeight - mTabHeight);
            translateTab(adjustedScrollY, false);
            propagateScroll(adjustedScrollY);
        }
    }

    private void translateTab(int scrollY, boolean animated) {
        int flexibleSpaceImageHeight = getResources().getDimensionPixelSize(R.dimen.flexible_space_image_height);
        int tabHeight = getResources().getDimensionPixelSize(R.dimen.tab_height);
//        TextView titleView = (TextView) findViewById(R.id.title);

        // Translate overlay and image
        float flexibleRange = flexibleSpaceImageHeight - getActionBarSize();
        int minOverlayTransitionY = tabHeight - overlayView.getHeight();
        ViewHelper.setTranslationY(overlayView, ScrollUtils.getFloat(-scrollY, minOverlayTransitionY, 0));
        ViewHelper.setTranslationY(profileImage, ScrollUtils.getFloat(-scrollY / 2, minOverlayTransitionY, 0));

        // Change alpha of overlay
        ViewHelper.setAlpha(overlayView, ScrollUtils.getFloat((float) scrollY / flexibleRange, 0, 1));

        // Scale title text
        float scale = 1 + ScrollUtils.getFloat((flexibleRange - scrollY - tabHeight) / flexibleRange, 0, MAX_TEXT_SCALE_DELTA);
        setPivotXToTitle(titleView);
        ViewHelper.setPivotY(titleView, 0);
        ViewHelper.setScaleX(titleView, scale);
        ViewHelper.setScaleY(titleView, scale);

        // Translate title text
        int maxTitleTranslationY = flexibleSpaceImageHeight - tabHeight - getActionBarSize();
        int titleTranslationY = maxTitleTranslationY - scrollY;
        ViewHelper.setTranslationY(titleView, titleTranslationY);

        // If tabs are moving, cancel it to start a new animation.
        ViewPropertyAnimator.animate(mSlidingTabLayout).cancel();
        // Tabs will move between the top of the screen to the bottom of the image.
        float translationY = ScrollUtils.getFloat(-scrollY + mFlexibleSpaceHeight - mTabHeight, 0, mFlexibleSpaceHeight - mTabHeight);
        if (animated) {
            // Animation will be invoked only when the current tab is changed.
            ViewPropertyAnimator.animate(mSlidingTabLayout)
                    .translationY(translationY)
                    .setDuration(200)
                    .start();
        } else {
            // When Fragments' scroll, translate tabs immediately (without animation).
            ViewHelper.setTranslationY(mSlidingTabLayout, translationY);
        }
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    private void setPivotXToTitle(View view) {
        final TextView mTitleView = (TextView) view.findViewById(R.id.title);
        Configuration config = getResources().getConfiguration();
        if (Build.VERSION_CODES.JELLY_BEAN_MR1 <= Build.VERSION.SDK_INT
                && config.getLayoutDirection() == View.LAYOUT_DIRECTION_RTL) {
            ViewHelper.setPivotX(mTitleView, view.findViewById(android.R.id.content).getWidth());
        } else {
            ViewHelper.setPivotX(mTitleView, 0);
        }
    }

    private void propagateScroll(int scrollY) {
        // Set scrollY for the fragments that are not created yet
        mPagerAdapter.setScrollY(scrollY);

        // Set scrollY for the active fragments
        for (int i = 0; i < mPagerAdapter.getCount(); i++) {
            // Skip current item
            if (i == mPager.getCurrentItem()) {
                continue;
            }

            // Skip destroyed or not created item
            FlexibleSpaceWithImageBaseFragment f =
                    (FlexibleSpaceWithImageBaseFragment) mPagerAdapter.getItemAt(i);
            if (f == null) {
                continue;
            }

            View view = f.getView();
            if (view == null) {
                continue;
            }
            f.setScrollY(scrollY, mFlexibleSpaceHeight);
            f.updateFlexibleSpace(scrollY);
        }
    }

    private static class NavigationAdapter extends CacheFragmentStatePagerAdapter {

        private final List<String> titles;

        private int mScrollY;
        private Resume resume;

        public NavigationAdapter(FragmentManager fm, Resume resume) {
            super(fm);
            this.resume = resume;
            this.titles = resume.getTitles();
        }

        public void setScrollY(int scrollY) {
            mScrollY = scrollY;
        }

        @Override
        protected Fragment createItem(int position) {
            FlexibleSpaceWithImageBaseFragment f;
            switch (position) {
                case 0: {
                    f = PersonalDetailsFragment.newInstance(resume.getBasics(), mScrollY);
                    break;
                }
                default: {
                    f = FlexibleSpaceWithImageScrollViewFragment.getInstance(mScrollY);
                    break;
                }
            }
            return f;
        }

        @Override
        public int getCount() {
            return titles.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles.get(position);
        }
    }

}
