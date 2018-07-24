package com.qcloud.butterknifetest;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindArray;
import butterknife.BindColor;
import butterknife.BindDrawable;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnLongClick;

public class MainActivity extends Activity {

    @BindView(R.id.tv_1)
    TextView tv1;
    @BindView(R.id.et_1)
    EditText et1;
    @BindView(R.id.iv_1)
    ImageView iv1;
    @BindColor(R.color.colorAccent)
    int pink;//绑定颜色
    @BindString(R.string.app_name)
    String appName;//绑定一个常量
    @BindArray(R.array.city)
    String[] citys;//绑定一组数组
    @BindDrawable(R.drawable.smoker)
    Drawable drawable;//绑定图片
    @BindViews({R.id.tv_2,R.id.tv_3,R.id.tv_4})
    List<TextView> textViewList;

    @OnClick(R.id.btn_3)
    public void showToast(){
        Toast.makeText(this,"btn3说:程序的名字是 "+appName,Toast.LENGTH_SHORT).show();
    }
    @OnLongClick(R.id.btn_3)
    public boolean changeColor(){
        ButterKnife.findById(this,R.id.btn_3).setBackgroundColor(pink);
        return true;
    }
    @OnClick({R.id.btn_1,R.id.btn_2})
    public void onViewClicked(View view){
        switch (view.getId()){
            case R.id.btn_1:
                Toast.makeText(this,"按钮1你输入的是: "+et1.getText().toString(),Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_2:
                Toast.makeText(this,"按钮2的点击事件",Toast.LENGTH_SHORT).show();
                break;
        }
    }
    @OnClick({R.id.btn_1,R.id.btn_2})
    public void btnClick(Button button){
        Toast.makeText(this,"您输入的是: "+et1.getText().toString(),Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        iv1.setImageDrawable(drawable);
        tv1.setText(citys[0]);

        textViewList.get(0).setText(citys[1]);
        textViewList.get(1).setText(citys[2]);
        textViewList.get(2).setText(citys[3]);

    }
}
