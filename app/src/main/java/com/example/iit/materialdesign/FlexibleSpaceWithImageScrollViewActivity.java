package com.example.iit.materialdesign;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.iit.materialdesign.database.MyDB;
import com.example.iit.materialdesign.model.Comment;
import com.example.iit.materialdesign.parse.StarDataObject;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollView;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollViewCallbacks;
import com.github.ksoichiro.android.observablescrollview.ScrollState;
import com.github.ksoichiro.android.observablescrollview.ScrollUtils;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.ValueDependentColor;
import com.jjoe64.graphview.helper.StaticLabelsFormatter;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.DataPointInterface;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.OnDataPointTapListener;
import com.jjoe64.graphview.series.Series;
import com.mikepenz.iconics.typeface.FontAwesome;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.accountswitcher.AccountHeader;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.SectionDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;
import com.mikepenz.materialdrawer.model.interfaces.Nameable;
import com.mikepenz.materialdrawer.util.KeyboardUtil;
import com.nineoldandroids.view.ViewHelper;
import com.nineoldandroids.view.ViewPropertyAnimator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IIT on 4/8/2015.
 */
public class FlexibleSpaceWithImageScrollViewActivity extends BaseActivity implements ObservableScrollViewCallbacks {

    private static final float MAX_TEXT_SCALE_DELTA = 0.3f;
    private static final boolean TOOLBAR_IS_STICKY = false;

    private View mToolbar;
    private View mImageView;
    private View mOverlayView;
    private ObservableScrollView mScrollView;
    private TextView mTitleView, mDetailsView;
    private View mFab;
    private int mActionBarSize;
    private int mFlexibleSpaceShowFabOffset;
    private int mFlexibleSpaceImageHeight;
    private int mFabMargin;
    private int mToolbarColor;
    private boolean mFabIsShown;
    private AccountHeader.Result headerResult;
    private Drawer.Result result = null;
    private MyDB datasource;
    List<Comment> values;
//    Comment comment = null;
    ArrayAdapter<Comment> adapter;
    SharedPreferences id;
    int i;
    String name, starName, starFlux;
    ArrayList<StarDataObject> tableOfDatas;
    StarDataObject starDataObject = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flexiblespacewithimagescrollview);

        // Modify it
       // new AsyncClass(this).execute();

        startService(new Intent(getApplicationContext(), WebData.class));
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        id = getSharedPreferences("id", MODE_PRIVATE);
        final SharedPreferences.Editor editor = id.edit();
//        Context context
        name = getIntent().getStringExtra("position");
//        editor.clear();

        datasource = new MyDB(this);
        datasource.open();
        values = datasource.getAllComments();
        Log.e("Flexible", values.toString());
//        comment = new Comment("", "");

        mFlexibleSpaceImageHeight = getResources().getDimensionPixelSize(R.dimen.flexible_space_image_height);
        mFlexibleSpaceShowFabOffset = getResources().getDimensionPixelSize(R.dimen.flexible_space_show_fab_offset);
        mActionBarSize = getActionBarSize();
        mToolbarColor = getResources().getColor(R.color.primary);

        mToolbar = findViewById(R.id.toolbar);
        if (!TOOLBAR_IS_STICKY) {
            mToolbar.setBackgroundColor(Color.TRANSPARENT);
        }
        mImageView = findViewById(R.id.image);
        mOverlayView = findViewById(R.id.overlay);
        mScrollView = (ObservableScrollView) findViewById(R.id.scroll);
        mScrollView.setScrollViewCallbacks(this);
        mTitleView = (TextView) findViewById(R.id.title);
        mDetailsView = (TextView)findViewById(R.id.details);
//        mTitleView.setText(name);
        setTitle(null);
        mFab = findViewById(R.id.fab);
        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FlexibleSpaceWithImageScrollViewActivity.this, "FAB is clicked", Toast.LENGTH_SHORT).show();
                i= id.getInt("key",0);
                Log.e("key", i+" "+starName);
                datasource.createComment( starName, starFlux);
                editor.putInt("key", i++);
                editor.apply();

            }
        });
        mFabMargin = getResources().getDimensionPixelSize(R.dimen.margin_standard);
        ViewHelper.setScaleX(mFab, 0);
        ViewHelper.setScaleY(mFab, 0);

        ScrollUtils.addOnGlobalLayoutListener(mScrollView, new Runnable() {
            @Override
            public void run() {
                mScrollView.scrollTo(0, mFlexibleSpaceImageHeight - mActionBarSize);
            }
        });

        headerResult = new AccountHeader()
                .withActivity(this)
                .withHeaderBackground(R.drawable.header)
                .addProfiles(
                        new ProfileDrawerItem().withName("Name").withEmail("mail@gmail.com").withIcon(getResources().getDrawable(R.drawable.profile4))
                )
                .withOnAccountHeaderListener(new AccountHeader.OnAccountHeaderListener() {
                    @Override
                    public boolean onProfileChanged(View view, IProfile profile, boolean currentProfile) {
                        return false;
                    }
                })
                .build();

        result = new Drawer()
                .withActivity(this)
                .withToolbar((Toolbar) findViewById(R.id.toolbar))
                .withHeader(R.layout.drawer_header)
                .withAccountHeader(headerResult)
                .addDrawerItems(
                        new PrimaryDrawerItem().withName(R.string.drawer_item_home).withIcon(FontAwesome.Icon.faw_home).withIdentifier(1),
                        new PrimaryDrawerItem().withName(R.string.drawer_item_free_play).withIcon(FontAwesome.Icon.faw_gamepad).withIdentifier(2),
                        new SectionDrawerItem().withName(R.string.drawer_item_section_header),
                        new SecondaryDrawerItem().withName(R.string.drawer_item_settings).withIcon(FontAwesome.Icon.faw_cog).withIdentifier(3)
                )
                .withOnDrawerListener(new Drawer.OnDrawerListener() {
                    @Override
                    public void onDrawerOpened(View drawerView) {
                        Toast.makeText(FlexibleSpaceWithImageScrollViewActivity.this, "onDrawerOpened", Toast.LENGTH_SHORT).show();
                        KeyboardUtil.hideKeyboard(FlexibleSpaceWithImageScrollViewActivity.this);
                    }

                    @Override
                    public void onDrawerClosed(View drawerView) {
                        Toast.makeText(FlexibleSpaceWithImageScrollViewActivity.this, "onDrawerClosed", Toast.LENGTH_SHORT).show();
                    }
                })
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id, IDrawerItem drawerItem) {

                        if (drawerItem != null && drawerItem instanceof Nameable) {
//                            getSupportActionBar().setTitle(((Nameable) drawerItem).getNameRes());

                            if (drawerItem.getIdentifier() == 1) {
//                                startActivity(new Intent(getBaseContext(), MusicFragment.class));
                            } else if (drawerItem.getIdentifier() == 2) {
                                startActivity(new Intent(getBaseContext(), ParallaxToolbarScrollViewActivity.class));
                            } else if (drawerItem.getIdentifier() == 3) {
                                startActivity(new Intent(getBaseContext(), StickyHeaderRecyclerViewActivity.class));
                            }
                        }
                    }
                })
                .withFireOnInitialOnClick(true)
                .withSavedInstance(savedInstanceState)
                .withSelectedItem(0)
                .build();
        initiateValue();
    }

    private void initiateValue() {
        WebData webData = new WebData();
        if(Integer.parseInt(name) == 1){
            mTitleView.setText(getResources().getString(R.string.Name1));
            mDetailsView.setText(getResources().getString(R.string.Descrition1));
            starName= getResources().getString(R.string.a);
            if(webData.getFlux(starName)!=null)
                starFlux=webData.getFlux(starName);
        }
        else if(Integer.parseInt(name) == 2){
            mTitleView.setText(getResources().getString(R.string.Name2));
            mDetailsView.setText(getResources().getString(R.string.Description2));
            starName= getResources().getString(R.string.b);
            if(webData.getFlux(starName)!=null)
                starFlux=webData.getFlux(starName);
        }
        else if(Integer.parseInt(name) == 3){
            mTitleView.setText(getResources().getString(R.string.Name3));
            mDetailsView.setText(getResources().getString(R.string.Description3));
            starName= getResources().getString(R.string.c);
            if(webData.getFlux(starName)!=null)
                starFlux=webData.getFlux(starName);
        }
        else if(Integer.parseInt(name) == 4){
            mTitleView.setText(getResources().getString(R.string.Name4));
            mDetailsView.setText(getResources().getString(R.string.Description4));
            starName= getResources().getString(R.string.d);
            if(webData.getFlux(starName)!=null)
                starFlux=webData.getFlux(starName);
        }
        else if(Integer.parseInt(name) == 5){
            mTitleView.setText(getResources().getString(R.string.Name5));
            mDetailsView.setText(getResources().getString(R.string.Description5));
            starName= getResources().getString(R.string.e);
            if(webData.getFlux(starName)!=null)
                starFlux=webData.getFlux(starName);
        }
        else if(Integer.parseInt(name) == 6){
            mTitleView.setText(getResources().getString(R.string.Name6));
            mDetailsView.setText(getResources().getString(R.string.Description6));
            starName= getResources().getString(R.string.f);
            if(webData.getFlux(starName)!=null)
                starFlux=webData.getFlux(starName);
        }

        else if(Integer.parseInt(name) == 7) {
            mTitleView.setText("Cyg X-2");
            starName= getResources().getString(R.string.g);
            if(webData.getFlux(starName)!=null)
                starFlux=webData.getFlux(starName);
        }

        else if(Integer.parseInt(name) == 8){
            mTitleView.setText(getResources().getString(R.string.Name8));
            mDetailsView.setText(getResources().getString(R.string.Description8));
            starName= getResources().getString(R.string.h);
            if(webData.getFlux(starName)!=null)
                starFlux=webData.getFlux(starName);
        }

        else if(Integer.parseInt(name) == 9){
            mTitleView.setText(getResources().getString(R.string.Name9));
            mDetailsView.setText(getResources().getString(R.string.Description9));
            starName= getResources().getString(R.string.i);
            if(webData.getFlux(starName)!=null)
                starFlux=webData.getFlux(starName);
        }

        else if(Integer.parseInt(name) == 10){
            mTitleView.setText(getResources().getString(R.string.Name10));
            mDetailsView.setText(getResources().getString(R.string.Description10));
            starName= getResources().getString(R.string.j);
            if(webData.getFlux(starName)!=null)
                starFlux=webData.getFlux(starName);
        }
        else if(Integer.parseInt(name) == 11){
            mTitleView.setText(getResources().getString(R.string.Name11));
            mDetailsView.setText(getResources().getString(R.string.Description11));
            starName= getResources().getString(R.string.k);
            if(webData.getFlux(starName)!=null)
                starFlux=webData.getFlux(starName);
        }

        else if(Integer.parseInt(name) == 12){
            mTitleView.setText(getResources().getString(R.string.Name12));
            mDetailsView.setText(getResources().getString(R.string.Description12));
        }

        else {
            mTitleView.setText("GX 3+1");
            starName= getResources().getString(R.string.l);
            if(webData.getFlux(starName)!=null)
                starFlux=webData.getFlux(starName);
        }
    }

    public String getFlux(String name){

        if(tableOfDatas != null){
            for(int j=0; j<tableOfDatas.size(); j++){
                starDataObject = tableOfDatas.get(j);
                if(name.equals(starDataObject.getName())){
                    return starDataObject.getFlux();
                }
            }
        }
        return "0";
    }


    @Override
    public void onScrollChanged(int scrollY, boolean firstScroll, boolean dragging) {
        // Translate overlay and image
        float flexibleRange = mFlexibleSpaceImageHeight - mActionBarSize;
        int minOverlayTransitionY = mActionBarSize - mOverlayView.getHeight();
        ViewHelper.setTranslationY(mOverlayView, ScrollUtils.getFloat(-scrollY, minOverlayTransitionY, 0));
        ViewHelper.setTranslationY(mImageView, ScrollUtils.getFloat(-scrollY / 2, minOverlayTransitionY, 0));

        // Change alpha of overlay
        ViewHelper.setAlpha(mOverlayView, ScrollUtils.getFloat((float) scrollY / flexibleRange, 0, 1));

        // Scale title text
        float scale = 1 + ScrollUtils.getFloat((flexibleRange - scrollY) / flexibleRange, 0, MAX_TEXT_SCALE_DELTA);
        ViewHelper.setPivotX(mTitleView, 0);
        ViewHelper.setPivotY(mTitleView, 0);
        ViewHelper.setScaleX(mTitleView, scale);
        ViewHelper.setScaleY(mTitleView, scale);

        // Translate title text
        int maxTitleTranslationY = (int) (mFlexibleSpaceImageHeight - mTitleView.getHeight() * scale);
        int titleTranslationY = maxTitleTranslationY - scrollY;
        if (TOOLBAR_IS_STICKY) {
            titleTranslationY = Math.max(0, titleTranslationY);
        }
        ViewHelper.setTranslationY(mTitleView, titleTranslationY);

        // Translate FAB
        int maxFabTranslationY = mFlexibleSpaceImageHeight - mFab.getHeight() / 2;
        float fabTranslationY = ScrollUtils.getFloat(
                -scrollY + mFlexibleSpaceImageHeight - mFab.getHeight() / 2,
                mActionBarSize - mFab.getHeight() / 2,
                maxFabTranslationY);
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB) {
            // On pre-honeycomb, ViewHelper.setTranslationX/Y does not set margin,
            // which causes FAB's OnClickListener not working.
            FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) mFab.getLayoutParams();
            lp.leftMargin = mOverlayView.getWidth() - mFabMargin - mFab.getWidth();
            lp.topMargin = (int) fabTranslationY;
            mFab.requestLayout();
        } else {
            ViewHelper.setTranslationX(mFab, mOverlayView.getWidth() - mFabMargin - mFab.getWidth());
            ViewHelper.setTranslationY(mFab, fabTranslationY);
        }

        // Show/hide FAB
        if (fabTranslationY < mFlexibleSpaceShowFabOffset) {
            hideFab();
        } else {
            showFab();
        }

        if (TOOLBAR_IS_STICKY) {
            // Change alpha of toolbar background
            if (-scrollY + mFlexibleSpaceImageHeight <= mActionBarSize) {
                mToolbar.setBackgroundColor(ScrollUtils.getColorWithAlpha(1, mToolbarColor));
            } else {
                mToolbar.setBackgroundColor(ScrollUtils.getColorWithAlpha(0, mToolbarColor));
            }
        } else {
            // Translate Toolbar
            if (scrollY < mFlexibleSpaceImageHeight) {
                ViewHelper.setTranslationY(mToolbar, 0);
            } else {
                ViewHelper.setTranslationY(mToolbar, -scrollY);
            }
        }
    }

    @Override
    public void onDownMotionEvent() {
    }

    @Override
    public void onUpOrCancelMotionEvent(ScrollState scrollState) {
    }

    private void showFab() {
        if (!mFabIsShown) {
            ViewPropertyAnimator.animate(mFab).cancel();
            ViewPropertyAnimator.animate(mFab).scaleX(1).scaleY(1).setDuration(200).start();
            mFabIsShown = true;
        }
    }

    private void hideFab() {
        if (mFabIsShown) {
            ViewPropertyAnimator.animate(mFab).cancel();
            ViewPropertyAnimator.animate(mFab).scaleX(0).scaleY(0).setDuration(200).start();
            mFabIsShown = false;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.delete:
                datasource.deleteComment(starName);

                break;
        }
        return super.onOptionsItemSelected(item);
    }
}