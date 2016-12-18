package com.zhaojunlike.theme.activity;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.zhaojunlike.theme.R;
import com.zhaojunlike.theme.adapter.ViewPagerAdapter;
import com.zhaojunlike.theme.fragment.CategoryFragment;
import com.zhaojunlike.theme.fragment.BlogListFragment;
import com.zhaojunlike.theme.fragment.HotFragment;
import com.zhaojunlike.theme.fragment.HomeFragment;
import com.zhaojunlike.theme.fragment.FlashFragment;

public class MainActivity extends ActionBarActivity {

    private Toolbar m_toolbar;
    private DrawerLayout m_drawerLayout;
    private RecyclerView m_rv_list;
    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private ActionBarDrawerToggle mActionBarDrawerToggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.initView();
    }

    /**
     * 初始化布局
     */
    private void initView() {
        //实例化控件
        mToolbar = (Toolbar) findViewById(R.id.main_toolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.main_dl_drawer);//侧滑
        mTabLayout = (TabLayout) findViewById(R.id.main_tl_tabs);//tab
        mNavigationView = (NavigationView) findViewById(R.id.main_nv_menu);
        mViewPager = (ViewPager) findViewById(R.id.main_vp_content);
        //设置对应属性
        this.initToolBar();
        this.initMainContent();
        this.initAction();
    }

    /**
     * 侧滑菜单
     */
    private void initAction() {
        //设置侧滑菜单点击监听
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                int id = menuItem.getItemId();
                switch (id) {
                    //返回首页
                    case R.id.nav_home:
                        mViewPager.setCurrentItem(0);
                        break;
                }
                mDrawerLayout.closeDrawers();
                return false;
            }
        });
    }

    /**
     * 初始化TabLayout和ViewPager
     */
    private void initMainContent() {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        Fragment homeFragment = new HomeFragment();

        Fragment categoryFragment = new CategoryFragment();//精华
        Fragment hotFragment = new HotFragment();//最火
        Fragment flashFragment = new FlashFragment();//推荐
        Fragment blogListFragment = new BlogListFragment();//博客列表
        adapter.addFragment(homeFragment, "博客首页");
        adapter.addFragment(blogListFragment, "阅读排行");
        adapter.addFragment(flashFragment, "社区闪存");

        adapter.addFragment(categoryFragment, "文章分类");
//        adapter.addFragment(hotFragment, "阅读排行");
        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    /**
     * 初始化ToolBar
     */
    private void initToolBar() {
        mToolbar.setTitle("赵俊的博客");
        this.setSupportActionBar(mToolbar);
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.mActionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.drawer_open, R.string.drawer_close);
        this.mActionBarDrawerToggle.syncState();//同步状态
        this.mDrawerLayout.addDrawerListener(mActionBarDrawerToggle);
    }

}
