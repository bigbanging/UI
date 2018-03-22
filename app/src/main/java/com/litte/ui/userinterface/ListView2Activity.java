package com.litte.ui.userinterface;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import com.litte.ui.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListView2Activity extends Activity {

    String[] name = {"Jay", "GD", "IU", "JB", "emma"};
    String[] say = {"哎哟，不错哟！", "BANG BANG BANG", "民国公主", "这是丁日", "艾玛"};
    int[] head = {R.drawable.jay, R.drawable.gd, R.drawable.iu, R.drawable.jb, R.drawable.emma};
    @BindView(R.id.list_view)
    ListView listView;
    @BindView(R.id.listView2)
    ListView listView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view2);
        ButterKnife.bind(this);
        requestMyPermission();
        List<Map<String, Object>> list = new ArrayList<>();
        for (int i = 0; i < name.length; i++) {
            Map<String, Object> showItem = new HashMap<String, Object>();
            showItem.put("head", head[i]);
            showItem.put("name", name[i]);
            showItem.put("say", say[i]);
            list.add(showItem);
        }
        SimpleAdapter adapter = new SimpleAdapter(this, list, R.layout.list_item, new String[]{"head", "name", "say"}, new int[]{R.id.iv_head, R.id.tv_name, R.id.tv_describe});
        listView.setAdapter(adapter);
//        读写联系人的权限
        Cursor cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
        SimpleCursorAdapter simpleCursorAdapter = new SimpleCursorAdapter(this,R.layout.list_item2,cursor,new String[]{ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME, ContactsContract.CommonDataKinds.Phone.NUMBER},
                new int[]{R.id.tv_show_name,R.id.tv_show_phone});
        listView2.setAdapter(simpleCursorAdapter);

    }

    private void requestMyPermission() {
        // 版本判断。当手机系统大于 23 时，才有必要去判断权限是否获取
        if (Build.VERSION.SDK_INT >=Build.VERSION_CODES.M) {
            //检查权限是否被授予
            int i = ContextCompat.checkSelfPermission(this, Manifest.permission_group.CONTACTS);
            if (i != PackageManager.PERMISSION_GRANTED){
                //没有授权就提示用户同意授权同意
                requestPermission();
            }
        }
    }

    private void requestPermission() {
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission_group.CONTACTS},100);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 100){
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this, "获取申请的权限", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
