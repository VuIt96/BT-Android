package com.example.bt2.sqltask;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.bt2.R;

import java.util.ArrayList;

public class SQLiteListActivity extends AppCompatActivity {
    DatabaseActivity databaseActivity;
    ListView lvSQLite;
    ArrayList<TaskActivity> arrayTask;
    TaskAdapterActivity taskAdapterActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_list);
        lvSQLite = (ListView) findViewById(R.id.lvSQLite);
        arrayTask = new ArrayList<>();
        taskAdapterActivity = new TaskAdapterActivity(this, R.layout.line_task, arrayTask);
        lvSQLite.setAdapter(taskAdapterActivity);
        //tao database ghi chu.
        databaseActivity = new DatabaseActivity(this, "Ghichu.sqlite", null, 1);
        //tao bang
        databaseActivity.QueryData("CREATE TABLE IF NOT EXISTS CongViec(Id INTEGER PRIMARY KEY AUTOINCREMENT, TenCV VARCHAR(200))");
        //INSERT DATA
        //       databaseActivity.QueryData("INSERT INTO CongViec VALUES(null, 'Viet ung dung ghi chu')");

        //Select data
        getDataTask();
    }

    private void getDataTask() {
        Cursor dataCV = databaseActivity.getData("SELECT* FROM CongViec");
        arrayTask.clear();
        while (dataCV.moveToNext()) {
            String Name = dataCV.getString(1);
            int id = dataCV.getInt(0);
            arrayTask.add(new TaskActivity(id, Name));
        }
        taskAdapterActivity.notifyDataSetChanged();
    }

    public void dialogDeleteTask(String NameTask, final int id) {
        final AlertDialog.Builder dialogDelete = new AlertDialog.Builder(this);
        dialogDelete.setMessage("Ban co muon xoa cong viec => " + NameTask + " )= khong ???");
        dialogDelete.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                databaseActivity.QueryData("DELETE FROM CongViec WHERE Id = '" + id + "'");
                Toast.makeText(SQLiteListActivity.this, "DA XOA", Toast.LENGTH_SHORT).show();
                getDataTask();
            }
        });
        dialogDelete.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        dialogDelete.show();
    }

    public void dialogUpdateTask(String Name, final int id) {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog);
        final EditText etNameTasksua = (EditText) dialog.findViewById(R.id.etNameTasksua);
        Button btYes = (Button) dialog.findViewById(R.id.btYes);
        Button btNo = (Button) dialog.findViewById(R.id.btNo);
        etNameTasksua.setText(Name);

        btYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String NameTaskNew = etNameTasksua.getText().toString().trim();
                databaseActivity.QueryData("UPDATE CongViec SET TenCV = '" + NameTaskNew + "' WHERE Id ='" + id + "'");
                Toast.makeText(SQLiteListActivity.this, "THAnh cong ", Toast.LENGTH_SHORT).show();
                dialog.cancel();
                getDataTask();
            }
        });
        btNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
            }
        });
        dialog.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_sqltask, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.idAdd) {
            dialogAdd();
        }
        return super.onOptionsItemSelected(item);
    }

    private void dialogAdd() {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_add_task);
        final EditText etName = (EditText) dialog.findViewById(R.id.etName);
        Button btAdd = (Button) dialog.findViewById(R.id.btAdd);
        Button btDelete = (Button) dialog.findViewById(R.id.btDelete);
        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String NameTask = etName.getText().toString();
                if (NameTask.equals("")) {
                    Toast.makeText(SQLiteListActivity.this, "nhap", Toast.LENGTH_SHORT).show();
                } else {
                    databaseActivity.QueryData("INSERT INTO CongViec VALUES(null, '" + NameTask + "')");
                    Toast.makeText(SQLiteListActivity.this, "DA them", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                    getDataTask();
                }
            }
        });
        btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
                //dialog.dismiss();
            }
        });

        dialog.show();

    }
}
