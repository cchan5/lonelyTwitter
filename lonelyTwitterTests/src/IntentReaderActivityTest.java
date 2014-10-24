import ca.ualberta.cs.lonelytwitter.IntentReaderActivity;
import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ViewAsserts;


public class IntentReaderActivityTest extends
		ActivityInstrumentationTestCase2<IntentReaderActivity> {
	
	public IntentReaderActivityTest() {
		super(IntentReaderActivity.class);
	}
	
	//Make sure the activity received the text
	public void testSendText() {
		Intent intent = new Intent();
		intent.putExtra(IntentReaderActivity.TEXT_KEY, "some string");
		intent.putExtra(IntentReaderActivity.TRANSFORM_KEY, IntentReaderActivity.NORMAL);
		setActivityIntent(intent);
		//THis is kind of like new for an activity in a test
		IntentReaderActivity activity = (IntentReaderActivity) getActivity();
		assertEquals("some string", activity.getText());
	}

	public void testDoubleText() {
		Intent intent = new Intent();
		intent.putExtra(IntentReaderActivity.TEXT_KEY, "some string");
		intent.putExtra(IntentReaderActivity.TRANSFORM_KEY, IntentReaderActivity.DOUBLE);
		setActivityIntent(intent);
		//THis is kind of like new for an activity in a test
		IntentReaderActivity activity = (IntentReaderActivity) getActivity();
		assertEquals("some stringsome string", activity.getText());
	}
	
	//This is how to test views
	public void testDisplayText() {
		Intent intent = new Intent();
		intent.putExtra(IntentReaderActivity.TEXT_KEY, "some string");
		intent.putExtra(IntentReaderActivity.TRANSFORM_KEY, IntentReaderActivity.DOUBLE);
		setActivityIntent(intent);
		//THis is kind of like new for an activity in a test
		IntentReaderActivity activity = (IntentReaderActivity) getActivity();
		assertEquals("some stringsome string", activity.getView().getText());
	}
	
	public void testDisplayText2() throws Throwable {
		//THis is kind of like new for an activity in a test
		IntentReaderActivity activity = (IntentReaderActivity) getActivity();
		runTestOnUiThread(new Runnable() {
			@Override
			public void run() {
				getActivity().getView().setText("some string some string ");
			}
		});
		assertEquals("some string some string ", activity.getView().getText());
	}
	
	public void testReverseTest() throws Throwable {
		Intent intent = new Intent();
		intent.putExtra(IntentReaderActivity.TEXT_KEY, "some string");
		intent.putExtra(IntentReaderActivity.TRANSFORM_KEY, IntentReaderActivity.REVERSE);
		setActivityIntent(intent);
	
		IntentReaderActivity activity = (IntentReaderActivity) getActivity();
		assertEquals("gnirts emos", activity.getView().getText());
		
	}
	
	public void testDisplayDefaultText() throws Throwable {
		IntentReaderActivity activity = (IntentReaderActivity) getActivity();
		assertEquals(IntentReaderActivity.DEFAULT_KEY, activity.getView().getText());
	}
	
	public void testScreenVisible() {
		IntentReaderActivity activity = (IntentReaderActivity) getActivity();
		
		ViewAsserts.assertOnScreen(activity.getWindow().getDecorView(),getActivity().getView());
	}
}
