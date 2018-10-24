package apollo.hospitals.makemehappy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubeThumbnailView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class VideoList extends AppCompatActivity  {

    int yes = 0;
    int no = 0;
    int cant_say = 0;
    List<String> yes_list;
    List<String> no_list;
    List<String> cant_say_List;
    int max = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_list);

        makeYesList();
        makeNoList();
        makeCantSayList();

        ListView listView = findViewById(R.id.listView);
        VideoListAdapter videoListAdapter = new VideoListAdapter();
        listView.setAdapter(videoListAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Intent intent = new Intent(VideoList.this,Player.class);
                intent.putExtra("code",view.getTag().toString());
                Log.e("codeIs",view.getTag().toString());
                startActivity(intent);
            }
        });

        String string = getIntent().getStringExtra("bundle");
        Log.e("stringIs",string);

        try {
            JSONObject jsonObject = new JSONObject(string);
            yes = jsonObject.getInt("yes");
            no = jsonObject.getInt("no");
            cant_say = jsonObject.getInt("cant_say");

            //big = a > b ? ( a > c ? a : c) : (b > c ? b : c) ;

            max = yes>no ? (yes>cant_say ? yes:cant_say):(no>cant_say ? no:cant_say);

            if (max == yes)
                makeVideoList(yes_list);
            else if (max == no)
                makeVideoList(no_list);
            else
                makeVideoList(cant_say_List);


        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    private List<String> makeNoList()
    {
        no_list = new ArrayList<>();
        no_list.add("ZIQlzUcH-R4");
        no_list.add("kd-6aw99DpA");
        no_list.add("t6MeeKrDIlM");
        no_list.add("puKD3nkB1h4");
        no_list.add("SaY5MuBXzIE");
        no_list.add("gq5acI30-Fk");

        return no_list;
    }

    private List<String> makeCantSayList()
    {
        cant_say_List = new ArrayList<>();
        cant_say_List.add("ZIQlzUcH-R4");
        cant_say_List.add("kd-6aw99DpA");
        cant_say_List.add("t6MeeKrDIlM");
        cant_say_List.add("puKD3nkB1h4");
        cant_say_List.add("SaY5MuBXzIE");
        cant_say_List.add("gq5acI30-Fk");
        cant_say_List.add("YZGfZjAOgs0");

        return cant_say_List;
    }

    private List<String> makeYesList() {
        yes_list = new ArrayList<>();
        yes_list.add("ZIQlzUcH-R4");
        yes_list.add("kd-6aw99DpA");
        yes_list.add("t6MeeKrDIlM");
        yes_list.add("puKD3nkB1h4");
        yes_list.add("SaY5MuBXzIE");
        yes_list.add("gq5acI30-Fk");
        yes_list.add("YZGfZjAOgs0");
        yes_list.add("abiL84EAWSY");

        return yes_list;
    }

    public  List<String> makeVideoList(List<String> strings)
    {

        return strings;
    }

    class VideoListAdapter extends BaseAdapter
    {

        @Override
        public int getCount() {
            return yes_list.size();
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

            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.list_part, parent, false);
                convertView.setTag(yes_list.get(position));
                ((TextView)convertView.findViewById(R.id.textView)).setText(""+position);
            }


            return convertView;
        }
    }

}
