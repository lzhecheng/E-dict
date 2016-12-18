
package application.client;

import application.share.*;

import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;

class Card extends GridPane implements Comparable<Card> {
	private final Integer dictIndex;
	private final Label lblDict;
	private final TextArea txtMsg;
	private final Button btnLike;
	private Integer numLike;
	
	public Card(int index, String msg, int like) {
		super();
		
		dictIndex = index;
		lblDict = new Label(DictInfo.info[dictIndex].name);
		txtMsg = new TextArea(msg);
		txtMsg.setPrefRowCount((txtMsg.getText() + " ").split("\n").length);
		txtMsg.textProperty().addListener((o, s1, s2) -> txtMsg
			.setPrefRowCount((txtMsg.getText() + " ").split("\n").length));
		txtMsg.setFont(new Font(15));
		btnLike = new Button(new Integer(numLike = like).toString());
		
		super.getColumnConstraints().addAll(col, new ColumnConstraints(30));
		super.getRowConstraints().addAll(new RowConstraints(40), row);
		
		super.add(lblDict, 0, 0, 1, 1);
		super.add(btnLike, 1, 0, 1, 1);
		super.add(txtMsg, 0, 1, 2, 1);
		
	}
	
	public void setCard(String msg, int like) {
		txtMsg.setText(msg);
		btnLike.setText(new Integer(numLike = like).toString());
	}
	
	private static ColumnConstraints col =
		new ColumnConstraints(30, 30, Double.MAX_VALUE);
	private static RowConstraints row = new RowConstraints();
	static {
		col.setHgrow(Priority.ALWAYS);
	}
	
	@Override
	public int compareTo(Card rhs) {
		int result = numLike.compareTo(rhs.numLike);
		return result == 0 ? dictIndex.compareTo(rhs.dictIndex) : result;
	}
	
}
