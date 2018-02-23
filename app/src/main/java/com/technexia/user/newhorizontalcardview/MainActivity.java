package com.technexia.user.newhorizontalcardview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.azoft.carousellayoutmanager.CarouselLayoutManager;
import com.azoft.carousellayoutmanager.CarouselZoomPostLayoutListener;
import com.azoft.carousellayoutmanager.CenterScrollListener;

import static android.view.accessibility.AccessibilityEvent.INVALID_POSITION;

public class MainActivity extends AppCompatActivity {

    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new Adapter(this);
        RecyclerView rh = (RecyclerView) findViewById(R.id.list_horizontal);
        initRecyclerView(rh, new CarouselLayoutManager(CarouselLayoutManager.HORIZONTAL, false), adapter);




    }

    private void initRecyclerView(final RecyclerView recyclerView, final CarouselLayoutManager layoutManager, final Adapter adapter) {
        // enable zoom effect. this line can be customized
        layoutManager.setPostLayoutListener(new CarouselZoomPostLayoutListener());

        layoutManager.setMaxVisibleItems(3);

        recyclerView.setLayoutManager(layoutManager);
        // we expect only fixed sized item for now
        recyclerView.setHasFixedSize(true);
        // sample adapter with random data
        recyclerView.setAdapter(adapter);
        // enable center post scrolling
        recyclerView.addOnScrollListener(new CenterScrollListener());
        adapter.mPosition[0] = 2;
        adapter.notifyDataSetChanged();
        layoutManager.addOnItemSelectionListener(new CarouselLayoutManager.OnCenterItemSelectionListener() {

            @Override
            public void onCenterItemChanged(final int adapterPosition) {
                if (INVALID_POSITION != adapterPosition) {
                    final int value = adapter.mPosition[adapterPosition];
                    adapter.mPosition[adapterPosition] = (value % 4) + (value / 4 + 1) * 4;
                    adapter.notifyItemChanged(adapterPosition);
                }
            }
        });
    }

}
