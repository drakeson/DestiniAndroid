package smith.drake.kato.destiniandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    Button mBtnUp, mBtnBtm;
    TextView mTxt;

    int mStoryIndex=1;

    Story[] storyArray = {
            new Story(R.string.T1_Story,R.string.T1_Ans1,R.string.T1_Ans2),
            new Story(R.string.T2_Story,R.string.T2_Ans1,R.string.T2_Ans2),
            new Story(R.string.T3_Story,R.string.T3_Ans1,R.string.T3_Ans2)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mBtnBtm = (Button) findViewById(R.id.buttonBottom);
        mBtnUp = (Button) findViewById(R.id.buttonTop);
        mTxt = (TextView) findViewById(R.id.storyTextView);


        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:

        mBtnUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mStoryIndex==1){
                    mStoryIndex=3;
                    Log.d("Destini","mStroyIndex now is: "+mStoryIndex);
                    mTxt.setText(storyArray[mStoryIndex-1].getStoryText());
                    mBtnUp.setText(storyArray[mStoryIndex-1].getTopAnswer());
                    mBtnBtm.setText(storyArray[mStoryIndex-1].getBottomAnswer());
                }else if(mStoryIndex==3){
                    mTxt.setText(R.string.T6_End);
                    mBtnUp.setVisibility(View.GONE);
                    mBtnBtm.setVisibility(View.GONE);
                }else if(mStoryIndex==2){
                    mStoryIndex=3;
                    mTxt.setText(storyArray[mStoryIndex-1].getStoryText());
                    mBtnUp.setText(storyArray[mStoryIndex-1].getTopAnswer());
                    mBtnBtm.setText(storyArray[mStoryIndex-1].getBottomAnswer());

                }
            }
        });


        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:

        mBtnBtm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mStoryIndex==1){
                    mStoryIndex=2;
                    mTxt.setText(storyArray[mStoryIndex-1].getStoryText());
                    mBtnUp.setText(storyArray[mStoryIndex-1].getTopAnswer());
                    mBtnBtm.setText(storyArray[mStoryIndex-1].getBottomAnswer());
                }else if(mStoryIndex==2){
                    mTxt.setText(R.string.T4_End);
                    mBtnUp.setVisibility(View.GONE);
                    mBtnBtm.setVisibility(View.GONE);

                }else if (mStoryIndex==3){
                    mTxt.setText(R.string.T5_End);
                    mBtnUp.setVisibility(View.GONE);
                    mBtnBtm.setVisibility(View.GONE);
                }
            }
        });

    }
}
