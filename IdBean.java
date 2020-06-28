// @Reabaln
//This stores the Id list in the Database
package mvc;

import java.util.ArrayList;

public class IdBean {
	
	private ArrayList<String> IdList;

	public ArrayList<String> getIdList() {
	
		return IdList;
	}

	public void setIdList(ArrayList<String> list) {
		IdList = list;
	}
	

	public static void main(String[] args) {
		
		IdBean id = new IdBean();
		id.getIdList();
	}

}
