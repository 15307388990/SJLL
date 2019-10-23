package com.ming.sjll.purchaser.fragment;

import android.os.Bundle;
import android.view.View;

import com.ming.sjll.R;
import com.ming.sjll.base.fragment.MvpFragment;
import com.ming.sjll.base.utils.Tools;
import com.ming.sjll.purchaser.presenter.ProjectSupplierPresenter;
import com.ming.sjll.purchaser.view.ProjectView;
import com.ming.sjll.purchaser.view.SupplierView;
import com.ming.sjll.view.FalseCalendar;
import com.ming.sjll.view.OnSpinnerItemSelectedListener;
import com.ming.sjll.view.SpinnerView;
import com.necer.calendar.BaseCalendar;
import com.necer.enumeration.SelectedModel;
import com.necer.listener.OnCalendarChangedListener;

import org.joda.time.LocalDate;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import butterknife.BindView;

/**
 * @author luoming
 * created at 2019-10-14 10:32
 * 概况
 */
public class TimerFragemt extends MvpFragment<SupplierView, ProjectSupplierPresenter> implements ProjectView {


    @BindView(R.id.monthCalendar)
    FalseCalendar monthCalendar;
    @BindView(R.id.ns_year)
    SpinnerView nsYear;
    @BindView(R.id.ns_moth)
    SpinnerView nsMoth;
    private String year;
    private String moth;

    public static TimerFragemt newInstance() {
        return new TimerFragemt();
    }

    @Override
    protected void onCreateView(Bundle savedInstanceState) {
        super.onCreateView(savedInstanceState);
        setContentView(R.layout.fragemt_timer);
        initCalendar();
        initSpiner();
    }

    private void initCalendar() {

        monthCalendar.setSelectedMode(SelectedModel.SINGLE_UNSELECTED);
        monthCalendar.setOnCalendarChangedListener(new OnCalendarChangedListener() {
            @Override
            public void onCalendarChange(BaseCalendar baseCalendar, int year, int month, LocalDate localDate) {
                nsMoth.setSelectedIndex(month - 1);
                switch (year) {
                    case 2019:
                        nsYear.setSelectedIndex(0);
                        break;
                    case 2020:
                        nsYear.setSelectedIndex(1);
                        break;
                    case 2021:
                        nsYear.setSelectedIndex(2);
                    case 2022:
                        nsYear.setSelectedIndex(3);
                    case 2023:
                        nsYear.setSelectedIndex(4);
                }


            }
        });
        monthCalendar.setDateInterval(Tools.Date(),"2023-12-30");

    }

    private void initSpiner() {

        List<String> dataset = new LinkedList<>(Arrays.asList("2019年", "2020年", "2021年", "2022年", "2023年"));
        nsYear.attachDataSource(dataset);
        int index = dataset.indexOf(Tools.getYear() + "年");
        if (index != -1) {
            nsYear.setSelectedIndex(index);
        }
        nsYear.setOnSpinnerItemSelectedListener(new OnSpinnerItemSelectedListener() {
            @Override
            public void onItemSelected(SpinnerView parent, View view, int position, long id) {
                jumpDate();
            }
        });

        List<String> dataset2 = new LinkedList<>(Arrays.asList("1月", "2月", "3月", "4月", "5月", "6月", "7月", "8月", "9月", "10月", "11月", "12月"));
        nsMoth.attachDataSource(dataset2);
        nsMoth.setSelectedIndex(Tools.getMonth() - 1);
        nsMoth.setOnSpinnerItemSelectedListener(new OnSpinnerItemSelectedListener() {
            @Override
            public void onItemSelected(SpinnerView parent, View view, int position, long id) {
                jumpDate();
            }
        });


    }

    //跳转至选择的日期
    private void jumpDate() {
        String date = nsYear.getSelectedItem().toString().replace("年", "") + "-" +
                nsMoth.getSelectedItem().toString().replace("月", "") + "-" + Tools.getDay();

        //yyyy-MM-dd
        monthCalendar.jumpDate(date);
    }


    @Override
    protected ProjectSupplierPresenter createPresenter() {
        return new ProjectSupplierPresenter();
    }

    @Override
    public void showLoading(String msg) {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showError(String msg) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

}
