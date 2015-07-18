import java.io.Serializable;
import java.util.ArrayList;


public class ServerMessage implements Serializable{
	private static final long serialVersionUID = 1L;
	private ArrayList<String> listOfFields;
	private ArrayList<String> listOfValues;
	
	public ArrayList<String> getListOfFields() {
		return listOfFields;
	}
	public void setListOfFields(ArrayList<String> listOfFields) {
		this.listOfFields = listOfFields;
	}
	public ArrayList<String> getListOfValues() {
		return listOfValues;
	}
	public void setListOfValues(ArrayList<String> listOfValues) {
		this.listOfValues = listOfValues;
	}
	
}
