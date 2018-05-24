package co.vinod.web;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public final class DispatcherView {
	
	
	Map<String, String> viewMappings = new HashMap<>();
	
	private DispatcherView() {
		ResourceBundle rb = ResourceBundle.getBundle("co.vinod.web.views");
		for(String key: rb.keySet()){
			viewMappings.put(key, rb.getString(key));
		}
	}

	static DispatcherView instance = new DispatcherView();

	public static DispatcherView newInstance(){
		return instance;
	}

	public String findView(String viewName) {
		return viewMappings.get(viewName);
	}

}
