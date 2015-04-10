package com.example.iit.materialdesign;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.github.ksoichiro.android.observablescrollview.ObservableScrollView;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollViewCallbacks;
import com.github.ksoichiro.android.observablescrollview.ScrollState;
import com.github.ksoichiro.android.observablescrollview.ScrollUtils;
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

/**
 * Created by IIT on 4/8/2015.
 */
public class ParallaxToolbarScrollViewActivity extends BaseActivity implements ObservableScrollViewCallbacks {

    private AccountHeader.Result headerResult;
    private Drawer.Result result = null;
    private View mImageView;
    private View mToolbarView;
    private ObservableScrollView mScrollView;
    private int mParallaxImageHeight;
    private View mFab;
    private int mActionBarSize;
    private int mFlexibleSpaceShowFabOffset;
    private int mFlexibleSpaceImageHeight;
    private int mFabMargin;
    private int mToolbarColor;
    private boolean mFabIsShown;
    TextView body;
    String name, flux;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parallaxtoolbarscrollview);

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));

        body = (TextView)findViewById(R.id.body);
        name = getIntent().getStringExtra("position2");
        Log.e("Parallax", name);
        mFlexibleSpaceImageHeight = getResources().getDimensionPixelSize(R.dimen.flexible_space_image_height);
        mFlexibleSpaceShowFabOffset = getResources().getDimensionPixelSize(R.dimen.flexible_space_show_fab_offset);
        mActionBarSize = getActionBarSize();

        mImageView = findViewById(R.id.image);
        mToolbarView = findViewById(R.id.toolbar);
        mToolbarView.setBackgroundColor(ScrollUtils.getColorWithAlpha(0, getResources().getColor(R.color.primary)));

        mScrollView = (ObservableScrollView) findViewById(R.id.scroll);
        mScrollView.setScrollViewCallbacks(this);

        mFab = findViewById(R.id.fab2);
        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ParallaxToolbarScrollViewActivity.this, flux, Toast.LENGTH_SHORT).show();
//                startActivity(new Intent(getBaseContext(), StickyHeaderRecyclerViewActivity.class));
            }
        });
        mFabMargin = getResources().getDimensionPixelSize(R.dimen.margin_standard);
        ViewHelper.setScaleX(mFab, 0);
        ViewHelper.setScaleY(mFab, 0);

        mParallaxImageHeight = getResources().getDimensionPixelSize(R.dimen.parallax_image_height);

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
                        Toast.makeText(ParallaxToolbarScrollViewActivity.this, "onDrawerOpened", Toast.LENGTH_SHORT).show();
                        KeyboardUtil.hideKeyboard(ParallaxToolbarScrollViewActivity.this);
                    }

                    @Override
                    public void onDrawerClosed(View drawerView) {
                        Toast.makeText(ParallaxToolbarScrollViewActivity.this, "onDrawerClosed", Toast.LENGTH_SHORT).show();
                    }
                })
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id, IDrawerItem drawerItem) {

                        if (drawerItem != null && drawerItem instanceof Nameable) {
//                            getSupportActionBar().setTitle(((Nameable) drawerItem).getNameRes());

                            if (drawerItem.getIdentifier() == 1) {
                                startActivity(new Intent(getBaseContext(), FlexibleSpaceWithImageScrollViewActivity.class));
                            } else if (drawerItem.getIdentifier() == 2) {
//                                startActivity(new Intent(getBaseContext(), GraphFragment.class));
                            } else if (drawerItem.getIdentifier() == 3) {
                                startActivity(new Intent(getBaseContext(), StickyHeaderRecyclerViewActivity.class));
                            }
                        }
                    }
                })
                .withFireOnInitialOnClick(true)
                .withSavedInstance(savedInstanceState)
                .withSelectedItem(1)
                .build();
        initiateValue();
    }

    private void initiateValue() {
        if(name.equals("Sco X-1")){
            body.setText(getResources().getString(R.string.Descrition1));
            flux = "Today's Flux 14994";
        }
        else if(name.equals("GX 5-1")){
            body.setText(getResources().getString(R.string.Description2));
            flux = "Today's Flux 1222";
        }
        else if(name.equals("Crab")){
            body.setText(getResources().getString(R.string.Description3));
            flux = "Today's Flux 1018";
        }
        else if(name.equals("GX 17+2")){
            body.setText(getResources().getString(R.string.Description4));
            flux = "Today's Flux 781";
        }
        else if(name.equals("GX 349+2")){
            body.setText(getResources().getString(R.string.Description5));
            flux = "Today's Flux 739";
        }
        else if(name.equals("GX 9+1")){
            body.setText(getResources().getString(R.string.Description6));
            flux = "Today's Flux 578";
        }
        else if(name.equals("CGX 13+1")){
            body.setText(getResources().getString(R.string.Description9));
            flux = "Today's Flux 434";
        }
        else if(name.equals("GX 340+0")){
            body.setText(getResources().getString(R.string.Description8));
            flux = "Today's Flux 435";
        }
        else if(name.equals("GX 13+1")){
            body.setText(getResources().getString(R.string.Description10));
            flux = "Today's Flux 434";
        }
        else {
            flux = "Today's Flux 302";
        }
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        onScrollChanged(mScrollView.getCurrentScrollY(), false, false);
    }

    @Override
    public void onScrollChanged(int scrollY, boolean firstScroll, boolean dragging) {
        int baseColor = getResources().getColor(R.color.primary);
        float alpha = 1 - (float) Math.max(0, mParallaxImageHeight - scrollY) / mParallaxImageHeight;
        mToolbarView.setBackgroundColor(ScrollUtils.getColorWithAlpha(alpha, baseColor));
        ViewHelper.setTranslationY(mImageView, scrollY / 2);

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
            lp.leftMargin = mScrollView.getWidth() - mFabMargin - mFab.getWidth();
            lp.topMargin = (int) fabTranslationY;
            mFab.requestLayout();
        } else {
            ViewHelper.setTranslationX(mFab, mScrollView.getWidth() - mFabMargin - mFab.getWidth());
            ViewHelper.setTranslationY(mFab, fabTranslationY);
        }

        // Show/hide FAB
        if (fabTranslationY < mFlexibleSpaceShowFabOffset) {
            hideFab();
        } else {
            showFab();
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
}