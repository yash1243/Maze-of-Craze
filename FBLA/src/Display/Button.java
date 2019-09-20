package Display;

import javax.swing.JButton;

public class Button {
	
	protected JButton button;
	private boolean buttonState;
	private String title, tag;
	
	public Button(JButton button, int x, int y, int width, int height, String title, boolean visablity, String tag){	
		this.button = button;
		this.title = title;
		this.tag = tag;
		button.setBounds(x, y, width, height);
		button.setText(title);
		button.setVisible(visablity);
		buttonState = false;
	}
	
	public Button(JButton button, int x, int y, int width, int height, String title, boolean visablity){	
		this.button = button;
		this.title = title;
		button.setBounds(x, y, width, height);
		button.setText(title);
		button.setVisible(visablity);
		buttonState = false;
	}
	
	public void visablityState(boolean b){
		button.setVisible(b);
	}
	
	public String getTag() {
		return tag;
	}
	
	public boolean getButtonState() {
		return buttonState;
	}
	
	public void setButtonState(boolean buttonState) {
		this.buttonState = buttonState;
	}
	
	public JButton getButton() {
		return button;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void update(Object src){
		if(src == button){
			buttonState = !buttonState;			
		}
	}
}
