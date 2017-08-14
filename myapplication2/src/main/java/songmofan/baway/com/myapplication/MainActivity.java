package songmofan.baway.com.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView re;
    private ArrayList<String> list;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
    }

    private void initData() {
        list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add("hhahahha"+i);
        }
    }

    private void initView() {
        re = (RecyclerView) findViewById(R.id.recyclerview);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        re.setLayoutManager(layoutManager);
        adapter = new MyAdapter(MainActivity.this,list);
        re.setAdapter(adapter);
        re.addOnItemTouchListener(new MyItemClickLinsener(re) {
            @Override
            public void setOnItemClick(RecyclerView.ViewHolder viewHolder) {
                int position = viewHolder.getAdapterPosition();
                Toast.makeText(MainActivity.this, "点击le："+list.get(position), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
