package songmofan.baway.com.demo;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import songmofan.baway.com.demo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        user = new User("hah", "11",1);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setUser(user);
        binding.setPersen(new presenter());


    }

public class  presenter{
    public  void  ssss(View view){
        Toast.makeText(MainActivity.this, "绑定方法--点击事件", Toast.LENGTH_SHORT).show();

    }
    //实时更改第一个text
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        user.setName(s.toString());
        binding.setUser(user);

    }

    public void  jianting(User u){
        Toast.makeText(MainActivity.this, "绑定事件之打印名字"+u.getName(), Toast.LENGTH_SHORT).show();

    }

}







}
