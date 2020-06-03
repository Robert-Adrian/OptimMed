package com.example.optimmed.ui.home;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.optimmed.R;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private LineChart ekgChart;
    private BarChart pulsChart;
    private PieChart umiditateChart;
    private PieChart temperaturaChart;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
       // final TextView textView = root.findViewById(R.id.text_home);
        root.setBackgroundColor(Color.WHITE);

        umiditateChart = (PieChart) root.findViewById(R.id.umiditate);
        temperaturaChart = (PieChart) root.findViewById(R.id.temperatura);

        umiditateChart.getDescription().setEnabled(true);
        Description descriptionUmid = new Description();
        descriptionUmid.setText("Umiditate");
        descriptionUmid.setTextSize(15);
        descriptionUmid.setTextColor(Color.WHITE);
        umiditateChart.setDescription(descriptionUmid);
        umiditateChart.setExtraOffsets(5,5,5,2);
        //umiditateChart.setDragDecelerationFrictionCoef(0.99f);
        umiditateChart.setDrawHoleEnabled(true);
        umiditateChart.setHoleColor(Color.WHITE);
        umiditateChart.setTransparentCircleRadius(15f);
        umiditateChart.setCenterText("34 %");
        umiditateChart.invalidate();
        umiditateChart.setRotationEnabled(false);

        ArrayList<PieEntry> yValuesUmid = new ArrayList<>();
        yValuesUmid.add(new PieEntry(34f));
        yValuesUmid.add(new PieEntry(66f));
        umiditateChart.animateY(1000, Easing.EasingOption.EaseInOutCubic);

        PieDataSet dataSetUmi = new PieDataSet(yValuesUmid, "");
        dataSetUmi.setSliceSpace(0f);
        dataSetUmi.setSelectionShift(5f);

        dataSetUmi.setColors(Color.BLUE, Color.GRAY);

        PieData dataUmid = new PieData(dataSetUmi);
        dataUmid.setValueTextSize(0f);
        dataUmid.setValueTextColor(Color.WHITE);
        umiditateChart.setData(dataUmid);


        temperaturaChart.getDescription().setEnabled(true);
        Description descriptionTemp = new Description();
        descriptionTemp.setText("Temperatura");
        descriptionTemp.setTextSize(15);
        descriptionTemp.setTextColor(Color.WHITE);
        temperaturaChart.setDescription(descriptionTemp);
        temperaturaChart.setExtraOffsets(5,5,5,2);
        temperaturaChart.setDrawHoleEnabled(true);
        temperaturaChart.setHoleColor(Color.WHITE);
        temperaturaChart.setTransparentCircleRadius(15f);
        temperaturaChart.setCenterText("24 C");
        temperaturaChart.invalidate();
        temperaturaChart.setRotationEnabled(false);

        ArrayList<PieEntry> yValuesTemp = new ArrayList<>();
        yValuesTemp.add(new PieEntry(24f));
        yValuesTemp.add(new PieEntry(76f));

        temperaturaChart.animateY(1000, Easing.EasingOption.EaseInOutCubic);

        PieDataSet dataSetTemp = new PieDataSet(yValuesTemp, "");
        dataSetTemp.setSliceSpace(0f);
        dataSetTemp.setSelectionShift(5f);
        dataSetTemp.setColors(Color.BLUE, Color.GRAY);

        PieData dataTemp = new PieData(dataSetTemp);
        dataTemp.setValueTextSize(0f);
        dataTemp.setValueTextColor(Color.WHITE);
        temperaturaChart.setData(dataTemp);



        ekgChart = (LineChart) root.findViewById(R.id.ekg_graphic);
        pulsChart = (BarChart) root.findViewById(R.id.puls_graphic);

        ekgChart.setDragEnabled(true);
        ekgChart.setScaleEnabled(true);
        ekgChart.getAxisRight().setEnabled(false);

        pulsChart.setDrawBarShadow(false);
        pulsChart.setDrawValueAboveBar(true);
        pulsChart.setMaxVisibleValueCount(50);
        pulsChart.setPinchZoom(false);
       // pulsChart.setDrawGridBackground(true);
        pulsChart.getAxisRight().setEnabled(false);

        ArrayList<Entry> yValuesEKG = new ArrayList<>();

        yValuesEKG.add(new Entry(0, 60f));
        yValuesEKG.add(new Entry(1, 50f));
        yValuesEKG.add(new Entry(2, 70f));
        yValuesEKG.add(new Entry(3, 30f));
        yValuesEKG.add(new Entry(4, 60f));
        yValuesEKG.add(new Entry(5, 40f));
        yValuesEKG.add(new Entry(6, 70f));
        yValuesEKG.add(new Entry(7, 20f));
        LineDataSet setareEKG = new LineDataSet(yValuesEKG, "EKG");

        setareEKG.setFillAlpha(110);

        setareEKG.setColor(Color.RED);
        setareEKG.setLineWidth(3f);
        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(setareEKG);
        LineData data = new LineData(dataSets);
        ekgChart.setData(data);


        ArrayList<BarEntry> yValuesPuls = new ArrayList<>();

        yValuesPuls.add(new BarEntry(0, 60f));
        yValuesPuls.add(new BarEntry(1, 50f));
        yValuesPuls.add(new BarEntry(2, 70f));
        yValuesPuls.add(new BarEntry(3, 30f));
        yValuesPuls.add(new BarEntry(4, 60f));
        yValuesPuls.add(new BarEntry(5, 40f));
        yValuesPuls.add(new BarEntry(6, 70f));
        yValuesPuls.add(new BarEntry(7, 20f));
        BarDataSet setarePuls = new BarDataSet(yValuesPuls, "Puls");

        setarePuls.setColors(ColorTemplate.COLORFUL_COLORS);
//        setarePuls.setColor(Color.RED);
        //setarePuls.setLineWidth(3f);
        BarData dataPuls = new BarData(setarePuls);
        dataPuls.setBarWidth(0.4f);
        pulsChart.setData(dataPuls);



        return root;
    }
}
