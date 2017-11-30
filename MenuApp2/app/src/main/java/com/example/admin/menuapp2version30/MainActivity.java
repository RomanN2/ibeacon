package com.example.admin.menuapp2version30;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.TextView;
        import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        TextView headerView = (TextView) findViewById(R.id.header);
        switch(id){
            case R.id.action_settings :
                headerView.setText("Настройки");
                Intent intent = new Intent(this,SettingsActivity.class);
                startActivity(intent);
                Toast toast = Toast.makeText(MainActivity.this, "SettingsActivity loaded", Toast.LENGTH_SHORT);
                toast.show();
                return true;

            case R.id.open_settings:
                headerView.setText("Открыть");
                Intent intent1 = new Intent(this,Open_Activity.class);
                startActivity(intent1);
                Toast toast2 = Toast.makeText(MainActivity.this, "SettingsActivity loaded", Toast.LENGTH_SHORT);
                toast2.show();
                return true;

            case R.id.save_settings:
                headerView.setText("Сохранить");
                Intent intent2 = new Intent(this,SaveActivity.class);
                startActivity(intent2);
                Toast toast3 = Toast.makeText(MainActivity.this, " SavedActivity loaded", Toast.LENGTH_SHORT);
                toast3.show();
                return true;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {

    }
}