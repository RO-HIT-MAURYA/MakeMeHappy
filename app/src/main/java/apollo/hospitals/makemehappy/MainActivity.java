package apollo.hospitals.makemehappy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    int count=0;
    int button1 = 0;
    int button2 = 0;
    int button3 = 0;
    JSONObject jsonObject;


    List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jsonObject = new JSONObject();

        findViewById(R.id.button1).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);

        list = new ArrayList<>();
        list.add("Have you cried today?");
        list.add("You're feeling sleepy?");
        list.add("You're ready to punch somebody in the face?");
        list.add("You feel like you're alone (even if you ARE in a roomfull of people)");
        list.add("Do you missing someone?");
        list.add("Do you thinking about your worst enemy?");
        list.add("Are you happy with yourself right now?");
        list.add("Are you feeling the pressure to want to harm somebody in any possible way?");
        list.add("Are you feeling like you want to begin crying?");

        ((TextView)findViewById(R.id.textView)).setText(list.get(0));

    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.button1)
            button1++;

        if (v.getId() == R.id.button2)
            button2++;

        if (v.getId() == R.id.button3)
            button3++;

        if (count<list.size()-1) {
            ++count;
            ((TextView)findViewById(R.id.textView)).setText(list.get(count));
        }
        else
        {
            try {
                jsonObject.put("yes",button1);
                jsonObject.put("no",button2);
                jsonObject.put("cant_say",button3);

                Intent intent = new Intent(MainActivity.this,VideoList.class);
                intent.putExtra("bundle",jsonObject.toString());
                Log.e("strIs",""+jsonObject);
                startActivity(intent);

            } catch (JSONException e) {
                e.printStackTrace();
            }


        }
    }


}
