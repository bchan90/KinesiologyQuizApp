package com.example.android.kinesiologyquizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

	int score = 0;
	private boolean[] incorrect = new boolean[10];
	private int i = 0;
	private String name = "";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void startQuiz(View view) {
		LinearLayout layout = (LinearLayout) findViewById(R.id.initLayout);
		EditText name_field = (EditText) findViewById(R.id.name_field);
		name = name_field.getText().toString();
		layout.setVisibility(LinearLayout.GONE);
		layout=(LinearLayout) findViewById(R.id.quizLayout);
		layout.setVisibility(LinearLayout.VISIBLE);
	}

	public void checkAnswer(View view) {
		boolean checked = ((RadioButton) view).isChecked();

		if (R.id.rbAns == view.getId()) {
			if (checked)
				score++;
		}
		else
			wrongAns();
	}

	private void checkCbAnswer() {
		CheckBox cbA1 = (CheckBox) findViewById(R.id.cbAns1);
		CheckBox cbA2 = (CheckBox) findViewById(R.id.cbAns2);
		CheckBox cbA3 = (CheckBox) findViewById(R.id.cbAns3);
		CheckBox cbA4 = (CheckBox) findViewById(R.id.cbAns4);

		if (cbA1.isChecked() & cbA2.isChecked() & cbA4.isChecked())
			score++;
		else
			wrongAns();
	}

	private void wrongAns() {
		//Check if already marked as incorrect.
		if(incorrect[i] == true) {
			return;
		} else {
			incorrect[i] = true;
			i++;
		}
	}

	public void finishQuiz(View view) {
		checkCbAnswer();
		Button btn = (Button) findViewById(R.id.btnFinish);
		String strScore = "Congratulations " + name + "! You've completed the quiz!\n";
		strScore += "You answered " + score + "/10 questions correctly.\n";

		Toast.makeText(getApplicationContext(), strScore, Toast.LENGTH_LONG).show();
		score = 0;

		// Deactivate Finish button
		// Need to code to reset all vars and radio buttons
		btn.setClickable(false);
	}

}
