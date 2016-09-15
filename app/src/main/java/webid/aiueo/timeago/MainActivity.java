package webid.aiueo.timeago;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<DataCollect> dataCollectList = new ArrayList<>();
    private RecyclerView recyclerView;
    private DataAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new DataAdapter(dataCollectList);

        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                DataCollect dataCollect = dataCollectList.get(position);
                Toast.makeText(getApplicationContext(), dataCollect.getTitle() + " is selected!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        prepareData();
    }

    private void prepareData() {
        DataCollect dataCollect = new DataCollect("Subject Message One","Description of message","2016/09/15 08:15:00");
        dataCollectList.add(dataCollect);

        dataCollect = new DataCollect("Subject Message Two","Description of message","2016/09/14 08:15:00");
        dataCollectList.add(dataCollect);

        dataCollect = new DataCollect("Subject Message Three","Description of message","2016/09/13 07:15:00");
        dataCollectList.add(dataCollect);

        dataCollect = new DataCollect("Subject Message Four","Description of message","2016/09/10 06:15:00");
        dataCollectList.add(dataCollect);

        dataCollect = new DataCollect("Subject Message Five","Description of message","2016/09/06 08:15:00");
        dataCollectList.add(dataCollect);
        mAdapter.notifyDataSetChanged();
    }

}
