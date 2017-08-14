package songmofan.baway.com.text1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView re;
    private ArrayList<String> mDatas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
       initView();
    }

    private void initData() {
        mDatas = new ArrayList<>();
        for (int i = 'A'; i < 'Z'; i++) {
            mDatas.add("" + (char) i);
        }
    }

    private void initView() {
        re = (RecyclerView) findViewById(R.id.recyclerview);
        LinearLayoutManager ly=new LinearLayoutManager(this);
        re.setLayoutManager(ly);
        re.setAdapter(new MyAdapter(MainActivity.this,mDatas));
        re.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        //
        re.addOnItemTouchListener(new MyItemClikLisener(re) {
            @Override
            public void onItemClick(RecyclerView.ViewHolder viewHolder) {
                int position = viewHolder.getAdapterPosition();
                Toast.makeText(MainActivity.this, "点击了"+position, Toast.LENGTH_SHORT).show();
            }
        });

    }
}
