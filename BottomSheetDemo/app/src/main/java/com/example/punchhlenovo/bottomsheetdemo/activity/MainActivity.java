package com.example.punchhlenovo.bottomsheetdemo.activity;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.punchhlenovo.bottomsheetdemo.R;
import com.example.punchhlenovo.bottomsheetdemo.fragment.MapFragment;

public class MainActivity extends AppCompatActivity {
    private BottomSheetBehavior mBottomSheetBehavior;
    private MapFragment mapFragment;
    private Button btn_map_expnd_colle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_map_expnd_colle = (Button) findViewById(R.id.btn_map_expnd_colle);
        initializeMap();
        setBottomSheetViews();
    }

    private void setBottomSheetViews() {
        final View bottomSheet2 = findViewById(R.id.bottom_sheet2);
        mBottomSheetBehavior = BottomSheetBehavior.from(bottomSheet2);
        mBottomSheetBehavior.setHideable(false);
        mBottomSheetBehavior.setPeekHeight(200);

        mBottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                switch (newState) {
                    case BottomSheetBehavior.STATE_HIDDEN:
                        setBottomSheetOnHidden();
                        break;
                    case BottomSheetBehavior.STATE_SETTLING:
                        setBottomSheetOnHidden();
                        break;
                    case BottomSheetBehavior.STATE_COLLAPSED:
                        setBottomSheetOnCollapsed();
                        break;
                    case BottomSheetBehavior.STATE_DRAGGING:
                        setBottomSheetOnDragging();
                        break;
                    case BottomSheetBehavior.STATE_EXPANDED:
                        setBottomSheetOnExpand();
                        break;
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });

        btn_map_expnd_colle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickBtnExpandColle(mBottomSheetBehavior.getState());

            }
        });
    }

    private void setBottomSheetOnExpand() {
    }

    private void setBottomSheetOnDragging() {
    }

    private void setBottomSheetOnCollapsed() {
    }

    private void setBottomSheetOnHidden() {
    }

    private void initializeMap() {
        mapFragment = MapFragment.newInstance();
        getSupportFragmentManager().beginTransaction().replace(R.id.view_fragment_container, mapFragment).commit();
    }

    private void onClickBtnExpandColle(int state) {
        switch (state) {
            case BottomSheetBehavior.STATE_SETTLING:
                handleBottomSheetHiddenView();
                break;
            case BottomSheetBehavior.STATE_EXPANDED:
                handleBottomSheetOnExpand();
                break;
            case BottomSheetBehavior.STATE_COLLAPSED:
                handleBottomSheetOnCollapse();
                break;
        }
    }

    private void handleBottomSheetHiddenView() {
        mBottomSheetBehavior.setPeekHeight((int) getResources().getDimension(R.dimen.bottomsheet_peek_height_px));
        mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        mBottomSheetBehavior.setHideable(false);
    }

    private void handleBottomSheetOnExpand() {
        mBottomSheetBehavior.setPeekHeight(0);
        mBottomSheetBehavior.setHideable(true);
        mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
    }

    private void handleBottomSheetOnCollapse() {
        mBottomSheetBehavior.setPeekHeight(0);
        mBottomSheetBehavior.setHideable(true);
        mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
    }
}
