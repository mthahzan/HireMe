package me.thahzan.hirethahzan;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.graphics.Palette;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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

        resume = Resume.getInstance("{\"basics\":{\"name\":\"M. N. Mohomed Thahzan\",\"label\":\"Android Application Developer\",\"picture\":\"https://scontent-sin1-1.xx.fbcdn.net/hphotos-xat1/t31.0-8/10644290_10152445778021725_5512972876630151693_o.jpg\",\"email\":\"mthahzan@gmail.com\",\"phone\":\"+94 711 911 644\",\"website\":\"\",\"summary\":\"A summary of Mohomed Thahzan.\\nThis may take a few lines...\",\"location\":{\"address\":\"95, Se Street\",\"postalCode\":\"11500\",\"city\":\"Negombo\",\"countryCode\":\"SL\",\"region\":\"Western Province\"},\"profiles\":[{\"network\":\"Twitter\",\"username\":\"mthahzan\",\"url\":\"https://twitter.com/mthahzan\"},{\"network\":\"Facebook\",\"username\":\"mthahzan\",\"url\":\"https://www.facebook.com/mthahzan\"},{\"network\":\"Google Plus\",\"username\":\"ThahzanMohomed\",\"url\":\"https://plus.google.com/+ThahzanMohomed/\"},{\"network\":\"Linkedin\",\"username\":\"mthahzan\",\"url\":\"https://lk.linkedin.com/in/mthahzan\"},{\"network\":\"StackOverflow\",\"username\":\"thahzan-mohomed\",\"url\":\"http://stackoverflow.com/users/2857164/thahzan-mohomed\"}]},\"work\":[{\"company\":\"Ceylon Linux\",\"position\":\"Android Application Developer\",\"website\":\"http://www.ceylonlinux.com\",\"startDate\":\"2014-01-21\",\"endDate\":\"\",\"summary\":\"Started as an intern. Now the best developer in the entire company.\",\"highlights\":[\"Developed Edna Sales Force Automation System (Android Application) and Laugfs Dealer Mapping Android Application from the scratch.\",\"Debugged and enhanced several other Android applications (ie : Lucky Lanka, Laugfs, Ceylon and Foriegn Trades, etc.)\"]}],\"volunteer\":[],\"education\":[{\"institution\":\"ESoft\",\"area\":\"BCS - Certificate Level\",\"studyType\":\"Certificate\",\"startDate\":\"2013-04-01\",\"endDate\":\"2013-09-01\",\"gpa\":\"\",\"courses\":[\"Information Systems\",\"Software Development\",\"Computer and Network Technology\"]},{\"institution\":\"ESoft\",\"area\":\"BCS - Diploma Level\",\"studyType\":\"Diploma\",\"startDate\":\"2013-10-01\",\"endDate\":\"2014-03-01\",\"gpa\":\"\",\"courses\":[\"Computer Networks\",\"Database Systems\",\"Object Oriented Programming\",\"Professional Issues in Information Systems Practice\"]},{\"institution\":\"ESoft\",\"area\":\"BCS - Professional Graduate Diploma Level\",\"studyType\":\"Bachelor\",\"startDate\":\"2014-10-01\",\"endDate\":\"2015-03-01\",\"gpa\":\"\",\"courses\":[\"Network Information Systems\",\"Distributed and Parrallel Systems\",\"Knowledge Based Systems\",\"Web Engineering\"]}],\"awards\":[],\"publications\":[],\"skills\":[{\"name\":\"Android App Development\",\"level\":\"Intermediate\",\"keywords\":[\"Java\",\"Android\",\"XML\",\"JSON\"]},{\"name\":\"iOS Development\",\"level\":\"Beginner\",\"keywords\":[\"Objective-C\",\"Swift\"]}],\"languages\":[{\"language\":\"English\",\"fluency\":\"Fluent both written and orally\"},{\"language\":\"Singhalese\",\"fluency\":\"Native speaker\"},{\"language\":\"Tamil\",\"fluency\":\"Native Speaker\"}],\"interests\":[{\"name\":\"Football\",\"keywords\":[\"Manchester United\",\"Barclays Premier League\",\"UEFA Champions League\"]}],\"references\":[{\"name\":\"Waruna Buwaneka\",\"reference\":\"Director - EI&M Private Limited.\"}]}");

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
            Picasso.with(MainActivity.this).load(resume.getBasics().getPicture()).resize(512, 512).centerCrop()
                    .into(profileImage, new Callback() {
                        @Override
                        public void onSuccess() {
//                            Toast.makeText(MainActivity.this, "Loaded", Toast.LENGTH_SHORT).show();
                            Bitmap bitmap = ((BitmapDrawable)profileImage.getDrawable()).getBitmap();
                            if(bitmap != null) {
//                                AsyncTask paletteAsyncTask = Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
//                                    @Override
//                                    public void onGenerated(Palette palette) {
//                                        int vibrantColor = palette.getVibrantColor(getResources().getColor(R.color.primary));
//                                        changeThemeColor(vibrantColor);
//                                    }
//                                });
//
//                                paletteAsyncTask.execute();

                                Palette palette = Palette.from(bitmap).generate();
                                int vibrantColor = palette.getVibrantColor(getResources().getColor(R.color.primary));
                                changeThemeColor(vibrantColor);
                            }
                        }

                        @Override
                        public void onError() {

                        }
                    });
        }

    }

    private void changeThemeColor(int newColor) {

        //Animated colour change
        int colorFrom = getResources().getColor(R.color.primary);
        ValueAnimator colorAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), colorFrom, newColor);
        colorAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animator) {
                overlayView.setBackgroundColor((Integer)animator.getAnimatedValue());

//                mToolbarColor = (Integer)animator.getAnimatedValue();
//                mOverlayColor = (Integer)animator.getAnimatedValue();



//                mFab.setColorPressed(darkerColor((Integer)animator.getAnimatedValue()));


                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Window window = getWindow();
                    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                    window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                    window.setStatusBarColor(darkerColor((Integer)animator.getAnimatedValue()));
                }

//                mFab.setColorNormal((Integer)animator.getAnimatedValue());

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

    /**
     * This adapter provides three types of fragments as an example.
     * {@linkplain #createItem(int)} should be modified if you use this example for your app.
     */
    private static class NavigationAdapter extends CacheFragmentStatePagerAdapter {

//        private static final String[] TITLES = new String[]{"Applepie", "Butter Cookie", "Cupcake", "Donut", "Eclair", "Froyo", "Gingerbread", "Honeycomb", "Ice Cream Sandwich", "Jelly Bean", "KitKat", "Lollipop"};
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
                    f = new FlexibleSpaceWithImageScrollViewFragment();
                    break;
                }
            }
            f.setArguments(mScrollY);
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
