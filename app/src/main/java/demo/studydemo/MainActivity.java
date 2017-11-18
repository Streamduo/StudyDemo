package demo.studydemo;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterViewFlipper;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.QuickContactBadge;
import android.widget.Spinner;
import android.widget.StackView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static android.R.string.no;
import static android.app.PendingIntent.getActivity;
import static demo.studydemo.R.id.autoview;
import static demo.studydemo.R.id.spinner;

public class MainActivity extends AppCompatActivity {
    private String [] people=new String[]{"爸爸吧","妈妈吗","妹妹吗"};
    ArrayList<String> list=new ArrayList<String>();
    private AdapterViewFlipper adapterview;
    private int [] images=new int[]{R.mipmap.bao1,R.mipmap.bao2,R.mipmap.bao3,R.mipmap.bao4,R.mipmap.bao5,
            R.mipmap.bao6,R.mipmap.bao7,R.mipmap.bao8,};
    private StackView stickview;
    private StackView stickview2;
    private NotificationManager notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        TextView but_study= (TextView) findViewById(R.id.but_study);
        //but_study.setElevation(50);
        Button butqicai= (Button) findViewById(R.id.butqicai);
//        QuickContactBadge quick_num= (QuickContactBadge) findViewById(R.id.quick_num);
//        quick_num.assignContactFromPhone("110",false);
        AutoCompleteTextView autoview= (AutoCompleteTextView) findViewById(R.id.autoview);
        MultiAutoCompleteTextView multview= (MultiAutoCompleteTextView) findViewById(R.id.muliview);
        ArrayAdapter<String> aa=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,people);
        autoview.setAdapter(aa);
        multview.setAdapter(aa);
        for (int i=1;i<10;i++){
            list.add("你今天非常棒");
            Log.i("fhjf","测试测试");
        }
        ArrayAdapter listadapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,list);
        Spinner spinner= (Spinner) findViewById(R.id.spinner);
        spinner.setAdapter(listadapter);
//        adapterview = (AdapterViewFlipper) findViewById(R.id.adapterview);
//        adapterview.setAdapter(adapter);
        stickview = (StackView) findViewById(R.id.stackview);
        stickview.setAdapter(adapter);
        autoview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(MainActivity.this,StudyActivity.class));
                notificationManager.cancel(0*123);
            }
        });

        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);


        butqicai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,StudyActivity.class);
//                PendingIntent pu=PendingIntent.getActivity(MainActivity.this,0,intent,0);
//                Notification notification=new Notification.Builder(MainActivity.this)
//                        .setAutoCancel(true)
//                        .setTicker("新消息来了")
//                        .setSmallIcon(R.drawable.yuan)
//                        .setContentTitle("一条新同事")
//                        .setContentText("加薪了")
//                        .setWhen(System.currentTimeMillis())
//                        .setContentIntent(pu)
//                        .build();
//                notificationManager.notify(0*123,notification);
                startActivity(intent);
            }
        });
    }

    BaseAdapter adapter=new BaseAdapter() {
        @Override
        public int getCount() {
            return images.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView=new ImageView(MainActivity.this);
            imageView.setImageResource(images[position]);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT));
            return imageView;
        }
    };

    public void last(View view){
       // adapterview.showPrevious();
        stickview.showPrevious();
    }
    public void next(View view){
        //adapterview.showNext();
        stickview.showNext();
    }

    public void zidong(View view){
        //adapterview.startFlipping();
    }

}
