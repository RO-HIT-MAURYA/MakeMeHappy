package apollo.hospitals.makemehappy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class Player extends YouTubeBaseActivity {

    YouTubePlayerView youTubePlayerView;
    YouTubePlayer.OnInitializedListener onInitializedListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        youTubePlayerView = findViewById(R.id.ytpw);

        onInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                String code = getIntent().getStringExtra("code");
                Log.d("codeIs", code);
                youTubePlayer.loadVideo(code);
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };
        playVideo();
    }

    private void playVideo() {
        youTubePlayerView.initialize("AIzaSyD9EXG88GTaxJVK_ljUsVMGrXJH6qqYJp4", onInitializedListener);
    }//AIzaSyD9EXG88GTaxJVK_ljUsVMGrXJH6qqYJp4
    //AIzaSyDheKHlDb3CYdrkzsVT_F8wsdayraIOtZs//rohit
}
